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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.53 build 2510.31460)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.supportnetworkcommunityservices;

import ims.core.vo.CommunityServiceVo;
import ims.core.vo.CommunityServiceVoCollection;
import ims.core.vo.LocShortVo;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.LocationServiceVo;
import ims.core.vo.ServiceVoCollection;
import ims.core.vo.SuppNetworkServiceProfessionDetailVo;
import ims.core.vo.SupportNetworkServicesVo;
import ims.core.vo.SupportNetworkServicesVoCollection;
import ims.core.vo.lookups.ServiceCategory;
import ims.core.vo.lookups.ServiceCategoryCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.ctnServiceDetail().customControlAuth().setIsRequiredPropertyToControls(true);
		open();
	}	
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		form.setMode(FormMode.VIEW);
		open();
	}
	public void open() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		form.ctnServiceDetail().setCollapsed(true);
		listSupportCommunityServices();		
		form.setMode(FormMode.VIEW);		
	}
	private void listSupportCommunityServices()
	{
		ServiceCategoryCollection excludedColl = new ServiceCategoryCollection();
		excludedColl.add(ServiceCategory.PATHOLOGY_DISCIPLINE);
		excludedColl.add(ServiceCategory.RADIOLOGY_MODALITY);
		//WDEV-1913 
		ServiceVoCollection voCollService = domain.listService(excludedColl);
		form.ctnServiceDetail().cmbService().clear();

		for (int i = 0; i < voCollService.size(); i++)
			form.ctnServiceDetail().cmbService().newRow(voCollService.get(i), voCollService.get(i).getServiceName());
		
		form.grdDetails().getRows().clear();
	
		CommunityServiceVoCollection voColl = domain.listCommunityServicesByCareContext(form.getGlobalContext().Core.getCurrentCareContext(),Boolean.TRUE);
		CommunityServiceVo vo = null;	
		
		GenForm.grdDetailsRow row = null;
		if(voColl == null || voColl.size() == 0)
		{
			SupportNetworkServicesVoCollection voCollSns = domain.listSupportNetworkServiceByPatient(form.getGlobalContext().Core.getPatientShort(),Boolean.TRUE);
			
			if (voCollSns != null && voCollSns.size()>0)
			{
				//ask user if they want to copy in existing support network services records.
				form.getGlobalContext().Core.setYesNoDialogMessage("Do you want to copy the Support Network Services ?");
				engine.open(form.getForms().Core.YesNoDialog);
				return;
			}
		}
			
		for(int i=0;i<voColl.size();i++)
		{
			vo = voColl.get(i);
			row = form.grdDetails().getRows().newRow();
			if (vo.getServiceIsNotNull())
				row.setComunityService(vo.getService().getServiceName());
			row.setCurrentFrequency(vo.getCurrentFrequency());
			row.setRequested(vo.getIsDischargeServiceIsNotNull()?vo.getIsDischargeService().booleanValue():false); 
			row.setDischargeFrequency(vo.getDischargeFrequency());
			row.setInPlace(vo.getIsServiceInPlaceIsNotNull()?vo.getIsServiceInPlace().booleanValue():false);
			row.setConfirmDate(vo.getConfirmedDate());
			row.setValue(vo);
		}
		
		//set selection back
		if (form.getLocalContext().getSelectedRecordIsNotNull())
		{
			//need to get timestamp from record retrieved from List call.
			GenForm.grdDetailsRow row1 = form.grdDetails().getRowByValue(form.getLocalContext().getSelectedRecord());
			if (row1 != null && row1.getValue() != null)
			{			
				
				form.grdDetails().setValue(form.getLocalContext().getSelectedRecord());
				populateInstanceControl(form.grdDetails().getValue());
			}
			else
				clearInstanceControls();
			form.getLocalContext().setSelectedRecord(form.grdDetails().getValue());
			updateControlsState();			
		}
		else		
			form.ctnServiceDetail().setCollapsed(true);
		
	}
	public void populateInstanceControl(CommunityServiceVo vo)
	{
		clearInstanceControls();
		
		form.getLocalContext().setSelectedRecord(vo);
		form.getContextMenus().getLIPUpdateItem().setVisible(true);
				
		if (vo.getLocationService() != null)
		{
			if (vo.getLocationService().getService() != null){
				form.ctnServiceDetail().cmbService().newRow(vo.getLocationService().getService(), vo.getLocationService().getService().getServiceName());
				form.ctnServiceDetail().cmbService().setValue(vo.getLocationService().getService());
			}
			cmbServiceValueChanged();
		}
		
		if (vo.getSuppliedServiceIsNotNull())
		{
			form.ctnServiceDetail().chkSupplyServiceDetail().setValue(true);
			form.ctnServiceDetail().txtAddressService().setValue(vo.getSuppliedService().getAddress());
			form.ctnServiceDetail().txtAreaLoc().setValue(vo.getSuppliedService().getServiceLocation());
			form.ctnServiceDetail().txtContactPerson().setValue(vo.getSuppliedService().getName());
			form.ctnServiceDetail().txtPhoneNoService().setValue(vo.getSuppliedService().getWorkPhone());
			if (vo.getServiceIsNotNull() && vo.getService().getServiceNameIsNotNull())
			{
				form.ctnServiceDetail().cmbService().newRow(vo.getService(),vo.getService().getServiceName());
				form.ctnServiceDetail().cmbService().setValue(vo.getService());
			}
			
			form.ctnServiceDetail().txtAreaLoc().setVisible(true);
			form.ctnServiceDetail().cmbLocation().setVisible(false);	
			
			
		}
		else if (vo.getLocationServiceIsNotNull())
		{
			form.ctnServiceDetail().chkSupplyServiceDetail().setValue(false);
			if (vo.getLocationService().getLocation() != null)
			{
				if (locationExistsInCombo(vo.getLocationService().getLocation()) == false)
					form.ctnServiceDetail().cmbLocation().newRow(vo.getLocationService().getLocation(), vo.getLocationService().getLocation().getName());

				form.ctnServiceDetail().cmbLocation().setValue(vo.getLocationService().getLocation());
			}

			form.ctnServiceDetail().txtAreaLoc().setVisible(false);
			form.ctnServiceDetail().cmbLocation().setVisible(true);			
			
			cmbLocationValueChanged();			
		}		
		
		form.ctnServiceDetail().customControlAuth().setValue(vo.getAuthoringInformation());		
		form.ctnServiceDetail().txtCFreq().setValue(vo.getCurrentFrequency());
		form.ctnServiceDetail().txtDFreq().setValue(vo.getDischargeFrequency());
		form.ctnServiceDetail().txtCommentsService().setValue(vo.getComments());
		form.ctnServiceDetail().chkInplace().setValue(vo.getIsServiceInPlaceIsNotNull()?vo.getIsServiceInPlace().booleanValue():false);
		form.ctnServiceDetail().chkReqForDis().setValue(vo.getIsDischargeServiceIsNotNull()?vo.getIsDischargeService().booleanValue():false);
		form.ctnServiceDetail().dteConfirmDate().setValue(vo.getConfirmedDate());
		
		form.ctnServiceDetail().setCollapsed(false);
	}	
	private boolean locationExistsInCombo(LocShortVo location)
	{
		LocShortVo loc = null;
		for (int i = 0; i < form.ctnServiceDetail().cmbLocation().getValues().size(); i++)
		{
			loc = (LocShortVo) form.ctnServiceDetail().cmbLocation().getValues().get(i);

			if (loc.getID_Location().equals(location.getID_Location()))
				return true;
		}

		return false;
	}

	public CommunityServiceVo populateDataFromScreen(CommunityServiceVo value) 
	{
		CommunityServiceVo vo = form.getLocalContext().getSelectedRecord();

		if (vo.getID_CommunityServices() == null)
		{
			vo.setIsCurrentlyActive(Boolean.TRUE);
			vo.setCurrentFrequency(form.ctnServiceDetail().txtCFreq().getValue());
			vo.setDischargeFrequency(form.ctnServiceDetail().txtDFreq().getValue());
			vo.setComments(form.ctnServiceDetail().txtCommentsService().getValue());
			vo.setIsServiceInPlace(new Boolean(form.ctnServiceDetail().chkInplace().getValue()));
			vo.setIsDischargeService(new Boolean(form.ctnServiceDetail().chkReqForDis().getValue()));
			vo.setConfirmedDate(form.ctnServiceDetail().dteConfirmDate().getValue());
			
			
			if (form.ctnServiceDetail().chkSupplyServiceDetail().getValue())
			{
				SuppNetworkServiceProfessionDetailVo voProf = new SuppNetworkServiceProfessionDetailVo();

				voProf.setAddress(form.ctnServiceDetail().txtAddressService().getValue());
				voProf.setName(form.ctnServiceDetail().txtContactPerson().getValue());
				voProf.setServiceLocation(form.ctnServiceDetail().txtAreaLoc().getValue());
				voProf.setWorkPhone(form.ctnServiceDetail().txtPhoneNoService().getValue());
				//supplied area/location
				vo.setSuppliedService(voProf);				
			}
			else
			{					
				if (form.getLocalContext().getlocationService() != null)
					vo.setLocationService(form.getLocalContext().getlocationService());
				vo.setSuppliedService(null);
			}				
		}
		else
		{
			//only update frequecy and comments, in place and confirm date
			vo.setDischargeFrequency(form.ctnServiceDetail().txtDFreq().getValue());
			vo.setComments(form.ctnServiceDetail().txtCommentsService().getValue());
			vo.setIsServiceInPlace(new Boolean(form.ctnServiceDetail().chkInplace().getValue()));
			vo.setConfirmedDate(form.ctnServiceDetail().dteConfirmDate().getValue());
			vo.setIsDischargeService(new Boolean(form.ctnServiceDetail().chkReqForDis().getValue()));
		}

		//set for update as well
		vo.setAuthoringInformation(form.ctnServiceDetail().customControlAuth().getValue());
		vo.setService(form.ctnServiceDetail().cmbService().getValue());

		//default currently active to true
		if(vo.getIsCurrentlyActive() == null)
			vo.setIsCurrentlyActive(Boolean.TRUE);
		
		if (vo.getCareContext() == null)
			vo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if (vo.getClinicalContact() == null)
			vo.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
				
		return vo;
	}
	public void clearInstanceControls()
	{
		form.ctnServiceDetail().chkSupplyServiceDetail().setValue(false);
		form.ctnServiceDetail().chkInplace().setValue(false);
		form.ctnServiceDetail().chkReqForDis().setValue(false);
		form.ctnServiceDetail().dteConfirmDate().setValue(null);
		form.ctnServiceDetail().cmbLocation().setValue(null);
		form.ctnServiceDetail().cmbService().setValue(null);
		form.ctnServiceDetail().txtAddressService().setValue(null);
		form.ctnServiceDetail().txtAreaLoc().setValue(null);
		form.ctnServiceDetail().txtCommentsService().setValue(null);
		form.ctnServiceDetail().txtContactPerson().setValue(null);
		form.ctnServiceDetail().txtCFreq().setValue(null);
		form.ctnServiceDetail().txtDFreq().setValue(null);
		form.ctnServiceDetail().txtPhoneNoService().setValue(null);
		form.ctnServiceDetail().customControlAuth().setValue(null);		
	}
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		CommunityServiceVo voComSer = new CommunityServiceVo(); 		
		form.ctnServiceDetail().customControlAuth().initializeComponent();
		
		voComSer.setIsCurrentlyActive(Boolean.TRUE); 
		form.getLocalContext().setSelectedRecord(voComSer);
				
		form.setMode(FormMode.EDIT);
		form.ctnServiceDetail().setcustomControlAuthEnabled(true);

		form.grdDetails().setValue(null);
		
		form.ctnServiceDetail().cmbLocation().clear();
		
		form.ctnServiceDetail().chkSupplyServiceDetail().setEnabled(true);
		form.ctnServiceDetail().setcustomControlAuthEnabled(true);
		form.ctnServiceDetail().cmbLocation().setEnabled(true);
		form.ctnServiceDetail().cmbService().setEnabled(true);
		
		form.ctnServiceDetail().txtAreaLoc().setVisible(false);
		form.ctnServiceDetail().cmbLocation().setVisible(true);
		
	}
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		CommunityServiceVo vo = populateInstanceData();
					 
		if (form.ctnServiceDetail().cmbService().getValue() == null)
		{
			engine.showMessage("Please select a Service Type");
			return false;
		}

		if ((!form.ctnServiceDetail().chkSupplyServiceDetail().getValue()) && form.ctnServiceDetail().cmbLocation().getValue() == null)
		{
			engine.showMessage("Please select a Location");
			return false;
		}
		
		if(vo.getAuthoringInformation() == null || vo.getAuthoringInformation().getAuthoringHcp() == null || vo.getAuthoringInformation().getAuthoringDateTime() == null)
		{
			engine.showMessage("Please enter Authoring Information");
			return false;
		}
		
		String[] arrErrors = vo.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}
		try 
		{
			form.getLocalContext().setSelectedRecord(domain.saveCommunitService(vo));
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		return true;

	}
	protected CommunityServiceVo populateInstanceData() 
	{				
		return populateDataFromScreen(form.getLocalContext().getSelectedRecord());
	}
	
	public void updateControlsState()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.ctnServiceDetail().setCollapsed(false);
			form.ctnServiceDetail().txtAreaLoc().setEnabled(true);
			form.getContextMenus().hideAllLIPMenuItems();
			
			if ((form.getLocalContext().getSelectedRecord() == null) || (form.getLocalContext().getSelectedRecordIsNotNull() && form.getLocalContext().getSelectedRecord().getID_CommunityServices() == null))
			{
				form.ctnServiceDetail().setcustomControlAuthEnabled(true);
			}
		}
		else if (form.getMode().equals(FormMode.VIEW))
		{
			form.btnUpdate().setVisible(form.grdDetails().getValue() != null);
			//form.btnInactive().setVisible(form.grdFamily().getValue() != null);
			//form.btnReactivate().setVisible(false);
						
			form.ctnServiceDetail().cmbLocation().setEnabled(false);
			form.ctnServiceDetail().txtAreaLoc().setEnabled(false);
			form.getContextMenus().getLIPNewItem().setVisible(true);
			form.getContextMenus().getLIPUpdateItem().setVisible(form.grdDetails().getSelectedRow() != null);
		}		
	}
	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
		//form.btnInactiveRecord().setVisible(false);
		form.getContextMenus().hideAllLIPMenuItems();			
		
		if (form.getLocalContext().getSelectedRecord().getAuthoringInformation() == null)
		{
			form.ctnServiceDetail().customControlAuth().initializeComponent();
			form.ctnServiceDetail().setcustomControlAuthEnabled(true);
		}
		else
			form.ctnServiceDetail().setcustomControlAuthEnabled(false);
		
		if (form.getLocalContext().getSelectedRecord().getSuppliedServiceIsNotNull())
		{					
			form.ctnServiceDetail().cmbLocation().setEnabled(true);
			form.ctnServiceDetail().txtAddressService().setEnabled(false);
			form.ctnServiceDetail().txtAreaLoc().setEnabled(false);
			form.ctnServiceDetail().txtContactPerson().setEnabled(false);
			form.ctnServiceDetail().txtPhoneNoService().setEnabled(false);
			form.ctnServiceDetail().chkSupplyServiceDetail().setEnabled(false);
		}
	}
	protected void onFormModeChanged()
	{
		updateControlsState();		
	}
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.LIP.New:
				newInstance();
			break;
			case GenForm.ContextMenus.LIP.Update:
				updateInstance();
			break;
		}				
	}
	protected void onChkSupplyServiceDetailValueChanged() throws PresentationLogicException
	{
		form.ctnServiceDetail().cmbLocation().setVisible(!form.ctnServiceDetail().chkSupplyServiceDetail().getValue());
		form.ctnServiceDetail().cmbLocation().setEnabled(!form.ctnServiceDetail().chkSupplyServiceDetail().getValue() && form.getMode().equals(FormMode.EDIT));
		form.ctnServiceDetail().txtAreaLoc().setVisible(form.ctnServiceDetail().chkSupplyServiceDetail().getValue());
		form.ctnServiceDetail().txtAreaLoc().setEnabled(form.ctnServiceDetail().chkSupplyServiceDetail().getValue());
		form.ctnServiceDetail().txtAddressService().setEnabled(form.ctnServiceDetail().chkSupplyServiceDetail().getValue());
		form.ctnServiceDetail().txtContactPerson().setEnabled(form.ctnServiceDetail().chkSupplyServiceDetail().getValue());
		form.ctnServiceDetail().txtPhoneNoService().setEnabled(form.ctnServiceDetail().chkSupplyServiceDetail().getValue());		
		
		clearRelatedFields();
	}
	private void clearRelatedFields() {
		form.ctnServiceDetail().cmbLocation().setValue(null);
		form.ctnServiceDetail().txtAreaLoc().setValue(null);
		form.ctnServiceDetail().txtAddressService().setValue(null);
		form.ctnServiceDetail().txtContactPerson().setValue(null);
		form.ctnServiceDetail().txtPhoneNoService().setValue(null);
		
	}
	protected void onCmbLocationValueChanged() throws PresentationLogicException
	{
		cmbLocationValueChanged();	
	}
	private void cmbLocationValueChanged()
	{
		LocShortVo voLoc = form.ctnServiceDetail().cmbLocation().getValue();
		form.ctnServiceDetail().txtAddressService().setValue(null);
		if (voLoc != null)
		{
			if (voLoc.getAddressIsNotNull())
				form.ctnServiceDetail().txtAddressService().setValue(voLoc.getAddress().toDisplayStringForMultiLineTextBox());

			LocationServiceVo voLocService = domain.getLocationService(voLoc, form.ctnServiceDetail().cmbService().getValue());

			if (voLocService == null)
				return;

			form.getLocalContext().setlocationService(voLocService);
			if (voLocService.getContact() != null)
			{
				if(voLocService.getContact().getNameIsNotNull())
					form.ctnServiceDetail().txtContactPerson().setValue(voLocService.getContact().getName().toString());
				form.ctnServiceDetail().txtPhoneNoService().setValue(voLocService.getContact().getContactNumber());
			}
		}
	}
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.YesNoDialog) && result.equals(DialogResult.YES))
		{
				//copy in support network services for this care context
				insertServices();
				open();
		}
		
	}
	private void insertServices()
	{
		form.grdDetails().getRows().clear();
		
		Boolean bActiveOnly = Boolean.TRUE;
					
		SupportNetworkServicesVoCollection voColl = domain.listSupportNetworkServiceByPatient(form.getGlobalContext().Core.getPatientShort(),bActiveOnly);
		
		if (voColl != null && voColl.size()>0)
		{
			SupportNetworkServicesVo vo = null;	
			
			GenForm.grdDetailsRow row = null;
			for(int i=0;i<voColl.size();i++)
			{
				vo = voColl.get(i);
				row = form.grdDetails().getRows().newRow();
				if (vo.getSuppliedServiceIsNotNull())
					row.setComunityService(vo.getSuppliedService().getName());
				else if (vo.getServiceIsNotNull())
					row.setComunityService(vo.getService().getServiceName());
				row.setCurrentFrequency(vo.getFrequencyOfService());
				
				//create Community Service vo
				CommunityServiceVo voComSer = new CommunityServiceVo();
				voComSer.setCurrentFrequency(vo.getFrequencyOfService());
				
				//copy if supplied
				if (vo.getSuppliedServiceIsNotNull())
				{
					SuppNetworkServiceProfessionDetailVo voSerProfDet = new SuppNetworkServiceProfessionDetailVo();
					voSerProfDet.setAddress(vo.getSuppliedService().getAddress());
					voSerProfDet.setEmailAddress(vo.getSuppliedService().getEmailAddress());
					voSerProfDet.setMobilePhone(vo.getSuppliedService().getMobilePhone());
					voSerProfDet.setName(vo.getSuppliedService().getName());
					voSerProfDet.setServiceLocation(vo.getSuppliedService().getServiceLocation());
					voSerProfDet.setWorkPhone(vo.getSuppliedService().getWorkPhone());
					voComSer.setSuppliedService(voSerProfDet);
				}
				
				voComSer.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
				voComSer.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
				voComSer.setService(vo.getService());
				voComSer.setLocationService(vo.getLocationService());
				voComSer.setIsCurrentlyActive(new Boolean(true));
				voComSer.setComments(vo.getComments());
				
				String[] arrErrors = voComSer.validate();
				if(arrErrors != null)
				{
					engine.showErrors(arrErrors);			
				}
				try 
				{
					domain.saveCommunitService(voComSer);
				} 
				catch (StaleObjectException e) 
				{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				}
				
				row.setValue(voComSer);
			}
		}
	}
	protected void onGrdDetailsSelectionChanged() throws PresentationLogicException
	{
		form.getLocalContext().setSelectedRecord(form.grdDetails().getValue());
		
		/*
		if (form.grdDetails().getValue().getIsCurrentlyActive().booleanValue())
		{
			form.btnInactiveRecord().setEnabled(true);
			form.btnUpdate().setEnabled(true);
			form.btnInactiveRecord().setVisible(true);	//WDEV-1913 
			form.btnUpdate().setVisible(true);			//WDEV-1913
		}
		else
		{
			form.btnInactiveRecord().setEnabled(false);
			form.btnUpdate().setEnabled(false);
		}
		*/
		
		populateInstanceControl(form.getLocalContext().getSelectedRecord());
		updateControlsState();

	}
	protected void onCmbServiceValueChanged() throws PresentationLogicException 
	{
		cmbServiceValueChanged();		
	}
	private void cmbServiceValueChanged()
	{
		form.ctnServiceDetail().cmbLocation().clear();
		//clearServicesReadOnlyDetails();

		if (form.ctnServiceDetail().cmbService().getValue() == null)
			return;

		LocShortVoCollection voCollLoc = domain.listLocations(form.ctnServiceDetail().cmbService().getValue());
		LocShortVo voLoc = null;

		if (voCollLoc == null)
			return;

		for (int i = 0; i < voCollLoc.size(); i++)
		{
			voLoc = voCollLoc.get(i);

			form.ctnServiceDetail().cmbLocation().newRow(voLoc, voLoc.getName());
		}

	}

}
