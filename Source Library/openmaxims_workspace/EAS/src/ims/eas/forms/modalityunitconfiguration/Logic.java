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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.forms.modalityunitconfiguration;

import java.util.Iterator;

import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.eas.forms.modalityunitconfiguration.GenForm.grdModalityUnitDetailsRow;
import ims.eas.forms.treatmentsiteconfiguration.GenForm;
import ims.eas.vo.ModalityConfigVo;
import ims.eas.vo.ModalityConfigVoCollection;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initalise();
		open();
	}
	
	private void initalise() 
	{
		//default search
		form.chkActiveSearch().setValue(true);
		ModalityConfigVo vo = new ModalityConfigVo();
		vo.setActive(true);
		form.getLocalContext().setcurrentSearchFilter(vo);
	}

	private void open() 
	{
		//assuming there is not going to a huge number of records, so by default showing all records.
		displayRecord(null);
		populateConfigurationGrid(form.getLocalContext().getcurrentSearchFilter());		
		form.setMode(FormMode.VIEW);
		
	}
	private void populateConfigurationGrid(ModalityConfigVo filter) 
	{
		
		form.grdModalityUnitDetails().getRows().clear();
				
		ModalityConfigVoCollection voColl = domain.list(filter);
		
		Iterator iter = voColl.iterator();
		
		if (iter != null && iter.hasNext())
		{
			ModalityConfigVo vo = null;
			
			while (iter.hasNext()) 
			{
				vo = (ModalityConfigVo)iter.next();
				grdModalityUnitDetailsRow row = form.grdModalityUnitDetails().getRows().newRow();
				row.setModality(vo.getModalityIsNotNull()?vo.getModality().getText():"");
				row.setUnit(vo.getUnitIsNotNull()?vo.getUnit().getText():"");
				row.setEnergy(vo.getEnergyIsNotNull()?vo.getEnergy().toString():"");
				if (vo.getActiveIsNotNull())
				{
					row.setActive(vo.getActive()?form.getImages().Core.AnswerBox_Yes:form.getImages().Core.AnswerBox_No);
				}
				else
					row.setActive(form.getImages().Core.AnswerBox_Yes);
				row.setValue(vo);
			}
			
			if (form.getLocalContext().getcurrentSelectionIsNotNull())
			{
				form.getLocalContext().setcurrentSelection(domain.get(form.getLocalContext().getcurrentSelection()));
				form.grdModalityUnitDetails().setValue(form.getLocalContext().getcurrentSelection());			
				displayRecord(form.getLocalContext().getcurrentSelection());
			}
			
		}
		else
		{
			engine.showMessage("No records found.");
		}
				
		updateControlsState();
	}
	
	protected void onGrdModalityUnitDetailsSelectionChanged()
	{
		form.getLocalContext().setcurrentSelection(form.grdModalityUnitDetails().getValue());
		displayRecord(form.getLocalContext().getcurrentSelection());
		updateControlsState();
	}
	
	private void displayRecord(ModalityConfigVo currentSelection) 
	{		 
		form.ctnDetail().cmbModalityNew().setValue(null);
		form.ctnDetail().cmbUnitNew().setValue(null);
		form.ctnDetail().decEnergy().setValue(null);
		form.ctnDetail().chkActive().setValue(null);
		
		if (currentSelection != null)
		{
			if (form.getLocalContext().getcurrentSearchFilterIsNotNull())
			{
				 if (form.getLocalContext().getcurrentSearchFilter().getActiveIsNotNull() 
						 && (!form.getLocalContext().getcurrentSearchFilter().getActive() || form.getLocalContext().getcurrentSearchFilter().getActive().equals(currentSelection.getActive())))
				 {
						form.ctnDetail().cmbModalityNew().setValue(currentSelection.getModality());
						form.ctnDetail().cmbUnitNew().setValue(currentSelection.getUnit());
						form.ctnDetail().decEnergy().setValue(currentSelection.getEnergy());
						form.ctnDetail().chkActive().setValue(currentSelection.getActiveIsNotNull()?currentSelection.getActive():true);
						form.btnEdit().setEnabled(true);
				 }
			}
			else
			{
				form.ctnDetail().cmbModalityNew().setValue(currentSelection.getModality());
				form.ctnDetail().cmbUnitNew().setValue(currentSelection.getUnit());
				form.ctnDetail().decEnergy().setValue(currentSelection.getEnergy());
				form.ctnDetail().chkActive().setValue(currentSelection.getActiveIsNotNull()?currentSelection.getActive():true);				
			}
		}
	}

	protected void onGrdModalityUnitDetailsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setcurrentSelection(null);
		displayRecord(null);
	}
	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setcurrentSelection(null);
		form.grdModalityUnitDetails().setValue(null);
		displayRecord(null);		
		form.setMode(FormMode.EDIT);
	}
	
	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.grdModalityUnitDetails().getSelectedRowIndex()>-1)
		{
			form.getLocalContext().setcurrentSelection(form.grdModalityUnitDetails().getValue());
			form.setMode(FormMode.EDIT);
		}
		else
			engine.showMessage("Please select a configuration entry in the grid to edit.");
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ModalityConfigVo vo = null;
		
		if (form.grdModalityUnitDetails().getValue() == null)
			//save new entry
			vo = new ModalityConfigVo();
		else
			//update an existing entry
			vo = form.getLocalContext().getcurrentSelection();

		vo.setModality(form.ctnDetail().cmbModalityNew().getValue());
		vo.setUnit(form.ctnDetail().cmbUnitNew().getValue());
		vo.setEnergy(form.ctnDetail().decEnergy().getValue());
		vo.setActive(form.ctnDetail().chkActive().getValue());
		
		String[] arrErrors = vo.validate();
		if (arrErrors != null)
		{
			engine.showErrors("Validation Errors", arrErrors);
			return;
		}
		
		try {
			form.getLocalContext().setcurrentSelection(domain.save(vo));
			//onImbSearchClick();
			open();
		} catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
		} catch (StaleObjectException e) 
		{
			engine.showMessage("Record was updated by another user. Screen will refresh.");
			form.getLocalContext().setcurrentSelection(domain.get(form.getLocalContext().getcurrentSelection()));
			onImbSearchClick();
			open();
			return;
		} catch (ForeignKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
		} catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());			
		}
		
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		onImbSearchClick();
	}

	
	protected void onImbClearClick() throws PresentationLogicException 
	{		
		clearScreen();
		updateControlsState();		
	}

	private void clearScreen()
	{
		form.grdModalityUnitDetails().getRows().clear();
		form.ctnDetail().chkActive().setValue(null);
		form.ctnDetail().cmbModalityNew().setValue(null);
		form.ctnDetail().cmbUnitNew().setValue(null);
		form.ctnDetail().cmbUnitNew().setValue(null);
		form.ctnDetail().decEnergy().setValue(null);

		form.cmbModalitySearch().setValue(null);
		form.cmbUnitSearch().setValue(null);
		form.chkActiveSearch().setValue(true);
	}
	
	protected void onImbSearchClick() throws PresentationLogicException 
	{		
		ModalityConfigVo vo = new ModalityConfigVo();
		form.getLocalContext().setcurrentSelection(null);
		displayRecord(null);
		vo.setModality(form.cmbModalitySearch().getValue());
		vo.setUnit(form.cmbUnitSearch().getValue());
		vo.setActive(form.chkActiveSearch().getValue());
		form.getLocalContext().setcurrentSearchFilter(vo);
		populateConfigurationGrid(vo);
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.EASNamespace.TreatmentSiteConfigMenu.NEW:
				onBtnNewClick();
				break;
			case GenForm.ContextMenus.EASNamespace.TreatmentSiteConfigMenu.EDIT:
				onBtnEditClick();
				break;
		}
	}
	
	private void updateControlsState()
	{

		form.btnEdit().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdModalityUnitDetails().getSelectedRow() != null);
		form.btnEdit().setEnabled(form.getMode().equals(FormMode.VIEW) && form.grdModalityUnitDetails().getSelectedRow() != null);

		form.getContextMenus().EAS.getModalityUnitConfigMenuNEWItem().setVisible(form.getMode().equals(FormMode.VIEW));
		form.getContextMenus().EAS.getModalityUnitConfigMenuNEWItem().setEnabled(form.getMode().equals(FormMode.VIEW));
		
		form.getContextMenus().EAS.getModalityUnitConfigMenuEDITItem().setVisible(form.getMode().equals(FormMode.VIEW) && form.grdModalityUnitDetails().getSelectedRow() != null);
		form.getContextMenus().EAS.getModalityUnitConfigMenuEDITItem().setEnabled(form.getMode().equals(FormMode.VIEW) && form.grdModalityUnitDetails().getSelectedRow() != null);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
}
