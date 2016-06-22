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

package ims.core.vo;

/**
 * Linked to core.admin.HrgConfig business object (ID: 1004100036).
 */
public class HrgConfigLiteVo extends ims.core.admin.vo.HrgConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HrgConfigLiteVo()
	{
	}
	public HrgConfigLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public HrgConfigLiteVo(ims.core.vo.beans.HrgConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hrgcode = bean.getHRGCode();
		this.hrgdescription = bean.getHRGDescription();
		this.costpounds = bean.getCostPounds();
		this.costpence = bean.getCostPence();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.HrgConfigLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hrgcode = bean.getHRGCode();
		this.hrgdescription = bean.getHRGDescription();
		this.costpounds = bean.getCostPounds();
		this.costpence = bean.getCostPence();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.HrgConfigLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.HrgConfigLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.HrgConfigLiteVoBean();
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
		if(fieldName.equals("HRGCODE"))
			return getHRGCode();
		if(fieldName.equals("HRGDESCRIPTION"))
			return getHRGDescription();
		if(fieldName.equals("COSTPOUNDS"))
			return getCostPounds();
		if(fieldName.equals("COSTPENCE"))
			return getCostPence();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHRGCodeIsNotNull()
	{
		return this.hrgcode != null;
	}
	public String getHRGCode()
	{
		return this.hrgcode;
	}
	public static int getHRGCodeMaxLength()
	{
		return 25;
	}
	public void setHRGCode(String value)
	{
		this.isValidated = false;
		this.hrgcode = value;
	}
	public boolean getHRGDescriptionIsNotNull()
	{
		return this.hrgdescription != null;
	}
	public String getHRGDescription()
	{
		return this.hrgdescription;
	}
	public static int getHRGDescriptionMaxLength()
	{
		return 255;
	}
	public void setHRGDescription(String value)
	{
		this.isValidated = false;
		this.hrgdescription = value;
	}
	public boolean getCostPoundsIsNotNull()
	{
		return this.costpounds != null;
	}
	public Integer getCostPounds()
	{
		return this.costpounds;
	}
	public void setCostPounds(Integer value)
	{
		this.isValidated = false;
		this.costpounds = value;
	}
	public boolean getCostPenceIsNotNull()
	{
		return this.costpence != null;
	}
	public Integer getCostPence()
	{
		return this.costpence;
	}
	public void setCostPence(Integer value)
	{
		this.isValidated = false;
		this.costpence = value;
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
		if(this.hrgcode == null || this.hrgcode.length() == 0)
			listOfErrors.add("HRGCode is mandatory");
		else if(this.hrgcode.length() > 25)
			listOfErrors.add("The length of the field [hrgcode] in the value object [ims.core.vo.HrgConfigLiteVo] is too big. It should be less or equal to 25");
		if(this.hrgdescription == null || this.hrgdescription.length() == 0)
			listOfErrors.add("HRGDescription is mandatory");
		else if(this.hrgdescription.length() > 255)
			listOfErrors.add("The length of the field [hrgdescription] in the value object [ims.core.vo.HrgConfigLiteVo] is too big. It should be less or equal to 255");
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
	
		HrgConfigLiteVo clone = new HrgConfigLiteVo(this.id, this.version);
		
		clone.hrgcode = this.hrgcode;
		clone.hrgdescription = this.hrgdescription;
		clone.costpounds = this.costpounds;
		clone.costpence = this.costpence;
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
		if (!(HrgConfigLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HrgConfigLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((HrgConfigLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((HrgConfigLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.hrgcode != null)
			count++;
		if(this.hrgdescription != null)
			count++;
		if(this.costpounds != null)
			count++;
		if(this.costpence != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String hrgcode;
	protected String hrgdescription;
	protected Integer costpounds;
	protected Integer costpence;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
