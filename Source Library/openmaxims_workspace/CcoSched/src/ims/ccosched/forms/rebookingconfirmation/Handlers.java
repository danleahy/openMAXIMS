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

package ims.ccosched.forms.rebookingconfirmation;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindMainGridTransportLookup();
	abstract protected void bindPatientStatusLookup();
	abstract protected void defaultPatientStatusLookupValue();
	abstract protected void bindSpecialRequirementsRequirementLookup();
	abstract protected void bindPriorityLookup();
	abstract protected void defaultPriorityLookupValue();
	abstract protected void bindConfirmationStatusLookup();
	abstract protected void defaultConfirmationStatusLookupValue();
	abstract protected void bindBookingSystemTypeLookup();
	abstract protected void defaultBookingSystemTypeLookupValue();
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnCancel() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnRebook() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnMinus() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnPlus() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onPatientStatusValueSet(Object value);
	abstract protected void onSpecialRequirementsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onEarlierDateOfferedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onPriorityValueSet(Object value);
	abstract protected void onConfirmationStatusValueSet(Object value);
	abstract protected void onBookingSystemTypeValueSet(Object value);

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
		this.form.Cancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnCancel();
			}
		});
		this.form.Rebook().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnRebook();
			}
		});
		this.form.imbMinus().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnMinus();
			}
		});
		this.form.imbPlus().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnPlus();
			}
		});
		this.form.PatientStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onPatientStatusValueSet(value);
			}
		});
		this.form.SpecialRequirements().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onSpecialRequirementsSelectionChanged();
			}
		});
		this.form.EarlierDateOffered().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onEarlierDateOfferedValueChanged();
			}
		});
		this.form.Priority().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onPriorityValueSet(value);
			}
		});
		this.form.ConfirmationStatus().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onConfirmationStatusValueSet(value);
			}
		});
		this.form.BookingSystemType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onBookingSystemTypeValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindMainGridTransportLookup();
		bindPatientStatusLookup();
		bindSpecialRequirementsRequirementLookup();
		bindPriorityLookup();
		bindConfirmationStatusLookup();
		bindBookingSystemTypeLookup();
	}
	protected void rebindAllLookups()
	{
		bindMainGridTransportLookup();
		bindPatientStatusLookup();
		bindSpecialRequirementsRequirementLookup();
		bindPriorityLookup();
		bindConfirmationStatusLookup();
		bindBookingSystemTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultPatientStatusLookupValue();
		defaultPriorityLookupValue();
		defaultConfirmationStatusLookupValue();
		defaultBookingSystemTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
