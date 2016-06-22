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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.icp.forms.icpstageselectdialog;

import ims.core.vo.lookups.YesNo;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.icp.forms.icpstageselectdialog.GenForm.grdStagesRow;
import ims.icp.vo.ICPStageListVo;
import ims.icp.vo.ICPStageListVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	// ------------------------------------------------------------------------------------------------------------------------------------------------------
	// Region - Event Handlers
	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Initialize the form
		intialize();
		// Refresh screen
		open();
	}

	@Override
	protected void onFormModeChanged()
	{
		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Search for ICP Phases matching the search criteria
		search();
		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clear();
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onGrdStagesSelectionChanged()
	{
		// Update controls state
		updateControlsState();
	}
	
	@Override
	protected void onGrdStagesSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		// Update controls state
		updateControlsState();
	}

	@Override
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Set the current selection as the phase to be cloned
		form.getGlobalContext().ICP.setStageForCloning(form.grdStages().getValue());		
		// Close dialog as success
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Close dialog as cancel
		engine.close(DialogResult.CANCEL);
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation functions
	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to initialize the form
	 */
	private void intialize()
	{
		// Clear global context
		form.getGlobalContext().ICP.setStageForCloning(null);
	}

	/**
	 * Function used to refresh the screen
	 */
	private void open()
	{
		// Clear screen
		clear();
		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	/**
	 * Function used to search ICP Stages
	 */
	private void search()
	{
		listICPStages(domain.listStages(form.txtStageName().getValue(), form.txtICPName().getValue(), form.cmbStatus().getValue()));
	}
	
	/**
	 * Function used to clear the screen
	 */
	private void clear()
	{
		// Clear search controls
		clearSearchControls();
		// Clear list
		form.grdStages().getRows().clear();
	}

	/**
	 * Function used to clear search controls
	 */
	private void clearSearchControls()
	{
		form.txtStageName().setValue(null);
		form.txtICPName().setValue(null);
		form.cmbStatus().setValue(null);
	}

	/**
	 * Function used to update controls state
	 */
	private void updateControlsState()
	{
		form.btnSelect().setVisible(true);
		form.btnSelect().setEnabled(form.grdStages().getValue() != null);
	}	


	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation functions
	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to populate phases to grid
	 */
	private void listICPStages(ICPStageListVoCollection stages)
	{
		// Clear grid
		form.grdStages().getRows().clear();
		
		if (stages == null || stages.size() == 0)
		{
			engine.showMessage("No search results were found"); //WDEV-18046 
			return;
		}
		
		for (ICPStageListVo stage : stages)
		{
			grdStagesRow row = form.grdStages().getRows().newRow();
			
			row.setColStage(stage.getName());
			row.setTooltipForColStage(stage.getName());
			
			row.setColDescription(stage.getDescription());
			//WDEV-17155
			row.setTooltipForColDescription(Boolean.TRUE.equals(stage.getDescriptionIsNotNull()) ? stage.getDescription() : "");
			
			row.setColPhases(Boolean.TRUE.equals(stage.getHasPhase()) ? YesNo.YES : YesNo.NO);
			row.setColStatus(stage.getStatus());
			
			row.setColICP(stage.getICPName());
			row.setTooltipForColICP(stage.getICPName());
			
			row.setValue(stage);
		}
	}
}
