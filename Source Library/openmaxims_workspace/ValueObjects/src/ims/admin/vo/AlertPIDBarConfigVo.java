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

package ims.admin.vo;

/**
 * Linked to clinical.configuration.AlertPIDBarConfig business object (ID: 1073100037).
 */
public class AlertPIDBarConfigVo extends ims.clinical.configuration.vo.AlertPIDBarConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AlertPIDBarConfigVo()
	{
	}
	public AlertPIDBarConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public AlertPIDBarConfigVo(ims.admin.vo.beans.AlertPIDBarConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.alertcategoryposition1 = bean.getAlertCategoryPosition1() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition1());
		this.alertcategoryposition2 = bean.getAlertCategoryPosition2() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition2());
		this.alertcategoryposition3 = bean.getAlertCategoryPosition3() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition3());
		this.alertcategoryposition4 = bean.getAlertCategoryPosition4() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition4());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AlertPIDBarConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.alertcategoryposition1 = bean.getAlertCategoryPosition1() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition1());
		this.alertcategoryposition2 = bean.getAlertCategoryPosition2() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition2());
		this.alertcategoryposition3 = bean.getAlertCategoryPosition3() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition3());
		this.alertcategoryposition4 = bean.getAlertCategoryPosition4() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertCategoryPosition4());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AlertPIDBarConfigVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AlertPIDBarConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AlertPIDBarConfigVoBean();
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
		if(fieldName.equals("ALERTCATEGORYPOSITION1"))
			return getAlertCategoryPosition1();
		if(fieldName.equals("ALERTCATEGORYPOSITION2"))
			return getAlertCategoryPosition2();
		if(fieldName.equals("ALERTCATEGORYPOSITION3"))
			return getAlertCategoryPosition3();
		if(fieldName.equals("ALERTCATEGORYPOSITION4"))
			return getAlertCategoryPosition4();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAlertCategoryPosition1IsNotNull()
	{
		return this.alertcategoryposition1 != null;
	}
	public ims.core.vo.lookups.AlertType getAlertCategoryPosition1()
	{
		return this.alertcategoryposition1;
	}
	public void setAlertCategoryPosition1(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alertcategoryposition1 = value;
	}
	public boolean getAlertCategoryPosition2IsNotNull()
	{
		return this.alertcategoryposition2 != null;
	}
	public ims.core.vo.lookups.AlertType getAlertCategoryPosition2()
	{
		return this.alertcategoryposition2;
	}
	public void setAlertCategoryPosition2(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alertcategoryposition2 = value;
	}
	public boolean getAlertCategoryPosition3IsNotNull()
	{
		return this.alertcategoryposition3 != null;
	}
	public ims.core.vo.lookups.AlertType getAlertCategoryPosition3()
	{
		return this.alertcategoryposition3;
	}
	public void setAlertCategoryPosition3(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alertcategoryposition3 = value;
	}
	public boolean getAlertCategoryPosition4IsNotNull()
	{
		return this.alertcategoryposition4 != null;
	}
	public ims.core.vo.lookups.AlertType getAlertCategoryPosition4()
	{
		return this.alertcategoryposition4;
	}
	public void setAlertCategoryPosition4(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alertcategoryposition4 = value;
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
	
		AlertPIDBarConfigVo clone = new AlertPIDBarConfigVo(this.id, this.version);
		
		if(this.alertcategoryposition1 == null)
			clone.alertcategoryposition1 = null;
		else
			clone.alertcategoryposition1 = (ims.core.vo.lookups.AlertType)this.alertcategoryposition1.clone();
		if(this.alertcategoryposition2 == null)
			clone.alertcategoryposition2 = null;
		else
			clone.alertcategoryposition2 = (ims.core.vo.lookups.AlertType)this.alertcategoryposition2.clone();
		if(this.alertcategoryposition3 == null)
			clone.alertcategoryposition3 = null;
		else
			clone.alertcategoryposition3 = (ims.core.vo.lookups.AlertType)this.alertcategoryposition3.clone();
		if(this.alertcategoryposition4 == null)
			clone.alertcategoryposition4 = null;
		else
			clone.alertcategoryposition4 = (ims.core.vo.lookups.AlertType)this.alertcategoryposition4.clone();
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
		if (!(AlertPIDBarConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AlertPIDBarConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AlertPIDBarConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AlertPIDBarConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.alertcategoryposition1 != null)
			count++;
		if(this.alertcategoryposition2 != null)
			count++;
		if(this.alertcategoryposition3 != null)
			count++;
		if(this.alertcategoryposition4 != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.lookups.AlertType alertcategoryposition1;
	protected ims.core.vo.lookups.AlertType alertcategoryposition2;
	protected ims.core.vo.lookups.AlertType alertcategoryposition3;
	protected ims.core.vo.lookups.AlertType alertcategoryposition4;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
