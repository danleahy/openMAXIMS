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

package ims.clinical.forms.clinicalnoteslist;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbHcpStatusLookup();
	abstract protected void defaultcmbHcpStatusLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdNotesRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrSearcFilterTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onImbClearHcpClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchHcpClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbHcpRecTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbHcpStatusValueSet(Object value);
	abstract protected void onImbClearUserClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchUserClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbUserRecTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

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
		this.form.dyngrdNotes().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdNotesRowSelectionChanged(row);
			}
		});
		this.form.lyrSearcFilter().tabRecordingHcp().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSearcFiltertabRecordingHcpActivated();
			}
		});
		this.form.lyrSearcFilter().tabRecordingUser().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrSearcFiltertabRecordingUserActivated();
			}
		});
		this.form.lyrSearcFilter().tabRecordingHcp().imbClearHcp().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearHcpClick();
			}
		});
		this.form.lyrSearcFilter().tabRecordingHcp().imbSearchHcp().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchHcpClick();
			}
		});
		this.form.lyrSearcFilter().tabRecordingHcp().qmbHcpRec().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbHcpRecTextSubmited(value);
			}
		});
		this.form.lyrSearcFilter().tabRecordingHcp().cmbHcpStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbHcpStatusValueSet(value);
			}
		});
		this.form.lyrSearcFilter().tabRecordingUser().imbClearUser().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearUserClick();
			}
		});
		this.form.lyrSearcFilter().tabRecordingUser().imbSearchUser().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchUserClick();
			}
		});
		this.form.lyrSearcFilter().tabRecordingUser().qmbUserRec().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbUserRecTextSubmited(value);
			}
		});
		this.form.getContextMenus().getClinicalNotingADDItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.ADD, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingEDITItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.EDIT, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingVALIDATEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.VALIDATE, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingCORRECTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.CORRECT, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.VIEW, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingREVIEWItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.REVIEW, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingSTATUS_HISTItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.STATUS_HIST, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingVIEW_CORRECTION_HISTORYItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.VIEW_CORRECTION_HISTORY, sender);
			}
		});
		this.form.getContextMenus().getClinicalNotingADD_SOAP_NOTEItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.ClinicalNoting.ADD_SOAP_NOTE, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbHcpStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbHcpStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbHcpStatusLookupValue();
	}
	private void onlyrSearcFiltertabRecordingHcpActivated()
	{
		this.form.lyrSearcFilter().showtabRecordingHcp();
		onlyrSearcFilterTabChanged(this.form.lyrSearcFilter().tabRecordingHcp());
	}
	private void onlyrSearcFiltertabRecordingUserActivated()
	{
		this.form.lyrSearcFilter().showtabRecordingUser();
		onlyrSearcFilterTabChanged(this.form.lyrSearcFilter().tabRecordingUser());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
