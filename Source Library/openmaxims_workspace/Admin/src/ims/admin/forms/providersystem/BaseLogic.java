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

package ims.admin.forms.providersystem;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.admin.domain.ProviderSystem.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.admin.domain.ProviderSystem domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbCategoryValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCategory().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.Category existingInstance = (ims.ocrr.vo.lookups.Category)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCategoryLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ocrr.vo.lookups.Category)
		{
			ims.ocrr.vo.lookups.Category instance = (ims.ocrr.vo.lookups.Category)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCategoryLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ocrr.vo.lookups.Category existingInstance = (ims.ocrr.vo.lookups.Category)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCategory().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCategoryLookup()
	{
		this.form.cmbCategory().clear();
		ims.ocrr.vo.lookups.CategoryCollection lookupCollection = ims.ocrr.vo.lookups.LookupHelper.getCategory(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCategory().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCategoryLookupValue(int id)
	{
		ims.ocrr.vo.lookups.Category instance = ims.ocrr.vo.lookups.LookupHelper.getCategoryInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCategory().setValue(instance);
	}
	protected final void defaultcmbCategoryLookupValue()
	{
		this.form.cmbCategory().setValue((ims.ocrr.vo.lookups.Category)domain.getLookupService().getDefaultInstance(ims.ocrr.vo.lookups.Category.class, engine.getFormName().getID(), ims.ocrr.vo.lookups.Category.TYPE_ID));
	}
	protected final void oncmbPrimaryIdValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPrimaryId().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPrimaryIdLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PatIdType)
		{
			ims.core.vo.lookups.PatIdType instance = (ims.core.vo.lookups.PatIdType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPrimaryIdLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PatIdType existingInstance = (ims.core.vo.lookups.PatIdType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPrimaryId().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPrimaryIdLookup()
	{
		this.form.cmbPrimaryId().clear();
		ims.core.vo.lookups.PatIdTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPatIdType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPrimaryId().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPrimaryIdLookupValue(int id)
	{
		ims.core.vo.lookups.PatIdType instance = ims.core.vo.lookups.LookupHelper.getPatIdTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPrimaryId().setValue(instance);
	}
	protected final void defaultcmbPrimaryIdLookupValue()
	{
		this.form.cmbPrimaryId().setValue((ims.core.vo.lookups.PatIdType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PatIdType.class, engine.getFormName().getID(), ims.core.vo.lookups.PatIdType.TYPE_ID));
	}
	protected final void oncmbCodeSystemValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCodeSystem().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TaxonomyType existingInstance = (ims.core.vo.lookups.TaxonomyType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCodeSystemLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.TaxonomyType)
		{
			ims.core.vo.lookups.TaxonomyType instance = (ims.core.vo.lookups.TaxonomyType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCodeSystemLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.TaxonomyType existingInstance = (ims.core.vo.lookups.TaxonomyType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCodeSystem().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCodeSystemLookup()
	{
		this.form.cmbCodeSystem().clear();
		ims.core.vo.lookups.TaxonomyTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getTaxonomyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCodeSystem().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCodeSystemLookupValue(int id)
	{
		ims.core.vo.lookups.TaxonomyType instance = ims.core.vo.lookups.LookupHelper.getTaxonomyTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCodeSystem().setValue(instance);
	}
	protected final void defaultcmbCodeSystemLookupValue()
	{
		this.form.cmbCodeSystem().setValue((ims.core.vo.lookups.TaxonomyType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.TaxonomyType.class, engine.getFormName().getID(), ims.core.vo.lookups.TaxonomyType.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.chkAssociateSafetyQuestionnaire().setValue(false);
		this.form.chkAssociateReferralLetter().setValue(false);
		this.form.txtHL7Application().setValue("");
		this.form.cmbCategory().setValue(null);
		this.form.txtSystemName().setValue("");
		this.form.cmbPrimaryId().setValue(null);
		this.form.cmbCodeSystem().setValue(null);
		this.form.txtSytemDescription().setValue("");
		this.form.intPort().setValue(null);
	}
	protected void populateScreenFromData(ims.ocrr.vo.ProviderSystemVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getSendQuestionnaireIsNotNull())
			this.form.chkAssociateSafetyQuestionnaire().setValue(value.getSendQuestionnaire().booleanValue());
		if(value.getSendReferralLetterIsNotNull())
			this.form.chkAssociateReferralLetter().setValue(value.getSendReferralLetter().booleanValue());
		this.form.txtHL7Application().setValue(value.getHl7ApplicationIsNotNull() ? value.getHl7Application(): null);
		this.form.cmbCategory().setValue(value.getCategoryIsNotNull() ? value.getCategory() : null);
		this.form.txtSystemName().setValue(value.getSystemNameIsNotNull() ? value.getSystemName(): null);
		this.form.cmbPrimaryId().setValue(value.getPrimaryPatientIdIsNotNull() ? value.getPrimaryPatientId() : null);
		this.form.cmbCodeSystem().setValue(value.getCodeSystemIsNotNull() ? value.getCodeSystem() : null);
		this.form.txtSytemDescription().setValue(value.getDescriptionIsNotNull() ? value.getDescription(): null);
		this.form.intPort().setValue(value.getIPPortIsNotNull() ? value.getIPPort() : null);
	}
	protected ims.ocrr.vo.ProviderSystemVo populateDataFromScreen(ims.ocrr.vo.ProviderSystemVo value)
	{
		if(value == null)
			value = new ims.ocrr.vo.ProviderSystemVo();

		value.setSendQuestionnaire(new Boolean(this.form.chkAssociateSafetyQuestionnaire().getValue()));
		value.setSendReferralLetter(new Boolean(this.form.chkAssociateReferralLetter().getValue()));
		value.setHl7Application(this.form.txtHL7Application().getValue());
		value.setCategory(this.form.cmbCategory().getValue());
		value.setSystemName(this.form.txtSystemName().getValue());
		value.setPrimaryPatientId(this.form.cmbPrimaryId().getValue());
		value.setCodeSystem(this.form.cmbCodeSystem().getValue());
		value.setDescription(this.form.txtSytemDescription().getValue());
		value.setIPPort(this.form.intPort().getValue());

		return value;
	}
	protected ims.ocrr.vo.ProviderSystemVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.ocrr.vo.ProviderSystemVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.admin.domain.ProviderSystem domain;
}
