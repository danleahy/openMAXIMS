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

package ims.generalmedical.vo;

/**
 * Linked to medical.InjuryAssocFactor business object (ID: 1023100016).
 */
public class AssociatedFactorVo extends ims.medical.vo.InjuryAssocFactorRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssociatedFactorVo()
	{
	}
	public AssociatedFactorVo(Integer id, int version)
	{
		super(id, version);
	}
	public AssociatedFactorVo(ims.generalmedical.vo.beans.AssociatedFactorVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.associatedfactor = bean.getAssociatedFactor() == null ? null : ims.spinalinjuries.vo.lookups.InjuryAssociatedFactor.buildLookup(bean.getAssociatedFactor());
		this.description = bean.getDescription();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.AssociatedFactorVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.associatedfactor = bean.getAssociatedFactor() == null ? null : ims.spinalinjuries.vo.lookups.InjuryAssociatedFactor.buildLookup(bean.getAssociatedFactor());
		this.description = bean.getDescription();
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.AssociatedFactorVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.AssociatedFactorVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.AssociatedFactorVoBean();
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
		if(fieldName.equals("ASSOCIATEDFACTOR"))
			return getAssociatedFactor();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssociatedFactorIsNotNull()
	{
		return this.associatedfactor != null;
	}
	public ims.spinalinjuries.vo.lookups.InjuryAssociatedFactor getAssociatedFactor()
	{
		return this.associatedfactor;
	}
	public void setAssociatedFactor(ims.spinalinjuries.vo.lookups.InjuryAssociatedFactor value)
	{
		this.isValidated = false;
		this.associatedfactor = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 1000;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
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
		if(this.associatedfactor == null)
			listOfErrors.add("Please select an Associated Factor.");
		if(this.description != null)
			if(this.description.length() > 1000)
				listOfErrors.add("The length of the field [description] in the value object [ims.generalmedical.vo.AssociatedFactorVo] is too big. It should be less or equal to 1000");
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
	
		AssociatedFactorVo clone = new AssociatedFactorVo(this.id, this.version);
		
		if(this.associatedfactor == null)
			clone.associatedfactor = null;
		else
			clone.associatedfactor = (ims.spinalinjuries.vo.lookups.InjuryAssociatedFactor)this.associatedfactor.clone();
		clone.description = this.description;
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
		if (!(AssociatedFactorVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssociatedFactorVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AssociatedFactorVo compareObj = (AssociatedFactorVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_InjuryAssocFactor() == null && compareObj.getID_InjuryAssocFactor() != null)
				return -1;
			if(this.getID_InjuryAssocFactor() != null && compareObj.getID_InjuryAssocFactor() == null)
				return 1;
			if(this.getID_InjuryAssocFactor() != null && compareObj.getID_InjuryAssocFactor() != null)
				retVal = this.getID_InjuryAssocFactor().compareTo(compareObj.getID_InjuryAssocFactor());
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
		if(this.associatedfactor != null)
			count++;
		if(this.description != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.spinalinjuries.vo.lookups.InjuryAssociatedFactor associatedfactor;
	protected String description;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
