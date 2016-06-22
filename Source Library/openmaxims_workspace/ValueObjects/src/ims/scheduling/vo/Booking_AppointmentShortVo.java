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
public class Booking_AppointmentShortVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IApptDuration
{
	private static final long serialVersionUID = 1L;

	public Booking_AppointmentShortVo()
	{
	}
	public Booking_AppointmentShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public Booking_AppointmentShortVo(ims.scheduling.vo.beans.Booking_AppointmentShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.apptstatusreas = bean.getApptStatusReas() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatusReas());
		this.apptstatushistory = ims.scheduling.vo.Appointment_StatusVoCollection.buildFromBeanCollection(bean.getApptStatusHistory());
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo();
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.arrivaltime = bean.getArrivalTime() == null ? null : bean.getArrivalTime().buildTime();
		this.seentime = bean.getSeenTime() == null ? null : bean.getSeenTime().buildTime();
		this.apptcompletetime = bean.getApptCompleteTime() == null ? null : bean.getApptCompleteTime().buildTime();
		this.requiresrebook = bean.getRequiresRebook();
		this.currentstatusrecord = bean.getCurrentStatusRecord() == null ? null : bean.getCurrentStatusRecord().buildVo();
		this.outcome = bean.getOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getOutcome());
		this.iscabbooking = bean.getIsCABBooking();
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.comments = bean.getComments();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.outcomecomments = bean.getOutcomeComments();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.appttrackingstatushistory = ims.scheduling.vo.Appt_Tracking_Status_HistoryVoCollection.buildFromBeanCollection(bean.getApptTrackingStatusHistory());
		this.theatrebooking = bean.getTheatreBooking() == null ? null : bean.getTheatreBooking().buildVo();
		this.sessionslot = bean.getSessionSlot() == null ? null : bean.getSessionSlot().buildVo();
		this.dummycolour = bean.getDummyColour() == null ? null : bean.getDummyColour().buildColor();
		this.durationhelper = bean.getDurationHelper() == null ? null : bean.getDurationHelper().buildVo();
		this.wasprinted = bean.getWasPrinted();
		this.bookingletter = bean.getBookingLetter() == null ? null : bean.getBookingLetter().buildVo();
		this.numprovidercancellations = bean.getNumProviderCancellations();
		this.numpatientcancellations = bean.getNumPatientCancellations();
		this.linkedapptstobecancelled = ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection.buildFromBeanCollection(bean.getLinkedApptsToBeCancelled());
		this.date28dayrulebreach = bean.getDate28DayRuleBreach() == null ? null : bean.getDate28DayRuleBreach().buildDate();
		this.iswardattendance = bean.getIsWardAttendance();
		this.wardattendanceoutcome = bean.getWardAttendanceOutcome() == null ? null : ims.core.vo.lookups.WardAttendanceOutcome.buildLookup(bean.getWardAttendanceOutcome());
		this.electivelist = bean.getElectiveList() == null ? null : new ims.RefMan.vo.PatientElectiveListRefVo(new Integer(bean.getElectiveList().getId()), bean.getElectiveList().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Booking_AppointmentShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.apptstatusreas = bean.getApptStatusReas() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatusReas());
		this.apptstatushistory = ims.scheduling.vo.Appointment_StatusVoCollection.buildFromBeanCollection(bean.getApptStatusHistory());
		this.seenby = bean.getSeenBy() == null ? null : bean.getSeenBy().buildVo(map);
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo(map);
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.arrivaltime = bean.getArrivalTime() == null ? null : bean.getArrivalTime().buildTime();
		this.seentime = bean.getSeenTime() == null ? null : bean.getSeenTime().buildTime();
		this.apptcompletetime = bean.getApptCompleteTime() == null ? null : bean.getApptCompleteTime().buildTime();
		this.requiresrebook = bean.getRequiresRebook();
		this.currentstatusrecord = bean.getCurrentStatusRecord() == null ? null : bean.getCurrentStatusRecord().buildVo(map);
		this.outcome = bean.getOutcome() == null ? null : ims.scheduling.vo.lookups.ApptOutcome.buildLookup(bean.getOutcome());
		this.iscabbooking = bean.getIsCABBooking();
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.comments = bean.getComments();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.outcomecomments = bean.getOutcomeComments();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.appttrackingstatushistory = ims.scheduling.vo.Appt_Tracking_Status_HistoryVoCollection.buildFromBeanCollection(bean.getApptTrackingStatusHistory());
		this.theatrebooking = bean.getTheatreBooking() == null ? null : bean.getTheatreBooking().buildVo(map);
		this.sessionslot = bean.getSessionSlot() == null ? null : bean.getSessionSlot().buildVo(map);
		this.dummycolour = bean.getDummyColour() == null ? null : bean.getDummyColour().buildColor();
		this.durationhelper = bean.getDurationHelper() == null ? null : bean.getDurationHelper().buildVo(map);
		this.wasprinted = bean.getWasPrinted();
		this.bookingletter = bean.getBookingLetter() == null ? null : bean.getBookingLetter().buildVo(map);
		this.numprovidercancellations = bean.getNumProviderCancellations();
		this.numpatientcancellations = bean.getNumPatientCancellations();
		this.linkedapptstobecancelled = ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection.buildFromBeanCollection(bean.getLinkedApptsToBeCancelled());
		this.date28dayrulebreach = bean.getDate28DayRuleBreach() == null ? null : bean.getDate28DayRuleBreach().buildDate();
		this.iswardattendance = bean.getIsWardAttendance();
		this.wardattendanceoutcome = bean.getWardAttendanceOutcome() == null ? null : ims.core.vo.lookups.WardAttendanceOutcome.buildLookup(bean.getWardAttendanceOutcome());
		this.electivelist = bean.getElectiveList() == null ? null : new ims.RefMan.vo.PatientElectiveListRefVo(new Integer(bean.getElectiveList().getId()), bean.getElectiveList().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Booking_AppointmentShortVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Booking_AppointmentShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Booking_AppointmentShortVoBean();
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
		if(fieldName.equals("APPTSTARTTIME"))
			return getApptStartTime();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("APPTSTATUSREAS"))
			return getApptStatusReas();
		if(fieldName.equals("APPTSTATUSHISTORY"))
			return getApptStatusHistory();
		if(fieldName.equals("SEENBY"))
			return getSeenBy();
		if(fieldName.equals("SESSION"))
			return getSession();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("ARRIVALTIME"))
			return getArrivalTime();
		if(fieldName.equals("SEENTIME"))
			return getSeenTime();
		if(fieldName.equals("APPTCOMPLETETIME"))
			return getApptCompleteTime();
		if(fieldName.equals("REQUIRESREBOOK"))
			return getRequiresRebook();
		if(fieldName.equals("CURRENTSTATUSRECORD"))
			return getCurrentStatusRecord();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		if(fieldName.equals("ISCABBOOKING"))
			return getIsCABBooking();
		if(fieldName.equals("APPTENDTIME"))
			return getApptEndTime();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("OUTCOMECOMMENTS"))
			return getOutcomeComments();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("APPTTRACKINGSTATUSHISTORY"))
			return getApptTrackingStatusHistory();
		if(fieldName.equals("THEATREBOOKING"))
			return getTheatreBooking();
		if(fieldName.equals("SESSIONSLOT"))
			return getSessionSlot();
		if(fieldName.equals("DUMMYCOLOUR"))
			return getDummyColour();
		if(fieldName.equals("DURATIONHELPER"))
			return getDurationHelper();
		if(fieldName.equals("WASPRINTED"))
			return getWasPrinted();
		if(fieldName.equals("BOOKINGLETTER"))
			return getBookingLetter();
		if(fieldName.equals("NUMPROVIDERCANCELLATIONS"))
			return getNumProviderCancellations();
		if(fieldName.equals("NUMPATIENTCANCELLATIONS"))
			return getNumPatientCancellations();
		if(fieldName.equals("LINKEDAPPTSTOBECANCELLED"))
			return getLinkedApptsToBeCancelled();
		if(fieldName.equals("DATE28DAYRULEBREACH"))
			return getDate28DayRuleBreach();
		if(fieldName.equals("ISWARDATTENDANCE"))
			return getIsWardAttendance();
		if(fieldName.equals("WARDATTENDANCEOUTCOME"))
			return getWardAttendanceOutcome();
		if(fieldName.equals("ELECTIVELIST"))
			return getElectiveList();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getApptStartTimeIsNotNull()
	{
		return this.apptstarttime != null;
	}
	public ims.framework.utils.Time getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptstarttime = value;
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
	public boolean getApptStatusHistoryIsNotNull()
	{
		return this.apptstatushistory != null;
	}
	public ims.scheduling.vo.Appointment_StatusVoCollection getApptStatusHistory()
	{
		return this.apptstatushistory;
	}
	public void setApptStatusHistory(ims.scheduling.vo.Appointment_StatusVoCollection value)
	{
		this.isValidated = false;
		this.apptstatushistory = value;
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
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.SessionLiteVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.SessionLiteVo value)
	{
		this.isValidated = false;
		this.session = value;
	}
	public boolean getAppointmentDateIsNotNull()
	{
		return this.appointmentdate != null;
	}
	public ims.framework.utils.Date getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.appointmentdate = value;
	}
	public boolean getArrivalTimeIsNotNull()
	{
		return this.arrivaltime != null;
	}
	public ims.framework.utils.Time getArrivalTime()
	{
		return this.arrivaltime;
	}
	public void setArrivalTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.arrivaltime = value;
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
	public boolean getRequiresRebookIsNotNull()
	{
		return this.requiresrebook != null;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.isValidated = false;
		this.requiresrebook = value;
	}
	public boolean getCurrentStatusRecordIsNotNull()
	{
		return this.currentstatusrecord != null;
	}
	public ims.scheduling.vo.Appointment_StatusVo getCurrentStatusRecord()
	{
		return this.currentstatusrecord;
	}
	public void setCurrentStatusRecord(ims.scheduling.vo.Appointment_StatusVo value)
	{
		this.isValidated = false;
		this.currentstatusrecord = value;
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
	public boolean getIsCABBookingIsNotNull()
	{
		return this.iscabbooking != null;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.isValidated = false;
		this.iscabbooking = value;
	}
	public boolean getApptEndTimeIsNotNull()
	{
		return this.apptendtime != null;
	}
	public ims.framework.utils.Time getApptEndTime()
	{
		return this.apptendtime;
	}
	public void setApptEndTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptendtime = value;
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
		return 500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityLiteVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityLiteVo value)
	{
		this.isValidated = false;
		this.activity = value;
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
	public boolean getApptTrackingStatusHistoryIsNotNull()
	{
		return this.appttrackingstatushistory != null;
	}
	public ims.scheduling.vo.Appt_Tracking_Status_HistoryVoCollection getApptTrackingStatusHistory()
	{
		return this.appttrackingstatushistory;
	}
	public void setApptTrackingStatusHistory(ims.scheduling.vo.Appt_Tracking_Status_HistoryVoCollection value)
	{
		this.isValidated = false;
		this.appttrackingstatushistory = value;
	}
	public boolean getTheatreBookingIsNotNull()
	{
		return this.theatrebooking != null;
	}
	public ims.scheduling.vo.TheatreBookingBaseVo getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.TheatreBookingBaseVo value)
	{
		this.isValidated = false;
		this.theatrebooking = value;
	}
	public boolean getSessionSlotIsNotNull()
	{
		return this.sessionslot != null;
	}
	public ims.scheduling.vo.SessionSlotForDNAVo getSessionSlot()
	{
		return this.sessionslot;
	}
	public void setSessionSlot(ims.scheduling.vo.SessionSlotForDNAVo value)
	{
		this.isValidated = false;
		this.sessionslot = value;
	}
	public boolean getDummyColourIsNotNull()
	{
		return this.dummycolour != null;
	}
	public ims.framework.utils.Color getDummyColour()
	{
		return this.dummycolour;
	}
	public void setDummyColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.dummycolour = value;
	}
	public boolean getDurationHelperIsNotNull()
	{
		return this.durationhelper != null;
	}
	public ims.scheduling.vo.AvailableDurationVo getDurationHelper()
	{
		return this.durationhelper;
	}
	public void setDurationHelper(ims.scheduling.vo.AvailableDurationVo value)
	{
		this.isValidated = false;
		this.durationhelper = value;
	}
	public boolean getWasPrintedIsNotNull()
	{
		return this.wasprinted != null;
	}
	public Boolean getWasPrinted()
	{
		return this.wasprinted;
	}
	public void setWasPrinted(Boolean value)
	{
		this.isValidated = false;
		this.wasprinted = value;
	}
	public boolean getBookingLetterIsNotNull()
	{
		return this.bookingletter != null;
	}
	public ims.core.vo.PatientDocumentLiteVo getBookingLetter()
	{
		return this.bookingletter;
	}
	public void setBookingLetter(ims.core.vo.PatientDocumentLiteVo value)
	{
		this.isValidated = false;
		this.bookingletter = value;
	}
	public boolean getNumProviderCancellationsIsNotNull()
	{
		return this.numprovidercancellations != null;
	}
	public Integer getNumProviderCancellations()
	{
		return this.numprovidercancellations;
	}
	public void setNumProviderCancellations(Integer value)
	{
		this.isValidated = false;
		this.numprovidercancellations = value;
	}
	public boolean getNumPatientCancellationsIsNotNull()
	{
		return this.numpatientcancellations != null;
	}
	public Integer getNumPatientCancellations()
	{
		return this.numpatientcancellations;
	}
	public void setNumPatientCancellations(Integer value)
	{
		this.isValidated = false;
		this.numpatientcancellations = value;
	}
	public boolean getLinkedApptsToBeCancelledIsNotNull()
	{
		return this.linkedapptstobecancelled != null;
	}
	public ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection getLinkedApptsToBeCancelled()
	{
		return this.linkedapptstobecancelled;
	}
	public void setLinkedApptsToBeCancelled(ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection value)
	{
		this.isValidated = false;
		this.linkedapptstobecancelled = value;
	}
	public boolean getDate28DayRuleBreachIsNotNull()
	{
		return this.date28dayrulebreach != null;
	}
	public ims.framework.utils.Date getDate28DayRuleBreach()
	{
		return this.date28dayrulebreach;
	}
	public void setDate28DayRuleBreach(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date28dayrulebreach = value;
	}
	public boolean getIsWardAttendanceIsNotNull()
	{
		return this.iswardattendance != null;
	}
	public Boolean getIsWardAttendance()
	{
		return this.iswardattendance;
	}
	public void setIsWardAttendance(Boolean value)
	{
		this.isValidated = false;
		this.iswardattendance = value;
	}
	public boolean getWardAttendanceOutcomeIsNotNull()
	{
		return this.wardattendanceoutcome != null;
	}
	public ims.core.vo.lookups.WardAttendanceOutcome getWardAttendanceOutcome()
	{
		return this.wardattendanceoutcome;
	}
	public void setWardAttendanceOutcome(ims.core.vo.lookups.WardAttendanceOutcome value)
	{
		this.isValidated = false;
		this.wardattendanceoutcome = value;
	}
	public boolean getElectiveListIsNotNull()
	{
		return this.electivelist != null;
	}
	public ims.RefMan.vo.PatientElectiveListRefVo getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.RefMan.vo.PatientElectiveListRefVo value)
	{
		this.isValidated = false;
		this.electivelist = value;
	}
	/**
	* IApptDuration interface methods
	*/
	public ims.framework.utils.Date getIApptDurationDate()
	{
		return this.appointmentdate;
	}
	public ims.framework.utils.Color getIApptDurationDummyColour()
	{
		return this.dummycolour;
	}
	public ims.framework.utils.Time getIApptDurationEndTime()
	{
		return this.apptendtime;
	}
	public ims.framework.utils.Time getIApptDurationStartTime()
	{
		return this.apptstarttime;
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
		if(this.apptstatushistory != null)
		{
			if(!this.apptstatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.session != null)
		{
			if(!this.session.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatusrecord != null)
		{
			if(!this.currentstatusrecord.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.appttrackingstatushistory != null)
		{
			if(!this.appttrackingstatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.sessionslot != null)
		{
			if(!this.sessionslot.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.durationhelper != null)
		{
			if(!this.durationhelper.isValidated())
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
		if(this.apptstatushistory != null)
		{
			String[] listOfOtherErrors = this.apptstatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.session != null)
		{
			String[] listOfOtherErrors = this.session.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatusrecord != null)
		{
			String[] listOfOtherErrors = this.currentstatusrecord.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments != null)
			if(this.comments.length() > 500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.scheduling.vo.Booking_AppointmentShortVo] is too big. It should be less or equal to 500");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.outcomecomments != null)
			if(this.outcomecomments.length() > 500)
				listOfErrors.add("The length of the field [outcomecomments] in the value object [ims.scheduling.vo.Booking_AppointmentShortVo] is too big. It should be less or equal to 500");
		if(this.appttrackingstatushistory != null)
		{
			String[] listOfOtherErrors = this.appttrackingstatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.sessionslot != null)
		{
			String[] listOfOtherErrors = this.sessionslot.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.durationhelper != null)
		{
			String[] listOfOtherErrors = this.durationhelper.validate();
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
	
		Booking_AppointmentShortVo clone = new Booking_AppointmentShortVo(this.id, this.version);
		
		if(this.apptstarttime == null)
			clone.apptstarttime = null;
		else
			clone.apptstarttime = (ims.framework.utils.Time)this.apptstarttime.clone();
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		if(this.apptstatusreas == null)
			clone.apptstatusreas = null;
		else
			clone.apptstatusreas = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatusreas.clone();
		if(this.apptstatushistory == null)
			clone.apptstatushistory = null;
		else
			clone.apptstatushistory = (ims.scheduling.vo.Appointment_StatusVoCollection)this.apptstatushistory.clone();
		if(this.seenby == null)
			clone.seenby = null;
		else
			clone.seenby = (ims.core.vo.HcpLiteVo)this.seenby.clone();
		if(this.session == null)
			clone.session = null;
		else
			clone.session = (ims.scheduling.vo.SessionLiteVo)this.session.clone();
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		if(this.arrivaltime == null)
			clone.arrivaltime = null;
		else
			clone.arrivaltime = (ims.framework.utils.Time)this.arrivaltime.clone();
		if(this.seentime == null)
			clone.seentime = null;
		else
			clone.seentime = (ims.framework.utils.Time)this.seentime.clone();
		if(this.apptcompletetime == null)
			clone.apptcompletetime = null;
		else
			clone.apptcompletetime = (ims.framework.utils.Time)this.apptcompletetime.clone();
		clone.requiresrebook = this.requiresrebook;
		if(this.currentstatusrecord == null)
			clone.currentstatusrecord = null;
		else
			clone.currentstatusrecord = (ims.scheduling.vo.Appointment_StatusVo)this.currentstatusrecord.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.scheduling.vo.lookups.ApptOutcome)this.outcome.clone();
		clone.iscabbooking = this.iscabbooking;
		if(this.apptendtime == null)
			clone.apptendtime = null;
		else
			clone.apptendtime = (ims.framework.utils.Time)this.apptendtime.clone();
		clone.comments = this.comments;
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityLiteVo)this.activity.clone();
		clone.outcomecomments = this.outcomecomments;
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.appttrackingstatushistory == null)
			clone.appttrackingstatushistory = null;
		else
			clone.appttrackingstatushistory = (ims.scheduling.vo.Appt_Tracking_Status_HistoryVoCollection)this.appttrackingstatushistory.clone();
		if(this.theatrebooking == null)
			clone.theatrebooking = null;
		else
			clone.theatrebooking = (ims.scheduling.vo.TheatreBookingBaseVo)this.theatrebooking.clone();
		if(this.sessionslot == null)
			clone.sessionslot = null;
		else
			clone.sessionslot = (ims.scheduling.vo.SessionSlotForDNAVo)this.sessionslot.clone();
		if(this.dummycolour == null)
			clone.dummycolour = null;
		else
			clone.dummycolour = (ims.framework.utils.Color)this.dummycolour.clone();
		if(this.durationhelper == null)
			clone.durationhelper = null;
		else
			clone.durationhelper = (ims.scheduling.vo.AvailableDurationVo)this.durationhelper.clone();
		clone.wasprinted = this.wasprinted;
		if(this.bookingletter == null)
			clone.bookingletter = null;
		else
			clone.bookingletter = (ims.core.vo.PatientDocumentLiteVo)this.bookingletter.clone();
		clone.numprovidercancellations = this.numprovidercancellations;
		clone.numpatientcancellations = this.numpatientcancellations;
		if(this.linkedapptstobecancelled == null)
			clone.linkedapptstobecancelled = null;
		else
			clone.linkedapptstobecancelled = (ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection)this.linkedapptstobecancelled.clone();
		if(this.date28dayrulebreach == null)
			clone.date28dayrulebreach = null;
		else
			clone.date28dayrulebreach = (ims.framework.utils.Date)this.date28dayrulebreach.clone();
		clone.iswardattendance = this.iswardattendance;
		if(this.wardattendanceoutcome == null)
			clone.wardattendanceoutcome = null;
		else
			clone.wardattendanceoutcome = (ims.core.vo.lookups.WardAttendanceOutcome)this.wardattendanceoutcome.clone();
		clone.electivelist = this.electivelist;
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
		if (!(Booking_AppointmentShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Booking_AppointmentShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		Booking_AppointmentShortVo compareObj = (Booking_AppointmentShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getApptStartTime() == null && compareObj.getApptStartTime() != null)
				return -1;
			if(this.getApptStartTime() != null && compareObj.getApptStartTime() == null)
				return 1;
			if(this.getApptStartTime() != null && compareObj.getApptStartTime() != null)
				retVal = this.getApptStartTime().compareTo(compareObj.getApptStartTime());
		}
		if (retVal == 0)
		{
			if(this.getApptEndTime() == null && compareObj.getApptEndTime() != null)
				return -1;
			if(this.getApptEndTime() != null && compareObj.getApptEndTime() == null)
				return 1;
			if(this.getApptEndTime() != null && compareObj.getApptEndTime() != null)
				retVal = this.getApptEndTime().compareTo(compareObj.getApptEndTime());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.apptstarttime != null)
			count++;
		if(this.apptstatus != null)
			count++;
		if(this.apptstatusreas != null)
			count++;
		if(this.apptstatushistory != null)
			count++;
		if(this.seenby != null)
			count++;
		if(this.session != null)
			count++;
		if(this.appointmentdate != null)
			count++;
		if(this.arrivaltime != null)
			count++;
		if(this.seentime != null)
			count++;
		if(this.apptcompletetime != null)
			count++;
		if(this.requiresrebook != null)
			count++;
		if(this.currentstatusrecord != null)
			count++;
		if(this.outcome != null)
			count++;
		if(this.iscabbooking != null)
			count++;
		if(this.apptendtime != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.outcomecomments != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.appttrackingstatushistory != null)
			count++;
		if(this.theatrebooking != null)
			count++;
		if(this.sessionslot != null)
			count++;
		if(this.dummycolour != null)
			count++;
		if(this.durationhelper != null)
			count++;
		if(this.wasprinted != null)
			count++;
		if(this.bookingletter != null)
			count++;
		if(this.numprovidercancellations != null)
			count++;
		if(this.numpatientcancellations != null)
			count++;
		if(this.linkedapptstobecancelled != null)
			count++;
		if(this.date28dayrulebreach != null)
			count++;
		if(this.iswardattendance != null)
			count++;
		if(this.wardattendanceoutcome != null)
			count++;
		if(this.electivelist != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 34;
	}
	protected ims.framework.utils.Time apptstarttime;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatusreas;
	protected ims.scheduling.vo.Appointment_StatusVoCollection apptstatushistory;
	protected ims.core.vo.HcpLiteVo seenby;
	protected ims.scheduling.vo.SessionLiteVo session;
	protected ims.framework.utils.Date appointmentdate;
	protected ims.framework.utils.Time arrivaltime;
	protected ims.framework.utils.Time seentime;
	protected ims.framework.utils.Time apptcompletetime;
	protected Boolean requiresrebook;
	protected ims.scheduling.vo.Appointment_StatusVo currentstatusrecord;
	protected ims.scheduling.vo.lookups.ApptOutcome outcome;
	protected Boolean iscabbooking;
	protected ims.framework.utils.Time apptendtime;
	protected String comments;
	protected ims.core.vo.PatientShort patient;
	protected ims.core.vo.ActivityLiteVo activity;
	protected String outcomecomments;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.scheduling.vo.Appt_Tracking_Status_HistoryVoCollection appttrackingstatushistory;
	protected ims.scheduling.vo.TheatreBookingBaseVo theatrebooking;
	protected ims.scheduling.vo.SessionSlotForDNAVo sessionslot;
	protected ims.framework.utils.Color dummycolour;
	protected ims.scheduling.vo.AvailableDurationVo durationhelper;
	protected Boolean wasprinted;
	protected ims.core.vo.PatientDocumentLiteVo bookingletter;
	protected Integer numprovidercancellations;
	protected Integer numpatientcancellations;
	protected ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection linkedapptstobecancelled;
	protected ims.framework.utils.Date date28dayrulebreach;
	protected Boolean iswardattendance;
	protected ims.core.vo.lookups.WardAttendanceOutcome wardattendanceoutcome;
	protected ims.RefMan.vo.PatientElectiveListRefVo electivelist;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
