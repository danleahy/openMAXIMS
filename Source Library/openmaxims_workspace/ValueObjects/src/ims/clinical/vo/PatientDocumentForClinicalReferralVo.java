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
 * Linked to core.Documents.PatientDocument business object (ID: 1068100001).
 */
public class PatientDocumentForClinicalReferralVo extends ims.core.documents.vo.PatientDocumentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDocumentForClinicalReferralVo()
	{
	}
	public PatientDocumentForClinicalReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDocumentForClinicalReferralVo(ims.clinical.vo.beans.PatientDocumentForClinicalReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.name = bean.getName();
		this.serverdocument = bean.getServerDocument() == null ? null : bean.getServerDocument().buildVo();
		this.creationtype = bean.getCreationType() == null ? null : ims.core.vo.lookups.DocumentCreationType.buildLookup(bean.getCreationType());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getCategory());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.recordinguser = bean.getRecordingUser() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getRecordingUser().getId()), bean.getRecordingUser().getVersion());
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
		this.documentdate = bean.getDocumentDate() == null ? null : bean.getDocumentDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientDocumentForClinicalReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.name = bean.getName();
		this.serverdocument = bean.getServerDocument() == null ? null : bean.getServerDocument().buildVo(map);
		this.creationtype = bean.getCreationType() == null ? null : ims.core.vo.lookups.DocumentCreationType.buildLookup(bean.getCreationType());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getCategory());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.recordinguser = bean.getRecordingUser() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getRecordingUser().getId()), bean.getRecordingUser().getVersion());
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
		this.documentdate = bean.getDocumentDate() == null ? null : bean.getDocumentDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientDocumentForClinicalReferralVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientDocumentForClinicalReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientDocumentForClinicalReferralVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("SERVERDOCUMENT"))
			return getServerDocument();
		if(fieldName.equals("CREATIONTYPE"))
			return getCreationType();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("RECORDINGUSER"))
			return getRecordingUser();
		if(fieldName.equals("RECORDINGDATETIME"))
			return getRecordingDateTime();
		if(fieldName.equals("DOCUMENTDATE"))
			return getDocumentDate();
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
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getServerDocumentIsNotNull()
	{
		return this.serverdocument != null;
	}
	public ims.core.vo.ServerDocumentVo getServerDocument()
	{
		return this.serverdocument;
	}
	public void setServerDocument(ims.core.vo.ServerDocumentVo value)
	{
		this.isValidated = false;
		this.serverdocument = value;
	}
	public boolean getCreationTypeIsNotNull()
	{
		return this.creationtype != null;
	}
	public ims.core.vo.lookups.DocumentCreationType getCreationType()
	{
		return this.creationtype;
	}
	public void setCreationType(ims.core.vo.lookups.DocumentCreationType value)
	{
		this.isValidated = false;
		this.creationtype = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.DocumentCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.DocumentCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getRecordingUserIsNotNull()
	{
		return this.recordinguser != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getRecordingUser()
	{
		return this.recordinguser;
	}
	public void setRecordingUser(ims.core.resource.people.vo.MemberOfStaffRefVo value)
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
	public boolean getDocumentDateIsNotNull()
	{
		return this.documentdate != null;
	}
	public ims.framework.utils.Date getDocumentDate()
	{
		return this.documentdate;
	}
	public void setDocumentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.documentdate = value;
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
		if(this.serverdocument != null)
		{
			if(!this.serverdocument.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.clinical.vo.PatientDocumentForClinicalReferralVo] is too big. It should be less or equal to 100");
		if(this.serverdocument == null)
			listOfErrors.add("ServerDocument is mandatory");
		if(this.serverdocument != null)
		{
			String[] listOfOtherErrors = this.serverdocument.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		PatientDocumentForClinicalReferralVo clone = new PatientDocumentForClinicalReferralVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.name = this.name;
		if(this.serverdocument == null)
			clone.serverdocument = null;
		else
			clone.serverdocument = (ims.core.vo.ServerDocumentVo)this.serverdocument.clone();
		if(this.creationtype == null)
			clone.creationtype = null;
		else
			clone.creationtype = (ims.core.vo.lookups.DocumentCreationType)this.creationtype.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.DocumentCategory)this.category.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.recordinguser = this.recordinguser;
		if(this.recordingdatetime == null)
			clone.recordingdatetime = null;
		else
			clone.recordingdatetime = (ims.framework.utils.DateTime)this.recordingdatetime.clone();
		if(this.documentdate == null)
			clone.documentdate = null;
		else
			clone.documentdate = (ims.framework.utils.Date)this.documentdate.clone();
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
		if (!(PatientDocumentForClinicalReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDocumentForClinicalReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDocumentForClinicalReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDocumentForClinicalReferralVo)obj).getBoId());
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
		if(this.name != null)
			count++;
		if(this.serverdocument != null)
			count++;
		if(this.creationtype != null)
			count++;
		if(this.category != null)
			count++;
		if(this.status != null)
			count++;
		if(this.recordinguser != null)
			count++;
		if(this.recordingdatetime != null)
			count++;
		if(this.documentdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected String name;
	protected ims.core.vo.ServerDocumentVo serverdocument;
	protected ims.core.vo.lookups.DocumentCreationType creationtype;
	protected ims.core.vo.lookups.DocumentCategory category;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo recordinguser;
	protected ims.framework.utils.DateTime recordingdatetime;
	protected ims.framework.utils.Date documentdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
