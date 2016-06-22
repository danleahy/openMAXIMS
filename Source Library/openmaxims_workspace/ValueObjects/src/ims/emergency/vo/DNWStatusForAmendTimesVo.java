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

package ims.emergency.vo;

/**
 * Linked to emergency.DNWStatus business object (ID: 1086100008).
 */
public class DNWStatusForAmendTimesVo extends ims.emergency.vo.DNWStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DNWStatusForAmendTimesVo()
	{
	}
	public DNWStatusForAmendTimesVo(Integer id, int version)
	{
		super(id, version);
	}
	public DNWStatusForAmendTimesVo(ims.emergency.vo.beans.DNWStatusForAmendTimesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.calledamount = bean.getCalledAmount();
		this.authoringuser = bean.getAuthoringUser() == null ? null : bean.getAuthoringUser().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.DNWStatusForAmendTimesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.statusdatetime = bean.getStatusDateTime() == null ? null : bean.getStatusDateTime().buildDateTime();
		this.calledamount = bean.getCalledAmount();
		this.authoringuser = bean.getAuthoringUser() == null ? null : bean.getAuthoringUser().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.DNWStatusForAmendTimesVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.DNWStatusForAmendTimesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.DNWStatusForAmendTimesVoBean();
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
		if(fieldName.equals("STATUSDATETIME"))
			return getStatusDateTime();
		if(fieldName.equals("CALLEDAMOUNT"))
			return getCalledAmount();
		if(fieldName.equals("AUTHORINGUSER"))
			return getAuthoringUser();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStatusDateTimeIsNotNull()
	{
		return this.statusdatetime != null;
	}
	public ims.framework.utils.DateTime getStatusDateTime()
	{
		return this.statusdatetime;
	}
	public void setStatusDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdatetime = value;
	}
	public boolean getCalledAmountIsNotNull()
	{
		return this.calledamount != null;
	}
	public Integer getCalledAmount()
	{
		return this.calledamount;
	}
	public void setCalledAmount(Integer value)
	{
		this.isValidated = false;
		this.calledamount = value;
	}
	public boolean getAuthoringUserIsNotNull()
	{
		return this.authoringuser != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAuthoringUser()
	{
		return this.authoringuser;
	}
	public void setAuthoringUser(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.authoringuser = value;
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
		if(this.statusdatetime == null)
			listOfErrors.add("StatusDateTime is mandatory");
		if(this.calledamount == null)
			listOfErrors.add("CalledAmount is mandatory");
		if(this.authoringuser == null)
			listOfErrors.add("AuthoringUser is mandatory");
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
	
		DNWStatusForAmendTimesVo clone = new DNWStatusForAmendTimesVo(this.id, this.version);
		
		if(this.statusdatetime == null)
			clone.statusdatetime = null;
		else
			clone.statusdatetime = (ims.framework.utils.DateTime)this.statusdatetime.clone();
		clone.calledamount = this.calledamount;
		if(this.authoringuser == null)
			clone.authoringuser = null;
		else
			clone.authoringuser = (ims.core.vo.MemberOfStaffLiteVo)this.authoringuser.clone();
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
		if (!(DNWStatusForAmendTimesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DNWStatusForAmendTimesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DNWStatusForAmendTimesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DNWStatusForAmendTimesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.statusdatetime != null)
			count++;
		if(this.calledamount != null)
			count++;
		if(this.authoringuser != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime statusdatetime;
	protected Integer calledamount;
	protected ims.core.vo.MemberOfStaffLiteVo authoringuser;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
