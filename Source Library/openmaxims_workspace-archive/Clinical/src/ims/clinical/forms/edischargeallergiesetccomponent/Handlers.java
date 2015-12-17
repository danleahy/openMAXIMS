//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.edischargeallergiesetccomponent;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbAlertSourceLookup();
	abstract protected void defaultcmbAlertSourceLookupValue();
	abstract protected void bindcmbAllergyTypeLookup();
	abstract protected void defaultcmbAllergyTypeLookupValue();
	abstract protected void bindcmbAllergySourceLookup();
	abstract protected void defaultcmbAllergySourceLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAlertsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAlertsGridCheckBoxClicked(int column, GenForm.grdAlertsRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbCategoryValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAlertSourceValueSet(Object value);
	abstract protected void onCustomControlCodingItemValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAllergyTypeValueSet(Object value);
	abstract protected void onCmbTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAllergySourceValueSet(Object value);
	abstract protected void onGrdAllergiesSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdAllergiesGridCheckBoxClicked(int column, GenForm.grdAllergiesRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
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
		this.form.grdAlerts().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAlertsSelectionChanged();
			}
		});
		this.form.grdAlerts().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAlertsGridCheckBoxClicked(column, new GenForm.grdAlertsRow(row), isChecked);
			}
		});
		this.form.ctnAlert().cmbAlertCategory().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbCategoryValueChanged();
			}
		});
		this.form.ctnAlert().cmbAlertSource().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAlertSourceValueSet(value);
			}
		});
		this.form.ctnAllergy().setccAllergyTermValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCustomControlCodingItemValueChanged();
			}
		});
		this.form.ctnAllergy().cmbAllergyType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAllergyTypeValueSet(value);
			}
		});
		this.form.ctnAllergy().cmbAllergyType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTypeValueChanged();
			}
		});
		this.form.ctnAllergy().cmbAllergySource().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAllergySourceValueSet(value);
			}
		});
		this.form.grdAllergies().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAllergiesSelectionChanged();
			}
		});
		this.form.grdAllergies().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdAllergiesGridCheckBoxClicked(column, new GenForm.grdAllergiesRow(row), isChecked);
			}
		});
		this.form.btnSave().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.getContextMenus().Clinical.getEdischargeAlertsEtcNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.EdischargeAlertsEtc.New, sender);
			}
		});
		this.form.getContextMenus().Clinical.getEdischargeAlertsEtcEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.EdischargeAlertsEtc.Edit, sender);
			}
		});
		this.form.getContextMenus().Clinical.getEdischargeAllergiesEtcNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.EdischargeAllergiesEtc.New, sender);
			}
		});
		this.form.getContextMenus().Clinical.getEdischargeAllergiesEtcEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNamespace.EdischargeAllergiesEtc.Edit, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbAlertSourceLookup();
		bindcmbAllergyTypeLookup();
		bindcmbAllergySourceLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbAlertSourceLookup();
		bindcmbAllergyTypeLookup();
		bindcmbAllergySourceLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbAlertSourceLookupValue();
		defaultcmbAllergyTypeLookupValue();
		defaultcmbAllergySourceLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}