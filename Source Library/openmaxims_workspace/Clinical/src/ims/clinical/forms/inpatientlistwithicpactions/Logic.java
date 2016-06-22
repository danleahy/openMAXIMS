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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3397.19184)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.inpatientlistwithicpactions;

import com.sun.org.apache.xpath.internal.operations.Bool;

import ims.clinical.forms.inpatientlistwithicpactions.GenForm.grdInpatientsWithICPSRow;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.IPandOPSearchCriteriaVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.icp.vo.InpatientEpisodeWithICPInfoVo;
import ims.icp.vo.InpatientEpisodeWithICPInfoVoCollection;
import ims.vo.interfaces.IMos;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	}

	private void open()
	{
		if (form.getGlobalContext().Core.getUKSHInPatientWardViewSearchCriteriaIsNotNull())
			refreshSearchCriteria();
	}
	
	private void initialise() 
	{
		form.ccHCP().initialize(MosType.HCP);
		if(Boolean.TRUE.equals(ConfigFlag.UI.DEFAULT_CONSULTANT_AND_WARD_ON_INPATIENT_ICP_FORM.getValue())) //wdev-13775
		{
			if (domain.getHcpUser() != null)
				form.ccHCP().setValue((IMos)domain.getHcpUser());
		}
		
		PatIdType dispIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()); 
		form.grdInpatientsWithICPS().setcolHospnumCaption(dispIdType.getText());
		
		loadHospitals();
		
		if (form.cmbHospital().getValue() == null && engine.getCurrentLocation() != null)
		{
			//Try and load the logged in location as a ward
			LocMostVo voLoc = domain.getLocation((LocationRefVo)engine.getCurrentLocation());
			if (voLoc != null && voLoc.getTypeIsNotNull()
				&& voLoc.getType().equals(LocationType.WARD))
			{
				form.cmbHospital().setValue(voLoc.getParentLocation());
	
				loadWards();
			}
		}
	}

	private void refreshSearchCriteria() 
	{
		IPandOPSearchCriteriaVo voCriteria = form.getGlobalContext().Core.getUKSHInPatientWardViewSearchCriteria();
		
		form.cmbHospital().setValue((LocationLiteVo) voCriteria.getHospital());
		if(form.cmbHospital().getValue() != null)
			loadWards();
		else
			form.cmbWard().clear();	//wdev-12482
		
		form.cmbWard().setValue((LocationLiteVo) voCriteria.getWard());
		form.ccHCP().setValue((IMos)voCriteria.getConsultant());

		search();
	}

	private void loadHospitals() 
	{
		LocationLiteVoCollection hospitals = domain.getActiveHospitals();
		if (hospitals!=null)
		{
			for (LocationLiteVo item: hospitals)
			{
				form.cmbHospital().newRow(item, item.getName());
				
				if(engine.getCurrentLocation() != null)
				{
					if (engine.getCurrentLocation().getID() == item.getID_Location().intValue())
					{
						form.cmbHospital().setValue(item);
						
						loadWards();
					}
				}
				else
				{
					if (hospitals.size() == 1)
						form.cmbHospital().setValue(item);	
				}
			}
		}
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		
		form.grdInpatientsWithICPS().getRows().clear();
		form.cmbHospital().setValue(null);
		form.cmbWard().setValue(null);
		form.cmbWard().clear();
		form.ccHCP().clear();

		form.getGlobalContext().Core.setUKSHInPatientWardViewSearchCriteria(null);
		form.getContextMenus().Clinical.hideAllIpWardListMenuMenuItems();
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}
	
	private void search() 
	{
		IPandOPSearchCriteriaVo filterVo = new IPandOPSearchCriteriaVo();
		
		filterVo = populateSearchFilter(filterVo);
		if (filterVo ==null)
			return;
		
		form.getGlobalContext().Core.setUKSHInPatientWardViewSearchCriteria(filterVo);

		form.grdInpatientsWithICPS().getRows().clear();
		form.getContextMenus().Clinical.hideAllIpWardListMenuMenuItems();

		InpatientEpisodeWithICPInfoVoCollection list = domain.listIPEpisodes(filterVo);
		if (list == null || list.size() == 0)
		{
			engine.showMessage("No records match your search criteria.", "No data found", MessageButtons.OK, MessageIcon.WARNING);
			return;
		}

		for (int i = 0 ; list != null && i < list.size() ; i++)
		{
			grdInpatientsWithICPSRow row = form.grdInpatientsWithICPS().getRows().newRow();

			row.setcolICP(list.get(i).getICPInfoIsNotNull() ? form.getImages().ICP.ICP : null);
			if (list.get(i).getPasEvent().getPatient().getDisplayId() != null) 
				row.setcolHospnum(list.get(i).getPasEvent().getPatient().getDisplayId().getValue());
			StringBuffer nameText = new StringBuffer();
			if(list.get(i).getPasEvent().getPatient().getNameIsNotNull()){
				nameText.append(list.get(i).getPasEvent().getPatient().getName().getSurname());
				if(list.get(i).getPasEvent().getPatient().getName().getForenameIsNotNull()){
					nameText.append(", "); 
					nameText.append(list.get(i).getPasEvent().getPatient().getName().getForename());
				}
			}
			row.setcolName(nameText.toString());
			row.setcolSex(list.get(i).getPasEvent().getPatient().getSexIsNotNull() ? list.get(i).getPasEvent().getPatient().getSex().toString() : "");
			row.setcolDob(list.get(i).getPasEvent().getPatient().getDobIsNotNull() ? list.get(i).getPasEvent().getPatient().getDob().toString() : "");
			if(list.get(i).getPasEventIsNotNull() && list.get(i).getPasEvent().getLocationIsNotNull() && list.get(i).getPasEvent().getLocation().getNameIsNotNull())
				row.setcolWard(list.get(i).getPasEvent().getLocation().getName().toString());
			else
				row.setcolWard("");
			row.setcolBedNUmber(list.get(i).getBedNumberIsNotNull() ? list.get(i).getBedNumber().toString(): "");
			row.setcolConsultant(list.get(i).getPasEvent().getConsultantIsNotNull() ? list.get(i).getPasEvent().getConsultant().getName().toString() : "");
			row.setcolAdmissionDate(list.get(i).getAdmissionDateTimeIsNotNull() ? list.get(i).getAdmissionDateTime().getDate() : null);
			
			if (list.get(i).getICPInfoIsNotNull())
			{
				if(list.get(i).getICPInfo().getHasOutstandingNursingActionsIsNotNull() 
				&& list.get(i).getICPInfo().getHasOutstandingNursingActions())
				{
					row.setcolNurseAction(form.getImages().Admin.Nurse24);
					row.setTooltipForcolNurseAction("Nursing Action Required for ICP : " + (list.get(i).getICPInfo().getICPIsNotNull() ? list.get(i).getICPInfo().getICP().getName().toString() : ""));
				}
				else
					row.setcolNurseAction(null);
			
				if (list.get(i).getICPInfo().getHasOutstandingClinicalActionsIsNotNull() 
					&& list.get(i).getICPInfo().getHasOutstandingClinicalActions())
				{
					row.setcolDoctorAction(form.getImages().Admin.Stethoscope24);
					row.setTooltipForcolDoctorAction("Medical Action Required for ICP : " + (list.get(i).getICPInfo().getICPIsNotNull() ? list.get(i).getICPInfo().getICP().getName().toString() : ""));
				}
				else
					row.setcolDoctorAction(null);

				if (list.get(i).getICPInfo().getHasOutstandingPhysioActionsIsNotNull() 
					&& list.get(i).getICPInfo().getHasOutstandingPhysioActions())
				{
					row.setcolPhysioAction(form.getImages().Admin.Doctor24);
					row.setTooltipForcolPhysioAction("Physio Action Required for ICP : " + (list.get(i).getICPInfo().getICPIsNotNull() ? list.get(i).getICPInfo().getICP().getName().toString() : ""));
				}
				else
					row.setcolPhysioAction(null);

				if(list.get(i).getICPInfo().getHasOutstandingAdminActionsIsNotNull()
					&& list.get(i).getICPInfo().getHasOutstandingAdminActions())
				{
					row.setcolAdminAction(form.getImages().Admin.AdminAction24);
					row.setTooltipForcolAdminAction("Admin Action Required for ICP : " + (list.get(i).getICPInfo().getICPIsNotNull() ? list.get(i).getICPInfo().getICP().getName().toString() : ""));
				}
				else
					row.setcolAdminAction(null);
			}

			row.setValue(list.get(i));
		}
	}

	private IPandOPSearchCriteriaVo populateSearchFilter(IPandOPSearchCriteriaVo filterVo) 
	{
		if (form.cmbHospital().getValue() != null)
			filterVo.setHospital(form.cmbHospital().getValue());

		if (form.cmbWard().getValue() != null)
			filterVo.setWard(form.cmbWard().getValue());

		if (form.ccHCP().getValue() != null)
			filterVo.setConsultant((IMos)form.ccHCP().getValue());
		
		return filterVo;
	}
	
	//WDEV-22353
	private Boolean isNotMosUser(String message)
	{
		Object mos = domain.getMosUser();
		if (mos == null)
		{
			engine.showMessage(message, "Not Allowed", MessageButtons.OK, MessageIcon.WARNING);
			return true;
		}
		return false;
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.ClinicalNamespace.IpWardListMenu.EditViewICPActions:
				form.getGlobalContext().ICP.setPatientICPRecord(form.grdInpatientsWithICPS().getValue().getICPInfo());
				engine.open(form.getForms().ICP.PatientICP);
			break;
			
			case GenForm.ContextMenus.ClinicalNamespace.IpWardListMenu.EditBedNumber:
				form.getGlobalContext().RefMan.setBedNumber(form.grdInpatientsWithICPS().getValue().getBedNumber());
				engine.open(form.getForms().Clinical.InpatientBedNumberDialog);
			break;
			
			case GenForm.ContextMenus.ClinicalNamespace.IpWardListMenu.DISCHARGE:
				//WDEV-22353
				if(!isNotMosUser("Logged in user is not associated with a Member of Staff. Discharge cannot continue."))
				{
					if (form.grdInpatientsWithICPS().getValue().getICPInfoIsNotNull())
					{
						form.getGlobalContext().Core.setCurrentCareContext(domain.getCareContext(form.grdInpatientsWithICPS().getValue().getICPInfo().getCareContext()));
					}
					form.getGlobalContext().RefMan.setCatsReferral(domain.getCatsReferralRef(form.grdInpatientsWithICPS().getValue()));
					engine.open(form.getForms().RefMan.DischargeSummaryWardPacuDialogAlias);
				}
			break;
				
			case GenForm.ContextMenus.ClinicalNamespace.IpWardListMenu.TRANSFER:
				//WDEV-22353
				if(!isNotMosUser("Logged in user is not associated with a Member of Staff. Transfer cannot continue."))
				{
					if (form.grdInpatientsWithICPS().getValue() != null)
					{
						engine.open(form.getForms().Core.InpatientTransferDialog, new Object[]{ form.grdInpatientsWithICPS().getValue()});
					}
				}
			break;
				
			default:
		}
		
	}

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException 
	{
		if (form.cmbHospital().getValue() != null)
			loadWards();
		else
			form.cmbWard().clear();//wdev7640
	}

	private void loadWards() 
	{
		if (form.cmbHospital().getValue() == null)
			return;
		
		form.cmbWard().clear();
		LocationLiteVoCollection listWards = domain.listWards(form.cmbHospital().getValue().getID_Location());
		if (listWards!=null)
		{
			for (LocationLiteVo item: listWards)
			{
				form.cmbWard().newRow(item, item.getName());
				
				if(Boolean.TRUE.equals(ConfigFlag.UI.DEFAULT_CONSULTANT_AND_WARD_ON_INPATIENT_ICP_FORM.getValue())) //wdev-13775
				{
					if(engine.getCurrentLocation() != null)
					{
						if (engine.getCurrentLocation().getID() == item.getID_Location().intValue())
							form.cmbWard().setValue(item);
					}
				}
			}
		}

	}

	@Override
	protected void onGrdIPGridButtonClicked(int column, grdInpatientsWithICPSRow row) throws PresentationLogicException 
	{
		//engine.open(form.getForms().RefMan.ICPActions);
	}

	@Override
	protected void onGrdIPSelectionChanged() throws PresentationLogicException 
	{
		form.getContextMenus().Clinical.hideAllIpWardListMenuMenuItems();
		
		form.getContextMenus().Clinical.getIpWardListMenuEditBedNumberItem().setVisible(true);
		form.getContextMenus().Clinical.getIpWardListMenuEditBedNumberItem().setEnabled(true);
		
		if(form.grdInpatientsWithICPS().getValue() != null 
			&& form.grdInpatientsWithICPS().getSelectedRow().getValue().getICPInfoIsNotNull()
			&& form.grdInpatientsWithICPS().getSelectedRow().getValue().getICPInfo().getID_PatientICPIsNotNull())
		{
			form.getContextMenus().Clinical.getIpWardListMenuEditViewICPActionsItem().setVisible(true);
			form.getContextMenus().Clinical.getIpWardListMenuEditViewICPActionsItem().setEnabled(true);
		}
		
		if (form.grdInpatientsWithICPS().getSelectedRow() != null
			&& form.grdInpatientsWithICPS().getSelectedRow().getValue() != null
			&& form.grdInpatientsWithICPS().getSelectedRow().getValue().getPasEventIsNotNull()
			&& form.grdInpatientsWithICPS().getSelectedRow().getValue().getPasEvent().getPatientIsNotNull())
			form.getGlobalContext().Core.setPatientShort(domain.getPatientShort(form.grdInpatientsWithICPS().getSelectedRow().getValue().getPasEvent().getPatient()));

		
		
		
		updateControlsState();
	}

	private void updateControlsState()
	{
		updateContextMenuState();
	}

	private void updateContextMenuState()
	{
		form.getContextMenus().Clinical.getIpWardListMenuTRANSFERItem().setVisible(form.grdInpatientsWithICPS().getValue() != null);
		// Activate only when the inpatient episode has an care context associated
		form.getContextMenus().Clinical.getIpWardListMenuDISCHARGEItem().setVisible(form.grdInpatientsWithICPS().getValue() != null && form.grdInpatientsWithICPS().getValue().getCareContextIsNotNull());
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Clinical.InpatientBedNumberDialog) && result.equals(DialogResult.OK))
		{
			saveNewBedNumber(form.getGlobalContext().RefMan.getBedNumber());
		}
		// WDEV-11648
		else if(formName.equals(form.getForms().Clinical.InpatientBedNumberDialog) && result.equals(DialogResult.CANCEL))
		{
			open();
		}
		else if (formName.equals(form.getForms().RefMan.DischargeSummaryWardPacuDialogAlias))
		{
			open();
		}
		else if(formName.equals(form.getForms().Core.InpatientTransferDialog) && result.equals(DialogResult.OK))
		{
			open();
		}
	}

	private void saveNewBedNumber(String bedNumber) 
	{
		InpatientEpisodeVo voIP = domain.getInpatientEpisode(form.grdInpatientsWithICPS().getValue().toInpatientEpisodeRefVo());
		
		if (voIP == null)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			search();
			return;
		}
		
		InpatientEpisodeWithICPInfoVo inpatientWithICP = form.grdInpatientsWithICPS().getValue();
		
		if (bedNumber != null)
		{
			inpatientWithICP.setBedNumber(bedNumber);
			
			String[] errors = inpatientWithICP.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}

			try 
			{
				voIP = domain.saveInpatientBedNumber(inpatientWithICP);
			}
			catch (StaleObjectException e) 
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				search();
				return;
			}
			
			search();
		}
	}
}
