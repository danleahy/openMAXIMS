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
 * Linked to core.clinical.SuppNetworkServiceProfessionDetail business object (ID: 1003100076).
 */
public class SuppNetworkServiceProfessionDetailVo extends ims.core.clinical.vo.SuppNetworkServiceProfessionDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SuppNetworkServiceProfessionDetailVo()
	{
	}
	public SuppNetworkServiceProfessionDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public SuppNetworkServiceProfessionDetailVo(ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.servicelocation = bean.getServiceLocation();
		this.name = bean.getName();
		this.address = bean.getAddress();
		this.workphone = bean.getWorkPhone();
		this.mobilephone = bean.getMobilePhone();
		this.emailaddress = bean.getEmailAddress();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.servicelocation = bean.getServiceLocation();
		this.name = bean.getName();
		this.address = bean.getAddress();
		this.workphone = bean.getWorkPhone();
		this.mobilephone = bean.getMobilePhone();
		this.emailaddress = bean.getEmailAddress();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.SuppNetworkServiceProfessionDetailVoBean();
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
		if(fieldName.equals("SERVICELOCATION"))
			return getServiceLocation();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("ADDRESS"))
			return getAddress();
		if(fieldName.equals("WORKPHONE"))
			return getWorkPhone();
		if(fieldName.equals("MOBILEPHONE"))
			return getMobilePhone();
		if(fieldName.equals("EMAILADDRESS"))
			return getEmailAddress();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceLocationIsNotNull()
	{
		return this.servicelocation != null;
	}
	public String getServiceLocation()
	{
		return this.servicelocation;
	}
	public static int getServiceLocationMaxLength()
	{
		return 50;
	}
	public void setServiceLocation(String value)
	{
		this.isValidated = false;
		this.servicelocation = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getAddressIsNotNull()
	{
		return this.address != null;
	}
	public String getAddress()
	{
		return this.address;
	}
	public static int getAddressMaxLength()
	{
		return 160;
	}
	public void setAddress(String value)
	{
		this.isValidated = false;
		this.address = value;
	}
	public boolean getWorkPhoneIsNotNull()
	{
		return this.workphone != null;
	}
	public String getWorkPhone()
	{
		return this.workphone;
	}
	public static int getWorkPhoneMaxLength()
	{
		return 30;
	}
	public void setWorkPhone(String value)
	{
		this.isValidated = false;
		this.workphone = value;
	}
	public boolean getMobilePhoneIsNotNull()
	{
		return this.mobilephone != null;
	}
	public String getMobilePhone()
	{
		return this.mobilephone;
	}
	public static int getMobilePhoneMaxLength()
	{
		return 30;
	}
	public void setMobilePhone(String value)
	{
		this.isValidated = false;
		this.mobilephone = value;
	}
	public boolean getEmailAddressIsNotNull()
	{
		return this.emailaddress != null;
	}
	public String getEmailAddress()
	{
		return this.emailaddress;
	}
	public static int getEmailAddressMaxLength()
	{
		return 30;
	}
	public void setEmailAddress(String value)
	{
		this.isValidated = false;
		this.emailaddress = value;
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
		if(this.servicelocation != null)
			if(this.servicelocation.length() > 50)
				listOfErrors.add("The length of the field [servicelocation] in the value object [ims.core.vo.SuppNetworkServiceProfessionDetailVo] is too big. It should be less or equal to 50");
		if(this.name != null)
			if(this.name.length() > 100)
				listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.SuppNetworkServiceProfessionDetailVo] is too big. It should be less or equal to 100");
		if(this.address != null)
			if(this.address.length() > 160)
				listOfErrors.add("The length of the field [address] in the value object [ims.core.vo.SuppNetworkServiceProfessionDetailVo] is too big. It should be less or equal to 160");
		if(this.workphone != null)
			if(this.workphone.length() > 30)
				listOfErrors.add("The length of the field [workphone] in the value object [ims.core.vo.SuppNetworkServiceProfessionDetailVo] is too big. It should be less or equal to 30");
		if(this.mobilephone != null)
			if(this.mobilephone.length() > 30)
				listOfErrors.add("The length of the field [mobilephone] in the value object [ims.core.vo.SuppNetworkServiceProfessionDetailVo] is too big. It should be less or equal to 30");
		if(this.emailaddress != null)
			if(this.emailaddress.length() > 30)
				listOfErrors.add("The length of the field [emailaddress] in the value object [ims.core.vo.SuppNetworkServiceProfessionDetailVo] is too big. It should be less or equal to 30");
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
	
		SuppNetworkServiceProfessionDetailVo clone = new SuppNetworkServiceProfessionDetailVo(this.id, this.version);
		
		clone.servicelocation = this.servicelocation;
		clone.name = this.name;
		clone.address = this.address;
		clone.workphone = this.workphone;
		clone.mobilephone = this.mobilephone;
		clone.emailaddress = this.emailaddress;
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
		if (!(SuppNetworkServiceProfessionDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SuppNetworkServiceProfessionDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SuppNetworkServiceProfessionDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SuppNetworkServiceProfessionDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.servicelocation != null)
			count++;
		if(this.name != null)
			count++;
		if(this.address != null)
			count++;
		if(this.workphone != null)
			count++;
		if(this.mobilephone != null)
			count++;
		if(this.emailaddress != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String servicelocation;
	protected String name;
	protected String address;
	protected String workphone;
	protected String mobilephone;
	protected String emailaddress;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
