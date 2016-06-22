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

package ims.ntpf.vo;

/**
 * Linked to core.resource.place.CodingAlertConfiguration business object (ID: 1038100002).
 */
public class CodingAlertConfigurationVo extends ims.core.resource.place.vo.CodingAlertConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CodingAlertConfigurationVo()
	{
	}
	public CodingAlertConfigurationVo(Integer id, int version)
	{
		super(id, version);
	}
	public CodingAlertConfigurationVo(ims.ntpf.vo.beans.CodingAlertConfigurationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.email = bean.getEmail();
		this.user = bean.getUser() == null ? null : bean.getUser().buildVo();
		this.description = bean.getDescription();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ntpf.vo.beans.CodingAlertConfigurationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.email = bean.getEmail();
		this.user = bean.getUser() == null ? null : bean.getUser().buildVo(map);
		this.description = bean.getDescription();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ntpf.vo.beans.CodingAlertConfigurationVoBean bean = null;
		if(map != null)
			bean = (ims.ntpf.vo.beans.CodingAlertConfigurationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ntpf.vo.beans.CodingAlertConfigurationVoBean();
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
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("EMAIL"))
			return getEmail();
		if(fieldName.equals("USER"))
			return getUser();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getEmailIsNotNull()
	{
		return this.email != null;
	}
	public String getEmail()
	{
		return this.email;
	}
	public static int getEmailMaxLength()
	{
		return 255;
	}
	public void setEmail(String value)
	{
		this.isValidated = false;
		this.email = value;
	}
	public boolean getUserIsNotNull()
	{
		return this.user != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getUser()
	{
		return this.user;
	}
	public void setUser(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.user = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
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
		if(this.activity != null)
		{
			if(!this.activity.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.user != null)
		{
			if(!this.user.isValidated())
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
		if(this.activity != null)
		{
			String[] listOfOtherErrors = this.activity.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.user != null)
		{
			String[] listOfOtherErrors = this.user.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.ntpf.vo.CodingAlertConfigurationVo] is too big. It should be less or equal to 255");
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
	
		CodingAlertConfigurationVo clone = new CodingAlertConfigurationVo(this.id, this.version);
		
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityVo)this.activity.clone();
		clone.email = this.email;
		if(this.user == null)
			clone.user = null;
		else
			clone.user = (ims.core.vo.MemberOfStaffShortVo)this.user.clone();
		clone.description = this.description;
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
		if (!(CodingAlertConfigurationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CodingAlertConfigurationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CodingAlertConfigurationVo compareObj = (CodingAlertConfigurationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_CodingAlertConfiguration() == null && compareObj.getID_CodingAlertConfiguration() != null)
				return -1;
			if(this.getID_CodingAlertConfiguration() != null && compareObj.getID_CodingAlertConfiguration() == null)
				return 1;
			if(this.getID_CodingAlertConfiguration() != null && compareObj.getID_CodingAlertConfiguration() != null)
				retVal = this.getID_CodingAlertConfiguration().compareTo(compareObj.getID_CodingAlertConfiguration());
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
		if(this.activity != null)
			count++;
		if(this.email != null)
			count++;
		if(this.user != null)
			count++;
		if(this.description != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.ActivityVo activity;
	protected String email;
	protected ims.core.vo.MemberOfStaffShortVo user;
	protected String description;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
