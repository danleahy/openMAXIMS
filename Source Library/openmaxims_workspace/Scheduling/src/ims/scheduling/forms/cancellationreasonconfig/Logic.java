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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.62 build 3084.20071)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.forms.cancellationreasonconfig;

import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.scheduling.forms.cancellationreasonconfig.GenForm.grdCancellationReasonsRow;
import ims.scheduling.vo.CancellationTypeReasonVo;
import ims.scheduling.vo.CancellationTypeReasonVoCollection;
import ims.scheduling.vo.lookups.CancelAppointmentReasonCollection;
import ims.scheduling.vo.lookups.LookupHelper;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.scheduling.vo.lookups.Status_ReasonCollection;
import ims.vo.LookupInstVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;
	
	private static final int COL_NON_MEDICAL_REASON_INDEX = 1;
	private static final int COL_SELECTED_INDEX = 2;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		populateCancellationTypeGrid();
		populateCancellationReasonGrid();
		open();
	}

	private void populateCancellationReasonGrid()
	{
		form.grdCancellationReasons().getRows().clear();
		CancelAppointmentReasonCollection cancelAppReasonColl = LookupHelper.getCancelAppointmentReason(domain.getLookupService());

		for (int i = 0; i < cancelAppReasonColl.size(); i++)
		{
			GenForm.grdCancellationReasonsRow row = form.grdCancellationReasons().getRows().newRow();
			row.setValue(cancelAppReasonColl.get(i));
			row.setcolCancellationReason(cancelAppReasonColl.get(i).getText());			
		}
	}

	private void populateCancellationTypeGrid()
	{
		form.grdCancellationType().getRows().clear();
		Status_ReasonCollection cancellationTypeCollection = LookupHelper.getStatus_Reason(domain.getLookupService());

		for (int i = 0; i < cancellationTypeCollection.size(); i++)
		{
			Status_Reason status_reason = cancellationTypeCollection.get(i);
			if (status_reason.equals(Status_Reason.CANCELLED))
			{
				Status_Reason reason = status_reason;
				ArrayList<LookupInstVo> reasonInstances = reason.getChildInstances();
				for (int j = 0; j < reason.getChildInstances().size(); j++)
				{
					LookupInstVo reasonInstance = reasonInstances.get(j);

					if (reasonInstance.equals(Status_Reason.HOSPITALCANCELLED) || reasonInstance.equals(Status_Reason.PATIENTCANCELLED))
					{
						GenForm.grdCancellationTypeRow row = form.grdCancellationType().getRows().newRow();
						row.setValue((Status_Reason) reasonInstance);
						row.setcolCancellationType(reasonInstance.getText());
					}
				}

			}

		}

	}

	private void open()
	{
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearReasonSettings();
		listCancellationReasons(form.grdCancellationType().getValue());
		open();
	}

	private void clearReasonSettings()
	{
		for (int i = 0; i < form.grdCancellationReasons().getRows().size(); i++)
		{
			GenForm.grdCancellationReasonsRow row = form.grdCancellationReasons().getRows().get(i);
			if (row == null)
				continue;
			row.setcolSelected(false);
			row.setcolNonMedicalReason(false);
			row.setColOutpatients(false);
			row.setColTciTheatre(false);
		}

	}
	private boolean save()
	{
		CancellationTypeReasonVoCollection typeReasonCol = new CancellationTypeReasonVoCollection();

		for (int i = 0; i < form.grdCancellationReasons().getRows().size(); i++)
		{
			GenForm.grdCancellationReasonsRow row = form.grdCancellationReasons().getRows().get(i);

			if (row.getcolSelected())
			{
				CancellationTypeReasonVo cancelTypeReason = new CancellationTypeReasonVo();

				cancelTypeReason.setCancellationType(form.grdCancellationType().getValue());
				cancelTypeReason.setCancellationReason(row.getValue());
				cancelTypeReason.setIsNonMedicalReason(row.getcolNonMedicalReason()); //WDEV-19446
				cancelTypeReason.setOutpatients(row.getColOutpatients());
				cancelTypeReason.setTCITheatre(row.getColTciTheatre());
				typeReasonCol.add(cancelTypeReason);
			}

		}

		String[] error = typeReasonCol.validate();

		if (error != null)
		{
			engine.showErrors(error);
			return false;
		}

		try
		{
			domain.saveCancellationTypeReasons(typeReasonCol, form.grdCancellationType().getValue());

		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage("There are data items in the system referencing this item");
			open();
			return false;
		}
		return true;
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);		
	}

	@Override
	protected void onGrdCancellationTypeChanged() throws ims.framework.exceptions.PresentationLogicException
	{
				
		clearReasonSettings();
		listCancellationReasons(form.grdCancellationType().getValue());
		updateControlsState();

	}

	private void listCancellationReasons(Status_Reason value)
	{
		CancellationTypeReasonVoCollection cancelTypeReasonVo = domain.listCancelationTypeReason(value);
		if (cancelTypeReasonVo == null)
			return;
		for (int i = 0; i < cancelTypeReasonVo.size(); i++)
		{
			CancellationTypeReasonVo typeReason = cancelTypeReasonVo.get(i);
			GenForm.grdCancellationReasonsRow row = form.grdCancellationReasons().getRowByValue(typeReason.getCancellationReason());
			if (row != null) //WDEV-19446
			{	
				row.setcolSelected(true);
				row.setcolNonMedicalReason(typeReason.getIsNonMedicalReasonIsNotNull() ? typeReason.getIsNonMedicalReason().booleanValue() : false);
				row.setColOutpatients(Boolean.TRUE.equals(typeReason.getOutpatients()));
				row.setColTciTheatre(Boolean.TRUE.equals(typeReason.getTCITheatre()));
			}	
		}
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		
		if(sender.equals(form.grdCancellationType()))
			
			switch(menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Update:
					onBtnEditClick();
					
					break;
			}
		updateControlsState(); //WDEV-19446
		
		
	}
	//WDEV-19446
	@Override
	protected void onGrdCancellationReasonsGridCheckBoxClicked(int column,	grdCancellationReasonsRow row, boolean isChecked)	throws PresentationLogicException 
	{
		if (COL_NON_MEDICAL_REASON_INDEX == column && isChecked)
		{	
			row.setcolSelected(true);
		}
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
		
	}
	
	private void updateControlsState()
	{
		form.btnEdit().setEnabled(FormMode.VIEW.equals(form.getMode()) && form.grdCancellationType().getValue() != null);
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().getGenericGridUpdateItem().setVisible(FormMode.VIEW.equals(form.getMode()) && form.grdCancellationType().getValue() != null);		
	}
	
	//WDEV-19446 -----------------------end
}
