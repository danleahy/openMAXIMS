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


public class PathologyOrdersResultsSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathologyOrdersResultsSearchCriteriaVo()
	{
	}
	public PathologyOrdersResultsSearchCriteriaVo(ims.ocrr.vo.beans.PathologyOrdersResultsSearchCriteriaVoBean bean)
	{
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.respclinician = bean.getRespClinician() == null ? null : bean.getRespClinician().buildVo();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo();
		this.searchtype = bean.getSearchType();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.inpatientoutpatientsearchtype = bean.getInpatientOutpatientSearchType();
		this.checked = bean.getChecked();
		this.unchecked = bean.getUnchecked();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathologyOrdersResultsSearchCriteriaVoBean bean)
	{
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDate();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDate();
		this.respclinician = bean.getRespClinician() == null ? null : bean.getRespClinician().buildVo(map);
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.investigation = bean.getInvestigation() == null ? null : bean.getInvestigation().buildVo(map);
		this.searchtype = bean.getSearchType();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.inpatientoutpatientsearchtype = bean.getInpatientOutpatientSearchType();
		this.checked = bean.getChecked();
		this.unchecked = bean.getUnchecked();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathologyOrdersResultsSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathologyOrdersResultsSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathologyOrdersResultsSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getFromDateIsNotNull()
	{
		return this.fromdate != null;
	}
	public ims.framework.utils.Date getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.fromdate = value;
	}
	public boolean getToDateIsNotNull()
	{
		return this.todate != null;
	}
	public ims.framework.utils.Date getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.todate = value;
	}
	public boolean getRespClinicianIsNotNull()
	{
		return this.respclinician != null;
	}
	public ims.core.vo.HcpLiteVo getRespClinician()
	{
		return this.respclinician;
	}
	public void setRespClinician(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.respclinician = value;
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
	public boolean getInvestigationIsNotNull()
	{
		return this.investigation != null;
	}
	public ims.ocrr.vo.InvestigationIndexLiteVo getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.InvestigationIndexLiteVo value)
	{
		this.isValidated = false;
		this.investigation = value;
	}
	public boolean getSearchTypeIsNotNull()
	{
		return this.searchtype != null;
	}
	public Integer getSearchType()
	{
		return this.searchtype;
	}
	public void setSearchType(Integer value)
	{
		this.isValidated = false;
		this.searchtype = value;
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
	public boolean getInpatientOutpatientSearchTypeIsNotNull()
	{
		return this.inpatientoutpatientsearchtype != null;
	}
	public Integer getInpatientOutpatientSearchType()
	{
		return this.inpatientoutpatientsearchtype;
	}
	public void setInpatientOutpatientSearchType(Integer value)
	{
		this.isValidated = false;
		this.inpatientoutpatientsearchtype = value;
	}
	public boolean getCheckedIsNotNull()
	{
		return this.checked != null;
	}
	public Boolean getChecked()
	{
		return this.checked;
	}
	public void setChecked(Boolean value)
	{
		this.isValidated = false;
		this.checked = value;
	}
	public boolean getUncheckedIsNotNull()
	{
		return this.unchecked != null;
	}
	public Boolean getUnchecked()
	{
		return this.unchecked;
	}
	public void setUnchecked(Boolean value)
	{
		this.isValidated = false;
		this.unchecked = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
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
		if(this.respclinician != null)
		{
			if(!this.respclinician.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.investigation != null)
		{
			if(!this.investigation.isValidated())
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
		if(this.respclinician != null)
		{
			String[] listOfOtherErrors = this.respclinician.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.investigation != null)
		{
			String[] listOfOtherErrors = this.investigation.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PathologyOrdersResultsSearchCriteriaVo clone = new PathologyOrdersResultsSearchCriteriaVo();
		
		if(this.fromdate == null)
			clone.fromdate = null;
		else
			clone.fromdate = (ims.framework.utils.Date)this.fromdate.clone();
		if(this.todate == null)
			clone.todate = null;
		else
			clone.todate = (ims.framework.utils.Date)this.todate.clone();
		if(this.respclinician == null)
			clone.respclinician = null;
		else
			clone.respclinician = (ims.core.vo.HcpLiteVo)this.respclinician.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.investigation == null)
			clone.investigation = null;
		else
			clone.investigation = (ims.ocrr.vo.InvestigationIndexLiteVo)this.investigation.clone();
		clone.searchtype = this.searchtype;
		clone.patient = this.patient;
		clone.inpatientoutpatientsearchtype = this.inpatientoutpatientsearchtype;
		clone.checked = this.checked;
		clone.unchecked = this.unchecked;
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
		if (!(PathologyOrdersResultsSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologyOrdersResultsSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PathologyOrdersResultsSearchCriteriaVo compareObj = (PathologyOrdersResultsSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getInvestigation() == null && compareObj.getInvestigation() != null)
				return -1;
			if(this.getInvestigation() != null && compareObj.getInvestigation() == null)
				return 1;
			if(this.getInvestigation() != null && compareObj.getInvestigation() != null)
				retVal = this.getInvestigation().compareTo(compareObj.getInvestigation());
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
		if(this.fromdate != null)
			count++;
		if(this.todate != null)
			count++;
		if(this.respclinician != null)
			count++;
		if(this.service != null)
			count++;
		if(this.investigation != null)
			count++;
		if(this.searchtype != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.inpatientoutpatientsearchtype != null)
			count++;
		if(this.checked != null)
			count++;
		if(this.unchecked != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.framework.utils.Date fromdate;
	protected ims.framework.utils.Date todate;
	protected ims.core.vo.HcpLiteVo respclinician;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.ocrr.vo.InvestigationIndexLiteVo investigation;
	protected Integer searchtype;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected Integer inpatientoutpatientsearchtype;
	protected Boolean checked;
	protected Boolean unchecked;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
