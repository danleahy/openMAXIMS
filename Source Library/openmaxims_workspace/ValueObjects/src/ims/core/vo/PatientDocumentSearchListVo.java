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
 * Linked to core.Documents.PatientDocument business object (ID: 1068100001).
 */
public class PatientDocumentSearchListVo extends ims.core.documents.vo.PatientDocumentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDocumentSearchListVo()
	{
	}
	public PatientDocumentSearchListVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDocumentSearchListVo(ims.core.vo.beans.PatientDocumentSearchListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationtype = bean.getCreationType() == null ? null : ims.core.vo.lookups.DocumentCreationType.buildLookup(bean.getCreationType());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getCategory());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
		this.documentdate = bean.getDocumentDate() == null ? null : bean.getDocumentDate().buildDate();
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
		this.currentdocumentstatus = bean.getCurrentDocumentStatus() == null ? null : bean.getCurrentDocumentStatus().buildVo();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
		this.correspondencestatus = bean.getCorrespondenceStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getCorrespondenceStatus());
		this.name = bean.getName();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientDocumentSearchListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.creationtype = bean.getCreationType() == null ? null : ims.core.vo.lookups.DocumentCreationType.buildLookup(bean.getCreationType());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.DocumentCategory.buildLookup(bean.getCategory());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
		this.documentdate = bean.getDocumentDate() == null ? null : bean.getDocumentDate().buildDate();
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
		this.currentdocumentstatus = bean.getCurrentDocumentStatus() == null ? null : bean.getCurrentDocumentStatus().buildVo(map);
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
		this.correspondencestatus = bean.getCorrespondenceStatus() == null ? null : ims.core.vo.lookups.DocumentStatus.buildLookup(bean.getCorrespondenceStatus());
		this.name = bean.getName();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientDocumentSearchListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientDocumentSearchListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientDocumentSearchListVoBean();
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
		if(fieldName.equals("CREATIONTYPE"))
			return getCreationType();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		if(fieldName.equals("DOCUMENTDATE"))
			return getDocumentDate();
		if(fieldName.equals("RECORDINGDATETIME"))
			return getRecordingDateTime();
		if(fieldName.equals("CURRENTDOCUMENTSTATUS"))
			return getCurrentDocumentStatus();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		if(fieldName.equals("CORRESPONDENCESTATUS"))
			return getCorrespondenceStatus();
		if(fieldName.equals("NAME"))
			return getName();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.HcpLiteVo getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
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
	public boolean getCurrentDocumentStatusIsNotNull()
	{
		return this.currentdocumentstatus != null;
	}
	public ims.core.vo.PatientDocumentStatusVo getCurrentDocumentStatus()
	{
		return this.currentdocumentstatus;
	}
	public void setCurrentDocumentStatus(ims.core.vo.PatientDocumentStatusVo value)
	{
		this.isValidated = false;
		this.currentdocumentstatus = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getCorrespondenceStatusIsNotNull()
	{
		return this.correspondencestatus != null;
	}
	public ims.core.vo.lookups.DocumentStatus getCorrespondenceStatus()
	{
		return this.correspondencestatus;
	}
	public void setCorrespondenceStatus(ims.core.vo.lookups.DocumentStatus value)
	{
		this.isValidated = false;
		this.correspondencestatus = value;
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
		if(this.category == null)
			listOfErrors.add("Category is mandatory");
		if(this.recordingdatetime == null)
			listOfErrors.add("RecordingDateTime is mandatory");
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.PatientDocumentSearchListVo] is too big. It should be less or equal to 100");
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
	
		PatientDocumentSearchListVo clone = new PatientDocumentSearchListVo(this.id, this.version);
		
		if(this.creationtype == null)
			clone.creationtype = null;
		else
			clone.creationtype = (ims.core.vo.lookups.DocumentCreationType)this.creationtype.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.DocumentCategory)this.category.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.HcpLiteVo)this.authoringhcp.clone();
		if(this.documentdate == null)
			clone.documentdate = null;
		else
			clone.documentdate = (ims.framework.utils.Date)this.documentdate.clone();
		if(this.recordingdatetime == null)
			clone.recordingdatetime = null;
		else
			clone.recordingdatetime = (ims.framework.utils.DateTime)this.recordingdatetime.clone();
		if(this.currentdocumentstatus == null)
			clone.currentdocumentstatus = null;
		else
			clone.currentdocumentstatus = (ims.core.vo.PatientDocumentStatusVo)this.currentdocumentstatus.clone();
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		if(this.correspondencestatus == null)
			clone.correspondencestatus = null;
		else
			clone.correspondencestatus = (ims.core.vo.lookups.DocumentStatus)this.correspondencestatus.clone();
		clone.name = this.name;
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
		if (!(PatientDocumentSearchListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDocumentSearchListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDocumentSearchListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDocumentSearchListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.creationtype != null)
			count++;
		if(this.category != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		if(this.documentdate != null)
			count++;
		if(this.recordingdatetime != null)
			count++;
		if(this.currentdocumentstatus != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.correspondencestatus != null)
			count++;
		if(this.name != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.core.vo.lookups.DocumentCreationType creationtype;
	protected ims.core.vo.lookups.DocumentCategory category;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.HcpLiteVo authoringhcp;
	protected ims.framework.utils.Date documentdate;
	protected ims.framework.utils.DateTime recordingdatetime;
	protected ims.core.vo.PatientDocumentStatusVo currentdocumentstatus;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	protected ims.core.vo.lookups.DocumentStatus correspondencestatus;
	protected String name;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
