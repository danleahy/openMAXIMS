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

package ims.emergency.forms.tracking;

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
			OCRR = new OCRRForms();
			Emergency = new EmergencyForms();
		}
		public final class OCRRForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private OCRRForms()
			{
				SelectAndOrderDialog = new LocalFormName(116131);
			}
			public final FormName SelectAndOrderDialog;
		}
		public final class EmergencyForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private EmergencyForms()
			{
				AllocateCubicle = new LocalFormName(129132);
				SendToXRay = new LocalFormName(129140);
				TrackingStatusDialog = new LocalFormName(129153);
				SendToAreaDialog = new LocalFormName(129121);
				BedAwaitingBedAvailable = new LocalFormName(129154);
				AttendanceHistory = new LocalFormName(129167);
				EventHistoryDialog = new LocalFormName(129164);
				AttendanceResultListDialog = new LocalFormName(129166);
				Triage = new LocalFormName(129103);
				TrackingSummary = new LocalFormName(129101);
				EDAssessmentComponent = new LocalFormName(129183);
				EDAssessmentDialog = new LocalFormName(129184);
				Tracking = new LocalFormName(129100);
				EDReferralToSpecialtyDialog = new LocalFormName(129188);
				EDSeenByAndCompleteDialog = new LocalFormName(129191);
				EDDecisionToAdmitDialog = new LocalFormName(129193);
				EDWhiteBoardDialog = new LocalFormName(129203);
				TransferDialog = new LocalFormName(129204);
				EDPartialAdmissionDialog = new LocalFormName(129205);
				EDWhiteBoardNewDialog = new LocalFormName(129216);
				EDAttendanceCommentsDialog = new LocalFormName(129238);
				EDSeenByNurseAndCompleteDialog = new LocalFormName(129239);
				PatientWhiteBoardEditAll = new LocalFormName(129235);
			}
			public final FormName AllocateCubicle;
			public final FormName SendToXRay;
			public final FormName TrackingStatusDialog;
			public final FormName SendToAreaDialog;
			public final FormName BedAwaitingBedAvailable;
			public final FormName AttendanceHistory;
			public final FormName EventHistoryDialog;
			public final FormName AttendanceResultListDialog;
			public final FormName Triage;
			public final FormName TrackingSummary;
			public final FormName EDAssessmentComponent;
			public final FormName EDAssessmentDialog;
			public final FormName Tracking;
			public final FormName EDReferralToSpecialtyDialog;
			public final FormName EDSeenByAndCompleteDialog;
			public final FormName EDDecisionToAdmitDialog;
			public final FormName EDWhiteBoardDialog;
			public final FormName TransferDialog;
			public final FormName EDPartialAdmissionDialog;
			public final FormName EDWhiteBoardNewDialog;
			public final FormName EDAttendanceCommentsDialog;
			public final FormName EDSeenByNurseAndCompleteDialog;
			public final FormName PatientWhiteBoardEditAll;
		}

		public OCRRForms OCRR;
		public EmergencyForms Emergency;
	}
}
