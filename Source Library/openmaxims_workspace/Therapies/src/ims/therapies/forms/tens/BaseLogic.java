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

package ims.therapies.forms.tens;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.TENS.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.TENS domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void onansProtocolValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().ansProtocol().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansProtocolLookup();
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
					bindansProtocolLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().ansProtocol().addOption(instance);
		}
	}
	protected final void bindansProtocolLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().ansProtocol().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().ansProtocol().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansProtocolLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().ansProtocol().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbModeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbMode().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSMode existingInstance = (ims.spinalinjuries.vo.lookups.TENSMode)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbModeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.TENSMode)
		{
			ims.spinalinjuries.vo.lookups.TENSMode instance = (ims.spinalinjuries.vo.lookups.TENSMode)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbModeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSMode existingInstance = (ims.spinalinjuries.vo.lookups.TENSMode)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbMode().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbModeLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbMode().clear();
		ims.spinalinjuries.vo.lookups.TENSModeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSMode(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbMode().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbModeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.TENSMode instance = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSModeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbMode().setValue(instance);
	}
	protected final void defaultcmbModeLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbMode().setValue((ims.spinalinjuries.vo.lookups.TENSMode)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.TENSMode.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.TENSMode.TYPE_ID));
	}
	protected final void oncmbUsageValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbUsage().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSDailyUsage existingInstance = (ims.spinalinjuries.vo.lookups.TENSDailyUsage)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbUsageLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.TENSDailyUsage)
		{
			ims.spinalinjuries.vo.lookups.TENSDailyUsage instance = (ims.spinalinjuries.vo.lookups.TENSDailyUsage)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbUsageLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSDailyUsage existingInstance = (ims.spinalinjuries.vo.lookups.TENSDailyUsage)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbUsage().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbUsageLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbUsage().clear();
		ims.spinalinjuries.vo.lookups.TENSDailyUsageCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSDailyUsage(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbUsage().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbUsageLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.TENSDailyUsage instance = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSDailyUsageInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbUsage().setValue(instance);
	}
	protected final void defaultcmbUsageLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbUsage().setValue((ims.spinalinjuries.vo.lookups.TENSDailyUsage)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.TENSDailyUsage.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.TENSDailyUsage.TYPE_ID));
	}
	protected final void oncmbElectrodesValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbElectrodes().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSElectrodes existingInstance = (ims.spinalinjuries.vo.lookups.TENSElectrodes)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbElectrodesLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.TENSElectrodes)
		{
			ims.spinalinjuries.vo.lookups.TENSElectrodes instance = (ims.spinalinjuries.vo.lookups.TENSElectrodes)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbElectrodesLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSElectrodes existingInstance = (ims.spinalinjuries.vo.lookups.TENSElectrodes)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbElectrodes().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbElectrodesLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbElectrodes().clear();
		ims.spinalinjuries.vo.lookups.TENSElectrodesCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSElectrodes(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbElectrodes().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbElectrodesLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.TENSElectrodes instance = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSElectrodesInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbElectrodes().setValue(instance);
	}
	protected final void defaultcmbElectrodesLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbElectrodes().setValue((ims.spinalinjuries.vo.lookups.TENSElectrodes)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.TENSElectrodes.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.TENSElectrodes.TYPE_ID));
	}
	protected final void oncmbSizeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbSize().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSSize existingInstance = (ims.spinalinjuries.vo.lookups.TENSSize)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSizeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.TENSSize)
		{
			ims.spinalinjuries.vo.lookups.TENSSize instance = (ims.spinalinjuries.vo.lookups.TENSSize)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSizeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSSize existingInstance = (ims.spinalinjuries.vo.lookups.TENSSize)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbSize().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSizeLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbSize().clear();
		ims.spinalinjuries.vo.lookups.TENSSizeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSSize(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbSize().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSizeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.TENSSize instance = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSSizeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbSize().setValue(instance);
	}
	protected final void defaultcmbSizeLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbSize().setValue((ims.spinalinjuries.vo.lookups.TENSSize)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.TENSSize.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.TENSSize.TYPE_ID));
	}
	protected final void oncmbModelValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbModel().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSModel existingInstance = (ims.spinalinjuries.vo.lookups.TENSModel)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbModelLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.TENSModel)
		{
			ims.spinalinjuries.vo.lookups.TENSModel instance = (ims.spinalinjuries.vo.lookups.TENSModel)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbModelLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSModel existingInstance = (ims.spinalinjuries.vo.lookups.TENSModel)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbModel().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbModelLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbModel().clear();
		ims.spinalinjuries.vo.lookups.TENSModelCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSModel(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbModel().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbModelLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.TENSModel instance = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSModelInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbModel().setValue(instance);
	}
	protected final void defaultcmbModelLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbModel().setValue((ims.spinalinjuries.vo.lookups.TENSModel)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.TENSModel.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.TENSModel.TYPE_ID));
	}
	protected final void oncmbAreaValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbArea().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSArea existingInstance = (ims.spinalinjuries.vo.lookups.TENSArea)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAreaLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.TENSArea)
		{
			ims.spinalinjuries.vo.lookups.TENSArea instance = (ims.spinalinjuries.vo.lookups.TENSArea)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAreaLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.TENSArea existingInstance = (ims.spinalinjuries.vo.lookups.TENSArea)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbArea().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAreaLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbArea().clear();
		ims.spinalinjuries.vo.lookups.TENSAreaCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSArea(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbArea().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAreaLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.TENSArea instance = ims.spinalinjuries.vo.lookups.LookupHelper.getTENSAreaInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbArea().setValue(instance);
	}
	protected final void defaultcmbAreaLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbArea().setValue((ims.spinalinjuries.vo.lookups.TENSArea)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.TENSArea.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.TENSArea.TYPE_ID));
	}
	protected final void oncmbLateralityValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().lyrTENS().tabDetails().cmbLaterality().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRB existingInstance = (ims.core.vo.lookups.LateralityLRB)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLateralityLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LateralityLRB)
		{
			ims.core.vo.lookups.LateralityLRB instance = (ims.core.vo.lookups.LateralityLRB)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLateralityLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LateralityLRB existingInstance = (ims.core.vo.lookups.LateralityLRB)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().lyrTENS().tabDetails().cmbLaterality().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLateralityLookup()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbLaterality().clear();
		ims.core.vo.lookups.LateralityLRBCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLateralityLRB(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().lyrTENS().tabDetails().cmbLaterality().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLateralityLookupValue(int id)
	{
		ims.core.vo.lookups.LateralityLRB instance = ims.core.vo.lookups.LookupHelper.getLateralityLRBInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().lyrTENS().tabDetails().cmbLaterality().setValue(instance);
	}
	protected final void defaultcmbLateralityLookupValue()
	{
		this.form.ctnDetails().lyrTENS().tabDetails().cmbLaterality().setValue((ims.core.vo.lookups.LateralityLRB)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LateralityLRB.class, engine.getFormName().getID(), ims.core.vo.lookups.LateralityLRB.TYPE_ID));
	}
	protected final void onansWarningValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansWarning().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansWarningLookup();
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
					bindansWarningLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansWarning().addOption(instance);
		}
	}
	protected final void bindansWarningLookup()
	{
		this.form.ansWarning().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansWarning().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansWarningLookupValue()
	{
		this.form.ansWarning().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.TENS domain;
}
