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

package ims.scheduling.vo;


public class PendingEmergencyTheatreRemovalVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PendingEmergencyTheatreRemovalVo()
	{
	}
	public PendingEmergencyTheatreRemovalVo(ims.scheduling.vo.beans.PendingEmergencyTheatreRemovalVoBean bean)
	{
		this.removaldatetime = bean.getRemovalDateTime() == null ? null : bean.getRemovalDateTime().buildDateTime();
		this.removalreason = bean.getRemovalReason() == null ? null : ims.scheduling.vo.lookups.PendingEmergencyTheatreRemovalReason.buildLookup(bean.getRemovalReason());
		this.removalby = bean.getRemovalBy() == null ? null : bean.getRemovalBy().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.PendingEmergencyTheatreRemovalVoBean bean)
	{
		this.removaldatetime = bean.getRemovalDateTime() == null ? null : bean.getRemovalDateTime().buildDateTime();
		this.removalreason = bean.getRemovalReason() == null ? null : ims.scheduling.vo.lookups.PendingEmergencyTheatreRemovalReason.buildLookup(bean.getRemovalReason());
		this.removalby = bean.getRemovalBy() == null ? null : bean.getRemovalBy().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.PendingEmergencyTheatreRemovalVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.PendingEmergencyTheatreRemovalVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.PendingEmergencyTheatreRemovalVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getRemovalDateTimeIsNotNull()
	{
		return this.removaldatetime != null;
	}
	public ims.framework.utils.DateTime getRemovalDateTime()
	{
		return this.removaldatetime;
	}
	public void setRemovalDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.removaldatetime = value;
	}
	public boolean getRemovalReasonIsNotNull()
	{
		return this.removalreason != null;
	}
	public ims.scheduling.vo.lookups.PendingEmergencyTheatreRemovalReason getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.scheduling.vo.lookups.PendingEmergencyTheatreRemovalReason value)
	{
		this.isValidated = false;
		this.removalreason = value;
	}
	public boolean getRemovalByIsNotNull()
	{
		return this.removalby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getRemovalBy()
	{
		return this.removalby;
	}
	public void setRemovalBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.removalby = value;
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
		if(!(obj instanceof PendingEmergencyTheatreRemovalVo))
			return false;
		PendingEmergencyTheatreRemovalVo compareObj = (PendingEmergencyTheatreRemovalVo)obj;
		if(this.getRemovalDateTime() == null && compareObj.getRemovalDateTime() != null)
			return false;
		if(this.getRemovalDateTime() != null && compareObj.getRemovalDateTime() == null)
			return false;
		if(this.getRemovalDateTime() != null && compareObj.getRemovalDateTime() != null)
			if(!this.getRemovalDateTime().equals(compareObj.getRemovalDateTime()))
				return false;
		if(this.getRemovalReason() == null && compareObj.getRemovalReason() != null)
			return false;
		if(this.getRemovalReason() != null && compareObj.getRemovalReason() == null)
			return false;
		if(this.getRemovalReason() != null && compareObj.getRemovalReason() != null)
			if(!this.getRemovalReason().equals(compareObj.getRemovalReason()))
				return false;
		if(this.getRemovalBy() == null && compareObj.getRemovalBy() != null)
			return false;
		if(this.getRemovalBy() != null && compareObj.getRemovalBy() == null)
			return false;
		if(this.getRemovalBy() != null && compareObj.getRemovalBy() != null)
			return this.getRemovalBy().equals(compareObj.getRemovalBy());
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
	
		PendingEmergencyTheatreRemovalVo clone = new PendingEmergencyTheatreRemovalVo();
		
		if(this.removaldatetime == null)
			clone.removaldatetime = null;
		else
			clone.removaldatetime = (ims.framework.utils.DateTime)this.removaldatetime.clone();
		if(this.removalreason == null)
			clone.removalreason = null;
		else
			clone.removalreason = (ims.scheduling.vo.lookups.PendingEmergencyTheatreRemovalReason)this.removalreason.clone();
		if(this.removalby == null)
			clone.removalby = null;
		else
			clone.removalby = (ims.core.vo.MemberOfStaffLiteVo)this.removalby.clone();
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
		if (!(PendingEmergencyTheatreRemovalVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PendingEmergencyTheatreRemovalVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PendingEmergencyTheatreRemovalVo compareObj = (PendingEmergencyTheatreRemovalVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getRemovalDateTime() == null && compareObj.getRemovalDateTime() != null)
				return -1;
			if(this.getRemovalDateTime() != null && compareObj.getRemovalDateTime() == null)
				return 1;
			if(this.getRemovalDateTime() != null && compareObj.getRemovalDateTime() != null)
				retVal = this.getRemovalDateTime().compareTo(compareObj.getRemovalDateTime());
		}
		if (retVal == 0)
		{
			if(this.getRemovalReason() == null && compareObj.getRemovalReason() != null)
				return -1;
			if(this.getRemovalReason() != null && compareObj.getRemovalReason() == null)
				return 1;
			if(this.getRemovalReason() != null && compareObj.getRemovalReason() != null)
				retVal = this.getRemovalReason().compareTo(compareObj.getRemovalReason());
		}
		if (retVal == 0)
		{
			if(this.getRemovalBy() == null && compareObj.getRemovalBy() != null)
				return -1;
			if(this.getRemovalBy() != null && compareObj.getRemovalBy() == null)
				return 1;
			if(this.getRemovalBy() != null && compareObj.getRemovalBy() != null)
				retVal = this.getRemovalBy().compareTo(compareObj.getRemovalBy());
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
		if(this.removaldatetime != null)
			count++;
		if(this.removalreason != null)
			count++;
		if(this.removalby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime removaldatetime;
	protected ims.scheduling.vo.lookups.PendingEmergencyTheatreRemovalReason removalreason;
	protected ims.core.vo.MemberOfStaffLiteVo removalby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
