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
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4084.19189)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.theatretrackingconfig;

import ims.RefMan.vo.TrackingStatusConfigVo;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------
	//	Dynamic grid columns constants
	//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	private static final int COL_TRACKING_STATUS = -17;
	
	private static final int ROW_ID_TIMEPACU			= -192;
	private static final int ROW_ID_TIMEANAESTHETIC		= -193;
	private static final int ROW_ID_THEATREIN			= -194;
	private static final int ROW_ID_SURGERYSTART		= -195;
	private static final int ROW_ID_SURGERYFINISH		= -196;
	private static final int ROW_ID_TIMEINRECOVERY		= -197;
	private static final int ROW_ID_TIMEOUT				= -198;
	

	//----------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers region
	//----------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		// Intialize
		initialize();
		
		// Display data on screen
		open();
	}
	
	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		updateInstance();
	}
	
	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if (save())
			open();
	}
	
	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onDyngrdTrackingColorsRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		if (row.getValue() instanceof Color) 
			form.cmbColor().setValue((Color) row.getValue());
		else
			form.cmbColor().setValue(null);
		
		updateControlsState();//WDEV-12123
	}
	

	@Override
	protected void onDyngrdTrackingColorsRowSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbColor().setValue(null);
		
		updateControlsState();//WDEV-12123
	}

	@Override
	protected void onCmbColorValueChanged() throws PresentationLogicException
	{
		DynamicGridRow back = form.dyngrdTrackingColors().getSelectedRow();//WDEV-12123
		if (back != null)
			back.setValue(form.cmbColor().getValue());
		form.dyngrdTrackingColors().setSelectedRow(null);//WDEV-12123 - FWUI issue walk around
		form.dyngrdTrackingColors().setSelectedRow(back);//WDEV-12123
	}

	//----------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation function
	//----------------------------------------------------------------------------------------------------------------------------------------------------

	private void initialize()
	{
		// Initialize dynamic grid
		form.dyngrdTrackingColors().clear();
		DynamicGridColumn column = form.dyngrdTrackingColors().getColumns().newColumn("Status", COL_TRACKING_STATUS);
		column.setWidth(-1);
		
		// Bind colour to combobox
		Color[] colors = Color.getAllColors();
		
		form.cmbColor().clear();
		for (int i = 0; i < colors.length; i++)
		{
			form.cmbColor().newRow(colors[i], colors[i].getName(), colors[i].getImage());
		}
	}
	
	private void open() throws PresentationLogicException
	{
		// Clear screen
		clear();
		
		// Populate status grid colours
		form.getLocalContext().setCurrentSettings(domain.getTrackingStatus());
		populateInstanceControlsFromData(form.getLocalContext().getCurrentSettings());
		
		// Set form to VIEW mode
		form.setMode(FormMode.VIEW);
	}
	
	private void updateControlsState()//WDEV-12123
	{
    	if (FormMode.EDIT.equals(form.getMode()))
    	{
    		form.cmbColor().setEnabled(form.dyngrdTrackingColors().getSelectedRow()!=null);
    	}
	}

	private void clear()
	{
		form.dyngrdTrackingColors().getRows().clear();
		
		form.cmbColor().setValue(null);
	}

	private void updateInstance()
	{
		// Set form to edit mode
		form.setMode(FormMode.EDIT);
		
		updateControlsState();
	}
	
	private boolean save() throws PresentationLogicException
	{
		try
		{
			// Populate data from screen
			form.getLocalContext().setCurrentSettings(populateDataFromInstanceControls(form.getLocalContext().getCurrentSettings()));

			// Validate data
			String[] errors = form.getLocalContext().getCurrentSettings().validate();

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}

			form.getLocalContext().setCurrentSettings(domain.saveTrackingStatus(form.getLocalContext().getCurrentSettings()));

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
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			e.printStackTrace();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	//----------------------------------------------------------------------------------------------------------------------------------------------------
	//	Data exchange functions
	//----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Function will populate dynamic grid with status to have their values changed
	 * and will assign each row the saved colour
	 */
	private void populateInstanceControlsFromData(TrackingStatusConfigVo trackingConfig)
	{
		// Clear dynamic grid rows
		form.dyngrdTrackingColors().getRows().clear();
		
	
		// Create row for Time into PACU
		DynamicGridRow row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		DynamicGridCell cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Time into PACU</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getTimeintoPACU() : null);
		row.setIdentifier(ROW_ID_TIMEPACU);

	
		// Create row for Time anaesthetic given
		row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Time anaesthetist start</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getTimeStartAnaesthetist() : null);
		row.setIdentifier(ROW_ID_TIMEANAESTHETIC);

	
		// Create row for Theatre in
		row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Theatre in</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getTheatreIn() : null);
		row.setIdentifier(ROW_ID_THEATREIN);

	
		// Create row for Surgery start
		row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Surgery start</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getSurgeryStart() : null);
		row.setIdentifier(ROW_ID_SURGERYSTART);

		// Create row for Surgery finish
		row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Surgery finish</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getSurgeryFinish() : null);
		row.setIdentifier(ROW_ID_SURGERYFINISH);

		// Create row for Stage 1 recovery
		row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Time into recovery</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getTimeIntoRecovery() : null);
		row.setIdentifier(ROW_ID_TIMEINRECOVERY);

		// Create row for Time out of recovery
		row = form.dyngrdTrackingColors().getRows().newRow();
		// Create cell for text
		cell = row.getCells().newCell(form.dyngrdTrackingColors().getColumns().getByIdentifier(COL_TRACKING_STATUS), DynamicCellType.STRING);
		cell.setValue("<b>Time out of recovery</b>");
		// Set row value and identifier
		row.setValue(trackingConfig != null ? trackingConfig.getTimeOutOfRecovery() : null);
		row.setIdentifier(ROW_ID_TIMEOUT);
	}



	private TrackingStatusConfigVo populateDataFromInstanceControls(TrackingStatusConfigVo currentSettings)
	{
		// If no current settings exist create a new VO
		if (currentSettings == null)
			currentSettings = new TrackingStatusConfigVo();

		
		// Iterate dynamic grid rows
		for (int i = 0; i < form.dyngrdTrackingColors().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdTrackingColors().getRows().get(i);
			
			// Crash if row identifier is not integer
			if (!(row.getIdentifier() instanceof Integer))
				throw new CodingRuntimeException("Can not exist rows without Integer identifiers");
			
			switch ((Integer) row.getIdentifier())
			{
				case ROW_ID_TIMEPACU:
					currentSettings.setTimeintoPACU(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
				case ROW_ID_TIMEANAESTHETIC:
					currentSettings.setTimeStartAnaesthetist(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
				case ROW_ID_THEATREIN:
					currentSettings.setTheatreIn(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
				case ROW_ID_SURGERYSTART:
					currentSettings.setSurgeryStart(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
				case ROW_ID_SURGERYFINISH:
					currentSettings.setSurgeryFinish(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
				case ROW_ID_TIMEINRECOVERY:
					currentSettings.setTimeIntoRecovery(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
				case ROW_ID_TIMEOUT:
					currentSettings.setTimeOutOfRecovery(row.getValue() instanceof Color ? (Color) row.getValue() : null);
					break;
			}
		}

		return currentSettings;
	}
}
