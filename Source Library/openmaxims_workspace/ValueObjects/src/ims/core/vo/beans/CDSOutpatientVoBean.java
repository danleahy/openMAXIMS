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

public class CDSOutpatientVoBean extends ims.vo.ValueObjectBean
{
	public CDSOutpatientVoBean()
	{
	}
	public CDSOutpatientVoBean(ims.core.vo.CDSOutpatientVo vo)
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
		this.consultantcode = vo.getConsultantCode();
		this.specialtycode = vo.getSpecialtyCode();
		this.treatmentfunccode = vo.getTreatmentFuncCode();
		if(vo.getICDDiagGroup() != null)
		{
			this.icddiaggroup = new ims.vo.RefVoBean[vo.getICDDiagGroup().size()];
			for(int icddiaggroup_i = 0; icddiaggroup_i < vo.getICDDiagGroup().size(); icddiaggroup_i++)
			{
				this.icddiaggroup[icddiaggroup_i] = new ims.vo.RefVoBean(vo.getICDDiagGroup().get(icddiaggroup_i).getBoId(),vo.getICDDiagGroup().get(icddiaggroup_i).getBoVersion());
			}
		}
		this.readdiaggroup = vo.getReadDiagGroup() == null ? null : new ims.vo.RefVoBean(vo.getReadDiagGroup().getBoId(), vo.getReadDiagGroup().getBoVersion());
		this.attendanceidentifier = vo.getAttendanceIdentifier();
		this.admincategory = vo.getAdminCategory();
		this.attendedordna = vo.getAttendedOrDNA();
		this.firstattendance = vo.getFirstAttendance();
		this.medstafftype = vo.getMedStaffType();
		this.operationstatus = vo.getOperationStatus();
		this.attendoutcome = vo.getAttendOutcome();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.age = vo.getAge();
		this.earliestofferdate = vo.getEarliestOfferDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEarliestOfferDate().getBean();
		this.serialnumber = vo.getSerialNumber();
		this.nhsserviceagreenum = vo.getNHSServiceAgreeNum();
		this.providerrefnum = vo.getProviderRefNum();
		this.commissionerrefnum = vo.getCommissionerRefNum();
		this.orgcodeprovider = vo.getOrgCodeProvider();
		this.orgcodecommissioner = vo.getOrgCodeCommissioner();
		if(vo.getOPCSProcedure() != null)
		{
			this.opcsprocedure = new ims.vo.RefVoBean[vo.getOPCSProcedure().size()];
			for(int opcsprocedure_i = 0; opcsprocedure_i < vo.getOPCSProcedure().size(); opcsprocedure_i++)
			{
				this.opcsprocedure[opcsprocedure_i] = new ims.vo.RefVoBean(vo.getOPCSProcedure().get(opcsprocedure_i).getBoId(),vo.getOPCSProcedure().get(opcsprocedure_i).getBoVersion());
			}
		}
		this.readprocedure = vo.getREADProcedure() == null ? null : new ims.vo.RefVoBean(vo.getREADProcedure().getBoId(), vo.getREADProcedure().getBoVersion());
		this.locationclass = vo.getLocationClass();
		this.sitecodetreatment = vo.getSiteCodeTreatment();
		this.gpcode = vo.getGPCode();
		this.practicecode = vo.getPracticeCode();
		this.prioritytype = vo.getPriorityType();
		this.servicetypereq = vo.getServiceTypeReq();
		this.referralsource = vo.getReferralSource();
		this.referralreceiveddate = vo.getReferralReceivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralReceivedDate().getBean();
		this.referrercode = vo.getReferrerCode();
		this.orgcodereferrer = vo.getOrgCodeReferrer();
		this.lastdnacanceldate = vo.getLastDNACancelDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastDNACancelDate().getBean();
		this.resourcegrpcode = vo.getResourceGrpCode();
		this.procedurescheme = vo.getProcedureScheme();
		this.hrgdominantgrouping = vo.getHrgDominantGrouping();
		this.cdsapplicabledate = vo.getCDSApplicableDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCDSApplicableDate().getBean();
		this.cdssenderorgcode = vo.getCDSSenderOrgCode();
		this.resourcegpversion = vo.getResourceGPVersion();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CDSOutpatientVo vo)
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
		this.consultantcode = vo.getConsultantCode();
		this.specialtycode = vo.getSpecialtyCode();
		this.treatmentfunccode = vo.getTreatmentFuncCode();
		if(vo.getICDDiagGroup() != null)
		{
			this.icddiaggroup = new ims.vo.RefVoBean[vo.getICDDiagGroup().size()];
			for(int icddiaggroup_i = 0; icddiaggroup_i < vo.getICDDiagGroup().size(); icddiaggroup_i++)
			{
				this.icddiaggroup[icddiaggroup_i] = new ims.vo.RefVoBean(vo.getICDDiagGroup().get(icddiaggroup_i).getBoId(),vo.getICDDiagGroup().get(icddiaggroup_i).getBoVersion());
			}
		}
		this.readdiaggroup = vo.getReadDiagGroup() == null ? null : new ims.vo.RefVoBean(vo.getReadDiagGroup().getBoId(), vo.getReadDiagGroup().getBoVersion());
		this.attendanceidentifier = vo.getAttendanceIdentifier();
		this.admincategory = vo.getAdminCategory();
		this.attendedordna = vo.getAttendedOrDNA();
		this.firstattendance = vo.getFirstAttendance();
		this.medstafftype = vo.getMedStaffType();
		this.operationstatus = vo.getOperationStatus();
		this.attendoutcome = vo.getAttendOutcome();
		this.apptdate = vo.getApptDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getApptDate().getBean();
		this.age = vo.getAge();
		this.earliestofferdate = vo.getEarliestOfferDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEarliestOfferDate().getBean();
		this.serialnumber = vo.getSerialNumber();
		this.nhsserviceagreenum = vo.getNHSServiceAgreeNum();
		this.providerrefnum = vo.getProviderRefNum();
		this.commissionerrefnum = vo.getCommissionerRefNum();
		this.orgcodeprovider = vo.getOrgCodeProvider();
		this.orgcodecommissioner = vo.getOrgCodeCommissioner();
		if(vo.getOPCSProcedure() != null)
		{
			this.opcsprocedure = new ims.vo.RefVoBean[vo.getOPCSProcedure().size()];
			for(int opcsprocedure_i = 0; opcsprocedure_i < vo.getOPCSProcedure().size(); opcsprocedure_i++)
			{
				this.opcsprocedure[opcsprocedure_i] = new ims.vo.RefVoBean(vo.getOPCSProcedure().get(opcsprocedure_i).getBoId(),vo.getOPCSProcedure().get(opcsprocedure_i).getBoVersion());
			}
		}
		this.readprocedure = vo.getREADProcedure() == null ? null : new ims.vo.RefVoBean(vo.getREADProcedure().getBoId(), vo.getREADProcedure().getBoVersion());
		this.locationclass = vo.getLocationClass();
		this.sitecodetreatment = vo.getSiteCodeTreatment();
		this.gpcode = vo.getGPCode();
		this.practicecode = vo.getPracticeCode();
		this.prioritytype = vo.getPriorityType();
		this.servicetypereq = vo.getServiceTypeReq();
		this.referralsource = vo.getReferralSource();
		this.referralreceiveddate = vo.getReferralReceivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralReceivedDate().getBean();
		this.referrercode = vo.getReferrerCode();
		this.orgcodereferrer = vo.getOrgCodeReferrer();
		this.lastdnacanceldate = vo.getLastDNACancelDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLastDNACancelDate().getBean();
		this.resourcegrpcode = vo.getResourceGrpCode();
		this.procedurescheme = vo.getProcedureScheme();
		this.hrgdominantgrouping = vo.getHrgDominantGrouping();
		this.cdsapplicabledate = vo.getCDSApplicableDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCDSApplicableDate().getBean();
		this.cdssenderorgcode = vo.getCDSSenderOrgCode();
		this.resourcegpversion = vo.getResourceGPVersion();
	}

	public ims.core.vo.CDSOutpatientVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CDSOutpatientVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CDSOutpatientVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CDSOutpatientVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CDSOutpatientVo();
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
	public ims.vo.RefVoBean[] getICDDiagGroup()
	{
		return this.icddiaggroup;
	}
	public void setICDDiagGroup(ims.vo.RefVoBean[] value)
	{
		this.icddiaggroup = value;
	}
	public ims.vo.RefVoBean getReadDiagGroup()
	{
		return this.readdiaggroup;
	}
	public void setReadDiagGroup(ims.vo.RefVoBean value)
	{
		this.readdiaggroup = value;
	}
	public String getAttendanceIdentifier()
	{
		return this.attendanceidentifier;
	}
	public void setAttendanceIdentifier(String value)
	{
		this.attendanceidentifier = value;
	}
	public String getAdminCategory()
	{
		return this.admincategory;
	}
	public void setAdminCategory(String value)
	{
		this.admincategory = value;
	}
	public String getAttendedOrDNA()
	{
		return this.attendedordna;
	}
	public void setAttendedOrDNA(String value)
	{
		this.attendedordna = value;
	}
	public String getFirstAttendance()
	{
		return this.firstattendance;
	}
	public void setFirstAttendance(String value)
	{
		this.firstattendance = value;
	}
	public String getMedStaffType()
	{
		return this.medstafftype;
	}
	public void setMedStaffType(String value)
	{
		this.medstafftype = value;
	}
	public String getOperationStatus()
	{
		return this.operationstatus;
	}
	public void setOperationStatus(String value)
	{
		this.operationstatus = value;
	}
	public String getAttendOutcome()
	{
		return this.attendoutcome;
	}
	public void setAttendOutcome(String value)
	{
		this.attendoutcome = value;
	}
	public ims.framework.utils.beans.DateBean getApptDate()
	{
		return this.apptdate;
	}
	public void setApptDate(ims.framework.utils.beans.DateBean value)
	{
		this.apptdate = value;
	}
	public Integer getAge()
	{
		return this.age;
	}
	public void setAge(Integer value)
	{
		this.age = value;
	}
	public ims.framework.utils.beans.DateBean getEarliestOfferDate()
	{
		return this.earliestofferdate;
	}
	public void setEarliestOfferDate(ims.framework.utils.beans.DateBean value)
	{
		this.earliestofferdate = value;
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
	public ims.vo.RefVoBean[] getOPCSProcedure()
	{
		return this.opcsprocedure;
	}
	public void setOPCSProcedure(ims.vo.RefVoBean[] value)
	{
		this.opcsprocedure = value;
	}
	public ims.vo.RefVoBean getREADProcedure()
	{
		return this.readprocedure;
	}
	public void setREADProcedure(ims.vo.RefVoBean value)
	{
		this.readprocedure = value;
	}
	public String getLocationClass()
	{
		return this.locationclass;
	}
	public void setLocationClass(String value)
	{
		this.locationclass = value;
	}
	public String getSiteCodeTreatment()
	{
		return this.sitecodetreatment;
	}
	public void setSiteCodeTreatment(String value)
	{
		this.sitecodetreatment = value;
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
	public String getPriorityType()
	{
		return this.prioritytype;
	}
	public void setPriorityType(String value)
	{
		this.prioritytype = value;
	}
	public String getServiceTypeReq()
	{
		return this.servicetypereq;
	}
	public void setServiceTypeReq(String value)
	{
		this.servicetypereq = value;
	}
	public String getReferralSource()
	{
		return this.referralsource;
	}
	public void setReferralSource(String value)
	{
		this.referralsource = value;
	}
	public ims.framework.utils.beans.DateBean getReferralReceivedDate()
	{
		return this.referralreceiveddate;
	}
	public void setReferralReceivedDate(ims.framework.utils.beans.DateBean value)
	{
		this.referralreceiveddate = value;
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
	public ims.framework.utils.beans.DateBean getLastDNACancelDate()
	{
		return this.lastdnacanceldate;
	}
	public void setLastDNACancelDate(ims.framework.utils.beans.DateBean value)
	{
		this.lastdnacanceldate = value;
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
	private String consultantcode;
	private String specialtycode;
	private String treatmentfunccode;
	private ims.vo.RefVoBean[] icddiaggroup;
	private ims.vo.RefVoBean readdiaggroup;
	private String attendanceidentifier;
	private String admincategory;
	private String attendedordna;
	private String firstattendance;
	private String medstafftype;
	private String operationstatus;
	private String attendoutcome;
	private ims.framework.utils.beans.DateBean apptdate;
	private Integer age;
	private ims.framework.utils.beans.DateBean earliestofferdate;
	private String serialnumber;
	private String nhsserviceagreenum;
	private String providerrefnum;
	private String commissionerrefnum;
	private String orgcodeprovider;
	private String orgcodecommissioner;
	private ims.vo.RefVoBean[] opcsprocedure;
	private ims.vo.RefVoBean readprocedure;
	private String locationclass;
	private String sitecodetreatment;
	private String gpcode;
	private String practicecode;
	private String prioritytype;
	private String servicetypereq;
	private String referralsource;
	private ims.framework.utils.beans.DateBean referralreceiveddate;
	private String referrercode;
	private String orgcodereferrer;
	private ims.framework.utils.beans.DateBean lastdnacanceldate;
	private String resourcegrpcode;
	private String procedurescheme;
	private String hrgdominantgrouping;
	private ims.framework.utils.beans.DateTimeBean cdsapplicabledate;
	private String cdssenderorgcode;
	private String resourcegpversion;
}
