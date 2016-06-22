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
// This code was generated by John Pearson using IMS Development Environment (version 1.45 build 2377.27529)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.hl7admin;

import ims.admin.forms.hl7admin.GenForm.lyrHL7Layer.tabDemographicFeedContainer.grdListRow;
import ims.admin.forms.hl7admin.GenForm.lyrHL7Layer.tabInterfacesContainer.grdStatsRow;
import ims.admin.forms.hl7admin.GenForm.lyrHL7Layer.tabOutboundControlContainer.grdProviderSystemRow;
import ims.admin.forms.hl7admin.GenForm.lyrHL7Layer.tabOutboundControlContainer.grdSelectQueueTypeRow;
import ims.admin.forms.hl7admin.GenForm.lyrHL7Layer.tabQueryContainer.grdMsgsRow;
import ims.admin.vo.DemographicFeedVo;
import ims.admin.vo.DemographicFeedVoCollection;
import ims.admin.vo.HL7AdminVo;
import ims.admin.vo.QryOrderMsgVo;
import ims.admin.vo.QryOrderMsgVoCollection;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.ProviderSystemRefVo;
import ims.core.vo.PatientId;
import ims.core.vo.lookups.MsgEventType;
import ims.core.vo.lookups.QueueTypeCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;
import ims.framework.utils.Time;
import ims.ocrr.vo.ProviderSystemLiteVo;
import ims.ocrr.vo.ProviderSystemLiteVoCollection;
import ims.ocs_if.vo.OutboundTriggersVo;
import ims.ocs_if.vo.OutboundTriggersVoCollection;

import java.util.ArrayList;
import java.util.Collections;




