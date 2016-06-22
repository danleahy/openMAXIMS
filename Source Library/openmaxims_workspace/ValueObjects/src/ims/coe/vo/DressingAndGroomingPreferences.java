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

package ims.coe.vo;

/**
 * Linked to coe.assessment.Dressing and Grooming Preferences business object (ID: 1012100021).
 */
public class DressingAndGroomingPreferences extends ims.coe.assessment.vo.DressingandGroomingPreferencesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DressingAndGroomingPreferences()
	{
	}
	public DressingAndGroomingPreferences(Integer id, int version)
	{
		super(id, version);
	}
	public DressingAndGroomingPreferences(ims.coe.vo.beans.DressingAndGroomingPreferencesBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.preferences = bean.getPreferences() == null ? null : ims.coe.vo.lookups.DressingAndGroomingPreferences.buildLookup(bean.getPreferences());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
		this.details = bean.getDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.DressingAndGroomingPreferencesBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.preferences = bean.getPreferences() == null ? null : ims.coe.vo.lookups.DressingAndGroomingPreferences.buildLookup(bean.getPreferences());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
		this.details = bean.getDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.DressingAndGroomingPreferencesBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.DressingAndGroomingPreferencesBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.DressingAndGroomingPreferencesBean();
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
		if(fieldName.equals("PREFERENCES"))
			return getPreferences();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPreferencesIsNotNull()
	{
		return this.preferences != null;
	}
	public ims.coe.vo.lookups.DressingAndGroomingPreferences getPreferences()
	{
		return this.preferences;
	}
	public void setPreferences(ims.coe.vo.lookups.DressingAndGroomingPreferences value)
	{
		this.isValidated = false;
		this.preferences = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getDetailsIsNotNull()
	{
		return this.details != null;
	}
	public String getDetails()
	{
		return this.details;
	}
	public static int getDetailsMaxLength()
	{
		return 255;
	}
	public void setDetails(String value)
	{
		this.isValidated = false;
		this.details = value;
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
	
		DressingAndGroomingPreferences clone = new DressingAndGroomingPreferences(this.id, this.version);
		
		if(this.preferences == null)
			clone.preferences = null;
		else
			clone.preferences = (ims.coe.vo.lookups.DressingAndGroomingPreferences)this.preferences.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.YesNoUnknown)this.status.clone();
		clone.details = this.details;
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
		if (!(DressingAndGroomingPreferences.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DressingAndGroomingPreferences object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DressingAndGroomingPreferences compareObj = (DressingAndGroomingPreferences)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_DressingandGroomingPreferences() == null && compareObj.getID_DressingandGroomingPreferences() != null)
				return -1;
			if(this.getID_DressingandGroomingPreferences() != null && compareObj.getID_DressingandGroomingPreferences() == null)
				return 1;
			if(this.getID_DressingandGroomingPreferences() != null && compareObj.getID_DressingandGroomingPreferences() != null)
				retVal = this.getID_DressingandGroomingPreferences().compareTo(compareObj.getID_DressingandGroomingPreferences());
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
		if(this.preferences != null)
			count++;
		if(this.status != null)
			count++;
		if(this.details != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.coe.vo.lookups.DressingAndGroomingPreferences preferences;
	protected ims.core.vo.lookups.YesNoUnknown status;
	protected String details;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
