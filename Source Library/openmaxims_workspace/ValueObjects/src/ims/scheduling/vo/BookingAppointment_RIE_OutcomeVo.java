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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointment_RIE_OutcomeVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BookingAppointment_RIE_OutcomeVo()
	{
	}
	public BookingAppointment_RIE_OutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public BookingAppointment_RIE_OutcomeVo(ims.scheduling.vo.beans.BookingAppointment_RIE_OutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.apptstatusreas = bean.getApptStatusReas() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatusReas());
		this.currentstatusrecord = bean.getCurrentStatusRecord() == null ? null : bean.getCurrentStatusRecord().buildVo();
		this.apptstatushistory = ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVoCollection.buildFromBeanCollection(bean.getApptStatusHistory());
		this.seentime = bean.getSeenTime() == null ? null : bean.getSeenTime().buildTime();
		this.seenby = bean.getSeenBy() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getSeenBy().getId()), bean.getSeenBy().getVersion());
		this.apptcompletetime = bean.getApptCompleteTime() == null ? null : bean.getApptCompleteTime().buildTime();
		this.outcome = bean.getOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getOutcome());
		this.outcomedatetime = bean.getOutcomeDateTime() == null ? null : bean.getOutcomeDateTime().buildDateTime();
		this.outcomereason = bean.getOutcomeReason() == null ? null : ims.admin.vo.lookups.AppointmentOutcomeReason.buildLookup(bean.getOutcomeReason());
		this.outcomecomments = bean.getOutcomeComments();
		this.wasfirstdefinitivetreatment = bean.getWasFirstDefinitiveTreatment();
		this.outcomehasrttclockimpact = bean.getOutcomeHasRTTClockImpact();
		this.statussavedfromoutcome = bean.getStatusSavedFromOutcome();
		this.apptbookedonsameday = bean.getApptBookedOnSameDay();
		this.outcomeactions = ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVoCollection.buildFromBeanCollection(bean.getOutcomeActions());
		this.rttclockimpact = bean.getRTTClockImpact() == null ? null : bean.getRTTClockImpact().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.BookingAppointment_RIE_OutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.apptstatusreas = bean.getApptStatusReas() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatusReas());
		this.currentstatusrecord = bean.getCurrentStatusRecord() == null ? null : bean.getCurrentStatusRecord().buildVo(map);
		this.apptstatushistory = ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVoCollection.buildFromBeanCollection(bean.getApptStatusHistory());
		this.seentime = bean.getSeenTime() == null ? null : bean.getSeenTime().buildTime();
		this.seenby = bean.getSeenBy() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getSeenBy().getId()), bean.getSeenBy().getVersion());
		this.apptcompletetime = bean.getApptCompleteTime() == null ? null : bean.getApptCompleteTime().buildTime();
		this.outcome = bean.getOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getOutcome());
		this.outcomedatetime = bean.getOutcomeDateTime() == null ? null : bean.getOutcomeDateTime().buildDateTime();
		this.outcomereason = bean.getOutcomeReason() == null ? null : ims.admin.vo.lookups.AppointmentOutcomeReason.buildLookup(bean.getOutcomeReason());
		this.outcomecomments = bean.getOutcomeComments();
		this.wasfirstdefinitivetreatment = bean.getWasFirstDefinitiveTreatment();
		this.outcomehasrttclockimpact = bean.getOutcomeHasRTTClockImpact();
		this.statussavedfromoutcome = bean.getStatusSavedFromOutcome();
		this.apptbookedonsameday = bean.getApptBookedOnSameDay();
		this.outcomeactions = ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVoCollection.buildFromBeanCollection(bean.getOutcomeActions());
		this.rttclockimpact = bean.getRTTClockImpact() == null ? null : bean.getRTTClockImpact().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.BookingAppointment_RIE_OutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.BookingAppointment_RIE_OutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.BookingAppointment_RIE_OutcomeVoBean();
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
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("APPTSTATUSREAS"))
			return getApptStatusReas();
		if(fieldName.equals("CURRENTSTATUSRECORD"))
			return getCurrentStatusRecord();
		if(fieldName.equals("APPTSTATUSHISTORY"))
			return getApptStatusHistory();
		if(fieldName.equals("SEENTIME"))
			return getSeenTime();
		if(fieldName.equals("SEENBY"))
			return getSeenBy();
		if(fieldName.equals("APPTCOMPLETETIME"))
			return getApptCompleteTime();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		if(fieldName.equals("OUTCOMEDATETIME"))
			return getOutcomeDateTime();
		if(fieldName.equals("OUTCOMEREASON"))
			return getOutcomeReason();
		if(fieldName.equals("OUTCOMECOMMENTS"))
			return getOutcomeComments();
		if(fieldName.equals("WASFIRSTDEFINITIVETREATMENT"))
			return getWasFirstDefinitiveTreatment();
		if(fieldName.equals("OUTCOMEHASRTTCLOCKIMPACT"))
			return getOutcomeHasRTTClockImpact();
		if(fieldName.equals("STATUSSAVEDFROMOUTCOME"))
			return getStatusSavedFromOutcome();
		if(fieldName.equals("APPTBOOKEDONSAMEDAY"))
			return getApptBookedOnSameDay();
		if(fieldName.equals("OUTCOMEACTIONS"))
			return getOutcomeActions();
		if(fieldName.equals("RTTCLOCKIMPACT"))
			return getRTTClockImpact();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getApptStatusIsNotNull()
	{
		return this.apptstatus != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.apptstatus = value;
	}
	public boolean getApptStatusReasIsNotNull()
	{
		return this.apptstatusreas != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getApptStatusReas()
	{
		return this.apptstatusreas;
	}
	public void setApptStatusReas(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.apptstatusreas = value;
	}
	public boolean getCurrentStatusRecordIsNotNull()
	{
		return this.currentstatusrecord != null;
	}
	public ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVo getCurrentStatusRecord()
	{
		return this.currentstatusrecord;
	}
	public void setCurrentStatusRecord(ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVo value)
	{
		this.isValidated = false;
		this.currentstatusrecord = value;
	}
	public boolean getApptStatusHistoryIsNotNull()
	{
		return this.apptstatushistory != null;
	}
	public ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVoCollection getApptStatusHistory()
	{
		return this.apptstatushistory;
	}
	public void setApptStatusHistory(ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVoCollection value)
	{
		this.isValidated = false;
		this.apptstatushistory = value;
	}
	public boolean getSeenTimeIsNotNull()
	{
		return this.seentime != null;
	}
	public ims.framework.utils.Time getSeenTime()
	{
		return this.seentime;
	}
	public void setSeenTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.seentime = value;
	}
	public boolean getSeenByIsNotNull()
	{
		return this.seenby != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.seenby = value;
	}
	public boolean getApptCompleteTimeIsNotNull()
	{
		return this.apptcompletetime != null;
	}
	public ims.framework.utils.Time getApptCompleteTime()
	{
		return this.apptcompletetime;
	}
	public void setApptCompleteTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptcompletetime = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.scheduling.vo.lookups.ApptOutcome getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.scheduling.vo.lookups.ApptOutcome value)
	{
		this.isValidated = false;
		this.outcome = value;
	}
	public boolean getOutcomeDateTimeIsNotNull()
	{
		return this.outcomedatetime != null;
	}
	public ims.framework.utils.DateTime getOutcomeDateTime()
	{
		return this.outcomedatetime;
	}
	public void setOutcomeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.outcomedatetime = value;
	}
	public boolean getOutcomeReasonIsNotNull()
	{
		return this.outcomereason != null;
	}
	public ims.admin.vo.lookups.AppointmentOutcomeReason getOutcomeReason()
	{
		return this.outcomereason;
	}
	public void setOutcomeReason(ims.admin.vo.lookups.AppointmentOutcomeReason value)
	{
		this.isValidated = false;
		this.outcomereason = value;
	}
	public boolean getOutcomeCommentsIsNotNull()
	{
		return this.outcomecomments != null;
	}
	public String getOutcomeComments()
	{
		return this.outcomecomments;
	}
	public static int getOutcomeCommentsMaxLength()
	{
		return 500;
	}
	public void setOutcomeComments(String value)
	{
		this.isValidated = false;
		this.outcomecomments = value;
	}
	public boolean getWasFirstDefinitiveTreatmentIsNotNull()
	{
		return this.wasfirstdefinitivetreatment != null;
	}
	public Boolean getWasFirstDefinitiveTreatment()
	{
		return this.wasfirstdefinitivetreatment;
	}
	public void setWasFirstDefinitiveTreatment(Boolean value)
	{
		this.isValidated = false;
		this.wasfirstdefinitivetreatment = value;
	}
	public boolean getOutcomeHasRTTClockImpactIsNotNull()
	{
		return this.outcomehasrttclockimpact != null;
	}
	public Boolean getOutcomeHasRTTClockImpact()
	{
		return this.outcomehasrttclockimpact;
	}
	public void setOutcomeHasRTTClockImpact(Boolean value)
	{
		this.isValidated = false;
		this.outcomehasrttclockimpact = value;
	}
	public boolean getStatusSavedFromOutcomeIsNotNull()
	{
		return this.statussavedfromoutcome != null;
	}
	public Boolean getStatusSavedFromOutcome()
	{
		return this.statussavedfromoutcome;
	}
	public void setStatusSavedFromOutcome(Boolean value)
	{
		this.isValidated = false;
		this.statussavedfromoutcome = value;
	}
	public boolean getApptBookedOnSameDayIsNotNull()
	{
		return this.apptbookedonsameday != null;
	}
	public Boolean getApptBookedOnSameDay()
	{
		return this.apptbookedonsameday;
	}
	public void setApptBookedOnSameDay(Boolean value)
	{
		this.isValidated = false;
		this.apptbookedonsameday = value;
	}
	public boolean getOutcomeActionsIsNotNull()
	{
		return this.outcomeactions != null;
	}
	public ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVoCollection getOutcomeActions()
	{
		return this.outcomeactions;
	}
	public void setOutcomeActions(ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVoCollection value)
	{
		this.isValidated = false;
		this.outcomeactions = value;
	}
	public boolean getRTTClockImpactIsNotNull()
	{
		return this.rttclockimpact != null;
	}
	public ims.pathways.vo.PathwayRTTClockImpactVo getRTTClockImpact()
	{
		return this.rttclockimpact;
	}
	public void setRTTClockImpact(ims.pathways.vo.PathwayRTTClockImpactVo value)
	{
		this.isValidated = false;
		this.rttclockimpact = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
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
		if(this.outcomeactions != null)
		{
			if(!this.outcomeactions.isValidated())
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
		if(this.outcomecomments != null)
			if(this.outcomecomments.length() > 500)
				listOfErrors.add("The length of the field [outcomecomments] in the value object [ims.scheduling.vo.BookingAppointment_RIE_OutcomeVo] is too big. It should be less or equal to 500");
		if(this.outcomeactions != null)
		{
			String[] listOfOtherErrors = this.outcomeactions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		BookingAppointment_RIE_OutcomeVo clone = new BookingAppointment_RIE_OutcomeVo(this.id, this.version);
		
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		if(this.apptstatusreas == null)
			clone.apptstatusreas = null;
		else
			clone.apptstatusreas = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatusreas.clone();
		if(this.currentstatusrecord == null)
			clone.currentstatusrecord = null;
		else
			clone.currentstatusrecord = (ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVo)this.currentstatusrecord.clone();
		if(this.apptstatushistory == null)
			clone.apptstatushistory = null;
		else
			clone.apptstatushistory = (ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVoCollection)this.apptstatushistory.clone();
		if(this.seentime == null)
			clone.seentime = null;
		else
			clone.seentime = (ims.framework.utils.Time)this.seentime.clone();
		clone.seenby = this.seenby;
		if(this.apptcompletetime == null)
			clone.apptcompletetime = null;
		else
			clone.apptcompletetime = (ims.framework.utils.Time)this.apptcompletetime.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.scheduling.vo.lookups.ApptOutcome)this.outcome.clone();
		if(this.outcomedatetime == null)
			clone.outcomedatetime = null;
		else
			clone.outcomedatetime = (ims.framework.utils.DateTime)this.outcomedatetime.clone();
		if(this.outcomereason == null)
			clone.outcomereason = null;
		else
			clone.outcomereason = (ims.admin.vo.lookups.AppointmentOutcomeReason)this.outcomereason.clone();
		clone.outcomecomments = this.outcomecomments;
		clone.wasfirstdefinitivetreatment = this.wasfirstdefinitivetreatment;
		clone.outcomehasrttclockimpact = this.outcomehasrttclockimpact;
		clone.statussavedfromoutcome = this.statussavedfromoutcome;
		clone.apptbookedonsameday = this.apptbookedonsameday;
		if(this.outcomeactions == null)
			clone.outcomeactions = null;
		else
			clone.outcomeactions = (ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVoCollection)this.outcomeactions.clone();
		if(this.rttclockimpact == null)
			clone.rttclockimpact = null;
		else
			clone.rttclockimpact = (ims.pathways.vo.PathwayRTTClockImpactVo)this.rttclockimpact.clone();
		clone.patient = this.patient;
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
		if (!(BookingAppointment_RIE_OutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BookingAppointment_RIE_OutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BookingAppointment_RIE_OutcomeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BookingAppointment_RIE_OutcomeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.apptstatus != null)
			count++;
		if(this.apptstatusreas != null)
			count++;
		if(this.currentstatusrecord != null)
			count++;
		if(this.apptstatushistory != null)
			count++;
		if(this.seentime != null)
			count++;
		if(this.seenby != null)
			count++;
		if(this.apptcompletetime != null)
			count++;
		if(this.outcome != null)
			count++;
		if(this.outcomedatetime != null)
			count++;
		if(this.outcomereason != null)
			count++;
		if(this.outcomecomments != null)
			count++;
		if(this.wasfirstdefinitivetreatment != null)
			count++;
		if(this.outcomehasrttclockimpact != null)
			count++;
		if(this.statussavedfromoutcome != null)
			count++;
		if(this.apptbookedonsameday != null)
			count++;
		if(this.outcomeactions != null)
			count++;
		if(this.rttclockimpact != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 18;
	}
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatusreas;
	protected ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVo currentstatusrecord;
	protected ims.scheduling.vo.Appointment_StatusForAppointmentOutcomeVoCollection apptstatushistory;
	protected ims.framework.utils.Time seentime;
	protected ims.core.resource.people.vo.HcpRefVo seenby;
	protected ims.framework.utils.Time apptcompletetime;
	protected ims.scheduling.vo.lookups.ApptOutcome outcome;
	protected ims.framework.utils.DateTime outcomedatetime;
	protected ims.admin.vo.lookups.AppointmentOutcomeReason outcomereason;
	protected String outcomecomments;
	protected Boolean wasfirstdefinitivetreatment;
	protected Boolean outcomehasrttclockimpact;
	protected Boolean statussavedfromoutcome;
	protected Boolean apptbookedonsameday;
	protected ims.scheduling.vo.AppointmentOutcomeAction_RIE_OutcomeVoCollection outcomeactions;
	protected ims.pathways.vo.PathwayRTTClockImpactVo rttclockimpact;
	protected ims.core.patient.vo.PatientRefVo patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
