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

package ims.clinicaladmin.vo;

/**
 * Linked to clinical.configuration.DiagnosisHotlist business object (ID: 1073100006).
 */
public class DiagnosisHotListShortVo extends ims.clinical.configuration.vo.DiagnosisHotlistRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHotlistShort
{
	private static final long serialVersionUID = 1L;

	public DiagnosisHotListShortVo()
	{
	}
	public DiagnosisHotListShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public DiagnosisHotListShortVo(ims.clinicaladmin.vo.beans.DiagnosisHotListShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.DiagnosisHotListShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.DiagnosisHotListShortVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.DiagnosisHotListShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.DiagnosisHotListShortVoBean();
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
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		return super.getFieldValueByFieldName(fieldName);
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
	/**
	* IHotlistShort
	*/
	public Boolean getISpecialtyIsNotNull() 
	{
		return Boolean.valueOf(this.getSpecialtyIsNotNull());
	}
		
	public ims.core.vo.lookups.Specialty getISpecialty() 
	{
		return this.getSpecialty();
	}
	
	public Integer getIHotlistShortID() 
	{
		return this.getID_DiagnosisHotlist();
	}
	
	public void setISpecialty(ims.core.vo.lookups.Specialty specialty) 
	{
		this.setSpecialty(specialty);
	}
		
	public void setIisGlobal(Boolean isGlobal) 
	{
		this.setIisGlobal(isGlobal);
	}
	
	public Boolean isIValidated() 
	{
		return Boolean.valueOf(this.isValidated());
	}
	
	public String[] iValidate(String[] strText)
	{
		return this.validate(strText);
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
	
		DiagnosisHotListShortVo clone = new DiagnosisHotListShortVo(this.id, this.version);
		
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
		if (!(DiagnosisHotListShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DiagnosisHotListShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DiagnosisHotListShortVo compareObj = (DiagnosisHotListShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSpecialty() == null && compareObj.getSpecialty() != null)
				return -1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() == null)
				return 1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() != null)
				retVal = this.getSpecialty().compareTo(compareObj.getSpecialty());
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
		if(this.specialty != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 1;
	}
	protected ims.core.vo.lookups.Specialty specialty;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
