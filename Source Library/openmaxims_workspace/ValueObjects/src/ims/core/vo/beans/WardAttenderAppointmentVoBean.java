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

public class WardAttenderAppointmentVoBean extends ims.vo.ValueObjectBean
{
	public WardAttenderAppointmentVoBean()
	{
	}
	public WardAttenderAppointmentVoBean(ims.core.vo.WardAttenderAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.comments = vo.getComments();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityWithImageLiteVoBean)vo.getActivity().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteWithListOwnerLiteVoBean)vo.getSession().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.haselectivelist = vo.getHasElectiveList();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentLiteVoBean)vo.getBookingLetter().getBean();
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean)vo.getReferral().getBean();
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean();
		this.bookingcomments = vo.getBookingComments();
		this.currentappttrakingstatus = vo.getCurrentApptTrakingStatus() == null ? null : (ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean)vo.getCurrentApptTrakingStatus().getBean();
		this.appointmenttrackingstatus = vo.getAppointmentTrackingStatus() == null ? null : (ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean)vo.getAppointmentTrackingStatus().getBean();
		this.iswardattendance = vo.getIsWardAttendance();
		this.wardattendanceoutcome = vo.getWardAttendanceOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceOutcome().getBean();
		this.wardattendanceoutcomecomment = vo.getWardAttendanceOutcomeComment();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.WardAttenderAppointmentVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.comments = vo.getComments();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityWithImageLiteVoBean)vo.getActivity().getBean(map);
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionLiteWithListOwnerLiteVoBean)vo.getSession().getBean(map);
		this.iscabbooking = vo.getIsCABBooking();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.haselectivelist = vo.getHasElectiveList();
		this.wasprinted = vo.getWasPrinted();
		this.bookingletter = vo.getBookingLetter() == null ? null : (ims.core.vo.beans.PatientDocumentLiteVoBean)vo.getBookingLetter().getBean(map);
		this.referral = vo.getReferral() == null ? null : (ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean)vo.getReferral().getBean(map);
		this.icpinfo = vo.getICPInfo() == null ? null : (ims.icp.vo.beans.PatientICPLiteVoBean)vo.getICPInfo().getBean(map);
		this.bookingcomments = vo.getBookingComments();
		this.currentappttrakingstatus = vo.getCurrentApptTrakingStatus() == null ? null : (ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean)vo.getCurrentApptTrakingStatus().getBean(map);
		this.appointmenttrackingstatus = vo.getAppointmentTrackingStatus() == null ? null : (ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean)vo.getAppointmentTrackingStatus().getBean(map);
		this.iswardattendance = vo.getIsWardAttendance();
		this.wardattendanceoutcome = vo.getWardAttendanceOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceOutcome().getBean();
		this.wardattendanceoutcomecomment = vo.getWardAttendanceOutcomeComment();
	}

	public ims.core.vo.WardAttenderAppointmentVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.WardAttenderAppointmentVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.WardAttenderAppointmentVo vo = null;
		if(map != null)
			vo = (ims.core.vo.WardAttenderAppointmentVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.WardAttenderAppointmentVo();
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
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.core.vo.beans.ActivityWithImageLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityWithImageLiteVoBean value)
	{
		this.activity = value;
	}
	public ims.scheduling.vo.beans.SessionLiteWithListOwnerLiteVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionLiteWithListOwnerLiteVoBean value)
	{
		this.session = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public Boolean getHasElectiveList()
	{
		return this.haselectivelist;
	}
	public void setHasElectiveList(Boolean value)
	{
		this.haselectivelist = value;
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
	public ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean value)
	{
		this.referral = value;
	}
	public ims.icp.vo.beans.PatientICPLiteVoBean getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.beans.PatientICPLiteVoBean value)
	{
		this.icpinfo = value;
	}
	public String getBookingComments()
	{
		return this.bookingcomments;
	}
	public void setBookingComments(String value)
	{
		this.bookingcomments = value;
	}
	public ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean getCurrentApptTrakingStatus()
	{
		return this.currentappttrakingstatus;
	}
	public void setCurrentApptTrakingStatus(ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean value)
	{
		this.currentappttrakingstatus = value;
	}
	public ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean getAppointmentTrackingStatus()
	{
		return this.appointmenttrackingstatus;
	}
	public void setAppointmentTrackingStatus(ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean value)
	{
		this.appointmenttrackingstatus = value;
	}
	public Boolean getIsWardAttendance()
	{
		return this.iswardattendance;
	}
	public void setIsWardAttendance(Boolean value)
	{
		this.iswardattendance = value;
	}
	public ims.vo.LookupInstanceBean getWardAttendanceOutcome()
	{
		return this.wardattendanceoutcome;
	}
	public void setWardAttendanceOutcome(ims.vo.LookupInstanceBean value)
	{
		this.wardattendanceoutcome = value;
	}
	public String getWardAttendanceOutcomeComment()
	{
		return this.wardattendanceoutcomecomment;
	}
	public void setWardAttendanceOutcomeComment(String value)
	{
		this.wardattendanceoutcomecomment = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.vo.LookupInstanceBean apptstatus;
	private String comments;
	private ims.core.vo.beans.ActivityWithImageLiteVoBean activity;
	private ims.scheduling.vo.beans.SessionLiteWithListOwnerLiteVoBean session;
	private Boolean iscabbooking;
	private ims.core.vo.beans.PatientShortBean patient;
	private Boolean haselectivelist;
	private Boolean wasprinted;
	private ims.core.vo.beans.PatientDocumentLiteVoBean bookingletter;
	private ims.RefMan.vo.beans.CatsReferralBreachDatesVoBean referral;
	private ims.icp.vo.beans.PatientICPLiteVoBean icpinfo;
	private String bookingcomments;
	private ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean currentappttrakingstatus;
	private ims.admin.vo.beans.AppointmentTrackingstatusColourConfigVoBean appointmenttrackingstatus;
	private Boolean iswardattendance;
	private ims.vo.LookupInstanceBean wardattendanceoutcome;
	private String wardattendanceoutcomecomment;
}
