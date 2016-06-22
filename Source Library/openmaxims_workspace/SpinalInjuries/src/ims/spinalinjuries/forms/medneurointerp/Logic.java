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
//This code was generated by Billy Mahon using IMS Development Environment (version 1.22 build 50124.900)
//Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.
//10/03/05 - AU - checks for null as a Java null pointer exception reported
//11/03/05 - AU - fix asia scores problem - the "N" score is saved as -1 in the database - when counting should be 0 
package ims.spinalinjuries.forms.medneurointerp;

import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.MotorChartAreaDetailVo;
import ims.core.vo.VertebrallevelVoCollection;
import ims.core.vo.lookups.ContactType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.generalmedical.vo.AdmisNeuroInterpretVo;
import ims.generalmedical.vo.NeuroInterpretShortVo;
import ims.generalmedical.vo.NeuroInterpretShortVoCollection;
import ims.generalmedical.vo.NeuroInterpretVo;
import ims.generalmedical.vo.NeuroMotorAreaFindingVo;
import ims.generalmedical.vo.NeuroMotorAreaFindingVoCollection;
import ims.generalmedical.vo.NeuroMotorExaminationVo;
import ims.generalmedical.vo.NeuroMotorFindingsVo;
import ims.generalmedical.vo.NeuroMotorRootValueVo;
import ims.generalmedical.vo.NeuroMotorRootValueVoCollection;
import ims.generalmedical.vo.NeuroSensationExaminationVo;
import ims.vo.ValueObject;

