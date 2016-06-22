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

public class CDSInpatientVoBean extends ims.vo.ValueObjectBean
{
	public CDSInpatientVoBean()
	{
	}
	public CDSInpatientVoBean(ims.core.vo.CDSInpatientVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ubrn = vo.getUBRN();
		this.pathwayidentifier = vo.getPathwayIdentifier();
		this.pathwayorgcode = vo.getPathwayOrgCode();
		this.referraltotreatmentstatus = vo.getReferralToTreatmentStatus();
		this.rttstartdate = vo.getRTTStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRTTStartDate().getBean();
		this.rttenddate = vo.getRTTEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRTTEndDate().getBean();
		this.leadcareactind = vo.getLeadCareActInd();
		this.localpatientidentifier = vo.getLocalPatientIdentifier();
		this.patidorgcode = vo.getPatIdOrgCode();
		this.nhsnumber = vo.getNHSNumber();
		this.nhsnumberstatusind = vo.getNHSNumberStatusInd();
		this.patientname = vo.getPatientName();
		this.patientaddress = vo.getPatientAddress();
		this.postcode = vo.getPostCode();
		this.pctorgcode = vo.getPCTOrgCode();
		this.dateofbirth = vo.getDateOfBirth() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfBirth().getBean();
		this.persongender = vo.getPersonGender();
		this.carersupportind = vo.getCarerSupportInd();
		this.ethniccategory = vo.getEthnicCategory();
		this.providerspellno = vo.getProviderSpellNo();
		this.admincategoryadt = vo.getAdminCategoryADT();
		this.patientclassification = vo.getPatientClassification();
		this.admissionmethod = vo.getAdmissionMethod();
		this.sourceofadmission = vo.getSourceOfAdmission();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.age = vo.getAge();
		this.dischargedestination = vo.getDischargeDestination();
		this.dischargemethod = vo.getDischargeMethod();
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.dischargedate = vo.getDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDate().getBean();
		this.episodenumber = vo.getEpisodeNumber();
		this.lastepisodeind = vo.getLastEpisodeInd();
		this.admincategoryepis = vo.getAdminCategoryEPIS();
		this.operationstatus = vo.getOperationStatus();
		this.neonatalcarelevel = vo.getNeonatalCareLevel();
		this.firstadmission = vo.getFirstAdmission();
		this.psychpatientstatus = vo.getPsychPatientStatus();
		this.legalstatus = vo.getLegalStatus();
		this.episodestartdate = vo.getEpisodeStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEpisodeStartDate().getBean();
		this.episodeenddate = vo.getEpisodeEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEpisodeEndDate().getBean();
		this.ageatcdsactivity = vo.getAgeAtCDSActivity();
		this.serialnumber = vo.getSerialNumber();
		this.nhsserviceagreenum = vo.getNHSServiceAgreeNum();
		this.providerrefnum = vo.getProviderRefNum();
		this.commissionerrefnum = vo.getCommissionerRefNum();
		this.orgcodeprovider = vo.getOrgCodeProvider();
		this.orgcodecommissioner = vo.getOrgCodeCommissioner();
		this.consultantcode = vo.getConsultantCode();
		this.specialtycode = vo.getSpecialtyCode();
		this.treatmentfunccode = vo.getTreatmentFuncCode();
		this.icddiagnosisgroup = vo.getICDDiagnosisGroup() == null ? null : vo.getICDDiagnosisGroup().getBeanCollection();
		this.readdiaggroup = vo.getReadDiagGroup() == null ? null : new ims.vo.RefVoBean(vo.getReadDiagGroup().getBoId(), vo.getReadDiagGroup().getBoVersion());
		if(vo.getOPCSProcedureGroup() != null)
		{
			this.opcsproceduregroup = new ims.vo.RefVoBean[vo.getOPCSProcedureGroup().size()];
			for(int opcsproceduregroup_i = 0; opcsproceduregroup_i < vo.getOPCSProcedureGroup().size(); opcsproceduregroup_i++)
			{
				this.opcsproceduregroup[opcsproceduregroup_i] = new ims.vo.RefVoBean(vo.getOPCSProcedureGroup().get(opcsproceduregroup_i).getBoId(),vo.getOPCSProcedureGroup().get(opcsproceduregroup_i).getBoVersion());
			}
		}
		this.readproceduregroup = vo.getREADProcedureGroup() == null ? null : new ims.vo.RefVoBean(vo.getREADProcedureGroup().getBoId(), vo.getREADProcedureGroup().getBoVersion());
		this.locationgroupstartepis = vo.getLocationGroupStartEpis() == null ? null : (ims.core.vo.beans.CDSInpatientLocationGroupVoBean)vo.getLocationGroupStartEpis().getBean();
		if(vo.getLocationGroupWardStay() != null)
		{
			this.locationgroupwardstay = new ims.vo.RefVoBean[vo.getLocationGroupWardStay().size()];
			for(int locationgroupwardstay_i = 0; locationgroupwardstay_i < vo.getLocationGroupWardStay().size(); locationgroupwardstay_i++)
			{
				this.locationgroupwardstay[locationgroupwardstay_i] = new ims.vo.RefVoBean(vo.getLocationGroupWardStay().get(locationgroupwardstay_i).getBoId(),vo.getLocationGroupWardStay().get(locationgroupwardstay_i).getBoVersion());
			}
		}
		this.locationgroupendepis = vo.getLocationGroupEndEpis() == null ? null : new ims.vo.RefVoBean(vo.getLocationGroupEndEpis().getBoId(), vo.getLocationGroupEndEpis().getBoVersion());
		this.neonatalcare = vo.getNeonatalCare() == null ? null : (ims.core.vo.beans.CDSCriticalCareVoBean)vo.getNeonatalCare().getBean();
		this.paediatriccare = vo.getPaediatricCare() == null ? null : new ims.vo.RefVoBean(vo.getPaediatricCare().getBoId(), vo.getPaediatricCare().getBoVersion());
		this.adultcare = vo.getAdultCare() == null ? null : new ims.vo.RefVoBean(vo.getAdultCare().getBoId(), vo.getAdultCare().getBoVersion());
		this.ccunitbedconfiguration = vo.getCCUnitBedConfiguration();
		this.ccadmissionsource = vo.getCCAdmissionSource();
		this.ccsourcelocation = vo.getCCSourceLocation();
		this.ccadmissiontype = vo.getCCAdmissionType();
		this.advrespiratorysupdays = vo.getAdvRespiratorySupDays();
		this.bscrespiratorysupdays = vo.getBscRespiratorySupDays();
		this.advcardiosupdays = vo.getAdvCardioSupDays();
		this.bsccardiosupdays = vo.getBscCardioSupDays();
		this.renalsupportdays = vo.getRenalSupportDays();
		this.neurosupportdays = vo.getNeuroSupportDays();
		this.gastrosupportdays = vo.getGastroSupportDays();
		this.dermasupportdays = vo.getDermaSupportDays();
		this.liversupportdays = vo.getLiverSupportDays();
		this.organsupportmax = vo.getOrganSupportMax();
		this.cclevel2days = vo.getCCLevel2Days();
		this.cclevel3days = vo.getCCLevel3Days();
		this.ccdischargedate = vo.getCCDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCCDischargeDate().getBean();
		this.ccdischargetime = vo.getCCDischargeTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getCCDischargeTime().getBean();
		this.ccdischargereadydate = vo.getCCDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCCDischargeReadyDate().getBean();
		this.ccdischargereadytime = vo.getCCDischargeReadyTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getCCDischargeReadyTime().getBean();
		this.ccdischargestatus = vo.getCCDischargeStatus();
		this.ccdischargedest = vo.getCCDischargeDest();
		this.ccdischargelocation = vo.getCCDischargeLocation();
		this.gpcode = vo.getGPCode();
		this.practicecode = vo.getPracticeCode();
		this.referrercode = vo.getReferrerCode();
		this.orgcodereferrer = vo.getOrgCodeReferrer();
		this.durelectivewait = vo.getDurElectiveWait();
		this.intendedmanagement = vo.getIntendedManagement();
		this.decidedtoadmitdate = vo.getDecidedToAdmitDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDecidedToAdmitDate().getBean();
		this.erodate = vo.getERODate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getERODate().getBean();
		this.resourcegrpcode = vo.getResourceGrpCode();
		this.procedurescheme = vo.getProcedureScheme();
		this.hrgdominantgrouping = vo.getHrgDominantGrouping();
		this.cdsapplicabledate = vo.getCDSApplicableDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCDSApplicableDate().getBean();
		this.cdssenderorgcode = vo.getCDSSenderOrgCode();
		this.resourcegpversion = vo.getResourceGPVersion();
		this.maritalstatus = vo.getMaritalStatus();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CDSInpatientVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.ubrn = vo.getUBRN();
		this.pathwayidentifier = vo.getPathwayIdentifier();
		this.pathwayorgcode = vo.getPathwayOrgCode();
		this.referraltotreatmentstatus = vo.getReferralToTreatmentStatus();
		this.rttstartdate = vo.getRTTStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRTTStartDate().getBean();
		this.rttenddate = vo.getRTTEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRTTEndDate().getBean();
		this.leadcareactind = vo.getLeadCareActInd();
		this.localpatientidentifier = vo.getLocalPatientIdentifier();
		this.patidorgcode = vo.getPatIdOrgCode();
		this.nhsnumber = vo.getNHSNumber();
		this.nhsnumberstatusind = vo.getNHSNumberStatusInd();
		this.patientname = vo.getPatientName();
		this.patientaddress = vo.getPatientAddress();
		this.postcode = vo.getPostCode();
		this.pctorgcode = vo.getPCTOrgCode();
		this.dateofbirth = vo.getDateOfBirth() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateOfBirth().getBean();
		this.persongender = vo.getPersonGender();
		this.carersupportind = vo.getCarerSupportInd();
		this.ethniccategory = vo.getEthnicCategory();
		this.providerspellno = vo.getProviderSpellNo();
		this.admincategoryadt = vo.getAdminCategoryADT();
		this.patientclassification = vo.getPatientClassification();
		this.admissionmethod = vo.getAdmissionMethod();
		this.sourceofadmission = vo.getSourceOfAdmission();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.age = vo.getAge();
		this.dischargedestination = vo.getDischargeDestination();
		this.dischargemethod = vo.getDischargeMethod();
		this.dischargereadydate = vo.getDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeReadyDate().getBean();
		this.dischargedate = vo.getDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDate().getBean();
		this.episodenumber = vo.getEpisodeNumber();
		this.lastepisodeind = vo.getLastEpisodeInd();
		this.admincategoryepis = vo.getAdminCategoryEPIS();
		this.operationstatus = vo.getOperationStatus();
		this.neonatalcarelevel = vo.getNeonatalCareLevel();
		this.firstadmission = vo.getFirstAdmission();
		this.psychpatientstatus = vo.getPsychPatientStatus();
		this.legalstatus = vo.getLegalStatus();
		this.episodestartdate = vo.getEpisodeStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEpisodeStartDate().getBean();
		this.episodeenddate = vo.getEpisodeEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEpisodeEndDate().getBean();
		this.ageatcdsactivity = vo.getAgeAtCDSActivity();
		this.serialnumber = vo.getSerialNumber();
		this.nhsserviceagreenum = vo.getNHSServiceAgreeNum();
		this.providerrefnum = vo.getProviderRefNum();
		this.commissionerrefnum = vo.getCommissionerRefNum();
		this.orgcodeprovider = vo.getOrgCodeProvider();
		this.orgcodecommissioner = vo.getOrgCodeCommissioner();
		this.consultantcode = vo.getConsultantCode();
		this.specialtycode = vo.getSpecialtyCode();
		this.treatmentfunccode = vo.getTreatmentFuncCode();
		this.icddiagnosisgroup = vo.getICDDiagnosisGroup() == null ? null : vo.getICDDiagnosisGroup().getBeanCollection();
		this.readdiaggroup = vo.getReadDiagGroup() == null ? null : new ims.vo.RefVoBean(vo.getReadDiagGroup().getBoId(), vo.getReadDiagGroup().getBoVersion());
		if(vo.getOPCSProcedureGroup() != null)
		{
			this.opcsproceduregroup = new ims.vo.RefVoBean[vo.getOPCSProcedureGroup().size()];
			for(int opcsproceduregroup_i = 0; opcsproceduregroup_i < vo.getOPCSProcedureGroup().size(); opcsproceduregroup_i++)
			{
				this.opcsproceduregroup[opcsproceduregroup_i] = new ims.vo.RefVoBean(vo.getOPCSProcedureGroup().get(opcsproceduregroup_i).getBoId(),vo.getOPCSProcedureGroup().get(opcsproceduregroup_i).getBoVersion());
			}
		}
		this.readproceduregroup = vo.getREADProcedureGroup() == null ? null : new ims.vo.RefVoBean(vo.getREADProcedureGroup().getBoId(), vo.getREADProcedureGroup().getBoVersion());
		this.locationgroupstartepis = vo.getLocationGroupStartEpis() == null ? null : (ims.core.vo.beans.CDSInpatientLocationGroupVoBean)vo.getLocationGroupStartEpis().getBean(map);
		if(vo.getLocationGroupWardStay() != null)
		{
			this.locationgroupwardstay = new ims.vo.RefVoBean[vo.getLocationGroupWardStay().size()];
			for(int locationgroupwardstay_i = 0; locationgroupwardstay_i < vo.getLocationGroupWardStay().size(); locationgroupwardstay_i++)
			{
				this.locationgroupwardstay[locationgroupwardstay_i] = new ims.vo.RefVoBean(vo.getLocationGroupWardStay().get(locationgroupwardstay_i).getBoId(),vo.getLocationGroupWardStay().get(locationgroupwardstay_i).getBoVersion());
			}
		}
		this.locationgroupendepis = vo.getLocationGroupEndEpis() == null ? null : new ims.vo.RefVoBean(vo.getLocationGroupEndEpis().getBoId(), vo.getLocationGroupEndEpis().getBoVersion());
		this.neonatalcare = vo.getNeonatalCare() == null ? null : (ims.core.vo.beans.CDSCriticalCareVoBean)vo.getNeonatalCare().getBean(map);
		this.paediatriccare = vo.getPaediatricCare() == null ? null : new ims.vo.RefVoBean(vo.getPaediatricCare().getBoId(), vo.getPaediatricCare().getBoVersion());
		this.adultcare = vo.getAdultCare() == null ? null : new ims.vo.RefVoBean(vo.getAdultCare().getBoId(), vo.getAdultCare().getBoVersion());
		this.ccunitbedconfiguration = vo.getCCUnitBedConfiguration();
		this.ccadmissionsource = vo.getCCAdmissionSource();
		this.ccsourcelocation = vo.getCCSourceLocation();
		this.ccadmissiontype = vo.getCCAdmissionType();
		this.advrespiratorysupdays = vo.getAdvRespiratorySupDays();
		this.bscrespiratorysupdays = vo.getBscRespiratorySupDays();
		this.advcardiosupdays = vo.getAdvCardioSupDays();
		this.bsccardiosupdays = vo.getBscCardioSupDays();
		this.renalsupportdays = vo.getRenalSupportDays();
		this.neurosupportdays = vo.getNeuroSupportDays();
		this.gastrosupportdays = vo.getGastroSupportDays();
		this.dermasupportdays = vo.getDermaSupportDays();
		this.liversupportdays = vo.getLiverSupportDays();
		this.organsupportmax = vo.getOrganSupportMax();
		this.cclevel2days = vo.getCCLevel2Days();
		this.cclevel3days = vo.getCCLevel3Days();
		this.ccdischargedate = vo.getCCDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCCDischargeDate().getBean();
		this.ccdischargetime = vo.getCCDischargeTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getCCDischargeTime().getBean();
		this.ccdischargereadydate = vo.getCCDischargeReadyDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCCDischargeReadyDate().getBean();
		this.ccdischargereadytime = vo.getCCDischargeReadyTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getCCDischargeReadyTime().getBean();
		this.ccdischargestatus = vo.getCCDischargeStatus();
		this.ccdischargedest = vo.getCCDischargeDest();
		this.ccdischargelocation = vo.getCCDischargeLocation();
		this.gpcode = vo.getGPCode();
		this.practicecode = vo.getPracticeCode();
		this.referrercode = vo.getReferrerCode();
		this.orgcodereferrer = vo.getOrgCodeReferrer();
		this.durelectivewait = vo.getDurElectiveWait();
		this.intendedmanagement = vo.getIntendedManagement();
		this.decidedtoadmitdate = vo.getDecidedToAdmitDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDecidedToAdmitDate().getBean();
		this.erodate = vo.getERODate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getERODate().getBean();
		this.resourcegrpcode = vo.getResourceGrpCode();
		this.procedurescheme = vo.getProcedureScheme();
		this.hrgdominantgrouping = vo.getHrgDominantGrouping();
		this.cdsapplicabledate = vo.getCDSApplicableDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCDSApplicableDate().getBean();
		this.cdssenderorgcode = vo.getCDSSenderOrgCode();
		this.resourcegpversion = vo.getResourceGPVersion();
		this.maritalstatus = vo.getMaritalStatus();
	}

