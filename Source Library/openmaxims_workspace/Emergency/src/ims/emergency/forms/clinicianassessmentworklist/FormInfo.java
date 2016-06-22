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

package ims.emergency.forms.clinicianassessmentworklist;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "Emergency";
	}
	public String getFormName()
	{
		return "ClinicianAssessmentWorklist";
	}
	public int getWidth()
	{
		return 1176;
	}
	public int getHeight()
	{
		return 736;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_Core.ImsReportId", "_cv_Emergency.TriageProtocolAssessment", "_cv_Emergency.Triage", "_cv_Emergency.Tracking" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_Emergency.ClinicianAssessmentWorklist.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[14];
		componentsInfo[0] = new ims.core.forms.alertscc.FormInfo(102401);
		componentsInfo[1] = new ims.clinical.forms.allergiescc.FormInfo(123239);
		componentsInfo[2] = new ims.emergency.forms.medicnotes.FormInfo(129144);
		componentsInfo[3] = new ims.core.forms.vitalsignsallcc.FormInfo(102387);
		componentsInfo[4] = new ims.clinical.forms.urinalysiscc.FormInfo(123254);
		componentsInfo[5] = new ims.clinical.forms.urinetoxcc.FormInfo(123255);
		componentsInfo[6] = new ims.clinical.forms.hcgcc.FormInfo(123256);
		componentsInfo[7] = new ims.clinical.forms.obspatientassessmentcc.FormInfo(123257);
		componentsInfo[8] = new ims.icp.forms.patienticppresentationcomponent.FormInfo(118128);
		componentsInfo[9] = new ims.emergency.forms.systemreview.FormInfo(129151);
		componentsInfo[10] = new ims.emergency.forms.triagepatientmeds.FormInfo(129126);
		componentsInfo[11] = new ims.emergency.forms.relevantpmh.FormInfo(129125);
		componentsInfo[12] = new ims.emergency.forms.supportservices.FormInfo(129161);
		componentsInfo[13] = new ims.emergency.forms.dischargedetails.FormInfo(129155);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "";
	}
}
