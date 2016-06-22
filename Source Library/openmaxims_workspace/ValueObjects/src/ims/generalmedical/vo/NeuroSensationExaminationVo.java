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


public class NeuroSensationExaminationVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NeuroSensationExaminationVo()
	{
	}
	public NeuroSensationExaminationVo(ims.generalmedical.vo.beans.NeuroSensationExaminationVoBean bean)
	{
		this.neurosens = bean.getNeuroSens() == null ? null : bean.getNeuroSens().buildVo();
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.beans.NeuroSensationExaminationVoBean bean)
	{
		this.neurosens = bean.getNeuroSens() == null ? null : bean.getNeuroSens().buildVo(map);
		this.problem = bean.getProblem() == null ? null : bean.getProblem().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.beans.NeuroSensationExaminationVoBean bean = null;
		if(map != null)
			bean = (ims.generalmedical.vo.beans.NeuroSensationExaminationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.generalmedical.vo.beans.NeuroSensationExaminationVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getNeuroSensIsNotNull()
	{
		return this.neurosens != null;
	}
	public ims.generalmedical.vo.NeuroSenastionFindingsVo getNeuroSens()
	{
		return this.neurosens;
	}
	public void setNeuroSens(ims.generalmedical.vo.NeuroSenastionFindingsVo value)
	{
		this.isValidated = false;
		this.neurosens = value;
	}
	public boolean getProblemIsNotNull()
	{
		return this.problem != null;
	}
	public ims.generalmedical.vo.MedicalProbOnAdmisVo getProblem()
	{
		return this.problem;
	}
	public void setProblem(ims.generalmedical.vo.MedicalProbOnAdmisVo value)
	{
		this.isValidated = false;
		this.problem = value;
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
		if(!(obj instanceof NeuroSensationExaminationVo))
			return false;
		NeuroSensationExaminationVo compareObj = (NeuroSensationExaminationVo)obj;
		if(this.getNeuroSens() == null && compareObj.getNeuroSens() != null)
			return false;
		if(this.getNeuroSens() != null && compareObj.getNeuroSens() == null)
			return false;
		if(this.getNeuroSens() != null && compareObj.getNeuroSens() != null)
			return this.getNeuroSens().equals(compareObj.getNeuroSens());
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
		if(this.neurosens != null)
		{
			if(!this.neurosens.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.problem != null)
		{
			if(!this.problem.isValidated())
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
		if(this.neurosens != null)
		{
			String[] listOfOtherErrors = this.neurosens.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.problem != null)
		{
			String[] listOfOtherErrors = this.problem.validate();
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
	
		NeuroSensationExaminationVo clone = new NeuroSensationExaminationVo();
		
		if(this.neurosens == null)
			clone.neurosens = null;
		else
			clone.neurosens = (ims.generalmedical.vo.NeuroSenastionFindingsVo)this.neurosens.clone();
		if(this.problem == null)
			clone.problem = null;
		else
			clone.problem = (ims.generalmedical.vo.MedicalProbOnAdmisVo)this.problem.clone();
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
		if (!(NeuroSensationExaminationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NeuroSensationExaminationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NeuroSensationExaminationVo compareObj = (NeuroSensationExaminationVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getNeuroSens() == null && compareObj.getNeuroSens() != null)
				return -1;
			if(this.getNeuroSens() != null && compareObj.getNeuroSens() == null)
				return 1;
			if(this.getNeuroSens() != null && compareObj.getNeuroSens() != null)
				retVal = this.getNeuroSens().compareTo(compareObj.getNeuroSens());
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
		if(this.neurosens != null)
			count++;
		if(this.problem != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.generalmedical.vo.NeuroSenastionFindingsVo neurosens;
	protected ims.generalmedical.vo.MedicalProbOnAdmisVo problem;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
