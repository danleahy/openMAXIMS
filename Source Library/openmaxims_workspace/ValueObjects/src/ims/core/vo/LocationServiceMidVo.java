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
 * Linked to core.resource.place.LocationService business object (ID: 1007100000).
 */
public class LocationServiceMidVo extends ims.core.resource.place.vo.LocationServiceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LocationServiceMidVo()
	{
	}
	public LocationServiceMidVo(Integer id, int version)
	{
		super(id, version);
	}
	public LocationServiceMidVo(ims.core.vo.beans.LocationServiceMidVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.effectiveto = bean.getEffectiveTo() == null ? null : bean.getEffectiveTo().buildDate();
		if(bean.getActivities() != null)
		{
			this.activities = new ims.core.resource.place.vo.LocationServiceActivityRefVoCollection();
			for(int activities_i = 0; activities_i < bean.getActivities().length; activities_i++)
			{
				this.activities.add(new ims.core.resource.place.vo.LocationServiceActivityRefVo(new Integer(bean.getActivities()[activities_i].getId()), bean.getActivities()[activities_i].getVersion()));
			}
		}
		this.contact = bean.getContact() == null ? null : bean.getContact().buildVo();
		if(bean.getFunctions() != null)
		{
			this.functions = new ims.core.resource.place.vo.LocationServiceFunctionRefVoCollection();
			for(int functions_i = 0; functions_i < bean.getFunctions().length; functions_i++)
			{
				this.functions.add(new ims.core.resource.place.vo.LocationServiceFunctionRefVo(new Integer(bean.getFunctions()[functions_i].getId()), bean.getFunctions()[functions_i].getVersion()));
			}
		}
		this.defaultprinter = bean.getDefaultPrinter();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.LocationServiceMidVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.effectiveto = bean.getEffectiveTo() == null ? null : bean.getEffectiveTo().buildDate();
		if(bean.getActivities() != null)
		{
			this.activities = new ims.core.resource.place.vo.LocationServiceActivityRefVoCollection();
			for(int activities_i = 0; activities_i < bean.getActivities().length; activities_i++)
			{
				this.activities.add(new ims.core.resource.place.vo.LocationServiceActivityRefVo(new Integer(bean.getActivities()[activities_i].getId()), bean.getActivities()[activities_i].getVersion()));
			}
		}
		this.contact = bean.getContact() == null ? null : bean.getContact().buildVo(map);
		if(bean.getFunctions() != null)
		{
			this.functions = new ims.core.resource.place.vo.LocationServiceFunctionRefVoCollection();
			for(int functions_i = 0; functions_i < bean.getFunctions().length; functions_i++)
			{
				this.functions.add(new ims.core.resource.place.vo.LocationServiceFunctionRefVo(new Integer(bean.getFunctions()[functions_i].getId()), bean.getFunctions()[functions_i].getVersion()));
			}
		}
		this.defaultprinter = bean.getDefaultPrinter();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.LocationServiceMidVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.LocationServiceMidVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.LocationServiceMidVoBean();
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
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("EFFECTIVETO"))
			return getEffectiveTo();
		if(fieldName.equals("ACTIVITIES"))
			return getActivities();
		if(fieldName.equals("CONTACT"))
			return getContact();
		if(fieldName.equals("FUNCTIONS"))
			return getFunctions();
		if(fieldName.equals("DEFAULTPRINTER"))
			return getDefaultPrinter();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocShortVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.location = value;
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
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getEffectiveToIsNotNull()
	{
		return this.effectiveto != null;
	}
	public ims.framework.utils.Date getEffectiveTo()
	{
		return this.effectiveto;
	}
	public void setEffectiveTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.effectiveto = value;
	}
	public boolean getActivitiesIsNotNull()
	{
		return this.activities != null;
	}
	public ims.core.resource.place.vo.LocationServiceActivityRefVoCollection getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.core.resource.place.vo.LocationServiceActivityRefVoCollection value)
	{
		this.isValidated = false;
		this.activities = value;
	}
	public boolean getContactIsNotNull()
	{
		return this.contact != null;
	}
	public ims.core.vo.ServiceContactVo getContact()
	{
		return this.contact;
	}
	public void setContact(ims.core.vo.ServiceContactVo value)
	{
		this.isValidated = false;
		this.contact = value;
	}
	public boolean getFunctionsIsNotNull()
	{
		return this.functions != null;
	}
	public ims.core.resource.place.vo.LocationServiceFunctionRefVoCollection getFunctions()
	{
		return this.functions;
	}
	public void setFunctions(ims.core.resource.place.vo.LocationServiceFunctionRefVoCollection value)
	{
		this.isValidated = false;
		this.functions = value;
	}
	public boolean getDefaultPrinterIsNotNull()
	{
		return this.defaultprinter != null;
	}
	public String getDefaultPrinter()
	{
		return this.defaultprinter;
	}
	public static int getDefaultPrinterMaxLength()
	{
		return 200;
	}
	public void setDefaultPrinter(String value)
	{
		this.isValidated = false;
		this.defaultprinter = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.location != null)
			sb.append(this.location);
		sb.append(":");
		if(this.service != null)
			sb.append(this.service);
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
		if(this.location != null)
		{
			if(!this.location.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.contact != null)
		{
			if(!this.contact.isValidated())
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
		if(this.location == null)
			listOfErrors.add("Location is mandatory");
		if(this.location != null)
		{
			String[] listOfOtherErrors = this.location.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.contact != null)
		{
			String[] listOfOtherErrors = this.contact.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.defaultprinter != null)
			if(this.defaultprinter.length() > 200)
				listOfErrors.add("The length of the field [defaultprinter] in the value object [ims.core.vo.LocationServiceMidVo] is too big. It should be less or equal to 200");
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
	
		LocationServiceMidVo clone = new LocationServiceMidVo(this.id, this.version);
		
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocShortVo)this.location.clone();
		clone.isactive = this.isactive;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceVo)this.service.clone();
		if(this.effectiveto == null)
			clone.effectiveto = null;
		else
			clone.effectiveto = (ims.framework.utils.Date)this.effectiveto.clone();
		clone.activities = this.activities;
		if(this.contact == null)
			clone.contact = null;
		else
			clone.contact = (ims.core.vo.ServiceContactVo)this.contact.clone();
		clone.functions = this.functions;
		clone.defaultprinter = this.defaultprinter;
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
		if (!(LocationServiceMidVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LocationServiceMidVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LocationServiceMidVo compareObj = (LocationServiceMidVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getLocation() == null && compareObj.getLocation() != null)
				return -1;
			if(this.getLocation() != null && compareObj.getLocation() == null)
				return 1;
			if(this.getLocation() != null && compareObj.getLocation() != null)
				retVal = this.getLocation().compareTo(compareObj.getLocation());
		}
		if (retVal == 0)
		{
			if(this.getService() == null && compareObj.getService() != null)
				return -1;
			if(this.getService() != null && compareObj.getService() == null)
				return 1;
			if(this.getService() != null && compareObj.getService() != null)
				retVal = this.getService().compareTo(compareObj.getService());
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
		if(this.location != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.service != null)
			count++;
		if(this.effectiveto != null)
			count++;
		if(this.activities != null)
			count++;
		if(this.contact != null)
			count++;
		if(this.functions != null)
			count++;
		if(this.defaultprinter != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.LocShortVo location;
	protected Boolean isactive;
	protected ims.core.vo.ServiceVo service;
	protected ims.framework.utils.Date effectiveto;
	protected ims.core.resource.place.vo.LocationServiceActivityRefVoCollection activities;
	protected ims.core.vo.ServiceContactVo contact;
	protected ims.core.resource.place.vo.LocationServiceFunctionRefVoCollection functions;
	protected String defaultprinter;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
