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

package ims.therapies.forms.stretching;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.Stretching.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.Stretching domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbAreaValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnStretching().lyrStretching().tabDetails().cmbArea().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.therapies.vo.lookups.StretchingArea existingInstance = (ims.therapies.vo.lookups.StretchingArea)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAreaLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.therapies.vo.lookups.StretchingArea)
		{
			ims.therapies.vo.lookups.StretchingArea instance = (ims.therapies.vo.lookups.StretchingArea)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAreaLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.therapies.vo.lookups.StretchingArea existingInstance = (ims.therapies.vo.lookups.StretchingArea)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnStretching().lyrStretching().tabDetails().cmbArea().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAreaLookup()
	{
		this.form.ctnStretching().lyrStretching().tabDetails().cmbArea().clear();
		ims.therapies.vo.lookups.StretchingAreaCollection lookupCollection = ims.therapies.vo.lookups.LookupHelper.getStretchingArea(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnStretching().lyrStretching().tabDetails().cmbArea().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAreaLookupValue(int id)
	{
		ims.therapies.vo.lookups.StretchingArea instance = ims.therapies.vo.lookups.LookupHelper.getStretchingAreaInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnStretching().lyrStretching().tabDetails().cmbArea().setValue(instance);
	}
	protected final void defaultcmbAreaLookupValue()
	{
		this.form.ctnStretching().lyrStretching().tabDetails().cmbArea().setValue((ims.therapies.vo.lookups.StretchingArea)domain.getLookupService().getDefaultInstance(ims.therapies.vo.lookups.StretchingArea.class, engine.getFormName().getID(), ims.therapies.vo.lookups.StretchingArea.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.Stretching domain;
}
