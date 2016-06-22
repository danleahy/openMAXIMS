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

package ims.therapies.vo;

/**
 * Linked to therapies.Contact business object (ID: 1030100009).
 */
public class TherapiesContactVo extends ims.therapies.vo.ContactRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TherapiesContactVo()
	{
	}
	public TherapiesContactVo(Integer id, int version)
	{
		super(id, version);
	}
	public TherapiesContactVo(ims.therapies.vo.beans.TherapiesContactVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.contacthcp = bean.getContactHCP() == null ? null : bean.getContactHCP().buildVo();
		this.hcpdiscipline = bean.getHCPDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHCPDiscipline());
		this.contactdatetime = bean.getContactDateTime() == null ? null : bean.getContactDateTime().buildDateTime();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.recordinginfo = bean.getRecordingInfo() == null ? null : bean.getRecordingInfo().buildVo();
		this.contacttype = bean.getContactType() == null ? null : ims.therapies.vo.lookups.TherapiesContactType.buildLookup(bean.getContactType());
		this.referringproblem = bean.getReferringProblem() == null ? null : ims.therapies.vo.lookups.Caseload.buildLookup(bean.getReferringProblem());
		this.consentreason = bean.getConsentReason() == null ? null : ims.therapies.vo.lookups.ConsentReason.buildLookup(bean.getConsentReason());
		this.isfirstcontact = bean.getIsFirstContact();
		if(bean.getActivities() != null)
		{
			this.activities = new ims.oncology.vo.ContactTypesByDisciplineItemRefVoCollection();
			for(int activities_i = 0; activities_i < bean.getActivities().length; activities_i++)
			{
				this.activities.add(new ims.oncology.vo.ContactTypesByDisciplineItemRefVo(new Integer(bean.getActivities()[activities_i].getId()), bean.getActivities()[activities_i].getVersion()));
			}
		}
		this.patientconsenttotreatment = bean.getPatientConsentToTreatment();
		this.numofadditionalhcps = bean.getNumOfAdditionalHCPs();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
		this.noactivityundertaken = bean.getNoActivityUndertaken();
		this.additionalhcps = ims.therapies.vo.AdditionalHCPVoCollection.buildFromBeanCollection(bean.getAdditionalHCPs());
		this.caseload = bean.getCaseload() == null ? null : ims.therapies.vo.lookups.Caseload.buildLookup(bean.getCaseload());
		this.timerequired = bean.getTimeRequired();
		this.timespent = bean.getTimeSpent();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.TherapiesContactVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.contacthcp = bean.getContactHCP() == null ? null : bean.getContactHCP().buildVo(map);
		this.hcpdiscipline = bean.getHCPDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHCPDiscipline());
		this.contactdatetime = bean.getContactDateTime() == null ? null : bean.getContactDateTime().buildDateTime();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.recordinginfo = bean.getRecordingInfo() == null ? null : bean.getRecordingInfo().buildVo(map);
		this.contacttype = bean.getContactType() == null ? null : ims.therapies.vo.lookups.TherapiesContactType.buildLookup(bean.getContactType());
		this.referringproblem = bean.getReferringProblem() == null ? null : ims.therapies.vo.lookups.Caseload.buildLookup(bean.getReferringProblem());
		this.consentreason = bean.getConsentReason() == null ? null : ims.therapies.vo.lookups.ConsentReason.buildLookup(bean.getConsentReason());
		this.isfirstcontact = bean.getIsFirstContact();
		if(bean.getActivities() != null)
		{
			this.activities = new ims.oncology.vo.ContactTypesByDisciplineItemRefVoCollection();
			for(int activities_i = 0; activities_i < bean.getActivities().length; activities_i++)
			{
				this.activities.add(new ims.oncology.vo.ContactTypesByDisciplineItemRefVo(new Integer(bean.getActivities()[activities_i].getId()), bean.getActivities()[activities_i].getVersion()));
			}
		}
		this.patientconsenttotreatment = bean.getPatientConsentToTreatment();
		this.numofadditionalhcps = bean.getNumOfAdditionalHCPs();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
		this.noactivityundertaken = bean.getNoActivityUndertaken();
		this.additionalhcps = ims.therapies.vo.AdditionalHCPVoCollection.buildFromBeanCollection(bean.getAdditionalHCPs());
		this.caseload = bean.getCaseload() == null ? null : ims.therapies.vo.lookups.Caseload.buildLookup(bean.getCaseload());
		this.timerequired = bean.getTimeRequired();
		this.timespent = bean.getTimeSpent();
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.TherapiesContactVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.TherapiesContactVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.TherapiesContactVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CONTACTHCP"))
			return getContactHCP();
		if(fieldName.equals("HCPDISCIPLINE"))
			return getHCPDiscipline();
		if(fieldName.equals("CONTACTDATETIME"))
			return getContactDateTime();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("RECORDINGINFO"))
			return getRecordingInfo();
		if(fieldName.equals("CONTACTTYPE"))
			return getContactType();
		if(fieldName.equals("REFERRINGPROBLEM"))
			return getReferringProblem();
		if(fieldName.equals("CONSENTREASON"))
			return getConsentReason();
		if(fieldName.equals("ISFIRSTCONTACT"))
			return getIsFirstContact();
		if(fieldName.equals("ACTIVITIES"))
			return getActivities();
		if(fieldName.equals("PATIENTCONSENTTOTREATMENT"))
			return getPatientConsentToTreatment();
		if(fieldName.equals("NUMOFADDITIONALHCPS"))
			return getNumOfAdditionalHCPs();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		if(fieldName.equals("NOACTIVITYUNDERTAKEN"))
			return getNoActivityUndertaken();
		if(fieldName.equals("ADDITIONALHCPS"))
			return getAdditionalHCPs();
		if(fieldName.equals("CASELOAD"))
			return getCaseload();
		if(fieldName.equals("TIMEREQUIRED"))
			return getTimeRequired();
		if(fieldName.equals("TIMESPENT"))
			return getTimeSpent();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getContactHCPIsNotNull()
	{
		return this.contacthcp != null;
	}
	public ims.core.vo.HcpLiteVo getContactHCP()
	{
		return this.contacthcp;
	}
	public void setContactHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.contacthcp = value;
	}
	public boolean getHCPDisciplineIsNotNull()
	{
		return this.hcpdiscipline != null;
	}
	public ims.core.vo.lookups.HcpDisType getHCPDiscipline()
	{
		return this.hcpdiscipline;
	}
	public void setHCPDiscipline(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.hcpdiscipline = value;
	}
	public boolean getContactDateTimeIsNotNull()
	{
		return this.contactdatetime != null;
	}
	public ims.framework.utils.DateTime getContactDateTime()
	{
		return this.contactdatetime;
	}
	public void setContactDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.contactdatetime = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getRecordingInfoIsNotNull()
	{
		return this.recordinginfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getRecordingInfo()
	{
		return this.recordinginfo;
	}
	public void setRecordingInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.recordinginfo = value;
	}
	public boolean getContactTypeIsNotNull()
	{
		return this.contacttype != null;
	}
	public ims.therapies.vo.lookups.TherapiesContactType getContactType()
	{
		return this.contacttype;
	}
	public void setContactType(ims.therapies.vo.lookups.TherapiesContactType value)
	{
		this.isValidated = false;
		this.contacttype = value;
	}
	public boolean getReferringProblemIsNotNull()
	{
		return this.referringproblem != null;
	}
	public ims.therapies.vo.lookups.Caseload getReferringProblem()
	{
		return this.referringproblem;
	}
	public void setReferringProblem(ims.therapies.vo.lookups.Caseload value)
	{
		this.isValidated = false;
		this.referringproblem = value;
	}
	public boolean getConsentReasonIsNotNull()
	{
		return this.consentreason != null;
	}
	public ims.therapies.vo.lookups.ConsentReason getConsentReason()
	{
		return this.consentreason;
	}
	public void setConsentReason(ims.therapies.vo.lookups.ConsentReason value)
	{
		this.isValidated = false;
		this.consentreason = value;
	}
	public boolean getIsFirstContactIsNotNull()
	{
		return this.isfirstcontact != null;
	}
	public Boolean getIsFirstContact()
	{
		return this.isfirstcontact;
	}
	public void setIsFirstContact(Boolean value)
	{
		this.isValidated = false;
		this.isfirstcontact = value;
	}
	public boolean getActivitiesIsNotNull()
	{
		return this.activities != null;
	}
	public ims.oncology.vo.ContactTypesByDisciplineItemRefVoCollection getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.oncology.vo.ContactTypesByDisciplineItemRefVoCollection value)
	{
		this.isValidated = false;
		this.activities = value;
	}
	public boolean getPatientConsentToTreatmentIsNotNull()
	{
		return this.patientconsenttotreatment != null;
	}
	public Boolean getPatientConsentToTreatment()
	{
		return this.patientconsenttotreatment;
	}
	public void setPatientConsentToTreatment(Boolean value)
	{
		this.isValidated = false;
		this.patientconsenttotreatment = value;
	}
	public boolean getNumOfAdditionalHCPsIsNotNull()
	{
		return this.numofadditionalhcps != null;
	}
	public Integer getNumOfAdditionalHCPs()
	{
		return this.numofadditionalhcps;
	}
	public void setNumOfAdditionalHCPs(Integer value)
	{
		this.isValidated = false;
		this.numofadditionalhcps = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getNoActivityUndertakenIsNotNull()
	{
		return this.noactivityundertaken != null;
	}
	public Boolean getNoActivityUndertaken()
	{
		return this.noactivityundertaken;
	}
	public void setNoActivityUndertaken(Boolean value)
	{
		this.isValidated = false;
		this.noactivityundertaken = value;
	}
	public boolean getAdditionalHCPsIsNotNull()
	{
		return this.additionalhcps != null;
	}
	public ims.therapies.vo.AdditionalHCPVoCollection getAdditionalHCPs()
	{
		return this.additionalhcps;
	}
	public void setAdditionalHCPs(ims.therapies.vo.AdditionalHCPVoCollection value)
	{
		this.isValidated = false;
		this.additionalhcps = value;
	}
	public boolean getCaseloadIsNotNull()
	{
		return this.caseload != null;
	}
	public ims.therapies.vo.lookups.Caseload getCaseload()
	{
		return this.caseload;
	}
	public void setCaseload(ims.therapies.vo.lookups.Caseload value)
	{
		this.isValidated = false;
		this.caseload = value;
	}
	public boolean getTimeRequiredIsNotNull()
	{
		return this.timerequired != null;
	}
	public Integer getTimeRequired()
	{
		return this.timerequired;
	}
	public void setTimeRequired(Integer value)
	{
		this.isValidated = false;
		this.timerequired = value;
	}
	public boolean getTimeSpentIsNotNull()
	{
		return this.timespent != null;
	}
	public Integer getTimeSpent()
	{
		return this.timespent;
	}
	public void setTimeSpent(Integer value)
	{
		this.isValidated = false;
		this.timespent = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.recordinginfo != null)
		{
			if(!this.recordinginfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.additionalhcps != null)
		{
			if(!this.additionalhcps.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.contacthcp == null)
			listOfErrors.add("ContactHCP is mandatory");
		if(this.hcpdiscipline == null)
			listOfErrors.add("HCPDiscipline is mandatory");
		if(this.contactdatetime == null)
			listOfErrors.add("ContactDateTime is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.recordinginfo != null)
		{
			String[] listOfOtherErrors = this.recordinginfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.additionalhcps != null)
		{
			String[] listOfOtherErrors = this.additionalhcps.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		TherapiesContactVo clone = new TherapiesContactVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.contacthcp == null)
			clone.contacthcp = null;
		else
			clone.contacthcp = (ims.core.vo.HcpLiteVo)this.contacthcp.clone();
		if(this.hcpdiscipline == null)
			clone.hcpdiscipline = null;
		else
			clone.hcpdiscipline = (ims.core.vo.lookups.HcpDisType)this.hcpdiscipline.clone();
		if(this.contactdatetime == null)
			clone.contactdatetime = null;
		else
			clone.contactdatetime = (ims.framework.utils.DateTime)this.contactdatetime.clone();
		clone.episodeofcare = this.episodeofcare;
		if(this.recordinginfo == null)
			clone.recordinginfo = null;
		else
			clone.recordinginfo = (ims.core.vo.AuthoringInformationVo)this.recordinginfo.clone();
		if(this.contacttype == null)
			clone.contacttype = null;
		else
			clone.contacttype = (ims.therapies.vo.lookups.TherapiesContactType)this.contacttype.clone();
		if(this.referringproblem == null)
			clone.referringproblem = null;
		else
			clone.referringproblem = (ims.therapies.vo.lookups.Caseload)this.referringproblem.clone();
		if(this.consentreason == null)
			clone.consentreason = null;
		else
			clone.consentreason = (ims.therapies.vo.lookups.ConsentReason)this.consentreason.clone();
		clone.isfirstcontact = this.isfirstcontact;
		clone.activities = this.activities;
		clone.patientconsenttotreatment = this.patientconsenttotreatment;
		clone.numofadditionalhcps = this.numofadditionalhcps;
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		clone.noactivityundertaken = this.noactivityundertaken;
		if(this.additionalhcps == null)
			clone.additionalhcps = null;
		else
			clone.additionalhcps = (ims.therapies.vo.AdditionalHCPVoCollection)this.additionalhcps.clone();
		if(this.caseload == null)
			clone.caseload = null;
		else
			clone.caseload = (ims.therapies.vo.lookups.Caseload)this.caseload.clone();
		clone.timerequired = this.timerequired;
		clone.timespent = this.timespent;
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(TherapiesContactVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TherapiesContactVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TherapiesContactVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TherapiesContactVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.contacthcp != null)
			count++;
		if(this.hcpdiscipline != null)
			count++;
		if(this.contactdatetime != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.recordinginfo != null)
			count++;
		if(this.contacttype != null)
			count++;
		if(this.referringproblem != null)
			count++;
		if(this.consentreason != null)
			count++;
		if(this.isfirstcontact != null)
			count++;
		if(this.activities != null)
			count++;
		if(this.patientconsenttotreatment != null)
			count++;
		if(this.numofadditionalhcps != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.noactivityundertaken != null)
			count++;
		if(this.additionalhcps != null)
			count++;
		if(this.caseload != null)
			count++;
		if(this.timerequired != null)
			count++;
		if(this.timespent != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 20;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.HcpLiteVo contacthcp;
	protected ims.core.vo.lookups.HcpDisType hcpdiscipline;
	protected ims.framework.utils.DateTime contactdatetime;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.vo.AuthoringInformationVo recordinginfo;
	protected ims.therapies.vo.lookups.TherapiesContactType contacttype;
	protected ims.therapies.vo.lookups.Caseload referringproblem;
	protected ims.therapies.vo.lookups.ConsentReason consentreason;
	protected Boolean isfirstcontact;
	protected ims.oncology.vo.ContactTypesByDisciplineItemRefVoCollection activities;
	protected Boolean patientconsenttotreatment;
	protected Integer numofadditionalhcps;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	protected Boolean noactivityundertaken;
	protected ims.therapies.vo.AdditionalHCPVoCollection additionalhcps;
	protected ims.therapies.vo.lookups.Caseload caseload;
	protected Integer timerequired;
	protected Integer timespent;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
