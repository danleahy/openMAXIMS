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
 * Linked to clinical.configuration.HospitalAtNightCutOverPointsConfig business object (ID: 1073100034).
 */
public class HospitalAtNightCutOverPointsConfigVo extends ims.clinical.configuration.vo.HospitalAtNightCutOverPointsConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HospitalAtNightCutOverPointsConfigVo()
	{
	}
	public HospitalAtNightCutOverPointsConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public HospitalAtNightCutOverPointsConfigVo(ims.clinical.vo.beans.HospitalAtNightCutOverPointsConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildTime();
		this.endtime = bean.getEndTime() == null ? null : bean.getEndTime().buildTime();
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.HospitalAtNightCutOverPointsConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starttime = bean.getStartTime() == null ? null : bean.getStartTime().buildTime();
		this.endtime = bean.getEndTime() == null ? null : bean.getEndTime().buildTime();
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocSiteRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.HospitalAtNightCutOverPointsConfigVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.HospitalAtNightCutOverPointsConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.HospitalAtNightCutOverPointsConfigVoBean();
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
		if(fieldName.equals("STARTTIME"))
			return getStartTime();
		if(fieldName.equals("ENDTIME"))
			return getEndTime();
		if(fieldName.equals("HOSPITAL"))
			return getHospital();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartTimeIsNotNull()
	{
		return this.starttime != null;
	}
	public ims.framework.utils.Time getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttime = value;
	}
	public boolean getEndTimeIsNotNull()
	{
		return this.endtime != null;
	}
	public ims.framework.utils.Time getEndTime()
	{
		return this.endtime;
	}
	public void setEndTime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.endtime = value;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.resource.place.vo.LocSiteRefVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.resource.place.vo.LocSiteRefVo value)
	{
		this.isValidated = false;
		this.hospital = value;
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
		if(this.starttime == null)
			listOfErrors.add("StartTime is mandatory");
		if(this.endtime == null)
			listOfErrors.add("EndTime is mandatory");
		if(this.hospital == null)
			listOfErrors.add("Hospital is mandatory");
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
	
		HospitalAtNightCutOverPointsConfigVo clone = new HospitalAtNightCutOverPointsConfigVo(this.id, this.version);
		
		if(this.starttime == null)
			clone.starttime = null;
		else
			clone.starttime = (ims.framework.utils.Time)this.starttime.clone();
		if(this.endtime == null)
			clone.endtime = null;
		else
			clone.endtime = (ims.framework.utils.Time)this.endtime.clone();
		clone.hospital = this.hospital;
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
		if (!(HospitalAtNightCutOverPointsConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HospitalAtNightCutOverPointsConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((HospitalAtNightCutOverPointsConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((HospitalAtNightCutOverPointsConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.starttime != null)
			count++;
		if(this.endtime != null)
			count++;
		if(this.hospital != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.Time starttime;
	protected ims.framework.utils.Time endtime;
	protected ims.core.resource.place.vo.LocSiteRefVo hospital;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
