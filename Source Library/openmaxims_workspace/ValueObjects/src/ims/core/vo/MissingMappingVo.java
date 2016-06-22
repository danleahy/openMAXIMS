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


public class MissingMappingVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MissingMappingVo()
	{
	}
	public MissingMappingVo(ims.core.vo.beans.MissingMappingVoBean bean)
	{
		this.pdsfield = bean.getPdsField();
		this.message = bean.getMessage();
		this.objectidentifier = bean.getObjectidentifier();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MissingMappingVoBean bean)
	{
		this.pdsfield = bean.getPdsField();
		this.message = bean.getMessage();
		this.objectidentifier = bean.getObjectidentifier();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MissingMappingVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MissingMappingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MissingMappingVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPdsFieldIsNotNull()
	{
		return this.pdsfield != null;
	}
	public Integer getPdsField()
	{
		return this.pdsfield;
	}
	public void setPdsField(Integer value)
	{
		this.isValidated = false;
		this.pdsfield = value;
	}
	public boolean getMessageIsNotNull()
	{
		return this.message != null;
	}
	public String getMessage()
	{
		return this.message;
	}
	public static int getMessageMaxLength()
	{
		return 255;
	}
	public void setMessage(String value)
	{
		this.isValidated = false;
		this.message = value;
	}
	public boolean getObjectidentifierIsNotNull()
	{
		return this.objectidentifier != null;
	}
	public String getObjectidentifier()
	{
		return this.objectidentifier;
	}
	public static int getObjectidentifierMaxLength()
	{
		return 255;
	}
	public void setObjectidentifier(String value)
	{
		this.isValidated = false;
		this.objectidentifier = value;
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
		if(!(obj instanceof MissingMappingVo))
			return false;
		MissingMappingVo compareObj = (MissingMappingVo)obj;
		if(this.getPdsField() == null && compareObj.getPdsField() != null)
			return false;
		if(this.getPdsField() != null && compareObj.getPdsField() == null)
			return false;
		if(this.getPdsField() != null && compareObj.getPdsField() != null)
			if(!this.getPdsField().equals(compareObj.getPdsField()))
				return false;
		if(this.getMessage() == null && compareObj.getMessage() != null)
			return false;
		if(this.getMessage() != null && compareObj.getMessage() == null)
			return false;
		if(this.getMessage() != null && compareObj.getMessage() != null)
			return this.getMessage().equals(compareObj.getMessage());
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
	
		MissingMappingVo clone = new MissingMappingVo();
		
		clone.pdsfield = this.pdsfield;
		clone.message = this.message;
		clone.objectidentifier = this.objectidentifier;
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
		if (!(MissingMappingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MissingMappingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MissingMappingVo compareObj = (MissingMappingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPdsField() == null && compareObj.getPdsField() != null)
				return -1;
			if(this.getPdsField() != null && compareObj.getPdsField() == null)
				return 1;
			if(this.getPdsField() != null && compareObj.getPdsField() != null)
				retVal = this.getPdsField().compareTo(compareObj.getPdsField());
		}
		if (retVal == 0)
		{
			if(this.getMessage() == null && compareObj.getMessage() != null)
				return -1;
			if(this.getMessage() != null && compareObj.getMessage() == null)
				return 1;
			if(this.getMessage() != null && compareObj.getMessage() != null)
			{
				if(caseInsensitive)
					retVal = this.getMessage().toLowerCase().compareTo(compareObj.getMessage().toLowerCase());
				else
					retVal = this.getMessage().compareTo(compareObj.getMessage());
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
		if(this.pdsfield != null)
			count++;
		if(this.message != null)
			count++;
		if(this.objectidentifier != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected Integer pdsfield;
	protected String message;
	protected String objectidentifier;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
