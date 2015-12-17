// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;


public class InpatientClinicalCodingWorklistSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InpatientClinicalCodingWorklistSearchCriteriaVo()
	{
	}
	public InpatientClinicalCodingWorklistSearchCriteriaVo(ims.RefMan.vo.beans.InpatientClinicalCodingWorklistSearchCriteriaVoBean bean)
	{
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.dischargeward = bean.getDischargeWard() == null ? null : bean.getDischargeWard().buildVo();
		// Interface field type not supported.
		this.dischargefrom = bean.getDischargeFrom() == null ? null : bean.getDischargeFrom().buildDate();
		this.dischargeto = bean.getDischargeTo() == null ? null : bean.getDischargeTo().buildDate();
		this.requirescoding = bean.getRequiresCoding();
		this.episodecoded = bean.getEpisodeCoded();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.InpatientClinicalCodingWorklistSearchCriteriaVoBean bean)
	{
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.dischargeward = bean.getDischargeWard() == null ? null : bean.getDischargeWard().buildVo(map);
		// Interface field type not supported.
		this.dischargefrom = bean.getDischargeFrom() == null ? null : bean.getDischargeFrom().buildDate();
		this.dischargeto = bean.getDischargeTo() == null ? null : bean.getDischargeTo().buildDate();
		this.requirescoding = bean.getRequiresCoding();
		this.episodecoded = bean.getEpisodeCoded();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.InpatientClinicalCodingWorklistSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.InpatientClinicalCodingWorklistSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.InpatientClinicalCodingWorklistSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getDischargeWardIsNotNull()
	{
		return this.dischargeward != null;
	}
	public ims.core.vo.LocationLiteVo getDischargeWard()
	{
		return this.dischargeward;
	}
	public void setDischargeWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.dischargeward = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.vo.interfaces.IMos getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getDischargeFromIsNotNull()
	{
		return this.dischargefrom != null;
	}
	public ims.framework.utils.Date getDischargeFrom()
	{
		return this.dischargefrom;
	}
	public void setDischargeFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargefrom = value;
	}
	public boolean getDischargeToIsNotNull()
	{
		return this.dischargeto != null;
	}
	public ims.framework.utils.Date getDischargeTo()
	{
		return this.dischargeto;
	}
	public void setDischargeTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargeto = value;
	}
	public boolean getRequiresCodingIsNotNull()
	{
		return this.requirescoding != null;
	}
	public Boolean getRequiresCoding()
	{
		return this.requirescoding;
	}
	public void setRequiresCoding(Boolean value)
	{
		this.isValidated = false;
		this.requirescoding = value;
	}
	public boolean getEpisodeCodedIsNotNull()
	{
		return this.episodecoded != null;
	}
	public Boolean getEpisodeCoded()
	{
		return this.episodecoded;
	}
	public void setEpisodeCoded(Boolean value)
	{
		this.isValidated = false;
		this.episodecoded = value;
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
		if(!(obj instanceof InpatientClinicalCodingWorklistSearchCriteriaVo))
			return false;
		InpatientClinicalCodingWorklistSearchCriteriaVo compareObj = (InpatientClinicalCodingWorklistSearchCriteriaVo)obj;
		if(this.getSpecialty() == null && compareObj.getSpecialty() != null)
			return false;
		if(this.getSpecialty() != null && compareObj.getSpecialty() == null)
			return false;
		if(this.getSpecialty() != null && compareObj.getSpecialty() != null)
			if(!this.getSpecialty().equals(compareObj.getSpecialty()))
				return false;
		if(this.getDischargeWard() == null && compareObj.getDischargeWard() != null)
			return false;
		if(this.getDischargeWard() != null && compareObj.getDischargeWard() == null)
			return false;
		if(this.getDischargeWard() != null && compareObj.getDischargeWard() != null)
			if(!this.getDischargeWard().equals(compareObj.getDischargeWard()))
				return false;
		if(this.getConsultant() == null && compareObj.getConsultant() != null)
			return false;
		if(this.getConsultant() != null && compareObj.getConsultant() == null)
			return false;
		if(this.getConsultant() != null && compareObj.getConsultant() != null)
			if(!this.getConsultant().equals(compareObj.getConsultant()))
				return false;
		if(this.getDischargeFrom() == null && compareObj.getDischargeFrom() != null)
			return false;
		if(this.getDischargeFrom() != null && compareObj.getDischargeFrom() == null)
			return false;
		if(this.getDischargeFrom() != null && compareObj.getDischargeFrom() != null)
			if(!this.getDischargeFrom().equals(compareObj.getDischargeFrom()))
				return false;
		if(this.getDischargeTo() == null && compareObj.getDischargeTo() != null)
			return false;
		if(this.getDischargeTo() != null && compareObj.getDischargeTo() == null)
			return false;
		if(this.getDischargeTo() != null && compareObj.getDischargeTo() != null)
			if(!this.getDischargeTo().equals(compareObj.getDischargeTo()))
				return false;
		if(this.getRequiresCoding() == null && compareObj.getRequiresCoding() != null)
			return false;
		if(this.getRequiresCoding() != null && compareObj.getRequiresCoding() == null)
			return false;
		if(this.getRequiresCoding() != null && compareObj.getRequiresCoding() != null)
			if(!this.getRequiresCoding().equals(compareObj.getRequiresCoding()))
				return false;
		if(this.getEpisodeCoded() == null && compareObj.getEpisodeCoded() != null)
			return false;
		if(this.getEpisodeCoded() != null && compareObj.getEpisodeCoded() == null)
			return false;
		if(this.getEpisodeCoded() != null && compareObj.getEpisodeCoded() != null)
			return this.getEpisodeCoded().equals(compareObj.getEpisodeCoded());
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
	
		InpatientClinicalCodingWorklistSearchCriteriaVo clone = new InpatientClinicalCodingWorklistSearchCriteriaVo();
		
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.dischargeward == null)
			clone.dischargeward = null;
		else
			clone.dischargeward = (ims.core.vo.LocationLiteVo)this.dischargeward.clone();
		clone.consultant = this.consultant;
		if(this.dischargefrom == null)
			clone.dischargefrom = null;
		else
			clone.dischargefrom = (ims.framework.utils.Date)this.dischargefrom.clone();
		if(this.dischargeto == null)
			clone.dischargeto = null;
		else
			clone.dischargeto = (ims.framework.utils.Date)this.dischargeto.clone();
		clone.requirescoding = this.requirescoding;
		clone.episodecoded = this.episodecoded;
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
		if (!(InpatientClinicalCodingWorklistSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InpatientClinicalCodingWorklistSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		InpatientClinicalCodingWorklistSearchCriteriaVo compareObj = (InpatientClinicalCodingWorklistSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSpecialty() == null && compareObj.getSpecialty() != null)
				return -1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() == null)
				return 1;
			if(this.getSpecialty() != null && compareObj.getSpecialty() != null)
				retVal = this.getSpecialty().compareTo(compareObj.getSpecialty());
		}
		if (retVal == 0)
		{
			if(this.getDischargeWard() == null && compareObj.getDischargeWard() != null)
				return -1;
			if(this.getDischargeWard() != null && compareObj.getDischargeWard() == null)
				return 1;
			if(this.getDischargeWard() != null && compareObj.getDischargeWard() != null)
				retVal = this.getDischargeWard().compareTo(compareObj.getDischargeWard());
		}
		if (retVal == 0)
		{
			if(this.getConsultant() == null && compareObj.getConsultant() != null)
				return -1;
			if(this.getConsultant() != null && compareObj.getConsultant() == null)
				return 1;
			if(this.getConsultant() != null && compareObj.getConsultant() != null)
				retVal = this.getConsultant().compareTo(compareObj.getConsultant());
		}
		if (retVal == 0)
		{
			if(this.getDischargeFrom() == null && compareObj.getDischargeFrom() != null)
				return -1;
			if(this.getDischargeFrom() != null && compareObj.getDischargeFrom() == null)
				return 1;
			if(this.getDischargeFrom() != null && compareObj.getDischargeFrom() != null)
				retVal = this.getDischargeFrom().compareTo(compareObj.getDischargeFrom());
		}
		if (retVal == 0)
		{
			if(this.getDischargeTo() == null && compareObj.getDischargeTo() != null)
				return -1;
			if(this.getDischargeTo() != null && compareObj.getDischargeTo() == null)
				return 1;
			if(this.getDischargeTo() != null && compareObj.getDischargeTo() != null)
				retVal = this.getDischargeTo().compareTo(compareObj.getDischargeTo());
		}
		if (retVal == 0)
		{
			if(this.getRequiresCoding() == null && compareObj.getRequiresCoding() != null)
				return -1;
			if(this.getRequiresCoding() != null && compareObj.getRequiresCoding() == null)
				return 1;
			if(this.getRequiresCoding() != null && compareObj.getRequiresCoding() != null)
				retVal = this.getRequiresCoding().compareTo(compareObj.getRequiresCoding());
		}
		if (retVal == 0)
		{
			if(this.getEpisodeCoded() == null && compareObj.getEpisodeCoded() != null)
				return -1;
			if(this.getEpisodeCoded() != null && compareObj.getEpisodeCoded() == null)
				return 1;
			if(this.getEpisodeCoded() != null && compareObj.getEpisodeCoded() != null)
				retVal = this.getEpisodeCoded().compareTo(compareObj.getEpisodeCoded());
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
		if(this.specialty != null)
			count++;
		if(this.dischargeward != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.dischargefrom != null)
			count++;
		if(this.dischargeto != null)
			count++;
		if(this.requirescoding != null)
			count++;
		if(this.episodecoded != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.LocationLiteVo dischargeward;
	protected ims.vo.interfaces.IMos consultant;
	protected ims.framework.utils.Date dischargefrom;
	protected ims.framework.utils.Date dischargeto;
	protected Boolean requirescoding;
	protected Boolean episodecoded;
	private boolean isValidated = false;
	private boolean isBusy = false;
}