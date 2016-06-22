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

package ims.chooseandbook.vo;

/**
 * Linked to choose_book.PdsRequest business object (ID: 1069100002).
 */
public class PdsRequestVo extends ims.choose_book.vo.PdsRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PdsRequestVo()
	{
	}
	public PdsRequestVo(Integer id, int version)
	{
		super(id, version);
	}
	public PdsRequestVo(ims.chooseandbook.vo.beans.PdsRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nhsn = bean.getNhsn();
		this.datetimerequested = bean.getDateTimeRequested() == null ? null : bean.getDateTimeRequested().buildDateTime();
		this.datetimelastchecked = bean.getDateTimeLastChecked() == null ? null : bean.getDateTimeLastChecked().buildDateTime();
		this.active = bean.getActive();
		this.comments = bean.getComments();
		this.success = bean.getSuccess() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSuccess());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.chooseandbook.vo.beans.PdsRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nhsn = bean.getNhsn();
		this.datetimerequested = bean.getDateTimeRequested() == null ? null : bean.getDateTimeRequested().buildDateTime();
		this.datetimelastchecked = bean.getDateTimeLastChecked() == null ? null : bean.getDateTimeLastChecked().buildDateTime();
		this.active = bean.getActive();
		this.comments = bean.getComments();
		this.success = bean.getSuccess() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSuccess());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.chooseandbook.vo.beans.PdsRequestVoBean bean = null;
		if(map != null)
			bean = (ims.chooseandbook.vo.beans.PdsRequestVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.chooseandbook.vo.beans.PdsRequestVoBean();
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
		if(fieldName.equals("NHSN"))
			return getNhsn();
		if(fieldName.equals("DATETIMEREQUESTED"))
			return getDateTimeRequested();
		if(fieldName.equals("DATETIMELASTCHECKED"))
			return getDateTimeLastChecked();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("SUCCESS"))
			return getSuccess();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNhsnIsNotNull()
	{
		return this.nhsn != null;
	}
	public String getNhsn()
	{
		return this.nhsn;
	}
	public static int getNhsnMaxLength()
	{
		return 20;
	}
	public void setNhsn(String value)
	{
		this.isValidated = false;
		this.nhsn = value;
	}
	public boolean getDateTimeRequestedIsNotNull()
	{
		return this.datetimerequested != null;
	}
	public ims.framework.utils.DateTime getDateTimeRequested()
	{
		return this.datetimerequested;
	}
	public void setDateTimeRequested(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetimerequested = value;
	}
	public boolean getDateTimeLastCheckedIsNotNull()
	{
		return this.datetimelastchecked != null;
	}
	public ims.framework.utils.DateTime getDateTimeLastChecked()
	{
		return this.datetimelastchecked;
	}
	public void setDateTimeLastChecked(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetimelastchecked = value;
	}
	public boolean getActiveIsNotNull()
	{
		return this.active != null;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.isValidated = false;
		this.active = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getSuccessIsNotNull()
	{
		return this.success != null;
	}
	public ims.core.vo.lookups.YesNo getSuccess()
	{
		return this.success;
	}
	public void setSuccess(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.success = value;
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
		if(this.nhsn == null || this.nhsn.length() == 0)
			listOfErrors.add("nhsn is mandatory");
		else if(this.nhsn.length() > 20)
			listOfErrors.add("The length of the field [nhsn] in the value object [ims.chooseandbook.vo.PdsRequestVo] is too big. It should be less or equal to 20");
		if(this.datetimerequested == null)
			listOfErrors.add("dateTimeRequested is mandatory");
		if(this.active == null)
			listOfErrors.add("active is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 255)
				listOfErrors.add("The length of the field [comments] in the value object [ims.chooseandbook.vo.PdsRequestVo] is too big. It should be less or equal to 255");
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
	
		PdsRequestVo clone = new PdsRequestVo(this.id, this.version);
		
		clone.nhsn = this.nhsn;
		if(this.datetimerequested == null)
			clone.datetimerequested = null;
		else
			clone.datetimerequested = (ims.framework.utils.DateTime)this.datetimerequested.clone();
		if(this.datetimelastchecked == null)
			clone.datetimelastchecked = null;
		else
			clone.datetimelastchecked = (ims.framework.utils.DateTime)this.datetimelastchecked.clone();
		clone.active = this.active;
		clone.comments = this.comments;
		if(this.success == null)
			clone.success = null;
		else
			clone.success = (ims.core.vo.lookups.YesNo)this.success.clone();
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
		if (!(PdsRequestVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PdsRequestVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PdsRequestVo compareObj = (PdsRequestVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PdsRequest() == null && compareObj.getID_PdsRequest() != null)
				return -1;
			if(this.getID_PdsRequest() != null && compareObj.getID_PdsRequest() == null)
				return 1;
			if(this.getID_PdsRequest() != null && compareObj.getID_PdsRequest() != null)
				retVal = this.getID_PdsRequest().compareTo(compareObj.getID_PdsRequest());
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
		if(this.nhsn != null)
			count++;
		if(this.datetimerequested != null)
			count++;
		if(this.datetimelastchecked != null)
			count++;
		if(this.active != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.success != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String nhsn;
	protected ims.framework.utils.DateTime datetimerequested;
	protected ims.framework.utils.DateTime datetimelastchecked;
	protected Boolean active;
	protected String comments;
	protected ims.core.vo.lookups.YesNo success;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
