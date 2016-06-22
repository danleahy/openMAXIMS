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

package ims.eas.vo;

/**
 * Linked to EAS.ElectronicActionSheet business object (ID: 1113100000).
 */
public class EasWorklistVo extends ims.eas.vo.ElectronicActionSheetRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EasWorklistVo()
	{
	}
	public EasWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public EasWorklistVo(ims.eas.vo.beans.EasWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.easstatus = bean.getEasStatus() == null ? null : bean.getEasStatus().buildVo();
		this.responsiblehcp = bean.getResponsibleHcp() == null ? null : bean.getResponsibleHcp().buildVo();
		this.tpcreated = bean.getTPCreated();
		this.actionrequired = bean.getActionRequired();
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo();
		this.dateseen = bean.getDateSeen() == null ? null : bean.getDateSeen().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.intent = bean.getIntent() == null ? null : ims.ccosched.vo.lookups.TreatmentIntent.buildLookup(bean.getIntent());
		this.priority = bean.getPriority() == null ? null : ims.ccosched.vo.lookups.Priority.buildLookup(bean.getPriority());
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.ccosched.vo.lookups.Status.buildLookup(bean.getPatientStatus());
		this.removedstat = bean.getRemovedStat();
		this.delayed = bean.getDelayed();
		this.primarytumour = bean.getPrimaryTumour() == null ? null : bean.getPrimaryTumour().buildVo();
		this.treatmentsite = bean.getTreatmentSite() == null ? null : bean.getTreatmentSite().buildVo();
		this.statushistory = ims.eas.vo.EasStatusLiteVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.removalreason = bean.getRemovalReason() == null ? null : ims.eas.vo.lookups.RemovalReason.buildLookup(bean.getRemovalReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.EasWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.easstatus = bean.getEasStatus() == null ? null : bean.getEasStatus().buildVo(map);
		this.responsiblehcp = bean.getResponsibleHcp() == null ? null : bean.getResponsibleHcp().buildVo(map);
		this.tpcreated = bean.getTPCreated();
		this.actionrequired = bean.getActionRequired();
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo(map);
		this.dateseen = bean.getDateSeen() == null ? null : bean.getDateSeen().buildDate();
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.intent = bean.getIntent() == null ? null : ims.ccosched.vo.lookups.TreatmentIntent.buildLookup(bean.getIntent());
		this.priority = bean.getPriority() == null ? null : ims.ccosched.vo.lookups.Priority.buildLookup(bean.getPriority());
		this.patientstatus = bean.getPatientStatus() == null ? null : ims.ccosched.vo.lookups.Status.buildLookup(bean.getPatientStatus());
		this.removedstat = bean.getRemovedStat();
		this.delayed = bean.getDelayed();
		this.primarytumour = bean.getPrimaryTumour() == null ? null : bean.getPrimaryTumour().buildVo(map);
		this.treatmentsite = bean.getTreatmentSite() == null ? null : bean.getTreatmentSite().buildVo(map);
		this.statushistory = ims.eas.vo.EasStatusLiteVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.removalreason = bean.getRemovalReason() == null ? null : ims.eas.vo.lookups.RemovalReason.buildLookup(bean.getRemovalReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.EasWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.EasWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.EasWorklistVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EASSTATUS"))
			return getEasStatus();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHcp();
		if(fieldName.equals("TPCREATED"))
			return getTPCreated();
		if(fieldName.equals("ACTIONREQUIRED"))
			return getActionRequired();
		if(fieldName.equals("SEENBY"))
			return getSeenBy();
		if(fieldName.equals("DATESEEN"))
			return getDateSeen();
		if(fieldName.equals("DATEDECISIONTOTREAT"))
			return getDateDecisionToTreat();
		if(fieldName.equals("INTENT"))
			return getIntent();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("PATIENTSTATUS"))
			return getPatientStatus();
		if(fieldName.equals("REMOVEDSTAT"))
			return getRemovedStat();
		if(fieldName.equals("DELAYED"))
			return getDelayed();
		if(fieldName.equals("PRIMARYTUMOUR"))
			return getPrimaryTumour();
		if(fieldName.equals("TREATMENTSITE"))
			return getTreatmentSite();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("REMOVALREASON"))
			return getRemovalReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getEasStatusIsNotNull()
	{
		return this.easstatus != null;
	}
	public ims.eas.vo.EasStatusLiteVo getEasStatus()
	{
		return this.easstatus;
	}
	public void setEasStatus(ims.eas.vo.EasStatusLiteVo value)
	{
		this.isValidated = false;
		this.easstatus = value;
	}
	public boolean getResponsibleHcpIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHcp()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHcp(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getTPCreatedIsNotNull()
	{
		return this.tpcreated != null;
	}
	public Boolean getTPCreated()
	{
		return this.tpcreated;
	}
	public void setTPCreated(Boolean value)
	{
		this.isValidated = false;
		this.tpcreated = value;
	}
	public boolean getActionRequiredIsNotNull()
	{
		return this.actionrequired != null;
	}
	public Boolean getActionRequired()
	{
		return this.actionrequired;
	}
	public void setActionRequired(Boolean value)
	{
		this.isValidated = false;
		this.actionrequired = value;
	}
	public boolean getSeenByIsNotNull()
	{
		return this.seenby != null;
	}
	public ims.core.vo.HcpLiteVo getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.seenby = value;
	}
	public boolean getDateSeenIsNotNull()
	{
		return this.dateseen != null;
	}
	public ims.framework.utils.Date getDateSeen()
	{
		return this.dateseen;
	}
	public void setDateSeen(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateseen = value;
	}
	public boolean getDateDecisionToTreatIsNotNull()
	{
		return this.datedecisiontotreat != null;
	}
	public ims.framework.utils.Date getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datedecisiontotreat = value;
	}
	public boolean getIntentIsNotNull()
	{
		return this.intent != null;
	}
	public ims.ccosched.vo.lookups.TreatmentIntent getIntent()
	{
		return this.intent;
	}
	public void setIntent(ims.ccosched.vo.lookups.TreatmentIntent value)
	{
		this.isValidated = false;
		this.intent = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.ccosched.vo.lookups.Priority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.ccosched.vo.lookups.Priority value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getPatientStatusIsNotNull()
	{
		return this.patientstatus != null;
	}
	public ims.ccosched.vo.lookups.Status getPatientStatus()
	{
		return this.patientstatus;
	}
	public void setPatientStatus(ims.ccosched.vo.lookups.Status value)
	{
		this.isValidated = false;
		this.patientstatus = value;
	}
	public boolean getRemovedStatIsNotNull()
	{
		return this.removedstat != null;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.isValidated = false;
		this.removedstat = value;
	}
	public boolean getDelayedIsNotNull()
	{
		return this.delayed != null;
	}
	public Boolean getDelayed()
	{
		return this.delayed;
	}
	public void setDelayed(Boolean value)
	{
		this.isValidated = false;
		this.delayed = value;
	}
	public boolean getPrimaryTumourIsNotNull()
	{
		return this.primarytumour != null;
	}
	public ims.eas.vo.PrimaryTumourNameVo getPrimaryTumour()
	{
		return this.primarytumour;
	}
	public void setPrimaryTumour(ims.eas.vo.PrimaryTumourNameVo value)
	{
		this.isValidated = false;
		this.primarytumour = value;
	}
	public boolean getTreatmentSiteIsNotNull()
	{
		return this.treatmentsite != null;
	}
	public ims.eas.vo.TreatmentSiteNameVo getTreatmentSite()
	{
		return this.treatmentsite;
	}
	public void setTreatmentSite(ims.eas.vo.TreatmentSiteNameVo value)
	{
		this.isValidated = false;
		this.treatmentsite = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.eas.vo.EasStatusLiteVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.eas.vo.EasStatusLiteVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getRemovalReasonIsNotNull()
	{
		return this.removalreason != null;
	}
	public ims.eas.vo.lookups.RemovalReason getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.eas.vo.lookups.RemovalReason value)
	{
		this.isValidated = false;
		this.removalreason = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.easstatus == null)
			listOfErrors.add("EasStatus is mandatory");
		if(this.responsiblehcp == null)
			listOfErrors.add("ResponsibleHcp is mandatory");
		if(this.seenby == null)
			listOfErrors.add("SeenBy is mandatory");
		if(this.dateseen == null)
			listOfErrors.add("DateSeen is mandatory");
		if(this.datedecisiontotreat == null)
			listOfErrors.add("DateDecisionToTreat is mandatory");
		if(this.intent == null)
			listOfErrors.add("Intent is mandatory");
		if(this.priority == null)
			listOfErrors.add("Priority is mandatory");
		if(this.primarytumour == null)
			listOfErrors.add("PrimaryTumour is mandatory");
		if(this.treatmentsite == null)
			listOfErrors.add("TreatmentSite is mandatory");
		if(this.statushistory == null || this.statushistory.size() == 0)
			listOfErrors.add("StatusHistory are mandatory");
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
	
		EasWorklistVo clone = new EasWorklistVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientListVo)this.patient.clone();
		if(this.easstatus == null)
			clone.easstatus = null;
		else
			clone.easstatus = (ims.eas.vo.EasStatusLiteVo)this.easstatus.clone();
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		clone.tpcreated = this.tpcreated;
		clone.actionrequired = this.actionrequired;
		if(this.seenby == null)
			clone.seenby = null;
		else
			clone.seenby = (ims.core.vo.HcpLiteVo)this.seenby.clone();
		if(this.dateseen == null)
			clone.dateseen = null;
		else
			clone.dateseen = (ims.framework.utils.Date)this.dateseen.clone();
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.intent == null)
			clone.intent = null;
		else
			clone.intent = (ims.ccosched.vo.lookups.TreatmentIntent)this.intent.clone();
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.ccosched.vo.lookups.Priority)this.priority.clone();
		if(this.patientstatus == null)
			clone.patientstatus = null;
		else
			clone.patientstatus = (ims.ccosched.vo.lookups.Status)this.patientstatus.clone();
		clone.removedstat = this.removedstat;
		clone.delayed = this.delayed;
		if(this.primarytumour == null)
			clone.primarytumour = null;
		else
			clone.primarytumour = (ims.eas.vo.PrimaryTumourNameVo)this.primarytumour.clone();
		if(this.treatmentsite == null)
			clone.treatmentsite = null;
		else
			clone.treatmentsite = (ims.eas.vo.TreatmentSiteNameVo)this.treatmentsite.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.eas.vo.EasStatusLiteVoCollection)this.statushistory.clone();
		if(this.removalreason == null)
			clone.removalreason = null;
		else
			clone.removalreason = (ims.eas.vo.lookups.RemovalReason)this.removalreason.clone();
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
		if (!(EasWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EasWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EasWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EasWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.easstatus != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.tpcreated != null)
			count++;
		if(this.actionrequired != null)
			count++;
		if(this.seenby != null)
			count++;
		if(this.dateseen != null)
			count++;
		if(this.datedecisiontotreat != null)
			count++;
		if(this.intent != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.patientstatus != null)
			count++;
		if(this.removedstat != null)
			count++;
		if(this.delayed != null)
			count++;
		if(this.primarytumour != null)
			count++;
		if(this.treatmentsite != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.removalreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.vo.PatientListVo patient;
	protected ims.eas.vo.EasStatusLiteVo easstatus;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	protected Boolean tpcreated;
	protected Boolean actionrequired;
	protected ims.core.vo.HcpLiteVo seenby;
	protected ims.framework.utils.Date dateseen;
	protected ims.framework.utils.Date datedecisiontotreat;
	protected ims.ccosched.vo.lookups.TreatmentIntent intent;
	protected ims.ccosched.vo.lookups.Priority priority;
	protected ims.ccosched.vo.lookups.Status patientstatus;
	protected Boolean removedstat;
	protected Boolean delayed;
	protected ims.eas.vo.PrimaryTumourNameVo primarytumour;
	protected ims.eas.vo.TreatmentSiteNameVo treatmentsite;
	protected ims.eas.vo.EasStatusLiteVoCollection statushistory;
	protected ims.eas.vo.lookups.RemovalReason removalreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
