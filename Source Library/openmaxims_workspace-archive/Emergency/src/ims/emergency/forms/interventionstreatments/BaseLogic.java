//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.emergency.forms.interventionstreatments;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.InterventionsTreatments.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.InterventionsTreatments domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTreatmentTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTreatmentType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TreatmentInterventionType existingInstance = (ims.clinical.vo.lookups.TreatmentInterventionType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTreatmentTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.clinical.vo.lookups.TreatmentInterventionType)
		{
			ims.clinical.vo.lookups.TreatmentInterventionType instance = (ims.clinical.vo.lookups.TreatmentInterventionType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTreatmentTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.clinical.vo.lookups.TreatmentInterventionType existingInstance = (ims.clinical.vo.lookups.TreatmentInterventionType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTreatmentType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTreatmentTypeLookup()
	{
		this.form.cmbTreatmentType().clear();
		ims.clinical.vo.lookups.TreatmentInterventionTypeCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getTreatmentInterventionType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTreatmentType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTreatmentTypeLookupValue(int id)
	{
		ims.clinical.vo.lookups.TreatmentInterventionType instance = ims.clinical.vo.lookups.LookupHelper.getTreatmentInterventionTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTreatmentType().setValue(instance);
	}
	protected final void defaultcmbTreatmentTypeLookupValue()
	{
		this.form.cmbTreatmentType().setValue((ims.clinical.vo.lookups.TreatmentInterventionType)domain.getLookupService().getDefaultInstance(ims.clinical.vo.lookups.TreatmentInterventionType.class, engine.getFormName().getID(), ims.clinical.vo.lookups.TreatmentInterventionType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.InterventionsTreatments domain;
}