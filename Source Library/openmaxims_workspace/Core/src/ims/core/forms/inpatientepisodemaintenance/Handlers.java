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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.inpatientepisodemaintenance;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbSourceofEmerReferrralLookup();
	abstract protected void defaultcmbSourceofEmerReferrralLookupValue();
	abstract protected void bindcmbPatientCategoryLookup();
	abstract protected void defaultcmbPatientCategoryLookupValue();
	abstract protected void bindcmbSpecialtyLookup();
	abstract protected void defaultcmbSpecialtyLookupValue();
	abstract protected void bindcmbWardTypeLookup();
	abstract protected void defaultcmbWardTypeLookupValue();
	abstract protected void bindcmbAdmissionTypeLookup();
	abstract protected void defaultcmbAdmissionTypeLookupValue();
	abstract protected void bindcmbSourceOfReferralLookup();
	abstract protected void defaultcmbSourceOfReferralLookupValue();
	abstract protected void bindcmbMethodOfAdmissionLookup();
	abstract protected void defaultcmbMethodOfAdmissionLookupValue();
	abstract protected void bindcmbSourceOfAdmissionLookup();
	abstract protected void defaultcmbSourceOfAdmissionLookupValue();
	abstract protected void bindcmbDischargeDestinationLookup();
	abstract protected void defaultcmbDischargeDestinationLookupValue();
	abstract protected void bindcmbMethodOfDischargeLookup();
	abstract protected void defaultcmbMethodOfDischargeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnDischargedEpisodeCancel() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnDischargedEpisodeAdd() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnDischargedEpisodeRIE() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnHistoricDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnCancelCurrentAdmission() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnCurrentDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCurrentAdmissionDetailsSelectionCleared() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRIEConsultantTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditConsultantTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddConsultantTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnRIEWardTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditWardTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddWardTransferClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSourceofEmerReferrralValueSet(Object value);
	abstract protected void onCmbHospitalValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPatientCategoryValueSet(Object value);
	abstract protected void onCmbServiceValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSpecialtyValueSet(Object value);
	abstract protected void oncmbWardTypeValueSet(Object value);
	abstract protected void oncmbAdmissionTypeValueSet(Object value);
	abstract protected void OnBtnAdmissionDetailsCancel() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnAdmissionDetailsSave() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSourceOfReferralValueSet(Object value);
	abstract protected void onCmbSourceOfReferralValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbMethodOfAdmissionValueSet(Object value);
	abstract protected void oncmbSourceOfAdmissionValueSet(Object value);
	abstract protected void onBtnEditAdmissionDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdWardTransfersGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdConsultantTransfersGridSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnDischargeDetailsCancel() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnDischargeDetailsSave() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnDischargeDetailsEdit() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkTreatmentDefferredValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDischargeDestinationValueSet(Object value);
	abstract protected void oncmbMethodOfDischargeValueSet(Object value);
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnCancelDischarge().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnDischargedEpisodeCancel();
			}
		});
		this.form.btnAddHistoricalInpatientEpisodes().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnDischargedEpisodeAdd();
			}
		});
		this.form.btnRieHistoricaInpatientEpisodes().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnDischargedEpisodeRIE();
			}
		});
		this.form.grdHistoricalInpatientEpisodes().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				OnHistoricDetailsSelectionChanged();
			}
		});
		this.form.btnRieCurrentAdmissionDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnCancelCurrentAdmission();
			}
		});
		this.form.grdCurrentAdmissionDetails().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				OnCurrentDetailsSelectionChanged();
			}
		});
		this.form.grdCurrentAdmissionDetails().setSelectionClearedEvent(new SelectionCleared()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCurrentAdmissionDetailsSelectionCleared();
			}
		});
		this.form.ctn1().btnRIEConsultantTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRIEConsultantTransferClick();
			}
		});
		this.form.ctn1().btnEditConsultantTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditConsultantTransferClick();
			}
		});
		this.form.ctn1().btnAddConsultantTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddConsultantTransferClick();
			}
		});
		this.form.ctn1().btnRIEWardTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnRIEWardTransferClick();
			}
		});
		this.form.ctn1().btnEditWardTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditWardTransferClick();
			}
		});
		this.form.ctn1().btnAddWardTransfer().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddWardTransferClick();
			}
		});
		this.form.ctn1().cmbSourceofEmerReferrral().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSourceofEmerReferrralValueSet(value);
			}
		});
		this.form.ctn1().cmbHospital().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbHospitalValueChanged();
			}
		});
		this.form.ctn1().cmbPatientCategory().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPatientCategoryValueSet(value);
			}
		});
		this.form.ctn1().cmbService().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbServiceValueChanged();
			}
		});
		this.form.ctn1().cmbSpecialty().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSpecialtyValueSet(value);
			}
		});
		this.form.ctn1().cmbWardType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbWardTypeValueSet(value);
			}
		});
		this.form.ctn1().cmbAdmissionType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAdmissionTypeValueSet(value);
			}
		});
		this.form.ctn1().btnAdmissionDetailsCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnAdmissionDetailsCancel();
			}
		});
		this.form.ctn1().btnAdmissionDetailsSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnAdmissionDetailsSave();
			}
		});
		this.form.ctn1().cmbSourceOfReferral().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSourceOfReferralValueSet(value);
			}
		});
		this.form.ctn1().cmbSourceOfReferral().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbSourceOfReferralValueChanged();
			}
		});
		this.form.ctn1().cmbMethodOfAdmission().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMethodOfAdmissionValueSet(value);
			}
		});
		this.form.ctn1().cmbSourceOfAdmission().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSourceOfAdmissionValueSet(value);
			}
		});
		this.form.ctn1().btnEditAdmissionDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditAdmissionDetailsClick();
			}
		});
		this.form.ctn1().grdWardTransfersGrid().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdWardTransfersGridSelectionChanged();
			}
		});
		this.form.ctn1().grdConsultantTransfersGrid().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdConsultantTransfersGridSelectionChanged();
			}
		});
		this.form.ctn1().btnDischargeDetailsCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnDischargeDetailsCancel();
			}
		});
		this.form.ctn1().btnDischargeDetailsSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnDischargeDetailsSave();
			}
		});
		this.form.ctn1().btnEditDischDet().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnDischargeDetailsEdit();
			}
		});
		this.form.ctn1().chkTreatmentDefferred().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkTreatmentDefferredValueChanged();
			}
		});
		this.form.ctn1().cmbDischargeDestination().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDischargeDestinationValueSet(value);
			}
		});
		this.form.ctn1().cmbMethodOfDischarge().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMethodOfDischargeValueSet(value);
			}
		});
		this.form.getContextMenus().Core.getDischargedEpisodesMenuRIEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.DischargedEpisodesMenu.RIE, sender);
			}
		});
		this.form.getContextMenus().Core.getDischargedEpisodesMenuCANCEL_DISCHARGEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.DischargedEpisodesMenu.CANCEL_DISCHARGE, sender);
			}
		});
		this.form.getContextMenus().Core.getWardTransferForInpatientEpisodeMaintenanceADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.WardTransferForInpatientEpisodeMaintenance.ADD, sender);
			}
		});
		this.form.getContextMenus().Core.getWardTransferForInpatientEpisodeMaintenanceEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.WardTransferForInpatientEpisodeMaintenance.EDIT, sender);
			}
		});
		this.form.getContextMenus().Core.getWardTransferForInpatientEpisodeMaintenanceRIEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.WardTransferForInpatientEpisodeMaintenance.RIE, sender);
			}
		});
		this.form.getContextMenus().Core.getConsultantTransferForInpatientEpisodeMaintenanceADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.ConsultantTransferForInpatientEpisodeMaintenance.ADD, sender);
			}
		});
		this.form.getContextMenus().Core.getConsultantTransferForInpatientEpisodeMaintenanceEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.ConsultantTransferForInpatientEpisodeMaintenance.EDIT, sender);
			}
		});
		this.form.getContextMenus().Core.getConsultantTransferForInpatientEpisodeMaintenanceRIEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.CoreNamespace.ConsultantTransferForInpatientEpisodeMaintenance.RIE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbSourceofEmerReferrralLookup();
		bindcmbPatientCategoryLookup();
		bindcmbWardTypeLookup();
		bindcmbAdmissionTypeLookup();
		bindcmbSourceOfReferralLookup();
		bindcmbMethodOfAdmissionLookup();
		bindcmbSourceOfAdmissionLookup();
		bindcmbDischargeDestinationLookup();
		bindcmbMethodOfDischargeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbSourceofEmerReferrralLookup();
		bindcmbPatientCategoryLookup();
		bindcmbSpecialtyLookup();
		bindcmbWardTypeLookup();
		bindcmbAdmissionTypeLookup();
		bindcmbSourceOfReferralLookup();
		bindcmbMethodOfAdmissionLookup();
		bindcmbSourceOfAdmissionLookup();
		bindcmbDischargeDestinationLookup();
		bindcmbMethodOfDischargeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbSourceofEmerReferrralLookupValue();
		defaultcmbPatientCategoryLookupValue();
		defaultcmbSpecialtyLookupValue();
		defaultcmbWardTypeLookupValue();
		defaultcmbAdmissionTypeLookupValue();
		defaultcmbSourceOfReferralLookupValue();
		defaultcmbMethodOfAdmissionLookupValue();
		defaultcmbSourceOfAdmissionLookupValue();
		defaultcmbDischargeDestinationLookupValue();
		defaultcmbMethodOfDischargeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
