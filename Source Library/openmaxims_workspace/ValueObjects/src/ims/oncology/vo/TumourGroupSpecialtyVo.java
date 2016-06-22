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
 * Linked to Oncology.Configuration.TumourGroupSpecialty business object (ID: 1075100008).
 */
public class TumourGroupSpecialtyVo extends ims.oncology.configuration.vo.TumourGroupSpecialtyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourGroupSpecialtyVo()
	{
	}
	public TumourGroupSpecialtyVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourGroupSpecialtyVo(ims.oncology.vo.beans.TumourGroupSpecialtyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.associatedspecialty = bean.getAssociatedSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getAssociatedSpecialty());
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.TumourGroupSpecialtyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.associatedspecialty = bean.getAssociatedSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getAssociatedSpecialty());
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.TumourGroupSpecialtyVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.TumourGroupSpecialtyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.TumourGroupSpecialtyVoBean();
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
		if(fieldName.equals("ASSOCIATEDSPECIALTY"))
			return getAssociatedSpecialty();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssociatedSpecialtyIsNotNull()
	{
		return this.associatedspecialty != null;
	}
	public ims.core.vo.lookups.Specialty getAssociatedSpecialty()
	{
		return this.associatedspecialty;
	}
	public void setAssociatedSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.associatedspecialty = value;
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
		if(this.associatedspecialty == null)
			listOfErrors.add("AssociatedSpecialty is mandatory");
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
	
		TumourGroupSpecialtyVo clone = new TumourGroupSpecialtyVo(this.id, this.version);
		
		if(this.associatedspecialty == null)
			clone.associatedspecialty = null;
		else
			clone.associatedspecialty = (ims.core.vo.lookups.Specialty)this.associatedspecialty.clone();
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
		if (!(TumourGroupSpecialtyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourGroupSpecialtyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TumourGroupSpecialtyVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TumourGroupSpecialtyVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.associatedspecialty != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.Specialty associatedspecialty;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
