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

package ims.emergency.vo;

/**
 * Linked to core.admin.EmergencyEpisode business object (ID: 1004100024).
 */
public class EmergencyEpisodeForTriageLiteVo extends ims.core.admin.vo.EmergencyEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyEpisodeForTriageLiteVo()
	{
	}
	public EmergencyEpisodeForTriageLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyEpisodeForTriageLiteVo(ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.injurydatetime = bean.getInjuryDateTime() == null ? null : bean.getInjuryDateTime().buildDateTime();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.presentingcomplaint = bean.getPresentingComplaint() == null ? null : ims.emergency.vo.lookups.PresentingComplaint.buildLookup(bean.getPresentingComplaint());
		this.category = bean.getCategory() == null ? null : ims.emergency.vo.lookups.PatientCategory.buildLookup(bean.getCategory());
		this.medpatientconsent = bean.getMedPatientConsent();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.injurydatetime = bean.getInjuryDateTime() == null ? null : bean.getInjuryDateTime().buildDateTime();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.presentingcomplaint = bean.getPresentingComplaint() == null ? null : ims.emergency.vo.lookups.PresentingComplaint.buildLookup(bean.getPresentingComplaint());
		this.category = bean.getCategory() == null ? null : ims.emergency.vo.lookups.PatientCategory.buildLookup(bean.getCategory());
		this.medpatientconsent = bean.getMedPatientConsent();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyEpisodeForTriageLiteVoBean();
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
		if(fieldName.equals("INJURYDATETIME"))
			return getInjuryDateTime();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("PRESENTINGCOMPLAINT"))
			return getPresentingComplaint();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("MEDPATIENTCONSENT"))
			return getMedPatientConsent();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInjuryDateTimeIsNotNull()
	{
		return this.injurydatetime != null;
	}
	public ims.framework.utils.DateTime getInjuryDateTime()
	{
		return this.injurydatetime;
	}
	public void setInjuryDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.injurydatetime = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.emergency.vo.EpisodeOfcareLiteVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.emergency.vo.EpisodeOfcareLiteVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getPresentingComplaintIsNotNull()
	{
		return this.presentingcomplaint != null;
	}
	public ims.emergency.vo.lookups.PresentingComplaint getPresentingComplaint()
	{
		return this.presentingcomplaint;
	}
	public void setPresentingComplaint(ims.emergency.vo.lookups.PresentingComplaint value)
	{
		this.isValidated = false;
		this.presentingcomplaint = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.emergency.vo.lookups.PatientCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.emergency.vo.lookups.PatientCategory value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getMedPatientConsentIsNotNull()
	{
		return this.medpatientconsent != null;
	}
	public Boolean getMedPatientConsent()
	{
		return this.medpatientconsent;
	}
	public void setMedPatientConsent(Boolean value)
	{
		this.isValidated = false;
		this.medpatientconsent = value;
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
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
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
	
		EmergencyEpisodeForTriageLiteVo clone = new EmergencyEpisodeForTriageLiteVo(this.id, this.version);
		
		if(this.injurydatetime == null)
			clone.injurydatetime = null;
		else
			clone.injurydatetime = (ims.framework.utils.DateTime)this.injurydatetime.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.emergency.vo.EpisodeOfcareLiteVo)this.episodeofcare.clone();
		if(this.presentingcomplaint == null)
			clone.presentingcomplaint = null;
		else
			clone.presentingcomplaint = (ims.emergency.vo.lookups.PresentingComplaint)this.presentingcomplaint.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.emergency.vo.lookups.PatientCategory)this.category.clone();
		clone.medpatientconsent = this.medpatientconsent;
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
		if (!(EmergencyEpisodeForTriageLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyEpisodeForTriageLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyEpisodeForTriageLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyEpisodeForTriageLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.injurydatetime != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.presentingcomplaint != null)
			count++;
		if(this.category != null)
			count++;
		if(this.medpatientconsent != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.framework.utils.DateTime injurydatetime;
	protected ims.emergency.vo.EpisodeOfcareLiteVo episodeofcare;
	protected ims.emergency.vo.lookups.PresentingComplaint presentingcomplaint;
	protected ims.emergency.vo.lookups.PatientCategory category;
	protected Boolean medpatientconsent;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
