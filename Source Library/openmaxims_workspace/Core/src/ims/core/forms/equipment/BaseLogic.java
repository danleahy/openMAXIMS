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

package ims.core.forms.equipment;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.Equipment.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.Equipment domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbFundedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbFunded().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationsFundedBy existingInstance = (ims.core.vo.lookups.EquipmentAdaptationsFundedBy)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFundedLookup();
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
					bindcmbFundedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationsFundedBy existingInstance = (ims.core.vo.lookups.EquipmentAdaptationsFundedBy)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbFunded().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFundedLookup()
	{
		this.form.ctnDetails().cmbFunded().clear();
		ims.core.vo.lookups.EquipmentAdaptationsFundedByCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationsFundedBy(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbFunded().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFundedLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationsFundedBy instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationsFundedByInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbFunded().setValue(instance);
	}
	protected final void defaultcmbFundedLookupValue()
	{
		this.form.ctnDetails().cmbFunded().setValue((ims.core.vo.lookups.EquipmentAdaptationsFundedBy)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationsFundedBy.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationsFundedBy.TYPE_ID));
	}
	protected final void oncmbLoanValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbLoan().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationLoan existingInstance = (ims.core.vo.lookups.EquipmentAdaptationLoan)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLoanLookup();
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
					bindcmbLoanLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationLoan existingInstance = (ims.core.vo.lookups.EquipmentAdaptationLoan)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbLoan().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLoanLookup()
	{
		this.form.ctnDetails().cmbLoan().clear();
		ims.core.vo.lookups.EquipmentAdaptationLoanCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationLoan(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbLoan().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLoanLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationLoan instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationLoanInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbLoan().setValue(instance);
	}
	protected final void defaultcmbLoanLookupValue()
	{
		this.form.ctnDetails().cmbLoan().setValue((ims.core.vo.lookups.EquipmentAdaptationLoan)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationLoan.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationLoan.TYPE_ID));
	}
	protected final void oncmbSuppliedForValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbSuppliedFor().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSuppliedFor existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSuppliedForLookup();
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
					bindcmbSuppliedForLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSuppliedFor existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbSuppliedFor().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSuppliedForLookup()
	{
		this.form.ctnDetails().cmbSuppliedFor().clear();
		ims.core.vo.lookups.EquipmentAdaptationSuppliedForCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSuppliedFor(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbSuppliedFor().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSuppliedForLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationSuppliedFor instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSuppliedForInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbSuppliedFor().setValue(instance);
	}
	protected final void defaultcmbSuppliedForLookupValue()
	{
		this.form.ctnDetails().cmbSuppliedFor().setValue((ims.core.vo.lookups.EquipmentAdaptationSuppliedFor)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationSuppliedFor.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationSuppliedFor.TYPE_ID));
	}
	protected final void oncmbSupplierValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbSupplier().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSupplier existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSupplier)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSupplierLookup();
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
					bindcmbSupplierLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.EquipmentAdaptationSupplier existingInstance = (ims.core.vo.lookups.EquipmentAdaptationSupplier)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbSupplier().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSupplierLookup()
	{
		this.form.ctnDetails().cmbSupplier().clear();
		ims.core.vo.lookups.EquipmentAdaptationSupplierCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSupplier(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbSupplier().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSupplierLookupValue(int id)
	{
		ims.core.vo.lookups.EquipmentAdaptationSupplier instance = ims.core.vo.lookups.LookupHelper.getEquipmentAdaptationSupplierInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbSupplier().setValue(instance);
	}
	protected final void defaultcmbSupplierLookupValue()
	{
		this.form.ctnDetails().cmbSupplier().setValue((ims.core.vo.lookups.EquipmentAdaptationSupplier)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.EquipmentAdaptationSupplier.class, engine.getFormName().getID(), ims.core.vo.lookups.EquipmentAdaptationSupplier.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.Equipment domain;
}
