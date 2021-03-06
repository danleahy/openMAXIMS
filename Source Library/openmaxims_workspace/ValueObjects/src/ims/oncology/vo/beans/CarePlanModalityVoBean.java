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

package ims.oncology.vo.beans;

public class CarePlanModalityVoBean extends ims.vo.ValueObjectBean
{
	public CarePlanModalityVoBean()
	{
	}
	public CarePlanModalityVoBean(ims.oncology.vo.CarePlanModalityVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.treatmentmodality = vo.getTreatmentModality() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentModality().getBean();
		this.ismdtmodality = vo.getIsMDTModality();
		this.mdtsequence = vo.getMDTSequence();
		this.patientsequence = vo.getPatientSequence();
		this.modalitystatus = vo.getModalityStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getModalityStatus().getBean();
		this.completeddate = vo.getCompletedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCompletedDate().getBean();
		this.iscommenced = vo.getIsCommenced();
		this.patientagreed = vo.getPatientAgreed() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientAgreed().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.CarePlanModalityVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.treatmentmodality = vo.getTreatmentModality() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentModality().getBean();
		this.ismdtmodality = vo.getIsMDTModality();
		this.mdtsequence = vo.getMDTSequence();
		this.patientsequence = vo.getPatientSequence();
		this.modalitystatus = vo.getModalityStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getModalityStatus().getBean();
		this.completeddate = vo.getCompletedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCompletedDate().getBean();
		this.iscommenced = vo.getIsCommenced();
		this.patientagreed = vo.getPatientAgreed() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientAgreed().getBean();
	}

	public ims.oncology.vo.CarePlanModalityVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.CarePlanModalityVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.CarePlanModalityVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.CarePlanModalityVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.CarePlanModalityVo();
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
	public ims.vo.LookupInstanceBean getTreatmentModality()
	{
		return this.treatmentmodality;
	}
	public void setTreatmentModality(ims.vo.LookupInstanceBean value)
	{
		this.treatmentmodality = value;
	}
	public Boolean getIsMDTModality()
	{
		return this.ismdtmodality;
	}
	public void setIsMDTModality(Boolean value)
	{
		this.ismdtmodality = value;
	}
	public Integer getMDTSequence()
	{
		return this.mdtsequence;
	}
	public void setMDTSequence(Integer value)
	{
		this.mdtsequence = value;
	}
	public Integer getPatientSequence()
	{
		return this.patientsequence;
	}
	public void setPatientSequence(Integer value)
	{
		this.patientsequence = value;
	}
	public ims.vo.LookupInstanceBean getModalityStatus()
	{
		return this.modalitystatus;
	}
	public void setModalityStatus(ims.vo.LookupInstanceBean value)
	{
		this.modalitystatus = value;
	}
	public ims.framework.utils.beans.DateBean getCompletedDate()
	{
		return this.completeddate;
	}
	public void setCompletedDate(ims.framework.utils.beans.DateBean value)
	{
		this.completeddate = value;
	}
	public Boolean getIsCommenced()
	{
		return this.iscommenced;
	}
	public void setIsCommenced(Boolean value)
	{
		this.iscommenced = value;
	}
	public ims.vo.LookupInstanceBean getPatientAgreed()
	{
		return this.patientagreed;
	}
	public void setPatientAgreed(ims.vo.LookupInstanceBean value)
	{
		this.patientagreed = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean treatmentmodality;
	private Boolean ismdtmodality;
	private Integer mdtsequence;
	private Integer patientsequence;
	private ims.vo.LookupInstanceBean modalitystatus;
	private ims.framework.utils.beans.DateBean completeddate;
	private Boolean iscommenced;
	private ims.vo.LookupInstanceBean patientagreed;
}
