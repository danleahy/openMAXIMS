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

package ims.clinical.vo;


public class EMISDiariesVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EMISDiariesVo()
	{
	}
	public EMISDiariesVo(ims.clinical.vo.beans.EMISDiariesVoBean bean)
	{
		this.diary = bean.getDiary();
		this.effectivedate = bean.getEffectiveDate();
		this.originalterm = bean.getOriginalTerm();
		this.confidentialitypolicy = bean.getConfidentialityPolicy();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EMISDiariesVoBean bean)
	{
		this.diary = bean.getDiary();
		this.effectivedate = bean.getEffectiveDate();
		this.originalterm = bean.getOriginalTerm();
		this.confidentialitypolicy = bean.getConfidentialityPolicy();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EMISDiariesVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EMISDiariesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EMISDiariesVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getDiaryIsNotNull()
	{
		return this.diary != null;
	}
	public String getDiary()
	{
		return this.diary;
	}
	public static int getDiaryMaxLength()
	{
		return 255;
	}
	public void setDiary(String value)
	{
		this.isValidated = false;
		this.diary = value;
	}
	public boolean getEffectiveDateIsNotNull()
	{
		return this.effectivedate != null;
	}
	public String getEffectiveDate()
	{
		return this.effectivedate;
	}
	public static int getEffectiveDateMaxLength()
	{
		return 255;
	}
	public void setEffectiveDate(String value)
	{
		this.isValidated = false;
		this.effectivedate = value;
	}
	public boolean getOriginalTermIsNotNull()
	{
		return this.originalterm != null;
	}
	public String getOriginalTerm()
	{
		return this.originalterm;
	}
	public static int getOriginalTermMaxLength()
	{
		return 255;
	}
	public void setOriginalTerm(String value)
	{
		this.isValidated = false;
		this.originalterm = value;
	}
	public boolean getConfidentialityPolicyIsNotNull()
	{
		return this.confidentialitypolicy != null;
	}
	public String getConfidentialityPolicy()
	{
		return this.confidentialitypolicy;
	}
	public static int getConfidentialityPolicyMaxLength()
	{
		return 255;
	}
	public void setConfidentialityPolicy(String value)
	{
		this.isValidated = false;
		this.confidentialitypolicy = value;
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
		if(!(obj instanceof EMISDiariesVo))
			return false;
		EMISDiariesVo compareObj = (EMISDiariesVo)obj;
		if(this.getDiary() == null && compareObj.getDiary() != null)
			return false;
		if(this.getDiary() != null && compareObj.getDiary() == null)
			return false;
		if(this.getDiary() != null && compareObj.getDiary() != null)
			return this.getDiary().equals(compareObj.getDiary());
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
	
		EMISDiariesVo clone = new EMISDiariesVo();
		
		clone.diary = this.diary;
		clone.effectivedate = this.effectivedate;
		clone.originalterm = this.originalterm;
		clone.confidentialitypolicy = this.confidentialitypolicy;
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
		if (!(EMISDiariesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EMISDiariesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EMISDiariesVo compareObj = (EMISDiariesVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDiary() == null && compareObj.getDiary() != null)
				return -1;
			if(this.getDiary() != null && compareObj.getDiary() == null)
				return 1;
			if(this.getDiary() != null && compareObj.getDiary() != null)
			{
				if(caseInsensitive)
					retVal = this.getDiary().toLowerCase().compareTo(compareObj.getDiary().toLowerCase());
				else
					retVal = this.getDiary().compareTo(compareObj.getDiary());
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
		if(this.diary != null)
			count++;
		if(this.effectivedate != null)
			count++;
		if(this.originalterm != null)
			count++;
		if(this.confidentialitypolicy != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String diary;
	protected String effectivedate;
	protected String originalterm;
	protected String confidentialitypolicy;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
