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

package ims.admin.vo;


public class GPSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GPSearchCriteriaVo()
	{
	}
	public GPSearchCriteriaVo(ims.admin.vo.beans.GPSearchCriteriaVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.practicename = bean.getPracticeName();
		this.addresscontains = bean.getAddressContains();
		this.codetype = bean.getCodeType() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getCodeType());
		this.code = bean.getCode();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.GPStatus.buildLookup(bean.getStatus());
		this.aredistinctrectoberetrieved = bean.getAreDistinctRecToBeRetrieved();
		this.practice = bean.getPractice() == null ? null : new ims.core.resource.place.vo.OrganisationRefVo(new Integer(bean.getPractice().getId()), bean.getPractice().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.GPSearchCriteriaVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.practicename = bean.getPracticeName();
		this.addresscontains = bean.getAddressContains();
		this.codetype = bean.getCodeType() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getCodeType());
		this.code = bean.getCode();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.GPStatus.buildLookup(bean.getStatus());
		this.aredistinctrectoberetrieved = bean.getAreDistinctRecToBeRetrieved();
		this.practice = bean.getPractice() == null ? null : new ims.core.resource.place.vo.OrganisationRefVo(new Integer(bean.getPractice().getId()), bean.getPractice().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.GPSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.GPSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.GPSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 255;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 255;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getPracticeNameIsNotNull()
	{
		return this.practicename != null;
	}
	public String getPracticeName()
	{
		return this.practicename;
	}
	public static int getPracticeNameMaxLength()
	{
		return 255;
	}
	public void setPracticeName(String value)
	{
		this.isValidated = false;
		this.practicename = value;
	}
	public boolean getAddressContainsIsNotNull()
	{
		return this.addresscontains != null;
	}
	public String getAddressContains()
	{
		return this.addresscontains;
	}
	public static int getAddressContainsMaxLength()
	{
		return 255;
	}
	public void setAddressContains(String value)
	{
		this.isValidated = false;
		this.addresscontains = value;
	}
	public boolean getCodeTypeIsNotNull()
	{
		return this.codetype != null;
	}
	public ims.core.vo.lookups.TaxonomyType getCodeType()
	{
		return this.codetype;
	}
	public void setCodeType(ims.core.vo.lookups.TaxonomyType value)
	{
		this.isValidated = false;
		this.codetype = value;
	}
	public boolean getCodeIsNotNull()
	{
		return this.code != null;
	}
	public String getCode()
	{
		return this.code;
	}
	public static int getCodeMaxLength()
	{
		return 255;
	}
	public void setCode(String value)
	{
		this.isValidated = false;
		this.code = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.GPStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.GPStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getAreDistinctRecToBeRetrievedIsNotNull()
	{
		return this.aredistinctrectoberetrieved != null;
	}
	public Boolean getAreDistinctRecToBeRetrieved()
	{
		return this.aredistinctrectoberetrieved;
	}
	public void setAreDistinctRecToBeRetrieved(Boolean value)
	{
		this.isValidated = false;
		this.aredistinctrectoberetrieved = value;
	}
	public boolean getPracticeIsNotNull()
	{
		return this.practice != null;
	}
	public ims.core.resource.place.vo.OrganisationRefVo getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.core.resource.place.vo.OrganisationRefVo value)
	{
		this.isValidated = false;
		this.practice = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof GPSearchCriteriaVo))
			return false;
		GPSearchCriteriaVo compareObj = (GPSearchCriteriaVo)obj;
		if(this.getSurname() == null && compareObj.getSurname() != null)
			return false;
		if(this.getSurname() != null && compareObj.getSurname() == null)
			return false;
		if(this.getSurname() != null && compareObj.getSurname() != null)
			if(!this.getSurname().equals(compareObj.getSurname()))
				return false;
		if(this.getPracticeName() == null && compareObj.getPracticeName() != null)
			return false;
		if(this.getPracticeName() != null && compareObj.getPracticeName() == null)
			return false;
		if(this.getPracticeName() != null && compareObj.getPracticeName() != null)
			if(!this.getPracticeName().equals(compareObj.getPracticeName()))
				return false;
		if(this.getAddressContains() == null && compareObj.getAddressContains() != null)
			return false;
		if(this.getAddressContains() != null && compareObj.getAddressContains() == null)
			return false;
		if(this.getAddressContains() != null && compareObj.getAddressContains() != null)
			if(!this.getAddressContains().equals(compareObj.getAddressContains()))
				return false;
		if(this.getCodeType() == null && compareObj.getCodeType() != null)
			return false;
		if(this.getCodeType() != null && compareObj.getCodeType() == null)
			return false;
		if(this.getCodeType() != null && compareObj.getCodeType() != null)
			if(!this.getCodeType().equals(compareObj.getCodeType()))
				return false;
		if(this.getCode() == null && compareObj.getCode() != null)
			return false;
		if(this.getCode() != null && compareObj.getCode() == null)
			return false;
		if(this.getCode() != null && compareObj.getCode() != null)
			if(!this.getCode().equals(compareObj.getCode()))
				return false;
		if(this.getForename() == null && compareObj.getForename() != null)
			return false;
		if(this.getForename() != null && compareObj.getForename() == null)
			return false;
		if(this.getForename() != null && compareObj.getForename() != null)
			return this.getForename().equals(compareObj.getForename());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		GPSearchCriteriaVo clone = new GPSearchCriteriaVo();
		
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.practicename = this.practicename;
		clone.addresscontains = this.addresscontains;
		if(this.codetype == null)
			clone.codetype = null;
		else
			clone.codetype = (ims.core.vo.lookups.TaxonomyType)this.codetype.clone();
		clone.code = this.code;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.GPStatus)this.status.clone();
		clone.aredistinctrectoberetrieved = this.aredistinctrectoberetrieved;
		clone.practice = this.practice;
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
		if (!(GPSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GPSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		GPSearchCriteriaVo compareObj = (GPSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSurname() == null && compareObj.getSurname() != null)
				return -1;
			if(this.getSurname() != null && compareObj.getSurname() == null)
				return 1;
			if(this.getSurname() != null && compareObj.getSurname() != null)
			{
				if(caseInsensitive)
					retVal = this.getSurname().toLowerCase().compareTo(compareObj.getSurname().toLowerCase());
				else
					retVal = this.getSurname().compareTo(compareObj.getSurname());
			}
		}
		if (retVal == 0)
		{
			if(this.getPracticeName() == null && compareObj.getPracticeName() != null)
				return -1;
			if(this.getPracticeName() != null && compareObj.getPracticeName() == null)
				return 1;
			if(this.getPracticeName() != null && compareObj.getPracticeName() != null)
			{
				if(caseInsensitive)
					retVal = this.getPracticeName().toLowerCase().compareTo(compareObj.getPracticeName().toLowerCase());
				else
					retVal = this.getPracticeName().compareTo(compareObj.getPracticeName());
			}
		}
		if (retVal == 0)
		{
			if(this.getAddressContains() == null && compareObj.getAddressContains() != null)
				return -1;
			if(this.getAddressContains() != null && compareObj.getAddressContains() == null)
				return 1;
			if(this.getAddressContains() != null && compareObj.getAddressContains() != null)
			{
				if(caseInsensitive)
					retVal = this.getAddressContains().toLowerCase().compareTo(compareObj.getAddressContains().toLowerCase());
				else
					retVal = this.getAddressContains().compareTo(compareObj.getAddressContains());
			}
		}
		if (retVal == 0)
		{
			if(this.getCodeType() == null && compareObj.getCodeType() != null)
				return -1;
			if(this.getCodeType() != null && compareObj.getCodeType() == null)
				return 1;
			if(this.getCodeType() != null && compareObj.getCodeType() != null)
				retVal = this.getCodeType().compareTo(compareObj.getCodeType());
		}
		if (retVal == 0)
		{
			if(this.getCode() == null && compareObj.getCode() != null)
				return -1;
			if(this.getCode() != null && compareObj.getCode() == null)
				return 1;
			if(this.getCode() != null && compareObj.getCode() != null)
			{
				if(caseInsensitive)
					retVal = this.getCode().toLowerCase().compareTo(compareObj.getCode().toLowerCase());
				else
					retVal = this.getCode().compareTo(compareObj.getCode());
			}
		}
		if (retVal == 0)
		{
			if(this.getForename() == null && compareObj.getForename() != null)
				return -1;
			if(this.getForename() != null && compareObj.getForename() == null)
				return 1;
			if(this.getForename() != null && compareObj.getForename() != null)
			{
				if(caseInsensitive)
					retVal = this.getForename().toLowerCase().compareTo(compareObj.getForename().toLowerCase());
				else
					retVal = this.getForename().compareTo(compareObj.getForename());
			}
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
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.practicename != null)
			count++;
		if(this.addresscontains != null)
			count++;
		if(this.codetype != null)
			count++;
		if(this.code != null)
			count++;
		if(this.status != null)
			count++;
		if(this.aredistinctrectoberetrieved != null)
			count++;
		if(this.practice != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String surname;
	protected String forename;
	protected String practicename;
	protected String addresscontains;
	protected ims.core.vo.lookups.TaxonomyType codetype;
	protected String code;
	protected ims.core.vo.lookups.GPStatus status;
	protected Boolean aredistinctrectoberetrieved;
	protected ims.core.resource.place.vo.OrganisationRefVo practice;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
