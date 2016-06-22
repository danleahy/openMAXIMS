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

package ims.pathways.forms.worklist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Pathways = new PathwaysContext(context);
		Core = new CoreContext(context);
	}
	public final class PathwaysContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PathwaysContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedPatientJourneyTargetIsNotNull()
		{
			return !cx_PathwaysSelectedPatientJourneyTarget.getValueIsNull(context);
		}
		public ims.pathways.vo.PatientJourneyTargetVo getSelectedPatientJourneyTarget()
		{
			return (ims.pathways.vo.PatientJourneyTargetVo)cx_PathwaysSelectedPatientJourneyTarget.getValue(context);
		}
		public void setSelectedPatientJourneyTarget(ims.pathways.vo.PatientJourneyTargetVo value)
		{
			cx_PathwaysSelectedPatientJourneyTarget.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysSelectedPatientJourneyTarget = new ims.framework.ContextVariable("Pathways.SelectedPatientJourneyTarget", "_cv_Pathways.SelectedPatientJourneyTarget");
		public boolean getSelectedPatientPathwayJourneyIsNotNull()
		{
			return !cx_PathwaysSelectedPatientPathwayJourney.getValueIsNull(context);
		}
		public ims.pathways.vo.PatientPathwayJourneyRefVo getSelectedPatientPathwayJourney()
		{
			return (ims.pathways.vo.PatientPathwayJourneyRefVo)cx_PathwaysSelectedPatientPathwayJourney.getValue(context);
		}
		public void setSelectedPatientPathwayJourney(ims.pathways.vo.PatientPathwayJourneyRefVo value)
		{
			cx_PathwaysSelectedPatientPathwayJourney.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysSelectedPatientPathwayJourney = new ims.framework.ContextVariable("Pathways.SelectedPatientPathwayJourney", "_cv_Pathways.SelectedPatientPathwayJourney");
		public boolean getWorkListSearchCriteriaIsNotNull()
		{
			return !cx_PathwaysWorkListSearchCriteria.getValueIsNull(context);
		}
		public ims.pathways.vo.WorkListSearchCriteriaVo getWorkListSearchCriteria()
		{
			return (ims.pathways.vo.WorkListSearchCriteriaVo)cx_PathwaysWorkListSearchCriteria.getValue(context);
		}
		public void setWorkListSearchCriteria(ims.pathways.vo.WorkListSearchCriteriaVo value)
		{
			cx_PathwaysWorkListSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysWorkListSearchCriteria = new ims.framework.ContextVariable("Pathways.WorkListSearchCriteria", "_cvp_Pathways.WorkListSearchCriteria");

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
		public boolean getReportIDIsNotNull()
		{
			return !cx_CoreReportID.getValueIsNull(context);
		}
		public Integer getReportID()
		{
			return (Integer)cx_CoreReportID.getValue(context);
		}
		public void setReportID(Integer value)
		{
			cx_CoreReportID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReportID = new ims.framework.ContextVariable("Core.ReportID", "_cv_Core.ReportID");
		public boolean getTemplateIDIsNotNull()
		{
			return !cx_CoreTemplateID.getValueIsNull(context);
		}
		public Integer getTemplateID()
		{
			return (Integer)cx_CoreTemplateID.getValue(context);
		}
		public void setTemplateID(Integer value)
		{
			cx_CoreTemplateID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplateID = new ims.framework.ContextVariable("Core.TemplateID", "_cv_Core.TemplateID");

		private ims.framework.Context context;
	}

	public PathwaysContext Pathways;
	public CoreContext Core;
}
