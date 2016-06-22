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

package ims.core.forms.homeleavedetailsdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedWaitingAreaPatientIsNotNull()
		{
			return !cx_CoreSelectedWaitingAreaPatient.getValueIsNull(context);
		}
		public ims.core.vo.InpatientEpisodeLiteVo getSelectedWaitingAreaPatient()
		{
			return (ims.core.vo.InpatientEpisodeLiteVo)cx_CoreSelectedWaitingAreaPatient.getValue(context);
		}
		public void setSelectedWaitingAreaPatient(ims.core.vo.InpatientEpisodeLiteVo value)
		{
			cx_CoreSelectedWaitingAreaPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedWaitingAreaPatient = new ims.framework.ContextVariable("Core.SelectedWaitingAreaPatient", "_cv_Core.SelectedWaitingAreaPatient");
		public boolean getSelectedBedSpaceStateIsNotNull()
		{
			return !cx_CoreSelectedBedSpaceState.getValueIsNull(context);
		}
		public ims.core.vo.BedSpaceStateLiteVo getSelectedBedSpaceState()
		{
			return (ims.core.vo.BedSpaceStateLiteVo)cx_CoreSelectedBedSpaceState.getValue(context);
		}
		public void setSelectedBedSpaceState(ims.core.vo.BedSpaceStateLiteVo value)
		{
			cx_CoreSelectedBedSpaceState.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSelectedBedSpaceState = new ims.framework.ContextVariable("Core.SelectedBedSpaceState", "_cv_Core.SelectedBedSpaceState");
		public boolean getHomeLeaveDetailsIsNotNull()
		{
			return !cx_CoreHomeLeaveDetails.getValueIsNull(context);
		}
		public ims.core.vo.HomeLeaveVo getHomeLeaveDetails()
		{
			return (ims.core.vo.HomeLeaveVo)cx_CoreHomeLeaveDetails.getValue(context);
		}
		public void setHomeLeaveDetails(ims.core.vo.HomeLeaveVo value)
		{
			cx_CoreHomeLeaveDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreHomeLeaveDetails = new ims.framework.ContextVariable("Core.HomeLeaveDetails", "_cv_Core.HomeLeaveDetails");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
