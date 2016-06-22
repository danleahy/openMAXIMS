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
// This code was generated by Mara Iroaie using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.internalreferraladmineventdialog;

import java.util.ArrayList;
import ims.clinical.vo.ClinicalReferralForAdminEventVo;
import ims.clinical.vo.ClinicalReferralStatusForEventDialogVo;
import ims.clinical.vo.lookups.ClinicalReferralType;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.RecordingUserInformationVo;
import ims.core.vo.lookups.InternalReferralStatus;
import ims.core.vo.lookups.InternalReferralStatusCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setlcSelectedReferralDetails(null);
		form.getLocalContext().setlcPreviousStatus(null);
		open();
	}
	
	private void open()
	{
		ClinicalReferralForAdminEventVo referralDetails = null;
		if(form.getGlobalContext().Clinical.getClinicalReferralRefIsNotNull())
			referralDetails = domain.getReferralDetails(form.getGlobalContext().Clinical.getClinicalReferralRef());
	
		if (referralDetails == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return;
		}
		
		form.getLocalContext().setlcSelectedReferralDetails(referralDetails);
		
		populateScreenFromData(referralDetails);	
	}

	private void populateScreenFromData(ClinicalReferralForAdminEventVo referralDetails) 
	{
		form.lblCurrentStatus().setValue(referralDetails.getCurrentReferralStatus() != null ? referralDetails.getCurrentReferralStatus().getReferralStatus().getText() : " ");
		initializeNewStatusCombo(referralDetails.getCurrentReferralStatus(), referralDetails.getReferralType());
	}
	
	private void initializeNewStatusCombo(ClinicalReferralStatusForEventDialogVo currentReferralStatus, ClinicalReferralType clinicalReferralType) 
	{
		form.cmbNewStatus().clear();
		
		InternalReferralStatusCollection referralStatus = ims.core.vo.lookups.LookupHelper.getInternalReferralStatus(domain.getLookupService());
		
		for (int i = 0; i < referralStatus.size(); i ++)
		{
			if (InternalReferralStatus.ABANDONED.equals(referralStatus.get(i)) ||
				(currentReferralStatus != null && currentReferralStatus.getReferralStatus() != null && currentReferralStatus.getReferralStatus().equals(referralStatus.get(i))))
				continue;
			
			form.cmbNewStatus().newRow(referralStatus.get(i), referralStatus.get(i).getText());
		}
		
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			engine.close(DialogResult.OK);
	}

	private boolean save() 
	{
		if (!validateUIRules())
			return false;
				
		ClinicalReferralForAdminEventVo referralDetais = updateReferralStatus((ClinicalReferralForAdminEventVo) form.getLocalContext().getlcSelectedReferralDetails().clone());
		
		String[] errors = referralDetais.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{			
			domain.saveReferral(referralDetais);
			
		}catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}

		return true;
	}

	private ClinicalReferralForAdminEventVo updateReferralStatus(ClinicalReferralForAdminEventVo referralDetais)
	{
		referralDetais.setCurrentReferralStatus(createNewCurrentStatus());
		referralDetais.getHistoryOfReferralStatus().add(referralDetais.getCurrentReferralStatus());
		
//		if(InternalReferralStatus.ACCEPTED_APPOINTMENT_REQUIRED.equals(form.cmbNewStatus().getValue()))
//		{
//			referralDetais.setBookedAppt(null);
//		}
			
		if(InternalReferralStatus.ACCEPTED.equals(form.cmbNewStatus().getValue())	&& 
		   (ClinicalReferralType.IP_TO_BE_SEEN_AS_OUTPATIENT.equals(form.getLocalContext().getlcSelectedReferralDetails().getReferralType()) ||
			ClinicalReferralType.OP_TO_BE_SEEN_AS_OUTPATIENT.equals(form.getLocalContext().getlcSelectedReferralDetails().getReferralType())))
		{
			//referralDetais.setBookedAppt(true);
		}
		
		if (InternalReferralStatus.REJECTED.equals(form.cmbNewStatus().getValue()))
		{
			referralDetais.setAcknowledgeRejection(false);
		}
		
		if (InternalReferralStatus.AWAITING_AUTHORISATION.equals(form.cmbNewStatus().getValue()))
		{
			referralDetais.setAuthorisingInfo(null);
		}

		return referralDetais;
	}

	private ClinicalReferralStatusForEventDialogVo createNewCurrentStatus()
	{
		ClinicalReferralStatusForEventDialogVo newStatus = new ClinicalReferralStatusForEventDialogVo();
		
		newStatus.setReferralStatus(form.cmbNewStatus().getValue());

		newStatus.setInternalReferralStatusChangeReason(form.cmbCangeReason().getValue());
	
		RecordingUserInformationVo recordingInformation = new RecordingUserInformationVo();
		recordingInformation.setRecordingDateTime(new DateTime());
		recordingInformation.setRecordingUser((MemberOfStaffLiteVo) domain.getMosUser());
		newStatus.setRecordingInfo(recordingInformation);
		
		return newStatus;
	}

	private boolean validateUIRules()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.cmbNewStatus().getValue() == null)
		{
			errors.add("New status is mandatory!");
		}
		
		if (form.cmbCangeReason().getValue() == null)
		{
			errors.add("Reason for changing the status is mandatory!");
		}
		
		int errorCount = errors.size();
		String[] result = new String[errorCount];

		for (int i = 0; i < errorCount; i++)
			result[i] = (String) errors.get(i);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}
	
}
