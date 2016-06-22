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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.51 build 2467.14786)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.planofcareactions;

import java.util.ArrayList;

import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.nursing.forms.planofcareactions.GenForm;
import ims.nursing.vo.PlanOfCareActionsSearchCriteriaVo;
import ims.nursing.vo.PlanOfCareActionsVo;
import ims.nursing.vo.PlanOfCareActionsVoCollection;
import ims.nursing.vo.PlanOfCareListVo;
import ims.nursing.vo.PlanOfCareListVoCollection;
import ims.nursing.vo.PlanOfCareNotingVo;
import ims.nursing.vo.PlanOfCareNotingVoCollection;
import ims.nursing.vo.lookups.PlanOfCareActionStatus;
import ims.nursing.vo.lookups.PlanOfCareInterval;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		
		//WDEV-19389 
		if (!(form.getGlobalContext().Core.getCurrentCareContextIsNotNull() && form.getGlobalContext().Nursing.getPlanOfCareActionsSearchCriteriaIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().equals(form.getGlobalContext().Nursing.getPlanOfCareActionsSearchCriteria().getCareContext())))
		{
			form.getGlobalContext().Nursing.setPlanOfCareActionsSearchCriteria(null);
		}
		
		if(form.getGlobalContext().Nursing.getPlanOfCareActionsSearchCriteriaIsNotNull())
		{
			setSearchCriteria(form.getGlobalContext().Nursing.getPlanOfCareActionsSearchCriteria());
			form.lyr1().showtabChronological();
			form.lyr1().tabChronological().setHeaderVisible(true);
			form.lyr1().tabNewActions().setHeaderVisible(false);
			listAllActions();
			
		}
		else
			open();
		//WDEV-19389 - end
	}
	
	private void open()
	{
		form.setMode(FormMode.VIEW);
		displayTabCronological();
	}
	
	private PlanOfCareActionsSearchCriteriaVo getSearchCriteria()
	{
		PlanOfCareActionsSearchCriteriaVo searchCriteria = new PlanOfCareActionsSearchCriteriaVo();
		
		searchCriteria.setInterval(form.lyr1().tabChronological().cmbInterval().getValue());
		searchCriteria.setFromDate(form.lyr1().tabChronological().dteStart().getValue());
		searchCriteria.setToDate(form.lyr1().tabChronological().dteEnd().getValue());
		searchCriteria.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(PlanOfCareActionsSearchCriteriaVo planOfCareActionsSearchCriteriaVo)
	{
		form.lyr1().tabChronological().cmbInterval().setValue(planOfCareActionsSearchCriteriaVo.getInterval());	
		form.lyr1().tabChronological().dteStart().setValue(planOfCareActionsSearchCriteriaVo.getFromDate());
		form.lyr1().tabChronological().dteEnd().setValue(planOfCareActionsSearchCriteriaVo.getToDate());
	}
	
	private void displayTabNewActions() 
	{
		form.lyr1().showtabNewActions();
		form.lyr1().tabNewActions().setHeaderVisible(true);
		form.lyr1().tabChronological().setHeaderVisible(false);
		
		form.setMode(FormMode.EDIT);
		form.lyr1().tabNewActions().grdActions().getRows().clear();;
			
		form.lyr1().tabNewActions().customAuthoring().initializeComponent();
		form.lyr1().tabNewActions().setcustomAuthoringEnabled(false);
		
		PlanOfCareListVoCollection list = domain.listPlanOfCare
			(form.getGlobalContext().Core.getCurrentCareContext());
		
		if(list != null)
		{
			for(int i = 0; i < list.size(); i++)
			{
				addNewActionRowRecord(list.get(i));
			}
		}		
	}
		
	private boolean returnFlagStatus()
	{
		return engine.hasRight(AppRight.CAN_CONFIRM_NURSING_DOCUMENTATION);
	}
	
	private void addNewActionRowRecord(PlanOfCareListVo record) 
	{	
		if(record == null)
			return;
			
		GenForm.lyr1Layer.tabNewActionsContainer.grdActionsRow 
		row = form.lyr1().tabNewActions().grdActions().getRows().newRow();
			
		row.setColPoc(record.getTitle());
		
		if (record.getLevelOfIntervention().equals(Color.Red))
			row.setColImage(form.getImages().Core.RedSqaure);
		if (record.getLevelOfIntervention().equals(Color.Yellow))
			row.setColImage(form.getImages().Core.YellowSquare);
		if (record.getLevelOfIntervention().equals(Color.Green))
			row.setColImage(form.getImages().Core.GreenSquare);
		
		row.setValue(record);	
	}

	private boolean save() 
	{
		PlanOfCareActionsVoCollection recordColl = populateDataFromScreen();		
		
		
		
		
		if(recordColl != null)
		{
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
				domain.saveNewActions(recordColl, recordNoting);	
			}
			catch(StaleObjectException e)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				return false;
			}
		
		return true;
	
		}
		return false;	
	}
	
	private PlanOfCareNotingVo populateDataFromScreenForNoting(PlanOfCareActionsVoCollection voColl)
	{
		if (voColl == null)
			return new PlanOfCareNotingVo();
		
		PlanOfCareNotingVo pocNoting = new PlanOfCareNotingVo();
		
		pocNoting.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if ( voColl.size() != 0 && voColl.get(0).getAuthoringInformation() != null)
		{
			AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo();
			voAuthoringInformation.setAuthoringDateTime(voColl.get(0).getAuthoringInformation().getAuthoringDateTime());
			voAuthoringInformation.setAuthoringHcp(voColl.get(0).getAuthoringInformation().getAuthoringHcp());
			pocNoting.setAuthoringInformation(voAuthoringInformation);
		}
		else
		{
			AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo();
			voAuthoringInformation.setAuthoringDateTime(form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringDateTime());
			voAuthoringInformation.setAuthoringHcp(form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringHcp());
			pocNoting.setAuthoringInformation(voAuthoringInformation);
		}
		
		if (!returnFlagStatus())
		{
			pocNoting.setActionStatus(PlanOfCareActionStatus.REQUIRES_CONFIRMATION);
		}
		else
		{
			pocNoting.setActionStatus(PlanOfCareActionStatus.ACTIVE);
		}
		
		pocNoting.setActions(voColl);
		
		return pocNoting;
	}
	
	private PlanOfCareActionsVoCollection populateDataFromScreen() 
	{
		PlanOfCareActionsVoCollection coColl = new PlanOfCareActionsVoCollection();
	
		for(int x = 0; x < form.lyr1().tabNewActions().grdActions().getRows().size(); x++)
		{
			PlanOfCareListVo rowValue = form.lyr1().tabNewActions().grdActions().getRows().get(x).getValue();
			
			
			String action = form.lyr1().tabNewActions().grdActions().getRows().get(x).getColAction();
//			if(validateActionText(action))
//				return null;
			
			PlanOfCareActionsVo	newActionVo = new PlanOfCareActionsVo();
		
			if (rowValue != null && action != null && action.length() > 0)
			{
				//Authoring Component
				if (form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringDateTimeIsNotNull() &&
					form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringHcpIsNotNull())
				{
					AuthoringInformationVo voAuthoringInformation = new AuthoringInformationVo();
					voAuthoringInformation.setAuthoringDateTime(form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringDateTime());
					voAuthoringInformation.setAuthoringHcp(form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringHcp());
					newActionVo.setAuthoringInformation(voAuthoringInformation);
				}
			
				//Action
				newActionVo.setAction(action);
				
				//PlanOfCare
				newActionVo.setPlanOfCare(rowValue);
				
				//add row to collection
				coColl.add(newActionVo);
				
			}				
			
		}	
/*		String [] error = coColl.validate();
		
					
		
		if(error != null && error.length != 0)
		{
				engine.showErrors(error);
				return null;
		}*/
		
		return coColl;
	}

	private String[] getUiErrors() 
	{
		ArrayList errors = new ArrayList();
		
		if (form.lyr1().tabNewActions().customAuthoring().getValue() != null) 
		{
			if (form.lyr1().tabNewActions().customAuthoring().getValue().getAuthoringHcp() == null) 
			{
				errors.add("Authoring Hcp is mandatory");
			}
			if (form.lyr1().tabNewActions().customAuthoring().getValue() .getAuthoringDateTime() == null) 
			{
				errors.add("Authoring Date/Time is mandatory");
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

	private void displayTabCronological() 
	{
		form.lyr1().showtabChronological();
		form.lyr1().tabChronological().setHeaderVisible(true);
		form.lyr1().tabNewActions().setHeaderVisible(false);
		form.lyr1().tabChronological().grdChronological().getRows().clear();
		form.lyr1().tabChronological().cmbInterval().setValue(PlanOfCareInterval.HOURS72);
		form.lyr1().tabChronological().dteStart().setValue(null);
		form.lyr1().tabChronological().dteEnd().setValue(null);
		//list last 72 hours
		populateChronologicalGrig(domain.listSearchNoting((new DateTime()).addHours(-72), new DateTime(), form.getGlobalContext().Core.getCurrentCareContext()));
	}
		
	private void populateChronologicalGrig(PlanOfCareNotingVoCollection voPocNoting)
	{
		if (voPocNoting != null && voPocNoting.size() > 0)
		{
			for(int x = 0; x < voPocNoting.size(); x++)
			{
			
				GenForm.lyr1Layer.tabChronologicalContainer.grdChronologicalRow row = null;
 
				row = form.lyr1().tabChronological().grdChronological().getRows().newRow();
				row.setBold(true);
	
				if (voPocNoting.get(x).getReviewingDateTimeIsNotNull() &&
						voPocNoting.get(x).getReviewingHCPIsNotNull())
				{
					row.setColDateTime(voPocNoting.get(x).getAuthoringInformation().getAuthoringDateTime()+
							" "+"hrs"+" "+voPocNoting.get(x).getAuthoringInformation().getAuthoringHcp()+ 
							(voPocNoting.get(x).getActionStatusIsNotNull() ? " - "+voPocNoting.get(x).getActionStatus().getText() : "")+
							" Reviewing by: "+voPocNoting.get(x).getReviewingHCP()+" on "+voPocNoting.get(x).getReviewingDateTime());
				}
				else
				{
					row.setColDateTime(voPocNoting.get(x).getAuthoringInformation().getAuthoringDateTime()+
						" "+"hrs"+" "+voPocNoting.get(x).getAuthoringInformation().getAuthoringHcp()+ 
						(voPocNoting.get(x).getActionStatusIsNotNull() ? " - "+voPocNoting.get(x).getActionStatus().getText() : ""));
				}
				
				for(int i=0; i<voPocNoting.get(x).getActions().size(); i++)
				{	
					PlanOfCareActionsVo voPocItem = voPocNoting.get(x).getActions().get(i);
				
					GenForm.lyr1Layer.tabChronologicalContainer.grdChronologicalRow rowAction = 
						row.getRows().newRow();
				
					rowAction.setColDateTime(voPocItem.getPlanOfCare().getTitle().toUpperCase()+" - "+ voPocItem.getAction());
					rowAction.setTooltip(voPocItem.getPlanOfCare().getTitle().toUpperCase()+" - "+ voPocItem.getAction());//WDEV-15085
					
					if (voPocItem.getPlanOfCare().getLevelOfIntervention().equals(Color.Red))
					{
						rowAction.setCollapsedImage(form.getImages().Core.RedSqaure);
						rowAction.setExpandedImage(form.getImages().Core.RedSqaure);
					}
					
					if (voPocItem.getPlanOfCare().getLevelOfIntervention().equals(Color.Yellow))
					{
						rowAction.setCollapsedImage(form.getImages().Core.YellowSquare);
						rowAction.setExpandedImage(form.getImages().Core.YellowSquare);	
					}
					if (voPocItem.getPlanOfCare().getLevelOfIntervention().equals(Color.Green))
					{
						rowAction.setCollapsedImage(form.getImages().Core.GreenSquare);
						rowAction.setExpandedImage(form.getImages().Core.GreenSquare);
					}
									
					rowAction.setColComments(voPocItem.getReview());
					
					rowAction.setValue(voPocNoting.get(x));
				}
				
				row.setValue(voPocNoting.get(x));
				row.setExpanded(true);
			}
		}
	}
	
	private void initialize()
	{	
		//displayPocListTabOnly();
		//form.getContextMenus().getPlanOfCareNEWPOCItem().setVisible(true);
	}
	
	protected void onFormModeChanged()
	{
		// TODO Add your code here.
	}
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();
		form.getGlobalContext().Nursing.setPlanOfCareActionsSearchCriteria(null); //WDEV-19389 
	}
	private void clear() 
	{
		form.lyr1().tabChronological().grdChronological().getRows().clear();
		form.lyr1().tabChronological().cmbInterval().setValue(PlanOfCareInterval.HOURS72);
		//wdev-10721
		form.lyr1().tabChronological().dteStart().setValue(null);
		form.lyr1().tabChronological().dteEnd().setValue(null);
		//----------
	}

	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		listAllActions();
	}
	
	private void listAllActions() 
	{
		form.lyr1().tabChronological().grdChronological().getRows().clear();

		if (form.lyr1().tabChronological().cmbInterval().getValue() == null &&
				form.lyr1().tabChronological().dteStart().getValue() == null && 
				form.lyr1().tabChronological().dteEnd().getValue() == null)
		{
			engine.showMessage("Please enter some search criteria !");
			return;
		}
			
		DateTime startDate = null;
		DateTime endDate = null;

		if (form.lyr1().tabChronological().cmbInterval().getValue() != null)
		{
			PlanOfCareInterval hours = form.lyr1().tabChronological().cmbInterval().getValue();
			
			int hoursInput = -72;
			if (hours.equals(PlanOfCareInterval.HOURS12))
				hoursInput = -12;
			else if (hours.equals(PlanOfCareInterval.HOURS24))
				hoursInput = -24;
			else if (hours.equals(PlanOfCareInterval.HOURS36))
				hoursInput = -36;
			else if (hours.equals(PlanOfCareInterval.HOURS48))
				hoursInput = -48;
			else if (hours.equals(PlanOfCareInterval.HOURS72))
				hoursInput = -72;
			
			startDate = new DateTime().addHours(hoursInput);
			endDate = new DateTime();
			populateChronologicalGrig(domain.listSearchNoting(startDate, endDate, form.getGlobalContext().Core.getCurrentCareContext()));
			
			if(form.lyr1().tabChronological().grdChronological().getRows().size() == 0)
				engine.showMessage("No records found.");
		}
		else
		{
			if (form.lyr1().tabChronological().dteStart().getValue() != null 
					&& form.lyr1().tabChronological().dteEnd().getValue() != null 
					&& form.lyr1().tabChronological().dteStart().getValue().isGreaterThan(
							form.lyr1().tabChronological().dteEnd().getValue()))
			{
				engine.showMessage("The Start Date is greater than End Date!");
				return;
			}
			else
			{
				Time timeStart = new Time(0, 0), timeEnd = new Time(23, 59);

				if(form.lyr1().tabChronological().dteStart().getValue() != null)
					startDate = new DateTime(form.lyr1().tabChronological().dteStart().getValue(), timeStart);
				
				if(form.lyr1().tabChronological().dteEnd().getValue() != null)
					endDate = new DateTime(form.lyr1().tabChronological().dteEnd().getValue(), timeEnd);

				populateChronologicalGrig(domain.listSearchNoting(startDate, endDate, form.getGlobalContext().Core.getCurrentCareContext()));

				if(form.lyr1().tabChronological().grdChronological().getRows().size() == 0)
					engine.showMessage("No records found.");
			}		
		}
		
		form.getGlobalContext().Nursing.setPlanOfCareActionsSearchCriteria(getSearchCriteria()); //WDEV-19389 
		//clear dte
		//form.lyr1().tabChronological().dteStart().setValue(null);
		//form.lyr1().tabChronological().dteEnd().setValue(null);	
	}
	
	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.VIEW);
		form.lyr1().showtabChronological();
		form.lyr1().tabChronological().setHeaderVisible(true);
		form.lyr1().tabNewActions().setHeaderVisible(false);
	}

	protected void onBtnNewClick() throws PresentationLogicException 
	{
		displayTabNewActions();
	}

	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		if (save())
			open();
	}

	protected void onGrdChronologicalSelectionChanged() throws PresentationLogicException 
	{
		if (form.lyr1().tabChronological().grdChronological().getSelectedRow().getValue() != null)
		{
			PlanOfCareNotingVo voItem = form.lyr1().tabChronological().grdChronological().getSelectedRow().getValue();
			
			if (voItem.getActionStatusIsNotNull() &&
					voItem.getActionStatus().equals(PlanOfCareActionStatus.REQUIRES_CONFIRMATION) &&
					returnFlagStatus())
			{
				if (voItem.getActionStatus().equals(PlanOfCareActionStatus.REQUIRES_CONFIRMATION))
				{
					form.getContextMenus().getGenericGridAddItem().setText("Review Actions");
					form.getContextMenus().getGenericGridAddItem().setVisible(true);
				}
				else
				{
					form.getContextMenus().getGenericGridAddItem().setVisible(false);
					
				}
			}
			else
			{
				form.getContextMenus().getGenericGridAddItem().setVisible(false);
			}
			form.getGlobalContext().setPlanOfCareActionsReview(voItem);
		}
	}
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if (sender == null)
			throw new CodingRuntimeException("sender is null : onContextMenuItemClick");
		if (sender.equals(form.lyr1().tabChronological().grdChronological()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add :
					openForm();
					break;			
			}
		}
	}

	private void openForm() 
	{
		engine.open(form.getForms().Nursing.PlanOfCareActionsReview);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		initialize();
			open();
	}

	@Override
	protected void onCmbIntervalValueChanged() throws PresentationLogicException
	{
		form.lyr1().tabChronological().dteStart().setValue(null);
		form.lyr1().tabChronological().dteEnd().setValue(null);
	}

	@Override
	protected void onDteEndValueChanged() throws PresentationLogicException
	{
		form.lyr1().tabChronological().cmbInterval().setValue(null);
	}

	@Override
	protected void onDteStartValueChanged() throws PresentationLogicException
	{
		form.lyr1().tabChronological().cmbInterval().setValue(null);
	}
//	private boolean validateActionText(String Action)
//	{
//		if(Action.length()>= 256 )
//		{
//			engine.showMessage("Action lenght cannot exceed 255 characters");
//			return true;
//		}
//		return false;
//	}
//	
	
	
}
