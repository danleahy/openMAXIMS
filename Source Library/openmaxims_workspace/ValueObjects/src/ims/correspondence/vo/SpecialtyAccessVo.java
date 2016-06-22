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

package ims.correspondence.vo;

/**
 * Linked to correspondence.configuration.SpecialtyAccess business object (ID: 1053100006).
 */
public class SpecialtyAccessVo extends ims.correspondence.configuration.vo.SpecialtyAccessRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SpecialtyAccessVo()
	{
	}
	public SpecialtyAccessVo(Integer id, int version)
	{
		super(id, version);
	}
	public SpecialtyAccessVo(ims.correspondence.vo.beans.SpecialtyAccessVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.accessright = bean.getAccessRight() == null ? null : ims.correspondence.vo.lookups.Access.buildLookup(bean.getAccessRight());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.SpecialtyAccessVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.accessright = bean.getAccessRight() == null ? null : ims.correspondence.vo.lookups.Access.buildLookup(bean.getAccessRight());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.SpecialtyAccessVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.SpecialtyAccessVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.SpecialtyAccessVoBean();
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
		if(fieldName.equals("ACCESSRIGHT"))
			return getAccessRight();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAccessRightIsNotNull()
	{
		return this.accessright != null;
	}
	public ims.correspondence.vo.lookups.Access getAccessRight()
	{
		return this.accessright;
	}
	public void setAccessRight(ims.correspondence.vo.lookups.Access value)
	{
		this.isValidated = false;
		this.accessright = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
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
		if(this.accessright == null)
			listOfErrors.add("AccessRight is mandatory");
		if(this.specialty == null)
			listOfErrors.add("Specialty is mandatory");
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
	
		SpecialtyAccessVo clone = new SpecialtyAccessVo(this.id, this.version);
		
		if(this.accessright == null)
			clone.accessright = null;
		else
			clone.accessright = (ims.correspondence.vo.lookups.Access)this.accessright.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
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
		if (!(SpecialtyAccessVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SpecialtyAccessVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SpecialtyAccessVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SpecialtyAccessVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.accessright != null)
			count++;
		if(this.specialty != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.correspondence.vo.lookups.Access accessright;
	protected ims.core.vo.lookups.Specialty specialty;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
