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

package ims.therapies.forms.hydrotherapy;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.Hydrotherapy.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.Hydrotherapy domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbAssistanceValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAssistance().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance existingInstance = (ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAssistanceLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance)
		{
			ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance instance = (ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAssistanceLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance existingInstance = (ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAssistance().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAssistanceLookup()
	{
		this.form.cmbAssistance().clear();
		ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistanceCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getHydrotherapyLevelOfAssistance(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAssistance().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAssistanceLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance instance = ims.spinalinjuries.vo.lookups.LookupHelper.getHydrotherapyLevelOfAssistanceInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAssistance().setValue(instance);
	}
	protected final void defaultcmbAssistanceLookupValue()
	{
		this.form.cmbAssistance().setValue((ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.HydrotherapyLevelOfAssistance.TYPE_ID));
	}
	protected final void oncmbTransferOutValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTransferOut().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut existingInstance = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTransferOutLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut)
		{
			ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut instance = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTransferOutLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut existingInstance = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTransferOut().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTransferOutLookup()
	{
		this.form.cmbTransferOut().clear();
		ims.spinalinjuries.vo.lookups.HydrotherapyTransferOutCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getHydrotherapyTransferOut(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTransferOut().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTransferOutLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut instance = ims.spinalinjuries.vo.lookups.LookupHelper.getHydrotherapyTransferOutInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTransferOut().setValue(instance);
	}
	protected final void defaultcmbTransferOutLookupValue()
	{
		this.form.cmbTransferOut().setValue((ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.HydrotherapyTransferOut.TYPE_ID));
	}
	protected final void oncmbTransferInValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTransferIn().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn existingInstance = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTransferInLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn)
		{
			ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn instance = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTransferInLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn existingInstance = (ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTransferIn().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTransferInLookup()
	{
		this.form.cmbTransferIn().clear();
		ims.spinalinjuries.vo.lookups.HydrotherapyTransferInCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getHydrotherapyTransferIn(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTransferIn().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTransferInLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn instance = ims.spinalinjuries.vo.lookups.LookupHelper.getHydrotherapyTransferInInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTransferIn().setValue(instance);
	}
	protected final void defaultcmbTransferInLookupValue()
	{
		this.form.cmbTransferIn().setValue((ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.HydrotherapyTransferIn.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.Hydrotherapy domain;
}
