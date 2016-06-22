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

package ims.generalmedical.vo;


public class AdmisExamGeneralVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdmisExamGeneralVo()
	{
	}
	public AdmisExamGeneralVo(ims.generalmedical.vo.beans.AdmisExamGeneralVoBean bean)
	{
		this.genexaminationdet = bean.getGenExaminationDet() == null ? null : bean.getGenExaminationDet().buildVo();
		this.problemsonadmission = ims.generalmedical.vo.MedicalProbOnAdmisVoCollection.buildFromBeanCollection(bean.getProblemsOnAdmission());
		this.vitalssignsrecorded = bean.getVitalssignsrecorded() == null ? null : bean.getVitalssignsrecorded().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.AdmisExamGeneralVoBean bean)
	{
		this.genexaminationdet = bean.getGenExaminationDet() == null ? null : bean.getGenExaminationDet().buildVo(map);
		this.problemsonadmission = ims.generalmedical.vo.MedicalProbOnAdmisVoCollection.buildFromBeanCollection(bean.getProblemsOnAdmission());
		this.vitalssignsrecorded = bean.getVitalssignsrecorded() == null ? null : bean.getVitalssignsrecorded().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.AdmisExamGeneralVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.AdmisExamGeneralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.AdmisExamGeneralVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getGenExaminationDetIsNotNull()
	{
		return this.genexaminationdet != null;
	}
	public ims.generalmedical.vo.MedExamGeneralVo getGenExaminationDet()
	{
		return this.genexaminationdet;
	}
	public void setGenExaminationDet(ims.generalmedical.vo.MedExamGeneralVo value)
	{
		this.isValidated = false;
		this.genexaminationdet = value;
	}
	public boolean getProblemsOnAdmissionIsNotNull()
	{
		return this.problemsonadmission != null;
	}
	public ims.generalmedical.vo.MedicalProbOnAdmisVoCollection getProblemsOnAdmission()
	{
		return this.problemsonadmission;
	}
	public void setProblemsOnAdmission(ims.generalmedical.vo.MedicalProbOnAdmisVoCollection value)
	{
		this.isValidated = false;
		this.problemsonadmission = value;
	}
	public boolean getVitalssignsrecordedIsNotNull()
	{
		return this.vitalssignsrecorded != null;
	}
	public ims.core.vo.VitalSignsVo getVitalssignsrecorded()
	{
		return this.vitalssignsrecorded;
	}
	public void setVitalssignsrecorded(ims.core.vo.VitalSignsVo value)
	{
		this.isValidated = false;
		this.vitalssignsrecorded = value;
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
		if(!(obj instanceof AdmisExamGeneralVo))
			return false;
		AdmisExamGeneralVo compareObj = (AdmisExamGeneralVo)obj;
		if(this.getGenExaminationDet() == null && compareObj.getGenExaminationDet() != null)
			return false;
		if(this.getGenExaminationDet() != null && compareObj.getGenExaminationDet() == null)
			return false;
		if(this.getGenExaminationDet() != null && compareObj.getGenExaminationDet() != null)
			return this.getGenExaminationDet().equals(compareObj.getGenExaminationDet());
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
		if(this.genexaminationdet != null)
		{
			if(!this.genexaminationdet.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.problemsonadmission != null)
		{
			if(!this.problemsonadmission.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.vitalssignsrecorded != null)
		{
			if(!this.vitalssignsrecorded.isValidated())
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
		if(this.genexaminationdet != null)
		{
			String[] listOfOtherErrors = this.genexaminationdet.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.problemsonadmission != null)
		{
			String[] listOfOtherErrors = this.problemsonadmission.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.vitalssignsrecorded != null)
		{
			String[] listOfOtherErrors = this.vitalssignsrecorded.validate();
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		AdmisExamGeneralVo clone = new AdmisExamGeneralVo();
		
		if(this.genexaminationdet == null)
			clone.genexaminationdet = null;
		else
			clone.genexaminationdet = (ims.generalmedical.vo.MedExamGeneralVo)this.genexaminationdet.clone();
		if(this.problemsonadmission == null)
			clone.problemsonadmission = null;
		else
			clone.problemsonadmission = (ims.generalmedical.vo.MedicalProbOnAdmisVoCollection)this.problemsonadmission.clone();
		if(this.vitalssignsrecorded == null)
			clone.vitalssignsrecorded = null;
		else
			clone.vitalssignsrecorded = (ims.core.vo.VitalSignsVo)this.vitalssignsrecorded.clone();
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
		if (!(AdmisExamGeneralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdmisExamGeneralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AdmisExamGeneralVo compareObj = (AdmisExamGeneralVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getGenExaminationDet() == null && compareObj.getGenExaminationDet() != null)
				return -1;
			if(this.getGenExaminationDet() != null && compareObj.getGenExaminationDet() == null)
				return 1;
			if(this.getGenExaminationDet() != null && compareObj.getGenExaminationDet() != null)
				retVal = this.getGenExaminationDet().compareTo(compareObj.getGenExaminationDet());
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
		if(this.genexaminationdet != null)
			count++;
		if(this.problemsonadmission != null)
			count++;
		if(this.vitalssignsrecorded != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.generalmedical.vo.MedExamGeneralVo genexaminationdet;
	protected ims.generalmedical.vo.MedicalProbOnAdmisVoCollection problemsonadmission;
	protected ims.core.vo.VitalSignsVo vitalssignsrecorded;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
