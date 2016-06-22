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

package ims.therapies.forms.homevisitrooms;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.HomeVisitRooms.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.HomeVisitRooms domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbUnitValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbUnit().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement existingInstance = (ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUnitLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement)
		{
			ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement instance = (ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUnitLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement existingInstance = (ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbUnit().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUnitLookup()
	{
		this.form.ctnDetails().cmbUnit().clear();
		ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurementCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getDoorWidthUnitOfMeasurement(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbUnit().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUnitLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement instance = ims.spinalinjuries.vo.lookups.LookupHelper.getDoorWidthUnitOfMeasurementInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbUnit().setValue(instance);
	}
	protected final void defaultcmbUnitLookupValue()
	{
		this.form.ctnDetails().cmbUnit().setValue((ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.DoorWidthUnitOfMeasurement.TYPE_ID));
	}
	protected final void oncomboBoxTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().comboBoxType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RoomType existingInstance = (ims.spinalinjuries.vo.lookups.RoomType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RoomType)
		{
			ims.spinalinjuries.vo.lookups.RoomType instance = (ims.spinalinjuries.vo.lookups.RoomType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RoomType existingInstance = (ims.spinalinjuries.vo.lookups.RoomType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().comboBoxType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxTypeLookup()
	{
		this.form.ctnDetails().comboBoxType().clear();
		ims.spinalinjuries.vo.lookups.RoomTypeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRoomType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().comboBoxType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxTypeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RoomType instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRoomTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().comboBoxType().setValue(instance);
	}
	protected final void defaultcomboBoxTypeLookupValue()
	{
		this.form.ctnDetails().comboBoxType().setValue((ims.spinalinjuries.vo.lookups.RoomType)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RoomType.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RoomType.TYPE_ID));
	}
	protected final void oncomboBoxLocationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().comboBoxLocation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RoomLocation existingInstance = (ims.spinalinjuries.vo.lookups.RoomLocation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxLocationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.RoomLocation)
		{
			ims.spinalinjuries.vo.lookups.RoomLocation instance = (ims.spinalinjuries.vo.lookups.RoomLocation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxLocationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.RoomLocation existingInstance = (ims.spinalinjuries.vo.lookups.RoomLocation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().comboBoxLocation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxLocationLookup()
	{
		this.form.ctnDetails().comboBoxLocation().clear();
		ims.spinalinjuries.vo.lookups.RoomLocationCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getRoomLocation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().comboBoxLocation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxLocationLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.RoomLocation instance = ims.spinalinjuries.vo.lookups.LookupHelper.getRoomLocationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().comboBoxLocation().setValue(instance);
	}
	protected final void defaultcomboBoxLocationLookupValue()
	{
		this.form.ctnDetails().comboBoxLocation().setValue((ims.spinalinjuries.vo.lookups.RoomLocation)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.RoomLocation.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.RoomLocation.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.HomeVisitRooms domain;
}
