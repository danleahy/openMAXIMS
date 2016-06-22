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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.51 build 2469.17966)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.planofcareactionsreview;


import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.enums.AuthoringLabelType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.nursing.vo.PlanOfCareActionsVo;
import ims.nursing.vo.PlanOfCareActionsVoCollection;
import ims.nursing.vo.PlanOfCareNotingVo;
import ims.nursing.vo.lookups.PlanOfCareActionStatus;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
			open();
	}

	private void initialize() 
	{
		form.customReviewing().setLabels(AuthoringLabelType.REVIEWING);
		populateCustomControls();
	}

	private void populateCustomControls() 
	{
		PlanOfCareNotingVo voItem = form.getGlobalContext().getPlanOfCareActionsReview();
		
		if (voItem.getAuthoringInformationIsNotNull())
		{
			AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo();
			voAuthoringInformation.setAuthoringDateTime(voItem.getAuthoringInformation().getAuthoringDateTime());
			voAuthoringInformation.setAuthoringHcp(voItem.getAuthoringInformation().getAuthoringHcp());
			form.customAuthoring().setValue(voAuthoringInformation);
		}
		
		if (voItem.getReviewingDateTimeIsNotNull() &&
				voItem.getReviewingHCPIsNotNull())
		{
			AuthoringInformationVo voReviewingInformation = new AuthoringInformationVo();
			voReviewingInformation.setAuthoringDateTime(voItem.getReviewingDateTime());
			voReviewingInformation.setAuthoringHcp(voItem.getReviewingHCP());
			form.customReviewing().setValue(voReviewingInformation);
		}	
		else
		{
			form.customReviewing().initializeComponent();
		}
		form.setcustomAuthoringEnabled(false);
		form.setcustomReviewingEnabled(false);
	}

	private void open()
	{
		PlanOfCareNotingVo voItem = form.getGlobalContext().getPlanOfCareActionsReview();
		PlanOfCareActionsVoCollection voColl = voItem.getActions(); 
				
		if(voColl != null)
		{
			for(int i = 0; i < voColl.size(); i++)
			{
				addNewActionRowRecord(voColl.get(i));
			}
		}		
	}
	
	private void addNewActionRowRecord(PlanOfCareActionsVo record) 
	{
		if(record == null)
			return;
			
		GenForm.grdActionReviewRow row = form.grdActionReview().getRows().newRow();
			
		row.setColPOC(record.getPlanOfCare().getTitle());
		row.setColAction(record.getAction());
		if (record.getReview() != null)
			row.setColReview(record.getReview());
		else
			row.setColReview("");
		row.setValue(record);		
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}
	private boolean save() 
	{
		PlanOfCareActionsVoCollection recordColl = populateDataFromScreen();
		PlanOfCareNotingVo recordNoting = populateDataFromScreenForNoting(recordColl);
		
		String[] uiErrors = getUiErrors();
		String[] errors = recordNoting.validate(uiErrors);
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);	
			return false;
		}
		
		try
		{	
			domain.saveActionsReview(recordColl, recordNoting);
		}
		
		catch(StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			
			return false;
		}
		
		return true;
	}

	private PlanOfCareNotingVo populateDataFromScreenForNoting(PlanOfCareActionsVoCollection recordColl) 
	{
		PlanOfCareNotingVo pocNoting = form.getGlobalContext().getPlanOfCareActionsReview();
//		POCNoting CareContext
		pocNoting.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo();
		voAuthoringInformation.setAuthoringDateTime(form.customAuthoring().getValue().getAuthoringDateTime());
		voAuthoringInformation.setAuthoringHcp(form.customAuthoring().getValue().getAuthoringHcp());
		pocNoting.setAuthoringInformation(voAuthoringInformation);
		
		//POCNoting ReviewingHCP ReviewingDateTime
		pocNoting.setReviewingDateTime(form.customReviewing().getValue().getAuthoringDateTime());
		pocNoting.setReviewingHCP(form.customReviewing().getValue().getAuthoringHcp());
			
		pocNoting.setActionStatus(PlanOfCareActionStatus.ACTIVE);
		
		pocNoting.setActions(recordColl);
		
		return pocNoting;
	}

	private PlanOfCareActionsVoCollection populateDataFromScreen() 
	{
		PlanOfCareActionsVoCollection voColl = form.getGlobalContext().getPlanOfCareActionsReview().getActions();
	
		for(int x = 0; x <form.grdActionReview().getRows().size(); x++)
		{
			PlanOfCareActionsVo rowValue = form.grdActionReview().getRows().get(x).getValue();
			String actionReview = form.grdActionReview().getRows().get(x).getColReview();
		
			if (rowValue != null && actionReview != null && actionReview.length() > 0)
			{
				AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo();
				voAuthoringInformation.setAuthoringDateTime(form.customAuthoring().getValue().getAuthoringDateTime());
				voAuthoringInformation.setAuthoringHcp(form.customAuthoring().getValue().getAuthoringHcp());
				
				rowValue.setAuthoringInformation(voAuthoringInformation);
				rowValue.setReview(actionReview);
//				POCNoting ReviewingHCP ReviewingDateTime
				rowValue.setReviewingDateTime(form.customReviewing().getValue().getAuthoringDateTime());
				rowValue.setReviewingHCP(form.customReviewing().getValue().getAuthoringHcp());
					

				voColl.add(rowValue);
			}				
		}	
		
		return voColl;
	}

	private String[] getUiErrors() 
	{
		ArrayList errors = new ArrayList();
			
		if (form.customAuthoring().getValue() != null) 
		{
			if (form.customAuthoring().getValue().getAuthoringHcp() == null) 
			{
				errors.add("Authoring Hcp is mandatory");
			}
			if (form.customAuthoring().getValue() .getAuthoringDateTime() == null) 
			{
				errors.add("Authoring Date/Time is mandatory");
			}
		}
		
		if (form.customReviewing().getValue() != null) 
		{
			if (form.customReviewing().getValue().getAuthoringHcp() == null) 
			{
				errors.add("Reviewing Hcp is mandatory");
			}
			if (form.customReviewing().getValue() .getAuthoringDateTime() == null) 
			{
				errors.add("Reviewing Date/Time is mandatory");
			}
		}
		
		if (errors.size() > 0) 
		{
			String[] searchErrors = new String[errors.size()];
			errors.toArray(searchErrors);
			engine.showErrors("Invalid 	PlanOfCare Actions", searchErrors);
			return searchErrors;
		}
		return null;
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
