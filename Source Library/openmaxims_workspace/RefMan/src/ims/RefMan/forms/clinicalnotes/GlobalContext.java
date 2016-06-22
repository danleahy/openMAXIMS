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

package ims.RefMan.forms.clinicalnotes;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
		Core = new CoreContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");
		public boolean getReferralClinicalNotesIsNotNull()
		{
			return !cx_RefManReferralClinicalNotes.getValueIsNull(context);
		}
		public ims.RefMan.vo.ReferralClinicalNotesVo getReferralClinicalNotes()
		{
			return (ims.RefMan.vo.ReferralClinicalNotesVo)cx_RefManReferralClinicalNotes.getValue(context);
		}
		public void setReferralClinicalNotes(ims.RefMan.vo.ReferralClinicalNotesVo value)
		{
			cx_RefManReferralClinicalNotes.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralClinicalNotes = new ims.framework.ContextVariable("RefMan.ReferralClinicalNotes", "_cv_RefMan.ReferralClinicalNotes");
		public boolean getAppointmentClinicalNoteIsNotNull()
		{
			return !cx_RefManAppointmentClinicalNote.getValueIsNull(context);
		}
		public ims.RefMan.vo.AppointmentClinicalNotesVo getAppointmentClinicalNote()
		{
			return (ims.RefMan.vo.AppointmentClinicalNotesVo)cx_RefManAppointmentClinicalNote.getValue(context);
		}
		public void setAppointmentClinicalNote(ims.RefMan.vo.AppointmentClinicalNotesVo value)
		{
			cx_RefManAppointmentClinicalNote.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManAppointmentClinicalNote = new ims.framework.ContextVariable("RefMan.AppointmentClinicalNote", "_cv_RefMan.AppointmentClinicalNote");
		public boolean getAppointmentForPatientDiagnosisOrProceduresIsNotNull()
		{
			return !cx_RefManAppointmentForPatientDiagnosisOrProcedures.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getAppointmentForPatientDiagnosisOrProcedures()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_RefManAppointmentForPatientDiagnosisOrProcedures.getValue(context);
		}
		public void setAppointmentForPatientDiagnosisOrProcedures(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_RefManAppointmentForPatientDiagnosisOrProcedures.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManAppointmentForPatientDiagnosisOrProcedures = new ims.framework.ContextVariable("RefMan.AppointmentForPatientDiagnosisOrProcedures", "_cv_RefMan.AppointmentForPatientDiagnosisOrProcedures");
		public boolean getPreviousReferralsIsNotNull()
		{
			return !cx_RefManPreviousReferrals.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralForClinicalNotesVoCollection getPreviousReferrals()
		{
			return (ims.RefMan.vo.CatsReferralForClinicalNotesVoCollection)cx_RefManPreviousReferrals.getValue(context);
		}
		public void setPreviousReferrals(ims.RefMan.vo.CatsReferralForClinicalNotesVoCollection value)
		{
			cx_RefManPreviousReferrals.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManPreviousReferrals = new ims.framework.ContextVariable("RefMan.PreviousReferrals", "_cv_RefMan.PreviousReferrals");
		public boolean getAppointmentPatientDiagnosisIsNotNull()
		{
			return !cx_RefManAppointmentPatientDiagnosis.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientDiagnosisApptDetailVo getAppointmentPatientDiagnosis()
		{
			return (ims.RefMan.vo.PatientDiagnosisApptDetailVo)cx_RefManAppointmentPatientDiagnosis.getValue(context);
		}
		public void setAppointmentPatientDiagnosis(ims.RefMan.vo.PatientDiagnosisApptDetailVo value)
		{
			cx_RefManAppointmentPatientDiagnosis.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManAppointmentPatientDiagnosis = new ims.framework.ContextVariable("RefMan.AppointmentPatientDiagnosis", "_cv_RefMan.AppointmentPatientDiagnosis");
		public boolean getAppointmentPatientProcedureIsNotNull()
		{
			return !cx_RefManAppointmentPatientProcedure.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientProcedureApptDetailVo getAppointmentPatientProcedure()
		{
			return (ims.RefMan.vo.PatientProcedureApptDetailVo)cx_RefManAppointmentPatientProcedure.getValue(context);
		}
		public void setAppointmentPatientProcedure(ims.RefMan.vo.PatientProcedureApptDetailVo value)
		{
			cx_RefManAppointmentPatientProcedure.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManAppointmentPatientProcedure = new ims.framework.ContextVariable("RefMan.AppointmentPatientProcedure", "_cv_RefMan.AppointmentPatientProcedure");

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

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}
		public void setEpisodeofCareShort(ims.core.vo.EpisodeofCareShortVo value)
		{
			cx_CoreEpisodeofCareShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
	public CoreContext Core;
}
