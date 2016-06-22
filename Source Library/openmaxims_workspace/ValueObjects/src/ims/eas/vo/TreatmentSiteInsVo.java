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

package ims.eas.vo;

/**
 * Linked to EAS.Configuration.TreatmentSites business object (ID: 1114100000).
 */
public class TreatmentSiteInsVo extends ims.eas.configuration.vo.TreatmentSitesRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TreatmentSiteInsVo()
	{
	}
	public TreatmentSiteInsVo(Integer id, int version)
	{
		super(id, version);
	}
	public TreatmentSiteInsVo(ims.eas.vo.beans.TreatmentSiteInsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentsite = bean.getTreatmentSite() == null ? null : ims.eas.vo.lookups.TreatmentSites.buildLookup(bean.getTreatmentSite());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.laterality = bean.getLaterality();
		this.assessment = bean.getAssessment() == null ? null : new ims.assessment.configuration.vo.GraphicAssessmentRefVo(new Integer(bean.getAssessment().getId()), bean.getAssessment().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.TreatmentSiteInsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.treatmentsite = bean.getTreatmentSite() == null ? null : ims.eas.vo.lookups.TreatmentSites.buildLookup(bean.getTreatmentSite());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.laterality = bean.getLaterality();
		this.assessment = bean.getAssessment() == null ? null : new ims.assessment.configuration.vo.GraphicAssessmentRefVo(new Integer(bean.getAssessment().getId()), bean.getAssessment().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.TreatmentSiteInsVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.TreatmentSiteInsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.TreatmentSiteInsVoBean();
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
		if(fieldName.equals("TREATMENTSITE"))
			return getTreatmentSite();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		if(fieldName.equals("ASSESSMENT"))
			return getAssessment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentSiteIsNotNull()
	{
		return this.treatmentsite != null;
	}
	public ims.eas.vo.lookups.TreatmentSites getTreatmentSite()
	{
		return this.treatmentsite;
	}
	public void setTreatmentSite(ims.eas.vo.lookups.TreatmentSites value)
	{
		this.isValidated = false;
		this.treatmentsite = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public Boolean getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(Boolean value)
	{
		this.isValidated = false;
		this.laterality = value;
	}
	public boolean getAssessmentIsNotNull()
	{
		return this.assessment != null;
	}
	public ims.assessment.configuration.vo.GraphicAssessmentRefVo getAssessment()
	{
		return this.assessment;
	}
	public void setAssessment(ims.assessment.configuration.vo.GraphicAssessmentRefVo value)
	{
		this.isValidated = false;
		this.assessment = value;
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
		if(this.treatmentsite == null)
			listOfErrors.add("TreatmentSite is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
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
	
		TreatmentSiteInsVo clone = new TreatmentSiteInsVo(this.id, this.version);
		
		if(this.treatmentsite == null)
			clone.treatmentsite = null;
		else
			clone.treatmentsite = (ims.eas.vo.lookups.TreatmentSites)this.treatmentsite.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		clone.laterality = this.laterality;
		clone.assessment = this.assessment;
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
		if (!(TreatmentSiteInsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TreatmentSiteInsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TreatmentSiteInsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TreatmentSiteInsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatmentsite != null)
			count++;
		if(this.status != null)
			count++;
		if(this.laterality != null)
			count++;
		if(this.assessment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.eas.vo.lookups.TreatmentSites treatmentsite;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected Boolean laterality;
	protected ims.assessment.configuration.vo.GraphicAssessmentRefVo assessment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
