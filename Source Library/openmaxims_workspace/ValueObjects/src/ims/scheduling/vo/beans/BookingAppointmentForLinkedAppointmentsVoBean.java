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

public class BookingAppointmentForLinkedAppointmentsVoBean extends ims.vo.ValueObjectBean
{
	public BookingAppointmentForLinkedAppointmentsVoBean()
	{
	}
	public BookingAppointmentForLinkedAppointmentsVoBean(ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptendtime = vo.getApptEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptEndTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForAppLinkedVoBean)vo.getSession().getBean();
		this.linkedappointments = vo.getLinkedAppointments() == null ? null : vo.getLinkedAppointments().getBeanCollection();
		this.sessionslot = vo.getSessionSlot() == null ? null : new ims.vo.RefVoBean(vo.getSessionSlot().getBoId(), vo.getSessionSlot().getBoVersion());
		this.parentchildslot = vo.getParentChildSlot() == null ? null : new ims.vo.RefVoBean(vo.getParentChildSlot().getBoId(), vo.getParentChildSlot().getBoVersion());
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean();
		this.firstconsultationactivity = vo.getFirstConsultationActivity();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptendtime = vo.getApptEndTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptEndTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForAppLinkedVoBean)vo.getSession().getBean(map);
		this.linkedappointments = vo.getLinkedAppointments() == null ? null : vo.getLinkedAppointments().getBeanCollection();
		this.sessionslot = vo.getSessionSlot() == null ? null : new ims.vo.RefVoBean(vo.getSessionSlot().getBoId(), vo.getSessionSlot().getBoVersion());
		this.parentchildslot = vo.getParentChildSlot() == null ? null : new ims.vo.RefVoBean(vo.getParentChildSlot().getBoId(), vo.getParentChildSlot().getBoVersion());
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean(map);
		this.firstconsultationactivity = vo.getFirstConsultationActivity();
	}

	public ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVo();
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
	public ims.framework.utils.beans.TimeBean getApptEndTime()
	{
		return this.apptendtime;
	}
	public void setApptEndTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptendtime = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.scheduling.vo.beans.SessionForAppLinkedVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionForAppLinkedVoBean value)
	{
		this.session = value;
	}
	public ims.scheduling.vo.beans.BookingAppointmentForLinkedAppointmentsVoBean[] getLinkedAppointments()
	{
		return this.linkedappointments;
	}
	public void setLinkedAppointments(ims.scheduling.vo.beans.BookingAppointmentForLinkedAppointmentsVoBean[] value)
	{
		this.linkedappointments = value;
	}
	public ims.vo.RefVoBean getSessionSlot()
	{
		return this.sessionslot;
	}
	public void setSessionSlot(ims.vo.RefVoBean value)
	{
		this.sessionslot = value;
	}
	public ims.vo.RefVoBean getParentChildSlot()
	{
		return this.parentchildslot;
	}
	public void setParentChildSlot(ims.vo.RefVoBean value)
	{
		this.parentchildslot = value;
	}
	public ims.core.vo.beans.ActivityLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityLiteVoBean value)
	{
		this.activity = value;
	}
	public Boolean getFirstConsultationActivity()
	{
		return this.firstconsultationactivity;
	}
	public void setFirstConsultationActivity(Boolean value)
	{
		this.firstconsultationactivity = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.framework.utils.beans.TimeBean apptendtime;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.scheduling.vo.beans.SessionForAppLinkedVoBean session;
	private ims.scheduling.vo.beans.BookingAppointmentForLinkedAppointmentsVoBean[] linkedappointments;
	private ims.vo.RefVoBean sessionslot;
	private ims.vo.RefVoBean parentchildslot;
	private ims.core.vo.beans.ActivityLiteVoBean activity;
	private Boolean firstconsultationactivity;
}
