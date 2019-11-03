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
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef account_provisioning_model_TYPES_H
#define account_provisioning_model_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/TBase.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/cxxfunctional.h>


namespace apache { namespace airavata { namespace model { namespace appcatalog { namespace accountprovisioning {

struct SSHAccountProvisionerConfigParamType {
  enum type {
    STRING = 0,
    CRED_STORE_PASSWORD_TOKEN = 1
  };
};

extern const std::map<int, const char*> _SSHAccountProvisionerConfigParamType_VALUES_TO_NAMES;

class SSHAccountProvisionerConfigParam;

class SSHAccountProvisioner;

typedef struct _SSHAccountProvisionerConfigParam__isset {
  _SSHAccountProvisionerConfigParam__isset() : description(false) {}
  bool description :1;
} _SSHAccountProvisionerConfigParam__isset;

class SSHAccountProvisionerConfigParam : public virtual ::apache::thrift::TBase {
 public:

  SSHAccountProvisionerConfigParam(const SSHAccountProvisionerConfigParam&);
  SSHAccountProvisionerConfigParam& operator=(const SSHAccountProvisionerConfigParam&);
  SSHAccountProvisionerConfigParam() : name(), type((SSHAccountProvisionerConfigParamType::type)0), isOptional(false), description() {
    type = (SSHAccountProvisionerConfigParamType::type)0;

  }

  virtual ~SSHAccountProvisionerConfigParam() throw();
  std::string name;
  SSHAccountProvisionerConfigParamType::type type;
  bool isOptional;
  std::string description;

  _SSHAccountProvisionerConfigParam__isset __isset;

  void __set_name(const std::string& val);

  void __set_type(const SSHAccountProvisionerConfigParamType::type val);

  void __set_isOptional(const bool val);

  void __set_description(const std::string& val);

  bool operator == (const SSHAccountProvisionerConfigParam & rhs) const
  {
    if (!(name == rhs.name))
      return false;
    if (!(type == rhs.type))
      return false;
    if (!(isOptional == rhs.isOptional))
      return false;
    if (__isset.description != rhs.__isset.description)
      return false;
    else if (__isset.description && !(description == rhs.description))
      return false;
    return true;
  }
  bool operator != (const SSHAccountProvisionerConfigParam &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const SSHAccountProvisionerConfigParam & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(SSHAccountProvisionerConfigParam &a, SSHAccountProvisionerConfigParam &b);

inline std::ostream& operator<<(std::ostream& out, const SSHAccountProvisionerConfigParam& obj)
{
  obj.printTo(out);
  return out;
}


class SSHAccountProvisioner : public virtual ::apache::thrift::TBase {
 public:

  SSHAccountProvisioner(const SSHAccountProvisioner&);
  SSHAccountProvisioner& operator=(const SSHAccountProvisioner&);
  SSHAccountProvisioner() : name(), canCreateAccount(0), canInstallSSHKey(0) {
  }

  virtual ~SSHAccountProvisioner() throw();
  std::string name;
  bool canCreateAccount;
  bool canInstallSSHKey;
  std::vector<SSHAccountProvisionerConfigParam>  configParams;

  void __set_name(const std::string& val);

  void __set_canCreateAccount(const bool val);

  void __set_canInstallSSHKey(const bool val);

  void __set_configParams(const std::vector<SSHAccountProvisionerConfigParam> & val);

  bool operator == (const SSHAccountProvisioner & rhs) const
  {
    if (!(name == rhs.name))
      return false;
    if (!(canCreateAccount == rhs.canCreateAccount))
      return false;
    if (!(canInstallSSHKey == rhs.canInstallSSHKey))
      return false;
    if (!(configParams == rhs.configParams))
      return false;
    return true;
  }
  bool operator != (const SSHAccountProvisioner &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const SSHAccountProvisioner & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(SSHAccountProvisioner &a, SSHAccountProvisioner &b);

inline std::ostream& operator<<(std::ostream& out, const SSHAccountProvisioner& obj)
{
  obj.printTo(out);
  return out;
}

}}}}} // namespace

#endif