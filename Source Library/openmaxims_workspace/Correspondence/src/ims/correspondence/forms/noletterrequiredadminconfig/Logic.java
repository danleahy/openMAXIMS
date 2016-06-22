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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.62 build 3035.29542)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.noletterrequiredadminconfig;

import ims.core.vo.ClinicLiteVo;
import ims.core.vo.ClinicLiteVoCollection;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.SpecialtyCollection;
import ims.correspondence.vo.NoLetterIsRequiredVo;
import ims.correspondence.vo.NoLetterIsRequiredVoCollection;
import ims.correspondence.vo.lookups.Yes;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.lookups.LookupService;
import ims.framework.Control;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridCellItem;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Image;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int COL_IMAGE = 1;
	private static final int COL_HEADING =2;
	private static final int COL_NEWEXCLUDE =3;
	private static final int COL_REVIEWEXCLUDE =4;
	
	private enum Correspondence
	{ 
		CLINICS (0, "Clinics"), CONSULTANTS (1, "Consultants"), SPECIALTY (2, "Specialties");
		
		private int index;
		private String value;
		
		Correspondence(int index, String value)
		{
			this.index = index;
			this.value = value;
		}
		
		public int getIndex()
		{
			return index;
		}
		
		public String getStringName()
		{
			return this.value;
		}
	}

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	@Override
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
		super.initialize();
		initializeGrid();
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		populateGrid();
	}
	
	private void initializeGrid() 
	{
		form.dyngrdLetter().clear();
		form.dyngrdLetter().getColumns().newColumn("", COL_IMAGE);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE).setCanGrow(false);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE).setWidth(60);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE).setAlignment(Alignment.RIGHT);
		
		form.dyngrdLetter().getColumns().newColumn("Clinics / Consultants / Specialties", COL_HEADING);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING).setWidth(500);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING).setCanGrow(true);
		
		form.dyngrdLetter().getColumns().newColumn("New Clinics", COL_NEWEXCLUDE);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_NEWEXCLUDE).setWidth(100);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_NEWEXCLUDE).setCanGrow(false);
		
		form.dyngrdLetter().getColumns().newColumn("Review Clinics", COL_REVIEWEXCLUDE);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_REVIEWEXCLUDE).setWidth(100);
		form.dyngrdLetter().getColumns().getByIdentifier(COL_REVIEWEXCLUDE).setCanGrow(false);
		
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	
	@Override
	protected void onDyngrdLetterCellTextSubmited(ims.framework.controls.DynamicGridCell cell)
	{
		if(cell.getRow() != null && cell.getRow().getParent() != null && cell.getRow().getParent().getValue() instanceof Correspondence)
		{
			if (cell.getTypedText() == null || cell.getTypedText().length() < 3)
			{
				engine.showMessage("Please enter at least 3 characters for search criteria");
				return;
			}
			
			switch((Correspondence) cell.getRow().getParent().getValue())
			{
				case CONSULTANTS:
					populateQueryConsultants(cell, cell.getTypedText());
					break;
				case SPECIALTY:
					populateQuerySpecialty(cell, cell.getTypedText());
					break;
				case CLINICS:	
					populateQueryClinics(cell, cell.getTypedText());
					break;
			}
		}
	}
	
	private void populateQueryClinics(DynamicGridCell cell, String textTyped) 
	{
		cell.getItems().clear();
		ClinicLiteVoCollection clinicsColl = domain.listClinics(textTyped);
		
		if(clinicsColl != null)
		{
			for(int i=0; i<clinicsColl.size(); i++)
			{
				if(clinicNotOnScreen(clinicsColl.get(i), cell.getRow().getParent()))
				{
					DynamicGridCellItem newComboItem = cell.getItems().newItem(clinicsColl.get(i));
				}
			}
			
			if(clinicsColl.size() > 0)
			{
				cell.showOpened();
			}
		}
	}

	private boolean clinicNotOnScreen(ClinicLiteVo clinicLiteVo, DynamicGridRow parentRow) 
	{
		for(int i=0; i<parentRow.getRows().size(); i++)
		{
			if(clinicLiteVo.equals(parentRow.getRows().get(i).getValue()))
					return false;
		}
		return true;
	}

	private void populateQuerySpecialty(DynamicGridCell cell, String string) 
	{
		cell.getItems().clear();
		
		LookupService lookup = domain.getLookupService();
		SpecialtyCollection collection = (SpecialtyCollection) lookup.getLookupCollection(Specialty.TYPE_ID,SpecialtyCollection.class, Specialty.class);
		
		if(collection != null)
		{
			for(int i=0; i<collection.size(); i++)
			{
				if(validTypedText(cell.getTypedText(), collection.get(i).getIItemText()) 
						&& specialtyNotOnScreen(collection.get(i), cell.getRow().getParent()))
				{
					DynamicGridCellItem newComboItem = cell.getItems().newItem(collection.get(i));
				}
			}
			if(collection.size() > 0)
			{
				cell.showOpened();
			}
		}	
	}

	private boolean specialtyNotOnScreen(Specialty specialty, DynamicGridRow parentRow) 
	{
		for(int i=0; i<parentRow.getRows().size(); i++)
		{
			if(specialty.equals(parentRow.getRows().get(i).getValue()))
			{
				return false;
			}
		}
		return true;
	}

	private boolean validTypedText(String typedText, String inputString) 
	{
		if(typedText == null || typedText.length() == 0)
			return false;
		 
		String typedTextNew = typedText.replaceAll("%", "");
		
		if(typedTextNew.length() == 0)
			return true;
		
		if(inputString.toLowerCase().indexOf(typedTextNew.toLowerCase()) >= 0)
			return true;
		
		return false;
	}

	private void populateQueryConsultants(DynamicGridCell cell, String textTyped) 
	{
		cell.getItems().clear();
		MedicLiteVoCollection medicColl = domain.listConsultants(textTyped);
		
		if(medicColl != null)
		{
			for(int i=0; i<medicColl.size(); i++)
			{
				if(consultantNotOnScreen(medicColl.get(i), cell.getRow().getParent()))
				{
					DynamicGridCellItem newComboItem = cell.getItems().newItem(medicColl.get(i));
				}
			}
			
			if(medicColl.size() > 0)
			{
				cell.showOpened();
			}
		}
	}

	private boolean consultantNotOnScreen(MedicLiteVo medicLiteVo, DynamicGridRow parentRow) 
	{
		for(int i=0; i<parentRow.getRows().size(); i++)
		{
			if(medicLiteVo.equals(parentRow.getRows().get(i).getValue()))
			{
				return false;
			}
		}
		return true;
		
	}

	@Override
	protected void onDyngrdLetterRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		updateControlsState();
	}
	
	private void populateGrid() 
	{
		form.dyngrdLetter().getRows().clear();
		populateProfile();
	}

	private void populateProfile() 
	{
		for (Correspondence correspondence : Correspondence.values())
		{
			DynamicGridRow row = form.dyngrdLetter().getRows().newRow();
			DynamicGridColumn column = null;
			DynamicGridCell cell = null;
			
			row.setBackColor(Color.Beige);
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE);
			cell = row.getCells().newCell(column, DynamicCellType.IMAGE);
			cell.setValue(getImageParent(correspondence));
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING);
			cell = row.getCells().newCell(column, DynamicCellType.STRING);
			cell.setValue(correspondence.getStringName());
			cell.setReadOnly(true);
			
			row.setExpanded(true);
			row.setValue(correspondence);
			
			NoLetterIsRequiredVoCollection listLetter = domain.listNoLetterIsRequired();
			
			if(listLetter != null)
			{
				for(int i=0; i<listLetter.size(); i++)
				{
					populateChilds(row, correspondence, listLetter.get(i));
				}
			}
		}
	}

	private void populateChilds(DynamicGridRow parentRow, Correspondence correspondence, NoLetterIsRequiredVo letter) 
	{
		switch(correspondence)
		{
			case CONSULTANTS:
				populateConsultants(parentRow, letter);
				break;
			case SPECIALTY:
				populateSpecialty(parentRow, letter);
				break;
			case CLINICS:	
				populateClinics(parentRow, letter);
				break;
		}
	}

	private void populateClinics(DynamicGridRow parentRow, NoLetterIsRequiredVo letter) 
	{
		if(letter.getNewClinicsIsNotNull())
		{
			parentRow.getRows().clear();
			for(int i=0; i<letter.getNewClinics().size(); i++)
			{
				DynamicGridRow childRow = parentRow.getRows().newRow();
				populateRowClinic(childRow, letter.getNewClinics().get(i), true, false, true);
			}
		}
		if(letter.getReviewClinicsIsNotNull())
		{
			for(int i=0; i<letter.getReviewClinics().size(); i++)
			{
				boolean foundClinic = false;
				if(parentRow.getRows() != null)
				{
					for(int j=0; j<parentRow.getRows().size(); j++)
					{
						if(parentRow.getRows().get(j).getValue().equals(letter.getReviewClinics().get(i)))
						{
							foundClinic = true;
							populateRowClinic(parentRow.getRows().get(j), letter.getReviewClinics().get(i), false, true, false);
							break;
						}
					}
					if(!foundClinic)
					{
						DynamicGridRow childRow = parentRow.getRows().newRow();
						populateRowClinic(childRow, letter.getReviewClinics().get(i), false, true, true);
					}
				}
			}
		}
	}

	private void populateRowClinic(DynamicGridRow childRow, ClinicLiteVo clinicLiteVo, boolean newClinic, boolean reviewClinic, boolean createRow) 
	{
		if(createRow)
		{
			DynamicGridColumn column = null;
			DynamicGridCell cell = null;
			
			childRow.setValue(clinicLiteVo);
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE);
			cell = childRow.getCells().newCell(column, DynamicCellType.IMAGE);
			cell.setValue(form.getImages().Admin.Clinic01);
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING);
			cell = childRow.getCells().newCell(column, DynamicCellType.STRING);
			cell.setReadOnly(true);
			cell.setValue(clinicLiteVo.getClinicName());
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_NEWEXCLUDE);
			cell = childRow.getCells().newCell(column, DynamicCellType.ANSWER);
			engine.populate(cell, ims.correspondence.vo.lookups.Yes.getNegativeInstancesAsIItemCollection());
			cell.setAutoPostBack(false);
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_REVIEWEXCLUDE);
			cell = childRow.getCells().newCell(column, DynamicCellType.ANSWER);
			engine.populate(cell, ims.correspondence.vo.lookups.Yes.getNegativeInstancesAsIItemCollection());
			cell.setAutoPostBack(false);
		}
		
		if(newClinic)
		{
			childRow.getCells().get(form.dyngrdLetter().getColumns().getByIdentifier(COL_NEWEXCLUDE)).setValue(ims.correspondence.vo.lookups.Yes.YES);
		}
		if(reviewClinic)
		{
			childRow.getCells().get(form.dyngrdLetter().getColumns().getByIdentifier(COL_REVIEWEXCLUDE)).setValue(ims.correspondence.vo.lookups.Yes.YES);
		}
		
	}

	private void populateSpecialty(DynamicGridRow parentRow, NoLetterIsRequiredVo letter) 
	{
		if(letter.getSpecialtiesIsNotNull())
		{
			parentRow.getRows().clear();
			for(int i=0; i<letter.getSpecialties().size(); i++)
			{
				populateRowSpecialty(parentRow, letter.getSpecialties().get(i));
			}
		}
	}

	private void populateRowSpecialty(DynamicGridRow parentRow, Specialty specialty) 
	{
		DynamicGridRow childRow = parentRow.getRows().newRow();
		DynamicGridColumn column = null;
		DynamicGridCell cell = null;
		
		childRow.setValue(specialty);
		
		column = form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE);
		cell = childRow.getCells().newCell(column, DynamicCellType.IMAGE);
		cell.setValue(form.getImages().Admin.Specialty01);
		
		column = form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING);
		cell = childRow.getCells().newCell(column, DynamicCellType.STRING);
		cell.setReadOnly(true);
		cell.setValue(specialty.getIItemText());
	}

	private void populateConsultants(DynamicGridRow parentRow, NoLetterIsRequiredVo letter) 
	{
		if(letter.getConsultantsIsNotNull())
		{
			parentRow.getRows().clear();
			for(int i=0; i<letter.getConsultants().size(); i++)
			{
				populateRowConsultant(parentRow, letter.getConsultants().get(i));
			}
		}
	}

	private void populateRowConsultant(DynamicGridRow parentRow, MedicLiteVo medicLiteVo) 
	{
		DynamicGridRow childRow = parentRow.getRows().newRow();
		DynamicGridColumn column = null;
		DynamicGridCell cell = null;
		
		childRow.setValue(medicLiteVo);
		
		column = form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE);
		cell = childRow.getCells().newCell(column, DynamicCellType.IMAGE);
		cell.setValue(form.getImages().Core.User);
		
		column = form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING);
		cell = childRow.getCells().newCell(column, DynamicCellType.STRING);
		cell.setReadOnly(true);
		cell.setValue(medicLiteVo.getName().toString());
	}

	private Image getImageParent(Correspondence correspondence) 
	{
		switch(correspondence)
		{
			case CONSULTANTS:
				return form.getImages().Core.Users;
			case SPECIALTY:
				return form.getImages().Admin.Specialty02;
			case CLINICS:
				return form.getImages().Admin.Clinic02;
		}
		return null;
	}
	
	private Image getImageChild(Correspondence correspondence) 
	{
		switch(correspondence)
		{
			case CONSULTANTS:
				return form.getImages().Core.User;
			case SPECIALTY:
				return form.getImages().Admin.Specialty01;
			case CLINICS:
				return form.getImages().Admin.Clinic01;
		}
		return null;
	}

	public void clearInstanceControls()
	{
		// TODO: Add you code here.
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		NoLetterIsRequiredVo voNLR = domain.getNLRItems();
		
		if (voNLR == null)
			voNLR = new NoLetterIsRequiredVo();
		
		populateNoLetterIsRequiredVo(voNLR);
		
		String[] errors = voNLR.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}						
		try 
		{
			domain.saveNoLetterIsRequired(voNLR);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		
		return true;
	}
	
	private void populateNoLetterIsRequiredVo(NoLetterIsRequiredVo voNLR) 
	{
		MedicLiteVoCollection med = new MedicLiteVoCollection();
		SpecialtyCollection spec = new SpecialtyCollection();
		ClinicLiteVoCollection newClin = new ClinicLiteVoCollection();
		ClinicLiteVoCollection reviewClin = new ClinicLiteVoCollection();
		
		for(int i=0; i<form.dyngrdLetter().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdLetter().getRows().get(i);
			if(row.getValue() instanceof Correspondence)
			{
				for(int j=0; j<row.getRows().size(); j++)
				{
					DynamicGridRow childRow = row.getRows().get(j);
					
					if(childRow.getValue() instanceof MedicLiteVo)
					{
						med.add((MedicLiteVo) childRow.getValue());
					}
					
					if(childRow.getValue() instanceof Specialty)
					{
						spec.add((Specialty) childRow.getValue());
					}
				
					if(childRow.getValue() instanceof ClinicLiteVo)
					{
						DynamicGridCell newClinicCell = childRow.getCells().get(form.dyngrdLetter().getColumns().getByIdentifier(COL_NEWEXCLUDE));
						DynamicGridCell reviewClinicCell = childRow.getCells().get(form.dyngrdLetter().getColumns().getByIdentifier(COL_REVIEWEXCLUDE));
						if(newClinicCell.getValue() != null && newClinicCell.getValue().equals(Yes.YES))
						{
							newClin.add((ClinicLiteVo) childRow.getValue());
						}
						if(reviewClinicCell.getValue() != null && reviewClinicCell.getValue().equals(Yes.YES))
						{
							reviewClin.add((ClinicLiteVo) childRow.getValue());
						}
					}
				}
			}
		}
		
		voNLR.setConsultants(med);
		voNLR.setSpecialties(spec);
		voNLR.setNewClinics(newClin);
		voNLR.setReviewClinics(reviewClin);
		voNLR.setIsActive(Boolean.TRUE);
	}

	public void updateControlsState()
	{
		form.getContextMenus().Correspondence.getNoLetterIsRequiredADDItem().setVisible(form.getMode().equals(FormMode.EDIT) && form.dyngrdLetter().getValue() instanceof Correspondence);
		form.getContextMenus().Correspondence.getNoLetterIsRequiredREMOVEItem().setVisible(form.getMode().equals(FormMode.EDIT) 
				&& (form.dyngrdLetter().getValue() instanceof ClinicLiteVo 
						|| form.dyngrdLetter().getValue() instanceof Specialty
							|| form.dyngrdLetter().getValue() instanceof MedicLiteVo));
	}
	
	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.CorrespondenceNamespace.NoLetterIsRequired.ADD:
				addInstance(form.dyngrdLetter().getSelectedRow(), form.dyngrdLetter().getValue());
				break;
			case GenForm.ContextMenus.CorrespondenceNamespace.NoLetterIsRequired.REMOVE:
				removeInstance(form.dyngrdLetter().getSelectedRow());
		}
		updateControlsState();
	}

	private void removeInstance(DynamicGridRow selectedRow) 
	{
		if(selectedRow.getValue() instanceof ClinicLiteVo 
				|| selectedRow.getValue() instanceof Specialty
					|| selectedRow.getValue() instanceof MedicLiteVo)
		{
			form.dyngrdLetter().getRows().remove(selectedRow);
		}
	}

	private void addInstance(DynamicGridRow parentRow, Object value) 
	{
		if(value instanceof Correspondence)
		{
			parentRow.setExpanded(true);
			
			DynamicGridRow childRow = parentRow.getRows().newRow(true);
			
			DynamicGridColumn column = null;
			DynamicGridCell cell = null;
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_IMAGE);
			cell = childRow.getCells().newCell(column, DynamicCellType.IMAGE);
			cell.setValue(getImageChild((Correspondence) value));
			
			column = form.dyngrdLetter().getColumns().getByIdentifier(COL_HEADING);
			cell = childRow.getCells().newCell(column, DynamicCellType.QUERYCOMBOBOX);
			cell.setTooltip("");
			cell.setAutoPostBack(true);
			
			if(((Correspondence) value).equals(Correspondence.CLINICS))
			{
				column = form.dyngrdLetter().getColumns().getByIdentifier(COL_NEWEXCLUDE);
				cell = childRow.getCells().newCell(column, DynamicCellType.ANSWER);
				engine.populate(cell, ims.correspondence.vo.lookups.Yes.getNegativeInstancesAsIItemCollection());
				cell.setAutoPostBack(false);
				
				column = form.dyngrdLetter().getColumns().getByIdentifier(COL_REVIEWEXCLUDE);
				cell = childRow.getCells().newCell(column, DynamicCellType.ANSWER);
				engine.populate(cell, ims.correspondence.vo.lookups.Yes.getNegativeInstancesAsIItemCollection());
				cell.setAutoPostBack(false);
			}
		}
	}

	@Override
	protected void onDyngrdLetterCellValueChanged(DynamicGridCell cell) 
	{
		if(cell.getValue() != null && cell.getRow() != null && cell.getRow().getParent() != null && cell.getRow().getParent().getValue() instanceof Correspondence)
		{
			if(!(cell.getValue() instanceof Yes))
			{
				cell.getRow().setValue(cell.getValue());
			}
		}
	}
}
