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

public class PatientShortBean extends ims.vo.ValueObjectBean
{
	public PatientShortBean()
	{
	}
	public PatientShortBean(ims.core.vo.PatientShort vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean();
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.age = vo.getAge();
		this.agetext = vo.getAgeText();
		this.address = vo.getAddress() == null ? null : (ims.core.vo.beans.PersonAddressBean)vo.getAddress().getBean();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.dod = vo.getDod() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDod().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean();
		this.religion = vo.getReligion() == null ? null : (ims.vo.LookupInstanceBean)vo.getReligion().getBean();
		this.hasallergies = vo.getHasAllergies();
		this.hasalerts = vo.getHasAlerts();
		this.identifiers = vo.getIdentifiers() == null ? null : vo.getIdentifiers().getBeanCollection();
		this.isactive = vo.getIsActive();
		this.associatedpatient = vo.getAssociatedPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getAssociatedPatient().getBean();
		this.commchannels = vo.getCommChannels() == null ? null : vo.getCommChannels().getBeanCollection();
		this.ethnicorigin = vo.getEthnicOrigin() == null ? null : (ims.vo.LookupInstanceBean)vo.getEthnicOrigin().getBean();
		this.maritalstatus = vo.getMaritalStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMaritalStatus().getBean();
		this.scn = vo.getSCN();
		this.sourceofinformation = vo.getSourceOfInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfInformation().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.hasactivealerts = vo.getHasActiveAlerts();
		this.timeofdeath = vo.getTimeOfDeath() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOfDeath().getBean();
		this.isquickregistrationpatient = vo.getIsQuickRegistrationPatient();
		this.ocsnotification = vo.getOCSNotification() == null ? null : (ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean)vo.getOCSNotification().getBean();
		this.currentresponsibleconsultant = vo.getCurrentResponsibleConsultant() == null ? null : new ims.vo.RefVoBean(vo.getCurrentResponsibleConsultant().getBoId(), vo.getCurrentResponsibleConsultant().getBoVersion());
		this.dementiabreachdatetime = vo.getDementiaBreachDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDementiaBreachDateTime().getBean();
		this.dementiaworkliststatus = vo.getDementiaWorklistStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDementiaWorklistStatus().getBean();
		this.mrnstatus = vo.getMRNStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMRNStatus().getBean();
		this.hasscannedcasenotefolders = vo.getHasScannedCaseNoteFolders();
		this.isconfidential = vo.getIsConfidential();
		this.timeofbirth = vo.getTimeOfBirth() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOfBirth().getBean();
		this.isselfadmitpatient = vo.getIsSelfAdmitPatient();
		this.patientcategory = vo.getPatientCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientCategory().getBean();
		this.pdspatientgp = vo.getPDSPatientGP() == null ? null : (ims.core.vo.beans.PDSPatientGPVoBean)vo.getPDSPatientGP().getBean();
		this.hasalertcategory1 = vo.getHasAlertCategory1();
		this.hasalertcategory2 = vo.getHasAlertCategory2();
		this.hasalertcategory3 = vo.getHasAlertCategory3();
		this.hasalertcategory4 = vo.getHasAlertCategory4();
		this.hasalertcategoryother = vo.getHasAlertCategoryOther();
		this.futureapptscancelonmarkdeceasedanswer = vo.getFutureApptsCancelOnMarkDeceasedAnswer();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientShort vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getName().getBean(map);
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.age = vo.getAge();
		this.agetext = vo.getAgeText();
		this.address = vo.getAddress() == null ? null : (ims.core.vo.beans.PersonAddressBean)vo.getAddress().getBean(map);
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.dod = vo.getDod() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDod().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getWard().getBean(map);
		this.religion = vo.getReligion() == null ? null : (ims.vo.LookupInstanceBean)vo.getReligion().getBean();
		this.hasallergies = vo.getHasAllergies();
		this.hasalerts = vo.getHasAlerts();
		this.identifiers = vo.getIdentifiers() == null ? null : vo.getIdentifiers().getBeanCollection();
		this.isactive = vo.getIsActive();
		this.associatedpatient = vo.getAssociatedPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getAssociatedPatient().getBean(map);
		this.commchannels = vo.getCommChannels() == null ? null : vo.getCommChannels().getBeanCollection();
		this.ethnicorigin = vo.getEthnicOrigin() == null ? null : (ims.vo.LookupInstanceBean)vo.getEthnicOrigin().getBean();
		this.maritalstatus = vo.getMaritalStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMaritalStatus().getBean();
		this.scn = vo.getSCN();
		this.sourceofinformation = vo.getSourceOfInformation() == null ? null : (ims.vo.LookupInstanceBean)vo.getSourceOfInformation().getBean();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.hasactivealerts = vo.getHasActiveAlerts();
		this.timeofdeath = vo.getTimeOfDeath() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOfDeath().getBean();
		this.isquickregistrationpatient = vo.getIsQuickRegistrationPatient();
		this.ocsnotification = vo.getOCSNotification() == null ? null : (ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean)vo.getOCSNotification().getBean(map);
		this.currentresponsibleconsultant = vo.getCurrentResponsibleConsultant() == null ? null : new ims.vo.RefVoBean(vo.getCurrentResponsibleConsultant().getBoId(), vo.getCurrentResponsibleConsultant().getBoVersion());
		this.dementiabreachdatetime = vo.getDementiaBreachDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDementiaBreachDateTime().getBean();
		this.dementiaworkliststatus = vo.getDementiaWorklistStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getDementiaWorklistStatus().getBean();
		this.mrnstatus = vo.getMRNStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getMRNStatus().getBean();
		this.hasscannedcasenotefolders = vo.getHasScannedCaseNoteFolders();
		this.isconfidential = vo.getIsConfidential();
		this.timeofbirth = vo.getTimeOfBirth() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeOfBirth().getBean();
		this.isselfadmitpatient = vo.getIsSelfAdmitPatient();
		this.patientcategory = vo.getPatientCategory() == null ? null : (ims.vo.LookupInstanceBean)vo.getPatientCategory().getBean();
		this.pdspatientgp = vo.getPDSPatientGP() == null ? null : (ims.core.vo.beans.PDSPatientGPVoBean)vo.getPDSPatientGP().getBean(map);
		this.hasalertcategory1 = vo.getHasAlertCategory1();
		this.hasalertcategory2 = vo.getHasAlertCategory2();
		this.hasalertcategory3 = vo.getHasAlertCategory3();
		this.hasalertcategory4 = vo.getHasAlertCategory4();
		this.hasalertcategoryother = vo.getHasAlertCategoryOther();
		this.futureapptscancelonmarkdeceasedanswer = vo.getFutureApptsCancelOnMarkDeceasedAnswer();
	}

