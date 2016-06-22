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

package ims.pathways.forms.eventconfiguration;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbEventTypeLookup();
	abstract protected void defaultcmbEventTypeLookupValue();
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void bindgrdExternalEventMappingsColStatusLookup();
	abstract protected void bindgrdRTTColActionLookup();
	abstract protected void bindgrdRTTColStatusLookup();
	abstract protected void bindcmbTypeLookup();
	abstract protected void defaultcmbTypeLookupValue();
	abstract protected void bindcmbReasonLookup();
	abstract protected void defaultcmbReasonLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkEndsPathwayValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkStopClocksValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkStartsClockValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbEventTypeValueSet(Object value);
	abstract protected void onCmbEventTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void onCmbStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkReturnClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrTargetsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onGrdExternalEventMappingsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdExternalEventMappingsGridComboBoxSelectionChanged(int column, GenForm.lyrTargetsLayer.tabExternalMappingsContainer.grdExternalEventMappingsRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdRTTSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdRTTMutableComboBoxSelected(int column, GenForm.lyrTargetsLayer.tabRTTContainer.grdRTTRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdRTTGridComboBoxSelectionChanged(int column, GenForm.lyrTargetsLayer.tabRTTContainer.grdRTTRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdEventTargetManagementCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdEventTargetManagementRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbImageTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTypeValueSet(Object value);
	abstract protected void onCmbTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbReasonValueSet(Object value);
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
		this.form.chkEndsPathway().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkEndsPathwayValueChanged();
			}
		});
		this.form.chkStopClocks().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkStopClocksValueChanged();
			}
		});
		this.form.chkStartsClock().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkStartsClockValueChanged();
			}
		});
		this.form.cmbEventType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbEventTypeValueSet(value);
			}
		});
		this.form.cmbEventType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbEventTypeValueChanged();
			}
		});
		this.form.cmbStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusValueSet(value);
			}
		});
		this.form.cmbStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbStatusValueChanged();
			}
		});
		this.form.lnkReturn().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkReturnClick();
			}
		});
		this.form.lyrTargets().tabExternalMappings().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTargetstabExternalMappingsActivated();
			}
		});
		this.form.lyrTargets().tabRTT().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTargetstabRTTActivated();
			}
		});
		this.form.lyrTargets().tabEventTargets().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTargetstabEventTargetsActivated();
			}
		});
		this.form.lyrTargets().tabActioningRoles().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTargetstabActioningRolesActivated();
			}
		});
		this.form.lyrTargets().tabExternalMappings().grdExternalEventMappings().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdExternalEventMappingsSelectionChanged();
			}
		});
		this.form.lyrTargets().tabExternalMappings().grdExternalEventMappings().setGridComboBoxSelectionChangedEvent(new GridComboBoxSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdExternalEventMappingsGridComboBoxSelectionChanged(column, new GenForm.lyrTargetsLayer.tabExternalMappingsContainer.grdExternalEventMappingsRow(row), value);
			}
		});
		this.form.lyrTargets().tabRTT().grdRTT().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdRTTSelectionChanged();
			}
		});
		this.form.lyrTargets().tabRTT().grdRTT().setGridMutableComboBoxSelectedEvent(new GridMutableComboBoxSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdRTTMutableComboBoxSelected(column, new GenForm.lyrTargetsLayer.tabRTTContainer.grdRTTRow(row), value);
			}
		});
		this.form.lyrTargets().tabRTT().grdRTT().setGridComboBoxSelectionChangedEvent(new GridComboBoxSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdRTTGridComboBoxSelectionChanged(column, new GenForm.lyrTargetsLayer.tabRTTContainer.grdRTTRow(row), value);
			}
		});
		this.form.lyrTargets().tabEventTargets().dyngrdEventTargetManagement().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdEventTargetManagementCellValueChanged(cell);
			}
		});
		this.form.lyrTargets().tabEventTargets().dyngrdEventTargetManagement().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdEventTargetManagementRowSelectionChanged(row);
			}
		});
		this.form.qmbImage().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbImageTextSubmited(value);
			}
		});
		this.form.btnNew().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewClick();
			}
		});
		this.form.btnEdit().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnEditClick();
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
		this.form.cmbType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeValueSet(value);
			}
		});
		this.form.cmbType().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbTypeValueChanged();
			}
		});
		this.form.cmbReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReasonValueSet(value);
			}
		});
		this.form.getContextMenus().Pathways.getEventConfigExternalSystemEventAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventConfigExternalSystemEvent.Add, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventConfigExternalSystemEventRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventConfigExternalSystemEvent.Remove, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventConfigExternalSystemRTTAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventConfigExternalSystemRTT.Add, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventConfigExternalSystemRTTRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventConfigExternalSystemRTT.Remove, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventConfigExternalSystemRTTEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventConfigExternalSystemRTT.Edit, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventTargetManagementAddTargetItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventTargetManagement.AddTarget, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventTargetManagementAddActivateTargetItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventTargetManagement.AddActivateTarget, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventTargetManagementRemoveItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventTargetManagement.Remove, sender);
			}
		});
		this.form.getContextMenus().Pathways.getEventTargetManagementEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.EventTargetManagement.Edit, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbEventTypeLookup();
		bindcmbStatusLookup();
		bindgrdExternalEventMappingsColStatusLookup();
		bindgrdRTTColActionLookup();
		bindgrdRTTColStatusLookup();
		bindcmbReasonLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbEventTypeLookup();
		bindcmbStatusLookup();
		bindgrdExternalEventMappingsColStatusLookup();
		bindgrdRTTColActionLookup();
		bindgrdRTTColStatusLookup();
		bindcmbTypeLookup();
		bindcmbReasonLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbEventTypeLookupValue();
		defaultcmbStatusLookupValue();
		defaultcmbTypeLookupValue();
		defaultcmbReasonLookupValue();
	}
	private void onlyrTargetstabExternalMappingsActivated()
	{
		this.form.lyrTargets().showtabExternalMappings();
		onlyrTargetsTabChanged(this.form.lyrTargets().tabExternalMappings());
	}
	private void onlyrTargetstabRTTActivated()
	{
		this.form.lyrTargets().showtabRTT();
		onlyrTargetsTabChanged(this.form.lyrTargets().tabRTT());
	}
	private void onlyrTargetstabEventTargetsActivated()
	{
		this.form.lyrTargets().showtabEventTargets();
		onlyrTargetsTabChanged(this.form.lyrTargets().tabEventTargets());
	}
	private void onlyrTargetstabActioningRolesActivated()
	{
		this.form.lyrTargets().showtabActioningRoles();
		onlyrTargetsTabChanged(this.form.lyrTargets().tabActioningRoles());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	public abstract void clearContextInformation();
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
