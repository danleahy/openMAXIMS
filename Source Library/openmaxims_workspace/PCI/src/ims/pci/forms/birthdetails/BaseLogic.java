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

package ims.pci.forms.birthdetails;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pci.domain.BirthDetails.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pci.domain.BirthDetails domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansStillbornValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansStillborn().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansStillbornLookup();
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
					bindansStillbornLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNo existingInstance = (ims.core.vo.lookups.YesNo)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansStillborn().addOption(instance);
		}
	}
	protected final void bindansStillbornLookup()
	{
		this.form.ansStillborn().clear();
		ims.core.vo.lookups.YesNoCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNo(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansStillborn().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansStillbornLookupValue()
	{
		this.form.ansStillborn().setValue((ims.core.vo.lookups.YesNo)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNo.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNo.TYPE_ID));
	}
	protected final void onansPKUTestValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansPKUTest().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansPKUTestLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansPKUTestLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansPKUTest().addOption(instance);
		}
	}
	protected final void bindansPKUTestLookup()
	{
		this.form.ansPKUTest().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansPKUTest().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansPKUTestLookupValue()
	{
		this.form.ansPKUTest().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onansEpisiotomyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansEpisiotomy().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansEpisiotomyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansEpisiotomyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansEpisiotomy().addOption(instance);
		}
	}
	protected final void bindansEpisiotomyLookup()
	{
		this.form.ansEpisiotomy().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansEpisiotomy().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansEpisiotomyLookupValue()
	{
		this.form.ansEpisiotomy().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbDeliveryMethodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDeliveryMethod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.DeliveryMethodBirth existingInstance = (ims.pci.vo.lookups.DeliveryMethodBirth)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDeliveryMethodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.DeliveryMethodBirth)
		{
			ims.pci.vo.lookups.DeliveryMethodBirth instance = (ims.pci.vo.lookups.DeliveryMethodBirth)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDeliveryMethodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.DeliveryMethodBirth existingInstance = (ims.pci.vo.lookups.DeliveryMethodBirth)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDeliveryMethod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDeliveryMethodLookup()
	{
		this.form.cmbDeliveryMethod().clear();
		ims.pci.vo.lookups.DeliveryMethodBirthCollection lookupCollection = ims.pci.vo.lookups.LookupHelper.getDeliveryMethodBirth(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDeliveryMethod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDeliveryMethodLookupValue(int id)
	{
		ims.pci.vo.lookups.DeliveryMethodBirth instance = ims.pci.vo.lookups.LookupHelper.getDeliveryMethodBirthInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDeliveryMethod().setValue(instance);
	}
	protected final void defaultcmbDeliveryMethodLookupValue()
	{
		this.form.cmbDeliveryMethod().setValue((ims.pci.vo.lookups.DeliveryMethodBirth)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.DeliveryMethodBirth.class, engine.getFormName().getID(), ims.pci.vo.lookups.DeliveryMethodBirth.TYPE_ID));
	}
	protected final void onansEpiduralValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansEpidural().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansEpiduralLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansEpiduralLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansEpidural().addOption(instance);
		}
	}
	protected final void bindansEpiduralLookup()
	{
		this.form.ansEpidural().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansEpidural().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansEpiduralLookupValue()
	{
		this.form.ansEpidural().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbPlaceOfBirthValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPlaceOfBirth().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.PlaceOfBirth existingInstance = (ims.pci.vo.lookups.PlaceOfBirth)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPlaceOfBirthLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.PlaceOfBirth)
		{
			ims.pci.vo.lookups.PlaceOfBirth instance = (ims.pci.vo.lookups.PlaceOfBirth)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPlaceOfBirthLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.PlaceOfBirth existingInstance = (ims.pci.vo.lookups.PlaceOfBirth)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPlaceOfBirth().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPlaceOfBirthLookup()
	{
		this.form.cmbPlaceOfBirth().clear();
		ims.pci.vo.lookups.PlaceOfBirthCollection lookupCollection = ims.pci.vo.lookups.LookupHelper.getPlaceOfBirth(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPlaceOfBirth().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPlaceOfBirthLookupValue(int id)
	{
		ims.pci.vo.lookups.PlaceOfBirth instance = ims.pci.vo.lookups.LookupHelper.getPlaceOfBirthInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPlaceOfBirth().setValue(instance);
	}
	protected final void defaultcmbPlaceOfBirthLookupValue()
	{
		this.form.cmbPlaceOfBirth().setValue((ims.pci.vo.lookups.PlaceOfBirth)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.PlaceOfBirth.class, engine.getFormName().getID(), ims.pci.vo.lookups.PlaceOfBirth.TYPE_ID));
	}
	protected final void oncmbBFThreeMonthsValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbBFThreeMonths().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.BreastFeedingStatus existingInstance = (ims.pci.vo.lookups.BreastFeedingStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBFThreeMonthsLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.BreastFeedingStatus)
		{
			ims.pci.vo.lookups.BreastFeedingStatus instance = (ims.pci.vo.lookups.BreastFeedingStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBFThreeMonthsLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.BreastFeedingStatus existingInstance = (ims.pci.vo.lookups.BreastFeedingStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbBFThreeMonths().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBFThreeMonthsLookup()
	{
		this.form.cmbBFThreeMonths().clear();
		ims.pci.vo.lookups.BreastFeedingStatusCollection lookupCollection = ims.pci.vo.lookups.LookupHelper.getBreastFeedingStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbBFThreeMonths().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBFThreeMonthsLookupValue(int id)
	{
		ims.pci.vo.lookups.BreastFeedingStatus instance = ims.pci.vo.lookups.LookupHelper.getBreastFeedingStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbBFThreeMonths().setValue(instance);
	}
	protected final void defaultcmbBFThreeMonthsLookupValue()
	{
		this.form.cmbBFThreeMonths().setValue((ims.pci.vo.lookups.BreastFeedingStatus)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.BreastFeedingStatus.class, engine.getFormName().getID(), ims.pci.vo.lookups.BreastFeedingStatus.TYPE_ID));
	}
	protected final void oncmbBFPHNVisitValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbBFPHNVisit().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.BreastFeedingStatus existingInstance = (ims.pci.vo.lookups.BreastFeedingStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBFPHNVisitLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.BreastFeedingStatus)
		{
			ims.pci.vo.lookups.BreastFeedingStatus instance = (ims.pci.vo.lookups.BreastFeedingStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBFPHNVisitLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.BreastFeedingStatus existingInstance = (ims.pci.vo.lookups.BreastFeedingStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbBFPHNVisit().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBFPHNVisitLookup()
	{
		this.form.cmbBFPHNVisit().clear();
		ims.pci.vo.lookups.BreastFeedingStatusCollection lookupCollection = ims.pci.vo.lookups.LookupHelper.getBreastFeedingStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbBFPHNVisit().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBFPHNVisitLookupValue(int id)
	{
		ims.pci.vo.lookups.BreastFeedingStatus instance = ims.pci.vo.lookups.LookupHelper.getBreastFeedingStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbBFPHNVisit().setValue(instance);
	}
	protected final void defaultcmbBFPHNVisitLookupValue()
	{
		this.form.cmbBFPHNVisit().setValue((ims.pci.vo.lookups.BreastFeedingStatus)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.BreastFeedingStatus.class, engine.getFormName().getID(), ims.pci.vo.lookups.BreastFeedingStatus.TYPE_ID));
	}
	protected final void oncmbBFDischargeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbBFDischarge().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.BreastFeedingStatus existingInstance = (ims.pci.vo.lookups.BreastFeedingStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBFDischargeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.BreastFeedingStatus)
		{
			ims.pci.vo.lookups.BreastFeedingStatus instance = (ims.pci.vo.lookups.BreastFeedingStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBFDischargeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.BreastFeedingStatus existingInstance = (ims.pci.vo.lookups.BreastFeedingStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbBFDischarge().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBFDischargeLookup()
	{
		this.form.cmbBFDischarge().clear();
		ims.pci.vo.lookups.BreastFeedingStatusCollection lookupCollection = ims.pci.vo.lookups.LookupHelper.getBreastFeedingStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbBFDischarge().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBFDischargeLookupValue(int id)
	{
		ims.pci.vo.lookups.BreastFeedingStatus instance = ims.pci.vo.lookups.LookupHelper.getBreastFeedingStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbBFDischarge().setValue(instance);
	}
	protected final void defaultcmbBFDischargeLookupValue()
	{
		this.form.cmbBFDischarge().setValue((ims.pci.vo.lookups.BreastFeedingStatus)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.BreastFeedingStatus.class, engine.getFormName().getID(), ims.pci.vo.lookups.BreastFeedingStatus.TYPE_ID));
	}
	protected final void onansBreastFeedingValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansBreastFeeding().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansBreastFeedingLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindansBreastFeedingLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansBreastFeeding().addOption(instance);
		}
	}
	protected final void bindansBreastFeedingLookup()
	{
		this.form.ansBreastFeeding().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansBreastFeeding().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansBreastFeedingLookupValue()
	{
		this.form.ansBreastFeeding().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbMaritalStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMaritalStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.MaritalStatusAtBirth existingInstance = (ims.pci.vo.lookups.MaritalStatusAtBirth)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaritalStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pci.vo.lookups.MaritalStatusAtBirth)
		{
			ims.pci.vo.lookups.MaritalStatusAtBirth instance = (ims.pci.vo.lookups.MaritalStatusAtBirth)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMaritalStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pci.vo.lookups.MaritalStatusAtBirth existingInstance = (ims.pci.vo.lookups.MaritalStatusAtBirth)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMaritalStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaritalStatusLookup()
	{
		this.form.cmbMaritalStatus().clear();
		ims.pci.vo.lookups.MaritalStatusAtBirthCollection lookupCollection = ims.pci.vo.lookups.LookupHelper.getMaritalStatusAtBirth(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMaritalStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaritalStatusLookupValue(int id)
	{
		ims.pci.vo.lookups.MaritalStatusAtBirth instance = ims.pci.vo.lookups.LookupHelper.getMaritalStatusAtBirthInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMaritalStatus().setValue(instance);
	}
	protected final void defaultcmbMaritalStatusLookupValue()
	{
		this.form.cmbMaritalStatus().setValue((ims.pci.vo.lookups.MaritalStatusAtBirth)domain.getLookupService().getDefaultInstance(ims.pci.vo.lookups.MaritalStatusAtBirth.class, engine.getFormName().getID(), ims.pci.vo.lookups.MaritalStatusAtBirth.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.pci.domain.BirthDetails domain;
}