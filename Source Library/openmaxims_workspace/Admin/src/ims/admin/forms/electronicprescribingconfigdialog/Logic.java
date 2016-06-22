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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.forms.electronicprescribingconfigdialog;

import ims.admin.vo.ElectronicPrescribingConfigVo;
import ims.core.vo.lookups.ElectronicPrescribingButton;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		populateScreenFromData();
	}

	private void initialise() 
	{
		form.getLocalContext().setParameters(ims.clinical.vo.lookups.LookupHelper.getElectronicPrescribingParameters(this.domain.getLookupService()));
	}

	private void populateScreenFromData()
	{
		form.lblButton().setValue(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButtonIsNotNull() ? form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButton().getText() : "");
		form.txtButtonText().setValue(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButtonText());
		form.txtLabelText().setValue(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getLabelText());
		form.txtExePath().setValue(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButtonExecutablePath());
		form.txtParameter().setValue(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButtonParameter());
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if ( ! validateData())
			return;
		
		ElectronicPrescribingConfigVo voEp = form.getGlobalContext().Admin.getElectronicPrescribingConfigVo();
		
		voEp.setButtonText(form.txtButtonText().getValue());
		voEp.setLabelText(form.txtLabelText().getValue());
		voEp.setButtonExecutablePath(form.txtExePath().getValue().toLowerCase());//WDEV-14666
		voEp.setButtonParameter(form.txtParameter().getValue());

		form.getGlobalContext().Admin.setElectronicPrescribingConfigVo(voEp);

		engine.close(DialogResult.OK);
	}
	private boolean  validateData()
	{
		StringBuffer sb = new StringBuffer();

		if (form.txtButtonText().getValue() == null)
			sb.append("Button Text is a required field\n");
		
		if (form.txtExePath().getValue() == null)
			sb.append("Executable Path is a required field\n");
		
		if (form.txtParameter().getValue() == null)
			sb.append("Parameter is a required field\n");
		
		if (form.txtParameter().getValue() != null && ipButtonSelected())
		{
			if(isDeniedParameter(form.txtParameter().getValue()))
			{
				sb.append("Invalid parameter \'" + form.txtParameter().getValue() + "\' for Inpatient Prescribing\n");
			}
		}

		if (sb.length() > 0)
		{
			engine.showMessage(sb.toString());
			return false;
		}
		return true;
	}

	private boolean isDeniedParameter(String parameter) 
	{
		if(form.getLocalContext().getParameters() == null || parameter == null)
			return false;
		
		for(int i=0; i<form.getLocalContext().getParameters().size(); i++)
		{
			if(form.getLocalContext().getParameters().get(i).getText() == null)
				continue;
			
			if(parameter.toLowerCase().equals(form.getLocalContext().getParameters().get(i).getText().toLowerCase()))
				return true;
		}
		
		return false;
	}

	private boolean ipButtonSelected() 
	{
		if(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo() == null)
			return false;
		
		if(ElectronicPrescribingButton.IPBUTTONONE.equals(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButton())
				|| ElectronicPrescribingButton.IPBUTTONTWO.equals(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButton())
				|| ElectronicPrescribingButton.IPBUTTONTHREE.equals(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButton())
				|| ElectronicPrescribingButton.IPBUTTONFOUR.equals(form.getGlobalContext().Admin.getElectronicPrescribingConfigVo().getButton()))
			return true;
				
		return false;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
