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

package ims.pathways.forms.targetconfiguration;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode, ims.framework.interfaces.IClearInfo
{
	abstract protected void bindcmbSearchTargetDateCalFromLookup();
	abstract protected void defaultcmbSearchTargetDateCalFromLookupValue();
	abstract protected void bindgrdTargetsColEventLinkLookup();
	abstract protected void bindgrdTargetsColTargetDateCalculationLookup();
	abstract protected void bindgrdTargetsColStatusLookup();
	abstract protected void bindcmbPathwayEventLookup();
	abstract protected void defaultcmbPathwayEventLookupValue();
	abstract protected void bindcmbPathwayStatusLookup();
	abstract protected void defaultcmbPathwayStatusLookupValue();
	abstract protected void bindcmbTargetDateCalculationLookup();
	abstract protected void defaultcmbTargetDateCalculationLookupValue();
	abstract protected void bindcmbSearchEventLookup();
	abstract protected void defaultcmbSearchEventLookupValue();
	abstract protected void bindcmbSearchStatusLookup();
	abstract protected void defaultcmbSearchStatusLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSearchTargetDateCalFromValueSet(Object value);
	abstract protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdTargetsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPathwayEventValueSet(Object value);
	abstract protected void oncmbPathwayStatusValueSet(Object value);
	abstract protected void oncmbTargetDateCalculationValueSet(Object value);
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbSearchEventValueSet(Object value);
	abstract protected void oncmbSearchStatusValueSet(Object value);
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
				onFormOpen(args);
			}
		});
		this.form.cmbSearchTargetDateCalFrom().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSearchTargetDateCalFromValueSet(value);
			}
		});
		this.form.imbClear().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbClearClick();
			}
		});
		this.form.imbSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSearchClick();
			}
		});
		this.form.grdTargets().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdTargetsSelectionChanged();
			}
		});
		this.form.ctnDetails().cmbPathwayEvent().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPathwayEventValueSet(value);
			}
		});
		this.form.ctnDetails().cmbPathwayStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPathwayStatusValueSet(value);
			}
		});
		this.form.ctnDetails().cmbTargetDateCalculation().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTargetDateCalculationValueSet(value);
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
		this.form.cmbSearchEvent().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSearchEventValueSet(value);
			}
		});
		this.form.cmbSearchStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSearchStatusValueSet(value);
			}
		});
		this.form.getContextMenus().Pathways.getTargetConfigurationNewItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.TargetConfiguration.New, sender);
			}
		});
		this.form.getContextMenus().Pathways.getTargetConfigurationEditItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PathwaysNamespace.TargetConfiguration.Edit, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbSearchTargetDateCalFromLookup();
		bindgrdTargetsColEventLinkLookup();
		bindgrdTargetsColTargetDateCalculationLookup();
		bindgrdTargetsColStatusLookup();
		bindcmbPathwayEventLookup();
		bindcmbPathwayStatusLookup();
		bindcmbTargetDateCalculationLookup();
		bindcmbSearchEventLookup();
		bindcmbSearchStatusLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbSearchTargetDateCalFromLookup();
		bindgrdTargetsColEventLinkLookup();
		bindgrdTargetsColTargetDateCalculationLookup();
		bindgrdTargetsColStatusLookup();
		bindcmbPathwayEventLookup();
		bindcmbPathwayStatusLookup();
		bindcmbTargetDateCalculationLookup();
		bindcmbSearchEventLookup();
		bindcmbSearchStatusLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbSearchTargetDateCalFromLookupValue();
		defaultcmbPathwayEventLookupValue();
		defaultcmbPathwayStatusLookupValue();
		defaultcmbTargetDateCalculationLookupValue();
		defaultcmbSearchEventLookupValue();
		defaultcmbSearchStatusLookupValue();
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
