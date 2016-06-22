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

package ims.core.forms.vitalsignsbaselineandall;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Assessment = new AssessmentContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getVitalSignIsNotNull()
		{
			return !cx_CoreVitalSign.getValueIsNull(context);
		}
		public ims.core.vo.VitalSignsVo getVitalSign()
		{
			return (ims.core.vo.VitalSignsVo)cx_CoreVitalSign.getValue(context);
		}
		public void setVitalSign(ims.core.vo.VitalSignsVo value)
		{
			cx_CoreVitalSign.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSign = new ims.framework.ContextVariable("Core.VitalSign", "_cv_Core.VitalSign");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
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
		public boolean getVitalSignsEscalationScoreIsNotNull()
		{
			return !cx_CoreVitalSignsEscalationScore.getValueIsNull(context);
		}
		public String getVitalSignsEscalationScore()
		{
			return (String)cx_CoreVitalSignsEscalationScore.getValue(context);
		}
		public void setVitalSignsEscalationScore(String value)
		{
			cx_CoreVitalSignsEscalationScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSignsEscalationScore = new ims.framework.ContextVariable("Core.VitalSignsEscalationScore", "_cv_Core.VitalSignsEscalationScore");
		public boolean getVitalSignsEscalationTextIsNotNull()
		{
			return !cx_CoreVitalSignsEscalationText.getValueIsNull(context);
		}
		public String getVitalSignsEscalationText()
		{
			return (String)cx_CoreVitalSignsEscalationText.getValue(context);
		}
		public void setVitalSignsEscalationText(String value)
		{
			cx_CoreVitalSignsEscalationText.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSignsEscalationText = new ims.framework.ContextVariable("Core.VitalSignsEscalationText", "_cv_Core.VitalSignsEscalationText");
		public boolean getPatientAssessmentFullIsNotNull()
		{
			return !cx_CorePatientAssessmentFull.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientAssessmentVo getPatientAssessmentFull()
		{
			return (ims.assessment.vo.PatientAssessmentVo)cx_CorePatientAssessmentFull.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientAssessmentFull = new ims.framework.ContextVariable("Core.PatientAssessmentFull", "_cv_Core.PatientAssessmentFull");
		public boolean getUnrecordedObservationsReasonIsNotNull()
		{
			return !cx_CoreUnrecordedObservationsReason.getValueIsNull(context);
		}
		public ims.core.vo.UnrecordedObservationsReasonVo getUnrecordedObservationsReason()
		{
			return (ims.core.vo.UnrecordedObservationsReasonVo)cx_CoreUnrecordedObservationsReason.getValue(context);
		}
		public void setUnrecordedObservationsReason(ims.core.vo.UnrecordedObservationsReasonVo value)
		{
			cx_CoreUnrecordedObservationsReason.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreUnrecordedObservationsReason = new ims.framework.ContextVariable("Core.UnrecordedObservationsReason", "_cv_Core.UnrecordedObservationsReason");
		public boolean getIdFormIsNotNull()
		{
			return !cx_CoreIdForm.getValueIsNull(context);
		}
		public Integer getIdForm()
		{
			return (Integer)cx_CoreIdForm.getValue(context);
		}
		public void setIdForm(Integer value)
		{
			cx_CoreIdForm.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreIdForm = new ims.framework.ContextVariable("Core.IdForm", "_cv_Core.IdForm");

		private ims.framework.Context context;
	}
	public final class AssessmentContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AssessmentContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getIsDynamicAssessmentOpenedForPreviewIsNotNull()
		{
			return !cx_AssessmentIsDynamicAssessmentOpenedForPreview.getValueIsNull(context);
		}
		public Boolean getIsDynamicAssessmentOpenedForPreview()
		{
			return (Boolean)cx_AssessmentIsDynamicAssessmentOpenedForPreview.getValue(context);
		}
		public void setIsDynamicAssessmentOpenedForPreview(Boolean value)
		{
			cx_AssessmentIsDynamicAssessmentOpenedForPreview.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentIsDynamicAssessmentOpenedForPreview = new ims.framework.ContextVariable("Assessment.IsDynamicAssessmentOpenedForPreview", "_cv_Assessment.IsDynamicAssessmentOpenedForPreview");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public AssessmentContext Assessment;
}
