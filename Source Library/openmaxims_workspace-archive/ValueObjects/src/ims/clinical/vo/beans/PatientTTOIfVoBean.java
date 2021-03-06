//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo.beans;

public class PatientTTOIfVoBean extends ims.vo.ValueObjectBean
{
	public PatientTTOIfVoBean()
	{
	}
	public PatientTTOIfVoBean(ims.clinical.vo.PatientTTOIfVo vo)
	{
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.ttos = vo.getTTOs() == null ? null : vo.getTTOs().getBeanCollection();
		this.medicationchanges = vo.getMedicationChanges() == null ? null : vo.getMedicationChanges().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PatientTTOIfVo vo)
	{
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.ttos = vo.getTTOs() == null ? null : vo.getTTOs().getBeanCollection();
		this.medicationchanges = vo.getMedicationChanges() == null ? null : vo.getMedicationChanges().getBeanCollection();
	}

	public ims.clinical.vo.PatientTTOIfVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PatientTTOIfVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PatientTTOIfVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PatientTTOIfVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PatientTTOIfVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.clinical.vo.beans.TTODetailsIFVoBean[] getTTOs()
	{
		return this.ttos;
	}
	public void setTTOs(ims.clinical.vo.beans.TTODetailsIFVoBean[] value)
	{
		this.ttos = value;
	}
	public ims.clinical.vo.beans.AdmissionMedicationChangesVoBean[] getMedicationChanges()
	{
		return this.medicationchanges;
	}
	public void setMedicationChanges(ims.clinical.vo.beans.AdmissionMedicationChangesVoBean[] value)
	{
		this.medicationchanges = value;
	}

	private ims.vo.RefVoBean patient;
	private ims.clinical.vo.beans.TTODetailsIFVoBean[] ttos;
	private ims.clinical.vo.beans.AdmissionMedicationChangesVoBean[] medicationchanges;
}
