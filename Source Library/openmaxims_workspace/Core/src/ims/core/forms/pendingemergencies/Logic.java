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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.

package ims.core.forms.pendingemergencies;

import ims.core.forms.pendingemergencyworklist.GenForm;
import ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVo;
import ims.core.vo.CatsReferralPendingEmergencyNonEDAdmissionListVoCollection;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.PendingEmergencyAdmissionWorklistSearchCriteriaVo;
import ims.core.vo.ServiceLiteVo;
import ims.core.vo.ServiceLiteVoCollection;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PendingEmergencyAdmissionType;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.DateTimeFormat;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int COL_SURNAME = 1;
	private static final int COL_SURNAME_WIDTH = 80;
	
	private static final int COL_FORENAME = 2;
	private static final int COL_FORENAME_WIDTH = 80;
	
	private static final int COL_ADMISSION_TYPE = 3;
	private static final int COL_ADMISSION_TYPE_WIDTH = 105;
	
	private static final int COL_WARD = 5;
	private static final int COL_WARD_WIDTH = 110;
	
	private static final int COL_ACCEPTING_CONSULTANT = 6;
	private static final int COL_ACCEPTING_CONSULTANT_WIDTH = 150;
	
	private static final int COL_ACCEPTED_DATE = 7;
	private static final int COL_ACCEPTED_DATE_WIDTH = 100;
	
	private static final int COL_SOURCE_OF_EMERGENCY_REFERRAL = 8;
	private static final int COL_SOURCE_OF_EMERGENCY_REFERRAL_WIDTH = -1;
	
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		
	}	
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onQmbAcceptingConsultantTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		MemberOfStaffLiteVoCollection consultants = domain.listAcceptingConsultants(value);
		
		populateAcceptingConsultants(consultants);
	}
	@Override
	protected void onQmbServiceTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		ServiceLiteVoCollection services = domain.listServices(value);
		
		populateServices(services);
	}
	@Override
	protected void onQmbWardTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		LocationLiteVoCollection wards = domain.listWardsForHospital(form.cmbHospital().getValue(), value);
		
		populateWards(wards);
	}
	@Override
	protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.qmbWard().clear();
		updateControlsState();
	}
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear Global Context
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setBedMngPendingEmergencyAdmissionListCriteria(null);
		
		// Clear search criteria & screen
		clearScreen();		

		// Update controls state
		updateControlsState();
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (validateSearchCriteria())
		{
			populateGlobalContextFromSearchCriteria(form.getGlobalContext().Core.getBedMngPendingEmergencyAdmissionListCriteria());
			
			search(true);
		}
		setTotals();
		// Update controls state
		updateControlsState();
	}
	@Override
	protected void onDyngrdPendingAdmissionsRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		if (form.dyngrdPendingAdmissions().getSelectedRow() != null)
		{
    		// Set Global Contexts
			CatsReferralPendingEmergencyNonEDAdmissionListVo pendingEmergencyAdmission = (CatsReferralPendingEmergencyNonEDAdmissionListVo) form.dyngrdPendingAdmissions().getSelectedRow().getValue();
			form.getGlobalContext().Core.setPatientShort(domain.getPatient(pendingEmergencyAdmission.getPatient()));
			form.getGlobalContext().RefMan.setCatsReferral(domain.getCatsReferral(pendingEmergencyAdmission));
		}
		
		updateControlsState();
	}
	@Override
	protected void onBtnViewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// View selected record
		viewSelectedRecord();
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.CoreNamespace.PendingEmergencyAdmissionWorklistCM.VIEW:
				viewSelectedRecord();
				break;
				
			case GenForm.ContextMenus.CoreNamespace.PendingEmergencyAdmissionWorklistCM.CANCEL:
				cancelSelectedRecord();
				break;
		}
		updateControlsState();
	}	
	
	//----------------------------------------------------------------------------------------------------------------------------
	//	Component interface functions
	//----------------------------------------------------------------------------------------------------------------------------

	public void initializeCustomControl()
	{
		initialize();		
	}		
	public void refresh()
	{
		if (form.getGlobalContext().Core.getBedMngPendingEmergencyAdmissionListCriteria() != null)
		{				
			open();
		}
		updateControlsState();
		
	}	
	public void setFocusOnSearch()
	{
		form.imbSearch().setFocus();		
	}	
	//----------------------------------------------------------------------------------------------------------------------------
		//	Form presentation functions
	//----------------------------------------------------------------------------------------------------------------------------


	protected void initialize()
	{
		// Initialize dynamic grid
		initializeDynamicGrid();
		setTotals();
		
		// Populate hospitals
		populateHospitals(domain.listHospitals());
		setLocationDefaults(); //WDEV-22710
			
	}
		//WDEV-22710
	private void setLocationDefaults()
	{
		ILocation iLoc = engine.getCurrentLocation();
		if (form.getGlobalContext().Core.getBedMngPendingEmergencyAdmissionListCriteria() != null)
			return;
		LocationLiteVo currentLocation = domain.getCurrentWard(iLoc);
		boolean bLoggedIntoAWardLocation = currentLocation != null && LocationType.WARD.equals(currentLocation.getType());
		if (form.cmbHospital().getValue() == null && bLoggedIntoAWardLocation)
		{	
			LocationLiteVo currentHospital = domain.getCurrentHospital(iLoc);
			form.cmbHospital().setValue(currentHospital);

		}
		if (bLoggedIntoAWardLocation)
		{
			form.qmbWard().newRow(currentLocation, currentLocation.getName());
			form.qmbWard().setValue(currentLocation);
		}
	}

		private void initializeDynamicGrid()
		{
			form.dyngrdPendingAdmissions().clear();
			
			DynamicGridColumn colSurname = form.dyngrdPendingAdmissions().getColumns().newColumn("Surname", COL_SURNAME);
			colSurname.setWidth(COL_SURNAME_WIDTH);
			colSurname.setSortMode(SortMode.AUTOMATIC);
			colSurname.setCanGrow(true);
			
			DynamicGridColumn colForename = form.dyngrdPendingAdmissions().getColumns().newColumn("Forename", COL_FORENAME);
			colForename.setWidth(COL_FORENAME_WIDTH);
			colForename.setSortMode(SortMode.AUTOMATIC);
			colForename.setCanGrow(true);
			
			DynamicGridColumn colAdmissionType = form.dyngrdPendingAdmissions().getColumns().newColumn("Admission Type", COL_ADMISSION_TYPE);
			colAdmissionType.setWidth(COL_ADMISSION_TYPE_WIDTH);
			colAdmissionType.setSortMode(SortMode.AUTOMATIC);
			colAdmissionType.setCanGrow(true);
			
			DynamicGridColumn columnWard = form.dyngrdPendingAdmissions().getColumns().newColumn("Ward", COL_WARD);
			columnWard.setWidth(COL_WARD_WIDTH);
			columnWard.setSortMode(SortMode.AUTOMATIC);
			columnWard.setCanGrow(true);
			
			DynamicGridColumn columnAcceptingConsultant = form.dyngrdPendingAdmissions().getColumns().newColumn("Accepting Consultant", COL_ACCEPTING_CONSULTANT);
			columnAcceptingConsultant.setWidth(COL_ACCEPTING_CONSULTANT_WIDTH);
			columnAcceptingConsultant.setSortMode(SortMode.AUTOMATIC);
			columnAcceptingConsultant.setCanGrow(true);
			
			DynamicGridColumn columnAcceptedDate = form.dyngrdPendingAdmissions().getColumns().newColumn("Accepted Date", COL_ACCEPTED_DATE);
			columnAcceptedDate.setWidth(COL_ACCEPTED_DATE_WIDTH);
			columnAcceptedDate.setSortMode(SortMode.AUTOMATIC);
			columnAcceptedDate.setCanGrow(true);
			
			DynamicGridColumn columnSoR = form.dyngrdPendingAdmissions().getColumns().newColumn("Source of Emer. Referral", COL_SOURCE_OF_EMERGENCY_REFERRAL);
			columnSoR.setWidth(COL_SOURCE_OF_EMERGENCY_REFERRAL_WIDTH);
			columnSoR.setCanGrow(true);
			columnSoR.setSortMode(SortMode.AUTOMATIC);
		}

		protected void open()
		{
			// Populate search criteria from Global Context
			populateSearchCriteriaFromGlobalContext(form.getGlobalContext().Core.getBedMngPendingEmergencyAdmissionListCriteria());
			
			// Search for Pending Emergency Admissions records
			search(false);
			setTotals();
			
			// Set the form to VIEW Mode
			form.setMode(FormMode.VIEW);
		}

		private boolean validateSearchCriteria()
		{
			ArrayList<String> errorList = new ArrayList<String>();
			
			if (form.dteAcceptingDateFrom().getValue() != null && form.dteAcceptingDateTo().getValue() != null)
			{
				if (form.dteAcceptingDateFrom().getValue().isGreaterThan(form.dteAcceptingDateTo().getValue()))
					errorList.add("Accepting Dates must be chronological.");
			}
			
			if (form.dteReferralDateFrom().getValue() != null && form.dteReferralDateTo().getValue() != null)
			{
				if (form.dteReferralDateFrom().getValue().isGreaterThan(form.dteReferralDateTo().getValue()))
					errorList.add("Referring Dates must be chronological.");
			}

			if (errorList.size() > 0)
			{
				engine.showErrors(errorList.toArray(new String[errorList.size()]));
				return false;
			}

			return true;
		}


		private void search(boolean verboseErrors)
		{
			// Clear selections
			form.getGlobalContext().Core.setPatientShort(null);
			form.getGlobalContext().Core.setSelectedPendingNonEDEmergencyAdmission(null);
			
			
			CatsReferralPendingEmergencyNonEDAdmissionListVoCollection pendingAdmissions = domain.search(form.getGlobalContext().Core.getBedMngPendingEmergencyAdmissionListCriteria());
			
			if (pendingAdmissions == null || pendingAdmissions.size() == 0)
			{
				engine.showMessage("No results found.");
			}
			
			populatePendingAdmission(pendingAdmissions);
		}

		
		private void cancelSelectedRecord()
		{
			
			if (form.dyngrdPendingAdmissions().getSelectedRow() != null)
			{
				CatsReferralPendingEmergencyNonEDAdmissionListVo pendingEmergencyAdmission = (CatsReferralPendingEmergencyNonEDAdmissionListVo) form.dyngrdPendingAdmissions().getSelectedRow().getValue();
			
				engine.open(form.getForms().Core.CancelPendingAdmissionReason, new Object[] {pendingEmergencyAdmission});
			}
		}

		
		private void viewSelectedRecord()
		{
			if (form.dyngrdPendingAdmissions().getSelectedRow() != null)
			{
	    		// Set Global Contexts
				CatsReferralPendingEmergencyNonEDAdmissionListVo pendingEmergencyAdmission = (CatsReferralPendingEmergencyNonEDAdmissionListVo) form.dyngrdPendingAdmissions().getSelectedRow().getValue();
				form.getGlobalContext().Core.setPatientShort(domain.getPatient(pendingEmergencyAdmission.getPatient()));
				form.getGlobalContext().Core.setSelectedPendingNonEDEmergencyAdmission(domain.getPendingEmergency(pendingEmergencyAdmission));

				// Open the form for Pending Emergency Admission Request as dialog
	    		engine.open(form.getForms().Core.PendingEmergencyAdmissionRequestDialog); //WDEV-22318
			}
		}


		private void updateControlsState()
		{
			form.cmbSourceofReferral().setVisible(PendingEmergencyAdmissionType.OTHER.equals(form.cmbType().getValue()));
			form.lblSourceOfEmergReferrral().setVisible(PendingEmergencyAdmissionType.OTHER.equals(form.cmbType().getValue()));
			
			form.btnView().setEnabled(true);
			form.btnView().setVisible(form.dyngrdPendingAdmissions().getSelectedRow() != null);
			
			form.getContextMenus().Core.getPendingEmergencyAdmissionWorklistCMVIEWItem().setVisible(form.dyngrdPendingAdmissions().getSelectedRow() != null);
			form.getContextMenus().Core.getPendingEmergencyAdmissionWorklistCMCANCELItem().setVisible(form.dyngrdPendingAdmissions().getSelectedRow() != null);
		}

		
		//----------------------------------------------------------------------------------------------------------------------------
		//	Form populating functions
		//----------------------------------------------------------------------------------------------------------------------------

		private void clearScreen()
		{
			// Clear search controls
			form.cmbCategory().setValue(null);
			form.cmbType().setValue(null);
			form.cmbTransferReason().setValue(null);
			form.cmbHospital().setValue(null);
			form.qmbWard().clear();
			form.qmbService().clear();
			form.cmbSourceofReferral().setValue(null);
			form.qmbAcceptingConsultant().setValue(null);
			form.dteAcceptingDateFrom().setValue(null);
			form.dteAcceptingDateTo().setValue(null);
			form.dteReferralDateFrom().setValue(null);
			form.dteReferralDateTo().setValue(null);
			
			// Clear results
			form.dyngrdPendingAdmissions().getRows().clear();
			setTotals();
		}

		
		private void populateSearchCriteriaFromGlobalContext(PendingEmergencyAdmissionWorklistSearchCriteriaVo worklistSearchCriteria)
		{
			if (worklistSearchCriteria == null)
				return;
			
			form.cmbType().setValue(worklistSearchCriteria.getType());
			form.cmbCategory().setValue(worklistSearchCriteria.getCategory());
			form.cmbTransferReason().setValue(worklistSearchCriteria.getTransferReason());
			form.cmbHospital().setValue(worklistSearchCriteria.getHospital());
			
			form.qmbWard().setValue(worklistSearchCriteria.getWard());
			if (form.qmbWard().getValue() == null && worklistSearchCriteria.getWard() != null)
			{
				form.qmbWard().newRow(worklistSearchCriteria.getWard(), worklistSearchCriteria.getWard().getName());
				form.qmbWard().setValue(worklistSearchCriteria.getWard());
			}
			
			form.qmbService().setValue(worklistSearchCriteria.getService());
			if (form.qmbService().getValue() == null && worklistSearchCriteria.getService() != null)
			{
				form.qmbService().newRow(worklistSearchCriteria.getService(), worklistSearchCriteria.getService().getServiceName());
				form.qmbService().setValue(worklistSearchCriteria.getService());
			}
			
			form.cmbSourceofReferral().setValue(worklistSearchCriteria.getSourceOfReferral());
			
			form.qmbAcceptingConsultant().setValue(worklistSearchCriteria.getAcceptingConsultant());
			if (form.qmbAcceptingConsultant().getValue() == null && worklistSearchCriteria.getAcceptingConsultant() != null)
			{
				form.qmbAcceptingConsultant().newRow(worklistSearchCriteria.getAcceptingConsultant(), worklistSearchCriteria.getAcceptingConsultant().getIMosName());
				form.qmbAcceptingConsultant().setValue(worklistSearchCriteria.getAcceptingConsultant());
			}
			
			form.dteAcceptingDateFrom().setValue(worklistSearchCriteria.getAcceptingDateFrom());
			form.dteAcceptingDateTo().setValue(worklistSearchCriteria.getAcceptingDateTo());
			form.dteReferralDateFrom().setValue(worklistSearchCriteria.getReferralDateFrom());
			form.dteReferralDateTo().setValue(worklistSearchCriteria.getReferralDateTo());
		}

		
		private void populateGlobalContextFromSearchCriteria(PendingEmergencyAdmissionWorklistSearchCriteriaVo worklistSearchCriteria)
		{
			if (worklistSearchCriteria == null)
				worklistSearchCriteria = new PendingEmergencyAdmissionWorklistSearchCriteriaVo();
			
			worklistSearchCriteria.setType(form.cmbType().getValue());
			worklistSearchCriteria.setCategory(form.cmbCategory().getValue());
			worklistSearchCriteria.setTransferReason(form.cmbTransferReason().getValue());
			worklistSearchCriteria.setHospital(form.cmbHospital().getValue());
			worklistSearchCriteria.setWard(form.qmbWard().getValue());
			worklistSearchCriteria.setService(form.qmbService().getValue());
			worklistSearchCriteria.setSourceOfReferral(form.cmbSourceofReferral().getValue());
			worklistSearchCriteria.setAcceptingConsultant(form.qmbAcceptingConsultant().getValue());
			worklistSearchCriteria.setAcceptingDateFrom(form.dteAcceptingDateFrom().getValue());
			worklistSearchCriteria.setAcceptingDateTo(form.dteAcceptingDateTo().getValue());
			worklistSearchCriteria.setReferralDateFrom(form.dteReferralDateFrom().getValue());
			worklistSearchCriteria.setReferralDateTo(form.dteReferralDateTo().getValue());
			
			form.getGlobalContext().Core.setBedMngPendingEmergencyAdmissionListCriteria(worklistSearchCriteria);
		}


		private void populatePendingAdmission(CatsReferralPendingEmergencyNonEDAdmissionListVoCollection pendingAdmissions)
		{
			form.dyngrdPendingAdmissions().getRows().clear();
			setTotals();
			
			if (pendingAdmissions == null)
				return;
			
			for (CatsReferralPendingEmergencyNonEDAdmissionListVo pendingAdmission : pendingAdmissions)
			{
				DynamicGridRow newRow = form.dyngrdPendingAdmissions().getRows().newRow();
				
				DynamicGridCell cellSurname = newRow.getCells().newCell(getColumn(COL_FORENAME), DynamicCellType.STRING);
				cellSurname.setValue(pendingAdmission.getPatient().getNameIsNotNull() ? pendingAdmission.getPatient().getName().getForename() : null);
				cellSurname.setTooltip(pendingAdmission.getPatient().getNameIsNotNull() ? pendingAdmission.getPatient().getName().getForename() : "");
				cellSurname.setReadOnly(true);
				
				DynamicGridCell cellForename = newRow.getCells().newCell(getColumn(COL_SURNAME), DynamicCellType.STRING);
				cellForename.setValue(pendingAdmission.getPatient().getNameIsNotNull() ? pendingAdmission.getPatient().getName().getSurname() : null);
				cellForename.setTooltip(pendingAdmission.getPatient().getNameIsNotNull() ? pendingAdmission.getPatient().getName().getSurname() : "");
				cellForename.setReadOnly(true);
				
				DynamicGridCell cellAdmissionType = newRow.getCells().newCell(getColumn(COL_ADMISSION_TYPE), DynamicCellType.STRING);
				cellAdmissionType.setValue(pendingAdmission.getRepatriationRequest().getTypeIsNotNull() ? pendingAdmission.getRepatriationRequest().getType().getText() : null);
				cellAdmissionType.setTooltip(pendingAdmission.getRepatriationRequest().getTypeIsNotNull() ? pendingAdmission.getRepatriationRequest().getType().getText() : "");
				cellAdmissionType.setReadOnly(true);
				
				DynamicGridCell cellWard = newRow.getCells().newCell(getColumn(COL_WARD), DynamicCellType.STRING);
				cellWard.setValue(pendingAdmission.getRepatriationRequest().getWard() != null ? pendingAdmission.getRepatriationRequest().getWard().getName() : "");
				cellWard.setTooltip(pendingAdmission.getRepatriationRequest().getWard() != null ? pendingAdmission.getRepatriationRequest().getWard().getName() : "");
				cellWard.setReadOnly(true);
				
				DynamicGridCell cellAcceptingConsultant = newRow.getCells().newCell(getColumn(COL_ACCEPTING_CONSULTANT), DynamicCellType.STRING);
				cellAcceptingConsultant.setValue(pendingAdmission.getAcceptedStatus() != null && pendingAdmission.getAcceptedStatus().getAuthoringUser() != null ? pendingAdmission.getAcceptedStatus().getAuthoringUser().toString() : "");
				cellAcceptingConsultant.setTooltip(pendingAdmission.getAcceptedStatus() != null && pendingAdmission.getAcceptedStatus().getAuthoringUser() != null ? pendingAdmission.getAcceptedStatus().getAuthoringUser().toString() : "");
				cellAcceptingConsultant.setReadOnly(true);
				
				DynamicGridCell cellAcceptedDate = newRow.getCells().newCell(getColumn(COL_ACCEPTED_DATE), DynamicCellType.STRING);
				cellAcceptedDate.setValue(pendingAdmission.getAcceptedStatus() != null && pendingAdmission.getAcceptedStatus().getStatusDateTime() != null ? pendingAdmission.getAcceptedStatus().getStatusDateTime().toString(DateTimeFormat.STANDARD) : "");
				//WDEV-22737
				cellAcceptedDate.setTooltip(pendingAdmission.getAcceptedStatus() != null && pendingAdmission.getAcceptedStatus().getStatusDateTime() != null ? pendingAdmission.getAcceptedStatus().getStatusDateTime().toString(DateTimeFormat.STANDARD) : "");
				cellAcceptedDate.setReadOnly(true);
				
				DynamicGridCell cellSor = newRow.getCells().newCell(getColumn(COL_SOURCE_OF_EMERGENCY_REFERRAL), DynamicCellType.STRING);
				cellSor.setValue(pendingAdmission.getRepatriationRequest() != null && pendingAdmission.getRepatriationRequest().getSourceOfEmergencyReferral() != null ? pendingAdmission.getRepatriationRequest().getSourceOfEmergencyReferral().getText() : "");
				//WDEV-22737
				cellSor.setTooltip(pendingAdmission.getRepatriationRequest() != null && pendingAdmission.getRepatriationRequest().getSourceOfEmergencyReferral() != null ? pendingAdmission.getRepatriationRequest().getSourceOfEmergencyReferral().getText() : "");
				cellSor.setReadOnly(true);
				
				newRow.setValue(pendingAdmission);
			}
		}


		private void populateHospitals(LocationLiteVoCollection hospitals)
		{
			form.cmbHospital().clear();
			
			if (hospitals == null)
				return;
			
			for (LocationLiteVo hospital : hospitals)
			{
				form.cmbHospital().newRow(hospital, hospital.getName());
				
				if (form.getGlobalContext().Core.getBedMngPendingEmergencyAdmissionListCriteria() == null && engine.getCurrentLocation() != null 
						&& hospital.getID_Location().equals(engine.getCurrentLocation().getID()))
						form.cmbHospital().setValue(hospital);
			}			
		}

		private void populateWards(LocationLiteVoCollection wards)
		{
			form.qmbWard().clear();
			
			if (wards == null)
				return;
			
			for (LocationLiteVo ward : wards)
			{
				form.qmbWard().newRow(ward, ward.getName());
			}
			
			if (wards.size() == 1)
				form.qmbWard().setValue(wards.get(0));
			else
				form.qmbWard().showOpened();
		}


		private void populateServices(ServiceLiteVoCollection services)
		{
			form.qmbService().clear();
			
			if (services == null)
				return;
			
			for (ServiceLiteVo service : services)
			{
				form.qmbService().newRow(service, service.getServiceName());
			}
			
			if (services.size() == 1)
				form.qmbService().setValue(services.get(0));
			else
				form.qmbService().showOpened();
		}


		private void populateAcceptingConsultants(MemberOfStaffLiteVoCollection consultants)
		{
			form.qmbAcceptingConsultant().clear();
			
			if (consultants == null)
				return;
			
			for (MemberOfStaffLiteVo consultant : consultants)
			{
				form.qmbAcceptingConsultant().newRow(consultant, consultant.getIMosName());
			}
			
			if (consultants.size() == 1)
				form.qmbAcceptingConsultant().setValue(consultants.get(0));
			else
				form.qmbAcceptingConsultant().showOpened();
		}


		private DynamicGridColumn getColumn(Object identifier)
		{
			if (identifier == null)
				return null;
			
			return form.dyngrdPendingAdmissions().getColumns().getByIdentifier(identifier);
		}
		private void setTotals()
		{
			form.lblTotal().setValue("Total: " + form.dyngrdPendingAdmissions().getRows().size());
		}
		@Override
		protected void onCmbTypeValueChanged()	throws PresentationLogicException 
		{
			if (!PendingEmergencyAdmissionType.OTHER.equals(form.cmbType().getValue()))
			{	
				form.cmbSourceofReferral().setValue(null);
			}	
			updateControlsState();			
		}
}
