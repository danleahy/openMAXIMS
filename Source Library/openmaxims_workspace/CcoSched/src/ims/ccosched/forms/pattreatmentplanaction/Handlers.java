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

package ims.ccosched.forms.pattreatmentplanaction;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbPlannedRegimeLookup();
	abstract protected void defaultcmbPlannedRegimeLookupValue();
	abstract protected void bindcmbUnitLookup();
	abstract protected void defaultcmbUnitLookupValue();
	abstract protected void bindcmbModalityLookup();
	abstract protected void defaultcmbModalityLookupValue();
	abstract protected void bindcmbCategoryLookup();
	abstract protected void defaultcmbCategoryLookupValue();
	abstract protected void bindcmbAttendingAsLookup();
	abstract protected void defaultcmbAttendingAsLookupValue();
	abstract protected void bindcmbTransportLookup();
	abstract protected void defaultcmbTransportLookupValue();
	abstract protected void bindcmbStatusLookup();
	abstract protected void defaultcmbStatusLookupValue();
	abstract protected void bindcmbPriorityLookup();
	abstract protected void defaultcmbPriorityLookupValue();
	abstract protected void bindAnaestheticLookup();
	abstract protected void defaultAnaestheticLookupValue();
	abstract protected void OnFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnOk() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnRemoveDose() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnAddDose() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void Dose_SelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPlannedRegimeValueSet(Object value);
	abstract protected void oncmbUnitValueSet(Object value);
	abstract protected void oncmbModalityValueSet(Object value);
	abstract protected void oncmbCategoryValueSet(Object value);
	abstract protected void SelChangeActionStatus() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void RemoveTreatmentSite() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void AddTreatmentSite() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGridTrSiteSelectionChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onGridTrSiteGridComboBoxSelectionChanged(int column, GenForm.GridTrSiteRow row, Object value) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAttendingAsValueSet(Object value);
	abstract protected void oncmbTransportValueSet(Object value);
	abstract protected void oncmbStatusValueSet(Object value);
	abstract protected void oncmbPriorityValueSet(Object value);
	abstract protected void onCmbActionValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void SelChangeActivity() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void SelChangeGroup() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onAnaestheticValueSet(Object value);
	abstract protected void OnCancel() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void OnBtnSave() throws ims.framework.exceptions.PresentationLogicException;

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
				OnFormOpen(args);
			}
		});
		this.form.btnUpdate().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateClick();
			}
		});
		this.form.bOk().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnOk();
			}
		});
		this.form.btnRemoveDose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnRemoveDose();
			}
		});
		this.form.btnAddDose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnAddDose();
			}
		});
		this.form.gDose().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				Dose_SelectionChanged();
			}
		});
		this.form.cmbPlannedRegime().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPlannedRegimeValueSet(value);
			}
		});
		this.form.cmbUnit().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbUnitValueSet(value);
			}
		});
		this.form.cmbModality().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbModalityValueSet(value);
			}
		});
		this.form.cmbCategory().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCategoryValueSet(value);
			}
		});
		this.form.cmbActionStatus().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				SelChangeActionStatus();
			}
		});
		this.form.btnRemoveTrSite().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				RemoveTreatmentSite();
			}
		});
		this.form.btnAddTrSite().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				AddTreatmentSite();
			}
		});
		this.form.GridTrSite().setSelectionChangedEvent(new GridSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onGridTrSiteSelectionChanged();
			}
		});
		this.form.GridTrSite().setGridComboBoxSelectionChangedEvent(new GridComboBoxSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int column, ims.framework.controls.GridRow row, Object value) throws ims.framework.exceptions.PresentationLogicException
			{
				onGridTrSiteGridComboBoxSelectionChanged(column, new GenForm.GridTrSiteRow(row), value);
			}
		});
		this.form.cmbAttendingAs().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAttendingAsValueSet(value);
			}
		});
		this.form.cmbTransport().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbTransportValueSet(value);
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
		this.form.cmbPriority().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPriorityValueSet(value);
			}
		});
		this.form.cmbAction().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbActionValueChanged();
			}
		});
		this.form.cmbActivity().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				SelChangeActivity();
			}
		});
		this.form.cmbGroup().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				SelChangeGroup();
			}
		});
		this.form.Anaesthetic().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				onAnaestheticValueSet(value);
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
		this.form.Save().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				OnBtnSave();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbPlannedRegimeLookup();
		bindcmbUnitLookup();
		bindcmbModalityLookup();
		bindcmbCategoryLookup();
		bindcmbAttendingAsLookup();
		bindcmbTransportLookup();
		bindcmbStatusLookup();
		bindcmbPriorityLookup();
		bindAnaestheticLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbPlannedRegimeLookup();
		bindcmbUnitLookup();
		bindcmbModalityLookup();
		bindcmbCategoryLookup();
		bindcmbAttendingAsLookup();
		bindcmbTransportLookup();
		bindcmbStatusLookup();
		bindcmbPriorityLookup();
		bindAnaestheticLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbPlannedRegimeLookupValue();
		defaultcmbUnitLookupValue();
		defaultcmbModalityLookupValue();
		defaultcmbCategoryLookupValue();
		defaultcmbAttendingAsLookupValue();
		defaultcmbTransportLookupValue();
		defaultcmbStatusLookupValue();
		defaultcmbPriorityLookupValue();
		defaultAnaestheticLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
