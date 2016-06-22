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

package ims.core.vo;

/**
 * Linked to core.patient.NationalHealthCover business object (ID: 1001100005).
 */
public class NationalHealthCoverVo extends ims.core.patient.vo.NationalHealthCoverRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NationalHealthCoverVo()
	{
	}
	public NationalHealthCoverVo(Integer id, int version)
	{
		super(id, version);
	}
	public NationalHealthCoverVo(ims.core.vo.beans.NationalHealthCoverVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medicalcardno = bean.getMedicalCardNo();
		this.healthactcategory = bean.getHealthActCategory() == null ? null : ims.core.vo.lookups.PersonHealthActCategory.buildLookup(bean.getHealthActCategory());
		this.ehicnumber = bean.getEHICNumber();
		this.ehicexpirydate = bean.getEHICExpiryDate() == null ? null : bean.getEHICExpiryDate().buildPartialDate();
		this.ehiccountry = bean.getEHICCountry() == null ? null : ims.core.vo.lookups.Country.buildLookup(bean.getEHICCountry());
		this.ehicinstitution = bean.getEHICInstitution();
		this.medicalcardproved = bean.getMedicalCardProved() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getMedicalCardProved());
		this.eligibilityproof = bean.getEligibilityProof();
		this.medicalcardexpirydate = bean.getMedicalCardExpiryDate() == null ? null : bean.getMedicalCardExpiryDate().buildPartialDate();
		this.ehicinstitutioncode = bean.getEHICInstitutionCode() == null ? null : ims.core.vo.lookups.Institution.buildLookup(bean.getEHICInstitutionCode());
		this.eligibility = bean.getEligibility() == null ? null : ims.core.vo.lookups.Eligibility.buildLookup(bean.getEligibility());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.NationalHealthCoverVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.medicalcardno = bean.getMedicalCardNo();
		this.healthactcategory = bean.getHealthActCategory() == null ? null : ims.core.vo.lookups.PersonHealthActCategory.buildLookup(bean.getHealthActCategory());
		this.ehicnumber = bean.getEHICNumber();
		this.ehicexpirydate = bean.getEHICExpiryDate() == null ? null : bean.getEHICExpiryDate().buildPartialDate();
		this.ehiccountry = bean.getEHICCountry() == null ? null : ims.core.vo.lookups.Country.buildLookup(bean.getEHICCountry());
		this.ehicinstitution = bean.getEHICInstitution();
		this.medicalcardproved = bean.getMedicalCardProved() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getMedicalCardProved());
		this.eligibilityproof = bean.getEligibilityProof();
		this.medicalcardexpirydate = bean.getMedicalCardExpiryDate() == null ? null : bean.getMedicalCardExpiryDate().buildPartialDate();
		this.ehicinstitutioncode = bean.getEHICInstitutionCode() == null ? null : ims.core.vo.lookups.Institution.buildLookup(bean.getEHICInstitutionCode());
		this.eligibility = bean.getEligibility() == null ? null : ims.core.vo.lookups.Eligibility.buildLookup(bean.getEligibility());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.NationalHealthCoverVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.NationalHealthCoverVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.NationalHealthCoverVoBean();
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
		if(fieldName.equals("MEDICALCARDNO"))
			return getMedicalCardNo();
		if(fieldName.equals("HEALTHACTCATEGORY"))
			return getHealthActCategory();
		if(fieldName.equals("EHICNUMBER"))
			return getEHICNumber();
		if(fieldName.equals("EHICEXPIRYDATE"))
			return getEHICExpiryDate();
		if(fieldName.equals("EHICCOUNTRY"))
			return getEHICCountry();
		if(fieldName.equals("EHICINSTITUTION"))
			return getEHICInstitution();
		if(fieldName.equals("MEDICALCARDPROVED"))
			return getMedicalCardProved();
		if(fieldName.equals("ELIGIBILITYPROOF"))
			return getEligibilityProof();
		if(fieldName.equals("MEDICALCARDEXPIRYDATE"))
			return getMedicalCardExpiryDate();
		if(fieldName.equals("EHICINSTITUTIONCODE"))
			return getEHICInstitutionCode();
		if(fieldName.equals("ELIGIBILITY"))
			return getEligibility();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMedicalCardNoIsNotNull()
	{
		return this.medicalcardno != null;
	}
	public String getMedicalCardNo()
	{
		return this.medicalcardno;
	}
	public static int getMedicalCardNoMaxLength()
	{
		return 50;
	}
	public void setMedicalCardNo(String value)
	{
		this.isValidated = false;
		this.medicalcardno = value;
	}
	public boolean getHealthActCategoryIsNotNull()
	{
		return this.healthactcategory != null;
	}
	public ims.core.vo.lookups.PersonHealthActCategory getHealthActCategory()
	{
		return this.healthactcategory;
	}
	public void setHealthActCategory(ims.core.vo.lookups.PersonHealthActCategory value)
	{
		this.isValidated = false;
		this.healthactcategory = value;
	}
	public boolean getEHICNumberIsNotNull()
	{
		return this.ehicnumber != null;
	}
	public String getEHICNumber()
	{
		return this.ehicnumber;
	}
	public static int getEHICNumberMaxLength()
	{
		return 20;
	}
	public void setEHICNumber(String value)
	{
		this.isValidated = false;
		this.ehicnumber = value;
	}
	public boolean getEHICExpiryDateIsNotNull()
	{
		return this.ehicexpirydate != null;
	}
	public ims.framework.utils.PartialDate getEHICExpiryDate()
	{
		return this.ehicexpirydate;
	}
	public void setEHICExpiryDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.ehicexpirydate = value;
	}
	public boolean getEHICCountryIsNotNull()
	{
		return this.ehiccountry != null;
	}
	public ims.core.vo.lookups.Country getEHICCountry()
	{
		return this.ehiccountry;
	}
	public void setEHICCountry(ims.core.vo.lookups.Country value)
	{
		this.isValidated = false;
		this.ehiccountry = value;
	}
	public boolean getEHICInstitutionIsNotNull()
	{
		return this.ehicinstitution != null;
	}
	public String getEHICInstitution()
	{
		return this.ehicinstitution;
	}
	public static int getEHICInstitutionMaxLength()
	{
		return 255;
	}
	public void setEHICInstitution(String value)
	{
		this.isValidated = false;
		this.ehicinstitution = value;
	}
	public boolean getMedicalCardProvedIsNotNull()
	{
		return this.medicalcardproved != null;
	}
	public ims.core.vo.lookups.YesNo getMedicalCardProved()
	{
		return this.medicalcardproved;
	}
	public void setMedicalCardProved(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.medicalcardproved = value;
	}
	public boolean getEligibilityProofIsNotNull()
	{
		return this.eligibilityproof != null;
	}
	public String getEligibilityProof()
	{
		return this.eligibilityproof;
	}
	public static int getEligibilityProofMaxLength()
	{
		return 255;
	}
	public void setEligibilityProof(String value)
	{
		this.isValidated = false;
		this.eligibilityproof = value;
	}
	public boolean getMedicalCardExpiryDateIsNotNull()
	{
		return this.medicalcardexpirydate != null;
	}
	public ims.framework.utils.PartialDate getMedicalCardExpiryDate()
	{
		return this.medicalcardexpirydate;
	}
	public void setMedicalCardExpiryDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.medicalcardexpirydate = value;
	}
	public boolean getEHICInstitutionCodeIsNotNull()
	{
		return this.ehicinstitutioncode != null;
	}
	public ims.core.vo.lookups.Institution getEHICInstitutionCode()
	{
		return this.ehicinstitutioncode;
	}
	public void setEHICInstitutionCode(ims.core.vo.lookups.Institution value)
	{
		this.isValidated = false;
		this.ehicinstitutioncode = value;
	}
	public boolean getEligibilityIsNotNull()
	{
		return this.eligibility != null;
	}
	public ims.core.vo.lookups.Eligibility getEligibility()
	{
		return this.eligibility;
	}
	public void setEligibility(ims.core.vo.lookups.Eligibility value)
	{
		this.isValidated = false;
		this.eligibility = value;
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
		if(this.medicalcardno != null)
			if(this.medicalcardno.length() > 50)
				listOfErrors.add("The length of the field [medicalcardno] in the value object [ims.core.vo.NationalHealthCoverVo] is too big. It should be less or equal to 50");
		if(this.ehicnumber != null)
			if(this.ehicnumber.length() > 20)
				listOfErrors.add("The length of the field [ehicnumber] in the value object [ims.core.vo.NationalHealthCoverVo] is too big. It should be less or equal to 20");
		if(this.ehicinstitution != null)
			if(this.ehicinstitution.length() > 255)
				listOfErrors.add("The length of the field [ehicinstitution] in the value object [ims.core.vo.NationalHealthCoverVo] is too big. It should be less or equal to 255");
		if(this.eligibilityproof != null)
			if(this.eligibilityproof.length() > 255)
				listOfErrors.add("The length of the field [eligibilityproof] in the value object [ims.core.vo.NationalHealthCoverVo] is too big. It should be less or equal to 255");
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
	
		NationalHealthCoverVo clone = new NationalHealthCoverVo(this.id, this.version);
		
		clone.medicalcardno = this.medicalcardno;
		if(this.healthactcategory == null)
			clone.healthactcategory = null;
		else
			clone.healthactcategory = (ims.core.vo.lookups.PersonHealthActCategory)this.healthactcategory.clone();
		clone.ehicnumber = this.ehicnumber;
		if(this.ehicexpirydate == null)
			clone.ehicexpirydate = null;
		else
			clone.ehicexpirydate = (ims.framework.utils.PartialDate)this.ehicexpirydate.clone();
		if(this.ehiccountry == null)
			clone.ehiccountry = null;
		else
			clone.ehiccountry = (ims.core.vo.lookups.Country)this.ehiccountry.clone();
		clone.ehicinstitution = this.ehicinstitution;
		if(this.medicalcardproved == null)
			clone.medicalcardproved = null;
		else
			clone.medicalcardproved = (ims.core.vo.lookups.YesNo)this.medicalcardproved.clone();
		clone.eligibilityproof = this.eligibilityproof;
		if(this.medicalcardexpirydate == null)
			clone.medicalcardexpirydate = null;
		else
			clone.medicalcardexpirydate = (ims.framework.utils.PartialDate)this.medicalcardexpirydate.clone();
		if(this.ehicinstitutioncode == null)
			clone.ehicinstitutioncode = null;
		else
			clone.ehicinstitutioncode = (ims.core.vo.lookups.Institution)this.ehicinstitutioncode.clone();
		if(this.eligibility == null)
			clone.eligibility = null;
		else
			clone.eligibility = (ims.core.vo.lookups.Eligibility)this.eligibility.clone();
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
		if (!(NationalHealthCoverVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NationalHealthCoverVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NationalHealthCoverVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NationalHealthCoverVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.medicalcardno != null)
			count++;
		if(this.healthactcategory != null)
			count++;
		if(this.ehicnumber != null)
			count++;
		if(this.ehicexpirydate != null)
			count++;
		if(this.ehiccountry != null)
			count++;
		if(this.ehicinstitution != null)
			count++;
		if(this.medicalcardproved != null)
			count++;
		if(this.eligibilityproof != null)
			count++;
		if(this.medicalcardexpirydate != null)
			count++;
		if(this.ehicinstitutioncode != null)
			count++;
		if(this.eligibility != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected String medicalcardno;
	protected ims.core.vo.lookups.PersonHealthActCategory healthactcategory;
	protected String ehicnumber;
	protected ims.framework.utils.PartialDate ehicexpirydate;
	protected ims.core.vo.lookups.Country ehiccountry;
	protected String ehicinstitution;
	protected ims.core.vo.lookups.YesNo medicalcardproved;
	protected String eligibilityproof;
	protected ims.framework.utils.PartialDate medicalcardexpirydate;
	protected ims.core.vo.lookups.Institution ehicinstitutioncode;
	protected ims.core.vo.lookups.Eligibility eligibility;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
