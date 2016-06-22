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
 * Linked to choose_book.ActionRequest business object (ID: 1069100000).
 */
public class ActionRequestVo extends ims.choose_book.vo.ActionRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActionRequestVo()
	{
	}
	public ActionRequestVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActionRequestVo(ims.chooseandbook.vo.beans.ActionRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.requesttype = bean.getRequestType() == null ? null : ims.chooseandbook.vo.lookups.ActionRequestType.buildLookup(bean.getRequestType());
		this.requestdate = bean.getRequestDate() == null ? null : bean.getRequestDate().buildDateTime();
		this.convid = bean.getConvId();
		this.cpaid = bean.getCpaId();
		this.msgdetails = bean.getMsgDetails();
		this.active = bean.getActive();
		this.statcomment = bean.getStatComment();
		this.progresscomment = bean.getProgressComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.chooseandbook.vo.beans.ActionRequestVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.requesttype = bean.getRequestType() == null ? null : ims.chooseandbook.vo.lookups.ActionRequestType.buildLookup(bean.getRequestType());
		this.requestdate = bean.getRequestDate() == null ? null : bean.getRequestDate().buildDateTime();
		this.convid = bean.getConvId();
		this.cpaid = bean.getCpaId();
		this.msgdetails = bean.getMsgDetails();
		this.active = bean.getActive();
		this.statcomment = bean.getStatComment();
		this.progresscomment = bean.getProgressComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.chooseandbook.vo.beans.ActionRequestVoBean bean = null;
		if(map != null)
			bean = (ims.chooseandbook.vo.beans.ActionRequestVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.chooseandbook.vo.beans.ActionRequestVoBean();
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
		if(fieldName.equals("REQUESTTYPE"))
			return getRequestType();
		if(fieldName.equals("REQUESTDATE"))
			return getRequestDate();
		if(fieldName.equals("CONVID"))
			return getConvId();
		if(fieldName.equals("CPAID"))
			return getCpaId();
		if(fieldName.equals("MSGDETAILS"))
			return getMsgDetails();
		if(fieldName.equals("ACTIVE"))
			return getActive();
		if(fieldName.equals("STATCOMMENT"))
			return getStatComment();
		if(fieldName.equals("PROGRESSCOMMENT"))
			return getProgressComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRequestTypeIsNotNull()
	{
		return this.requesttype != null;
	}
	public ims.chooseandbook.vo.lookups.ActionRequestType getRequestType()
	{
		return this.requesttype;
	}
	public void setRequestType(ims.chooseandbook.vo.lookups.ActionRequestType value)
	{
		this.isValidated = false;
		this.requesttype = value;
	}
	public boolean getRequestDateIsNotNull()
	{
		return this.requestdate != null;
	}
	public ims.framework.utils.DateTime getRequestDate()
	{
		return this.requestdate;
	}
	public void setRequestDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.requestdate = value;
	}
	public boolean getConvIdIsNotNull()
	{
		return this.convid != null;
	}
	public String getConvId()
	{
		return this.convid;
	}
	public static int getConvIdMaxLength()
	{
		return 100;
	}
	public void setConvId(String value)
	{
		this.isValidated = false;
		this.convid = value;
	}
	public boolean getCpaIdIsNotNull()
	{
		return this.cpaid != null;
	}
	public String getCpaId()
	{
		return this.cpaid;
	}
	public static int getCpaIdMaxLength()
	{
		return 100;
	}
	public void setCpaId(String value)
	{
		this.isValidated = false;
		this.cpaid = value;
	}
	public boolean getMsgDetailsIsNotNull()
	{
		return this.msgdetails != null;
	}
	public String getMsgDetails()
	{
		return this.msgdetails;
	}
	public static int getMsgDetailsMaxLength()
	{
		return 2000;
	}
	public void setMsgDetails(String value)
	{
		this.isValidated = false;
		this.msgdetails = value;
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
	public boolean getStatCommentIsNotNull()
	{
		return this.statcomment != null;
	}
	public String getStatComment()
	{
		return this.statcomment;
	}
	public static int getStatCommentMaxLength()
	{
		return 255;
	}
	public void setStatComment(String value)
	{
		this.isValidated = false;
		this.statcomment = value;
	}
	public boolean getProgressCommentIsNotNull()
	{
		return this.progresscomment != null;
	}
	public String getProgressComment()
	{
		return this.progresscomment;
	}
	public static int getProgressCommentMaxLength()
	{
		return 255;
	}
	public void setProgressComment(String value)
	{
		this.isValidated = false;
		this.progresscomment = value;
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
		if(this.requesttype == null)
			listOfErrors.add("requestType is mandatory");
		if(this.requestdate == null)
			listOfErrors.add("requestDate is mandatory");
		if(this.convid != null)
			if(this.convid.length() > 100)
				listOfErrors.add("The length of the field [convid] in the value object [ims.chooseandbook.vo.ActionRequestVo] is too big. It should be less or equal to 100");
		if(this.cpaid != null)
			if(this.cpaid.length() > 100)
				listOfErrors.add("The length of the field [cpaid] in the value object [ims.chooseandbook.vo.ActionRequestVo] is too big. It should be less or equal to 100");
		if(this.msgdetails != null)
			if(this.msgdetails.length() > 2000)
				listOfErrors.add("The length of the field [msgdetails] in the value object [ims.chooseandbook.vo.ActionRequestVo] is too big. It should be less or equal to 2000");
		if(this.statcomment != null)
			if(this.statcomment.length() > 255)
				listOfErrors.add("The length of the field [statcomment] in the value object [ims.chooseandbook.vo.ActionRequestVo] is too big. It should be less or equal to 255");
		if(this.progresscomment != null)
			if(this.progresscomment.length() > 255)
				listOfErrors.add("The length of the field [progresscomment] in the value object [ims.chooseandbook.vo.ActionRequestVo] is too big. It should be less or equal to 255");
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
	
		ActionRequestVo clone = new ActionRequestVo(this.id, this.version);
		
		if(this.requesttype == null)
			clone.requesttype = null;
		else
			clone.requesttype = (ims.chooseandbook.vo.lookups.ActionRequestType)this.requesttype.clone();
		if(this.requestdate == null)
			clone.requestdate = null;
		else
			clone.requestdate = (ims.framework.utils.DateTime)this.requestdate.clone();
		clone.convid = this.convid;
		clone.cpaid = this.cpaid;
		clone.msgdetails = this.msgdetails;
		clone.active = this.active;
		clone.statcomment = this.statcomment;
		clone.progresscomment = this.progresscomment;
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
		if (!(ActionRequestVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActionRequestVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ActionRequestVo compareObj = (ActionRequestVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ActionRequest() == null && compareObj.getID_ActionRequest() != null)
				return -1;
			if(this.getID_ActionRequest() != null && compareObj.getID_ActionRequest() == null)
				return 1;
			if(this.getID_ActionRequest() != null && compareObj.getID_ActionRequest() != null)
				retVal = this.getID_ActionRequest().compareTo(compareObj.getID_ActionRequest());
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
		if(this.requesttype != null)
			count++;
		if(this.requestdate != null)
			count++;
		if(this.convid != null)
			count++;
		if(this.cpaid != null)
			count++;
		if(this.msgdetails != null)
			count++;
		if(this.active != null)
			count++;
		if(this.statcomment != null)
			count++;
		if(this.progresscomment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.chooseandbook.vo.lookups.ActionRequestType requesttype;
	protected ims.framework.utils.DateTime requestdate;
	protected String convid;
	protected String cpaid;
	protected String msgdetails;
	protected Boolean active;
	protected String statcomment;
	protected String progresscomment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
