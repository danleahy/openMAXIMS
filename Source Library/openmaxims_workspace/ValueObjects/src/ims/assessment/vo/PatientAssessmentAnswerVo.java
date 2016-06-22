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
 * Linked to Assessment.Instantiation.PatientAssessmentAnswer business object (ID: 1003100061).
 */
public class PatientAssessmentAnswerVo extends ims.assessment.instantiation.vo.PatientAssessmentAnswerRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAssessmentAnswerVo()
	{
	}
	public PatientAssessmentAnswerVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAssessmentAnswerVo(ims.assessment.vo.beans.PatientAssessmentAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answerdetails = ims.core.vo.AnswerDetailsVoCollection.buildFromBeanCollection(bean.getAnswerDetails());
		this.confirminginfo = bean.getConfirmingInfo() == null ? null : bean.getConfirmingInfo().buildVo();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientAssessmentAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.answerdetails = ims.core.vo.AnswerDetailsVoCollection.buildFromBeanCollection(bean.getAnswerDetails());
		this.confirminginfo = bean.getConfirmingInfo() == null ? null : bean.getConfirmingInfo().buildVo(map);
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientAssessmentAnswerVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientAssessmentAnswerVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientAssessmentAnswerVoBean();
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
		if(fieldName.equals("ANSWERDETAILS"))
			return getAnswerDetails();
		if(fieldName.equals("CONFIRMINGINFO"))
			return getConfirmingInfo();
		if(fieldName.equals("AUTHORINGINFO"))
			return getAuthoringInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAnswerDetailsIsNotNull()
	{
		return this.answerdetails != null;
	}
	public ims.core.vo.AnswerDetailsVoCollection getAnswerDetails()
	{
		return this.answerdetails;
	}
	public void setAnswerDetails(ims.core.vo.AnswerDetailsVoCollection value)
	{
		this.isValidated = false;
		this.answerdetails = value;
	}
	public boolean getConfirmingInfoIsNotNull()
	{
		return this.confirminginfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getConfirmingInfo()
	{
		return this.confirminginfo;
	}
	public void setConfirmingInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.confirminginfo = value;
	}
	public boolean getAuthoringInfoIsNotNull()
	{
		return this.authoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinfo = value;
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
		if(this.answerdetails != null)
		{
			if(!this.answerdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.confirminginfo != null)
		{
			if(!this.confirminginfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinfo != null)
		{
			if(!this.authoringinfo.isValidated())
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
		if(this.answerdetails != null)
		{
			String[] listOfOtherErrors = this.answerdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.confirminginfo != null)
		{
			String[] listOfOtherErrors = this.confirminginfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringinfo != null)
		{
			String[] listOfOtherErrors = this.authoringinfo.validate();
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
	
		PatientAssessmentAnswerVo clone = new PatientAssessmentAnswerVo(this.id, this.version);
		
		if(this.answerdetails == null)
			clone.answerdetails = null;
		else
			clone.answerdetails = (ims.core.vo.AnswerDetailsVoCollection)this.answerdetails.clone();
		if(this.confirminginfo == null)
			clone.confirminginfo = null;
		else
			clone.confirminginfo = (ims.core.vo.AuthoringInformationVo)this.confirminginfo.clone();
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
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
		if (!(PatientAssessmentAnswerVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAssessmentAnswerVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientAssessmentAnswerVo compareObj = (PatientAssessmentAnswerVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientAssessmentAnswer() == null && compareObj.getID_PatientAssessmentAnswer() != null)
				return -1;
			if(this.getID_PatientAssessmentAnswer() != null && compareObj.getID_PatientAssessmentAnswer() == null)
				return 1;
			if(this.getID_PatientAssessmentAnswer() != null && compareObj.getID_PatientAssessmentAnswer() != null)
				retVal = this.getID_PatientAssessmentAnswer().compareTo(compareObj.getID_PatientAssessmentAnswer());
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
		if(this.answerdetails != null)
			count++;
		if(this.confirminginfo != null)
			count++;
		if(this.authoringinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.AnswerDetailsVoCollection answerdetails;
	protected ims.core.vo.AuthoringInformationVo confirminginfo;
	protected ims.core.vo.AuthoringInformationVo authoringinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
