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

package ims.clinical.forms.hcgdialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.clinical.domain.HCGDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.clinical.domain.HCGDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbSerumHCGValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSerumHCG().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.HCGResults existingInstance = (ims.emergency.vo.lookups.HCGResults)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSerumHCGLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.HCGResults)
		{
			ims.emergency.vo.lookups.HCGResults instance = (ims.emergency.vo.lookups.HCGResults)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSerumHCGLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.HCGResults existingInstance = (ims.emergency.vo.lookups.HCGResults)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSerumHCG().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSerumHCGLookup()
	{
		this.form.cmbSerumHCG().clear();
		ims.emergency.vo.lookups.HCGResultsCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getHCGResults(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSerumHCG().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSerumHCGLookupValue(int id)
	{
		ims.emergency.vo.lookups.HCGResults instance = ims.emergency.vo.lookups.LookupHelper.getHCGResultsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSerumHCG().setValue(instance);
	}
	protected final void defaultcmbSerumHCGLookupValue()
	{
		this.form.cmbSerumHCG().setValue((ims.emergency.vo.lookups.HCGResults)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.HCGResults.class, engine.getFormName().getID(), ims.emergency.vo.lookups.HCGResults.TYPE_ID));
	}
	protected final void oncmbUrineHCGValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbUrineHCG().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.HCGResults existingInstance = (ims.emergency.vo.lookups.HCGResults)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUrineHCGLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.HCGResults)
		{
			ims.emergency.vo.lookups.HCGResults instance = (ims.emergency.vo.lookups.HCGResults)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUrineHCGLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.HCGResults existingInstance = (ims.emergency.vo.lookups.HCGResults)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbUrineHCG().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUrineHCGLookup()
	{
		this.form.cmbUrineHCG().clear();
		ims.emergency.vo.lookups.HCGResultsCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getHCGResults(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbUrineHCG().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUrineHCGLookupValue(int id)
	{
		ims.emergency.vo.lookups.HCGResults instance = ims.emergency.vo.lookups.LookupHelper.getHCGResultsInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbUrineHCG().setValue(instance);
	}
	protected final void defaultcmbUrineHCGLookupValue()
	{
		this.form.cmbUrineHCG().setValue((ims.emergency.vo.lookups.HCGResults)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.HCGResults.class, engine.getFormName().getID(), ims.emergency.vo.lookups.HCGResults.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.clinical.domain.HCGDialog domain;
}
