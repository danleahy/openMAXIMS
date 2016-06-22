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

package ims.nursing.vo;

/**
 * Linked to nursing.PlanOfCare business object (ID: 1009100002).
 */
public class PlanOfCareVo extends ims.nursing.vo.PlanOfCareListVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PlanOfCareVo()
	{
	}
	public PlanOfCareVo(Integer id, int version)
	{
		super(id, version);
	}
	public PlanOfCareVo(ims.nursing.vo.beans.PlanOfCareVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.group = bean.getGroup() == null ? null : ims.clinical.vo.lookups.PlanOfCareGroupings.buildLookup(bean.getGroup());
		this.title = bean.getTitle();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.resolveddatetime = bean.getResolvedDateTime() == null ? null : bean.getResolvedDateTime().buildDateTime();
		this.assessmentquestion = bean.getAssessmentQuestion() == null ? null : bean.getAssessmentQuestion().buildVo();
		this.levelofintervention = bean.getLevelOfIntervention() == null ? null : bean.getLevelOfIntervention().buildColor();
		this.actions = ims.nursing.vo.PlanOfCareActionsVoCollection.buildFromBeanCollection(bean.getActions());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.starthcp = bean.getStartHCP() == null ? null : bean.getStartHCP().buildVo();
		this.status = bean.getStatus() == null ? null : ims.nursing.vo.lookups.PlanOfCareStatus.buildLookup(bean.getStatus());
		this.resolvinghcp = bean.getResolvingHCP() == null ? null : bean.getResolvingHCP().buildVo();
		this.confirmingdatetime = bean.getConfirmingDateTime() == null ? null : bean.getConfirmingDateTime().buildDateTime();
		this.confirminghcp = bean.getConfirmingHCP() == null ? null : bean.getConfirmingHCP().buildVo();
		this.answerhistory = ims.nursing.vo.PlanOfCareHistoryVoCollection.buildFromBeanCollection(bean.getAnswerHistory());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.PlanOfCareVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.group = bean.getGroup() == null ? null : ims.clinical.vo.lookups.PlanOfCareGroupings.buildLookup(bean.getGroup());
		this.title = bean.getTitle();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.resolveddatetime = bean.getResolvedDateTime() == null ? null : bean.getResolvedDateTime().buildDateTime();
		this.assessmentquestion = bean.getAssessmentQuestion() == null ? null : bean.getAssessmentQuestion().buildVo(map);
		this.levelofintervention = bean.getLevelOfIntervention() == null ? null : bean.getLevelOfIntervention().buildColor();
		this.actions = ims.nursing.vo.PlanOfCareActionsVoCollection.buildFromBeanCollection(bean.getActions());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.starthcp = bean.getStartHCP() == null ? null : bean.getStartHCP().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.nursing.vo.lookups.PlanOfCareStatus.buildLookup(bean.getStatus());
		this.resolvinghcp = bean.getResolvingHCP() == null ? null : bean.getResolvingHCP().buildVo(map);
		this.confirmingdatetime = bean.getConfirmingDateTime() == null ? null : bean.getConfirmingDateTime().buildDateTime();
		this.confirminghcp = bean.getConfirmingHCP() == null ? null : bean.getConfirmingHCP().buildVo(map);
		this.answerhistory = ims.nursing.vo.PlanOfCareHistoryVoCollection.buildFromBeanCollection(bean.getAnswerHistory());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.PlanOfCareVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.PlanOfCareVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.PlanOfCareVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("STARTHCP"))
			return getStartHCP();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("RESOLVINGHCP"))
			return getResolvingHCP();
		if(fieldName.equals("CONFIRMINGDATETIME"))
			return getConfirmingDateTime();
		if(fieldName.equals("CONFIRMINGHCP"))
			return getConfirmingHCP();
		if(fieldName.equals("ANSWERHISTORY"))
			return getAnswerHistory();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getStartHCPIsNotNull()
	{
		return this.starthcp != null;
	}
	public ims.core.vo.HcpLiteVo getStartHCP()
	{
		return this.starthcp;
	}
	public void setStartHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.starthcp = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.nursing.vo.lookups.PlanOfCareStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.nursing.vo.lookups.PlanOfCareStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getResolvingHCPIsNotNull()
	{
		return this.resolvinghcp != null;
	}
	public ims.core.vo.HcpLiteVo getResolvingHCP()
	{
		return this.resolvinghcp;
	}
	public void setResolvingHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.resolvinghcp = value;
	}
	public boolean getConfirmingDateTimeIsNotNull()
	{
		return this.confirmingdatetime != null;
	}
	public ims.framework.utils.DateTime getConfirmingDateTime()
	{
		return this.confirmingdatetime;
	}
	public void setConfirmingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.confirmingdatetime = value;
	}
	public boolean getConfirmingHCPIsNotNull()
	{
		return this.confirminghcp != null;
	}
	public ims.core.vo.HcpLiteVo getConfirmingHCP()
	{
		return this.confirminghcp;
	}
	public void setConfirmingHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.confirminghcp = value;
	}
	public boolean getAnswerHistoryIsNotNull()
	{
		return this.answerhistory != null;
	}
	public ims.nursing.vo.PlanOfCareHistoryVoCollection getAnswerHistory()
	{
		return this.answerhistory;
	}
	public void setAnswerHistory(ims.nursing.vo.PlanOfCareHistoryVoCollection value)
	{
		this.isValidated = false;
		this.answerhistory = value;
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
		if(this.assessmentquestion != null)
		{
			if(!this.assessmentquestion.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.actions != null)
		{
			if(!this.actions.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.starthcp != null)
		{
			if(!this.starthcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.resolvinghcp != null)
		{
			if(!this.resolvinghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.confirminghcp != null)
		{
			if(!this.confirminghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.answerhistory != null)
		{
			if(!this.answerhistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.assessmentquestion != null)
		{
			String[] listOfOtherErrors = this.assessmentquestion.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.actions != null)
		{
			String[] listOfOtherErrors = this.actions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.starthcp != null)
		{
			String[] listOfOtherErrors = this.starthcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resolvinghcp != null)
		{
			String[] listOfOtherErrors = this.resolvinghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.confirminghcp != null)
		{
			String[] listOfOtherErrors = this.confirminghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.answerhistory != null)
		{
			String[] listOfOtherErrors = this.answerhistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		PlanOfCareVo clone = new PlanOfCareVo(this.id, this.version);
		
		if(this.group == null)
			clone.group = null;
		else
			clone.group = (ims.clinical.vo.lookups.PlanOfCareGroupings)this.group.clone();
		clone.title = this.title;
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		if(this.resolveddatetime == null)
			clone.resolveddatetime = null;
		else
			clone.resolveddatetime = (ims.framework.utils.DateTime)this.resolveddatetime.clone();
		if(this.assessmentquestion == null)
			clone.assessmentquestion = null;
		else
			clone.assessmentquestion = (ims.core.vo.AssessmentQuestionShortVo)this.assessmentquestion.clone();
		if(this.levelofintervention == null)
			clone.levelofintervention = null;
		else
			clone.levelofintervention = (ims.framework.utils.Color)this.levelofintervention.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.nursing.vo.PlanOfCareActionsVoCollection)this.actions.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		if(this.starthcp == null)
			clone.starthcp = null;
		else
			clone.starthcp = (ims.core.vo.HcpLiteVo)this.starthcp.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.nursing.vo.lookups.PlanOfCareStatus)this.status.clone();
		if(this.resolvinghcp == null)
			clone.resolvinghcp = null;
		else
			clone.resolvinghcp = (ims.core.vo.HcpLiteVo)this.resolvinghcp.clone();
		if(this.confirmingdatetime == null)
			clone.confirmingdatetime = null;
		else
			clone.confirmingdatetime = (ims.framework.utils.DateTime)this.confirmingdatetime.clone();
		if(this.confirminghcp == null)
			clone.confirminghcp = null;
		else
			clone.confirminghcp = (ims.core.vo.HcpLiteVo)this.confirminghcp.clone();
		if(this.answerhistory == null)
			clone.answerhistory = null;
		else
			clone.answerhistory = (ims.nursing.vo.PlanOfCareHistoryVoCollection)this.answerhistory.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
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
		if (!(PlanOfCareVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PlanOfCareVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PlanOfCareVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PlanOfCareVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.starthcp != null)
			count++;
		if(this.status != null)
			count++;
		if(this.resolvinghcp != null)
			count++;
		if(this.confirmingdatetime != null)
			count++;
		if(this.confirminghcp != null)
			count++;
		if(this.answerhistory != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.HcpLiteVo starthcp;
	protected ims.nursing.vo.lookups.PlanOfCareStatus status;
	protected ims.core.vo.HcpLiteVo resolvinghcp;
	protected ims.framework.utils.DateTime confirmingdatetime;
	protected ims.core.vo.HcpLiteVo confirminghcp;
	protected ims.nursing.vo.PlanOfCareHistoryVoCollection answerhistory;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
