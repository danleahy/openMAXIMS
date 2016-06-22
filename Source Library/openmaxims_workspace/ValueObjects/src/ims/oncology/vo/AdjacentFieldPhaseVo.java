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
 * Linked to Oncology.AdjacentFieldPhase business object (ID: 1074100029).
 */
public class AdjacentFieldPhaseVo extends ims.oncology.vo.AdjacentFieldPhaseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdjacentFieldPhaseVo()
	{
	}
	public AdjacentFieldPhaseVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdjacentFieldPhaseVo(ims.oncology.vo.beans.AdjacentFieldPhaseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phase = bean.getPhase();
		this.dose1 = bean.getDose1();
		this.fractions1 = bean.getFractions1();
		this.dose2 = bean.getDose2();
		this.fractions2 = bean.getFractions2();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.AdjacentFieldPhaseVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.phase = bean.getPhase();
		this.dose1 = bean.getDose1();
		this.fractions1 = bean.getFractions1();
		this.dose2 = bean.getDose2();
		this.fractions2 = bean.getFractions2();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.AdjacentFieldPhaseVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.AdjacentFieldPhaseVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.AdjacentFieldPhaseVoBean();
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
		if(fieldName.equals("PHASE"))
			return getPhase();
		if(fieldName.equals("DOSE1"))
			return getDose1();
		if(fieldName.equals("FRACTIONS1"))
			return getFractions1();
		if(fieldName.equals("DOSE2"))
			return getDose2();
		if(fieldName.equals("FRACTIONS2"))
			return getFractions2();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPhaseIsNotNull()
	{
		return this.phase != null;
	}
	public Integer getPhase()
	{
		return this.phase;
	}
	public void setPhase(Integer value)
	{
		this.isValidated = false;
		this.phase = value;
	}
	public boolean getDose1IsNotNull()
	{
		return this.dose1 != null;
	}
	public Float getDose1()
	{
		return this.dose1;
	}
	public void setDose1(Float value)
	{
		this.isValidated = false;
		this.dose1 = value;
	}
	public boolean getFractions1IsNotNull()
	{
		return this.fractions1 != null;
	}
	public Integer getFractions1()
	{
		return this.fractions1;
	}
	public void setFractions1(Integer value)
	{
		this.isValidated = false;
		this.fractions1 = value;
	}
	public boolean getDose2IsNotNull()
	{
		return this.dose2 != null;
	}
	public Float getDose2()
	{
		return this.dose2;
	}
	public void setDose2(Float value)
	{
		this.isValidated = false;
		this.dose2 = value;
	}
	public boolean getFractions2IsNotNull()
	{
		return this.fractions2 != null;
	}
	public Integer getFractions2()
	{
		return this.fractions2;
	}
	public void setFractions2(Integer value)
	{
		this.isValidated = false;
		this.fractions2 = value;
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
	
		AdjacentFieldPhaseVo clone = new AdjacentFieldPhaseVo(this.id, this.version);
		
		clone.phase = this.phase;
		clone.dose1 = this.dose1;
		clone.fractions1 = this.fractions1;
		clone.dose2 = this.dose2;
		clone.fractions2 = this.fractions2;
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
		if (!(AdjacentFieldPhaseVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdjacentFieldPhaseVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdjacentFieldPhaseVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdjacentFieldPhaseVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.phase != null)
			count++;
		if(this.dose1 != null)
			count++;
		if(this.fractions1 != null)
			count++;
		if(this.dose2 != null)
			count++;
		if(this.fractions2 != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected Integer phase;
	protected Float dose1;
	protected Integer fractions1;
	protected Float dose2;
	protected Integer fractions2;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
