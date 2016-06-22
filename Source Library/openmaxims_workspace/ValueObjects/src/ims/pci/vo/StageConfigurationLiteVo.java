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

package ims.pci.vo;

/**
 * Linked to PCI.StageConfiguration business object (ID: 1091100003).
 */
public class StageConfigurationLiteVo extends ims.pci.vo.StageConfigurationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public StageConfigurationLiteVo()
	{
	}
	public StageConfigurationLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public StageConfigurationLiteVo(ims.pci.vo.beans.StageConfigurationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : ims.pci.vo.lookups.Stage.buildLookup(bean.getStage());
		this.ageinmonths = bean.getAgeInMonths();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.beans.StageConfigurationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : ims.pci.vo.lookups.Stage.buildLookup(bean.getStage());
		this.ageinmonths = bean.getAgeInMonths();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.beans.StageConfigurationLiteVoBean bean = null;
		if(map != null)
			bean = (ims.pci.vo.beans.StageConfigurationLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pci.vo.beans.StageConfigurationLiteVoBean();
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
		if(fieldName.equals("STAGE"))
			return getStage();
		if(fieldName.equals("AGEINMONTHS"))
			return getAgeInMonths();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.pci.vo.lookups.Stage getStage()
	{
		return this.stage;
	}
	public void setStage(ims.pci.vo.lookups.Stage value)
	{
		this.isValidated = false;
		this.stage = value;
	}
	public boolean getAgeInMonthsIsNotNull()
	{
		return this.ageinmonths != null;
	}
	public Integer getAgeInMonths()
	{
		return this.ageinmonths;
	}
	public void setAgeInMonths(Integer value)
	{
		this.isValidated = false;
		this.ageinmonths = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.stage != null)
			sb.append(this.stage);
		return sb.toString();
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
		if(this.stage == null)
			listOfErrors.add("Stage is mandatory");
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
	
		StageConfigurationLiteVo clone = new StageConfigurationLiteVo(this.id, this.version);
		
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.pci.vo.lookups.Stage)this.stage.clone();
		clone.ageinmonths = this.ageinmonths;
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
		if (!(StageConfigurationLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A StageConfigurationLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((StageConfigurationLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((StageConfigurationLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.stage != null)
			count++;
		if(this.ageinmonths != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.pci.vo.lookups.Stage stage;
	protected Integer ageinmonths;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
