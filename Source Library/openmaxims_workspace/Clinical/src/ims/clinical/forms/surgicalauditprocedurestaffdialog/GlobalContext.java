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

package ims.clinical.forms.surgicalauditprocedurestaffdialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Clinical = new ClinicalContext(context);
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedHCPsIsNotNull()
		{
			return !cx_ClinicalSelectedHCPs.getValueIsNull(context);
		}
		public java.util.ArrayList<Object> getSelectedHCPs()
		{
			return (java.util.ArrayList<Object>)cx_ClinicalSelectedHCPs.getValue(context);
		}
		public void setSelectedHCPs(java.util.ArrayList<Object> value)
		{
			cx_ClinicalSelectedHCPs.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedHCPs = new ims.framework.ContextVariable("Clinical.SelectedHCPs", "_cv_Clinical.SelectedHCPs");
		public boolean getRadiographerSurgAuditProcDetailsIsNotNull()
		{
			return !cx_ClinicalRadiographerSurgAuditProcDetails.getValueIsNull(context);
		}
		public ims.core.vo.HcpLiteVoCollection getRadiographerSurgAuditProcDetails()
		{
			return (ims.core.vo.HcpLiteVoCollection)cx_ClinicalRadiographerSurgAuditProcDetails.getValue(context);
		}
		public void setRadiographerSurgAuditProcDetails(ims.core.vo.HcpLiteVoCollection value)
		{
			cx_ClinicalRadiographerSurgAuditProcDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalRadiographerSurgAuditProcDetails = new ims.framework.ContextVariable("Clinical.RadiographerSurgAuditProcDetails", "_cv_Clinical.RadiographerSurgAuditProcDetails");
		public boolean getSelectedHcpIsNotNull()
		{
			return !cx_ClinicalSelectedHcp.getValueIsNull(context);
		}
		public ims.core.vo.lookups.HcpDisType getSelectedHcp()
		{
			return (ims.core.vo.lookups.HcpDisType)cx_ClinicalSelectedHcp.getValue(context);
		}
		public void setSelectedHcp(ims.core.vo.lookups.HcpDisType value)
		{
			cx_ClinicalSelectedHcp.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedHcp = new ims.framework.ContextVariable("Clinical.SelectedHcp", "_cv_Clinical.SelectedHcp");
		public boolean getSelectedHcpGradeIsNotNull()
		{
			return !cx_ClinicalSelectedHcpGrade.getValueIsNull(context);
		}
		public ims.core.vo.lookups.MedicGrade getSelectedHcpGrade()
		{
			return (ims.core.vo.lookups.MedicGrade)cx_ClinicalSelectedHcpGrade.getValue(context);
		}
		public void setSelectedHcpGrade(ims.core.vo.lookups.MedicGrade value)
		{
			cx_ClinicalSelectedHcpGrade.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedHcpGrade = new ims.framework.ContextVariable("Clinical.SelectedHcpGrade", "_cv_Clinical.SelectedHcpGrade");
		public boolean getMedicsSurgicalAuditIsNotNull()
		{
			return !cx_ClinicalMedicsSurgicalAudit.getValueIsNull(context);
		}
		public ims.core.vo.MedicLiteVoCollection getMedicsSurgicalAudit()
		{
			return (ims.core.vo.MedicLiteVoCollection)cx_ClinicalMedicsSurgicalAudit.getValue(context);
		}
		public void setMedicsSurgicalAudit(ims.core.vo.MedicLiteVoCollection value)
		{
			cx_ClinicalMedicsSurgicalAudit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalMedicsSurgicalAudit = new ims.framework.ContextVariable("Clinical.MedicsSurgicalAudit", "_cv_Clinical.MedicsSurgicalAudit");
		public boolean getNursessSurgicalAuditIsNotNull()
		{
			return !cx_ClinicalNursessSurgicalAudit.getValueIsNull(context);
		}
		public ims.core.vo.NurseVoCollection getNursessSurgicalAudit()
		{
			return (ims.core.vo.NurseVoCollection)cx_ClinicalNursessSurgicalAudit.getValue(context);
		}
		public void setNursessSurgicalAudit(ims.core.vo.NurseVoCollection value)
		{
			cx_ClinicalNursessSurgicalAudit.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalNursessSurgicalAudit = new ims.framework.ContextVariable("Clinical.NursessSurgicalAudit", "_cv_Clinical.NursessSurgicalAudit");

		private ims.framework.Context context;
	}

	public ClinicalContext Clinical;
}
