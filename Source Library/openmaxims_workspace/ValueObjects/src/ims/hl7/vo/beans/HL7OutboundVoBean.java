//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.hl7.vo.beans;

public class HL7OutboundVoBean extends ims.vo.ValueObjectBean
{
	public HL7OutboundVoBean()
	{
	}
	public HL7OutboundVoBean(ims.hl7.vo.HL7OutboundVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteVoBean)vo.getPatient().getBean();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean();
		this.hl7message = vo.getHL7Message();
		this.messagetype = vo.getMessageType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageType().getBean();
		this.messagecategory = vo.getMessageCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageCategory().getBean();
		this.failuremessage = vo.getFailureMessage();
		this.messagesentdatetime = vo.getMessageSentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMessageSentDateTime().getBean();
		this.successfuloutcome = vo.getSuccessfulOutcome();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.hl7.vo.HL7OutboundVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLiteVoBean)vo.getPatient().getBean(map);
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean(map);
		this.hl7message = vo.getHL7Message();
		this.messagetype = vo.getMessageType() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageType().getBean();
		this.messagecategory = vo.getMessageCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageCategory().getBean();
		this.failuremessage = vo.getFailureMessage();
		this.messagesentdatetime = vo.getMessageSentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getMessageSentDateTime().getBean();
		this.successfuloutcome = vo.getSuccessfulOutcome();
	}

	public ims.hl7.vo.HL7OutboundVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.hl7.vo.HL7OutboundVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.hl7.vo.HL7OutboundVo vo = null;
		if(map != null)
			vo = (ims.hl7.vo.HL7OutboundVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.hl7.vo.HL7OutboundVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.core.vo.beans.PatientLiteVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLiteVoBean value)
	{
		this.patient = value;
	}
	public ims.ocrr.vo.beans.ProviderSystemVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.ocrr.vo.beans.ProviderSystemVoBean value)
	{
		this.providersystem = value;
	}
	public String getHL7Message()
	{
		return this.hl7message;
	}
	public void setHL7Message(String value)
	{
		this.hl7message = value;
	}
	public ims.vo.LookupInstanceBean getMessageType()
	{
		return this.messagetype;
	}
	public void setMessageType(ims.vo.LookupInstanceBean value)
	{
		this.messagetype = value;
	}
	public ims.vo.LookupInstanceBean getMessageCategory()
	{
		return this.messagecategory;
	}
	public void setMessageCategory(ims.vo.LookupInstanceBean value)
	{
		this.messagecategory = value;
	}
	public String getFailureMessage()
	{
		return this.failuremessage;
	}
	public void setFailureMessage(String value)
	{
		this.failuremessage = value;
	}
	public ims.framework.utils.beans.DateTimeBean getMessageSentDateTime()
	{
		return this.messagesentdatetime;
	}
	public void setMessageSentDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.messagesentdatetime = value;
	}
	public Boolean getSuccessfulOutcome()
	{
		return this.successfuloutcome;
	}
	public void setSuccessfulOutcome(Boolean value)
	{
		this.successfuloutcome = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientLiteVoBean patient;
	private ims.ocrr.vo.beans.ProviderSystemVoBean providersystem;
	private String hl7message;
	private ims.vo.LookupInstanceBean messagetype;
	private ims.vo.LookupInstanceBean messagecategory;
	private String failuremessage;
	private ims.framework.utils.beans.DateTimeBean messagesentdatetime;
	private Boolean successfuloutcome;
}
