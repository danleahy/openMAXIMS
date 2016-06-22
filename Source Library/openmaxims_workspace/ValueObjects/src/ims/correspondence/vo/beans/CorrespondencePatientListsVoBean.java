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

package ims.correspondence.vo.beans;

public class CorrespondencePatientListsVoBean extends ims.vo.ValueObjectBean
{
	public CorrespondencePatientListsVoBean()
	{
	}
	public CorrespondencePatientListsVoBean(ims.correspondence.vo.CorrespondencePatientListsVo vo)
	{
		this.inpatientepisodevo = vo.getInpatientEpisodeVo() == null ? null : (ims.core.vo.beans.InpatientEpisodeVoBean)vo.getInpatientEpisodeVo().getBean();
		this.paseventvo = vo.getPASEventVo() == null ? null : (ims.core.vo.beans.PasEventShortVoBean)vo.getPASEventVo().getBean();
		this.correspondencedetailsvo = vo.getCorrespondenceDetailsVo() == null ? null : (ims.correspondence.vo.beans.CorrespondenceDetailsVoBean)vo.getCorrespondenceDetailsVo().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPatient().getBean();
		this.dischargeepisodevo = vo.getDischargeEpisodeVo() == null ? null : (ims.core.vo.beans.DischargedEpisodeVoBean)vo.getDischargeEpisodeVo().getBean();
		this.outpatientattendancevo = vo.getOutpatientAttendanceVo() == null ? null : (ims.core.vo.beans.OutPatientAttendanceVoBean)vo.getOutpatientAttendanceVo().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.CorrespondencePatientListsVo vo)
	{
		this.inpatientepisodevo = vo.getInpatientEpisodeVo() == null ? null : (ims.core.vo.beans.InpatientEpisodeVoBean)vo.getInpatientEpisodeVo().getBean(map);
		this.paseventvo = vo.getPASEventVo() == null ? null : (ims.core.vo.beans.PasEventShortVoBean)vo.getPASEventVo().getBean(map);
		this.correspondencedetailsvo = vo.getCorrespondenceDetailsVo() == null ? null : (ims.correspondence.vo.beans.CorrespondenceDetailsVoBean)vo.getCorrespondenceDetailsVo().getBean(map);
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPatient().getBean(map);
		this.dischargeepisodevo = vo.getDischargeEpisodeVo() == null ? null : (ims.core.vo.beans.DischargedEpisodeVoBean)vo.getDischargeEpisodeVo().getBean(map);
		this.outpatientattendancevo = vo.getOutpatientAttendanceVo() == null ? null : (ims.core.vo.beans.OutPatientAttendanceVoBean)vo.getOutpatientAttendanceVo().getBean(map);
	}

	public ims.correspondence.vo.CorrespondencePatientListsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.CorrespondencePatientListsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.CorrespondencePatientListsVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.CorrespondencePatientListsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.CorrespondencePatientListsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.InpatientEpisodeVoBean getInpatientEpisodeVo()
	{
		return this.inpatientepisodevo;
	}
	public void setInpatientEpisodeVo(ims.core.vo.beans.InpatientEpisodeVoBean value)
	{
		this.inpatientepisodevo = value;
	}
	public ims.core.vo.beans.PasEventShortVoBean getPASEventVo()
	{
		return this.paseventvo;
	}
	public void setPASEventVo(ims.core.vo.beans.PasEventShortVoBean value)
	{
		this.paseventvo = value;
	}
	public ims.correspondence.vo.beans.CorrespondenceDetailsVoBean getCorrespondenceDetailsVo()
	{
		return this.correspondencedetailsvo;
	}
	public void setCorrespondenceDetailsVo(ims.correspondence.vo.beans.CorrespondenceDetailsVoBean value)
	{
		this.correspondencedetailsvo = value;
	}
	public ims.core.vo.beans.PatientBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.DischargedEpisodeVoBean getDischargeEpisodeVo()
	{
		return this.dischargeepisodevo;
	}
	public void setDischargeEpisodeVo(ims.core.vo.beans.DischargedEpisodeVoBean value)
	{
		this.dischargeepisodevo = value;
	}
	public ims.core.vo.beans.OutPatientAttendanceVoBean getOutpatientAttendanceVo()
	{
		return this.outpatientattendancevo;
	}
	public void setOutpatientAttendanceVo(ims.core.vo.beans.OutPatientAttendanceVoBean value)
	{
		this.outpatientattendancevo = value;
	}

	private ims.core.vo.beans.InpatientEpisodeVoBean inpatientepisodevo;
	private ims.core.vo.beans.PasEventShortVoBean paseventvo;
	private ims.correspondence.vo.beans.CorrespondenceDetailsVoBean correspondencedetailsvo;
	private ims.core.vo.beans.PatientBean patient;
	private ims.core.vo.beans.DischargedEpisodeVoBean dischargeepisodevo;
	private ims.core.vo.beans.OutPatientAttendanceVoBean outpatientattendancevo;
}
