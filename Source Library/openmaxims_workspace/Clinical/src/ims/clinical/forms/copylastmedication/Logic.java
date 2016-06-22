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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.71 build 3876.15807)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.copylastmedication;

import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.PatientMedicationVo;
import ims.core.vo.PatientMedicationVoCollection;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	
	private static final int COL_MEDICATION_NAME	= 0;
	private static final int COL_DOSE				= 1;
	private static final int COL_FREQUENCY			= 2;
	private static final int COL_ROUTE				= 3; 
//	private static final int COL_COMMENCED_BY		= 4;
//	private static final int COL_COMMENCED_DATE		= 5;
	private static final int COL_SELECT				= 6;

	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// Event handlers
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Take the arguments passed in form open
		if (args != null && args.length > 1 && args[0] instanceof PatientRefVo && args[1] instanceof DateTime)
		{
			form.getLocalContext().setPatient((PatientRefVo) args[0]);
			form.getLocalContext().setStartDateTime((DateTime) args[1]);
		}
		else
		{
			form.getLocalContext().setPatient(null);
			form.getLocalContext().setStartDateTime(null);
		}
			
		
		// Initialize the form (dynamic grid, context menu, local contexts, global contexts)
		initialize();
		
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
	protected void onDyngrdMedicationsRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		// TODO Add your code here.
	}
	
	@Override
	protected void onDyngrdMedicationsRowSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	
	@Override
	protected void onDyngrdMedicationsRowChecked(ims.framework.controls.DynamicGridRow row)
	{
		// TODO Add your code here.
	}
	
	@Override
	protected void onBtnCopyClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Fill patient medication collection to be passed to parent form
		form.getGlobalContext().Clinical.setPatientMedicationCollection(getSelectedMedications());
		
		if (!form.getGlobalContext().Clinical.getPatientMedicationCollectionIsNotNull() || form.getGlobalContext().Clinical.getPatientMedicationCollection().size() == 0)
		{
			engine.showMessage("No medication were selected to be copied");
			return;
		}
		
		// Close window
		engine.close(DialogResult.OK);
	}


	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	public void initialize() throws FormOpenException
	{
		// Initialize dynamic grid
		initializeDynamicGrid();
	}

	private void initializeDynamicGrid()
	{
		// Build dynamic grid columns		
		DynamicGridColumn column = form.dyngrdMedications().getColumns().newColumn("Medication");
		column.setIdentifier(COL_MEDICATION_NAME);
		column.setWidth(200);
		column.setAlignment(Alignment.LEFT);
		column.setHeaderAlignment(Alignment.CENTER);
		column.setCanGrow(true);
		
		column = form.dyngrdMedications().getColumns().newColumn("Dose");
		column.setIdentifier(COL_DOSE);
		column.setWidth(80);
		column.setAlignment(Alignment.CENTER);
		column.setHeaderAlignment(Alignment.CENTER);
		column.setCanGrow(false);
		
		column = form.dyngrdMedications().getColumns().newColumn("Frequency");
		column.setIdentifier(COL_FREQUENCY);
		column.setWidth(80);
		column.setAlignment(Alignment.CENTER);
		column.setHeaderAlignment(Alignment.CENTER);
		column.setCanGrow(false);
		
		column = form.dyngrdMedications().getColumns().newColumn("Route");
		column.setIdentifier(COL_ROUTE);
		column.setWidth(80);
		column.setAlignment(Alignment.CENTER);
		column.setHeaderAlignment(Alignment.CENTER);
		column.setCanGrow(false);
		
//		column = form.dyngrdMedications().getColumns().newColumn("Commenced by");
//		column.setIdentifier(COL_COMMENCED_BY);
//		column.setWidth(180);
//		column.setAlignment(Alignment.LEFT);
//		column.setHeaderAlignment(Alignment.CENTER);
//		column.setCanGrow(true);

//		column = form.dyngrdMedications().getColumns().newColumn("Commenced date");
//		column.setIdentifier(COL_COMMENCED_DATE);
//		column.setWidth(120);
//		column.setAlignment(Alignment.LEFT);
//		column.setHeaderAlignment(Alignment.CENTER);
//		column.setCanGrow(false);
		
		column = form.dyngrdMedications().getColumns().newColumn("Copy");
		column.setIdentifier(COL_SELECT);
		column.setWidth(80);
		column.setAlignment(Alignment.CENTER);
		column.setHeaderAlignment(Alignment.CENTER);
		column.setCanGrow(false);
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear screen
		clear();
		
		// Populate dynamic grid with last admission medication
		populateMedicationsGrid(domain.listMedications(form.getLocalContext().getPatient(), form.getLocalContext().getStartDateTime()));
		
		// Set form mode to EDIT
		form.setMode(FormMode.EDIT);
	}
	
	private void populateMedicationsGrid(PatientMedicationVoCollection medications)
	{
		// Clear dynamic grid
		form.dyngrdMedications().getRows().clear();
		
		// Check medication collection
		if (medications == null)
			return;
		
		
		for (int i = 0; i < medications.size(); i++)
		{
			PatientMedicationVo patientMedication = medications.get(i);
			
			if (patientMedication == null)
				continue;
			
			populateMedicationRow(form.dyngrdMedications().getRows().newRow(), patientMedication);
		}
	}
	
	private void populateMedicationRow(DynamicGridRow row, PatientMedicationVo medication)
	{
		if (medication == null)
			return;
		
		if (row == null)
			throw new CodingRuntimeException("Major logical error - can not populate to a null row parameter");
		
		// Fill row cells
		DynamicGridColumn column = form.dyngrdMedications().getColumns().getByIdentifier(COL_MEDICATION_NAME);
		DynamicGridCell cell = row.getCells().newCell(column, DynamicCellType.STRING);
		cell.setValue(medication.getMedicationIsNotNull() ? medication.getMedication().getMedicationName() : medication.getOtherMedicationText());
		cell.setReadOnly(true);
		
		column = form.dyngrdMedications().getColumns().getByIdentifier(COL_DOSE);
		cell = row.getCells().newCell(column, DynamicCellType.STRING);
		cell.setValue((medication.getPrescribedDosesIsNotNull() && medication.getPrescribedDoses().size() > 0) ? medication.getPrescribedDoses().get(0).getDose() : "");
		cell.setReadOnly(true);
		
		column = form.dyngrdMedications().getColumns().getByIdentifier(COL_FREQUENCY);
		cell = row.getCells().newCell(column, DynamicCellType.STRING);
		cell.setValue(medication.getFrequencyIsNotNull() ? medication.getFrequency().getText() : "");
		cell.setReadOnly(true);
		
		column = form.dyngrdMedications().getColumns().getByIdentifier(COL_ROUTE);
		cell = row.getCells().newCell(column, DynamicCellType.STRING);
		cell.setValue((medication.getPrescribedDosesIsNotNull() && medication.getPrescribedDoses().size() > 0) ? (medication.getPrescribedDoses().get(0).getAdminRouteIsNotNull() ? medication.getPrescribedDoses().get(0).getAdminRoute().getText() : "") : "");
		cell.setReadOnly(true);
		
//		column = form.dyngrdMedications().getColumns().getByIdentifier(COL_COMMENCED_BY);
//		cell = row.getCells().newCell(column, DynamicCellType.STRING);
//		cell.setValue(medication.getHcpCommencedIsNotNull() ? medication.getHcpCommenced().toString() : "");
//		cell.setReadOnly(true);

//		column = form.dyngrdMedications().getColumns().getByIdentifier(COL_COMMENCED_DATE);
//		cell = row.getCells().newCell(column, DynamicCellType.DATE);
//		cell.setValue(medication.getCommencedDate());
//		cell.setReadOnly(true);

		column = form.dyngrdMedications().getColumns().getByIdentifier(COL_SELECT);
		cell = row.getCells().newCell(column, DynamicCellType.BOOL);
		cell.setValue(Boolean.FALSE);
		cell.setReadOnly(false);
		
		// Set row value
		row.setValue(medication);
	}

	private PatientMedicationVoCollection getSelectedMedications()
	{
		if (form.dyngrdMedications().getRows().size() == 0)
			return null;
		
		PatientMedicationVoCollection medications = new PatientMedicationVoCollection();
		
		DynamicGridColumn column = form.dyngrdMedications().getColumns().getByIdentifier(COL_SELECT);
		
		for (int i = 0; i < form.dyngrdMedications().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdMedications().getRows().get(i);
			
			if (row == null || !(row.getValue() instanceof PatientMedicationVo) || !Boolean.TRUE.equals(row.getCells().get(column).getValue()))
				continue;
			
			medications.add((PatientMedicationVo) row.getValue());
		}
		
		return medications;
	}

	public void clear()
	{
		// Clear non-instance controls
		
		// Clear instance controls
		clearInstanceControls();
	}
	
	public void clearInstanceControls()
	{
		// Clear dynamic grid
		form.dyngrdMedications().getRows().clear();
	}
	
	public void updateControlsState()
	{
		// TODO: Add you code here.
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	public void updateInstance()
	{
		// TODO: Add you code here.
	}
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
		return false;
	}
}