	public ims.core.vo.PatientShort buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientShort buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientShort vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientShort)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientShort();
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
	public ims.core.vo.beans.PersonNameBean getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.beans.PersonNameBean value)
	{
		this.name = value;
	}
	public ims.vo.LookupInstanceBean getSex()
	{
		return this.sex;
	}
	public void setSex(ims.vo.LookupInstanceBean value)
	{
		this.sex = value;
	}
	public Integer getAge()
	{
		return this.age;
	}
	public void setAge(Integer value)
	{
		this.age = value;
	}
	public String getAgeText()
	{
		return this.agetext;
	}
	public void setAgeText(String value)
	{
		this.agetext = value;
	}
	public ims.core.vo.beans.PersonAddressBean getAddress()
	{
		return this.address;
	}
	public void setAddress(ims.core.vo.beans.PersonAddressBean value)
	{
		this.address = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dob = value;
	}
	public ims.framework.utils.beans.DateBean getDod()
	{
		return this.dod;
	}
	public void setDod(ims.framework.utils.beans.DateBean value)
	{
		this.dod = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.ward = value;
	}
	public ims.vo.LookupInstanceBean getReligion()
	{
		return this.religion;
	}
	public void setReligion(ims.vo.LookupInstanceBean value)
	{
		this.religion = value;
	}
	public Boolean getHasAllergies()
	{
		return this.hasallergies;
	}
	public void setHasAllergies(Boolean value)
	{
		this.hasallergies = value;
	}
	public Boolean getHasAlerts()
	{
		return this.hasalerts;
	}
	public void setHasAlerts(Boolean value)
	{
		this.hasalerts = value;
	}
	public ims.core.vo.beans.PatientIdBean[] getIdentifiers()
	{
		return this.identifiers;
	}
	public void setIdentifiers(ims.core.vo.beans.PatientIdBean[] value)
	{
		this.identifiers = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.PatientShortBean getAssociatedPatient()
	{
		return this.associatedpatient;
	}
	public void setAssociatedPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.associatedpatient = value;
	}
	public ims.core.vo.beans.CommChannelVoBean[] getCommChannels()
	{
		return this.commchannels;
	}
	public void setCommChannels(ims.core.vo.beans.CommChannelVoBean[] value)
	{
		this.commchannels = value;
	}
	public ims.vo.LookupInstanceBean getEthnicOrigin()
	{
		return this.ethnicorigin;
	}
	public void setEthnicOrigin(ims.vo.LookupInstanceBean value)
	{
		this.ethnicorigin = value;
	}
	public ims.vo.LookupInstanceBean getMaritalStatus()
	{
		return this.maritalstatus;
	}
	public void setMaritalStatus(ims.vo.LookupInstanceBean value)
	{
		this.maritalstatus = value;
	}
	public Integer getSCN()
	{
		return this.scn;
	}
	public void setSCN(Integer value)
	{
		this.scn = value;
	}
	public ims.vo.LookupInstanceBean getSourceOfInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceOfInformation(ims.vo.LookupInstanceBean value)
	{
		this.sourceofinformation = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public Boolean getHasActiveAlerts()
	{
		return this.hasactivealerts;
	}
	public void setHasActiveAlerts(Boolean value)
	{
		this.hasactivealerts = value;
	}
	public ims.framework.utils.beans.TimeBean getTimeOfDeath()
	{
		return this.timeofdeath;
	}
	public void setTimeOfDeath(ims.framework.utils.beans.TimeBean value)
	{
		this.timeofdeath = value;
	}
	public Boolean getIsQuickRegistrationPatient()
	{
		return this.isquickregistrationpatient;
	}
	public void setIsQuickRegistrationPatient(Boolean value)
	{
		this.isquickregistrationpatient = value;
	}
	public ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean getOCSNotification()
	{
		return this.ocsnotification;
	}
	public void setOCSNotification(ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean value)
	{
		this.ocsnotification = value;
	}
	public ims.vo.RefVoBean getCurrentResponsibleConsultant()
	{
		return this.currentresponsibleconsultant;
	}
	public void setCurrentResponsibleConsultant(ims.vo.RefVoBean value)
	{
		this.currentresponsibleconsultant = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDementiaBreachDateTime()
	{
		return this.dementiabreachdatetime;
	}
	public void setDementiaBreachDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dementiabreachdatetime = value;
	}
	public ims.vo.LookupInstanceBean getDementiaWorklistStatus()
	{
		return this.dementiaworkliststatus;
	}
	public void setDementiaWorklistStatus(ims.vo.LookupInstanceBean value)
	{
		this.dementiaworkliststatus = value;
	}
	public ims.vo.LookupInstanceBean getMRNStatus()
	{
		return this.mrnstatus;
	}
	public void setMRNStatus(ims.vo.LookupInstanceBean value)
	{
		this.mrnstatus = value;
	}
	public Boolean getHasScannedCaseNoteFolders()
	{
		return this.hasscannedcasenotefolders;
	}
	public void setHasScannedCaseNoteFolders(Boolean value)
	{
		this.hasscannedcasenotefolders = value;
	}
	public Boolean getIsConfidential()
	{
		return this.isconfidential;
	}
	public void setIsConfidential(Boolean value)
	{
		this.isconfidential = value;
	}
	public ims.framework.utils.beans.TimeBean getTimeOfBirth()
	{
		return this.timeofbirth;
	}
	public void setTimeOfBirth(ims.framework.utils.beans.TimeBean value)
	{
		this.timeofbirth = value;
	}
	public Boolean getIsSelfAdmitPatient()
	{
		return this.isselfadmitpatient;
	}
	public void setIsSelfAdmitPatient(Boolean value)
	{
		this.isselfadmitpatient = value;
	}
	public ims.vo.LookupInstanceBean getPatientCategory()
	{
		return this.patientcategory;
	}
	public void setPatientCategory(ims.vo.LookupInstanceBean value)
	{
		this.patientcategory = value;
	}
	public ims.core.vo.beans.PDSPatientGPVoBean getPDSPatientGP()
	{
		return this.pdspatientgp;
	}
	public void setPDSPatientGP(ims.core.vo.beans.PDSPatientGPVoBean value)
	{
		this.pdspatientgp = value;
	}
	public Boolean getHasAlertCategory1()
	{
		return this.hasalertcategory1;
	}
	public void setHasAlertCategory1(Boolean value)
	{
		this.hasalertcategory1 = value;
	}
	public Boolean getHasAlertCategory2()
	{
		return this.hasalertcategory2;
	}
	public void setHasAlertCategory2(Boolean value)
	{
		this.hasalertcategory2 = value;
	}
	public Boolean getHasAlertCategory3()
	{
		return this.hasalertcategory3;
	}
	public void setHasAlertCategory3(Boolean value)
	{
		this.hasalertcategory3 = value;
	}
	public Boolean getHasAlertCategory4()
	{
		return this.hasalertcategory4;
	}
	public void setHasAlertCategory4(Boolean value)
	{
		this.hasalertcategory4 = value;
	}
	public Boolean getHasAlertCategoryOther()
	{
		return this.hasalertcategoryother;
	}
	public void setHasAlertCategoryOther(Boolean value)
	{
		this.hasalertcategoryother = value;
	}
	public Boolean getFutureApptsCancelOnMarkDeceasedAnswer()
	{
		return this.futureapptscancelonmarkdeceasedanswer;
	}
	public void setFutureApptsCancelOnMarkDeceasedAnswer(Boolean value)
	{
		this.futureapptscancelonmarkdeceasedanswer = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.PersonNameBean name;
	private ims.vo.LookupInstanceBean sex;
	private Integer age;
	private String agetext;
	private ims.core.vo.beans.PersonAddressBean address;
	private ims.framework.utils.beans.PartialDateBean dob;
	private ims.framework.utils.beans.DateBean dod;
	private ims.core.vo.beans.LocationLiteVoBean ward;
	private ims.vo.LookupInstanceBean religion;
	private Boolean hasallergies;
	private Boolean hasalerts;
	private ims.core.vo.beans.PatientIdBean[] identifiers;
	private Boolean isactive;
	private ims.core.vo.beans.PatientShortBean associatedpatient;
	private ims.core.vo.beans.CommChannelVoBean[] commchannels;
	private ims.vo.LookupInstanceBean ethnicorigin;
	private ims.vo.LookupInstanceBean maritalstatus;
	private Integer scn;
	private ims.vo.LookupInstanceBean sourceofinformation;
	private ims.vo.SysInfoBean sysinfo;
	private Boolean hasactivealerts;
	private ims.framework.utils.beans.TimeBean timeofdeath;
	private Boolean isquickregistrationpatient;
	private ims.core.vo.beans.PatientNotificationsFillerOnlyVoBean ocsnotification;
	private ims.vo.RefVoBean currentresponsibleconsultant;
	private ims.framework.utils.beans.DateTimeBean dementiabreachdatetime;
	private ims.vo.LookupInstanceBean dementiaworkliststatus;
	private ims.vo.LookupInstanceBean mrnstatus;
	private Boolean hasscannedcasenotefolders;
	private Boolean isconfidential;
	private ims.framework.utils.beans.TimeBean timeofbirth;
	private Boolean isselfadmitpatient;
	private ims.vo.LookupInstanceBean patientcategory;
	private ims.core.vo.beans.PDSPatientGPVoBean pdspatientgp;
	private Boolean hasalertcategory1;
	private Boolean hasalertcategory2;
	private Boolean hasalertcategory3;
	private Boolean hasalertcategory4;
	private Boolean hasalertcategoryother;
	private Boolean futureapptscancelonmarkdeceasedanswer;
}
