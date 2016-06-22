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
 * Linked to medical.NeuroReflexesOtherFindings business object (ID: 1031100001).
 */
public class NeuroReflexOtherTestsVo extends ims.medical.vo.NeuroReflexesOtherFindingsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NeuroReflexOtherTestsVo()
	{
	}
	public NeuroReflexOtherTestsVo(Integer id, int version)
	{
		super(id, version);
	}
	public NeuroReflexOtherTestsVo(ims.generalmedical.vo.beans.NeuroReflexOtherTestsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.othermodality = bean.getOtherModality() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExmOtherTests.buildLookup(bean.getOtherModality());
		this.otherfinding = bean.getOtherFinding() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExmOtherTests.buildLookup(bean.getOtherFinding());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.NeuroReflexOtherTestsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.othermodality = bean.getOtherModality() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExmOtherTests.buildLookup(bean.getOtherModality());
		this.otherfinding = bean.getOtherFinding() == null ? null : ims.spinalinjuries.vo.lookups.NeuroExmOtherTests.buildLookup(bean.getOtherFinding());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.NeuroReflexOtherTestsVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.NeuroReflexOtherTestsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.NeuroReflexOtherTestsVoBean();
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
		if(fieldName.equals("OTHERMODALITY"))
			return getOtherModality();
		if(fieldName.equals("OTHERFINDING"))
			return getOtherFinding();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOtherModalityIsNotNull()
	{
		return this.othermodality != null;
	}
	public ims.spinalinjuries.vo.lookups.NeuroExmOtherTests getOtherModality()
	{
		return this.othermodality;
	}
	public void setOtherModality(ims.spinalinjuries.vo.lookups.NeuroExmOtherTests value)
	{
		this.isValidated = false;
		this.othermodality = value;
	}
	public boolean getOtherFindingIsNotNull()
	{
		return this.otherfinding != null;
	}
	public ims.spinalinjuries.vo.lookups.NeuroExmOtherTests getOtherFinding()
	{
		return this.otherfinding;
	}
	public void setOtherFinding(ims.spinalinjuries.vo.lookups.NeuroExmOtherTests value)
	{
		this.isValidated = false;
		this.otherfinding = value;
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
		if(this.othermodality == null)
			listOfErrors.add("otherModality is mandatory");
		if(this.otherfinding == null)
			listOfErrors.add("otherFinding is mandatory");
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
	
		NeuroReflexOtherTestsVo clone = new NeuroReflexOtherTestsVo(this.id, this.version);
		
		if(this.othermodality == null)
			clone.othermodality = null;
		else
			clone.othermodality = (ims.spinalinjuries.vo.lookups.NeuroExmOtherTests)this.othermodality.clone();
		if(this.otherfinding == null)
			clone.otherfinding = null;
		else
			clone.otherfinding = (ims.spinalinjuries.vo.lookups.NeuroExmOtherTests)this.otherfinding.clone();
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
		if (!(NeuroReflexOtherTestsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NeuroReflexOtherTestsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NeuroReflexOtherTestsVo compareObj = (NeuroReflexOtherTestsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_NeuroReflexesOtherFindings() == null && compareObj.getID_NeuroReflexesOtherFindings() != null)
				return -1;
			if(this.getID_NeuroReflexesOtherFindings() != null && compareObj.getID_NeuroReflexesOtherFindings() == null)
				return 1;
			if(this.getID_NeuroReflexesOtherFindings() != null && compareObj.getID_NeuroReflexesOtherFindings() != null)
				retVal = this.getID_NeuroReflexesOtherFindings().compareTo(compareObj.getID_NeuroReflexesOtherFindings());
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
		if(this.othermodality != null)
			count++;
		if(this.otherfinding != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.spinalinjuries.vo.lookups.NeuroExmOtherTests othermodality;
	protected ims.spinalinjuries.vo.lookups.NeuroExmOtherTests otherfinding;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
