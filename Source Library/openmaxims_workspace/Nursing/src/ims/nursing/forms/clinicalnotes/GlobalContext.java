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

package ims.nursing.forms.clinicalnotes;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		COE = new COEContext(context);
		Core = new CoreContext(context);
	}
	public final class COEContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private COEContext(ims.framework.Context context)
		{
			this.context = context;

			ClinicalNotes = new ClinicalNotesContext(context);
		}
		public final class ClinicalNotesContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicalNotesContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getCallingFormIsNotNull()
			{
				return !cx_COEClinicalNotesCallingForm.getValueIsNull(context);
			}
			public ims.framework.FormName getCallingForm()
			{
				return (ims.framework.FormName)cx_COEClinicalNotesCallingForm.getValue(context);
			}

			private ims.framework.ContextVariable cx_COEClinicalNotesCallingForm = new ims.framework.ContextVariable("COE.ClinicalNotes.CallingForm", "_cv_COE.ClinicalNotes.CallingForm");
			private ims.framework.Context context;
		}

		public boolean getClinicalNotesVoIsNotNull()
		{
			return !cx_COEClinicalNotesVo.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalNotesVo getClinicalNotesVo()
		{
			return (ims.core.vo.ClinicalNotesVo)cx_COEClinicalNotesVo.getValue(context);
		}

		private ims.framework.ContextVariable cx_COEClinicalNotesVo = new ims.framework.ContextVariable("COE.ClinicalNotesVo", "_cv_COE.ClinicalNotesVo");
		public boolean getCarePlanIsNotNull()
		{
			return !cx_COECarePlan.getValueIsNull(context);
		}
		public ims.nursing.vo.CarePlan getCarePlan()
		{
			return (ims.nursing.vo.CarePlan)cx_COECarePlan.getValue(context);
		}

		private ims.framework.ContextVariable cx_COECarePlan = new ims.framework.ContextVariable("COE.CarePlan", "_cv_COE.CarePlan");
		public boolean getCarePlanIDIsNotNull()
		{
			return !cx_COECarePlanID.getValueIsNull(context);
		}
		public Integer getCarePlanID()
		{
			return (Integer)cx_COECarePlanID.getValue(context);
		}

		private ims.framework.ContextVariable cx_COECarePlanID = new ims.framework.ContextVariable("COE.CarePlanID", "_cv_COE.CarePlanID");

		public ClinicalNotesContext ClinicalNotes;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}

	public COEContext COE;
	public CoreContext Core;
}
