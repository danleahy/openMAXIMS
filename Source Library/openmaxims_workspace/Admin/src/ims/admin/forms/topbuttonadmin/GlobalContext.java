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

package ims.admin.forms.topbuttonadmin;

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

		public boolean getTopButtonExcludedButtonsIsNotNull()
		{
			return !cx_AdminTopButtonExcludedButtons.getValueIsNull(context);
		}
		public ims.framework.TopButtonCollection getTopButtonExcludedButtons()
		{
			return (ims.framework.TopButtonCollection)cx_AdminTopButtonExcludedButtons.getValue(context);
		}
		public void setTopButtonExcludedButtons(ims.framework.TopButtonCollection value)
		{
			cx_AdminTopButtonExcludedButtons.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminTopButtonExcludedButtons = new ims.framework.ContextVariable("Admin.TopButtonExcludedButtons", "_cv_Admin.TopButtonExcludedButtons");
		public boolean getTopButtonSelectionTypeIsNotNull()
		{
			return !cx_AdminTopButtonSelectionType.getValueIsNull(context);
		}
		public ims.admin.vo.enums.TopButtonSelectionType getTopButtonSelectionType()
		{
			return (ims.admin.vo.enums.TopButtonSelectionType)cx_AdminTopButtonSelectionType.getValue(context);
		}
		public void setTopButtonSelectionType(ims.admin.vo.enums.TopButtonSelectionType value)
		{
			cx_AdminTopButtonSelectionType.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminTopButtonSelectionType = new ims.framework.ContextVariable("Admin.TopButtonSelectionType", "_cv_Admin.TopButtonSelectionType");
		public boolean getTopButtonSelectionIsNotNull()
		{
			return !cx_AdminTopButtonSelection.getValueIsNull(context);
		}
		public ims.admin.vo.AppTopButtonVoCollection getTopButtonSelection()
		{
			return (ims.admin.vo.AppTopButtonVoCollection)cx_AdminTopButtonSelection.getValue(context);
		}

		private ims.framework.ContextVariable cx_AdminTopButtonSelection = new ims.framework.ContextVariable("Admin.TopButtonSelection", "_cv_Admin.TopButtonSelection");
		public boolean getTopButtonMaxSelectionCountIsNotNull()
		{
			return !cx_AdminTopButtonMaxSelectionCount.getValueIsNull(context);
		}
		public Integer getTopButtonMaxSelectionCount()
		{
			return (Integer)cx_AdminTopButtonMaxSelectionCount.getValue(context);
		}
		public void setTopButtonMaxSelectionCount(Integer value)
		{
			cx_AdminTopButtonMaxSelectionCount.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AdminTopButtonMaxSelectionCount = new ims.framework.ContextVariable("Admin.TopButtonMaxSelectionCount", "_cv_Admin.TopButtonMaxSelectionCount");

		private ims.framework.Context context;
	}

	public AdminContext Admin;
}
