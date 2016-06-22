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

package ims.scheduling.vo.beans;

public class ReferralAppointmentDetailsBookingAppointmentVoBean extends ims.vo.ValueObjectBean
{
	public ReferralAppointmentDetailsBookingAppointmentVoBean()
	{
	}
	public ReferralAppointmentDetailsBookingAppointmentVoBean(ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForReferralAppointmentVoBean)vo.getSession().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.requiresrebook = vo.getRequiresRebook();
		this.sessionslot = vo.getSessionSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotVoBean)vo.getSessionSlot().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean();
		this.theatreslot = vo.getTheatreSlot() == null ? null : (ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean)vo.getTheatreSlot().getBean();
		this.bookingcomments = vo.getBookingComments();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentLiteVoBean)vo.getBookingLetter().getBean();
		this.numprovidercancellations = vo.getNumProviderCancellations();
		this.numpatientcancellations = vo.getNumPatientCancellations();
		this.linkedappointments = vo.getLinkedAppointments() == null ? null : vo.getLinkedAppointments().getBeanCollection();
		this.isflexibleappointment = vo.getIsFlexibleAppointment();
		this.iswardattendance = vo.getIsWardAttendance();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean();
		this.reasonforbreachingfirstapptkpi = vo.getReasonForBreachingFirstApptKPI() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForBreachingFirstApptKPI().getBean();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.RefMan.vo.beans.AppointmentStatusForElectiveListDetailsVoBean)vo.getCurrentStatusRecord().getBean();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.comments = vo.getComments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForReferralAppointmentVoBean)vo.getSession().getBean(map);
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.requiresrebook = vo.getRequiresRebook();
		this.sessionslot = vo.getSessionSlot() == null ? null : (ims.scheduling.vo.beans.SessionSlotVoBean)vo.getSessionSlot().getBean(map);
		this.iscabbooking = vo.getIsCABBooking();
		this.theatrebooking = vo.getTheatreBooking() == null ? null : (ims.scheduling.vo.beans.TheatreBookingBaseVoBean)vo.getTheatreBooking().getBean(map);
		this.theatreslot = vo.getTheatreSlot() == null ? null : (ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean)vo.getTheatreSlot().getBean(map);
		this.bookingcomments = vo.getBookingComments();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentLiteVoBean)vo.getBookingLetter().getBean(map);
		this.numprovidercancellations = vo.getNumProviderCancellations();
		this.numpatientcancellations = vo.getNumPatientCancellations();
		this.linkedappointments = vo.getLinkedAppointments() == null ? null : vo.getLinkedAppointments().getBeanCollection();
		this.isflexibleappointment = vo.getIsFlexibleAppointment();
		this.iswardattendance = vo.getIsWardAttendance();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean(map);
		this.reasonforbreachingfirstapptkpi = vo.getReasonForBreachingFirstApptKPI() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForBreachingFirstApptKPI().getBean();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.RefMan.vo.beans.AppointmentStatusForElectiveListDetailsVoBean)vo.getCurrentStatusRecord().getBean(map);
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.comments = vo.getComments();
	}

	public ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.ReferralAppointmentDetailsBookingAppointmentVo();
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
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.scheduling.vo.beans.SessionForReferralAppointmentVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionForReferralAppointmentVoBean value)
	{
		this.session = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public Boolean getRequiresRebook()
	{
		return this.requiresrebook;
	}
	public void setRequiresRebook(Boolean value)
	{
		this.requiresrebook = value;
	}
	public ims.scheduling.vo.beans.SessionSlotVoBean getSessionSlot()
	{
		return this.sessionslot;
	}
	public void setSessionSlot(ims.scheduling.vo.beans.SessionSlotVoBean value)
	{
		this.sessionslot = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.scheduling.vo.beans.TheatreBookingBaseVoBean getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.beans.TheatreBookingBaseVoBean value)
	{
		this.theatrebooking = value;
	}
	public ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean getTheatreSlot()
	{
		return this.theatreslot;
	}
	public void setTheatreSlot(ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean value)
	{
		this.theatreslot = value;
	}
	public String getBookingComments()
	{
		return this.bookingcomments;
	}
	public void setBookingComments(String value)
	{
		this.bookingcomments = value;
	}
	public Boolean getWasPrinted()
	{
		return this.wasprinted;
	}
	public void setWasPrinted(Boolean value)
	{
		this.wasprinted = value;
	}
	public ims.core.vo.beans.PatientDocumentLiteVoBean getBookingLetter()
	{
		return this.bookingletter;
	}
	public void setBookingLetter(ims.core.vo.beans.PatientDocumentLiteVoBean value)
	{
		this.bookingletter = value;
	}
	public Integer getNumProviderCancellations()
	{
		return this.numprovidercancellations;
	}
	public void setNumProviderCancellations(Integer value)
	{
		this.numprovidercancellations = value;
	}
	public Integer getNumPatientCancellations()
	{
		return this.numpatientcancellations;
	}
	public void setNumPatientCancellations(Integer value)
	{
		this.numpatientcancellations = value;
	}
	public ims.RefMan.vo.beans.LinkedAppointmentForReferralAppointmentComponentVoBean[] getLinkedAppointments()
	{
		return this.linkedappointments;
	}
	public void setLinkedAppointments(ims.RefMan.vo.beans.LinkedAppointmentForReferralAppointmentComponentVoBean[] value)
	{
		this.linkedappointments = value;
	}
	public Boolean getIsFlexibleAppointment()
	{
		return this.isflexibleappointment;
	}
	public void setIsFlexibleAppointment(Boolean value)
	{
		this.isflexibleappointment = value;
	}
	public Boolean getIsWardAttendance()
	{
		return this.iswardattendance;
	}
	public void setIsWardAttendance(Boolean value)
	{
		this.iswardattendance = value;
	}
	public ims.core.vo.beans.ActivityLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityLiteVoBean value)
	{
		this.activity = value;
	}
	public ims.vo.LookupInstanceBean getReasonForBreachingFirstApptKPI()
	{
		return this.reasonforbreachingfirstapptkpi;
	}
	public void setReasonForBreachingFirstApptKPI(ims.vo.LookupInstanceBean value)
	{
		this.reasonforbreachingfirstapptkpi = value;
	}
	public ims.RefMan.vo.beans.AppointmentStatusForElectiveListDetailsVoBean getCurrentStatusRecord()
	{
		return this.currentstatusrecord;
	}
	public void setCurrentStatusRecord(ims.RefMan.vo.beans.AppointmentStatusForElectiveListDetailsVoBean value)
	{
		this.currentstatusrecord = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.scheduling.vo.beans.SessionForReferralAppointmentVoBean session;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private Boolean requiresrebook;
	private ims.scheduling.vo.beans.SessionSlotVoBean sessionslot;
	private Boolean iscabbooking;
	private ims.scheduling.vo.beans.TheatreBookingBaseVoBean theatrebooking;
	private ims.scheduling.vo.beans.ToCameInTimeFromTheatreSlotVoBean theatreslot;
	private String bookingcomments;
	private Boolean wasprinted;
	private ims.core.vo.beans.PatientDocumentLiteVoBean bookingletter;
	private Integer numprovidercancellations;
	private Integer numpatientcancellations;
	private ims.RefMan.vo.beans.LinkedAppointmentForReferralAppointmentComponentVoBean[] linkedappointments;
	private Boolean isflexibleappointment;
	private Boolean iswardattendance;
	private ims.core.vo.beans.ActivityLiteVoBean activity;
	private ims.vo.LookupInstanceBean reasonforbreachingfirstapptkpi;
	private ims.RefMan.vo.beans.AppointmentStatusForElectiveListDetailsVoBean currentstatusrecord;
	private ims.vo.LookupInstanceBean outcome;
	private String comments;
}
