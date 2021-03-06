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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.SessionParentChildSlot business object (ID: 1090100019).
 */
public class SessionFlexibleSlotForSessionManagementVo extends ims.scheduling.vo.SessionParentChildSlotRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionFlexibleSlotForSessionManagementVo()
	{
	}
	public SessionFlexibleSlotForSessionManagementVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionFlexibleSlotForSessionManagementVo(ims.scheduling.vo.beans.SessionFlexibleSlotForSessionManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildTime();
		this.isactive = bean.getIsActive();
		this.duration = bean.getDuration();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo();
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo();
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.comment = bean.getComment();
		this.catsreferral = bean.getCatsReferral() == null ? null : bean.getCatsReferral().buildVo();
		this.cancelblockreason = bean.getCancelBlockReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancelBlockReason());
		this.cancelblockcomment = bean.getCancelBlockComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.SessionFlexibleSlotForSessionManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildTime();
		this.isactive = bean.getIsActive();
		this.duration = bean.getDuration();
		this.status = bean.getStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getStatus());
		this.appointment = bean.getAppointment() == null ? null : bean.getAppointment().buildVo(map);
		this.slotresp = bean.getSlotResp() == null ? null : bean.getSlotResp().buildVo(map);
		this.priority = bean.getPriority() == null ? null : ims.scheduling.vo.lookups.SchedulingPriority.buildLookup(bean.getPriority());
		this.comment = bean.getComment();
		this.catsreferral = bean.getCatsReferral() == null ? null : bean.getCatsReferral().buildVo(map);
		this.cancelblockreason = bean.getCancelBlockReason() == null ? null : ims.scheduling.vo.lookups.CancelAppointmentReason.buildLookup(bean.getCancelBlockReason());
		this.cancelblockcomment = bean.getCancelBlockComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.SessionFlexibleSlotForSessionManagementVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.SessionFlexibleSlotForSessionManagementVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.SessionFlexibleSlotForSessionManagementVoBean();
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
		if(fieldName.equals("STARTTIME"))
			return getStartTime();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		if(fieldName.equals("SLOTRESP"))
			return getSlotResp();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		if(fieldName.equals("CANCELBLOCKREASON"))
			return getCancelBlockReason();
		if(fieldName.equals("CANCELBLOCKCOMMENT"))
			return getCancelBlockComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartTimeIsNotNull()
	{
		return this.starttime != null;
	}
	public ims.framework.utils.Time getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttime = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.BookingAppointmentForSessionManagementVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.BookingAppointmentForSessionManagementVo value)
	{
		this.isValidated = false;
		this.appointment = value;
	}
	public boolean getSlotRespIsNotNull()
	{
		return this.slotresp != null;
	}
	public ims.scheduling.vo.SessionListOwnerLiteVo getSlotResp()
	{
		return this.slotresp;
	}
	public void setSlotResp(ims.scheduling.vo.SessionListOwnerLiteVo value)
	{
		this.isValidated = false;
		this.slotresp = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.scheduling.vo.lookups.SchedulingPriority getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.scheduling.vo.lookups.SchedulingPriority value)
	{
		this.isValidated = false;
		this.priority = value;
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
		return 500;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.RefMan.vo.CatsReferralForSessionManagementVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.RefMan.vo.CatsReferralForSessionManagementVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getCancelBlockReasonIsNotNull()
	{
		return this.cancelblockreason != null;
	}
	public ims.scheduling.vo.lookups.CancelAppointmentReason getCancelBlockReason()
	{
		return this.cancelblockreason;
	}
	public void setCancelBlockReason(ims.scheduling.vo.lookups.CancelAppointmentReason value)
	{
		this.isValidated = false;
		this.cancelblockreason = value;
	}
	public boolean getCancelBlockCommentIsNotNull()
	{
		return this.cancelblockcomment != null;
	}
	public String getCancelBlockComment()
	{
		return this.cancelblockcomment;
	}
	public static int getCancelBlockCommentMaxLength()
	{
		return 250;
	}
	public void setCancelBlockComment(String value)
	{
		this.isValidated = false;
		this.cancelblockcomment = value;
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
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.comment != null)
			if(this.comment.length() > 500)
				listOfErrors.add("The length of the field [comment] in the value object [ims.scheduling.vo.SessionFlexibleSlotForSessionManagementVo] is too big. It should be less or equal to 500");
		if(this.cancelblockcomment != null)
			if(this.cancelblockcomment.length() > 250)
				listOfErrors.add("The length of the field [cancelblockcomment] in the value object [ims.scheduling.vo.SessionFlexibleSlotForSessionManagementVo] is too big. It should be less or equal to 250");
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
	
		SessionFlexibleSlotForSessionManagementVo clone = new SessionFlexibleSlotForSessionManagementVo(this.id, this.version);
		
		if(this.starttime == null)
			clone.starttime = null;
		else
			clone.starttime = (ims.framework.utils.Time)this.starttime.clone();
		clone.isactive = this.isactive;
		clone.duration = this.duration;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.scheduling.vo.lookups.Status_Reason)this.status.clone();
		if(this.appointment == null)
			clone.appointment = null;
		else
			clone.appointment = (ims.scheduling.vo.BookingAppointmentForSessionManagementVo)this.appointment.clone();
		if(this.slotresp == null)
			clone.slotresp = null;
		else
			clone.slotresp = (ims.scheduling.vo.SessionListOwnerLiteVo)this.slotresp.clone();
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.scheduling.vo.lookups.SchedulingPriority)this.priority.clone();
		clone.comment = this.comment;
		if(this.catsreferral == null)
			clone.catsreferral = null;
		else
			clone.catsreferral = (ims.RefMan.vo.CatsReferralForSessionManagementVo)this.catsreferral.clone();
		if(this.cancelblockreason == null)
			clone.cancelblockreason = null;
		else
			clone.cancelblockreason = (ims.scheduling.vo.lookups.CancelAppointmentReason)this.cancelblockreason.clone();
		clone.cancelblockcomment = this.cancelblockcomment;
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
		if (!(SessionFlexibleSlotForSessionManagementVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionFlexibleSlotForSessionManagementVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionFlexibleSlotForSessionManagementVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionFlexibleSlotForSessionManagementVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.starttime != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.status != null)
			count++;
		if(this.appointment != null)
			count++;
		if(this.slotresp != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.catsreferral != null)
			count++;
		if(this.cancelblockreason != null)
			count++;
		if(this.cancelblockcomment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.framework.utils.Time starttime;
	protected Boolean isactive;
	protected Integer duration;
	protected ims.scheduling.vo.lookups.Status_Reason status;
	protected ims.scheduling.vo.BookingAppointmentForSessionManagementVo appointment;
	protected ims.scheduling.vo.SessionListOwnerLiteVo slotresp;
	protected ims.scheduling.vo.lookups.SchedulingPriority priority;
	protected String comment;
	protected ims.RefMan.vo.CatsReferralForSessionManagementVo catsreferral;
	protected ims.scheduling.vo.lookups.CancelAppointmentReason cancelblockreason;
	protected String cancelblockcomment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
