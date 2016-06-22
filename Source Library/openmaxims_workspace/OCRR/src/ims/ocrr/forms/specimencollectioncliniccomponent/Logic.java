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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.ocrr.forms.specimencollectioncliniccomponent;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.PatientIdCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.PersonAddress;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridCellOptions;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.ocrr.forms.specimencollectioncliniccomponent.GenForm.GroupStatusEnumeration;
import ims.ocrr.helper.PhlebotomyHelper;
import ims.ocrr.vo.OrderSpecimenListVo;
import ims.ocrr.vo.SpecimenWorkListItemListVo;
import ims.ocrr.vo.SpecimenWorkListItemListVoCollection;
import ims.ocrr.vo.SpecimenWorkListItemVo;
import ims.ocrr.vo.lookups.OrderInvStatus;
import ims.ocrr.vo.lookups.SpecimenCollectionMethod;
import ims.ocrr.vo.lookups.SpecimenCollectionStatus;

import java.util.ArrayList;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final String	PATIENT_COL		= "-1";
	private static final String	ACTIONED_COL	= "-2";
	private static final String	COLLECTED_COL	= "-3";
	private static final String	DATE_COL		= "-5";
	private static final String	TIME_COL		= "-6";
	private static final String	QUERY_COL		= "-7";
	private static final String	TEXT_COL		= "-8";
	private static final String	INFO_COL		= "-9";
	private static final String	BTN_COL			= "-10";

	protected void onFormOpen() throws PresentationLogicException
	{
		setDynamicGridColumns();
	}

	public void initialize()
	{
		setDynamicGridColumns();
		if (form.getLocalContext().getCollectionStatusIsNotNull())
			form.GroupStatus().setValue(form.getLocalContext().getCollectionStatus());
		else
			form.GroupStatus().setValue(GroupStatusEnumeration.rdoForCollection);
		
		selectPatient();
		
		form.setMode(FormMode.VIEW);
	}

	protected void onGrdPatientListSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.clearAlerts();
		selectPatient();
	}

	private void selectPatient()
	{
		populatePatientDetails(form.getGlobalContext().Core.getPatientShort());
		populateCollectDataGrid(getStatus());
	}

	private boolean save(DynamicGridCell cell)
	{
		DynamicGridRow row = cell.getRow();
		// Actioned
		if (((Boolean) row.getCells().get(getColumn(ACTIONED_COL)).getValue()).booleanValue())
		{
			Object obj = row.getValue();
			if (obj instanceof SpecimenWorkListItemListVo)
			{
				SpecimenCollectionStatus answer = (SpecimenCollectionStatus) row.getCells().get(getColumn(COLLECTED_COL)).getValue();
				if (answer == null)
				{
					engine.showErrors(new String[]{"Please select Collected"});
					return false;
				}
				MemberOfStaffShortVo phlebotomist = null;
				DateTime dateTimeCollected 		= null;
				String commentCollected			= null;
				OrderSpecimenListVo specimen = ((SpecimenWorkListItemListVo)obj).getSpecimen();
				
				boolean isCollected = answer.equals(SpecimenCollectionStatus.COLLECTIONCOMPLETE);
				if (isCollected)
				{
					Date dateCollected = (Date) row.getCells().get(getColumn(DATE_COL)).getValue();
					Time timeCollected = (Time) row.getCells().get(getColumn(TIME_COL)).getValue();
					Object mosObj = row.getCells().get(getColumn(QUERY_COL)).getValue();
					phlebotomist = mosObj instanceof MemberOfStaffShortVo ? (MemberOfStaffShortVo) mosObj : null;
					commentCollected = (String) row.getCells().get(getColumn(TEXT_COL)).getValue();

					ArrayList errors = new ArrayList();
					if (dateCollected == null)
						errors.add("Date is mandatory");
					else
					{
						if(specimen.getSysInfoIsNotNull())
						{
							if(specimen.getSysInfo().getCreationDateTime() != null && specimen.getSysInfo().getCreationDateTime().getDate() != null)
							{
								if(dateCollected.isLessThan(specimen.getSysInfo().getCreationDateTime().getDate()))
								{
									engine.showMessage("The Collection Date cannot be before the Requested Date.");
									return false;
								}	
							}
						}
						if(dateCollected.isGreaterThan(new Date()))
						{
							engine.showMessage("The Collection Date cannot be in the future");
							return false;
						}
						if(dateCollected.isLessThan(new Date()))
						{
							engine.showMessage("The Collection Date cannot be before today.");
							return false;
						}
					}
					
					if (timeCollected == null)
						errors.add("Time is mandatory");
					else
					{
						if(specimen.getSysInfoIsNotNull())
						{
							if (dateCollected != null && specimen.getSysInfo().getCreationDateTime() != null && specimen.getSysInfo().getCreationDateTime().getDate() != null)
							{
								//only validate the time entered afgainst collection time if the collection date is the same as the requested date
								//because the time can be any time if it is on a different day
								if(dateCollected.equals(specimen.getSysInfo().getCreationDateTime().getDate()))
								{			
									if(specimen.getSysInfo().getCreationDateTime() != null && specimen.getSysInfo().getCreationDateTime().getTime() != null)
									{
										if(timeCollected.isLessThan(specimen.getSysInfo().getCreationDateTime().getTime()))
										{
											engine.showMessage("The Collection Time cannot be before the Requested Time.");
											return false;
										}		
									}
								}
								if(dateCollected.equals(new Date()))
								{
									if(timeCollected.isGreaterThan(new Time()))
									{
										engine.showMessage("The Collection Time cannot be in the future");
										return false;
									}
								}
							}
						}
					}
					
					
					if (phlebotomist == null)
						errors.add("Phlebotomist is mandatory");
					errors.trimToSize();

					if (errors.size() > 0)
					{
						String[] uiErrors = new String[errors.size()];
						errors.toArray(uiErrors);
						engine.showErrors(uiErrors);
						return false;
					}

					dateTimeCollected = new DateTime(dateCollected, timeCollected);
				}
				
				boolean isNotColleted = answer.equals(SpecimenCollectionStatus.COULDNOTCOLLECT);
				if(isNotColleted)
				{
					commentCollected = (String) row.getCells().get(getColumn(TEXT_COL)).getValue();
					if (commentCollected == null || commentCollected.length() == 0)
					{
						engine.showErrors(new String[]{"Comment is mandatory"});
						return false;
					}
				}

				SpecimenWorkListItemListVo voSpecimenWorkListItemList = (SpecimenWorkListItemListVo) obj;
				if (voSpecimenWorkListItemList != null)
				{
					if (isCollected)
					{
						voSpecimenWorkListItemList.getSpecimen().setCollDateTimePlacer(dateTimeCollected);
						voSpecimenWorkListItemList.getSpecimen().setCollectingMos(phlebotomist);
						voSpecimenWorkListItemList.getSpecimen().setIsAwaitingCollection(Boolean.FALSE);
						voSpecimenWorkListItemList.setCollectionStatus(SpecimenCollectionStatus.COLLECTIONCOMPLETE);
						
						String existingComment 	  = voSpecimenWorkListItemList.getSpecimen().getCollectorComment();
						String phlebotomistString = phlebotomist != null ? phlebotomist.getInitials() : null; 
						commentCollected = getPhlebotomistComment(existingComment, phlebotomistString, dateTimeCollected, commentCollected);

						if(getMaxLength(existingComment) < 0)
							commentCollected = existingComment;
					}
					else
					{
						voSpecimenWorkListItemList.setCollectionStatus(SpecimenCollectionStatus.COULDNOTCOLLECT);
						
						voSpecimenWorkListItemList.getSpecimen().setIsAwaitingCollection(Boolean.FALSE);
						
						String existingComment 	  = voSpecimenWorkListItemList.getSpecimen().getCollectorComment();
						commentCollected = getPhlebotomistComment(existingComment, engine.getLoggedInUser().getUserRealName(), new DateTime(), commentCollected);

						if(getMaxLength(existingComment) < 0)
							commentCollected = existingComment;
					}
					
					voSpecimenWorkListItemList.getSpecimen().setCollectorComment(getHelper().getCollectorCommentTrimmed(commentCollected));

					try
					{
						voSpecimenWorkListItemList = domain.saveWorkListItem(voSpecimenWorkListItemList);
					}
					catch (StaleObjectException e)
					{
						engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
						
					}
					populateCollectDataGrid(getStatus());
				}
			}
		}

		return true;

	}
	
	private String getPhlebotomistComment(String existingComment, String phlebotomistString, DateTime dateTimeCollected, String commentCollected)
	{
		return new PhlebotomyHelper().getPhlebotomistComment(existingComment, phlebotomistString, dateTimeCollected, commentCollected);
	}

	private void setDynamicGridColumns()
	{
		form.dyngrdCollect().getColumns().clear();
		DynamicGridColumn column = form.dyngrdCollect().getColumns().newColumn("Details", PATIENT_COL);
		column.setWidth(245);
		column.setCanGrow(true);

		column = form.dyngrdCollect().getColumns().newColumn("Info", INFO_COL);
		column.setWidth(40);
		
		column = form.dyngrdCollect().getColumns().newColumn("Actioned", ACTIONED_COL);
		column.setWidth(55);
		column.setAlignment(Alignment.CENTER);

		column = form.dyngrdCollect().getColumns().newColumn("Collected", COLLECTED_COL);
		column.setWidth(60);
		column.setAlignment(Alignment.CENTER);

		column = form.dyngrdCollect().getColumns().newColumn("Date", DATE_COL);
		column.setWidth(77);

		column = form.dyngrdCollect().getColumns().newColumn("Time", TIME_COL);
		column.setWidth(37);

		column = form.dyngrdCollect().getColumns().newColumn("Collector", QUERY_COL);
		column.setWidth(100);
		column.setAlignment(Alignment.RIGHT);

		column = form.dyngrdCollect().getColumns().newColumn("Collector's Comments", TEXT_COL);
		column.setWidth(135);
		
		column = form.dyngrdCollect().getColumns().newColumn("Save", BTN_COL);
		column.setAlignment(Alignment.CENTER);
		column.setWidth(-1);
	}

	private DynamicGridColumn getColumn(String identifier)
	{
		return form.dyngrdCollect().getColumns().getByIdentifier(identifier);
	}

	protected void onDyngrdCollectCellTextSubmited(DynamicGridCell cell)
	{
		if (cell.getColumn().equals(getColumn(QUERY_COL)))
		{
			cell.getItems().clear();
			String value = cell.getTypedText();
			PersonName name = new PersonName();
			MemberOfStaffShortVo filter = new MemberOfStaffShortVo();
			name.setSurname(value);
			filter.setIsActive(Boolean.TRUE);
			filter.setName(name);
			MemberOfStaffShortVoCollection voColl = domain.listMembersOfStaff(filter);
			for (int i = 0; i < voColl.size(); i++)
			{
				cell.getItems().newItem(voColl.get(i));
			}
			int cellItemSize = cell.getItems().size();
			if (cellItemSize > 0)
			{
				if (cellItemSize == 1)
					cell.setValue(cell.getItems().get(0));
				cell.showOpened();
			}
		}
	}

	protected void onDyngrdCollectCellValueChanged(DynamicGridCell cell)
	{
		processCellPostback(cell);
	}

	private void processCellPostback(DynamicGridCell cell)
	{
		DynamicGridColumn actionedCol = getColumn(ACTIONED_COL);
		if(actionedCol == null)
			return;
		boolean actioned = cell.getRow().getCells().get(actionedCol).getValue().equals(Boolean.TRUE);
		
		if (actioned)
		{
			disableActionedColumn(cell);//disable other cells
			
			DynamicGridCell collectedCell = cell.getRow().getCells().get(getColumn(COLLECTED_COL));
			// Create Collected Cell
			if (collectedCell == null)
			{
				collectedCell = cell.getRow().getCells().newCell(getColumn(COLLECTED_COL), DynamicCellType.ANSWER);
				setAnswersOptionsToCell(collectedCell);
				collectedCell.setAutoPostBack(true);
			}

			if (cell.getColumn().equals(getColumn(COLLECTED_COL)))
			{
				if (cell.getValue() != null)
				{
					if (cell.getValue().equals(SpecimenCollectionStatus.COLLECTIONCOMPLETE))
					{
						createControlsForCollection(cell.getRow());
					}
					if (cell.getValue().equals(SpecimenCollectionStatus.COULDNOTCOLLECT))
					{
						createControlsForNotCollection(cell.getRow());
					}
					createCommonControls(cell.getRow());
				}
				else
				{
					removeCellByColumn(cell.getRow(), COLLECTED_COL);
					clearAllCells(cell.getRow());
					clearActionedColumn(cell.getRow());
					enableActionedColumn();
				}
			}
		}
		else
		{
			removeCellByColumn(cell.getRow(), COLLECTED_COL);
			clearAllCells(cell.getRow());
			enableActionedColumn();
		}
	}

	private void clearActionedColumn(DynamicGridRow row)
	{
		DynamicGridCell cell;
		cell = row.getCells().get(getColumn(ACTIONED_COL));
		if (cell != null)
			cell.setValue(null);
	}

	private void disableActionedColumn(DynamicGridCell currentCell)
	{
		for (int i = 0; i < form.dyngrdCollect().getRows().size(); i++)
		{
			DynamicGridRow parentRow = form.dyngrdCollect().getRows().get(i);
			for (int j = 0; j < parentRow.getRows().size(); j++)
			{
				DynamicGridRow row = parentRow.getRows().get(j);
				
				DynamicGridCell cell = row.getCells().get(getColumn(ACTIONED_COL));
				if (cell != null && cell != currentCell)
					cell.setReadOnly(true);
			}
		}
	}
	private void enableActionedColumn()
	{
		for (int i = 0; i < form.dyngrdCollect().getRows().size(); i++)
		{
			DynamicGridRow parentRow = form.dyngrdCollect().getRows().get(i);
			for (int j = 0; j < parentRow.getRows().size(); j++)
			{
				DynamicGridRow row = parentRow.getRows().get(j);
				
				DynamicGridCell cell = row.getCells().get(getColumn(ACTIONED_COL));
				if (cell != null)
					cell.setReadOnly(false);
			}
		}
	}

	private void createControlsForNotCollection(DynamicGridRow row)
	{
		createControlsForNotCollection(row, null);
	}
	private void createControlsForNotCollection(DynamicGridRow row, SpecimenWorkListItemListVo item)
	{
		clearVariableCells(row);

		DynamicGridCell cell = row.getCells().newCell(getColumn(DATE_COL), DynamicCellType.LABEL, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
		cell = row.getCells().newCell(getColumn(TIME_COL), DynamicCellType.LABEL, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
		cell = row.getCells().newCell(getColumn(QUERY_COL), DynamicCellType.LABEL, DynamicGridCellOptions.LABEL_CELL);
		cell.setValue("Reason:");
		cell = row.getCells().newCell(getColumn(TEXT_COL), DynamicCellType.STRING, DynamicGridCellOptions.EDITABLE_DATA_CELL);
		setCellMaxLength(item, cell);
		if(item != null)
		{
			if(item.getSpecimenIsNotNull() && item.getSpecimen().getCollectorCommentIsNotNull())
			{	
				cell.setValue(item.getSpecimen().getCollectorComment());
				cell.setTooltip(item.getSpecimen().getCollectorComment());
			}
		}
	}

	private void createControlsForCollection(DynamicGridRow row)
	{
		clearVariableCells(row);
		DynamicGridCell cell = row.getCells().newCell(getColumn(DATE_COL), DynamicCellType.DATE, DynamicGridCellOptions.EDITABLE_DATA_CELL);
		setDefaultDateValue(cell);
		cell = row.getCells().newCell(getColumn(TIME_COL), DynamicCellType.TIME, DynamicGridCellOptions.EDITABLE_DATA_CELL);
		setDefaultTimeValue(cell);
		cell = row.getCells().newCell(getColumn(QUERY_COL), DynamicCellType.QUERYCOMBOBOX, DynamicGridCellOptions.EDITABLE_DATA_CELL);
		cell.setAutoPostBack(true);
		setDefaultMosValue(cell);
		cell = row.getCells().newCell(getColumn(TEXT_COL), DynamicCellType.STRING, DynamicGridCellOptions.EDITABLE_DATA_CELL);
		setCellMaxLength(((row.getValue() instanceof SpecimenWorkListItemListVo)?((SpecimenWorkListItemListVo)row.getValue()):null), cell);
	}
	
	private void createCommonControls(DynamicGridRow row)
	{
		if(row.getCells().get(getColumn(BTN_COL)) == null)
		{
			DynamicGridCell cell = row.getCells().newCell(getColumn(BTN_COL), DynamicCellType.IMAGEBUTTON, DynamicGridCellOptions.EDITABLE_DATA_CELL);
			cell.setValue(form.getImages().OCRR.SaveGrid);
			cell.setTooltip("Save");
		}
	}

	private void setDefaultDateValue(DynamicGridCell cell)
	{
		cell.setValue(new Date());
	}
	
	private void setDefaultTimeValue(DynamicGridCell cell)
	{
		DynamicGridRow parentRow = cell.getRow().getParent();
		//Get Previous row time and set it to the current row
		for (int i = 0; parentRow != null && i < parentRow.getRows().size(); i++)
		{
			if(i > 0 && parentRow.getRows().get(i).getValue().equals(cell.getRow().getValue()))
			{
				DynamicGridColumn column = getColumn(TIME_COL);
				if(column != null)
				{
					DynamicGridCell timCell = parentRow.getRows().get(i-1).getCells().get(column);
					if(timCell != null)
					{
						Object previousTime = timCell.getValue();
						if(previousTime instanceof Time)
							cell.setValue(previousTime);
					}
				}
				
				break;
			}
		}
		if (cell.getValue() == null)
			cell.setValue(new Time()); 

	}
	
	private void setDefaultMosValue(DynamicGridCell cell)
	{
		MemberOfStaffShortVo mos = (MemberOfStaffShortVo)domain.getMosUser();
		if (mos != null && mos.getNameIsNotNull())
		{
			cell.getItems().newItem(mos);
			cell.setValue(mos);
		}		
	}

	private void clearVariableCells(DynamicGridRow row)
	{
		removeCellByColumn(row, DATE_COL);
		removeCellByColumn(row, TIME_COL);
		removeCellByColumn(row, QUERY_COL);
		removeCellByColumn(row, TEXT_COL);
	}
	
	private void clearCommonCells(DynamicGridRow row)
	{
		removeCellByColumn(row, BTN_COL);
	}

	private void clearAllCells(DynamicGridRow row)
	{
		clearVariableCells(row);
		clearCommonCells(row);
	}

	private void removeCellByColumn(DynamicGridRow row, String colIdentifier)
	{
		DynamicGridCell cell;
		cell = row.getCells().get(getColumn(colIdentifier));
		if (cell != null)
			row.getCells().remove(cell);
	}

	private void setAnswersOptionsToCell(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		cell.getItems().newItem(SpecimenCollectionStatus.COLLECTIONCOMPLETE);
		cell.getItems().newItem(SpecimenCollectionStatus.COULDNOTCOLLECT);
	}
	
	private void populatePatientDetails(PatientShort voPatShort)
	{
		if (voPatShort == null)
			return;
		// Populates sex, age and dob
		form.cmbSex().setValue(voPatShort.getSexIsNotNull() ? voPatShort.getSex() : null);
		voPatShort.calculateAge();
		form.intAge().setValue(voPatShort.getAgeIsNotNull() ? voPatShort.getAge() : null);
		form.pdtDateOfBirth().setValue(voPatShort.getDobIsNotNull() ? voPatShort.getDob() : null);

		PersonName personName = voPatShort.getName();
		if (personName != null)
		{
			form.cmbTitle().setValue(personName.getTitle());
			form.txtSurname().setValue(personName.getSurname());
			form.txtForename().setValue(personName.getForename());
			form.txtMiddleName().setValue(personName.getMiddleName());
		}

		PersonAddress voPersonAddres = voPatShort.getAddress();
		if (voPersonAddres != null)
		{
			form.txtAddress().setValue(voPersonAddres.toDisplayStringForMultiLineTextBox());
			form.txtPostcode().setValue(voPatShort.getAddress().getPostCode());
		}

		PatientIdCollection voCollIdentifiers = voPatShort.getIdentifiers();
		form.grdIdentifiers().getRows().clear();
		for (int i = 0; i < voCollIdentifiers.size(); i++)
		{
			ims.ocrr.forms.specimencollectioncliniccomponent.GenForm.grdIdentifiersRow row = form.grdIdentifiers().getRows().newRow();
			row.setcolType(voCollIdentifiers.get(i).getTypeIsNotNull() ? voCollIdentifiers.get(i).getType().toString() : "");
			row.setcolValue(voCollIdentifiers.get(i).getValue());
		}
	}

	private void populateCollectDataGrid(SpecimenCollectionStatus status)
	{
		SpecimenWorkListItemListVoCollection voColl = domain.listWorkListItems(form.getGlobalContext().Core.getCurrentCareContext(), SpecimenCollectionMethod.OUTPATIENT, status);
		form.dyngrdCollect().getRows().clear();

		for (int i = 0; i < voColl.size(); i++)
		{
			SpecimenWorkListItemListVo item = voColl.get(i);
			if(item.getSpecimen() == null)
				continue;

			DynamicGridRow patientRow = form.dyngrdCollect().getRows().newRow();
			patientRow.setExpanded(true);
			patientRow.setSelectable(false);
			patientRow.setBold(true);

			DynamicGridCell patientCell = patientRow.getCells().newCell(getColumn(PATIENT_COL), DynamicCellType.STRING);
			String headerTitle = getHeaderTitle(item);
			patientCell.setValue(headerTitle);
			patientCell.setTooltip(headerTitle + (item.getSpecimen() != null ? item.getSpecimen().getOCSNumber() : "")); 
			patientCell.setReadOnly(true);

			StringBuffer lastDisciplineCaption = new StringBuffer();
			String disciplineName = item.getSpecimen().getDisciplineIsNotNull()?item.getSpecimen().getDiscipline().getServiceName():null;
			if(disciplineName == null)
				disciplineName = "(No discipline)";
			lastDisciplineCaption.append(disciplineName);
			lastDisciplineCaption.append(" - ");

			for (int j = 0; item.getSpecimen().getInvestigationsIsNotNull() && j < item.getSpecimen().getInvestigations().size(); j++)
			{
				String investigationName = "(No investigation)";
				if(item.getSpecimen().getInvestigations().get(j).getInvestigationIsNotNull() && item.getSpecimen().getInvestigations().get(j).getInvestigation().getInvestigationIndexIsNotNull() && item.getSpecimen().getInvestigations().get(j).getInvestigation().getInvestigationIndex().getName() != null)
				{
					if(item.getSpecimen().getInvestigations().get(j).getOrdInvCurrentStatusIsNotNull() && item.getSpecimen().getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatusIsNotNull() && (!item.getSpecimen().getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatus().equals(OrderInvStatus.CANCEL_REQUEST) && !item.getSpecimen().getInvestigations().get(j).getOrdInvCurrentStatus().getOrdInvStatus().equals(OrderInvStatus.CANCELLED)))
						investigationName = item.getSpecimen().getInvestigations().get(j).getInvestigation().getInvestigationIndex().getName();
					else
						investigationName = "";
				}
					
				lastDisciplineCaption.append(investigationName);
				lastDisciplineCaption.append("; ");
			}
			
			for (int j = 0; item.getSpecimen().getContainersIsNotNull() && j < item.getSpecimen().getContainers().size(); j++)
			{
				String specimen = "(No specimen)";
				if(item.getSpecimen().getContainers().get(j).getContainerIsNotNull())
					specimen = item.getSpecimen().getContainers().get(j).getContainer().getName();
				lastDisciplineCaption.append(specimen);
				lastDisciplineCaption.append("(Qty: ");
				lastDisciplineCaption.append(item.getSpecimen().getContainers().get(j).getContainerQuantity());
				lastDisciplineCaption.append("); ");
			}
			
			DynamicGridRow disciplineRow = patientRow.getRows().newRow();
			disciplineRow.setSelectable(false);
			disciplineRow.setCollapsedImage(form.getImages().OCRR.TestTube);
			disciplineRow.setExpandedImage(form.getImages().OCRR.TestTube);
			disciplineRow.setValue(item);
			
			boolean isForCollected = item.getCollectionStatusIsNotNull() && item.getCollectionStatus().equals(SpecimenCollectionStatus.FORCOLLECTION);
			if(isForCollected == false)
			{
				displayCommonCells(item, disciplineRow);
			}
			else
			{
				DynamicGridCell actionedCell = disciplineRow.getCells().newCell(getColumn(ACTIONED_COL), DynamicCellType.BOOL);
				actionedCell.setAutoPostBack(true);
				
				//Create Comment cell if any comment
				String comment = item.getSpecimenIsNotNull()?item.getSpecimen().getCollectorComment():null;
				if(comment != null && comment.length() > 0)
				{
					DynamicGridCell cellText = disciplineRow.getCells().get(getColumn(TEXT_COL));
					if(cellText != null)
						disciplineRow.getCells().remove(cellText);
					cellText = disciplineRow.getCells().newCell(getColumn(TEXT_COL), DynamicCellType.STRING);
					cellText.setValue(comment);
					cellText.setTooltip(comment);
					cellText.setReadOnly(true);
					setCellMaxLength(item, cellText);
				}
			}
			
			//Info cell
			DynamicGridCell infoCell = disciplineRow.getCells().newCell(getColumn(INFO_COL), DynamicCellType.IMAGE, DynamicGridCellOptions.EDITABLE_DATA_CELL);
			if(item.getSpecimen().getInstructionsToCollectorIsNotNull() && disciplineRow != null)
			{
				infoCell.setValue(form.getImages().Core.Information);
				infoCell.setTooltip(PhlebotomyHelper.getInstructorToCollectorTooltip(item.getSpecimen().getInstructionsToCollector()));
			}
			
			String discipline = lastDisciplineCaption.toString();
			DynamicGridCell specimenCell = disciplineRow.getCells().newCell(getColumn(PATIENT_COL), DynamicCellType.STRING);
			specimenCell.setReadOnly(true);
			specimenCell.setValue(discipline);
			specimenCell.setTooltip(discipline);
		}
	}

	/**
	 * @param item
	 * @param disciplineRow
	 */
	private void displayCommonCells(SpecimenWorkListItemListVo item, DynamicGridRow disciplineRow)
	{
		if(item == null || disciplineRow == null)
			return;
		
		removeCellByColumn(disciplineRow, COLLECTED_COL);
		DynamicGridCell collectedCell = disciplineRow.getCells().newCell(getColumn(COLLECTED_COL), DynamicCellType.IMAGE, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
		if(item.getCollectionStatusIsNotNull())
		{
			collectedCell.setValue(item.getCollectionStatus().getImage());
			collectedCell.setTooltip(item.getCollectionStatus().toString());
		}
		
		Date date = null;
		Time time = null;
		if(item.getSpecimenIsNotNull() && item.getSpecimen().getCollDateTimePlacerIsNotNull())
		{
			date = item.getSpecimen().getCollDateTimePlacer().getDate();
			time = item.getSpecimen().getCollDateTimePlacer().getTime();
		}
		
		if(item.getCollectionStatusIsNotNull() && (item.getCollectionStatus().equals(SpecimenCollectionStatus.CANCELLED) ||item.getCollectionStatus().equals(SpecimenCollectionStatus.COULDNOTCOLLECT)))
		{
			createControlsForNotCollection(disciplineRow, item);
		}
		else
		{
			removeCellByColumn(disciplineRow, DATE_COL);
			DynamicGridCell dateCell = disciplineRow.getCells().newCell(getColumn(DATE_COL), DynamicCellType.STRING, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
			dateCell.setValue(date != null?date.toString():"");
			dateCell.setReadOnly(true);
			
			removeCellByColumn(disciplineRow, TIME_COL);
			DynamicGridCell timeCell = disciplineRow.getCells().newCell(getColumn(TIME_COL), DynamicCellType.STRING, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
			timeCell.setValue(time != null?time.toString():"");
			timeCell.setReadOnly(true);
			
			removeCellByColumn(disciplineRow, QUERY_COL);
			DynamicGridCell cellQuery = disciplineRow.getCells().newCell(getColumn(QUERY_COL), DynamicCellType.STRING, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
			cellQuery.setValue(item.getSpecimen().getCollectingMosIsNotNull() && item.getSpecimen().getCollectingMos().getNameIsNotNull()?item.getSpecimen().getCollectingMos().getName().toString():"");
			cellQuery.setReadOnly(true);
			
			removeCellByColumn(disciplineRow, TEXT_COL);
			DynamicGridCell cellText = disciplineRow.getCells().newCell(getColumn(TEXT_COL), DynamicCellType.STRING, DynamicGridCellOptions.READ_ONLY_DATA_CELL);
			cellText.setValue(item.getSpecimen().getCollectorComment());
			cellText.setTooltip(item.getSpecimen().getCollectorComment());
			cellText.setReadOnly(true);
			setCellMaxLength(item, cellText);
		}
		
		disciplineRow.setReadOnly(true);
		disciplineRow.setBackColor(Color.LightGray);
	}

	private String getHeaderTitle(SpecimenWorkListItemListVo item)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Date Required: ");
		sb.append(item.getDateToCollectIsNotNull() ? item.getDateToCollect().toString() : "");
		sb.append(" Responsible Clinician: ");
		if(item.getSpecimenIsNotNull() && 
		   item.getSpecimen().getOrderIsNotNull() && 
		   item.getSpecimen().getOrder().getResponsibleClinicianIsNotNull() &&
		   item.getSpecimen().getOrder().getResponsibleClinician().getMosIsNotNull() &&
		   item.getSpecimen().getOrder().getResponsibleClinician().getMos().getName() != null)
		sb.append(item.getSpecimen().getOrder().getResponsibleClinician().getMos().getName().toString());
		return sb.toString();
	}

	protected void onDyngrdCollectCellButtonClicked(DynamicGridCell cell)
	{
		if(cell.getColumn().equals(getColumn(BTN_COL)))
			save(cell);
	}

	protected void onBtnPrintClick() throws PresentationLogicException
	{
		if(form.dyngrdCollect().getRows().size() == 0)
		{
			engine.showMessage("There is no data to print !");
			return;
		}
		
		form.getLocalContext().setContextDummyForReports(null);
		
		for (int i = 0; i < form.dyngrdCollect().getRows().size(); i++)
		{
			DynamicGridRow parentRow = form.dyngrdCollect().getRows().get(i);
			
			for (int j = 0; j < parentRow.getRows().size(); j++)
			{
				DynamicGridRow row = parentRow.getRows().get(j);
				
				DynamicGridCell cell = row.getCells().get(getColumn(ACTIONED_COL));
				
				boolean isActioned = false;
				
				if(cell != null && cell.getValue() instanceof Boolean)
					isActioned = ((Boolean)cell.getValue()).booleanValue();
				
				if(isActioned && form.getLocalContext().getContextDummyForReports() == null)
				{
					SpecimenWorkListItemVo specimenWorkListItemVo = new SpecimenWorkListItemVo();
					specimenWorkListItemVo.setID_SpecimenWorkListItem(new Integer(-1));
					form.getLocalContext().setContextDummyForReports(specimenWorkListItemVo);
					form.getGlobalContext().RefMan.setSpecimenWorkListItemForReports(specimenWorkListItemVo);
				}
			}
		}
		
		if(form.getLocalContext().getContextDummyForReports() == null)
		{
			engine.showMessage("There is no actioned records to print !");
			return;
		}
		
		form.getGlobalContext().Core.setPrepareForPrinting(Boolean.TRUE);
		engine.open(form.getForms().Core.PrintReport);
	}

	protected void onRadioButtonGroupStatusValueChanged() throws PresentationLogicException
	{
		populateCollectDataGrid(getStatus());
	}
	
	private SpecimenCollectionStatus getStatus()
	{
		ims.ocrr.forms.specimencollectioncliniccomponent.GenForm.GroupStatusEnumeration status = form.GroupStatus().getValue();
		form.getLocalContext().setCollectionStatus(status);
		if(status.equals(GroupStatusEnumeration.rdoForCollection))
		{
			return SpecimenCollectionStatus.FORCOLLECTION;
		}
		if(status.equals(GroupStatusEnumeration.rdoCollected))
		{
			return SpecimenCollectionStatus.COLLECTIONCOMPLETE;
		}
		if(status.equals(GroupStatusEnumeration.rdoCancelled))
		{
			return SpecimenCollectionStatus.COULDNOTCOLLECT;
		}

		return null;
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if(formName.equals(form.getForms().Core.PrintReport) && result.equals(DialogResult.OK))
			printActionedRecords();
	}

	private void printActionedRecords()
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		for (int i = 0; i < form.dyngrdCollect().getRows().size(); i++)
		{
			DynamicGridRow parentRow = form.dyngrdCollect().getRows().get(i);
			
			for (int j = 0; j < parentRow.getRows().size(); j++)
			{
				DynamicGridRow row = parentRow.getRows().get(j);
				
				DynamicGridCell cell = row.getCells().get(getColumn(ACTIONED_COL));
				
				boolean isActioned = false;
				
				if(cell != null && cell.getValue() instanceof Boolean)
					isActioned = ((Boolean)cell.getValue()).booleanValue();

				SpecimenWorkListItemListVo item = (SpecimenWorkListItemListVo) row.getValue();
				
				if(isActioned && item != null)
				{
					QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
					
					client.addSeed(new SeedValue("SpecimenWorkListItem_id", item.getID_SpecimenWorkListItem(), Integer.class));
					
					try
					{
						client.printReport(form.getGlobalContext().Core.getReport(), form.getGlobalContext().Core.getTemplate(), urlReportServer, form.getGlobalContext().Core.getPrinterSelect(), 1);
					} 
					catch (QueryBuilderClientException e1)
					{
						engine.showMessage("Error creating report: " + e1.getMessage());
						return;
					}
				}
			}
		}
	}
	
	//calculate dynamically the max length of the comment based on what you can expect when saving the colector comment.
	private int getMaxLength(String collectoComment)
	{
		return getHelper().getMaxLength(collectoComment);
	}
	
	private void setCellMaxLength(SpecimenWorkListItemListVo item, DynamicGridCell cellText)
	{
		String collectorComment = item != null ? item.getSpecimen().getCollectorComment() : "";
		getHelper().setCellMaxLength(collectorComment, cellText);
	}
	
	private PhlebotomyHelper getHelper()
	{
		return new PhlebotomyHelper(engine.getLoggedInUser().getUserRealName());
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
	}
}
