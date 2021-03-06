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
 * Linked to core.admin.ReportSeedBo business object (ID: 1004100010).
 */
public class DischargeReportSeedVo extends ims.core.admin.vo.ReportSeedBoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DischargeReportSeedVo()
	{
	}
	public DischargeReportSeedVo(Integer id, int version)
	{
		super(id, version);
	}
	public DischargeReportSeedVo(ims.correspondence.vo.beans.DischargeReportSeedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.boname = bean.getBOName();
		this.bofieldname = bean.getBOFieldName();
		this.datatype = bean.getDataType();
		this.canbenull = bean.getCanBeNull();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.DischargeReportSeedVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.boname = bean.getBOName();
		this.bofieldname = bean.getBOFieldName();
		this.datatype = bean.getDataType();
		this.canbenull = bean.getCanBeNull();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.DischargeReportSeedVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.DischargeReportSeedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.DischargeReportSeedVoBean();
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
		if(fieldName.equals("BONAME"))
			return getBOName();
		if(fieldName.equals("BOFIELDNAME"))
			return getBOFieldName();
		if(fieldName.equals("DATATYPE"))
			return getDataType();
		if(fieldName.equals("CANBENULL"))
			return getCanBeNull();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBONameIsNotNull()
	{
		return this.boname != null;
	}
	public String getBOName()
	{
		return this.boname;
	}
	public static int getBONameMaxLength()
	{
		return 200;
	}
	public void setBOName(String value)
	{
		this.isValidated = false;
		this.boname = value;
	}
	public boolean getBOFieldNameIsNotNull()
	{
		return this.bofieldname != null;
	}
	public String getBOFieldName()
	{
		return this.bofieldname;
	}
	public static int getBOFieldNameMaxLength()
	{
		return 100;
	}
	public void setBOFieldName(String value)
	{
		this.isValidated = false;
		this.bofieldname = value;
	}
	public boolean getDataTypeIsNotNull()
	{
		return this.datatype != null;
	}
	public String getDataType()
	{
		return this.datatype;
	}
	public static int getDataTypeMaxLength()
	{
		return 255;
	}
	public void setDataType(String value)
	{
		this.isValidated = false;
		this.datatype = value;
	}
	public boolean getCanBeNullIsNotNull()
	{
		return this.canbenull != null;
	}
	public Boolean getCanBeNull()
	{
		return this.canbenull;
	}
	public void setCanBeNull(Boolean value)
	{
		this.isValidated = false;
		this.canbenull = value;
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
		if(this.boname != null)
			if(this.boname.length() > 200)
				listOfErrors.add("The length of the field [boname] in the value object [ims.correspondence.vo.DischargeReportSeedVo] is too big. It should be less or equal to 200");
		if(this.bofieldname != null)
			if(this.bofieldname.length() > 100)
				listOfErrors.add("The length of the field [bofieldname] in the value object [ims.correspondence.vo.DischargeReportSeedVo] is too big. It should be less or equal to 100");
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
	
		DischargeReportSeedVo clone = new DischargeReportSeedVo(this.id, this.version);
		
		clone.boname = this.boname;
		clone.bofieldname = this.bofieldname;
		clone.datatype = this.datatype;
		clone.canbenull = this.canbenull;
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
		if (!(DischargeReportSeedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DischargeReportSeedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DischargeReportSeedVo compareObj = (DischargeReportSeedVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getBOName() == null && compareObj.getBOName() != null)
				return -1;
			if(this.getBOName() != null && compareObj.getBOName() == null)
				return 1;
			if(this.getBOName() != null && compareObj.getBOName() != null)
			{
				if(caseInsensitive)
					retVal = this.getBOName().toLowerCase().compareTo(compareObj.getBOName().toLowerCase());
				else
					retVal = this.getBOName().compareTo(compareObj.getBOName());
			}
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
		if(this.boname != null)
			count++;
		if(this.bofieldname != null)
			count++;
		if(this.datatype != null)
			count++;
		if(this.canbenull != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String boname;
	protected String bofieldname;
	protected String datatype;
	protected Boolean canbenull;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
