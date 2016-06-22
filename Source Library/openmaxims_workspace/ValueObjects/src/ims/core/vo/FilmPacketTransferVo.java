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
 * Linked to core.clinical.FilmPacketTransfer business object (ID: 1003100116).
 */
public class FilmPacketTransferVo extends ims.core.clinical.vo.FilmPacketTransferRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public FilmPacketTransferVo()
	{
	}
	public FilmPacketTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public FilmPacketTransferVo(ims.core.vo.beans.FilmPacketTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.transferlocation = bean.getTransferLocation();
		this.datesent = bean.getDateSent() == null ? null : bean.getDateSent().buildDate();
		this.comment = bean.getComment();
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo();
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.FilmPacketTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.transferlocation = bean.getTransferLocation();
		this.datesent = bean.getDateSent() == null ? null : bean.getDateSent().buildDate();
		this.comment = bean.getComment();
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo(map);
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.FilmPacketTransferVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.FilmPacketTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.FilmPacketTransferVoBean();
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
		if(fieldName.equals("TRANSFERLOCATION"))
			return getTransferLocation();
		if(fieldName.equals("DATESENT"))
			return getDateSent();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("RECORDINGUSER"))
			return getRecordingUser();
		if(fieldName.equals("RECORDINGDATETIME"))
			return getRecordingDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTransferLocationIsNotNull()
	{
		return this.transferlocation != null;
	}
	public String getTransferLocation()
	{
		return this.transferlocation;
	}
	public static int getTransferLocationMaxLength()
	{
		return 30;
	}
	public void setTransferLocation(String value)
	{
		this.isValidated = false;
		this.transferlocation = value;
	}
	public boolean getDateSentIsNotNull()
	{
		return this.datesent != null;
	}
	public ims.framework.utils.Date getDateSent()
	{
		return this.datesent;
	}
	public void setDateSent(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datesent = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 255;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getRecordingUserIsNotNull()
	{
		return this.recordinguser != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.recordinguser = value;
	}
	public boolean getRecordingDateTimeIsNotNull()
	{
		return this.recordingdatetime != null;
	}
	public ims.framework.utils.DateTime getRecordingDateTime()
	{
		return this.recordingdatetime;
	}
	public void setRecordingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.recordingdatetime = value;
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
		if(this.transferlocation == null || this.transferlocation.length() == 0)
			listOfErrors.add("TransferLocation is mandatory");
		else if(this.transferlocation.length() > 30)
			listOfErrors.add("The length of the field [transferlocation] in the value object [ims.core.vo.FilmPacketTransferVo] is too big. It should be less or equal to 30");
		if(this.datesent == null)
			listOfErrors.add("DateSent is mandatory");
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.FilmPacketTransferVo] is too big. It should be less or equal to 255");
		if(this.recordinguser == null)
			listOfErrors.add("RecordingUser is mandatory");
		if(this.recordingdatetime == null)
			listOfErrors.add("RecordingDateTime is mandatory");
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
	
		FilmPacketTransferVo clone = new FilmPacketTransferVo(this.id, this.version);
		
		clone.transferlocation = this.transferlocation;
		if(this.datesent == null)
			clone.datesent = null;
		else
			clone.datesent = (ims.framework.utils.Date)this.datesent.clone();
		clone.comment = this.comment;
		if(this.recordinguser == null)
			clone.recordinguser = null;
		else
			clone.recordinguser = (ims.core.vo.MemberOfStaffLiteVo)this.recordinguser.clone();
		if(this.recordingdatetime == null)
			clone.recordingdatetime = null;
		else
			clone.recordingdatetime = (ims.framework.utils.DateTime)this.recordingdatetime.clone();
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
		if (!(FilmPacketTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A FilmPacketTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		FilmPacketTransferVo compareObj = (FilmPacketTransferVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDateSent() == null && compareObj.getDateSent() != null)
				return -1;
			if(this.getDateSent() != null && compareObj.getDateSent() == null)
				return 1;
			if(this.getDateSent() != null && compareObj.getDateSent() != null)
				retVal = this.getDateSent().compareTo(compareObj.getDateSent());
		}
		if (retVal == 0)
		{
			if(this.getRecordingDateTime() == null && compareObj.getRecordingDateTime() != null)
				return -1;
			if(this.getRecordingDateTime() != null && compareObj.getRecordingDateTime() == null)
				return 1;
			if(this.getRecordingDateTime() != null && compareObj.getRecordingDateTime() != null)
				retVal = this.getRecordingDateTime().compareTo(compareObj.getRecordingDateTime());
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
		if(this.transferlocation != null)
			count++;
		if(this.datesent != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.recordinguser != null)
			count++;
		if(this.recordingdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected String transferlocation;
	protected ims.framework.utils.Date datesent;
	protected String comment;
	protected ims.core.vo.MemberOfStaffLiteVo recordinguser;
	protected ims.framework.utils.DateTime recordingdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
