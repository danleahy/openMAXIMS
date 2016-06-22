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


public class MDTCustomListSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MDTCustomListSearchCriteriaVo()
	{
	}
	public MDTCustomListSearchCriteriaVo(ims.core.vo.beans.MDTCustomListSearchCriteriaVoBean bean)
	{
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.listname = bean.getListName() == null ? null : bean.getListName().buildVo();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MDTCustomListSearchCriteriaVoBean bean)
	{
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.listname = bean.getListName() == null ? null : bean.getListName().buildVo(map);
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MDTCustomListSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MDTCustomListSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MDTCustomListSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getListNameIsNotNull()
	{
		return this.listname != null;
	}
	public ims.core.vo.CustomListVo getListName()
	{
		return this.listname;
	}
	public void setListName(ims.core.vo.CustomListVo value)
	{
		this.isValidated = false;
		this.listname = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.Date getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date = value;
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
	
		MDTCustomListSearchCriteriaVo clone = new MDTCustomListSearchCriteriaVo();
		
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.listname == null)
			clone.listname = null;
		else
			clone.listname = (ims.core.vo.CustomListVo)this.listname.clone();
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
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
		if (!(MDTCustomListSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MDTCustomListSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MDTCustomListSearchCriteriaVo compareObj = (MDTCustomListSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getListName() == null && compareObj.getListName() != null)
				return -1;
			if(this.getListName() != null && compareObj.getListName() == null)
				return 1;
			if(this.getListName() != null && compareObj.getListName() != null)
				retVal = this.getListName().compareTo(compareObj.getListName());
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
		if(this.specialty != null)
			count++;
		if(this.listname != null)
			count++;
		if(this.date != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.CustomListVo listname;
	protected ims.framework.utils.Date date;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
