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
// This code was generated by Peter Martin using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.oncology.forms.clinicaltrials;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.patientmedicalinsurance.GenForm;
import ims.core.vo.AuthoringInformationVo;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.enumerations.FormMode;
import ims.framework.utils.DateTime;
import ims.oncology.forms.clinicaltrials.GenForm.grdClinicalTrialsRow;
import ims.oncology.vo.ClinicalTrialsVo;
import ims.oncology.vo.ClinicalTrialsVoCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void open()
	{
		clear();
		populateClinicalTrialsGrid(domain.listClinicalTrialsVo(form.getGlobalContext().Core.getEpisodeofCareShort()));
		form.getLocalContext().setClinicalTrialsVo(domain.getClinicalTrialsVo(form.getLocalContext().getClinicalTrialsVo()));
		form.grdClinicalTrials().setValue(form.getLocalContext().getClinicalTrialsVo());
		populateInstanceControlsFromData(form.getLocalContext().getClinicalTrialsVo());
		form.setMode(FormMode.VIEW);
		updateControlsState();		
	}
	
	private void populateInstanceControlsFromData(ClinicalTrialsVo clinicalTrialsVo) 
	{
		//Clear instance controls
		clearInstanceControls();
		
		// Terminate function on null value parameter
		if (clinicalTrialsVo == null)
			return;
		
		//Set value to instance controls
		form.ctnDetails().cmbTrialName().setValue(clinicalTrialsVo.getClinicalTrial());
		form.ctnDetails().cmbOferred().setValue(clinicalTrialsVo.getPlaceOfferedOnTrial());
		form.ctnDetails().cmbEntered().setValue(clinicalTrialsVo.getAcceptedTrialOffer());
		form.ctnDetails().txtReasonRejected().setValue(clinicalTrialsVo.getReasonForRejection());
		form.ctnDetails().dteStartDate().setValue(clinicalTrialsVo.getStartDate());
		form.ctnDetails().dteEndDate().setValue(clinicalTrialsVo.getEndDate());
		form.ctnDetails().customControlAuthor().setValue(clinicalTrialsVo.getAuthoringInfo());
		form.ctnDetails().lblRecUser().setValue(clinicalTrialsVo.getSysInfoIsNotNull() ? clinicalTrialsVo.getSysInfo().getCreationUser() : "");
		form.ctnDetails().lblRecDT().setValue(clinicalTrialsVo.getSysInfoIsNotNull() ? clinicalTrialsVo.getSysInfo().getCreationDateTime().toString() : "");
		
	}
	
	private void clearInstanceControls()
	{
		form.ctnDetails().cmbTrialName().setValue(null);
		form.ctnDetails().cmbOferred().setValue(null);
		form.ctnDetails().cmbEntered().setValue(null);
		form.ctnDetails().txtReasonRejected().setValue("");
		form.ctnDetails().dteStartDate().setValue(null);
		form.ctnDetails().dteEndDate().setValue(null);
		form.ctnDetails().customControlAuthor().setValue(null);
		form.ctnDetails().lblRecUser().setValue("");
		form.ctnDetails().lblRecDT().setValue("");
	}
	
	private void populateClinicalTrialsGrid(ClinicalTrialsVoCollection collection)
	{
		// Clear grid
		form.grdClinicalTrials().getRows().clear();
		
		// Terminate function on null value parameter
		if (collection == null)
			return;
				
		// Iterate through pasconfig collection
		for (ClinicalTrialsVo voClinicalTrials : collection)
		{
			if (voClinicalTrials == null)
				continue;
			
			// Add each pasconfig to a grid row
			grdClinicalTrialsRow grdClinicalTrials = form.grdClinicalTrials().getRows().newRow(true);
			
			// Set pasconfigvo row columns
			if(voClinicalTrials.getClinicalTrialIsNotNull())
				grdClinicalTrials.setColTrialName(voClinicalTrials.getClinicalTrial().toString());
			if(voClinicalTrials.getPlaceOfferedOnTrialIsNotNull())
				grdClinicalTrials.setColOffered(voClinicalTrials.getPlaceOfferedOnTrial().toString());
			if(voClinicalTrials.getAcceptedTrialOfferIsNotNull())
				grdClinicalTrials.setColEntered(voClinicalTrials.getAcceptedTrialOffer().toString());
			grdClinicalTrials.setColReasonRejected(voClinicalTrials.getReasonForRejection());
			if(voClinicalTrials.getStartDateIsNotNull())
				grdClinicalTrials.setColStartDate(voClinicalTrials.getStartDate().toString());
			if(voClinicalTrials.getEndDateIsNotNull())
				grdClinicalTrials.setColEndDate(voClinicalTrials.getEndDate().toString());
						
			grdClinicalTrials.setValue(voClinicalTrials);
		}
		
	}
	
	private void clear() 
	{
		form.grdClinicalTrials().getRows().clear();
		clearInstanceControls();		
	}
	
	private void updateControlsState() 
	{
		// Update controls for VIEW mode
		if (FormMode.VIEW.equals(form.getMode()))
		{
			// EDIT button
			form.btnUpdate().setEnabled(true);
			form.btnUpdate().setVisible(form.getLocalContext().getClinicalTrialsVoIsNotNull() && form.grdClinicalTrials().getValue() != null);
			form.ctnDetails().setCollapsed(form.grdClinicalTrials().getValue() == null); //WDEV-14551
		}
		
		// Update context menu options
		updateContextMenuState();
		
	}
	
	private void updateContextMenuState() 
	{
		// NEW option should be visible in VIEW mode always, EDIT options should have the same rules as EDIT button
		form.getContextMenus().getGenericGridAddItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.getLocalContext().getClinicalTrialsVoIsNotNull() && form.grdClinicalTrials().getValue() != null);
		
	}
	
	private void initialize() 
	{
		form.getLocalContext().setClinicalTrialsVo(null);
		// Initialize context menu
		form.getContextMenus().hideAllGenericGridMenuItems();

		form.getContextMenus().getGenericGridAddItem().setText("New");
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
		form.ctnDetails().setCollapsed(true);
		
	}
	@Override
	protected void onGrdClinicalTrialsSelectionChanged()
	{
		form.getLocalContext().setClinicalTrialsVo(domain.getClinicalTrialsVo(form.grdClinicalTrials().getValue()));
		// Populate instance controls with selected record
		populateInstanceControlsFromData(form.getLocalContext().getClinicalTrialsVo());

		// Update controls state (buttons, context menu options, etc.)
		updateControlsState();
		form.ctnDetails().setCollapsed(false);		
	}
	@Override
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();		
	}
	
	private void updateInstance() 
	{
		form.setMode(FormMode.EDIT);
	//	form.ctnDetails().setcustomControlAuthorEnabled(false);
		form.ctnDetails().customControlAuthor().setEnabledAuthoringHCP(Boolean.TRUE);
		form.ctnDetails().customControlAuthor().setEnabledDateTime(Boolean.TRUE);
		form.ctnDetails().setCollapsed(false); //WDEV-14422 
	}
	
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
		form.ctnDetails().setCollapsed(false);
	}
	
	private void newInstance() 
	{
		// Clear local context selection
		form.getLocalContext().setClinicalTrialsVo(null);
		
		// Clear instance controls
		clearInstanceControls();
		// Set form to EDIT mode
		form.ctnDetails().setCollapsed(false);
		form.setMode(FormMode.EDIT);
		
		setAuthoringInfo();
		setRecordingInfo();
	}
	
	private void setRecordingInfo()
	{
		// TODO Auto-generated method stub
		form.ctnDetails().lblRecUser().setValue(engine.getLoggedInUser().getUsername());
		form.ctnDetails().lblRecDT().setValue(new DateTime().toString());
	}

	private void setAuthoringInfo() 
	{
		form.ctnDetails().customControlAuthor().initializeComponent();
		form.ctnDetails().customControlAuthor().setEnabledAuthoringHCP(Boolean.TRUE);
		form.ctnDetails().customControlAuthor().setEnabledDateTime(Boolean.TRUE);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	
	private boolean save() 
	{
		try
		{
			// Populate instance data from screen
			
			ClinicalTrialsVo  voClinicalTrialsVo = populateDataFromInstanceControls(form.getLocalContext().getClinicalTrialsVo());

			// Validate instance data
			String[] errors = voClinicalTrialsVo.validate(validateUIRules());           //wdev-13714

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
			form.getLocalContext().setClinicalTrialsVo(voClinicalTrialsVo);	
			// Attempt to save
			form.getLocalContext().setClinicalTrialsVo(domain.saveClinicalTrialsVo(form.getLocalContext().getClinicalTrialsVo()));
			
			// Save was successful
			return true;
		}
		// Treat exceptions
		catch (StaleObjectException e)
		{
			
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UnqViolationUncheckedException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
	}
	
	//wdev-13714
	private String[] validateUIRules()
	{
		java.util.ArrayList listOfErrors = new java.util.ArrayList();

		if (form.ctnDetails().dteStartDate().getValue() != null && form.ctnDetails().dteEndDate().getValue() != null)
		{
			if (form.ctnDetails().dteStartDate().getValue().isGreaterThan(form.ctnDetails().dteEndDate().getValue()))
			{
				listOfErrors.add("End Date has to be greater or equal than the Start Date.");
			}
		}
	
		int errorCount = listOfErrors.size();
		if (errorCount == 0)
		{
			return null;
		}
		String[] result = new String[errorCount];
		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		return result;
	}
	
	private ClinicalTrialsVo populateDataFromInstanceControls(ClinicalTrialsVo clinicalTrialsVo) 
	{
		if (clinicalTrialsVo == null)
		{
			clinicalTrialsVo = new ClinicalTrialsVo();
		}
		
		if(clinicalTrialsVo.getEpisodeOfCare()==null)
			clinicalTrialsVo.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		
		AuthoringInformationVo  voAuthInfo = clinicalTrialsVo.getAuthoringInfo();
		if(voAuthInfo == null)
			voAuthInfo = new AuthoringInformationVo();
		
		
		voAuthInfo.setAuthoringDateTime(form.ctnDetails().customControlAuthor().getValue().getAuthoringDateTime());
		voAuthInfo.setAuthoringHcp(form.ctnDetails().customControlAuthor().getValue().getAuthoringHcp());
		clinicalTrialsVo.setAuthoringInfo(voAuthInfo);
		
		// Get instance data from screen
		clinicalTrialsVo.setClinicalTrial(form.ctnDetails().cmbTrialName().getValue());
		clinicalTrialsVo.setPlaceOfferedOnTrial(form.ctnDetails().cmbOferred().getValue());
		clinicalTrialsVo.setAcceptedTrialOffer(form.ctnDetails().cmbEntered().getValue());
		clinicalTrialsVo.setReasonForRejection(form.ctnDetails().txtReasonRejected().getValue());
		clinicalTrialsVo.setStartDate(form.ctnDetails().dteStartDate().getValue());
		clinicalTrialsVo.setEndDate(form.ctnDetails().dteEndDate().getValue());
		

		return clinicalTrialsVo;
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
				
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
		}
	}
}
