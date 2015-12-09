/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.appcatalog.appdeployment;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Application Module Information. A module has to be registered before registering a deployment.
 * 
 * appModuleId: Airavata Internal Unique Job ID. This is set by the registry.
 * 
 * appModuleName:
 *   Name of the application module.
 * 
 * appModuleVersion:
 *   Version of the application.
 * 
 * appModuleDescription:
 *    Descriprion of the Module
 * 
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-12-8")
public class ApplicationModule implements org.apache.thrift.TBase<ApplicationModule, ApplicationModule._Fields>, java.io.Serializable, Cloneable, Comparable<ApplicationModule> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ApplicationModule");

  private static final org.apache.thrift.protocol.TField APP_MODULE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("appModuleId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField APP_MODULE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("appModuleName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField APP_MODULE_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("appModuleVersion", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField APP_MODULE_DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("appModuleDescription", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ApplicationModuleStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ApplicationModuleTupleSchemeFactory());
  }

  private String appModuleId; // required
  private String appModuleName; // required
  private String appModuleVersion; // optional
  private String appModuleDescription; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    APP_MODULE_ID((short)1, "appModuleId"),
    APP_MODULE_NAME((short)2, "appModuleName"),
    APP_MODULE_VERSION((short)3, "appModuleVersion"),
    APP_MODULE_DESCRIPTION((short)4, "appModuleDescription");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // APP_MODULE_ID
          return APP_MODULE_ID;
        case 2: // APP_MODULE_NAME
          return APP_MODULE_NAME;
        case 3: // APP_MODULE_VERSION
          return APP_MODULE_VERSION;
        case 4: // APP_MODULE_DESCRIPTION
          return APP_MODULE_DESCRIPTION;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.APP_MODULE_VERSION,_Fields.APP_MODULE_DESCRIPTION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.APP_MODULE_ID, new org.apache.thrift.meta_data.FieldMetaData("appModuleId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP_MODULE_NAME, new org.apache.thrift.meta_data.FieldMetaData("appModuleName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP_MODULE_VERSION, new org.apache.thrift.meta_data.FieldMetaData("appModuleVersion", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.APP_MODULE_DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("appModuleDescription", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ApplicationModule.class, metaDataMap);
  }

  public ApplicationModule() {
    this.appModuleId = "DO_NOT_SET_AT_CLIENTS";

  }

  public ApplicationModule(
    String appModuleId,
    String appModuleName)
  {
    this();
    this.appModuleId = appModuleId;
    this.appModuleName = appModuleName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ApplicationModule(ApplicationModule other) {
    if (other.isSetAppModuleId()) {
      this.appModuleId = other.appModuleId;
    }
    if (other.isSetAppModuleName()) {
      this.appModuleName = other.appModuleName;
    }
    if (other.isSetAppModuleVersion()) {
      this.appModuleVersion = other.appModuleVersion;
    }
    if (other.isSetAppModuleDescription()) {
      this.appModuleDescription = other.appModuleDescription;
    }
  }

  public ApplicationModule deepCopy() {
    return new ApplicationModule(this);
  }

  @Override
  public void clear() {
    this.appModuleId = "DO_NOT_SET_AT_CLIENTS";

    this.appModuleName = null;
    this.appModuleVersion = null;
    this.appModuleDescription = null;
  }

  public String getAppModuleId() {
    return this.appModuleId;
  }

  public void setAppModuleId(String appModuleId) {
    this.appModuleId = appModuleId;
  }

  public void unsetAppModuleId() {
    this.appModuleId = null;
  }

  /** Returns true if field appModuleId is set (has been assigned a value) and false otherwise */
  public boolean isSetAppModuleId() {
    return this.appModuleId != null;
  }

  public void setAppModuleIdIsSet(boolean value) {
    if (!value) {
      this.appModuleId = null;
    }
  }

  public String getAppModuleName() {
    return this.appModuleName;
  }

  public void setAppModuleName(String appModuleName) {
    this.appModuleName = appModuleName;
  }

  public void unsetAppModuleName() {
    this.appModuleName = null;
  }

  /** Returns true if field appModuleName is set (has been assigned a value) and false otherwise */
  public boolean isSetAppModuleName() {
    return this.appModuleName != null;
  }

  public void setAppModuleNameIsSet(boolean value) {
    if (!value) {
      this.appModuleName = null;
    }
  }

  public String getAppModuleVersion() {
    return this.appModuleVersion;
  }

  public void setAppModuleVersion(String appModuleVersion) {
    this.appModuleVersion = appModuleVersion;
  }

  public void unsetAppModuleVersion() {
    this.appModuleVersion = null;
  }

  /** Returns true if field appModuleVersion is set (has been assigned a value) and false otherwise */
  public boolean isSetAppModuleVersion() {
    return this.appModuleVersion != null;
  }

  public void setAppModuleVersionIsSet(boolean value) {
    if (!value) {
      this.appModuleVersion = null;
    }
  }

  public String getAppModuleDescription() {
    return this.appModuleDescription;
  }

  public void setAppModuleDescription(String appModuleDescription) {
    this.appModuleDescription = appModuleDescription;
  }

  public void unsetAppModuleDescription() {
    this.appModuleDescription = null;
  }

  /** Returns true if field appModuleDescription is set (has been assigned a value) and false otherwise */
  public boolean isSetAppModuleDescription() {
    return this.appModuleDescription != null;
  }

  public void setAppModuleDescriptionIsSet(boolean value) {
    if (!value) {
      this.appModuleDescription = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case APP_MODULE_ID:
      if (value == null) {
        unsetAppModuleId();
      } else {
        setAppModuleId((String)value);
      }
      break;

    case APP_MODULE_NAME:
      if (value == null) {
        unsetAppModuleName();
      } else {
        setAppModuleName((String)value);
      }
      break;

    case APP_MODULE_VERSION:
      if (value == null) {
        unsetAppModuleVersion();
      } else {
        setAppModuleVersion((String)value);
      }
      break;

    case APP_MODULE_DESCRIPTION:
      if (value == null) {
        unsetAppModuleDescription();
      } else {
        setAppModuleDescription((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case APP_MODULE_ID:
      return getAppModuleId();

    case APP_MODULE_NAME:
      return getAppModuleName();

    case APP_MODULE_VERSION:
      return getAppModuleVersion();

    case APP_MODULE_DESCRIPTION:
      return getAppModuleDescription();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case APP_MODULE_ID:
      return isSetAppModuleId();
    case APP_MODULE_NAME:
      return isSetAppModuleName();
    case APP_MODULE_VERSION:
      return isSetAppModuleVersion();
    case APP_MODULE_DESCRIPTION:
      return isSetAppModuleDescription();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ApplicationModule)
      return this.equals((ApplicationModule)that);
    return false;
  }

  public boolean equals(ApplicationModule that) {
    if (that == null)
      return false;

    boolean this_present_appModuleId = true && this.isSetAppModuleId();
    boolean that_present_appModuleId = true && that.isSetAppModuleId();
    if (this_present_appModuleId || that_present_appModuleId) {
      if (!(this_present_appModuleId && that_present_appModuleId))
        return false;
      if (!this.appModuleId.equals(that.appModuleId))
        return false;
    }

    boolean this_present_appModuleName = true && this.isSetAppModuleName();
    boolean that_present_appModuleName = true && that.isSetAppModuleName();
    if (this_present_appModuleName || that_present_appModuleName) {
      if (!(this_present_appModuleName && that_present_appModuleName))
        return false;
      if (!this.appModuleName.equals(that.appModuleName))
        return false;
    }

    boolean this_present_appModuleVersion = true && this.isSetAppModuleVersion();
    boolean that_present_appModuleVersion = true && that.isSetAppModuleVersion();
    if (this_present_appModuleVersion || that_present_appModuleVersion) {
      if (!(this_present_appModuleVersion && that_present_appModuleVersion))
        return false;
      if (!this.appModuleVersion.equals(that.appModuleVersion))
        return false;
    }

    boolean this_present_appModuleDescription = true && this.isSetAppModuleDescription();
    boolean that_present_appModuleDescription = true && that.isSetAppModuleDescription();
    if (this_present_appModuleDescription || that_present_appModuleDescription) {
      if (!(this_present_appModuleDescription && that_present_appModuleDescription))
        return false;
      if (!this.appModuleDescription.equals(that.appModuleDescription))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_appModuleId = true && (isSetAppModuleId());
    list.add(present_appModuleId);
    if (present_appModuleId)
      list.add(appModuleId);

    boolean present_appModuleName = true && (isSetAppModuleName());
    list.add(present_appModuleName);
    if (present_appModuleName)
      list.add(appModuleName);

    boolean present_appModuleVersion = true && (isSetAppModuleVersion());
    list.add(present_appModuleVersion);
    if (present_appModuleVersion)
      list.add(appModuleVersion);

    boolean present_appModuleDescription = true && (isSetAppModuleDescription());
    list.add(present_appModuleDescription);
    if (present_appModuleDescription)
      list.add(appModuleDescription);

    return list.hashCode();
  }

  @Override
  public int compareTo(ApplicationModule other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAppModuleId()).compareTo(other.isSetAppModuleId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppModuleId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appModuleId, other.appModuleId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppModuleName()).compareTo(other.isSetAppModuleName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppModuleName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appModuleName, other.appModuleName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppModuleVersion()).compareTo(other.isSetAppModuleVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppModuleVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appModuleVersion, other.appModuleVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppModuleDescription()).compareTo(other.isSetAppModuleDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppModuleDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appModuleDescription, other.appModuleDescription);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ApplicationModule(");
    boolean first = true;

    sb.append("appModuleId:");
    if (this.appModuleId == null) {
      sb.append("null");
    } else {
      sb.append(this.appModuleId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("appModuleName:");
    if (this.appModuleName == null) {
      sb.append("null");
    } else {
      sb.append(this.appModuleName);
    }
    first = false;
    if (isSetAppModuleVersion()) {
      if (!first) sb.append(", ");
      sb.append("appModuleVersion:");
      if (this.appModuleVersion == null) {
        sb.append("null");
      } else {
        sb.append(this.appModuleVersion);
      }
      first = false;
    }
    if (isSetAppModuleDescription()) {
      if (!first) sb.append(", ");
      sb.append("appModuleDescription:");
      if (this.appModuleDescription == null) {
        sb.append("null");
      } else {
        sb.append(this.appModuleDescription);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetAppModuleId()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'appModuleId' is unset! Struct:" + toString());
    }

    if (!isSetAppModuleName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'appModuleName' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ApplicationModuleStandardSchemeFactory implements SchemeFactory {
    public ApplicationModuleStandardScheme getScheme() {
      return new ApplicationModuleStandardScheme();
    }
  }

  private static class ApplicationModuleStandardScheme extends StandardScheme<ApplicationModule> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ApplicationModule struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // APP_MODULE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appModuleId = iprot.readString();
              struct.setAppModuleIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // APP_MODULE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appModuleName = iprot.readString();
              struct.setAppModuleNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // APP_MODULE_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appModuleVersion = iprot.readString();
              struct.setAppModuleVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // APP_MODULE_DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appModuleDescription = iprot.readString();
              struct.setAppModuleDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ApplicationModule struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.appModuleId != null) {
        oprot.writeFieldBegin(APP_MODULE_ID_FIELD_DESC);
        oprot.writeString(struct.appModuleId);
        oprot.writeFieldEnd();
      }
      if (struct.appModuleName != null) {
        oprot.writeFieldBegin(APP_MODULE_NAME_FIELD_DESC);
        oprot.writeString(struct.appModuleName);
        oprot.writeFieldEnd();
      }
      if (struct.appModuleVersion != null) {
        if (struct.isSetAppModuleVersion()) {
          oprot.writeFieldBegin(APP_MODULE_VERSION_FIELD_DESC);
          oprot.writeString(struct.appModuleVersion);
          oprot.writeFieldEnd();
        }
      }
      if (struct.appModuleDescription != null) {
        if (struct.isSetAppModuleDescription()) {
          oprot.writeFieldBegin(APP_MODULE_DESCRIPTION_FIELD_DESC);
          oprot.writeString(struct.appModuleDescription);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ApplicationModuleTupleSchemeFactory implements SchemeFactory {
    public ApplicationModuleTupleScheme getScheme() {
      return new ApplicationModuleTupleScheme();
    }
  }

  private static class ApplicationModuleTupleScheme extends TupleScheme<ApplicationModule> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ApplicationModule struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.appModuleId);
      oprot.writeString(struct.appModuleName);
      BitSet optionals = new BitSet();
      if (struct.isSetAppModuleVersion()) {
        optionals.set(0);
      }
      if (struct.isSetAppModuleDescription()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAppModuleVersion()) {
        oprot.writeString(struct.appModuleVersion);
      }
      if (struct.isSetAppModuleDescription()) {
        oprot.writeString(struct.appModuleDescription);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ApplicationModule struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.appModuleId = iprot.readString();
      struct.setAppModuleIdIsSet(true);
      struct.appModuleName = iprot.readString();
      struct.setAppModuleNameIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.appModuleVersion = iprot.readString();
        struct.setAppModuleVersionIsSet(true);
      }
      if (incoming.get(1)) {
        struct.appModuleDescription = iprot.readString();
        struct.setAppModuleDescriptionIsSet(true);
      }
    }
  }

}

