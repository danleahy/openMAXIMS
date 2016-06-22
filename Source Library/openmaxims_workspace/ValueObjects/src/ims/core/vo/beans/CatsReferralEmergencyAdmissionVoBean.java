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

public class CatsReferralEmergencyAdmissionVoBean extends ims.vo.ValueObjectBean
{
	public CatsReferralEmergencyAdmissionVoBean()
	{
	}
	public CatsReferralEmergencyAdmissionVoBean(ims.core.vo.CatsReferralEmergencyAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.RefMan.vo.beans.CatsReferralStatusVoBean)vo.getCurrentStatus().getBean();
		if(vo.getStatusHistory() != null)
		{
			this.statushistory = new ims.vo.RefVoBean[vo.getStatusHistory().size()];
			for(int statushistory_i = 0; statushistory_i < vo.getStatusHistory().size(); statushistory_i++)
			{
				this.statushistory[statushistory_i] = new ims.vo.RefVoBean(vo.getStatusHistory().get(statushistory_i).getBoId(),vo.getStatusHistory().get(statushistory_i).getBoVersion());
			}
		}
		this.journey = vo.getJourney() == null ? null : new ims.vo.RefVoBean(vo.getJourney().getBoId(), vo.getJourney().getBoVersion());
		this.admissions = vo.getAdmissions() == null ? null : vo.getAdmissions().getBeanCollection();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.core.vo.beans.ReferralDetailsEmergencyAdmissionVoBean)vo.getReferralDetails().getBean();
		this.contract = vo.getContract() == null ? null : new ims.vo.RefVoBean(vo.getContract().getBoId(), vo.getContract().getBoVersion());
		this.hasappointments = vo.getHasAppointments();
		this.isemergencyreferral = vo.getIsEmergencyReferral();
		this.rttclockimpact = vo.getRTTClockImpact();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.urgency = vo.getUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgency().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CatsReferralEmergencyAdmissionVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.RefMan.vo.beans.CatsReferralStatusVoBean)vo.getCurrentStatus().getBean(map);
		if(vo.getStatusHistory() != null)
		{
			this.statushistory = new ims.vo.RefVoBean[vo.getStatusHistory().size()];
			for(int statushistory_i = 0; statushistory_i < vo.getStatusHistory().size(); statushistory_i++)
			{
				this.statushistory[statushistory_i] = new ims.vo.RefVoBean(vo.getStatusHistory().get(statushistory_i).getBoId(),vo.getStatusHistory().get(statushistory_i).getBoVersion());
			}
		}
		this.journey = vo.getJourney() == null ? null : new ims.vo.RefVoBean(vo.getJourney().getBoId(), vo.getJourney().getBoVersion());
		this.admissions = vo.getAdmissions() == null ? null : vo.getAdmissions().getBeanCollection();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.core.vo.beans.ReferralDetailsEmergencyAdmissionVoBean)vo.getReferralDetails().getBean(map);
		this.contract = vo.getContract() == null ? null : new ims.vo.RefVoBean(vo.getContract().getBoId(), vo.getContract().getBoVersion());
		this.hasappointments = vo.getHasAppointments();
		this.isemergencyreferral = vo.getIsEmergencyReferral();
		this.rttclockimpact = vo.getRTTClockImpact();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.urgency = vo.getUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgency().getBean();
	}

	public ims.core.vo.CatsReferralEmergencyAdmissionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CatsReferralEmergencyAdmissionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CatsReferralEmergencyAdmissionVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CatsReferralEmergencyAdmissionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CatsReferralEmergencyAdmissionVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.RefMan.vo.beans.CatsReferralStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.beans.CatsReferralStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.vo.RefVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.vo.RefVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.vo.RefVoBean getJourney()
	{
		return this.journey;
	}
	public void setJourney(ims.vo.RefVoBean value)
	{
		this.journey = value;
	}
	public ims.core.vo.beans.AdmissionDetailVoBean[] getAdmissions()
	{
		return this.admissions;
	}
	public void setAdmissions(ims.core.vo.beans.AdmissionDetailVoBean[] value)
	{
		this.admissions = value;
	}
	public ims.core.vo.beans.ReferralDetailsEmergencyAdmissionVoBean getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.core.vo.beans.ReferralDetailsEmergencyAdmissionVoBean value)
	{
		this.referraldetails = value;
	}
	public ims.vo.RefVoBean getContract()
	{
		return this.contract;
	}
	public void setContract(ims.vo.RefVoBean value)
	{
		this.contract = value;
	}
	public Boolean getHasAppointments()
	{
		return this.hasappointments;
	}
	public void setHasAppointments(Boolean value)
	{
		this.hasappointments = value;
	}
	public Boolean getIsEmergencyReferral()
	{
		return this.isemergencyreferral;
	}
	public void setIsEmergencyReferral(Boolean value)
	{
		this.isemergencyreferral = value;
	}
	public Boolean getRTTClockImpact()
	{
		return this.rttclockimpact;
	}
	public void setRTTClockImpact(Boolean value)
	{
		this.rttclockimpact = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.vo.LookupInstanceBean getUrgency()
	{
		return this.urgency;
	}
	public void setUrgency(ims.vo.LookupInstanceBean value)
	{
		this.urgency = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PatientLite_IdentifiersVoBean patient;
	private ims.vo.RefVoBean carecontext;
	private ims.RefMan.vo.beans.CatsReferralStatusVoBean currentstatus;
	private ims.vo.RefVoBean[] statushistory;
	private ims.vo.RefVoBean journey;
	private ims.core.vo.beans.AdmissionDetailVoBean[] admissions;
	private ims.core.vo.beans.ReferralDetailsEmergencyAdmissionVoBean referraldetails;
	private ims.vo.RefVoBean contract;
	private Boolean hasappointments;
	private Boolean isemergencyreferral;
	private Boolean rttclockimpact;
	private ims.vo.RefVoBean episodeofcare;
	private ims.vo.LookupInstanceBean urgency;
}
