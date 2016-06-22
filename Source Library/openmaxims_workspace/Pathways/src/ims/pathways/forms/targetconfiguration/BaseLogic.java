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

package ims.pathways.forms.targetconfiguration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pathways.domain.TargetConfiguration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pathways.domain.TargetConfiguration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbSearchTargetDateCalFromValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSearchTargetDateCalFrom().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.TargetDateCalculation existingInstance = (ims.pathways.vo.lookups.TargetDateCalculation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSearchTargetDateCalFromLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.TargetDateCalculation)
		{
			ims.pathways.vo.lookups.TargetDateCalculation instance = (ims.pathways.vo.lookups.TargetDateCalculation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSearchTargetDateCalFromLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.TargetDateCalculation existingInstance = (ims.pathways.vo.lookups.TargetDateCalculation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSearchTargetDateCalFrom().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSearchTargetDateCalFromLookup()
	{
		this.form.cmbSearchTargetDateCalFrom().clear();
		ims.pathways.vo.lookups.TargetDateCalculationCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getTargetDateCalculation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSearchTargetDateCalFrom().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSearchTargetDateCalFromLookupValue(int id)
	{
		ims.pathways.vo.lookups.TargetDateCalculation instance = ims.pathways.vo.lookups.LookupHelper.getTargetDateCalculationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSearchTargetDateCalFrom().setValue(instance);
	}
	protected final void defaultcmbSearchTargetDateCalFromLookupValue()
	{
		this.form.cmbSearchTargetDateCalFrom().setValue((ims.pathways.vo.lookups.TargetDateCalculation)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.TargetDateCalculation.class, engine.getFormName().getID(), ims.pathways.vo.lookups.TargetDateCalculation.TYPE_ID));
	}
	protected final void bindgrdTargetsColEventLinkLookup()
	{
		this.form.grdTargets().ColEventLinkComboBox().clear();
		ims.pathways.vo.lookups.EventLinkTypeCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getEventLinkType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTargets().ColEventLinkComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdTargetsColTargetDateCalculationLookup()
	{
		this.form.grdTargets().ColTargetDateCalculationComboBox().clear();
		ims.pathways.vo.lookups.TargetDateCalculationCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getTargetDateCalculation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTargets().ColTargetDateCalculationComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdTargetsColStatusLookup()
	{
		this.form.grdTargets().ColStatusComboBox().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdTargets().ColStatusComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbPathwayEventValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbPathwayEvent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.EventLinkType existingInstance = (ims.pathways.vo.lookups.EventLinkType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPathwayEventLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.EventLinkType)
		{
			ims.pathways.vo.lookups.EventLinkType instance = (ims.pathways.vo.lookups.EventLinkType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPathwayEventLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.EventLinkType existingInstance = (ims.pathways.vo.lookups.EventLinkType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbPathwayEvent().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPathwayEventLookup()
	{
		this.form.ctnDetails().cmbPathwayEvent().clear();
		ims.pathways.vo.lookups.EventLinkTypeCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getEventLinkType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbPathwayEvent().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPathwayEventLookupValue(int id)
	{
		ims.pathways.vo.lookups.EventLinkType instance = ims.pathways.vo.lookups.LookupHelper.getEventLinkTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbPathwayEvent().setValue(instance);
	}
	protected final void defaultcmbPathwayEventLookupValue()
	{
		this.form.ctnDetails().cmbPathwayEvent().setValue((ims.pathways.vo.lookups.EventLinkType)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.EventLinkType.class, engine.getFormName().getID(), ims.pathways.vo.lookups.EventLinkType.TYPE_ID));
	}
	protected final void oncmbPathwayStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbPathwayStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPathwayStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PreActiveActiveInactiveStatus)
		{
			ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPathwayStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbPathwayStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPathwayStatusLookup()
	{
		this.form.ctnDetails().cmbPathwayStatus().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbPathwayStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPathwayStatusLookupValue(int id)
	{
		ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbPathwayStatus().setValue(instance);
	}
	protected final void defaultcmbPathwayStatusLookupValue()
	{
		this.form.ctnDetails().cmbPathwayStatus().setValue((ims.core.vo.lookups.PreActiveActiveInactiveStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PreActiveActiveInactiveStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PreActiveActiveInactiveStatus.TYPE_ID));
	}
	protected final void oncmbTargetDateCalculationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnDetails().cmbTargetDateCalculation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.TargetDateCalculation existingInstance = (ims.pathways.vo.lookups.TargetDateCalculation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTargetDateCalculationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.TargetDateCalculation)
		{
			ims.pathways.vo.lookups.TargetDateCalculation instance = (ims.pathways.vo.lookups.TargetDateCalculation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTargetDateCalculationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.TargetDateCalculation existingInstance = (ims.pathways.vo.lookups.TargetDateCalculation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnDetails().cmbTargetDateCalculation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTargetDateCalculationLookup()
	{
		this.form.ctnDetails().cmbTargetDateCalculation().clear();
		ims.pathways.vo.lookups.TargetDateCalculationCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getTargetDateCalculation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnDetails().cmbTargetDateCalculation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTargetDateCalculationLookupValue(int id)
	{
		ims.pathways.vo.lookups.TargetDateCalculation instance = ims.pathways.vo.lookups.LookupHelper.getTargetDateCalculationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnDetails().cmbTargetDateCalculation().setValue(instance);
	}
	protected final void defaultcmbTargetDateCalculationLookupValue()
	{
		this.form.ctnDetails().cmbTargetDateCalculation().setValue((ims.pathways.vo.lookups.TargetDateCalculation)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.TargetDateCalculation.class, engine.getFormName().getID(), ims.pathways.vo.lookups.TargetDateCalculation.TYPE_ID));
	}
	protected final void oncmbSearchEventValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSearchEvent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.EventLinkType existingInstance = (ims.pathways.vo.lookups.EventLinkType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSearchEventLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.EventLinkType)
		{
			ims.pathways.vo.lookups.EventLinkType instance = (ims.pathways.vo.lookups.EventLinkType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSearchEventLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.EventLinkType existingInstance = (ims.pathways.vo.lookups.EventLinkType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSearchEvent().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSearchEventLookup()
	{
		this.form.cmbSearchEvent().clear();
		ims.pathways.vo.lookups.EventLinkTypeCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getEventLinkType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSearchEvent().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSearchEventLookupValue(int id)
	{
		ims.pathways.vo.lookups.EventLinkType instance = ims.pathways.vo.lookups.LookupHelper.getEventLinkTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSearchEvent().setValue(instance);
	}
	protected final void defaultcmbSearchEventLookupValue()
	{
		this.form.cmbSearchEvent().setValue((ims.pathways.vo.lookups.EventLinkType)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.EventLinkType.class, engine.getFormName().getID(), ims.pathways.vo.lookups.EventLinkType.TYPE_ID));
	}
	protected final void oncmbSearchStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSearchStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSearchStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PreActiveActiveInactiveStatus)
		{
			ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSearchStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSearchStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSearchStatusLookup()
	{
		this.form.cmbSearchStatus().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSearchStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSearchStatusLookupValue(int id)
	{
		ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSearchStatus().setValue(instance);
	}
	protected final void defaultcmbSearchStatusLookupValue()
	{
		this.form.cmbSearchStatus().setValue((ims.core.vo.lookups.PreActiveActiveInactiveStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PreActiveActiveInactiveStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PreActiveActiveInactiveStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.pathways.domain.TargetConfiguration domain;
}
