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
 * Linked to core.admin.pas.AdmissionDetail business object (ID: 1014100008).
 */
public class AdmissionDetailLiteWithInpatientEpisodeVo extends ims.core.vo.AdmissionDetailLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdmissionDetailLiteWithInpatientEpisodeVo()
	{
	}
	public AdmissionDetailLiteWithInpatientEpisodeVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdmissionDetailLiteWithInpatientEpisodeVo(ims.core.vo.beans.AdmissionDetailLiteWithInpatientEpisodeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.bed = bean.getBed() == null ? null : bean.getBed().buildVo();
		// Interface field type not supported.
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDateTime();
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : bean.getInpatientEpisode().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AdmissionDetailLiteWithInpatientEpisodeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.bed = bean.getBed() == null ? null : bean.getBed().buildVo(map);
		// Interface field type not supported.
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDateTime();
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : bean.getInpatientEpisode().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AdmissionDetailLiteWithInpatientEpisodeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AdmissionDetailLiteWithInpatientEpisodeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AdmissionDetailLiteWithInpatientEpisodeVoBean();
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
		if(fieldName.equals("INPATIENTEPISODE"))
			return getInpatientEpisode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getInpatientEpisodeIsNotNull()
	{
		return this.inpatientepisode != null;
	}
	public ims.core.vo.InpatientEpisodeBedNumberUpdateVo getInpatientEpisode()
	{
		return this.inpatientepisode;
	}
	public void setInpatientEpisode(ims.core.vo.InpatientEpisodeBedNumberUpdateVo value)
	{
		this.isValidated = false;
		this.inpatientepisode = value;
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
		if(this.pasevent != null)
		{
			if(!this.pasevent.isValidated())
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
		if(this.admissiondatetime == null)
			listOfErrors.add("Admission Date Time is mandatory");
		if(this.consultant == null)
			listOfErrors.add("Consultant is mandatory");
		if(this.specialty == null)
			listOfErrors.add("Specialty is mandatory");
		if(this.pasevent == null)
			listOfErrors.add("pasEvent is mandatory");
		if(this.pasevent != null)
		{
			String[] listOfOtherErrors = this.pasevent.validate();
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
	
		AdmissionDetailLiteWithInpatientEpisodeVo clone = new AdmissionDetailLiteWithInpatientEpisodeVo(this.id, this.version);
		
		if(this.admissiondatetime == null)
			clone.admissiondatetime = null;
		else
			clone.admissiondatetime = (ims.framework.utils.DateTime)this.admissiondatetime.clone();
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.bed == null)
			clone.bed = null;
		else
			clone.bed = (ims.core.vo.BedSpaceVo)this.bed.clone();
		clone.consultant = this.consultant;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventADTVo)this.pasevent.clone();
		if(this.estdischargedate == null)
			clone.estdischargedate = null;
		else
			clone.estdischargedate = (ims.framework.utils.DateTime)this.estdischargedate.clone();
		if(this.inpatientepisode == null)
			clone.inpatientepisode = null;
		else
			clone.inpatientepisode = (ims.core.vo.InpatientEpisodeBedNumberUpdateVo)this.inpatientepisode.clone();
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
		if (!(AdmissionDetailLiteWithInpatientEpisodeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdmissionDetailLiteWithInpatientEpisodeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdmissionDetailLiteWithInpatientEpisodeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdmissionDetailLiteWithInpatientEpisodeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.inpatientepisode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.core.vo.InpatientEpisodeBedNumberUpdateVo inpatientepisode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
