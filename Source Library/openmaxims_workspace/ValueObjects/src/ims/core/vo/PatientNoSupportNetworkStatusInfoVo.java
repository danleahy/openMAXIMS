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
 * Linked to core.clinical.PatientNoSupportNetworkStatusInfo business object (ID: 1003100086).
 */
public class PatientNoSupportNetworkStatusInfoVo extends ims.core.clinical.vo.PatientNoSupportNetworkStatusInfoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientNoSupportNetworkStatusInfoVo()
	{
	}
	public PatientNoSupportNetworkStatusInfoVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientNoSupportNetworkStatusInfoVo(ims.core.vo.beans.PatientNoSupportNetworkStatusInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.supportnetworkstatus = bean.getSupportNetworkStatus() == null ? null : ims.core.vo.lookups.PatientSupportNetworkStatus.buildLookup(bean.getSupportNetworkStatus());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientNoSupportNetworkStatusInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.supportnetworkstatus = bean.getSupportNetworkStatus() == null ? null : ims.core.vo.lookups.PatientSupportNetworkStatus.buildLookup(bean.getSupportNetworkStatus());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientNoSupportNetworkStatusInfoVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientNoSupportNetworkStatusInfoVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientNoSupportNetworkStatusInfoVoBean();
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
		if(fieldName.equals("SUPPORTNETWORKSTATUS"))
			return getSupportNetworkStatus();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getSupportNetworkStatusIsNotNull()
	{
		return this.supportnetworkstatus != null;
	}
	public ims.core.vo.lookups.PatientSupportNetworkStatus getSupportNetworkStatus()
	{
		return this.supportnetworkstatus;
	}
	public void setSupportNetworkStatus(ims.core.vo.lookups.PatientSupportNetworkStatus value)
	{
		this.isValidated = false;
		this.supportnetworkstatus = value;
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.supportnetworkstatus == null)
			listOfErrors.add("SupportNetworkStatus is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
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
	
		PatientNoSupportNetworkStatusInfoVo clone = new PatientNoSupportNetworkStatusInfoVo(this.id, this.version);
		
		clone.patient = this.patient;
		if(this.supportnetworkstatus == null)
			clone.supportnetworkstatus = null;
		else
			clone.supportnetworkstatus = (ims.core.vo.lookups.PatientSupportNetworkStatus)this.supportnetworkstatus.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
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
		if (!(PatientNoSupportNetworkStatusInfoVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientNoSupportNetworkStatusInfoVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientNoSupportNetworkStatusInfoVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientNoSupportNetworkStatusInfoVo)obj).getBoId());
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
		if(this.supportnetworkstatus != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.lookups.PatientSupportNetworkStatus supportnetworkstatus;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
