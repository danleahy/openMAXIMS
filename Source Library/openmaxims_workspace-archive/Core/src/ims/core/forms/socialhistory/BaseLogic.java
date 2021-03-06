//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.forms.socialhistory;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.SocialHistory.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.SocialHistory domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbDietaryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDietary().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SocialHistoryDiet existingInstance = (ims.core.vo.lookups.SocialHistoryDiet)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDietaryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SocialHistoryDiet)
		{
			ims.core.vo.lookups.SocialHistoryDiet instance = (ims.core.vo.lookups.SocialHistoryDiet)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDietaryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SocialHistoryDiet existingInstance = (ims.core.vo.lookups.SocialHistoryDiet)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDietary().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDietaryLookup()
	{
		this.form.cmbDietary().clear();
		ims.core.vo.lookups.SocialHistoryDietCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSocialHistoryDiet(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDietary().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDietaryLookupValue(int id)
	{
		ims.core.vo.lookups.SocialHistoryDiet instance = ims.core.vo.lookups.LookupHelper.getSocialHistoryDietInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDietary().setValue(instance);
	}
	protected final void defaultcmbDietaryLookupValue()
	{
		this.form.cmbDietary().setValue((ims.core.vo.lookups.SocialHistoryDiet)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SocialHistoryDiet.class, engine.getFormName().getID(), ims.core.vo.lookups.SocialHistoryDiet.TYPE_ID));
	}
	protected final void oncmbOccupationStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOccupationStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OccupationStatus existingInstance = (ims.core.vo.lookups.OccupationStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOccupationStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.OccupationStatus)
		{
			ims.core.vo.lookups.OccupationStatus instance = (ims.core.vo.lookups.OccupationStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOccupationStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OccupationStatus existingInstance = (ims.core.vo.lookups.OccupationStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOccupationStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOccupationStatusLookup()
	{
		this.form.cmbOccupationStatus().clear();
		ims.core.vo.lookups.OccupationStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOccupationStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOccupationStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOccupationStatusLookupValue(int id)
	{
		ims.core.vo.lookups.OccupationStatus instance = ims.core.vo.lookups.LookupHelper.getOccupationStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOccupationStatus().setValue(instance);
	}
	protected final void defaultcmbOccupationStatusLookupValue()
	{
		this.form.cmbOccupationStatus().setValue((ims.core.vo.lookups.OccupationStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.OccupationStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.OccupationStatus.TYPE_ID));
	}
	protected final void oncmbMaritalStatValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbMaritalStat().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbMaritalStatLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.MaritalStatus)
		{
			ims.core.vo.lookups.MaritalStatus instance = (ims.core.vo.lookups.MaritalStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbMaritalStatLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.MaritalStatus existingInstance = (ims.core.vo.lookups.MaritalStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbMaritalStat().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbMaritalStatLookup()
	{
		this.form.cmbMaritalStat().clear();
		ims.core.vo.lookups.MaritalStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMaritalStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbMaritalStat().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbMaritalStatLookupValue(int id)
	{
		ims.core.vo.lookups.MaritalStatus instance = ims.core.vo.lookups.LookupHelper.getMaritalStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbMaritalStat().setValue(instance);
	}
	protected final void defaultcmbMaritalStatLookupValue()
	{
		this.form.cmbMaritalStat().setValue((ims.core.vo.lookups.MaritalStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.MaritalStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.MaritalStatus.TYPE_ID));
	}
	protected final void oncmbFitToCareForPatientValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbFitToCareForPatient().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFitToCareForPatientLookup();
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
					bindcmbFitToCareForPatientLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbFitToCareForPatient().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFitToCareForPatientLookup()
	{
		this.form.cmbFitToCareForPatient().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbFitToCareForPatient().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFitToCareForPatientLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbFitToCareForPatient().setValue(instance);
	}
	protected final void defaultcmbFitToCareForPatientLookupValue()
	{
		this.form.cmbFitToCareForPatient().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbSomeoneToTakeHomeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSomeoneToTakeHome().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSomeoneToTakeHomeLookup();
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
					bindcmbSomeoneToTakeHomeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSomeoneToTakeHome().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSomeoneToTakeHomeLookup()
	{
		this.form.cmbSomeoneToTakeHome().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSomeoneToTakeHome().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSomeoneToTakeHomeLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSomeoneToTakeHome().setValue(instance);
	}
	protected final void defaultcmbSomeoneToTakeHomeLookupValue()
	{
		this.form.cmbSomeoneToTakeHome().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void bindgrdSmokingDetailsColStatusLookup()
	{
		this.form.grdSmokingDetails().ColStatusComboBox().clear();
		ims.core.vo.lookups.SmokingCurrentHistoricCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSmokingCurrentHistoric(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdSmokingDetails().ColStatusComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdSmokingDetailsColWhatLookup()
	{
		this.form.grdSmokingDetails().ColWhatComboBox().clear();
		ims.core.vo.lookups.SmokingWhatCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSmokingWhat(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdSmokingDetails().ColWhatComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbSmokingStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbSmokingStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SmokingStatus existingInstance = (ims.core.vo.lookups.SmokingStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbSmokingStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.SmokingStatus)
		{
			ims.core.vo.lookups.SmokingStatus instance = (ims.core.vo.lookups.SmokingStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbSmokingStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.SmokingStatus existingInstance = (ims.core.vo.lookups.SmokingStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbSmokingStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbSmokingStatusLookup()
	{
		this.form.cmbSmokingStatus().clear();
		ims.core.vo.lookups.SmokingStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getSmokingStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbSmokingStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbSmokingStatusLookupValue(int id)
	{
		ims.core.vo.lookups.SmokingStatus instance = ims.core.vo.lookups.LookupHelper.getSmokingStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbSmokingStatus().setValue(instance);
	}
	protected final void defaultcmbSmokingStatusLookupValue()
	{
		this.form.cmbSmokingStatus().setValue((ims.core.vo.lookups.SmokingStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.SmokingStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.SmokingStatus.TYPE_ID));
	}
	protected final void oncmbAlcoholStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAlcoholStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAlcoholStatusLookup();
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
					bindcmbAlcoholStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAlcoholStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAlcoholStatusLookup()
	{
		this.form.cmbAlcoholStatus().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAlcoholStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAlcoholStatusLookupValue(int id)
	{
		ims.core.vo.lookups.YesNoUnknown instance = ims.core.vo.lookups.LookupHelper.getYesNoUnknownInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAlcoholStatus().setValue(instance);
	}
	protected final void defaultcmbAlcoholStatusLookupValue()
	{
		this.form.cmbAlcoholStatus().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncmbOccupationValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOccupation().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Occupation existingInstance = (ims.core.vo.lookups.Occupation)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOccupationLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.Occupation)
		{
			ims.core.vo.lookups.Occupation instance = (ims.core.vo.lookups.Occupation)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOccupationLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.Occupation existingInstance = (ims.core.vo.lookups.Occupation)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOccupation().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOccupationLookup()
	{
		this.form.cmbOccupation().clear();
		ims.core.vo.lookups.OccupationCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOccupation(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOccupation().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOccupationLookupValue(int id)
	{
		ims.core.vo.lookups.Occupation instance = ims.core.vo.lookups.LookupHelper.getOccupationInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOccupation().setValue(instance);
	}
	protected final void defaultcmbOccupationLookupValue()
	{
		this.form.cmbOccupation().setValue((ims.core.vo.lookups.Occupation)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.Occupation.class, engine.getFormName().getID(), ims.core.vo.lookups.Occupation.TYPE_ID));
	}
	protected final void oncmbLivesWithValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbLivesWith().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LivesWith existingInstance = (ims.core.vo.lookups.LivesWith)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbLivesWithLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.LivesWith)
		{
			ims.core.vo.lookups.LivesWith instance = (ims.core.vo.lookups.LivesWith)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbLivesWithLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.LivesWith existingInstance = (ims.core.vo.lookups.LivesWith)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbLivesWith().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbLivesWithLookup()
	{
		this.form.cmbLivesWith().clear();
		ims.core.vo.lookups.LivesWithCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getLivesWith(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbLivesWith().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbLivesWithLookupValue(int id)
	{
		ims.core.vo.lookups.LivesWith instance = ims.core.vo.lookups.LookupHelper.getLivesWithInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbLivesWith().setValue(instance);
	}
	protected final void defaultcmbLivesWithLookupValue()
	{
		this.form.cmbLivesWith().setValue((ims.core.vo.lookups.LivesWith)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.LivesWith.class, engine.getFormName().getID(), ims.core.vo.lookups.LivesWith.TYPE_ID));
	}
	protected final void onansIVUserValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ansIVUser().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindansIVUserLookup();
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
					bindansIVUserLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ansIVUser().addOption(instance);
		}
	}
	protected final void bindansIVUserLookup()
	{
		this.form.ansIVUser().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ansIVUser().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultansIVUserLookupValue()
	{
		this.form.ansIVUser().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void bindgrdIllicitDrugsColumnStatusLookup()
	{
		this.form.grdIllicitDrugs().ColumnStatusComboBox().clear();
		ims.clinical.vo.lookups.IllicitDrugsCurrentStatusCollection lookupCollection = ims.clinical.vo.lookups.LookupHelper.getIllicitDrugsCurrentStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdIllicitDrugs().ColumnStatusComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdIllicitDrugsColumnDrugLookup()
	{
		this.form.grdIllicitDrugs().ColumnDrugComboBox().clear();
		ims.core.vo.lookups.IllicitDrugsCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getIllicitDrugs(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.grdIllicitDrugs().ColumnDrugComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected void clearScreen()
	{
		this.form.cmbDietary().setValue(null);
		this.form.cmbOccupationStatus().setValue(null);
		this.form.txtMobilityIndependence().setValue("");
		this.form.txtGeneralNotes().setValue("");
		this.form.cmbFitToCareForPatient().setValue(null);
		this.form.cmbSomeoneToTakeHome().setValue(null);
		this.form.txtOccupation().setValue("");
		this.form.cmbSmokingStatus().setValue(null);
		this.form.cmbOccupation().setValue(null);
		this.form.cmbLivesWith().setValue(null);
		this.form.txtIllicitDrugs().setValue("");
	}
	protected void populateScreenFromData(ims.core.vo.SocialHistoryVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.cmbDietary().setValue(value.getDietIsNotNull() ? value.getDiet() : null);
		this.form.cmbOccupationStatus().setValue(value.getOccupationStatusIsNotNull() ? value.getOccupationStatus() : null);
		this.form.txtMobilityIndependence().setValue(value.getMobilityIndependenceIsNotNull() ? value.getMobilityIndependence(): null);
		this.form.txtGeneralNotes().setValue(value.getSocialHistoryNotesIsNotNull() ? value.getSocialHistoryNotes(): null);
		this.form.cmbFitToCareForPatient().setValue(value.getFitToCareForPatientIsNotNull() ? value.getFitToCareForPatient() : null);
		this.form.cmbSomeoneToTakeHome().setValue(value.getFitToTakeHomeIsNotNull() ? value.getFitToTakeHome() : null);
		this.form.txtOccupation().setValue(value.getOccupationTextIsNotNull() ? value.getOccupationText(): null);
		this.form.cmbSmokingStatus().setValue(value.getSmokingStatusIsNotNull() ? value.getSmokingStatus() : null);
		this.form.cmbOccupation().setValue(value.getOccupationIsNotNull() ? value.getOccupation() : null);
		this.form.cmbLivesWith().setValue(value.getLivesWithIsNotNull() ? value.getLivesWith() : null);
		this.form.txtIllicitDrugs().setValue(value.getIllicitDrugsIsNotNull() ? value.getIllicitDrugs(): null);
	}
	protected ims.core.vo.SocialHistoryVo populateDataFromScreen(ims.core.vo.SocialHistoryVo value)
	{
		if(value == null)
			value = new ims.core.vo.SocialHistoryVo();

		value.setDiet(this.form.cmbDietary().getValue());
		value.setOccupationStatus(this.form.cmbOccupationStatus().getValue());
		value.setMobilityIndependence(this.form.txtMobilityIndependence().getValue());
		value.setSocialHistoryNotes(this.form.txtGeneralNotes().getValue());
		value.setFitToCareForPatient(this.form.cmbFitToCareForPatient().getValue());
		value.setFitToTakeHome(this.form.cmbSomeoneToTakeHome().getValue());
		value.setOccupationText(this.form.txtOccupation().getValue());
		value.setSmokingStatus(this.form.cmbSmokingStatus().getValue());
		value.setOccupation(this.form.cmbOccupation().getValue());
		value.setLivesWith(this.form.cmbLivesWith().getValue());
		value.setIllicitDrugs(this.form.txtIllicitDrugs().getValue());

		return value;
	}
	protected ims.core.vo.SocialHistoryVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.core.vo.SocialHistoryVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.SocialHistory domain;
}
