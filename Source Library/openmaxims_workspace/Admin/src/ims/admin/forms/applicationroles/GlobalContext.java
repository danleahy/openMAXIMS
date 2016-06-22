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

package ims.admin.forms.applicationroles;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Admin = new AdminContext(context);
	}
	public final class AdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedMenuActionsIsNotNull()
		{
			return !cx_AdminSelectedMenuActions.getValueIsNull(context);
		}
		public ims.admin.vo.AppFormMenuActionsVoCollection getSelectedMenuActions()
		{
			return (ims.admin.vo.AppFormMenuActionsVoCollection)cx_AdminSelectedMenuActions.getValue(context);
		}
		public void setSelectedMenuActions(ims.admin.vo.AppFormMenuActionsVoCollection value)
		{
			cx_AdminSelectedMenuActions.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminSelectedMenuActions = new ims.framework.ContextVariable("Admin.SelectedMenuActions", "_cv_Admin.SelectedMenuActions");
		public boolean getSelectedRoleRigthsIsNotNull()
		{
			return !cx_AdminSelectedRoleRigths.getValueIsNull(context);
		}
		public ims.admin.vo.AppRightVoCollection getSelectedRoleRigths()
		{
			return (ims.admin.vo.AppRightVoCollection)cx_AdminSelectedRoleRigths.getValue(context);
		}
		public void setSelectedRoleRigths(ims.admin.vo.AppRightVoCollection value)
		{
			cx_AdminSelectedRoleRigths.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminSelectedRoleRigths = new ims.framework.ContextVariable("Admin.SelectedRoleRigths", "_cv_Admin.SelectedRoleRigths");
		public boolean getSelectedPdsRoleRightsIsNotNull()
		{
			return !cx_AdminSelectedPdsRoleRights.getValueIsNull(context);
		}
		public ims.admin.vo.AppRightVoCollection getSelectedPdsRoleRights()
		{
			return (ims.admin.vo.AppRightVoCollection)cx_AdminSelectedPdsRoleRights.getValue(context);
		}
		public void setSelectedPdsRoleRights(ims.admin.vo.AppRightVoCollection value)
		{
			cx_AdminSelectedPdsRoleRights.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminSelectedPdsRoleRights = new ims.framework.ContextVariable("Admin.SelectedPdsRoleRights", "_cv_Admin.SelectedPdsRoleRights");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
}
