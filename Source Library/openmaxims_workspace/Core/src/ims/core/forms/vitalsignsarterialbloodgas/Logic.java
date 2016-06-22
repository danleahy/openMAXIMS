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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.22 build 41215.900)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.vitalsignsarterialbloodgas;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.VSArterialBloodGas;
import ims.core.vo.VSOxygenSaturation;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.VitalSignsVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();
	}
	
	private void open() throws FormOpenException
	{
		clearEntryControls();
		// List all fluid balances for this episode
		CareContextShortVo careContext = form.getGlobalContext().Core.getCurrentCareContext();
		
		form.btnUpdate().setEnabled(false);
		
		if (careContext == null)
		{
			throw new FormOpenException("Please select a clinical contact");
		}
			
		populateGrid(domain.listABGO2Sats(careContext));
	
	}
	
	private void populateGrid(VitalSignsVoCollection coll)
	{
		form.grdBloodGas().getRows().clear();
		GenForm.grdBloodGasRow row;

		//inactive record handling
		for(int i=0;i<coll.size();i++)
		{

			
			VitalSignsVo aBGO2Sats  = coll.get(i);
				
			if (aBGO2Sats != null && aBGO2Sats.getArterialBloodGasIsNotNull())
			{
				row = form.grdBloodGas().getRows().newRow();
				row.setValue(aBGO2Sats);
				row.setColBExcess(aBGO2Sats.getArterialBloodGas().getBaseExcess());
				row.setColDateTime(aBGO2Sats.getVitalsTakenDateTime().getDate().toString() + " "+ aBGO2Sats.getVitalsTakenDateTime().getTime().toString());
				row.setColO2(aBGO2Sats.getOxygenSaturation().getOxygenSaturationLevel());
				row.setColPaCO2(aBGO2Sats.getArterialBloodGas().getPaCO2());
				row.setColPaO2(aBGO2Sats.getArterialBloodGas().getPaO2());
				row.setColPh(aBGO2Sats.getArterialBloodGas().getPH());
				row.setColSBC(aBGO2Sats.getArterialBloodGas().getSBC());
				if (aBGO2Sats.getArterialBloodGas().getVentilationMode() != null)
					row.setColMode(aBGO2Sats.getArterialBloodGas().getVentilationMode().getText());
			}
		}
		
		//WDEV-10802 for RIE
		CareContextShortVo careContext = form.getGlobalContext().Core.getCurrentCareContext();
		domain.listArterialBSVo(careContext);	
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearEntryControls();

		form.customControlAuthoringInfo().setValue(null);
		
		open();
		form.setMode(FormMode.VIEW);
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		//now you wont be able to create a blank vital signs record. o2 is now mandatory.
		if(form.intSats().getValue() == null)
		{
			engine.showMessage("'O2 Sats' is a mandatory field.");
			return;
		}
		if(form.dtimTaken().getValue() == null)
		{
			engine.showMessage("'Date/Time taken' is a mandatory field.");
			return;
		}
		//Vital Sign
		VitalSignsVo voVitalSignABG;
		if(form.getLocalContext().getCurrentABGIsNotNull())
			voVitalSignABG = form.getLocalContext().getCurrentABG(); //update
		else
			voVitalSignABG = new VitalSignsVo();
		
		voVitalSignABG.setAuthoringInformation(form.customControlAuthoringInfo().getValue());
		
		voVitalSignABG.setVitalsTakenDateTime(form.dtimTaken().getValue());
		
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			voVitalSignABG.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		if(form.getGlobalContext().Core.getCurrentCareContextIsNotNull())
			voVitalSignABG.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
	
		//O2
		VSOxygenSaturation o2 = voVitalSignABG.getOxygenSaturation();
		if(o2 == null)
			o2 = new VSOxygenSaturation();
			
		o2.setOxygenSaturationLevel(form.intSats().getValue());
		
		//Arterial Blood Gas
		VSArterialBloodGas abg = voVitalSignABG.getArterialBloodGas();
		if(abg == null)
			abg = new VSArterialBloodGas();
		
		abg.setBaseExcess(form.decBExcess().getValue());
		abg.setPaCO2(form.decPaCO2().getValue());
		abg.setPaO2(form.decPaO2().getValue());
		abg.setPH(form.decPh().getValue());
		abg.setSBC(form.decSBC().getValue());
		abg.setVentilationMode(form.cmbVentilation().getValue());
		
		voVitalSignABG.setOxygenSaturation(o2);
		voVitalSignABG.setArterialBloodGas(abg);

		try {
			String[] errors = voVitalSignABG.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
			
			voVitalSignABG = domain.saveABGO2Sats(voVitalSignABG);
		} 
		catch (StaleObjectException e) 
		{
			
			open();
			form.setMode(FormMode.VIEW);
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return;
		}
		
		open();
		form.setMode(FormMode.VIEW);
	}
	
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		int index = form.grdBloodGas().getSelectedRowIndex();
		if (index < 0)
		{
			engine.showMessage("Please select a record to update");
			return;
		}
		form.getLocalContext().setCurrentABG(form.grdBloodGas().getValue());
		form.setMode(FormMode.EDIT);
		form.setcustomControlAuthoringInfoEnabled(false);
		form.btnUpdate().setEnabled(false);
	}
	protected void onBNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setCurrentABG(null);
		clearEntryControls();
		form.dtimTaken().setValue(new DateTime());
		
		form.setMode(FormMode.EDIT);
		//------------------------
		form.customControlAuthoringInfo().setIsRequiredPropertyToControls(true);
		//------------------------
		form.customControlAuthoringInfo().initializeComponent();
		form.setcustomControlAuthoringInfoEnabled(true);
		form.btnUpdate().setEnabled(false);
		form.grdBloodGas().setValue(null);
	}
	
	private void clearEntryControls()
	{
		form.customControlAuthoringInfo().initializeComponent();
		form.cmbVentilation().setValue(null);
		form.decBExcess().setValue(null);
		form.decPaCO2().setValue(null);
		form.decPaO2().setValue(null);
		form.decPh().setValue(null);
		form.decSBC().setValue(null);
		form.dtimTaken().setValue(null);
		form.intSats().setValue(null);
		
	}
	
	private void populateEntryControls(VitalSignsVo vo)
	{
		form.cmbVentilation().setValue(vo.getArterialBloodGas().getVentilationMode());
		form.decBExcess().setValue(vo.getArterialBloodGas().getBaseExcess());
		form.decPaCO2().setValue(vo.getArterialBloodGas().getPaCO2());
		form.decPaO2().setValue(vo.getArterialBloodGas().getPaO2());
		form.decPh().setValue(vo.getArterialBloodGas().getPH());
		form.decSBC().setValue(vo.getArterialBloodGas().getSBC());
		form.dtimTaken().setValue(vo.getVitalsTakenDateTime());
		form.intSats().setValue(vo.getOxygenSaturation().getOxygenSaturationLevel());
		if(vo.getAuthoringInformationIsNotNull())
			form.customControlAuthoringInfo().setValue(vo.getAuthoringInformation());
	}

	protected void onGrdBloodGasSelectionChanged() throws PresentationLogicException 
	{
		int index = form.grdBloodGas().getSelectedRowIndex();
		if (index >= 0)
		{
			form.btnUpdate().setEnabled(true);
			VitalSignsVo vo = form.grdBloodGas().getValue();
			populateEntryControls(vo);
			form.getLocalContext().setVSArterialBloodGas(vo.getArterialBloodGas());
		}
		else
			form.getLocalContext().setVSArterialBloodGas(null);		
	}
}
