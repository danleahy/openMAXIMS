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
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.66 build 3237.28774)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.naes.forms.actionsearch;

import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.ActionPlanVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.naes.forms.actionsearch.GenForm.grdDetailsRow;
import ims.naes.vo.ActionDetailStatusVo;
import ims.naes.vo.ActionDetailVo;
import ims.naes.vo.ActionDetailVoCollection;
import ims.naes.vo.ActionPlanQuarterVo;
import ims.naes.vo.ActionPlanQuarterVoCollection;
import ims.naes.vo.ActionSearchResultVo;
import ims.naes.vo.ActionSearchResultVoCollection;
import ims.naes.vo.filterVo;
import ims.naes.vo.lookups.Action;
import ims.naes.vo.lookups.NaesActionStatus;
public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{

		form.intDays().setEnabled(false);
		clear();
		form.getGlobalContext().Core.setPatientShort(null);

		form.getContextMenus().NAES.getActionSearchVIEWACTIONItem().setText("Edit Action");
		if (form.getGlobalContext().Naes.getsearchFilterIsNotNull())
		{
			filterVo searchCriteria = form.getGlobalContext().Naes.getsearchFilter();
			form.cmbAction().setValue(searchCriteria.getAction());
			form.cmbStatus().setValue(searchCriteria.getStatus());
			form.dteStartDate().setValue(searchCriteria.getStartDate());
			form.dteEndDate().setValue(searchCriteria.getToDate());
			form.intDays().setValue(searchCriteria.getDays());
			form.txtOrderNo().setValue(searchCriteria.getOrderNumber());
			if (searchCriteria.getMOSLiteIsNotNull())
			{
				form.qmbResponsibleTechnician().newRow(searchCriteria.getMOSLite(), searchCriteria.getMOSLite().getIMosName());
				form.qmbResponsibleTechnician().setValue(searchCriteria.getMOSLite());
			}
			if (searchCriteria.getDaysIsNotNull())
				form.intDays().setEnabled(true);

			if (searchCriteria.getPositiveOrNegativeIsNotNull())
			{
				form.intDays().setEnabled(true);
				if (searchCriteria.getPositiveOrNegative() == true)
				{
					form.chkPositive().setValue(true);
					form.chkNegative().setValue(false);
				}
				else if (searchCriteria.getPositiveOrNegative() == false)
				{
					form.chkPositive().setValue(false);
					form.chkNegative().setValue(true);
				}
			}
			onImbSearchClicked();
			return;
		}
		form.getContextMenus().NAES.getActionSearchVIEWACTIONItem().setText("Edit Action");
		form.getContextMenus().NAES.hideAllActionSearchMenuItems();
		
		//WDEV-11574
		MemberOfStaffLiteVo voMember = (MemberOfStaffLiteVo) domain.getMosUser();
		if(voMember != null)
		{
			form.qmbResponsibleTechnician().newRow(voMember, voMember.getIMosName());
			form.qmbResponsibleTechnician().setValue(voMember);
		}
	}

	protected void onimbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clear();
		form.getGlobalContext().Naes.setsearchFilter(null);
		clearContexts();
	}

	private void clearContexts()
	{
		form.getGlobalContext().setActionPlan(null);
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Naes.setReferral(null);
		form.getContextMenus().NAES.hideAllActionSearchMenuItems();
		form.getLocalContext().setCompleteAndCloseActionDialog(null);
		form.getLocalContext().setExistingCompletedLabActions(null);
	}

	private void clear()
	{
		form.cmbAction().setValue(null);
		form.cmbStatus().setValue(null);
		form.dteEndDate().setValue(null);
		form.dteStartDate().setValue(null);
		form.intDays().setValue(null);
		form.chkNegative().setValue(null);
		form.chkPositive().setValue(null);
		form.txtOrderNo().setValue(null);
		form.grdDetails().getRows().clear();
		form.qmbResponsibleTechnician().clear();

	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{

		switch (menuItemID)
		{
			case ims.naes.forms.actionsearch.GenForm.ContextMenus.NAESNamespace.ActionSearch.VIEWACTIONPLAN :
				openActionPlan();
			break;

			case ims.naes.forms.actionsearch.GenForm.ContextMenus.NAESNamespace.ActionSearch.VIEWACTION :
				openAction();
			break;
			
			case ims.naes.forms.actionsearch.GenForm.ContextMenus.NAESNamespace.ActionSearch.COMPLETEACTION :
				completeSelectedAction();
			break;
		}

	}

	private void completeSelectedAction()
	{
		ActionPlanVo voActionPlan = form.grdDetails().getValue();
		
		if(voActionPlan != null)
			form.getLocalContext().setExistingCompletedLabActions(new Integer(voActionPlan.countCurrentLabCompletions(true))); //WDEV-9193
			
		boolean completedSceleraExists = false;
		boolean completedLabExists = false;
		if(voActionPlan != null)
		{
			if(voActionPlan.getActionsIsNotNull())
			{
				completedSceleraExists = checkForCompletedSclera(voActionPlan.getActions());
				completedLabExists = checkForCompletedLab(voActionPlan.getActions());
			}
		}

		if(form.grdDetails().getSelectedRow() != null && voActionPlan != null)
		{	
			ActionDetailVo voActionDetail = form.grdDetails().getSelectedRow().getAction();
			
			ActionDetailStatusVo voNewStatus = new ActionDetailStatusVo();
			voNewStatus.setStatus(NaesActionStatus.COMPLETED);
			voNewStatus.setStatusDateTime(new DateTime());
		
			//WDEV-11512 
			MemberOfStaffLiteVo voMos = (MemberOfStaffLiteVo) domain.getMosUser();
			if(voMos != null)
			{
				voNewStatus.setTechnician(voMos);
				voActionDetail.setResponsibleTechnician(voMos);
			}
			else
			{
				if(voActionDetail.getCurrentStatusIsNotNull())
					voNewStatus.setTechnician(voActionDetail.getCurrentStatus().getTechnician());
			}
			
		
			voActionDetail.getStatusHistory().add(voActionDetail.getCurrentStatus());
			voActionDetail.setCurrentStatus(voNewStatus);
			
			//replacing the action in the collection with the new one
			if(voActionPlan.getActionsIsNotNull())
				voActionPlan.getActions().set(voActionPlan.getActions().indexOf(voActionDetail), voActionDetail);
		
			form.getGlobalContext().Naes.setActionDetails(voActionDetail);
			form.getGlobalContext().setActionPlan(voActionPlan);
			//pass a boolean to dialog here so that the dialog will know to validate the global and close automatically
			engine.open(form.getForms().NAES.ActionDialog, new Object[]{true, completedSceleraExists, completedLabExists});
			form.getLocalContext().setCompleteAndCloseActionDialog(true);
		}
	}

	private void openAction()
	{
		grdDetailsRow row = form.grdDetails().getSelectedRow();

		boolean completedSceleraExists = false;
		boolean completedLabExists = false;
		
		if (row.getValue() != null)
		{
			form.getGlobalContext().setActionPlan(row.getValue());
			form.getGlobalContext().Naes.setActionDetails(row.getAction());
			
			if(form.getGlobalContext().getActionPlan().getActionsIsNotNull())
			{
				completedSceleraExists = checkForCompletedSclera(form.getGlobalContext().getActionPlan().getActions());
				completedLabExists = checkForCompletedLab(form.getGlobalContext().getActionPlan().getActions());
			}
		}
		
		engine.open(form.getForms().NAES.ActionDialog, new Object[] { null, completedSceleraExists, completedLabExists});
	}

	private boolean checkForCompletedSclera(ActionDetailVoCollection actions) {
		for (int i = 0; i < actions.size(); i++)
		{
			ActionDetailVo voActionDetail = actions.get(i);
			if(voActionDetail.getAction().equals(Action.SCLERACODEVERIFIED)
					&& voActionDetail.getCurrentStatus().getStatusIsNotNull()
					&& voActionDetail.getCurrentStatus().getStatus().equals(NaesActionStatus.COMPLETED))
				return true;
		}
		return false;
	}

	private boolean checkForCompletedLab(ActionDetailVoCollection actions) {
		for (int i = 0; i < actions.size(); i++)
		{
			ActionDetailVo voActionDetail = actions.get(i);
			if(voActionDetail.getAction().equals(Action.LABCOMP)
					&& voActionDetail.getCurrentStatus().getStatusIsNotNull()
					&& voActionDetail.getCurrentStatus().getStatus().equals(NaesActionStatus.COMPLETED))
				return true;
		}
		return false;
	}
	
	private void populateFiltervo()
	{
		filterVo searchfilter = new filterVo();
		searchfilter.setAction(form.cmbAction().getValue());
		searchfilter.setDays(form.intDays().getValue());
		if (form.chkNegative().getValue() == true)
		{
			searchfilter.setPositiveOrNegative(false);
		}
		else if (form.chkPositive().getValue() == true)
		{
			searchfilter.setPositiveOrNegative(true);
		}

		searchfilter.setMOSLite(form.qmbResponsibleTechnician().getValue());
		searchfilter.setOrderNumber(form.txtOrderNo().getValue());
		searchfilter.setStartDate(form.dteStartDate().getValue());
		searchfilter.setToDate(form.dteEndDate().getValue());
		searchfilter.setStatus(form.cmbStatus().getValue());
		form.getGlobalContext().Naes.setsearchFilter(searchfilter);
	}

	private void openActionPlan()
	{
		if (form.grdDetails().getSelectedRow().getValue() != null)
			form.getGlobalContext().setActionPlan(form.grdDetails().getSelectedRow().getValue());
		form.getGlobalContext().Naes.setReferral(form.grdDetails().getSelectedRow().getValue().getNAESReferral());
		form.getGlobalContext().Core.setPatientShort(form.getGlobalContext().getActionPlan().getNAESReferral().getPatient());
		engine.open(form.getForms().NAES.ActionPlan,new Object[] {Boolean.TRUE});		//wdev-10745

	}

	protected void onImbSearchClicked() throws PresentationLogicException
	{
		clearContexts();
		
		ActionSearchResultVoCollection searchResults = null;

		Integer tech_id = null;

		if (form.qmbResponsibleTechnician().getValue() != null)
		{
			tech_id = form.qmbResponsibleTechnician().getValue().getID_MemberOfStaff();
		}
		
		
		if (form.dteEndDate().getValue() != null && form.dteStartDate().getValue() == null)
		{
			engine.showMessage("Please enter a start date for the search date range");
			return;
		}
		
		// WDEV-16610 
		
		if (form.dteStartDate().getValue() != null && form.dteEndDate().getValue()!= null && form.dteStartDate().getValue().isGreaterThan(form.dteEndDate().getValue()))
		{
			engine.showMessage("Invalid Date Range: Start Date cannot be greater than To date");
			return;
			
		}
		Boolean chkValue = null;

		if (form.chkNegative().getValue() == true)
		{
			chkValue = false;
		}
		if (form.chkPositive().getValue() == true)
		{

			chkValue = true;

		}

		String OrderNo = null;
		if (form.txtOrderNo().getValue() != null)
		{
			OrderNo = form.txtOrderNo().getValue();
		}
		//wdev-10748
		if(form.intDays() != null && form.intDays().getValue() != null )
		{
			
			if(form.chkPositive().getValue() == true)
			{
				if(form.dteEndDate().getValue() == null)
					form.dteEndDate().setValue(new Date());
				
				if(form.dteStartDate().getValue() == null )
					form.dteStartDate().setValue(calculateStartDateForElapsed(form.dteEndDate().getValue(),form.intDays().getValue()));
			}
			else if(form.chkNegative().getValue() == true)
			{
				if(form.dteStartDate().getValue() == null)
					form.dteStartDate().setValue(new Date());
				
				if(form.dteEndDate().getValue() == null )
					form.dteEndDate().setValue(calculateEndDateForElapsed(form.dteStartDate().getValue(),form.intDays().getValue()));
			}
			
			
		}
		//---------
		
		// Calculate Days Elapsed
		Integer daysElapsed = null;
		
		if (form.intDays().getValue() != null)
		{
			daysElapsed = form.intDays().getValue() * (form.chkNegative().getValue() ? -1 : 1);
		}
		
		searchResults = search(form.cmbAction().getValue(), form.cmbStatus().getValue(), form.dteEndDate().getValue(), form.dteStartDate().getValue(), daysElapsed, chkValue, tech_id, OrderNo);

		populateGrid(searchResults);
		if (form.grdDetails().getRows().size() == 0)
			engine.showMessage("No Actions Found");
	}
	//wdev-10748

	private Date calculateStartDateForElapsed(Date endDate, int elapsedDays)
	{
		Date DateTo = (Date) endDate.clone();
		if(elapsedDays < 0)
			elapsedDays *= -1;
			
		DateTo.addDay(elapsedDays*(-1));
		
		long nrDays = Date.daysBetween(DateTo, endDate);
		if(nrDays < elapsedDays)
			return DateTo.addDay((int) (elapsedDays- nrDays)*(-1));
		else if (nrDays > elapsedDays)
			return DateTo.addDay((int) (nrDays - elapsedDays)*(-1));

		return DateTo;
		
	}
	
	private Date calculateEndDateForElapsed(Date endDate, int elapsedDays)
	{
		Date DateTo = (Date) endDate.clone();
		if(elapsedDays < 0)
			elapsedDays *= -1;
			
		DateTo.addDay(elapsedDays);
		long nrDays = Date.daysBetween(DateTo, endDate);
		if(nrDays < 0)
			nrDays *= -1;
		if(nrDays < elapsedDays)
			return DateTo.addDay((int) (elapsedDays- nrDays));
		else if (nrDays > elapsedDays)
			return DateTo.addDay((int) (nrDays - elapsedDays));

		return DateTo;
	}
	//----------------------
	private void populateGrid(ActionSearchResultVoCollection searchResults)
	{
		form.grdDetails().getRows().clear();
		if (searchResults != null)
		{
			populateFiltervo();
			
			for (int i = 0; i < searchResults.size(); i++)
			{
				ActionSearchResultVo result = searchResults.get(i);
				
				if (result == null || !result.getActionPlanIsNotNull() || !result.getActionDetailIsNotNull())
					continue;
					
				populateGridRow(form.grdDetails().getRows().newRow(), result);
			}
		}
	}

	/**
	 * Function used to populate a grid row from an ActionSearchResultVo value
	 * The row will be assigned the ActionPlanVo value from ActionSearchResultVo
	 */
	private void populateGridRow(grdDetailsRow row, ActionSearchResultVo result)
	{
		if (result == null || !result.getActionPlanIsNotNull() || !result.getActionDetailIsNotNull())
			throw new CodingRuntimeException("Unexpected data passed to populate grid row");

		if (result.getActionPlan().getDateCompletedIsNotNull())
		{
			row.setBackColor(Color.Beige);
			row.setTooltip("Action Plan Complete");
		}
		else if (result.getActionPlan().getSixMonthOpenPeriodIsNotNull()
				&& result.getActionPlan().getSixMonthOpenPeriod().isLessOrEqualThan(new Date()))
		{
			row.setBackColor(Color.LightGray);
			row.setTooltip("Action Plan Read only");
		}

		row.setActionName(result.getActionDetail().getAction().getText());
		
		if (result.getActionPlan().getNAESReferralIsNotNull() && result.getActionPlan().getNAESReferral().getPatientIsNotNull() && result.getActionPlan().getNAESReferral().getPatient().getHospnum() != null)
			row.setPatientId(result.getActionPlan().getNAESReferral().getPatient().getHospnum().getValue());
		else
			row.setPatientId("N/A");
		
		if (result.getActionPlan().getNAESReferralIsNotNull() && result.getActionPlan().getNAESReferral().getPatientIsNotNull() && result.getActionPlan().getNAESReferral().getPatient().getNameIsNotNull())
			row.setPatientName(result.getActionPlan().getNAESReferral().getPatient().getName().toShortForm());
		
		row.setOrderNo(result.getActionPlan().getOrderNumber());
		row.setStartDate(result.getActionDetail().getStartDate());
		row.setAction(result.getActionDetail());
		row.setStatus(result.getActionDetail().getCurrentStatus().getStatus().getText());
		
		if (result.getActionDetail().getStartDateIsNotNull())
			row.setElapsedDays(elapsedDays(result.getActionDetail().getStartDate()));
		
		if (result.getActionDetail().getResponsibleTechnicianIsNotNull())
			row.setResTech(result.getActionDetail().getResponsibleTechnician().getIMosName());

		row.setValue(result.getActionPlan());
	}

	private String elapsedDays(Date startDate)
	{
		Date now = new Date();
		long days = Date.daysBetween(startDate, now);
		return Long.toString(days);
	}

	private ActionSearchResultVoCollection search(Action action, NaesActionStatus status, Date endDate, Date startDate, Integer noDaysElapsed, Boolean posOrNeg, Integer resposibleTech, String OrderNo)
	{
		if (endDate != null && startDate != null)
		{
			if (!validateSearchDates(endDate, startDate))
				return null;
		}

		ActionSearchResultVoCollection results = domain.search(startDate, endDate, noDaysElapsed, posOrNeg, action, status, resposibleTech, OrderNo);

		return results;
	}

	private boolean validateSearchDates(Date endDate, Date startDate)
	{

		if (endDate.isLessThan(startDate))
		{
			engine.showMessage("Start date cannot be after the End date");
			return false;

		}

		return true;
	}

	@Override
	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException
	{
		form.getContextMenus().NAES.hideAllActionSearchMenuItems();
		
		if (form.grdDetails().getSelectedRow().getValue() != null)
		{
			form.getContextMenus().NAES.getActionSearchVIEWACTIONPLANItem().setVisible(true);
			form.getContextMenus().NAES.getActionSearchVIEWACTIONItem().setVisible(true);

			if (form.grdDetails().getSelectedRow().getValue() != null) //wdev-11734
			{
				if ( form.grdDetails().getSelectedRow().getAction() != null && form.grdDetails().getSelectedRow().getAction().getCurrentStatusIsNotNull() && form.grdDetails().getSelectedRow().getAction().getCurrentStatus().getStatusIsNotNull() && form.grdDetails().getSelectedRow().getAction().getCurrentStatus().getStatus().equals(NaesActionStatus.COMPLETED) ) //wdev-11735//wdev-11734 
					form.getContextMenus().NAES.getActionSearchVIEWACTIONItem().setVisible(false);
			}
		
			if(form.grdDetails().getSelectedRow().getAction() != null && form.grdDetails().getSelectedRow().getAction().getCurrentStatusIsNotNull() && form.grdDetails().getSelectedRow().getAction().getCurrentStatus().getStatusIsNotNull())
			{
				if(!form.grdDetails().getSelectedRow().getAction().getCurrentStatus().getStatus().equals(NaesActionStatus.COMPLETED)) //WDEV-11572
				{
					form.getContextMenus().NAES.getActionSearchCOMPLETEACTIONItem().setVisible(true);
				}
			}

			if(form.grdDetails().getSelectedRow().getValue()!=null && form.grdDetails().getSelectedRow().getValue().getNAESReferralIsNotNull())
				form.getGlobalContext().Core.setPatientShort(form.grdDetails().getSelectedRow().getValue().getNAESReferral().getPatient());
		}
	}

	protected void onResponsibleTechQmbTextSubmitted(String value) throws PresentationLogicException
	{
		populateResponsibleTechnicianCombo(value);
		form.qmbResponsibleTechnician().showOpened();

	}

	private void populateResponsibleTechnicianCombo(String value)
	{
		form.qmbResponsibleTechnician().clear();
		
		MemberOfStaffLiteVoCollection techs = domain.getResponsibleTechnican(value);

		for (int i = 0; i < techs.size(); i++)
		{
			form.qmbResponsibleTechnician().newRow(techs.get(i), techs.get(i).getIItemText());
		}
	}

	@Override
	protected void onChkNegativeValueChanged() throws PresentationLogicException
	{
		if (form.chkNegative().getValue() == true)
		{
			form.chkPositive().setValue(false);
			form.intDays().setEnabled(true);
			return;

		}
		form.intDays().setEnabled(false);
		form.intDays().setValue(null);

	}

	@Override
	protected void onchkPositiveValueChanged() throws PresentationLogicException
	{
		if (form.chkPositive().getValue() == true)
		{
			form.chkNegative().setValue(false);
			form.intDays().setEnabled(true);
			return;
		}
		form.intDays().setEnabled(false);
		form.intDays().setValue(null);

	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().NAES.ActionDialog))
		{
			if (result == DialogResult.OK)
			{		
				ActionPlanVo voActionPlan = form.getGlobalContext().getActionPlan();
				
			
				//WDEV-15705
				if(form.getGlobalContext().Naes.getActionDetailsIsNotNull())
				{
					int index = voActionPlan.getActions().indexOf(form.getGlobalContext().Naes.getActionDetails());
					voActionPlan.getActions().set(index, form.getGlobalContext().Naes.getActionDetails());
				}

				if (voActionPlan.isLabCompletionActionCompleted())
					voActionPlan.setQuarterYear(voActionPlan.calculateYearQuater());
				
				//batch number
				if(voActionPlan.getScleraIsNotNull() && voActionPlan.getFinalCureIsNotNull() && voActionPlan.getQuarterYearIsNotNull() && voActionPlan.getBatchNumber() == null)
					voActionPlan.setBatchNumber(voActionPlan.getSclera() + voActionPlan.getQuarterYear() + voActionPlan.getFinalCure());
				
				//Quarter History
				int totalCompletions = voActionPlan.countCurrentLabCompletions(false); //WDEV-9193
				int existingCompletions = form.getLocalContext().getExistingCompletedLabActionsIsNotNull() ? form.getLocalContext().getExistingCompletedLabActions() : 0;
				// if this is the second or subsequent time a lab completion has been done update the quarter year and history
				if(totalCompletions > 1 && totalCompletions > existingCompletions && existingCompletions > 0)
				{
					if (voActionPlan.getQuarterHistory() == null)
						voActionPlan.setQuarterHistory(new ActionPlanQuarterVoCollection());

					ActionPlanQuarterVo voQuarter = new ActionPlanQuarterVo();
					voQuarter.setDateTime(new DateTime());
					voQuarter.setResponsibleMos((MemberOfStaffRefVo) domain.getMosUser());
					if(voActionPlan.getQuarterYear() == null)
						throw new CodingRuntimeException("Quarter Year is null in method isLabCompletionActionCompleted");
					
					voQuarter.setQuarter(new Integer(voActionPlan.getQuarterYear()));
					voActionPlan.getQuarterHistory().add(voQuarter);

					voActionPlan.setQuarterYear(voActionPlan.calculateYearQuater());
				}
				
				String[] errors = voActionPlan.validate();

				if (errors != null)
				{
					engine.showErrors(errors);
					return;
				}
				
				try
				{
					domain.saveActionPlan(voActionPlan);
				}
				catch (StaleObjectException e)
				{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				}
			}
			onImbSearchClicked();
		}
	}
}
