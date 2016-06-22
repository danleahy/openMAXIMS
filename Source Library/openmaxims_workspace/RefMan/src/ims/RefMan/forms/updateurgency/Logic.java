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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5443.18271)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.updateurgency;

import ims.RefMan.forms.updateurgency.GenForm.grdUrgencyRow;
import ims.RefMan.vo.CatsReferralForChangeUrgencyVo;
import ims.RefMan.vo.ReferalDetailsForChangeUrgencyVo;
import ims.RefMan.vo.ReferralUrgencyUpdatesVo;
import ims.RefMan.vo.ReferralUrgencyUpdatesVoCollection;
import ims.RefMan.vo.lookups.ReferralUrgency;
import ims.RefMan.vo.lookups.ReferralUrgencyCollection;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.ReferralSourceUrgencyVo;
import ims.core.vo.ReferralSourceUrgencyVoCollection;
import ims.core.vo.lookups.SourceOfReferral;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.vo.LookupInstVo;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise(args);
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setCatsReferral(domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral()));
		
		populateScreenFromData(form.getLocalContext().getCatsReferral());
		
		if(form.getLocalContext().getFormMode() != null)
		{
			form.setMode(form.getLocalContext().getFormMode());
		}
		
		updateControlsState();
	}

	private void updateControlsState()
	{
		if(form.getLocalContext().getCatsReferral() == null)
			return;
		
		ReferralUrgency currentUrgency = form.getLocalContext().getCatsReferral().getUrgency();
		SourceOfReferral sourceOfReferral = form.getLocalContext().getCatsReferral().getReferralDetails() != null ? form.getLocalContext().getCatsReferral().getReferralDetails().getReferrerType() : null;
		
		form.btnDowngradeUrgency().setVisible(engine.hasRight(AppRight.REFERRALS_CAN_PERFORM_DOWNGRADE) && FormMode.EDIT.equals(form.getMode()) && ReferralUrgency.TWO_WEEK_WAIT.equals(currentUrgency));
		form.btnConsultantUprade().setVisible(engine.hasRight(AppRight.REFERRALS_CAN_PERFORM_CONSULTANT_UPGRADE) && FormMode.EDIT.equals(form.getMode()) && !ReferralUrgency.TWO_WEEK_WAIT.equals(currentUrgency) && !SourceOfReferral.NATIONAL_SCREENING.equals(sourceOfReferral) && !ReferralUrgency.CONSULTANT_UPGRADE.equals(currentUrgency));
		
		form.cmbUrgency().setVisible(FormMode.EDIT.equals(form.getMode()));
		form.cmbUrgency().setEnabled((!ReferralUrgency.TWO_WEEK_WAIT.equals(currentUrgency) || Boolean.TRUE.equals(form.getLocalContext().getIsDowngradeUrgency())) && !Boolean.TRUE.equals(form.getLocalContext().getIsConsultantUpgrade()));
		form.btnConsultantUprade().setEnabled(!Boolean.TRUE.equals(form.getLocalContext().getIsConsultantUpgrade()) && Boolean.TRUE.equals(form.getLocalContext().getIsConsultantUpgradeActive()));
		form.btnDowngradeUrgency().setEnabled(!Boolean.TRUE.equals(form.getLocalContext().getIsDowngradeUrgency()));
		
		form.lblConsultantUpgradeDate().setVisible(FormMode.EDIT.equals(form.getMode()) && Boolean.TRUE.equals(form.getLocalContext().getIsConsultantUpgrade()));
		form.dteConsultantUpgrade().setVisible(FormMode.EDIT.equals(form.getMode()) && Boolean.TRUE.equals(form.getLocalContext().getIsConsultantUpgrade()));
	}

	private void populateScreenFromData(CatsReferralForChangeUrgencyVo catsReferral)
	{
		clear();
		
		if(catsReferral == null)
			return;
		
		form.lblUrgency().setValue(catsReferral.getUrgency() != null ? catsReferral.getUrgency().getText() : null);
		populateUrgencyGrid(catsReferral.getUrgencyUpdateHistory());
	}

	private void clear()
	{
		form.grdUrgency().getRows().clear();
	}

	private void populateUrgencyGrid(ReferralUrgencyUpdatesVoCollection coll)
	{
		form.grdUrgency().getRows().clear();
		
		if(coll == null)
			return;
		
		for(ReferralUrgencyUpdatesVo urgency : coll)
		{
			addUrgencyRow(urgency);
		}
	}

	private void addUrgencyRow(ReferralUrgencyUpdatesVo urgency)
	{
		if(urgency == null)
			return;
		
		grdUrgencyRow row = form.grdUrgency().getRows().newRow();	
		
		row.setColUrgency(urgency.getUrgency() != null ? urgency.getUrgency().getText() : null);
		row.setCellColUrgencyTooltip(urgency.getUrgency() != null ? urgency.getUrgency().getText() : null); //WDEV-23398
		
		row.setColChangedBy(urgency.getRecordingUser() != null ? urgency.getRecordingUser().getIMosName() : null);
		row.setCellColChangedByTooltip(urgency.getRecordingUser() != null ? urgency.getRecordingUser().getIMosName() : null); //WDEV-23398
		
		row.setColRecordingDate(urgency.getRecordingDateTime() != null ? urgency.getRecordingDateTime().toString() : null); //WDEV-23398
		row.setCellColRecordingDateTooltip(urgency.getRecordingDateTime() != null ? urgency.getRecordingDateTime().toString() : null); //WDEV-23398
		
		row.setColReason(urgency.getReasonForChangeUrgency() != null ? urgency.getReasonForChangeUrgency().getText() : null);
		row.setCellColReasonTooltip(urgency.getReasonForChangeUrgency() != null ? urgency.getReasonForChangeUrgency().getText() : null); //WDEV-23398
		
		row.setValue(urgency);
	}

	private void initialise(Object[] args)
	{
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof FormMode)
			{
				form.getLocalContext().setFormMode((FormMode) args[0]);
			}
		}
		
		Object user = domain.getMosUser();
		
		if(user instanceof MemberOfStaffLiteVo)
		{
			form.lblUpdatedBy().setValue(((MemberOfStaffLiteVo) user).getIMosName());
		}
		
		//WDEV-21034
