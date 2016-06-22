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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40608.1230)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.assesscommunication;

import ims.coe.vo.AssessmentCommunication;
import ims.coe.vo.CommunicationHearingVo;
import ims.coe.vo.CommunicationSpeechAndLanguageVo;
import ims.coe.vo.CommunicationUnderstanding;
import ims.coe.vo.CommunicationUnderstandingCollection;
import ims.coe.vo.CommunicationVisionVo;
import ims.coe.vo.lookups.Communicates;
import ims.coe.vo.lookups.CommunicatesCollection;
import ims.coe.vo.lookups.LookupHelper;
import ims.coe.vo.lookups.SpeechAndLanguageUnderstanding;
import ims.coe.vo.lookups.SpeechAndLanguageUnderstandingCollection;
import ims.coe.vo.lookups.Verbally;
import ims.coe.vo.lookups.VerballyCollection;
import ims.core.vo.lookups.YesNoUnknown;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.nursing.vo.AssessmentHeaderInfo;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateCollection;
import ims.nursing.vo.CarePlanTemplateTitle;
import ims.nursing.vo.CarePlanTemplateTitleCollection;
import ims.nursing.vo.lookups.AssessmentComponentType;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}
	
	private void open() throws FormOpenException
	{
		form.container1().ansCommDifficulty().setFocus();
		form.setMode(FormMode.EDIT);
		form.container1().bSave().setEnabled(true);
		form.container1().gridCarePlan().setReadOnly(false);
		form.chkCopyPrev().setEnabled(false);
		
	
		// If there is an assessment in the global context, we want to call the get component domain method
		// Otherwise, it is a new assessment component
		AssessmentHeaderInfo assmnt = form.getGlobalContext().Nursing.getAssessmentHeaderInfo();
		form.getLocalContext().setassmnt(assmnt);
		if (assmnt != null && assmnt.getID_AssessmentIsNotNull())
		{		
			AssessmentCommunication assessComm = (AssessmentCommunication)domain.getComponent(assmnt,AssessmentComponentType.COMMUNICATION);
			form.getLocalContext().setcommunication(assessComm);
			populateInstanceControl(assessComm);
		}
		else
		{
			// check if there is a relevant component
			getLastAssessmentComponent();
		}

		try
		{
			onAnsHearingImpValueChanged();
			onAnsVisImpairValueChanged();
		} 
		catch (PresentationLogicException e)
		{
			throw new FormOpenException(e.getMessage(),e);
		}
		
	}
	private void initialize()
	{
		form.getLocalContext().setverballyColl(LookupHelper.getVerbally(domain.getLookupService()));
		form.getLocalContext().setspeechColl(LookupHelper.getSpeechAndLanguageUnderstanding(domain.getLookupService()));
		form.getLocalContext().setyesNoColl(ims.core.vo.lookups.LookupHelper.getYesNoUnknown(domain.getLookupService()));
		loadGrids();
	}
	/*
	 * Method will populate the form onFormOpen with the lookups and grid information
	 */
	private void loadGrids()
	{
		loadCommunicationsGrd();
		loadVerbalGrd();
		loadCoherentGrd();
		loadCarePlanGrd();
	}
	
	private void loadCarePlanGrd() 
	{
		CarePlanTemplateTitleCollection tempColl = domain.listCarePlanTemplates(AssessmentComponentType.COMMUNICATION);
		if (tempColl != null)
		{
			form.container1().gridCarePlan().getRows().clear();
			GenForm.container1Container.gridCarePlanRow tempRow;
			for (int i=0; i<tempColl.size(); i++)
			{
				CarePlanTemplateTitle template = tempColl.get(i);
				tempRow = form.container1().gridCarePlan().getRows().newRow();
				tempRow.setValue(template);
				tempRow.setcolCarePlans(template.getTitle());
			}
		}
	}

	private void loadCoherentGrd() 
	{
		SpeechAndLanguageUnderstandingCollection speechLangColl = form.getLocalContext().getspeechColl();
		GenForm.container1Container.gridCoherentRow coherentRow;
		form.container1().gridCoherent().getRows().clear();
		SpeechAndLanguageUnderstanding speech;
		for (int i=0; i<speechLangColl.size(); i++)
		{
			speech = speechLangColl.get(i);
			coherentRow = form.container1().gridCoherent().getRows().newRow();
			coherentRow.setcolQuest(speech);
		}
	}

	private void loadVerbalGrd() 
	{
		VerballyCollection verballyColl = form.getLocalContext().getverballyColl();
		 GenForm.container1Container.gridVerballyRow verbalRow;
		 form.container1().gridVerbally().getRows().clear();
		Verbally verbally;
		 for (int i=0; i<verballyColl.size(); i++)
		 {
			verbally = verballyColl.get(i);
			verbalRow = form.container1().gridVerbally().getRows().newRow();
			verbalRow.setValue(verbally);
			verbalRow.setcolVerbally(verbally.getText());
			verbalRow.setcolSelected(false);
		 }
	}

	private void loadCommunicationsGrd()
	{
		CommunicatesCollection communicatesColl = LookupHelper.getCommunicates(domain.getLookupService());
		form.container1().gridCommunicates().getRows().clear();
		GenForm.container1Container.gridCommunicatesRow row;
		Communicates comm;
		for (int i=0; i<communicatesColl.size(); i++)
		{
			comm = communicatesColl.get(i);
			row = form.container1().gridCommunicates().getRows().newRow();
			row.setValue(comm);
			row.setcolCommunicates(comm.getText());
			row.setcolSelected(false);
		}
	}

	/*
	 * Method will populate the form with data from the assessment communication component
	 */
	private void populateInstanceControl(AssessmentCommunication voAssCommunication)
	{
		// We have the data now, we need to populate everything on the form to
		// reflect what we have in assessComm
		if (voAssCommunication == null)
			return;		
		
		// Difficulty Communication
		form.container1().ansCommDifficulty().setValue(voAssCommunication.getDifficultyInCommunication());
		// Speech and Language
		if(voAssCommunication.getSpeechAndLanguage() != null)
		{
			CommunicationSpeechAndLanguageVo voCommSpeechAndLang = voAssCommunication.getSpeechAndLanguage();
			form.container1().ansSLDifficulty().setValue(voCommSpeechAndLang.getSpeechLanguageDifficulty());
			form.container1().cmbSpokenLang().setValue(voCommSpeechAndLang.getSpokenLanguage());
		
			CommunicatesCollection coll = voCommSpeechAndLang.getCommunicates();
			GenForm.container1Container.gridCommunicatesRow row;
			Communicates comm;
			for (int i=0; i<coll.size(); i++)
			{
				comm = coll.get(i);
				row = form.container1().gridCommunicates().getRowByValue(comm);
				if (row != null) 
					row.setcolSelected(true);
				else
				{
					row = form.container1().gridCommunicates().getRows().newRow();
					row.setValue(comm);
					row.setcolCommunicates(comm.getText());
					row.setcolSelected(true); 
				}
			}
		
			VerballyCollection vColl = voCommSpeechAndLang.getVerbally();
			GenForm.container1Container.gridVerballyRow vRow;
			Verbally verbal;
			for (int i=0; i<vColl.size(); i++)
			{
				verbal = vColl.get(i);
				vRow = form.container1().gridVerbally().getRowByValue(verbal);
				if (vRow != null)
					vRow.setcolSelected(true);
				else
				{
					vRow = form.container1().gridVerbally().getRows().newRow();
					vRow.setValue(verbal);
					vRow.setcolVerbally(verbal.getText());
					vRow.setcolSelected(true); 
				}
			}
		
		
			GenForm.container1Container.gridCoherentRow coherentRow;
			CommunicationUnderstandingCollection sColl = voCommSpeechAndLang.getSpeechAndLanguageUnderstanding();
			if (sColl != null)
			{
				for (int i=0; i<sColl.size(); i++)
				{
					CommunicationUnderstanding speech = sColl.get(i);
					int numRows = form.container1().gridCoherent().getRows().size();
					int j = 0;
					for (j=0; j<numRows; j++)
					{
						coherentRow = form.container1().gridCoherent().getRows().get(j);
						if (speech.getSpeechAndLanguageUnderstanding().equals(coherentRow.getcolQuest()))
						{
							coherentRow.setcolStatus(speech.getStatus());
							coherentRow.setValue(speech);	
							break;					
						}
					}
					if(j == form.container1().gridCoherent().getRows().size())
					{
						coherentRow = form.container1().gridCoherent().getRows().newRow();
						coherentRow.setcolQuest(speech.getSpeechAndLanguageUnderstanding());
						coherentRow.setcolStatus(speech.getStatus());
						coherentRow.setValue(speech);	
					}
				}
			}
		}

		if(voAssCommunication.getVision() != null)
		{
			CommunicationVisionVo voCommVision = voAssCommunication.getVision();
			//Vision
			form.container1().ansVisImpair().setValue(voCommVision.getVisualImpairment());
			form.container1().comboBoxEyes().setValue(voCommVision.getEffectedEyes());
			form.container1().intNoGlasses().setValue(voCommVision.getNumberOfGlasses());
			form.container1().txtOther().setValue(voCommVision.getOther());
			form.container1().intYearLastEyeTest().setValue(voCommVision.getYearLastEyeTest());	
			form.container1().ansGlasses().setValue(voCommVision.getWearGlasses());
			form.container1().ansWearLenses().setValue(voCommVision.getWearLenses());
			form.container1().ansRegBlind().setValue(voCommVision.getRegisteredBlind());
		}
		
		if(voAssCommunication.getHearing() != null)
		{
			CommunicationHearingVo voCommHearing = voAssCommunication.getHearing();  
			//Hearing
			form.container1().comboBoxEars().setValue(voCommHearing.getEffectedEars());
			form.container1().intYearLastHearTest().setValue(voCommHearing.getYearLastHearingTest());
			form.container1().ansHearingImp().setValue(voCommHearing.getHearingImpairment());
			form.container1().ansHearingAid().setValue(voCommHearing.getHearingAid());
			form.container1().ansHearingAidAdmission().setValue(voCommHearing.getHearingAidWithPatientOnAdmission());
			form.container1().ansBatteries().setValue(voCommHearing.getBatteriesInOrder());
		}
		

		// Populate the correct selected careplan template if one saved with the component
		if (voAssCommunication.getCarePlanTemplate() != null && voAssCommunication.getCarePlanTemplate().size() > 0)
		{
			GenForm.container1Container.gridCarePlanRow cpRow;
			CarePlanTemplateCollection templateColl = voAssCommunication.getCarePlanTemplate();
			CarePlanTemplate template;
			int i=0;
			// Find the correct row to set to selected
			for (int j=0; j<form.container1().gridCarePlan().getRows().size(); j++)
			{
				cpRow = form.container1().gridCarePlan().getRows().get(j);
				for (i=0; i<templateColl.size(); i++)
				{
					template = templateColl.get(i);
					if (cpRow.getValue().getID_CarePlanTemplate().equals(template.getID_CarePlanTemplate()))
					{
						cpRow.setcolSelected(true);
						cpRow.setReadOnly(true);
						break;
					}
				}
			}
		}
				
		if (voAssCommunication.getIsComplete().booleanValue() == true) // Complete
		{
			form.container1().chkComplete().setValue(true);
			form.container1().bSave().setEnabled(false);
			form.setMode(FormMode.VIEW);
			form.container1().chkComplete().setEnabled(false);
			form.chkCopyPrev().setEnabled(false);
			form.container1().gridCarePlan().setReadOnly(true);
			
			form.container1().comboBoxEyes().setEnabled(false);
			form.container1().ansWearLenses().setEnabled(false);
			form.container1().ansGlasses().setEnabled(false);
			form.container1().ansRegBlind().setEnabled(false);
			form.container1().intNoGlasses().setEnabled(false);
			form.container1().intYearLastEyeTest().setEnabled(false);
			form.container1().txtOther().setEnabled(false);
			
		}
		if (voAssCommunication.getCopy().booleanValue() == true)
		{
			form.chkCopyPrev().setValue(true);
			form.chkCopyPrev().setEnabled(false);
		}
	}
	
	protected void onCopyPrevAssessmentValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getPrevAssessCommunication() == null)
			return;
		
		form.getLocalContext().getPrevAssessCommunication().setIsComplete(Boolean.FALSE);
		form.getLocalContext().getPrevAssessCommunication().setCarePlanTemplate(null);
		populateInstanceControl(form.getLocalContext().getPrevAssessCommunication());
		form.chkCopyPrev().setValue(true);
		form.chkCopyPrev().setEnabled(false);
	}
	
	protected void getLastAssessmentComponent()
	{
		AssessmentCommunication tmpAssessComm = (AssessmentCommunication)domain.getLastAssessmentComponent(form.getGlobalContext().Core.getPatientShort(),form.getGlobalContext().Core.getCurrentCareContext(),AssessmentComponentType.COMMUNICATION);
		if (tmpAssessComm == null)
		{
			this.form.chkCopyPrev().setValue(false);
			return;
		}
		
		form.getLocalContext().setPrevAssessCommunication(tmpAssessComm);
		form.chkCopyPrev().setEnabled(true);
	}
	
	protected void onInfoLinkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getcommunication() != null && form.getLocalContext().getcommunication().getAssessmentInfo() != null)
		{
			form.getGlobalContext().Nursing.setAssessmentInfo(form.getLocalContext().getcommunication().getAssessmentInfo());
			engine.open(form.getForms().Nursing.AssessmentInfo);
		}
	}
	
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.AdmissionAssessOverview);
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{		 
		if ( (form.container1().intYearLastEyeTest().getValue() != null) && (form.container1().intYearLastEyeTest().getValue().toString().length() > 4))
		{
			engine.showMessage("The entry for Year of last eye test should be no more than 4 chars. Please re-enter.");
			return;
		}
		if ( (form.container1().intNoGlasses().getValue() != null) && (form.container1().intNoGlasses().getValue().toString().length() > 2))
		{
			engine.showMessage("The number of glasses cannot exceed 99. Please re-enter.");
			form.container1().intNoGlasses().setFocus();
			return;
		}
		if (form.container1().cmbSpokenLang().getValue() == null)
		{
			engine.showMessage("Please select a 'Spoken Language'");
			form.container1().cmbSpokenLang().setFocus();
			return;
		}
		
		CommunicationSpeechAndLanguageVo voCommSpeechAndLang = null;
		CommunicationVisionVo voCommVision = null;
		CommunicationHearingVo voCommHearing = null;
		AssessmentCommunication voAssessCommunication = null; 
		
		if(form.getLocalContext().getcommunication() != null)
		{
			voAssessCommunication = form.getLocalContext().getcommunication();
			voCommVision = voAssessCommunication.getVision();
			voCommHearing = voAssessCommunication.getHearing();
			voCommSpeechAndLang = voAssessCommunication.getSpeechAndLanguage();
		}
		
		if (voAssessCommunication == null)
		{
			voAssessCommunication = new AssessmentCommunication();
			voAssessCommunication.setComponentType(AssessmentComponentType.COMMUNICATION);
		}
			
		voAssessCommunication.setIsComplete(new Boolean(this.form.container1().chkComplete().getValue()));
		voAssessCommunication.setCopy(new Boolean(this.form.chkCopyPrev().getValue()));
		voAssessCommunication.setDifficultyInCommunication(form.container1().ansCommDifficulty().getValue());
		
		if(voCommSpeechAndLang == null)
			voCommSpeechAndLang = new CommunicationSpeechAndLanguageVo();
		// SpeechAndLanguage
		voCommSpeechAndLang.setSpeechLanguageDifficulty(form.container1().ansSLDifficulty().getValue());
		voCommSpeechAndLang.setSpokenLanguage(form.container1().cmbSpokenLang().getValue());
		
		// Go through the communicates grid and save them
		CommunicatesCollection commColl = new CommunicatesCollection();
		GenForm.container1Container.gridCommunicatesRow row;
		for (int i=0; i<form.container1().gridCommunicates().getRows().size(); i++)
		{
			row = form.container1().gridCommunicates().getRows().get(i);
			if(row.getcolSelected())
				commColl.add(row.getValue());
		}
		voCommSpeechAndLang.setCommunicates(commColl);

		// Go through the Verbally grid and save them
		VerballyCollection verbColl = new VerballyCollection();
		GenForm.container1Container.gridVerballyRow verRow;
		for (int i=0; i<form.container1().gridVerbally().getRows().size(); i++)
		{
			verRow = form.container1().gridVerbally().getRows().get(i);
			if(verRow.getcolSelected())
				verbColl.add(verRow.getValue());
		}
		voCommSpeechAndLang.setVerbally(verbColl);

		// Go through the grid coherent and set the value objects accordingly
		CommunicationUnderstandingCollection sluColl = new CommunicationUnderstandingCollection();
		GenForm.container1Container.gridCoherentRow cRow;
		for (int i=0; i<form.container1().gridCoherent().getRows().size(); i++)
		{
			cRow = form.container1().gridCoherent().getRows().get(i);
			if(cRow.getcolStatus() != null)
			{
				CommunicationUnderstanding speech = cRow.getValue();
				if (speech == null)
					speech = new CommunicationUnderstanding();
				speech.setSpeechAndLanguageUnderstanding(cRow.getcolQuest());
				speech.setStatus(cRow.getcolStatus());
				sluColl.add(speech);
			}
		}	
		
		voCommSpeechAndLang.setSpeechAndLanguageUnderstanding(sluColl);
		voAssessCommunication.setSpeechAndLanguage(voCommSpeechAndLang);

		//Vision	
		if(voCommVision == null)
			voCommVision = new CommunicationVisionVo();	
		voCommVision.setVisualImpairment(form.container1().ansVisImpair().getValue());
		voCommVision.setWearGlasses(form.container1().ansGlasses().getValue());		
		voCommVision.setWearLenses(form.container1().ansWearLenses().getValue());
		voCommVision.setRegisteredBlind(form.container1().ansRegBlind().getValue());
		voCommVision.setYearLastEyeTest(form.container1().intYearLastEyeTest().getValue());
		voCommVision.setEffectedEyes(form.container1().comboBoxEyes().getValue());
		voCommVision.setNumberOfGlasses(form.container1().intNoGlasses().getValue());
		voCommVision.setOther(form.container1().txtOther().getValue());
		voAssessCommunication.setVision(voCommVision);
		
		//Hearing
		if(voCommHearing == null)
			voCommHearing = new CommunicationHearingVo();
		voCommHearing.setHearingImpairment(form.container1().ansHearingImp().getValue());
		voCommHearing.setHearingAid(form.container1().ansHearingAid().getValue());
		voCommHearing.setHearingAidWithPatientOnAdmission(form.container1().ansHearingAidAdmission().getValue());
		voCommHearing.setBatteriesInOrder(form.container1().ansBatteries().getValue());
		voCommHearing.setEffectedEars(form.container1().comboBoxEars().getValue());
		voCommHearing.setYearLastHearingTest(form.container1().intYearLastHearTest().getValue());
		voAssessCommunication.setHearing(voCommHearing);
					
		try
		{
			String[] messages = voAssessCommunication.validate();
			if (messages != null)
			{
				engine.showErrors("Error occurred Creating Assessment Communication Component. ", messages);
			 	return;
			}
						
			AssessmentHeaderInfo newAssmnt = form.getLocalContext().getassmnt();
			
			if (newAssmnt.getCareContext() == null)
				newAssmnt.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
			if (newAssmnt.getClinicalContact() == null)
				newAssmnt.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
			newAssmnt = domain.saveComponent(newAssmnt, voAssessCommunication);
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(newAssmnt);
		}
		catch(StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			// We may need to reset the current component value in GC for onFormOpen - if there was none previously
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(domain.getAssessment(form.getGlobalContext().Core.getCurrentCareContext()));	
			open();
			return;				
		} 
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("A Communication Assessment record already exists. " + e.getMessage());
			open();
			return;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			form.getGlobalContext().Nursing.setAssessmentHeaderInfo(domain.getAssessment(form.getGlobalContext().Core.getCurrentCareContext()));	
			open();
			return;	
		}
		
		// If the careplan grid is not readonly, we may need to go to the careplanstep2 form
		if (form.container1().gridCarePlan().getReadOnly() == false)
		{
			CarePlanTemplateTitleCollection templList = new CarePlanTemplateTitleCollection();
			GenForm.container1Container.gridCarePlanRow cpRow;
			for (int i=0; i<form.container1().gridCarePlan().getRows().size(); i++)
			{
				cpRow = form.container1().gridCarePlan().getRows().get(i);
				if (cpRow.getcolSelected() && !cpRow.isReadOnly())
					templList.add(cpRow.getValue());
			}
			if (templList.size() > 0)
			{
				form.getGlobalContext().COE.CarePlan.setTemplateList(templList);
				engine.open(form.getForms().Nursing.CarePlanStep2);
			}
			else
				engine.open(form.getForms().Nursing.AdmissionAssessOverview);
		}
		else
			engine.open(form.getForms().Nursing.AdmissionAssessOverview);
	}
	
	
	protected void onAnsHearingImpValueChanged() throws PresentationLogicException
	{
		if(form.container1().ansHearingImp().getValue() != null && form.container1().ansHearingImp().getValue().equals(YesNoUnknown.NO))
		{
			if (form.getMode().equals(FormMode.EDIT))
			{	
				form.container1().comboBoxEars().setEnabled(false);
				form.container1().ansHearingAid().setEnabled(false);
				form.container1().ansHearingAidAdmission().setEnabled(false);
				form.container1().ansBatteries().setEnabled(false);
			
				form.container1().comboBoxEars().setValue(null);
				form.container1().ansHearingAid().setValue(null);
				form.container1().ansHearingAidAdmission().setValue(null);
				form.container1().ansBatteries().setValue(null);
			}
			
		}
		else
		{
			if (form.getMode().equals(FormMode.EDIT))
			{
				form.container1().comboBoxEars().setEnabled(true);
				form.container1().ansHearingAid().setEnabled(true);
				form.container1().ansHearingAidAdmission().setEnabled(true);
				form.container1().ansBatteries().setEnabled(true);
			}
		}
	}
	protected void onAnsVisImpairValueChanged() throws PresentationLogicException
	{
		if(form.container1().ansVisImpair().getValue() != null && form.container1().ansVisImpair().getValue().equals(YesNoUnknown.NO))
		{
			if (form.getMode().equals(FormMode.EDIT))
			{	
				form.container1().comboBoxEyes().setEnabled(false);
				form.container1().ansGlasses().setEnabled(false);
				form.container1().intNoGlasses().setEnabled(false);
				form.container1().ansWearLenses().setEnabled(false);
				form.container1().txtOther().setEnabled(false);
				form.container1().ansRegBlind().setEnabled(false);
			
				form.container1().comboBoxEyes().setValue(null);
				form.container1().ansGlasses().setValue(null);
				form.container1().intNoGlasses().setValue(null);
				form.container1().ansWearLenses().setValue(null);
				form.container1().txtOther().setValue(null);
				form.container1().ansRegBlind().setValue(null);
			}
		}
		else
		{
			if (form.getMode().equals(FormMode.EDIT))
			{
				form.container1().comboBoxEyes().setEnabled(true);
				form.container1().ansGlasses().setEnabled(true);
				form.container1().intNoGlasses().setEnabled(true);
				form.container1().ansWearLenses().setEnabled(true);
				form.container1().txtOther().setEnabled(true);
				form.container1().ansRegBlind().setEnabled(true);
			}
		}
	}
}
