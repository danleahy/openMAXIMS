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

package ims.pathways.vo;

/**
 * Linked to Pathways.PatientPathwayJourney business object (ID: 1088100000).
 */
public class PatientJourneyModifyRTTClockStatusVo extends ims.pathways.vo.PatientPathwayJourneyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientJourneyModifyRTTClockStatusVo()
	{
	}
	public PatientJourneyModifyRTTClockStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientJourneyModifyRTTClockStatusVo(ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentclock = bean.getCurrentClock() == null ? null : bean.getCurrentClock().buildVo();
		this.clockhistory = ims.pathways.vo.PathwayClockVoCollection.buildFromBeanCollection(bean.getClockHistory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentclock = bean.getCurrentClock() == null ? null : bean.getCurrentClock().buildVo(map);
		this.clockhistory = ims.pathways.vo.PathwayClockVoCollection.buildFromBeanCollection(bean.getClockHistory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.PatientJourneyModifyRTTClockStatusVoBean();
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
		if(fieldName.equals("CURRENTCLOCK"))
			return getCurrentClock();
		if(fieldName.equals("CLOCKHISTORY"))
			return getClockHistory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCurrentClockIsNotNull()
	{
		return this.currentclock != null;
	}
	public ims.pathways.vo.PathwayClockVo getCurrentClock()
	{
		return this.currentclock;
	}
	public void setCurrentClock(ims.pathways.vo.PathwayClockVo value)
	{
		this.isValidated = false;
		this.currentclock = value;
	}
	public boolean getClockHistoryIsNotNull()
	{
		return this.clockhistory != null;
	}
	public ims.pathways.vo.PathwayClockVoCollection getClockHistory()
	{
		return this.clockhistory;
	}
	public void setClockHistory(ims.pathways.vo.PathwayClockVoCollection value)
	{
		this.isValidated = false;
		this.clockhistory = value;
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
		if(this.currentclock != null)
		{
			if(!this.currentclock.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clockhistory != null)
		{
			if(!this.clockhistory.isValidated())
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
		if(this.currentclock != null)
		{
			String[] listOfOtherErrors = this.currentclock.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clockhistory != null)
		{
			String[] listOfOtherErrors = this.clockhistory.validate();
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
	
		PatientJourneyModifyRTTClockStatusVo clone = new PatientJourneyModifyRTTClockStatusVo(this.id, this.version);
		
		if(this.currentclock == null)
			clone.currentclock = null;
		else
			clone.currentclock = (ims.pathways.vo.PathwayClockVo)this.currentclock.clone();
		if(this.clockhistory == null)
			clone.clockhistory = null;
		else
			clone.clockhistory = (ims.pathways.vo.PathwayClockVoCollection)this.clockhistory.clone();
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
		if (!(PatientJourneyModifyRTTClockStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientJourneyModifyRTTClockStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientJourneyModifyRTTClockStatusVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientJourneyModifyRTTClockStatusVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.currentclock != null)
			count++;
		if(this.clockhistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.pathways.vo.PathwayClockVo currentclock;
	protected ims.pathways.vo.PathwayClockVoCollection clockhistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
