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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.ThermalActivity business object (ID: 1019100015).
 */
public class ThermalActivityVo extends ims.therapies.treatment.vo.ThermalActivityRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ThermalActivityVo()
	{
	}
	public ThermalActivityVo(Integer id, int version)
	{
		super(id, version);
	}
	public ThermalActivityVo(ims.therapies.vo.beans.ThermalActivityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.thermal = bean.getThermal() == null ? null : ims.spinalinjuries.vo.lookups.ThermalType.buildLookup(bean.getThermal());
		this.thermaltype = bean.getThermalType() == null ? null : ims.spinalinjuries.vo.lookups.ThermalType.buildLookup(bean.getThermalType());
		this.area = bean.getArea() == null ? null : ims.spinalinjuries.vo.lookups.ThermalArea.buildLookup(bean.getArea());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getLaterality());
		this.duration = bean.getDuration();
		this.details = bean.getDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.ThermalActivityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.thermal = bean.getThermal() == null ? null : ims.spinalinjuries.vo.lookups.ThermalType.buildLookup(bean.getThermal());
		this.thermaltype = bean.getThermalType() == null ? null : ims.spinalinjuries.vo.lookups.ThermalType.buildLookup(bean.getThermalType());
		this.area = bean.getArea() == null ? null : ims.spinalinjuries.vo.lookups.ThermalArea.buildLookup(bean.getArea());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getLaterality());
		this.duration = bean.getDuration();
		this.details = bean.getDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.ThermalActivityVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.ThermalActivityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.ThermalActivityVoBean();
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
		if(fieldName.equals("THERMAL"))
			return getThermal();
		if(fieldName.equals("THERMALTYPE"))
			return getThermalType();
		if(fieldName.equals("AREA"))
			return getArea();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("DETAILS"))
			return getDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getThermalIsNotNull()
	{
		return this.thermal != null;
	}
	public ims.spinalinjuries.vo.lookups.ThermalType getThermal()
	{
		return this.thermal;
	}
	public void setThermal(ims.spinalinjuries.vo.lookups.ThermalType value)
	{
		this.isValidated = false;
		this.thermal = value;
	}
	public boolean getThermalTypeIsNotNull()
	{
		return this.thermaltype != null;
	}
	public ims.spinalinjuries.vo.lookups.ThermalType getThermalType()
	{
		return this.thermaltype;
	}
	public void setThermalType(ims.spinalinjuries.vo.lookups.ThermalType value)
	{
		this.isValidated = false;
		this.thermaltype = value;
	}
	public boolean getAreaIsNotNull()
	{
		return this.area != null;
	}
	public ims.spinalinjuries.vo.lookups.ThermalArea getArea()
	{
		return this.area;
	}
	public void setArea(ims.spinalinjuries.vo.lookups.ThermalArea value)
	{
		this.isValidated = false;
		this.area = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public ims.core.vo.lookups.LateralityLRB getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.core.vo.lookups.LateralityLRB value)
	{
		this.isValidated = false;
		this.laterality = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
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
		return 100;
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
		if(this.details != null)
			if(this.details.length() > 100)
				listOfErrors.add("The length of the field [details] in the value object [ims.therapies.vo.ThermalActivityVo] is too big. It should be less or equal to 100");
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
	
		ThermalActivityVo clone = new ThermalActivityVo(this.id, this.version);
		
		if(this.thermal == null)
			clone.thermal = null;
		else
			clone.thermal = (ims.spinalinjuries.vo.lookups.ThermalType)this.thermal.clone();
		if(this.thermaltype == null)
			clone.thermaltype = null;
		else
			clone.thermaltype = (ims.spinalinjuries.vo.lookups.ThermalType)this.thermaltype.clone();
		if(this.area == null)
			clone.area = null;
		else
			clone.area = (ims.spinalinjuries.vo.lookups.ThermalArea)this.area.clone();
		if(this.laterality == null)
			clone.laterality = null;
		else
			clone.laterality = (ims.core.vo.lookups.LateralityLRB)this.laterality.clone();
		clone.duration = this.duration;
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
		if (!(ThermalActivityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ThermalActivityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ThermalActivityVo compareObj = (ThermalActivityVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ThermalActivity() == null && compareObj.getID_ThermalActivity() != null)
				return -1;
			if(this.getID_ThermalActivity() != null && compareObj.getID_ThermalActivity() == null)
				return 1;
			if(this.getID_ThermalActivity() != null && compareObj.getID_ThermalActivity() != null)
				retVal = this.getID_ThermalActivity().compareTo(compareObj.getID_ThermalActivity());
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
		if(this.thermal != null)
			count++;
		if(this.thermaltype != null)
			count++;
		if(this.area != null)
			count++;
		if(this.laterality != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.details != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.spinalinjuries.vo.lookups.ThermalType thermal;
	protected ims.spinalinjuries.vo.lookups.ThermalType thermaltype;
	protected ims.spinalinjuries.vo.lookups.ThermalArea area;
	protected ims.core.vo.lookups.LateralityLRB laterality;
	protected Integer duration;
	protected String details;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
