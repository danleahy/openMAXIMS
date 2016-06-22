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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3909.24643)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.oncology.forms.internalreferralcomponent;

import ims.core.vo.EpisodeOfCareForInternalReferralVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.oncology.forms.internalreferralcomponent.GenForm.GroupStatusEnumeration;
import ims.oncology.vo.InternalReferralOutcomeVo;
import ims.oncology.vo.InternalReferralRefVo;
import ims.oncology.vo.InternalReferralVo;
import ims.oncology.vo.lookups.InternalReferralTypeAndReason;
import ims.oncology.vo.lookups.InternalReferralTypeAndReasonCollection;
import ims.oncology.vo.lookups.LookupHelper;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);	
		form.getGlobalContext().Clinical.PatientSummary.setEpisodeOfCare(null);
		form.getLocalContext().setShowRemove(Boolean.FALSE);
		form.chkRemove().setVisible(Boolean.FALSE);
	}

	private DynamicGridColumn getCol(String identifier) 
	{
		return form.dyngrdReasons().getColumns().getByIdentifier(identifier);
	}
	
	private void populateInstanceControls(InternalReferralVo voInternalReferral) 
	{
		clearInstanceControls();
		
		if(voInternalReferral != null)
		{
			form.dteReferral().setValue(voInternalReferral.getReferralDate());
			form.cmbReferralType().setValue(voInternalReferral.getReferralType());
			form.cmbReferralSource().setValue(voInternalReferral.getReferralSource());
			form.ccReferredBy().setValue(voInternalReferral.getReferredBy());
			form.txtReferredBy().setValue(voInternalReferral.getReferredByIsNotNull() ? voInternalReferral.getReferredBy().getName().toString() :"");
			form.txtCurrentReason().setValue(voInternalReferral.getDiagnosisText());
			
			form.dteEpisodeOfCareStart().setValue(voInternalReferral.getEpisodeOfCareIsNotNull() ? voInternalReferral.getEpisodeOfCare().getStartDate() : null);			
			form.dtePlannedDisch().setValue(voInternalReferral.getPlannedDischargeDate());
			form.dteTreatmentStartDate().setValue(voInternalReferral.getTreatmentStartDate());
			form.dteTreatmentEnd().setValue(voInternalReferral.getTreatmentEndDate());
			form.txtComments().setValue(voInternalReferral.getComments());
			form.dyngrdReasons().getRows().clear();

			for (int i = 0 ;  voInternalReferral.getReferralReasonIsNotNull() && i < voInternalReferral.getReferralReason().size() ; i ++)
			{
				DynamicGridRow row = form.dyngrdReasons().getRows().newRow();

				DynamicGridCell reasonCell = row.getCells().newCell(getCol("REASON"), DynamicCellType.ENUMERATION);
				loadReasonCombo(reasonCell);
				reasonCell.setValue(voInternalReferral.getReferralReason().get(i));
				if (reasonCell.getValue() == null && voInternalReferral.getReferralReason().get(i) != null && !voInternalReferral.getReferralReason().get(i).isActive())
				{
					reasonCell.getItems().newItem(voInternalReferral.getReferralReason().get(i));
					reasonCell.setValue(voInternalReferral.getReferralReason().get(i));
				}
				
				row.setValue(voInternalReferral.getReferralReason().get(i));
			}
			form.GroupStatus().setValue(voInternalReferral.getStatusIsNotNull() && voInternalReferral.getStatus().equals(PreActiveActiveInactiveStatus.ACTIVE) ? GroupStatusEnumeration.rdoActive : GroupStatusEnumeration.rdoInactive);

			form.cmbOutcome().setValue(voInternalReferral.getInternalReferralOutcomeIsNotNull() ? voInternalReferral.getInternalReferralOutcome().getReferralOutcome() : null);
			form.dteOutcomeDate().setValue(voInternalReferral.getInternalReferralOutcomeIsNotNull() ? voInternalReferral.getInternalReferralOutcome().getReferralOutcomeDate() : null);
			form.txtOutcomeNotes().setValue(voInternalReferral.getInternalReferralOutcomeIsNotNull() ? voInternalReferral.getInternalReferralOutcome().getReferralOutcomeNotes() : null);
			form.chkRemove().setValue(voInternalReferral.getReferralSeenIsNotNull() ? voInternalReferral.getReferralSeen() : null);
			if (voInternalReferral.getReferralSeenIsNotNull()
				&& voInternalReferral.getReferralSeen())
				form.chkRemove().setVisible(Boolean.TRUE);
		}
	}
	
	private void clearInstanceControls() 
	{
		form.dteReferral().setValue(null);
		form.cmbReferralType().setValue(null);
		form.cmbReferralSource().setValue(null);
		form.ccReferredBy().setValue(null);
		form.txtReferredBy().setValue(null);
		form.txtCurrentReason().setValue(null);
		form.dteEpisodeOfCareStart().setValue(null);
		form.dtePlannedDisch().setValue(null);
		form.dteTreatmentStartDate().setValue(null);
		form.dteTreatmentEnd().setValue(null);
		form.txtComments().setValue(null);
		form.dyngrdReasons().getRows().clear();
		form.GroupStatus().setValue(GroupStatusEnumeration.None);
		form.cmbOutcome().setValue(null);
		form.dteOutcomeDate().setValue(null);
		form.txtOutcomeNotes().setValue(null);
		form.chkRemove().setValue(null);
	}

	private void initialise()
	{
		form.setMode(FormMode.VIEW);
		form.ccReferredBy().initialize(MosType.HCP);
		form.ccReferredBy().isRequired(Boolean.TRUE);
		initializeDynamicGrid();
		loadReferralTypeCombo();
	}


	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			clearInstanceControls();
			form.setMode(FormMode.VIEW);
			form.chkRemove().setEnabled(Boolean.FALSE);
			form.getGlobalContext().RefMan.setIsComponentInEditMode(FormMode.VIEW);
			form.fireCustomControlValueChanged();
			populateInstanceControls(form.getLocalContext().getSelectedRecord());
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		form.chkRemove().setEnabled(Boolean.FALSE);
		InternalReferralVo voInternalReferral = form.getLocalContext().getSelectedRecord();
		if(voInternalReferral!=null && voInternalReferral.getID_InternalReferralIsNotNull())
			form.getLocalContext().setSelectedRecord(domain.getInternalReferral(voInternalReferral));
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		form.getGlobalContext().RefMan.setIsComponentInEditMode(FormMode.VIEW);
		form.fireCustomControlValueChanged();
	
	}

	private boolean save() 
	{
		InternalReferralVo voInternalReferral = populateInstanceData();
		
		if (form.getLocalContext().getChosenEpisodeOfCareIsNotNull())
		{
			EpisodeOfCareForInternalReferralVo voTemp = new EpisodeOfCareForInternalReferralVo();
			voTemp.setID_EpisodeOfCare(form.getLocalContext().getChosenEpisodeOfCare().getID_EpisodeOfCare());
			voInternalReferral.setEpisodeOfCare(voTemp);
		}
				
		String[] arrErrors = validateUIRules();
		arrErrors = voInternalReferral.validate(arrErrors);
		if (arrErrors != null)
		{	
			engine.showErrors(arrErrors);
			return false;
		}
		
		try
		{
			form.getLocalContext().setSelectedRecord(domain.saveInternalReferral(voInternalReferral));
		}
		catch(StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateInstanceControls(domain.getInternalReferral(voInternalReferral));
			return false;
		} 
		catch (DomainInterfaceException e)
		{
			engine.showErrors(new String[]{e.getMessage()});
			return false;
		}
		
		form.getGlobalContext().Oncology.setInternalReferralRef(form.getLocalContext().getSelectedRecord());
		return true;
	}

	private String[] validateUIRules() 
	{
		ArrayList screenErrors = new ArrayList();
		
		if(form.dteReferral().getValue() != null && form.dteReferral().getValue().isGreaterThan(new Date()))
			screenErrors.add("Referral Date cannot be in the future.");
		
		if(form.dteOutcomeDate().getValue() != null && form.dteOutcomeDate().getValue().isGreaterThan(new Date()))
			screenErrors.add("Outcome Date cannot be in the future.");
		
		if(form.dyngrdReasons().getRows().size() == 0)
			screenErrors.add("Please enter a Reason for Referral record.");
		else
		{
			boolean bValid = true;
			for (int i = 0 ; i < form.dyngrdReasons().getRows().size() ; i ++)
			{
				if (form.dyngrdReasons().getRows().get(i).getCells().get(getCol("REASON")).getValue() == null)
					bValid = false;			
			}
			if (! bValid)
				screenErrors.add("Please enter a valid Reason for Referral record in all grid rows");
		}

		if(form.dteEpisodeOfCareStart().getValue() == null)
			screenErrors.add("Please enter a Current Episode of Care Start Date.");
		
		//WDEV-13181 
		if(form.dteTreatmentStartDate().getValue() != null
			&& form.dteTreatmentEnd().getValue() != null
			&& form.dteTreatmentStartDate().getValue().isGreaterThan(form.dteTreatmentEnd().getValue()))
			screenErrors.add("Treatment Start Date cannot be greater than Treatment End Date");

		if (form.chkRemove().isVisible()
			&& form.chkRemove().getValue()
			&& form.cmbOutcome().getValue() == null)
			screenErrors.add("An Outcome value is needed before this Referral can be removed.");
		
		if ((form.dteOutcomeDate().getValue() == null) &&  form.dteOutcomeDate().isEnabled())//wdev-14325
		{
			screenErrors.add("Date is mandatory.");
		}
			
		int errorCount = screenErrors.size();
		if(errorCount == 0)
		{
			return null;
		}
		String[] result = new String[errorCount];
		screenErrors.toArray(result);
		
		return result;
	}
	
	private InternalReferralVo populateInstanceData() 
	{
		InternalReferralVo voInternalReferral = form.getLocalContext().getSelectedRecord();
		
		if(voInternalReferral == null)
			voInternalReferral = new InternalReferralVo();

		voInternalReferral.setPatient(form.getGlobalContext().Core.getPatientShort());
		voInternalReferral.setReferralDate(form.dteReferral().getValue());
		voInternalReferral.setReferralType(form.cmbReferralType().getValue());
		voInternalReferral.setReferralSource(form.cmbReferralSource().getValue());
		voInternalReferral.setReferredBy((HcpLiteVo) form.ccReferredBy().getValue());
		voInternalReferral.setDiagnosisText(form.txtCurrentReason().getValue());
		
		voInternalReferral.setPlannedDischargeDate(form.dtePlannedDisch().getValue());
		voInternalReferral.setTreatmentStartDate(form.dteTreatmentStartDate().getValue());
		voInternalReferral.setTreatmentEndDate(form.dteTreatmentEnd().getValue());
		voInternalReferral.setComments(form.txtComments().getValue());
		
		voInternalReferral.setReferralReason(new InternalReferralTypeAndReasonCollection());
		for (int i = 0 ; i < form.dyngrdReasons().getRows().size() ; i ++)
		{
			if (form.dyngrdReasons().getRows().get(i).getCells().get(getCol("REASON")).getValue() != null)
				voInternalReferral.getReferralReason().add((InternalReferralTypeAndReason)form.dyngrdReasons().getRows().get(i).getCells().get(getCol("REASON")).getValue());
		}

		voInternalReferral.setStatus(form.GroupStatus().getValue().equals(GroupStatusEnumeration.rdoActive) ? PreActiveActiveInactiveStatus.ACTIVE : PreActiveActiveInactiveStatus.INACTIVE);

		if (form.cmbOutcome().getValue() != null
			|| form.dteOutcomeDate().getValue() != null
			|| form.txtOutcomeNotes().getValue() != null)
		{
			if (voInternalReferral.getInternalReferralOutcome() == null)
				voInternalReferral.setInternalReferralOutcome(new InternalReferralOutcomeVo());
			
			voInternalReferral.getInternalReferralOutcome().setReferralOutcome(form.cmbOutcome().getValue());
			voInternalReferral.getInternalReferralOutcome().setReferralOutcomeDate(form.dteOutcomeDate().getValue());
			voInternalReferral.getInternalReferralOutcome().setReferralOutcomeNotes(form.txtOutcomeNotes().getValue());
		}
		
		voInternalReferral.setReferralSeen(form.chkRemove().getValue());
			
		if (form.getGlobalContext().Clinical.PatientSummary.getEpisodeOfCareIsNotNull())
		{
			EpisodeOfCareForInternalReferralVo voRef = new EpisodeOfCareForInternalReferralVo();
			voRef.setID_EpisodeOfCare(form.getGlobalContext().Clinical.PatientSummary.getEpisodeOfCare().getID_EpisodeOfCare());
			voInternalReferral.setEpisodeOfCare(voRef);
		}
		
		return voInternalReferral;
	}

	private void newInstance() 
	{
		clearInstanceControls();
		
		//form.getLocalContext().setSelectedRecord(new InternalReferralVo()); //WDEV-14356
		
		form.setMode(FormMode.EDIT);
		enableMainControls(Boolean.TRUE);
		if (domain.getHcpLiteUser() != null)
			form.ccReferredBy().setValue((HcpLiteVo)domain.getHcpLiteUser());
		
		form.GroupStatus().setValue(GroupStatusEnumeration.rdoActive);
		form.chkRemove().setVisible(Boolean.FALSE);
	}
	

	private void updateInstance() 
	{
		if (form.getLocalContext().getSelectedRecordIsNotNull())
			form.setMode(FormMode.EDIT);
		
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
		
		if (form.getLocalContext().getShowRemoveIsNotNull()
			&& form.getLocalContext().getShowRemove())
		{
			enableMainControls(Boolean.FALSE);
			enableOutcomeControls();
		}
		else
			enableMainControls(Boolean.TRUE);
			
	}

	private void enableMainControls(Boolean bEnable) 
	{
		if (form.getMode().equals(FormMode.VIEW))
			return;
		
		form.dteReferral().setEnabled(bEnable);
		form.cmbReferralType().setEnabled(bEnable);
		form.cmbReferralSource().setEnabled(bEnable);
		form.ccReferredBy().setEnabled(bEnable);
		form.txtCurrentReason().setEnabled(bEnable);//WDEV-13181 
		form.btnCareSpell().setEnabled(bEnable);
		form.btnCareSpell().setVisible(bEnable);
		form.dtePlannedDisch().setEnabled(bEnable);
		form.dteTreatmentStartDate().setEnabled(bEnable);
		form.dteTreatmentEnd().setEnabled(bEnable);
		form.txtComments().setEnabled(bEnable);
		if (bEnable)
			form.dyngrdReasons().setEnabled(bEnable);
		else	
			form.dyngrdReasons().setEnabled(bEnable);//WDEV-14439
			//form.dyngrdReasons().setReadOnly(Boolean.TRUE); //WDEV-14439
		
		form.GroupStatus().setEnabled(bEnable);
		form.txtEpisodeStartDate().setEnabled(bEnable);//WDEV-14357 
		form.txtReferralReason().setEnabled(bEnable);//WDEV-14357 
	}

	private void enableOutcomeControls()
	{
		form.cmbOutcome().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.dteOutcomeDate().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.txtOutcomeNotes().setEnabled(form.getMode().equals(FormMode.EDIT));
		form.chkRemove().setVisible(form.getLocalContext().getShowRemoveIsNotNull() 
				&& form.getLocalContext().getShowRemove());
		form.chkRemove().setEnabled(form.getMode().equals(FormMode.EDIT));
	}

	public void initialise(InternalReferralVo voInternalReferral, Boolean bEditMode, Boolean bShowRemove) 
	{
		form.getLocalContext().setShowRemove(bShowRemove);
		form.chkRemove().setVisible(form.getLocalContext().getShowRemove());
		form.getLocalContext().setSelectedRecord(null);
		if (voInternalReferral != null)
			form.getLocalContext().setSelectedRecord(domain.getInternalReferral(voInternalReferral));
		//WDEV-14356
		else
			form.getLocalContext().setSelectedRecord(null);
		
		initialiseComponent(bEditMode);
	}

	private void initialiseComponent(Boolean bEditMode)
	{
		initialise();
		clearInstanceControls();
		form.setMode(FormMode.VIEW);
		form.getGlobalContext().RefMan.setIsComponentInEditMode(null);
		
		if (form.getLocalContext().getSelectedRecord() == null && bEditMode)
			newInstance();
		else if (form.getLocalContext().getSelectedRecordIsNotNull() && bEditMode)
			updateInstance();
		else if (form.getLocalContext().getSelectedRecordIsNotNull() && ! bEditMode)
			viewInstance();
		
		if (form.getLocalContext().getSelectedRecordIsNotNull()
			&& form.getLocalContext().getSelectedRecord().getStatusIsNotNull()
			&& form.getLocalContext().getSelectedRecord().getStatus().equals(PreActiveActiveInactiveStatus.INACTIVE)
			&& form.getLocalContext().getShowRemoveIsNotNull()
			&& form.getLocalContext().getShowRemove())
			form.chkRemove().setVisible(Boolean.FALSE);
	}

	private void viewInstance() 
	{
		form.chkRemove().setVisible(Boolean.FALSE);
		form.chkRemove().setEnabled(Boolean.FALSE);
		populateInstanceControls(form.getLocalContext().getSelectedRecord());
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.OncologyNamespace.InternalReferralsReasons.NEW :
				newRow();
			break;			
			case GenForm.ContextMenus.OncologyNamespace.InternalReferralsReasons.REMOVE:
				form.dyngrdReasons().getRows().remove(form.dyngrdReasons().getSelectedRow());
			break;			
			default :
			break;
		}
		
		updateContextMenu(); //WDEV-13181 
	}

	private void newRow() 
	{
		DynamicGridRow row = form.dyngrdReasons().getRows().newRow();
		DynamicGridColumn coll = form.dyngrdReasons().getColumns().getByIdentifier("REASON");
		
		DynamicGridCell cell = row.getCells().newCell(coll, DynamicCellType.ENUMERATION);
		loadReasonCombo(cell);
		cell.setWidth(-1);
//		cell.setValue(note != null ? (note.getFollowUpTypeIsNotNull() ? note.getFollowUpType() : null)  : null);		
		cell.setReadOnly(false);		
		
	}
	private void loadReasonCombo(DynamicGridCell cell) 
	{
		cell.getItems().clear();		

		InternalReferralTypeAndReason reasonParent = form.cmbReferralType().getValue();
		if (reasonParent != null)
		{
			InternalReferralTypeAndReasonCollection coll = LookupHelper.getInternalReferralTypeAndReason(domain.getLookupService());
			InternalReferralTypeAndReason statReason;
			for (int i = 0; coll != null && i < coll.size(); i++)
			{
				statReason = coll.get(i);
				if (statReason.getParent() != null && statReason.getParent().equals(reasonParent))
					cell.getItems().newItem(statReason);
			}
		}

	}

	@Override
	protected void onFormModeChanged() 
	{
		updateContextMenu();
	}

	private void updateContextMenu() 
	{
		form.getContextMenus().Oncology.hideAllInternalReferralsReasonsMenuItems();
		
	//	//if user is a therapist then return, and leave menu options hidden.
	//	MemberOfStaffShortVo voMos = (MemberOfStaffShortVo)domain.getMosUser();
	//	if (voMos != null
	//		&& voMos.getHcpIsNotNull()
	//		&& voMos.getHcp().getHcpTypeIsNotNull()
	//		&& voMos.getHcp().getHcpType().equals(HcpDisType.THERAPY))
	//		return;

		form.getContextMenus().Oncology.getInternalReferralsReasonsNEWItem().setVisible(form.getMode().equals(FormMode.EDIT) && form.cmbReferralType().getValue() != null);
		form.getContextMenus().Oncology.getInternalReferralsReasonsNEWItem().setEnabled(form.getMode().equals(FormMode.EDIT) && form.cmbReferralType().getValue() != null);

		form.getContextMenus().Oncology.getInternalReferralsReasonsREMOVEItem().setVisible(form.dyngrdReasons().getSelectedRow() != null && form.getMode().equals(FormMode.EDIT));
		form.getContextMenus().Oncology.getInternalReferralsReasonsREMOVEItem().setEnabled(form.dyngrdReasons().getSelectedRow() != null && form.getMode().equals(FormMode.EDIT));
	
	}

	private void loadReferralTypeCombo()
	{
		InternalReferralTypeAndReasonCollection coll = LookupHelper.getInternalReferralTypeAndReason(domain.getLookupService());

		form.cmbReferralType().clear();

		for (int i = 0; i < coll.size(); i++)
		{
			if (coll.get(i).getParent() == null && coll.get(i) .isActive())
				form.cmbReferralType().newRow(coll.get(i), coll.get(i).getText(), coll.get(i).getImage(), coll.get(i).getTextColor());
		}
	}
	
	private void initializeDynamicGrid()
	{
		form.dyngrdReasons().clear();
		form.dyngrdReasons().setSelectable(true);
		
		DynamicGridColumn reasonColumn = null;
		reasonColumn = form.dyngrdReasons().getColumns().newColumn(" ", false);				
		reasonColumn.setIdentifier("REASON");
		reasonColumn.setWidth(-1);
		reasonColumn.setSortMode(SortMode.AUTOMATIC);
	}

	public void clearComponent() 
	{
		clearInstanceControls();
		form.getLocalContext().setSelectedRecord(null);
	}

	public void initialise(InternalReferralRefVo voInternalReferral, Boolean bEditMode, Boolean bShowRemove) 
	{
		form.getLocalContext().setShowRemove(bShowRemove);
		form.chkRemove().setVisible(form.getLocalContext().getShowRemove());

		form.getLocalContext().setSelectedRecord(null);
		if (voInternalReferral != null)
			form.getLocalContext().setSelectedRecord(domain.getInternalReferral(voInternalReferral));
		
		initialiseComponent(bEditMode);
	}

	@Override
	protected void onBtnCareSpellClick() throws PresentationLogicException 
	{
		engine.open(form.getForms().Oncology.InternalReferralCareSpellSelectionDialog);
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (formName.equals(form.getForms().Oncology.InternalReferralCareSpellSelectionDialog)
			&& result.equals(DialogResult.OK))
		{
			form.dteEpisodeOfCareStart().setValue(form.getGlobalContext().Oncology.getEpisodeOfCareDate());
			form.getLocalContext().setChosenEpisodeOfCare(form.getGlobalContext().Clinical.PatientSummary.getEpisodeOfCare());
		}
	}

	@Override
	protected void onBtnPrintClick() throws PresentationLogicException 
	{
		form.getGlobalContext().Core.setPrepareForPrinting(Boolean.FALSE);		//wdev-18705
		engine.open(form.getForms().Core.PrintReport);		
	}

	@Override
	protected void onCmbReferralTypeValueChanged() throws PresentationLogicException
	{
		if (form.dyngrdReasons().getRows().size() > 0)
			form.dyngrdReasons().getRows().clear();
		
		updateContextMenu();
	}

	@Override
	protected void onDyngrdReasonsRowSelectionChanged(DynamicGridRow row) throws PresentationLogicException 
	{
		form.getGlobalContext().RefMan.setIsComponentInEditMode(null);
		if (form.getMode().equals(FormMode.EDIT))
		{
	//		loadReasonCombo(form.dyngrdReasons().getSelectedRow(), (InternalReferralTypeAndReason)form.dyngrdReasons().getSelectedRow().getColReason().getValue());
			updateContextMenu();
		}
	}

	//WDEV-13181 
	public void enablePrintButton(Boolean enable) {
		if (form.getMode().equals(FormMode.VIEW))
			form.btnPrint().setEnabled(enable);		
	}

	//WDEV-14383
	protected void onChkRemoveValueChanged() throws PresentationLogicException 
	{
	
		if (form.chkRemove().getValue() == true)
		{
			form.cmbOutcome().setRequired(true);
		}
		else
		{
			form.cmbOutcome().setRequired(false);
		}
		
	}

}
