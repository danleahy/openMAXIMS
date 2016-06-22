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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4847.21738)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.forms.additionalactionsheets;

import ims.eas.vo.AdditionalActionSheetVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnNoClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.NO);
	}
	
	@Override
	protected void onBtnYesClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().EAS.setAdditionalActionSheet(populateDataFromScreen());
		engine.close(DialogResult.YES);
	}

	private AdditionalActionSheetVo populateDataFromScreen() 
	{
		AdditionalActionSheetVo record = new AdditionalActionSheetVo();
		
		record.setMultiplePrimaryTumours(form.chkMultiplePrimaryTumours().getValue());
		record.setMultipleSites(form.chkMultipleSites().getValue());
		
		return record;
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.btnYes().setEnabled(form.chkMultiplePrimaryTumours().getValue() || form.chkMultipleSites().getValue());
	}

	@Override
	protected void onChkMultipleSitesValueChanged()	throws PresentationLogicException 
	{
		if(form.chkMultipleSites().getValue())
		{
			form.chkMultiplePrimaryTumours().setValue(null);
		}
		
		updateControlsState();
	}

	@Override
	protected void onChkMultiplePrimaryTumoursValueChanged() throws PresentationLogicException 
	{
		if(form.chkMultiplePrimaryTumours().getValue())
		{
			form.chkMultipleSites().setValue(null);
		}
		
		updateControlsState();
	}
}
