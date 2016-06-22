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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4972.23166)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.suspensiondetails;



import ims.RefMan.forms.suspensiondetails.GenForm.grdSuspensionHistoryRow;
import ims.RefMan.vo.ElectiveListStatusVo;
import ims.RefMan.vo.ElectiveListStatusVoCollection;
import ims.RefMan.vo.PatientElectiveListForSuspensionDetailsVo;
import ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo;
import ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.lookups.WaitingListStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//WDEV-18308
		if (args!=null && args.length>1)
		{
			if (args[1]!=null && args[1] instanceof Boolean)
				form.getLocalContext().setformOpenedBySuspendButton((Boolean) args[1]);
		}
		
		//WDEV-19517
		if (args!=null && args.length>2 && args[2]!=null && args[2] instanceof Boolean)
		{
			if (Boolean.TRUE.equals((Boolean) args[2]))
			{
				form.dteEndDate().setRequired(true);
				form.btnSave().setText("Unsuspend");
			}
		}
		
		open();
	}
	
	private void open()
	{
		form.getLocalContext().setPatientElectiveList(domain.getPatientElectiveList(form.getGlobalContext().RefMan.getPatientElectiveListRef()));	
		populateScreenFromData(form.getLocalContext().getPatientElectiveList());

		form.setMode(form.getMode());
	}

	private void populateScreenFromData(PatientElectiveListForSuspensionDetailsVo patientElectiveList)
	{
		clear();
		
		//WDEV-18308
		if (patientElectiveList == null)
			return;
		
		SuspensionDetailsForPatientElectiveListVoCollection suspensions = patientElectiveList.getSuspensions()!=null ? patientElectiveList.getSuspensions().sort(SortOrder.DESCENDING) : null;	
		populateSuspensionsHistoryGrid(suspensions);
		
		if (form.getLocalContext().getformOpenedBySuspendButton()==null)
		{
			if(patientElectiveList.getEROD() == null)
    			return;
    		
    		form.dteStartDate().setValue(patientElectiveList.getEROD().getERODDate1());
    		form.dteEndDate().setValue(patientElectiveList.getEROD().getPatAvailFromDate());
		}
		else if (Boolean.TRUE.equals(form.getLocalContext().getformOpenedBySuspendButton())) //WDEV-18308
		{
			form.getLocalContext().setCurrentSuspensionDetail(getSuspension(suspensions));
			populateSuspensionDetailsScreenFromData(form.getLocalContext().getCurrentSuspensionDetail());
		}

	}

	//WDEV-18308
	private SuspensionDetailsForPatientElectiveListVo getSuspension(SuspensionDetailsForPatientElectiveListVoCollection suspensions)
	{
		if (suspensions==null || suspensions.size()==0)
			return null;
		
		if (suspensions.get(0)!=null && suspensions.get(0).getEndDate()==null)
			return suspensions.get(0);
		else
		{
			for (int i=0;i<suspensions.size();i++)
			{
				if (suspensions.get(i)!=null && suspensions.get(i).getEndDate()==null)
					return suspensions.get(i);
			}
		}
	
		return null;
	}

	//WDEV-18308
	private void populateSuspensionsHistoryGrid(SuspensionDetailsForPatientElectiveListVoCollection suspensions)
	{
		form.grdSuspensionHistory().getRows().clear();
		
		if (suspensions==null )
			return;
		
		for (int i=0;i<suspensions.size();i++)
		{
			if ( (suspensions.get(i).getIsRIE() == null
					|| suspensions.get(i).getIsRIE() != null && !suspensions.get(i).getIsRIE()))
				addRowToSuspensionHistoryGrid(suspensions.get(i));
		}
	}

	//WDEV-18308
	private void addRowToSuspensionHistoryGrid(SuspensionDetailsForPatientElectiveListVo suspensionDetails)
	{
		if (suspensionDetails==null)
			return;
		
		grdSuspensionHistoryRow row = form.grdSuspensionHistory().getRows().newRow();
		row.setColStartDate(suspensionDetails.getStartDate()!=null ? suspensionDetails.getStartDate().toString() : null);
		row.setTooltipForColStartDate(suspensionDetails.getStartDate()!=null ? suspensionDetails.getStartDate().toString() : null);
		row.setColEndDate(suspensionDetails.getEndDate()!=null ? suspensionDetails.getEndDate().toString() : null);
		row.setTooltipForColEndDate(suspensionDetails.getEndDate()!=null ? suspensionDetails.getEndDate().toString() : null);
		row.setColInitiator(suspensionDetails.getInitator()!=null ? suspensionDetails.getInitator().toString() : null);
		row.setTooltipForColInitiator(suspensionDetails.getInitator()!=null ? suspensionDetails.getInitator().toString() : null);
		row.setColReasonAndComments(suspensionDetails.getComments());
		row.setTooltipForColReasonAndComments(suspensionDetails.getComments());
		
		row.setValue(suspensionDetails);
	}

	//WDEV-18308
	private void populateSuspensionDetailsScreenFromData(SuspensionDetailsForPatientElectiveListVo suspensionDetails)
	{
		if (suspensionDetails==null || suspensionDetails.getEndDate()!=null)
		{
			form.dteStartDate().setValue(new Date());
			return;
		}
		
		form.dteStartDate().setValue(suspensionDetails.getStartDate());
		form.dteEndDate().setValue(suspensionDetails.getEndDate());
		form.cmbInitator().setValue(suspensionDetails.getInitator());
		form.cmbSuspensionReason().setValue(suspensionDetails.getSuspensionReason());
		form.txtComments().setValue(suspensionDetails.getComments());
	}

	private void clear()
	{
		form.dteStartDate().setValue(null);
		form.dteEndDate().setValue(null);
		form.cmbInitator().setValue(null);
		form.cmbSuspensionReason().setValue(null);
		form.txtComments().setValue(null);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{
		PatientElectiveListForSuspensionDetailsVo patientElectiveList = populateDataFromScreen(form.getLocalContext().getPatientElectiveList());
		
		if(patientElectiveList == null)
			return false;
		
		String[] errors = patientElectiveList.validate(validateUI());//WDEV-18308
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setPatientElectiveList(domain.savePatientElectiveList(patientElectiveList));
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}
		
		return true;
	}
	private boolean saveRIE()
	{

		try
		{
			domain.markAsRie(form.grdSuspensionHistory().getSelectedRow().getValue(), form.getForms().RefMan.SuspensionDetails, form.getGlobalContext().Core.getPatientShort() != null ? form.getGlobalContext().Core.getPatientShort().getID_Patient() : null, null, null, form.getGlobalContext().Core.getRieMessage());
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
		}

		PatientElectiveListForSuspensionDetailsVo patientElectiveList = domain.getPatientElectiveList(form.getGlobalContext().RefMan.getPatientElectiveListRef());	

		if(patientElectiveList.getElectiveListStatusHistory() == null)
			patientElectiveList.setElectiveListStatusHistory(new ElectiveListStatusVoCollection());
		
		//If there is an open suspension and the RIE is a closed one, then do not null this
		if (patientElectiveList != null &&  ! anyOtherOpenSuspensionRecords())
		{	
			patientElectiveList.setCurrentSuspensionEndDate(null);
		
			ElectiveListStatusVo previousStatus = getPreviousStatusFromHistory(patientElectiveList.getElectiveListStatusHistory());
			
			if (previousStatus!=null)
			{
				ElectiveListStatusVo previousStatus1 = populateStatus(previousStatus.getElectiveListStatus());
				patientElectiveList.setElectiveListStatus(previousStatus1);
				patientElectiveList.getElectiveListStatusHistory().add(previousStatus1);
			}
	
			String[] errors = patientElectiveList.validate(validateUI());//WDEV-18308
			if(errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
			try
			{
				form.getLocalContext().setPatientElectiveList(domain.savePatientElectiveList(patientElectiveList));
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				engine.close(DialogResult.ABORT);
			}
		}
		
		return true;
	}


	
	private boolean anyOtherOpenSuspensionRecords()
	{
		if (form.grdSuspensionHistory().getRows().size() == 1)
			return false;
		
		for (int i = 0 ; i < form.grdSuspensionHistory().getRows().size() ; i++)
		{
			if (form.grdSuspensionHistory().getRows().get(i).getValue().equals(form.grdSuspensionHistory().getSelectedRow().getValue()) )
				continue;
			
			if (form.grdSuspensionHistory().getRows().get(i).getValue().getEndDate() == null || ( form.grdSuspensionHistory().getRows().get(i).getValue().getEndDate() != null && form.grdSuspensionHistory().getRows().get(i).getValue().getEndDate().isGreaterThan(new Date())))		//wdev-20805
				return true;
		}
		return false;
	}

	//WDEV-18308
	private String[] validateUI()
	{
		ArrayList<String> errors = new ArrayList<String>();

		//WDEV-19517
		if (form.dteEndDate().isRequired()&& form.dteEndDate().getValue()==null)
		{
			errors.add("'End Date' is mandatory!");
		}
		
		if (form.dteStartDate().getValue()!=null && form.dteEndDate().getValue()!=null && form.dteEndDate().getValue().isLessThan(form.dteStartDate().getValue()))
		{
			errors.add("'End Date' should be greater than 'Start Date'!");
		}
		
		if (errors.size() > 0)
		{
			String[] UIErrors = new String[errors.size()];
			errors.toArray(UIErrors);
			return UIErrors;
		}

		return null;
	}

	private PatientElectiveListForSuspensionDetailsVo populateDataFromScreen(PatientElectiveListForSuspensionDetailsVo patientElectiveList)
	{
		if(patientElectiveList == null)
			return null;
		
		patientElectiveList = (PatientElectiveListForSuspensionDetailsVo) patientElectiveList.clone();
		
		//WDEV-18308
		SuspensionDetailsForPatientElectiveListVo suspension=form.getLocalContext().getCurrentSuspensionDetail();
		if (suspension==null)
			suspension = new SuspensionDetailsForPatientElectiveListVo();
		else
			suspension=(SuspensionDetailsForPatientElectiveListVo) suspension.clone();
		
		suspension.setStartDate(form.dteStartDate().getValue());
		suspension.setEndDate(form.dteEndDate().getValue());
		suspension.setInitator(form.cmbInitator().getValue());
		suspension.setSuspensionReason(form.cmbSuspensionReason().getValue());
		suspension.setComments(form.txtComments().getValue());
		
		if(patientElectiveList.getSuspensions() == null)
			patientElectiveList.setSuspensions(new SuspensionDetailsForPatientElectiveListVoCollection());
		
		//WDEV-18308
		if (patientElectiveList.getSuspensions().contains(suspension))
				patientElectiveList.getSuspensions().remove(suspension);
		
		patientElectiveList.getSuspensions().add(suspension);
		patientElectiveList.setCurrentSuspensionEndDate(form.dteEndDate().getValue()!=null ? new DateTime(form.dteEndDate().getValue(), new Time(0, 0, 0)): null);
		if(patientElectiveList.getElectiveListStatusHistory() == null)
			patientElectiveList.setElectiveListStatusHistory(new ElectiveListStatusVoCollection());
		
		ElectiveListStatusVo previousStatus=null, status=null;
		
		if (form.dteEndDate().getValue()!=null 
			&& form.dteEndDate().getValue().isLessOrEqualThan(new Date()) && patientElectiveList.getElectiveListStatus()!=null)
		{
			if (suspension.getID_SuspensionDetailsForPatientElectiveList()==null && !WaitingListStatus.SUSPENDED.equals(patientElectiveList.getElectiveListStatus().getElectiveListStatus()))
			{
				previousStatus=patientElectiveList.getElectiveListStatus();
			}
			else
			{
				previousStatus=getPreviousStatusFromHistory(patientElectiveList.getElectiveListStatusHistory());
			}
		}
		
		status = populateStatus(WaitingListStatus.SUSPENDED);
		
		if (suspension.getID_SuspensionDetailsForPatientElectiveList()!=null && form.dteEndDate().getValue()==null)
			return patientElectiveList;
		
		if (previousStatus!=null)
		{
			ElectiveListStatusVo previousStatus1 = populateStatus(previousStatus.getElectiveListStatus());
			patientElectiveList.setElectiveListStatus(previousStatus1);
			patientElectiveList.getElectiveListStatusHistory().contains(status);
			if (suspension.getID_SuspensionDetailsForPatientElectiveList()==null)
			{
				patientElectiveList.getElectiveListStatusHistory().add(status);
			}
			patientElectiveList.getElectiveListStatusHistory().add(previousStatus1);
		}
		else
		{
			patientElectiveList.setElectiveListStatus(status);
			patientElectiveList.getElectiveListStatusHistory().add(status);
		}
			
		return patientElectiveList;
	}

	//WDEV-18308
	private ElectiveListStatusVo getPreviousStatusFromHistory(ElectiveListStatusVoCollection electiveListStatusHistory)
	{
		if (electiveListStatusHistory==null || electiveListStatusHistory.size()<1)
			return null;
		
		for (int i=electiveListStatusHistory.size()-1;i>=0;i--)
		{
			if (!WaitingListStatus.SUSPENDED.equals(electiveListStatusHistory.get(i).getElectiveListStatus()))
			{
				return electiveListStatusHistory.get(i);
			}
		}
		
		return null;
	}

	//WDEV-18308
	private ElectiveListStatusVo populateStatus(WaitingListStatus waitingListStatus)
	{
		ElectiveListStatusVo status = new ElectiveListStatusVo();
		
		Object user = domain.getMosUser();
		if(user instanceof MemberOfStaffLiteVo)
		{
			status.setAuthoringUser((MemberOfStaffLiteVo) user);
		}
		
		status.setStatusDateTime(new DateTime());
		status.setElectiveListStatus(waitingListStatus);
		return status;
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	private void updateControlsState()
	{
		form.getContextMenus().RefMan.hideAllSuspensionsMenuMenuItems();
		form.getContextMenus().RefMan.getSuspensionsMenuRIEItem().setVisible(form.grdSuspensionHistory().getSelectedRow() != null);
	}

	@Override
	protected void onGrdSuspensionHistorySelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.RefManNamespace.SuspensionsMenu.RIE :
				clear();
				engine.showMessage( "Are you sure you want to RIE this Suspension period? ","Please Confirm", MessageButtons.YESNO, MessageIcon.QUESTION);
			break;			
			default :
			break;
		}
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException 
	{
		if (result == DialogResult.YES)
		{
			form.grdSuspensionHistory().getSelectedRow().getValue().setIsRIE(Boolean.TRUE);
			if(saveRIE())
				engine.close(DialogResult.OK);
		}
		else
			open();
		
	}
}
