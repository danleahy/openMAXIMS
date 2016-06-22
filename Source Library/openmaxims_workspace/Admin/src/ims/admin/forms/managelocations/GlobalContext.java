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

package ims.admin.forms.managelocations;

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

		public boolean getSelectedLocationsIsNotNull()
		{
			return !cx_AdminSelectedLocations.getValueIsNull(context);
		}
		public ims.framework.interfaces.ILocation[] getSelectedLocations()
		{
			return (ims.framework.interfaces.ILocation[])cx_AdminSelectedLocations.getValue(context);
		}

		private ims.framework.ContextVariable cx_AdminSelectedLocations = new ims.framework.ContextVariable("Admin.SelectedLocations", "_cv_Admin.SelectedLocations");
		public boolean getManagedLocationsIsNotNull()
		{
			return !cx_AdminManagedLocations.getValueIsNull(context);
		}
		public ims.framework.interfaces.ILocation[] getManagedLocations()
		{
			return (ims.framework.interfaces.ILocation[])cx_AdminManagedLocations.getValue(context);
		}
		public void setManagedLocations(ims.framework.interfaces.ILocation[] value)
		{
			cx_AdminManagedLocations.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminManagedLocations = new ims.framework.ContextVariable("Admin.ManagedLocations", "_cv_Admin.ManagedLocations");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
}
