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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.62 build 2929.28798)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.demopatientreferrallist;

import ims.clinical.forms.demopatientreferrallist.GenForm.grdDetailsRow;
import ims.clinical.vo.ReferralSearchCriteriaVo;
import ims.clinical.vo.ReferralsRecordingShortVo;
import ims.clinical.vo.ReferralsRecordingShortVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.enums.MosType;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.customControlMos().initialize(MosType.HCP);
		search();
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbSpecialty().setValue(null);
		form.cmbDiscipline().setValue(null);
		form.cmbStatus().setValue(null);
		form.cmbSourceOfReferral().setValue(null);
		form.customControlMos().setValue(null);
		form.dteFrom().setValue(null);
		form.dteTo().setValue(null);
		
		form.grdDetails().getRows().clear();
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}
	
	private void search() 
	{
		
		ReferralSearchCriteriaVo voFilter = new ReferralSearchCriteriaVo();
		
		if ( (form.dteFrom().getValue() != null) && (form.dteTo().getValue() != null)) 
		{
			if (form.dteFrom().getValue().isGreaterThan(form.dteTo().getValue()))
			{
				engine.showMessage("The From and To dates are not in chronological order. Please change.");
				return;
			}
		}
			
		if(form.cmbSpecialty().getValue() != null)
			voFilter.setSpecialtyFunctionCode(form.cmbSpecialty().getValue());
		
		if(form.cmbDiscipline().getValue() != null)
			voFilter.setDiscipline(form.cmbDiscipline().getValue());
		
		if(form.cmbStatus().getValue() != null)
		    voFilter.setReferralStatus(form.cmbStatus().getValue());
		    
		if(form.cmbSourceOfReferral().getValue() != null)
		    voFilter.setReferralSource(form.cmbSourceOfReferral().getValue());
		    
	    if(form.customControlMos().getValue() != null)
	        voFilter.setReferralHCP(form.customControlMos().getValue() instanceof HcpLiteVo ? ((HcpLiteVo)form.customControlMos().getValue()).getMos() : null);
		
		if(form.dteFrom().getValue() != null)
			voFilter.setFromDate(form.dteFrom().getValue());
		
		if(form.dteTo().getValue() != null)
			voFilter.setToDate(form.dteTo().getValue());
		
		voFilter.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		ReferralsRecordingShortVoCollection voColl = domain.listReferralsForPatient(voFilter);
		
		form.grdDetails().getRows().clear();

		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
		form.getContextMenus().getGenericGridViewItem().setVisible(false);
		
		if (voColl == null)
		{
			engine.showMessage("No Referrals found.");
			return;
		}
		
		for(int i = 0 ; i < voColl.size() ; i++)
			addRow(form.grdDetails().getRows().newRow(), voColl.get(i));
	}

	private void addRow(grdDetailsRow row, ReferralsRecordingShortVo vo) 
	{
		row.setColDateSent(vo.getDateSentIsNotNull() ? vo.getDateSent().toString() : "");
		row.setColSpecialty(vo.getSpecialtyFunctionCodeIsNotNull() ? vo.getSpecialtyFunctionCode().getText() : "");
		row.setColDiscipline(vo.getDisciplineIsNotNull() ? vo.getDiscipline().toString() : "");
		row.setColStatus(vo.getReferralStatusIsNotNull() ? vo.getReferralStatus().toString() : "");
		row.setColReferralSource(vo.getReferralSourceIsNotNull() ? vo.getReferralSource().toString() : "");
		row.setColReferredTo(vo.getReferralHCPIsNotNull() ? vo.getReferralHCP().toString() : "");
		
		row.setValue(vo);
	}

	@Override
	protected void onGrdDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
		form.getContextMenus().getGenericGridViewItem().setVisible(true);
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				
	        //	form.getGlobalContext().Core.setCurrentCareContext(null);
	        	form.getGlobalContext().Clinical.setSelectedReferralRecordingVo(null);
			//	form.getGlobalContext().Core.setPatientShort((PatientShort) voInvoiceApproval.getPatient());
				
	    		engine.open(form.getForms().Clinical.DemoreferralDetailsDialog, new Object[] {FormMode.EDIT});
//	    		FormMode mode = FormMode.VIEW;
//	    		if (args != null && args.length == 1)
//	    		{
//	    			if (args[0] instanceof FormMode)
//	    				mode = (FormMode) args[0];
//	    		}
				//set Patient in Global Context to Patient of selected Invoice
			break;

			case GenForm.ContextMenus.GenericGrid.View:
				
	        	form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContext(form.grdDetails().getRows().get(form.grdDetails().getSelectedRowIndex()).getValue().getCareContext()));
	        	form.getGlobalContext().Core.setCurrentClinicalContact(domain.getClinicalContact(form.grdDetails().getRows().get(form.grdDetails().getSelectedRowIndex()).getValue().getClinicalContact()));
	        	form.getGlobalContext().Clinical.setSelectedReferralRecordingVo(form.grdDetails().getRows().get(form.grdDetails().getSelectedRowIndex()).getValue());
			//	form.getGlobalContext().Core.setPatientShort((PatientShort) voInvoiceApproval.getPatient());
				
	    		engine.open(form.getForms().Clinical.DemoreferralDetailsDialog, new Object[] {FormMode.VIEW});
			break;
			
			case GenForm.ContextMenus.GenericGrid.Update:
	        	form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContext(form.grdDetails().getRows().get(form.grdDetails().getSelectedRowIndex()).getValue().getCareContext()));
	        	form.getGlobalContext().Core.setCurrentClinicalContact(domain.getClinicalContact(form.grdDetails().getRows().get(form.grdDetails().getSelectedRowIndex()).getValue().getClinicalContact()));
	        	form.getGlobalContext().Clinical.setSelectedReferralRecordingVo(form.grdDetails().getRows().get(form.grdDetails().getSelectedRowIndex()).getValue());
			//	form.getGlobalContext().Core.setPatientShort((PatientShort) voInvoiceApproval.getPatient());
				
	    		engine.open(form.getForms().Clinical.DemoreferralDetailsDialog, new Object[] {FormMode.EDIT});
			break;
			
			default:
				break;
		}
	}
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (formName.equals(form.getForms().Clinical.DemoreferralDetailsDialog))
		{
			search();
		}
	}
}
