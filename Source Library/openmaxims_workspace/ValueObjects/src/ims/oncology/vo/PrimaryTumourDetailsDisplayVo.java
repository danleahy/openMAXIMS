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
 * Linked to Oncology.PrimaryTumourDetails business object (ID: 1074100007).
 */
public class PrimaryTumourDetailsDisplayVo extends ims.oncology.vo.PrimaryTumourDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PrimaryTumourDetailsDisplayVo()
	{
	}
	public PrimaryTumourDetailsDisplayVo(Integer id, int version)
	{
		super(id, version);
	}
	public PrimaryTumourDetailsDisplayVo(ims.oncology.vo.beans.PrimaryTumourDetailsDisplayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tumourgroup = bean.getTumourGroup() == null ? null : bean.getTumourGroup().buildVo();
		this.pretreatmenttval = bean.getPreTreatmentTVal() == null ? null : bean.getPreTreatmentTVal().buildVo();
		this.pretreatmentnval = bean.getPreTreatmentNVal() == null ? null : bean.getPreTreatmentNVal().buildVo();
		this.pretreatmentmval = bean.getPreTreatmentMVal() == null ? null : bean.getPreTreatmentMVal().buildVo();
		this.pretreatmentoverall = bean.getPreTreatmentOverall() == null ? null : bean.getPreTreatmentOverall().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.PrimaryTumourDetailsDisplayVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tumourgroup = bean.getTumourGroup() == null ? null : bean.getTumourGroup().buildVo(map);
		this.pretreatmenttval = bean.getPreTreatmentTVal() == null ? null : bean.getPreTreatmentTVal().buildVo(map);
		this.pretreatmentnval = bean.getPreTreatmentNVal() == null ? null : bean.getPreTreatmentNVal().buildVo(map);
		this.pretreatmentmval = bean.getPreTreatmentMVal() == null ? null : bean.getPreTreatmentMVal().buildVo(map);
		this.pretreatmentoverall = bean.getPreTreatmentOverall() == null ? null : bean.getPreTreatmentOverall().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.PrimaryTumourDetailsDisplayVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.PrimaryTumourDetailsDisplayVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.PrimaryTumourDetailsDisplayVoBean();
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
		if(fieldName.equals("TUMOURGROUP"))
			return getTumourGroup();
		if(fieldName.equals("PRETREATMENTTVAL"))
			return getPreTreatmentTVal();
		if(fieldName.equals("PRETREATMENTNVAL"))
			return getPreTreatmentNVal();
		if(fieldName.equals("PRETREATMENTMVAL"))
			return getPreTreatmentMVal();
		if(fieldName.equals("PRETREATMENTOVERALL"))
			return getPreTreatmentOverall();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTumourGroupIsNotNull()
	{
		return this.tumourgroup != null;
	}
	public ims.clinicaladmin.vo.TumourGroupLiteVo getTumourGroup()
	{
		return this.tumourgroup;
	}
	public void setTumourGroup(ims.clinicaladmin.vo.TumourGroupLiteVo value)
	{
		this.isValidated = false;
		this.tumourgroup = value;
	}
	public boolean getPreTreatmentTValIsNotNull()
	{
		return this.pretreatmenttval != null;
	}
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo getPreTreatmentTVal()
	{
		return this.pretreatmenttval;
	}
	public void setPreTreatmentTVal(ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo value)
	{
		this.isValidated = false;
		this.pretreatmenttval = value;
	}
	public boolean getPreTreatmentNValIsNotNull()
	{
		return this.pretreatmentnval != null;
	}
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo getPreTreatmentNVal()
	{
		return this.pretreatmentnval;
	}
	public void setPreTreatmentNVal(ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo value)
	{
		this.isValidated = false;
		this.pretreatmentnval = value;
	}
	public boolean getPreTreatmentMValIsNotNull()
	{
		return this.pretreatmentmval != null;
	}
	public ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo getPreTreatmentMVal()
	{
		return this.pretreatmentmval;
	}
	public void setPreTreatmentMVal(ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo value)
	{
		this.isValidated = false;
		this.pretreatmentmval = value;
	}
	public boolean getPreTreatmentOverallIsNotNull()
	{
		return this.pretreatmentoverall != null;
	}
	public ims.clinicaladmin.vo.TumourGroupSiteOverallStagingLiteVo getPreTreatmentOverall()
	{
		return this.pretreatmentoverall;
	}
	public void setPreTreatmentOverall(ims.clinicaladmin.vo.TumourGroupSiteOverallStagingLiteVo value)
	{
		this.isValidated = false;
		this.pretreatmentoverall = value;
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
		if(this.tumourgroup == null)
			listOfErrors.add("TumourGroup is mandatory");
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
	
		PrimaryTumourDetailsDisplayVo clone = new PrimaryTumourDetailsDisplayVo(this.id, this.version);
		
		if(this.tumourgroup == null)
			clone.tumourgroup = null;
		else
			clone.tumourgroup = (ims.clinicaladmin.vo.TumourGroupLiteVo)this.tumourgroup.clone();
		if(this.pretreatmenttval == null)
			clone.pretreatmenttval = null;
		else
			clone.pretreatmenttval = (ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo)this.pretreatmenttval.clone();
		if(this.pretreatmentnval == null)
			clone.pretreatmentnval = null;
		else
			clone.pretreatmentnval = (ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo)this.pretreatmentnval.clone();
		if(this.pretreatmentmval == null)
			clone.pretreatmentmval = null;
		else
			clone.pretreatmentmval = (ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo)this.pretreatmentmval.clone();
		if(this.pretreatmentoverall == null)
			clone.pretreatmentoverall = null;
		else
			clone.pretreatmentoverall = (ims.clinicaladmin.vo.TumourGroupSiteOverallStagingLiteVo)this.pretreatmentoverall.clone();
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
		if (!(PrimaryTumourDetailsDisplayVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PrimaryTumourDetailsDisplayVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PrimaryTumourDetailsDisplayVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PrimaryTumourDetailsDisplayVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.tumourgroup != null)
			count++;
		if(this.pretreatmenttval != null)
			count++;
		if(this.pretreatmentnval != null)
			count++;
		if(this.pretreatmentmval != null)
			count++;
		if(this.pretreatmentoverall != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.clinicaladmin.vo.TumourGroupLiteVo tumourgroup;
	protected ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo pretreatmenttval;
	protected ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo pretreatmentnval;
	protected ims.clinicaladmin.vo.TumourGroupSiteTNMValueListVo pretreatmentmval;
	protected ims.clinicaladmin.vo.TumourGroupSiteOverallStagingLiteVo pretreatmentoverall;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
