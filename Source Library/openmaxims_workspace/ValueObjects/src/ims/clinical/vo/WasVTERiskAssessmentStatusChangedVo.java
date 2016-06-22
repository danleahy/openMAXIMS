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


public class WasVTERiskAssessmentStatusChangedVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WasVTERiskAssessmentStatusChangedVo()
	{
	}
	public WasVTERiskAssessmentStatusChangedVo(ims.clinical.vo.beans.WasVTERiskAssessmentStatusChangedVoBean bean)
	{
		this.wasstatuschanged = bean.getWasStatusChanged();
		this.vtestatus = bean.getVTEStatus() == null ? null : ims.clinical.vo.lookups.VTEAsessmentStatus.buildLookup(bean.getVTEStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.WasVTERiskAssessmentStatusChangedVoBean bean)
	{
		this.wasstatuschanged = bean.getWasStatusChanged();
		this.vtestatus = bean.getVTEStatus() == null ? null : ims.clinical.vo.lookups.VTEAsessmentStatus.buildLookup(bean.getVTEStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.WasVTERiskAssessmentStatusChangedVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.WasVTERiskAssessmentStatusChangedVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.WasVTERiskAssessmentStatusChangedVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getWasStatusChangedIsNotNull()
	{
		return this.wasstatuschanged != null;
	}
	public Boolean getWasStatusChanged()
	{
		return this.wasstatuschanged;
	}
	public void setWasStatusChanged(Boolean value)
	{
		this.isValidated = false;
		this.wasstatuschanged = value;
	}
	public boolean getVTEStatusIsNotNull()
	{
		return this.vtestatus != null;
	}
	public ims.clinical.vo.lookups.VTEAsessmentStatus getVTEStatus()
	{
		return this.vtestatus;
	}
	public void setVTEStatus(ims.clinical.vo.lookups.VTEAsessmentStatus value)
	{
		this.isValidated = false;
		this.vtestatus = value;
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
		if(!(obj instanceof WasVTERiskAssessmentStatusChangedVo))
			return false;
		WasVTERiskAssessmentStatusChangedVo compareObj = (WasVTERiskAssessmentStatusChangedVo)obj;
		if(this.getWasStatusChanged() == null && compareObj.getWasStatusChanged() != null)
			return false;
		if(this.getWasStatusChanged() != null && compareObj.getWasStatusChanged() == null)
			return false;
		if(this.getWasStatusChanged() != null && compareObj.getWasStatusChanged() != null)
			if(!this.getWasStatusChanged().equals(compareObj.getWasStatusChanged()))
				return false;
		if(this.getVTEStatus() == null && compareObj.getVTEStatus() != null)
			return false;
		if(this.getVTEStatus() != null && compareObj.getVTEStatus() == null)
			return false;
		if(this.getVTEStatus() != null && compareObj.getVTEStatus() != null)
			return this.getVTEStatus().equals(compareObj.getVTEStatus());
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
	
		WasVTERiskAssessmentStatusChangedVo clone = new WasVTERiskAssessmentStatusChangedVo();
		
		clone.wasstatuschanged = this.wasstatuschanged;
		if(this.vtestatus == null)
			clone.vtestatus = null;
		else
			clone.vtestatus = (ims.clinical.vo.lookups.VTEAsessmentStatus)this.vtestatus.clone();
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
		if (!(WasVTERiskAssessmentStatusChangedVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WasVTERiskAssessmentStatusChangedVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WasVTERiskAssessmentStatusChangedVo compareObj = (WasVTERiskAssessmentStatusChangedVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getWasStatusChanged() == null && compareObj.getWasStatusChanged() != null)
				return -1;
			if(this.getWasStatusChanged() != null && compareObj.getWasStatusChanged() == null)
				return 1;
			if(this.getWasStatusChanged() != null && compareObj.getWasStatusChanged() != null)
				retVal = this.getWasStatusChanged().compareTo(compareObj.getWasStatusChanged());
		}
		if (retVal == 0)
		{
			if(this.getVTEStatus() == null && compareObj.getVTEStatus() != null)
				return -1;
			if(this.getVTEStatus() != null && compareObj.getVTEStatus() == null)
				return 1;
			if(this.getVTEStatus() != null && compareObj.getVTEStatus() != null)
				retVal = this.getVTEStatus().compareTo(compareObj.getVTEStatus());
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
		if(this.wasstatuschanged != null)
			count++;
		if(this.vtestatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected Boolean wasstatuschanged;
	protected ims.clinical.vo.lookups.VTEAsessmentStatus vtestatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
