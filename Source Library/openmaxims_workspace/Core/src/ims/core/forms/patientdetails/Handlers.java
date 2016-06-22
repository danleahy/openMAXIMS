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

package ims.core.forms.patientdetails;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbTitleLookup();
	abstract protected void defaultcmbTitleLookupValue();
	abstract protected void bindcmbEthnicLookup();
	abstract protected void defaultcmbEthnicLookupValue();
	abstract protected void bindcmbReligionLookup();
	abstract protected void defaultcmbReligionLookupValue();
	abstract protected void bindcmbMaritalLookup();
	abstract protected void defaultcmbMaritalLookupValue();
	abstract protected void bindcmbSexLookup();
	abstract protected void defaultcmbSexLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onQmbOccupationTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbAliasClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDeceasedClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbTitleValueSet(Object value);
	abstract protected void onImbOtherNamesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbEthnicValueSet(Object value);
	abstract protected void oncmbReligionValueSet(Object value);
	abstract protected void oncmbMaritalValueSet(Object value);
	abstract protected void oncmbSexValueSet(Object value);

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
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
		this.form.qmbOccupation().setSearchEvent(new ComboBoxSearch()
		{
			private static final long serialVersionUID = 1L;
			public void handle(String value) throws ims.framework.exceptions.PresentationLogicException
			{
				onQmbOccupationTextSubmited(value);
			}
		});
		this.form.imbAlias().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbAliasClick();
			}
		});
		this.form.btnDeceased().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDeceasedClick();
			}
		});
		this.form.cmbTitle().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTitleValueSet(value);
			}
		});
		this.form.imbOtherNames().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbOtherNamesClick();
			}
		});
		this.form.cmbEthnic().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbEthnicValueSet(value);
			}
		});
		this.form.cmbReligion().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReligionValueSet(value);
			}
		});
		this.form.cmbMarital().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbMaritalValueSet(value);
			}
		});
		this.form.cmbSex().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSexValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbTitleLookup();
		bindcmbEthnicLookup();
		bindcmbReligionLookup();
		bindcmbMaritalLookup();
		bindcmbSexLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbTitleLookup();
		bindcmbEthnicLookup();
		bindcmbReligionLookup();
		bindcmbMaritalLookup();
		bindcmbSexLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbTitleLookupValue();
		defaultcmbEthnicLookupValue();
		defaultcmbReligionLookupValue();
		defaultcmbMaritalLookupValue();
		defaultcmbSexLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}
