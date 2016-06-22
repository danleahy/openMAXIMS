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

public class RadiotherapyDetailsVoBean extends ims.vo.ValueObjectBean
{
	public RadiotherapyDetailsVoBean()
	{
	}
	public RadiotherapyDetailsVoBean(ims.oncology.vo.RadiotherapyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.radiotherapytype = vo.getRadiotherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRadiotherapyType().getBean();
		// Interface field type not supported.
		this.treatementintent = vo.getTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatementIntent().getBean();
		this.anatomicaltreatmentsite = vo.getAnatomicalTreatmentSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnatomicalTreatmentSite().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.prescribeddose = vo.getPrescribedDose();
		this.prescribedfractions = vo.getPrescribedFractions();
		this.prescribedduration = vo.getPrescribedDuration();
		this.teletherapydetails = vo.getTeletherapyDetails() == null ? null : (ims.oncology.vo.beans.TeletherapyDetailsVoBean)vo.getTeletherapyDetails().getBean();
		this.brachytherapydetails = vo.getBrachytherapyDetails() == null ? null : (ims.oncology.vo.beans.BrachytherapyDetailsVoBean)vo.getBrachytherapyDetails().getBean();
		this.treatmentcoursestatus = vo.getTreatmentCourseStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentCourseStatus().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.treatinghospital = vo.getTreatingHospital() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatingHospital().getBean();
		this.performancestatusatddt = vo.getPerformanceStatusAtDDT() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerformanceStatusAtDDT().getBean();
		this.concurrentchemotherapy = vo.getConcurrentChemotherapy() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcurrentChemotherapy().getBean();
		this.treatmentcategory = vo.getTreatmentCategory();
		this.diseasestatus = vo.getDiseaseStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiseaseStatus().getBean();
		this.diseasetreatment = vo.getDiseaseTreatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiseaseTreatment().getBean();
		this.reasondelay1 = vo.getReasonDelay1() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonDelay1().getBean();
		this.reasondelay2 = vo.getReasonDelay2() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonDelay2().getBean();
		this.prescribinghcp = vo.getPrescribingHCP() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getPrescribingHCP().getBean();
		this.prescribeddate = vo.getPrescribedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPrescribedDate().getBean();
		this.associatedtreatmentplanaction = vo.getAssociatedTreatmentPlanAction() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedTreatmentPlanAction().getBoId(), vo.getAssociatedTreatmentPlanAction().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.RadiotherapyDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.radiotherapytype = vo.getRadiotherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRadiotherapyType().getBean();
		// Interface field type not supported.
		this.treatementintent = vo.getTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatementIntent().getBean();
		this.anatomicaltreatmentsite = vo.getAnatomicalTreatmentSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnatomicalTreatmentSite().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.prescribeddose = vo.getPrescribedDose();
		this.prescribedfractions = vo.getPrescribedFractions();
		this.prescribedduration = vo.getPrescribedDuration();
		this.teletherapydetails = vo.getTeletherapyDetails() == null ? null : (ims.oncology.vo.beans.TeletherapyDetailsVoBean)vo.getTeletherapyDetails().getBean(map);
		this.brachytherapydetails = vo.getBrachytherapyDetails() == null ? null : (ims.oncology.vo.beans.BrachytherapyDetailsVoBean)vo.getBrachytherapyDetails().getBean(map);
		this.treatmentcoursestatus = vo.getTreatmentCourseStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentCourseStatus().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.treatinghospital = vo.getTreatingHospital() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatingHospital().getBean();
		this.performancestatusatddt = vo.getPerformanceStatusAtDDT() == null ? null : (ims.vo.LookupInstanceBean)vo.getPerformanceStatusAtDDT().getBean();
		this.concurrentchemotherapy = vo.getConcurrentChemotherapy() == null ? null : (ims.vo.LookupInstanceBean)vo.getConcurrentChemotherapy().getBean();
		this.treatmentcategory = vo.getTreatmentCategory();
		this.diseasestatus = vo.getDiseaseStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiseaseStatus().getBean();
		this.diseasetreatment = vo.getDiseaseTreatment() == null ? null : (ims.vo.LookupInstanceBean)vo.getDiseaseTreatment().getBean();
		this.reasondelay1 = vo.getReasonDelay1() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonDelay1().getBean();
		this.reasondelay2 = vo.getReasonDelay2() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonDelay2().getBean();
		this.prescribinghcp = vo.getPrescribingHCP() == null ? null : (ims.core.vo.beans.MedicVoBean)vo.getPrescribingHCP().getBean(map);
		this.prescribeddate = vo.getPrescribedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getPrescribedDate().getBean();
		this.associatedtreatmentplanaction = vo.getAssociatedTreatmentPlanAction() == null ? null : new ims.vo.RefVoBean(vo.getAssociatedTreatmentPlanAction().getBoId(), vo.getAssociatedTreatmentPlanAction().getBoVersion());
	}

