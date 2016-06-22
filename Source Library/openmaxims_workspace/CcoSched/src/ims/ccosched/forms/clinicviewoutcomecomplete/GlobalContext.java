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

package ims.ccosched.forms.clinicviewoutcomecomplete;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		CcoSched = new CcoSchedContext(context);
		Core = new CoreContext(context);
	}
	public final class CcoSchedContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CcoSchedContext(ims.framework.Context context)
		{
			this.context = context;

			ClinicView = new ClinicViewContext(context);
		}
		public final class ClinicViewContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicViewContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getApptDetailsIsNotNull()
			{
				return !cx_CcoSchedClinicViewApptDetails.getValueIsNull(context);
			}
			public ims.dto.client.Sd_appt_dts.Sd_appt_dtsRecord getApptDetails()
			{
				return (ims.dto.client.Sd_appt_dts.Sd_appt_dtsRecord)cx_CcoSchedClinicViewApptDetails.getValue(context);
			}
		public void setApptDetails(ims.dto.client.Sd_appt_dts.Sd_appt_dtsRecord value)
		{
				cx_CcoSchedClinicViewApptDetails.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewApptDetails = new ims.framework.ContextVariable("CcoSched.ClinicView.ApptDetails", "_cv_CcoSched.ClinicView.ApptDetails");
			public boolean getBookingCommentIsNotNull()
			{
				return !cx_CcoSchedClinicViewBookingComment.getValueIsNull(context);
			}
			public String getBookingComment()
			{
				return (String)cx_CcoSchedClinicViewBookingComment.getValue(context);
			}
		public void setBookingComment(String value)
		{
				cx_CcoSchedClinicViewBookingComment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewBookingComment = new ims.framework.ContextVariable("CcoSched.ClinicView.BookingComment", "_cv_CcoSched.ClinicView.BookingComment");
			public boolean getInpatientIsNotNull()
			{
				return !cx_CcoSchedClinicViewInpatient.getValueIsNull(context);
			}
			public String getInpatient()
			{
				return (String)cx_CcoSchedClinicViewInpatient.getValue(context);
			}
		public void setInpatient(String value)
		{
				cx_CcoSchedClinicViewInpatient.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewInpatient = new ims.framework.ContextVariable("CcoSched.ClinicView.Inpatient", "_cv_CcoSched.ClinicView.Inpatient");
			public boolean getPatientDetailsIsNotNull()
			{
				return !cx_CcoSchedClinicViewPatientDetails.getValueIsNull(context);
			}
			public ims.dto.client.Patient.PatientRecord getPatientDetails()
			{
				return (ims.dto.client.Patient.PatientRecord)cx_CcoSchedClinicViewPatientDetails.getValue(context);
			}
		public void setPatientDetails(ims.dto.client.Patient.PatientRecord value)
		{
				cx_CcoSchedClinicViewPatientDetails.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewPatientDetails = new ims.framework.ContextVariable("CcoSched.ClinicView.PatientDetails", "_cv_CcoSched.ClinicView.PatientDetails");
			public boolean getAppointmentHeaderIDIsNotNull()
			{
				return !cx_CcoSchedClinicViewAppointmentHeaderID.getValueIsNull(context);
			}
			public String getAppointmentHeaderID()
			{
				return (String)cx_CcoSchedClinicViewAppointmentHeaderID.getValue(context);
			}
		public void setAppointmentHeaderID(String value)
		{
				cx_CcoSchedClinicViewAppointmentHeaderID.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewAppointmentHeaderID = new ims.framework.ContextVariable("CcoSched.ClinicView.AppointmentHeaderID", "_cv_CcoSched.ClinicView.AppointmentHeaderID");
			public boolean getAppointmentIDIsNotNull()
			{
				return !cx_CcoSchedClinicViewAppointmentID.getValueIsNull(context);
			}
			public String getAppointmentID()
			{
				return (String)cx_CcoSchedClinicViewAppointmentID.getValue(context);
			}
		public void setAppointmentID(String value)
		{
				cx_CcoSchedClinicViewAppointmentID.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewAppointmentID = new ims.framework.ContextVariable("CcoSched.ClinicView.AppointmentID", "_cv_CcoSched.ClinicView.AppointmentID");
			public boolean getCategoryIsNotNull()
			{
				return !cx_CcoSchedClinicViewCategory.getValueIsNull(context);
			}
			public String getCategory()
			{
				return (String)cx_CcoSchedClinicViewCategory.getValue(context);
			}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewCategory = new ims.framework.ContextVariable("CcoSched.ClinicView.Category", "_cv_CcoSched.ClinicView.Category");
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

		public ClinicViewContext ClinicView;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}

	public CcoSchedContext CcoSched;
	public CoreContext Core;
}
