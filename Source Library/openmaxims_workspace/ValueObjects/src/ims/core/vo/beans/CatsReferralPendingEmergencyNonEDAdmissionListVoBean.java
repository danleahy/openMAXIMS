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

public class CatsReferralPendingEmergencyNonEDAdmissionListVoBean extends ims.vo.ValueObjectBean
{
	public CatsReferralPendingEmergencyNonEDAdmissionListVoBean()
	{
	}
	public CatsReferralPendingEmergencyNonEDAdmissionListVoBean(ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean();
		this.repatriationrequest = vo.getRepatriationRequest() == null ? null : (ims.core.vo.beans.PendingEmergencyNonEDAdmissionListVoBean)vo.getRepatriationRequest().getBean();
		this.acceptedstatus = vo.getAcceptedStatus() == null ? null : (ims.core.vo.beans.CatsReferralStatusWithHcpVoBean)vo.getAcceptedStatus().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.core.vo.beans.CatsReferralDetailsRepatriationRequestLiteVoBean)vo.getReferralDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean(map);
		this.repatriationrequest = vo.getRepatriationRequest() == null ? null : (ims.core.vo.beans.PendingEmergencyNonEDAdmissionListVoBean)vo.getRepatriationRequest().getBean(map);
		this.acceptedstatus = vo.getAcceptedStatus() == null ? null : (ims.core.vo.beans.CatsReferralStatusWithHcpVoBean)vo.getAcceptedStatus().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.core.vo.beans.CatsReferralDetailsRepatriationRequestLiteVoBean)vo.getReferralDetails().getBean(map);
	}

	public ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo();
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
	public ims.core.vo.beans.PatientLite_IdentifiersVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLite_IdentifiersVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.PendingEmergencyNonEDAdmissionListVoBean getRepatriationRequest()
	{
		return this.repatriationrequest;
	}
	public void setRepatriationRequest(ims.core.vo.beans.PendingEmergencyNonEDAdmissionListVoBean value)
	{
		this.repatriationrequest = value;
	}
	public ims.core.vo.beans.CatsReferralStatusWithHcpVoBean getAcceptedStatus()
	{
		return this.acceptedstatus;
	}
	public void setAcceptedStatus(ims.core.vo.beans.CatsReferralStatusWithHcpVoBean value)
	{
		this.acceptedstatus = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.CatsReferralDetailsRepatriationRequestLiteVoBean getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.core.vo.beans.CatsReferralDetailsRepatriationRequestLiteVoBean value)
	{
		this.referraldetails = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientLite_IdentifiersVoBean patient;
	private ims.core.vo.beans.PendingEmergencyNonEDAdmissionListVoBean repatriationrequest;
	private ims.core.vo.beans.CatsReferralStatusWithHcpVoBean acceptedstatus;
	private ims.vo.RefVoBean carecontext;
	private ims.core.vo.beans.CatsReferralDetailsRepatriationRequestLiteVoBean referraldetails;
}
