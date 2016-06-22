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

package ims.RefMan.vo;

/**
 * Linked to RefMan.ClinicalOutcomeCategoryProcedureRequiredConfig business object (ID: 1096100054).
 */
public class ClinicalOutcomeCategoryProcedureRequiredConfigVo extends ims.RefMan.vo.ClinicalOutcomeCategoryProcedureRequiredConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeCategoryProcedureRequiredConfigVo()
	{
	}
	public ClinicalOutcomeCategoryProcedureRequiredConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalOutcomeCategoryProcedureRequiredConfigVo(ims.RefMan.vo.beans.ClinicalOutcomeCategoryProcedureRequiredConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.category = bean.getCategory() == null ? null : ims.clinical.vo.lookups.ClinicalOutcomeCategory.buildLookup(bean.getCategory());
		this.requiresprocedurelink = bean.getRequiresProcedureLink();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ClinicalOutcomeCategoryProcedureRequiredConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.category = bean.getCategory() == null ? null : ims.clinical.vo.lookups.ClinicalOutcomeCategory.buildLookup(bean.getCategory());
		this.requiresprocedurelink = bean.getRequiresProcedureLink();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ClinicalOutcomeCategoryProcedureRequiredConfigVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ClinicalOutcomeCategoryProcedureRequiredConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ClinicalOutcomeCategoryProcedureRequiredConfigVoBean();
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
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("REQUIRESPROCEDURELINK"))
			return getRequiresProcedureLink();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.clinical.vo.lookups.ClinicalOutcomeCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.clinical.vo.lookups.ClinicalOutcomeCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getRequiresProcedureLinkIsNotNull()
	{
		return this.requiresprocedurelink != null;
	}
	public Boolean getRequiresProcedureLink()
	{
		return this.requiresprocedurelink;
	}
	public void setRequiresProcedureLink(Boolean value)
	{
		this.isValidated = false;
		this.requiresprocedurelink = value;
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
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.requiresprocedurelink == null)
			listOfErrors.add("requiresProcedureLink is mandatory");
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
	
		ClinicalOutcomeCategoryProcedureRequiredConfigVo clone = new ClinicalOutcomeCategoryProcedureRequiredConfigVo(this.id, this.version);
		
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.clinical.vo.lookups.ClinicalOutcomeCategory)this.category.clone();
		clone.requiresprocedurelink = this.requiresprocedurelink;
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
		if (!(ClinicalOutcomeCategoryProcedureRequiredConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalOutcomeCategoryProcedureRequiredConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicalOutcomeCategoryProcedureRequiredConfigVo compareObj = (ClinicalOutcomeCategoryProcedureRequiredConfigVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCategory() == null && compareObj.getCategory() != null)
				return -1;
			if(this.getCategory() != null && compareObj.getCategory() == null)
				return 1;
			if(this.getCategory() != null && compareObj.getCategory() != null)
				retVal = this.getCategory().compareTo(compareObj.getCategory());
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
		if(this.category != null)
			count++;
		if(this.requiresprocedurelink != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinical.vo.lookups.ClinicalOutcomeCategory category;
	protected Boolean requiresprocedurelink;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
