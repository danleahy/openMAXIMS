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

package ims.RefMan.vo.beans;

public class CatsReferralForReferralTriageVoBean extends ims.vo.ValueObjectBean
{
	public CatsReferralForReferralTriageVoBean()
	{
	}
	public CatsReferralForReferralTriageVoBean(ims.RefMan.vo.CatsReferralForReferralTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.referraldocuments = vo.getReferralDocuments() == null ? null : vo.getReferralDocuments().getBeanCollection();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.RefMan.vo.beans.ReferralDetailsForReferralTriageVoBean)vo.getReferralDetails().getBean();
		this.iscab = vo.getIsCAB();
		this.urgency = vo.getUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgency().getBean();
		this.triagedatetime = vo.getTriageDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageDateTime().getBean();
		this.isacceptedoncab = vo.getIsAcceptedOnCAB();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.RefMan.vo.beans.CatsReferralStatusVoBean)vo.getCurrentStatus().getBean();
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.triageoutcome = vo.getTriageOutcome() == null ? null : (ims.RefMan.vo.beans.TriageOutcomeVoBean)vo.getTriageOutcome().getBean();
		this.rejectreferraldetail = vo.getRejectReferralDetail() == null ? null : (ims.RefMan.vo.beans.RejectReferralVoBean)vo.getRejectReferralDetail().getBean();
		this.awaitingclinicalinfo = vo.getAwaitingClinicalInfo() == null ? null : (ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean)vo.getAwaitingClinicalInfo().getBean();
		this.appointments = vo.getAppointments() == null ? null : vo.getAppointments().getBeanCollection();
		this.isawaitingclinicalinfo = vo.getIsAwaitingClinicalInfo();
		this.consultationactivityrequired = vo.getConsultationActivityRequired();
		this.pathwayid = vo.getPathwayID();
		this.rttclockimpact = vo.getRTTClockImpact();
		this.contract = vo.getContract() == null ? null : new ims.vo.RefVoBean(vo.getContract().getBoId(), vo.getContract().getBoVersion());
		this.changecbappointment = vo.getChangeCBAppointment();
		this.redirectcab = vo.getRedirectCAB();
		this.changecabopaanddirecttolist = vo.getChangeCABOPAandDirectToList();
		this.cabopaanddirecttolist = vo.getCABOPAandDirectToList();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.CatsReferralForReferralTriageVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.referraldocuments = vo.getReferralDocuments() == null ? null : vo.getReferralDocuments().getBeanCollection();
		this.referraldetails = vo.getReferralDetails() == null ? null : (ims.RefMan.vo.beans.ReferralDetailsForReferralTriageVoBean)vo.getReferralDetails().getBean(map);
		this.iscab = vo.getIsCAB();
		this.urgency = vo.getUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getUrgency().getBean();
		this.triagedatetime = vo.getTriageDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTriageDateTime().getBean();
		this.isacceptedoncab = vo.getIsAcceptedOnCAB();
		this.currentstatus = vo.getCurrentStatus() == null ? null : (ims.RefMan.vo.beans.CatsReferralStatusVoBean)vo.getCurrentStatus().getBean(map);
		this.statushistory = vo.getStatusHistory() == null ? null : vo.getStatusHistory().getBeanCollection();
		this.triageoutcome = vo.getTriageOutcome() == null ? null : (ims.RefMan.vo.beans.TriageOutcomeVoBean)vo.getTriageOutcome().getBean(map);
		this.rejectreferraldetail = vo.getRejectReferralDetail() == null ? null : (ims.RefMan.vo.beans.RejectReferralVoBean)vo.getRejectReferralDetail().getBean(map);
		this.awaitingclinicalinfo = vo.getAwaitingClinicalInfo() == null ? null : (ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean)vo.getAwaitingClinicalInfo().getBean(map);
		this.appointments = vo.getAppointments() == null ? null : vo.getAppointments().getBeanCollection();
		this.isawaitingclinicalinfo = vo.getIsAwaitingClinicalInfo();
		this.consultationactivityrequired = vo.getConsultationActivityRequired();
		this.pathwayid = vo.getPathwayID();
		this.rttclockimpact = vo.getRTTClockImpact();
		this.contract = vo.getContract() == null ? null : new ims.vo.RefVoBean(vo.getContract().getBoId(), vo.getContract().getBoVersion());
		this.changecbappointment = vo.getChangeCBAppointment();
		this.redirectcab = vo.getRedirectCAB();
		this.changecabopaanddirecttolist = vo.getChangeCABOPAandDirectToList();
		this.cabopaanddirecttolist = vo.getCABOPAandDirectToList();
	}

	public ims.RefMan.vo.CatsReferralForReferralTriageVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.CatsReferralForReferralTriageVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.CatsReferralForReferralTriageVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.CatsReferralForReferralTriageVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.CatsReferralForReferralTriageVo();
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
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.RefMan.vo.beans.PatientDocumentForReferralTriageVoBean[] getReferralDocuments()
	{
		return this.referraldocuments;
	}
	public void setReferralDocuments(ims.RefMan.vo.beans.PatientDocumentForReferralTriageVoBean[] value)
	{
		this.referraldocuments = value;
	}
	public ims.RefMan.vo.beans.ReferralDetailsForReferralTriageVoBean getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.RefMan.vo.beans.ReferralDetailsForReferralTriageVoBean value)
	{
		this.referraldetails = value;
	}
	public Boolean getIsCAB()
	{
		return this.iscab;
	}
	public void setIsCAB(Boolean value)
	{
		this.iscab = value;
	}
	public ims.vo.LookupInstanceBean getUrgency()
	{
		return this.urgency;
	}
	public void setUrgency(ims.vo.LookupInstanceBean value)
	{
		this.urgency = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTriageDateTime()
	{
		return this.triagedatetime;
	}
	public void setTriageDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.triagedatetime = value;
	}
	public Boolean getIsAcceptedOnCAB()
	{
		return this.isacceptedoncab;
	}
	public void setIsAcceptedOnCAB(Boolean value)
	{
		this.isacceptedoncab = value;
	}
	public ims.RefMan.vo.beans.CatsReferralStatusVoBean getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.beans.CatsReferralStatusVoBean value)
	{
		this.currentstatus = value;
	}
	public ims.RefMan.vo.beans.CatsReferralStatusVoBean[] getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.RefMan.vo.beans.CatsReferralStatusVoBean[] value)
	{
		this.statushistory = value;
	}
	public ims.RefMan.vo.beans.TriageOutcomeVoBean getTriageOutcome()
	{
		return this.triageoutcome;
	}
	public void setTriageOutcome(ims.RefMan.vo.beans.TriageOutcomeVoBean value)
	{
		this.triageoutcome = value;
	}
	public ims.RefMan.vo.beans.RejectReferralVoBean getRejectReferralDetail()
	{
		return this.rejectreferraldetail;
	}
	public void setRejectReferralDetail(ims.RefMan.vo.beans.RejectReferralVoBean value)
	{
		this.rejectreferraldetail = value;
	}
	public ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean getAwaitingClinicalInfo()
	{
		return this.awaitingclinicalinfo;
	}
	public void setAwaitingClinicalInfo(ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean value)
	{
		this.awaitingclinicalinfo = value;
	}
	public ims.RefMan.vo.beans.BookAppointmentForReferralTriageVoBean[] getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.RefMan.vo.beans.BookAppointmentForReferralTriageVoBean[] value)
	{
		this.appointments = value;
	}
	public Boolean getIsAwaitingClinicalInfo()
	{
		return this.isawaitingclinicalinfo;
	}
	public void setIsAwaitingClinicalInfo(Boolean value)
	{
		this.isawaitingclinicalinfo = value;
	}
	public Boolean getConsultationActivityRequired()
	{
		return this.consultationactivityrequired;
	}
	public void setConsultationActivityRequired(Boolean value)
	{
		this.consultationactivityrequired = value;
	}
	public String getPathwayID()
	{
		return this.pathwayid;
	}
	public void setPathwayID(String value)
	{
		this.pathwayid = value;
	}
	public Boolean getRTTClockImpact()
	{
		return this.rttclockimpact;
	}
	public void setRTTClockImpact(Boolean value)
	{
		this.rttclockimpact = value;
	}
	public ims.vo.RefVoBean getContract()
	{
		return this.contract;
	}
	public void setContract(ims.vo.RefVoBean value)
	{
		this.contract = value;
	}
	public Boolean getChangeCBAppointment()
	{
		return this.changecbappointment;
	}
	public void setChangeCBAppointment(Boolean value)
	{
		this.changecbappointment = value;
	}
	public Boolean getRedirectCAB()
	{
		return this.redirectcab;
	}
	public void setRedirectCAB(Boolean value)
	{
		this.redirectcab = value;
	}
	public Boolean getChangeCABOPAandDirectToList()
	{
		return this.changecabopaanddirecttolist;
	}
	public void setChangeCABOPAandDirectToList(Boolean value)
	{
		this.changecabopaanddirecttolist = value;
	}
	public Boolean getCABOPAandDirectToList()
	{
		return this.cabopaanddirecttolist;
	}
	public void setCABOPAandDirectToList(Boolean value)
	{
		this.cabopaanddirecttolist = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean patient;
	private ims.RefMan.vo.beans.PatientDocumentForReferralTriageVoBean[] referraldocuments;
	private ims.RefMan.vo.beans.ReferralDetailsForReferralTriageVoBean referraldetails;
	private Boolean iscab;
	private ims.vo.LookupInstanceBean urgency;
	private ims.framework.utils.beans.DateTimeBean triagedatetime;
	private Boolean isacceptedoncab;
	private ims.RefMan.vo.beans.CatsReferralStatusVoBean currentstatus;
	private ims.RefMan.vo.beans.CatsReferralStatusVoBean[] statushistory;
	private ims.RefMan.vo.beans.TriageOutcomeVoBean triageoutcome;
	private ims.RefMan.vo.beans.RejectReferralVoBean rejectreferraldetail;
	private ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean awaitingclinicalinfo;
	private ims.RefMan.vo.beans.BookAppointmentForReferralTriageVoBean[] appointments;
	private Boolean isawaitingclinicalinfo;
	private Boolean consultationactivityrequired;
	private String pathwayid;
	private Boolean rttclockimpact;
	private ims.vo.RefVoBean contract;
	private Boolean changecbappointment;
	private Boolean redirectcab;
	private Boolean changecabopaanddirecttolist;
	private Boolean cabopaanddirecttolist;
}