	public ims.core.vo.CDSInpatientVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CDSInpatientVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CDSInpatientVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CDSInpatientVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CDSInpatientVo();
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
	public String getUBRN()
	{
		return this.ubrn;
	}
	public void setUBRN(String value)
	{
		this.ubrn = value;
	}
	public String getPathwayIdentifier()
	{
		return this.pathwayidentifier;
	}
	public void setPathwayIdentifier(String value)
	{
		this.pathwayidentifier = value;
	}
	public String getPathwayOrgCode()
	{
		return this.pathwayorgcode;
	}
	public void setPathwayOrgCode(String value)
	{
		this.pathwayorgcode = value;
	}
	public String getReferralToTreatmentStatus()
	{
		return this.referraltotreatmentstatus;
	}
	public void setReferralToTreatmentStatus(String value)
	{
		this.referraltotreatmentstatus = value;
	}
	public ims.framework.utils.beans.DateBean getRTTStartDate()
	{
		return this.rttstartdate;
	}
	public void setRTTStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.rttstartdate = value;
	}
	public ims.framework.utils.beans.DateBean getRTTEndDate()
	{
		return this.rttenddate;
	}
	public void setRTTEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.rttenddate = value;
	}
	public String getLeadCareActInd()
	{
		return this.leadcareactind;
	}
	public void setLeadCareActInd(String value)
	{
		this.leadcareactind = value;
	}
	public String getLocalPatientIdentifier()
	{
		return this.localpatientidentifier;
	}
	public void setLocalPatientIdentifier(String value)
	{
		this.localpatientidentifier = value;
	}
	public String getPatIdOrgCode()
	{
		return this.patidorgcode;
	}
	public void setPatIdOrgCode(String value)
	{
		this.patidorgcode = value;
	}
	public String getNHSNumber()
	{
		return this.nhsnumber;
	}
	public void setNHSNumber(String value)
	{
		this.nhsnumber = value;
	}
	public String getNHSNumberStatusInd()
	{
		return this.nhsnumberstatusind;
	}
	public void setNHSNumberStatusInd(String value)
	{
		this.nhsnumberstatusind = value;
	}
	public String getPatientName()
	{
		return this.patientname;
	}
	public void setPatientName(String value)
	{
		this.patientname = value;
	}
	public String getPatientAddress()
	{
		return this.patientaddress;
	}
	public void setPatientAddress(String value)
	{
		this.patientaddress = value;
	}
	public String getPostCode()
	{
		return this.postcode;
	}
	public void setPostCode(String value)
	{
		this.postcode = value;
	}
	public String getPCTOrgCode()
	{
		return this.pctorgcode;
	}
	public void setPCTOrgCode(String value)
	{
		this.pctorgcode = value;
	}
	public ims.framework.utils.beans.DateBean getDateOfBirth()
	{
		return this.dateofbirth;
	}
	public void setDateOfBirth(ims.framework.utils.beans.DateBean value)
	{
		this.dateofbirth = value;
	}
	public String getPersonGender()
	{
		return this.persongender;
	}
	public void setPersonGender(String value)
	{
		this.persongender = value;
	}
	public String getCarerSupportInd()
	{
		return this.carersupportind;
	}
	public void setCarerSupportInd(String value)
	{
		this.carersupportind = value;
	}
	public String getEthnicCategory()
	{
		return this.ethniccategory;
	}
	public void setEthnicCategory(String value)
	{
		this.ethniccategory = value;
	}
	public String getProviderSpellNo()
	{
		return this.providerspellno;
	}
	public void setProviderSpellNo(String value)
	{
		this.providerspellno = value;
	}
	public String getAdminCategoryADT()
	{
		return this.admincategoryadt;
	}
	public void setAdminCategoryADT(String value)
	{
		this.admincategoryadt = value;
	}
	public String getPatientClassification()
	{
		return this.patientclassification;
	}
	public void setPatientClassification(String value)
	{
		this.patientclassification = value;
	}
	public String getAdmissionMethod()
	{
		return this.admissionmethod;
	}
	public void setAdmissionMethod(String value)
	{
		this.admissionmethod = value;
	}
	public String getSourceOfAdmission()
	{
		return this.sourceofadmission;
	}
	public void setSourceOfAdmission(String value)
	{
		this.sourceofadmission = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public Integer getAge()
	{
		return this.age;
	}
	public void setAge(Integer value)
	{
		this.age = value;
	}
	public String getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(String value)
	{
		this.dischargedestination = value;
	}
	public String getDischargeMethod()
	{
		return this.dischargemethod;
	}
	public void setDischargeMethod(String value)
	{
		this.dischargemethod = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeReadyDate()
	{
		return this.dischargereadydate;
	}
	public void setDischargeReadyDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargereadydate = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargedate = value;
	}
	public String getEpisodeNumber()
	{
		return this.episodenumber;
	}
	public void setEpisodeNumber(String value)
	{
		this.episodenumber = value;
	}
	public String getLastEpisodeInd()
	{
		return this.lastepisodeind;
	}
	public void setLastEpisodeInd(String value)
	{
		this.lastepisodeind = value;
	}
	public String getAdminCategoryEPIS()
	{
		return this.admincategoryepis;
	}
	public void setAdminCategoryEPIS(String value)
	{
		this.admincategoryepis = value;
	}
	public String getOperationStatus()
	{
		return this.operationstatus;
	}
	public void setOperationStatus(String value)
	{
		this.operationstatus = value;
	}
	public String getNeonatalCareLevel()
	{
		return this.neonatalcarelevel;
	}
	public void setNeonatalCareLevel(String value)
	{
		this.neonatalcarelevel = value;
	}
	public String getFirstAdmission()
	{
		return this.firstadmission;
	}
	public void setFirstAdmission(String value)
	{
		this.firstadmission = value;
	}
	public String getPsychPatientStatus()
	{
		return this.psychpatientstatus;
	}
	public void setPsychPatientStatus(String value)
	{
		this.psychpatientstatus = value;
	}
	public String getLegalStatus()
	{
		return this.legalstatus;
	}
	public void setLegalStatus(String value)
	{
		this.legalstatus = value;
	}
	public ims.framework.utils.beans.DateBean getEpisodeStartDate()
	{
		return this.episodestartdate;
	}
	public void setEpisodeStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.episodestartdate = value;
	}
	public ims.framework.utils.beans.DateBean getEpisodeEndDate()
	{
		return this.episodeenddate;
	}
	public void setEpisodeEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.episodeenddate = value;
	}
	public Integer getAgeAtCDSActivity()
	{
		return this.ageatcdsactivity;
	}
	public void setAgeAtCDSActivity(Integer value)
	{
		this.ageatcdsactivity = value;
	}
	public String getSerialNumber()
	{
		return this.serialnumber;
	}
	public void setSerialNumber(String value)
	{
		this.serialnumber = value;
	}
	public String getNHSServiceAgreeNum()
	{
		return this.nhsserviceagreenum;
	}
	public void setNHSServiceAgreeNum(String value)
	{
		this.nhsserviceagreenum = value;
	}
	public String getProviderRefNum()
	{
		return this.providerrefnum;
	}
	public void setProviderRefNum(String value)
	{
		this.providerrefnum = value;
	}
	public String getCommissionerRefNum()
	{
		return this.commissionerrefnum;
	}
	public void setCommissionerRefNum(String value)
	{
		this.commissionerrefnum = value;
	}
	public String getOrgCodeProvider()
	{
		return this.orgcodeprovider;
	}
	public void setOrgCodeProvider(String value)
	{
		this.orgcodeprovider = value;
	}
	public String getOrgCodeCommissioner()
	{
		return this.orgcodecommissioner;
	}
	public void setOrgCodeCommissioner(String value)
	{
		this.orgcodecommissioner = value;
	}
	public String getConsultantCode()
	{
		return this.consultantcode;
	}
	public void setConsultantCode(String value)
	{
		this.consultantcode = value;
	}
	public String getSpecialtyCode()
	{
		return this.specialtycode;
	}
	public void setSpecialtyCode(String value)
	{
		this.specialtycode = value;
	}
	public String getTreatmentFuncCode()
	{
		return this.treatmentfunccode;
	}
	public void setTreatmentFuncCode(String value)
	{
		this.treatmentfunccode = value;
	}
	public ims.core.vo.beans.CDSDiagnosisDetailsVoBean[] getICDDiagnosisGroup()
	{
		return this.icddiagnosisgroup;
	}
	public void setICDDiagnosisGroup(ims.core.vo.beans.CDSDiagnosisDetailsVoBean[] value)
	{
		this.icddiagnosisgroup = value;
	}
	public ims.vo.RefVoBean getReadDiagGroup()
	{
		return this.readdiaggroup;
	}
	public void setReadDiagGroup(ims.vo.RefVoBean value)
	{
		this.readdiaggroup = value;
	}
	public ims.vo.RefVoBean[] getOPCSProcedureGroup()
	{
		return this.opcsproceduregroup;
	}
	public void setOPCSProcedureGroup(ims.vo.RefVoBean[] value)
	{
		this.opcsproceduregroup = value;
	}
	public ims.vo.RefVoBean getREADProcedureGroup()
	{
		return this.readproceduregroup;
	}
	public void setREADProcedureGroup(ims.vo.RefVoBean value)
	{
		this.readproceduregroup = value;
	}
	public ims.core.vo.beans.CDSInpatientLocationGroupVoBean getLocationGroupStartEpis()
	{
		return this.locationgroupstartepis;
	}
	public void setLocationGroupStartEpis(ims.core.vo.beans.CDSInpatientLocationGroupVoBean value)
	{
		this.locationgroupstartepis = value;
	}
	public ims.vo.RefVoBean[] getLocationGroupWardStay()
	{
		return this.locationgroupwardstay;
	}
	public void setLocationGroupWardStay(ims.vo.RefVoBean[] value)
	{
		this.locationgroupwardstay = value;
	}
	public ims.vo.RefVoBean getLocationGroupEndEpis()
	{
		return this.locationgroupendepis;
	}
	public void setLocationGroupEndEpis(ims.vo.RefVoBean value)
	{
		this.locationgroupendepis = value;
	}
	public ims.core.vo.beans.CDSCriticalCareVoBean getNeonatalCare()
	{
		return this.neonatalcare;
	}
	public void setNeonatalCare(ims.core.vo.beans.CDSCriticalCareVoBean value)
	{
		this.neonatalcare = value;
	}
	public ims.vo.RefVoBean getPaediatricCare()
	{
		return this.paediatriccare;
	}
	public void setPaediatricCare(ims.vo.RefVoBean value)
	{
		this.paediatriccare = value;
	}
	public ims.vo.RefVoBean getAdultCare()
	{
		return this.adultcare;
	}
	public void setAdultCare(ims.vo.RefVoBean value)
	{
		this.adultcare = value;
	}
	public String getCCUnitBedConfiguration()
	{
		return this.ccunitbedconfiguration;
	}
	public void setCCUnitBedConfiguration(String value)
	{
		this.ccunitbedconfiguration = value;
	}
	public String getCCAdmissionSource()
	{
		return this.ccadmissionsource;
	}
	public void setCCAdmissionSource(String value)
	{
		this.ccadmissionsource = value;
	}
	public String getCCSourceLocation()
	{
		return this.ccsourcelocation;
	}
	public void setCCSourceLocation(String value)
	{
		this.ccsourcelocation = value;
	}
	public String getCCAdmissionType()
	{
		return this.ccadmissiontype;
	}
	public void setCCAdmissionType(String value)
	{
		this.ccadmissiontype = value;
	}
	public String getAdvRespiratorySupDays()
	{
		return this.advrespiratorysupdays;
	}
	public void setAdvRespiratorySupDays(String value)
	{
		this.advrespiratorysupdays = value;
	}
	public String getBscRespiratorySupDays()
	{
		return this.bscrespiratorysupdays;
	}
	public void setBscRespiratorySupDays(String value)
	{
		this.bscrespiratorysupdays = value;
	}
	public String getAdvCardioSupDays()
	{
		return this.advcardiosupdays;
	}
	public void setAdvCardioSupDays(String value)
	{
		this.advcardiosupdays = value;
	}
	public String getBscCardioSupDays()
	{
		return this.bsccardiosupdays;
	}
	public void setBscCardioSupDays(String value)
	{
		this.bsccardiosupdays = value;
	}
	public String getRenalSupportDays()
	{
		return this.renalsupportdays;
	}
	public void setRenalSupportDays(String value)
	{
		this.renalsupportdays = value;
	}
	public String getNeuroSupportDays()
	{
		return this.neurosupportdays;
	}
	public void setNeuroSupportDays(String value)
	{
		this.neurosupportdays = value;
	}
	public String getGastroSupportDays()
	{
		return this.gastrosupportdays;
	}
	public void setGastroSupportDays(String value)
	{
		this.gastrosupportdays = value;
	}
	public String getDermaSupportDays()
	{
		return this.dermasupportdays;
	}
	public void setDermaSupportDays(String value)
	{
		this.dermasupportdays = value;
	}
	public String getLiverSupportDays()
	{
		return this.liversupportdays;
	}
	public void setLiverSupportDays(String value)
	{
		this.liversupportdays = value;
	}
	public String getOrganSupportMax()
	{
		return this.organsupportmax;
	}
	public void setOrganSupportMax(String value)
	{
		this.organsupportmax = value;
	}
	public String getCCLevel2Days()
	{
		return this.cclevel2days;
	}
	public void setCCLevel2Days(String value)
	{
		this.cclevel2days = value;
	}
	public String getCCLevel3Days()
	{
		return this.cclevel3days;
	}
	public void setCCLevel3Days(String value)
	{
		this.cclevel3days = value;
	}
	public ims.framework.utils.beans.DateBean getCCDischargeDate()
	{
		return this.ccdischargedate;
	}
	public void setCCDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.ccdischargedate = value;
	}
	public ims.framework.utils.beans.TimeBean getCCDischargeTime()
	{
		return this.ccdischargetime;
	}
	public void setCCDischargeTime(ims.framework.utils.beans.TimeBean value)
	{
		this.ccdischargetime = value;
	}
	public ims.framework.utils.beans.DateBean getCCDischargeReadyDate()
	{
		return this.ccdischargereadydate;
	}
	public void setCCDischargeReadyDate(ims.framework.utils.beans.DateBean value)
	{
		this.ccdischargereadydate = value;
	}
	public ims.framework.utils.beans.TimeBean getCCDischargeReadyTime()
	{
		return this.ccdischargereadytime;
	}
	public void setCCDischargeReadyTime(ims.framework.utils.beans.TimeBean value)
	{
		this.ccdischargereadytime = value;
	}
	public String getCCDischargeStatus()
	{
		return this.ccdischargestatus;
	}
	public void setCCDischargeStatus(String value)
	{
		this.ccdischargestatus = value;
	}
	public String getCCDischargeDest()
	{
		return this.ccdischargedest;
	}
	public void setCCDischargeDest(String value)
	{
		this.ccdischargedest = value;
	}
	public String getCCDischargeLocation()
	{
		return this.ccdischargelocation;
	}
	public void setCCDischargeLocation(String value)
	{
		this.ccdischargelocation = value;
	}
	public String getGPCode()
	{
		return this.gpcode;
	}
	public void setGPCode(String value)
	{
		this.gpcode = value;
	}
	public String getPracticeCode()
	{
		return this.practicecode;
	}
	public void setPracticeCode(String value)
	{
		this.practicecode = value;
	}
	public String getReferrerCode()
	{
		return this.referrercode;
	}
	public void setReferrerCode(String value)
	{
		this.referrercode = value;
	}
	public String getOrgCodeReferrer()
	{
		return this.orgcodereferrer;
	}
	public void setOrgCodeReferrer(String value)
	{
		this.orgcodereferrer = value;
	}
	public String getDurElectiveWait()
	{
		return this.durelectivewait;
	}
	public void setDurElectiveWait(String value)
	{
		this.durelectivewait = value;
	}
	public String getIntendedManagement()
	{
		return this.intendedmanagement;
	}
	public void setIntendedManagement(String value)
	{
		this.intendedmanagement = value;
	}
	public ims.framework.utils.beans.DateBean getDecidedToAdmitDate()
	{
		return this.decidedtoadmitdate;
	}
	public void setDecidedToAdmitDate(ims.framework.utils.beans.DateBean value)
	{
		this.decidedtoadmitdate = value;
	}
	public ims.framework.utils.beans.DateBean getERODate()
	{
		return this.erodate;
	}
	public void setERODate(ims.framework.utils.beans.DateBean value)
	{
		this.erodate = value;
	}
	public String getResourceGrpCode()
	{
		return this.resourcegrpcode;
	}
	public void setResourceGrpCode(String value)
	{
		this.resourcegrpcode = value;
	}
	public String getProcedureScheme()
	{
		return this.procedurescheme;
	}
	public void setProcedureScheme(String value)
	{
		this.procedurescheme = value;
	}
	public String getHrgDominantGrouping()
	{
		return this.hrgdominantgrouping;
	}
	public void setHrgDominantGrouping(String value)
	{
		this.hrgdominantgrouping = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCDSApplicableDate()
	{
		return this.cdsapplicabledate;
	}
	public void setCDSApplicableDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.cdsapplicabledate = value;
	}
	public String getCDSSenderOrgCode()
	{
		return this.cdssenderorgcode;
	}
	public void setCDSSenderOrgCode(String value)
	{
		this.cdssenderorgcode = value;
	}
	public String getResourceGPVersion()
	{
		return this.resourcegpversion;
	}
	public void setResourceGPVersion(String value)
	{
		this.resourcegpversion = value;
	}
	public String getMaritalStatus()
	{
		return this.maritalstatus;
	}
	public void setMaritalStatus(String value)
	{
		this.maritalstatus = value;
	}

	private Integer id;
	private int version;
	private String ubrn;
	private String pathwayidentifier;
	private String pathwayorgcode;
	private String referraltotreatmentstatus;
	private ims.framework.utils.beans.DateBean rttstartdate;
	private ims.framework.utils.beans.DateBean rttenddate;
	private String leadcareactind;
	private String localpatientidentifier;
	private String patidorgcode;
	private String nhsnumber;
	private String nhsnumberstatusind;
	private String patientname;
	private String patientaddress;
	private String postcode;
	private String pctorgcode;
	private ims.framework.utils.beans.DateBean dateofbirth;
	private String persongender;
	private String carersupportind;
	private String ethniccategory;
	private String providerspellno;
	private String admincategoryadt;
	private String patientclassification;
	private String admissionmethod;
	private String sourceofadmission;
	private ims.framework.utils.beans.DateBean startdate;
	private Integer age;
	private String dischargedestination;
	private String dischargemethod;
	private ims.framework.utils.beans.DateBean dischargereadydate;
	private ims.framework.utils.beans.DateBean dischargedate;
	private String episodenumber;
	private String lastepisodeind;
	private String admincategoryepis;
	private String operationstatus;
	private String neonatalcarelevel;
	private String firstadmission;
	private String psychpatientstatus;
	private String legalstatus;
	private ims.framework.utils.beans.DateBean episodestartdate;
	private ims.framework.utils.beans.DateBean episodeenddate;
	private Integer ageatcdsactivity;
	private String serialnumber;
	private String nhsserviceagreenum;
	private String providerrefnum;
	private String commissionerrefnum;
	private String orgcodeprovider;
	private String orgcodecommissioner;
	private String consultantcode;
	private String specialtycode;
	private String treatmentfunccode;
	private ims.core.vo.beans.CDSDiagnosisDetailsVoBean[] icddiagnosisgroup;
	private ims.vo.RefVoBean readdiaggroup;
	private ims.vo.RefVoBean[] opcsproceduregroup;
	private ims.vo.RefVoBean readproceduregroup;
	private ims.core.vo.beans.CDSInpatientLocationGroupVoBean locationgroupstartepis;
	private ims.vo.RefVoBean[] locationgroupwardstay;
	private ims.vo.RefVoBean locationgroupendepis;
	private ims.core.vo.beans.CDSCriticalCareVoBean neonatalcare;
	private ims.vo.RefVoBean paediatriccare;
	private ims.vo.RefVoBean adultcare;
	private String ccunitbedconfiguration;
	private String ccadmissionsource;
	private String ccsourcelocation;
	private String ccadmissiontype;
	private String advrespiratorysupdays;
	private String bscrespiratorysupdays;
	private String advcardiosupdays;
	private String bsccardiosupdays;
	private String renalsupportdays;
	private String neurosupportdays;
	private String gastrosupportdays;
	private String dermasupportdays;
	private String liversupportdays;
	private String organsupportmax;
	private String cclevel2days;
	private String cclevel3days;
	private ims.framework.utils.beans.DateBean ccdischargedate;
	private ims.framework.utils.beans.TimeBean ccdischargetime;
	private ims.framework.utils.beans.DateBean ccdischargereadydate;
	private ims.framework.utils.beans.TimeBean ccdischargereadytime;
	private String ccdischargestatus;
	private String ccdischargedest;
	private String ccdischargelocation;
	private String gpcode;
	private String practicecode;
	private String referrercode;
	private String orgcodereferrer;
	private String durelectivewait;
	private String intendedmanagement;
	private ims.framework.utils.beans.DateBean decidedtoadmitdate;
	private ims.framework.utils.beans.DateBean erodate;
	private String resourcegrpcode;
	private String procedurescheme;
	private String hrgdominantgrouping;
	private ims.framework.utils.beans.DateTimeBean cdsapplicabledate;
	private String cdssenderorgcode;
	private String resourcegpversion;
	private String maritalstatus;
}
