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

package ims.emergency.forms.tiigdialog;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbPatientPreviouslyLookup();
	abstract protected void defaultcmbPatientPreviouslyLookupValue();
	abstract protected void bindcmbGenderOfAttackerLookup();
	abstract protected void defaultcmbGenderOfAttackerLookupValue();
	abstract protected void bindcmbNumberOfAttackersLookup();
	abstract protected void defaultcmbNumberOfAttackersLookupValue();
	abstract protected void bindcmbAttackerHadConsumedAlcoholLookup();
	abstract protected void defaultcmbAttackerHadConsumedAlcoholLookupValue();
	abstract protected void bindcmbDrinkPriorIncidentLookup();
	abstract protected void defaultcmbDrinkPriorIncidentLookupValue();
	abstract protected void bindcmbIntendedToInformPoliceLookup();
	abstract protected void defaultcmbIntendedToInformPoliceLookupValue();
	abstract protected void bindcmbRelationshipToAttackerLookup();
	abstract protected void defaultcmbRelationshipToAttackerLookupValue();
	abstract protected void bindcmbAssaultLocationLookup();
	abstract protected void defaultcmbAssaultLocationLookupValue();
	abstract protected void bindcmbAssaultWeaponLookup();
	abstract protected void defaultcmbAssaultWeaponLookupValue();
	abstract protected void bindcmbIncidentLocationLookup();
	abstract protected void defaultcmbIncidentLocationLookupValue();
	abstract protected void bindcmbHadPatientConsumedAlcoholLookup();
	abstract protected void defaultcmbHadPatientConsumedAlcoholLookupValue();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbPatientPreviouslyValueSet(Object value);
	abstract protected void oncmbGenderOfAttackerValueSet(Object value);
	abstract protected void oncmbNumberOfAttackersValueSet(Object value);
	abstract protected void oncmbAttackerHadConsumedAlcoholValueSet(Object value);
	abstract protected void oncmbDrinkPriorIncidentValueSet(Object value);
	abstract protected void onCmbDrinkPriorIncidentValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIntendedToInformPoliceValueSet(Object value);
	abstract protected void oncmbRelationshipToAttackerValueSet(Object value);
	abstract protected void oncmbAssaultLocationValueSet(Object value);
	abstract protected void onCmbAssaultLocationValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAssaultWeaponValueSet(Object value);
	abstract protected void onCmbAssaultWeaponValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIncidentLocationValueSet(Object value);
	abstract protected void oncmbHadPatientConsumedAlcoholValueSet(Object value);

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
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
		this.form.btnOK().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOKClick();
			}
		});
		this.form.cmbPatientPreviously().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbPatientPreviouslyValueSet(value);
			}
		});
		this.form.cmbGenderOfAttacker().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbGenderOfAttackerValueSet(value);
			}
		});
		this.form.cmbNumberOfAttackers().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbNumberOfAttackersValueSet(value);
			}
		});
		this.form.cmbAttackerHadConsumedAlcohol().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAttackerHadConsumedAlcoholValueSet(value);
			}
		});
		this.form.cmbDrinkPriorIncident().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDrinkPriorIncidentValueSet(value);
			}
		});
		this.form.cmbDrinkPriorIncident().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbDrinkPriorIncidentValueChanged();
			}
		});
		this.form.cmbIntendedToInformPolice().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIntendedToInformPoliceValueSet(value);
			}
		});
		this.form.cmbRelationshipToAttacker().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbRelationshipToAttackerValueSet(value);
			}
		});
		this.form.cmbAssaultLocation().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAssaultLocationValueSet(value);
			}
		});
		this.form.cmbAssaultLocation().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbAssaultLocationValueChanged();
			}
		});
		this.form.cmbAssaultWeapon().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAssaultWeaponValueSet(value);
			}
		});
		this.form.cmbAssaultWeapon().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbAssaultWeaponValueChanged();
			}
		});
		this.form.cmbIncidentLocation().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIncidentLocationValueSet(value);
			}
		});
		this.form.cmbHadPatientConsumedAlcohol().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbHadPatientConsumedAlcoholValueSet(value);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbPatientPreviouslyLookup();
		bindcmbGenderOfAttackerLookup();
		bindcmbNumberOfAttackersLookup();
		bindcmbAttackerHadConsumedAlcoholLookup();
		bindcmbDrinkPriorIncidentLookup();
		bindcmbIntendedToInformPoliceLookup();
		bindcmbRelationshipToAttackerLookup();
		bindcmbAssaultLocationLookup();
		bindcmbAssaultWeaponLookup();
		bindcmbIncidentLocationLookup();
		bindcmbHadPatientConsumedAlcoholLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbPatientPreviouslyLookup();
		bindcmbGenderOfAttackerLookup();
		bindcmbNumberOfAttackersLookup();
		bindcmbAttackerHadConsumedAlcoholLookup();
		bindcmbDrinkPriorIncidentLookup();
		bindcmbIntendedToInformPoliceLookup();
		bindcmbRelationshipToAttackerLookup();
		bindcmbAssaultLocationLookup();
		bindcmbAssaultWeaponLookup();
		bindcmbIncidentLocationLookup();
		bindcmbHadPatientConsumedAlcoholLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbPatientPreviouslyLookupValue();
		defaultcmbGenderOfAttackerLookupValue();
		defaultcmbNumberOfAttackersLookupValue();
		defaultcmbAttackerHadConsumedAlcoholLookupValue();
		defaultcmbDrinkPriorIncidentLookupValue();
		defaultcmbIntendedToInformPoliceLookupValue();
		defaultcmbRelationshipToAttackerLookupValue();
		defaultcmbAssaultLocationLookupValue();
		defaultcmbAssaultWeaponLookupValue();
		defaultcmbIncidentLocationLookupValue();
		defaultcmbHadPatientConsumedAlcoholLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
