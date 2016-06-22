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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.18 build 40707.1200)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.assesssleepingmedication;

import ims.coe.vo.SleepingMedication;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		// See if there is an existing pain medication VO to display
		SleepingMedication med = form.getGlobalContext().COE.getSleepMedication();
		if (med != null)
		{
			form.comboBoxFreq().setValue(med.getFrequency());
			form.comboBoxMed().setValue(med.getSleepMedication());
			form.comboBoxRoute().setValue(med.getRoute());
			form.textBoxEffectiveFor().setValue(med.getEffectiveFor());
			form.textBoxTakenWith().setValue(med.getTakenWhen());
			form.textBoxDose().setValue(med.getDose());
			form.textBoxOther().setValue(med.getOther());

			form.comboBoxMed().setEnabled(false);
			form.textBoxOther().setEnabled(false);
			
			form.getLocalContext().setSleepMedication(med);
		}
	}
	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		 if ((form.comboBoxMed().getValue() == null) && (form.textBoxOther().getValue() == null))
		{
			engine.showMessage("Sleep Medication is a mandatory field.");
			return;
		}
		if ((form.comboBoxMed().getValue() != null) 
			&& ( (form.textBoxOther().getValue() != null) && (!form.textBoxOther().getValue().toString().equals("")) ) )
		{
			engine.showMessage("Please enter only one of Sleep Medication or Other Medication only.");
			return;
		}
		
		if ((form.comboBoxRoute().getValue() == null))
		{
			engine.showMessage("Route is a mandatory field."); 
			return;
		}
		if ((form.textBoxDose().getValue() == null))
		{
			engine.showMessage("Dose is a mandatory field."); 
			return;
		}
		if ((form.comboBoxFreq().getValue() == null))
		{
			engine.showMessage("Frequency is a mandatory field."); 
			return;
		}

		SleepingMedication med = form.getLocalContext().getSleepMedication();
		if (med == null)
			med = new SleepingMedication();
		med.setDose(form.textBoxDose().getValue());
		med.setEffectiveFor(form.textBoxEffectiveFor().getValue());
		med.setFrequency(form.comboBoxFreq().getValue());
		med.setSleepMedication(form.comboBoxMed().getValue());
		med.setOther(form.textBoxOther().getValue());
		med.setRoute(form.comboBoxRoute().getValue());
		med.setTakenWhen(form.textBoxTakenWith().getValue());
		
		if (form.chkInActive().getValue())
			med.setIsCurrentlyActive(Boolean.FALSE);
		else
			med.setIsCurrentlyActive(Boolean.TRUE);
				
		form.getGlobalContext().COE.setSleepMedication(med);
		engine.close(DialogResult.OK);
	}
	
	protected void onComboBoxMedValueChanged() throws PresentationLogicException 
	{
		form.textBoxOther().setValue(null);
		form.textBoxOther().setEnabled(false);
	}

	protected void onTextBoxOtherValueChanged() throws PresentationLogicException 
	{
		form.comboBoxMed().setEnabled(false);
	}
}
