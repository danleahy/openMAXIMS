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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2249.27365)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

/**
 * AU - 22/06/2006 WDEV-1288
 * Changes: 
 * - extended functionality adding Laterality, tooltips
 * - save a diagnosis as complication when there is at least one "is a complication of" negative lookup in both grids
 * - Save button text change to "OK" when isDialogOpenedFromPatientSummary()
 * Extra changes: 
 * - code formatting, addNewItem method overloaded, StaleObjectException   
*/
/**
 * AU - 23/05/2007
 * //WDEV-3112 - return true as the refresh will be done in the parent form.
*/
package ims.clinical.forms.clinicaldiassociations;

import ims.clinical.forms.clinicaldiassociations.GenForm.GroupProcedureEnumeration;
import ims.clinical.vo.ClinicalDIAssociationVo;
import ims.clinical.vo.ClinicalDIAssociationVoCollection;
import ims.clinical.vo.ClinicalProblemShortVo;
import ims.clinical.vo.lookups.CDIAssociationDescription;
import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.vo.PatientDiagnosisRefVo;
import ims.core.clinical.vo.PatientProblemRefVo;
import ims.core.clinical.vo.PatientProcedureRefVo;
import ims.core.vo.PatientDiagnosisShortVo;
import ims.core.vo.PatientDiagnosisShortVoCollection;
import ims.core.vo.PatientDiagnosisVo;
import ims.core.vo.PatientProblemListVo;
import ims.core.vo.PatientProblemVo;
import ims.core.vo.PatientProblemVoCollection;
import ims.core.vo.PatientProcedureShortListVo;
import ims.core.vo.PatientProcedureShortVo;
import ims.core.vo.PatientProcedureShortVoCollection;
import ims.core.vo.lookups.LateralityLRB;
import ims.core.vo.lookups.PatientProcedureStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.IControlComparable;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Image;
import ims.vo.ValueObject;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{		
		initialize();
		open();
	}
	protected void onRadioButtonGroupProcedureValueChanged() throws PresentationLogicException 
	{
		setChangedRecordIntoCache(form.grdProcedure());
		loadAllProcedures();
		populateScreen();
	}
	protected void onRadioButtonGroupItemTypeValueChanged() throws PresentationLogicException 
	{
		setChangedRecordIntoCache(form.grdItem());
		loadAllDiagnosis();
		populateScreen();
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);		
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isDialogOpenedFromPatientSummary())
		{
			if(save())
			{
				if(isDiagnosis() && isAtLeastOneComplication())
				{
					DiagnosisSaveResult result = saveDiagnosisAsComplication();
					switch (result)
					{
						case VALIDATION_ERROR:
							return;
						
						case STALE_OBJECT_ERROR:
							form.getGlobalContext().Clinical.setIsDiagnosisRecordUpdated(new Boolean(true));
							return;
						
						case NO_ERROR:
							form.getGlobalContext().Clinical.setIsDiagnosisRecordUpdated(new Boolean(true));
							break;
							
						default :
						break;
					}
				}
				
				engine.close(DialogResult.OK);
			}
		}
		else
		{
			form.getGlobalContext().Clinical.setClinicalDIAssociationVoCollection(populateData());
			if(isDialogInViewMode())
				engine.close(DialogResult.CANCEL);
			else
				engine.close(DialogResult.OK);
		}
	}

	private void intializeData()
	{
		ValueObject primary = form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation();
		String name = "Unknown";
		String desc = "";
		if (isDiagnosis(primary))
		{
			boolean isComplication = false;
			String diagnosisDescription = "Unknown";
			if(primary instanceof PatientDiagnosisShortVo)
			{
				PatientDiagnosisShortVo typed = (PatientDiagnosisShortVo) primary;
				isComplication 		 = typed.getIsComplicationIsNotNull() && typed.getIsComplication().booleanValue();
				diagnosisDescription = typed.getDiagnosisDescriptionIsNotNull()?typed.getDiagnosisDescription():"";
			}
			else if(primary instanceof PatientDiagnosisVo)
			{
				PatientDiagnosisVo typed = (PatientDiagnosisVo) primary;
				isComplication		 = typed.getIsComplicationIsNotNull() && typed.getIsComplication().booleanValue();
				diagnosisDescription = typed.getDiagnosisDescriptionIsNotNull() ? typed.getDiagnosisDescription() : "";
			}
			
			if (isComplication)
				name = "Complication: ";
			else
				name = "Diagnosis: ";
			
			desc = diagnosisDescription;	
		}
		else if (isProcedure(primary))
		{
			String procedureDescription = "Unknown";
			if(primary instanceof PatientProcedureShortVo)
			{
				PatientProcedureShortVo primaryP = (PatientProcedureShortVo) primary;
				procedureDescription = primaryP.getProcedureDescriptionIsNotNull()?primaryP.getProcedureDescription():"Unknown";
			}
			else 
				if(primary instanceof PatientProcedureShortListVo)
				{
				PatientProcedureShortListVo primaryP = (PatientProcedureShortListVo) primary;
				procedureDescription = primaryP.getProcedureDescriptionIsNotNull()?primaryP.getProcedureDescription():"Unknown";
				}
			
			name = "Procedure: " ;
			desc = procedureDescription;
		}
		else if (primary instanceof ClinicalProblemShortVo)
		{
			ClinicalProblemShortVo typed = (ClinicalProblemShortVo) primary;
			name = "Problem: ";
			desc = (typed.getPCNameIsNotNull() ? typed.getPCName() : "Unknown");
		}
		else if (primary instanceof PatientProblemVo)
		{
			PatientProblemVo typed = (PatientProblemVo) primary;
			name = "Problem: ";
			desc = (typed.getPatientProblemIsNotNull() ? typed.getPatientProblem() : "Unknown");
		}
		else if (primary instanceof PatientProblemListVo)//WDEV-1481
		{
			PatientProblemListVo typed = (PatientProblemListVo) primary;
			name = "Problem: " ;
			desc = (typed.getPatientProblemIsNotNull() ? typed.getPatientProblem() : "Unknown");
		}
		form.lblDataItem().setValue(name);
		form.txtName().setValue(desc);
		
		form.GroupItemType().setValue(GenForm.GroupItemTypeEnumeration.rdoAllDiagnosis);
		form.GroupProcedure().setValue(GenForm.GroupProcedureEnumeration.rdoAllProcedure);
	}
	private boolean isDiagnosis(ValueObject primary)
	{
		return  primary instanceof PatientDiagnosisShortVo || primary instanceof PatientDiagnosisVo;
	}
	private boolean isProcedure(ValueObject primary)
	{
		return primary instanceof  PatientProcedureShortVo || primary instanceof PatientProcedureShortListVo;
	}
	private void initialize()
	{
		if(!isDialogOpenedFromPatientSummary() && isDialogInViewMode()) //WDEV-17749
		{
			form.btnSave().setText("OK");
		}
		
		if(isDialogInViewMode())
		{
			form.setMode(FormMode.VIEW);
		}
	}
	private void open()
	{ 
		intializeData();
		
		loadAllProcedures();
		loadAllDiagnosis();
		
		populateScreen();
	}
	private void populateScreen() 
	{
		ClinicalDIAssociationVoCollection list = getCachedClinicalDIAssociations();
		if(list == null || list.size() == 0)
		{
			ValueObject primary = form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation();				
			
			if(primary instanceof PatientDiagnosisRefVo)
			{
				PatientDiagnosisRefVo refVo = (PatientDiagnosisRefVo)primary;
				if (refVo.getID_PatientDiagnosisIsNotNull())
					list = domain.listClinicalDiAssociation(refVo);
			}
			else if(primary instanceof PatientProcedureRefVo)
			{
				PatientProcedureRefVo refVo = (PatientProcedureRefVo)primary;
				if (refVo.getID_PatientProcedureIsNotNull())
					list = domain.listClinicalDiAssociation((PatientProcedureRefVo)primary);
			}
			else if(primary instanceof PatientProblemRefVo)
			{
				PatientProblemRefVo refVo = (PatientProblemRefVo)primary;
				if (refVo.getID_PatientProblemIsNotNull())
					list = domain.listClinicalDiAssociation((PatientProblemRefVo) primary);
			}
		}
		
		form.getLocalContext().setRecords(list);
		
		if(list == null)
			return;
		
		for(int x = 0; x < list.size(); x++)
		{			
			ClinicalDIAssociationVo assoc = list.get(x);			
			if(assoc != null && assoc.getIsActiveIsNotNull() && assoc.getIsActive().booleanValue())
			{
				ims.vo.ValueObject assocRec = null; 
				
				if(assoc.getAssocDiagnosisIsNotNull())
					assocRec = assoc.getAssocDiagnosis();
				else if(assoc.getAssocProcedureIsNotNull())
					assocRec = assoc.getAssocProcedure();
				else if(assoc.getAssocProblemIsNotNull())
					assocRec = assoc.getAssocProblem();
						
				if(assocRec != null)
				{
					boolean found = false;
					for(int y = 0; y < form.grdProcedure().getRows().size(); y++)
					{
						if(assocRec.equals(form.grdProcedure().getRows().get(y).getValue()))
						{
							form.grdProcedure().getRows().get(y).setColRelationship(assoc.getAssociationDescription());
							found = true;
							break;
						}
					}
					if(!found)
					{
						for(int y = 0; y < form.grdItem().getRows().size(); y++)
						{
							if(assocRec.equals(form.grdItem().getRows().get(y).getValue()))
							{
								form.grdItem().getRows().get(y).setColRelationship(assoc.getAssociationDescription());
								found = true;
								break;
							}
						}
					}
				}
			}
		}
	}
	private ClinicalDIAssociationVoCollection getCachedClinicalDIAssociations()
	{
		ClinicalDIAssociationVoCollection cachedRecords = form.getLocalContext().getRecords();

		//When the cache (initially the listed records) are empty and the dialog is not opened from  
		//Patient Summary then return the records from the context 
		boolean isCacheEmpty = cachedRecords == null || cachedRecords.size() == 0;
		if(!isDialogOpenedFromPatientSummary() && isCacheEmpty)
			return form.getGlobalContext().Clinical.getClinicalDIAssociationVoCollection();

		return cachedRecords;
	}
	private void loadAllProcedures()
	{
		form.grdProcedure().getRows().clear();
		loadProcedures();
	}	
	private void loadAllDiagnosis()
	{		
		form.grdItem().getRows().clear();
		
		if(form.GroupItemType().getValue() == GenForm.GroupItemTypeEnumeration.rdoDiagnosis)
		{
			loadDiagnosis();
		}
		else if(form.GroupItemType().getValue() == GenForm.GroupItemTypeEnumeration.rdoComplications)
		{
			loadComplications();
		}
		else if(form.GroupItemType().getValue() == GenForm.GroupItemTypeEnumeration.rdoProblems)
		{
			loadProblems();
		}
		else
		{
			loadDiagnosis();
			loadComplications();
			loadProblems();
		}
	}	
	private boolean save() 
	{
		ClinicalDIAssociationVoCollection data = populateData();
		data = removeUnsavedInactiveRecordsFromCache(data);
		String[] errors = data.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try 
		{
			domain.saveClinicalDiAssociation(data);
		} 
		catch (StaleObjectException e) 
		{
			//WDEV-3112
			form.getGlobalContext().Core.setYesNoDialogMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.open(form.getForms().Core.OkDialog, "Data Warning");
			return false;
		}
		
		return true;
	}
	
	private DiagnosisSaveResult saveDiagnosisAsComplication()
	{
		ValueObject primary = form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation();
		if (primary instanceof PatientDiagnosisShortVo)
		{
			PatientDiagnosisShortVo voPatientDiagnosis = (PatientDiagnosisShortVo) primary;
			voPatientDiagnosis.setIsComplication(new Boolean(true));

			String[] errors = voPatientDiagnosis.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return DiagnosisSaveResult.VALIDATION_ERROR;
			}

			try
			{
				domain.saveDiagnosis(voPatientDiagnosis);
			}
			catch (StaleObjectException e)
			{
				//WDEV-3112
				form.getGlobalContext().Core.setYesNoDialogMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				engine.open(form.getForms().Core.OkDialog, "Data Warning");
				return DiagnosisSaveResult.STALE_OBJECT_ERROR;
			}
		}

		return DiagnosisSaveResult.NO_ERROR;
	}
	private ClinicalDIAssociationVo setPrimary(ClinicalDIAssociationVo data)
	{		
		if(data == null)
			return data;
		
		ValueObject primary = form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation();				
		
		if(primary instanceof PatientDiagnosisShortVo)
		{
			data.setPrimDiagnosis((PatientDiagnosisRefVo)form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation());			
		}
		else if(primary instanceof PatientProcedureShortVo)
		{
			data.setPrimProcedure((PatientProcedureRefVo)form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation());
		}
		else if(primary instanceof PatientProblemVo)
		{
			data.setPrimProblem((PatientProblemVo)form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation());
		}
		
		return data;
	}	
	private ClinicalDIAssociationVoCollection populateData()
	{
		return populateData(null);
	}
	private ClinicalDIAssociationVoCollection populateData(IControlComparable control) 
	{	
		ClinicalDIAssociationVoCollection newResult = new ClinicalDIAssociationVoCollection();
		ClinicalDIAssociationVoCollection result = form.getLocalContext().getRecords();
		if(result == null)
			result = new ClinicalDIAssociationVoCollection();	

		if(control == null || control.equals(form.grdItem()))
		{
			for(int x = 0; x < form.grdItem().getRows().size(); x++)
			{
				GenForm.grdItemRow row = form.grdItem().getRows().get(x);
				ValueObject value = row.getValue();
				CDIAssociationDescription relationship = row.getColRelationship();
				addOrUpdateAssociationRecord(newResult, result, value, relationship);
			}
		}
		
		if(control == null || control.equals(form.grdProcedure()))
		{
			for(int x = 0; x < form.grdProcedure().getRows().size(); x++)
			{
				GenForm.grdProcedureRow row = form.grdProcedure().getRows().get(x);
				ValueObject value = row.getValue();
				CDIAssociationDescription relationship = row.getColRelationship();
				addOrUpdateAssociationRecord(newResult, result, value, relationship);
			}
		}
		
		for(int x = 0; x < result.size(); x++)
		{
			newResult.add(result.get(x));
		}
		
		return newResult;
	}
	private void addOrUpdateAssociationRecord(ClinicalDIAssociationVoCollection newResult, ClinicalDIAssociationVoCollection result, ValueObject value, CDIAssociationDescription relationship)
	{
		if(value != null)
		{
			boolean found = false;
			for(int y = 0; y < result.size(); y++)
			{
				ClinicalDIAssociationVo record = result.get(y);
				ValueObject assocRec = null;
				
				if(record.getAssocDiagnosisIsNotNull())
					assocRec = record.getAssocDiagnosis();
				else if(record.getAssocProcedureIsNotNull())
					assocRec = record.getAssocProcedure();
				else if(record.getAssocProblemIsNotNull())
					assocRec = record.getAssocProblem();

				if(assocRec != null && assocRec.equals(value))
				{
					//When relationship is removed we inactivate the record
					if(relationship == null)
						record.setIsActive(new Boolean(false));
					else
						record.setIsActive(new Boolean(true));
					record.setAssociationDescription(relationship);
					found = true;
					break;
				}
			}
			
			if(!found && relationship != null)
			{
				ClinicalDIAssociationVo newRecord = getNewAssociationRecord(value, relationship);
				newResult.add(newRecord);
			}
		}
	}
	private ClinicalDIAssociationVo getNewAssociationRecord(ValueObject value, CDIAssociationDescription relationship)
	{
		ClinicalDIAssociationVo newRecord = setPrimary(new ClinicalDIAssociationVo());
		newRecord.setAssociationDescription(relationship);
		newRecord.setIsActive(new Boolean(true));
		
		if(value instanceof PatientDiagnosisRefVo)
		{
			newRecord.setAssocDiagnosis((PatientDiagnosisRefVo)value);
		}
		else if(value instanceof PatientProcedureRefVo)
		{
			newRecord.setAssocProcedure((PatientProcedureRefVo)value);
		}
		else if(value instanceof PatientProblemRefVo)
		{
			newRecord.setAssocProblem((PatientProblemRefVo)value);
		}
		return newRecord;
	}
	private ClinicalDIAssociationVoCollection removeUnsavedInactiveRecordsFromCache(ClinicalDIAssociationVoCollection data)
	{
		boolean removed = true;
		while(removed)
		{
			removed = false;
			for (int i = 0; data != null && i < data.size(); i++)
			{
				boolean activeRecord = data.get(i).getIsActive() == null || data.get(i).getIsActive().booleanValue() == false;
				boolean recordSaved  = data.get(i).getID_ClinicalcdiassociationsIsNotNull();
				if(activeRecord && recordSaved == false)
				{
					data.remove(i);
					removed = true;
					break;
				}	
			}
		}
		
		return data;
	}
	private void loadProcedures() 
	{
		PatientProcedureShortVoCollection list = domain.listProcedures(form.getGlobalContext().Core.getPatientShort(), getProcedureStatus());
		for (int x = 0; list != null && x < list.size(); x++)
		{
			if (list.get(x) != null && list.get(x).getProcedureDescriptionIsNotNull())
			{
				if (!list.get(x).equals(form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation()))
				{
					GenForm.grdProcedureRow row = form.grdProcedure().getRows().newRow();
					row.setcolLaterality(getProcedureLateralityImg(list.get(x).getProcLaterality(), list.get(x).getProcedureStatus()));
					row.setColProcedure(list.get(x).getProcedureDescription());
					row.setTooltip(list.get(x).getDiAssociationsTooltip());
					row.setValue(list.get(x));
				}
			}
		}
	}
	private void loadDiagnosis() 
	{
		PatientDiagnosisShortVoCollection list = domain.listDiagnosis(form.getGlobalContext().Core.getPatientShort());
		if(list != null)
		{
			for(int x = 0; x < list.size(); x++)
			{
				PatientDiagnosisShortVo patientDiagnosisShortVo = list.get(x);
				if(patientDiagnosisShortVo != null && patientDiagnosisShortVo.getDiagnosisDescriptionIsNotNull())
				{
					if(!patientDiagnosisShortVo.equals(form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation()))
					{
						addNewItem(patientDiagnosisShortVo);
					}
				}
			}
		}
	}
	private void loadComplications() 
	{
		PatientDiagnosisShortVoCollection list = domain.listComplications(form.getGlobalContext().Core.getPatientShort());
		if(list != null)
		{
			for(int x = 0; x < list.size(); x++)
			{
				if(list.get(x) != null && list.get(x).getDiagnosisDescriptionIsNotNull())
				{
					if(!list.get(x).equals(form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation()))
					{
						addNewItem(list.get(x), true);
					}
				}
			}
		}
	}
	private void loadProblems() 
	{		
		PatientProblemVoCollection list = domain.listProblems(form.getGlobalContext().Core.getPatientShort());
		if(list != null)
		{
			for(int x = 0; x < list.size(); x++)
			{
				if(list.get(x) != null && list.get(x).getPatientProblemIsNotNull())
				{
					if(!list.get(x).equals(form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation()))
					{
						addNewItem(list.get(x));
					}
				}
			}
		}
	}
	
	private void addNewItem(ValueObject voObject)
	{
		addNewItem(voObject, false);
	}
	
	private void addNewItem(ValueObject voObject, boolean isComplication)
	{
		GenForm.grdItemRow row = form.grdItem().getRows().newRow();
		String description  = "";
		Image lateralityImg = null;
		String tooltip      = new String();
		
		if (voObject instanceof PatientDiagnosisShortVo)
		{
			PatientDiagnosisShortVo patientDiagnosisShortVo = ((PatientDiagnosisShortVo) voObject);
			description = patientDiagnosisShortVo.getDiagnosisDescription();
			tooltip 	= patientDiagnosisShortVo.getTooltipForDiAssociation();
			if (isComplication)
				lateralityImg = getComplicationLateralityImg(patientDiagnosisShortVo.getDiagLaterality());
			else
				lateralityImg = getDiagnosisLateralityImg(patientDiagnosisShortVo.getDiagLaterality());
		}

		if (voObject instanceof PatientProblemVo)
		{
			PatientProblemVo patientProblemVo = ((PatientProblemVo) voObject);
			description = patientProblemVo.getPatientProblem();
			lateralityImg = form.getImages().COE.BlueViolet;
			tooltip = patientProblemVo.getDiAssociationTooltip();
		}
		row.setColDataItem(description);
		row.setcolLaterality(lateralityImg);
		row.setTooltip(tooltip);
		row.setValue(voObject);
	}
	
	private PatientProcedureStatus getProcedureStatus()
	{
		PatientProcedureStatus status = null;
		GroupProcedureEnumeration procedure = form.GroupProcedure().getValue();

		if (procedure.equals(GroupProcedureEnumeration.rdoPlannedProcedure))
			status = PatientProcedureStatus.PLANNED;
		else if (procedure.equals(GroupProcedureEnumeration.rdoPerformedProcedure))
			status = PatientProcedureStatus.PERFORMED;
		return status;
	}
	
	private boolean isDiagnosis()
	{
		ValueObject primary = form.getGlobalContext().Clinical.PatientSummary.getPrimaryAssociation();
		if (primary instanceof PatientDiagnosisShortVo)
		{
			PatientDiagnosisShortVo patientDiagShortVo = (PatientDiagnosisShortVo) primary;
			return patientDiagShortVo.getIsComplication() == null || patientDiagShortVo.getIsComplication().booleanValue() == false;
		}
		return false;
	}

	private boolean isDialogOpenedFromPatientSummary()
	{
		return form.getGlobalContext().Clinical.getIsDiAssociationDialogOpenedFromPatientSummaryIsNotNull() && form.getGlobalContext().Clinical.getIsDiAssociationDialogOpenedFromPatientSummary().booleanValue();
	}
	
	private boolean isAtLeastOneComplication()
	{
		for (int i = 0; i < form.grdItem().getRows().size(); i++)
		{
			CDIAssociationDescription associationDescription = form.grdItem().getRows().get(i).getColRelationship();
			if(associationDescription != null  && associationDescription.equals(CDIAssociationDescription.ISACOMPLICATIONOF))
				return true;
		}
		
		for (int i = 0; i < form.grdProcedure().getRows().size(); i++)
		{
			CDIAssociationDescription associationDescription = form.grdProcedure().getRows().get(i).getColRelationship();
			if(associationDescription != null  && associationDescription.equals(CDIAssociationDescription.ISACOMPLICATIONOF))
				return true;
		}
		
		return false;
	}
	
	private Image getProcedureLateralityImg(LateralityLRB procLaterality, PatientProcedureStatus status)
	{
		if (procLaterality != null && status != null)
		{
			if (procLaterality.equals(LateralityLRB.LEFT))
			{
				if (status.equals(PatientProcedureStatus.PLANNED))
					return form.getImages().COE.DarkCyanLeft;
				else if (status.equals(PatientProcedureStatus.PERFORMED))
					return form.getImages().COE.OrangeLeft;
	
			}
			else if (procLaterality.equals(LateralityLRB.RIGHT))
			{
				if (status.equals(PatientProcedureStatus.PLANNED))
					return form.getImages().COE.DarkCyanRight;
				else if (status.equals(PatientProcedureStatus.PERFORMED))
					return form.getImages().COE.OrangeRight;
	
			}
			else if (procLaterality.equals(LateralityLRB.BILATERAL))
			{
				if (status.equals(PatientProcedureStatus.PLANNED))
					return form.getImages().COE.DarkCyanBoth;
				else if (status.equals(PatientProcedureStatus.PERFORMED))
					return form.getImages().COE.OrangeBoth;
			}
		}
		else
		{
			if(status != null)
			{
				if (status.equals(PatientProcedureStatus.PLANNED))
					return form.getImages().COE.DarkCyan;
				else if (status.equals(PatientProcedureStatus.PERFORMED))
					return form.getImages().COE.Orange;
			}
		}
		return null;
	}

	private Image getDiagnosisLateralityImg(LateralityLRB diagLaterality)
	{
		if(diagLaterality != null)
		{
			if(diagLaterality.equals(LateralityLRB.LEFT))
				return form.getImages().COE.BlueLeft;
			else if(diagLaterality.equals(LateralityLRB.RIGHT))
				return form.getImages().COE.BlueRight;
			else if(diagLaterality.equals(LateralityLRB.BILATERAL))
				return form.getImages().COE.BlueBoth;
		}
		else
			return form.getImages().COE.Blue;
		
		return null;
	}

	private Image getComplicationLateralityImg(LateralityLRB diagLaterality)
	{
		if(diagLaterality != null)
		{
			if(diagLaterality.equals(LateralityLRB.LEFT))
				return form.getImages().COE.LightSkyBlueLeft;
			else if(diagLaterality.equals(LateralityLRB.RIGHT))
				return form.getImages().COE.LightSkyBlueRight;
			else if(diagLaterality.equals(LateralityLRB.BILATERAL))
				return form.getImages().COE.LightSkyBlueBoth;
		}
		else
			return form.getImages().COE.LightSkyBlue;
		
		return null;
	}
	
	private boolean isDialogInViewMode()
	{
		FormMode mode = form.getGlobalContext().Clinical.getClinicalDIassociationsFormMode();
		if(mode != null && mode.equals(FormMode.VIEW))
			return true;

		return false;		
	}
	
	private void setChangedRecordIntoCache(IControlComparable control)
	{
		if(form.getMode().equals(FormMode.EDIT))
		{
			ClinicalDIAssociationVoCollection voColl = populateData(control);
			if(voColl != null)
				form.getLocalContext().setRecords(voColl);
		}
	}
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if(formName.equals(form.getForms().Core.OkDialog) && result.equals(DialogResult.CANCEL))
		{
			engine.close(DialogResult.OK);
		}
	}
	
	public enum DiagnosisSaveResult
	{
		VALIDATION_ERROR, 
		STALE_OBJECT_ERROR, 
		NO_ERROR;
	}
}
