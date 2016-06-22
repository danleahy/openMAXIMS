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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.SplintDetails business object (ID: 1019100041).
 */
public class SplintDetailsVo extends ims.therapies.treatment.vo.SplintDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SplintDetailsVo()
	{
	}
	public SplintDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public SplintDetailsVo(ims.therapies.vo.beans.SplintDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.area = bean.getArea() == null ? null : ims.spinalinjuries.vo.lookups.SplintArea.buildLookup(bean.getArea());
		this.splintcategory = bean.getSplintCategory() == null ? null : ims.spinalinjuries.vo.lookups.SplintCategory.buildLookup(bean.getSplintCategory());
		this.material = bean.getMaterial() == null ? null : ims.spinalinjuries.vo.lookups.SplintMaterial.buildLookup(bean.getMaterial());
		this.product = bean.getProduct() == null ? null : ims.spinalinjuries.vo.lookups.SplintProduct.buildLookup(bean.getProduct());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRonly.buildLookup(bean.getLaterality());
		this.splinttype = bean.getSplintType() == null ? null : ims.spinalinjuries.vo.lookups.SplintType.buildLookup(bean.getSplintType());
		this.splintbase = bean.getSplintBase() == null ? null : ims.spinalinjuries.vo.lookups.SplintBase.buildLookup(bean.getSplintBase());
		this.splintsize = bean.getSplintSize() == null ? null : ims.spinalinjuries.vo.lookups.SplintSize.buildLookup(bean.getSplintSize());
		this.splintswearregime = ims.therapies.vo.SplintsWearRegimeVoCollection.buildFromBeanCollection(bean.getSplintsWearRegime());
		this.splintinstructions = ims.therapies.vo.SplintsInstructionDetailsVoCollection.buildFromBeanCollection(bean.getSplintInstructions());
		this.splintadditionalfeatures = ims.therapies.vo.SplintAdditionalFeaturesVoCollection.buildFromBeanCollection(bean.getSplintAdditionalFeatures());
		this.consentgiven = bean.getConsentGiven() == null ? null : bean.getConsentGiven().buildVo();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.SplintDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.area = bean.getArea() == null ? null : ims.spinalinjuries.vo.lookups.SplintArea.buildLookup(bean.getArea());
		this.splintcategory = bean.getSplintCategory() == null ? null : ims.spinalinjuries.vo.lookups.SplintCategory.buildLookup(bean.getSplintCategory());
		this.material = bean.getMaterial() == null ? null : ims.spinalinjuries.vo.lookups.SplintMaterial.buildLookup(bean.getMaterial());
		this.product = bean.getProduct() == null ? null : ims.spinalinjuries.vo.lookups.SplintProduct.buildLookup(bean.getProduct());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRonly.buildLookup(bean.getLaterality());
		this.splinttype = bean.getSplintType() == null ? null : ims.spinalinjuries.vo.lookups.SplintType.buildLookup(bean.getSplintType());
		this.splintbase = bean.getSplintBase() == null ? null : ims.spinalinjuries.vo.lookups.SplintBase.buildLookup(bean.getSplintBase());
		this.splintsize = bean.getSplintSize() == null ? null : ims.spinalinjuries.vo.lookups.SplintSize.buildLookup(bean.getSplintSize());
		this.splintswearregime = ims.therapies.vo.SplintsWearRegimeVoCollection.buildFromBeanCollection(bean.getSplintsWearRegime());
		this.splintinstructions = ims.therapies.vo.SplintsInstructionDetailsVoCollection.buildFromBeanCollection(bean.getSplintInstructions());
		this.splintadditionalfeatures = ims.therapies.vo.SplintAdditionalFeaturesVoCollection.buildFromBeanCollection(bean.getSplintAdditionalFeatures());
		this.consentgiven = bean.getConsentGiven() == null ? null : bean.getConsentGiven().buildVo(map);
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.SplintDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.SplintDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.SplintDetailsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("AREA"))
			return getArea();
		if(fieldName.equals("SPLINTCATEGORY"))
			return getSplintCategory();
		if(fieldName.equals("MATERIAL"))
			return getMaterial();
		if(fieldName.equals("PRODUCT"))
			return getProduct();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		if(fieldName.equals("SPLINTTYPE"))
			return getSplintType();
		if(fieldName.equals("SPLINTBASE"))
			return getSplintBase();
		if(fieldName.equals("SPLINTSIZE"))
			return getSplintSize();
		if(fieldName.equals("SPLINTSWEARREGIME"))
			return getSplintsWearRegime();
		if(fieldName.equals("SPLINTINSTRUCTIONS"))
			return getSplintInstructions();
		if(fieldName.equals("SPLINTADDITIONALFEATURES"))
			return getSplintAdditionalFeatures();
		if(fieldName.equals("CONSENTGIVEN"))
			return getConsentGiven();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getAreaIsNotNull()
	{
		return this.area != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintArea getArea()
	{
		return this.area;
	}
	public void setArea(ims.spinalinjuries.vo.lookups.SplintArea value)
	{
		this.isValidated = false;
		this.area = value;
	}
	public boolean getSplintCategoryIsNotNull()
	{
		return this.splintcategory != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintCategory getSplintCategory()
	{
		return this.splintcategory;
	}
	public void setSplintCategory(ims.spinalinjuries.vo.lookups.SplintCategory value)
	{
		this.isValidated = false;
		this.splintcategory = value;
	}
	public boolean getMaterialIsNotNull()
	{
		return this.material != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintMaterial getMaterial()
	{
		return this.material;
	}
	public void setMaterial(ims.spinalinjuries.vo.lookups.SplintMaterial value)
	{
		this.isValidated = false;
		this.material = value;
	}
	public boolean getProductIsNotNull()
	{
		return this.product != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintProduct getProduct()
	{
		return this.product;
	}
	public void setProduct(ims.spinalinjuries.vo.lookups.SplintProduct value)
	{
		this.isValidated = false;
		this.product = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public ims.core.vo.lookups.LateralityLRonly getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.core.vo.lookups.LateralityLRonly value)
	{
		this.isValidated = false;
		this.laterality = value;
	}
	public boolean getSplintTypeIsNotNull()
	{
		return this.splinttype != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintType getSplintType()
	{
		return this.splinttype;
	}
	public void setSplintType(ims.spinalinjuries.vo.lookups.SplintType value)
	{
		this.isValidated = false;
		this.splinttype = value;
	}
	public boolean getSplintBaseIsNotNull()
	{
		return this.splintbase != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintBase getSplintBase()
	{
		return this.splintbase;
	}
	public void setSplintBase(ims.spinalinjuries.vo.lookups.SplintBase value)
	{
		this.isValidated = false;
		this.splintbase = value;
	}
	public boolean getSplintSizeIsNotNull()
	{
		return this.splintsize != null;
	}
	public ims.spinalinjuries.vo.lookups.SplintSize getSplintSize()
	{
		return this.splintsize;
	}
	public void setSplintSize(ims.spinalinjuries.vo.lookups.SplintSize value)
	{
		this.isValidated = false;
		this.splintsize = value;
	}
	public boolean getSplintsWearRegimeIsNotNull()
	{
		return this.splintswearregime != null;
	}
	public ims.therapies.vo.SplintsWearRegimeVoCollection getSplintsWearRegime()
	{
		return this.splintswearregime;
	}
	public void setSplintsWearRegime(ims.therapies.vo.SplintsWearRegimeVoCollection value)
	{
		this.isValidated = false;
		this.splintswearregime = value;
	}
	public boolean getSplintInstructionsIsNotNull()
	{
		return this.splintinstructions != null;
	}
	public ims.therapies.vo.SplintsInstructionDetailsVoCollection getSplintInstructions()
	{
		return this.splintinstructions;
	}
	public void setSplintInstructions(ims.therapies.vo.SplintsInstructionDetailsVoCollection value)
	{
		this.isValidated = false;
		this.splintinstructions = value;
	}
	public boolean getSplintAdditionalFeaturesIsNotNull()
	{
		return this.splintadditionalfeatures != null;
	}
	public ims.therapies.vo.SplintAdditionalFeaturesVoCollection getSplintAdditionalFeatures()
	{
		return this.splintadditionalfeatures;
	}
	public void setSplintAdditionalFeatures(ims.therapies.vo.SplintAdditionalFeaturesVoCollection value)
	{
		this.isValidated = false;
		this.splintadditionalfeatures = value;
	}
	public boolean getConsentGivenIsNotNull()
	{
		return this.consentgiven != null;
	}
	public ims.core.vo.ConsentGivenVo getConsentGiven()
	{
		return this.consentgiven;
	}
	public void setConsentGiven(ims.core.vo.ConsentGivenVo value)
	{
		this.isValidated = false;
		this.consentgiven = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.splintswearregime != null)
		{
			if(!this.splintswearregime.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.splintinstructions != null)
		{
			if(!this.splintinstructions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.splintadditionalfeatures != null)
		{
			if(!this.splintadditionalfeatures.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.consentgiven != null)
		{
			if(!this.consentgiven.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.authoringcp == null)
			listOfErrors.add("AuthoringCP is mandatory");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.startdate == null)
			listOfErrors.add("Start Date is a mandatory field");
		if(this.area == null)
			listOfErrors.add("Area is a mandatory field");
		if(this.splintswearregime != null)
		{
			String[] listOfOtherErrors = this.splintswearregime.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.splintinstructions != null)
		{
			String[] listOfOtherErrors = this.splintinstructions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.splintadditionalfeatures != null)
		{
			String[] listOfOtherErrors = this.splintadditionalfeatures.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.consentgiven != null)
		{
			String[] listOfOtherErrors = this.consentgiven.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		SplintDetailsVo clone = new SplintDetailsVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.area == null)
			clone.area = null;
		else
			clone.area = (ims.spinalinjuries.vo.lookups.SplintArea)this.area.clone();
		if(this.splintcategory == null)
			clone.splintcategory = null;
		else
			clone.splintcategory = (ims.spinalinjuries.vo.lookups.SplintCategory)this.splintcategory.clone();
		if(this.material == null)
			clone.material = null;
		else
			clone.material = (ims.spinalinjuries.vo.lookups.SplintMaterial)this.material.clone();
		if(this.product == null)
			clone.product = null;
		else
			clone.product = (ims.spinalinjuries.vo.lookups.SplintProduct)this.product.clone();
		if(this.laterality == null)
			clone.laterality = null;
		else
			clone.laterality = (ims.core.vo.lookups.LateralityLRonly)this.laterality.clone();
		if(this.splinttype == null)
			clone.splinttype = null;
		else
			clone.splinttype = (ims.spinalinjuries.vo.lookups.SplintType)this.splinttype.clone();
		if(this.splintbase == null)
			clone.splintbase = null;
		else
			clone.splintbase = (ims.spinalinjuries.vo.lookups.SplintBase)this.splintbase.clone();
		if(this.splintsize == null)
			clone.splintsize = null;
		else
			clone.splintsize = (ims.spinalinjuries.vo.lookups.SplintSize)this.splintsize.clone();
		if(this.splintswearregime == null)
			clone.splintswearregime = null;
		else
			clone.splintswearregime = (ims.therapies.vo.SplintsWearRegimeVoCollection)this.splintswearregime.clone();
		if(this.splintinstructions == null)
			clone.splintinstructions = null;
		else
			clone.splintinstructions = (ims.therapies.vo.SplintsInstructionDetailsVoCollection)this.splintinstructions.clone();
		if(this.splintadditionalfeatures == null)
			clone.splintadditionalfeatures = null;
		else
			clone.splintadditionalfeatures = (ims.therapies.vo.SplintAdditionalFeaturesVoCollection)this.splintadditionalfeatures.clone();
		if(this.consentgiven == null)
			clone.consentgiven = null;
		else
			clone.consentgiven = (ims.core.vo.ConsentGivenVo)this.consentgiven.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(SplintDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SplintDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SplintDetailsVo compareObj = (SplintDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_SplintDetails() == null && compareObj.getID_SplintDetails() != null)
				return -1;
			if(this.getID_SplintDetails() != null && compareObj.getID_SplintDetails() == null)
				return 1;
			if(this.getID_SplintDetails() != null && compareObj.getID_SplintDetails() != null)
				retVal = this.getID_SplintDetails().compareTo(compareObj.getID_SplintDetails());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalcontact != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.area != null)
			count++;
		if(this.splintcategory != null)
			count++;
		if(this.material != null)
			count++;
		if(this.product != null)
			count++;
		if(this.laterality != null)
			count++;
		if(this.splinttype != null)
			count++;
		if(this.splintbase != null)
			count++;
		if(this.splintsize != null)
			count++;
		if(this.splintswearregime != null)
			count++;
		if(this.splintinstructions != null)
			count++;
		if(this.splintadditionalfeatures != null)
			count++;
		if(this.consentgiven != null)
			count++;
		if(this.enddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 17;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.framework.utils.Date startdate;
	protected ims.spinalinjuries.vo.lookups.SplintArea area;
	protected ims.spinalinjuries.vo.lookups.SplintCategory splintcategory;
	protected ims.spinalinjuries.vo.lookups.SplintMaterial material;
	protected ims.spinalinjuries.vo.lookups.SplintProduct product;
	protected ims.core.vo.lookups.LateralityLRonly laterality;
	protected ims.spinalinjuries.vo.lookups.SplintType splinttype;
	protected ims.spinalinjuries.vo.lookups.SplintBase splintbase;
	protected ims.spinalinjuries.vo.lookups.SplintSize splintsize;
	protected ims.therapies.vo.SplintsWearRegimeVoCollection splintswearregime;
	protected ims.therapies.vo.SplintsInstructionDetailsVoCollection splintinstructions;
	protected ims.therapies.vo.SplintAdditionalFeaturesVoCollection splintadditionalfeatures;
	protected ims.core.vo.ConsentGivenVo consentgiven;
	protected ims.framework.utils.Date enddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
