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

package ims.admin.forms.dictionaryconfig;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDynDictionariesRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdListSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnClear2Click() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnImportClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

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
				onFormOpen(args);
			}
		});
		this.form.dynDictionaries().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDynDictionariesRowSelectionChanged(row);
			}
		});
		this.form.lyr1().tabWords().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr1tabWordsActivated();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabManagement().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr2tabManagementActivated();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabImport().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyr2tabImportActivated();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabManagement().btnClear1().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnClearClick();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabManagement().btnSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSearchClick();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabManagement().grdList().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdListSelectionChanged();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabManagement().btnClear2().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnClear2Click();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabManagement().btnAdd().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnAddClick();
			}
		});
		this.form.lyr1().tabWords().lyr2().tabImport().btnImport().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnImportClick();
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
	}
	private void onlyr1tabWordsActivated()
	{
		this.form.lyr1().showtabWords();
	}
	private void onlyr2tabManagementActivated()
	{
		this.form.lyr1().tabWords().lyr2().showtabManagement();
	}
	private void onlyr2tabImportActivated()
	{
		this.form.lyr1().tabWords().lyr2().showtabImport();
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
