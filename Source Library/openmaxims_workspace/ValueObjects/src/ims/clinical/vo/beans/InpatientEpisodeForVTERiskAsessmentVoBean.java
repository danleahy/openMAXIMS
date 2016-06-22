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

package ims.clinical.vo.beans;

public class InpatientEpisodeForVTERiskAsessmentVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeForVTERiskAsessmentVoBean()
	{
	}
	public InpatientEpisodeForVTERiskAsessmentVoBean(ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
		this.vteassessmentstatusreason = vo.getVTEAssessmentStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatusReason().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstDischargeDate().getBean();
		this.confirmeddischargedatetime = vo.getConfirmedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDischargeDateTime().getBean();
		this.isonhomeleave = vo.getIsOnHomeLeave();
		this.dateonhomeleave = vo.getDateOnHomeLeave() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnHomeLeave().getBean();
		this.timeonhomeleave = vo.getTimeOnHomeLeave() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOnHomeLeave().getBean();
		this.expecteddateofreturn = vo.getExpectedDateOfReturn() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpectedDateOfReturn().getBean();
		this.expectedtimeofreturn = vo.getExpectedTimeOfReturn() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getExpectedTimeOfReturn().getBean();
		this.latestsecsscore = vo.getLatestSECSScore() == null ? null : (ims.clinical.vo.beans.PatientSECSLiteVoBean)vo.getLatestSECSScore().getBean();
		this.isconfirmeddischarge = vo.getIsConfirmedDischarge();
		this.currenttrackingmovement = vo.getCurrentTrackingMovement() == null ? null : (ims.core.vo.beans.TrackingMovementVoBean)vo.getCurrentTrackingMovement().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.vteassessmentstatus = vo.getVTEAssessmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatus().getBean();
		this.vteriskassessment = vo.getVTERiskAssessment() == null ? null : new ims.vo.RefVoBean(vo.getVTERiskAssessment().getBoId(), vo.getVTERiskAssessment().getBoVersion());
		this.vteassessmentstatusreason = vo.getVTEAssessmentStatusReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getVTEAssessmentStatusReason().getBean();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstDischargeDate().getBean();
		this.confirmeddischargedatetime = vo.getConfirmedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDischargeDateTime().getBean();
		this.isonhomeleave = vo.getIsOnHomeLeave();
		this.dateonhomeleave = vo.getDateOnHomeLeave() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOnHomeLeave().getBean();
		this.timeonhomeleave = vo.getTimeOnHomeLeave() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOnHomeLeave().getBean();
		this.expecteddateofreturn = vo.getExpectedDateOfReturn() == null ? null : (ims.framework.utils.beans.DateBean)vo.getExpectedDateOfReturn().getBean();
		this.expectedtimeofreturn = vo.getExpectedTimeOfReturn() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getExpectedTimeOfReturn().getBean();
		this.latestsecsscore = vo.getLatestSECSScore() == null ? null : (ims.clinical.vo.beans.PatientSECSLiteVoBean)vo.getLatestSECSScore().getBean(map);
		this.isconfirmeddischarge = vo.getIsConfirmedDischarge();
		this.currenttrackingmovement = vo.getCurrentTrackingMovement() == null ? null : (ims.core.vo.beans.TrackingMovementVoBean)vo.getCurrentTrackingMovement().getBean(map);
	}

	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo();
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
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public ims.vo.LookupInstanceBean getVTEAssessmentStatus()
	{
		return this.vteassessmentstatus;
	}
	public void setVTEAssessmentStatus(ims.vo.LookupInstanceBean value)
	{
		this.vteassessmentstatus = value;
	}
	public ims.vo.RefVoBean getVTERiskAssessment()
	{
		return this.vteriskassessment;
	}
	public void setVTERiskAssessment(ims.vo.RefVoBean value)
	{
		this.vteriskassessment = value;
	}
	public ims.vo.LookupInstanceBean getVTEAssessmentStatusReason()
	{
		return this.vteassessmentstatusreason;
	}
	public void setVTEAssessmentStatusReason(ims.vo.LookupInstanceBean value)
	{
		this.vteassessmentstatusreason = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.estdischargedate = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConfirmedDischargeDateTime()
	{
		return this.confirmeddischargedatetime;
	}
	public void setConfirmedDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.confirmeddischargedatetime = value;
	}
	public Boolean getIsOnHomeLeave()
	{
		return this.isonhomeleave;
	}
	public void setIsOnHomeLeave(Boolean value)
	{
		this.isonhomeleave = value;
	}
	public ims.framework.utils.beans.DateBean getDateOnHomeLeave()
	{
		return this.dateonhomeleave;
	}
	public void setDateOnHomeLeave(ims.framework.utils.beans.DateBean value)
	{
		this.dateonhomeleave = value;
	}
	public ims.framework.utils.beans.TimeBean getTimeOnHomeLeave()
	{
		return this.timeonhomeleave;
	}
	public void setTimeOnHomeLeave(ims.framework.utils.beans.TimeBean value)
	{
		this.timeonhomeleave = value;
	}
	public ims.framework.utils.beans.DateBean getExpectedDateOfReturn()
	{
		return this.expecteddateofreturn;
	}
	public void setExpectedDateOfReturn(ims.framework.utils.beans.DateBean value)
	{
		this.expecteddateofreturn = value;
	}
	public ims.framework.utils.beans.TimeBean getExpectedTimeOfReturn()
	{
		return this.expectedtimeofreturn;
	}
	public void setExpectedTimeOfReturn(ims.framework.utils.beans.TimeBean value)
	{
		this.expectedtimeofreturn = value;
	}
	public ims.clinical.vo.beans.PatientSECSLiteVoBean getLatestSECSScore()
	{
		return this.latestsecsscore;
	}
	public void setLatestSECSScore(ims.clinical.vo.beans.PatientSECSLiteVoBean value)
	{
		this.latestsecsscore = value;
	}
	public Boolean getIsConfirmedDischarge()
	{
		return this.isconfirmeddischarge;
	}
	public void setIsConfirmedDischarge(Boolean value)
	{
		this.isconfirmeddischarge = value;
	}
	public ims.core.vo.beans.TrackingMovementVoBean getCurrentTrackingMovement()
	{
		return this.currenttrackingmovement;
	}
	public void setCurrentTrackingMovement(ims.core.vo.beans.TrackingMovementVoBean value)
	{
		this.currenttrackingmovement = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private ims.vo.LookupInstanceBean vteassessmentstatus;
	private ims.vo.RefVoBean vteriskassessment;
	private ims.vo.LookupInstanceBean vteassessmentstatusreason;
	private ims.framework.utils.beans.DateTimeBean estdischargedate;
	private ims.framework.utils.beans.DateTimeBean confirmeddischargedatetime;
	private Boolean isonhomeleave;
	private ims.framework.utils.beans.DateBean dateonhomeleave;
	private ims.framework.utils.beans.TimeBean timeonhomeleave;
	private ims.framework.utils.beans.DateBean expecteddateofreturn;
	private ims.framework.utils.beans.TimeBean expectedtimeofreturn;
	private ims.clinical.vo.beans.PatientSECSLiteVoBean latestsecsscore;
	private Boolean isconfirmeddischarge;
	private ims.core.vo.beans.TrackingMovementVoBean currenttrackingmovement;
}
