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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3467.22451)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.icp.forms.icpcritcalevents;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.icp.vo.PatientCriticalEventsVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// Event handlers region
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		setFormReadOnlyMode(args);
		
		open();
		
		updateControlsState();
	}
	

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}
	

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation function
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Function used to set the form to read only.
	 * Used when ICP is completed or user only views the critical event
	 */
	private void setFormReadOnlyMode(Object[] args)
	{
		// Check arguments to determine if the dialog should be in read-only mode
		boolean isReadOnly = (args != null) && (args.length > 0) && Boolean.TRUE.equals(args[0]);
		// Set appropriate mode to form
		form.setMode(isReadOnly ? FormMode.VIEW : FormMode.EDIT);
	}

	/**
	 * Function used to present / refresh screen
	 */
	private void open()
	{
		// Get PatientICP record from domain
		form.getLocalContext().setPatientICP(domain.getPatientICP(form.getGlobalContext().ICP.getPatientICPRecord()));
		
		if (form.getLocalContext().getPatientICP().getVersion_PatientICP() > form.getGlobalContext().ICP.getPatientICPRecord().getVersion_PatientICP())
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.CANCEL);
			return;
		}
		
		// Get CriticalEvent record from domain
		form.getLocalContext().setPatientCriticalEvent(domain.getCriticalEvent(form.getGlobalContext().ICP.getPatientCriticalEvent()));
		
		// Populate instance controls with event
		populateInstanceControlsFromData(form.getLocalContext().getPatientCriticalEvent());
	}
	
	/**
	 * Function used to clear instance controls
	 */
	private void clearInstanceControls()
	{
		form.cmbCriticalEvent().setValue(null);
		form.ccAutoringInfo().setValue(null);
		form.richTextNote().setValue(null);
	}

	/**
	 * Function used to update controls state
	 */
	private void updateControlsState()
	{
		PatientCriticalEventsVo event = form.getLocalContext().getPatientCriticalEvent();
		
		boolean isEditMode = FormMode.EDIT.equals(form.getMode());
		
		form.ccAutoringInfo().setEnabledAuthoringHCP(isEditMode && (event == null || event.getID_PatientCriticalEvents() == null));
		form.ccAutoringInfo().setEnabledDateTime(isEditMode && (event == null || event.getID_PatientCriticalEvents() == null));
	}

	
	private boolean save()
	{
		PatientCriticalEventsVo event = populateDataFromInstanceControls(form.getLocalContext().getPatientCriticalEvent());

		String[] errors = event.validate();

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		if (event.getID_PatientCriticalEvents() == null)
		{
			try
			{
				domain.addCriticalEvent(form.getLocalContext().getPatientICP(), event);
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				engine.close(DialogResult.CANCEL);
				return false;
			}
		}
		else
		{
			try
			{
				domain.updateCriticalEvent(event);
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				open();
				return false;
			}
		}

		return true;
	}


	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange functions
	//------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 *	Function used to populate a CriticalEvent with data from screen 
	 */
	private PatientCriticalEventsVo populateDataFromInstanceControls(PatientCriticalEventsVo event)
	{
		if (event == null)
		{
			event = new PatientCriticalEventsVo();
		}
		
		// Get data from screen into an instance
		event.setCriticalEvent(form.cmbCriticalEvent().getValue());
		event.setAuthoringInformation(form.ccAutoringInfo().getValue());
		event.setNote(form.richTextNote().getValue());
		
		return event;
	}
	
	/**
	 *	Function used to populate CriticalEvent record to screen 
	 */
	private void populateInstanceControlsFromData(PatientCriticalEventsVo event)
	{
		// Clear instance controls
		clearInstanceControls();
		
		// If the event is null, then set default Authoring Info
		// and exit the function
		if (event == null)
		{
			form.ccAutoringInfo().initializeComponent();
			form.ccAutoringInfo().setIsRequiredPropertyToControls(Boolean.TRUE);
			return;
		}
		
		// Populate controls with data from CriticalEvent record
		form.cmbCriticalEvent().setValue(event.getCriticalEvent());
		form.ccAutoringInfo().setValue(event.getAuthoringInformation());
		form.richTextNote().setValue(event.getNote());
	}
}
