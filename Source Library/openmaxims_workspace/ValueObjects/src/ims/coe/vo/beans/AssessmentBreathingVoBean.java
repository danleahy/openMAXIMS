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

package ims.coe.vo.beans;

public class AssessmentBreathingVoBean extends ims.vo.ValueObjectBean
{
	public AssessmentBreathingVoBean()
	{
	}
	public AssessmentBreathingVoBean(ims.coe.vo.AssessmentBreathingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean();
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.difficultybreathing = vo.getDifficultyBreathing() == null ? null : (ims.vo.LookupInstanceBean)vo.getDifficultyBreathing().getBean();
		this.breathingdyspnoea = vo.getBreathingDyspnoea() == null ? null : vo.getBreathingDyspnoea().getBeanCollection();
		this.acutechronic = vo.getAcuteChronic() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcuteChronic().getBean();
		this.smoking = vo.getSmoking() == null ? null : (ims.core.vo.beans.SmokingBean)vo.getSmoking().getBean();
		this.breathingmedication = vo.getBreathingMedication() == null ? null : vo.getBreathingMedication().getBeanCollection();
		this.breathingcough = vo.getBreathingCough() == null ? null : (ims.coe.vo.beans.AssessmentBreathingCoughVoBean)vo.getBreathingCough().getBean();
		this.breathingtreatment = vo.getBreathingTreatment() == null ? null : vo.getBreathingTreatment().getBeanCollection();
		this.ventilationtracheostomy = vo.getVentilationTracheostomy() == null ? null : (ims.core.vo.beans.VentilationTracheostomyVoBean)vo.getVentilationTracheostomy().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.AssessmentBreathingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.iscomplete = vo.getIsComplete();
		this.assessmentinfo = vo.getAssessmentInfo() == null ? null : vo.getAssessmentInfo().getBeanCollection();
		this.copy = vo.getCopy();
		this.componenttype = vo.getComponentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getComponentType().getBean();
		this.lastassessmentinfo = vo.getLastAssessmentInfo() == null ? null : (ims.nursing.vo.beans.AssessmentInfoBean)vo.getLastAssessmentInfo().getBean(map);
		this.careplantemplate = vo.getCarePlanTemplate() == null ? null : vo.getCarePlanTemplate().getBeanCollection();
		this.careplans = vo.getCarePlans() == null ? null : vo.getCarePlans().getBeanCollection();
		this.difficultybreathing = vo.getDifficultyBreathing() == null ? null : (ims.vo.LookupInstanceBean)vo.getDifficultyBreathing().getBean();
		this.breathingdyspnoea = vo.getBreathingDyspnoea() == null ? null : vo.getBreathingDyspnoea().getBeanCollection();
		this.acutechronic = vo.getAcuteChronic() == null ? null : (ims.vo.LookupInstanceBean)vo.getAcuteChronic().getBean();
		this.smoking = vo.getSmoking() == null ? null : (ims.core.vo.beans.SmokingBean)vo.getSmoking().getBean(map);
		this.breathingmedication = vo.getBreathingMedication() == null ? null : vo.getBreathingMedication().getBeanCollection();
		this.breathingcough = vo.getBreathingCough() == null ? null : (ims.coe.vo.beans.AssessmentBreathingCoughVoBean)vo.getBreathingCough().getBean(map);
		this.breathingtreatment = vo.getBreathingTreatment() == null ? null : vo.getBreathingTreatment().getBeanCollection();
		this.ventilationtracheostomy = vo.getVentilationTracheostomy() == null ? null : (ims.core.vo.beans.VentilationTracheostomyVoBean)vo.getVentilationTracheostomy().getBean(map);
	}

