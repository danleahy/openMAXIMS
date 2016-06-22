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

package ims.oncology.vo;

/**
 * Linked to Oncology.ChemoDosageDetails business object (ID: 1074100035).
 */
public class ChemoDosageDetailsVo extends ims.oncology.vo.ChemoDosageDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemoDosageDetailsVo()
	{
	}
	public ChemoDosageDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemoDosageDetailsVo(ims.oncology.vo.beans.ChemoDosageDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patientmedication = bean.getPatientMedication() == null ? null : bean.getPatientMedication().buildVo();
		this.numberdoses = bean.getNumberDoses();
		this.providerorganisation = bean.getProviderOrganisation() == null ? null : ims.oncology.vo.lookups.ChemoProviderOrg.buildLookup(bean.getProviderOrganisation());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ChemoDosageDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patientmedication = bean.getPatientMedication() == null ? null : bean.getPatientMedication().buildVo(map);
		this.numberdoses = bean.getNumberDoses();
		this.providerorganisation = bean.getProviderOrganisation() == null ? null : ims.oncology.vo.lookups.ChemoProviderOrg.buildLookup(bean.getProviderOrganisation());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ChemoDosageDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ChemoDosageDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ChemoDosageDetailsVoBean();
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
		if(fieldName.equals("PATIENTMEDICATION"))
			return getPatientMedication();
		if(fieldName.equals("NUMBERDOSES"))
			return getNumberDoses();
		if(fieldName.equals("PROVIDERORGANISATION"))
			return getProviderOrganisation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientMedicationIsNotNull()
	{
		return this.patientmedication != null;
	}
	public ims.core.vo.PatientMedicationLiteVo getPatientMedication()
	{
		return this.patientmedication;
	}
	public void setPatientMedication(ims.core.vo.PatientMedicationLiteVo value)
	{
		this.isValidated = false;
		this.patientmedication = value;
	}
	public boolean getNumberDosesIsNotNull()
	{
		return this.numberdoses != null;
	}
	public Integer getNumberDoses()
	{
		return this.numberdoses;
	}
	public void setNumberDoses(Integer value)
	{
		this.isValidated = false;
		this.numberdoses = value;
	}
	public boolean getProviderOrganisationIsNotNull()
	{
		return this.providerorganisation != null;
	}
	public ims.oncology.vo.lookups.ChemoProviderOrg getProviderOrganisation()
	{
		return this.providerorganisation;
	}
	public void setProviderOrganisation(ims.oncology.vo.lookups.ChemoProviderOrg value)
	{
		this.isValidated = false;
		this.providerorganisation = value;
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
		if(this.patientmedication != null)
		{
			if(!this.patientmedication.isValidated())
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
		if(this.patientmedication == null)
			listOfErrors.add("PatientMedication is mandatory");
		if(this.patientmedication != null)
		{
			String[] listOfOtherErrors = this.patientmedication.validate();
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
	
		ChemoDosageDetailsVo clone = new ChemoDosageDetailsVo(this.id, this.version);
		
		if(this.patientmedication == null)
			clone.patientmedication = null;
		else
			clone.patientmedication = (ims.core.vo.PatientMedicationLiteVo)this.patientmedication.clone();
		clone.numberdoses = this.numberdoses;
		if(this.providerorganisation == null)
			clone.providerorganisation = null;
		else
			clone.providerorganisation = (ims.oncology.vo.lookups.ChemoProviderOrg)this.providerorganisation.clone();
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
		if (!(ChemoDosageDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemoDosageDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ChemoDosageDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ChemoDosageDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patientmedication != null)
			count++;
		if(this.numberdoses != null)
			count++;
		if(this.providerorganisation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.PatientMedicationLiteVo patientmedication;
	protected Integer numberdoses;
	protected ims.oncology.vo.lookups.ChemoProviderOrg providerorganisation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
