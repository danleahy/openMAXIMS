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

package ims.ccosched.forms.rebooking;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindEnergyUnitLookup();
	abstract protected void defaultEnergyUnitLookupValue();
	abstract protected void bindModalityLookup();
	abstract protected void defaultModalityLookupValue();
	abstract protected void onFormClosing(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onAvailabilityDetailsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnClose() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnTimeChanged(int column, GenForm.ChangeTimeRow row, ims.framework.utils.Time value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnSessionList() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnGridCheckBoxClicked(int column, GenForm.SlotsGridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnNextDateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnPreviousDateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBActionsClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGrdFurtherApptSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnNumberOfAppointments() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnSequence() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGenerateDatesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnResetClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnDateSelected(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnDateChecked(ims.framework.utils.Date date, boolean value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnMonthSelected(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnResource() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onEnergyUnitValueSet(Object value);
	abstract protected void onModalityValueSet(Object value);
	abstract protected void OnListOwner() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnMainGrid() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnConfirm() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormClosingEvent(new FormClosing()
		{
			private static final long serialVersionUID = 1L;
			public void handle(CancelArgs args) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormClosing(args);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				OnFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				OnFormDialogClosed(formName, result);
			}
		});
		this.form.AvailabilityDetails().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onAvailabilityDetailsClick();
			}
		});
		this.form.Close().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnClose();
			}
		});
		this.form.ChangeTime().setGridTimeControlValueChangedEvent(new GridTimeControlValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, ims.framework.utils.Time value) throws ims.framework.exceptions.PresentationLogicException
			{
				OnTimeChanged(column, new GenForm.ChangeTimeRow(row), value);
			}
		});
		this.form.SessionList().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnSessionList();
			}
		});
		this.form.SlotsGrid().setGridCheckBoxClickedEvent(new GridCheckBoxClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, boolean isChecked) throws ims.framework.exceptions.PresentationLogicException
			{
				OnGridCheckBoxClicked(column, new GenForm.SlotsGridRow(row), isChecked);
			}
		});
		this.form.NextDate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnNextDateClick();
			}
		});
		this.form.PreviousDate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnPreviousDateClick();
			}
		});
		this.form.bActions().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBActionsClick();
			}
		});
		this.form.grdFurtherAppt().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGrdFurtherApptSelectionChanged();
			}
		});
		this.form.NumberOfAppointments().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnNumberOfAppointments();
			}
		});
		this.form.Sequence().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnSequence();
			}
		});
		this.form.GenerateDates().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onGenerateDatesClick();
			}
		});
		this.form.Reset().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnResetClick();
			}
		});
		this.form.Calendar().setBookingCalendarDateSelectedEvent(new BookingCalendarDateSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException
			{
				OnDateSelected(date);
			}
		});
		this.form.Calendar().setBookingCalendarDateCheckedEvent(new BookingCalendarDateChecked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date, boolean value) throws ims.framework.exceptions.PresentationLogicException
			{
				OnDateChecked(date, value);
			}
		});
		this.form.Calendar().setBookingCalendarMonthSelectedEvent(new BookingCalendarMonthSelected()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.utils.Date date) throws ims.framework.exceptions.PresentationLogicException
			{
				OnMonthSelected(date);
			}
		});
		this.form.Resource().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnResource();
			}
		});
		this.form.EnergyUnit().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onEnergyUnitValueSet(value);
			}
		});
		this.form.Modality().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onModalityValueSet(value);
			}
		});
		this.form.ListOwner().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnListOwner();
			}
		});
		this.form.MainGrid().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				OnMainGrid();
			}
		});
		this.form.ConfirmRebooking().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnConfirm();
			}
		});
	}
	protected void rebindAllLookups()
	{
		bindEnergyUnitLookup();
		bindModalityLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultEnergyUnitLookupValue();
		defaultModalityLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
