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
 * Linked to core.resource.GpToPractice business object (ID: 1005100004).
 */
public class GpToLocationPracticeVo extends ims.core.resource.vo.GpToPracticeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public GpToLocationPracticeVo()
	{
	}
	public GpToLocationPracticeVo(Integer id, int version)
	{
		super(id, version);
	}
	public GpToLocationPracticeVo(ims.correspondence.vo.beans.GpToLocationPracticeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.gp = bean.getGp() == null ? null : bean.getGp().buildVo();
		this.isprimarypractice = bean.getIsPrimaryPractice();
		this.gpcode = bean.getGpCode();
		this.practice = bean.getPractice() == null ? null : bean.getPractice().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.GpToLocationPracticeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.gp = bean.getGp() == null ? null : bean.getGp().buildVo(map);
		this.isprimarypractice = bean.getIsPrimaryPractice();
		this.gpcode = bean.getGpCode();
		this.practice = bean.getPractice() == null ? null : bean.getPractice().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.GpToLocationPracticeVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.GpToLocationPracticeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.GpToLocationPracticeVoBean();
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
		if(fieldName.equals("GP"))
			return getGp();
		if(fieldName.equals("ISPRIMARYPRACTICE"))
			return getIsPrimaryPractice();
		if(fieldName.equals("GPCODE"))
			return getGpCode();
		if(fieldName.equals("PRACTICE"))
			return getPractice();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGpIsNotNull()
	{
		return this.gp != null;
	}
	public ims.core.vo.GpShortVo getGp()
	{
		return this.gp;
	}
	public void setGp(ims.core.vo.GpShortVo value)
	{
		this.isValidated = false;
		this.gp = value;
	}
	public boolean getIsPrimaryPracticeIsNotNull()
	{
		return this.isprimarypractice != null;
	}
	public Boolean getIsPrimaryPractice()
	{
		return this.isprimarypractice;
	}
	public void setIsPrimaryPractice(Boolean value)
	{
		this.isValidated = false;
		this.isprimarypractice = value;
	}
	public boolean getGpCodeIsNotNull()
	{
		return this.gpcode != null;
	}
	public String getGpCode()
	{
		return this.gpcode;
	}
	public static int getGpCodeMaxLength()
	{
		return 40;
	}
	public void setGpCode(String value)
	{
		this.isValidated = false;
		this.gpcode = value;
	}
	public boolean getPracticeIsNotNull()
	{
		return this.practice != null;
	}
	public ims.core.vo.GpPracticeLiteVo getPractice()
	{
		return this.practice;
	}
	public void setPractice(ims.core.vo.GpPracticeLiteVo value)
	{
		this.isValidated = false;
		this.practice = value;
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
		if(this.gp != null)
		{
			if(!this.gp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.practice != null)
		{
			if(!this.practice.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.gp != null)
		{
			String[] listOfOtherErrors = this.gp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.gpcode != null)
			if(this.gpcode.length() > 40)
				listOfErrors.add("The length of the field [gpcode] in the value object [ims.correspondence.vo.GpToLocationPracticeVo] is too big. It should be less or equal to 40");
		if(this.practice != null)
		{
			String[] listOfOtherErrors = this.practice.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		GpToLocationPracticeVo clone = new GpToLocationPracticeVo(this.id, this.version);
		
		if(this.gp == null)
			clone.gp = null;
		else
			clone.gp = (ims.core.vo.GpShortVo)this.gp.clone();
		clone.isprimarypractice = this.isprimarypractice;
		clone.gpcode = this.gpcode;
		if(this.practice == null)
			clone.practice = null;
		else
			clone.practice = (ims.core.vo.GpPracticeLiteVo)this.practice.clone();
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
		if (!(GpToLocationPracticeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A GpToLocationPracticeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((GpToLocationPracticeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((GpToLocationPracticeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.gp != null)
			count++;
		if(this.isprimarypractice != null)
			count++;
		if(this.gpcode != null)
			count++;
		if(this.practice != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.GpShortVo gp;
	protected Boolean isprimarypractice;
	protected String gpcode;
	protected ims.core.vo.GpPracticeLiteVo practice;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
