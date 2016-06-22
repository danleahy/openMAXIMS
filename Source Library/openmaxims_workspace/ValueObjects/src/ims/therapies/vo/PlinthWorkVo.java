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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.PlinthWork business object (ID: 1019100034).
 */
public class PlinthWorkVo extends ims.therapies.treatment.vo.PlinthWorkRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PlinthWorkVo()
	{
	}
	public PlinthWorkVo(Integer id, int version)
	{
		super(id, version);
	}
	public PlinthWorkVo(ims.therapies.vo.beans.PlinthWorkVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.analysis = ims.therapies.vo.PlinthWorkAnalysisVoCollection.buildFromBeanCollection(bean.getAnalysis());
		this.treatment = ims.therapies.vo.PlinthWorkTreatmentVoCollection.buildFromBeanCollection(bean.getTreatment());
		this.activities = ims.therapies.vo.PlinthWorkActivitiesVoCollection.buildFromBeanCollection(bean.getActivities());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.PlinthWorkVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.analysis = ims.therapies.vo.PlinthWorkAnalysisVoCollection.buildFromBeanCollection(bean.getAnalysis());
		this.treatment = ims.therapies.vo.PlinthWorkTreatmentVoCollection.buildFromBeanCollection(bean.getTreatment());
		this.activities = ims.therapies.vo.PlinthWorkActivitiesVoCollection.buildFromBeanCollection(bean.getActivities());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.PlinthWorkVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.PlinthWorkVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.PlinthWorkVoBean();
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
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("ANALYSIS"))
			return getAnalysis();
		if(fieldName.equals("TREATMENT"))
			return getTreatment();
		if(fieldName.equals("ACTIVITIES"))
			return getActivities();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAnalysisIsNotNull()
	{
		return this.analysis != null;
	}
	public ims.therapies.vo.PlinthWorkAnalysisVoCollection getAnalysis()
	{
		return this.analysis;
	}
	public void setAnalysis(ims.therapies.vo.PlinthWorkAnalysisVoCollection value)
	{
		this.isValidated = false;
		this.analysis = value;
	}
	public boolean getTreatmentIsNotNull()
	{
		return this.treatment != null;
	}
	public ims.therapies.vo.PlinthWorkTreatmentVoCollection getTreatment()
	{
		return this.treatment;
	}
	public void setTreatment(ims.therapies.vo.PlinthWorkTreatmentVoCollection value)
	{
		this.isValidated = false;
		this.treatment = value;
	}
	public boolean getActivitiesIsNotNull()
	{
		return this.activities != null;
	}
	public ims.therapies.vo.PlinthWorkActivitiesVoCollection getActivities()
	{
		return this.activities;
	}
	public void setActivities(ims.therapies.vo.PlinthWorkActivitiesVoCollection value)
	{
		this.isValidated = false;
		this.activities = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.analysis != null)
		{
			if(!this.analysis.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.treatment != null)
		{
			if(!this.treatment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.activities != null)
		{
			if(!this.activities.isValidated())
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
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is a mandatory field");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date/Time is a mandatory field");
		if(this.analysis != null)
		{
			String[] listOfOtherErrors = this.analysis.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.treatment != null)
		{
			String[] listOfOtherErrors = this.treatment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activities != null)
		{
			String[] listOfOtherErrors = this.activities.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.countFieldsWithValue() < 3)
		{
			listOfErrors.add("A minimum of 3 data fields must be entered");
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
	
		PlinthWorkVo clone = new PlinthWorkVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.analysis == null)
			clone.analysis = null;
		else
			clone.analysis = (ims.therapies.vo.PlinthWorkAnalysisVoCollection)this.analysis.clone();
		if(this.treatment == null)
			clone.treatment = null;
		else
			clone.treatment = (ims.therapies.vo.PlinthWorkTreatmentVoCollection)this.treatment.clone();
		if(this.activities == null)
			clone.activities = null;
		else
			clone.activities = (ims.therapies.vo.PlinthWorkActivitiesVoCollection)this.activities.clone();
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
		if (!(PlinthWorkVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PlinthWorkVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PlinthWorkVo compareObj = (PlinthWorkVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PlinthWork() == null && compareObj.getID_PlinthWork() != null)
				return -1;
			if(this.getID_PlinthWork() != null && compareObj.getID_PlinthWork() == null)
				return 1;
			if(this.getID_PlinthWork() != null && compareObj.getID_PlinthWork() != null)
				retVal = this.getID_PlinthWork().compareTo(compareObj.getID_PlinthWork());
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
		if(this.authoringcp != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.analysis != null)
			count++;
		if(this.treatment != null)
			count++;
		if(this.activities != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.therapies.vo.PlinthWorkAnalysisVoCollection analysis;
	protected ims.therapies.vo.PlinthWorkTreatmentVoCollection treatment;
	protected ims.therapies.vo.PlinthWorkActivitiesVoCollection activities;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