//		bindCmbUrgencyLookup();
		bindCmbUrgencyLookup(form.getLocalContext().getCatsReferral());
		
		form.lblUpdatedDate().setValue((new DateTime()).toString());
		
		LookupInstVo consultantUpgrade = domain.getLookupService().getLookupInstance(ReferralUrgency.class, ReferralUrgency.CONSULTANT_UPGRADE.getID());
		form.getLocalContext().setIsConsultantUpgradeActive(consultantUpgrade != null && consultantUpgrade.isActive());
	}
	
	//WDEV-21034
	private void bindCmbUrgencyLookup(CatsReferralForChangeUrgencyVo catsReferral)
	{
		form.getLocalContext().setSourceOfReferralConfiguration(domain.getSourceOfReferralConfigVoColl());
		form.getLocalContext().setCatsReferral(domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral()));
		
		form.cmbUrgency().clear();
			
		if (form.getLocalContext().getCatsReferral().getUrgency() != null)
		{
			SourceOfReferral srcOfReferral = form.getLocalContext().getCatsReferral().getReferralDetails().getReferrerType();
			if( srcOfReferral != null)
			{
				ReferralSourceUrgencyVo referralSrcUrgencyVo = getSourceReferralUrgencyVo(srcOfReferral, form.getLocalContext().getSourceOfReferralConfiguration());
				if( referralSrcUrgencyVo != null
						&& referralSrcUrgencyVo.getUrgencyIsNotNull()
						&& referralSrcUrgencyVo.getUrgency().size() > 0)
				{
					for (int h = 0; h < referralSrcUrgencyVo.getUrgency().size(); h++ )
					{
						if(referralSrcUrgencyVo.getUrgency().get(h) == null || !referralSrcUrgencyVo.getUrgency().get(h).isActive())
							continue;
						
						if (referralSrcUrgencyVo.getUrgency().get(h).getID() != form.getLocalContext().getCatsReferral().getUrgency().getID()
								&& ! (ReferralUrgency.TWO_WEEK_WAIT.equals(referralSrcUrgencyVo.getUrgency().get(h)) 
										|| ReferralUrgency.CONSULTANT_UPGRADE.equals(referralSrcUrgencyVo.getUrgency().get(h)) 
										|| ReferralUrgency.NATIONAL_SCREENING.equals(referralSrcUrgencyVo.getUrgency().get(h))))
						{
							form.cmbUrgency().newRow(referralSrcUrgencyVo.getUrgency().get(h), referralSrcUrgencyVo.getUrgency().get(h).getText());
						}
					}
				}
			}
		}
	}

	//WDEV-21034
	private ReferralSourceUrgencyVo getSourceReferralUrgencyVo(SourceOfReferral srcOfReferral, ReferralSourceUrgencyVoCollection  referralSrcUrgencyColl)
	{
		if( srcOfReferral != null 
				&& referralSrcUrgencyColl != null 
				&& referralSrcUrgencyColl.size() > 0)
		{
			for (int i = 0; i < referralSrcUrgencyColl.size(); i++)
			{
				ReferralSourceUrgencyVo referralSrcUrgencyVo = referralSrcUrgencyColl.get(i); 
				if( referralSrcUrgencyVo != null 
						&& srcOfReferral!= null 
						&& srcOfReferral.equals(referralSrcUrgencyVo.getSourceOfReferral()))
					return referralSrcUrgencyVo;
			}
		}
		return null;
	} 

	private void bindCmbUrgencyLookup()
	{
		form.cmbUrgency().clear();
		
		ReferralUrgencyCollection lookupCollection = ims.RefMan.vo.lookups.LookupHelper.getReferralUrgency(this.domain.getLookupService());
		
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			if(lookupCollection.get(x) == null || ReferralUrgency.TWO_WEEK_WAIT.equals(lookupCollection.get(x)) || ReferralUrgency.CONSULTANT_UPGRADE.equals(lookupCollection.get(x)) || ReferralUrgency.NATIONAL_SCREENING.equals(lookupCollection.get(x)))
				continue;
			
			form.cmbUrgency().newRow(lookupCollection.get(x), lookupCollection.get(x).getText());
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save(false))
			engine.close(DialogResult.OK);
	}

	private boolean save(boolean onMessageBoxConfirm)
	{
		ReferralUrgency prevUrgency = form.getLocalContext().getCatsReferral() != null ? ((CatsReferralForChangeUrgencyVo) form.getLocalContext().getCatsReferral().clone()).getUrgency() : null;
		boolean urgencyChanged =  onMessageBoxConfirm ? true : prevUrgency != null && !ReferralUrgency.EMERGENCY.equals(prevUrgency) && ReferralUrgency.EMERGENCY.equals(form.cmbUrgency().getValue());
		
		CatsReferralForChangeUrgencyVo catsReferral = populateDataFromScreen(form.getLocalContext().getCatsReferral());
		
		String[] errors = catsReferral.validate(validateUIRules());
		
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		if (urgencyChanged && !onMessageBoxConfirm)
		{
			form.getLocalContext().setMessageBoxChangedToEmergency(engine.showMessage(getReferralChangeUrgencyMessage(catsReferral.getReferralDetails()), "Change Urgency", MessageButtons.YESNO, MessageIcon.QUESTION));
			return false;
		}
		
		try
		{
			domain.saveCatsReferral(catsReferral, form.getLocalContext().getIsDowngradeUrgency(), form.getLocalContext().getIsConsultantUpgrade(), Boolean.TRUE.equals(form.getLocalContext().getIsConsultantUpgrade()) ? form.dteConsultantUpgrade().getValue() : null, urgencyChanged);
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}

	private String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if(form.dteConsultantUpgrade().isVisible() && form.dteConsultantUpgrade().getValue() == null)
		{
    		uiErrors.add("Consultant Upgrade Date is mandatory.");
		}
		
		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);
		
		return uiResults;
	}
	private String getReferralChangeUrgencyMessage(ReferalDetailsForChangeUrgencyVo referalDetailsForChangeUrgencyVo)
	{
		if (referalDetailsForChangeUrgencyVo == null)
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append("Are you sure that you want to change this to an emergency referral?");
	
		if (referalDetailsForChangeUrgencyVo.getEnd18WWIsNotNull())  
				sb.append("\nThis action will remove all RTT related information.");			
	
		return sb.toString();
	}	
	private CatsReferralForChangeUrgencyVo populateDataFromScreen(CatsReferralForChangeUrgencyVo catsReferral)
	{
		if(catsReferral == null)
			return null;
		else
			catsReferral = (CatsReferralForChangeUrgencyVo) catsReferral.clone();
		
		catsReferral.setUrgency(form.cmbUrgency().getValue());
		
		if(catsReferral.getUrgencyUpdateHistory() == null)
		{
			catsReferral.setUrgencyUpdateHistory(new ReferralUrgencyUpdatesVoCollection());
		}
		
		catsReferral.getUrgencyUpdateHistory().add(createReferralUrgencyUpdateRecord());
		
		return catsReferral;
	}

	private ReferralUrgencyUpdatesVo createReferralUrgencyUpdateRecord()
	{
		ReferralUrgencyUpdatesVo record = new ReferralUrgencyUpdatesVo();
		
		record.setUrgency(form.cmbUrgency().getValue());
		record.setReasonForChangeUrgency(form.cmbReason().getValue());
		record.setReason(form.txtComments().getValue());
		record.setRecordingDateTime(new DateTime());
		
		Object user = domain.getMosUser();
		
		if(user instanceof MemberOfStaffLiteVo)
		{
			record.setRecordingUser((MemberOfStaffLiteVo) user);
		}
		
		return record;
	}

	@Override
	protected void onBtnDowngradeUrgencyClick() throws PresentationLogicException
	{
		form.getLocalContext().setIsDowngradeUrgency(true);
		form.getLocalContext().setIsConsultantUpgrade(null);
		
		updateControlsState();
	}

	@Override
	protected void onBtnConsultantUpradeClick() throws PresentationLogicException
	{
		form.cmbUrgency().newRow(ReferralUrgency.CONSULTANT_UPGRADE, ReferralUrgency.CONSULTANT_UPGRADE.getText());
		form.cmbUrgency().setValue(ReferralUrgency.CONSULTANT_UPGRADE);
		
		form.getLocalContext().setIsDowngradeUrgency(null);
		form.getLocalContext().setIsConsultantUpgrade(true);
		
		updateControlsState();
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (form.getLocalContext().getMessageBoxChangedToEmergencyIsNotNull() && form.getLocalContext().getMessageBoxChangedToEmergency().equals(messageBoxId))
		{
			form.getLocalContext().setMessageBoxChangedToEmergency(null);
			if (DialogResult.YES.equals(result))
			{	
				if(save(true))
					engine.close(DialogResult.OK);
			}
		}		
	}
}
