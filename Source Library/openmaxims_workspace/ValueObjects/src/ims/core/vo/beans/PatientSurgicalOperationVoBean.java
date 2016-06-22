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

public class PatientSurgicalOperationVoBean extends ims.vo.ValueObjectBean
{
	public PatientSurgicalOperationVoBean()
	{
	}
	public PatientSurgicalOperationVoBean(ims.core.vo.PatientSurgicalOperationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.proceduredescription = vo.getProcedureDescription();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.infosource = vo.getInfoSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getInfoSource().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean();
		this.procdate = vo.getProcDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getProcDate().getBean();
		this.includeindischargeletter = vo.getIncludeInDischargeLetter();
		this.sitetext = vo.getSiteText();
		this.proclaterality = vo.getProcLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcLaterality().getBean();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.proctime = vo.getProcTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getProcTime().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.isprimary = vo.getIsPrimary();
		this.notes = vo.getNotes();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.procedureurgency = vo.getProcedureUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureUrgency().getBean();
		this.procedureoutcome = vo.getProcedureOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureOutcome().getBean();
		this.dateplanned = vo.getDatePlanned() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDatePlanned().getBean();
		this.plannedproc = vo.getPlannedProc() == null ? null : new ims.vo.RefVoBean(vo.getPlannedProc().getBoId(), vo.getPlannedProc().getBoVersion());
		this.procsite = vo.getProcSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcSite().getBean();
		// Interface field type not supported.
		this.procedureintent = vo.getProcedureIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureIntent().getBean();
		this.location = vo.getLocation();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.confirmedstatus = vo.getConfirmedStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getConfirmedStatus().getBean();
		this.confirmedby = vo.getConfirmedBy() == null ? null : (ims.core.vo.beans.HcpBean)vo.getConfirmedBy().getBean();
		this.confirmeddatetime = vo.getConfirmedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDateTime().getBean();
		this.excludefromothers = vo.getExcludeFromOthers();
		this.hcppresent = vo.getHCPPresent() == null ? null : vo.getHCPPresent().getBeanCollection();
		this.inserteddevices = vo.getInsertedDevices() == null ? null : vo.getInsertedDevices().getBeanCollection();
		this.removeddevices = vo.getRemovedDevices() == null ? null : vo.getRemovedDevices().getBeanCollection();
		this.assocclinicalnote = vo.getAssocClinicalNote();
		this.proclocation = vo.getProcLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcLocation().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
		this.ispmh = vo.getIsPMH();
		this.cancelleddate = vo.getCancelledDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCancelledDate().getBean();
		this.cancelledreason = vo.getCancelledReason();
		this.surgeonsgrade = vo.getSurgeonsGrade() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurgeonsGrade().getBean();
		this.procenddate = vo.getProcEndDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getProcEndDate().getBean();
		this.procendtime = vo.getProcEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getProcEndTime().getBean();
		this.signifproc = vo.getSignifProc();
		this.intraoperativerecord = vo.getIntraOperativeRecord() == null ? null : (ims.clinical.vo.beans.IntraOperativeCareRecordMinVoBean)vo.getIntraOperativeRecord().getBean();
		this.assistants = vo.getAssistants() == null ? null : vo.getAssistants().getBeanCollection();
		this.nurse = vo.getNurse() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getNurse().getBean();
		this.anaesthetist = vo.getAnaesthetist() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAnaesthetist().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientSurgicalOperationVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.proceduredescription = vo.getProcedureDescription();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.infosource = vo.getInfoSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getInfoSource().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean(map);
		this.procdate = vo.getProcDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getProcDate().getBean();
		this.includeindischargeletter = vo.getIncludeInDischargeLetter();
		this.sitetext = vo.getSiteText();
		this.proclaterality = vo.getProcLaterality() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcLaterality().getBean();
		this.procedurestatus = vo.getProcedureStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureStatus().getBean();
		this.proctime = vo.getProcTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getProcTime().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.isprimary = vo.getIsPrimary();
		this.notes = vo.getNotes();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.procedureurgency = vo.getProcedureUrgency() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureUrgency().getBean();
		this.procedureoutcome = vo.getProcedureOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureOutcome().getBean();
		this.dateplanned = vo.getDatePlanned() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDatePlanned().getBean();
		this.plannedproc = vo.getPlannedProc() == null ? null : new ims.vo.RefVoBean(vo.getPlannedProc().getBoId(), vo.getPlannedProc().getBoVersion());
		this.procsite = vo.getProcSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcSite().getBean();
		// Interface field type not supported.
		this.procedureintent = vo.getProcedureIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcedureIntent().getBean();
		this.location = vo.getLocation();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
		this.confirmedstatus = vo.getConfirmedStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getConfirmedStatus().getBean();
		this.confirmedby = vo.getConfirmedBy() == null ? null : (ims.core.vo.beans.HcpBean)vo.getConfirmedBy().getBean(map);
		this.confirmeddatetime = vo.getConfirmedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConfirmedDateTime().getBean();
		this.excludefromothers = vo.getExcludeFromOthers();
		this.hcppresent = vo.getHCPPresent() == null ? null : vo.getHCPPresent().getBeanCollection();
		this.inserteddevices = vo.getInsertedDevices() == null ? null : vo.getInsertedDevices().getBeanCollection();
		this.removeddevices = vo.getRemovedDevices() == null ? null : vo.getRemovedDevices().getBeanCollection();
		this.assocclinicalnote = vo.getAssocClinicalNote();
		this.proclocation = vo.getProcLocation() == null ? null : (ims.vo.LookupInstanceBean)vo.getProcLocation().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
		this.ispmh = vo.getIsPMH();
		this.cancelleddate = vo.getCancelledDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getCancelledDate().getBean();
		this.cancelledreason = vo.getCancelledReason();
		this.surgeonsgrade = vo.getSurgeonsGrade() == null ? null : (ims.vo.LookupInstanceBean)vo.getSurgeonsGrade().getBean();
		this.procenddate = vo.getProcEndDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getProcEndDate().getBean();
		this.procendtime = vo.getProcEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getProcEndTime().getBean();
		this.signifproc = vo.getSignifProc();
		this.intraoperativerecord = vo.getIntraOperativeRecord() == null ? null : (ims.clinical.vo.beans.IntraOperativeCareRecordMinVoBean)vo.getIntraOperativeRecord().getBean(map);
		this.assistants = vo.getAssistants() == null ? null : vo.getAssistants().getBeanCollection();
		this.nurse = vo.getNurse() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getNurse().getBean(map);
		this.anaesthetist = vo.getAnaesthetist() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAnaesthetist().getBean(map);
	}

