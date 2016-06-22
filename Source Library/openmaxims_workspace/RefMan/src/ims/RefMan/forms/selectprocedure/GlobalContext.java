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

package ims.RefMan.forms.selectprocedure;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getprocedureListForActivityIsNotNull()
		{
			return !cx_RefManprocedureListForActivity.getValueIsNull(context);
		}
		public ims.core.vo.ProcedureLiteVoCollection getprocedureListForActivity()
		{
			return (ims.core.vo.ProcedureLiteVoCollection)cx_RefManprocedureListForActivity.getValue(context);
		}
		public void setprocedureListForActivity(ims.core.vo.ProcedureLiteVoCollection value)
		{
			cx_RefManprocedureListForActivity.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManprocedureListForActivity = new ims.framework.ContextVariable("RefMan.procedureListForActivity", "_cv_RefMan.procedureListForActivity");
		public boolean getunavailableProceduresIsNotNull()
		{
			return !cx_RefManunavailableProcedures.getValueIsNull(context);
		}
		public ims.core.vo.ProcedureLiteVoCollection getunavailableProcedures()
		{
			return (ims.core.vo.ProcedureLiteVoCollection)cx_RefManunavailableProcedures.getValue(context);
		}
		public void setunavailableProcedures(ims.core.vo.ProcedureLiteVoCollection value)
		{
			cx_RefManunavailableProcedures.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManunavailableProcedures = new ims.framework.ContextVariable("RefMan.unavailableProcedures", "_cv_RefMan.unavailableProcedures");
		public boolean getAssociatedProceduresIsNotNull()
		{
			return !cx_RefManAssociatedProcedures.getValueIsNull(context);
		}
		public ims.core.vo.ProcedureLiteVoCollection getAssociatedProcedures()
		{
			return (ims.core.vo.ProcedureLiteVoCollection)cx_RefManAssociatedProcedures.getValue(context);
		}
		public void setAssociatedProcedures(ims.core.vo.ProcedureLiteVoCollection value)
		{
			cx_RefManAssociatedProcedures.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManAssociatedProcedures = new ims.framework.ContextVariable("RefMan.AssociatedProcedures", "_cv_RefMan.AssociatedProcedures");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
