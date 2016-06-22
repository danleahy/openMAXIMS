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

package ims.racpc.forms.racpcsymptomandriskfactor;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbAlcoholLookup();
	abstract protected void defaultcmbAlcoholLookupValue();
	abstract protected void bindcmbDiabetesLookup();
	abstract protected void defaultcmbDiabetesLookupValue();
	abstract protected void bindcmbSmokerLookup();
	abstract protected void defaultcmbSmokerLookupValue();
	abstract protected void bindcmbDurationLookup();
	abstract protected void defaultcmbDurationLookupValue();
	abstract protected void bindgrdSymptomscolSympLookup();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkRiskFactorsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAlcoholValueSet(Object value);
	abstract protected void oncmbDiabetesValueSet(Object value);
	abstract protected void oncmbSmokerValueSet(Object value);
	abstract protected void onCmbSmokerValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDurationValueSet(Object value);
	abstract protected void onCmbDurationValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkCardiacSymptomsValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onIntDurationValueChanged() throws ims.framework.exceptions.PresentationLogicException;

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
		this.form.chkRiskFactors().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkRiskFactorsValueChanged();
			}
		});
		this.form.cmbAlcohol().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAlcoholValueSet(value);
			}
		});
		this.form.cmbDiabetes().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDiabetesValueSet(value);
			}
		});
		this.form.cmbSmoker().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbSmokerValueSet(value);
			}
		});
		this.form.cmbSmoker().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbSmokerValueChanged();
			}
		});
		this.form.cmbDuration().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDurationValueSet(value);
			}
		});
		this.form.cmbDuration().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbDurationValueChanged();
			}
		});
		this.form.chkCardiacSymptoms().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkCardiacSymptomsValueChanged();
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
		this.form.intDuration().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onIntDurationValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbAlcoholLookup();
		bindcmbDiabetesLookup();
		bindcmbSmokerLookup();
		bindcmbDurationLookup();
		bindgrdSymptomscolSympLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbAlcoholLookup();
		bindcmbDiabetesLookup();
		bindcmbSmokerLookup();
		bindcmbDurationLookup();
		bindgrdSymptomscolSympLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbAlcoholLookupValue();
		defaultcmbDiabetesLookupValue();
		defaultcmbSmokerLookupValue();
		defaultcmbDurationLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
