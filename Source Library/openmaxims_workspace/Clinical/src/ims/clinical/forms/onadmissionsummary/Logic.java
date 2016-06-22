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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.45 build 2278.17185)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.onadmissionsummary;

import ims.clinical.vo.OnAdmissionSummaryVo;
import ims.framework.enumerations.FormMode;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.ClinicalNoteStatusVo;
import ims.core.vo.ClinicalNoteStatusVoCollection;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.lookups.ClinicalNoteType;
import ims.core.vo.lookups.ClinicalNotesStatus;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onFormModeChanged()
	{
		updateControlStatus();
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBtnSaveNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		clearControls();

		setCurrentClinicalNote();
			
		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			//WDEV-1037 - Notes created on this form need to have notetype set to SUMMARYATADMISSION( -882) and have discipline set to MEDICAL ( -59) 
			form.getLocalContext().setSelectedRecord(domain.get(null, ClinicalNoteType.SUMMARYATADMISSION, HcpDisType.MEDICAL ,form.getGlobalContext().Core.getCurrentCareContext()));
			if (form.getLocalContext().getSelectedRecordIsNotNull())
			{
				ClinicalNotesVo admissionNotes = form.getLocalContext().getSelectedRecord().getAdmissionNotes();
				if (admissionNotes != null)
				{
					if (admissionNotes.getAuthoringInfoIsNotNull())
						form.customControlAuthoringInfo().setValue(admissionNotes.getAuthoringInfo());

					form.txtSummary().setValue(admissionNotes.getClinicalNote());					
				}
			}
		}
		
		form.setMode(FormMode.VIEW);
	}
	
	private void setCurrentClinicalNote()
	{
		if (form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
		{
			ClinicalContactShortVo currentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			ClinicalNotesVo clinicalNotesForContact = domain.getClinicalNotesForContact(currentClinicalContact);
			
			if (clinicalNotesForContact != null)
				form.getGlobalContext().Clinical.setCurrentClinicalNote(domain.getClinicalNote(clinicalNotesForContact));
			else
				form.getGlobalContext().Clinical.setCurrentClinicalNote(null);
		}
	}
	
	protected void updateControlStatus()
	{
		if (form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getMode().equals(FormMode.VIEW))
		{
			form.btnUpdate().setVisible(form.getLocalContext().getSelectedRecordIsNotNull());
			form.btnUpdate().setEnabled(form.getLocalContext().getSelectedRecordIsNotNull());
			form.btnNew().setVisible(!form.getLocalContext().getSelectedRecordIsNotNull());
			form.btnNew().setEnabled(!form.getLocalContext().getSelectedRecordIsNotNull());				
		}
		else
		{
			form.btnUpdate().setVisible(false);
			form.btnUpdate().setEnabled(false);
			form.btnNew().setVisible(false);
			form.btnNew().setEnabled(false);				
		}
		
		OnAdmissionSummaryVo voOnAdmissionSummary = form.getLocalContext().getSelectedRecord();
		boolean isNewRecord = voOnAdmissionSummary == null || voOnAdmissionSummary.getID_OnAdmissionSummary() == null;
		boolean authoringEditable = form.getMode().equals(FormMode.EDIT) && isNewRecord;
		form.setcustomControlAuthoringInfoEnabled(authoringEditable);
	}
	protected void onBtnNewClick() throws PresentationLogicException 
	{
		newInstance();
	}
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		updateInstance();
		
	}
	private void newInstance()
	{
		form.setMode(FormMode.EDIT);
		form.customControlAuthoringInfo().initializeComponent();
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(true);
		form.setcustomControlAuthoringInfoEnabled(true);
		form.txtSummary().setFocus();
	}
	private void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	
		form.setcustomControlAuthoringInfoEnabled(false);
	}	
	private boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		OnAdmissionSummaryVo vo = populateDataFromScreen();
		
		//check UI and VO validation	
		String[] arrErrors =  vo.validate(getUIValidation());			
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.save(vo));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("There is already an Admission Summary for this Care Context");
			open();
			return false;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (DomainRuntimeException e)
		{
			engine.showMessage(e.getMessage());
			open();
			return false;
		}
		//form.getGlobalContext().Clinical.setCurrentClinicalNote(vo.getAdmissionNotes());
		
		return true;
	}
	private String[] getUIValidation()
	{
		java.util.ArrayList<String> errors = new java.util.ArrayList<String>();
		if(form.customControlAuthoringInfo().getValue() != null && form.customControlAuthoringInfo().getValue().getAuthoringHcp() == null)
			errors.add("Authoring HCP is mandatory");
		if(form.customControlAuthoringInfo().getValue() != null && form.customControlAuthoringInfo().getValue().getAuthoringDateTime() == null)
			errors.add("Authoring Date Time is mandatory");
		
		int errosSize = errors.size();
		if(errosSize > 0)
		{
			String[] uiErrors = new String[errosSize];
			errors.toArray(uiErrors);
			return uiErrors;
		}
		
		return null;
	}
	private OnAdmissionSummaryVo populateDataFromScreen()
	{
		OnAdmissionSummaryVo vo = form.getLocalContext().getSelectedRecord();
		ClinicalNotesVo voClinNotes = null;
		
		if (vo == null)
			vo = new OnAdmissionSummaryVo();
	
		vo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		vo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		voClinNotes = vo.getAdmissionNotes();
		
		if (voClinNotes == null)
		{
			voClinNotes = new ClinicalNotesVo();
			
			//WDEV-2408
			ClinicalNoteStatusVo voRecordStatus = new ClinicalNoteStatusVo();
			voRecordStatus.setStatus(ClinicalNotesStatus.ACTIVE);
			voClinNotes.setCurrentStatus(voRecordStatus);
			ClinicalNoteStatusVoCollection voStatusColl = new ClinicalNoteStatusVoCollection();
			if (! voStatusColl.contains(voRecordStatus))
				voStatusColl.add(voRecordStatus);
			
			voClinNotes.setAuthoringInfo(form.customControlAuthoringInfo().getValue());		
			voClinNotes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			voClinNotes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			voClinNotes.setInHospitalReport(new Boolean(true));
			//WDEV-1037 - Notes created on this form need to have discipline set to MEDICAL ( -59)
			voClinNotes.setDiscipline(HcpDisType.MEDICAL);
			//WDEV-1037 - Notes created on this form need to have notetype set to SUMMARYATADMISSION( -882) 
			voClinNotes.setNoteType(ClinicalNoteType.SUMMARYATADMISSION);
		}
				
		voClinNotes.setClinicalNote(form.txtSummary().getValue());
		voClinNotes.setIsDerivedNote(Boolean.FALSE);
		
		vo.setAdmissionNotes(voClinNotes);
		
		
		return vo;
	}
	//WDEV-1037 
	private void clearControls()
	{
		form.txtSummary().setValue("");
		form.customControlAuthoringInfo().setValue(null);
	}
}
