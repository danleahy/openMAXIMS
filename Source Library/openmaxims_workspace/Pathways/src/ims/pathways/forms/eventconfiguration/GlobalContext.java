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

package ims.pathways.forms.eventconfiguration;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Pathway = new PathwayContext(context);
		Pathways = new PathwaysContext(context);
	}
	public final class PathwayContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PathwayContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedExternalEventsIsNotNull()
		{
			return !cx_PathwaySelectedExternalEvents.getValueIsNull(context);
		}
		public ims.pathways.vo.ExternalEventMappingVoCollection getSelectedExternalEvents()
		{
			return (ims.pathways.vo.ExternalEventMappingVoCollection)cx_PathwaySelectedExternalEvents.getValue(context);
		}
		public void setSelectedExternalEvents(ims.pathways.vo.ExternalEventMappingVoCollection value)
		{
			cx_PathwaySelectedExternalEvents.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaySelectedExternalEvents = new ims.framework.ContextVariable("Pathway.SelectedExternalEvents", "_cv_Pathway.SelectedExternalEvents");
		public boolean getSelectedEventLiteVoIsNotNull()
		{
			return !cx_PathwaySelectedEventLiteVo.getValueIsNull(context);
		}
		public ims.pathways.vo.EventLiteVo getSelectedEventLiteVo()
		{
			return (ims.pathways.vo.EventLiteVo)cx_PathwaySelectedEventLiteVo.getValue(context);
		}
		public void setSelectedEventLiteVo(ims.pathways.vo.EventLiteVo value)
		{
			cx_PathwaySelectedEventLiteVo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaySelectedEventLiteVo = new ims.framework.ContextVariable("Pathway.SelectedEventLiteVo", "_cv_Pathway.SelectedEventLiteVo");

		private ims.framework.Context context;
	}
	public final class PathwaysContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private PathwaysContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getEventSearchAndSelectFilterIsNotNull()
		{
			return !cx_PathwaysEventSearchAndSelectFilter.getValueIsNull(context);
		}
		public ims.pathways.vo.EventLiteVo getEventSearchAndSelectFilter()
		{
			return (ims.pathways.vo.EventLiteVo)cx_PathwaysEventSearchAndSelectFilter.getValue(context);
		}
		public void setEventSearchAndSelectFilter(ims.pathways.vo.EventLiteVo value)
		{
			cx_PathwaysEventSearchAndSelectFilter.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_PathwaysEventSearchAndSelectFilter = new ims.framework.ContextVariable("Pathways.EventSearchAndSelectFilter", "_cv_Pathways.EventSearchAndSelectFilter");

		private ims.framework.Context context;
	}

	public PathwayContext Pathway;
	public PathwaysContext Pathways;
}
