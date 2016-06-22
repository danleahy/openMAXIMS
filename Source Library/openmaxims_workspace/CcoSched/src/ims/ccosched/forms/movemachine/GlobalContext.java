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

package ims.ccosched.forms.movemachine;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		CcoSched = new CcoSchedContext(context);
	}
	public final class CcoSchedContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CcoSchedContext(ims.framework.Context context)
		{
			this.context = context;

			PatientAppointments = new PatientAppointmentsContext(context);
		}
		public final class PatientAppointmentsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientAppointmentsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getChildrenIsNotNull()
			{
				return !cx_CcoSchedPatientAppointmentsChildren.getValueIsNull(context);
			}
			public java.util.ArrayList getChildren()
			{
				return (java.util.ArrayList)cx_CcoSchedPatientAppointmentsChildren.getValue(context);
			}
		public void setChildren(java.util.ArrayList value)
		{
				cx_CcoSchedPatientAppointmentsChildren.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedPatientAppointmentsChildren = new ims.framework.ContextVariable("CcoSched.PatientAppointments.Children", "_cv_CcoSched.PatientAppointments.Children");
			public boolean getParentIsNotNull()
			{
				return !cx_CcoSchedPatientAppointmentsParent.getValueIsNull(context);
			}
			public ims.dto.client.Sd_appt getParent()
			{
				return (ims.dto.client.Sd_appt)cx_CcoSchedPatientAppointmentsParent.getValue(context);
			}
		public void setParent(ims.dto.client.Sd_appt value)
		{
				cx_CcoSchedPatientAppointmentsParent.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedPatientAppointmentsParent = new ims.framework.ContextVariable("CcoSched.PatientAppointments.Parent", "_cv_CcoSched.PatientAppointments.Parent");
			private ims.framework.Context context;
		}

		public boolean getLoggedInUserIdIsNotNull()
		{
			return !cx_CcoSchedLoggedInUserId.getValueIsNull(context);
		}
		public String getLoggedInUserId()
		{
			return (String)cx_CcoSchedLoggedInUserId.getValue(context);
		}

		private ims.framework.ContextVariable cx_CcoSchedLoggedInUserId = new ims.framework.ContextVariable("CcoSched.LoggedInUserId", "_cvp_CcoSched.LoggedInUserId");

		public PatientAppointmentsContext PatientAppointments;
		private ims.framework.Context context;
	}

	public CcoSchedContext CcoSched;
}
