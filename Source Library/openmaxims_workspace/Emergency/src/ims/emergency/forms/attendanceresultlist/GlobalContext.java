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

package ims.emergency.forms.attendanceresultlist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		OCRR = new OCRRContext(context);
		Core = new CoreContext(context);
		Emergency = new EmergencyContext(context);
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

			PathologyResults = new PathologyResultsContext(context);
		}
		public final class PathologyResultsContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PathologyResultsContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getOrderIsNotNull()
			{
				return !cx_OCRRPathologyResultsOrder.getValueIsNull(context);
			}
			public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrder()
			{
				return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRRPathologyResultsOrder.getValue(context);
			}
		public void setOrder(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
		{
				cx_OCRRPathologyResultsOrder.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_OCRRPathologyResultsOrder = new ims.framework.ContextVariable("OCRR.PathologyResults.Order", "_cv_OCRR.PathologyResults.Order");
			private ims.framework.Context context;
		}

		public boolean getResultDisplayDateIsNotNull()
		{
			return !cx_OCRRResultDisplayDate.getValueIsNull(context);
		}
		public ims.framework.utils.Date getResultDisplayDate()
		{
			return (ims.framework.utils.Date)cx_OCRRResultDisplayDate.getValue(context);
		}
		public void setResultDisplayDate(ims.framework.utils.Date value)
		{
			cx_OCRRResultDisplayDate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRResultDisplayDate = new ims.framework.ContextVariable("OCRR.ResultDisplayDate", "_cv_OCRR.ResultDisplayDate");
		public boolean getSelectedPathRadResultsIsNotNull()
		{
			return !cx_OCRRSelectedPathRadResults.getValueIsNull(context);
		}
		public ims.ocrr.vo.OcsPathRadResultVoCollection getSelectedPathRadResults()
		{
			return (ims.ocrr.vo.OcsPathRadResultVoCollection)cx_OCRRSelectedPathRadResults.getValue(context);
		}
		public void setSelectedPathRadResults(ims.ocrr.vo.OcsPathRadResultVoCollection value)
		{
			cx_OCRRSelectedPathRadResults.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRSelectedPathRadResults = new ims.framework.ContextVariable("OCRR.SelectedPathRadResults", "_cv_OCRR.SelectedPathRadResults");
		public boolean getCurrentPathRadResultIsNotNull()
		{
			return !cx_OCRRCurrentPathRadResult.getValueIsNull(context);
		}
		public ims.ocrr.vo.OcsPathRadResultVo getCurrentPathRadResult()
		{
			return (ims.ocrr.vo.OcsPathRadResultVo)cx_OCRRCurrentPathRadResult.getValue(context);
		}
		public void setCurrentPathRadResult(ims.ocrr.vo.OcsPathRadResultVo value)
		{
			cx_OCRRCurrentPathRadResult.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRCurrentPathRadResult = new ims.framework.ContextVariable("OCRR.CurrentPathRadResult", "_cv_OCRR.CurrentPathRadResult");
		public boolean getOrderAwaitingAuthorisationIsNotNull()
		{
			return !cx_OCRROrderAwaitingAuthorisation.getValueIsNull(context);
		}
		public ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo getOrderAwaitingAuthorisation()
		{
			return (ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo)cx_OCRROrderAwaitingAuthorisation.getValue(context);
		}
		public void setOrderAwaitingAuthorisation(ims.ocrr.orderingresults.vo.OcsOrderSessionRefVo value)
		{
			cx_OCRROrderAwaitingAuthorisation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRROrderAwaitingAuthorisation = new ims.framework.ContextVariable("OCRR.OrderAwaitingAuthorisation", "_cv_OCRR.OrderAwaitingAuthorisation");
		public boolean getLastUpdatedPathRadResultIsNotNull()
		{
			return !cx_OCRRLastUpdatedPathRadResult.getValueIsNull(context);
		}
		public ims.ocrr.vo.OcsPathRadResultVo getLastUpdatedPathRadResult()
		{
			return (ims.ocrr.vo.OcsPathRadResultVo)cx_OCRRLastUpdatedPathRadResult.getValue(context);
		}
		public void setLastUpdatedPathRadResult(ims.ocrr.vo.OcsPathRadResultVo value)
		{
			cx_OCRRLastUpdatedPathRadResult.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRLastUpdatedPathRadResult = new ims.framework.ContextVariable("OCRR.LastUpdatedPathRadResult", "_cv_OCRR.LastUpdatedPathRadResult");

		public PathologyResultsContext PathologyResults;
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

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}
	public final class EmergencyContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private EmergencyContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAttendanceResultListSearchCriteriaIsNotNull()
		{
			return !cx_EmergencyAttendanceResultListSearchCriteria.getValueIsNull(context);
		}
		public ims.emergency.vo.AttendanceResultListSearchCriteriaVo getAttendanceResultListSearchCriteria()
		{
			return (ims.emergency.vo.AttendanceResultListSearchCriteriaVo)cx_EmergencyAttendanceResultListSearchCriteria.getValue(context);
		}
		public void setAttendanceResultListSearchCriteria(ims.emergency.vo.AttendanceResultListSearchCriteriaVo value)
		{
			cx_EmergencyAttendanceResultListSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EmergencyAttendanceResultListSearchCriteria = new ims.framework.ContextVariable("Emergency.AttendanceResultListSearchCriteria", "_cvp_Emergency.AttendanceResultListSearchCriteria");

		private ims.framework.Context context;
	}

	public OCRRContext OCRR;
	public CoreContext Core;
	public EmergencyContext Emergency;
}
