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

public class WardAttenderOutcomeVoBean extends ims.vo.ValueObjectBean
{
	public WardAttenderOutcomeVoBean()
	{
	}
	public WardAttenderOutcomeVoBean(ims.core.vo.WardAttenderOutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean();
		this.outpatientprocedures = vo.getOutpatientProcedures() == null ? null : vo.getOutpatientProcedures().getBeanCollection();
		this.wardattendancehcptype = vo.getWardAttendanceHcpType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceHcpType().getBean();
		this.wardattendanceoutcome = vo.getWardAttendanceOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceOutcome().getBean();
		this.wardattendanceoutcomecomment = vo.getWardAttendanceOutcomeComment();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.RefMan.vo.beans.SessionForAppointmentOutcomeVoBean)vo.getSession().getBean();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.seentime = vo.getSeenTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getSeenTime().getBean();
		this.apptstatushistory = vo.getApptStatusHistory() == null ? null : vo.getApptStatusHistory().getBeanCollection();
		this.appttrackingstatushistory = vo.getApptTrackingStatusHistory() == null ? null : vo.getApptTrackingStatusHistory().getBeanCollection();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.scheduling.vo.beans.Appointment_StatusVoBean)vo.getCurrentStatusRecord().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.WardAttenderOutcomeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.seenby = vo.getSeenBy() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSeenBy().getBean(map);
		this.outpatientprocedures = vo.getOutpatientProcedures() == null ? null : vo.getOutpatientProcedures().getBeanCollection();
		this.wardattendancehcptype = vo.getWardAttendanceHcpType() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceHcpType().getBean();
		this.wardattendanceoutcome = vo.getWardAttendanceOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getWardAttendanceOutcome().getBean();
		this.wardattendanceoutcomecomment = vo.getWardAttendanceOutcomeComment();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.RefMan.vo.beans.SessionForAppointmentOutcomeVoBean)vo.getSession().getBean(map);
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.seentime = vo.getSeenTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getSeenTime().getBean();
		this.apptstatushistory = vo.getApptStatusHistory() == null ? null : vo.getApptStatusHistory().getBeanCollection();
		this.appttrackingstatushistory = vo.getApptTrackingStatusHistory() == null ? null : vo.getApptTrackingStatusHistory().getBeanCollection();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.currentstatusrecord = vo.getCurrentStatusRecord() == null ? null : (ims.scheduling.vo.beans.Appointment_StatusVoBean)vo.getCurrentStatusRecord().getBean(map);
	}

	public ims.core.vo.WardAttenderOutcomeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.WardAttenderOutcomeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.WardAttenderOutcomeVo vo = null;
		if(map != null)
			vo = (ims.core.vo.WardAttenderOutcomeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.WardAttenderOutcomeVo();
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
	public ims.core.vo.beans.HcpLiteVoBean getSeenBy()
	{
		return this.seenby;
	}
	public void setSeenBy(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.seenby = value;
	}
	public ims.RefMan.vo.beans.PatientProcedureForAppointmentOutcomeVoBean[] getOutpatientProcedures()
	{
		return this.outpatientprocedures;
	}
	public void setOutpatientProcedures(ims.RefMan.vo.beans.PatientProcedureForAppointmentOutcomeVoBean[] value)
	{
		this.outpatientprocedures = value;
	}
	public ims.vo.LookupInstanceBean getWardAttendanceHcpType()
	{
		return this.wardattendancehcptype;
	}
	public void setWardAttendanceHcpType(ims.vo.LookupInstanceBean value)
	{
		this.wardattendancehcptype = value;
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
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.RefMan.vo.beans.SessionForAppointmentOutcomeVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.RefMan.vo.beans.SessionForAppointmentOutcomeVoBean value)
	{
		this.session = value;
	}
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.framework.utils.beans.TimeBean getSeenTime()
	{
		return this.seentime;
	}
	public void setSeenTime(ims.framework.utils.beans.TimeBean value)
	{
		this.seentime = value;
	}
	public ims.scheduling.vo.beans.Appointment_StatusVoBean[] getApptStatusHistory()
	{
		return this.apptstatushistory;
	}
	public void setApptStatusHistory(ims.scheduling.vo.beans.Appointment_StatusVoBean[] value)
	{
		this.apptstatushistory = value;
	}
	public ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean[] getApptTrackingStatusHistory()
	{
		return this.appttrackingstatushistory;
	}
	public void setApptTrackingStatusHistory(ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean[] value)
	{
		this.appttrackingstatushistory = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.scheduling.vo.beans.Appointment_StatusVoBean getCurrentStatusRecord()
	{
		return this.currentstatusrecord;
	}
	public void setCurrentStatusRecord(ims.scheduling.vo.beans.Appointment_StatusVoBean value)
	{
		this.currentstatusrecord = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.HcpLiteVoBean seenby;
	private ims.RefMan.vo.beans.PatientProcedureForAppointmentOutcomeVoBean[] outpatientprocedures;
	private ims.vo.LookupInstanceBean wardattendancehcptype;
	private ims.vo.LookupInstanceBean wardattendanceoutcome;
	private String wardattendanceoutcomecomment;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.RefMan.vo.beans.SessionForAppointmentOutcomeVoBean session;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean seentime;
	private ims.scheduling.vo.beans.Appointment_StatusVoBean[] apptstatushistory;
	private ims.scheduling.vo.beans.Appt_Tracking_Status_HistoryVoBean[] appttrackingstatushistory;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.scheduling.vo.beans.Appointment_StatusVoBean currentstatusrecord;
}