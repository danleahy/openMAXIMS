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

package ims.oncology.forms.teletherapyplanning;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.oncology.domain.TeletherapyPlanning.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.oncology.domain.TeletherapyPlanning domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncomboBox1ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBox1().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBox1Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBox1Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBox1().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBox1Lookup()
	{
		this.form.comboBox1().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBox1().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBox1LookupValue(int id)
	{
		ims.core.vo.lookups.YesNo instance = ims.core.vo.lookups.LookupHelper.getYesNoInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBox1().setValue(instance);
	}
	protected final void defaultcomboBox1LookupValue()
	{
		this.form.comboBox1().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void oncomboBox2ValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.comboBox2().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBox2Lookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNo)
		{
			ims.core.vo.lookups.YesNo instance = (ims.core.vo.lookups.YesNo)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBox2Lookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.comboBox2().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBox2Lookup()
	{
		this.form.comboBox2().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.comboBox2().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBox2LookupValue(int id)
	{
		ims.core.vo.lookups.YesNo instance = ims.core.vo.lookups.LookupHelper.getYesNoInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.comboBox2().setValue(instance);
	}
	protected final void defaultcomboBox2LookupValue()
	{
		this.form.comboBox2().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.oncology.domain.TeletherapyPlanning domain;
}
