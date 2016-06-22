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

package ims.core.forms.closeblockreopenbayorwarddlg;

public abstract class BaseLogic extends Handlers
{
	private java.util.ArrayList lookupUsageErrors;

	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.CloseBlockReOpenBayOrWardDlg.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.CloseBlockReOpenBayOrWardDlg domain)
	{
		setContext(engine, form);
		this.domain = domain;
		if(domain.getLookupService().countLookupInstances(ims.core.vo.lookups.WardBayBlockingReasonCollection.class, ims.core.vo.lookups.WardBayBlockingReason.class, 1021352, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'WardBayBlockingReason' (ID: 1021352) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.core.vo.lookups.WardBayClosingReasonCollection.class, ims.core.vo.lookups.WardBayClosingReason.class, 1021351, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'WardBayClosingReason' (ID: 1021351) must have at least one active instance configured.");
		}
		if(domain.getLookupService().countLookupInstances(ims.core.vo.lookups.WardBayReopenReasonCollection.class, ims.core.vo.lookups.WardBayReopenReason.class, 1021353, true) == 0)
		{
			if(lookupUsageErrors == null)
				lookupUsageErrors = new java.util.ArrayList();
			lookupUsageErrors.add("The lookup type 'WardBayReopenReason' (ID: 1021353) must have at least one active instance configured.");
		}
	}
	public final String[] getLookupUsageErrors()
	{
		if(lookupUsageErrors == null)
			return null;
		String[] errors = new String[lookupUsageErrors.size()];
		for(int x = 0; x < lookupUsageErrors.size(); x++)
		{
			errors[x] = (String)lookupUsageErrors.get(x);
		}
		return errors;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbClosureReasonWardCloseValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCloseW().cmbClosureReasonWardClose().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayClosingReason existingInstance = (ims.core.vo.lookups.WardBayClosingReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbClosureReasonWardCloseLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardBayClosingReason)
		{
			ims.core.vo.lookups.WardBayClosingReason instance = (ims.core.vo.lookups.WardBayClosingReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbClosureReasonWardCloseLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayClosingReason existingInstance = (ims.core.vo.lookups.WardBayClosingReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCloseW().cmbClosureReasonWardClose().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbClosureReasonWardCloseLookup()
	{
		this.form.lyrDetails().tabCloseW().cmbClosureReasonWardClose().clear();
		ims.core.vo.lookups.WardBayClosingReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardBayClosingReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCloseW().cmbClosureReasonWardClose().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbClosureReasonWardCloseLookupValue(int id)
	{
		ims.core.vo.lookups.WardBayClosingReason instance = ims.core.vo.lookups.LookupHelper.getWardBayClosingReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCloseW().cmbClosureReasonWardClose().setValue(instance);
	}
	protected final void defaultcmbClosureReasonWardCloseLookupValue()
	{
		this.form.lyrDetails().tabCloseW().cmbClosureReasonWardClose().setValue((ims.core.vo.lookups.WardBayClosingReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardBayClosingReason.class, engine.getFormName().getID(), ims.core.vo.lookups.WardBayClosingReason.TYPE_ID));
	}
	protected final void oncmbBlockingReasonWardValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabBlockW().cmbBlockingReasonWard().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayBlockingReason existingInstance = (ims.core.vo.lookups.WardBayBlockingReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbBlockingReasonWardLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardBayBlockingReason)
		{
			ims.core.vo.lookups.WardBayBlockingReason instance = (ims.core.vo.lookups.WardBayBlockingReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbBlockingReasonWardLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayBlockingReason existingInstance = (ims.core.vo.lookups.WardBayBlockingReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabBlockW().cmbBlockingReasonWard().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbBlockingReasonWardLookup()
	{
		this.form.lyrDetails().tabBlockW().cmbBlockingReasonWard().clear();
		ims.core.vo.lookups.WardBayBlockingReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardBayBlockingReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabBlockW().cmbBlockingReasonWard().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbBlockingReasonWardLookupValue(int id)
	{
		ims.core.vo.lookups.WardBayBlockingReason instance = ims.core.vo.lookups.LookupHelper.getWardBayBlockingReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabBlockW().cmbBlockingReasonWard().setValue(instance);
	}
	protected final void defaultcmbBlockingReasonWardLookupValue()
	{
		this.form.lyrDetails().tabBlockW().cmbBlockingReasonWard().setValue((ims.core.vo.lookups.WardBayBlockingReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardBayBlockingReason.class, engine.getFormName().getID(), ims.core.vo.lookups.WardBayBlockingReason.TYPE_ID));
	}
	protected final void oncmbReopenReasonWardValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabReopenW().cmbReopenReasonWard().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayReopenReason existingInstance = (ims.core.vo.lookups.WardBayReopenReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReopenReasonWardLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardBayReopenReason)
		{
			ims.core.vo.lookups.WardBayReopenReason instance = (ims.core.vo.lookups.WardBayReopenReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReopenReasonWardLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayReopenReason existingInstance = (ims.core.vo.lookups.WardBayReopenReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabReopenW().cmbReopenReasonWard().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReopenReasonWardLookup()
	{
		this.form.lyrDetails().tabReopenW().cmbReopenReasonWard().clear();
		ims.core.vo.lookups.WardBayReopenReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardBayReopenReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabReopenW().cmbReopenReasonWard().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReopenReasonWardLookupValue(int id)
	{
		ims.core.vo.lookups.WardBayReopenReason instance = ims.core.vo.lookups.LookupHelper.getWardBayReopenReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabReopenW().cmbReopenReasonWard().setValue(instance);
	}
	protected final void defaultcmbReopenReasonWardLookupValue()
	{
		this.form.lyrDetails().tabReopenW().cmbReopenReasonWard().setValue((ims.core.vo.lookups.WardBayReopenReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardBayReopenReason.class, engine.getFormName().getID(), ims.core.vo.lookups.WardBayReopenReason.TYPE_ID));
	}
	protected final void oncmbReasonforClosureBayCloseValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabCloseB().cmbReasonforClosureBayClose().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayClosingReason existingInstance = (ims.core.vo.lookups.WardBayClosingReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonforClosureBayCloseLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardBayClosingReason)
		{
			ims.core.vo.lookups.WardBayClosingReason instance = (ims.core.vo.lookups.WardBayClosingReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonforClosureBayCloseLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayClosingReason existingInstance = (ims.core.vo.lookups.WardBayClosingReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabCloseB().cmbReasonforClosureBayClose().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonforClosureBayCloseLookup()
	{
		this.form.lyrDetails().tabCloseB().cmbReasonforClosureBayClose().clear();
		ims.core.vo.lookups.WardBayClosingReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardBayClosingReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabCloseB().cmbReasonforClosureBayClose().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonforClosureBayCloseLookupValue(int id)
	{
		ims.core.vo.lookups.WardBayClosingReason instance = ims.core.vo.lookups.LookupHelper.getWardBayClosingReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabCloseB().cmbReasonforClosureBayClose().setValue(instance);
	}
	protected final void defaultcmbReasonforClosureBayCloseLookupValue()
	{
		this.form.lyrDetails().tabCloseB().cmbReasonforClosureBayClose().setValue((ims.core.vo.lookups.WardBayClosingReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardBayClosingReason.class, engine.getFormName().getID(), ims.core.vo.lookups.WardBayClosingReason.TYPE_ID));
	}
	protected final void oncmbReasonBlockingBayValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabBlockB().cmbReasonBlockingBay().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayBlockingReason existingInstance = (ims.core.vo.lookups.WardBayBlockingReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonBlockingBayLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardBayBlockingReason)
		{
			ims.core.vo.lookups.WardBayBlockingReason instance = (ims.core.vo.lookups.WardBayBlockingReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonBlockingBayLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayBlockingReason existingInstance = (ims.core.vo.lookups.WardBayBlockingReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabBlockB().cmbReasonBlockingBay().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonBlockingBayLookup()
	{
		this.form.lyrDetails().tabBlockB().cmbReasonBlockingBay().clear();
		ims.core.vo.lookups.WardBayBlockingReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardBayBlockingReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabBlockB().cmbReasonBlockingBay().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonBlockingBayLookupValue(int id)
	{
		ims.core.vo.lookups.WardBayBlockingReason instance = ims.core.vo.lookups.LookupHelper.getWardBayBlockingReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabBlockB().cmbReasonBlockingBay().setValue(instance);
	}
	protected final void defaultcmbReasonBlockingBayLookupValue()
	{
		this.form.lyrDetails().tabBlockB().cmbReasonBlockingBay().setValue((ims.core.vo.lookups.WardBayBlockingReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardBayBlockingReason.class, engine.getFormName().getID(), ims.core.vo.lookups.WardBayBlockingReason.TYPE_ID));
	}
	protected final void oncmbReasonReopenBayValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyrDetails().tabReopenB().cmbReasonReopenBay().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayReopenReason existingInstance = (ims.core.vo.lookups.WardBayReopenReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonReopenBayLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WardBayReopenReason)
		{
			ims.core.vo.lookups.WardBayReopenReason instance = (ims.core.vo.lookups.WardBayReopenReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonReopenBayLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WardBayReopenReason existingInstance = (ims.core.vo.lookups.WardBayReopenReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyrDetails().tabReopenB().cmbReasonReopenBay().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonReopenBayLookup()
	{
		this.form.lyrDetails().tabReopenB().cmbReasonReopenBay().clear();
		ims.core.vo.lookups.WardBayReopenReasonCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWardBayReopenReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrDetails().tabReopenB().cmbReasonReopenBay().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonReopenBayLookupValue(int id)
	{
		ims.core.vo.lookups.WardBayReopenReason instance = ims.core.vo.lookups.LookupHelper.getWardBayReopenReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyrDetails().tabReopenB().cmbReasonReopenBay().setValue(instance);
	}
	protected final void defaultcmbReasonReopenBayLookupValue()
	{
		this.form.lyrDetails().tabReopenB().cmbReasonReopenBay().setValue((ims.core.vo.lookups.WardBayReopenReason)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WardBayReopenReason.class, engine.getFormName().getID(), ims.core.vo.lookups.WardBayReopenReason.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.CloseBlockReOpenBayOrWardDlg domain;
}
