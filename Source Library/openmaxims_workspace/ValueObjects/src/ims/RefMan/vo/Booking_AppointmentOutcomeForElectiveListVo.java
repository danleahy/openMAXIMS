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

package ims.RefMan.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class Booking_AppointmentOutcomeForElectiveListVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Booking_AppointmentOutcomeForElectiveListVo()
	{
	}
	public Booking_AppointmentOutcomeForElectiveListVo(Integer id, int version)
	{
		super(id, version);
	}
	public Booking_AppointmentOutcomeForElectiveListVo(ims.RefMan.vo.beans.Booking_AppointmentOutcomeForElectiveListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.outcomereason = bean.getOutcomeReason() == null ? null : ims.admin.vo.lookups.AppointmentOutcomeReason.buildLookup(bean.getOutcomeReason());
		this.outcomecomments = bean.getOutcomeComments();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.Booking_AppointmentOutcomeForElectiveListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.outcomereason = bean.getOutcomeReason() == null ? null : ims.admin.vo.lookups.AppointmentOutcomeReason.buildLookup(bean.getOutcomeReason());
		this.outcomecomments = bean.getOutcomeComments();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.Booking_AppointmentOutcomeForElectiveListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.Booking_AppointmentOutcomeForElectiveListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.Booking_AppointmentOutcomeForElectiveListVoBean();
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
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("APPTSTARTTIME"))
			return getApptStartTime();
		if(fieldName.equals("APPTENDTIME"))
			return getApptEndTime();
		if(fieldName.equals("OUTCOMEREASON"))
			return getOutcomeReason();
		if(fieldName.equals("OUTCOMECOMMENTS"))
			return getOutcomeComments();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAppointmentDateIsNotNull()
	{
		return this.appointmentdate != null;
	}
	public ims.framework.utils.Date getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.appointmentdate = value;
	}
	public boolean getApptStartTimeIsNotNull()
	{
		return this.apptstarttime != null;
	}
	public ims.framework.utils.Time getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptstarttime = value;
	}
	public boolean getApptEndTimeIsNotNull()
	{
		return this.apptendtime != null;
	}
	public ims.framework.utils.Time getApptEndTime()
	{
		return this.apptendtime;
	}
	public void setApptEndTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.apptendtime = value;
	}
	public boolean getOutcomeReasonIsNotNull()
	{
		return this.outcomereason != null;
	}
	public ims.admin.vo.lookups.AppointmentOutcomeReason getOutcomeReason()
	{
		return this.outcomereason;
	}
	public void setOutcomeReason(ims.admin.vo.lookups.AppointmentOutcomeReason value)
	{
		this.isValidated = false;
		this.outcomereason = value;
	}
	public boolean getOutcomeCommentsIsNotNull()
	{
		return this.outcomecomments != null;
	}
	public String getOutcomeComments()
	{
		return this.outcomecomments;
	}
	public static int getOutcomeCommentsMaxLength()
	{
		return 500;
	}
	public void setOutcomeComments(String value)
	{
		this.isValidated = false;
		this.outcomecomments = value;
	}
	public boolean getApptStatusIsNotNull()
	{
		return this.apptstatus != null;
	}
	public ims.scheduling.vo.lookups.Status_Reason getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.scheduling.vo.lookups.Status_Reason value)
	{
		this.isValidated = false;
		this.apptstatus = value;
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
		if(this.outcomecomments != null)
			if(this.outcomecomments.length() > 500)
				listOfErrors.add("The length of the field [outcomecomments] in the value object [ims.RefMan.vo.Booking_AppointmentOutcomeForElectiveListVo] is too big. It should be less or equal to 500");
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
	
		Booking_AppointmentOutcomeForElectiveListVo clone = new Booking_AppointmentOutcomeForElectiveListVo(this.id, this.version);
		
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		if(this.apptstarttime == null)
			clone.apptstarttime = null;
		else
			clone.apptstarttime = (ims.framework.utils.Time)this.apptstarttime.clone();
		if(this.apptendtime == null)
			clone.apptendtime = null;
		else
			clone.apptendtime = (ims.framework.utils.Time)this.apptendtime.clone();
		if(this.outcomereason == null)
			clone.outcomereason = null;
		else
			clone.outcomereason = (ims.admin.vo.lookups.AppointmentOutcomeReason)this.outcomereason.clone();
		clone.outcomecomments = this.outcomecomments;
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
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
		if (!(Booking_AppointmentOutcomeForElectiveListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Booking_AppointmentOutcomeForElectiveListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Booking_AppointmentOutcomeForElectiveListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Booking_AppointmentOutcomeForElectiveListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.appointmentdate != null)
			count++;
		if(this.apptstarttime != null)
			count++;
		if(this.apptendtime != null)
			count++;
		if(this.outcomereason != null)
			count++;
		if(this.outcomecomments != null)
			count++;
		if(this.apptstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.Date appointmentdate;
	protected ims.framework.utils.Time apptstarttime;
	protected ims.framework.utils.Time apptendtime;
	protected ims.admin.vo.lookups.AppointmentOutcomeReason outcomereason;
	protected String outcomecomments;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
