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
 * Linked to Assessment.Instantiation.PatientAssessment business object (ID: 1003100048).
 */
public class PatientAssessmentForWhiteboardVo extends ims.assessment.instantiation.vo.PatientAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentForWhiteboardVo()
	{
	}
	public PatientAssessmentForWhiteboardVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAssessmentForWhiteboardVo(ims.emergency.vo.beans.PatientAssessmentForWhiteboardVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentdata = bean.getAssessmentData() == null ? null : bean.getAssessmentData().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatus());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.score = bean.getScore();
		this.completedhcp = bean.getCompletedHCP() == null ? null : bean.getCompletedHCP().buildVo();
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.PatientAssessmentForWhiteboardVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.assessmentdata = bean.getAssessmentData() == null ? null : bean.getAssessmentData().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatus());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.score = bean.getScore();
		this.completedhcp = bean.getCompletedHCP() == null ? null : bean.getCompletedHCP().buildVo(map);
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.PatientAssessmentForWhiteboardVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.PatientAssessmentForWhiteboardVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.PatientAssessmentForWhiteboardVoBean();
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
		if(fieldName.equals("ASSESSMENTDATA"))
			return getAssessmentData();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("SCORE"))
			return getScore();
		if(fieldName.equals("COMPLETEDHCP"))
			return getCompletedHCP();
		if(fieldName.equals("COMPLETEDDATETIME"))
			return getCompletedDateTime();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssessmentDataIsNotNull()
	{
		return this.assessmentdata != null;
	}
	public ims.emergency.vo.PatientAssessmentDataForWhiteboardVo getAssessmentData()
	{
		return this.assessmentdata;
	}
	public void setAssessmentData(ims.emergency.vo.PatientAssessmentDataForWhiteboardVo value)
	{
		this.isValidated = false;
		this.assessmentdata = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PatientAssessmentStatusReason getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PatientAssessmentStatusReason value)
	{
		this.isValidated = false;
		this.status = value;
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
	public boolean getScoreIsNotNull()
	{
		return this.score != null;
	}
	public Float getScore()
	{
		return this.score;
	}
	public void setScore(Float value)
	{
		this.isValidated = false;
		this.score = value;
	}
	public boolean getCompletedHCPIsNotNull()
	{
		return this.completedhcp != null;
	}
	public ims.core.vo.HcpMinVo getCompletedHCP()
	{
		return this.completedhcp;
	}
	public void setCompletedHCP(ims.core.vo.HcpMinVo value)
	{
		this.isValidated = false;
		this.completedhcp = value;
	}
	public boolean getCompletedDateTimeIsNotNull()
	{
		return this.completeddatetime != null;
	}
	public ims.framework.utils.DateTime getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completeddatetime = value;
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
		if(this.assessmentdata == null)
			listOfErrors.add("AssessmentData is mandatory");
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
	
		PatientAssessmentForWhiteboardVo clone = new PatientAssessmentForWhiteboardVo(this.id, this.version);
		
		if(this.assessmentdata == null)
			clone.assessmentdata = null;
		else
			clone.assessmentdata = (ims.emergency.vo.PatientAssessmentDataForWhiteboardVo)this.assessmentdata.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PatientAssessmentStatusReason)this.status.clone();
		clone.carecontext = this.carecontext;
		clone.score = this.score;
		if(this.completedhcp == null)
			clone.completedhcp = null;
		else
			clone.completedhcp = (ims.core.vo.HcpMinVo)this.completedhcp.clone();
		if(this.completeddatetime == null)
			clone.completeddatetime = null;
		else
			clone.completeddatetime = (ims.framework.utils.DateTime)this.completeddatetime.clone();
		clone.patient = this.patient;
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
		if (!(PatientAssessmentForWhiteboardVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentForWhiteboardVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientAssessmentForWhiteboardVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientAssessmentForWhiteboardVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.assessmentdata != null)
			count++;
		if(this.status != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.score != null)
			count++;
		if(this.completedhcp != null)
			count++;
		if(this.completeddatetime != null)
			count++;
		if(this.patient != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.emergency.vo.PatientAssessmentDataForWhiteboardVo assessmentdata;
	protected ims.core.vo.lookups.PatientAssessmentStatusReason status;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected Float score;
	protected ims.core.vo.HcpMinVo completedhcp;
	protected ims.framework.utils.DateTime completeddatetime;
	protected ims.core.patient.vo.PatientRefVo patient;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
