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


public class PatientSummaryOverviewVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientSummaryOverviewVo()
	{
	}
	public PatientSummaryOverviewVo(ims.core.vo.beans.PatientSummaryOverviewVoBean bean)
	{
		this.gp = bean.getGp() == null ? null : bean.getGp().buildVo();
		this.surgicalhistory = ims.core.vo.IntraOperativeCRforSummaryOverviewVoCollection.buildFromBeanCollection(bean.getSurgicalHistory());
		this.patientallergies = ims.core.vo.PatientAllergyForSummaryOverviewVoCollection.buildFromBeanCollection(bean.getPatientAllergies());
		this.patientalerts = ims.core.vo.PatientAlertLiteVoCollection.buildFromBeanCollection(bean.getPatientAlerts());
		this.riskassessments = ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection.buildFromBeanCollection(bean.getRiskAssessments());
		this.appointmentshistory = ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection.buildFromBeanCollection(bean.getAppointmentsHistory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientSummaryOverviewVoBean bean)
	{
		this.gp = bean.getGp() == null ? null : bean.getGp().buildVo(map);
		this.surgicalhistory = ims.core.vo.IntraOperativeCRforSummaryOverviewVoCollection.buildFromBeanCollection(bean.getSurgicalHistory());
		this.patientallergies = ims.core.vo.PatientAllergyForSummaryOverviewVoCollection.buildFromBeanCollection(bean.getPatientAllergies());
		this.patientalerts = ims.core.vo.PatientAlertLiteVoCollection.buildFromBeanCollection(bean.getPatientAlerts());
		this.riskassessments = ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection.buildFromBeanCollection(bean.getRiskAssessments());
		this.appointmentshistory = ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection.buildFromBeanCollection(bean.getAppointmentsHistory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientSummaryOverviewVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientSummaryOverviewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientSummaryOverviewVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getGpIsNotNull()
	{
		return this.gp != null;
	}
	public ims.core.vo.GpToPracticesForSummaryOverviewVo getGp()
	{
		return this.gp;
	}
	public void setGp(ims.core.vo.GpToPracticesForSummaryOverviewVo value)
	{
		this.isValidated = false;
		this.gp = value;
	}
	public boolean getSurgicalHistoryIsNotNull()
	{
		return this.surgicalhistory != null;
	}
	public ims.core.vo.IntraOperativeCRforSummaryOverviewVoCollection getSurgicalHistory()
	{
		return this.surgicalhistory;
	}
	public void setSurgicalHistory(ims.core.vo.IntraOperativeCRforSummaryOverviewVoCollection value)
	{
		this.isValidated = false;
		this.surgicalhistory = value;
	}
	public boolean getPatientAllergiesIsNotNull()
	{
		return this.patientallergies != null;
	}
	public ims.core.vo.PatientAllergyForSummaryOverviewVoCollection getPatientAllergies()
	{
		return this.patientallergies;
	}
	public void setPatientAllergies(ims.core.vo.PatientAllergyForSummaryOverviewVoCollection value)
	{
		this.isValidated = false;
		this.patientallergies = value;
	}
	public boolean getPatientAlertsIsNotNull()
	{
		return this.patientalerts != null;
	}
	public ims.core.vo.PatientAlertLiteVoCollection getPatientAlerts()
	{
		return this.patientalerts;
	}
	public void setPatientAlerts(ims.core.vo.PatientAlertLiteVoCollection value)
	{
		this.isValidated = false;
		this.patientalerts = value;
	}
	public boolean getRiskAssessmentsIsNotNull()
	{
		return this.riskassessments != null;
	}
	public ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection getRiskAssessments()
	{
		return this.riskassessments;
	}
	public void setRiskAssessments(ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection value)
	{
		this.isValidated = false;
		this.riskassessments = value;
	}
	public boolean getAppointmentsHistoryIsNotNull()
	{
		return this.appointmentshistory != null;
	}
	public ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection getAppointmentsHistory()
	{
		return this.appointmentshistory;
	}
	public void setAppointmentsHistory(ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection value)
	{
		this.isValidated = false;
		this.appointmentshistory = value;
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
	
		PatientSummaryOverviewVo clone = new PatientSummaryOverviewVo();
		
		if(this.gp == null)
			clone.gp = null;
		else
			clone.gp = (ims.core.vo.GpToPracticesForSummaryOverviewVo)this.gp.clone();
		if(this.surgicalhistory == null)
			clone.surgicalhistory = null;
		else
			clone.surgicalhistory = (ims.core.vo.IntraOperativeCRforSummaryOverviewVoCollection)this.surgicalhistory.clone();
		if(this.patientallergies == null)
			clone.patientallergies = null;
		else
			clone.patientallergies = (ims.core.vo.PatientAllergyForSummaryOverviewVoCollection)this.patientallergies.clone();
		if(this.patientalerts == null)
			clone.patientalerts = null;
		else
			clone.patientalerts = (ims.core.vo.PatientAlertLiteVoCollection)this.patientalerts.clone();
		if(this.riskassessments == null)
			clone.riskassessments = null;
		else
			clone.riskassessments = (ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection)this.riskassessments.clone();
		if(this.appointmentshistory == null)
			clone.appointmentshistory = null;
		else
			clone.appointmentshistory = (ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection)this.appointmentshistory.clone();
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
		if (!(PatientSummaryOverviewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientSummaryOverviewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientSummaryOverviewVo compareObj = (PatientSummaryOverviewVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getGp() == null && compareObj.getGp() != null)
				return -1;
			if(this.getGp() != null && compareObj.getGp() == null)
				return 1;
			if(this.getGp() != null && compareObj.getGp() != null)
				retVal = this.getGp().compareTo(compareObj.getGp());
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
		if(this.gp != null)
			count++;
		if(this.surgicalhistory != null)
			count++;
		if(this.patientallergies != null)
			count++;
		if(this.patientalerts != null)
			count++;
		if(this.riskassessments != null)
			count++;
		if(this.appointmentshistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.GpToPracticesForSummaryOverviewVo gp;
	protected ims.core.vo.IntraOperativeCRforSummaryOverviewVoCollection surgicalhistory;
	protected ims.core.vo.PatientAllergyForSummaryOverviewVoCollection patientallergies;
	protected ims.core.vo.PatientAlertLiteVoCollection patientalerts;
	protected ims.core.vo.RiskAssessmentForSummaryOverviewVoCollection riskassessments;
	protected ims.core.vo.AppointmentHistoryForSummaryOverviewVoCollection appointmentshistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
