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
 * Linked to emergency.EDTransfer business object (ID: 1086100042).
 */
public class EDTransferVo extends ims.emergency.vo.EDTransferRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EDTransferVo()
	{
	}
	public EDTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public EDTransferVo(ims.emergency.vo.beans.EDTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referreddatetime = bean.getReferredDateTime() == null ? null : bean.getReferredDateTime().buildDateTime();
		this.accepteddatetime = bean.getAcceptedDateTime() == null ? null : bean.getAcceptedDateTime().buildDateTime();
		this.tohospital = bean.getToHospital() == null ? null : ims.emergency.vo.lookups.TransferToHospital.buildLookup(bean.getToHospital());
		this.otherhospital = bean.getOtherHospital();
		this.transfermode = bean.getTransferMode() == null ? null : ims.emergency.vo.lookups.ModeOfArrival.buildLookup(bean.getTransferMode());
		this.transferescort = bean.getTransferEscort() == null ? null : ims.emergency.vo.lookups.TransferEscort.buildLookup(bean.getTransferEscort());
		this.comment = bean.getComment();
		this.referredby = bean.getReferredBy() == null ? null : bean.getReferredBy().buildVo();
		this.notaccepted = bean.getNotAccepted();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EDTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referreddatetime = bean.getReferredDateTime() == null ? null : bean.getReferredDateTime().buildDateTime();
		this.accepteddatetime = bean.getAcceptedDateTime() == null ? null : bean.getAcceptedDateTime().buildDateTime();
		this.tohospital = bean.getToHospital() == null ? null : ims.emergency.vo.lookups.TransferToHospital.buildLookup(bean.getToHospital());
		this.otherhospital = bean.getOtherHospital();
		this.transfermode = bean.getTransferMode() == null ? null : ims.emergency.vo.lookups.ModeOfArrival.buildLookup(bean.getTransferMode());
		this.transferescort = bean.getTransferEscort() == null ? null : ims.emergency.vo.lookups.TransferEscort.buildLookup(bean.getTransferEscort());
		this.comment = bean.getComment();
		this.referredby = bean.getReferredBy() == null ? null : bean.getReferredBy().buildVo(map);
		this.notaccepted = bean.getNotAccepted();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EDTransferVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EDTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EDTransferVoBean();
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
		if(fieldName.equals("REFERREDDATETIME"))
			return getReferredDateTime();
		if(fieldName.equals("ACCEPTEDDATETIME"))
			return getAcceptedDateTime();
		if(fieldName.equals("TOHOSPITAL"))
			return getToHospital();
		if(fieldName.equals("OTHERHOSPITAL"))
			return getOtherHospital();
		if(fieldName.equals("TRANSFERMODE"))
			return getTransferMode();
		if(fieldName.equals("TRANSFERESCORT"))
			return getTransferEscort();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("REFERREDBY"))
			return getReferredBy();
		if(fieldName.equals("NOTACCEPTED"))
			return getNotAccepted();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferredDateTimeIsNotNull()
	{
		return this.referreddatetime != null;
	}
	public ims.framework.utils.DateTime getReferredDateTime()
	{
		return this.referreddatetime;
	}
	public void setReferredDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.referreddatetime = value;
	}
	public boolean getAcceptedDateTimeIsNotNull()
	{
		return this.accepteddatetime != null;
	}
	public ims.framework.utils.DateTime getAcceptedDateTime()
	{
		return this.accepteddatetime;
	}
	public void setAcceptedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.accepteddatetime = value;
	}
	public boolean getToHospitalIsNotNull()
	{
		return this.tohospital != null;
	}
	public ims.emergency.vo.lookups.TransferToHospital getToHospital()
	{
		return this.tohospital;
	}
	public void setToHospital(ims.emergency.vo.lookups.TransferToHospital value)
	{
		this.isValidated = false;
		this.tohospital = value;
	}
	public boolean getOtherHospitalIsNotNull()
	{
		return this.otherhospital != null;
	}
	public String getOtherHospital()
	{
		return this.otherhospital;
	}
	public static int getOtherHospitalMaxLength()
	{
		return 100;
	}
	public void setOtherHospital(String value)
	{
		this.isValidated = false;
		this.otherhospital = value;
	}
	public boolean getTransferModeIsNotNull()
	{
		return this.transfermode != null;
	}
	public ims.emergency.vo.lookups.ModeOfArrival getTransferMode()
	{
		return this.transfermode;
	}
	public void setTransferMode(ims.emergency.vo.lookups.ModeOfArrival value)
	{
		this.isValidated = false;
		this.transfermode = value;
	}
	public boolean getTransferEscortIsNotNull()
	{
		return this.transferescort != null;
	}
	public ims.emergency.vo.lookups.TransferEscort getTransferEscort()
	{
		return this.transferescort;
	}
	public void setTransferEscort(ims.emergency.vo.lookups.TransferEscort value)
	{
		this.isValidated = false;
		this.transferescort = value;
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
	public boolean getReferredByIsNotNull()
	{
		return this.referredby != null;
	}
	public ims.core.vo.HcpLiteVo getReferredBy()
	{
		return this.referredby;
	}
	public void setReferredBy(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.referredby = value;
	}
	public boolean getNotAcceptedIsNotNull()
	{
		return this.notaccepted != null;
	}
	public Boolean getNotAccepted()
	{
		return this.notaccepted;
	}
	public void setNotAccepted(Boolean value)
	{
		this.isValidated = false;
		this.notaccepted = value;
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
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
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
		if(this.referredby != null)
		{
			if(!this.referredby.isValidated())
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
		if(this.referreddatetime == null)
			listOfErrors.add("ReferredDateTime is mandatory");
		if(this.tohospital == null)
			listOfErrors.add("ToHospital is mandatory");
		if(this.otherhospital != null)
			if(this.otherhospital.length() > 100)
				listOfErrors.add("The length of the field [otherhospital] in the value object [ims.emergency.vo.EDTransferVo] is too big. It should be less or equal to 100");
		if(this.comment != null)
			if(this.comment.length() > 255)
				listOfErrors.add("The length of the field [comment] in the value object [ims.emergency.vo.EDTransferVo] is too big. It should be less or equal to 255");
		if(this.referredby == null)
			listOfErrors.add("ReferredBy is mandatory");
		if(this.referredby != null)
		{
			String[] listOfOtherErrors = this.referredby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
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
	
		EDTransferVo clone = new EDTransferVo(this.id, this.version);
		
		if(this.referreddatetime == null)
			clone.referreddatetime = null;
		else
			clone.referreddatetime = (ims.framework.utils.DateTime)this.referreddatetime.clone();
		if(this.accepteddatetime == null)
			clone.accepteddatetime = null;
		else
			clone.accepteddatetime = (ims.framework.utils.DateTime)this.accepteddatetime.clone();
		if(this.tohospital == null)
			clone.tohospital = null;
		else
			clone.tohospital = (ims.emergency.vo.lookups.TransferToHospital)this.tohospital.clone();
		clone.otherhospital = this.otherhospital;
		if(this.transfermode == null)
			clone.transfermode = null;
		else
			clone.transfermode = (ims.emergency.vo.lookups.ModeOfArrival)this.transfermode.clone();
		if(this.transferescort == null)
			clone.transferescort = null;
		else
			clone.transferescort = (ims.emergency.vo.lookups.TransferEscort)this.transferescort.clone();
		clone.comment = this.comment;
		if(this.referredby == null)
			clone.referredby = null;
		else
			clone.referredby = (ims.core.vo.HcpLiteVo)this.referredby.clone();
		clone.notaccepted = this.notaccepted;
		clone.patient = this.patient;
		clone.episode = this.episode;
		clone.attendance = this.attendance;
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
		if (!(EDTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EDTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EDTransferVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EDTransferVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.referreddatetime != null)
			count++;
		if(this.accepteddatetime != null)
			count++;
		if(this.tohospital != null)
			count++;
		if(this.otherhospital != null)
			count++;
		if(this.transfermode != null)
			count++;
		if(this.transferescort != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.referredby != null)
			count++;
		if(this.notaccepted != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.attendance != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected ims.framework.utils.DateTime referreddatetime;
	protected ims.framework.utils.DateTime accepteddatetime;
	protected ims.emergency.vo.lookups.TransferToHospital tohospital;
	protected String otherhospital;
	protected ims.emergency.vo.lookups.ModeOfArrival transfermode;
	protected ims.emergency.vo.lookups.TransferEscort transferescort;
	protected String comment;
	protected ims.core.vo.HcpLiteVo referredby;
	protected Boolean notaccepted;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
