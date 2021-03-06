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

package ims.ocrr.vo;


public class SpecimentWorkListItemCustomOutpatientVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SpecimentWorkListItemCustomOutpatientVo()
	{
	}
	public SpecimentWorkListItemCustomOutpatientVo(ims.ocrr.vo.beans.SpecimentWorkListItemCustomOutpatientVoBean bean)
	{
		this.worklistitemid = bean.getWorkListitemId();
		this.specimenid = bean.getSpecimenId();
		this.serviceid = bean.getServiceId();
		this.servicename = bean.getServiceName();
		this.investigation = bean.getInvestigation();
		this.container = bean.getContainer();
		this.containerquantity = bean.getContainerQuantity();
		this.daterequired = bean.getDateRequired() == null ? null : bean.getDateRequired().buildDate();
		this.hcpname = bean.getHcpName();
		this.hcpid = bean.getHcpID();
		this.specimencontainerid = bean.getSpecimenContainerId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.SpecimentWorkListItemCustomOutpatientVoBean bean)
	{
		this.worklistitemid = bean.getWorkListitemId();
		this.specimenid = bean.getSpecimenId();
		this.serviceid = bean.getServiceId();
		this.servicename = bean.getServiceName();
		this.investigation = bean.getInvestigation();
		this.container = bean.getContainer();
		this.containerquantity = bean.getContainerQuantity();
		this.daterequired = bean.getDateRequired() == null ? null : bean.getDateRequired().buildDate();
		this.hcpname = bean.getHcpName();
		this.hcpid = bean.getHcpID();
		this.specimencontainerid = bean.getSpecimenContainerId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.SpecimentWorkListItemCustomOutpatientVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.SpecimentWorkListItemCustomOutpatientVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.SpecimentWorkListItemCustomOutpatientVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getWorkListitemIdIsNotNull()
	{
		return this.worklistitemid != null;
	}
	public Integer getWorkListitemId()
	{
		return this.worklistitemid;
	}
	public void setWorkListitemId(Integer value)
	{
		this.isValidated = false;
		this.worklistitemid = value;
	}
	public boolean getSpecimenIdIsNotNull()
	{
		return this.specimenid != null;
	}
	public Integer getSpecimenId()
	{
		return this.specimenid;
	}
	public void setSpecimenId(Integer value)
	{
		this.isValidated = false;
		this.specimenid = value;
	}
	public boolean getServiceIdIsNotNull()
	{
		return this.serviceid != null;
	}
	public Integer getServiceId()
	{
		return this.serviceid;
	}
	public void setServiceId(Integer value)
	{
		this.isValidated = false;
		this.serviceid = value;
	}
	public boolean getServiceNameIsNotNull()
	{
		return this.servicename != null;
	}
	public String getServiceName()
	{
		return this.servicename;
	}
	public static int getServiceNameMaxLength()
	{
		return 255;
	}
	public void setServiceName(String value)
	{
		this.isValidated = false;
		this.servicename = value;
	}
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public String getInvestigation()
	{
		return this.investigation;
	}
	public static int getInvestigationMaxLength()
	{
		return 255;
	}
	public void setInvestigation(String value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getContainerIsNotNull()
	{
		return this.container != null;
	}
	public String getContainer()
	{
		return this.container;
	}
	public static int getContainerMaxLength()
	{
		return 255;
	}
	public void setContainer(String value)
	{
		this.isValidated = false;
		this.container = value;
	}
	public boolean getContainerQuantityIsNotNull()
	{
		return this.containerquantity != null;
	}
	public Integer getContainerQuantity()
	{
		return this.containerquantity;
	}
	public void setContainerQuantity(Integer value)
	{
		this.isValidated = false;
		this.containerquantity = value;
	}
	public boolean getDateRequiredIsNotNull()
	{
		return this.daterequired != null;
	}
	public ims.framework.utils.Date getDateRequired()
	{
		return this.daterequired;
	}
	public void setDateRequired(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.daterequired = value;
	}
	public boolean getHcpNameIsNotNull()
	{
		return this.hcpname != null;
	}
	public String getHcpName()
	{
		return this.hcpname;
	}
	public static int getHcpNameMaxLength()
	{
		return 255;
	}
	public void setHcpName(String value)
	{
		this.isValidated = false;
		this.hcpname = value;
	}
	public boolean getHcpIDIsNotNull()
	{
		return this.hcpid != null;
	}
	public Integer getHcpID()
	{
		return this.hcpid;
	}
	public void setHcpID(Integer value)
	{
		this.isValidated = false;
		this.hcpid = value;
	}
	public boolean getSpecimenContainerIdIsNotNull()
	{
		return this.specimencontainerid != null;
	}
	public Integer getSpecimenContainerId()
	{
		return this.specimencontainerid;
	}
	public void setSpecimenContainerId(Integer value)
	{
		this.isValidated = false;
		this.specimencontainerid = value;
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
		if(!(obj instanceof SpecimentWorkListItemCustomOutpatientVo))
			return false;
		SpecimentWorkListItemCustomOutpatientVo compareObj = (SpecimentWorkListItemCustomOutpatientVo)obj;
		if(this.getWorkListitemId() == null && compareObj.getWorkListitemId() != null)
			return false;
		if(this.getWorkListitemId() != null && compareObj.getWorkListitemId() == null)
			return false;
		if(this.getWorkListitemId() != null && compareObj.getWorkListitemId() != null)
			if(!this.getWorkListitemId().equals(compareObj.getWorkListitemId()))
				return false;
		if(this.getSpecimenId() == null && compareObj.getSpecimenId() != null)
			return false;
		if(this.getSpecimenId() != null && compareObj.getSpecimenId() == null)
			return false;
		if(this.getSpecimenId() != null && compareObj.getSpecimenId() != null)
			if(!this.getSpecimenId().equals(compareObj.getSpecimenId()))
				return false;
		if(this.getServiceId() == null && compareObj.getServiceId() != null)
			return false;
		if(this.getServiceId() != null && compareObj.getServiceId() == null)
			return false;
		if(this.getServiceId() != null && compareObj.getServiceId() != null)
			if(!this.getServiceId().equals(compareObj.getServiceId()))
				return false;
		if(this.getHcpID() == null && compareObj.getHcpID() != null)
			return false;
		if(this.getHcpID() != null && compareObj.getHcpID() == null)
			return false;
		if(this.getHcpID() != null && compareObj.getHcpID() != null)
			if(!this.getHcpID().equals(compareObj.getHcpID()))
				return false;
		if(this.getDateRequired() == null && compareObj.getDateRequired() != null)
			return false;
		if(this.getDateRequired() != null && compareObj.getDateRequired() == null)
			return false;
		if(this.getDateRequired() != null && compareObj.getDateRequired() != null)
			return this.getDateRequired().equals(compareObj.getDateRequired());
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
	
		SpecimentWorkListItemCustomOutpatientVo clone = new SpecimentWorkListItemCustomOutpatientVo();
		
		clone.worklistitemid = this.worklistitemid;
		clone.specimenid = this.specimenid;
		clone.serviceid = this.serviceid;
		clone.servicename = this.servicename;
		clone.investigation = this.investigation;
		clone.container = this.container;
		clone.containerquantity = this.containerquantity;
		if(this.daterequired == null)
			clone.daterequired = null;
		else
			clone.daterequired = (ims.framework.utils.Date)this.daterequired.clone();
		clone.hcpname = this.hcpname;
		clone.hcpid = this.hcpid;
		clone.specimencontainerid = this.specimencontainerid;
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
		if (!(SpecimentWorkListItemCustomOutpatientVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SpecimentWorkListItemCustomOutpatientVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SpecimentWorkListItemCustomOutpatientVo compareObj = (SpecimentWorkListItemCustomOutpatientVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getWorkListitemId() == null && compareObj.getWorkListitemId() != null)
				return -1;
			if(this.getWorkListitemId() != null && compareObj.getWorkListitemId() == null)
				return 1;
			if(this.getWorkListitemId() != null && compareObj.getWorkListitemId() != null)
				retVal = this.getWorkListitemId().compareTo(compareObj.getWorkListitemId());
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
		if(this.worklistitemid != null)
			count++;
		if(this.specimenid != null)
			count++;
		if(this.serviceid != null)
			count++;
		if(this.servicename != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.container != null)
			count++;
		if(this.containerquantity != null)
			count++;
		if(this.daterequired != null)
			count++;
		if(this.hcpname != null)
			count++;
		if(this.hcpid != null)
			count++;
		if(this.specimencontainerid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected Integer worklistitemid;
	protected Integer specimenid;
	protected Integer serviceid;
	protected String servicename;
	protected String investigation;
	protected String container;
	protected Integer containerquantity;
	protected ims.framework.utils.Date daterequired;
	protected String hcpname;
	protected Integer hcpid;
	protected Integer specimencontainerid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
