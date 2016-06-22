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

package ims.nursing.forms.planofcare;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected String[] getLookupUsageErrors();
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void bindcmbGroupLookup();
	abstract protected void defaultcmbGroupLookupValue();
	abstract protected void bindcmbStatusPOCLookup();
	abstract protected void defaultcmbStatusPOCLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdPOCCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdPOCRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void onCmbStatusValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbGroupValueSet(Object value);
	abstract protected void onChkConfirmValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusPOCValueSet(Object value);
	abstract protected void onCmbStatusPOCValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
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
				// Checking lookups usage
				if(getLookupUsageErrors() != null && getLookupUsageErrors().length > 0)
					throw new ims.framework.exceptions.FormMandatoryLookupMissingException(ims.framework.exceptions.FormMandatoryLookupMissingException.getError(getLookupUsageErrors()));
				onFormOpen();
			}
		});
		this.form.lyrPOC().tabPocList().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPOCtabPocListActivated();
			}
		});
		this.form.lyrPOC().tabPocDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrPOCtabPocDetailsActivated();
			}
		});
		this.form.lyrPOC().tabPocList().dyngrdPOC().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPOCCellButtonClicked(cell);
			}
		});
		this.form.lyrPOC().tabPocList().dyngrdPOC().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdPOCRowSelectionChanged(row);
			}
		});
		this.form.lyrPOC().tabPocList().cmbStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusValueSet(value);
			}
		});
		this.form.lyrPOC().tabPocList().cmbStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbStatusValueChanged();
			}
		});
		this.form.lyrPOC().tabPocDetails().cmbGroup().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbGroupValueSet(value);
			}
		});
		this.form.lyrPOC().tabPocDetails().chkConfirm().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkConfirmValueChanged();
			}
		});
		this.form.lyrPOC().tabPocDetails().cmbStatusPOC().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusPOCValueSet(value);
			}
		});
		this.form.lyrPOC().tabPocDetails().cmbStatusPOC().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbStatusPOCValueChanged();
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
		this.form.getContextMenus().getPlanOfCareNEWPOCItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PlanOfCare.NEWPOC, sender);
			}
		});
		this.form.getContextMenus().getPlanOfCareUPDATEPOCItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PlanOfCare.UPDATEPOC, sender);
			}
		});
		this.form.getContextMenus().getPlanOfCareVIEWPOCItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PlanOfCare.VIEWPOC, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbStatusLookup();
		bindcmbGroupLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbStatusLookup();
		bindcmbGroupLookup();
		bindcmbStatusPOCLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbStatusLookupValue();
		defaultcmbGroupLookupValue();
		defaultcmbStatusPOCLookupValue();
	}
	private void onlyrPOCtabPocListActivated()
	{
		this.form.lyrPOC().showtabPocList();
	}
	private void onlyrPOCtabPocDetailsActivated()
	{
		this.form.lyrPOC().showtabPocDetails();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
