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

/**
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class Sch_SessionShortVo extends ims.scheduling.vo.Sch_SessionLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Sch_SessionShortVo()
	{
	}
	public Sch_SessionShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public Sch_SessionShortVo(ims.scheduling.vo.beans.Sch_SessionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sessiondate = bean.getSessionDate() == null ? null : bean.getSessionDate().buildDate();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.Sch_SessionShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.sessiondate = bean.getSessionDate() == null ? null : bean.getSessionDate().buildDate();
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.Sch_SessionShortVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.Sch_SessionShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.Sch_SessionShortVoBean();
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
		if(fieldName.equals("SERVICE"))
			return getService();
		return super.getFieldValueByFieldName(fieldName);
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
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.Sch_SessionShortVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.scheduling.vo.Sch_SessionShortVo] is too big. It should be less or equal to 255");
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
	
		Sch_SessionShortVo clone = new Sch_SessionShortVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.sessiondate == null)
			clone.sessiondate = null;
		else
			clone.sessiondate = (ims.framework.utils.Date)this.sessiondate.clone();
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		if(this.endtm == null)
			clone.endtm = null;
		else
			clone.endtm = (ims.framework.utils.Time)this.endtm.clone();
		clone.isactive = this.isactive;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
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
		if (!(Sch_SessionShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Sch_SessionShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Sch_SessionShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Sch_SessionShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.service != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.core.vo.ServiceLiteVo service;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
