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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4121.17238)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.clinicaloutcomecategoryprocedurerequiredconfig;

import ims.RefMan.forms.clinicaloutcomecategoryprocedurerequiredconfig.GenForm.grdOutcomeCategoriesRow;
import ims.RefMan.vo.ClinicalOutcomeCategoryProcedureRequiredConfigVo;
import ims.RefMan.vo.ClinicalOutcomeCategoryProcedureRequiredConfigVoCollection;
import ims.clinical.vo.lookups.ClinicalOutcomeCategory;
import ims.clinical.vo.lookups.ClinicalOutcomeCategoryCollection;
import ims.clinical.vo.lookups.LookupHelper;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;

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
		initialize();
		
		// Refresh the form
		open();
	}

	@Override
	protected void onFormModeChanged()
	{
		// Update the state for controls
		updateControlsState();
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Update the instance
		updateInstance();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// If the save is successful, then refresh the form
		if (save())
			open();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Refresh the form
		open();
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	// Form presentation functions
	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function used to intialize the form
	 * Put here all code 
	 */
	public void initialize() throws FormOpenException
	{
		
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clearInstanceControls();
		
		// Populate grid with lookup values
		populateGridWithLookups();
		// Update grid with saved records
		updateGridWithSavedRecords(domain.listClinicalOutcomeConfig());
		
		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	/**
	 * Function used to clear screen
	 */
	public void clearInstanceControls()
	{
		// Remove grid rows
		form.grdOutcomeCategories().getRows().clear();
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}

	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			// Populate data from screen
			ClinicalOutcomeCategoryProcedureRequiredConfigVoCollection collectionToSave = populateClinicalOutcomeRecordsFromGrid();

			// Validate data
			String[] errors = collectionToSave.validate();
			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			// Attempt to save
			domain.saveClinicalOutcomeConfig(collectionToSave);

			// Assume save succeeded
			return true;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			e.printStackTrace();
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			open();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			open();
			return false;
		}
	}
	
	public void updateControlsState()
	{
		// TODO: Add you code here.
	}

	public void updateInstance()
	{
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	// Data exchange function
	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Form used to populate the grid with lookup values
	 */
	private void populateGridWithLookups()
	{
		// Clear grid rows
		form.grdOutcomeCategories().getRows().clear();
		
		// Get the lookup collection
		ClinicalOutcomeCategoryCollection lookupCollection = LookupHelper.getClinicalOutcomeCategory(domain.getLookupService());
		
		// Populate grid with lookup collection
		for (int i = 0; i < lookupCollection.size(); i++)
		{
			ClinicalOutcomeCategory clinicalOutcomeCategory = lookupCollection.get(i);
			
			if (clinicalOutcomeCategory.isActive())
			{
				// Create new grid row
				grdOutcomeCategoriesRow row = form.grdOutcomeCategories().getRows().newRow();

				// Create row value VO
				ClinicalOutcomeCategoryProcedureRequiredConfigVo rowValue = new ClinicalOutcomeCategoryProcedureRequiredConfigVo();
				rowValue.setCategory(clinicalOutcomeCategory);
				rowValue.setRequiresProcedureLink(false);

				// Set row cells value
				row.setColOutcomeCategory(clinicalOutcomeCategory.getText());
				row.setColProcedureRequired(false);

				// Set row value
				row.setValue(rowValue);
			}
		}
	}

	/**
	 * Function used to update the grid rows with saved records 
	 */
	private void updateGridWithSavedRecords(ClinicalOutcomeCategoryProcedureRequiredConfigVoCollection listClinicalOutcomeConfig)
	{
		// Terminate function if the collection is null
		if (listClinicalOutcomeConfig == null)
			return;
		
		// Iterate saved ClinicalOutcome records
		for (ClinicalOutcomeCategoryProcedureRequiredConfigVo clinicalOutcomeConfig : listClinicalOutcomeConfig)
		{
			for (int i = 0; i < form.grdOutcomeCategories().getRows().size(); i++)
			{
				grdOutcomeCategoriesRow row = form.grdOutcomeCategories().getRows().get(i);
				
				if (clinicalOutcomeConfig.getCategory().equals(row.getValue().getCategory()))
				{
					// Update row value
					row.setValue(clinicalOutcomeConfig);
					row.setColProcedureRequired(Boolean.TRUE.equals(clinicalOutcomeConfig.getRequiresProcedureLink()));
					
					break;
				}
			}
		}
	}

	/**
	 * Function used to 
	 * @return
	 */
	private ClinicalOutcomeCategoryProcedureRequiredConfigVoCollection populateClinicalOutcomeRecordsFromGrid()
	{
		// Declare the result collection
		ClinicalOutcomeCategoryProcedureRequiredConfigVoCollection results = new ClinicalOutcomeCategoryProcedureRequiredConfigVoCollection();
		
		// Iterate grid rows
		for (int i = 0; i < form.grdOutcomeCategories().getRows().size(); i++)
		{
			grdOutcomeCategoriesRow row = form.grdOutcomeCategories().getRows().get(i);

			// Get row value & update with screen input
			ClinicalOutcomeCategoryProcedureRequiredConfigVo clinicalOutcomeCategory = row.getValue();
			clinicalOutcomeCategory.setRequiresProcedureLink(row.getColProcedureRequired());
			
			// Add clinical outcome to results collection
			results.add(clinicalOutcomeCategory);
		}
		
		// Return data from screen
		return results;
	}
}
