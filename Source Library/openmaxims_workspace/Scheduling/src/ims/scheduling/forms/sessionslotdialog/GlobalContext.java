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

package ims.scheduling.forms.sessionslotdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
		Scheduling = new SchedulingContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedSessionsIsNotNull()
		{
			return !cx_RefManSelectedSessions.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionShortVoCollection getSelectedSessions()
		{
			return (ims.scheduling.vo.SessionShortVoCollection)cx_RefManSelectedSessions.getValue(context);
		}

		private ims.framework.ContextVariable cx_RefManSelectedSessions = new ims.framework.ContextVariable("RefMan.SelectedSessions", "_cv_RefMan.SelectedSessions");
		public boolean getSelectedSessionIsNotNull()
		{
			return !cx_RefManSelectedSession.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionShortVo getSelectedSession()
		{
			return (ims.scheduling.vo.SessionShortVo)cx_RefManSelectedSession.getValue(context);
		}
		public void setSelectedSession(ims.scheduling.vo.SessionShortVo value)
		{
			cx_RefManSelectedSession.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSelectedSession = new ims.framework.ContextVariable("RefMan.SelectedSession", "_cv_RefMan.SelectedSession");

		private ims.framework.Context context;
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getDirectoryofServicesCollectionIsNotNull()
		{
			return !cx_SchedulingDirectoryofServicesCollection.getValueIsNull(context);
		}
		public ims.scheduling.vo.DirectoryOfServiceVoCollection getDirectoryofServicesCollection()
		{
			return (ims.scheduling.vo.DirectoryOfServiceVoCollection)cx_SchedulingDirectoryofServicesCollection.getValue(context);
		}
		public void setDirectoryofServicesCollection(ims.scheduling.vo.DirectoryOfServiceVoCollection value)
		{
			cx_SchedulingDirectoryofServicesCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingDirectoryofServicesCollection = new ims.framework.ContextVariable("Scheduling.DirectoryofServicesCollection", "_cv_Scheduling.DirectoryofServicesCollection");
		public boolean getSelectedSessionListOwnersIsNotNull()
		{
			return !cx_SchedulingSelectedSessionListOwners.getValueIsNull(context);
		}
		public ims.scheduling.vo.Session_ListOwnerVoCollection getSelectedSessionListOwners()
		{
			return (ims.scheduling.vo.Session_ListOwnerVoCollection)cx_SchedulingSelectedSessionListOwners.getValue(context);
		}
		public void setSelectedSessionListOwners(ims.scheduling.vo.Session_ListOwnerVoCollection value)
		{
			cx_SchedulingSelectedSessionListOwners.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSelectedSessionListOwners = new ims.framework.ContextVariable("Scheduling.SelectedSessionListOwners", "_cv_Scheduling.SelectedSessionListOwners");
		public boolean getSessionSlotIsNotNull()
		{
			return !cx_SchedulingSessionSlot.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionSlotVo getSessionSlot()
		{
			return (ims.scheduling.vo.SessionSlotVo)cx_SchedulingSessionSlot.getValue(context);
		}
		public void setSessionSlot(ims.scheduling.vo.SessionSlotVo value)
		{
			cx_SchedulingSessionSlot.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSessionSlot = new ims.framework.ContextVariable("Scheduling.SessionSlot", "_cv_Scheduling.SessionSlot");
		public boolean getBookingAppointmentIsNotNull()
		{
			return !cx_SchedulingBookingAppointment.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentVo getBookingAppointment()
		{
			return (ims.scheduling.vo.Booking_AppointmentVo)cx_SchedulingBookingAppointment.getValue(context);
		}
		public void setBookingAppointment(ims.scheduling.vo.Booking_AppointmentVo value)
		{
			cx_SchedulingBookingAppointment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointment = new ims.framework.ContextVariable("Scheduling.BookingAppointment", "_cv_Scheduling.BookingAppointment");
		public boolean getSessionSlotsIsNotNull()
		{
			return !cx_SchedulingSessionSlots.getValueIsNull(context);
		}
		public ims.scheduling.vo.SessionSlotVoCollection getSessionSlots()
		{
			return (ims.scheduling.vo.SessionSlotVoCollection)cx_SchedulingSessionSlots.getValue(context);
		}
		public void setSessionSlots(ims.scheduling.vo.SessionSlotVoCollection value)
		{
			cx_SchedulingSessionSlots.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingSessionSlots = new ims.framework.ContextVariable("Scheduling.SessionSlots", "_cv_Scheduling.SessionSlots");
		public boolean getBookingActivityIsNotNull()
		{
			return !cx_SchedulingBookingActivity.getValueIsNull(context);
		}
		public ims.core.resource.place.vo.ActivityRefVo getBookingActivity()
		{
			return (ims.core.resource.place.vo.ActivityRefVo)cx_SchedulingBookingActivity.getValue(context);
		}
		public void setBookingActivity(ims.core.resource.place.vo.ActivityRefVo value)
		{
			cx_SchedulingBookingActivity.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingActivity = new ims.framework.ContextVariable("Scheduling.BookingActivity", "_cv_Scheduling.BookingActivity");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
	public SchedulingContext Scheduling;
}
