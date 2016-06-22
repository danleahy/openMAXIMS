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

package ims.core.forms.casenotemerge;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTypeToLookup();
	abstract protected void defaultcmbTypeToLookupValue();
	abstract protected void bindcmbStatusToLookup();
	abstract protected void defaultcmbStatusToLookupValue();
	abstract protected void bindcmbTypeFromLookup();
	abstract protected void defaultcmbTypeFromLookupValue();
	abstract protected void bindcmbStatusFromLookup();
	abstract protected void defaultcmbStatusFromLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnMergeVolumeClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTypeToValueSet(Object value);
	abstract protected void onCcVolumeToValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusToValueSet(Object value);
	abstract protected void oncmbTypeFromValueSet(Object value);
	abstract protected void onCcVolumeFromValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbStatusFromValueSet(Object value);

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
				onFormOpen(args);
			}
		});
		this.form.btnClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCloseClick();
			}
		});
		this.form.btnMergeVolume().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnMergeVolumeClick();
			}
		});
		this.form.cmbTypeTo().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeToValueSet(value);
			}
		});
		this.form.setccVolumeToValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcVolumeToValueChanged();
			}
		});
		this.form.cmbStatusTo().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusToValueSet(value);
			}
		});
		this.form.cmbTypeFrom().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTypeFromValueSet(value);
			}
		});
		this.form.setccVolumeFromValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCcVolumeFromValueChanged();
			}
		});
		this.form.cmbStatusFrom().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbStatusFromValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTypeToLookup();
		bindcmbStatusToLookup();
		bindcmbTypeFromLookup();
		bindcmbStatusFromLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTypeToLookup();
		bindcmbStatusToLookup();
		bindcmbTypeFromLookup();
		bindcmbStatusFromLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTypeToLookupValue();
		defaultcmbStatusToLookupValue();
		defaultcmbTypeFromLookupValue();
		defaultcmbStatusFromLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
