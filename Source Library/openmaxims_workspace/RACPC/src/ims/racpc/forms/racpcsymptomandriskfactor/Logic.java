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
// This code was generated by Peter Martin using IMS Development Environment (version 1.71 build 3642.24101)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.racpc.forms.racpcsymptomandriskfactor;

import ims.clinical.vo.RACPSymptomRiskFactorsVo;
import ims.clinical.vo.RACPSymptomsVo;
import ims.clinical.vo.RACPSymptomsVoCollection;
import ims.core.vo.AlcoholVo;
import ims.core.vo.Smoking;
import ims.core.vo.SmokingDetails;
import ims.core.vo.SmokingDetailsCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.RACPRiskFactor;
import ims.core.vo.lookups.RACPRiskFactorCollection;
import ims.core.vo.lookups.RACPSymptom;
import ims.core.vo.lookups.RACPSymptomCollection;
import ims.core.vo.lookups.SmokingStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.racpc.forms.racpcsymptomandriskfactor.GenForm.grdRisksRow;
import ims.racpc.forms.racpcsymptomandriskfactor.GenForm.grdSymptomsRow;
import ims.vo.LookupInstVo;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	}
	private void open() 
	{
		clearScreen();
		
		setSmokingControls(null);
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
		{
			RACPSymptomRiskFactorsVo voRACPSymptomRiskFactors = domain.getRACPSymptomRiskFactorsForCareContact(form.getGlobalContext().Core.getCurrentCareContext());
			form.getLocalContext().setRACPSymptomRiskFactorsVo(voRACPSymptomRiskFactors);
			if(voRACPSymptomRiskFactors!=null)
			{
				loadSymptomsGrid(true);
				loadRiskFactorsGrid(true);
				populateScreen(voRACPSymptomRiskFactors);
			}
		}
		
		form.setMode(FormMode.VIEW);	//WDEV-13437
	}
	private void populateScreen(RACPSymptomRiskFactorsVo voRACPSymptomRiskFactors) {
			
		form.chkCardiacSymptoms().setValue(voRACPSymptomRiskFactors.getSymptomIndicator());
		form.chkRiskFactors().setValue(voRACPSymptomRiskFactors.getRiskFactorIndicator());
		form.txtCardiacSymptoms().setValue(voRACPSymptomRiskFactors.getSymptomNotes());
		form.txtNotes().setValue(voRACPSymptomRiskFactors.getOtherNotes());
		if(voRACPSymptomRiskFactors.getAlcoholUnitsPerWeekIsNotNull())
			form.cmbAlcohol().setValue(voRACPSymptomRiskFactors.getAlcoholUnitsPerWeek().getUnitsPerWeek());
		intDurationValueChanged();
		cmbDurationValueChanged();
		form.cmbDiabetes().setValue(voRACPSymptomRiskFactors.getDiabetesStatus());
		form.cmbDuration().setValue(voRACPSymptomRiskFactors.getSymptomDuration());
		form.intDuration().setValue(voRACPSymptomRiskFactors.getSymptomDurationUnit());
		if(voRACPSymptomRiskFactors.getSmokingStatusIsNotNull()){
			setSmokingControls(voRACPSymptomRiskFactors.getSmokingStatus().getCurrentSmokingStatus());
			form.cmbSmoker().setValue(voRACPSymptomRiskFactors.getSmokingStatus().getCurrentSmokingStatus());
			if(voRACPSymptomRiskFactors.getSmokingStatus().getSmokingDetailsIsNotNull()){
				SmokingDetailsCollection collSmokingDetails = voRACPSymptomRiskFactors.getSmokingStatus().getSmokingDetails();
				if(collSmokingDetails!=null && collSmokingDetails.size()>0){
					SmokingDetails smokingDetails = collSmokingDetails.get(0);
					form.intDailyAmount().setValue(smokingDetails.getAmountPerDay());
					form.intYearsStopped().setValue(collSmokingDetails.get(0).getNumberOfYears());
				}
			}
		}
		
		if(voRACPSymptomRiskFactors.getSymptomsIsNotNull()){
			RACPSymptomsVoCollection currentSymptomsColl = voRACPSymptomRiskFactors.getSymptoms();
			form.grdSymptoms().getRows().clear();
			for (int i = 0; i < currentSymptomsColl.size(); i++)
			{
				RACPSymptomsVo voRACPSymptoms = currentSymptomsColl.get(i);
				grdSymptomsRow row = form.grdSymptoms().getRows().newRow();
				row.setcolSymp(voRACPSymptoms.getRAPCSymptom());
				row.getcolFinding().newRow(voRACPSymptoms.getRACPCFinding(), voRACPSymptoms.getRACPCFinding().getText());
				row.getcolFinding().setValue(voRACPSymptoms.getRACPCFinding());
			}
		}
		
	}
	private void setSmokingControls(SmokingStatus status) {
		if(status!=null){
			if(status.equals(SmokingStatus.EXSMOKER)){
				form.intYearsStopped().setVisible(true);
				form.intYearsStopped().setEnabled(form.getMode().equals(FormMode.EDIT));
				form.lblYearsStopped().setVisible(true);
				form.intDailyAmount().setVisible(false);
				form.lblDailyAmount().setVisible(false);
				form.intDailyAmount().setValue(null);
				return;
			}
			else if(status.equals(SmokingStatus.SMOKER)){
				form.intYearsStopped().setVisible(false);
				form.lblYearsStopped().setVisible(false);
				form.intDailyAmount().setVisible(true);
				form.intDailyAmount().setEnabled(form.getMode().equals(FormMode.EDIT));
				form.lblDailyAmount().setVisible(true);
				form.intYearsStopped().setValue(null);
				return;
			}
			else if(status.equals(SmokingStatus.NEVERSMOKED)){
				form.intYearsStopped().setVisible(false);
				form.lblYearsStopped().setVisible(false);
				form.intDailyAmount().setVisible(false);
				form.lblDailyAmount().setVisible(false);
				form.intDailyAmount().setValue(null);
				form.intYearsStopped().setValue(null);
				return;
			}
		}
				
		form.intDailyAmount().setVisible(false);
		form.lblDailyAmount().setVisible(false);
		form.intDailyAmount().setValue(null);
		form.intYearsStopped().setVisible(false);
		form.lblYearsStopped().setVisible(false);
		form.intYearsStopped().setValue(null);
	}
	private void clearScreen() {
		form.grdRisks().getRows().clear();
		form.grdSymptoms().getRows().clear();
		
		form.chkCardiacSymptoms().setValue(false);
		form.chkRiskFactors().setValue(false);
		form.txtCardiacSymptoms().setValue("");
		form.txtNotes().setValue("");
		form.cmbAlcohol().setValue(null);
		form.cmbDiabetes().setValue(null);
		form.cmbDuration().setValue(null);
		form.intDuration().setValue(null);
		form.cmbSmoker().setValue(null);
		form.intDailyAmount().setValue(null);
		form.intYearsStopped().setValue(null);		
	}
	private void initialise() {
		prePopulateGrids();
	}
	private void prePopulateGrids() {
		loadSymptomsGrid(false);
		loadRiskFactorsGrid(false);		
	}
	private void loadSymptomsGrid(boolean bOnUpdate) {
		form.grdSymptoms().getRows().clear();
		
		RACPSymptomCollection collRACPSymptom = LookupHelper.getRACPSymptom(domain.getLookupService());
		form.getLocalContext().setRACPSymptomCollection(collRACPSymptom);	
		
		for (int i = 0; i < collRACPSymptom.size(); i++)
		{
			if(collRACPSymptom.get(i).getParent()==null){
				grdSymptomsRow row = form.grdSymptoms().getRows().newRow();
				row.setcolSymp(collRACPSymptom.get(i));
				ArrayList<LookupInstVo> findings = collRACPSymptom.get(i).getChildInstances();
				for (int j = 0; j < findings.size(); j++)
				{
					row.getcolFinding().newRow(findings.get(j), findings.get(j).getText());
				}
			}
		}		
		
		if(bOnUpdate && form.getLocalContext().getRACPSymptomRiskFactorsVo().getSymptomsIsNotNull()){
			RACPSymptomsVoCollection currentSymptomsColl = form.getLocalContext().getRACPSymptomRiskFactorsVo().getSymptoms();
			for (int i = 0; i < form.grdSymptoms().getRows().size(); i++)
			{
				grdSymptomsRow row = form.grdSymptoms().getRows().get(i);
				for (int j = 0; j < currentSymptomsColl.size(); j++)
				{
					if(row.getcolSymp().equals(currentSymptomsColl.get(j).getRAPCSymptom()))
						row.getcolFinding().setValue(currentSymptomsColl.get(j).getRACPCFinding());
				}
			}
		}
	}
	private void loadRiskFactorsGrid(boolean bOnUpdate) {
		form.grdRisks().getRows().clear();
		
		RACPRiskFactorCollection collRACPRiskFactor = LookupHelper.getRACPRiskFactor(domain.getLookupService());
		form.getLocalContext().setRACPRiskFactorCollection(collRACPRiskFactor);	
		
		for (int i = 0; i < collRACPRiskFactor.size(); i++)
		{
			grdRisksRow row = form.grdRisks().getRows().newRow();
			row.setcolRisk(collRACPRiskFactor.get(i).getText());
			row.setValue(collRACPRiskFactor.get(i));
		}		
		
		if(bOnUpdate && form.getLocalContext().getRACPSymptomRiskFactorsVo().getRiskFactorsIsNotNull()){
			RACPRiskFactorCollection currentRiskFactorsColl = form.getLocalContext().getRACPSymptomRiskFactorsVo().getRiskFactors();
			for (int i = 0; i < form.grdRisks().getRows().size(); i++)
			{
				grdRisksRow row = form.grdRisks().getRows().get(i);
				for (int j = 0; j < currentRiskFactorsColl.size(); j++)
				{
					if(row.getValue()!=null && row.getValue().equals(currentRiskFactorsColl.get(j)))
						row.setcolSelect(true);
				}
			}
			
			for (int i = 0; i < currentRiskFactorsColl.size(); i++)
			{
				RACPRiskFactor voRiskFactor = currentRiskFactorsColl.get(i);
				boolean bFound = false;
				for (int j = 0; j < form.grdRisks().getRows().size(); j++)
				{
					grdRisksRow row = form.grdRisks().getRows().get(j);
					if(row.getValue()!=null && row.getValue().equals(voRiskFactor))
						bFound = true;
				}
				if(!bFound){
					grdRisksRow row = form.grdRisks().getRows().newRow();
					row.setcolRisk(voRiskFactor.getText());
					row.setValue(voRiskFactor);
					row.setcolSelect(true);
				}
			}
		}
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isRACPCComplete())//	WDEV-13662
			return;
		
		form.getLocalContext().setRACPSymptomRiskFactorsVo(null);
		form.setMode(FormMode.EDIT);
		form.txtCardiacSymptoms().setEnabled(true);
		onChkRiskFactorsValueChanged();
		clearScreen();
		loadSymptomsGrid(false);
		loadRiskFactorsGrid(false);
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(isRACPCComplete())//	WDEV-13662
			return;
		
		form.setMode(FormMode.EDIT);
		chkCardiacSymptomsValueChanged();
		onChkRiskFactorsValueChanged();
		onCmbSmokerValueChanged();
		cmbDurationValueChanged();
		
		loadSymptomsGrid(true);	
		loadRiskFactorsGrid(true);	
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}
	private boolean save() 
	{
		if(isRACPCComplete())//	WDEV-13662
			return false;

		RACPSymptomRiskFactorsVo voRACPSymptomRiskFactors = populateDataFromScreen(form.getLocalContext().getRACPSymptomRiskFactorsVo());
		
		String[] uiErrors = validateUIRules();
		String[] arrErrors = voRACPSymptomRiskFactors.validate(uiErrors);
	
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		try
		{
			voRACPSymptomRiskFactors = domain.saveRACPSymptomRiskFactorsVo(voRACPSymptomRiskFactors);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
				
		form.getLocalContext().setRACPSymptomRiskFactorsVo(voRACPSymptomRiskFactors);
		return true;
	}
	public String[] validateUIRules()
	{
		ArrayList<String> errorsList = new ArrayList<String>();
		if (form.cmbDuration().getValue()==null && form.intDuration().getValue()!=null)
		{
			errorsList.add("If duration number is provided the type is also required.");
		}
		else if (form.intDuration().getValue()==null && form.cmbDuration().getValue()!=null)
		{
			errorsList.add("If duration type is provided the number is also required.");
		}
		if (errorsList.size()==0)
			return null;
		String [] errors = new String[errorsList.size()];
		errorsList.toArray(errors);
		return errors;
			
	}
	private RACPSymptomRiskFactorsVo populateDataFromScreen(RACPSymptomRiskFactorsVo symptomRiskFactorsVo) {
		if(symptomRiskFactorsVo == null)
			symptomRiskFactorsVo = new RACPSymptomRiskFactorsVo();
		
		if(symptomRiskFactorsVo.getCareContext()==null)
			symptomRiskFactorsVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			
		populateSymptomsFromGrid(symptomRiskFactorsVo);
		populateRiskFactorsFromGrid(symptomRiskFactorsVo);	
			
		if(form.cmbSmoker().getValue()!=null){
			Smoking smokingStatus = symptomRiskFactorsVo.getSmokingStatus();
			if(smokingStatus==null)
				smokingStatus = new Smoking();
			smokingStatus.setCurrentSmokingStatus(form.cmbSmoker().getValue());
			SmokingDetailsCollection collSmokingDetails = smokingStatus.getSmokingDetails();  
			if(collSmokingDetails==null)
				collSmokingDetails = new SmokingDetailsCollection();
			SmokingDetails voSmokingDetails = new SmokingDetails();
			if(collSmokingDetails.size()>0)
				voSmokingDetails = collSmokingDetails.get(0);
			voSmokingDetails.setAmountPerDay(form.intDailyAmount().getValue());
			voSmokingDetails.setNumberOfYears(form.intYearsStopped().getValue());
			collSmokingDetails.add(voSmokingDetails);
			smokingStatus.setSmokingDetails(collSmokingDetails);
			symptomRiskFactorsVo.setSmokingStatus(smokingStatus);
		}
		else
			symptomRiskFactorsVo.setSmokingStatus(null);
		symptomRiskFactorsVo.setSymptomIndicator(form.chkCardiacSymptoms().getValue());
		symptomRiskFactorsVo.setRiskFactorIndicator(form.chkRiskFactors().getValue());
		symptomRiskFactorsVo.setSymptomNotes(form.txtCardiacSymptoms().getValue());
		symptomRiskFactorsVo.setOtherNotes(form.txtNotes().getValue());
		if(symptomRiskFactorsVo.getAlcoholUnitsPerWeek()==null)
			symptomRiskFactorsVo.setAlcoholUnitsPerWeek(new AlcoholVo());
		symptomRiskFactorsVo.getAlcoholUnitsPerWeek().setUnitsPerWeek(form.cmbAlcohol().getValue());
		if(form.cmbAlcohol().getValue()==null)
			symptomRiskFactorsVo.setAlcoholUnitsPerWeek(null);
		symptomRiskFactorsVo.setDiabetesStatus(form.cmbDiabetes().getValue());
		symptomRiskFactorsVo.setSymptomDuration(form.cmbDuration().getValue());
		symptomRiskFactorsVo.setSymptomDurationUnit(form.intDuration().getValue());
	
		return symptomRiskFactorsVo;
	}
	private void populateRiskFactorsFromGrid(RACPSymptomRiskFactorsVo symptomRiskFactorsVo) {
		RACPRiskFactorCollection collRACPRiskFactor  = new RACPRiskFactorCollection();
		for (int i = 0; i < form.grdRisks().getRows().size(); i++)
		{
			grdRisksRow row = form.grdRisks().getRows().get(i);
			if(row.getcolSelect())
				collRACPRiskFactor.add(row.getValue());
		}
		
		if(collRACPRiskFactor.size()>0)
			symptomRiskFactorsVo.setRiskFactors(collRACPRiskFactor);
		else
			symptomRiskFactorsVo.setRiskFactors(null);
		
	}
	private void populateSymptomsFromGrid(RACPSymptomRiskFactorsVo symptomRiskFactorsVo) {
		RACPSymptomsVoCollection collRACPSymptomsVo = new RACPSymptomsVoCollection();
		symptomRiskFactorsVo.setSymptoms(null);
		for (int i = 0; i < form.grdSymptoms().getRows().size(); i++)
		{
			grdSymptomsRow row = form.grdSymptoms().getRows().get(i);
			if(row.getcolFinding().getValue()!=null){
				RACPSymptomsVo voRACPSymptoms  = new RACPSymptomsVo ();
				voRACPSymptoms.setRAPCSymptom(row.getcolSymp());
				voRACPSymptoms.setRACPCFinding((RACPSymptom) row.getcolFinding().getValue());
				collRACPSymptomsVo.add(voRACPSymptoms);
			}
		}
		
		if(collRACPSymptomsVo.size()>0)
			symptomRiskFactorsVo.setSymptoms(collRACPSymptomsVo);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onCmbSmokerValueChanged() throws PresentationLogicException {
		if(!form.getMode().equals(FormMode.EDIT))
			return;
		setSmokingControls(form.cmbSmoker().getValue());
	}
	@Override
	protected void onChkRiskFactorsValueChanged() throws PresentationLogicException {
		if(!form.getMode().equals(FormMode.EDIT))
			return;
		if(form.chkRiskFactors().getValue()){
			form.grdRisks().setReadOnly(true);
			for (int i = 0; i < form.grdRisks().getRows().size(); i++)
			{
				grdRisksRow row = form.grdRisks().getRows().get(i);
				row.setcolSelect(false);
			}
		}
		else
			form.grdRisks().setReadOnly(false);
				
	}
	@Override
	protected void onIntDurationValueChanged() throws PresentationLogicException {
		intDurationValueChanged();
	}
	private void intDurationValueChanged() {
		if(form.getMode().equals(FormMode.EDIT)){
			if(form.intDuration().getValue()!=null && form.cmbDuration().getValue()==null)
				form.cmbDuration().setRequired(true);	
			else
				form.cmbDuration().setRequired(false);	
			if(form.intDuration().getValue()==null && form.cmbDuration().getValue()!=null)
				form.intDuration().setRequired(true);	
			else
				form.intDuration().setRequired(false);	
		}
	}
	@Override
	protected void onChkCardiacSymptomsValueChanged() throws PresentationLogicException {
		chkCardiacSymptomsValueChanged();		
	}
	private void chkCardiacSymptomsValueChanged() {
		if(form.getMode().equals(FormMode.EDIT) && !form.chkCardiacSymptoms().getValue())
			form.txtCardiacSymptoms().setEnabled(true);	
		else{
			form.txtCardiacSymptoms().setEnabled(false);
			form.txtCardiacSymptoms().setValue("");	
		}
	}
	@Override
	protected void onCmbDurationValueChanged() throws PresentationLogicException {
		cmbDurationValueChanged();
	}
	private void cmbDurationValueChanged() {
		if(form.getMode().equals(FormMode.EDIT)){
				
			if(form.cmbDuration().getValue()!=null && form.intDuration().getValue()==null)
				form.intDuration().setRequired(true);	
			else
				form.intDuration().setRequired(false);
			if(form.cmbDuration().getValue()==null && form.intDuration().getValue()!=null)
				form.cmbDuration().setRequired(true);	
			else
				form.cmbDuration().setRequired(false);
		}
		
		
	}
	
	//	WDEV-13437
	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}
	
	//	WDEV-13437
	private void updateControlsState() 
	{
		if(FormMode.VIEW.equals(form.getMode()))
		{
			boolean isReadOnly = domain.isRACPCSummaryComplete(form.getGlobalContext().Core.getCurrentCareContext());
			
			form.btnNew().setVisible(form.getLocalContext().getRACPSymptomRiskFactorsVo() == null && !isReadOnly);
			form.btnEdit().setVisible(form.getLocalContext().getRACPSymptomRiskFactorsVo() != null && !isReadOnly);
			form.intYearsStopped().setEnabled(false); //WDEV-14058
			form.intDailyAmount().setEnabled(false); //WDEV-14058
		}
	}
	
	//	WDEV-13662
	private boolean isRACPCComplete() 
	{	
		boolean isRACPCSummaryComplete = domain.isRACPCSummaryComplete(form.getGlobalContext().Core.getCurrentCareContext());//	WDEV-13662
		
		if(isRACPCSummaryComplete)//	WDEV-13662
		{
			engine.showMessage("RACPC Summary has already been completed. The screen will be refreshed.");
			open();
			return true;
		}
		
		return false;
	}
}
