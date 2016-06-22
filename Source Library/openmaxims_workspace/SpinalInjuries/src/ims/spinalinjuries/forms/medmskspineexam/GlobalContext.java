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

package ims.spinalinjuries.forms.medmskspineexam;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		SpinalInjuries = new SpinalInjuriesContext(context);
		Core = new CoreContext(context);
	}
	public final class SpinalInjuriesContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SpinalInjuriesContext(ims.framework.Context context)
		{
			this.context = context;

			Back = new BackContext(context);
		}
		public final class BackContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private BackContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getAdminSpineExamVoIsNotNull()
			{
				return !cx_SpinalInjuriesBackAdminSpineExamVo.getValueIsNull(context);
			}
			public ims.generalmedical.vo.AdmisSpineExamVo getAdminSpineExamVo()
			{
				return (ims.generalmedical.vo.AdmisSpineExamVo)cx_SpinalInjuriesBackAdminSpineExamVo.getValue(context);
			}
		public void setAdminSpineExamVo(ims.generalmedical.vo.AdmisSpineExamVo value)
		{
				cx_SpinalInjuriesBackAdminSpineExamVo.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_SpinalInjuriesBackAdminSpineExamVo = new ims.framework.ContextVariable("SpinalInjuries.Back.AdminSpineExamVo", "_cv_SpinalInjuries.Back.AdminSpineExamVo");
			public boolean getAreasIsNotNull()
			{
				return !cx_SpinalInjuriesBackAreas.getValueIsNull(context);
			}
			public ims.framework.controls.DrawingControlAreaCollection getAreas()
			{
				return (ims.framework.controls.DrawingControlAreaCollection)cx_SpinalInjuriesBackAreas.getValue(context);
			}
		public void setAreas(ims.framework.controls.DrawingControlAreaCollection value)
		{
				cx_SpinalInjuriesBackAreas.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_SpinalInjuriesBackAreas = new ims.framework.ContextVariable("SpinalInjuries.Back.Areas", "_cv_SpinalInjuries.Back.Areas");
			public boolean getGroupsIsNotNull()
			{
				return !cx_SpinalInjuriesBackGroups.getValueIsNull(context);
			}
			public ims.framework.controls.DrawingControlGroupCollection getGroups()
			{
				return (ims.framework.controls.DrawingControlGroupCollection)cx_SpinalInjuriesBackGroups.getValue(context);
			}
		public void setGroups(ims.framework.controls.DrawingControlGroupCollection value)
		{
				cx_SpinalInjuriesBackGroups.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_SpinalInjuriesBackGroups = new ims.framework.ContextVariable("SpinalInjuries.Back.Groups", "_cv_SpinalInjuries.Back.Groups");
			public boolean getMskSpineExamFindingVoIsNotNull()
			{
				return !cx_SpinalInjuriesBackMskSpineExamFindingVo.getValueIsNull(context);
			}
			public ims.generalmedical.vo.MskSpineExamFindingVo getMskSpineExamFindingVo()
			{
				return (ims.generalmedical.vo.MskSpineExamFindingVo)cx_SpinalInjuriesBackMskSpineExamFindingVo.getValue(context);
			}
		public void setMskSpineExamFindingVo(ims.generalmedical.vo.MskSpineExamFindingVo value)
		{
				cx_SpinalInjuriesBackMskSpineExamFindingVo.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_SpinalInjuriesBackMskSpineExamFindingVo = new ims.framework.ContextVariable("SpinalInjuries.Back.MskSpineExamFindingVo", "_cv_SpinalInjuries.Back.MskSpineExamFindingVo");
			private ims.framework.Context context;
		}

		public boolean getMedicalProbToSaveIsNotNull()
		{
			return !cx_SpinalInjuriesMedicalProbToSave.getValueIsNull(context);
		}
		public ims.generalmedical.vo.MedicalProbOnAdmisVo getMedicalProbToSave()
		{
			return (ims.generalmedical.vo.MedicalProbOnAdmisVo)cx_SpinalInjuriesMedicalProbToSave.getValue(context);
		}
		public void setMedicalProbToSave(ims.generalmedical.vo.MedicalProbOnAdmisVo value)
		{
			cx_SpinalInjuriesMedicalProbToSave.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SpinalInjuriesMedicalProbToSave = new ims.framework.ContextVariable("SpinalInjuries.MedicalProbToSave", "_cv_SpinalInjuries.MedicalProbToSave");

		public BackContext Back;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
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

	public SpinalInjuriesContext SpinalInjuries;
	public CoreContext Core;
}
