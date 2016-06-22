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

package ims.scheduling.forms.sessiondetailsedit;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.scheduling.domain.SessionDetailsEdit.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.scheduling.domain.SessionDetailsEdit domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.Session_Status_and_Reason existingInstance = (ims.scheduling.vo.lookups.Session_Status_and_Reason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.Session_Status_and_Reason)
		{
			ims.scheduling.vo.lookups.Session_Status_and_Reason instance = (ims.scheduling.vo.lookups.Session_Status_and_Reason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.Session_Status_and_Reason existingInstance = (ims.scheduling.vo.lookups.Session_Status_and_Reason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.cmbStatus().clear();
		ims.scheduling.vo.lookups.Session_Status_and_ReasonCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getSession_Status_and_Reason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.scheduling.vo.lookups.Session_Status_and_Reason instance = ims.scheduling.vo.lookups.LookupHelper.getSession_Status_and_ReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.scheduling.vo.lookups.Session_Status_and_Reason)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.Session_Status_and_Reason.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.Session_Status_and_Reason.TYPE_ID));
	}
	protected final void oncmbConsMediaValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrSessEdit().tabGeneral().cmbConsMedia().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ConsultationMediaType existingInstance = (ims.scheduling.vo.lookups.ConsultationMediaType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbConsMediaLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.ConsultationMediaType)
		{
			ims.scheduling.vo.lookups.ConsultationMediaType instance = (ims.scheduling.vo.lookups.ConsultationMediaType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbConsMediaLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ConsultationMediaType existingInstance = (ims.scheduling.vo.lookups.ConsultationMediaType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrSessEdit().tabGeneral().cmbConsMedia().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbConsMediaLookup()
	{
		this.form.lyrSessEdit().tabGeneral().cmbConsMedia().clear();
		ims.scheduling.vo.lookups.ConsultationMediaTypeCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getConsultationMediaType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrSessEdit().tabGeneral().cmbConsMedia().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbConsMediaLookupValue(int id)
	{
		ims.scheduling.vo.lookups.ConsultationMediaType instance = ims.scheduling.vo.lookups.LookupHelper.getConsultationMediaTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrSessEdit().tabGeneral().cmbConsMedia().setValue(instance);
	}
	protected final void defaultcmbConsMediaLookupValue()
	{
		this.form.lyrSessEdit().tabGeneral().cmbConsMedia().setValue((ims.scheduling.vo.lookups.ConsultationMediaType)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.ConsultationMediaType.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.ConsultationMediaType.TYPE_ID));
	}
	protected final void oncmbListTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrSessEdit().tabListOwners().cmbListType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ProfileListType existingInstance = (ims.scheduling.vo.lookups.ProfileListType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbListTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.ProfileListType)
		{
			ims.scheduling.vo.lookups.ProfileListType instance = (ims.scheduling.vo.lookups.ProfileListType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbListTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.ProfileListType existingInstance = (ims.scheduling.vo.lookups.ProfileListType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrSessEdit().tabListOwners().cmbListType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbListTypeLookup()
	{
		this.form.lyrSessEdit().tabListOwners().cmbListType().clear();
		ims.scheduling.vo.lookups.ProfileListTypeCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getProfileListType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrSessEdit().tabListOwners().cmbListType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbListTypeLookupValue(int id)
	{
		ims.scheduling.vo.lookups.ProfileListType instance = ims.scheduling.vo.lookups.LookupHelper.getProfileListTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrSessEdit().tabListOwners().cmbListType().setValue(instance);
	}
	protected final void defaultcmbListTypeLookupValue()
	{
		this.form.lyrSessEdit().tabListOwners().cmbListType().setValue((ims.scheduling.vo.lookups.ProfileListType)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.ProfileListType.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.ProfileListType.TYPE_ID));
	}
	protected final void bindgrdSlotscolPriorityLookup()
	{
		this.form.lyrSessEdit().tabSlotDetails().grdSlots().colPriorityComboBox().clear();
		ims.scheduling.vo.lookups.SchedulingPriorityCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getSchedulingPriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrSessEdit().tabSlotDetails().grdSlots().colPriorityComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdSlotsFlexibleColPriorityLookup()
	{
		this.form.lyrSessEdit().tabActivitiesWithSlots().grdSlotsFlexible().ColPriorityComboBox().clear();
		ims.scheduling.vo.lookups.SchedulingPriorityCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getSchedulingPriority(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrSessEdit().tabActivitiesWithSlots().grdSlotsFlexible().ColPriorityComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.scheduling.domain.SessionDetailsEdit domain;
}
