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

package ims.assessment.vo;

/**
 * Linked to Assessment.Instantiation.PatientAssessment business object (ID: 1003100048).
 */
public class PatientAssessmentVo extends ims.assessment.vo.PatientAssessmentLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPatientAssessmentData
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentVo()
	{
	}
	public PatientAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAssessmentVo(ims.assessment.vo.beans.PatientAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatus());
		this.completedhcp = bean.getCompletedHCP() == null ? null : bean.getCompletedHCP().buildVo();
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.assessmentdata = bean.getAssessmentData() == null ? null : bean.getAssessmentData().buildVo();
		this.statusreason = bean.getStatusReason() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatusReason());
		this.statusreasontext = bean.getStatusReasonText();
		this.dpptype = bean.getDPPType() == null ? null : ims.assessment.vo.lookups.DPPType.buildLookup(bean.getDPPType());
		this.dpptypetext = bean.getDPPTypeText();
		this.iscurrentfortype = bean.getIsCurrentForType();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.score = bean.getScore();
		this.isassessmentdocumentsaved = bean.getIsAssessmentDocumentSaved();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatus());
		this.completedhcp = bean.getCompletedHCP() == null ? null : bean.getCompletedHCP().buildVo(map);
		this.completeddatetime = bean.getCompletedDateTime() == null ? null : bean.getCompletedDateTime().buildDateTime();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.assessmentdata = bean.getAssessmentData() == null ? null : bean.getAssessmentData().buildVo(map);
		this.statusreason = bean.getStatusReason() == null ? null : ims.core.vo.lookups.PatientAssessmentStatusReason.buildLookup(bean.getStatusReason());
		this.statusreasontext = bean.getStatusReasonText();
		this.dpptype = bean.getDPPType() == null ? null : ims.assessment.vo.lookups.DPPType.buildLookup(bean.getDPPType());
		this.dpptypetext = bean.getDPPTypeText();
		this.iscurrentfortype = bean.getIsCurrentForType();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.score = bean.getScore();
		this.isassessmentdocumentsaved = bean.getIsAssessmentDocumentSaved();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientAssessmentVoBean();
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
		if(fieldName.equals("STATUSREASON"))
			return getStatusReason();
		if(fieldName.equals("STATUSREASONTEXT"))
			return getStatusReasonText();
		if(fieldName.equals("DPPTYPE"))
			return getDPPType();
		if(fieldName.equals("DPPTYPETEXT"))
			return getDPPTypeText();
		if(fieldName.equals("ISCURRENTFORTYPE"))
			return getIsCurrentForType();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("SCORE"))
			return getScore();
		if(fieldName.equals("ISASSESSMENTDOCUMENTSAVED"))
			return getIsAssessmentDocumentSaved();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAssessmentDataIsNotNull()
	{
		return this.assessmentdata != null;
	}
	public ims.assessment.vo.PatientAssessmentDataVo getAssessmentData()
	{
		return this.assessmentdata;
	}
	public void setAssessmentData(ims.assessment.vo.PatientAssessmentDataVo value)
	{
		this.isValidated = false;
		this.assessmentdata = value;
	}
	public boolean getStatusReasonIsNotNull()
	{
		return this.statusreason != null;
	}
	public ims.core.vo.lookups.PatientAssessmentStatusReason getStatusReason()
	{
		return this.statusreason;
	}
	public void setStatusReason(ims.core.vo.lookups.PatientAssessmentStatusReason value)
	{
		this.isValidated = false;
		this.statusreason = value;
	}
	public boolean getStatusReasonTextIsNotNull()
	{
		return this.statusreasontext != null;
	}
	public String getStatusReasonText()
	{
		return this.statusreasontext;
	}
	public static int getStatusReasonTextMaxLength()
	{
		return 255;
	}
	public void setStatusReasonText(String value)
	{
		this.isValidated = false;
		this.statusreasontext = value;
	}
	public boolean getDPPTypeIsNotNull()
	{
		return this.dpptype != null;
	}
	public ims.assessment.vo.lookups.DPPType getDPPType()
	{
		return this.dpptype;
	}
	public void setDPPType(ims.assessment.vo.lookups.DPPType value)
	{
		this.isValidated = false;
		this.dpptype = value;
	}
	public boolean getDPPTypeTextIsNotNull()
	{
		return this.dpptypetext != null;
	}
	public String getDPPTypeText()
	{
		return this.dpptypetext;
	}
	public static int getDPPTypeTextMaxLength()
	{
		return 255;
	}
	public void setDPPTypeText(String value)
	{
		this.isValidated = false;
		this.dpptypetext = value;
	}
	public boolean getIsCurrentForTypeIsNotNull()
	{
		return this.iscurrentfortype != null;
	}
	public Boolean getIsCurrentForType()
	{
		return this.iscurrentfortype;
	}
	public void setIsCurrentForType(Boolean value)
	{
		this.isValidated = false;
		this.iscurrentfortype = value;
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
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
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
	public boolean getIsAssessmentDocumentSavedIsNotNull()
	{
		return this.isassessmentdocumentsaved != null;
	}
	public Boolean getIsAssessmentDocumentSaved()
	{
		return this.isassessmentdocumentsaved;
	}
	public void setIsAssessmentDocumentSaved(Boolean value)
	{
		this.isValidated = false;
		this.isassessmentdocumentsaved = value;
	}
	/**
	* IPatientAssessmentData interface methods
	*/
	public String getAssessmentName()
	{
		if (this.getAssessmentDataIsNotNull() && this.getAssessmentData().getUserAssessmentIsNotNull())
			return this.getAssessmentData().getUserAssessment().getName();
	
		if (this.getAssessmentDataIsNotNull() && this.getAssessmentData().getGraphicIsNotNull())
			return this.getAssessmentData().getGraphic().getName();
	
	
		return "";
	}
	
	public ims.core.vo.AuthoringInformationVo getAuthoringInfo()
	{
		return this.authoringinformation;
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
		if(this.assessmentdata != null)
		{
			if(!this.assessmentdata.isValidated())
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
		if(this.assessmentdata == null)
			listOfErrors.add("AssessmentData is mandatory");
		if(this.assessmentdata != null)
		{
			String[] listOfOtherErrors = this.assessmentdata.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.statusreasontext != null)
			if(this.statusreasontext.length() > 255)
				listOfErrors.add("The length of the field [statusreasontext] in the value object [ims.assessment.vo.PatientAssessmentVo] is too big. It should be less or equal to 255");
		if(this.dpptypetext != null)
			if(this.dpptypetext.length() > 255)
				listOfErrors.add("The length of the field [dpptypetext] in the value object [ims.assessment.vo.PatientAssessmentVo] is too big. It should be less or equal to 255");
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
	
		PatientAssessmentVo clone = new PatientAssessmentVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PatientAssessmentStatusReason)this.status.clone();
		if(this.completedhcp == null)
			clone.completedhcp = null;
		else
			clone.completedhcp = (ims.core.vo.HcpLiteVo)this.completedhcp.clone();
		if(this.completeddatetime == null)
			clone.completeddatetime = null;
		else
			clone.completeddatetime = (ims.framework.utils.DateTime)this.completeddatetime.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.assessmentdata == null)
			clone.assessmentdata = null;
		else
			clone.assessmentdata = (ims.assessment.vo.PatientAssessmentDataVo)this.assessmentdata.clone();
		if(this.statusreason == null)
			clone.statusreason = null;
		else
			clone.statusreason = (ims.core.vo.lookups.PatientAssessmentStatusReason)this.statusreason.clone();
		clone.statusreasontext = this.statusreasontext;
		if(this.dpptype == null)
			clone.dpptype = null;
		else
			clone.dpptype = (ims.assessment.vo.lookups.DPPType)this.dpptype.clone();
		clone.dpptypetext = this.dpptypetext;
		clone.iscurrentfortype = this.iscurrentfortype;
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		clone.episodeofcare = this.episodeofcare;
		clone.patient = this.patient;
		clone.score = this.score;
		clone.isassessmentdocumentsaved = this.isassessmentdocumentsaved;
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
		if (!(PatientAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientAssessmentVo compareObj = (PatientAssessmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.assessmentdata != null)
			count++;
		if(this.statusreason != null)
			count++;
		if(this.statusreasontext != null)
			count++;
		if(this.dpptype != null)
			count++;
		if(this.dpptypetext != null)
			count++;
		if(this.iscurrentfortype != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.score != null)
			count++;
		if(this.isassessmentdocumentsaved != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 12;
	}
	protected ims.assessment.vo.PatientAssessmentDataVo assessmentdata;
	protected ims.core.vo.lookups.PatientAssessmentStatusReason statusreason;
	protected String statusreasontext;
	protected ims.assessment.vo.lookups.DPPType dpptype;
	protected String dpptypetext;
	protected Boolean iscurrentfortype;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected Float score;
	protected Boolean isassessmentdocumentsaved;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
