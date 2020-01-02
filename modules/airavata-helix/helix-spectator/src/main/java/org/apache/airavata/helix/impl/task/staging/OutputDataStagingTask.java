/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.airavata.helix.impl.task.staging;

import org.apache.airavata.agents.api.AgentAdaptor;
import org.apache.airavata.agents.api.AgentException;
import org.apache.airavata.agents.api.StorageResourceAdaptor;
import org.apache.airavata.common.utils.ServerSettings;
import org.apache.airavata.helix.impl.task.TaskContext;
import org.apache.airavata.helix.impl.task.TaskOnFailException;
import org.apache.airavata.helix.task.api.TaskHelper;
import org.apache.airavata.helix.task.api.annotation.TaskDef;
import org.apache.airavata.mft.admin.MFTAdmin;
import org.apache.airavata.mft.admin.models.AgentInfo;
import org.apache.airavata.mft.admin.models.TransferRequest;
import org.apache.airavata.mft.admin.models.TransferState;
import org.apache.airavata.model.appcatalog.storageresource.StorageResourceDescription;
import org.apache.airavata.model.application.io.DataType;
import org.apache.airavata.model.application.io.OutputDataObjectType;
import org.apache.airavata.model.status.ProcessState;
import org.apache.airavata.model.task.DataStagingTaskModel;
import org.apache.helix.task.TaskResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@TaskDef(name = "Output Data Staging Task")
public class OutputDataStagingTask extends DataStagingTask {

    private final static Logger logger = LoggerFactory.getLogger(OutputDataStagingTask.class);

