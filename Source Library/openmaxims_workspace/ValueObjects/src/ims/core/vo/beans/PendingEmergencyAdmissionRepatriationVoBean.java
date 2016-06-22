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

package ims.core.vo.beans;

public class PendingEmergencyAdmissionRepatriationVoBean extends ims.vo.ValueObjectBean
{
	public PendingEmergencyAdmissionRepatriationVoBean()
	{
	}
	public PendingEmergencyAdmissionRepatriationVoBean(ims.core.vo.PendingEmergencyAdmissionRepatriationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.transferreason = vo.getTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferReason().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getHospital().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean();
		this.referredlocation = vo.getReferredLocation();
		this.contactdetails = vo.getContactDetails();
		this.comments = vo.getComments();
		this.proposedtransferdate = vo.getProposedTransferDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getProposedTransferDate().getBean();
		this.recordedby = vo.getRecordedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordedBy().getBean();
		this.recordeddatetime = vo.getRecordedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordedDateTime().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PendingEmergencyAdmissionRepatriationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.transferreason = vo.getTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferReason().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getHospital().getBean(map);
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean(map);
		this.referredlocation = vo.getReferredLocation();
		this.contactdetails = vo.getContactDetails();
		this.comments = vo.getComments();
		this.proposedtransferdate = vo.getProposedTransferDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getProposedTransferDate().getBean();
		this.recordedby = vo.getRecordedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRecordedBy().getBean(map);
		this.recordeddatetime = vo.getRecordedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRecordedDateTime().getBean();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
	}

	public ims.core.vo.PendingEmergencyAdmissionRepatriationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PendingEmergencyAdmissionRepatriationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PendingEmergencyAdmissionRepatriationVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PendingEmergencyAdmissionRepatriationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PendingEmergencyAdmissionRepatriationVo();
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
	public ims.vo.LookupInstanceBean getType()
	{
		return this.type;
	}
	public void setType(ims.vo.LookupInstanceBean value)
	{
		this.type = value;
	}
	public ims.vo.LookupInstanceBean getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.vo.LookupInstanceBean value)
	{
		this.category = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public ims.vo.LookupInstanceBean getTransferReason()
	{
		return this.transferreason;
	}
	public void setTransferReason(ims.vo.LookupInstanceBean value)
	{
		this.transferreason = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.hospital = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.ward = value;
	}
	public String getReferredLocation()
	{
		return this.referredlocation;
	}
	public void setReferredLocation(String value)
	{
		this.referredlocation = value;
	}
	public String getContactDetails()
	{
		return this.contactdetails;
	}
	public void setContactDetails(String value)
	{
		this.contactdetails = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.framework.utils.beans.DateBean getProposedTransferDate()
	{
		return this.proposedtransferdate;
	}
	public void setProposedTransferDate(ims.framework.utils.beans.DateBean value)
	{
		this.proposedtransferdate = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRecordedBy()
	{
		return this.recordedby;
	}
	public void setRecordedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.recordedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRecordedDateTime()
	{
		return this.recordeddatetime;
	}
	public void setRecordedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.recordeddatetime = value;
	}
	public ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfEmergencyReferral()
	{
		return this.sourceofemergencyreferral;
	}
	public void setSourceOfEmergencyReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofemergencyreferral = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean type;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private ims.vo.LookupInstanceBean transferreason;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.core.vo.beans.LocationLiteVoBean hospital;
	private ims.core.vo.beans.LocationLiteVoBean ward;
	private String referredlocation;
	private String contactdetails;
	private String comments;
	private ims.framework.utils.beans.DateBean proposedtransferdate;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean recordedby;
	private ims.framework.utils.beans.DateTimeBean recordeddatetime;
	private ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean currentstatus;
	private ims.core.vo.beans.PendingEmergencyAdmissionStatusVoBean[] statushistory;
	private ims.vo.LookupInstanceBean sourceofemergencyreferral;
}
