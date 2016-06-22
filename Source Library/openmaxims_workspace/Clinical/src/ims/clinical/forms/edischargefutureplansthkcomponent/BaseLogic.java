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

package ims.clinical.forms.edischargefutureplansthkcomponent;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.EDischargeFuturePlanSthkComponent.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.clinical.domain.EDischargeFuturePlanSthkComponent domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void setMode(ims.framework.enumerations.FormMode mode)
	{
		form.setMode(mode);
	}
	public ims.framework.enumerations.FormMode getMode()
	{
		return form.getMode();
	}
	protected final void oncmbAdviceapplicableValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAdviceapplicable().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.AdviceApplicatiableForUnit existingInstance = (ims.clinical.vo.lookups.AdviceApplicatiableForUnit)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAdviceapplicableLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.AdviceApplicatiableForUnit)
		{
			ims.clinical.vo.lookups.AdviceApplicatiableForUnit instance = (ims.clinical.vo.lookups.AdviceApplicatiableForUnit)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAdviceapplicableLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.AdviceApplicatiableForUnit existingInstance = (ims.clinical.vo.lookups.AdviceApplicatiableForUnit)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAdviceapplicable().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAdviceapplicableLookup()
	{
		this.form.cmbAdviceapplicable().clear();
		ims.clinical.vo.lookups.AdviceApplicatiableForUnitCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getAdviceApplicatiableForUnit(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAdviceapplicable().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAdviceapplicableLookupValue(int id)
	{
		ims.clinical.vo.lookups.AdviceApplicatiableForUnit instance = ims.clinical.vo.lookups.LookupHelper.getAdviceApplicatiableForUnitInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAdviceapplicable().setValue(instance);
	}
	protected final void defaultcmbAdviceapplicableLookupValue()
	{
		this.form.cmbAdviceapplicable().setValue((ims.clinical.vo.lookups.AdviceApplicatiableForUnit)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.AdviceApplicatiableForUnit.class, engine.getFormName().getID(), ims.clinical.vo.lookups.AdviceApplicatiableForUnit.TYPE_ID));
	}
	protected final void oncmbReturnToWorkAdviceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReturnToWorkAdvice().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReturnToWorkAdvice existingInstance = (ims.clinical.vo.lookups.ReturnToWorkAdvice)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReturnToWorkAdviceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.ReturnToWorkAdvice)
		{
			ims.clinical.vo.lookups.ReturnToWorkAdvice instance = (ims.clinical.vo.lookups.ReturnToWorkAdvice)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReturnToWorkAdviceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.ReturnToWorkAdvice existingInstance = (ims.clinical.vo.lookups.ReturnToWorkAdvice)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReturnToWorkAdvice().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReturnToWorkAdviceLookup()
	{
		this.form.cmbReturnToWorkAdvice().clear();
		ims.clinical.vo.lookups.ReturnToWorkAdviceCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getReturnToWorkAdvice(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReturnToWorkAdvice().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReturnToWorkAdviceLookupValue(int id)
	{
		ims.clinical.vo.lookups.ReturnToWorkAdvice instance = ims.clinical.vo.lookups.LookupHelper.getReturnToWorkAdviceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReturnToWorkAdvice().setValue(instance);
	}
	protected final void defaultcmbReturnToWorkAdviceLookupValue()
	{
		this.form.cmbReturnToWorkAdvice().setValue((ims.clinical.vo.lookups.ReturnToWorkAdvice)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.ReturnToWorkAdvice.class, engine.getFormName().getID(), ims.clinical.vo.lookups.ReturnToWorkAdvice.TYPE_ID));
	}
	protected final void bindgrdFuturePlanColPeriodLookup()
	{
		this.form.grdFuturePlan().ColPeriodComboBox().clear();
		ims.core.vo.lookups.TimeDaystoYearsCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTimeDaystoYears(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdFuturePlan().ColPeriodComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdFuturePlanColSpecLookup()
	{
		this.form.grdFuturePlan().ColSpecComboBox().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdFuturePlan().ColSpecComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.EDischargeFuturePlanSthkComponent domain;
}
