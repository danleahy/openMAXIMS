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

package ims.emergency.forms.edpartialadmissiondialog;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.EDPartialAdmissionDialog.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.EDPartialAdmissionDialog domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbAccomodationTypeRequestedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAccomodationTypeRequested().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AccomodationRequestedType existingInstance = (ims.core.vo.lookups.AccomodationRequestedType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAccomodationTypeRequestedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.AccomodationRequestedType)
		{
			ims.core.vo.lookups.AccomodationRequestedType instance = (ims.core.vo.lookups.AccomodationRequestedType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAccomodationTypeRequestedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.AccomodationRequestedType existingInstance = (ims.core.vo.lookups.AccomodationRequestedType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAccomodationTypeRequested().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAccomodationTypeRequestedLookup()
	{
		this.form.cmbAccomodationTypeRequested().clear();
		ims.core.vo.lookups.AccomodationRequestedTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getAccomodationRequestedType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAccomodationTypeRequested().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAccomodationTypeRequestedLookupValue(int id)
	{
		ims.core.vo.lookups.AccomodationRequestedType instance = ims.core.vo.lookups.LookupHelper.getAccomodationRequestedTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAccomodationTypeRequested().setValue(instance);
	}
	protected final void defaultcmbAccomodationTypeRequestedLookupValue()
	{
		this.form.cmbAccomodationTypeRequested().setValue((ims.core.vo.lookups.AccomodationRequestedType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.AccomodationRequestedType.class, engine.getFormName().getID(), ims.core.vo.lookups.AccomodationRequestedType.TYPE_ID));
	}
	protected final void oncmbPatientStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPatientStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.PatientAttendanceStatus existingInstance = (ims.emergency.vo.lookups.PatientAttendanceStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPatientStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.PatientAttendanceStatus)
		{
			ims.emergency.vo.lookups.PatientAttendanceStatus instance = (ims.emergency.vo.lookups.PatientAttendanceStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPatientStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.PatientAttendanceStatus existingInstance = (ims.emergency.vo.lookups.PatientAttendanceStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPatientStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPatientStatusLookup()
	{
		this.form.cmbPatientStatus().clear();
		ims.emergency.vo.lookups.PatientAttendanceStatusCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getPatientAttendanceStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPatientStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPatientStatusLookupValue(int id)
	{
		ims.emergency.vo.lookups.PatientAttendanceStatus instance = ims.emergency.vo.lookups.LookupHelper.getPatientAttendanceStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPatientStatus().setValue(instance);
	}
	protected final void defaultcmbPatientStatusLookupValue()
	{
		this.form.cmbPatientStatus().setValue((ims.emergency.vo.lookups.PatientAttendanceStatus)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.PatientAttendanceStatus.class, engine.getFormName().getID(), ims.emergency.vo.lookups.PatientAttendanceStatus.TYPE_ID));
	}
	protected final void oncmbAdmissionStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAdmissionStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.AllocationStatus existingInstance = (ims.emergency.vo.lookups.AllocationStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAdmissionStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.AllocationStatus)
		{
			ims.emergency.vo.lookups.AllocationStatus instance = (ims.emergency.vo.lookups.AllocationStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAdmissionStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.AllocationStatus existingInstance = (ims.emergency.vo.lookups.AllocationStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAdmissionStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAdmissionStatusLookup()
	{
		this.form.cmbAdmissionStatus().clear();
		ims.emergency.vo.lookups.AllocationStatusCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getAllocationStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAdmissionStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAdmissionStatusLookupValue(int id)
	{
		ims.emergency.vo.lookups.AllocationStatus instance = ims.emergency.vo.lookups.LookupHelper.getAllocationStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAdmissionStatus().setValue(instance);
	}
	protected final void defaultcmbAdmissionStatusLookupValue()
	{
		this.form.cmbAdmissionStatus().setValue((ims.emergency.vo.lookups.AllocationStatus)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.AllocationStatus.class, engine.getFormName().getID(), ims.emergency.vo.lookups.AllocationStatus.TYPE_ID));
	}
	protected final void oncmbSpecialtyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSpecialty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSpecialtyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Specialty)
		{
			ims.core.vo.lookups.Specialty instance = (ims.core.vo.lookups.Specialty)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSpecialtyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Specialty existingInstance = (ims.core.vo.lookups.Specialty)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSpecialty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSpecialtyLookup()
	{
		this.form.cmbSpecialty().clear();
		ims.core.vo.lookups.SpecialtyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSpecialty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSpecialty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSpecialtyLookupValue(int id)
	{
		ims.core.vo.lookups.Specialty instance = ims.core.vo.lookups.LookupHelper.getSpecialtyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSpecialty().setValue(instance);
	}
	protected final void defaultcmbSpecialtyLookupValue()
	{
		this.form.cmbSpecialty().setValue((ims.core.vo.lookups.Specialty)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Specialty.class, engine.getFormName().getID(), ims.core.vo.lookups.Specialty.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.EDPartialAdmissionDialog domain;
}
