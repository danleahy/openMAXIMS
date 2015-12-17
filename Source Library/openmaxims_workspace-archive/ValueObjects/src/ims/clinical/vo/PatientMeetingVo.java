//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo;

/**
 * Linked to clinical.PatientMeeting business object (ID: 1072100058).
 */
public class PatientMeetingVo extends ims.clinical.vo.PatientMeetingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientMeetingVo()
	{
	}
	public PatientMeetingVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientMeetingVo(ims.clinical.vo.beans.PatientMeetingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.meetingdatetime = bean.getMeetingDateTime() == null ? null : bean.getMeetingDateTime().buildDateTime();
		this.nextmeetingdate = bean.getNextMeetingDate() == null ? null : bean.getNextMeetingDate().buildDateTime();
		this.status = bean.getStatus() == null ? null : ims.clinical.vo.lookups.MeetingStatus.buildLookup(bean.getStatus());
		this.meetingnotes = bean.getMeetingNotes();
		this.attendees = ims.clinical.vo.PatientMeetingInviteeVoCollection.buildFromBeanCollection(bean.getAttendees());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientMeetingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.meetingdatetime = bean.getMeetingDateTime() == null ? null : bean.getMeetingDateTime().buildDateTime();
		this.nextmeetingdate = bean.getNextMeetingDate() == null ? null : bean.getNextMeetingDate().buildDateTime();
		this.status = bean.getStatus() == null ? null : ims.clinical.vo.lookups.MeetingStatus.buildLookup(bean.getStatus());
		this.meetingnotes = bean.getMeetingNotes();
		this.attendees = ims.clinical.vo.PatientMeetingInviteeVoCollection.buildFromBeanCollection(bean.getAttendees());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientMeetingVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientMeetingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientMeetingVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("MEETINGDATETIME"))
			return getMeetingDateTime();
		if(fieldName.equals("NEXTMEETINGDATE"))
			return getNextMeetingDate();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("MEETINGNOTES"))
			return getMeetingNotes();
		if(fieldName.equals("ATTENDEES"))
			return getAttendees();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getMeetingDateTimeIsNotNull()
	{
		return this.meetingdatetime != null;
	}
	public ims.framework.utils.DateTime getMeetingDateTime()
	{
		return this.meetingdatetime;
	}
	public void setMeetingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.meetingdatetime = value;
	}
	public boolean getNextMeetingDateIsNotNull()
	{
		return this.nextmeetingdate != null;
	}
	public ims.framework.utils.DateTime getNextMeetingDate()
	{
		return this.nextmeetingdate;
	}
	public void setNextMeetingDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.nextmeetingdate = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.clinical.vo.lookups.MeetingStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.clinical.vo.lookups.MeetingStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getMeetingNotesIsNotNull()
	{
		return this.meetingnotes != null;
	}
	public String getMeetingNotes()
	{
		return this.meetingnotes;
	}
	public static int getMeetingNotesMaxLength()
	{
		return 1500;
	}
	public void setMeetingNotes(String value)
	{
		this.isValidated = false;
		this.meetingnotes = value;
	}
	public boolean getAttendeesIsNotNull()
	{
		return this.attendees != null;
	}
	public ims.clinical.vo.PatientMeetingInviteeVoCollection getAttendees()
	{
		return this.attendees;
	}
	public void setAttendees(ims.clinical.vo.PatientMeetingInviteeVoCollection value)
	{
		this.isValidated = false;
		this.attendees = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.attendees != null)
		{
			if(!this.attendees.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.meetingnotes != null)
			if(this.meetingnotes.length() > 1500)
				listOfErrors.add("The length of the field [meetingnotes] in the value object [ims.clinical.vo.PatientMeetingVo] is too big. It should be less or equal to 1500");
		if(this.attendees != null)
		{
			String[] listOfOtherErrors = this.attendees.validate();
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
	
		PatientMeetingVo clone = new PatientMeetingVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		clone.clinicalcontact = this.clinicalcontact;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.meetingdatetime == null)
			clone.meetingdatetime = null;
		else
			clone.meetingdatetime = (ims.framework.utils.DateTime)this.meetingdatetime.clone();
		if(this.nextmeetingdate == null)
			clone.nextmeetingdate = null;
		else
			clone.nextmeetingdate = (ims.framework.utils.DateTime)this.nextmeetingdate.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.clinical.vo.lookups.MeetingStatus)this.status.clone();
		clone.meetingnotes = this.meetingnotes;
		if(this.attendees == null)
			clone.attendees = null;
		else
			clone.attendees = (ims.clinical.vo.PatientMeetingInviteeVoCollection)this.attendees.clone();
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
		if (!(PatientMeetingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientMeetingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientMeetingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientMeetingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.meetingdatetime != null)
			count++;
		if(this.nextmeetingdate != null)
			count++;
		if(this.status != null)
			count++;
		if(this.meetingnotes != null)
			count++;
		if(this.attendees != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.framework.utils.DateTime meetingdatetime;
	protected ims.framework.utils.DateTime nextmeetingdate;
	protected ims.clinical.vo.lookups.MeetingStatus status;
	protected String meetingnotes;
	protected ims.clinical.vo.PatientMeetingInviteeVoCollection attendees;
	private boolean isValidated = false;
	private boolean isBusy = false;
}