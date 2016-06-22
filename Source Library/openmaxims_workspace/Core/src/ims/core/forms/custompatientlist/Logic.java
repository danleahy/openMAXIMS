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
// This code was generated by Calin Perebiceanu using IMS Development Environment (version 1.71 build 3832.22959)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.forms.custompatientlist;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.custompatientlist.GenForm.grdDetailsRow;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.ColumnSortOrderVo;
import ims.core.vo.CustomListSearchCriteriaVo;
import ims.core.vo.CustomListVo;
import ims.core.vo.CustomListVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.PatientCustomItemVo;
import ims.core.vo.PatientCustomItemVoCollection;
import ims.core.vo.PatientCustomListVo;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.CustomListType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.PartialDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int SURNAME_COLUMN_ID = 1;
	private static final int FORENAME_COLUMN_ID = 2;
	private static final int IDENTIFIER_COLUMN_ID = 3;
	private static final int SEX_COLUMN_ID = 4;
	private static final int AGE_COLUMN_ID = 5;
	private static final int DOB_COLUMN_ID = 6;
	private static final int ADDED_BY_COLUMN_ID = 7;
	private static final int ADDED_DATE_TIME_COLUMN_ID = 8;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		listCustomLists();
		refreshSearchCriteria();
	}
	
	private void refreshSearchCriteria() 
	{
		if (form.getGlobalContext().Core.getCustomListSearchCriteriaVoIsNotNull())
		{
			if ( ! form.cmbCustomLists().getValues().isEmpty())
			{
				for(int i = 0 ; i < form.cmbCustomLists().getValues().size() ; i++)
				{
					if (form.cmbCustomLists().getValues() != null
						&& form.getGlobalContext().Core.getCustomListSearchCriteriaVo().getCustomListRefIsNotNull()
						&& form.cmbCustomLists().getValues().get(i) != null
						&& ((CustomListVo)form.cmbCustomLists().getValues().get(i)).getID_CustomList().equals(form.getGlobalContext().Core.getCustomListSearchCriteriaVo().getCustomListRef().getID_CustomList()))
					{
						form.cmbCustomLists().setValue(((CustomListVo)form.cmbCustomLists().getValues().get(i)));
						
						//if(domain.getHcpLiteUser()!=null)//WDEV-9696 
						//{
						    updateButtonState(); //WDEV-18640
						//}
						
						search();
						
						break;
					}
				}
			}
		}
	}

	private void listCustomLists()
	{
		form.cmbCustomLists().clear();
		form.grdDetails().getRows().clear();

		updateMenuState();
		updateButtonState();
		//WDEV-18640
		CustomListVoCollection voColl = domain.listCustomLists((MemberOfStaffRefVo) domain.getMosUser(),true);
		if (voColl != null && voColl.size() > 0 )
		{
			for (int i = 0 ; i < voColl.size() ; i++)
				form.cmbCustomLists().newRow(voColl.get(i), voColl.get(i).getListName());
		}
	}

	private void initialise() 
	{
		form.getGlobalContext().Core.setCustomList(null); //WDEV-18640
		updateMenuState();
		updateButtonState();
		
		// WDEV-16083 Use display patid type, otherwise if not set, use NHS Number as was previous
		String patidColHeader="NHS Number";
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
		if(dispIdType != null)
			patidColHeader=dispIdType.getText();
		form.grdDetails().setColPatIdCaption(patidColHeader);

	}

	private void updateMenuState()
	{
		form.getContextMenus().Core.hideAllRCHTCustomListMenuMenuItems();
		form.getContextMenus().Core.getRCHTCustomListMenuSELECTItem().setVisible(form.grdDetails().getValue() != null);
		form.getContextMenus().Core.getRCHTCustomListMenuSELECTItem().setEnabled(form.grdDetails().getValue() != null);
		//WDEV-18640
		boolean isCurrentMosListOwner = form.cmbCustomLists().getValue() != null && form.cmbCustomLists().getValue().getListOwnerIsNotNull() && form.cmbCustomLists().getValue().getListOwner().equals((MemberOfStaffLiteVo)domain.getMosUser());
		boolean isListWithFullAccess = form.cmbCustomLists().getValue() != null && Boolean.TRUE.equals(form.cmbCustomLists().getValue().getIsFullAccess());
			
		form.getContextMenus().Core.getRCHTCustomListMenuREMOVEItem().setVisible(form.grdDetails().getValue() != null && (isCurrentMosListOwner || isListWithFullAccess));
		form.getContextMenus().Core.getRCHTCustomListMenuREMOVEItem().setEnabled(form.grdDetails().getValue() != null && (isCurrentMosListOwner || isListWithFullAccess));
	}

	private void updateButtonState()
	{		
		//WDEV-14238 
		if(!ConfigFlag.UI.CUSTOM_PATIENT_LIST_ACCESS_TYPE.getValue().equals("HCP")) 
			form.imbNewCustomList().setEnabled(true);
		//WDEV-18640
		form.imbRemoveList().setEnabled(form.cmbCustomLists().getValue() != null ? isCurrentMosUserCustomListOwner(form.cmbCustomLists().getValue()) : false);
		form.imbGrantAccess().setEnabled(form.cmbCustomLists().getValue() != null ? isCurrentMosUserCustomListOwner(form.cmbCustomLists().getValue()) : false);
	}
	//WDEV-18640
	private boolean isCurrentMosUserCustomListOwner(CustomListVo list)
	{
		Object user = domain.getMosUser();

		if (list != null && list.getListOwnerIsNotNull() && user != null)
		{
			return ((MemberOfStaffShortVo) user).getID_MemberOfStaff().equals(list.getListOwner().getID_MemberOfStaff());
		}
		return false;

	}
	private void search() 
	{
		form.grdDetails().getRows().clear();
		if (form.cmbCustomLists().getValue() != null)
		{
			PatientCustomListVo voPCL = domain.getPatientCustomList(form.cmbCustomLists().getValue());
			
			if (voPCL != null)
			{
				voPCL.getListEntry().sort();
				populateGrid(voPCL.getListEntry());
				
				CustomListSearchCriteriaVo voFilter = form.getGlobalContext().Core.getCustomListSearchCriteriaVo();
				
				if (voFilter != null && voFilter.getColumnSortOrder() != null)
				{
					setSortOrderForColumn(voFilter.getColumnSortOrder().getColumnId(), voFilter.getColumnSortOrder().getSortOrder());
				}
			}
		}
	}

	private void setSortOrderForColumn(Integer columnId, Integer sortOrderId)
	{
		SortOrder order;
		
		if (sortOrderId == 1) // 1 is ascending but for the form to work correct we need to reverse this
			order = SortOrder.DESCENDING;
		else
			order = SortOrder.ASCENDING;
		
		if (SURNAME_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderSurname(order);
			sortColumn(SURNAME_COLUMN_ID);
		}
		else if (FORENAME_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderForename(order);
			sortColumn(FORENAME_COLUMN_ID);
		}
		else if (IDENTIFIER_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderIdentifier(order);
			sortColumn(IDENTIFIER_COLUMN_ID);
		}
		else if (SEX_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderSex(order);
			sortColumn(SEX_COLUMN_ID);
		}
		else if (AGE_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderAge(order);
			sortColumn(AGE_COLUMN_ID);
		}
		else if (DOB_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderDOB(order);
			sortColumn(DOB_COLUMN_ID);
		}
		else if (ADDED_BY_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderAddedBy(order);
			sortColumn(ADDED_BY_COLUMN_ID);
		}
		else if (ADDED_DATE_TIME_COLUMN_ID == columnId)
		{
			form.getLocalContext().setSortOrderAddedDateTime(order);
			sortColumn(ADDED_DATE_TIME_COLUMN_ID);
		}
	}

	private void populateGrid(PatientCustomItemVoCollection listEntry) 
	{
	
		for ( int i = 0 ; listEntry != null && i < listEntry.size() ; i++)
		{
			addGridRow(listEntry.get(i));
		}
	}

	private void addGridRow(PatientCustomItemVo voItem)
	{
		grdDetailsRow row = form.grdDetails().getRows().newRow();
		
		PatientShort ps = voItem.getPatient();
		
		if ( (ps.getIsActiveIsNotNull() && ps.getIsActive()) 
				|| ps.getAssociatedPatientIsNotNull())
		{
			row.setColSurname(ps.getNameIsNotNull() ? ps.getName().getSurname() : ""); 		
			row.setColForename(ps.getNameIsNotNull() ? ps.getName().getForename() : ""); 		
			
			// WDEV-16083 - display PatientIdType for the DISPLAY_PATID_TYPE flag rather than hardcoding to NHS Number
			PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
			row.setColPatId(ps.getPatId(dispIdType) != null ? (ps.getPatId(dispIdType).getValueIsNotNull() ? ps.getPatId(dispIdType).getValue().toString() : "") : ""); 		
			row.setColSex(ps.getSexIsNotNull() ? ps.getSex().toString() : ""); 		
			row.setColAge(ps.getDobIsNotNull() ? ps.calculateAgeText() : ""); 		
			row.setColDOB(ps.getDobIsNotNull() ? ps.getDob().toString() : ""); 		
			row.setColAddedBy(voItem.getAddedByIsNotNull() ? voItem.getAddedBy().getName().toString() : ""); 		
			row.setColDateTime(voItem.getAddedDateTimeIsNotNull() ? voItem.getAddedDateTime().toString() : "");
			
			tickCol(row, voItem);
		
			if(voItem.getPatient().getAssociatedPatientIsNotNull())
				row.setBackColor(ConfigFlag.UI.MERGED_COLOUR.getValue());
				
			if (voItem.getPatient().getIsDead().booleanValue())
				row.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());			

			row.setValue(voItem);
		}
	}

	private void tickCol(grdDetailsRow row, PatientCustomItemVo voItem) 
	{
		if (form.getGlobalContext().Core.getCustomListSearchCriteriaVoIsNotNull())
		{
			CustomListSearchCriteriaVo voCurrent = form.getGlobalContext().Core.getCustomListSearchCriteriaVo();
			for (int i = 0; voCurrent != null && i < voCurrent.getViewedItems().length; i++)
			{
				if (voCurrent.getViewedItems()[i] != null && voCurrent.getViewedItems()[i].equals(voItem.getPatient().getID_Patient()))
				{
					row.setColViewed(form.getImages().Core.Tick);
					row.setTooltipForColViewed("Patient viewed");//WDEV-14694
				}
			}
		}
	}

	@Override
	protected void onGrdDetailsSelectionChanged()
	{
		updateMenuState();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
		case GenForm.ContextMenus.CoreNamespace.RCHTCustomListMenu.REMOVE:
			engine.showMessage("Are you sure you want to remove this patient from the list?", "Remove Patient", MessageButtons.YESNO, MessageIcon.QUESTION);
			form.getLocalContext().setLastMessageBox(1);
			break;
		case GenForm.ContextMenus.CoreNamespace.RCHTCustomListMenu.SELECT:
			selectPatient();
			break;
		}	
	}
	
	private void selectPatient() 
	{
		if(form.grdDetails().getSelectedRow() == null)
			return;
		
		if ( form.grdDetails().getSelectedRow().getValue() instanceof PatientCustomItemVo) 
		{
			form.getGlobalContext().Core.clearPatientShort();
		
			PatientShort ps = ((PatientCustomItemVo)form.grdDetails().getSelectedRow().getValue()).getPatient();
			form.getGlobalContext().Core.setPatientToBeDisplayed(ps);
			
			updateSearchCriteriaGC(ps.getID_Patient(), true);

			engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
		}
	}

	private void updateSearchCriteriaGC(Integer patient, boolean bAdd) 
	{
		if (form.getGlobalContext().Core.getCustomListSearchCriteriaVo() == null)
		{
			CustomListSearchCriteriaVo voNew = new CustomListSearchCriteriaVo();
			voNew.setCustomListRef(form.cmbCustomLists().getValue());
			
			Integer[] intValues = new Integer[1];
			intValues[0] = patient;
			voNew.setViewedItems(intValues);

			form.getGlobalContext().Core.setCustomListSearchCriteriaVo(voNew);
			return;
		}
		else
			form.getGlobalContext().Core.getCustomListSearchCriteriaVo().setCustomListRef(form.cmbCustomLists().getValue());
		
		CustomListSearchCriteriaVo voCurrent = form.getGlobalContext().Core.getCustomListSearchCriteriaVo();
		
		List<Integer> ids = new ArrayList<Integer>();
		boolean bAlreadyInlist = false;
		for (int i = 0; voCurrent != null && i < voCurrent.getViewedItems().length; i++)
		{
			if (voCurrent.getViewedItems().equals(patient)
				&& !bAdd)
				continue;
			else if ( ! voCurrent.getViewedItems().equals(patient))
				ids.add(voCurrent.getViewedItems()[i]);
			else if ( voCurrent.getViewedItems().equals(patient)
					&& bAdd)
				bAlreadyInlist = true;
		}
		if ( ! bAlreadyInlist && bAdd)
			ids.add(patient);
		
		if (ids.size() > 0)
		{
			Integer[] intValues = new Integer[ids.size()];
			ids.toArray(intValues);
			form.getGlobalContext().Core.getCustomListSearchCriteriaVo().setViewedItems(intValues);
		}
	}

	private void removePatient()
	{
		if (form.cmbCustomLists().getValue() != null
			&& form.grdDetails().getSelectedRow() != null)
		{
			PatientCustomListVo voWorkList = domain.getPatientCustomList(form.cmbCustomLists().getValue());
			voWorkList.getListEntry().remove(form.grdDetails().getSelectedRow().getValue());

			if (voWorkList.getListEntry().size() == 0)
			{
				voWorkList.setListEntry(null);
				try 
				{
					domain.deleteCustomList(voWorkList);
				} 
				catch (StaleObjectException e) 
				{
					engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				} 
				catch (ForeignKeyViolationException e) 
				{
					engine.showMessage(e.toString());
					return;
				}
				search();
				return;
			}

			updateSearchCriteriaGC(form.grdDetails().getSelectedRow().getValue().getPatient().getID_Patient(), false);

			String[] errors = voWorkList.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
				
			try 
			{
				domain.savePatientCustomList(voWorkList);
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				return;
			} 
		}
		search();
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (formName.equals(form.getForms().Core.NewCustomListDialog)
			&& result.equals(DialogResult.OK))
			saveNewCustomList();
		else if (formName.equals(form.getForms().Core.AddToCustomListDialog)
			&& result.equals(DialogResult.OK))
			onCmbCustomListsValueChanged();
		else if (formName.equals(form.getForms().Core.GrantCustomListAccess) //WDEV-18640
			&& result.equals(DialogResult.OK))
			updateCustomList(form.getGlobalContext().Core.getCustomList());
		updateMenuState(); //WDEV-18640
	}
	//WDEV-18640
	private void updateCustomList(CustomListVo customList)
	{
		if (customList == null)
			return;

		if (customList.validate() != null)
		{
			engine.showErrors(customList.validate());
			return;
		}

		try 
		{
			domain.saveCustomList(customList);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		} 
		search();
	}

	private void saveNewCustomList() 
	{
		CustomListVo voCL = new CustomListVo();
		
		voCL.setListType(CustomListType.CUSTOM_PATIENT_LIST);
		voCL.setListName(form.getGlobalContext().Core.getCustomListName());
		voCL.setDate(new Date());
		voCL.setIsActive(true);
		voCL.setListOwner((MemberOfStaffLiteVo) domain.getMosUser());
		
		String[] errors = voCL.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}
		
		try 
		{
			domain.saveCustomList(voCL);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		} 
		listCustomLists();
	}
	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException 
	{
		if(form.getLocalContext().getErrorMessageIsNotNull() && form.getLocalContext().getErrorMessage() == messageBoxId)
		{
			if(DialogResult.OK.equals(result))
				engine.close(DialogResult.ABORT);
		}
		
		if (result.equals(DialogResult.YES) 
			&& form.getLocalContext().getLastMessageBoxIsNotNull() 
			&& form.getLocalContext().getLastMessageBox().equals(2))
			removeCustomList();

		if (result.equals(DialogResult.YES) 
			&& form.getLocalContext().getLastMessageBoxIsNotNull() 
			&& form.getLocalContext().getLastMessageBox().equals(1))
			removePatient();

		updateMenuState();
		updateButtonState();
	}
	
	private void removeCustomList() 
	{
		CustomListVo voCL = form.cmbCustomLists().getValue();
			
		voCL.setIsActive(false);
			
		String[] errors = voCL.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}
			
		try 
		{
			domain.saveCustomList(voCL);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		}
		listCustomLists();
		
		updateButtonState();
	}

	@Override
	protected void onImbRemoveListClick() throws PresentationLogicException 
	{
		if(ConfigFlag.UI.CUSTOM_PATIENT_LIST_ACCESS_TYPE.getValue().equals("HCP"))//WDEV-14238 
		{
			if(domain.getHcpLiteUser()==null)//WDEV-9696 
			{			
				form.getLocalContext().setErrorMessage(engine.showMessage("Operation not allowed. User is not HCP.", "", MessageButtons.OK, MessageIcon.INFORMATION));
				return;
			}
		}
		engine.showMessage("Are you sure you want to inactivate the '" + form.cmbCustomLists().getValue().getListName() + "' Custom list ?", "Are you sure?", MessageButtons.YESNO, MessageIcon.QUESTION);;
		form.getLocalContext().setLastMessageBox(2);
		
		
	}

	@Override
	protected void onImbNewCustomListClick() throws PresentationLogicException 
	{
		if(ConfigFlag.UI.CUSTOM_PATIENT_LIST_ACCESS_TYPE.getValue().equals("HCP"))//WDEV-14238 
		{
			if(domain.getHcpLiteUser()==null) //WDEV-9696 
			{
				form.getLocalContext().setErrorMessage(engine.showMessage("Operation not allowed. User is not HCP.", "", MessageButtons.OK, MessageIcon.INFORMATION));
				return;
			}
		}
			engine.open(form.getForms().Core.NewCustomListDialog);
		}

	@Override
	protected void onCmbCustomListsValueChanged() throws PresentationLogicException 
	{
		//form.getGlobalContext().Core.setCustomListSearchCriteriaVo(null);
		updateSearchCriteriaGC(-1, true);
		search();
		updateMenuState();
		updateButtonState();
	}

	@Override
	protected void onGrdDetailsGridHeaderClicked(int column) throws PresentationLogicException 
	{
		sortColumn(column);
	}

	private void sortColumn(int column)
	{
		if (column == SURNAME_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderSurname() == null)
			{
				form.getLocalContext().setSortOrderSurname(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new SurnameComparator(form.getLocalContext().getSortOrderSurname()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderSurname()))
			{
				form.getLocalContext().setSortOrderSurname(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderSurname(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(SURNAME_COLUMN_ID, form.getLocalContext().getSortOrderSurname());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == FORENAME_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderForename() == null)
			{
				form.getLocalContext().setSortOrderForename(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new ForenameComparator(form.getLocalContext().getSortOrderForename()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderForename()))
			{
				form.getLocalContext().setSortOrderForename(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderForename(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(FORENAME_COLUMN_ID, form.getLocalContext().getSortOrderForename());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == IDENTIFIER_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderIdentifier() == null)
			{
				form.getLocalContext().setSortOrderIdentifier(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new IdentifierComparator(form.getLocalContext().getSortOrderIdentifier()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderIdentifier()))
			{
				form.getLocalContext().setSortOrderIdentifier(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderIdentifier(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(IDENTIFIER_COLUMN_ID, form.getLocalContext().getSortOrderIdentifier());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == SEX_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderSex() == null)
			{
				form.getLocalContext().setSortOrderSex(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new SexComparator(form.getLocalContext().getSortOrderSex()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderSex()))
			{
				form.getLocalContext().setSortOrderSex(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderSex(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(SEX_COLUMN_ID, form.getLocalContext().getSortOrderSex());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == AGE_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderAge() == null)
			{
				form.getLocalContext().setSortOrderAge(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new DOBComparator(form.getLocalContext().getSortOrderAge()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderAge()))
			{
				form.getLocalContext().setSortOrderAge(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderAge(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(AGE_COLUMN_ID, form.getLocalContext().getSortOrderAge());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == DOB_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderDOB() == null)
			{
				form.getLocalContext().setSortOrderDOB(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new DOBComparator(form.getLocalContext().getSortOrderDOB()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderDOB()))
			{
				form.getLocalContext().setSortOrderDOB(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderDOB(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(DOB_COLUMN_ID, form.getLocalContext().getSortOrderDOB());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == ADDED_BY_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderAddedBy() == null)
			{
				form.getLocalContext().setSortOrderAddedBy(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(new AddedByComparator(form.getLocalContext().getSortOrderAddedBy()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderAddedBy()))
			{
				form.getLocalContext().setSortOrderAddedBy(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderAddedBy(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(ADDED_BY_COLUMN_ID, form.getLocalContext().getSortOrderAddedBy());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
		else if (column == ADDED_DATE_TIME_COLUMN_ID)
		{
			if (form.getLocalContext().getSortOrderAddedDateTime() == null)
			{
				form.getLocalContext().setSortOrderAddedDateTime(SortOrder.ASCENDING);
			}

			PatientCustomItemVoCollection voColl = form.grdDetails().getValues();
			voColl.sort(PatientCustomItemVo.getDateTimeComparator(form.getLocalContext().getSortOrderAddedDateTime()));

			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderAddedDateTime()))
			{
				form.getLocalContext().setSortOrderAddedDateTime(SortOrder.DESCENDING);
			}
			else 
				form.getLocalContext().setSortOrderAddedDateTime(SortOrder.ASCENDING);

			addColumnSortToSearchCriteriaGC(ADDED_DATE_TIME_COLUMN_ID, form.getLocalContext().getSortOrderAddedDateTime());
			
			form.grdDetails().getRows().clear();
			populateGrid(voColl);
		}
	}

	private void addColumnSortToSearchCriteriaGC(int identifierColumnId, SortOrder sortOrder)
	{
		if (form.getGlobalContext().Core.getCustomListSearchCriteriaVo() == null)
			return;
		
		ColumnSortOrderVo columnSortOrder = new ColumnSortOrderVo();
		
		columnSortOrder.setColumnId(identifierColumnId);
		
		if (SortOrder.ASCENDING.equals(sortOrder))
			columnSortOrder.setSortOrder(1);
		else
			columnSortOrder.setSortOrder(-1);
		
		form.getGlobalContext().Core.getCustomListSearchCriteriaVo().setColumnSortOrder(columnSortOrder);
		
	}
	
	public class SurnameComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public SurnameComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public SurnameComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof PatientCustomItemVo )
			{
				PatientCustomItemVo ps1 = (PatientCustomItemVo)ob1;
				rez1 = (ps1.getPatient() != null && ps1.getPatient().getName() != null) ? ps1.getPatient().getName().getSurname():null;
			}
			if(ob2 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps2 = (PatientCustomItemVo)ob2;
				rez2 = (ps2.getPatient() != null && ps2.getPatient().getName() != null) ? ps2.getPatient().getName().getSurname():null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class ForenameComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public ForenameComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public ForenameComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof PatientCustomItemVo )
			{
				PatientCustomItemVo ps1 = (PatientCustomItemVo)ob1;
				rez1 = (ps1.getPatient() != null && ps1.getPatient().getName() != null) ? ps1.getPatient().getName().getForename():null;
			}
			if(ob2 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps2 = (PatientCustomItemVo)ob2;
				rez2 = (ps2.getPatient() != null && ps2.getPatient().getName() != null) ? ps2.getPatient().getName().getForename():null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class IdentifierComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public IdentifierComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public IdentifierComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
			
			if(ob1 instanceof PatientCustomItemVo )
			{
				PatientCustomItemVo ps1 = (PatientCustomItemVo)ob1;
				rez1 = (ps1.getPatient() != null && ps1.getPatient().getPatId(dispIdType) != null && ps1.getPatient().getPatId(dispIdType).getValue() != null) ? ps1.getPatient().getPatId(dispIdType).getValue().toString():null;
			}
			if(ob2 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps2 = (PatientCustomItemVo)ob2;
				rez2 = (ps2.getPatient() != null && ps2.getPatient().getPatId(dispIdType) != null && ps2.getPatient().getPatId(dispIdType).getValue() != null) ? ps2.getPatient().getPatId(dispIdType).getValue().toString():null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class SexComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public SexComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public SexComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof PatientCustomItemVo )
			{
				PatientCustomItemVo ps1 = (PatientCustomItemVo)ob1;
				rez1 = (ps1.getPatient() != null && ps1.getPatient().getSex() != null) ? ps1.getPatient().getSex().getText():null;
			}
			if(ob2 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps2 = (PatientCustomItemVo)ob2;
				rez2 = (ps2.getPatient() != null && ps2.getPatient().getSex() != null) ? ps2.getPatient().getSex().getText():null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class DOBComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public DOBComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public DOBComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			PartialDate rez1 = null;
			PartialDate rez2 = null;
			
			if(ob1 instanceof PatientCustomItemVo )
			{
				PatientCustomItemVo ps1 = (PatientCustomItemVo)ob1;
				rez1 = (ps1.getPatient() != null && ps1.getPatient().getDob() != null) ? ps1.getPatient().getDob():null;
			}
			if(ob2 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps2 = (PatientCustomItemVo)ob2;
				rez2 = (ps2.getPatient() != null && ps2.getPatient().getDob() != null) ? ps2.getPatient().getDob():null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareTo(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	
	public class AddedByComparator implements Comparator<Object>
	{
		private int direction = 1;
		
		public AddedByComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public AddedByComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			String rez1 = null;
			String rez2 = null;
			
			if(ob1 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps1 = (PatientCustomItemVo)ob1;
				rez1 = (ps1.getAddedBy() != null && ps1.getAddedBy().getName() != null) ? ps1.getAddedBy().getName().toString() : null;
			}
			if(ob2 instanceof PatientCustomItemVo)
			{
				PatientCustomItemVo ps2 = (PatientCustomItemVo)ob2;
				rez2 = (ps2.getAddedBy() != null && ps2.getAddedBy().getName() != null)? ps2.getAddedBy().getName().toString() : null;
			}
			
			if(rez1 != null && rez2 != null)
				return  rez1.compareToIgnoreCase(rez2)*direction;
			
			if(rez1 != null && rez2 == null)
				return  direction;
			
			if(rez2 != null && rez1 == null)
				return (-1)*direction;
			
			return 0;
		}
	}
	//WDEV-18640
	@Override
	protected void onImbGrantAccessClick() throws PresentationLogicException
	{
		form.getGlobalContext().Core.setCustomList(domain.getCustomList(form.cmbCustomLists().getValue()));
		engine.open(form.getForms().Core.GrantCustomListAccess);
		
	}
}
