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
 * Linked to core.resource.people.Hcp business object (ID: 1006100000).
 */
public class TherapistVo extends ims.core.vo.Hcp implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHcp
{
	private static final long serialVersionUID = 1L;

	public TherapistVo()
	{
	}
	public TherapistVo(Integer id, int version)
	{
		super(id, version);
	}
	public TherapistVo(ims.core.vo.beans.TherapistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcptype = bean.getHcpType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHcpType());
		this.queryname = bean.getQueryName() == null ? null : bean.getQueryName().buildVo();
		this.isactive = bean.getIsActive();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo();
		this.ishcparesponsiblehcp = bean.getIsHCPaResponsibleHCP();
		this.isalocalconsultant = bean.getIsALocalConsultant();
		this.isaresponsibleedclinician = bean.getIsAResponsibleEDClinician();
		this.ishcpaendoscopist = bean.getIsHCPaEndoscopist();
		this.therapisttype = bean.getTherapistType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getTherapistType());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.TherapistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hcptype = bean.getHcpType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHcpType());
		this.queryname = bean.getQueryName() == null ? null : bean.getQueryName().buildVo(map);
		this.isactive = bean.getIsActive();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo(map);
		this.ishcparesponsiblehcp = bean.getIsHCPaResponsibleHCP();
		this.isalocalconsultant = bean.getIsALocalConsultant();
		this.isaresponsibleedclinician = bean.getIsAResponsibleEDClinician();
		this.ishcpaendoscopist = bean.getIsHCPaEndoscopist();
		this.therapisttype = bean.getTherapistType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getTherapistType());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.TherapistVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.TherapistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.TherapistVoBean();
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
		if(fieldName.equals("THERAPISTTYPE"))
			return getTherapistType();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTherapistTypeIsNotNull()
	{
		return this.therapisttype != null;
	}
	public ims.core.vo.lookups.HcpDisType getTherapistType()
	{
		return this.therapisttype;
	}
	public void setTherapistType(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.therapisttype = value;
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
		if(this.queryname != null)
		{
			if(!this.queryname.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.mos != null)
		{
			if(!this.mos.isValidated())
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
		if(this.queryname != null)
		{
			String[] listOfOtherErrors = this.queryname.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.mos != null)
		{
			String[] listOfOtherErrors = this.mos.validate();
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
	
		TherapistVo clone = new TherapistVo(this.id, this.version);
		
		if(this.hcptype == null)
			clone.hcptype = null;
		else
			clone.hcptype = (ims.core.vo.lookups.HcpDisType)this.hcptype.clone();
		if(this.queryname == null)
			clone.queryname = null;
		else
			clone.queryname = (ims.core.vo.PersonName)this.queryname.clone();
		clone.isactive = this.isactive;
		if(this.mos == null)
			clone.mos = null;
		else
			clone.mos = (ims.core.vo.MemberOfStaffShortVo)this.mos.clone();
		clone.ishcparesponsiblehcp = this.ishcparesponsiblehcp;
		clone.isalocalconsultant = this.isalocalconsultant;
		clone.isaresponsibleedclinician = this.isaresponsibleedclinician;
		clone.ishcpaendoscopist = this.ishcpaendoscopist;
		if(this.therapisttype == null)
			clone.therapisttype = null;
		else
			clone.therapisttype = (ims.core.vo.lookups.HcpDisType)this.therapisttype.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
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
		if (!(TherapistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TherapistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TherapistVo compareObj = (TherapistVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMos() == null && compareObj.getMos() != null)
				return -1;
			if(this.getMos() != null && compareObj.getMos() == null)
				return 1;
			if(this.getMos() != null && compareObj.getMos() != null)
				retVal = this.getMos().compareTo(compareObj.getMos());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.therapisttype != null)
			count++;
		if(this.specialty != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.core.vo.lookups.HcpDisType therapisttype;
	protected ims.core.vo.lookups.Specialty specialty;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