	public ims.core.vo.PatientSurgicalOperationVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientSurgicalOperationVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientSurgicalOperationVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientSurgicalOperationVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientSurgicalOperationVo();
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
	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public String getProcedureDescription()
	{
		return this.proceduredescription;
	}
	public void setProcedureDescription(String value)
	{
		this.proceduredescription = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.vo.LookupInstanceBean getInfoSource()
	{
		return this.infosource;
	}
	public void setInfoSource(ims.vo.LookupInstanceBean value)
	{
		this.infosource = value;
	}
	public ims.core.vo.beans.CareContextLiteVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextLiteVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.PartialDateBean getProcDate()
	{
		return this.procdate;
	}
	public void setProcDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.procdate = value;
	}
	public Boolean getIncludeInDischargeLetter()
	{
		return this.includeindischargeletter;
	}
	public void setIncludeInDischargeLetter(Boolean value)
	{
		this.includeindischargeletter = value;
	}
	public String getSiteText()
	{
		return this.sitetext;
	}
	public void setSiteText(String value)
	{
		this.sitetext = value;
	}
	public ims.vo.LookupInstanceBean getProcLaterality()
	{
		return this.proclaterality;
	}
	public void setProcLaterality(ims.vo.LookupInstanceBean value)
	{
		this.proclaterality = value;
	}
	public ims.vo.LookupInstanceBean getProcedureStatus()
	{
		return this.procedurestatus;
	}
	public void setProcedureStatus(ims.vo.LookupInstanceBean value)
	{
		this.procedurestatus = value;
	}
	public ims.framework.utils.beans.TimeBean getProcTime()
	{
		return this.proctime;
	}
	public void setProcTime(ims.framework.utils.beans.TimeBean value)
	{
		this.proctime = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public Boolean getIsPrimary()
	{
		return this.isprimary;
	}
	public void setIsPrimary(Boolean value)
	{
		this.isprimary = value;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public void setNotes(String value)
	{
		this.notes = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.vo.LookupInstanceBean getProcedureUrgency()
	{
		return this.procedureurgency;
	}
	public void setProcedureUrgency(ims.vo.LookupInstanceBean value)
	{
		this.procedureurgency = value;
	}
	public ims.vo.LookupInstanceBean getProcedureOutcome()
	{
		return this.procedureoutcome;
	}
	public void setProcedureOutcome(ims.vo.LookupInstanceBean value)
	{
		this.procedureoutcome = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDatePlanned()
	{
		return this.dateplanned;
	}
	public void setDatePlanned(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dateplanned = value;
	}
	public ims.vo.RefVoBean getPlannedProc()
	{
		return this.plannedproc;
	}
	public void setPlannedProc(ims.vo.RefVoBean value)
	{
		this.plannedproc = value;
	}
	public ims.vo.LookupInstanceBean getProcSite()
	{
		return this.procsite;
	}
	public void setProcSite(ims.vo.LookupInstanceBean value)
	{
		this.procsite = value;
	}
	public ims.vo.LookupInstanceBean getProcedureIntent()
	{
		return this.procedureintent;
	}
	public void setProcedureIntent(ims.vo.LookupInstanceBean value)
	{
		this.procedureintent = value;
	}
	public String getLocation()
	{
		return this.location;
	}
	public void setLocation(String value)
	{
		this.location = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}
	public ims.vo.LookupInstanceBean getConfirmedStatus()
	{
		return this.confirmedstatus;
	}
	public void setConfirmedStatus(ims.vo.LookupInstanceBean value)
	{
		this.confirmedstatus = value;
	}
	public ims.core.vo.beans.HcpBean getConfirmedBy()
	{
		return this.confirmedby;
	}
	public void setConfirmedBy(ims.core.vo.beans.HcpBean value)
	{
		this.confirmedby = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConfirmedDateTime()
	{
		return this.confirmeddatetime;
	}
	public void setConfirmedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.confirmeddatetime = value;
	}
	public Boolean getExcludeFromOthers()
	{
		return this.excludefromothers;
	}
	public void setExcludeFromOthers(Boolean value)
	{
		this.excludefromothers = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean[] getHCPPresent()
	{
		return this.hcppresent;
	}
	public void setHCPPresent(ims.core.vo.beans.HcpLiteVoBean[] value)
	{
		this.hcppresent = value;
	}
	public ims.core.vo.beans.PatientCharacteristicVoBean[] getInsertedDevices()
	{
		return this.inserteddevices;
	}
	public void setInsertedDevices(ims.core.vo.beans.PatientCharacteristicVoBean[] value)
	{
		this.inserteddevices = value;
	}
	public ims.core.vo.beans.PatientCharacteristicVoBean[] getRemovedDevices()
	{
		return this.removeddevices;
	}
	public void setRemovedDevices(ims.core.vo.beans.PatientCharacteristicVoBean[] value)
	{
		this.removeddevices = value;
	}
	public String getAssocClinicalNote()
	{
		return this.assocclinicalnote;
	}
	public void setAssocClinicalNote(String value)
	{
		this.assocclinicalnote = value;
	}
	public ims.vo.LookupInstanceBean getProcLocation()
	{
		return this.proclocation;
	}
	public void setProcLocation(ims.vo.LookupInstanceBean value)
	{
		this.proclocation = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}
	public Boolean getIsPMH()
	{
		return this.ispmh;
	}
	public void setIsPMH(Boolean value)
	{
		this.ispmh = value;
	}
	public ims.framework.utils.beans.DateBean getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.beans.DateBean value)
	{
		this.cancelleddate = value;
	}
	public String getCancelledReason()
	{
		return this.cancelledreason;
	}
	public void setCancelledReason(String value)
	{
		this.cancelledreason = value;
	}
	public ims.vo.LookupInstanceBean getSurgeonsGrade()
	{
		return this.surgeonsgrade;
	}
	public void setSurgeonsGrade(ims.vo.LookupInstanceBean value)
	{
		this.surgeonsgrade = value;
	}
	public ims.framework.utils.beans.PartialDateBean getProcEndDate()
	{
		return this.procenddate;
	}
	public void setProcEndDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.procenddate = value;
	}
	public ims.framework.utils.beans.TimeBean getProcEndTime()
	{
		return this.procendtime;
	}
	public void setProcEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.procendtime = value;
	}
	public Boolean getSignifProc()
	{
		return this.signifproc;
	}
	public void setSignifProc(Boolean value)
	{
		this.signifproc = value;
	}
	public ims.clinical.vo.beans.IntraOperativeCareRecordMinVoBean getIntraOperativeRecord()
	{
		return this.intraoperativerecord;
	}
	public void setIntraOperativeRecord(ims.clinical.vo.beans.IntraOperativeCareRecordMinVoBean value)
	{
		this.intraoperativerecord = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean[] getAssistants()
	{
		return this.assistants;
	}
	public void setAssistants(ims.core.vo.beans.HcpLiteVoBean[] value)
	{
		this.assistants = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getNurse()
	{
		return this.nurse;
	}
	public void setNurse(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.nurse = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAnaesthetist()
	{
		return this.anaesthetist;
	}
	public void setAnaesthetist(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.anaesthetist = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private String proceduredescription;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.vo.LookupInstanceBean infosource;
	private ims.core.vo.beans.CareContextLiteVoBean carecontext;
	private ims.framework.utils.beans.PartialDateBean procdate;
	private Boolean includeindischargeletter;
	private String sitetext;
	private ims.vo.LookupInstanceBean proclaterality;
	private ims.vo.LookupInstanceBean procedurestatus;
	private ims.framework.utils.beans.TimeBean proctime;
	private ims.vo.RefVoBean episodeofcare;
	private Boolean isprimary;
	private String notes;
	private ims.vo.SysInfoBean sysinfo;
	private ims.vo.LookupInstanceBean procedureurgency;
	private ims.vo.LookupInstanceBean procedureoutcome;
	private ims.framework.utils.beans.PartialDateBean dateplanned;
	private ims.vo.RefVoBean plannedproc;
	private ims.vo.LookupInstanceBean procsite;
	private ims.vo.LookupInstanceBean procedureintent;
	private String location;
	private ims.vo.LookupInstanceBean specialty;
	private ims.vo.LookupInstanceBean confirmedstatus;
	private ims.core.vo.beans.HcpBean confirmedby;
	private ims.framework.utils.beans.DateTimeBean confirmeddatetime;
	private Boolean excludefromothers;
	private ims.core.vo.beans.HcpLiteVoBean[] hcppresent;
	private ims.core.vo.beans.PatientCharacteristicVoBean[] inserteddevices;
	private ims.core.vo.beans.PatientCharacteristicVoBean[] removeddevices;
	private String assocclinicalnote;
	private ims.vo.LookupInstanceBean proclocation;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
	private Boolean ispmh;
	private ims.framework.utils.beans.DateBean cancelleddate;
	private String cancelledreason;
	private ims.vo.LookupInstanceBean surgeonsgrade;
	private ims.framework.utils.beans.PartialDateBean procenddate;
	private ims.framework.utils.beans.TimeBean procendtime;
	private Boolean signifproc;
	private ims.clinical.vo.beans.IntraOperativeCareRecordMinVoBean intraoperativerecord;
	private ims.core.vo.beans.HcpLiteVoBean[] assistants;
	private ims.core.vo.beans.HcpLiteVoBean nurse;
	private ims.core.vo.beans.HcpLiteVoBean anaesthetist;
}
