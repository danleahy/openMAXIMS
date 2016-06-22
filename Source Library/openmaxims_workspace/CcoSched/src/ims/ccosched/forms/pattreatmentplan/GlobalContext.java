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

package ims.ccosched.forms.pattreatmentplan;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		CcoSched = new CcoSchedContext(context);
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
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");

		private ims.framework.Context context;
	}
	public final class CcoSchedContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CcoSchedContext(ims.framework.Context context)
		{
			this.context = context;

			TreatmentPlan = new TreatmentPlanContext(context);
			ActionUpdate = new ActionUpdateContext(context);
			ActivityView = new ActivityViewContext(context);
			CancelledAppointments = new CancelledAppointmentsContext(context);
			Rebooking = new RebookingContext(context);
		}
		public final class TreatmentPlanContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private TreatmentPlanContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getActionIDIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanActionID.getValueIsNull(context);
			}
			public String getActionID()
			{
				return (String)cx_CcoSchedTreatmentPlanActionID.getValue(context);
			}
		public void setActionID(String value)
		{
				cx_CcoSchedTreatmentPlanActionID.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanActionID = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.ActionID", "_cv_CcoSched.TreatmentPlan.ActionID");
			public boolean getIgnoreActionID2IsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanIgnoreActionID2.getValueIsNull(context);
			}
			public Boolean getIgnoreActionID2()
			{
				return (Boolean)cx_CcoSchedTreatmentPlanIgnoreActionID2.getValue(context);
			}
		public void setIgnoreActionID2(Boolean value)
		{
				cx_CcoSchedTreatmentPlanIgnoreActionID2.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanIgnoreActionID2 = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.IgnoreActionID2", "_cv_CcoSched.TreatmentPlan.IgnoreActionID2");
			public boolean getFurtherAppointmentIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanFurtherAppointment.getValueIsNull(context);
			}
			public Boolean getFurtherAppointment()
			{
				return (Boolean)cx_CcoSchedTreatmentPlanFurtherAppointment.getValue(context);
			}
		public void setFurtherAppointment(Boolean value)
		{
				cx_CcoSchedTreatmentPlanFurtherAppointment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanFurtherAppointment = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.FurtherAppointment", "_cv_CcoSched.TreatmentPlan.FurtherAppointment");
			public boolean getTreatmentPlanUpdateScreenModeIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanTreatmentPlanUpdateScreenMode.getValueIsNull(context);
			}
			public Boolean getTreatmentPlanUpdateScreenMode()
			{
				return (Boolean)cx_CcoSchedTreatmentPlanTreatmentPlanUpdateScreenMode.getValue(context);
			}
		public void setTreatmentPlanUpdateScreenMode(Boolean value)
		{
				cx_CcoSchedTreatmentPlanTreatmentPlanUpdateScreenMode.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanTreatmentPlanUpdateScreenMode = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.TreatmentPlanUpdateScreenMode", "_cv_CcoSched.TreatmentPlan.TreatmentPlanUpdateScreenMode");
			public boolean getActionModeIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanActionMode.getValueIsNull(context);
			}
			public Boolean getActionMode()
			{
				return (Boolean)cx_CcoSchedTreatmentPlanActionMode.getValue(context);
			}
		public void setActionMode(Boolean value)
		{
				cx_CcoSchedTreatmentPlanActionMode.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanActionMode = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.ActionMode", "_cv_CcoSched.TreatmentPlan.ActionMode");
			public boolean getActionUpdateModeIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanActionUpdateMode.getValueIsNull(context);
			}
			public Integer getActionUpdateMode()
			{
				return (Integer)cx_CcoSchedTreatmentPlanActionUpdateMode.getValue(context);
			}
		public void setActionUpdateMode(Integer value)
		{
				cx_CcoSchedTreatmentPlanActionUpdateMode.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanActionUpdateMode = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.ActionUpdateMode", "_cv_CcoSched.TreatmentPlan.ActionUpdateMode");
			public boolean getTreatmentPlanUpdateModeIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanTreatmentPlanUpdateMode.getValueIsNull(context);
			}
			public Integer getTreatmentPlanUpdateMode()
			{
				return (Integer)cx_CcoSchedTreatmentPlanTreatmentPlanUpdateMode.getValue(context);
			}
		public void setTreatmentPlanUpdateMode(Integer value)
		{
				cx_CcoSchedTreatmentPlanTreatmentPlanUpdateMode.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanTreatmentPlanUpdateMode = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.TreatmentPlanUpdateMode", "_cv_CcoSched.TreatmentPlan.TreatmentPlanUpdateMode");
			public boolean getSelectedPlanIsNotNull()
			{
				return !cx_CcoSchedTreatmentPlanSelectedPlan.getValueIsNull(context);
			}
			public ims.dto.client.Sd_comp_plan getSelectedPlan()
			{
				return (ims.dto.client.Sd_comp_plan)cx_CcoSchedTreatmentPlanSelectedPlan.getValue(context);
			}
		public void setSelectedPlan(ims.dto.client.Sd_comp_plan value)
		{
				cx_CcoSchedTreatmentPlanSelectedPlan.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedTreatmentPlanSelectedPlan = new ims.framework.ContextVariable("CcoSched.TreatmentPlan.SelectedPlan", "_cv_CcoSched.TreatmentPlan.SelectedPlan");
			private ims.framework.Context context;
		}
		public final class ActionUpdateContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ActionUpdateContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getActionInsertedIdIsNotNull()
			{
				return !cx_CcoSchedActionUpdateActionInsertedId.getValueIsNull(context);
			}
			public String getActionInsertedId()
			{
				return (String)cx_CcoSchedActionUpdateActionInsertedId.getValue(context);
			}
		public void setActionInsertedId(String value)
		{
				cx_CcoSchedActionUpdateActionInsertedId.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActionUpdateActionInsertedId = new ims.framework.ContextVariable("CcoSched.ActionUpdate.ActionInsertedId", "_cv_CcoSched.ActionUpdate.ActionInsertedId");
			public boolean getTreatmentPlanActionsIsNotNull()
			{
				return !cx_CcoSchedActionUpdateTreatmentPlanActions.getValueIsNull(context);
			}
			public ims.ccosched.vo.PatTreatPlanActionVoCollection getTreatmentPlanActions()
			{
				return (ims.ccosched.vo.PatTreatPlanActionVoCollection)cx_CcoSchedActionUpdateTreatmentPlanActions.getValue(context);
			}
		public void setTreatmentPlanActions(ims.ccosched.vo.PatTreatPlanActionVoCollection value)
		{
				cx_CcoSchedActionUpdateTreatmentPlanActions.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActionUpdateTreatmentPlanActions = new ims.framework.ContextVariable("CcoSched.ActionUpdate.TreatmentPlanActions", "_cv_CcoSched.ActionUpdate.TreatmentPlanActions");
			private ims.framework.Context context;
		}
		public final class ActivityViewContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ActivityViewContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getActionIDIsNotNull()
			{
				return !cx_CcoSchedActivityViewActionID.getValueIsNull(context);
			}
			public String getActionID()
			{
				return (String)cx_CcoSchedActivityViewActionID.getValue(context);
			}
		public void setActionID(String value)
		{
				cx_CcoSchedActivityViewActionID.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedActivityViewActionID = new ims.framework.ContextVariable("CcoSched.ActivityView.ActionID", "_cv_CcoSched.ActivityView.ActionID");
			private ims.framework.Context context;
		}
		public final class CancelledAppointmentsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CancelledAppointmentsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getRebookAppointmentDetailIsNotNull()
			{
				return !cx_CcoSchedCancelledAppointmentsRebookAppointmentDetail.getValueIsNull(context);
			}
			public String getRebookAppointmentDetail()
			{
				return (String)cx_CcoSchedCancelledAppointmentsRebookAppointmentDetail.getValue(context);
			}
		public void setRebookAppointmentDetail(String value)
		{
				cx_CcoSchedCancelledAppointmentsRebookAppointmentDetail.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedCancelledAppointmentsRebookAppointmentDetail = new ims.framework.ContextVariable("CcoSched.CancelledAppointments.RebookAppointmentDetail", "_cv_CcoSched.CancelledAppointments.RebookAppointmentDetail");
			private ims.framework.Context context;
		}
		public final class RebookingContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RebookingContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getRebookingSucceededIsNotNull()
			{
				return !cx_CcoSchedRebookingRebookingSucceeded.getValueIsNull(context);
			}
			public Boolean getRebookingSucceeded()
			{
				return (Boolean)cx_CcoSchedRebookingRebookingSucceeded.getValue(context);
			}
		public void setRebookingSucceeded(Boolean value)
		{
				cx_CcoSchedRebookingRebookingSucceeded.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedRebookingRebookingSucceeded = new ims.framework.ContextVariable("CcoSched.Rebooking.RebookingSucceeded", "_cv_CcoSched.Rebooking.RebookingSucceeded");
			private ims.framework.Context context;
		}


		public TreatmentPlanContext TreatmentPlan;
		public ActionUpdateContext ActionUpdate;
		public ActivityViewContext ActivityView;
		public CancelledAppointmentsContext CancelledAppointments;
		public RebookingContext Rebooking;
		private ims.framework.Context context;
	}
	public boolean getPatTreatmentPlanActionIsNotNull()
	{
		return !cx_PatTreatmentPlanAction.getValueIsNull(context);
	}
	public ims.ccosched.vo.PatTreatPlanActionVo getPatTreatmentPlanAction()
	{
		return (ims.ccosched.vo.PatTreatPlanActionVo)cx_PatTreatmentPlanAction.getValue(context);
	}
		public void setPatTreatmentPlanAction(ims.ccosched.vo.PatTreatPlanActionVo value)
		{
		cx_PatTreatmentPlanAction.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PatTreatmentPlanAction = new ims.framework.ContextVariable("PatTreatmentPlanAction", "_cv_PatTreatmentPlanAction");
	public boolean getPatTreatmentPlanIsNotNull()
	{
		return !cx_PatTreatmentPlan.getValueIsNull(context);
	}
	public ims.ccosched.vo.PatTreatmentPlanLiteVo getPatTreatmentPlan()
	{
		return (ims.ccosched.vo.PatTreatmentPlanLiteVo)cx_PatTreatmentPlan.getValue(context);
	}
		public void setPatTreatmentPlan(ims.ccosched.vo.PatTreatmentPlanLiteVo value)
		{
		cx_PatTreatmentPlan.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_PatTreatmentPlan = new ims.framework.ContextVariable("PatTreatmentPlan", "_cv_PatTreatmentPlan");

	public CoreContext Core;
	public CcoSchedContext CcoSched;
}
