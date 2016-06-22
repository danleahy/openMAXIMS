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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.22 build 41222.900)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.
//15/03/2005 - Functionality added to the Comment editor to have a consistent behaviour across the screens
package ims.spinalinjuries.forms.medneuroreflexes;

import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareContextVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.lookups.ContactType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.generalmedical.vo.MedicalProbOnAdmisVo;
import ims.generalmedical.vo.MedicalProbOnAdmisVoCollection;
import ims.generalmedical.vo.NeuroReflexAnalTestsVo;
import ims.generalmedical.vo.NeuroReflexAnalTestsVoCollection;
import ims.generalmedical.vo.NeuroReflexOtherTestsVo;
import ims.generalmedical.vo.NeuroReflexOtherTestsVoCollection;
import ims.generalmedical.vo.NeuroReflexPeripheralTestsVo;
import ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection;
import ims.generalmedical.vo.NeuroReflexesExaminationVo;
import ims.generalmedical.vo.NeuroReflexesShortVo;
import ims.generalmedical.vo.NeuroReflexesShortVoCollection;
import ims.generalmedical.vo.NeuroReflexesVo;
import ims.spinalinjuries.forms.medneuroreflexes.GenForm.grdProblemsRow;
import ims.spinalinjuries.vo.lookups.LookupHelper;
import ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests;
import ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTestsCollection;
import ims.spinalinjuries.vo.lookups.NeuroExmAnalTest;
import ims.spinalinjuries.vo.lookups.NeuroExmAnalTestCollection;
import ims.spinalinjuries.vo.lookups.NeuroExmOtherTests;
import ims.spinalinjuries.vo.lookups.NeuroExmOtherTestsCollection;
import ims.vo.ValueObject;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		open();
	}
	private void initialize()
	{
		ClinicalContactShortVo currentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		boolean bMedicalAdmissionContactSelected = (currentClinicalContact!=null && currentClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION));
		Boolean bMedicalInpatientForm = new Boolean(engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroReflexesInpatient));
		
		form.getLocalContext().setIsMedicalInpatientForm(bMedicalInpatientForm);
		displayRecordBrowser(bMedicalInpatientForm.booleanValue());
		
		if(writeConditionsApply(bMedicalInpatientForm,	bMedicalAdmissionContactSelected))
			activateButtons(true);
		else
			activateButtons(false);		
		
		displayRecordBrowser(form.getLocalContext().getIsMedicalInpatientForm().booleanValue());
		displayProblemsGrd(!form.getLocalContext().getIsMedicalInpatientForm().booleanValue());
		
		form.ccAuthoring().setIsRequiredPropertyToControls(true); //WDEV-15172
		
	}
	/**
	 * inpatient form writable when Spinal Medical Admission contact NOT selected
	 * admission form writable when Spinal Medical Admission contact IS selected
	 * @param  bMedicalInpatientForm, currentClinicalContact
	 * @return boolean
	 */		
	private boolean writeConditionsApply(Boolean bMedicalInpatientForm, boolean bMedicalAdmissionContactSelected) {
	
		if(bMedicalInpatientForm.booleanValue()){
			
			if(bMedicalAdmissionContactSelected)
				return false;
			else
				return true;
		}
		else{
			if(bMedicalAdmissionContactSelected)
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

	private void displayProblemsGrd(boolean visible)
	{
		form.grdProblems().setVisible(visible);
		form.pnlProblems().setVisible(visible);		
	}

	private void displayRecordBrowser(boolean visible)
	{
		form.recbrReflexes().setVisible(visible);
		form.lblBrowseStatus().setVisible(visible);
		form.pnlReflex().setVisible(!visible);
	}

	private void loadLookupsIntoGrids()
	{
		NeuroExamPeripheralTestsCollection neuroPeripheralTestsColl = LookupHelper.getNeuroExamPeripheralTests(domain.getLookupService());
		NeuroExmAnalTestCollection neuroAnalTestColl = LookupHelper.getNeuroExmAnalTest(domain.getLookupService());
		NeuroExmOtherTestsCollection neuroOtherTestsColl = LookupHelper.getNeuroExmOtherTests(domain.getLookupService());
		
		TreeNode[] rootNodes = null;
		ArrayList childColl = null;
	
		form.grdAnalExm().getRows().clear();
		GenForm.grdAnalExmRow rowAnal = null;
		NeuroExmAnalTest childAnalInst = null;
		rootNodes = neuroAnalTestColl.getRootNodes();
		for (int i = 0; i < rootNodes.length; i++)
		{
			NeuroExmAnalTest inst = (NeuroExmAnalTest)rootNodes[i];
			rowAnal = form.grdAnalExm().getRows().newRow();
			rowAnal.setcolTest(inst);
			for(int p=0;p<neuroAnalTestColl.size();p++)
			{
				if(neuroAnalTestColl.get(p).equals(inst))
				{
					childColl = neuroAnalTestColl.get(p).getChildInstances();
					
					for(int j=0;j<childColl.size();j++)
					{
						childAnalInst = (NeuroExmAnalTest)childColl.get(j);
						rowAnal.getcolFinding().newRow(childAnalInst, childAnalInst.getText());
					}	
				}
			}
		}	
			
		form.grdOtherTest().getRows().clear();
		GenForm.grdOtherTestRow rowOther = null;
		NeuroExmOtherTests childOtherInst = null;
		rootNodes = neuroOtherTestsColl.getRootNodes();
		for (int i = 0; i < rootNodes.length; i++)
		{
			NeuroExmOtherTests inst = (NeuroExmOtherTests)rootNodes[i];
			rowOther = form.grdOtherTest().getRows().newRow();
			rowOther.setcolModality(inst);
			
			for(int p=0;p<neuroOtherTestsColl.size();p++)
			{
				if(neuroOtherTestsColl.get(p).equals(inst))
				{
					childColl = neuroOtherTestsColl.get(p).getChildInstances();
					
					for(int j=0;j<childColl.size();j++)
					{
						childOtherInst = (NeuroExmOtherTests)childColl.get(j);
						rowOther.getcolFinding().newRow(childOtherInst, childOtherInst.getText());
					}	
				}
			}
		}

		form.grdReflexes().getRows().clear();
		GenForm.grdReflexesRow rowPeri = null;
		NeuroExamPeripheralTests childPeriInst = null;
		rootNodes = neuroPeripheralTestsColl.getRootNodes();
		for (int i = 0; i < rootNodes.length; i++)
		{
			NeuroExamPeripheralTests inst = (NeuroExamPeripheralTests)rootNodes[i];
			rowPeri = form.grdReflexes().getRows().newRow();
			rowPeri.setcolModality(inst);
	
			for(int p=0;p<neuroPeripheralTestsColl.size();p++)
			{
				if(neuroPeripheralTestsColl.get(p).equals(inst))
				{
					childColl = neuroPeripheralTestsColl.get(p).getChildInstances();
			
					for(int j=0;j<childColl.size();j++)
					{
						childPeriInst = (NeuroExamPeripheralTests)childColl.get(j);
						rowPeri.getcolLeft().newRow(childPeriInst, childPeriInst.getText());
						rowPeri.getcolRight().newRow(childPeriInst, childPeriInst.getText());
					}	
				}
			}
		}
	}
	
	private void clearScreen()
	{
		form.ccAuthoring().setValue(null); //WDEV-15172
		form.grdProblems().getRows().clear();
	}
	
	private void loadProblemsGrid(MedicalProbOnAdmisVoCollection voProbColl) 
	{
		form.grdProblems().getRows().clear();
		GenForm.grdProblemsRow row = null;
		if(voProbColl != null)
		{
			for(int i=0;i<voProbColl.size();i++)
			{
				if(voProbColl.get(i).getPatientProblem() != null)
				{
					row = form.grdProblems().getRows().newRow();
					row.setcolProblem(voProbColl.get(i).getPatientProblem());
					row.setTooltipForcolProblem(voProbColl.get(i).getPatientProblem());
					
					row.setcolProblemButton(voProbColl.get(i).getPatientProblem());
					row.setcolActive(voProbColl.get(i).getIsActive().booleanValue());
					row.setValue(voProbColl.get(i));
				}
			}
		}
	}
	
	private void open()
	{
		form.setMode(FormMode.VIEW);
		form.getLocalContext().setSelectedNeuroReflexesVo(null);
		
		clearScreen();
		loadLookupsIntoGrids();

		if(engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroReflexes))
		{
			ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			
			if(voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION))
				form.getLocalContext().setReflexRecord(domain.getNeuroReflexRecord(voClinicalContact, null));
			else
				form.getLocalContext().setReflexRecord(domain.getSpinalMedicalAdmissionReflexesByCareContext(form.getGlobalContext().Core.getCurrentCareContext()));
		
			populateScreenFromData();
		}
		else
		{
			fillRecordBrowser();
		}
	}

	private void fillRecordBrowser()
	{
		form.recbrReflexes().clear();
		
		NeuroReflexesShortVoCollection voNeuroReflexesColl = domain.listByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
		loadCareContextRecords(voNeuroReflexesColl);
				
		sortNeuroReflexes(voNeuroReflexesColl);
			
		checkForSelectedClinicalContact();
			
		setRecordBrowser();
		browseRecord();
	}

	private void checkForSelectedClinicalContact()
	{
		// the selected Clinical Contact that has been selected from Patient Summary may not have a record and therefore 
		// must be added to the record browser
		boolean clinicalContactFound = false;
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voSelectedClinicalContact != null)
		{
			for(int i =0; i< form.recbrReflexes().size(); i++)
			{
				ValueObject vo = (ValueObject) form.recbrReflexes().getValues().get(i);
				if(vo instanceof ClinicalContactShortVo)
				{
					ClinicalContactShortVo voClinicalContact = (ClinicalContactShortVo) form.recbrReflexes().getValues().get(i);
					if(voClinicalContact.equals(voSelectedClinicalContact))
						clinicalContactFound = true;
				}
			}
			
			if(!clinicalContactFound)
			{
				form.recbrReflexes().newRow(voSelectedClinicalContact, "Clinical Contact: " + voSelectedClinicalContact.getStartDateTime() + " - " + voSelectedClinicalContact.getSeenBy(), Color.Green);
				form.recbrReflexes().setValue(voSelectedClinicalContact);
			}
		}
	}

	private void sortNeuroReflexes(NeuroReflexesShortVoCollection voNeuroReflexesColl)
	{
		if(voNeuroReflexesColl != null)
		{
			int x = 0;
			for(x = 0; x < voNeuroReflexesColl.size(); x++)
			{
				NeuroReflexesShortVoCollection voNeuroReflexesCollForClinicalContact = new NeuroReflexesShortVoCollection();
				if(voNeuroReflexesColl.get(x).getClinicalContact() != null)
				{
					ClinicalContactShortVo voClinicalContact = voNeuroReflexesColl.get(x).getClinicalContact();
					
					for(int i =0; i<voNeuroReflexesColl.size(); i++)
					{
						if(voNeuroReflexesColl.get(i).getClinicalContact() != null)
						{
							if(voNeuroReflexesColl.get(i).getClinicalContact().getID_ClinicalContact().equals(voClinicalContact.getID_ClinicalContact()))
							{
								voNeuroReflexesCollForClinicalContact.add(voNeuroReflexesColl.get(i));
								x = i;
							}
						}
					}
					loadClinicalContactReflexRecords(voClinicalContact, voNeuroReflexesCollForClinicalContact);
				}
			}
		}
	}

	private void loadClinicalContactReflexRecords(ClinicalContactShortVo voClinicalContact, NeuroReflexesShortVoCollection voNeuroReflexesColl)
	{
		boolean isClinicalContactSelected = checkCurrentClinicalContact(voClinicalContact);
		
		Color textColour = null;
		if(isClinicalContactSelected)
			textColour = Color.Green;
		
		form.recbrReflexes().newRow(voClinicalContact, "Clinical Contact: " + voClinicalContact.getStartDateTime() + " - " + voClinicalContact.getSeenBy(), textColour);
		
		if(isClinicalContactSelected)
			form.recbrReflexes().setValue(voClinicalContact);
		
		for(int i=0; i<voNeuroReflexesColl.size(); i++)
		{
			NeuroReflexesShortVo voNeuroReflexes = voNeuroReflexesColl.get(i);
			form.recbrReflexes().newRow(voNeuroReflexes, "\t\t\t\t " + voNeuroReflexes.getAuthoringDateTime() + " - " + voNeuroReflexes.getAuthoringCP().getMos().getName(), textColour);
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

	private void loadCareContextRecords(NeuroReflexesShortVoCollection voNeuroReflexesColl)
	{
		CareContextShortVo voCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		
		if(form.getGlobalContext().Core.getCurrentClinicalContact() == null)
		{
			form.recbrReflexes().newRow(voCareContext, "Care Context:    " + voCareContext.getStartDateTime() + " - " + voCareContext.getEpisodeOfCare().getResponsibleHCP(), Color.Green);
			loadCareContextMotorRecords(voNeuroReflexesColl, Color.Green);
			form.recbrReflexes().setValue(voCareContext);
		}
		else
		{
			form.recbrReflexes().newRow(voCareContext, "Care Context:    " + voCareContext.getStartDateTime() + " - " + voCareContext.getEpisodeOfCare().getResponsibleHCP());
			loadCareContextMotorRecords(voNeuroReflexesColl, null);
		} 
	}

	private void loadCareContextMotorRecords(NeuroReflexesShortVoCollection voNeuroReflexesColl, Color activeColor)
	{
		if(voNeuroReflexesColl != null)
		{
			for(int i=0; i<voNeuroReflexesColl.size(); i++)
			{
				NeuroReflexesShortVo voNeuroReflexes = voNeuroReflexesColl.get(i);
				if(voNeuroReflexes.getClinicalContact() == null)
				{
					form.recbrReflexes().newRow(voNeuroReflexes, "\t\t\t\t "+ voNeuroReflexes.getAuthoringDateTime() + " - " + voNeuroReflexes.getAuthoringCP().getMos().getName(), activeColor);
				}
			}
		}
	}

	private void setRecordBrowser()
	{
		// after an update need to set the record browser to display the updated record
		if(form.getLocalContext().getUpdatedInstanceIsNotNull())
		{
			form.recbrReflexes().setValue(form.getLocalContext().getUpdatedInstance());
	
			browseRecord();
		}
	}

	private void populateScreenFromData() 
	{
		NeuroReflexesExaminationVo voReflexExam = form.getLocalContext().getReflexRecord();
		if(voReflexExam!=null)
			form.getLocalContext().setSelectedNeuroReflexesVo(voReflexExam.getNeuroRef());
		
		if(voReflexExam != null)
		{
			ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			if(voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION) &&
					!engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroReflexesInpatient))
			{
			
				if(voReflexExam.getNeuroRef() == null)
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
			
			loadProblemsGrid(voReflexExam.getProblemsOnAdmission());
			
			NeuroReflexesVo voReflex = voReflexExam.getNeuroRef();
			if(voReflex != null)
			{
				populateContactInfo(voReflex);
				populateAnalGridFromData(voReflex.getAnalTests());
				populateOtherGridFromData(voReflex.getOtherTests());
				populatePeripheralGridFromData(voReflex.getPeripheralReflexes());
			}
		}
	}
		
	private void populatePeripheralGridFromData(NeuroReflexPeripheralTestsVoCollection collection) 
	{
		for(int i=0;i<form.grdReflexes().getRows().size();i++)
		{
			form.grdReflexes().getRows().get(i).getcolLeft().setValue(null);
			form.grdReflexes().getRows().get(i).getcolRight().setValue(null);
		}
		
		if(collection == null)
			return;
		
		GenForm.grdReflexesRow row = null;
		NeuroReflexPeripheralTestsVo item = null;	
		for(int i=0;i<collection.size();i++)
		{
			boolean bParentFound = false;
			item = collection.get(i);
			for(int p=0; p<form.grdReflexes().getRows().size();p++)
			{
				row = form.grdReflexes().getRows().get(p);
				if(item.getPeripheralReflex().equals(row.getcolModality()))
				{
					bParentFound = true;
					break;
				}
			}
			if(bParentFound)
			{
				row.getcolLeft().setValue(item.getLeftFinding());
				if(row.getcolLeft().getValue() == null && item.getLeftFinding() != null)
				{
					row.getcolLeft().newRow(item.getLeftFinding(), item.getLeftFinding().getText());
					row.getcolLeft().setValue(item.getLeftFinding());
				}
				
				row.getcolRight().setValue(item.getRightFinding());
				if(row.getcolRight().getValue() == null && item.getRightFinding() != null)
				{
					row.getcolRight().newRow(item.getRightFinding(), item.getRightFinding().getText());
					row.getcolRight().setValue(item.getRightFinding());
				}
				
				row.setValue(item);
				bParentFound = false;
			}
			else
			{
				//parent instance made inactive - add new row
				row = form.grdReflexes().getRows().newRow();
				row.setcolModality(item.getPeripheralReflex());
				if(item.getLeftFinding() != null)
					row.getcolLeft().newRow(item.getLeftFinding(), item.getLeftFinding().getText());
				row.getcolLeft().setValue(item.getLeftFinding());
				if(item.getRightFinding() != null)
					row.getcolRight().newRow(item.getRightFinding(), item.getRightFinding().getText());
				row.getcolRight().setValue(item.getRightFinding());
				row.setValue(item);
			}		
		}
	}

	private void populateOtherGridFromData(NeuroReflexOtherTestsVoCollection collection) 
	{
		for(int i=0;i<form.grdOtherTest().getRows().size();i++)
			form.grdOtherTest().getRows().get(i).getcolFinding().setValue(null);
		
		if(collection == null)
			return;
		
		GenForm.grdOtherTestRow row = null;
		NeuroReflexOtherTestsVo item = null;	
		for(int i=0;i<collection.size();i++)
		{
			boolean bParentFound = false;
			item = collection.get(i);
			for(int p=0; p<form.grdOtherTest().getRows().size();p++)
			{
				row = form.grdOtherTest().getRows().get(p);
				if(item.getOtherModality().equals(row.getcolModality()))
				{
					bParentFound = true;
					break;
				}
			}
			if(bParentFound)
			{
				row.getcolFinding().setValue(item.getOtherFinding());
				//if the column hasnt been set correctly then the child instance was made inactive and was not in the list
				if(row.getcolFinding().getValue() == null)
				{
					//add the entry to the dynamic combo
					row.getcolFinding().newRow(item.getOtherFinding(), item.getOtherFinding().getText());
					row.getcolFinding().setValue(item.getOtherFinding());
				}
				row.setValue(item);
				bParentFound = false;
			}
			else
			{
				//parent instance made inactive - add new row
				row = form.grdOtherTest().getRows().newRow();
				row.setcolModality(item.getOtherModality());
				row.getcolFinding().newRow(item.getOtherFinding(), item.getOtherFinding().getText());
				row.getcolFinding().setValue(item.getOtherFinding());
				row.setValue(item);
			}		
		}
	}

	private void populateAnalGridFromData(NeuroReflexAnalTestsVoCollection collection) 
	{
		for(int i=0;i<form.grdAnalExm().getRows().size();i++)
			form.grdAnalExm().getRows().get(i).getcolFinding().setValue(null);
		
		if(collection == null)
			return;
		
		GenForm.grdAnalExmRow row = null;
		NeuroReflexAnalTestsVo item = null;	
		for(int i=0;i<collection.size();i++)
		{
			boolean bParentFound = false;
			item = collection.get(i);
			for(int p=0; p<form.grdAnalExm().getRows().size();p++)
			{
				row = form.grdAnalExm().getRows().get(p);
				if(item.getAnalTest().equals(row.getcolTest()))
				{
					bParentFound = true;
					break;
				}
			}
			if(bParentFound)
			{
				row.getcolFinding().setValue(item.getAnalTestfinding());
				//if the column hasnt been set correctly then the child instance was made inactive and was not in the list
				if(row.getcolFinding().getValue() == null)
				{
					//add the entry to the dynamic combo
					row.getcolFinding().newRow(item.getAnalTestfinding(), item.getAnalTestfinding().getText());
					row.getcolFinding().setValue(item.getAnalTestfinding());
				}
				row.setValue(item);
				bParentFound = false;
			}
			else
			{
				//parent instance made inactive - add new row
				row = form.grdAnalExm().getRows().newRow();
				row.setcolTest(item.getAnalTest());
				row.getcolFinding().newRow(item.getAnalTestfinding(), item.getAnalTestfinding().getText());
				row.getcolFinding().setValue(item.getAnalTestfinding());
				row.setValue(item);
			}		
		}
	}

	private void populateContactInfo(NeuroReflexesVo voReflex) 
	{
		if(voReflex != null)
		{
			//WDEV-15172
			AuthoringInformationVo authoringInfo = new AuthoringInformationVo(); 
			authoringInfo.setAuthoringHcp(voReflex.getAuthoringCP());
			authoringInfo.setAuthoringDateTime(voReflex.getAuthoringDateTime());
			form.ccAuthoring().setValue(authoringInfo);
			return;
		}
		setDefaultAuthoringInfo();
	}
	
	//WDEV-18846 - start
	private void setDefaultAuthoringInfo()
	{		
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
	}	
	//---------- end WDEV-18846
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		form.lblBrowseStatus().setValue("Creating new record");
		
		//need to set ClinicalContact on new, not in populateDataFromScreen as we dont want to change the contact.
		NeuroReflexesExaminationVo voReflex = new NeuroReflexesExaminationVo();	
		NeuroReflexesVo voNeuroReflex = new NeuroReflexesVo();
		
		voNeuroReflex.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		voNeuroReflex.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		voReflex.setNeuroRef(voNeuroReflex);
		
		form.getLocalContext().setReflexRecord(voReflex);
		
		if(engine.getFormName().equals(form.getForms().SpinalInjuries.MedNeuroReflexesInpatient))
		{
			clearScreen();
			form.grdProblems().getRows().clear();
			loadLookupsIntoGrids();
			
			form.ccAuthoring().initializeComponent(true, null); //WDEV-15172 //WDEV-18846
		}	
	}

	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(validUpdate())
		{
			form.setMode(FormMode.EDIT);
			setUpdatedRecord();
		}
	}

	private void setUpdatedRecord()
	{
		if(form.recbrReflexes().getValue() != null)
		{
			form.getLocalContext().setUpdatedInstance(form.recbrReflexes().getValue());
		}
	}

	private boolean validUpdate()
	{
		if(form.getLocalContext().getReflexRecord() == null)
		{
			engine.showMessage("Please select a record to update");
			return false;
		}
		return true;
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		NeuroReflexesExaminationVo voReflexExam = form.getLocalContext().getReflexRecord();
			
		if (populateDataFromScreen(voReflexExam) == null)
		{
			//Wdev-1826
			StringBuffer sb = new StringBuffer();
			
			sb.append("Please enter either a value in the 'Reflexes, Anal Examination or Other tests grids' ");
			if ( ! form.getLocalContext().getIsMedicalInpatientForm().booleanValue())
				sb.append("or an entry int the Problems grid ");
			sb.append("and save again.");

			engine.showMessage(sb.toString());
			return;
		}
		
		if ( !validateUIRules() )
		{
			return;
		}
		
		String[] arrErrors = voReflexExam.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		
		try
		{
			form.getLocalContext().setReflexRecord(domain.saveNeuroReflexRecord(voReflexExam));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch(UniqueKeyViolationException e)
		{
			engine.showMessage("A Neurological Reflexes record already exists for this clinical contact. " + e.getMessage());
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
	
	private NeuroReflexesExaminationVo populateDataFromScreen(NeuroReflexesExaminationVo voReflexExam) 
	{
		NeuroReflexesVo voReflex = voReflexExam.getNeuroRef();
		if(voReflex == null)
			voReflex = new NeuroReflexesVo();
		
		//WDEV-15172
		if (form.ccAuthoring().getValue() != null)
		{
			voReflex.setAuthoringDateTime(form.ccAuthoring().getValue().getAuthoringDateTime());
			voReflex.setAuthoringCP(form.ccAuthoring().getValue().getAuthoringHcp());
		}
		
		voReflex.setAnalTests(populateAnalDataFromGrid());
		voReflex.setOtherTests(populateOtherDataFromGrid());
		voReflex.setPeripheralReflexes(populatePeripheralDataFromGrid());
		
		voReflexExam.setProblemsOnAdmission(populateProblemsOnAdmissionDataFromScreen(voReflex));
		voReflexExam.setNeuroRef(voReflex);
		
		//Check there is a minimum data set entry
		if(    (voReflex.getAnalTests().size() == 0)
			&& (voReflex.getOtherTests().size() == 0)
			&& (voReflex.getPeripheralReflexes().size() == 0)
			&& (voReflexExam.getProblemsOnAdmission().size() == 0) )	
			return null;
		else
			return voReflexExam;		
	}


	private NeuroReflexPeripheralTestsVoCollection populatePeripheralDataFromGrid() 
	{
		NeuroReflexPeripheralTestsVoCollection coll = new NeuroReflexPeripheralTestsVoCollection();
		NeuroReflexPeripheralTestsVo item = null;

		GenForm.grdReflexesRow row = null;
		for(int i=0;i<form.grdReflexes().getRows().size();i++)
		{
			row = form.grdReflexes().getRows().get(i);
			if(row.getcolLeft().getValue() != null || row.getcolRight().getValue() != null)
			{
				item = row.getValue();
				if(item == null)
					item = new NeuroReflexPeripheralTestsVo();
			
				item.setPeripheralReflex(row.getcolModality());
				item.setLeftFinding((NeuroExamPeripheralTests) row.getcolLeft().getValue());
				item.setRightFinding((NeuroExamPeripheralTests) row.getcolRight().getValue());
				coll.add(item);
			}
		}
		return coll;
	}

	
	private NeuroReflexOtherTestsVoCollection populateOtherDataFromGrid() 
	{	
		NeuroReflexOtherTestsVoCollection coll = new NeuroReflexOtherTestsVoCollection();
		NeuroReflexOtherTestsVo item = null;

		GenForm.grdOtherTestRow row = null;
		for(int i=0;i<form.grdOtherTest().getRows().size();i++)
		{
			row = form.grdOtherTest().getRows().get(i);
			if(row.getcolFinding().getValue() != null)
			{
				item = row.getValue();
				if(item == null)
					item = new NeuroReflexOtherTestsVo();
			
				item.setOtherModality(row.getcolModality());
				item.setOtherFinding((NeuroExmOtherTests) row.getcolFinding().getValue());
				coll.add(item);
			}
		}
		return coll;
	}

	private NeuroReflexAnalTestsVoCollection populateAnalDataFromGrid() 
	{	
		NeuroReflexAnalTestsVoCollection coll = new NeuroReflexAnalTestsVoCollection();
		NeuroReflexAnalTestsVo item = null;
		
		GenForm.grdAnalExmRow row = null;
		for(int i=0;i<form.grdAnalExm().getRows().size();i++)
		{
			row = form.grdAnalExm().getRows().get(i);
			if(row.getcolFinding().getValue() != null)
			{
				item = row.getValue();
				if(item == null)
					item = new NeuroReflexAnalTestsVo();
					
				item.setAnalTest(row.getcolTest());
				item.setAnalTestfinding((NeuroExmAnalTest)row.getcolFinding().getValue());
				coll.add(item);
			}
		}
		return coll;
	}

	private MedicalProbOnAdmisVoCollection populateProblemsOnAdmissionDataFromScreen(NeuroReflexesVo voReflex) 
	{
		MedicalProbOnAdmisVoCollection voCollProblems = new MedicalProbOnAdmisVoCollection();
		MedicalProbOnAdmisVo item = null;
		for(int i=0;i<form.grdProblems().getRows().size();i++)
		{
			item = form.grdProblems().getRows().get(i).getValue();
			item.setPatientProblem(form.grdProblems().getRows().get(i).getcolProblemButton());
			if(item.getPatientProblemIsNotNull())
			{
				item.setIsActive(new Boolean(form.grdProblems().getRows().get(i).getcolActive()));
				item.setClinicalContact(voReflex.getClinicalContact());
				item.setCareContext(form.getGlobalContext().Core.getCurrentCareContext()); 
				item.setProblemContext("Neuro - Reflexes");
				voCollProblems.add(item);		
			}
		}
		
		return voCollProblems;
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setReflexRecord(null);
		form.getLocalContext().setUpdatedInstance(null);
		open();
	}

	protected void onImbAddProblemsClick() 
	{
		newProblem();
	}

	private void newProblem() 
	{
		GenForm.grdProblemsRow row = form.grdProblems().getRows().newRow();
		row.showcolProblemButtonOpened();
		row.setcolActive(true);
		row.setValue(new MedicalProbOnAdmisVo());
	}

	protected void onGrdProblemsGridCommentChanged(int column, grdProblemsRow row) throws PresentationLogicException 
	{
		row.setcolProblem(row.getcolProblemButton());		
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdProblems()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add:
					newProblem();
					break;					
			}
		}
	}

	protected void onFormModeChanged() 
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.EDIT));
		
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.recbrReflexes().setEnabled(true);
			form.grdProblems().setReadOnly(true);
		}
		else
		{
			form.recbrReflexes().setEnabled(false);
			form.grdProblems().setReadOnly(false);
		}
		
		//WDEV-15172
		form.ccAuthoring().setEnabledAuthoringHCP(form.getMode().equals(FormMode.EDIT));	//WDEV-18846
		form.ccAuthoring().setEnabledDateTime(form.getMode().equals(FormMode.EDIT));	//WDEV-18846
	}

	protected void onRecbrReflexesValueChanged() throws PresentationLogicException
	{
		browseRecord();
	}

	private void browseRecord()
	{
		clearScreen();
		clearGrids();
		loadLookupsIntoGrids();
		
		updateBrowseInformation();
		
		if(form.recbrReflexes().getValue() != null)
		{			
			if(form.recbrReflexes().getValue() instanceof ClinicalContactShortVo)
			{
				form.getLocalContext().setReflexRecord(domain.getNeuroReflexRecord((ClinicalContactShortVo) form.recbrReflexes().getValue(), null));
			}
			else if(form.recbrReflexes().getValue() instanceof NeuroReflexesShortVo)
			{
				NeuroReflexesShortVo voReflexes = (NeuroReflexesShortVo) form.recbrReflexes().getValue();
				
				if(voReflexes.getClinicalContact() == null)
					form.getLocalContext().setReflexRecord(domain.getNeuroReflexByCareContext(voReflexes.getCareContext(), voReflexes));
				else
					form.getLocalContext().setReflexRecord(domain.getNeuroReflexRecord(voReflexes.getClinicalContact(), voReflexes));
			}
			else
			{
				form.getLocalContext().setReflexRecord(domain.getNeuroReflexByCareContext((CareContextLiteVo) form.recbrReflexes().getValue(), null));
			}
			populateScreenFromData();
		}
		checkRecordIsEditable();
	
	}

	private void clearGrids()
	{
		form.grdAnalExm().getRows().clear();
		form.grdOtherTest().getRows().clear();
		form.grdProblems().getRows().clear();
		form.grdReflexes().getRows().clear();		
	}

	private void checkRecordIsEditable()
	{
		if(form.recbrReflexes().getValue() != null)
		{
			CareContextShortVo voCurrentCareContext = form.getGlobalContext().Core.getCurrentCareContext();
			ClinicalContactShortVo voCurrentClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
			
			if(form.recbrReflexes().getValue() instanceof CareContextVo)
			{
				CareContextShortVo voSelectedCareContext = (CareContextShortVo) form.recbrReflexes().getValue();
				if(voSelectedCareContext.getID_CareContext().equals(voCurrentCareContext.getID_CareContext()) && form.getGlobalContext().Core.getCurrentClinicalContact() == null)
					activateButtons(true);
				else
					activateButtons(false);
				
			}
			else if(form.recbrReflexes().getValue() instanceof NeuroReflexesShortVo)
			{
				NeuroReflexesShortVo voNeuroReflexes = (NeuroReflexesShortVo) form.recbrReflexes().getValue();
				if(voNeuroReflexes.getClinicalContact()== null)
				{
					CareContextRefVo voSelectedCareContext = voNeuroReflexes.getCareContext();
					if(voSelectedCareContext.getID_CareContext().equals(voCurrentCareContext.getID_CareContext()) && form.getGlobalContext().Core.getCurrentClinicalContact() == null)
					{
						activateButtons(true);
					}
					else
						activateButtons(false);
				}
				else
				{
					
					ClinicalContactShortVo voSelectedClinicalContact = voNeuroReflexes.getClinicalContact();
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
			else if(form.recbrReflexes().getValue() instanceof ClinicalContactShortVo)
			{
				ClinicalContactShortVo voSelectedClinicalContact = (ClinicalContactShortVo) form.recbrReflexes().getValue();
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
				if(form.getLocalContext().getReflexRecordIsNotNull() && form.getLocalContext().getReflexRecord().getNeuroRefIsNotNull() && voCurrentClinicalContact!=null){
					NeuroReflexesVo voNeuroReflexes = form.getLocalContext().getReflexRecord().getNeuroRef();
					if(voNeuroReflexes.getClinicalContactIsNotNull() && voNeuroReflexes.getClinicalContact().getID_ClinicalContact().equals(voCurrentClinicalContact.getID_ClinicalContact()))
						form.btnNew().setEnabled(false);
				}
			}
		}
		
		checkForReflexRecord();
		isRecordOfTypeMedicalAdmission();
	}


	private void isRecordOfTypeMedicalAdmission()
	{
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		if(voClinicalContact != null)
		{
			if(voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION))
				activateButtons(false);
		}
	}

	private void checkForReflexRecord()
	{
		if(form.getLocalContext().getReflexRecordIsNotNull())
		{
			if(form.getLocalContext().getReflexRecord().getNeuroRef() == null)
				form.btnUpdate().setVisible(false);
		}
	}

	private void updateBrowseInformation()
	{
		form.lblBrowseStatus().setValue(form.recbrReflexes().getRecordState("Assessment", "Assessments"));
	}
}
