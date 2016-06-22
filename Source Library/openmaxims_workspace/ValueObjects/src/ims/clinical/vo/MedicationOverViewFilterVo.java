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

package ims.clinical.vo;

/**
 * Linked to clinical.MedicationOverview business object (ID: 1072100034).
 */
public class MedicationOverViewFilterVo extends ims.clinical.vo.MedicationOverviewRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MedicationOverViewFilterVo()
	{
	}
	public MedicationOverViewFilterVo(Integer id, int version)
	{
		super(id, version);
	}
	public MedicationOverViewFilterVo(ims.clinical.vo.beans.MedicationOverViewFilterVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.clinical.vo.lookups.MedicationSnapShot.buildLookup(bean.getType());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.patientref = bean.getPatientRef() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatientRef().getId()), bean.getPatientRef().getVersion());
		this.filter = bean.getFilter();
		this.selectedmedication = bean.getSelectedMedication() == null ? null : bean.getSelectedMedication().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.MedicationOverViewFilterVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.type = bean.getType() == null ? null : ims.clinical.vo.lookups.MedicationSnapShot.buildLookup(bean.getType());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.patientref = bean.getPatientRef() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatientRef().getId()), bean.getPatientRef().getVersion());
		this.filter = bean.getFilter();
		this.selectedmedication = bean.getSelectedMedication() == null ? null : bean.getSelectedMedication().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.MedicationOverViewFilterVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.MedicationOverViewFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.MedicationOverViewFilterVoBean();
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
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("PATIENTREF"))
			return getPatientRef();
		if(fieldName.equals("FILTER"))
			return getFilter();
		if(fieldName.equals("SELECTEDMEDICATION"))
			return getSelectedMedication();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.clinical.vo.lookups.MedicationSnapShot getType()
	{
		return this.type;
	}
	public void setType(ims.clinical.vo.lookups.MedicationSnapShot value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getPatientRefIsNotNull()
	{
		return this.patientref != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatientRef()
	{
		return this.patientref;
	}
	public void setPatientRef(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patientref = value;
	}
	public boolean getFilterIsNotNull()
	{
		return this.filter != null;
	}
	public Boolean getFilter()
	{
		return this.filter;
	}
	public void setFilter(Boolean value)
	{
		this.isValidated = false;
		this.filter = value;
	}
	public boolean getSelectedMedicationIsNotNull()
	{
		return this.selectedmedication != null;
	}
	public ims.clinical.vo.MedicationOverViewLiteVo getSelectedMedication()
	{
		return this.selectedmedication;
	}
	public void setSelectedMedication(ims.clinical.vo.MedicationOverViewLiteVo value)
	{
		this.isValidated = false;
		this.selectedmedication = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		MedicationOverViewFilterVo clone = new MedicationOverViewFilterVo(this.id, this.version);
		
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.clinical.vo.lookups.MedicationSnapShot)this.type.clone();
		clone.carecontext = this.carecontext;
		clone.patientref = this.patientref;
		clone.filter = this.filter;
		if(this.selectedmedication == null)
			clone.selectedmedication = null;
		else
			clone.selectedmedication = (ims.clinical.vo.MedicationOverViewLiteVo)this.selectedmedication.clone();
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
		if (!(MedicationOverViewFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MedicationOverViewFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MedicationOverViewFilterVo compareObj = (MedicationOverViewFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_MedicationOverview() == null && compareObj.getID_MedicationOverview() != null)
				return -1;
			if(this.getID_MedicationOverview() != null && compareObj.getID_MedicationOverview() == null)
				return 1;
			if(this.getID_MedicationOverview() != null && compareObj.getID_MedicationOverview() != null)
				retVal = this.getID_MedicationOverview().compareTo(compareObj.getID_MedicationOverview());
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
		if(this.type != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.patientref != null)
			count++;
		if(this.filter != null)
			count++;
		if(this.selectedmedication != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.clinical.vo.lookups.MedicationSnapShot type;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.patient.vo.PatientRefVo patientref;
	protected Boolean filter;
	protected ims.clinical.vo.MedicationOverViewLiteVo selectedmedication;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