public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	private static final int	INBOUND				= 0;
	private static final int	OUTBOUND			= 1;

	protected void onFormOpen() throws PresentationLogicException
	{
		initializeOutBoundTab();
		initializeTriggersTab();
		setInterfaceType(INBOUND);
		isOutBoundRunning();
		populateControlsFromVo(getInterfaceInfo());
		updateControlState();//WDEV-14638
	}

	private void setInterfaceType(int interfaceType)
	{
		if (interfaceType == INBOUND)
		{
			form.lyrHL7().tabInterfaces().grpInterface().setValue(GenForm.lyrHL7Layer.tabInterfacesContainer.grpInterfaceEnumeration.rdoInbound);
			form.lyrHL7().tabInterfaces().btnRecover().setVisible(false);
			form.lyrHL7().tabInterfaces().txtIpaddress().setVisible(false);
			form.lyrHL7().tabInterfaces().lblIpaddress().setVisible(false);
		}
		else
		{
			form.lyrHL7().tabInterfaces().grpInterface().setValue(GenForm.lyrHL7Layer.tabInterfacesContainer.grpInterfaceEnumeration.rdoOutbound);
			form.lyrHL7().tabInterfaces().btnRecover().setVisible(true);
			form.lyrHL7().tabInterfaces().txtIpaddress().setVisible(true);
			form.lyrHL7().tabInterfaces().lblIpaddress().setVisible(true);
		}
	}

	private int getInterfaceType()
	{
		if (form.lyrHL7().tabInterfaces().grpInterface().getValue().equals(GenForm.lyrHL7Layer.tabInterfacesContainer.grpInterfaceEnumeration.rdoInbound))
		{
			return INBOUND;
		}
		else
		{
			return OUTBOUND;
		}
	}

	private boolean validateSearchCriteria()
	{
		
		if (form.lyrHL7().tabQuery().cmbPatIdType().getValue() != null && form.lyrHL7().tabQuery().txtPatId().getValue() != null && !form.lyrHL7().tabQuery().txtPatId().getValue().trim().equals(""))
		{
			PatientId patId = new PatientId();
			patId.setType(form.lyrHL7().tabQuery().cmbPatIdType().getValue());
			patId.setValue(form.lyrHL7().tabQuery().txtPatId().getValue());
			form.getLocalContext().setPatId(patId);
		}
		else
		{
			form.getLocalContext().setPatId(null);
		}
		//WDEV-17055 
		String[] dateRangeErrors = validatUIRules(getDateTimeFrom(), getDateTimeTo());
		
		
		if (dateRangeErrors != null && dateRangeErrors.length > 0)
		{
			engine.showErrors(dateRangeErrors);
			return false;
		}
		//end //WDEV-17055
		return true;
	}
	
	//WDEV-17055
	private String[] validatUIRules(DateTime dtFrom,DateTime dtTo)
	{
		ArrayList<String> errorList = new ArrayList<String>();
		

		if (form.getLocalContext().getPatId() == null)
			
		{
			if ((dtFrom != null && dtTo == null) || (dtFrom == null && dtTo != null))
			{
				errorList.add("Both From date and To date must be specified.");
	
			}		
			else if (dtFrom != null && dtTo != null && dtFrom.isGreaterThan(dtTo))
			{
				errorList.add("From date cannot be greater than To date.");
	
			}
		}
		
		if (form.getLocalContext().getPatId() == null && errorList.size() > 0)
		{
			errorList.add("Please specify either a valid date range or a patient on which to search.");
		}
		Collections.reverse(errorList);
		return errorList.toArray(new String[errorList.size()]);
	}

	private DateTime getDateTimeTo()
	{
		if (form.lyrHL7().tabQuery().dteTo().getValue() != null)
			return new DateTime(form.lyrHL7().tabQuery().dteTo().getValue(), form.lyrHL7().tabQuery().timTo().getValue());
		else
			return null;
	}

	private DateTime getDateTimeFrom()
	{
		if (form.lyrHL7().tabQuery().dteFrom().getValue() != null)
			return new DateTime(form.lyrHL7().tabQuery().dteFrom().getValue(), form.lyrHL7().tabQuery().timFrom().getValue());
		else
			return null;
	}

	private HL7AdminVo getInterfaceInfo()
	{
		HL7AdminVo interfaceVo = null;

		if (getInterfaceType() == INBOUND)
		{
			try
			{
				interfaceVo = domain.getInboundInfo();
				form.lyrHL7().tabInterfaces().btnRecover().setVisible(false);
				form.lyrHL7().tabInterfaces().txtIpaddress().setVisible(false);
				form.lyrHL7().tabInterfaces().lblIpaddress().setVisible(false);
			}
			catch (DomainInterfaceException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				interfaceVo = domain.getOutboundInfo();
				form.lyrHL7().tabInterfaces().btnRecover().setVisible(true);
				form.lyrHL7().tabInterfaces().txtIpaddress().setVisible(true);
				form.lyrHL7().tabInterfaces().lblIpaddress().setVisible(true);
				form.lyrHL7().tabInterfaces().txtIpaddress().setValue(domain.getIpAddress());
			}
			catch (DomainInterfaceException e)
			{
				e.printStackTrace();
			}
		}

		return interfaceVo;
	}

	private void populateControlsFromVo(HL7AdminVo interfaceVo)
	{
		int nTotalProcessed = 0;
		int nTotalFailed = 0;
		int nTotalSuccessful = 0;

		clearStatsControls();
		clearQueryControls();
		if (interfaceVo == null)
		{
			engine.showMessage("interfaceVo is null");
			return;
		}

		if (interfaceVo.getIsRunning().equals(Boolean.TRUE))
		{
			form.lyrHL7().tabInterfaces().txtStatus().setValue("Running");
			form.lyrHL7().tabInterfaces().btnStartStop().setText("Stop");
			//WDEV-17055
			form.lyrHL7().tabInterfaces().btnStartStop().setTooltip(form.lyrHL7().tabInterfaces().btnStartStop().getText() + " Interface");
			form.getLocalContext().setIsStart(Boolean.FALSE);
			form.lyrHL7().tabInterfaces().txtStarted().setValue(interfaceVo.getStarted());

			if (interfaceVo.getMessagesIsNotNull())
			{
				for (int i = 0; i < interfaceVo.getMessages().size(); i++)
				{
					grdStatsRow row = form.lyrHL7().tabInterfaces().grdStats().getRows().newRow();
					row.setcolMessType(interfaceVo.getMessages().get(i).getMessageType());
					row.setcolTotal(interfaceVo.getMessages().get(i).getTotal());
					row.setcolSuccessful(interfaceVo.getMessages().get(i).getSuccessful());
					row.setcolFailed(interfaceVo.getMessages().get(i).getFailed());
					if(interfaceVo.getMessages().get(i).getLastSuccessDateTime() != null)
						row.setlastSuccessfulTime(interfaceVo.getMessages().get(i).getLastSuccessDateTime().toString(DateTimeFormat.STANDARD_SECS));

					if (interfaceVo.getMessages().get(i).getLastSuccessMessage() != null)
					{
						row.setlastSuccessMessage(interfaceVo.getMessages().get(i).getLastSuccessMessage().substring(0, 40));
						row.setTooltipForlastSuccessMessage(interfaceVo.getMessages().get(i).getLastSuccessMessage());
					}

					if (interfaceVo.getMessages().get(i).getLastFailedMessage() != null)
					{
						row.setlastFailedMessage(interfaceVo.getMessages().get(i).getLastFailedMessage().substring(0, 40));
						row.setTooltipForlastFailedMessage(interfaceVo.getMessages().get(i).getLastFailedMessage());
					}

					if(interfaceVo.getMessages().get(i).getLastFailedDateTime() != null)
						row.setlastFailedTime(interfaceVo.getMessages().get(i).getLastFailedDateTime().toString(DateTimeFormat.STANDARD_SECS));

					row.setValue(interfaceVo.getMessages().get(i));
					
					nTotalProcessed = nTotalProcessed + interfaceVo.getMessages().get(i).getTotal().intValue();
					nTotalFailed = nTotalFailed + interfaceVo.getMessages().get(i).getFailed().intValue();
					nTotalSuccessful = nTotalSuccessful + interfaceVo.getMessages().get(i).getSuccessful().intValue();
				}
			}
			grdStatsRow row = form.lyrHL7().tabInterfaces().grdStats().getRows().newRow();
			row.setBold(true);
			row.setBackColor(Color.Beige);
			row.setcolMessType("Totals");
			row.setcolTotal(new Integer(nTotalProcessed));
			row.setcolSuccessful(new Integer(nTotalSuccessful));
			row.setcolFailed(new Integer(nTotalFailed));
			row.setSelectable(false);
		}
		else if (interfaceVo.getIsRunning().equals(Boolean.FALSE))
		{
			form.lyrHL7().tabInterfaces().txtStatus().setValue("Stopped");
			form.lyrHL7().tabInterfaces().btnStartStop().setText("Start");
			//WDEV-17055
			form.lyrHL7().tabInterfaces().btnStartStop().setTooltip(form.lyrHL7().tabInterfaces().btnStartStop().getText() + " Interface");
			
			form.lyrHL7().tabInterfaces().txtStarted().setValue("Not Running");
			form.getLocalContext().setIsStart(Boolean.TRUE);
		}

		form.lyrHL7().tabInterfaces().btnStartStop().setEnabled(interfaceVo.getCfgStartInterface().booleanValue());
		if (!interfaceVo.getCfgStartInterface().booleanValue())
		{
			form.lyrHL7().tabInterfaces().btnStartStop().setTooltip("Server Start flag not set");
			//WDEV-6569 - allow interface to be stopped if it's running and flag has been
			//switched off
			if (interfaceVo.getIsRunning().booleanValue())			
				form.lyrHL7().tabInterfaces().btnStartStop().setEnabled(true);							
		}
		else
		{
			//WDEV-17055
			form.lyrHL7().tabInterfaces().btnStartStop().setTooltip(form.lyrHL7().tabInterfaces().btnStartStop().getText() + " Interface");
		}
		form.lyrHL7().tabInterfaces().chkStart().setValue(interfaceVo.getCfgStartInterface().booleanValue());		
	}

	private void clearQueryControls()
	{
		form.getLocalContext().setPatId(null);

		form.lyrHL7().tabQuery().dteFrom().setValue(new Date());
		form.lyrHL7().tabQuery().timFrom().setValue(new Time(0,0));
		form.lyrHL7().tabQuery().dteTo().setValue(new Date());
		form.lyrHL7().tabQuery().timTo().setValue(new Time(0,0));		
		form.lyrHL7().tabQuery().cmbPatIdType().setValue(null);
		form.lyrHL7().tabQuery().txtPatId().setValue(null);
		form.lyrHL7().tabQuery().cmbPatIdType().setValue(null);
		form.lyrHL7().tabQuery().lblTotal().setValue("");
		form.lyrHL7().tabQuery().grdMsgs().getRows().clear();
	}

	private void doSearch()
	{
		form.lyrHL7().tabQuery().grdMsgs().getRows().clear();
		DateTime dtFrom = getDateTimeFrom();
		DateTime dtTo = getDateTimeTo();
		
		QryOrderMsgVoCollection messages = domain.listOrdersByDateTimeRange(form.getLocalContext().getPatId(), dtFrom, dtTo);
		
		//WDEV-14638
		if (messages==null || messages.size()==0)
		{
			updateTotalLabel();
			engine.showMessage("There are no Records for the Search Criteria Provided");
			return;
		}
			  
		if (messages != null)
		{
			for (int i = 0; i < messages.size(); i++)
			{
				addRowToGrid(messages.get(i));
			}
		}
		updateTotalLabel();
	}

	private void updateTotalLabel()
	{
		form.lyrHL7().tabQuery().lblTotal().setValue("Total : " + form.lyrHL7().tabQuery().grdMsgs().getRows().size());
	}

	private void addRowToGrid(QryOrderMsgVo messageVo) 
	{
		grdMsgsRow row;

		row = form.lyrHL7().tabQuery().grdMsgs().getRows().newRow();
		row.setcolPatient(messageVo.getOrderDetails().getPatient().getName().toString());
		
		if (messageVo.getSysInfo() != null)
		{
			if ( messageVo.getSysInfo().getCreationDateTime() != null)
				row.setcolDateTime(messageVo.getSysInfo().getCreationDateTime().toString());
			
			if ( messageVo.getSysInfo().getLastupdateDateTime() != null)
				row.setcolLastUpdate(messageVo.getSysInfo().getLastupdateDateTime().toString());			
		}

		if (messageVo.getHL7Message() != null)
		{
			row.setcolMessage(messageVo.getHL7Message().substring(0, 20));
			row.setTooltipForcolMessage(messageVo.getHL7Message());
		}

		row.setcolCategory(messageVo.getOrderCategory().getText());
		row.setcolProvider(messageVo.getProviderSystem().getSystemName());
		if (messageVo.getFailureMessageIsNotNull()&&messageVo.getFailureMessage().length()>=20)
			row.setcolFailure(messageVo.getFailureMessage().substring(0, 20));
		row.setTooltipForcolFailure(messageVo.getFailureMessage());
		row.setcolPlacerNum(messageVo.getPlacerOrdNum().toString());
		row.setcolStatus(messageVo.getMessageStatus().getText());

	}

	protected void onImbSearchClick() throws PresentationLogicException
	{
		if (ConfigFlag.HL7.HL7_START_OUTBOUND.getValue()&& validateSearchCriteria()) //WDEV-14903 
		{
			doSearch();
		}
	}

	protected void onChkStartupFlag() throws PresentationLogicException
	{
		try
		{
			if (getInterfaceType() == INBOUND)
			{
				domain.setInboundFlag(new Boolean(form.lyrHL7().tabInterfaces().chkStart().getValue() == true));
			}
			else
			{
				domain.setOutboundFlag(new Boolean(form.lyrHL7().tabInterfaces().chkStart().getValue() == true));
			}
			refreshScreen();
			enableContextMenuItems();
			
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
		}
	}

	protected void onBtnRefresh() throws PresentationLogicException
	{
		refreshScreen();
		enableContextMenuItems();
	}

	private void refreshScreen()
	{
		populateControlsFromVo(getInterfaceInfo());
	}

	protected void onRadioButtongrpInterfaceValueChanged() throws PresentationLogicException
	{
		refreshScreen();
		enableContextMenuItems();
		updateControlState();//WDEV-14637
	}

	protected void onImbResetClick() throws PresentationLogicException
	{
		clearQueryControls();
	}

	private void clearStatsControls()
	{
		form.lyrHL7().tabInterfaces().grdStats().getRows().clear();
		form.lyrHL7().tabInterfaces().grdStats().setcolFailedCaption("Failed");
		form.lyrHL7().tabInterfaces().grdStats().setcolSuccessfulCaption("Successful");
		form.lyrHL7().tabInterfaces().grdStats().setcolTotalCaption("Processed");
	}

	protected void onBtnRecoverClick() throws PresentationLogicException
	{
		String msg = "Are you sure you wish to clear the existing HL7 Outbound Registration record from the database " + ConfigFlag.DBNAME.getValue() + "? " + "\nOnly use this if you are certain there is no running Outbound Interface.";

		form.getGlobalContext().Core.setYesNoDialogMessage(msg);
		form.getGlobalContext().Core.setHideCancelButton(Boolean.TRUE);
		engine.open(form.getForms().Core.YesNoDialog);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.YesNoDialog))
		{
			if (result.equals(DialogResult.OK) || result.equals(DialogResult.YES))
			{
				domain.clearOutboundRegistration();
			}
		}
	}

	protected void onGrdStatsSelectionChanged() throws PresentationLogicException
	{
		enableContextMenuItems();
	}

	private void enableContextMenuItems()
	{
		form.getContextMenus().getHl7AdminStatsMenuVIEW_FAILEDItem().setVisible(false);
		form.getContextMenus().getHl7AdminStatsMenuVIEW_SUCCESSFULItem().setVisible(false);
		form.getContextMenus().getHl7AdminQryMenuVIEW_MESSAGEItem().setVisible(false);

		if (form.lyrHL7().tabInterfaces().grdStats().getValue() != null)
		{
			if (form.lyrHL7().tabInterfaces().grdStats().getValue().getLastSuccessMessage() != null)
				form.getContextMenus().getHl7AdminStatsMenuVIEW_SUCCESSFULItem().setVisible(true);

			if (form.lyrHL7().tabInterfaces().grdStats().getValue().getLastFailedMessage() != null)
				form.getContextMenus().getHl7AdminStatsMenuVIEW_FAILEDItem().setVisible(true);
		}

		if (form.lyrHL7().tabQuery().grdMsgs().getValue() != null)
		{
			form.getContextMenus().getHl7AdminQryMenuVIEW_MESSAGEItem().setVisible(true);
		}
	}

	protected void onBtnStartStopClick()
	{
		try
		{
			if (getInterfaceType() == INBOUND)
			{
				if (form.getLocalContext().getIsStart().booleanValue())
				{									
					domain.startInbound();
				}
				else
					domain.stopInbound();
				
				refreshScreen();
			}
			else if (getInterfaceType() == OUTBOUND)
			{
				if (form.getLocalContext().getIsStart().booleanValue())
				{
					domain.startOutbound();
				}
				else
					domain.stopOutbound();
				
				//WDEV-3605
				Thread.sleep(5000); //..instead of wait..notify, to allow IP address to display/refresh
				
				refreshScreen();			        								
			}
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		catch (InterruptedException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		finally
		{
			enableContextMenuItems();
		}
		updateControlState();//WDEV-14637
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.Hl7AdminStatsMenu.VIEW_FAILED :
				if(null!=form.lyrHL7().tabInterfaces().grdStats().getValue())
					engine.open(form.getForms().Admin.HL7MessageViewDialog, new Object[]{form.lyrHL7().tabInterfaces().grdStats().getValue().getLastFailedMessage()});
			break;
			case GenForm.ContextMenus.Hl7AdminStatsMenu.VIEW_SUCCESSFUL :
				if(null!=form.lyrHL7().tabInterfaces().grdStats().getValue())
					engine.open(form.getForms().Admin.HL7MessageViewDialog, new Object[]{form.lyrHL7().tabInterfaces().grdStats().getValue().getLastSuccessMessage()});
			break;
			case GenForm.ContextMenus.Hl7AdminQryMenu.VIEW_MESSAGE :
				if(null!=form.lyrHL7().tabQuery().grdMsgs().getValue())
					engine.open(form.getForms().Admin.HL7MessageViewDialog, new Object[]{form.lyrHL7().tabQuery().grdMsgs().getValue().getHL7Message()});
			break;
			case GenForm.ContextMenus.GenericGrid.Update:
				form.setMode(FormMode.EDIT);
			break;
			default :
			break;
		}
	}

	protected void onDteToValueChanged() throws PresentationLogicException
	{
		if (form.lyrHL7().tabQuery().dteTo().getValue() != null)
		{
			if (form.lyrHL7().tabQuery().dteFrom().getValue() == null)
			{
				form.lyrHL7().tabQuery().dteFrom().setValue(form.lyrHL7().tabQuery().dteTo().getValue());
				form.lyrHL7().tabQuery().timFrom().setValue(new Time(0,0));
			}
		}
	}

	protected void onDteFromValueChanged() throws PresentationLogicException
	{
		if (form.lyrHL7().tabQuery().dteFrom().getValue() != null)
		{
			if (form.lyrHL7().tabQuery().dteTo().getValue() == null)
			{
				form.lyrHL7().tabQuery().dteTo().setValue(form.lyrHL7().tabQuery().dteFrom().getValue());
				form.lyrHL7().tabQuery().timTo().setValue(new Time(0,0));
			}
		}
	}

	protected void onGrdMsgsSelectionChanged() throws PresentationLogicException
	{
		// TODO Auto-generated method stub
		System.out.println("Selection changed");
		
	}
	private void isOutBoundRunning() {
	
		
		/*if (!ConfigFlag.HL7.HL7_START_OUTBOUND.getValue())
		{
			form.lyrHL7().tabQuery().setHeaderVisible(false);
			grpInterfaceEnumeration intEnum=null;
			form.lyrHL7().tabInterfaces().grpInterface().setVisible(intEnum.rdoOutbound, false);
			
		}*/
	}

	@Override
	protected void OnbtnOBsearchClick() throws PresentationLogicException
	{
		OutBoundSearch();
	}

	@Override
	protected void onGrdListSelectionChanged() throws PresentationLogicException
	{
		displayDetails(form.lyrHL7().tabDemographicFeed().grdList().getValue());
	}
	
	private void displayDetails(DemographicFeedVo details)
	{
		clearDetails();
		if(details.getMsgTextIsNotNull())
			form.lyrHL7().tabDemographicFeed().txtMessage().setValue(details.getMsgText());
		if(details.getAckTextIsNotNull())
		{
			form.lyrHL7().tabDemographicFeed().txtResponse().setValue(details.getAckText());
		}
		else if (details.getFailureMsgIsNotNull())
		{
			form.lyrHL7().tabDemographicFeed().txtResponse().setValue(details.getFailureMsg());
		}
//		else 
//		{
//			form.lyrHL7().tabDemographicFeed().txtResponse().setVisible(false);
//			form.lyrHL7().tabDemographicFeed().lblresponse().setVisible(false);
//		}
			
	}
	
	private void clearDetails()
	{
		form.lyrHL7().tabDemographicFeed().txtMessage().setValue(null);
		form.lyrHL7().tabDemographicFeed().txtResponse().setValue(null);
	}
	
	private void OutBoundSearch()
	{
		if(	form.lyrHL7().tabDemographicFeed().dtimStart().getValue() != null && form.lyrHL7().tabDemographicFeed().dtimEnd().getValue() != null) //wdev-14649
		{
			if(	form.lyrHL7().tabDemographicFeed().dtimStart().getValue().isGreaterThan(form.lyrHL7().tabDemographicFeed().dtimEnd().getValue()))
			{
				engine.showErrors(new String[]{"Start Date cannot be greater than End Date"});
				return;
			}
		}
		
		DateTime start = form.lyrHL7().tabDemographicFeed().dtimStart().getValue();
		DateTime end = form.lyrHL7().tabDemographicFeed().dtimEnd().getValue();
		PatientId patId = new PatientId();
		patId.setType(form.lyrHL7().tabDemographicFeed().cmbPatId().getValue());
		patId.setValue(form.lyrHL7().tabDemographicFeed().txtOBPatId().getValue());
		MsgEventType msgType =  form.lyrHL7().tabDemographicFeed().cmbMsgType().getValue();
		ProviderSystemRefVo providerSystem = form.lyrHL7().tabDemographicFeed().cmbProviderSystem().getValue();
		populate(domain.getOBFeedEntries(start, end, patId, msgType, providerSystem));
	}

	private void initializeOutBoundTab()
	{
		form.lyrHL7().tabDemographicFeed().dtimStart().setValue(new DateTime(new Date(), new Time()).addHours(-1));
		form.lyrHL7().tabDemographicFeed().dtimEnd().setValue(new DateTime(new Date(), new Time()));
		ProviderSystemLiteVoCollection providerSystems = domain.listProviderSystems();
		if (providerSystems!=null)
		{
			for (ProviderSystemLiteVo providerSystemLiteVo : providerSystems)
			{
				form.lyrHL7().tabDemographicFeed().cmbProviderSystem().newRow(providerSystemLiteVo, providerSystemLiteVo.getSystemName());
			}
		}
	}
	
	
	private void populate(DemographicFeedVoCollection entries)
	{
		form.lyrHL7().tabDemographicFeed().grdList().getRows().clear();
		form.lyrHL7().tabDemographicFeed().grdList().resetScrollPosition();
		form.lyrHL7().tabDemographicFeed().txtMessage().setValue(null);
		form.lyrHL7().tabDemographicFeed().txtResponse().setValue(null);
		
		if (entries==null)
			return;
		
		//WDEV-14647
		if (entries.size()==0)
		{
			engine.showMessage("There are no Records for the Search Criteria Provided");
			return;
		}
		
		for (DemographicFeedVo demographicFeedVo : entries)
		{
			grdListRow row = form.lyrHL7().tabDemographicFeed().grdList().getRows().newRow();
			row.setValue(demographicFeedVo);
			if(demographicFeedVo.getPatientIsNotNull() && demographicFeedVo.getPatient().getNameIsNotNull())
				row.setPatient(demographicFeedVo.getPatient().getName().toString());
			if(demographicFeedVo.getSystemInformationIsNotNull()&&demographicFeedVo.getSystemInformation().getCreationDateTime()!=null)
				row.setCreated(demographicFeedVo.getSystemInformation().getCreationDateTime().toString());
			if(demographicFeedVo.getSystemInformationIsNotNull()&& demographicFeedVo.getSystemInformation().getLastupdateDateTime()!=null)
				row.setUpdated(demographicFeedVo.getSystemInformation().getLastupdateDateTime().toString());
			if(demographicFeedVo.getMsgTextIsNotNull())
				row.setmsgType(demographicFeedVo.getMsgType().getText());
			if (demographicFeedVo.getProviderSystemIsNotNull())
				row.setProviderSystem(demographicFeedVo.getProviderSystem().getSystemName());
			if(demographicFeedVo.getMessageStatusIsNotNull())
				row.setstatus(demographicFeedVo.getMessageStatus().getText());
			
		}
		
	}
	private void initializeTriggersTab()
	{
		open();
	}
	
	private void loadQueueTypes()
	{
		form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().clear();
		QueueTypeCollection collQueueTypes = ims.core.vo.lookups.LookupHelper.getQueueType(domain.getLookupService()); 
		
		for(int i=0;i<collQueueTypes.size(); i++)
		{
			grdSelectQueueTypeRow row = form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().newRow();
			row.setQueueType(collQueueTypes.get(i));
		}
	}

	private void populateScreenFromData(OutboundTriggersVo  value)
	{
		clearInstanceControls();		
		
		if(value == null)
			return;
		
		if(value.getQueueTypeIsNotNull())
		{
			for(int i=0;i<value.getQueueType().size(); i++)
			{
				for(int p=0;p<form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().size();p++)
				{
					grdSelectQueueTypeRow row = form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().get(p);
					if(row.getQueueType().equals(value.getQueueType().get(i)))
						row.setcolSelect(true);
				}
			}
		}
		
	}
	
	private void clearInstanceControls()
	{
		for(int i=0;i<form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().size();i++)
		{
			grdSelectQueueTypeRow row = form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().get(i);
			row.setcolSelect(false);
		}
	}
	

	@Override
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
	}

	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if (save()) //WDEV-17343 call open only if save() returned true
		open();
	}

	@Override
	protected void onGrdProviderSystemSelectionChanged() throws PresentationLogicException
	{
		populateScreenFromData(form.lyrHL7().tabOutboundControl().grdProviderSystem().getValue());
		updateControlState();
	}
	
	private boolean save()
	{
		OutboundTriggersVo voTriggers = populateDataFromScreen(form.lyrHL7().tabOutboundControl().grdProviderSystem().getSelectedRow());
//		ResultSpecimenTypesVo voResSpecType = populateDataFromScreen(form.grdList().getSelectedRow());
	
		//to delete record when config is cleared
		if(voTriggers.getQueueTypeIsNotNull() && voTriggers.getQueueType().size() == 0 && voTriggers.getID_OutboundTriggers() != null)
		{
			try
			{
				domain.deleteOutBoundTriggers(voTriggers);
			}
			catch (ForeignKeyViolationException e)
			{
				engine.showMessage("Delete Failed " + e.getMessage());
				return false;
			}
			return true;
		}
		
		String[] arrErrors = voTriggers.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			domain.saveOutBoundTriggers(voTriggers);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open(); //WDEV-17343
			return false;
		}
	
		return true;
	}
	
	private OutboundTriggersVo populateDataFromScreen(grdProviderSystemRow row)
	{
		OutboundTriggersVo voTriggers = row.getValue();
		if(voTriggers == null)
			voTriggers = new OutboundTriggersVo();
		
		voTriggers.setProviderSystem(row.getValue().getProviderSystem());
		voTriggers.setQueueType(new QueueTypeCollection());
		
		for(int i=0;i<form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().size();i++)
		{
			grdSelectQueueTypeRow rsRow = form.lyrHL7().tabOutboundControl().grdSelectQueueType().getRows().get(i);
			if(rsRow.getcolSelect())
				voTriggers.getQueueType().add(rsRow.getQueueType());
		}
		
		return voTriggers;
	}
	private void updateControlState()
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.lyrHL7().tabOutboundControl().btnEdit().setVisible(true);
			
			form.lyrHL7().tabOutboundControl().btnEdit().setEnabled(form.lyrHL7().tabOutboundControl().grdProviderSystem().getSelectedRow() != null);
			
			form.getContextMenus().getGenericGridUpdateItem().setVisible(form.lyrHL7().tabOutboundControl().grdProviderSystem().getSelectedRow() != null);
		}
		else if(form.getMode().equals(FormMode.EDIT))
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		
		//WDEV-14638
		form.lyrHL7().tabQuery().txtPatId().setEnabled(form.lyrHL7().tabQuery().cmbPatIdType().getValue()!=null);
		
		//WDEV-14647
		form.lyrHL7().tabDemographicFeed().txtOBPatId().setEnabled(form.lyrHL7().tabDemographicFeed().cmbPatId().getValue()!=null);
		
		//WDEV-14637
		form.lyrHL7().tabInterfaces().btnRefresh().setEnabled(!form.lyrHL7().tabInterfaces().txtStatus().getValue().equals("Stopped"));
	}

	private void open()
	{
		clearInstanceControls();	
		
		form.lyrHL7().tabOutboundControl().grdProviderSystem().getRows().clear();
		
		ProviderSystemLiteVoCollection providerSystems = domain.listProviderSystems();
		OutboundTriggersVoCollection triggers = domain.listOutboundTriggers();
		if (providerSystems!=null)
		{
			for (ProviderSystemLiteVo providerSystemLiteVo : providerSystems)
			{
				grdProviderSystemRow row= form.lyrHL7().tabOutboundControl().grdProviderSystem().getRows().newRow();
				for (OutboundTriggersVo outboundTriggersVo : triggers)
				{
					if(outboundTriggersVo.getProviderSystemIsNotNull()&&outboundTriggersVo.getProviderSystem().equals(providerSystemLiteVo))
					{
						row.setValue(outboundTriggersVo);
					}
				}
				if (row.getValue()==null)
				{
					OutboundTriggersVo outboundTriggersVo= new OutboundTriggersVo();
					outboundTriggersVo.setProviderSystem(providerSystemLiteVo);
					row.setValue(outboundTriggersVo);
				}
				row.setProviderSystem(providerSystemLiteVo.getSystemName());
			}
			loadQueueTypes();
		}
		
		form.setMode(FormMode.VIEW);
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlState();
	}

	//WDEV-14638
	@Override
	protected void onCmbPatIdTypeValueChanged()	throws PresentationLogicException 
	{
		updateControlState();	
		if (form.lyrHL7().tabQuery().cmbPatIdType().getValue()==null)
		{
			form.lyrHL7().tabQuery().txtPatId().setValue(null);
		}
			
	}

	//WDEV-14647
	@Override
	protected void onCmbPatIdValueChanged() throws PresentationLogicException 
	{
		updateControlState();	
		if (form.lyrHL7().tabDemographicFeed().cmbPatId().getValue()==null)
		{
			form.lyrHL7().tabDemographicFeed().txtOBPatId().setValue(null);
		}
		
	}
	
}
