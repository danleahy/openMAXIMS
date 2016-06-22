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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.22 build 50211.900)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.forms.medconcernonadmis;


import ims.core.vo.PatientCurrentConcernVo;
import ims.core.vo.PatientCurrentConcernVoCollection;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.PatientConcernStatus;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.spinalinjuries.helper.SysInfoUtil;
import ims.spinalinjuries.vo.MedConcernOnAdmisSearchCriteriaVo;
import ims.vo.interfaces.IMos;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		//WDEV-19389 
		if (!(form.getGlobalContext().Core.getPatientShortIsNotNull() && form.getGlobalContext().SpinalInjuries.getMedConcernOnAdmisSearchCriteriaIsNotNull() && form.getGlobalContext().SpinalInjuries.getMedConcernOnAdmisSearchCriteria().getPatientIsNotNull() && form.getGlobalContext().Core.getPatientShort().equals(form.getGlobalContext().SpinalInjuries.getMedConcernOnAdmisSearchCriteria().getPatient())))
			form.getGlobalContext().SpinalInjuries.setMedConcernOnAdmisSearchCriteria(null);
		
		if(form.getGlobalContext().SpinalInjuries.getMedConcernOnAdmisSearchCriteriaIsNotNull())
		{
			setSearchCriteria(form.getGlobalContext().SpinalInjuries.getMedConcernOnAdmisSearchCriteria());
			listPatientConcerns(form.customControlMos().getValue(), form.cmbStatus().getValue());
		}
		else
			listPatientConcerns(null, null);
		//WDEV-19389 - end
		updateControlsState();
	}
	
	private MedConcernOnAdmisSearchCriteriaVo getSearchCriteria()
	{
		MedConcernOnAdmisSearchCriteriaVo searchCriteria = new MedConcernOnAdmisSearchCriteriaVo();
		
		searchCriteria.setMos(form.customControlMos().getValue());
		searchCriteria.setStatus(form.cmbStatus().getValue());
		searchCriteria.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return searchCriteria;
	}
	
	
	private void setSearchCriteria(MedConcernOnAdmisSearchCriteriaVo medConcernOnAdmisSearchCriteriaVo)
	{
		form.customControlMos().setValue(medConcernOnAdmisSearchCriteriaVo.getMos());
		form.cmbStatus().setValue(medConcernOnAdmisSearchCriteriaVo.getStatus());
	}

	private void initialize() 
	{
		form.customControlMos().initialize(MosType.HCP);
		form.customControlMos().setEnabled(true);
	}

	private void listPatientConcerns(IMos iHcp, PatientConcernStatus status) 
	{
		form.getGlobalContext().SpinalInjuries.setViewRecord(new Boolean(false));
		form.grdConcernList().getRows().clear();
		
		PatientCurrentConcernVo voConcern;
		PatientCurrentConcernVoCollection voCollConcerns = domain.listPatientConcern(form.getGlobalContext().Core.getPatientShort(),iHcp,status);
		
		GenForm.grdConcernListRow row = null;
		
		for(int i=0;i<voCollConcerns.size();i++)
		{
			row = form.grdConcernList().getRows().newRow();
			voConcern = voCollConcerns.get(i);
			
			row.setcolConcern(voConcern.getConcernDescription());
		
			if(voConcern.getMemberIdentifiedIsNotNull())
				row.setcolIdentifiedBy(voConcern.getMemberIdentified().toString());		
			if(voConcern.getAllocToTeamMemberIsNotNull())
				row.setcolAllocatedTo(voConcern.getAllocToTeamMember().toString());
			if(voConcern.getConcernStatusIsNotNull())
				row.setcolStatus(voConcern.getConcernStatus().getText());
			
			//30/11/2005 - Replace Recording/Updating date/time with SystemInformation
			Date creationDate    = SysInfoUtil.getCreationDate(voConcern.getSysInfo());
			Date lastUpdatedDate = SysInfoUtil.getLastUpdatedDate(voConcern.getSysInfo());
			row.setcolDate(creationDate != null?creationDate.toString():"");
			row.setcolStatusDate(lastUpdatedDate != null?lastUpdatedDate.toString():creationDate.toString());
			
			row.setValue(voConcern);	
		}
		
		
		form.grdConcernList().setValue(form.getLocalContext().getCurrentConcern()); //WDEV-15355
		
		if(form.grdConcernList().getValue() != null)
		{
			form.getLocalContext().setCurrentConcern(domain.getConcern(form.grdConcernList().getValue()));
		}
		else
		{
			form.getLocalContext().setCurrentConcern(null);
		}
		
	}
	
	private void newConcern() 
	{
		form.getGlobalContext().SpinalInjuries.setPatientConcern(null);
		engine.open(form.getForms().SpinalInjuries.SharedNewConcern);
	}
	
	private void updateConcern() 
	{
		PatientCurrentConcernVo voConcern = form.grdConcernList().getValue();
		if(voConcern == null)
		{
			engine.showMessage("Please select a record to Update");
			return;
		}
		
		form.getGlobalContext().SpinalInjuries.setPatientConcern(voConcern);
		engine.open(form.getForms().SpinalInjuries.SharedNewConcern);
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		if (sender.equals(form.grdConcernList()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.GenericGrid.Add:
					newConcern();
					break;
				case GenForm.ContextMenus.GenericGrid.Update:
					updateConcern();					
					break;
				case GenForm.ContextMenus.GenericGrid.View:
					viewConcern();
			}
		}	
	}

	private void viewConcern()
	{
		PatientCurrentConcernVo voConcern = form.grdConcernList().getValue();
		if(voConcern == null)
		{
			engine.showMessage("Please select a record to View");
			return;
		}
		
		form.getGlobalContext().SpinalInjuries.setViewRecord(new Boolean(true));
		form.getGlobalContext().SpinalInjuries.setPatientConcern(voConcern);
		engine.open(form.getForms().SpinalInjuries.SharedNewConcern);
	}

	protected void onFormModeChanged() 
	{
		updateControlsState();	
	}

	/*private boolean isMedicalAdmission()
	{
		ClinicalContactShortVo voClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		boolean isMedicalAdmission = voClinicalContact != null && voClinicalContact.getContactType().equals(ContactType.SPINALMEDICALADMISSION);
		return isMedicalAdmission;
	}*/

	protected void onGrdConcernListSelectionChanged() throws PresentationLogicException 
	{
		if(form.grdConcernList().getValue() instanceof PatientCurrentConcernVo)
			form.getLocalContext().setCurrentConcern(form.grdConcernList().getValue());
		
		updateControlsState();
	}

	//WDEV-7044
	private void updateContextMenu()
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(form.getMode().equals(FormMode.VIEW));	
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdConcernList().getReadOnly() && form.grdConcernList().getSelectedRowIndex() >= 0);
		form.getContextMenus().getGenericGridViewItem().setVisible(form.grdConcernList().getSelectedRowIndex() >= 0);
	}
	
	protected void onCmbStatusValueChanged() throws PresentationLogicException
	{
		listPatientConcerns(form.customControlMos().getValue(), form.cmbStatus().getValue());
		updateControlsState();
		
		form.getGlobalContext().SpinalInjuries.setMedConcernOnAdmisSearchCriteria(getSearchCriteria()); //WDEV-19389 
	}

	protected void onCustomControlMosValueChanged() throws PresentationLogicException 
	{
		listPatientConcerns(form.customControlMos().getValue(), form.cmbStatus().getValue());
		updateControlsState();
		form.getGlobalContext().SpinalInjuries.setMedConcernOnAdmisSearchCriteria(getSearchCriteria());//WDEV-19389 
	}

	
	protected void onBtnNewClick() throws PresentationLogicException
	{
		newConcern();
	}

	
	protected void onBtnUpdateClick() throws PresentationLogicException 
	{
		updateConcern();
	}	
	private void updateControlsState()
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.btnNew().setVisible(true);
			
			form.btnUpdate().setVisible(form.grdConcernList().getReadOnly() && form.grdConcernList().getSelectedRowIndex() != - 1);
			
		}
		
		updateContextMenu();	//WDEV-7044
	}
}
