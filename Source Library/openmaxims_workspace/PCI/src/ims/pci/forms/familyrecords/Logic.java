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
// This code was generated by Andrei Stefan Bondar using IMS Development Environment (version 1.62 build 3009.29450)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.forms.familyrecords;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.lookups.ChannelType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.FormName;
import ims.framework.LayerBridge;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.pci.vo.ClientAddressVo;
import ims.pci.vo.ClientVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
		PatientShort clientToDisplay = form.getGlobalContext().Core.getPatientToBeDisplayed();
		if(clientToDisplay == null)
			clientToDisplay = form.getGlobalContext().Core.getPatientShort();
		
		if(clientToDisplay != null)
		{
			ClientVo clientFromDemographic = null;
			
			try 
			{
				clientFromDemographic = domain.getClientFull(clientToDisplay);
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(e.getMessage());
			}
			
			boolean isParent = domain.isParent(clientFromDemographic);
			
			form.getLocalContext().setparentClient(clientFromDemographic);
			form.getLocalContext().setchildClient(clientFromDemographic);
			
			if(((clientFromDemographic.getClientParentIsNotNull() && clientFromDemographic.getDobIsNotNull() && clientFromDemographic.calculateAge() < 16) || (clientFromDemographic.getDobIsNotNull() && clientFromDemographic.calculateAge() < 16)) && !isParent)
			{
				form.lyrFamily().showtabPage2();
				
				populateChild(form.getLocalContext().getchildClient());
			}
			else
			{
				form.lyrFamily().showtabPage1();
				
				populateParent(form.getLocalContext().getparentClient());
				populateGridWithChilds(form.getLocalContext().getparentClient());
			}
		}
	}
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.PCINamespace.FamilyRecordsContextMenu.ViIEW_DEMOGRAPHICS:
				viewChildDemographics(form.lyrFamily().tabPage1().grdChilds().getValue());
				break;
			case GenForm.ContextMenus.PCINamespace.FamilyRecordsContextMenu.LINK:
				linkChild();
				break;
			case GenForm.ContextMenus.PCINamespace.FamilyRecordsContextMenu.UNLINK:
				unlinkChild();
				break;
		}
	}
	
	private void viewChildDemographics(PatientShort child) 
	{
		form.getGlobalContext().Core.setPatientToBeDisplayed(child);
		
		if(!isFamilyRecordsDialog())
		{
			engine.open(ConfigFlag.UI.DEMOGRAPHICS_FORM.getValue());
		}
		else
		{
			engine.close(DialogResult.OK);
		}
	}

	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		updateControlsState();
	}
	
	public void clearInstanceControls()
	{
		// TODO: Add you code here.
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
		return false;
	}
	
	private boolean isFamilyRecordsDialog() 
	{
		if(engine.getFormName().equals(form.getForms().PCI.FamilyRecordsDialog))
			return true;
		return false;
	}
	
	public void updateControlsState()
	{
		form.lyrFamily().tabPage1().btnSelectParent().setEnabled(form.getMode().equals(FormMode.VIEW));
		form.lyrFamily().tabPage1().btnUnlink().setEnabled(form.lyrFamily().tabPage1().grdChilds().getValue() instanceof PatientShort && form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getparentClientIsNotNull());
		
		form.lyrFamily().tabPage1().btnParentUpdateAddress().setEnabled(form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getparentClientIsNotNull());
		
		form.getContextMenus().PCI.getFamilyRecordsContextMenuViIEW_DEMOGRAPHICSItem().setVisible(form.getMode().equals(FormMode.VIEW) && form.lyrFamily().tabPage1().grdChilds().getValue() instanceof PatientShort);
		form.getContextMenus().PCI.getFamilyRecordsContextMenuUNLINKItem().setVisible(form.lyrFamily().tabPage1().grdChilds().getValue() instanceof PatientShort && form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getparentClientIsNotNull());
		
		if(form.getMode().equals(FormMode.EDIT))
		{
			form.lyrFamily().tabPage1().btnLinkChild().setEnabled(form.lyrFamily().tabPage1().grdChilds().getValue() instanceof PatientShort && form.lyrFamily().tabPage1().grdChilds().getSelectedRow().getBackColor().equals(Color.Beige) && form.getLocalContext().getparentClientIsNotNull());
			form.getContextMenus().PCI.getFamilyRecordsContextMenuLINKItem().setVisible(form.lyrFamily().tabPage1().grdChilds().getValue() instanceof PatientShort && form.lyrFamily().tabPage1().grdChilds().getSelectedRow().getBackColor().equals(Color.Beige) && form.getLocalContext().getparentClientIsNotNull());
		}
		else
		{
			form.lyrFamily().tabPage1().btnLinkChild().setEnabled(form.getLocalContext().getparentClientIsNotNull());
			form.getContextMenus().PCI.getFamilyRecordsContextMenuLINKItem().setVisible(form.getLocalContext().getparentClientIsNotNull());
		}
		
		//tabPage2
		form.lyrFamily().tabPage2().btnSelectChild().setEnabled(form.getMode().equals(FormMode.VIEW));
		form.lyrFamily().tabPage2().btnSelectGuardian().setEnabled(form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getchildClientIsNotNull());
		form.lyrFamily().tabPage2().btnUnlinkChild().setEnabled(form.getMode().equals(FormMode.VIEW) && form.getLocalContext().getguardianClientIsNotNull()
				&& (!form.getLocalContext().getnewGuardianClientIsNotNull() || (form.getLocalContext().getnewGuardianClientIsNotNull() && form.getLocalContext().getguardianClient().equals(form.getLocalContext().getnewGuardianClient()))));
		form.lyrFamily().tabPage2().btnLinkParent().setEnabled(form.getMode().equals(FormMode.EDIT) && form.getLocalContext().getnewGuardianClientIsNotNull()
				&& (!form.getLocalContext().getguardianClientIsNotNull() || (form.getLocalContext().getguardianClientIsNotNull() && !form.getLocalContext().getguardianClient().equals(form.getLocalContext().getnewGuardianClient()))));

		// WDEV - 5534
		// The button should be hidden at all times from DevEnv - if changes are made regarding the button then update this line also
//		form.lyrFamily().tabPage2().btnChildUpdateAddress().setEnabled(form.getLocalContext().getchildClientIsNotNull() && (form.getLocalContext().getguardianClientIsNotNull()
//				&& (!form.getLocalContext().getnewGuardianClientIsNotNull() || (form.getLocalContext().getnewGuardianClientIsNotNull() && form.getLocalContext().getguardianClient().equals(form.getLocalContext().getnewGuardianClient())))));
	}
	
	public void updateInstance()
	{
		// TODO: Add you code here.
	}
	
	@Override
	protected void onBtnLinkChildClick() throws PresentationLogicException 
	{
		linkChild();
	}

	private void linkChild() 
	{
		//engine.open(form.getForms().PCI.LinkChildDialog);
		if(form.getLocalContext().getcanLinkChildIsNotNull() && form.getLocalContext().getcanLinkChild())
		{
			String message = "";
			if(form.getLocalContext().getparentClientIsNotNull() && form.getLocalContext().getparentClient().getDobIsNotNull() && form.getLocalContext().getparentClient().calculateAge() < 16)
			{
				message = "This Parent\\Guardian is < 16 years old. ";
			}
			else if(form.lyrFamily().tabPage1().grdChilds().getValue() instanceof PatientShort && form.lyrFamily().tabPage1().grdChilds().getValue().calculateAge() > 16)
			{
				message = "This client is > 16 years old. ";
			}
			form.getLocalContext().setcanLinkChild(null);
			form.getLocalContext().setidLinkMessageBox(engine.showMessage(message + "Do you wish to link this client record to the Parent\\Guardian record?", "", MessageButtons.YESNO, MessageIcon.QUESTION));
		}
		else if(!form.getLocalContext().getcanLinkChildIsNotNull() || (form.getLocalContext().getcanLinkChildIsNotNull() && !form.getLocalContext().getcanLinkChild()))
		{
			form.getLocalContext().setisLinkSearch(true);
			engine.open(form.getForms().PCI.ParentSearch);
		}
	}
	
	@Override
	protected void onBtnLinkParentClick() throws PresentationLogicException 
	{
		String message = "";
		
		if(form.getLocalContext().getnewGuardianClientIsNotNull() && form.getLocalContext().getnewGuardianClient().calculateAge() < 16)
		{
			message = "This client is < 16 years old. ";
		}
		form.getLocalContext().setidLinkChildMessageBox(engine.showMessage(message + "Do you wish to link this client record to the Parent\\Guardian record?", "", MessageButtons.YESNO, MessageIcon.QUESTION));
	}
	
	@Override
	protected void onBtnParentUpdateAddressClick() throws PresentationLogicException 
	{
		if(form.getLocalContext().getparentClientIsNotNull())
		{
			openUpdateAddressDialog(form.getLocalContext().getparentClient());
		}
		form.getGlobalContext().PCI.setClientParent(form.getLocalContext().getparentClient());
		engine.open(form.getForms().PCI.UpdateAddressDialog);
	}

	private void openUpdateAddressDialog(PatientShort client) 
	{
		ClientVo clientFull = getClientFull(client);
		if(clientFull != null && clientFull.getAddressIsNotNull() && clientFull.getCommunityCareIsNotNull())
		{
			ClientAddressVo addresses = new ClientAddressVo();
			addresses.setPersonAddress(clientFull.getAddress());
			addresses.setCommunityCare(clientFull.getCommunityCare());
			form.getGlobalContext().PCI.setClientAddresses(addresses);
		}
	}
	
	@Override
	protected void onBtnChildUpdateAddressClick() throws PresentationLogicException 
	{
		if(form.getLocalContext().getchildClientIsNotNull())
		{
			openUpdateAddressDialog(form.getLocalContext().getchildClient());
		}
		form.getGlobalContext().PCI.setClientParent(form.getLocalContext().getguardianClient());
		engine.open(form.getForms().PCI.UpdateAddressDialog);
	}
	
	@Override
	protected void onBtnSelectChildClick() throws PresentationLogicException 
	{
		form.getLocalContext().setisChildSearch(true);
		engine.open(form.getForms().PCI.ParentSearch);
	}
	
	@Override
	protected void onBtnSelectGuardianClick() throws PresentationLogicException 
	{
		form.getLocalContext().setisGuardianSearch(true);
		engine.open(form.getForms().PCI.ParentSearch);
	}
	
	@Override
	protected void onBtnSelectParentClick() throws PresentationLogicException 
	{
		form.getLocalContext().setisParentSearch(true);
		engine.open(form.getForms().PCI.ParentSearch);
	}
	
	@Override
	protected void onBtnUnlinkChildClick() throws PresentationLogicException 
	{
		form.getLocalContext().setidUnlinkChildMessageBox(engine.showMessage("Do you wish to unlink this client record from the Parent\\Guardian record?", "", MessageButtons.YESNO, MessageIcon.QUESTION));
	}
	
	@Override
	protected void onBtnUnlinkClick() throws PresentationLogicException 
	{
		unlinkChild();
	}

	private void unlinkChild() 
	{
		form.getLocalContext().setidUnlinkMessageBox(engine.showMessage("Do you wish to unlink this client record from the Parent\\Guardian record?", "", MessageButtons.YESNO, MessageIcon.QUESTION));
	}
	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().PCI.ParentSearch) && result.equals(DialogResult.OK))
		{
			if(form.getLocalContext().getisParentSearchIsNotNull() && form.getLocalContext().getisParentSearch())
			{
				form.getLocalContext().setisParentSearch(null);
				form.getLocalContext().setparentClient(form.getGlobalContext().PCI.getClient());
				populateParent(form.getLocalContext().getparentClient());
				populateGridWithChilds(form.getLocalContext().getparentClient());
			}
			if(form.getLocalContext().getisLinkSearchIsNotNull() && form.getLocalContext().getisLinkSearch())
			{
				if(domain.verifyFamilyTree(form.getLocalContext().getparentClient(), form.getGlobalContext().PCI.getClient()))
				{
					form.getLocalContext().setcanLinkChild(true);
					form.setMode(FormMode.EDIT);
					addChildToGrid(form.getGlobalContext().PCI.getClient(), Color.Beige, true);
				}
				else// if(form.getGlobalContext().PCI.getClient().equals(form.getLocalContext().getparentClient()))
				{
					engine.showMessage("The client you are about to add, is already a parent in the hierarchy.");
				}
				form.getLocalContext().setisLinkSearch(null);
			}
			if(form.getLocalContext().getisChildSearchIsNotNull() && form.getLocalContext().getisChildSearch())
			{
				clearChildAll();
				form.getLocalContext().setisChildSearch(null);
				form.getLocalContext().setchildClient(form.getGlobalContext().PCI.getClient());
				populateChild(form.getLocalContext().getchildClient());
			}
			if(form.getLocalContext().getisGuardianSearchIsNotNull() && form.getLocalContext().getisGuardianSearch())
			{
				//if(!form.getGlobalContext().PCI.getClient().equals(form.getLocalContext().getchildClient()))
				if(!(form.getLocalContext().getguardianClientIsNotNull() && form.getLocalContext().getguardianClient().equals(form.getGlobalContext().PCI.getClient())))
				{
					if(domain.verifyFamilyTree(form.getGlobalContext().PCI.getClient(), form.getLocalContext().getchildClient()))
					{
						form.getLocalContext().setnewGuardianClient(form.getGlobalContext().PCI.getClient());
						form.setMode(FormMode.EDIT);
						populateGuardian(form.getLocalContext().getnewGuardianClient());
					}
					else// if(form.getGlobalContext().PCI.getClient().equals(form.getLocalContext().getchildClient()))
					{
						engine.showMessage("The client you are about to add, is already a child in the hierarchy.");
					}
				}
				form.getLocalContext().setisGuardianSearch(null);
			}
		}
		if(formName.equals(form.getForms().PCI.UpdateAddressDialog) && result.equals(DialogResult.OK))
		{
			updateScreen();
		}
		
		updateControlsState();
	}

	private void updateScreen() 
	{
		if(form.lyrFamily().tabPage1().isVisible())
		{
			if(form.getLocalContext().getparentClientIsNotNull())
			{
				PatientShort newParent = domain.getPatientShort(form.getLocalContext().getparentClient());
				if(newParent != null)
				{
					form.getLocalContext().setparentClient(newParent);
					populateParent(form.getLocalContext().getparentClient());
					populateGridWithChilds(form.getLocalContext().getparentClient());
				}
			}
		}
		else if(form.lyrFamily().tabPage2().isVisible())// && form.getLocalContext().getguardianClientIsNotNull())
		{
			if(form.getLocalContext().getchildClientIsNotNull())
			{
				PatientShort newChild = domain.getPatientShort(form.getLocalContext().getchildClient());
				if(newChild != null)
				{
					form.getLocalContext().setchildClient(newChild);
					populateChild(form.getLocalContext().getchildClient());
				}
			}
		}
	}
	
	private ClientVo getClientFull(PatientShort clientShort) 
	{
		if(clientShort == null)
			return null;
		
		ClientVo clientFull  = null;
		try 
		{
			clientFull = domain.getClientFull(clientShort);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}
		
		return clientFull;
	}

	private void populateChild(PatientShort child) 
	{
		clearChild();
		
		if(child == null)
			return;
		
		form.lyrFamily().tabPage2().txtNameChild().setValue(child.getNameIsNotNull() ? child.getName().toString() : null);
		form.lyrFamily().tabPage2().txtClientIdChild().setValue(extractClientId(child));
		form.lyrFamily().tabPage2().txtAddressChild().setValue(child.getAddressIsNotNull() ? child.getAddress().toDisplayString() : null);
		form.lyrFamily().tabPage2().txtPhoneChild().setValue(extractPhone(child));
		
		//get parent
		try 
		{
			form.getLocalContext().setguardianClient(domain.getParent(child));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		}
		
		populateGuardian(form.getLocalContext().getguardianClient());
		
		if (!domain.isParent(child) && child.calculateAge() < 16)
		{
			form.getLocalContext().setparentClient(form.getLocalContext().getguardianClient());
		}
	}

	private void populateGuardian(PatientShort parent) 
	{
		clearGuardian();
		
		if(parent == null)
			 return;
		
		form.lyrFamily().tabPage2().txtNameGuardian().setValue(parent.getNameIsNotNull() ? parent.getName().toString() : null);
		form.lyrFamily().tabPage2().txtClientIdGuardian().setValue(extractClientId(parent));
		form.lyrFamily().tabPage2().txtAddressGuardian().setValue(parent.getAddressIsNotNull() ? parent.getAddress().toDisplayString() : null);
		form.lyrFamily().tabPage2().txtPhoneGuardian().setValue(extractPhone(parent));
	}

	private String extractClientId(PatientShort child) 
	{
		if(child.getIdentifiers() != null)
		{
			for(int i =0; i<child.getIdentifiers().size(); i++)
			{
				if(child.getIdentifiers().get(i) != null && child.getIdentifiers().get(i).getTypeIsNotNull() && child.getIdentifiers().get(i).getType().equals(PatIdType.CLIENTID))
				{
					return child.getIdentifiers().get(i).getValue();
				}
			}
		}
		return null;
	}

	private void clearChild() 
	{
		form.lyrFamily().tabPage2().txtNameChild().setValue(null);
		form.lyrFamily().tabPage2().txtClientIdChild().setValue(null);
		form.lyrFamily().tabPage2().txtAddressChild().setValue(null);
		form.lyrFamily().tabPage2().txtPhoneChild().setValue(null);
		
		clearGuardian();
	}

	private void clearGuardian() 
	{
		form.lyrFamily().tabPage2().txtNameGuardian().setValue(null);
		form.lyrFamily().tabPage2().txtClientIdGuardian().setValue(null);
		form.lyrFamily().tabPage2().txtAddressGuardian().setValue(null);
		form.lyrFamily().tabPage2().txtPhoneGuardian().setValue(null);
	}

	private void populateParent(PatientShort parent) 
	{
		clearParent();
		
		if(parent == null)
			return;
		
		form.lyrFamily().tabPage1().txtNameParent().setValue(parent.getNameIsNotNull() ? parent.getName().toString() : null);
		form.lyrFamily().tabPage1().txtAddress().setValue(parent.getAddressIsNotNull() ? parent.getAddress().toDisplayString() : null);
		form.lyrFamily().tabPage1().txtClientId().setValue(extractClientId(parent));
		form.lyrFamily().tabPage1().txtPhoneParent().setValue(extractPhone(parent));
	}

	private String extractPhone(PatientShort parent) 
	{
		if(parent == null)
			return null;
		
		String phone = "";
		if(parent.getCommChannelsIsNotNull())
		{
			for(int i=0; i<parent.getCommChannels().size(); i++)
			{
				
				if(parent.getCommChannels().get(i) != null && parent.getCommChannels().get(i).getChannelTypeIsNotNull())
				{
					if(parent.getCommChannels().get(i).getChannelType().equals(ChannelType.HOME_PHONE))
					{
						phone = phone + (phone != null && phone.length()>0 ? ", " : "") + parent.getCommChannels().get(i).getCommValue();
					}
					if(parent.getCommChannels().get(i).getChannelType().equals(ChannelType.MOBILE))
					{
						phone = phone + (phone != null && phone.length()>0 ? ", " : "") + parent.getCommChannels().get(i).getCommValue();
					}
				}
			}
		}
		if(phone.length() > 0)
			return phone;
		
		return null;
	}

	private void clearParent() 
	{
		form.lyrFamily().tabPage1().txtNameParent().setValue(null);
		form.lyrFamily().tabPage1().txtClientId().setValue(null);
		form.lyrFamily().tabPage1().txtAddress().setValue(null);
		form.lyrFamily().tabPage1().txtPhoneParent().setValue(null);
		form.lyrFamily().tabPage1().grdChilds().getRows().clear();
		form.getLocalContext().setisParentSearch(null);
		form.getLocalContext().setisLinkSearch(null);
		form.getLocalContext().setcanLinkChild(null);
	}

	private void populateGridWithChilds(PatientShort parent) 
	{
		form.lyrFamily().tabPage1().grdChilds().getRows().clear();
		
		if(parent == null || (parent != null && !parent.getID_PatientIsNotNull()))
			return;
		
		PatientShortCollection listChilds = domain.listChilds(parent);
		
		if(listChilds == null)
			return;
		
		for(int i=0; i<listChilds.size(); i++)
		{
			if(listChilds.get(i) != null)
			{
				addChildToGrid(listChilds.get(i), Color.White, false);
			}
		}
	}

	private void addChildToGrid(PatientShort clientVo, Color color, boolean selectRow) 
	{
		GenForm.lyrFamilyLayer.tabPage1Container.grdChildsRow row = form.lyrFamily().tabPage1().grdChilds().getRows().newRow(selectRow);
		
		row.setColClientID(extractClientId(clientVo));
		
		row.setColClientName(clientVo.getNameIsNotNull() ? clientVo.getName().toString() : null);
		
		row.setColDOB(clientVo.getDobIsNotNull() ? clientVo.getDob().toString() : null);
		
		row.setColClientSex(clientVo.getSexIsNotNull() ? clientVo.getSex().getIItemText() : null);
		
		row.setColClientAddress(clientVo.getAddressIsNotNull() ? clientVo.getAddress().toDisplayString() : null);
		
		row.setBackColor(color);
		row.setValue(clientVo);
	}

	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}
	
	@Override
	protected void onGrdChildsSelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if(form.getLocalContext().getidLinkMessageBoxIsNotNull() && form.getLocalContext().getidLinkMessageBox() == messageBoxId)
		{
			if(result.equals(DialogResult.YES))
			{
				updateChild(form.lyrFamily().tabPage1().grdChilds().getValue(), form.getLocalContext().getparentClient());	
			}
			form.setMode(FormMode.VIEW);
			populateGridWithChilds(form.getLocalContext().getparentClient());
		}
		if(form.getLocalContext().getidUnlinkMessageBoxIsNotNull() && form.getLocalContext().getidUnlinkMessageBox() == messageBoxId)
		{
			if(result.equals(DialogResult.YES))
			{
				updateChild(form.lyrFamily().tabPage1().grdChilds().getValue(), null);
			}
			populateGridWithChilds(form.getLocalContext().getparentClient());
		}
		if(form.getLocalContext().getidUnlinkChildMessageBoxIsNotNull() && form.getLocalContext().getidUnlinkChildMessageBox() == messageBoxId)
		{
			if(result.equals(DialogResult.YES))
			{
				updateChild(form.getLocalContext().getchildClient(), null);
			}
			form.getLocalContext().setguardianClient(null);
			form.getLocalContext().setnewGuardianClient(null);
			populateChild(form.getLocalContext().getchildClient());
		}
		if(form.getLocalContext().getidLinkChildMessageBoxIsNotNull() && form.getLocalContext().getidLinkChildMessageBox() == messageBoxId)
		{
			if(result.equals(DialogResult.YES))
			{
				updateChild(form.getLocalContext().getchildClient(), form.getLocalContext().getnewGuardianClient());
			}
			if(result.equals(DialogResult.NO))
			{
				form.getLocalContext().setnewGuardianClient(null);
			}
			form.setMode(FormMode.VIEW);
			populateChild(form.getLocalContext().getchildClient());
		}
		updateControlsState();
	}

	private void updateChild(PatientShort child, PatientShort parent) 
	{
		if(child == null)
			return;
		
		try 
		{
			domain.updateChild(child, parent);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(e.getMessage());
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
		}
	}

	@Override
	protected void onlyrFamilyTabChanged(LayerBridge tab) 
	{
		if(tab.equals(form.lyrFamily().tabPage1()))
		{
			populateParent(form.getLocalContext().getparentClient());
			populateGridWithChilds(form.getLocalContext().getparentClient());
		}
		else if(tab.equals(form.lyrFamily().tabPage2()))
		{
			populateChild(form.getLocalContext().getchildClient());
		}
		
		form.getLocalContext().setnewGuardianClient(null);
		
		updateScreen();
		
		form.setMode(FormMode.VIEW);
	}

	private void clearChildAll() 
	{
		clearChild();
		form.getLocalContext().setguardianClient(null);
		form.getLocalContext().setchildClient(null);
		form.getLocalContext().setnewGuardianClient(null);
	}
}
