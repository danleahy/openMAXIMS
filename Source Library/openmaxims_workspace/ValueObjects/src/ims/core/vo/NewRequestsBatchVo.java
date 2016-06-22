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
 * Linked to core.configuration.NewRequestsBatch business object (ID: 1028100087).
 */
public class NewRequestsBatchVo extends ims.core.configuration.vo.NewRequestsBatchRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NewRequestsBatchVo()
	{
	}
	public NewRequestsBatchVo(Integer id, int version)
	{
		super(id, version);
	}
	public NewRequestsBatchVo(ims.core.vo.beans.NewRequestsBatchVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.configuredjobdetails = bean.getConfiguredJobDetails() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJobDetails().getId()), bean.getConfiguredJobDetails().getVersion());
		this.processedrequestsno = bean.getProcessedRequestsNo();
		this.successfulrequestsupdatedno = bean.getSuccessfulRequestsUpdatedNo();
		this.printagentto = bean.getPrintAgentTo();
		this.printrequestsforoutstandingandnewrequestsinndays = bean.getPrintRequestsForOutstandingAndNewRequestsInNdays();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.NewRequestsBatchVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.configuredjobdetails = bean.getConfiguredJobDetails() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJobDetails().getId()), bean.getConfiguredJobDetails().getVersion());
		this.processedrequestsno = bean.getProcessedRequestsNo();
		this.successfulrequestsupdatedno = bean.getSuccessfulRequestsUpdatedNo();
		this.printagentto = bean.getPrintAgentTo();
		this.printrequestsforoutstandingandnewrequestsinndays = bean.getPrintRequestsForOutstandingAndNewRequestsInNdays();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.NewRequestsBatchVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.NewRequestsBatchVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.NewRequestsBatchVoBean();
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
		if(fieldName.equals("CONFIGUREDJOBDETAILS"))
			return getConfiguredJobDetails();
		if(fieldName.equals("PROCESSEDREQUESTSNO"))
			return getProcessedRequestsNo();
		if(fieldName.equals("SUCCESSFULREQUESTSUPDATEDNO"))
			return getSuccessfulRequestsUpdatedNo();
		if(fieldName.equals("PRINTAGENTTO"))
			return getPrintAgentTo();
		if(fieldName.equals("PRINTREQUESTSFOROUTSTANDINGANDNEWREQUESTSINNDAYS"))
			return getPrintRequestsForOutstandingAndNewRequestsInNdays();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getConfiguredJobDetailsIsNotNull()
	{
		return this.configuredjobdetails != null;
	}
	public ims.core.configuration.vo.ConfiguredJobRefVo getConfiguredJobDetails()
	{
		return this.configuredjobdetails;
	}
	public void setConfiguredJobDetails(ims.core.configuration.vo.ConfiguredJobRefVo value)
	{
		this.isValidated = false;
		this.configuredjobdetails = value;
	}
	public boolean getProcessedRequestsNoIsNotNull()
	{
		return this.processedrequestsno != null;
	}
	public Integer getProcessedRequestsNo()
	{
		return this.processedrequestsno;
	}
	public void setProcessedRequestsNo(Integer value)
	{
		this.isValidated = false;
		this.processedrequestsno = value;
	}
	public boolean getSuccessfulRequestsUpdatedNoIsNotNull()
	{
		return this.successfulrequestsupdatedno != null;
	}
	public Integer getSuccessfulRequestsUpdatedNo()
	{
		return this.successfulrequestsupdatedno;
	}
	public void setSuccessfulRequestsUpdatedNo(Integer value)
	{
		this.isValidated = false;
		this.successfulrequestsupdatedno = value;
	}
	public boolean getPrintAgentToIsNotNull()
	{
		return this.printagentto != null;
	}
	public String getPrintAgentTo()
	{
		return this.printagentto;
	}
	public static int getPrintAgentToMaxLength()
	{
		return 500;
	}
	public void setPrintAgentTo(String value)
	{
		this.isValidated = false;
		this.printagentto = value;
	}
	public boolean getPrintRequestsForOutstandingAndNewRequestsInNdaysIsNotNull()
	{
		return this.printrequestsforoutstandingandnewrequestsinndays != null;
	}
	public Integer getPrintRequestsForOutstandingAndNewRequestsInNdays()
	{
		return this.printrequestsforoutstandingandnewrequestsinndays;
	}
	public void setPrintRequestsForOutstandingAndNewRequestsInNdays(Integer value)
	{
		this.isValidated = false;
		this.printrequestsforoutstandingandnewrequestsinndays = value;
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
		if(this.configuredjobdetails == null)
			listOfErrors.add("ConfiguredJobDetails is mandatory");
		if(this.printagentto != null)
			if(this.printagentto.length() > 500)
				listOfErrors.add("The length of the field [printagentto] in the value object [ims.core.vo.NewRequestsBatchVo] is too big. It should be less or equal to 500");
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
	
		NewRequestsBatchVo clone = new NewRequestsBatchVo(this.id, this.version);
		
		clone.configuredjobdetails = this.configuredjobdetails;
		clone.processedrequestsno = this.processedrequestsno;
		clone.successfulrequestsupdatedno = this.successfulrequestsupdatedno;
		clone.printagentto = this.printagentto;
		clone.printrequestsforoutstandingandnewrequestsinndays = this.printrequestsforoutstandingandnewrequestsinndays;
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
		if (!(NewRequestsBatchVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NewRequestsBatchVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NewRequestsBatchVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NewRequestsBatchVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.configuredjobdetails != null)
			count++;
		if(this.processedrequestsno != null)
			count++;
		if(this.successfulrequestsupdatedno != null)
			count++;
		if(this.printagentto != null)
			count++;
		if(this.printrequestsforoutstandingandnewrequestsinndays != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.configuration.vo.ConfiguredJobRefVo configuredjobdetails;
	protected Integer processedrequestsno;
	protected Integer successfulrequestsupdatedno;
	protected String printagentto;
	protected Integer printrequestsforoutstandingandnewrequestsinndays;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
