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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.ServiceQuestionAnswer business object (ID: 1070100018).
 */
public class ServiceQuestionAnswerVo extends ims.ocrr.orderingresults.vo.ServiceQuestionAnswerRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IMandatoryQuestionHeader
{
	private static final long serialVersionUID = 1L;

	public ServiceQuestionAnswerVo()
	{
	}
	public ServiceQuestionAnswerVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServiceQuestionAnswerVo(ims.ocrr.vo.beans.ServiceQuestionAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.servicequestionanswers = ims.core.vo.GeneralQuestionAnswerVoCollection.buildFromBeanCollection(bean.getServiceQuestionAnswers());
		this.investigationquestionanswers = ims.ocrr.vo.InvestigationQuestionAnswerVoCollection.buildFromBeanCollection(bean.getInvestigationQuestionAnswers());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ServiceQuestionAnswerVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.servicequestionanswers = ims.core.vo.GeneralQuestionAnswerVoCollection.buildFromBeanCollection(bean.getServiceQuestionAnswers());
		this.investigationquestionanswers = ims.ocrr.vo.InvestigationQuestionAnswerVoCollection.buildFromBeanCollection(bean.getInvestigationQuestionAnswers());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ServiceQuestionAnswerVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ServiceQuestionAnswerVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ServiceQuestionAnswerVoBean();
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
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("SERVICEQUESTIONANSWERS"))
			return getServiceQuestionAnswers();
		if(fieldName.equals("INVESTIGATIONQUESTIONANSWERS"))
			return getInvestigationQuestionAnswers();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getServiceQuestionAnswersIsNotNull()
	{
		return this.servicequestionanswers != null;
	}
	public ims.core.vo.GeneralQuestionAnswerVoCollection getServiceQuestionAnswers()
	{
		return this.servicequestionanswers;
	}
	public void setServiceQuestionAnswers(ims.core.vo.GeneralQuestionAnswerVoCollection value)
	{
		this.isValidated = false;
		this.servicequestionanswers = value;
	}
	public boolean getInvestigationQuestionAnswersIsNotNull()
	{
		return this.investigationquestionanswers != null;
	}
	public ims.ocrr.vo.InvestigationQuestionAnswerVoCollection getInvestigationQuestionAnswers()
	{
		return this.investigationquestionanswers;
	}
	public void setInvestigationQuestionAnswers(ims.ocrr.vo.InvestigationQuestionAnswerVoCollection value)
	{
		this.isValidated = false;
		this.investigationquestionanswers = value;
	}
	/**
	* IMandatoryQuestionHeader methods
	*/
		public String getName()
		{
			return this.getServiceIsNotNull() ? this.getService().getServiceName() : null;
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
		if(this.servicequestionanswers != null)
		{
			if(!this.servicequestionanswers.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.investigationquestionanswers != null)
		{
			if(!this.investigationquestionanswers.isValidated())
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
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.servicequestionanswers != null)
		{
			String[] listOfOtherErrors = this.servicequestionanswers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.investigationquestionanswers != null)
		{
			String[] listOfOtherErrors = this.investigationquestionanswers.validate();
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
	
		ServiceQuestionAnswerVo clone = new ServiceQuestionAnswerVo(this.id, this.version);
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.servicequestionanswers == null)
			clone.servicequestionanswers = null;
		else
			clone.servicequestionanswers = (ims.core.vo.GeneralQuestionAnswerVoCollection)this.servicequestionanswers.clone();
		if(this.investigationquestionanswers == null)
			clone.investigationquestionanswers = null;
		else
			clone.investigationquestionanswers = (ims.ocrr.vo.InvestigationQuestionAnswerVoCollection)this.investigationquestionanswers.clone();
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
		if (!(ServiceQuestionAnswerVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServiceQuestionAnswerVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ServiceQuestionAnswerVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ServiceQuestionAnswerVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.service != null)
			count++;
		if(this.servicequestionanswers != null)
			count++;
		if(this.investigationquestionanswers != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.GeneralQuestionAnswerVoCollection servicequestionanswers;
	protected ims.ocrr.vo.InvestigationQuestionAnswerVoCollection investigationquestionanswers;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
