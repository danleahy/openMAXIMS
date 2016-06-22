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

public class AdmissionDetailForADTUpdateAdmissionVoBean extends ims.vo.ValueObjectBean
{
	public AdmissionDetailForADTUpdateAdmissionVoBean()
	{
	}
	public AdmissionDetailForADTUpdateAdmissionVoBean(ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo vo)
	{
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
		this.patientcategory = vo.getPatientCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientCategory().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.requireschaplain = vo.getRequiresChaplain();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo vo)
	{
		this.sourceofemergencyreferral = vo.getSourceOfEmergencyReferral() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfEmergencyReferral().getBean();
		this.patientcategory = vo.getPatientCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientCategory().getBean();
		this.admissiondatetime = vo.getAdmissionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAdmissionDateTime().getBean();
		this.requireschaplain = vo.getRequiresChaplain();
	}

	public ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo vo = null;
		if(map != null)
			vo = (ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.AdmissionDetailForADTUpdateAdmissionVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getSourceOfEmergencyReferral()
	{
		return this.sourceofemergencyreferral;
	}
	public void setSourceOfEmergencyReferral(ims.vo.LookupInstanceBean value)
	{
		this.sourceofemergencyreferral = value;
	}
	public ims.vo.LookupInstanceBean getPatientCategory()
	{
		return this.patientcategory;
	}
	public void setPatientCategory(ims.vo.LookupInstanceBean value)
	{
		this.patientcategory = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.admissiondatetime = value;
	}
	public Boolean getRequiresChaplain()
	{
		return this.requireschaplain;
	}
	public void setRequiresChaplain(Boolean value)
	{
		this.requireschaplain = value;
	}

	private ims.vo.LookupInstanceBean sourceofemergencyreferral;
	private ims.vo.LookupInstanceBean patientcategory;
	private ims.framework.utils.beans.DateTimeBean admissiondatetime;
	private Boolean requireschaplain;
}
