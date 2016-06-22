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

package ims.eas.forms.patientelectronicactionsheet;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "EAS";
	}
	public String getFormName()
	{
		return "PatientElectronicActionSheet";
	}
	public int getWidth()
	{
		return 848;
	}
	public int getHeight()
	{
		return 632;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_EAS.AdditionalActionSheet", "_cv_EAS.ElectronicActionSheet", "_cv_Core.ImsReportId", "_cv_EAS.EasPatientAssessment" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_EAS.PatientElectronicActionSheet.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[6];
		componentsInfo[0] = new ims.eas.forms.easoverviewcomponent.FormInfo(145106);
		componentsInfo[1] = new ims.eas.forms.eastreatmentoptionscomponent.FormInfo(145107);
		componentsInfo[2] = new ims.eas.forms.easrequestimagetransfer.FormInfo(145109);
		componentsInfo[3] = new ims.eas.forms.easplanningoptionscomponent.FormInfo(145112);
		componentsInfo[4] = new ims.eas.forms.easmiscellaneous.FormInfo(145119);
		componentsInfo[5] = new ims.eas.forms.eassummary.FormInfo(145113);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "";
	}
}
