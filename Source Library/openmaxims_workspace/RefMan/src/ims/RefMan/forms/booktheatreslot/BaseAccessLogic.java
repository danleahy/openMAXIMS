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

package ims.RefMan.forms.booktheatreslot;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			Scheduling = new SchedulingForms();
			RefMan = new RefManForms();
		}
		public final class SchedulingForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SchedulingForms()
			{
				SortTheatreAppointments = new LocalFormName(114174);
				PrintAppointment = new LocalFormName(114163);
				SessionParentChildSlotDialog = new LocalFormName(114103);
				ModifyMultipleSlotsDialog = new LocalFormName(114104);
				SortFixedTheatreAppointments = new LocalFormName(114106);
				MoveAppointmentDialog = new LocalFormName(114107);
			}
			public final FormName SortTheatreAppointments;
			public final FormName PrintAppointment;
			public final FormName SessionParentChildSlotDialog;
			public final FormName ModifyMultipleSlotsDialog;
			public final FormName SortFixedTheatreAppointments;
			public final FormName MoveAppointmentDialog;
		}
		public final class RefManForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RefManForms()
			{
				BookTheatreSlotDetailDialog = new LocalFormName(114102);
				TheatreAvailability = new LocalFormName(134210);
				ERODDialog = new LocalFormName(134216);
			}
			public final FormName BookTheatreSlotDetailDialog;
			public final FormName TheatreAvailability;
			public final FormName ERODDialog;
		}

		public SchedulingForms Scheduling;
		public RefManForms RefMan;
	}
}
