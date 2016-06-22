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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.postdischargeliaison;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.enums.MosType;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.PostDischargeLiaisonVo;
import ims.emergency.vo.lookups.LetterReviewStatusCollection;
import ims.emergency.vo.lookups.PersonContacted;
import ims.framework.enumerations.FormMode;
import ims.vo.interfaces.IMos;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open(FormMode.EDIT);
	}
	
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open(FormMode.VIEW);
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open(FormMode.VIEW);
	}
	
	protected void onCmbPersonContactedValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (!PersonContacted.OTHER.equals(form.cmbPersonContacted().getValue()))
				form.txtPersonContacted().setValue(null);
		updateControlsState();
	}
	
	private void updateControlsState()
	{
      form.txtPersonContacted().setEnabled(FormMode.EDIT.equals(form.getMode()) && PersonContacted.OTHER.equals(form.cmbPersonContacted().getValue()));
      form.txtPersonContacted().setRequired(FormMode.EDIT.equals(form.getMode()) && PersonContacted.OTHER.equals(form.cmbPersonContacted().getValue()));
		
	}
	
	private void initialize()
	{
		form.chkLetterRequired().setValue(Boolean.TRUE);
		
		form.ccContactBy().initialize(MosType.HCP);
		form.ccContactBy().setValue((IMos) domain.getHcpLiteUser());
		form.ccContactBy().setMinRequiredCharsForSearch(new Integer(3));
		form.ccContactBy().isRequired(Boolean.TRUE);
		
		form.ccAllocateToHCP().initialize(MosType.HCP);
	}
	
	private void open(FormMode formMode)
	{
		populateScreenControlsFromData(form.getLocalContext().getSelectedRecord());
		form.setMode(formMode);		
	}
	private void populateScreenControlsFromData(PostDischargeLiaisonVo selectedRecord)
	{
		clearScreen();
		if (selectedRecord == null)
			return;
		form.ccContactBy().setValue(selectedRecord.getContactedBy().getAuthoringHcp());
		form.dtimContact().setValue(selectedRecord.getContactedBy().getAuthoringDateTime());
		form.cmbPersonContacted().setValue(selectedRecord.getPersonContacted());
		form.txtPersonContacted().setValue(selectedRecord.getPersonContactedText());
		form.cmbReasonForContact().setValue(selectedRecord.getReasonForContact());
		form.cmbContactMethod().setValue(selectedRecord.getContactMethod());
		form.txtComments().setValue(selectedRecord.getComments());
		
		LetterReviewStatusCollection letterStatus = new LetterReviewStatusCollection();
		letterStatus.add(selectedRecord.getLetterReviewStatus());
		form.chklistLetterReviewStatus().setValues(letterStatus);
		
		form.ccAllocateToHCP().setValue(selectedRecord.getAllocateToHCP());
		
		
	}
	private void clearScreen()
	{		
		form.dtimContact().setValue(null);
		form.cmbContactMethod().setValue(null);
		form.cmbPersonContacted().setValue(null);
		form.txtPersonContacted().setValue(null);
		form.cmbReasonForContact().setValue(null);
		form.txtComments().setValue(null);
		form.chklistLetterReviewStatus().setValues(null);
		form.ccAllocateToHCP().clear();
	}
	
	private boolean save()
	{
		String[] uiErrors = validateUIRules();
		PostDischargeLiaisonVo postDischargeDetails  = populateDataFromScreen();
		if (uiErrors != null)
		{
			engine.showErrors(uiErrors);
			return false;			
		}
		if (postDischargeDetails.validate() != null)
		{
			engine.showErrors(postDischargeDetails.validate());
			return false;
		}
		try
		{

			form.getLocalContext().setSelectedRecord(domain.save(postDischargeDetails));
		}
		catch (StaleObjectException ex)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open(FormMode.VIEW);
			return false;
		}
		return true;
	}
	private String[] validateUIRules()
	{
		if (PersonContacted.OTHER.equals(form.cmbPersonContacted().getValue()) && form.txtPersonContacted().getValue() == null)
		{
			return new String[] {"Other Person Contact is mandatory when Contact Type is set to 'Other'."};
		}
		return null;
	}
	private PostDischargeLiaisonVo populateDataFromScreen()
	{
		PostDischargeLiaisonVo voPostDischarge = new PostDischargeLiaisonVo();
		
		voPostDischarge.setContactedBy(populateAuthoringInfo());
		voPostDischarge.setContactMethod(form.cmbContactMethod().getValue());
		voPostDischarge.setLetterReviewStatus(form.chklistLetterReviewStatus().getValues() != null ? form.chklistLetterReviewStatus().getValues().get(0) : null);
		voPostDischarge.setComments(form.txtComments().getValue());
		voPostDischarge.setPersonContacted(form.cmbPersonContacted().getValue());
		voPostDischarge.setPersonContactedText(form.txtPersonContacted().getValue());
		voPostDischarge.setReasonForContact(form.cmbReasonForContact().getValue());
		voPostDischarge.setAllocateToHCP((HcpLiteVo) form.ccAllocateToHCP().getValue());
		
		return voPostDischarge;
	}
	private AuthoringInformationVo populateAuthoringInfo()
	{
		AuthoringInformationVo authoringInfo = new AuthoringInformationVo();
		authoringInfo.setAuthoringDateTime(form.dtimContact().getValue());
		authoringInfo.setAuthoringHcp((HcpLiteVo) form.ccContactBy().getValue());
		
		return authoringInfo;
	}
	
}
