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

package ims.oncology.forms.chemotherapydetails;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbHospitalLookup();
	abstract protected void defaultcmbHospitalLookupValue();
	abstract protected void bindcmbRegimenOutcomeSummaryLookup();
	abstract protected void defaultcmbRegimenOutcomeSummaryLookupValue();
	abstract protected void bindcmbDelay2Lookup();
	abstract protected void defaultcmbDelay2LookupValue();
	abstract protected void bindcmbDelay1Lookup();
	abstract protected void defaultcmbDelay1LookupValue();
	abstract protected void bindcmbPrefornmanceStatLookup();
	abstract protected void defaultcmbPrefornmanceStatLookupValue();
	abstract protected void bindcmbTreatmentIntentLookup();
	abstract protected void defaultcmbTreatmentIntentLookupValue();
	abstract protected void bindcmbRegimeAcronymLookup();
	abstract protected void defaultcmbRegimeAcronymLookupValue();
	abstract protected void bindcmbTreatmentResponseLookup();
	abstract protected void defaultcmbTreatmentResponseLookupValue();
	abstract protected void bindcmbReasonForChangingLookup();
	abstract protected void defaultcmbReasonForChangingLookupValue();
	abstract protected void bindcmbDrugTherapyTypeLookup();
	abstract protected void defaultcmbDrugTherapyTypeLookupValue();
	abstract protected void bindcmbPerformanceStatusAtSTartCycleLookup();
	abstract protected void defaultcmbPerformanceStatusAtSTartCycleLookupValue();
	abstract protected void bindcmbTreatmentTypeLookup();
	abstract protected void defaultcmbTreatmentTypeLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrDetailsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onDte1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbHospitalValueSet(Object value);
	abstract protected void oncmbRegimenOutcomeSummaryValueSet(Object value);
	abstract protected void oncmbDelay2ValueSet(Object value);
	abstract protected void oncmbDelay1ValueSet(Object value);
	abstract protected void oncmbPrefornmanceStatValueSet(Object value);
	abstract protected void oncmbTreatmentIntentValueSet(Object value);
	abstract protected void oncmbRegimeAcronymValueSet(Object value);
	abstract protected void onCmbRegimeAcronymValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTreatmentResponseValueSet(Object value);
	abstract protected void oncmbReasonForChangingValueSet(Object value);
	abstract protected void oncmbDrugTherapyTypeValueSet(Object value);
	abstract protected void onRadioButtonGroupStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPerformanceStatusAtSTartCycleValueSet(Object value);
	abstract protected void oncmbTreatmentTypeValueSet(Object value);
	abstract protected void onCmbTreatmentTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdCCOCyclesDaysRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveCycleClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelCycleClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onRadioButtonGroupFilterStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdCyclesDaysRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdChemotherapySelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
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
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
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
		this.form.lyrDetails().tabDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabDetailsActivated();
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabCycleAndDrugCCOActivated();
			}
		});
		this.form.lyrDetails().tabCycleAndDrug().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrDetailstabCycleAndDrugActivated();
			}
		});
		this.form.lyrDetails().tabDetails().dtePrescribing().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDte1ValueChanged();
			}
		});
		this.form.lyrDetails().tabDetails().cmbHospital().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbHospitalValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbRegimenOutcomeSummary().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbRegimenOutcomeSummaryValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbDelay2().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDelay2ValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbDelay1().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDelay1ValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbPrefornmanceStat().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPrefornmanceStatValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbTreatmentIntent().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTreatmentIntentValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbRegimeAcronym().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbRegimeAcronymValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbRegimeAcronym().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbRegimeAcronymValueChanged();
			}
		});
		this.form.lyrDetails().tabDetails().cmbTreatmentResponse().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTreatmentResponseValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbReasonForChanging().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReasonForChangingValueSet(value);
			}
		});
		this.form.lyrDetails().tabDetails().cmbDrugTherapyType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDrugTherapyTypeValueSet(value);
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().GroupStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupStatusValueChanged();
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbPerformanceStatusAtSTartCycle().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPerformanceStatusAtSTartCycleValueSet(value);
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTreatmentTypeValueSet(value);
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().cmbTreatmentType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTreatmentTypeValueChanged();
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().dyngrdCCOCyclesDays().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdCCOCyclesDaysRowSelectionChanged(row);
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().btnSaveCycle().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveCycleClick();
			}
		});
		this.form.lyrDetails().tabCycleAndDrugCCO().btnCancelCycle().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelCycleClick();
			}
		});
		this.form.lyrDetails().tabCycleAndDrug().GroupFilterStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onRadioButtonGroupFilterStatusValueChanged();
			}
		});
		this.form.lyrDetails().tabCycleAndDrug().dyngrdCyclesDays().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdCyclesDaysRowSelectionChanged(row);
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCancelClick();
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onSaveClick();
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onUpdateClick();
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onNewClick();
			}
		});
		this.form.grdChemotherapy().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdChemotherapySelectionChanged();
			}
		});
		this.form.getContextMenus().Oncology.getCCOChemoCycleMenuCCO_ADD_CYCLEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OncologyNamespace.CCOChemoCycleMenu.CCO_ADD_CYCLE, sender);
			}
		});
		this.form.getContextMenus().Oncology.getCCOChemoCycleMenuCCO_EDIT_CYCLEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.OncologyNamespace.CCOChemoCycleMenu.CCO_EDIT_CYCLE, sender);
			}
		});
		this.form.getContextMenus().getChemotherapyCycleAddCycleItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ChemotherapyCycle.AddCycle, sender);
			}
		});
		this.form.getContextMenus().getChemotherapyCycleEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ChemotherapyCycle.Edit, sender);
			}
		});
		this.form.getContextMenus().getChemotherapyCycleAddFractionItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ChemotherapyCycle.AddFraction, sender);
			}
		});
		this.form.getContextMenus().getChemotherapyCycleEditFractionItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ChemotherapyCycle.EditFraction, sender);
			}
		});
		this.form.getContextMenus().getChemotherapyCycleViewDayItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ChemotherapyCycle.ViewDay, sender);
			}
		});
		this.form.getContextMenus().getGenericGridAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Add, sender);
			}
		});
		this.form.getContextMenus().getGenericGridUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Update, sender);
			}
		});
		this.form.getContextMenus().getGenericGridRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Remove, sender);
			}
		});
		this.form.getContextMenus().getGenericGridViewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.View, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveUpItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveUp, sender);
			}
		});
		this.form.getContextMenus().getGenericGridMoveDownItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.MoveDown, sender);
			}
		});
		this.form.getContextMenus().getGenericGridReplaceItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Replace, sender);
			}
		});
		this.form.getContextMenus().getGenericGridConfirmItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.Confirm, sender);
			}
		});
		this.form.getContextMenus().getGenericGridEDIT_VIEW_ICP_ACTIONSItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.EDIT_VIEW_ICP_ACTIONS, sender);
			}
		});
		this.form.getContextMenus().getGenericGridCOPYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.COPY, sender);
			}
		});
		this.form.getContextMenus().getGenericGridREMOVE_UNVERIFIED_NHS_NUMBERItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.GenericGrid.REMOVE_UNVERIFIED_NHS_NUMBER, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbHospitalLookup();
		bindcmbRegimenOutcomeSummaryLookup();
		bindcmbDelay2Lookup();
		bindcmbDelay1Lookup();
		bindcmbPrefornmanceStatLookup();
		bindcmbTreatmentIntentLookup();
		bindcmbRegimeAcronymLookup();
		bindcmbTreatmentResponseLookup();
		bindcmbReasonForChangingLookup();
		bindcmbDrugTherapyTypeLookup();
		bindcmbPerformanceStatusAtSTartCycleLookup();
		bindcmbTreatmentTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbHospitalLookup();
		bindcmbRegimenOutcomeSummaryLookup();
		bindcmbDelay2Lookup();
		bindcmbDelay1Lookup();
		bindcmbPrefornmanceStatLookup();
		bindcmbTreatmentIntentLookup();
		bindcmbRegimeAcronymLookup();
		bindcmbTreatmentResponseLookup();
		bindcmbReasonForChangingLookup();
		bindcmbDrugTherapyTypeLookup();
		bindcmbPerformanceStatusAtSTartCycleLookup();
		bindcmbTreatmentTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbHospitalLookupValue();
		defaultcmbRegimenOutcomeSummaryLookupValue();
		defaultcmbDelay2LookupValue();
		defaultcmbDelay1LookupValue();
		defaultcmbPrefornmanceStatLookupValue();
		defaultcmbTreatmentIntentLookupValue();
		defaultcmbRegimeAcronymLookupValue();
		defaultcmbTreatmentResponseLookupValue();
		defaultcmbReasonForChangingLookupValue();
		defaultcmbDrugTherapyTypeLookupValue();
		defaultcmbPerformanceStatusAtSTartCycleLookupValue();
		defaultcmbTreatmentTypeLookupValue();
	}
	private void onlyrDetailstabDetailsActivated()
	{
		this.form.lyrDetails().showtabDetails();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabDetails());
	}
	private void onlyrDetailstabCycleAndDrugCCOActivated()
	{
		this.form.lyrDetails().showtabCycleAndDrugCCO();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabCycleAndDrugCCO());
	}
	private void onlyrDetailstabCycleAndDrugActivated()
	{
		this.form.lyrDetails().showtabCycleAndDrug();
		onlyrDetailsTabChanged(this.form.lyrDetails().tabCycleAndDrug());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
