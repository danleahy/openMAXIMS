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

package ims.emergency.forms.dischargedetails_advicetransport;

public abstract class BaseLogic extends Handlers implements IComponent
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.DischargeDetails_AdviceTransport.class;
	}
	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form, ims.emergency.domain.DischargeDetails_AdviceTransport domain)
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
	protected final void oncmbTransportTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTransportType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ApptTransportType existingInstance = (ims.scheduling.vo.lookups.ApptTransportType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTransportTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.ApptTransportType)
		{
			ims.scheduling.vo.lookups.ApptTransportType instance = (ims.scheduling.vo.lookups.ApptTransportType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTransportTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ApptTransportType existingInstance = (ims.scheduling.vo.lookups.ApptTransportType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTransportType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTransportTypeLookup()
	{
		this.form.cmbTransportType().clear();
		ims.scheduling.vo.lookups.ApptTransportTypeCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getApptTransportType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTransportType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTransportTypeLookupValue(int id)
	{
		ims.scheduling.vo.lookups.ApptTransportType instance = ims.scheduling.vo.lookups.LookupHelper.getApptTransportTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTransportType().setValue(instance);
	}
	protected final void defaultcmbTransportTypeLookupValue()
	{
		this.form.cmbTransportType().setValue((ims.scheduling.vo.lookups.ApptTransportType)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.ApptTransportType.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.ApptTransportType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.DischargeDetails_AdviceTransport domain;
}
