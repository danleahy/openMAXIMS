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

package ims.clinical.forms.clinicaldiassociations;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
		Core = new CoreContext(context);
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

			PatientSummary = new PatientSummaryContext(context);
		}
		public final class PatientSummaryContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientSummaryContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getPrimaryAssociationIsNotNull()
			{
				return !cx_ClinicalPatientSummaryPrimaryAssociation.getValueIsNull(context);
			}
			public ims.vo.ValueObject getPrimaryAssociation()
			{
				return (ims.vo.ValueObject)cx_ClinicalPatientSummaryPrimaryAssociation.getValue(context);
			}

			private ims.framework.ContextVariable cx_ClinicalPatientSummaryPrimaryAssociation = new ims.framework.ContextVariable("Clinical.PatientSummary.PrimaryAssociation", "_cv_Clinical.PatientSummary.PrimaryAssociation");
			private ims.framework.Context context;
		}

		public boolean getClinicalDIAssociationVoCollectionIsNotNull()
		{
			return !cx_ClinicalClinicalDIAssociationVoCollection.getValueIsNull(context);
		}
		public ims.clinical.vo.ClinicalDIAssociationVoCollection getClinicalDIAssociationVoCollection()
		{
			return (ims.clinical.vo.ClinicalDIAssociationVoCollection)cx_ClinicalClinicalDIAssociationVoCollection.getValue(context);
		}
		public void setClinicalDIAssociationVoCollection(ims.clinical.vo.ClinicalDIAssociationVoCollection value)
		{
			cx_ClinicalClinicalDIAssociationVoCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicalDIAssociationVoCollection = new ims.framework.ContextVariable("Clinical.ClinicalDIAssociationVoCollection", "_cv_Clinical.ClinicalDIAssociationVoCollection");
		public boolean getIsDiAssociationDialogOpenedFromPatientSummaryIsNotNull()
		{
			return !cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary.getValueIsNull(context);
		}
		public Boolean getIsDiAssociationDialogOpenedFromPatientSummary()
		{
			return (Boolean)cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary.getValue(context);
		}

		private ims.framework.ContextVariable cx_ClinicalIsDiAssociationDialogOpenedFromPatientSummary = new ims.framework.ContextVariable("Clinical.IsDiAssociationDialogOpenedFromPatientSummary", "_cv_Clinical.IsDiAssociationDialogOpenedFromPatientSummary");
		public boolean getIsDiagnosisRecordUpdatedIsNotNull()
		{
			return !cx_ClinicalIsDiagnosisRecordUpdated.getValueIsNull(context);
		}
		public Boolean getIsDiagnosisRecordUpdated()
		{
			return (Boolean)cx_ClinicalIsDiagnosisRecordUpdated.getValue(context);
		}
		public void setIsDiagnosisRecordUpdated(Boolean value)
		{
			cx_ClinicalIsDiagnosisRecordUpdated.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalIsDiagnosisRecordUpdated = new ims.framework.ContextVariable("Clinical.IsDiagnosisRecordUpdated", "_cv_Clinical.IsDiagnosisRecordUpdated");
		public boolean getClinicalDIassociationsFormModeIsNotNull()
		{
			return !cx_ClinicalClinicalDIassociationsFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getClinicalDIassociationsFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_ClinicalClinicalDIassociationsFormMode.getValue(context);
		}
		public void setClinicalDIassociationsFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_ClinicalClinicalDIassociationsFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicalDIassociationsFormMode = new ims.framework.ContextVariable("Clinical.ClinicalDIassociationsFormMode", "_cv_Clinical.ClinicalDIassociationsFormMode");

		public PatientSummaryContext PatientSummary;
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
		public boolean getYesNoDialogMessageIsNotNull()
		{
			return !cx_CoreYesNoDialogMessage.getValueIsNull(context);
		}
		public String getYesNoDialogMessage()
		{
			return (String)cx_CoreYesNoDialogMessage.getValue(context);
		}
		public void setYesNoDialogMessage(String value)
		{
			cx_CoreYesNoDialogMessage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreYesNoDialogMessage = new ims.framework.ContextVariable("Core.YesNoDialogMessage", "_cv_Core.YesNoDialogMessage");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
	public CoreContext Core;
}
