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

public class InpatientEpisodeForWardPatientListVoBean extends ims.vo.ValueObjectBean
{
	public InpatientEpisodeForWardPatientListVoBean()
	{
	}
	public InpatientEpisodeForWardPatientListVoBean(ims.core.vo.InpatientEpisodeForWardPatientListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstDischargeDate().getBean();
		this.isconfirmeddischarge = vo.getIsConfirmedDischarge();
		this.confirmeddischargedatetime = vo.getConfirmedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDischargeDateTime().getBean();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.nursing.vo.beans.PasEventForClinicalAdmissionVoBean)vo.getPasEvent().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.isonhomeleave = vo.getIsOnHomeLeave();
		this.currenttrackingmovement = vo.getCurrentTrackingMovement() == null ? null : (ims.core.vo.beans.TrackingMovementLiteVoBean)vo.getCurrentTrackingMovement().getBean();
		this.isreadytoleave = vo.getIsReadyToLeave();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.InpatientEpisodeForWardPatientListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.estdischargedate = vo.getEstDischargeDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEstDischargeDate().getBean();
		this.isconfirmeddischarge = vo.getIsConfirmedDischarge();
		this.confirmeddischargedatetime = vo.getConfirmedDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDischargeDateTime().getBean();
		this.pasevent = vo.getPasEvent() == null ? null : (ims.nursing.vo.beans.PasEventForClinicalAdmissionVoBean)vo.getPasEvent().getBean(map);
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.isonhomeleave = vo.getIsOnHomeLeave();
		this.currenttrackingmovement = vo.getCurrentTrackingMovement() == null ? null : (ims.core.vo.beans.TrackingMovementLiteVoBean)vo.getCurrentTrackingMovement().getBean(map);
		this.isreadytoleave = vo.getIsReadyToLeave();
	}

	public ims.core.vo.InpatientEpisodeForWardPatientListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.InpatientEpisodeForWardPatientListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.InpatientEpisodeForWardPatientListVo vo = null;
		if(map != null)
			vo = (ims.core.vo.InpatientEpisodeForWardPatientListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.InpatientEpisodeForWardPatientListVo();
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
	public ims.framework.utils.beans.DateTimeBean getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.estdischargedate = value;
	}
	public Boolean getIsConfirmedDischarge()
	{
		return this.isconfirmeddischarge;
	}
	public void setIsConfirmedDischarge(Boolean value)
	{
		this.isconfirmeddischarge = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConfirmedDischargeDateTime()
	{
		return this.confirmeddischargedatetime;
	}
	public void setConfirmedDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.confirmeddischargedatetime = value;
	}
	public ims.nursing.vo.beans.PasEventForClinicalAdmissionVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.nursing.vo.beans.PasEventForClinicalAdmissionVoBean value)
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
	public Boolean getIsOnHomeLeave()
	{
		return this.isonhomeleave;
	}
	public void setIsOnHomeLeave(Boolean value)
	{
		this.isonhomeleave = value;
	}
	public ims.core.vo.beans.TrackingMovementLiteVoBean getCurrentTrackingMovement()
	{
		return this.currenttrackingmovement;
	}
	public void setCurrentTrackingMovement(ims.core.vo.beans.TrackingMovementLiteVoBean value)
	{
		this.currenttrackingmovement = value;
	}
	public Boolean getIsReadyToLeave()
	{
		return this.isreadytoleave;
	}
	public void setIsReadyToLeave(Boolean value)
	{
		this.isreadytoleave = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean estdischargedate;
	private Boolean isconfirmeddischarge;
	private ims.framework.utils.beans.DateTimeBean confirmeddischargedatetime;
	private ims.nursing.vo.beans.PasEventForClinicalAdmissionVoBean pasevent;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private Boolean isonhomeleave;
	private ims.core.vo.beans.TrackingMovementLiteVoBean currenttrackingmovement;
	private Boolean isreadytoleave;
}
