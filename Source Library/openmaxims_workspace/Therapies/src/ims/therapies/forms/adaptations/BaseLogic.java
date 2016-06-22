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

package ims.therapies.forms.adaptations;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.Adaptations.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.Adaptations domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncomboBoxSupplierValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().comboBoxSupplier().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSupplier existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSupplier)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxSupplierLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.EquipmentAdaptationSupplier)
		{
			ims.core.vo.lookups.EquipmentAdaptationSupplier instance = (ims.core.vo.lookups.EquipmentAdaptationSupplier)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxSupplierLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSupplier existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSupplier)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().comboBoxSupplier().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxSupplierLookup()
	{
		this.form.ctnDetail().comboBoxSupplier().clear();
		ims.core.vo.lookups.EquipmentAdaptationSupplierCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSupplier(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().comboBoxSupplier().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxSupplierLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationSupplier instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSupplierInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().comboBoxSupplier().setValue(instance);
	}
	protected final void defaultcomboBoxSupplierLookupValue()
	{
		this.form.ctnDetail().comboBoxSupplier().setValue((ims.core.vo.lookups.EquipmentAdaptationSupplier)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationSupplier.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationSupplier.TYPE_ID));
	}
	protected final void oncomboBoxLoanValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().comboBoxLoan().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationLoan existingInstance = (ims.core.vo.lookups.EquipmentAdaptationLoan)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxLoanLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.EquipmentAdaptationLoan)
		{
			ims.core.vo.lookups.EquipmentAdaptationLoan instance = (ims.core.vo.lookups.EquipmentAdaptationLoan)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxLoanLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationLoan existingInstance = (ims.core.vo.lookups.EquipmentAdaptationLoan)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().comboBoxLoan().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxLoanLookup()
	{
		this.form.ctnDetail().comboBoxLoan().clear();
		ims.core.vo.lookups.EquipmentAdaptationLoanCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationLoan(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().comboBoxLoan().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxLoanLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationLoan instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationLoanInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().comboBoxLoan().setValue(instance);
	}
	protected final void defaultcomboBoxLoanLookupValue()
	{
		this.form.ctnDetail().comboBoxLoan().setValue((ims.core.vo.lookups.EquipmentAdaptationLoan)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationLoan.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationLoan.TYPE_ID));
	}
	protected final void oncomboBoxSuppliedForValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().comboBoxSuppliedFor().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSuppliedFor existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxSuppliedForLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)
		{
			ims.core.vo.lookups.EquipmentAdaptationSuppliedFor instance = (ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxSuppliedForLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSuppliedFor existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().comboBoxSuppliedFor().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxSuppliedForLookup()
	{
		this.form.ctnDetail().comboBoxSuppliedFor().clear();
		ims.core.vo.lookups.EquipmentAdaptationSuppliedForCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSuppliedFor(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().comboBoxSuppliedFor().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxSuppliedForLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationSuppliedFor instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSuppliedForInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().comboBoxSuppliedFor().setValue(instance);
	}
	protected final void defaultcomboBoxSuppliedForLookupValue()
	{
		this.form.ctnDetail().comboBoxSuppliedFor().setValue((ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationSuppliedFor.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationSuppliedFor.TYPE_ID));
	}
	protected final void oncomboBoxFundedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetail().comboBoxFunded().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationsFundedBy existingInstance = (ims.core.vo.lookups.EquipmentAdaptationsFundedBy)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxFundedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.EquipmentAdaptationsFundedBy)
		{
			ims.core.vo.lookups.EquipmentAdaptationsFundedBy instance = (ims.core.vo.lookups.EquipmentAdaptationsFundedBy)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxFundedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationsFundedBy existingInstance = (ims.core.vo.lookups.EquipmentAdaptationsFundedBy)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetail().comboBoxFunded().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxFundedLookup()
	{
		this.form.ctnDetail().comboBoxFunded().clear();
		ims.core.vo.lookups.EquipmentAdaptationsFundedByCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationsFundedBy(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetail().comboBoxFunded().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxFundedLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationsFundedBy instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationsFundedByInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetail().comboBoxFunded().setValue(instance);
	}
	protected final void defaultcomboBoxFundedLookupValue()
	{
		this.form.ctnDetail().comboBoxFunded().setValue((ims.core.vo.lookups.EquipmentAdaptationsFundedBy)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationsFundedBy.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationsFundedBy.TYPE_ID));
	}
	protected final void bindgrdListColSupplierLookup()
	{
		this.form.grdList().ColSupplierComboBox().clear();
		ims.core.vo.lookups.EquipmentAdaptationSupplierCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSupplier(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdList().ColSupplierComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdListColSuppliedforLookup()
	{
		this.form.grdList().ColSuppliedforComboBox().clear();
		ims.core.vo.lookups.EquipmentAdaptationSuppliedForCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSuppliedFor(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdList().ColSuppliedforComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdListColLoanLookup()
	{
		this.form.grdList().ColLoanComboBox().clear();
		ims.core.vo.lookups.EquipmentAdaptationLoanCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationLoan(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdList().ColLoanComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.Adaptations domain;
}
