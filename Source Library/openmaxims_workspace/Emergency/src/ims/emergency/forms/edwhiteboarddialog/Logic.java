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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 4876.20447)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.edwhiteboarddialog;



import ims.admin.vo.AppImageVo;
import ims.configuration.EnvironmentConfig;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AppDBImageVo;
import ims.core.vo.PatientId;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.Sex;
import ims.emergency.vo.PatientForTriageVo;
import ims.emergency.vo.TrackingAreaShortVo;
import ims.emergency.vo.TrackingAreaShortVoCollection;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVo;
import ims.emergency.vo.TrackingForClinicianWorklistAndTriageVoCollection;
import ims.emergency.vo.WhiteBoardEditVo;
import ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues;
import ims.emergency.vo.lookups.AttendanceClinicalNoteType;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridCellTable;
import ims.framework.controls.DynamicGridCellTable.TableCell;
import ims.framework.controls.DynamicGridCellTable.TableCellOptions;
import ims.framework.controls.DynamicGridCellTable.TableCellType;
import ims.framework.controls.DynamicGridCellTable.TableRow;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Align;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FontFamily;
import ims.framework.enumerations.FontWeight;
import ims.framework.enumerations.VerticalAlignment;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Base64;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final String	COLUMN_PATIENT			= "0";
	private static final String	COLUMN_LOCATION			= "1";
	private static final String	COLUMN_PAIN_ASSESSMENT	= "2";
	private static final String	COLUMN_WATERLOW			= "3";
	private static final String	COLUMN_FALLS			= "4";
	private static final String	COLUMN_ISAR			= "5";
	private static final String	COLUMN_REFERRAL			= "6";
	private static final String	COLUMN_OBS_REQUIRED		= "7";
	private static final String	COLUMN_MEDS_GIVEN		= "8";
	private static final String	COLUMN_ECG				= "9";
	private static final String	COLUMN_NPO				= "10";
	private static final String	COLUMN_ISOLATION		= "11";
	private static final String	COLUMN_COMMENT			= "12";
	
	private static final int REQUIRED = 1;
	private static final int COMPLETE = 2;
	private static final int NOT_REQUIRED = 3;
	
	
	private static final int DISPLAY_CLINICIANASSESSMNRWORKLIST	 = 0;
	private static final int DISPLAY_TRIAGE_FROM_TRACKING		 = 1;		
	
	protected void onFormModeChanged()
	{
		// TODO Add your code here.
	}
	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
		doSearch();
		updateControlsState();
	}

	private void updateControlsState()
	{
		Object selectedRow = form.dyngrdWhiteBoard().getValue();
		form.btnAssessmentDetails().setEnabled(selectedRow!=null);
		form.btnAllocatedCubicle().setEnabled(selectedRow!=null);
		form.btnSeenCompleteHCP().setEnabled(selectedRow!=null);
		form.btnResult().setEnabled(selectedRow!=null);
		form.btnPatStatus().setEnabled(selectedRow!=null);
		form.btnMove().setEnabled(selectedRow!=null);
	}

	private void open()
	{
		// TODO Auto-generated method stub
		
	}

	private void initialize()
	{
		populateAreasCombo();
		initializeDynamicGrid();
		initializeButtons();
	}

	private void initializeButtons() 
	{
		
		form.btnMove().setImage(form.getImages().Emergency.MOVE16);						
		form.btnResult().setImage(form.getImages().Emergency.RESULTS16);			
		form.btnPatStatus().setImage(form.getImages().Emergency.PATIENTSTATUS16);		
		form.btnSeenCompleteHCP().setImage(form.getImages().Emergency.SEENCOMPLETE16);	
		form.btnAllocatedCubicle().setImage(form.getImages().Emergency.ALLOCATECUBICLE16);	
		form.btnAssessmentDetails().setImage(form.getImages().Emergency.ASSESSMNTDETAILS16);
		form.btnClose().setImage(form.getImages().Core.Remove);
		
	}
	
	private void populateAreasCombo()
	{
		form.cmbArea().clear();
		TrackingAreaShortVoCollection tempVoColl = domain.listTrackingAreas(engine.getCurrentLocation());
		TrackingAreaShortVo overral = null; 
		if( tempVoColl != null && tempVoColl.size() > 0 )
		{
						
			for( int i = 0; i < tempVoColl.size();i++ )
			{
				TrackingAreaShortVo  tempTrVo = tempVoColl.get(i);
				if( tempTrVo != null && tempTrVo.getIsOverallViewIsNotNull() && Boolean.TRUE.equals(tempTrVo.getIsOverallView()))
					overral = tempTrVo;
				form.cmbArea().newRow(tempTrVo,tempTrVo.getAreaDisplayName());
			}
			if( overral != null)
				form.cmbArea().setValue(overral);
		}
	}
	
	private void initializeDynamicGrid()
	{
		form.dyngrdWhiteBoard().clear();
		form.dyngrdWhiteBoard().setHeaderHeight(40);
		

		DynamicGridColumn column = form.dyngrdWhiteBoard().getColumns().newColumn("Name",COLUMN_PATIENT);
		column.setWidth(300);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.TOP);
		column.setHeaderAlignment(Alignment.LEFT);
		column.setReadOnly(true);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("Location",COLUMN_LOCATION);
		column.setWidth(160);
		column.setAlignment(Alignment.LEFT);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
			
		column = form.dyngrdWhiteBoard().getColumns().newColumn("",COLUMN_PAIN_ASSESSMENT);
		column.setWidth(30);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setCaptionImage(form.getImages().Assessment.Assessment24);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("",COLUMN_WATERLOW);
		column.setWidth(30);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setCaptionImage(form.getImages().Nursing.WaterlowView24);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("",COLUMN_FALLS);
		column.setWidth(30);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setCaptionImage(form.getImages().Nursing.FallAssessment24);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("",COLUMN_ISAR);
		column.setWidth(30);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setCaptionImage(form.getImages().Emergency.Risk24);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("Referral",COLUMN_REFERRAL);
		column.setWidth(110);
		column.setAlignment(Alignment.LEFT);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("Obs Required",COLUMN_OBS_REQUIRED);
		column.setWidth(100);
		column.setAlignment(Alignment.RIGHT);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("Meds Given",COLUMN_MEDS_GIVEN);
		column.setWidth(100);
		column.setAlignment(Alignment.RIGHT);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("ECG",COLUMN_ECG);
		column.setWidth(35);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("NPO",COLUMN_NPO);
		column.setWidth(35);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("Isolation",COLUMN_ISOLATION);
		column.setWidth(65);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.MIDDLE);
		column.setHeaderAlignment(Alignment.LEFT);
		
		column = form.dyngrdWhiteBoard().getColumns().newColumn("Comment",COLUMN_COMMENT);
		column.setWidth(-1);
		column.setAlignment(Alignment.CENTER);
		column.setVerticalAlignment(VerticalAlignment.TOP);
		column.setHeaderAlignment(Alignment.LEFT);
		
	}

	protected void onCmbStatusValueChanged() throws PresentationLogicException
	{
		doSearch();
	}

	protected void onCmbAreaValueChanged() throws PresentationLogicException
	{
		doSearch();
	}
	
	private void doSearch()
	{
		TrackingForClinicianWorklistAndTriageVoCollection trackingPatiens = domain.listTrackingPatients(form.cmbArea().getValue(),form.cmbStatus().getValue() , null);
		
		populateDynGrid(trackingPatiens);
	}

	private void populateDynGrid(TrackingForClinicianWorklistAndTriageVoCollection trackingPatiens)
	{
		deletePatientImages();
		form.dyngrdWhiteBoard().getRows().clear();
		
		if( trackingPatiens == null || trackingPatiens.size() < 1)
			return;
		
		//trackingPatiens.sort(new TrackingComparator());
		for(int i = 0; i < trackingPatiens.size();i++)
		{
			ILocation currentLocation = engine.getCurrentLocation();
			TrackingForClinicianWorklistAndTriageVo tempVo = trackingPatiens.get(i);
			if( tempVo != null)
			{
				addRowToDyngrd(tempVo, currentLocation);
				
			}
			
		}
	}

	private void deletePatientImages() 
	{
		List<String> importedFiles = form.getLocalContext().getPatientImagesList();
		
		if (importedFiles != null && importedFiles.size() > 0)
		{
			for (Iterator<String> iterator = importedFiles.iterator(); iterator.hasNext();) 
			{
				String file = ((String) iterator.next()).replace("/", "\\");
				File f = new File(file);
				f.delete();											
			}
		}
	}
	
	private void addRowToDyngrd(TrackingForClinicianWorklistAndTriageVo tempVo, ILocation currentLocation)
	{
		if(	tempVo == null)
			return;
			
		DynamicGridRow row = form.dyngrdWhiteBoard().getRows().newRow();
		row.setValue(tempVo);
		
		addPatientCell(tempVo,row);
		
		DynamicGridCell cellLoc = row.getCells().newCell(getColumn(COLUMN_LOCATION), DynamicCellType.STRING);
		cellLoc.setValue(currentLocation != null ? currentLocation.getName() : "");
		cellLoc.setTooltip(currentLocation != null ? currentLocation.getName() : "");
		cellLoc.setReadOnly(true);
		
		DynamicGridCell cellPain = row.getCells().newCell(getColumn(COLUMN_PAIN_ASSESSMENT), DynamicCellType.INT);
		cellPain.setValue(3);
		cellPain.setTooltip("Pain");
		cellPain.setReadOnly(true);
		
		DynamicGridCell cellWaterlow = row.getCells().newCell(getColumn(COLUMN_WATERLOW), DynamicCellType.INT);
		cellWaterlow.setValue(1);
		cellWaterlow.setTooltip("Waterlow");
		cellWaterlow.setReadOnly(true);
		
		DynamicGridCell cellFalls = row.getCells().newCell(getColumn(COLUMN_FALLS), DynamicCellType.INT);
		cellFalls.setValue(2);
		cellFalls.setTooltip("Falls");
		cellFalls.setReadOnly(true);
		
		DynamicGridCell cellISAR = row.getCells().newCell(getColumn(COLUMN_ISAR), DynamicCellType.INT);
		cellISAR.setValue(3);
		cellISAR.setTooltip("ISAR");
		cellISAR.setReadOnly(true);
		
		DynamicGridCell cellReferral = row.getCells().newCell(getColumn(COLUMN_REFERRAL), DynamicCellType.STRING);
		cellReferral.setValue(tempVo.getCurrentReferral() != null && tempVo.getCurrentReferral().getSpecialty() != null ? tempVo.getCurrentReferral().getSpecialty().getText() : "");
		cellReferral.setTooltip((String) cellReferral.getValue());
		cellReferral.setReadOnly(true);
		
		DynamicGridCell cellObs = row.getCells().newCell(getColumn(COLUMN_OBS_REQUIRED), DynamicCellType.ENUMERATION);
		populateCellCombo(cellObs);
		
		DynamicGridCell cellMeds = row.getCells().newCell(getColumn(COLUMN_MEDS_GIVEN), DynamicCellType.ENUMERATION);
		populateCellCombo(cellMeds);
		
		DynamicGridCell cellECG = row.getCells().newCell(getColumn(COLUMN_ECG), DynamicCellType.BOOL);
		cellECG.setValue(null);
		cellECG.setAutoPostBack(true);
		cellECG.setReadOnly(false);
		
		DynamicGridCell cellNPO = row.getCells().newCell(getColumn(COLUMN_NPO), DynamicCellType.BOOL);
		cellNPO.setValue(null);
		cellNPO.setAutoPostBack(true);
		cellNPO.setReadOnly(false);
		
		DynamicGridCell cellIsolation = row.getCells().newCell(getColumn(COLUMN_ISOLATION), DynamicCellType.BOOL);
		cellIsolation.setValue(null);
		cellIsolation.setAutoPostBack(true);
		cellIsolation.setReadOnly(false);
		
		DynamicGridCell cellComment = row.getCells().newCell(getColumn(COLUMN_COMMENT), DynamicCellType.IMAGEBUTTON);
		/*
		cellComment.setValue(form.getImages().Core.Memo);
		cellComment.setAutoPostBack(true);
		cellComment.setReadOnly(false);
		*/
		//Add Comment Button Cell
		cellComment = row.getCells().newCell(getColumn(COLUMN_COMMENT), DynamicCellType.TABLE);
		DynamicGridCellTable helper = new DynamicGridCellTable(cellComment);		
		TableRow tableRow = helper.getRows().newRow();
		TableCell tableCell = tableRow.getCells().newCell();
		  		  tableCell.setType(TableCellType.BUTTON);		
					
		TableCellOptions cellOptions = new TableCellOptions();
						 cellOptions.setAutopostback(true);
						 cellOptions.setButtonImage(form.getImages().Core.Memo);
						 cellOptions.setButtonImageText(" Comment");
						 cellOptions.setButtonHeight(72);
						 cellOptions.setButtonWidth(80);
	
		tableCell.setOptions(cellOptions);
		//tableCell.setIdentifier(SelectedTriageWorklistButtons.PATIENTSUMMARY);
		cellComment.setValue(helper);
		
	}

	private void populateCellCombo(DynamicGridCell cellMeds)
	{
		cellMeds.getItems().newItem(ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.REQUIRED,ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.REQUIRED.getText(),ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.REQUIRED.getImage());
		cellMeds.getItems().newItem(ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.COMPLETE,ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.COMPLETE.getText(),ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.COMPLETE.getImage());
		cellMeds.getItems().newItem(ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.NOT_REQUIRED,ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.NOT_REQUIRED.getText(),ims.emergency.vo.enums.EDWhiteBoardDynGrdComboValues.NOT_REQUIRED.getImage());
		
		/*
		cellMeds.getItems().newItem("Required","Required", form.getImages().Core.CriticalError);
		cellMeds.getItems().newItem("Completed","Completed", form.getImages().Correspondence.PatientDocumentCreated16);
		cellMeds.getItems().newItem("Not Required","Not Required", form.getImages().Correspondence.NoLetterRequired);
		*/
		cellMeds.setAutoPostBack(true);
		cellMeds.setReadOnly(false);
	}
	
	private void addPatientCell(TrackingForClinicianWorklistAndTriageVo tracking, DynamicGridRow row)
	{
		if(tracking == null)
			return ;
		
		AppImageVo patientImage = null;
		
		try 
		{
			patientImage = getPatientImage(tracking);
			
			if(tracking != null && tracking.getPatient() != null && tracking.getPatient().getPhoto() != null)
			{
				addPatientToLocalCollection(patientImage);
			}
		}
		catch (IOException e) 
		{		
		} 
		
		/*
		Integer LOS = null;
		
		if(tracking.getAttendance() != null && tracking.getAttendance().getRegistrationDateTime() != null)
		{
			LOS = calculateDateDiffInMinutes(new DateTime(), tracking.getAttendance().getRegistrationDateTime());
		}
		*/
		DynamicGridCell cellLabel = row.getCells().newCell(getColumn(COLUMN_PATIENT), DynamicCellType.TABLE);
		DynamicGridCellTable helper = new DynamicGridCellTable(cellLabel);		
		helper.setBorder(4);		
		
		TableRow  tableRow = helper.getRows().newRow();
		
		TableCell tableCell = tableRow.getCells().newCell();
					tableCell.setType(TableCellType.IMAGE);		
					tableCell.setRowSpan(2);
					tableCell.setValue(patientImage);
					tableCell.setWidth(50);
					
		//Patient Name								
		TableCellOptions cellOptions = new TableCellOptions();		
						 cellOptions.setFontFamily(FontFamily.ARIAL);
						 cellOptions.setFontSize(16);
						 cellOptions.setFontWeight(FontWeight.BOLDER);	
						 cellOptions.setAlign(Align.CENTER);
						// setAwaitingTriageNameCellOptionsColors(cellOptions, LOS);						 

		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(130);		
		tableCell.setColSpan(3);
		
		if (tracking.getPatientIsNotNull() && tracking.getPatient().getNameIsNotNull())
		{
			String strForename = tracking.getPatient().getName().getForename();
			if( strForename == null)
				strForename = "       ";
			
			String strSurname = tracking.getPatient().getName().getSurnameIsNotNull() ? tracking.getPatient().getName().getSurname().toUpperCase():"       "; 		//wdev-17580
			tableCell.setValue( strSurname + "<br>"  + strForename ); 		//wdev-15939 ,wdev-17138
			tableCell.setTooltip("Surname: " + strSurname + ", Forename: " + (tracking.getPatient().getName().getForenameIsNotNull() ? tracking.getPatient().getName().getForename():""));		//wdev-15939,wdev-17580
		}
			
								
		//Hospital No
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		cellOptions = new TableCellOptions();		
						 cellOptions.setTextColor(Color.Black);
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(13);
						 cellOptions.setAlign(Align.RIGHT);
		tableCell.setOptions(cellOptions);
		tableCell.setColSpan(2);
		if (tracking.getPatientIsNotNull() && tracking.getPatient().getHospnum() != null)
		{
			tableCell.setValue(tracking.getPatient().getHospnum().getIdValue());
			tableCell.setTooltip(tracking.getPatient().getHospnum().getIdValue());
		}		
		tableCell.setColSpan(2);
		
		
		
		//UrgencyImage
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setValue(getImageForUrgency(tracking));
		tableCell.setWidth(30);
		
		//-------------------------
		//Temporary patient Image  - wdev-17138
		if( Boolean.TRUE.equals(tracking.getPatient().getIsQuickRegistrationPatient()))
		{
					
			tableCell = tableRow.getCells().newCell();
			tableCell.setType(TableCellType.IMAGE);
			tableCell.setValue(tracking.getPatient() != null && Boolean.TRUE.equals(tracking.getPatient().getIsQuickRegistrationPatient()) ? form.getImages().Emergency.EvenHistoryEnabled16 : null);
			
			tableCell.setTooltip("Temporary Patient");
			tableCell.setWidth(17);
		}
		//--------------------------
		
		
		//DOB
		tableRow = helper.getRows().newRow();
		
		//dd/mm/yyyy
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		cellOptions = new TableCellOptions();		
						 cellOptions.setTextColor(Color.Black);
						 cellOptions.setFontFamily(FontFamily.CALIBRI);
						 cellOptions.setFontSize(11);								 
		tableCell.setOptions(cellOptions);
		tableCell.setWidth(110);
		if (tracking.getPatientIsNotNull() && tracking.getPatient().getDobIsNotNull())
		{
			tableCell.setValue(tracking.getPatient().getDob().toString() + (tracking.getAttendance() != null && tracking.getAttendance().getAgeAtAttendance() != null ? " (" + tracking.getAttendance().getAgeAtAttendance() + ")" : ""));
			tableCell.setTooltip(tracking.getPatient().getDob().toString() + (tracking.getAttendance() != null && tracking.getAttendance().getAgeAtAttendance() != null ? " (" + tracking.getAttendance().getAgeAtAttendance() + ")" : ""));
		}
		
		//Gender
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(24);
		if (tracking.getPatientIsNotNull() && tracking.getPatient().getSex() != null)
		{
			if(tracking.getPatient().getSex().equals(Sex.MALE))
			{
				tableCell.setValue(form.getImages().Emergency.Male);
			}
			else if(tracking.getPatient().getSex().equals(Sex.FEMALE))
			{
				tableCell.setValue(form.getImages().Emergency.Female);
			}			
		}		
		
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(10);
		//LOS
		/*
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.STRING);
		
		
		cellOptions = new TableCellOptions();	
							 
		cellOptions.setFontFamily(FontFamily.CALIBRI);
		cellOptions.setFontSize(11);
		cellOptions.setFontWeight(FontWeight.BOLD);
		
		setLOSCellOptionColor(cellOptions, LOS);
							 
		tableCell.setOptions(cellOptions);
		
		if(LOS != null)
		{
			tableCell.setValue(EmergencyDisplayHelper.minutesToHoursAndMinutes(LOS));//WDEV-15818
			String str = EmergencyDisplayHelper.minutesToHoursAndMinutes(LOS);
			if( str != null)
				tableCell.setTooltip(str + " since Registration");//WDEV-15818, wdev-17252
		}
		*/
		//tableCell.setWidth(70);
		
		//Alert
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(24);
		tableCell.setValue(tracking.getPatient() != null && Boolean.TRUE.equals(tracking.getPatient().getHasAlerts()) ? form.getImages().Core.Alert48 : null);
		
		//Alert
		tableCell = tableRow.getCells().newCell();
		tableCell.setType(TableCellType.IMAGE);
		tableCell.setWidth(24);
		tableCell.setValue(tracking.getPatient() != null && Boolean.TRUE.equals(tracking.getPatient().getHasAllergies()) ? form.getImages().Core.Allergies48 : null);
		
		helper.renderValue();
		cellLabel.setValue(helper);
		cellLabel.setReadOnly(true);
		
		//row.setValue(tracking);
		
		return ;
	}
	
	private void addPatientToLocalCollection(AppImageVo patientImage) 
	{
		if(patientImage == null)
			return;
		
		List<String> imagesColl = form.getLocalContext().getPatientImagesList();
		
		if (imagesColl == null)
			imagesColl = new ArrayList<String>();
		
		if (EnvironmentConfig.getFileUploadMountpoint() != null && EnvironmentConfig.getFileUploadMountpoint() != "")
		{
			imagesColl.add(EnvironmentConfig.getFileUploadMountpoint() + patientImage.getImagePath());
		}
		else
		{
			imagesColl.add(EnvironmentConfig.getBaseUri() + patientImage.getImagePath());
		}
		
		form.getLocalContext().setPatientImagesList(imagesColl);
	}
	
	private Integer calculateDateDiffInMinutes(DateTime currentTime, DateTime registrationDateTime) 
	{
		if(currentTime == null || registrationDateTime == null)
			return null;
		
		long currentTimeInMillis = currentTime.getJavaDate().getTime();
		long registrationDateTimeInMillis = registrationDateTime.getJavaDate().getTime();
		
		return (int)(((currentTimeInMillis < registrationDateTimeInMillis ? registrationDateTimeInMillis - currentTimeInMillis : currentTimeInMillis - registrationDateTimeInMillis)/1000)/60);
	}
	
	private AppImageVo getPatientImage(TrackingForClinicianWorklistAndTriageVo tracking) throws IOException
	{
		if (tracking == null || tracking.getPatient() == null)
			return null;
		
		String sessionID = engine.getSessionId();
		
		AppDBImageVo dbImageVo =  tracking.getPatient().getPhoto();
		
		//Existing Patient with no image
		if (dbImageVo == null)
		{
			// NoPatientImage	
			AppImageVo imageVo = new AppImageVo();
			imageVo.setImagePath(form.getImages().Core.NoPatientImage.getImagePath());
			
			return imageVo;
		}
		
		String encodedImage = dbImageVo.getImageData();
		String type = dbImageVo.getImageType().getText();	  		  		  	
  	
		return decodeFromBase64(encodedImage, sessionID, type);
	}
	
	private AppImageVo decodeFromBase64(String content, String sessionID, String imageType) throws IOException
	{
		byte[] decBytes = Base64.decode(content);

		if (decBytes == null || (decBytes != null && decBytes.length == 0)) 
		{
			engine.showMessage("Base64 image size is zero");
			return null;
		}
		 
	    String str = generateName();
	    String image = EnvironmentConfig.getBaseUri() + ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + str + "." + imageType.toLowerCase();		
		
		try
		{		
			FileOutputStream fos = new FileOutputStream(image);				
			fos.write(decBytes);
			fos.close();	
			
			AppImageVo imageVo = new AppImageVo();
			imageVo.setImagePath(((ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + str + "." + imageType.toLowerCase()).replace("\\", "/")));
			return imageVo;
		}		
		catch(FileNotFoundException exception) {			
			System.out.println("FileNotFoundException : " + exception);
		}		
		catch(IOException ioexception) {						
			System.out.println("IOException : " + ioexception);
		}
						
		return null;	
	}
	
	private String generateName() 
	{
		String str = "";

		try
		{
			//Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length() < 12)
			{
				str = '0' + str;
			}

			//Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str;
			}
			//Get Third Random Segment
			byte bytes[] = new byte[16];
			SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
			thirdPrng.nextBytes(bytes);
			str += Integer.toHexString(thirdPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}
		}
		catch (java.security.NoSuchAlgorithmException ex)
		{
			ex.getMessage();
		}

		return str;
	}
	private Image getImageForUrgency(TrackingForClinicianWorklistAndTriageVo tracking) 
	{
		if(tracking == null || tracking.getAttendance() == null || tracking.getAttendance().getUrgencyLevel() == null)
			return  null;
		
		Image urgency = null;
		
		urgency = tracking.getAttendance().getUrgencyLevel().getImage();
		
		return urgency;
	}
	
	private  String getMRN(PatientForTriageVo patient)
	{
		if (patient==null || patient.getIdentifiers()==null || patient.getIdentifiers().size()==0)
			return null;
		
		for (int i=0;i<patient.getIdentifiers().size();i++)
		{
			PatientId tempId = patient.getIdentifiers().get(i);
			if (PatIdType.HOSPNUM.equals(tempId.getType()))
			{
				return tempId.getValue();
				
			}
		}
		
		return null;
	}

	private DynamicGridColumn getColumn(String identifier) 
	{
		return form.dyngrdWhiteBoard().getColumns().getByIdentifier(identifier);
	}

	@Override
	protected void onDyngrdWhiteBoardCellButtonClicked(DynamicGridCell cell)
	{
		form.dyngrdWhiteBoard().setValue(cell.getRow().getValue());
		setGlobalContexts((TrackingForClinicianWorklistAndTriageVo)form.dyngrdWhiteBoard().getValue());
		engine.open(form.getForms().Emergency.AttendanceClinicalNoteDialog, new Object[] {AttendanceClinicalNoteType.NURSE, null,null});
	}

	@Override
	protected void onDyngrdWhiteBoardRowSelectionChanged(DynamicGridRow row) throws PresentationLogicException
	{
		setGlobalContexts((TrackingForClinicianWorklistAndTriageVo)form.dyngrdWhiteBoard().getValue());
		populateGCFromRow(row);
		engine.open(form.getForms().Emergency.EDWhiteBoardEditDialog);
	}

	private void populateGCFromRow(DynamicGridRow row)
	{
		WhiteBoardEditVo data = new WhiteBoardEditVo();

		Object columnObsReq = row.getCells().get(getColumn(COLUMN_OBS_REQUIRED)).getValue();
		Object columnMedsGiven = row.getCells().get(getColumn(COLUMN_MEDS_GIVEN)).getValue();

		if (columnObsReq != null)
		{

			if (columnObsReq.equals(EDWhiteBoardDynGrdComboValues.REQUIRED))
			{
				data.setObsRequired(REQUIRED);
			}
			else if (columnObsReq.equals(EDWhiteBoardDynGrdComboValues.COMPLETE))
			{
				data.setObsRequired(COMPLETE);
			}
			else if (columnObsReq.equals(EDWhiteBoardDynGrdComboValues.NOT_REQUIRED))
			{
				data.setObsRequired(NOT_REQUIRED);
			}
		}

		if (columnMedsGiven != null)
		{

			if (columnMedsGiven.equals(EDWhiteBoardDynGrdComboValues.REQUIRED))
			{
				data.setMedsGiven(REQUIRED);
			}
			else if (columnMedsGiven.equals(EDWhiteBoardDynGrdComboValues.COMPLETE))
			{
				data.setMedsGiven(COMPLETE);
			}
			else if (columnMedsGiven.equals(EDWhiteBoardDynGrdComboValues.NOT_REQUIRED))
			{
				data.setMedsGiven(NOT_REQUIRED);
			}
		}

		data.setECG((Boolean) row.getCells().get(getColumn(COLUMN_ECG)).getValue());

		data.setNPO((Boolean) row.getCells().get(getColumn(COLUMN_NPO)).getValue());

		data.setIsolation((Boolean) row.getCells().get(getColumn(COLUMN_ISOLATION)).getValue());
		
		data.setPainAssessments((Integer) row.getCells().get(getColumn(COLUMN_PAIN_ASSESSMENT)).getValue());
		
		data.setWaterlowAssessments((Integer) row.getCells().get(getColumn(COLUMN_WATERLOW)).getValue());
		
		data.setFallsAssessment((Integer) row.getCells().get(getColumn(COLUMN_FALLS)).getValue());
		
		data.setIsarAssessments((Integer) row.getCells().get(getColumn(COLUMN_ISAR)).getValue());

		form.getGlobalContext().Emergency.setWhiteBoardEdit(data);

	}

	@Override
	protected void onImbRefreshClick() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onBtnSeenCompleteHCPClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.EDSeenByAndCompleteDialog);
	}

	@Override
	protected void onBtnAssessmentDetailsClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.EDAssessmentDialog);
		openEDAssessmentDialog();
	}

	private void openEDAssessmentDialog()
	{
		TrackingForClinicianWorklistAndTriageVo tempVo = (TrackingForClinicianWorklistAndTriageVo)form.dyngrdWhiteBoard().getValue();

		if( tempVo != null )
		{
			if( tempVo.getTriageDetailsIsNotNull() )
				engine.open(form.getForms().Emergency.EDAssessmentDialog, new Object[] {DISPLAY_CLINICIANASSESSMNRWORKLIST,tempVo},"Clinician Assessment Worklist");
			else
				engine.open(form.getForms().Emergency.EDAssessmentDialog, new Object[] {DISPLAY_TRIAGE_FROM_TRACKING,tempVo},"Triage");
				
		}
	}

	@Override
	protected void onBtnAllocatedCubicleClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.AllocateCubicle);
	}

	@Override
	protected void onBtnMoveClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.SendToAreaDialog);
	}

	@Override
	protected void onBtnPatStatusClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.TrackingStatusDialog);
	}

	@Override
	protected void onBtnResultClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Emergency.AttendanceResultListDialog);
	}

	@Override
	protected void onDyngrdWhiteBoardCellValueChanged(DynamicGridCell cell)
	{
		form.dyngrdWhiteBoard().setValue(cell.getRow().getValue());
		
		populateGCFromRow(form.dyngrdWhiteBoard().getSelectedRow());
		
		setGlobalContexts((TrackingForClinicianWorklistAndTriageVo)form.dyngrdWhiteBoard().getValue());
			
		
		if (getColumn(COLUMN_OBS_REQUIRED).equals(cell.getColumn()))
		{
			
			if (cell.getValue().equals(EDWhiteBoardDynGrdComboValues.REQUIRED))
			{
				form.getGlobalContext().Emergency.getWhiteBoardEdit().setObsRequired(REQUIRED);
			}
			else if (cell.getValue().equals(EDWhiteBoardDynGrdComboValues.COMPLETE))
			{
				form.getGlobalContext().Emergency.getWhiteBoardEdit().setObsRequired(COMPLETE);
			}
			else if (cell.getValue().equals(EDWhiteBoardDynGrdComboValues.NOT_REQUIRED))
			{
				form.getGlobalContext().Emergency.getWhiteBoardEdit().setObsRequired(NOT_REQUIRED);
			}
			
			engine.open(form.getForms().Emergency.EDWhiteBoardEditDialog);
		}
		else if (getColumn(COLUMN_MEDS_GIVEN).equals(cell.getColumn()))
		{
			if (cell.getValue().equals(EDWhiteBoardDynGrdComboValues.REQUIRED))
			{
				form.getGlobalContext().Emergency.getWhiteBoardEdit().setMedsGiven(REQUIRED);
			}
			else if (cell.getValue().equals(EDWhiteBoardDynGrdComboValues.COMPLETE))
			{
				form.getGlobalContext().Emergency.getWhiteBoardEdit().setMedsGiven(COMPLETE);
			}
			else if (cell.getValue().equals(EDWhiteBoardDynGrdComboValues.NOT_REQUIRED))
			{
				form.getGlobalContext().Emergency.getWhiteBoardEdit().setMedsGiven(NOT_REQUIRED);
			}
			
			engine.open(form.getForms().Emergency.EDWhiteBoardEditDialog);
		}
		else if (getColumn(COLUMN_ECG).equals(cell.getColumn()))
		{
			form.getGlobalContext().Emergency.getWhiteBoardEdit().setECG((Boolean)cell.getValue());
			engine.open(form.getForms().Emergency.EDWhiteBoardEditDialog);
			
		}
		else if (getColumn(COLUMN_NPO).equals(cell.getColumn()))
		{
			form.getGlobalContext().Emergency.getWhiteBoardEdit().setNPO((Boolean)cell.getValue());
			engine.open(form.getForms().Emergency.EDWhiteBoardEditDialog);
		}
		else if (getColumn(COLUMN_ISOLATION).equals(cell.getColumn()))
		{
			form.getGlobalContext().Emergency.getWhiteBoardEdit().setIsolation((Boolean)cell.getValue());
			engine.open(form.getForms().Emergency.EDWhiteBoardEditDialog);
		}
		else if (getColumn(COLUMN_COMMENT).equals(cell.getColumn()))
		{
			engine.open(form.getForms().Emergency.EDWhiteBoardDialog, new Object[] {AttendanceClinicalNoteType.NURSE, null,null});
		}
	}

	private void setGlobalContexts(TrackingForClinicianWorklistAndTriageVo tracking)
	{
		if (tracking==null)
			return;
		
		form.getGlobalContext().Core.setPatientShort(domain.getPatientShort(tracking.getPatient()));
		form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContextShort(tracking.getAttendance().getCareContext()));
		form.getGlobalContext().Emergency.setTracking(tracking);
		
		updateControlsState();
		
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Emergency.EDWhiteBoardEditDialog) && DialogResult.OK.equals(result))
		{
			if (form.getGlobalContext().Emergency.getWhiteBoardEdit() != null)
			{
				if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getObsRequired() != null)
				{
					if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getObsRequired() == REQUIRED)
					{
						form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_OBS_REQUIRED)).setValue(EDWhiteBoardDynGrdComboValues.REQUIRED);
					}
					else if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getObsRequired() == COMPLETE)
					{
						form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_OBS_REQUIRED)).setValue(EDWhiteBoardDynGrdComboValues.COMPLETE);
					}
					else if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getObsRequired() == NOT_REQUIRED)
					{
						form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_OBS_REQUIRED)).setValue(EDWhiteBoardDynGrdComboValues.NOT_REQUIRED);
					}
				}
				else
					form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_OBS_REQUIRED)).setValue(null);

				if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getMedsGiven() != null)
				{
					if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getMedsGiven() == REQUIRED)
					{
						form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_MEDS_GIVEN)).setValue(EDWhiteBoardDynGrdComboValues.REQUIRED);
					}
					else if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getMedsGiven() == COMPLETE)
					{
						form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_MEDS_GIVEN)).setValue(EDWhiteBoardDynGrdComboValues.COMPLETE);
					}
					else if (form.getGlobalContext().Emergency.getWhiteBoardEdit().getMedsGiven() == NOT_REQUIRED)
					{
						form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_MEDS_GIVEN)).setValue(EDWhiteBoardDynGrdComboValues.NOT_REQUIRED);
					}
				}
				else
					form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_MEDS_GIVEN)).setValue(null);

				form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_ECG)).setValue(form.getGlobalContext().Emergency.getWhiteBoardEdit().getECG());
				form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_NPO)).setValue(form.getGlobalContext().Emergency.getWhiteBoardEdit().getNPO());
				form.dyngrdWhiteBoard().getSelectedRow().getCells().get(getColumn(COLUMN_ISOLATION)).setValue(form.getGlobalContext().Emergency.getWhiteBoardEdit().getIsolation());

			}
		}
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.OK);
		
	}
}
