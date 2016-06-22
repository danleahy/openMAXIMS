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

/**
 * Linked to Oncology.Configuration.PrognosticLocationConfig business object (ID: 1075100017).
 */
public class PrognosticLocationConfigVo extends ims.oncology.configuration.vo.PrognosticLocationConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PrognosticLocationConfigVo()
	{
	}
	public PrognosticLocationConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public PrognosticLocationConfigVo(ims.oncology.vo.beans.PrognosticLocationConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.locationname = bean.getLocationName();
		this.locationdescription = bean.getLocationDescription();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.PrognosticLocationConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.locationname = bean.getLocationName();
		this.locationdescription = bean.getLocationDescription();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.PrognosticLocationConfigVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.PrognosticLocationConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.PrognosticLocationConfigVoBean();
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
		if(fieldName.equals("LOCATIONNAME"))
			return getLocationName();
		if(fieldName.equals("LOCATIONDESCRIPTION"))
			return getLocationDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLocationNameIsNotNull()
	{
		return this.locationname != null;
	}
	public String getLocationName()
	{
		return this.locationname;
	}
	public static int getLocationNameMaxLength()
	{
		return 30;
	}
	public void setLocationName(String value)
	{
		this.isValidated = false;
		this.locationname = value;
	}
	public boolean getLocationDescriptionIsNotNull()
	{
		return this.locationdescription != null;
	}
	public String getLocationDescription()
	{
		return this.locationdescription;
	}
	public static int getLocationDescriptionMaxLength()
	{
		return 100;
	}
	public void setLocationDescription(String value)
	{
		this.isValidated = false;
		this.locationdescription = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.locationname != null)
			sb.append(this.locationname);
		return sb.toString();
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
		if(this.locationname == null || this.locationname.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.locationname.length() > 30)
			listOfErrors.add("The length of the field [locationname] in the value object [ims.oncology.vo.PrognosticLocationConfigVo] is too big. It should be less or equal to 30");
		if(this.locationdescription == null || this.locationdescription.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.locationdescription.length() > 100)
			listOfErrors.add("The length of the field [locationdescription] in the value object [ims.oncology.vo.PrognosticLocationConfigVo] is too big. It should be less or equal to 100");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
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
	
		PrognosticLocationConfigVo clone = new PrognosticLocationConfigVo(this.id, this.version);
		
		clone.locationname = this.locationname;
		clone.locationdescription = this.locationdescription;
		clone.isactive = this.isactive;
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
		if (!(PrognosticLocationConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PrognosticLocationConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PrognosticLocationConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PrognosticLocationConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.locationname != null)
			count++;
		if(this.locationdescription != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String locationname;
	protected String locationdescription;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
