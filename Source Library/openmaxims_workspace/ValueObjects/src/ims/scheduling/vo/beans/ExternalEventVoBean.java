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

package ims.scheduling.vo.beans;

public class ExternalEventVoBean extends ims.vo.ValueObjectBean
{
	public ExternalEventVoBean()
	{
	}
	public ExternalEventVoBean(ims.scheduling.vo.ExternalEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.appointment = vo.getAppointment() == null ? null : new ims.vo.RefVoBean(vo.getAppointment().getBoId(), vo.getAppointment().getBoVersion());
		this.wasprocessed = vo.getWasProcessed();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean();
		this.messagestatus = vo.getMessageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageStatus().getBean();
		this.msgtext = vo.getMsgText();
		this.failuremsg = vo.getFailureMsg();
		this.processeddatetime = vo.getProcessedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getProcessedDateTime().getBean();
		this.investigation = vo.getInvestigation() == null ? null : new ims.vo.RefVoBean(vo.getInvestigation().getBoId(), vo.getInvestigation().getBoVersion());
		this.acktext = vo.getAckText();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.ExternalEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		this.appointment = vo.getAppointment() == null ? null : new ims.vo.RefVoBean(vo.getAppointment().getBoId(), vo.getAppointment().getBoVersion());
		this.wasprocessed = vo.getWasProcessed();
		this.providersystem = vo.getProviderSystem() == null ? null : (ims.ocrr.vo.beans.ProviderSystemVoBean)vo.getProviderSystem().getBean(map);
		this.messagestatus = vo.getMessageStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMessageStatus().getBean();
		this.msgtext = vo.getMsgText();
		this.failuremsg = vo.getFailureMsg();
		this.processeddatetime = vo.getProcessedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getProcessedDateTime().getBean();
		this.investigation = vo.getInvestigation() == null ? null : new ims.vo.RefVoBean(vo.getInvestigation().getBoId(), vo.getInvestigation().getBoVersion());
		this.acktext = vo.getAckText();
	}

	public ims.scheduling.vo.ExternalEventVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.ExternalEventVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.ExternalEventVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.ExternalEventVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.ExternalEventVo();
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
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public ims.vo.RefVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.vo.RefVoBean value)
	{
		this.appointment = value;
	}
	public Boolean getWasProcessed()
	{
		return this.wasprocessed;
	}
	public void setWasProcessed(Boolean value)
	{
		this.wasprocessed = value;
	}
	public ims.ocrr.vo.beans.ProviderSystemVoBean getProviderSystem()
	{
		return this.providersystem;
	}
	public void setProviderSystem(ims.ocrr.vo.beans.ProviderSystemVoBean value)
	{
		this.providersystem = value;
	}
	public ims.vo.LookupInstanceBean getMessageStatus()
	{
		return this.messagestatus;
	}
	public void setMessageStatus(ims.vo.LookupInstanceBean value)
	{
		this.messagestatus = value;
	}
	public String getMsgText()
	{
		return this.msgtext;
	}
	public void setMsgText(String value)
	{
		this.msgtext = value;
	}
	public String getFailureMsg()
	{
		return this.failuremsg;
	}
	public void setFailureMsg(String value)
	{
		this.failuremsg = value;
	}
	public ims.framework.utils.beans.DateTimeBean getProcessedDateTime()
	{
		return this.processeddatetime;
	}
	public void setProcessedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.processeddatetime = value;
	}
	public ims.vo.RefVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.vo.RefVoBean value)
	{
		this.investigation = value;
	}
	public String getAckText()
	{
		return this.acktext;
	}
	public void setAckText(String value)
	{
		this.acktext = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean eventtype;
	private ims.vo.RefVoBean appointment;
	private Boolean wasprocessed;
	private ims.ocrr.vo.beans.ProviderSystemVoBean providersystem;
	private ims.vo.LookupInstanceBean messagestatus;
	private String msgtext;
	private String failuremsg;
	private ims.framework.utils.beans.DateTimeBean processeddatetime;
	private ims.vo.RefVoBean investigation;
	private String acktext;
}