	public ims.coe.vo.AssessmentBreathingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.coe.vo.AssessmentBreathingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.AssessmentBreathingVo vo = null;
		if(map != null)
			vo = (ims.coe.vo.AssessmentBreathingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.coe.vo.AssessmentBreathingVo();
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
	public Boolean getIsComplete()
	{
		return this.iscomplete;
	}
	public void setIsComplete(Boolean value)
	{
		this.iscomplete = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean[] getAssessmentInfo()
	{
		return this.assessmentinfo;
	}
	public void setAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean[] value)
	{
		this.assessmentinfo = value;
	}
	public Boolean getCopy()
	{
		return this.copy;
	}
	public void setCopy(Boolean value)
	{
		this.copy = value;
	}
	public ims.vo.LookupInstanceBean getComponentType()
	{
		return this.componenttype;
	}
	public void setComponentType(ims.vo.LookupInstanceBean value)
	{
		this.componenttype = value;
	}
	public ims.nursing.vo.beans.AssessmentInfoBean getLastAssessmentInfo()
	{
		return this.lastassessmentinfo;
	}
	public void setLastAssessmentInfo(ims.nursing.vo.beans.AssessmentInfoBean value)
	{
		this.lastassessmentinfo = value;
	}
	public ims.nursing.vo.beans.CarePlanTemplateBean[] getCarePlanTemplate()
	{
		return this.careplantemplate;
	}
	public void setCarePlanTemplate(ims.nursing.vo.beans.CarePlanTemplateBean[] value)
	{
		this.careplantemplate = value;
	}
	public ims.nursing.vo.beans.CarePlanBean[] getCarePlans()
	{
		return this.careplans;
	}
	public void setCarePlans(ims.nursing.vo.beans.CarePlanBean[] value)
	{
		this.careplans = value;
	}
	public ims.vo.LookupInstanceBean getDifficultyBreathing()
	{
		return this.difficultybreathing;
	}
	public void setDifficultyBreathing(ims.vo.LookupInstanceBean value)
	{
		this.difficultybreathing = value;
	}
	public java.util.Collection getBreathingDyspnoea()
	{
		return this.breathingdyspnoea;
	}
	public void setBreathingDyspnoea(java.util.Collection value)
	{
		this.breathingdyspnoea = value;
	}
	public void addBreathingDyspnoea(java.util.Collection value)
	{
		if(this.breathingdyspnoea == null)
			this.breathingdyspnoea = new java.util.ArrayList();
		this.breathingdyspnoea.add(value);
	}
	public ims.vo.LookupInstanceBean getAcuteChronic()
	{
		return this.acutechronic;
	}
	public void setAcuteChronic(ims.vo.LookupInstanceBean value)
	{
		this.acutechronic = value;
	}
	public ims.core.vo.beans.SmokingBean getSmoking()
	{
		return this.smoking;
	}
	public void setSmoking(ims.core.vo.beans.SmokingBean value)
	{
		this.smoking = value;
	}
	public ims.core.vo.beans.PatientMedicationVoBean[] getBreathingMedication()
	{
		return this.breathingmedication;
	}
	public void setBreathingMedication(ims.core.vo.beans.PatientMedicationVoBean[] value)
	{
		this.breathingmedication = value;
	}
	public ims.coe.vo.beans.AssessmentBreathingCoughVoBean getBreathingCough()
	{
		return this.breathingcough;
	}
	public void setBreathingCough(ims.coe.vo.beans.AssessmentBreathingCoughVoBean value)
	{
		this.breathingcough = value;
	}
	public java.util.Collection getBreathingTreatment()
	{
		return this.breathingtreatment;
	}
	public void setBreathingTreatment(java.util.Collection value)
	{
		this.breathingtreatment = value;
	}
	public void addBreathingTreatment(java.util.Collection value)
	{
		if(this.breathingtreatment == null)
			this.breathingtreatment = new java.util.ArrayList();
		this.breathingtreatment.add(value);
	}
	public ims.core.vo.beans.VentilationTracheostomyVoBean getVentilationTracheostomy()
	{
		return this.ventilationtracheostomy;
	}
	public void setVentilationTracheostomy(ims.core.vo.beans.VentilationTracheostomyVoBean value)
	{
		this.ventilationtracheostomy = value;
	}

	private Integer id;
	private int version;
	private Boolean iscomplete;
	private ims.nursing.vo.beans.AssessmentInfoBean[] assessmentinfo;
	private Boolean copy;
	private ims.vo.LookupInstanceBean componenttype;
	private ims.nursing.vo.beans.AssessmentInfoBean lastassessmentinfo;
	private ims.nursing.vo.beans.CarePlanTemplateBean[] careplantemplate;
	private ims.nursing.vo.beans.CarePlanBean[] careplans;
	private ims.vo.LookupInstanceBean difficultybreathing;
	private java.util.Collection breathingdyspnoea;
	private ims.vo.LookupInstanceBean acutechronic;
	private ims.core.vo.beans.SmokingBean smoking;
	private ims.core.vo.beans.PatientMedicationVoBean[] breathingmedication;
	private ims.coe.vo.beans.AssessmentBreathingCoughVoBean breathingcough;
	private java.util.Collection breathingtreatment;
	private ims.core.vo.beans.VentilationTracheostomyVoBean ventilationtracheostomy;
}
