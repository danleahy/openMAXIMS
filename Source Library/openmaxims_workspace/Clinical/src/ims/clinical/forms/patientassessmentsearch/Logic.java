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
// This code was generated by Peter Martin using IMS Development Environment (version 1.71 build 3763.19232)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.patientassessmentsearch;

import java.util.ArrayList;

import ims.assessment.vo.GraphicAssessmentShortVo;
import ims.assessment.vo.PatientAssessmentDataListVo;
import ims.assessment.vo.PatientAssessmentListVo;
import ims.assessment.vo.PatientAssessmentListVoCollection;
import ims.assessment.vo.PatientAssessmentsFilterVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.enums.MosType;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.vo.LookupInstVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void initialize() {
		form.ccMos().initialize(MosType.HCP);		
	}

	private void populateSearchControls(PatientAssessmentsFilterVo patientAssessmentsFilter) {
		form.cmbSpecialty().setValue(patientAssessmentsFilter.getSpecialty());
		form.ccMos().setValue(patientAssessmentsFilter.getAuthoringHCPId());
		form.txtName().setValue(patientAssessmentsFilter.getName());
		form.dteFrom().setValue(patientAssessmentsFilter.getDateFrom());
		form.dteTo().setValue(patientAssessmentsFilter.getDateTo());
		form.cmbStatus().setValue(patientAssessmentsFilter.getStatus());
		form.cmbType().setValue(patientAssessmentsFilter.getType());
	}

	private void open() {
		form.setMode(FormMode.VIEW);
		if (form.getGlobalContext().Clinical.getPatientAssessmentsFilterIsNotNull())
		{
			populateSearchControls(form.getGlobalContext().Clinical.getPatientAssessmentsFilter());
			if (validateSearchCriteria(false))
			{
				populatePatientAssessmentsGrid(listPatientAssessments());
			}

		}
		updateControlState();		
	}
	private void populatePatientAssessmentsGrid(PatientAssessmentListVoCollection collection) 
	{
		for (int i = 0 ; collection != null && i < collection.size() ; i++)
		{
			PatientAssessmentListVo voPatientAssessment = collection.get(i);
			ims.clinical.forms.patientassessmentsearch.GenForm.grdDetailsRow newRow = form.grdDetails().getRows().newRow();
			newRow.setValue(voPatientAssessment);
			AuthoringInformationVo voAuthoringInfo = voPatientAssessment.getAuthoringInformation();
			if(voAuthoringInfo!= null && voAuthoringInfo.getAuthoringDateTimeIsNotNull())//WDEV-12339
				newRow.setDate(voAuthoringInfo.getAuthoringDateTime().getDate());
			
			//WDEV-12009
			LookupInstVo voLookupInst = domain.getSpecialtyByEpisodeOfCare(voPatientAssessment.getEpisodeOfCare());
			if(voLookupInst!=null)
				newRow.setSpecialty(voLookupInst.getText());
			if (voAuthoringInfo!= null && voAuthoringInfo.getAuthoringHcpIsNotNull())//WDEV-12339
				newRow.setAuthor(voAuthoringInfo.getAuthoringHcp().toString());
			newRow.setName(voPatientAssessment.getAssessmentName());
			if(voPatientAssessment.getAssessmentDataIsNotNull() && voPatientAssessment.getAssessmentData().getUserAssessmentIsNotNull()
					&& voPatientAssessment.getAssessmentData().getUserAssessment().getAssessmentTypeIsNotNull() )
				newRow.setType(voPatientAssessment.getAssessmentData().getUserAssessment().getAssessmentType().toString());
			
			PatientAssessmentDataListVo voPatientAssessmentDataList = voPatientAssessment.getAssessmentData();
			if(voPatientAssessmentDataList.getGraphicIsNotNull())
			{
				GraphicAssessmentShortVo voGraphic = voPatientAssessmentDataList.getGraphic();
				newRow.setName(voGraphic.getName());
				if(voGraphic.getAssessmentTypeIsNotNull())
					newRow.setType(voGraphic.getAssessmentType().toString());
			}
			newRow.setStatus(voPatientAssessment.getStatusIsNotNull() ? voPatientAssessment.getStatus().getIItemText() : null);
			
			if ( ! exactContextMatch(voPatientAssessment))
				newRow.setBackColor(Color.Bisque);
		}
	}
	
	private boolean exactContextMatch(PatientAssessmentListVo voPatientAssessment)
	{
		if (voPatientAssessment.getClinicalContactIsNotNull()
			&& form.getGlobalContext().Core.getCurrentClinicalContact() == null)
			return false;

		if (voPatientAssessment.getClinicalContactIsNotNull()
			&& form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()
			&& ! voPatientAssessment.getClinicalContact().equals(form.getGlobalContext().Core.getCurrentClinicalContact()))
			return false;
				
		if 	(voPatientAssessment.getCareContextIsNotNull()
			&& form.getGlobalContext().Core.getCurrentCareContext() == null)
			return false;

		if 	(voPatientAssessment.getCareContextIsNotNull()
			&& form.getGlobalContext().Core.getCurrentCareContextIsNotNull()
			&& ! voPatientAssessment.getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext()))	
			return false;

		if 	(voPatientAssessment.getEpisodeOfCareIsNotNull()
			&& form.getGlobalContext().Core.getEpisodeofCareShort() == null)
			return false;

		if 	(voPatientAssessment.getEpisodeOfCareIsNotNull()
			&& form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull()
			&& ! voPatientAssessment.getEpisodeOfCare().equals(form.getGlobalContext().Core.getEpisodeofCareShort()))
			return false;

		if ((voPatientAssessment.getEpisodeOfCareIsNotNull()
			|| voPatientAssessment.getCareContextIsNotNull()
			|| voPatientAssessment.getClinicalContactIsNotNull())
				&& voPatientAssessment.getPatientIsNotNull()
				&& form.getGlobalContext().Core.getCurrentClinicalContact() == null
				&& form.getGlobalContext().Core.getCurrentCareContext() == null
				&& form.getGlobalContext().Core.getEpisodeofCareShort() == null)
			return false;

		return true;
	}

	private PatientAssessmentListVoCollection listPatientAssessments() 
	{
		PatientAssessmentListVoCollection collPatientAssessmentVo = domain.listPatientAssessments(populateFilterVo());
			
		if (collPatientAssessmentVo == null || collPatientAssessmentVo.size() == 0)
		{
			engine.showMessage("No assessments matching your search criteria were found !", "No results",MessageButtons.OK, MessageIcon.INFORMATION);
			return null;
		}
		return collPatientAssessmentVo;
	}
	private PatientAssessmentsFilterVo populateFilterVo() {
		PatientAssessmentsFilterVo voPatientAssessmentsFilter = new PatientAssessmentsFilterVo();
		voPatientAssessmentsFilter.setSpecialty(form.cmbSpecialty().getValue());
		voPatientAssessmentsFilter.setAuthoringHCPId(form.ccMos().getValue());
		voPatientAssessmentsFilter.setName(form.txtName().getValue());
		voPatientAssessmentsFilter.setDateFrom(form.dteFrom().getValue());
		voPatientAssessmentsFilter.setDateTo(form.dteTo().getValue());
		voPatientAssessmentsFilter.setStatus(form.cmbStatus().getValue());
		voPatientAssessmentsFilter.setType(form.cmbType().getValue());
		voPatientAssessmentsFilter.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return voPatientAssessmentsFilter;
	}

	private boolean validateSearchCriteria(boolean showErrors) {
		Date dateFrom = form.dteFrom().getValue();
		Date dateTo = form.dteTo().getValue();
		
		ArrayList<String> uiErrors = new ArrayList<String>();
		Date today = new Date();
		
		if (dateFrom != null)
		{
			if (dateFrom.isGreaterThan(today))
			{
				uiErrors.add("'Authoring Date From' cannot be set to a date in the future."); //WDEV-18762 
			}
			if (dateTo != null && dateTo.isLessThan(dateFrom))
			{
				uiErrors.add("'Authoring Date From' cannot be later than 'Authoring Date To'."); //WDEV-18762 
			}
			if (dateFrom.isLessThan(form.getGlobalContext().Core.getPatientShort().getDob()))
			{
				uiErrors.add("'Authoring Date From' cannot be earlier than patient's Date of Birth."); //WDEV-18762 
			}
		}
		
			if (today.isLessThan(dateTo))
			{
				uiErrors.add("'Authoring Date To' cannot be set to a date in the future."); //WDEV-18762 
			}
			
		
		if (uiErrors.size() > 0)
		{
		
			if (showErrors)
				engine.showErrors(uiErrors.toArray(new String[uiErrors.size()]));
			return false;
		}
		return true;
	}
	
	private void clearSearchScreen() {
		form.cmbSpecialty().setValue(null);
		form.ccMos().clear();
		form.txtName().setValue("");
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		form.cmbType().setValue(null);
		form.cmbStatus().setValue(null);		
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearScreen();
		updateControlState();
	}
	private void clearScreen() {
		form.getGlobalContext().Clinical.setPatientAssessmentsFilter(null);
		form.grdDetails().getRows().clear();
		clearSearchScreen();		
	}
	private void updateControlState() {
		form.getContextMenus().hideAllGenericGridMenuItems();
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		searchAssessments();
	}
	private void searchAssessments()
	{
		form.grdDetails().getRows().clear();
		if (validateSearchCriteria(true))
		{
			saveSearchFilter();
			populatePatientAssessmentsGrid(listPatientAssessments());
		}	
		updateControlState();
	}

	private void saveSearchFilter() 
	{
		form.getGlobalContext().Clinical.setPatientAssessmentsFilter(populateSearchFilterDataFromScreen());		
	}
	private PatientAssessmentsFilterVo populateSearchFilterDataFromScreen() {
		PatientAssessmentsFilterVo voPatientAssessmentsFilter = new PatientAssessmentsFilterVo();
		
		voPatientAssessmentsFilter.setSpecialty(form.cmbSpecialty().getValue());
		if(form.ccMos().getValue()!=null)
			voPatientAssessmentsFilter.setAuthoringHCPId(form.ccMos().getValue());
		voPatientAssessmentsFilter.setName(form.txtName().getValue());
		voPatientAssessmentsFilter.setDateFrom(form.dteFrom().getValue());
		voPatientAssessmentsFilter.setDateTo(form.dteTo().getValue());
		voPatientAssessmentsFilter.setStatus(form.cmbStatus().getValue());
		voPatientAssessmentsFilter.setType(form.cmbType().getValue());
		return voPatientAssessmentsFilter;
	}
	@Override
	protected void onGrdDetailsSellectionChanged()
	{
//		form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
//		form.getContextMenus().getGenericGridUpdateItem().setText("View/Edit");
//		PatientAssessmentListVo pa = form.grdDetails().getValue();
///		if(pa != null
//			&& form.getGlobalContext().Core.getCurrentCareContext() == null)
//			form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContextShortVoByRefVo(pa.getCareContext()));

		form.getGlobalContext().Clinical.PatientAssessment.setSelectedAssessment(form.grdDetails().getValue());
		//WDEV-17142 form.getGlobalContext().Clinical.setReturnToFormName(engine.getFormName());

		form.getGlobalContext().Core.setUserDefinedFormMode(FormMode.VIEW);
	//	if ( exactContextMatch(form.grdDetails().getValue()))
	//		form.getGlobalContext().Core.setUserDefinedFormMode(FormMode.EDIT);
			
		PatientAssessmentListVo  voPatientAssessmentList  = form.grdDetails().getValue();
		if(voPatientAssessmentList!=null && voPatientAssessmentList.getAssessmentDataIsNotNull())
		{
			if(voPatientAssessmentList.getAssessmentData().getUserAssessmentIsNotNull())
				engine.open(form.getForms().Assessment.DynamicAssessmentsDialog, new Object[] {voPatientAssessmentList.getAssessmentData().getUserAssessment()});
			else if(voPatientAssessmentList.getAssessmentData().getGraphicIsNotNull())
				engine.open(form.getForms().Assessment.DynamicAssessmentsDialog, new Object[] {voPatientAssessmentList.getAssessmentData().getGraphic()});
		}

	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException {
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Update:
				
				form.getGlobalContext().Clinical.PatientAssessment.setSelectedAssessment(form.grdDetails().getValue());
				form.getGlobalContext().Clinical.setReturnToFormName(engine.getFormName());
				PatientAssessmentListVo  voPatientAssessmentList  = form.grdDetails().getValue();
				if(voPatientAssessmentList!=null && voPatientAssessmentList.getAssessmentDataIsNotNull()){
					if(voPatientAssessmentList.getAssessmentData().getUserAssessmentIsNotNull())
						engine.open(form.getForms().Assessment.DynamicAssessments, new Object[] {voPatientAssessmentList.getAssessmentData().getUserAssessment()});
					else if(voPatientAssessmentList.getAssessmentData().getGraphicIsNotNull())
						engine.open(form.getForms().Assessment.DynamicAssessments, new Object[] {voPatientAssessmentList.getAssessmentData().getGraphic()});
				}
				break;
			default:
				break;
		}		
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		searchAssessments();
	}
}