	public ims.oncology.vo.RadiotherapyDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.RadiotherapyDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.RadiotherapyDetailsVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.RadiotherapyDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.RadiotherapyDetailsVo();
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
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.LookupInstanceBean getRadiotherapyType()
	{
		return this.radiotherapytype;
	}
	public void setRadiotherapyType(ims.vo.LookupInstanceBean value)
	{
		this.radiotherapytype = value;
	}
	public ims.vo.LookupInstanceBean getTreatementIntent()
	{
		return this.treatementintent;
	}
	public void setTreatementIntent(ims.vo.LookupInstanceBean value)
	{
		this.treatementintent = value;
	}
	public ims.vo.LookupInstanceBean getAnatomicalTreatmentSite()
	{
		return this.anatomicaltreatmentsite;
	}
	public void setAnatomicalTreatmentSite(ims.vo.LookupInstanceBean value)
	{
		this.anatomicaltreatmentsite = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public Float getPrescribedDose()
	{
		return this.prescribeddose;
	}
	public void setPrescribedDose(Float value)
	{
		this.prescribeddose = value;
	}
	public Integer getPrescribedFractions()
	{
		return this.prescribedfractions;
	}
	public void setPrescribedFractions(Integer value)
	{
		this.prescribedfractions = value;
	}
	public Integer getPrescribedDuration()
	{
		return this.prescribedduration;
	}
	public void setPrescribedDuration(Integer value)
	{
		this.prescribedduration = value;
	}
	public ims.oncology.vo.beans.TeletherapyDetailsVoBean getTeletherapyDetails()
	{
		return this.teletherapydetails;
	}
	public void setTeletherapyDetails(ims.oncology.vo.beans.TeletherapyDetailsVoBean value)
	{
		this.teletherapydetails = value;
	}
	public ims.oncology.vo.beans.BrachytherapyDetailsVoBean getBrachytherapyDetails()
	{
		return this.brachytherapydetails;
	}
	public void setBrachytherapyDetails(ims.oncology.vo.beans.BrachytherapyDetailsVoBean value)
	{
		this.brachytherapydetails = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentCourseStatus()
	{
		return this.treatmentcoursestatus;
	}
	public void setTreatmentCourseStatus(ims.vo.LookupInstanceBean value)
	{
		this.treatmentcoursestatus = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.vo.LookupInstanceBean getTreatingHospital()
	{
		return this.treatinghospital;
	}
	public void setTreatingHospital(ims.vo.LookupInstanceBean value)
	{
		this.treatinghospital = value;
	}
	public ims.vo.LookupInstanceBean getPerformanceStatusAtDDT()
	{
		return this.performancestatusatddt;
	}
	public void setPerformanceStatusAtDDT(ims.vo.LookupInstanceBean value)
	{
		this.performancestatusatddt = value;
	}
	public ims.vo.LookupInstanceBean getConcurrentChemotherapy()
	{
		return this.concurrentchemotherapy;
	}
	public void setConcurrentChemotherapy(ims.vo.LookupInstanceBean value)
	{
		this.concurrentchemotherapy = value;
	}
	public Integer getTreatmentCategory()
	{
		return this.treatmentcategory;
	}
	public void setTreatmentCategory(Integer value)
	{
		this.treatmentcategory = value;
	}
	public ims.vo.LookupInstanceBean getDiseaseStatus()
	{
		return this.diseasestatus;
	}
	public void setDiseaseStatus(ims.vo.LookupInstanceBean value)
	{
		this.diseasestatus = value;
	}
	public ims.vo.LookupInstanceBean getDiseaseTreatment()
	{
		return this.diseasetreatment;
	}
	public void setDiseaseTreatment(ims.vo.LookupInstanceBean value)
	{
		this.diseasetreatment = value;
	}
	public ims.vo.LookupInstanceBean getReasonDelay1()
	{
		return this.reasondelay1;
	}
	public void setReasonDelay1(ims.vo.LookupInstanceBean value)
	{
		this.reasondelay1 = value;
	}
	public ims.vo.LookupInstanceBean getReasonDelay2()
	{
		return this.reasondelay2;
	}
	public void setReasonDelay2(ims.vo.LookupInstanceBean value)
	{
		this.reasondelay2 = value;
	}
	public ims.core.vo.beans.MedicVoBean getPrescribingHCP()
	{
		return this.prescribinghcp;
	}
	public void setPrescribingHCP(ims.core.vo.beans.MedicVoBean value)
	{
		this.prescribinghcp = value;
	}
	public ims.framework.utils.beans.DateBean getPrescribedDate()
	{
		return this.prescribeddate;
	}
	public void setPrescribedDate(ims.framework.utils.beans.DateBean value)
	{
		this.prescribeddate = value;
	}
	public ims.vo.RefVoBean getAssociatedTreatmentPlanAction()
	{
		return this.associatedtreatmentplanaction;
	}
	public void setAssociatedTreatmentPlanAction(ims.vo.RefVoBean value)
	{
		this.associatedtreatmentplanaction = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private ims.vo.LookupInstanceBean radiotherapytype;
	private ims.vo.LookupInstanceBean treatementintent;
	private ims.vo.LookupInstanceBean anatomicaltreatmentsite;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.vo.RefVoBean episodeofcare;
	private ims.framework.utils.beans.DateBean enddate;
	private Float prescribeddose;
	private Integer prescribedfractions;
	private Integer prescribedduration;
	private ims.oncology.vo.beans.TeletherapyDetailsVoBean teletherapydetails;
	private ims.oncology.vo.beans.BrachytherapyDetailsVoBean brachytherapydetails;
	private ims.vo.LookupInstanceBean treatmentcoursestatus;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.LookupInstanceBean treatinghospital;
	private ims.vo.LookupInstanceBean performancestatusatddt;
	private ims.vo.LookupInstanceBean concurrentchemotherapy;
	private Integer treatmentcategory;
	private ims.vo.LookupInstanceBean diseasestatus;
	private ims.vo.LookupInstanceBean diseasetreatment;
	private ims.vo.LookupInstanceBean reasondelay1;
	private ims.vo.LookupInstanceBean reasondelay2;
	private ims.core.vo.beans.MedicVoBean prescribinghcp;
	private ims.framework.utils.beans.DateBean prescribeddate;
	private ims.vo.RefVoBean associatedtreatmentplanaction;
}
