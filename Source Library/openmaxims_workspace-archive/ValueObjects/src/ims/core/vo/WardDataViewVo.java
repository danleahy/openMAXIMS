//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;


public class WardDataViewVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardDataViewVo()
	{
	}
	public WardDataViewVo(ims.core.vo.beans.WardDataViewVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo();
		this.bed = bean.getBed() == null ? null : bean.getBed().buildVo();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.inpatepisode = bean.getInpatEpisode() == null ? null : bean.getInpatEpisode().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.WardDataViewVoBean bean)
	{
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.bay = bean.getBay() == null ? null : bean.getBay().buildVo(map);
		this.bed = bean.getBed() == null ? null : bean.getBed().buildVo(map);
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.inpatepisode = bean.getInpatEpisode() == null ? null : bean.getInpatEpisode().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.WardDataViewVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.WardDataViewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.WardDataViewVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getBayIsNotNull()
	{
		return this.bay != null;
	}
	public ims.core.vo.LocationLiteVo getBay()
	{
		return this.bay;
	}
	public void setBay(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.bay = value;
	}
	public boolean getBedIsNotNull()
	{
		return this.bed != null;
	}
	public ims.core.vo.BedSpaceVo getBed()
	{
		return this.bed;
	}
	public void setBed(ims.core.vo.BedSpaceVo value)
	{
		this.isValidated = false;
		this.bed = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventADTVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventADTVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getInpatEpisodeIsNotNull()
	{
		return this.inpatepisode != null;
	}
	public ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo getInpatEpisode()
	{
		return this.inpatepisode;
	}
	public void setInpatEpisode(ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo value)
	{
		this.isValidated = false;
		this.inpatepisode = value;
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
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof WardDataViewVo))
			return false;
		WardDataViewVo compareObj = (WardDataViewVo)obj;
		if(this.getPatient() == null && compareObj.getPatient() != null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() == null)
			return false;
		if(this.getPatient() != null && compareObj.getPatient() != null)
			return this.getPatient().equals(compareObj.getPatient());
		return super.equals(obj);
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
	
		WardDataViewVo clone = new WardDataViewVo();
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.bay == null)
			clone.bay = null;
		else
			clone.bay = (ims.core.vo.LocationLiteVo)this.bay.clone();
		if(this.bed == null)
			clone.bed = null;
		else
			clone.bed = (ims.core.vo.BedSpaceVo)this.bed.clone();
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventADTVo)this.pasevent.clone();
		if(this.inpatepisode == null)
			clone.inpatepisode = null;
		else
			clone.inpatepisode = (ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo)this.inpatepisode.clone();
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
		if (!(WardDataViewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardDataViewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardDataViewVo compareObj = (WardDataViewVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getBay() == null && compareObj.getBay() != null)
				return -1;
			if(this.getBay() != null && compareObj.getBay() == null)
				return 1;
			if(this.getBay() != null && compareObj.getBay() != null)
				retVal = this.getBay().compareTo(compareObj.getBay());
		}
		if (retVal == 0)
		{
			if(this.getPatient() == null && compareObj.getPatient() != null)
				return -1;
			if(this.getPatient() != null && compareObj.getPatient() == null)
				return 1;
			if(this.getPatient() != null && compareObj.getPatient() != null)
				retVal = this.getPatient().compareTo(compareObj.getPatient());
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
		if(this.patient != null)
			count++;
		if(this.bay != null)
			count++;
		if(this.bed != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.inpatepisode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.PatientShort patient;
	protected ims.core.vo.LocationLiteVo bay;
	protected ims.core.vo.BedSpaceVo bed;
	protected ims.core.vo.PasEventADTVo pasevent;
	protected ims.clinical.vo.InpatientEpisodeForVTERiskAsessmentVo inpatepisode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