    @Override
    public TaskResult onRun(TaskHelper taskHelper, TaskContext taskContext) {

        logger.info("Starting output data staging task " + getTaskId() + " in experiment " + getExperimentId());
        saveAndPublishProcessStatus(ProcessState.OUTPUT_DATA_STAGING);

        try {
            // Get and validate data staging task model
            DataStagingTaskModel dataStagingTaskModel = getDataStagingTaskModel();

            // Fetch and validate input data type from data staging task model
            OutputDataObjectType processOutput = dataStagingTaskModel.getProcessOutput();
            if (processOutput != null && processOutput.getValue() == null) {
                String message = "expId: " + getExperimentId() + ", processId: " + getProcessId() + ", taskId: " + getTaskId() +
                        ":- Couldn't stage file " + processOutput.getName() + " , file name shouldn't be null. ";
                logger.error(message);
                if (processOutput.isIsRequired()) {
                    message += "File name is null, but this output's isRequired bit is not set";
                } else {
                    message += "File name is null";
                }
                throw new TaskOnFailException(message, true, null);
            }

            // Fetch and validate storage resource
            StorageResourceDescription storageResource = getStorageResource();

            // Fetch and validate source and destination URLS
            URI sourceURI;
            URI destinationURI;
            String sourceFileName;
            try {
                sourceURI = new URI(dataStagingTaskModel.getSource());
                sourceFileName = sourceURI.getPath().substring(sourceURI.getPath().lastIndexOf(File.separator) + 1,
                        sourceURI.getPath().length());

                if (dataStagingTaskModel.getDestination().startsWith("dummy")) {

                    String inputPath  = getTaskContext().getStorageFileSystemRootLocation();
                    String destFilePath =  buildDestinationFilePath(inputPath, sourceFileName);

                    destinationURI = new URI("file", getTaskContext().getStorageResourceLoginUserName(),
                            storageResource.getHostName(), 22, destFilePath, null, null);

                } else {
                    destinationURI = new URI(dataStagingTaskModel.getDestination());
                }

                if (logger.isDebugEnabled()) {
                    logger.debug("Source file " + sourceURI.getPath() + ", destination uri " + destinationURI.getPath() + " for task " + getTaskId());
                }
            } catch (URISyntaxException e) {
                throw new TaskOnFailException("Failed to obtain source URI for output data staging task " + getTaskId(), true, e);
            }

            // Fetch and validate storage adaptor
            StorageResourceAdaptor storageResourceAdaptor = getStorageAdaptor(taskHelper.getAdaptorSupport());

            // Fetch and validate compute resource adaptor
            AgentAdaptor adaptor = getComputeResourceAdaptor(taskHelper.getAdaptorSupport());

            List<URI> destinationURIs = new ArrayList<URI>();

            if (sourceFileName.contains("*")) {
                // if file is declared as a wild card
                logger.info("Handling output files with " + sourceFileName + " extension for task " + getTaskId());

                String destParentPath = (new File(destinationURI.getPath())).getParentFile().getPath();
                String sourceParentPath = (new File(sourceURI.getPath())).getParentFile().getPath();

                logger.debug("Destination parent path " + destParentPath + ", source parent path " + sourceParentPath);
                List<String> filePaths;
                try {
                    filePaths = adaptor.getFileNameFromExtension(sourceFileName, sourceParentPath);

                    if (logger.isTraceEnabled()) {
                        filePaths.forEach(fileName -> logger.trace("File found : " + fileName));
                    }

                } catch (AgentException e) {
                    throw new TaskOnFailException("Failed to fetch the file list from extension " + sourceFileName, false, e);
                }

                for (String subFilePath : filePaths) {
                    if (subFilePath == null || "".equals(subFilePath)) {
                        logger.warn("Ignoring file transfer as filename is empty or null");
                        continue;
                    }
                    sourceFileName = subFilePath;
                    if (destParentPath.endsWith(File.separator)) {
                        destinationURI = new URI(destParentPath + subFilePath);
                    } else {
                        destinationURI = new URI(destParentPath + File.separator + subFilePath);
                    }

                    URI newSourceURI = new URI((sourceParentPath.endsWith(File.separator) ?
                            sourceParentPath : sourceParentPath + File.separator) + sourceFileName);

                    //Wildcard support is only enabled for output data staging
                    assert processOutput != null;
                    logger.info("Transferring file " + sourceFileName);
                    boolean transferred = transferFileToStorage(newSourceURI.getPath(), destinationURI.getPath(), sourceFileName, adaptor, storageResourceAdaptor);
                    if (transferred) {
                        destinationURIs.add(destinationURI);
                    } else {
                        logger.warn("File " + sourceFileName + " did not transfer");
                    }

                    if (processOutput.getType() == DataType.URI) {
                        if (filePaths.size() > 1) {
                            logger.warn("More than one file matched wildcard, but output type is URI. Skipping remaining matches: " + filePaths.subList(1, filePaths.size()));
                        }
                        break;
                    }
                }
                if (!destinationURIs.isEmpty()) {
                    if (processOutput.getType() == DataType.URI) {
                        saveExperimentOutput(processOutput.getName(), destinationURIs.get(0).toString());
                    } else if (processOutput.getType() == DataType.URI_COLLECTION) {
                        saveExperimentOutputCollection(processOutput.getName(), destinationURIs.stream().map(URI::toString).collect(Collectors.toList()));
                    }
                }
                return onSuccess("Output data staging task " + getTaskId() + " successfully completed");

            } else {
                // Uploading output file to the storage resource
                assert processOutput != null;
                boolean transferred = false;
                if (ServerSettings.isAgentTransferEnabled()) {
                    String sourceId = "CLUSTER:" + sourceURI.getPath() + ":" + getGatewayId() + ":" + getTaskContext().getComputeResourceId();
                    String sourceToken = getTaskContext().getComputeResourceCredentialToken() + ":" + getTaskContext().getComputeResourceLoginUserName() + ":" + getGatewayId();

                    String destId = "STORAGE:" + destinationURI.getPath() + ":" + getGatewayId() + ":" + getTaskContext().getStorageResourceId();
                    String destToken = getTaskContext().getStorageResourceCredentialToken() + ":" + getTaskContext().getStorageResourceLoginUserName() + ":" + getGatewayId();

                    TransferRequest request = new TransferRequest();
                    request.setSourceId(sourceId);
                    request.setSourceToken(sourceToken);
                    request.setSourceType("SCP");

                    request.setDestinationId(destId);
                    request.setDestinationToken(destToken);
                    request.setDestinationType("SCP");

                    MFTAdmin mftAdmin = new MFTAdmin();
                    List<AgentInfo> liveAgentInfos = mftAdmin.getLiveAgentInfos();
                    if (liveAgentInfos.size() == 0) {
                        throw new TaskOnFailException("No active agent available", false, null);
                    }

                    String transferId = mftAdmin.submitTransfer(liveAgentInfos.get(0).getId(), request);
                    logger.info("Submitted to Agent " + liveAgentInfos.get(0).getId() + ". Transfer id " + transferId);

                    while (true) {
                        TransferState transferState = mftAdmin.getTransferState(transferId);
                        logger.info("Transfer status of " + transferId + " is " + transferState.getState());
                        if ("COMPLETED".equals(transferState.getState())) {
                            transferred = true;
                            break;
                        } else if ("FAILED".equals(transferState.getState())) {
                            throw new TaskOnFailException("Transfer " + transferId + " failed", false, null);
                        }
                        Thread.sleep(1000);
                    }

                } else {
                    transferred = transferFileToStorage(sourceURI.getPath(), destinationURI.getPath(), sourceFileName, adaptor, storageResourceAdaptor);
                }

                if (transferred) {
                    saveExperimentOutput(processOutput.getName(), destinationURI.toString());
                } else {
                    logger.warn("File " + sourceFileName + " did not transfer");
                }
                return onSuccess("Output data staging task " + getTaskId() + " successfully completed");
            }

        } catch (TaskOnFailException e) {
            if (e.getError() != null) {
                logger.error(e.getReason(), e.getError());
            } else {
                logger.error(e.getReason());
            }
            return onFail(e.getReason(), e.isCritical(), e.getError());

        } catch (Exception e) {
            logger.error("Unknown error while executing output data staging task " + getTaskId(), e);
            return onFail("Unknown error while executing output data staging task " + getTaskId(), false,  e);
        }
    }

    @Override
    public void onCancel(TaskContext taskContext) {

    }
}
