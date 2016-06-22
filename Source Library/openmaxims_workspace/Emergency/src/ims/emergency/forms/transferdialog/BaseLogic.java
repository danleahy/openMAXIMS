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

package ims.emergency.forms.transferdialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.TransferDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.TransferDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbTransferEscortValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTransferEscort().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TransferEscort existingInstance = (ims.emergency.vo.lookups.TransferEscort)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTransferEscortLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.TransferEscort)
		{
			ims.emergency.vo.lookups.TransferEscort instance = (ims.emergency.vo.lookups.TransferEscort)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTransferEscortLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TransferEscort existingInstance = (ims.emergency.vo.lookups.TransferEscort)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTransferEscort().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTransferEscortLookup()
	{
		this.form.cmbTransferEscort().clear();
		ims.emergency.vo.lookups.TransferEscortCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getTransferEscort(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTransferEscort().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTransferEscortLookupValue(int id)
	{
		ims.emergency.vo.lookups.TransferEscort instance = ims.emergency.vo.lookups.LookupHelper.getTransferEscortInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTransferEscort().setValue(instance);
	}
	protected final void defaultcmbTransferEscortLookupValue()
	{
		this.form.cmbTransferEscort().setValue((ims.emergency.vo.lookups.TransferEscort)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.TransferEscort.class, engine.getFormName().getID(), ims.emergency.vo.lookups.TransferEscort.TYPE_ID));
	}
	protected final void oncmbHospitalValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbHospital().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TransferToHospital existingInstance = (ims.emergency.vo.lookups.TransferToHospital)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbHospitalLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.TransferToHospital)
		{
			ims.emergency.vo.lookups.TransferToHospital instance = (ims.emergency.vo.lookups.TransferToHospital)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbHospitalLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.TransferToHospital existingInstance = (ims.emergency.vo.lookups.TransferToHospital)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbHospital().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbHospitalLookup()
	{
		this.form.cmbHospital().clear();
		ims.emergency.vo.lookups.TransferToHospitalCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getTransferToHospital(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbHospital().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbHospitalLookupValue(int id)
	{
		ims.emergency.vo.lookups.TransferToHospital instance = ims.emergency.vo.lookups.LookupHelper.getTransferToHospitalInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbHospital().setValue(instance);
	}
	protected final void defaultcmbHospitalLookupValue()
	{
		this.form.cmbHospital().setValue((ims.emergency.vo.lookups.TransferToHospital)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.TransferToHospital.class, engine.getFormName().getID(), ims.emergency.vo.lookups.TransferToHospital.TYPE_ID));
	}
	protected final void oncmbTransferModeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbTransferMode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ModeOfArrival existingInstance = (ims.emergency.vo.lookups.ModeOfArrival)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTransferModeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.ModeOfArrival)
		{
			ims.emergency.vo.lookups.ModeOfArrival instance = (ims.emergency.vo.lookups.ModeOfArrival)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTransferModeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ModeOfArrival existingInstance = (ims.emergency.vo.lookups.ModeOfArrival)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbTransferMode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTransferModeLookup()
	{
		this.form.cmbTransferMode().clear();
		ims.emergency.vo.lookups.ModeOfArrivalCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getModeOfArrival(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbTransferMode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTransferModeLookupValue(int id)
	{
		ims.emergency.vo.lookups.ModeOfArrival instance = ims.emergency.vo.lookups.LookupHelper.getModeOfArrivalInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbTransferMode().setValue(instance);
	}
	protected final void defaultcmbTransferModeLookupValue()
	{
		this.form.cmbTransferMode().setValue((ims.emergency.vo.lookups.ModeOfArrival)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.ModeOfArrival.class, engine.getFormName().getID(), ims.emergency.vo.lookups.ModeOfArrival.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.TransferDialog domain;
}
