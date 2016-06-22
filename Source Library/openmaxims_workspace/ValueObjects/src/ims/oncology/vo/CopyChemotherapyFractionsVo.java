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

package ims.oncology.vo;


public class CopyChemotherapyFractionsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CopyChemotherapyFractionsVo()
	{
	}
	public CopyChemotherapyFractionsVo(ims.oncology.vo.beans.CopyChemotherapyFractionsVoBean bean)
	{
		this.cyclenumber = bean.getCycleNumber();
		this.daydetails = bean.getDayDetails() == null ? null : bean.getDayDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.CopyChemotherapyFractionsVoBean bean)
	{
		this.cyclenumber = bean.getCycleNumber();
		this.daydetails = bean.getDayDetails() == null ? null : bean.getDayDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.CopyChemotherapyFractionsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.CopyChemotherapyFractionsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.CopyChemotherapyFractionsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getCycleNumberIsNotNull()
	{
		return this.cyclenumber != null;
	}
	public String getCycleNumber()
	{
		return this.cyclenumber;
	}
	public static int getCycleNumberMaxLength()
	{
		return 255;
	}
	public void setCycleNumber(String value)
	{
		this.isValidated = false;
		this.cyclenumber = value;
	}
	public boolean getDayDetailsIsNotNull()
	{
		return this.daydetails != null;
	}
	public ims.oncology.vo.ChemoTherapyDayDetailsVo getDayDetails()
	{
		return this.daydetails;
	}
	public void setDayDetails(ims.oncology.vo.ChemoTherapyDayDetailsVo value)
	{
		this.isValidated = false;
		this.daydetails = value;
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
		if(!(obj instanceof CopyChemotherapyFractionsVo))
			return false;
		CopyChemotherapyFractionsVo compareObj = (CopyChemotherapyFractionsVo)obj;
		if(this.getDayDetails() == null && compareObj.getDayDetails() != null)
			return false;
		if(this.getDayDetails() != null && compareObj.getDayDetails() == null)
			return false;
		if(this.getDayDetails() != null && compareObj.getDayDetails() != null)
			return this.getDayDetails().equals(compareObj.getDayDetails());
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
		if(this.daydetails != null)
		{
			if(!this.daydetails.isValidated())
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
		if(this.daydetails != null)
		{
			String[] listOfOtherErrors = this.daydetails.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		CopyChemotherapyFractionsVo clone = new CopyChemotherapyFractionsVo();
		
		clone.cyclenumber = this.cyclenumber;
		if(this.daydetails == null)
			clone.daydetails = null;
		else
			clone.daydetails = (ims.oncology.vo.ChemoTherapyDayDetailsVo)this.daydetails.clone();
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
		if (!(CopyChemotherapyFractionsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CopyChemotherapyFractionsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CopyChemotherapyFractionsVo compareObj = (CopyChemotherapyFractionsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDayDetails() == null && compareObj.getDayDetails() != null)
				return -1;
			if(this.getDayDetails() != null && compareObj.getDayDetails() == null)
				return 1;
			if(this.getDayDetails() != null && compareObj.getDayDetails() != null)
				retVal = this.getDayDetails().compareTo(compareObj.getDayDetails());
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
		if(this.cyclenumber != null)
			count++;
		if(this.daydetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String cyclenumber;
	protected ims.oncology.vo.ChemoTherapyDayDetailsVo daydetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
