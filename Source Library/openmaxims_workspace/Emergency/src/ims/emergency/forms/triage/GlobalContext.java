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

package ims.emergency.forms.triage;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		Emergency = new EmergencyContext(context);
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
		public boolean getImsReportIdIsNotNull()
		{
			return !cx_CoreImsReportId.getValueIsNull(context);
		}
		public Integer getImsReportId()
		{
			return (Integer)cx_CoreImsReportId.getValue(context);
		}
		public void setImsReportId(Integer value)
		{
			cx_CoreImsReportId.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreImsReportId = new ims.framework.ContextVariable("Core.ImsReportId", "_cv_Core.ImsReportId");

		private ims.framework.Context context;
	}
	public final class EmergencyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private EmergencyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTriageProtocolAssessmentIsNotNull()
		{
			return !cx_EmergencyTriageProtocolAssessment.getValueIsNull(context);
		}
		public ims.emergency.vo.TriageProtocolAssessmentRefVo getTriageProtocolAssessment()
		{
			return (ims.emergency.vo.TriageProtocolAssessmentRefVo)cx_EmergencyTriageProtocolAssessment.getValue(context);
		}
		public void setTriageProtocolAssessment(ims.emergency.vo.TriageProtocolAssessmentRefVo value)
		{
			cx_EmergencyTriageProtocolAssessment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTriageProtocolAssessment = new ims.framework.ContextVariable("Emergency.TriageProtocolAssessment", "_cv_Emergency.TriageProtocolAssessment");
		public boolean getTriageIsNotNull()
		{
			return !cx_EmergencyTriage.getValueIsNull(context);
		}
		public ims.emergency.vo.TriageRefVo getTriage()
		{
			return (ims.emergency.vo.TriageRefVo)cx_EmergencyTriage.getValue(context);
		}
		public void setTriage(ims.emergency.vo.TriageRefVo value)
		{
			cx_EmergencyTriage.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTriage = new ims.framework.ContextVariable("Emergency.Triage", "_cv_Emergency.Triage");
		public boolean getMainPresentingProblemIsNotNull()
		{
			return !cx_EmergencyMainPresentingProblem.getValueIsNull(context);
		}
		public ims.clinical.vo.ClinicalProblemShortVo getMainPresentingProblem()
		{
			return (ims.clinical.vo.ClinicalProblemShortVo)cx_EmergencyMainPresentingProblem.getValue(context);
		}
		public void setMainPresentingProblem(ims.clinical.vo.ClinicalProblemShortVo value)
		{
			cx_EmergencyMainPresentingProblem.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyMainPresentingProblem = new ims.framework.ContextVariable("Emergency.MainPresentingProblem", "_cv_Emergency.MainPresentingProblem");
		public boolean getTrackingIsNotNull()
		{
			return !cx_EmergencyTracking.getValueIsNull(context);
		}
		public ims.emergency.vo.TrackingRefVo getTracking()
		{
			return (ims.emergency.vo.TrackingRefVo)cx_EmergencyTracking.getValue(context);
		}
		public void setTracking(ims.emergency.vo.TrackingRefVo value)
		{
			cx_EmergencyTracking.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyTracking = new ims.framework.ContextVariable("Emergency.Tracking", "_cv_Emergency.Tracking");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public EmergencyContext Emergency;
}
