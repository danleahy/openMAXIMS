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

package ims.ccosched.forms.printlist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		CcoSched = new CcoSchedContext(context);
	}
	public final class CcoSchedContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CcoSchedContext(ims.framework.Context context)
		{
			this.context = context;

			ClinicView = new ClinicViewContext(context);
		}
		public final class ClinicViewContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ClinicViewContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getAppt_statIsNotNull()
			{
				return !cx_CcoSchedClinicViewAppt_stat.getValueIsNull(context);
			}
			public String getAppt_stat()
			{
				return (String)cx_CcoSchedClinicViewAppt_stat.getValue(context);
			}
		public void setAppt_stat(String value)
		{
				cx_CcoSchedClinicViewAppt_stat.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewAppt_stat = new ims.framework.ContextVariable("CcoSched.ClinicView.Appt_stat", "_cv_CcoSched.ClinicView.Appt_stat");
			public boolean getPrfile_sess_idIsNotNull()
			{
				return !cx_CcoSchedClinicViewPrfile_sess_id.getValueIsNull(context);
			}
			public String getPrfile_sess_id()
			{
				return (String)cx_CcoSchedClinicViewPrfile_sess_id.getValue(context);
			}
		public void setPrfile_sess_id(String value)
		{
				cx_CcoSchedClinicViewPrfile_sess_id.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewPrfile_sess_id = new ims.framework.ContextVariable("CcoSched.ClinicView.Prfile_sess_id", "_cv_CcoSched.ClinicView.Prfile_sess_id");
			public boolean getPrfiled_sess_idIsNotNull()
			{
				return !cx_CcoSchedClinicViewPrfiled_sess_id.getValueIsNull(context);
			}
			public String getPrfiled_sess_id()
			{
				return (String)cx_CcoSchedClinicViewPrfiled_sess_id.getValue(context);
			}
		public void setPrfiled_sess_id(String value)
		{
				cx_CcoSchedClinicViewPrfiled_sess_id.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewPrfiled_sess_id = new ims.framework.ContextVariable("CcoSched.ClinicView.Prfiled_sess_id", "_cv_CcoSched.ClinicView.Prfiled_sess_id");
			public boolean getScreenDateIsNotNull()
			{
				return !cx_CcoSchedClinicViewScreenDate.getValueIsNull(context);
			}
			public ims.framework.utils.Date getScreenDate()
			{
				return (ims.framework.utils.Date)cx_CcoSchedClinicViewScreenDate.getValue(context);
			}
		public void setScreenDate(ims.framework.utils.Date value)
		{
				cx_CcoSchedClinicViewScreenDate.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_CcoSchedClinicViewScreenDate = new ims.framework.ContextVariable("CcoSched.ClinicView.ScreenDate", "_cv_CcoSched.ClinicView.ScreenDate");
			private ims.framework.Context context;
		}

		public boolean getTemplateCategoryIDListIsNotNull()
		{
			return !cx_CcoSchedTemplateCategoryIDList.getValueIsNull(context);
		}
		public String getTemplateCategoryIDList()
		{
			return (String)cx_CcoSchedTemplateCategoryIDList.getValue(context);
		}
		public void setTemplateCategoryIDList(String value)
		{
			cx_CcoSchedTemplateCategoryIDList.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CcoSchedTemplateCategoryIDList = new ims.framework.ContextVariable("CcoSched.TemplateCategoryIDList", "_cv_CcoSched.TemplateCategoryIDList");

		public ClinicViewContext ClinicView;
		private ims.framework.Context context;
	}

	public CcoSchedContext CcoSched;
}
