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

public class PendingEmergencyAdmissionWorklistSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public PendingEmergencyAdmissionWorklistSearchCriteriaVoBean()
	{
	}
	public PendingEmergencyAdmissionWorklistSearchCriteriaVoBean(ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo vo)
	{
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.transferreason = vo.getTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferReason().getBean();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getHospital().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.acceptingconsultant = vo.getAcceptingConsultant() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAcceptingConsultant().getBean();
		this.acceptingdatefrom = vo.getAcceptingDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAcceptingDateFrom().getBean();
		this.acceptingdateto = vo.getAcceptingDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAcceptingDateTo().getBean();
		this.referraldatefrom = vo.getReferralDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDateFrom().getBean();
		this.referraldateto = vo.getReferralDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDateTo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo vo)
	{
		this.type = vo.getType() == null ? null : (ims.vo.LookupInstanceBean)vo.getType().getBean();
		this.category = vo.getCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getCategory().getBean();
		this.transferreason = vo.getTransferReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTransferReason().getBean();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getHospital().getBean(map);
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.sourceofreferral = vo.getSourceOfReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfReferral().getBean();
		this.acceptingconsultant = vo.getAcceptingConsultant() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getAcceptingConsultant().getBean(map);
		this.acceptingdatefrom = vo.getAcceptingDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAcceptingDateFrom().getBean();
		this.acceptingdateto = vo.getAcceptingDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAcceptingDateTo().getBean();
		this.referraldatefrom = vo.getReferralDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDateFrom().getBean();
		this.referraldateto = vo.getReferralDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDateTo().getBean();
	}

	public ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
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
	public ims.vo.LookupInstanceBean getTransferReason()
	{
		return this.transferreason;
	}
	public void setTransferReason(ims.vo.LookupInstanceBean value)
	{
		this.transferreason = value;
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
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofreferral = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getAcceptingConsultant()
	{
		return this.acceptingconsultant;
	}
	public void setAcceptingConsultant(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.acceptingconsultant = value;
	}
	public ims.framework.utils.beans.DateBean getAcceptingDateFrom()
	{
		return this.acceptingdatefrom;
	}
	public void setAcceptingDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.acceptingdatefrom = value;
	}
	public ims.framework.utils.beans.DateBean getAcceptingDateTo()
	{
		return this.acceptingdateto;
	}
	public void setAcceptingDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.acceptingdateto = value;
	}
	public ims.framework.utils.beans.DateBean getReferralDateFrom()
	{
		return this.referraldatefrom;
	}
	public void setReferralDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.referraldatefrom = value;
	}
	public ims.framework.utils.beans.DateBean getReferralDateTo()
	{
		return this.referraldateto;
	}
	public void setReferralDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.referraldateto = value;
	}

	private ims.vo.LookupInstanceBean type;
	private ims.vo.LookupInstanceBean category;
	private ims.vo.LookupInstanceBean transferreason;
	private ims.core.vo.beans.LocationLiteVoBean hospital;
	private ims.core.vo.beans.LocationLiteVoBean ward;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private ims.vo.LookupInstanceBean sourceofreferral;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean acceptingconsultant;
	private ims.framework.utils.beans.DateBean acceptingdatefrom;
	private ims.framework.utils.beans.DateBean acceptingdateto;
	private ims.framework.utils.beans.DateBean referraldatefrom;
	private ims.framework.utils.beans.DateBean referraldateto;
}
