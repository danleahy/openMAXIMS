//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;

/**
 * Linked to core.vitals.Temperature business object (ID: 1022100000).
 */
public class VSTemperature extends ims.core.vitals.vo.TemperatureRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public VSTemperature()
	{
	}
	public VSTemperature(Integer id, int version)
	{
		super(id, version);
	}
	public VSTemperature(ims.core.vo.beans.VSTemperatureBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recordingsite = bean.getRecordingSite() == null ? null : ims.core.vo.lookups.VSTempSite.buildLookup(bean.getRecordingSite());
		this.instrument = bean.getInstrument() == null ? null : ims.core.vo.lookups.VSTempInstrument.buildLookup(bean.getInstrument());
		this.temperature = bean.getTemperature();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.VSTemperatureBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.recordingsite = bean.getRecordingSite() == null ? null : ims.core.vo.lookups.VSTempSite.buildLookup(bean.getRecordingSite());
		this.instrument = bean.getInstrument() == null ? null : ims.core.vo.lookups.VSTempInstrument.buildLookup(bean.getInstrument());
		this.temperature = bean.getTemperature();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.VSTemperatureBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.VSTemperatureBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.VSTemperatureBean();
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
		if(fieldName.equals("RECORDINGSITE"))
			return getRecordingSite();
		if(fieldName.equals("INSTRUMENT"))
			return getInstrument();
		if(fieldName.equals("TEMPERATURE"))
			return getTemperature();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRecordingSiteIsNotNull()
	{
		return this.recordingsite != null;
	}
	public ims.core.vo.lookups.VSTempSite getRecordingSite()
	{
		return this.recordingsite;
	}
	public void setRecordingSite(ims.core.vo.lookups.VSTempSite value)
	{
		this.isValidated = false;
		this.recordingsite = value;
	}
	public boolean getInstrumentIsNotNull()
	{
		return this.instrument != null;
	}
	public ims.core.vo.lookups.VSTempInstrument getInstrument()
	{
		return this.instrument;
	}
	public void setInstrument(ims.core.vo.lookups.VSTempInstrument value)
	{
		this.isValidated = false;
		this.instrument = value;
	}
	public boolean getTemperatureIsNotNull()
	{
		return this.temperature != null;
	}
	public Float getTemperature()
	{
		return this.temperature;
	}
	public void setTemperature(Float value)
	{
		this.isValidated = false;
		this.temperature = value;
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
		if(this.temperature != null && (this.temperature.floatValue() < 20 || this.temperature.floatValue() > 45))
			listOfErrors.add("The Temperature has an invalid value. The valid range of values is between 20 and 45");
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
	
		VSTemperature clone = new VSTemperature(this.id, this.version);
		
		if(this.recordingsite == null)
			clone.recordingsite = null;
		else
			clone.recordingsite = (ims.core.vo.lookups.VSTempSite)this.recordingsite.clone();
		if(this.instrument == null)
			clone.instrument = null;
		else
			clone.instrument = (ims.core.vo.lookups.VSTempInstrument)this.instrument.clone();
		clone.temperature = this.temperature;
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
		if (!(VSTemperature.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A VSTemperature object cannot be compared an Object of type " + obj.getClass().getName());
		}
		VSTemperature compareObj = (VSTemperature)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_Temperature() == null && compareObj.getID_Temperature() != null)
				return -1;
			if(this.getID_Temperature() != null && compareObj.getID_Temperature() == null)
				return 1;
			if(this.getID_Temperature() != null && compareObj.getID_Temperature() != null)
				retVal = this.getID_Temperature().compareTo(compareObj.getID_Temperature());
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
		if(this.recordingsite != null)
			count++;
		if(this.instrument != null)
			count++;
		if(this.temperature != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.VSTempSite recordingsite;
	protected ims.core.vo.lookups.VSTempInstrument instrument;
	protected Float temperature;
	private boolean isValidated = false;
	private boolean isBusy = false;
}