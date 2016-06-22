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
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class BookingAppointmentLiteVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IApptDuration
{
	private static final long serialVersionUID = 1L;

	public BookingAppointmentLiteVo()
	{
	}
	public BookingAppointmentLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public BookingAppointmentLiteVo(ims.scheduling.vo.beans.BookingAppointmentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.comments = bean.getComments();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.dummycolour = bean.getDummyColour() == null ? null : bean.getDummyColour().buildColor();
		this.durationhelper = bean.getDurationHelper() == null ? null : bean.getDurationHelper().buildVo();
		this.iswardattendance = bean.getIsWardAttendance();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.BookingAppointmentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.session = bean.getSession() == null ? null : bean.getSession().buildVo(map);
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.apptendtime = bean.getApptEndTime() == null ? null : bean.getApptEndTime().buildTime();
		this.comments = bean.getComments();
		this.activity = bean.getActivity() == null ? null : bean.getActivity().buildVo(map);
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.dummycolour = bean.getDummyColour() == null ? null : bean.getDummyColour().buildColor();
		this.durationhelper = bean.getDurationHelper() == null ? null : bean.getDurationHelper().buildVo(map);
		this.iswardattendance = bean.getIsWardAttendance();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.BookingAppointmentLiteVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.BookingAppointmentLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.BookingAppointmentLiteVoBean();
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
		if(fieldName.equals("SESSION"))
			return getSession();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("APPTENDTIME"))
			return getApptEndTime();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("ACTIVITY"))
			return getActivity();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("DUMMYCOLOUR"))
			return getDummyColour();
		if(fieldName.equals("DURATIONHELPER"))
			return getDurationHelper();
		if(fieldName.equals("ISWARDATTENDANCE"))
			return getIsWardAttendance();
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
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.SessionLiteVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.SessionLiteVo value)
	{
		this.isValidated = false;
		this.session = value;
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
		return 500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getActivityIsNotNull()
	{
		return this.activity != null;
	}
	public ims.core.vo.ActivityLiteVo getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.ActivityLiteVo value)
	{
		this.isValidated = false;
		this.activity = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getDummyColourIsNotNull()
	{
		return this.dummycolour != null;
	}
	public ims.framework.utils.Color getDummyColour()
	{
		return this.dummycolour;
	}
	public void setDummyColour(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.dummycolour = value;
	}
	public boolean getDurationHelperIsNotNull()
	{
		return this.durationhelper != null;
	}
	public ims.scheduling.vo.AvailableDurationVo getDurationHelper()
	{
		return this.durationhelper;
	}
	public void setDurationHelper(ims.scheduling.vo.AvailableDurationVo value)
	{
		this.isValidated = false;
		this.durationhelper = value;
	}
	public boolean getIsWardAttendanceIsNotNull()
	{
		return this.iswardattendance != null;
	}
	public Boolean getIsWardAttendance()
	{
		return this.iswardattendance;
	}
	public void setIsWardAttendance(Boolean value)
	{
		this.isValidated = false;
		this.iswardattendance = value;
	}
	/**
	* toString
	*/
		public String toString()
		{
			StringBuffer text = new StringBuffer();
			if(appointmentdate != null)
				text.append(appointmentdate.toString());
			if(apptstarttime != null)
				text.append(" " + apptstarttime.toString());
			
			SessionLiteVo voSession = this.getSession();
			if(voSession != null)
			{
				text.append(" - " + voSession.getName());
				if(voSession.getSchLocationIsNotNull())
					text.append(" - " + voSession.getSchLocation().getName());
			}
			return text.toString();
		}
	/**
	* IApptDuration interface methods
	*/
	public ims.framework.utils.Date getIApptDurationDate()
	{
		return this.appointmentdate;
	}
	public ims.framework.utils.Color getIApptDurationDummyColour()
	{
		return this.dummycolour;
	}
	public ims.framework.utils.Time getIApptDurationEndTime()
	{
		return this.apptendtime;
	}
	public ims.framework.utils.Time getIApptDurationStartTime()
	{
		return this.apptstarttime;
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
		if(this.session != null)
		{
			if(!this.session.isValidated())
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
		if(this.session != null)
		{
			String[] listOfOtherErrors = this.session.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments != null)
			if(this.comments.length() > 500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.scheduling.vo.BookingAppointmentLiteVo] is too big. It should be less or equal to 500");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
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
	
		BookingAppointmentLiteVo clone = new BookingAppointmentLiteVo(this.id, this.version);
		
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		if(this.apptstarttime == null)
			clone.apptstarttime = null;
		else
			clone.apptstarttime = (ims.framework.utils.Time)this.apptstarttime.clone();
		if(this.session == null)
			clone.session = null;
		else
			clone.session = (ims.scheduling.vo.SessionLiteVo)this.session.clone();
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		if(this.apptendtime == null)
			clone.apptendtime = null;
		else
			clone.apptendtime = (ims.framework.utils.Time)this.apptendtime.clone();
		clone.comments = this.comments;
		if(this.activity == null)
			clone.activity = null;
		else
			clone.activity = (ims.core.vo.ActivityLiteVo)this.activity.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientListVo)this.patient.clone();
		if(this.dummycolour == null)
			clone.dummycolour = null;
		else
			clone.dummycolour = (ims.framework.utils.Color)this.dummycolour.clone();
		if(this.durationhelper == null)
			clone.durationhelper = null;
		else
			clone.durationhelper = (ims.scheduling.vo.AvailableDurationVo)this.durationhelper.clone();
		clone.iswardattendance = this.iswardattendance;
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
		if (!(BookingAppointmentLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BookingAppointmentLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		BookingAppointmentLiteVo compareObj = (BookingAppointmentLiteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getApptStartTime() == null && compareObj.getApptStartTime() != null)
				return -1;
			if(this.getApptStartTime() != null && compareObj.getApptStartTime() == null)
				return 1;
			if(this.getApptStartTime() != null && compareObj.getApptStartTime() != null)
				retVal = this.getApptStartTime().compareTo(compareObj.getApptStartTime());
		}
		if (retVal == 0)
		{
			if(this.getApptEndTime() == null && compareObj.getApptEndTime() != null)
				return -1;
			if(this.getApptEndTime() != null && compareObj.getApptEndTime() == null)
				return 1;
			if(this.getApptEndTime() != null && compareObj.getApptEndTime() != null)
				retVal = this.getApptEndTime().compareTo(compareObj.getApptEndTime());
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
		if(this.appointmentdate != null)
			count++;
		if(this.apptstarttime != null)
			count++;
		if(this.session != null)
			count++;
		if(this.apptstatus != null)
			count++;
		if(this.apptendtime != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.activity != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.dummycolour != null)
			count++;
		if(this.durationhelper != null)
			count++;
		if(this.iswardattendance != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.framework.utils.Date appointmentdate;
	protected ims.framework.utils.Time apptstarttime;
	protected ims.scheduling.vo.SessionLiteVo session;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected ims.framework.utils.Time apptendtime;
	protected String comments;
	protected ims.core.vo.ActivityLiteVo activity;
	protected ims.core.vo.PatientListVo patient;
	protected ims.framework.utils.Color dummycolour;
	protected ims.scheduling.vo.AvailableDurationVo durationhelper;
	protected Boolean iswardattendance;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
