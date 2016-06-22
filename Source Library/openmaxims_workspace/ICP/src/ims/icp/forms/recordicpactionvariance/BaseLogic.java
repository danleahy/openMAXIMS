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

package ims.icp.forms.recordicpactionvariance;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.icp.domain.RecordICPActionVariance.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.icp.domain.RecordICPActionVariance domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbVarianceTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbVarianceType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.icp.vo.lookups.ICPVarianceType existingInstance = (ims.icp.vo.lookups.ICPVarianceType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbVarianceTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.icp.vo.lookups.ICPVarianceType)
		{
			ims.icp.vo.lookups.ICPVarianceType instance = (ims.icp.vo.lookups.ICPVarianceType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbVarianceTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.icp.vo.lookups.ICPVarianceType existingInstance = (ims.icp.vo.lookups.ICPVarianceType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbVarianceType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbVarianceTypeLookup()
	{
		this.form.cmbVarianceType().clear();
		ims.icp.vo.lookups.ICPVarianceTypeCollection lookupCollection = ims.icp.vo.lookups.LookupHelper.getICPVarianceType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbVarianceType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbVarianceTypeLookupValue(int id)
	{
		ims.icp.vo.lookups.ICPVarianceType instance = ims.icp.vo.lookups.LookupHelper.getICPVarianceTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbVarianceType().setValue(instance);
	}
	protected final void defaultcmbVarianceTypeLookupValue()
	{
		this.form.cmbVarianceType().setValue((ims.icp.vo.lookups.ICPVarianceType)domain.getLookupService().getDefaultInstance(ims.icp.vo.lookups.ICPVarianceType.class, engine.getFormName().getID(), ims.icp.vo.lookups.ICPVarianceType.TYPE_ID));
	}
	protected final void oncmbVarianceCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbVarianceCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.icp.vo.lookups.ICPVarianceType existingInstance = (ims.icp.vo.lookups.ICPVarianceType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbVarianceCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.icp.vo.lookups.ICPVarianceType)
		{
			ims.icp.vo.lookups.ICPVarianceType instance = (ims.icp.vo.lookups.ICPVarianceType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbVarianceCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.icp.vo.lookups.ICPVarianceType existingInstance = (ims.icp.vo.lookups.ICPVarianceType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbVarianceCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbVarianceCategoryLookup()
	{
		this.form.cmbVarianceCategory().clear();
		ims.icp.vo.lookups.ICPVarianceTypeCollection lookupCollection = ims.icp.vo.lookups.LookupHelper.getICPVarianceType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbVarianceCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbVarianceCategoryLookupValue(int id)
	{
		ims.icp.vo.lookups.ICPVarianceType instance = ims.icp.vo.lookups.LookupHelper.getICPVarianceTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbVarianceCategory().setValue(instance);
	}
	protected final void defaultcmbVarianceCategoryLookupValue()
	{
		this.form.cmbVarianceCategory().setValue((ims.icp.vo.lookups.ICPVarianceType)domain.getLookupService().getDefaultInstance(ims.icp.vo.lookups.ICPVarianceType.class, engine.getFormName().getID(), ims.icp.vo.lookups.ICPVarianceType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.icp.domain.RecordICPActionVariance domain;
}
