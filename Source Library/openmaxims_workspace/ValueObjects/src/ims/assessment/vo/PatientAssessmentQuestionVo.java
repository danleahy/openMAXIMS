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
 * Linked to Assessment.Instantiation.PatientAssessmentQuestion business object (ID: 1070100005).
 */
public class PatientAssessmentQuestionVo extends ims.assessment.instantiation.vo.PatientAssessmentQuestionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentQuestionVo()
	{
	}
	public PatientAssessmentQuestionVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAssessmentQuestionVo(ims.assessment.vo.beans.PatientAssessmentQuestionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isanswered = bean.getIsAnswered() == null ? null : ims.assessment.vo.lookups.AnswerStatus.buildLookup(bean.getIsAnswered());
		this.assessmentquestion = bean.getAssessmentQuestion() == null ? null : bean.getAssessmentQuestion().buildVo();
		this.patientanswers = ims.assessment.vo.PatientAssessmentAnswerVoCollection.buildFromBeanCollection(bean.getPatientAnswers());
		this.ismandatory = bean.getIsMandatory();
		this.allowsmultipleanswers = bean.getAllowsMultipleAnswers();
		this.sequence = bean.getSequence();
		this.ispoc = bean.getIsPoc();
		this.isrolereadonly = bean.getIsRoleReadOnly();
		this.isconfirmed = bean.getIsConfirmed();
		this.ispocsaved = bean.getIsPocSaved();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientAssessmentQuestionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isanswered = bean.getIsAnswered() == null ? null : ims.assessment.vo.lookups.AnswerStatus.buildLookup(bean.getIsAnswered());
		this.assessmentquestion = bean.getAssessmentQuestion() == null ? null : bean.getAssessmentQuestion().buildVo(map);
		this.patientanswers = ims.assessment.vo.PatientAssessmentAnswerVoCollection.buildFromBeanCollection(bean.getPatientAnswers());
		this.ismandatory = bean.getIsMandatory();
		this.allowsmultipleanswers = bean.getAllowsMultipleAnswers();
		this.sequence = bean.getSequence();
		this.ispoc = bean.getIsPoc();
		this.isrolereadonly = bean.getIsRoleReadOnly();
		this.isconfirmed = bean.getIsConfirmed();
		this.ispocsaved = bean.getIsPocSaved();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientAssessmentQuestionVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientAssessmentQuestionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientAssessmentQuestionVoBean();
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
		if(fieldName.equals("ISANSWERED"))
			return getIsAnswered();
		if(fieldName.equals("ASSESSMENTQUESTION"))
			return getAssessmentQuestion();
		if(fieldName.equals("PATIENTANSWERS"))
			return getPatientAnswers();
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("ALLOWSMULTIPLEANSWERS"))
			return getAllowsMultipleAnswers();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("ISPOC"))
			return getIsPoc();
		if(fieldName.equals("ISROLEREADONLY"))
			return getIsRoleReadOnly();
		if(fieldName.equals("ISCONFIRMED"))
			return getIsConfirmed();
		if(fieldName.equals("ISPOCSAVED"))
			return getIsPocSaved();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsAnsweredIsNotNull()
	{
		return this.isanswered != null;
	}
	public ims.assessment.vo.lookups.AnswerStatus getIsAnswered()
	{
		return this.isanswered;
	}
	public void setIsAnswered(ims.assessment.vo.lookups.AnswerStatus value)
	{
		this.isValidated = false;
		this.isanswered = value;
	}
	public boolean getAssessmentQuestionIsNotNull()
	{
		return this.assessmentquestion != null;
	}
	public ims.core.vo.AssessmentQuestionVo getAssessmentQuestion()
	{
		return this.assessmentquestion;
	}
	public void setAssessmentQuestion(ims.core.vo.AssessmentQuestionVo value)
	{
		this.isValidated = false;
		this.assessmentquestion = value;
	}
	public boolean getPatientAnswersIsNotNull()
	{
		return this.patientanswers != null;
	}
	public ims.assessment.vo.PatientAssessmentAnswerVoCollection getPatientAnswers()
	{
		return this.patientanswers;
	}
	public void setPatientAnswers(ims.assessment.vo.PatientAssessmentAnswerVoCollection value)
	{
		this.isValidated = false;
		this.patientanswers = value;
	}
	public boolean getIsMandatoryIsNotNull()
	{
		return this.ismandatory != null;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.isValidated = false;
		this.ismandatory = value;
	}
	public boolean getAllowsMultipleAnswersIsNotNull()
	{
		return this.allowsmultipleanswers != null;
	}
	public Boolean getAllowsMultipleAnswers()
	{
		return this.allowsmultipleanswers;
	}
	public void setAllowsMultipleAnswers(Boolean value)
	{
		this.isValidated = false;
		this.allowsmultipleanswers = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getIsPocIsNotNull()
	{
		return this.ispoc != null;
	}
	public Boolean getIsPoc()
	{
		return this.ispoc;
	}
	public void setIsPoc(Boolean value)
	{
		this.isValidated = false;
		this.ispoc = value;
	}
	public boolean getIsRoleReadOnlyIsNotNull()
	{
		return this.isrolereadonly != null;
	}
	public Boolean getIsRoleReadOnly()
	{
		return this.isrolereadonly;
	}
	public void setIsRoleReadOnly(Boolean value)
	{
		this.isValidated = false;
		this.isrolereadonly = value;
	}
	public boolean getIsConfirmedIsNotNull()
	{
		return this.isconfirmed != null;
	}
	public Boolean getIsConfirmed()
	{
		return this.isconfirmed;
	}
	public void setIsConfirmed(Boolean value)
	{
		this.isValidated = false;
		this.isconfirmed = value;
	}
	public boolean getIsPocSavedIsNotNull()
	{
		return this.ispocsaved != null;
	}
	public Boolean getIsPocSaved()
	{
		return this.ispocsaved;
	}
	public void setIsPocSaved(Boolean value)
	{
		this.isValidated = false;
		this.ispocsaved = value;
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
		if(this.patientanswers != null)
		{
			if(!this.patientanswers.isValidated())
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
		if(this.isanswered == null)
			listOfErrors.add("isAnswered is mandatory");
		if(this.assessmentquestion == null)
			listOfErrors.add("AssessmentQuestion is mandatory");
		if(this.patientanswers != null)
		{
			String[] listOfOtherErrors = this.patientanswers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ismandatory == null)
			listOfErrors.add("isMandatory is mandatory");
		if(this.allowsmultipleanswers == null)
			listOfErrors.add("allowsMultipleAnswers is mandatory");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
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
	
		PatientAssessmentQuestionVo clone = new PatientAssessmentQuestionVo(this.id, this.version);
		
		if(this.isanswered == null)
			clone.isanswered = null;
		else
			clone.isanswered = (ims.assessment.vo.lookups.AnswerStatus)this.isanswered.clone();
		if(this.assessmentquestion == null)
			clone.assessmentquestion = null;
		else
			clone.assessmentquestion = (ims.core.vo.AssessmentQuestionVo)this.assessmentquestion.clone();
		if(this.patientanswers == null)
			clone.patientanswers = null;
		else
			clone.patientanswers = (ims.assessment.vo.PatientAssessmentAnswerVoCollection)this.patientanswers.clone();
		clone.ismandatory = this.ismandatory;
		clone.allowsmultipleanswers = this.allowsmultipleanswers;
		clone.sequence = this.sequence;
		clone.ispoc = this.ispoc;
		clone.isrolereadonly = this.isrolereadonly;
		clone.isconfirmed = this.isconfirmed;
		clone.ispocsaved = this.ispocsaved;
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
		if (!(PatientAssessmentQuestionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentQuestionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientAssessmentQuestionVo compareObj = (PatientAssessmentQuestionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSequence() == null && compareObj.getSequence() != null)
				return -1;
			if(this.getSequence() != null && compareObj.getSequence() == null)
				return 1;
			if(this.getSequence() != null && compareObj.getSequence() != null)
				retVal = this.getSequence().compareTo(compareObj.getSequence());
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
		if(this.isanswered != null)
			count++;
		if(this.assessmentquestion != null)
			count++;
		if(this.patientanswers != null)
			count++;
		if(this.ismandatory != null)
			count++;
		if(this.allowsmultipleanswers != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.ispoc != null)
			count++;
		if(this.isrolereadonly != null)
			count++;
		if(this.isconfirmed != null)
			count++;
		if(this.ispocsaved != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.assessment.vo.lookups.AnswerStatus isanswered;
	protected ims.core.vo.AssessmentQuestionVo assessmentquestion;
	protected ims.assessment.vo.PatientAssessmentAnswerVoCollection patientanswers;
	protected Boolean ismandatory;
	protected Boolean allowsmultipleanswers;
	protected Integer sequence;
	protected Boolean ispoc;
	protected Boolean isrolereadonly;
	protected Boolean isconfirmed;
	protected Boolean ispocsaved;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
