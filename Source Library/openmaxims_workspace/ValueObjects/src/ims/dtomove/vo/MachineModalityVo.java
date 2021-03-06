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

package ims.dtomove.vo;

/**
 * Linked to dto_move.MachineModality business object (ID: 1105100005).
 */
public class MachineModalityVo extends ims.dto_move.vo.MachineModalityRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MachineModalityVo()
	{
	}
	public MachineModalityVo(Integer id, int version)
	{
		super(id, version);
	}
	public MachineModalityVo(ims.dtomove.vo.beans.MachineModalityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.modalitytype = bean.getModalityType();
		this.energy = bean.getEnergy();
		this.energyunit = bean.getEnergyUnit();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.active = bean.getActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.dtomove.vo.beans.MachineModalityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.modalitytype = bean.getModalityType();
		this.energy = bean.getEnergy();
		this.energyunit = bean.getEnergyUnit();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.active = bean.getActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.dtomove.vo.beans.MachineModalityVoBean bean = null;
		if(map != null)
			bean = (ims.dtomove.vo.beans.MachineModalityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.dtomove.vo.beans.MachineModalityVoBean();
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
		if(fieldName.equals("MODALITYTYPE"))
			return getModalityType();
		if(fieldName.equals("ENERGY"))
			return getEnergy();
		if(fieldName.equals("ENERGYUNIT"))
			return getEnergyUnit();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getModalityTypeIsNotNull()
	{
		return this.modalitytype != null;
	}
	public Integer getModalityType()
	{
		return this.modalitytype;
	}
	public void setModalityType(Integer value)
	{
		this.isValidated = false;
		this.modalitytype = value;
	}
	public boolean getEnergyIsNotNull()
	{
		return this.energy != null;
	}
	public Float getEnergy()
	{
		return this.energy;
	}
	public void setEnergy(Float value)
	{
		this.isValidated = false;
		this.energy = value;
	}
	public boolean getEnergyUnitIsNotNull()
	{
		return this.energyunit != null;
	}
	public Integer getEnergyUnit()
	{
		return this.energyunit;
	}
	public void setEnergyUnit(Integer value)
	{
		this.isValidated = false;
		this.energyunit = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public String getActive()
	{
		return this.active;
	}
	public static int getActiveMaxLength()
	{
		return 1;
	}
	public void setActive(String value)
	{
		this.isValidated = false;
		this.active = value;
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
		if(this.active != null)
			if(this.active.length() > 1)
				listOfErrors.add("The length of the field [active] in the value object [ims.dtomove.vo.MachineModalityVo] is too big. It should be less or equal to 1");
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
	
		MachineModalityVo clone = new MachineModalityVo(this.id, this.version);
		
		clone.modalitytype = this.modalitytype;
		clone.energy = this.energy;
		clone.energyunit = this.energyunit;
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		clone.active = this.active;
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
		if (!(MachineModalityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MachineModalityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((MachineModalityVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((MachineModalityVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.modalitytype != null)
			count++;
		if(this.energy != null)
			count++;
		if(this.energyunit != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.active != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected Integer modalitytype;
	protected Float energy;
	protected Integer energyunit;
	protected ims.framework.utils.Date enddate;
	protected String active;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
