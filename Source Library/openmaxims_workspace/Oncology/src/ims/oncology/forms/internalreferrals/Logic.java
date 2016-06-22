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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3909.24643)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.oncology.forms.internalreferrals;

import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.oncology.forms.internalreferrals.GenForm.GroupStatusEnumeration;
import ims.oncology.forms.internalreferrals.GenForm.grdListRow;
import ims.oncology.vo.InternalReferralVoCollection;
import ims.oncology.vo.InternalReferralsSearchCriteriaVo;


public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	private static final int LIST_ALL			= 2;
	private static final int LIST_ACTIVE		= 1;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.GroupStatus().setValue(GroupStatusEnumeration.rdoCurrent);
		
		//WDEV-19389 
		if (!(form.getGlobalContext().Core.getPatientShortIsNotNull() && form.getGlobalContext().Oncology.getInternalReferralsSearchCriteriaIsNotNull() && form.getGlobalContext().Oncology.getInternalReferralsSearchCriteria().getPatientIsNotNull() && form.getGlobalContext().Core.getPatientShort().equals(form.getGlobalContext().Oncology.getInternalReferralsSearchCriteria().getPatient())))
			form.getGlobalContext().Oncology.setInternalReferralsSearchCriteria(null);
		
		if(form.getGlobalContext().Oncology.getInternalReferralsSearchCriteriaIsNotNull())
		{
			setSearchCriteria(form.getGlobalContext().Oncology.getInternalReferralsSearchCriteria());
			onRadioButtonGroupStatusValueChanged();

		}
		else
			open(true);
		//WDEV-19389 - end
	}
	
	private InternalReferralsSearchCriteriaVo getSearchCriteria()
	{
		InternalReferralsSearchCriteriaVo searchCriteria = new InternalReferralsSearchCriteriaVo();
		
		searchCriteria.setViewType(getViewType());
		searchCriteria.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(InternalReferralsSearchCriteriaVo internalReferralsSearchCriteriaVo)
	{
		setViewType(internalReferralsSearchCriteriaVo.getViewType());		
	}

	private void setViewType(Integer searchType)
	{
		if (searchType == null)
			return;
		
		switch (searchType)
		{
		case LIST_ALL:
			form.GroupStatus().setValue(GroupStatusEnumeration.rdoAll);
			break;
		case LIST_ACTIVE:
			form.GroupStatus().setValue(GroupStatusEnumeration.rdoCurrent);
			break;
		}				
	}
	
	private Integer getViewType()
	{
		GroupStatusEnumeration searchType = form.GroupStatus().getValue();
		if (GroupStatusEnumeration.rdoAll.equals(searchType))
		{
			return LIST_ALL;
		}
		if (GroupStatusEnumeration.rdoCurrent.equals(searchType))
		{
			return LIST_ACTIVE;
		}
		
		return null;
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.OncologyNamespace.InternalReferrals.NEW :
				newReferral();
			break;			
			case GenForm.ContextMenus.OncologyNamespace.InternalReferrals.UPDATE:
				updateReferral();
			break;			
			default :
			break;
		}

	}

	private void open(boolean bClear) 
	{
		form.setMode(FormMode.VIEW);
		form.ccReferral().enablePrintButton(false);

		if (bClear)
			clearScreen();
		
		InternalReferralVoCollection voIR = domain.listInternalReferrals(form.getGlobalContext().Core.getPatientShort(), form.GroupStatus().getValue().equals(GroupStatusEnumeration.rdoCurrent) ? true : false);
		if (voIR != null)
			populateScreenFromData(voIR, bClear);
		else
			clearScreen();//WDEV-13181 
		
		updateContextMenus();
	}

	private void populateScreenFromData(InternalReferralVoCollection voIRColl, boolean bClear) 
	{
		form.grdList().getRows().clear();
		
		for (int i = 0 ; i < voIRColl.size() ; i++)
		{
			grdListRow row = form.grdList().getRows().newRow();
			
			row.setColDate(voIRColl.get(i).getReferralDateIsNotNull() ? voIRColl.get(i).getReferralDate().toString() : "");
			row.setColType(voIRColl.get(i).getReferralTypeIsNotNull() ? voIRColl.get(i).getReferralType().getText() : "");
			row.setColInvDate(voIRColl.get(i).getInternalReferralOutcomeIsNotNull() &&  voIRColl.get(i).getInternalReferralOutcome().getReferralOutcomeDateIsNotNull() ? voIRColl.get(i).getInternalReferralOutcome().getReferralOutcomeDate().toString() : "");
			
			row.setValue(voIRColl.get(i));

			if (! bClear
				&& form.getGlobalContext().Oncology.getInternalReferralRefIsNotNull()
				&& voIRColl.get(i).getID_InternalReferral().equals(form.getGlobalContext().Oncology.getInternalReferralRef().getID_InternalReferral()))
				form.grdList().setValue(voIRColl.get(i)); 
		}
		//WDEV-18738 
		if(form.grdList().getValue() != null)
			form.ccReferral().enablePrintButton(true);
		else
			form.ccReferral().clearComponent();//WDEV-13181
	}

	private void clearScreen() 
	{
		form.grdList().getRows().clear();
		
		form.ccReferral().clearComponent();
	}

	private void updateReferral() 
	{
		form.ccReferral().initialise(form.grdList().getValue(), true, false);
		form.setMode(FormMode.EDIT);
		updateContextMenus();
	}

	private void newReferral() 
	{
		form.grdList().setValue(null);
		form.getGlobalContext().Oncology.setInternalReferralRef(null);
		form.ccReferral().initialise(null, true, false);
		form.setMode(FormMode.EDIT);
		updateContextMenus();
	}

	@Override
	protected void onGrdListSelectionChanged() throws PresentationLogicException 
	{
		updateContextMenus();
		//WDEV-18738 
		form.ccReferral().enablePrintButton(true);
		form.getGlobalContext().Oncology.setInternalReferralRef(form.grdList().getValue());
		form.ccReferral().initialise(form.grdList().getValue(), false, false);//Opens record in View mode
	}
	
	private void updateContextMenus() 
	{
		form.getContextMenus().Oncology.hideAllInternalReferralsMenuItems();
		
		form.getContextMenus().Oncology.getInternalReferralsNEWItem().setVisible(true);
		form.getContextMenus().Oncology.getInternalReferralsNEWItem().setEnabled(true);

		form.getContextMenus().Oncology.getInternalReferralsUPDATEItem().setVisible(form.grdList().getValue() != null && form.grdList().getValue().getInternalReferralOutcome() == null);
		form.getContextMenus().Oncology.getInternalReferralsUPDATEItem().setEnabled(form.grdList().getValue() != null && form.grdList().getValue().getInternalReferralOutcome() == null);
	}

	@Override
	protected void onCcReferralValueChanged() throws PresentationLogicException
	{
		if (form.getGlobalContext().RefMan.getIsComponentInEditModeIsNotNull()
			&& form.getGlobalContext().RefMan.getIsComponentInEditMode().equals(FormMode.VIEW))
		{
			open(false);
			form.getGlobalContext().RefMan.setIsComponentInEditMode(null);
		}
	}

	@Override
	protected void onRadioButtonGroupStatusValueChanged() throws PresentationLogicException 
	{
		form.getGlobalContext().Oncology.setInternalReferralsSearchCriteria(getSearchCriteria());//WDEV-19389 
		open(true);
	}


}