import java.util.ArrayList;
import java.util.Comparator;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}

	private void initialize()
	{
		loadVertebralCombos();
		
		ClinicalContactShortVo currentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		Boolean bMedicalAdmissionContactSelected = new Boolean(currentClinicalContact!=null && currentClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION));
		Boolean bMedicalInpatientForm = new Boolean(engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroInterpInpatient));
		
		form.getLocalContext().setMedicalAdmissionContactSelected(bMedicalAdmissionContactSelected);
		form.getLocalContext().setIsMedicalInpatientForm(bMedicalInpatientForm);
		displayRecordBrowser(bMedicalInpatientForm.booleanValue());
		
		if(writeConditionsApply(bMedicalInpatientForm,	bMedicalAdmissionContactSelected))
			activateButtons(true);
		else
			activateButtons(false);
		
		form.ccAuthoring().setIsRequiredPropertyToControls(true); //WDEV-15172
	}
	/**
	 * inpatient form writable when Spinal Medical Admission contact NOT selected
	 * admission form writable when Spinal Medical Admission contact IS selected
	 * @param  bMedicalInpatientForm, currentClinicalContact
	 * @return boolean
	 */		
	private boolean writeConditionsApply(Boolean bMedicalInpatientForm, Boolean bMedicalAdmissionContactSelected) {
	
		if(bMedicalInpatientForm.booleanValue()){
			
			if(bMedicalAdmissionContactSelected.booleanValue())
				return false;
			else
				return true;
		}
		else{
			if(bMedicalAdmissionContactSelected.booleanValue())
				return true;
			else
				return false;
		}
	}
	private void activateButtons(boolean activate)
	{
		form.btnNew().setVisible(activate);
		form.btnNew().setEnabled(activate);
		form.btnUpdate().setVisible(activate);
		form.btnUpdate().setEnabled(activate);
	}
	private void open() 
	{
		form.setMode(FormMode.VIEW);
		form.getLocalContext().setvoNeuroInterpret(null);

		clearScreen();
		
		if(engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroInterp))
		{
			ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			
			if(voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION))
			{
				form.getLocalContext().setvoNeuroMotorExam(domain.getNeuroMotorRecord(form.getGlobalContext().Core.getCurrentClinicalContact()));	
				form.getLocalContext().setvoNeuroSensationExamination(domain.getNeuroSensationExamination(form.getGlobalContext().Core.getCurrentClinicalContact()));
				form.getLocalContext().setAdmisNeuroInterpretVo(domain.getAdmisNeuroInterpret(form.getGlobalContext().Core.getCurrentClinicalContact(), null));
			}
			else
			{
				form.getLocalContext().setvoNeuroMotorExam(domain.getSpinalMedicalAdmissionMotorByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));	
				form.getLocalContext().setvoNeuroSensationExamination(domain.getSpinalMedicalAdmissionSensationByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));
				form.getLocalContext().setAdmisNeuroInterpretVo(domain.getSpinalMedicalAdmissionInterpretByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));
			}
			populateScreenFromData();
		}
		else
		{
			fillRecordBrowser();
		}
		displayFrankelAndAsiaDetails();
	}
	private void populateScreenFromData() 
	{
		AdmisNeuroInterpretVo voAdmisNeuroInterpret = form.getLocalContext().getAdmisNeuroInterpretVo();
		
		if(voAdmisNeuroInterpret != null)
		{
			form.getLocalContext().setvoNeuroInterpret(voAdmisNeuroInterpret.getNeuroInterpret());
			ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			if(voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION) &&
					!engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroInterpInpatient))
			{
			
				if(voAdmisNeuroInterpret.getNeuroInterpret() == null)
				{
					populateContactInfo(null);
					form.btnNew().setVisible(true);
					form.btnNew().setEnabled(true);
					form.btnUpdate().setVisible(false);
					return;
				}
				else
				{
					form.btnNew().setVisible(true);
					form.btnNew().setEnabled(false);
					form.btnUpdate().setVisible(true);
				}
			}
		
			if (voAdmisNeuroInterpret.getNeuroInterpretIsNotNull())	
			{
				populateContactInfo(voAdmisNeuroInterpret.getNeuroInterpret());
				if (voAdmisNeuroInterpret.getNeuroInterpret().getAsiaGradeIsNotNull())//	WDEV-11677
					form.cmbAsiaGrade().setValue(voAdmisNeuroInterpret.getNeuroInterpret().getAsiaGrade());//	WDEV-11677
				if (voAdmisNeuroInterpret.getNeuroInterpret().getSpinalSyndromeIsNotNull())
					form.cmbSpineSynd().setValue(voAdmisNeuroInterpret.getNeuroInterpret().getSpinalSyndrome());
				if (voAdmisNeuroInterpret.getNeuroInterpret().getOverallNeuroLevelIsNotNull())
					form.cmbOverallNeuro().setValue(voAdmisNeuroInterpret.getNeuroInterpret().getOverallNeuroLevel());
				if (voAdmisNeuroInterpret.getNeuroInterpret().getCompleteIncompleteIsNotNull())				
					form.cmbCompleteInComp().setValue(voAdmisNeuroInterpret.getNeuroInterpret().getCompleteIncomplete());
			}
		}
	}

	private void displayFrankelAndAsiaDetails() 
	{
		form.txtFrankel().setValue(null);
		//form.txtAsiaScore().setValue(null);
		//form.txtAsiaScoreLL().setValue(null);
		form.txtLowerLimbLeft().setValue(null);
		form.txtLowerLimbRight().setValue(null);
		form.txtUpperLimbLeft().setValue(null);
		form.txtUpperLimbRight().setValue(null);
		form.txtASIAOverallScore().setValue(null);
		
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION))
		{
			form.getLocalContext().setvoNeuroMotorExam(domain.getNeuroMotorRecord(form.getGlobalContext().Core.getCurrentClinicalContact()));	
			form.getLocalContext().setvoNeuroSensationExamination(domain.getNeuroSensationExamination(form.getGlobalContext().Core.getCurrentClinicalContact()));
		}
		else
		{
			form.getLocalContext().setvoNeuroMotorExam(domain.getSpinalMedicalAdmissionMotorByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));	
			form.getLocalContext().setvoNeuroSensationExamination(domain.getSpinalMedicalAdmissionSensationByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));
		}
		
		NeuroMotorExaminationVo voMotorExam = form.getLocalContext().getvoNeuroMotorExam(); 
		NeuroSensationExaminationVo voNeuroSensationExamination = form.getLocalContext().getvoNeuroSensationExamination();

		if(voMotorExam != null && voMotorExam.getNeuroMotorIsNotNull())
		{
			NeuroMotorFindingsVo voFindings = voMotorExam.getNeuroMotor();
			int intTotalAsiaScore   = -1;
			int intTotalAsiaLLScore = -1;
			if(voFindings != null)
			{
				if (voFindings.getRootFindingIsNotNull() && voFindings.getRootFinding().size() > 0)
				{
					populateAsiaScoreRootFindings(voFindings.getRootFinding());
				}
				else
				{
					populateAsiaScoreMotorAreaFindings(voFindings.getMotorAreaFindings());
				}
			}
		}
		if (voNeuroSensationExamination!=null && voNeuroSensationExamination.getNeuroSensIsNotNull())
		{
			if (voNeuroSensationExamination.getNeuroSens().getFrankleGrade() != null)
				form.txtFrankel().setValue(voNeuroSensationExamination.getNeuroSens().getFrankleGradeIsNotNull()?voNeuroSensationExamination.getNeuroSens().getFrankleGrade().toString():"");
		}
	}

	private void clearScreen() 
	{
		form.ccAuthoring().setValue(null); //WDEV-15172
		form.cmbSpineSynd().setValue(null);
		form.cmbOverallNeuro().setValue(null);
		form.cmbAsiaGrade().setValue(null);//	WDEV-11677
		form.cmbCompleteInComp().setValue(null);
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		
		if(engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroInterpInpatient))
		{
			form.getLocalContext().setAdmisNeuroInterpretVo(null);
			form.getLocalContext().setvoNeuroInterpret(null);
			clearScreen();
			form.ccAuthoring().initializeComponent(true,null); //WDEV-15172
		}
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		AdmisNeuroInterpretVo voAdmisNeuroInterpret = form.getLocalContext().getAdmisNeuroInterpretVo();  	 
		if (voAdmisNeuroInterpret == null)
		{
			voAdmisNeuroInterpret = new AdmisNeuroInterpretVo();
		}
		
		NeuroInterpretVo voNeuroInterpret;
		if ((voNeuroInterpret = voAdmisNeuroInterpret.getNeuroInterpret()) == null)
		{
			voNeuroInterpret = new NeuroInterpretVo();
		}
		
		if (form.txtFrankel().getValue() != null)
			voAdmisNeuroInterpret.setFrankleGrade(form.txtFrankel().getValue());
		if (form.txtASIAOverallScore().getValue() != null)
			voAdmisNeuroInterpret.setTotalAsiaScore(form.txtASIAOverallScore().getValue());
		if (form.txtLowerLimbLeft().getValue() != null)
			voAdmisNeuroInterpret.setLowerLimbAsiaLeft(form.txtLowerLimbLeft().getValue());
		if(form.txtLowerLimbRight().getValue() != null)
			voAdmisNeuroInterpret.setLowerLimbAsiaRight(form.txtLowerLimbRight().getValue());
		if(form.txtUpperLimbLeft().getValue() != null)
			voAdmisNeuroInterpret.setUpperLimbAsiaLeft(form.txtUpperLimbLeft().getValue());
		if(form.txtUpperLimbRight().getValue() != null)
			voAdmisNeuroInterpret.setUpperLimbAsiaRight(form.txtUpperLimbRight().getValue());
			
		//WDEV-15172
		if (form.ccAuthoring().getValue() != null)
		{
			voNeuroInterpret.setAuthoringDateTime(form.ccAuthoring().getValue().getAuthoringDateTime());  
			voNeuroInterpret.setAuthoringCP(form.ccAuthoring().getValue().getAuthoringHcp());
		}
		
		voNeuroInterpret.setAsiaGrade(form.cmbAsiaGrade().getValue());//	WDEV-11677
		voNeuroInterpret.setSpinalSyndrome(form.cmbSpineSynd().getValue());
		voNeuroInterpret.setOverallNeuroLevel(form.cmbOverallNeuro().getValue());
		voNeuroInterpret.setCompleteIncomplete(form.cmbCompleteInComp().getValue());
		
		voNeuroInterpret.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		voNeuroInterpret.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		voAdmisNeuroInterpret.setNeuroInterpret(voNeuroInterpret);
		
		if ( !validateUIRules() ) //WDEV-15172
		{
			return;
		}
		
		String[] errors = voAdmisNeuroInterpret.validate();
		
		if(errors != null)
		{	
			engine.showErrors("Validation Errors", errors);
			return;
		}
		
		try 
		{
			voAdmisNeuroInterpret = domain.saveAdmisNeuroInterpret(voAdmisNeuroInterpret, form.getGlobalContext().Core.getCurrentClinicalContact());
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		} catch (UniqueKeyViolationException e) {
			engine.showMessage("A Neurological Interpretation record already exists for this clinical contact. " + e.getMessage());
			open();
			return;
		}

		open();
	}

	private boolean validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if(form.ccAuthoring().getValue() == null)
		{
			listOfErrors.add(form.ccAuthoring().getErrors());
		}
			

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void populateContactInfo(NeuroInterpretVo voNeuroInter) 
	{
		if(voNeuroInter != null)
		{
			//WDEV-15172
			AuthoringInformationVo authoringInfo = new AuthoringInformationVo(); 
			authoringInfo.setAuthoringHcp(voNeuroInter.getAuthoringCP());
			authoringInfo.setAuthoringDateTime(voNeuroInter.getAuthoringDateTime());
			form.ccAuthoring().setValue(authoringInfo);
			return;
		}
		//WDEV-18846 - start
		boolean isLoggedOnUserHCP = domain.getHcpLiteUser() != null;
		if (isLoggedOnUserHCP)
		{
			form.ccAuthoring().initializeComponent(true,null);
		}
		else
		{
			if (form.getGlobalContext().Core.getCurrentClinicalContact() != null)
			{
				form.ccAuthoring().initializeComponent(false,true); //WDEV-15172 
			}
		}
		//---------- end WDEV-18846
	}	
	
	private void loadVertebralCombos() 
	{
		form.cmbOverallNeuro().clear();
		
		VertebrallevelVoCollection voCollVertebral = domain.listVertebralLevel(Boolean.TRUE);	
		for(int i=0;i<voCollVertebral.size();i++)
		{
			form.cmbOverallNeuro().newRow(voCollVertebral.get(i), voCollVertebral.get(i).getName());
		}
	}

	protected void onRecbrInterpretValueChanged() throws PresentationLogicException
	{
		browseRecord();
	}
	private void displayRecordBrowser(boolean visible)
	{
		form.recbrInterpret().setVisible(visible);
		form.lblBrowseStatus().setVisible(visible);
		form.panel1().setVisible(!visible);
	}
	private void fillRecordBrowser()
	{
		form.recbrInterpret().clear();
		NeuroInterpretShortVoCollection collVoNeuroInterpretShort = domain.listNeuroInterpretByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		loadCareContextRecords(collVoNeuroInterpretShort);
		
		sortNeuroSensation(collVoNeuroInterpretShort);
			
		checkForSelectedClinicalContact();
			
		setRecordBrowser();
		browseRecord();
	}
	private void loadCareContextRecords(NeuroInterpretShortVoCollection collVoNeuroInterpretShort)
	{
		CareContextShortVo voCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		
		if(form.getGlobalContext().Core.getCurrentClinicalContact() == null)
		{
			form.recbrInterpret().newRow(voCareContext, "Care Context:    " + voCareContext.getStartDateTime() + " - " + voCareContext.getEpisodeOfCare().getResponsibleHCP(), Color.Green);
			loadCareContextInterpretRecords(collVoNeuroInterpretShort, Color.Green);
			form.recbrInterpret().setValue(voCareContext);
		}
		else
		{
			form.recbrInterpret().newRow(voCareContext, "Care Context:    " + voCareContext.getStartDateTime() + " - " + voCareContext.getEpisodeOfCare().getResponsibleHCP());
			loadCareContextInterpretRecords(collVoNeuroInterpretShort, null);
		} 
	}
	private void loadCareContextInterpretRecords(NeuroInterpretShortVoCollection collVoNeuroInterpretShort, Color activeColor) 
	{
		if(collVoNeuroInterpretShort != null)
		{
			for(int i=0; i<collVoNeuroInterpretShort.size(); i++)
			{
				NeuroInterpretShortVo voNeuroInterpret = collVoNeuroInterpretShort.get(i);
				if(voNeuroInterpret.getClinicalContact() == null)
				{
					form.recbrInterpret().newRow(voNeuroInterpret, "\t\t\t\t "+ voNeuroInterpret.getAuthoringDateTime() + " - " + voNeuroInterpret.getCareContext().getEpisodeOfCare().getResponsibleHCP(), activeColor);
				}
			}
		}
	}

	private void sortNeuroSensation(NeuroInterpretShortVoCollection collVoNeuroInterpretShort)
	{
		if(collVoNeuroInterpretShort != null)
		{
			int x = 0;
			for(x = 0; x < collVoNeuroInterpretShort.size(); x++)
			{
				NeuroInterpretShortVoCollection collVoNeuroInterpretShortForClinicalContact = new NeuroInterpretShortVoCollection();
				if(collVoNeuroInterpretShort.get(x).getClinicalContact() != null)
				{
					ClinicalContactShortVo voClinicalContact = collVoNeuroInterpretShort.get(x).getClinicalContact();
					
					for(int i =0; i<collVoNeuroInterpretShort.size(); i++)
					{
						if(collVoNeuroInterpretShort.get(i).getClinicalContact() != null)
						{
							if(collVoNeuroInterpretShort.get(i).getClinicalContact().getID_ClinicalContact().equals(voClinicalContact.getID_ClinicalContact()))
							{
								collVoNeuroInterpretShortForClinicalContact.add(collVoNeuroInterpretShort.get(i));
								x = i;
							}
						}
					}
					loadClinicalContactInterpretRecords(voClinicalContact, collVoNeuroInterpretShortForClinicalContact);
				}
			}
		}
	}

	private void loadClinicalContactInterpretRecords(ClinicalContactShortVo voClinicalContact, NeuroInterpretShortVoCollection collVoNeuroInterpretShort)
	{
		boolean isClinicalContactSelected = checkCurrentClinicalContact(voClinicalContact);
		
		Color textColour = null;
		if(isClinicalContactSelected)
			textColour = Color.Green;
		
		form.recbrInterpret().newRow(voClinicalContact, "Clinical Contact: " + voClinicalContact.getStartDateTime() + " - " + voClinicalContact.getSeenBy(), textColour);
		
		if(isClinicalContactSelected)
			form.recbrInterpret().setValue(voClinicalContact);
		
		for(int i=0; i<collVoNeuroInterpretShort.size(); i++)
		{
			NeuroInterpretShortVo voNeuroInterpretShort = collVoNeuroInterpretShort.get(i);
			form.recbrInterpret().newRow(voNeuroInterpretShort, "\t\t\t\t " + voNeuroInterpretShort.getAuthoringDateTime() + " - " + voNeuroInterpretShort.getClinicalContact().getSeenBy(), textColour);
		}
	}
	
	private void checkForSelectedClinicalContact()
	{
		// the selected Clinical Contact that has been selected from Patient Summary may not have a record and therefore 
		// must be added to the record browser
		boolean clinicalContactFound = false;
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voSelectedClinicalContact != null)
		{
			for(int i =0; i< form.recbrInterpret().size(); i++)
			{
				ValueObject vo = (ValueObject) form.recbrInterpret().getValues().get(i);
				if(vo instanceof ClinicalContactShortVo)
				{
					ClinicalContactShortVo voClinicalContact = (ClinicalContactShortVo) form.recbrInterpret().getValues().get(i);
					if(voClinicalContact.equals(voSelectedClinicalContact))
						clinicalContactFound = true;
				}
			}
			if(!clinicalContactFound)
			{
				form.recbrInterpret().newRow(voSelectedClinicalContact, "Clinical Contact: " + voSelectedClinicalContact.getStartDateTime() + " - " + voSelectedClinicalContact.getSeenBy(), Color.Green);
				form.recbrInterpret().setValue(voSelectedClinicalContact);
			}
		}
	}
	private boolean checkCurrentClinicalContact(ClinicalContactShortVo voClinicalContact)
	{
		// checks if this Clinical Contact is the selected Clinical Contact from Patient Summary
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		if(voSelectedClinicalContact != null)
		{
			if(voSelectedClinicalContact.equals(voClinicalContact))
				return true;
			else
				return false;
		}
		return false;
	}
	private void setRecordBrowser()
	{
		//after an update need to set the record browser to display the updated record
		if(form.getLocalContext().getUpdatedInstanceIsNotNull())
		{
			form.recbrInterpret().setValue(form.getLocalContext().getUpdatedInstance());
			browseRecord();
		}
	}
	private void browseRecord()
	{
		clearScreen();
		updateBrowseInformation();
			
		if(form.recbrInterpret().getValue() != null)
		{			
			if(form.recbrInterpret().getValue() instanceof ClinicalContactShortVo)
			{
				form.getLocalContext().setAdmisNeuroInterpretVo(domain.getAdmisNeuroInterpret((ClinicalContactShortVo) form.recbrInterpret().getValue(), null));
			}
			else if(form.recbrInterpret().getValue() instanceof NeuroInterpretShortVo)
			{
				NeuroInterpretShortVo voNeuroInterpret = (NeuroInterpretShortVo) form.recbrInterpret().getValue();
				if(voNeuroInterpret.getClinicalContact() == null)
					form.getLocalContext().setAdmisNeuroInterpretVo(domain.getAdmisNeuroInterpretByCareContext(voNeuroInterpret.getCareContext(), voNeuroInterpret));
				else
					form.getLocalContext().setAdmisNeuroInterpretVo(domain.getAdmisNeuroInterpret(voNeuroInterpret.getClinicalContact(), voNeuroInterpret));
			}
			else
				form.getLocalContext().setAdmisNeuroInterpretVo(domain.getAdmisNeuroInterpretByCareContext((CareContextRefVo) form.recbrInterpret().getValue(), null));

			populateScreenFromData();
		}
		checkRecordIsEditable();
	}

	private void checkRecordIsEditable()
	{
		if(form.recbrInterpret().getValue() != null)
		{
			CareContextShortVo voCurrentCareContext = form.getGlobalContext().Core.getCurrentCareContext();
			ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			
			if(form.recbrInterpret().getValue() instanceof CareContextShortVo)						//wdev-13064
			{
				CareContextShortVo voSelectedCareContext = (CareContextShortVo) form.recbrInterpret().getValue();
				if(voSelectedCareContext.getID_CareContext().equals(voCurrentCareContext.getID_CareContext()) && form.getGlobalContext().Core.getCurrentClinicalContact() == null)
					activateButtons(true);
				else
					activateButtons(false);
			}
			else if(form.recbrInterpret().getValue() instanceof NeuroInterpretShortVo)
			{
				NeuroInterpretShortVo voNeuroInterpretShort = (NeuroInterpretShortVo) form.recbrInterpret().getValue();
				if(voNeuroInterpretShort.getClinicalContact()== null)
				{
					CareContextRefVo voSelectedCareContext = voNeuroInterpretShort.getCareContext();
					if(voSelectedCareContext.getID_CareContext().equals(voCurrentCareContext.getID_CareContext()) && form.getGlobalContext().Core.getCurrentClinicalContact() == null)
					{
						activateButtons(true);
					}
					else
						activateButtons(false);
				}
				else
				{
					
					ClinicalContactShortVo voSelectedClinicalContact = voNeuroInterpretShort.getClinicalContact();
					if(voCurrentClinicalContact != null)
					{
						if(voSelectedClinicalContact.getID_ClinicalContact().equals(voCurrentClinicalContact.getID_ClinicalContact()))
						{
							activateButtons(true);
							form.btnNew().setEnabled(false);
						}
						else
							activateButtons(false);
					}
					if(voSelectedClinicalContact!=null)
						form.btnNew().setEnabled(false);
				}
			}
			else
			{
				ClinicalContactShortVo voSelectedClinicalContact = (ClinicalContactShortVo) form.recbrInterpret().getValue();
				if(voCurrentClinicalContact != null)
				{
					if(voSelectedClinicalContact.getID_ClinicalContact().equals(voCurrentClinicalContact.getID_ClinicalContact()))
						activateButtons(true);
					else
						activateButtons(false);
				}
				else
					activateButtons(false);
				
				//Disable new if record exists for clinical contact
				if(form.getLocalContext().getAdmisNeuroInterpretVoIsNotNull() && form.getLocalContext().getAdmisNeuroInterpretVo().getNeuroInterpretIsNotNull() && voCurrentClinicalContact!=null){
					NeuroInterpretVo voNeuroInterpret = form.getLocalContext().getAdmisNeuroInterpretVo().getNeuroInterpret();
					if(voNeuroInterpret.getClinicalContactIsNotNull() && voNeuroInterpret.getClinicalContact().getID_ClinicalContact().equals(voCurrentClinicalContact.getID_ClinicalContact()))
						form.btnNew().setEnabled(false);
				}
			}
		}
		checkForSensationRecord();
		isRecordOfTypeMedicalAdmission();
	}

	private void isRecordOfTypeMedicalAdmission()
	{
		ClinicalContactShortVo voCurrentClinical = form.getGlobalContext().Core.getCurrentClinicalContact();
		if(voCurrentClinical != null)
		{
			if(voCurrentClinical.getContactType().equals(ContactType.SPINALMEDICALADMISSION))
				activateButtons(false);
		}
	}

	private void checkForSensationRecord()
	{
		if(form.getLocalContext().getAdmisNeuroInterpretVoIsNotNull())
		{
			if(form.getLocalContext().getAdmisNeuroInterpretVo().getNeuroInterpret() == null)
				form.btnUpdate().setVisible(false);
		}
	}

	private void updateBrowseInformation()
	{
		form.lblBrowseStatus().setValue(form.recbrInterpret().getRecordState("Assessment", "Assessments"));
	}

	protected void onFormModeChanged()
	{
		if(form.getMode().equals(FormMode.VIEW))
			form.recbrInterpret().setEnabled(true);
		else
			form.recbrInterpret().setEnabled(false);	
		
		//WDEV-15172
		form.ccAuthoring().setEnabledAuthoringHCP(form.getMode().equals(FormMode.EDIT)); //WDEV-18846
		form.ccAuthoring().setEnabledDateTime(form.getMode().equals(FormMode.EDIT));	//WDEV-18846
	}

	private void populateAsiaScoreMotorAreaFindings(NeuroMotorAreaFindingVoCollection motorcol)
	{
		int scoreUpperRight = 0;
		int scoreUpperLeft = 0;

		int scoreLowerRight = 0;
		int scoreLowerLeft = 0;

					
		if(motorcol != null)
		{
			motorcol.sort(new FindingsAndMotorChartComparator());
			// Calculate scores
			for (int i = 0; i < motorcol.size(); i++)
			{
										
				NeuroMotorAreaFindingVo motorAreaFinding =  motorcol.get(i);
				
				if(motorAreaFinding == null)
					continue;
				
				if(motorAreaFinding.getLeftFindingIsNotNull())
				{
					int score = motorAreaFinding.getLeftFinding();
					
					if (score < 0 || score > 5)
						score = 0;
	
					if (motorAreaFinding.getMotorArea().getIsLowerLimb())
						scoreLowerLeft += score;
					
					if (motorAreaFinding.getMotorArea().getIsUpperLimb())
						scoreUpperLeft += score;
				}	
				
				if(motorAreaFinding.getRightFindingIsNotNull())
				{
					int score = motorAreaFinding.getRightFinding();
							
					if (score < 0 || score > 5)
						score = 0;
	
					if (motorAreaFinding.getMotorArea().getIsLowerLimb())
						scoreLowerRight += score;
					
					if (motorAreaFinding.getMotorArea().getIsUpperLimb())
						scoreUpperRight += score;
				}
				
			}
		
		}
		displayAsiaScores(scoreUpperRight,scoreUpperLeft,scoreLowerRight, scoreLowerLeft );
				
	}
	private void populateAsiaScoreRootFindings(NeuroMotorRootValueVoCollection rootcol)
	{
		int scoreUpperRight = 0;
		int scoreUpperLeft = 0;

		int scoreLowerRight = 0;
		int scoreLowerLeft = 0;
		
		
		// Calculate scores
		if(rootcol != null)
		{
			rootcol.sort(new FindingsAndMotorChartComparator()); //sort collection like in neurologicalexaminationmotor form , compute of score is like in neurologicalexaminationmotor form
			for (int i = 0; i < rootcol.size(); i++)
			{
				NeuroMotorRootValueVo motorFinding = rootcol.get(i);
				
				if(motorFinding == null)
					continue;
	
					
				if (motorFinding.getLeftFindingIsNotNull() )
				{
					int score = motorFinding.getLeftFinding();
						
					if (score < 0 || score > 5)
						score = 0;

					if (motorFinding.getRootValue().getIsLLAsiaScore())
						scoreLowerLeft += score;
						
					if (motorFinding.getRootValue().getIsULAsiaScore())
						scoreUpperLeft += score;
					
				}
							
				
				if (motorFinding.getRightFindingIsNotNull())
				{
					
					int score = motorFinding.getRightFinding();
					
					if (score < 0 || score > 5)
						score = 0;
					
					if (motorFinding.getRootValue().getIsLLAsiaScore())
						scoreLowerRight += score;
					
					if (motorFinding.getRootValue().getIsULAsiaScore())
						scoreUpperRight += score;
					
					
				}
			}
		}
		displayAsiaScores(scoreUpperRight,scoreUpperLeft,scoreLowerRight, scoreLowerLeft );
		
		
	}
	private void displayAsiaScores(int scoreUpperRight,int scoreUpperLeft,int scoreLowerRight, int scoreLowerLeft )
	{
		form.txtUpperLimbLeft().setValue(String.valueOf(scoreUpperLeft));
		form.txtUpperLimbRight().setValue(String.valueOf(scoreUpperRight));
		
		form.txtLowerLimbLeft().setValue(String.valueOf(scoreLowerLeft));
		form.txtLowerLimbRight().setValue(String.valueOf(scoreLowerRight));
		
		form.txtASIAOverallScore().setValue(String.valueOf(scoreUpperLeft + scoreUpperRight + scoreLowerLeft + scoreLowerRight));
	}
	private class FindingsAndMotorChartComparator implements Comparator<Object>
	{
		public int compare(Object arg0, Object arg1)
		{
			if (arg0 instanceof NeuroMotorRootValueVo && arg1 instanceof NeuroMotorRootValueVo)
			{
				if (!((NeuroMotorRootValueVo) arg0).getRootValueIsNotNull() || !((NeuroMotorRootValueVo)arg1).getRootValueIsNotNull())
					return 0;
				
				if (!((NeuroMotorRootValueVo) arg0).getRootValue().getOrderNoIsNotNull() || !((NeuroMotorRootValueVo) arg1).getRootValueIsNotNull())
					return 0;
				
				return ((NeuroMotorRootValueVo)arg0).getRootValue().getOrderNo().compareTo(((NeuroMotorRootValueVo)arg1).getRootValue().getOrderNo());
			}
			
			if (arg0 instanceof NeuroMotorAreaFindingVo && arg1 instanceof NeuroMotorAreaFindingVo)
			{
				if (!((NeuroMotorAreaFindingVo) arg0).getMotorAreaIsNotNull() || !((NeuroMotorAreaFindingVo) arg1).getMotorAreaIsNotNull())
					return 0;
				
				if (!((NeuroMotorAreaFindingVo) arg0).getMotorArea().getOrderNoIsNotNull() || !((NeuroMotorAreaFindingVo) arg1).getMotorArea().getOrderNoIsNotNull())
					return 0;
				
				return ((NeuroMotorAreaFindingVo) arg0).getMotorArea().getOrderNo().compareTo(((NeuroMotorAreaFindingVo) arg1).getMotorArea().getOrderNo());
			}
			
			if (arg0 instanceof MotorChartAreaDetailVo && arg1 instanceof MotorChartAreaDetailVo)
			{
				if (!((MotorChartAreaDetailVo) arg0).getOrderNoIsNotNull() || !((MotorChartAreaDetailVo) arg1).getOrderNoIsNotNull())
					return 0;
				
				return ((MotorChartAreaDetailVo) arg0).getOrderNo().compareTo(((MotorChartAreaDetailVo)arg1).getOrderNo());
			}
			
			return 0;
		}	
	}


}
