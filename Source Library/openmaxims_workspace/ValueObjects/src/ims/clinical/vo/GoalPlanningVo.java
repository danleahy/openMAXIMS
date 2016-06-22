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

package ims.clinical.vo;

/**
 * Linked to clinical.GoalPlanning business object (ID: 1072100059).
 */
public class GoalPlanningVo extends ims.clinical.vo.GoalPlanningRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GoalPlanningVo()
	{
	}
	public GoalPlanningVo(Integer id, int version)
	{
		super(id, version);
	}
	public GoalPlanningVo(ims.clinical.vo.beans.GoalPlanningVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.goalplanningdate = bean.getGoalPlanningDate() == null ? null : bean.getGoalPlanningDate().buildDate();
		this.predicateddischargedate = bean.getPredicatedDischargeDate() == null ? null : bean.getPredicatedDischargeDate().buildPartialDate();
		this.goalplanningoutcome = bean.getGoalPlanningOutcome() == null ? null : ims.clinical.vo.lookups.GoalPlanningOutcome.buildLookup(bean.getGoalPlanningOutcome());
		this.primecancelreason = bean.getPrimeCancelReason() == null ? null : ims.clinical.vo.lookups.GoalPlanningCancellationReason.buildLookup(bean.getPrimeCancelReason());
		this.predictednextgoalplanning = bean.getPredictedNextGoalPlanning() == null ? null : bean.getPredictedNextGoalPlanning().buildPartialDate();
		this.dischargedelayvalue = bean.getDischargeDelayValue();
		this.dischargedelayunit = bean.getDischargeDelayUnit() == null ? null : ims.core.vo.lookups.TimeDaystoYears.buildLookup(bean.getDischargeDelayUnit());
		this.isgoalplanningconf = bean.getIsGoalPlanningConf();
		this.minutes = bean.getMinutes();
		this.comments = bean.getComments();
		this.invitees = ims.clinical.vo.GoalPlanningMeetingAttendeeVoCollection.buildFromBeanCollection(bean.getInvitees());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.GoalPlanningVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.goalplanningdate = bean.getGoalPlanningDate() == null ? null : bean.getGoalPlanningDate().buildDate();
		this.predicateddischargedate = bean.getPredicatedDischargeDate() == null ? null : bean.getPredicatedDischargeDate().buildPartialDate();
		this.goalplanningoutcome = bean.getGoalPlanningOutcome() == null ? null : ims.clinical.vo.lookups.GoalPlanningOutcome.buildLookup(bean.getGoalPlanningOutcome());
		this.primecancelreason = bean.getPrimeCancelReason() == null ? null : ims.clinical.vo.lookups.GoalPlanningCancellationReason.buildLookup(bean.getPrimeCancelReason());
		this.predictednextgoalplanning = bean.getPredictedNextGoalPlanning() == null ? null : bean.getPredictedNextGoalPlanning().buildPartialDate();
		this.dischargedelayvalue = bean.getDischargeDelayValue();
		this.dischargedelayunit = bean.getDischargeDelayUnit() == null ? null : ims.core.vo.lookups.TimeDaystoYears.buildLookup(bean.getDischargeDelayUnit());
		this.isgoalplanningconf = bean.getIsGoalPlanningConf();
		this.minutes = bean.getMinutes();
		this.comments = bean.getComments();
		this.invitees = ims.clinical.vo.GoalPlanningMeetingAttendeeVoCollection.buildFromBeanCollection(bean.getInvitees());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.GoalPlanningVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.GoalPlanningVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.GoalPlanningVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("GOALPLANNINGDATE"))
			return getGoalPlanningDate();
		if(fieldName.equals("PREDICATEDDISCHARGEDATE"))
			return getPredicatedDischargeDate();
		if(fieldName.equals("GOALPLANNINGOUTCOME"))
			return getGoalPlanningOutcome();
		if(fieldName.equals("PRIMECANCELREASON"))
			return getPrimeCancelReason();
		if(fieldName.equals("PREDICTEDNEXTGOALPLANNING"))
			return getPredictedNextGoalPlanning();
		if(fieldName.equals("DISCHARGEDELAYVALUE"))
			return getDischargeDelayValue();
		if(fieldName.equals("DISCHARGEDELAYUNIT"))
			return getDischargeDelayUnit();
		if(fieldName.equals("ISGOALPLANNINGCONF"))
			return getIsGoalPlanningConf();
		if(fieldName.equals("MINUTES"))
			return getMinutes();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("INVITEES"))
			return getInvitees();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getGoalPlanningDateIsNotNull()
	{
		return this.goalplanningdate != null;
	}
	public ims.framework.utils.Date getGoalPlanningDate()
	{
		return this.goalplanningdate;
	}
	public void setGoalPlanningDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.goalplanningdate = value;
	}
	public boolean getPredicatedDischargeDateIsNotNull()
	{
		return this.predicateddischargedate != null;
	}
	public ims.framework.utils.PartialDate getPredicatedDischargeDate()
	{
		return this.predicateddischargedate;
	}
	public void setPredicatedDischargeDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.predicateddischargedate = value;
	}
	public boolean getGoalPlanningOutcomeIsNotNull()
	{
		return this.goalplanningoutcome != null;
	}
	public ims.clinical.vo.lookups.GoalPlanningOutcome getGoalPlanningOutcome()
	{
		return this.goalplanningoutcome;
	}
	public void setGoalPlanningOutcome(ims.clinical.vo.lookups.GoalPlanningOutcome value)
	{
		this.isValidated = false;
		this.goalplanningoutcome = value;
	}
	public boolean getPrimeCancelReasonIsNotNull()
	{
		return this.primecancelreason != null;
	}
	public ims.clinical.vo.lookups.GoalPlanningCancellationReason getPrimeCancelReason()
	{
		return this.primecancelreason;
	}
	public void setPrimeCancelReason(ims.clinical.vo.lookups.GoalPlanningCancellationReason value)
	{
		this.isValidated = false;
		this.primecancelreason = value;
	}
	public boolean getPredictedNextGoalPlanningIsNotNull()
	{
		return this.predictednextgoalplanning != null;
	}
	public ims.framework.utils.PartialDate getPredictedNextGoalPlanning()
	{
		return this.predictednextgoalplanning;
	}
	public void setPredictedNextGoalPlanning(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.predictednextgoalplanning = value;
	}
	public boolean getDischargeDelayValueIsNotNull()
	{
		return this.dischargedelayvalue != null;
	}
	public Integer getDischargeDelayValue()
	{
		return this.dischargedelayvalue;
	}
	public void setDischargeDelayValue(Integer value)
	{
		this.isValidated = false;
		this.dischargedelayvalue = value;
	}
	public boolean getDischargeDelayUnitIsNotNull()
	{
		return this.dischargedelayunit != null;
	}
	public ims.core.vo.lookups.TimeDaystoYears getDischargeDelayUnit()
	{
		return this.dischargedelayunit;
	}
	public void setDischargeDelayUnit(ims.core.vo.lookups.TimeDaystoYears value)
	{
		this.isValidated = false;
		this.dischargedelayunit = value;
	}
	public boolean getIsGoalPlanningConfIsNotNull()
	{
		return this.isgoalplanningconf != null;
	}
	public Boolean getIsGoalPlanningConf()
	{
		return this.isgoalplanningconf;
	}
	public void setIsGoalPlanningConf(Boolean value)
	{
		this.isValidated = false;
		this.isgoalplanningconf = value;
	}
	public boolean getMinutesIsNotNull()
	{
		return this.minutes != null;
	}
	public String getMinutes()
	{
		return this.minutes;
	}
	public static int getMinutesMaxLength()
	{
		return 200;
	}
	public void setMinutes(String value)
	{
		this.isValidated = false;
		this.minutes = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 2000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getInviteesIsNotNull()
	{
		return this.invitees != null;
	}
	public ims.clinical.vo.GoalPlanningMeetingAttendeeVoCollection getInvitees()
	{
		return this.invitees;
	}
	public void setInvitees(ims.clinical.vo.GoalPlanningMeetingAttendeeVoCollection value)
	{
		this.isValidated = false;
		this.invitees = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinicalcontact != null)
		{
			if(!this.clinicalcontact.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.carecontext != null)
		{
			if(!this.carecontext.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.invitees != null)
		{
			if(!this.invitees.isValidated())
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalcontact != null)
		{
			String[] listOfOtherErrors = this.clinicalcontact.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.carecontext != null)
		{
			String[] listOfOtherErrors = this.carecontext.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.goalplanningdate == null)
			listOfErrors.add("GoalPlanningDate is mandatory");
		if(this.minutes != null)
			if(this.minutes.length() > 200)
				listOfErrors.add("The length of the field [minutes] in the value object [ims.clinical.vo.GoalPlanningVo] is too big. It should be less or equal to 200");
		if(this.comments != null)
			if(this.comments.length() > 2000)
				listOfErrors.add("The field Comments is too long. Please reduce it");
		if(this.invitees != null)
		{
			String[] listOfOtherErrors = this.invitees.validate();
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
	
		GoalPlanningVo clone = new GoalPlanningVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.goalplanningdate == null)
			clone.goalplanningdate = null;
		else
			clone.goalplanningdate = (ims.framework.utils.Date)this.goalplanningdate.clone();
		if(this.predicateddischargedate == null)
			clone.predicateddischargedate = null;
		else
			clone.predicateddischargedate = (ims.framework.utils.PartialDate)this.predicateddischargedate.clone();
		if(this.goalplanningoutcome == null)
			clone.goalplanningoutcome = null;
		else
			clone.goalplanningoutcome = (ims.clinical.vo.lookups.GoalPlanningOutcome)this.goalplanningoutcome.clone();
		if(this.primecancelreason == null)
			clone.primecancelreason = null;
		else
			clone.primecancelreason = (ims.clinical.vo.lookups.GoalPlanningCancellationReason)this.primecancelreason.clone();
		if(this.predictednextgoalplanning == null)
			clone.predictednextgoalplanning = null;
		else
			clone.predictednextgoalplanning = (ims.framework.utils.PartialDate)this.predictednextgoalplanning.clone();
		clone.dischargedelayvalue = this.dischargedelayvalue;
		if(this.dischargedelayunit == null)
			clone.dischargedelayunit = null;
		else
			clone.dischargedelayunit = (ims.core.vo.lookups.TimeDaystoYears)this.dischargedelayunit.clone();
		clone.isgoalplanningconf = this.isgoalplanningconf;
		clone.minutes = this.minutes;
		clone.comments = this.comments;
		if(this.invitees == null)
			clone.invitees = null;
		else
			clone.invitees = (ims.clinical.vo.GoalPlanningMeetingAttendeeVoCollection)this.invitees.clone();
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
		if (!(GoalPlanningVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GoalPlanningVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GoalPlanningVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GoalPlanningVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.goalplanningdate != null)
			count++;
		if(this.predicateddischargedate != null)
			count++;
		if(this.goalplanningoutcome != null)
			count++;
		if(this.primecancelreason != null)
			count++;
		if(this.predictednextgoalplanning != null)
			count++;
		if(this.dischargedelayvalue != null)
			count++;
		if(this.dischargedelayunit != null)
			count++;
		if(this.isgoalplanningconf != null)
			count++;
		if(this.minutes != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.invitees != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.framework.utils.Date goalplanningdate;
	protected ims.framework.utils.PartialDate predicateddischargedate;
	protected ims.clinical.vo.lookups.GoalPlanningOutcome goalplanningoutcome;
	protected ims.clinical.vo.lookups.GoalPlanningCancellationReason primecancelreason;
	protected ims.framework.utils.PartialDate predictednextgoalplanning;
	protected Integer dischargedelayvalue;
	protected ims.core.vo.lookups.TimeDaystoYears dischargedelayunit;
	protected Boolean isgoalplanningconf;
	protected String minutes;
	protected String comments;
	protected ims.clinical.vo.GoalPlanningMeetingAttendeeVoCollection invitees;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
