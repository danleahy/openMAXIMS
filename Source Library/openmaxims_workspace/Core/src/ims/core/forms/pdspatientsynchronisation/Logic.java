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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5205.12452)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.forms.pdspatientsynchronisation;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.enums.PDSSynchronisationCustomControlEvents;
import ims.framework.enumerations.DialogResult;

public class Logic extends BaseLogic
{
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		// TODO Add your code here.
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccPDSPatientSync().initialize(args);
		
		if(engine.isDialog() && form.ccPDSPatientSync().hasAnyDifferences() == false)
		{
			engine.showMessage("There are no differences between local and PDS patient record.");
			engine.close(DialogResult.OK);
		}
	}
	@Override
	protected void onCcPDSPatientSyncValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (PDSSynchronisationCustomControlEvents.DEFER.equals(form.ccPDSPatientSync().getSelectedEvent()))
		{	
			form.ccPDSPatientSync().clearSelectedEvent();
			if (!isFormDialogAlias())
			{	
				//still ok
				//WDEV-21387
				engine.close(DialogResult.OK);
			}
			else
			{	
				engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
			}
		}	
		if (PDSSynchronisationCustomControlEvents.SYNC_AND_SAVE.equals(form.ccPDSPatientSync().getSelectedEvent()))
		{	
			form.ccPDSPatientSync().clearSelectedEvent();
			if (!isFormDialogAlias())
			{	
				engine.close(DialogResult.OK);
			}
			else
			{	
				engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
			}
		}
	}
	private boolean isFormDialogAlias()
	{
		return form.getForms().Core.PDSPatientSynchronisationNavForm.equals(engine.getFormName());
	}
}
