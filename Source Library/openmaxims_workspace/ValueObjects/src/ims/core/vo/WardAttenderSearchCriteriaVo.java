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


public class WardAttenderSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardAttenderSearchCriteriaVo()
	{
	}
	public WardAttenderSearchCriteriaVo(ims.core.vo.beans.WardAttenderSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.wastimeron = bean.getWasTimerOn();
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardAttenderSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.wastimeron = bean.getWasTimerOn();
		this.clinic = bean.getClinic() == null ? null : bean.getClinic().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardAttenderSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardAttenderSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardAttenderSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.vo.LocationLiteVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.Date getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date = value;
	}
	public boolean getWasTimerOnIsNotNull()
	{
		return this.wastimeron != null;
	}
	public Boolean getWasTimerOn()
	{
		return this.wastimeron;
	}
	public void setWasTimerOn(Boolean value)
	{
		this.isValidated = false;
		this.wastimeron = value;
	}
	public boolean getClinicIsNotNull()
	{
		return this.clinic != null;
	}
	public ims.scheduling.vo.SessionForWardAttenderVo getClinic()
	{
		return this.clinic;
	}
	public void setClinic(ims.scheduling.vo.SessionForWardAttenderVo value)
	{
		this.isValidated = false;
		this.clinic = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.status = value;
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
		if(!(obj instanceof WardAttenderSearchCriteriaVo))
			return false;
		WardAttenderSearchCriteriaVo compareObj = (WardAttenderSearchCriteriaVo)obj;
		if(this.getHospital() == null && compareObj.getHospital() != null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() == null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() != null)
			if(!this.getHospital().equals(compareObj.getHospital()))
				return false;
		if(this.getWard() == null && compareObj.getWard() != null)
			return false;
		if(this.getWard() != null && compareObj.getWard() == null)
			return false;
		if(this.getWard() != null && compareObj.getWard() != null)
			if(!this.getWard().equals(compareObj.getWard()))
				return false;
		if(this.getService() == null && compareObj.getService() != null)
			return false;
		if(this.getService() != null && compareObj.getService() == null)
			return false;
		if(this.getService() != null && compareObj.getService() != null)
			if(!this.getService().equals(compareObj.getService()))
				return false;
		if(this.getDate() == null && compareObj.getDate() != null)
			return false;
		if(this.getDate() != null && compareObj.getDate() == null)
			return false;
		if(this.getDate() != null && compareObj.getDate() != null)
			if(!this.getDate().equals(compareObj.getDate()))
				return false;
		if(this.getWasTimerOn() == null && compareObj.getWasTimerOn() != null)
			return false;
		if(this.getWasTimerOn() != null && compareObj.getWasTimerOn() == null)
			return false;
		if(this.getWasTimerOn() != null && compareObj.getWasTimerOn() != null)
			return this.getWasTimerOn().equals(compareObj.getWasTimerOn());
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
	
		WardAttenderSearchCriteriaVo clone = new WardAttenderSearchCriteriaVo();
		
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocationLiteVo)this.hospital.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
		clone.wastimeron = this.wastimeron;
		if(this.clinic == null)
			clone.clinic = null;
		else
			clone.clinic = (ims.scheduling.vo.SessionForWardAttenderVo)this.clinic.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
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
		if (!(WardAttenderSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardAttenderSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardAttenderSearchCriteriaVo compareObj = (WardAttenderSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getHospital() == null && compareObj.getHospital() != null)
				return -1;
			if(this.getHospital() != null && compareObj.getHospital() == null)
				return 1;
			if(this.getHospital() != null && compareObj.getHospital() != null)
				retVal = this.getHospital().compareTo(compareObj.getHospital());
		}
		if (retVal == 0)
		{
			if(this.getWard() == null && compareObj.getWard() != null)
				return -1;
			if(this.getWard() != null && compareObj.getWard() == null)
				return 1;
			if(this.getWard() != null && compareObj.getWard() != null)
				retVal = this.getWard().compareTo(compareObj.getWard());
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
		if (retVal == 0)
		{
			if(this.getDate() == null && compareObj.getDate() != null)
				return -1;
			if(this.getDate() != null && compareObj.getDate() == null)
				return 1;
			if(this.getDate() != null && compareObj.getDate() != null)
				retVal = this.getDate().compareTo(compareObj.getDate());
		}
		if (retVal == 0)
		{
			if(this.getWasTimerOn() == null && compareObj.getWasTimerOn() != null)
				return -1;
			if(this.getWasTimerOn() != null && compareObj.getWasTimerOn() == null)
				return 1;
			if(this.getWasTimerOn() != null && compareObj.getWasTimerOn() != null)
				retVal = this.getWasTimerOn().compareTo(compareObj.getWasTimerOn());
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
		if(this.hospital != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.service != null)
			count++;
		if(this.date != null)
			count++;
		if(this.wastimeron != null)
			count++;
		if(this.clinic != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.LocationLiteVo hospital;
	protected ims.core.vo.LocationLiteVo ward;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.framework.utils.Date date;
	protected Boolean wastimeron;
	protected ims.scheduling.vo.SessionForWardAttenderVo clinic;
	protected ims.scheduling.vo.lookups.Status_Reason status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
