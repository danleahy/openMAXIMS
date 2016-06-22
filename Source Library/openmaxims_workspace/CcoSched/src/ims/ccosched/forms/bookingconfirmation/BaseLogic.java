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

package ims.ccosched.forms.bookingconfirmation;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.ccosched.domain.BookingConfirmation.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.ccosched.domain.BookingConfirmation domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindMainGridTransportLookup()
	{
		this.form.MainGrid().TransportComboBox().clear();
		ims.ccosched.vo.lookups.TransportCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getTransport(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.MainGrid().TransportComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void onPatientStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.PatientStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Status existingInstance = (ims.ccosched.vo.lookups.Status)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindPatientStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Status)
		{
			ims.ccosched.vo.lookups.Status instance = (ims.ccosched.vo.lookups.Status)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindPatientStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Status existingInstance = (ims.ccosched.vo.lookups.Status)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.PatientStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindPatientStatusLookup()
	{
		this.form.PatientStatus().clear();
		ims.ccosched.vo.lookups.StatusCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.PatientStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setPatientStatusLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Status instance = ims.ccosched.vo.lookups.LookupHelper.getStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.PatientStatus().setValue(instance);
	}
	protected final void defaultPatientStatusLookupValue()
	{
		this.form.PatientStatus().setValue((ims.ccosched.vo.lookups.Status)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Status.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Status.TYPE_ID));
	}
	protected final void bindSpecialRequirementsRequirementLookup()
	{
		this.form.SpecialRequirements().RequirementComboBox().clear();
		ims.ccosched.vo.lookups.RequirementsCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getRequirements(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.SpecialRequirements().RequirementComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void onPriorityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.Priority().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Priority existingInstance = (ims.ccosched.vo.lookups.Priority)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindPriorityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Priority)
		{
			ims.ccosched.vo.lookups.Priority instance = (ims.ccosched.vo.lookups.Priority)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindPriorityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Priority existingInstance = (ims.ccosched.vo.lookups.Priority)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.Priority().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindPriorityLookup()
	{
		this.form.Priority().clear();
		ims.ccosched.vo.lookups.PriorityCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getPriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.Priority().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setPriorityLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Priority instance = ims.ccosched.vo.lookups.LookupHelper.getPriorityInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.Priority().setValue(instance);
	}
	protected final void defaultPriorityLookupValue()
	{
		this.form.Priority().setValue((ims.ccosched.vo.lookups.Priority)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Priority.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Priority.TYPE_ID));
	}
	protected final void onConfirmationStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ConfirmationStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.ConfirmationStatus existingInstance = (ims.ccosched.vo.lookups.ConfirmationStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindConfirmationStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.ConfirmationStatus)
		{
			ims.ccosched.vo.lookups.ConfirmationStatus instance = (ims.ccosched.vo.lookups.ConfirmationStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindConfirmationStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.ConfirmationStatus existingInstance = (ims.ccosched.vo.lookups.ConfirmationStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ConfirmationStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindConfirmationStatusLookup()
	{
		this.form.ConfirmationStatus().clear();
		ims.ccosched.vo.lookups.ConfirmationStatusCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getConfirmationStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ConfirmationStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setConfirmationStatusLookupValue(int id)
	{
		ims.ccosched.vo.lookups.ConfirmationStatus instance = ims.ccosched.vo.lookups.LookupHelper.getConfirmationStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ConfirmationStatus().setValue(instance);
	}
	protected final void defaultConfirmationStatusLookupValue()
	{
		this.form.ConfirmationStatus().setValue((ims.ccosched.vo.lookups.ConfirmationStatus)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.ConfirmationStatus.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.ConfirmationStatus.TYPE_ID));
	}
	protected final void onBookingSystemTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.BookingSystemType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.BookingSystemType existingInstance = (ims.ccosched.vo.lookups.BookingSystemType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindBookingSystemTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.BookingSystemType)
		{
			ims.ccosched.vo.lookups.BookingSystemType instance = (ims.ccosched.vo.lookups.BookingSystemType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindBookingSystemTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.BookingSystemType existingInstance = (ims.ccosched.vo.lookups.BookingSystemType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.BookingSystemType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindBookingSystemTypeLookup()
	{
		this.form.BookingSystemType().clear();
		ims.ccosched.vo.lookups.BookingSystemTypeCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getBookingSystemType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.BookingSystemType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setBookingSystemTypeLookupValue(int id)
	{
		ims.ccosched.vo.lookups.BookingSystemType instance = ims.ccosched.vo.lookups.LookupHelper.getBookingSystemTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.BookingSystemType().setValue(instance);
	}
	protected final void defaultBookingSystemTypeLookupValue()
	{
		this.form.BookingSystemType().setValue((ims.ccosched.vo.lookups.BookingSystemType)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.BookingSystemType.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.BookingSystemType.TYPE_ID));
	}
	protected final void onTransportListValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.TransportList().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Transport existingInstance = (ims.ccosched.vo.lookups.Transport)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindTransportListLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ccosched.vo.lookups.Transport)
		{
			ims.ccosched.vo.lookups.Transport instance = (ims.ccosched.vo.lookups.Transport)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindTransportListLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ccosched.vo.lookups.Transport existingInstance = (ims.ccosched.vo.lookups.Transport)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.TransportList().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindTransportListLookup()
	{
		this.form.TransportList().clear();
		ims.ccosched.vo.lookups.TransportCollection lookupCollection = ims.ccosched.vo.lookups.LookupHelper.getTransport(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.TransportList().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setTransportListLookupValue(int id)
	{
		ims.ccosched.vo.lookups.Transport instance = ims.ccosched.vo.lookups.LookupHelper.getTransportInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.TransportList().setValue(instance);
	}
	protected final void defaultTransportListLookupValue()
	{
		this.form.TransportList().setValue((ims.ccosched.vo.lookups.Transport)domain.getLookupService().getDefaultInstance(ims.ccosched.vo.lookups.Transport.class, engine.getFormName().getID(), ims.ccosched.vo.lookups.Transport.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.ccosched.domain.BookingConfirmation domain;
}
