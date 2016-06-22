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
 * Linked to core.admin.pas.PAS Event business object (ID: 1014100003).
 */
public class PASEventForVTERiskAssessmentVo extends ims.core.admin.pas.vo.PASEventRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PASEventForVTERiskAssessmentVo()
	{
	}
	public PASEventForVTERiskAssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public PASEventForVTERiskAssessmentVo(ims.core.vo.beans.PASEventForVTERiskAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PASEventForVTERiskAssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.consultant = bean.getConsultant() == null ? null : bean.getConsultant().buildVo(map);
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PASEventForVTERiskAssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PASEventForVTERiskAssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PASEventForVTERiskAssessmentVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientForVTERiskAssessmentVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientForVTERiskAssessmentVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.vo.MedicLiteVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.vo.MedicLiteVo value)
	{
		this.isValidated = false;
		this.consultant = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.core.vo.LocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
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
		if(this.patient == null)
			listOfErrors.add("patient is mandatory");
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
	
		PASEventForVTERiskAssessmentVo clone = new PASEventForVTERiskAssessmentVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientForVTERiskAssessmentVo)this.patient.clone();
		if(this.consultant == null)
			clone.consultant = null;
		else
			clone.consultant = (ims.core.vo.MedicLiteVo)this.consultant.clone();
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.core.vo.LocationLiteVo)this.location.clone();
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
		if (!(PASEventForVTERiskAssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PASEventForVTERiskAssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PASEventForVTERiskAssessmentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PASEventForVTERiskAssessmentVo)obj).getBoId());
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
		if(this.consultant != null)
			count++;
		if(this.location != null)
			count++;
		if(this.specialty != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.PatientForVTERiskAssessmentVo patient;
	protected ims.core.vo.MedicLiteVo consultant;
	protected ims.core.vo.LocationLiteVo location;
	protected ims.core.vo.lookups.Specialty specialty;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
