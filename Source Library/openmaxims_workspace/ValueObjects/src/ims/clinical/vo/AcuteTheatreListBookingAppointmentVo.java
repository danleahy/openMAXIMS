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

package ims.clinical.vo;

/**
 * Linked to Scheduling.Booking_Appointment business object (ID: 1055100007).
 */
public class AcuteTheatreListBookingAppointmentVo extends ims.scheduling.vo.Booking_AppointmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AcuteTheatreListBookingAppointmentVo()
	{
	}
	public AcuteTheatreListBookingAppointmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public AcuteTheatreListBookingAppointmentVo(ims.clinical.vo.beans.AcuteTheatreListBookingAppointmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.theatrebooking = bean.getTheatreBooking() == null ? null : bean.getTheatreBooking().buildVo();
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.comments = bean.getComments();
		this.proceduredetails = bean.getProcedureDetails();
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.AcuteTheatreListBookingAppointmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.apptstarttime = bean.getApptStartTime() == null ? null : bean.getApptStartTime().buildTime();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.theatrebooking = bean.getTheatreBooking() == null ? null : bean.getTheatreBooking().buildVo(map);
		this.apptstatus = bean.getApptStatus() == null ? null : ims.scheduling.vo.lookups.Status_Reason.buildLookup(bean.getApptStatus());
		this.appointmentdate = bean.getAppointmentDate() == null ? null : bean.getAppointmentDate().buildDate();
		this.comments = bean.getComments();
		this.proceduredetails = bean.getProcedureDetails();
		this.session = bean.getSession() == null ? null : new ims.scheduling.vo.Sch_SessionRefVo(new Integer(bean.getSession().getId()), bean.getSession().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.AcuteTheatreListBookingAppointmentVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.AcuteTheatreListBookingAppointmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.AcuteTheatreListBookingAppointmentVoBean();
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
		if(fieldName.equals("APPTSTARTTIME"))
			return getApptStartTime();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("THEATREBOOKING"))
			return getTheatreBooking();
		if(fieldName.equals("APPTSTATUS"))
			return getApptStatus();
		if(fieldName.equals("APPOINTMENTDATE"))
			return getAppointmentDate();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("PROCEDUREDETAILS"))
			return getProcedureDetails();
		if(fieldName.equals("SESSION"))
			return getSession();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getTheatreBookingIsNotNull()
	{
		return this.theatrebooking != null;
	}
	public ims.scheduling.vo.TheatreBookingLiteVo getTheatreBooking()
	{
		return this.theatrebooking;
	}
	public void setTheatreBooking(ims.scheduling.vo.TheatreBookingLiteVo value)
	{
		this.isValidated = false;
		this.theatrebooking = value;
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
	public boolean getProcedureDetailsIsNotNull()
	{
		return this.proceduredetails != null;
	}
	public String getProcedureDetails()
	{
		return this.proceduredetails;
	}
	public static int getProcedureDetailsMaxLength()
	{
		return 500;
	}
	public void setProcedureDetails(String value)
	{
		this.isValidated = false;
		this.proceduredetails = value;
	}
	public boolean getSessionIsNotNull()
	{
		return this.session != null;
	}
	public ims.scheduling.vo.Sch_SessionRefVo getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.Sch_SessionRefVo value)
	{
		this.isValidated = false;
		this.session = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.clinical.vo.AcuteTheatreListBookingAppointmentVo] is too big. It should be less or equal to 500");
		if(this.proceduredetails != null)
			if(this.proceduredetails.length() > 500)
				listOfErrors.add("The length of the field [proceduredetails] in the value object [ims.clinical.vo.AcuteTheatreListBookingAppointmentVo] is too big. It should be less or equal to 500");
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
	
		AcuteTheatreListBookingAppointmentVo clone = new AcuteTheatreListBookingAppointmentVo(this.id, this.version);
		
		if(this.apptstarttime == null)
			clone.apptstarttime = null;
		else
			clone.apptstarttime = (ims.framework.utils.Time)this.apptstarttime.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.theatrebooking == null)
			clone.theatrebooking = null;
		else
			clone.theatrebooking = (ims.scheduling.vo.TheatreBookingLiteVo)this.theatrebooking.clone();
		if(this.apptstatus == null)
			clone.apptstatus = null;
		else
			clone.apptstatus = (ims.scheduling.vo.lookups.Status_Reason)this.apptstatus.clone();
		if(this.appointmentdate == null)
			clone.appointmentdate = null;
		else
			clone.appointmentdate = (ims.framework.utils.Date)this.appointmentdate.clone();
		clone.comments = this.comments;
		clone.proceduredetails = this.proceduredetails;
		clone.session = this.session;
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
		if (!(AcuteTheatreListBookingAppointmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AcuteTheatreListBookingAppointmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AcuteTheatreListBookingAppointmentVo compareObj = (AcuteTheatreListBookingAppointmentVo)obj;
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
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.apptstarttime != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.theatrebooking != null)
			count++;
		if(this.apptstatus != null)
			count++;
		if(this.appointmentdate != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.proceduredetails != null)
			count++;
		if(this.session != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.framework.utils.Time apptstarttime;
	protected ims.core.vo.PatientShort patient;
	protected ims.scheduling.vo.TheatreBookingLiteVo theatrebooking;
	protected ims.scheduling.vo.lookups.Status_Reason apptstatus;
	protected ims.framework.utils.Date appointmentdate;
	protected String comments;
	protected String proceduredetails;
	protected ims.scheduling.vo.Sch_SessionRefVo session;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
