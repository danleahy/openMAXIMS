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
 * Linked to Pathways.PatientEvent business object (ID: 1088100002).
 */
public class PatientEventForTransferOfCareVo extends ims.pathways.vo.PatientEventRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientEventForTransferOfCareVo()
	{
	}
	public PatientEventForTransferOfCareVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientEventForTransferOfCareVo(ims.RefMan.vo.beans.PatientEventForTransferOfCareVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.event = bean.getEvent() == null ? null : new ims.pathways.configuration.vo.EventRefVo(new Integer(bean.getEvent().getId()), bean.getEvent().getVersion());
		this.description = bean.getDescription();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.eventstatus = bean.getEventStatus() == null ? null : ims.pathways.vo.lookups.EventStatus.buildLookup(bean.getEventStatus());
		this.messageid = bean.getMessageId();
		this.externaleventid = bean.getExternalEventId();
		this.journey = bean.getJourney() == null ? null : new ims.pathways.vo.PatientPathwayJourneyRefVo(new Integer(bean.getJourney().getId()), bean.getJourney().getVersion());
		this.patienttarget = bean.getPatientTarget() == null ? null : bean.getPatientTarget().buildVo();
		this.externalevent = bean.getExternalEvent() == null ? null : new ims.pathways.configuration.vo.ExternalEventMappingRefVo(new Integer(bean.getExternalEvent().getId()), bean.getExternalEvent().getVersion());
		this.rttexternalevent = bean.getRttExternalEvent() == null ? null : new ims.pathways.configuration.vo.RTTEventRefVo(new Integer(bean.getRttExternalEvent().getId()), bean.getRttExternalEvent().getVersion());
		this.cliniccode = bean.getClinicCode();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PatientEventForTransferOfCareVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.event = bean.getEvent() == null ? null : new ims.pathways.configuration.vo.EventRefVo(new Integer(bean.getEvent().getId()), bean.getEvent().getVersion());
		this.description = bean.getDescription();
		this.eventdatetime = bean.getEventDateTime() == null ? null : bean.getEventDateTime().buildDateTime();
		this.eventstatus = bean.getEventStatus() == null ? null : ims.pathways.vo.lookups.EventStatus.buildLookup(bean.getEventStatus());
		this.messageid = bean.getMessageId();
		this.externaleventid = bean.getExternalEventId();
		this.journey = bean.getJourney() == null ? null : new ims.pathways.vo.PatientPathwayJourneyRefVo(new Integer(bean.getJourney().getId()), bean.getJourney().getVersion());
		this.patienttarget = bean.getPatientTarget() == null ? null : bean.getPatientTarget().buildVo(map);
		this.externalevent = bean.getExternalEvent() == null ? null : new ims.pathways.configuration.vo.ExternalEventMappingRefVo(new Integer(bean.getExternalEvent().getId()), bean.getExternalEvent().getVersion());
		this.rttexternalevent = bean.getRttExternalEvent() == null ? null : new ims.pathways.configuration.vo.RTTEventRefVo(new Integer(bean.getRttExternalEvent().getId()), bean.getRttExternalEvent().getVersion());
		this.cliniccode = bean.getClinicCode();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PatientEventForTransferOfCareVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PatientEventForTransferOfCareVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PatientEventForTransferOfCareVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EVENT"))
			return getEvent();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("EVENTDATETIME"))
			return getEventDateTime();
		if(fieldName.equals("EVENTSTATUS"))
			return getEventStatus();
		if(fieldName.equals("MESSAGEID"))
			return getMessageId();
		if(fieldName.equals("EXTERNALEVENTID"))
			return getExternalEventId();
		if(fieldName.equals("JOURNEY"))
			return getJourney();
		if(fieldName.equals("PATIENTTARGET"))
			return getPatientTarget();
		if(fieldName.equals("EXTERNALEVENT"))
			return getExternalEvent();
		if(fieldName.equals("RTTEXTERNALEVENT"))
			return getRttExternalEvent();
		if(fieldName.equals("CLINICCODE"))
			return getClinicCode();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("SCHEDULEDDATE"))
			return getScheduledDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getEventIsNotNull()
	{
		return this.event != null;
	}
	public ims.pathways.configuration.vo.EventRefVo getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.configuration.vo.EventRefVo value)
	{
		this.isValidated = false;
		this.event = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 2000;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getEventDateTimeIsNotNull()
	{
		return this.eventdatetime != null;
	}
	public ims.framework.utils.DateTime getEventDateTime()
	{
		return this.eventdatetime;
	}
	public void setEventDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.eventdatetime = value;
	}
	public boolean getEventStatusIsNotNull()
	{
		return this.eventstatus != null;
	}
	public ims.pathways.vo.lookups.EventStatus getEventStatus()
	{
		return this.eventstatus;
	}
	public void setEventStatus(ims.pathways.vo.lookups.EventStatus value)
	{
		this.isValidated = false;
		this.eventstatus = value;
	}
	public boolean getMessageIdIsNotNull()
	{
		return this.messageid != null;
	}
	public String getMessageId()
	{
		return this.messageid;
	}
	public static int getMessageIdMaxLength()
	{
		return 255;
	}
	public void setMessageId(String value)
	{
		this.isValidated = false;
		this.messageid = value;
	}
	public boolean getExternalEventIdIsNotNull()
	{
		return this.externaleventid != null;
	}
	public Integer getExternalEventId()
	{
		return this.externaleventid;
	}
	public void setExternalEventId(Integer value)
	{
		this.isValidated = false;
		this.externaleventid = value;
	}
	public boolean getJourneyIsNotNull()
	{
		return this.journey != null;
	}
	public ims.pathways.vo.PatientPathwayJourneyRefVo getJourney()
	{
		return this.journey;
	}
	public void setJourney(ims.pathways.vo.PatientPathwayJourneyRefVo value)
	{
		this.isValidated = false;
		this.journey = value;
	}
	public boolean getPatientTargetIsNotNull()
	{
		return this.patienttarget != null;
	}
	public ims.RefMan.vo.PatientJournayTargetForTransferOfCareVo getPatientTarget()
	{
		return this.patienttarget;
	}
	public void setPatientTarget(ims.RefMan.vo.PatientJournayTargetForTransferOfCareVo value)
	{
		this.isValidated = false;
		this.patienttarget = value;
	}
	public boolean getExternalEventIsNotNull()
	{
		return this.externalevent != null;
	}
	public ims.pathways.configuration.vo.ExternalEventMappingRefVo getExternalEvent()
	{
		return this.externalevent;
	}
	public void setExternalEvent(ims.pathways.configuration.vo.ExternalEventMappingRefVo value)
	{
		this.isValidated = false;
		this.externalevent = value;
	}
	public boolean getRttExternalEventIsNotNull()
	{
		return this.rttexternalevent != null;
	}
	public ims.pathways.configuration.vo.RTTEventRefVo getRttExternalEvent()
	{
		return this.rttexternalevent;
	}
	public void setRttExternalEvent(ims.pathways.configuration.vo.RTTEventRefVo value)
	{
		this.isValidated = false;
		this.rttexternalevent = value;
	}
	public boolean getClinicCodeIsNotNull()
	{
		return this.cliniccode != null;
	}
	public String getClinicCode()
	{
		return this.cliniccode;
	}
	public static int getClinicCodeMaxLength()
	{
		return 255;
	}
	public void setClinicCode(String value)
	{
		this.isValidated = false;
		this.cliniccode = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getScheduledDateIsNotNull()
	{
		return this.scheduleddate != null;
	}
	public ims.framework.utils.DateTime getScheduledDate()
	{
		return this.scheduleddate;
	}
	public void setScheduledDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.scheduleddate = value;
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
		if(this.patienttarget != null)
		{
			if(!this.patienttarget.isValidated())
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
		if(this.event == null)
			listOfErrors.add("Event is mandatory");
		if(this.description != null)
			if(this.description.length() > 2000)
				listOfErrors.add("The length of the field [description] in the value object [ims.RefMan.vo.PatientEventForTransferOfCareVo] is too big. It should be less or equal to 2000");
		if(this.patienttarget != null)
		{
			String[] listOfOtherErrors = this.patienttarget.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		PatientEventForTransferOfCareVo clone = new PatientEventForTransferOfCareVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.event = this.event;
		clone.description = this.description;
		if(this.eventdatetime == null)
			clone.eventdatetime = null;
		else
			clone.eventdatetime = (ims.framework.utils.DateTime)this.eventdatetime.clone();
		if(this.eventstatus == null)
			clone.eventstatus = null;
		else
			clone.eventstatus = (ims.pathways.vo.lookups.EventStatus)this.eventstatus.clone();
		clone.messageid = this.messageid;
		clone.externaleventid = this.externaleventid;
		clone.journey = this.journey;
		if(this.patienttarget == null)
			clone.patienttarget = null;
		else
			clone.patienttarget = (ims.RefMan.vo.PatientJournayTargetForTransferOfCareVo)this.patienttarget.clone();
		clone.externalevent = this.externalevent;
		clone.rttexternalevent = this.rttexternalevent;
		clone.cliniccode = this.cliniccode;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		clone.consultant = this.consultant;
		if(this.scheduleddate == null)
			clone.scheduleddate = null;
		else
			clone.scheduleddate = (ims.framework.utils.DateTime)this.scheduleddate.clone();
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
		if (!(PatientEventForTransferOfCareVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientEventForTransferOfCareVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientEventForTransferOfCareVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientEventForTransferOfCareVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.event != null)
			count++;
		if(this.description != null)
			count++;
		if(this.eventdatetime != null)
			count++;
		if(this.eventstatus != null)
			count++;
		if(this.messageid != null)
			count++;
		if(this.externaleventid != null)
			count++;
		if(this.journey != null)
			count++;
		if(this.patienttarget != null)
			count++;
		if(this.externalevent != null)
			count++;
		if(this.rttexternalevent != null)
			count++;
		if(this.cliniccode != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.scheduleddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.pathways.configuration.vo.EventRefVo event;
	protected String description;
	protected ims.framework.utils.DateTime eventdatetime;
	protected ims.pathways.vo.lookups.EventStatus eventstatus;
	protected String messageid;
	protected Integer externaleventid;
	protected ims.pathways.vo.PatientPathwayJourneyRefVo journey;
	protected ims.RefMan.vo.PatientJournayTargetForTransferOfCareVo patienttarget;
	protected ims.pathways.configuration.vo.ExternalEventMappingRefVo externalevent;
	protected ims.pathways.configuration.vo.RTTEventRefVo rttexternalevent;
	protected String cliniccode;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.resource.people.vo.HcpRefVo consultant;
	protected ims.framework.utils.DateTime scheduleddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
