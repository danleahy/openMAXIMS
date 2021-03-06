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

package ims.emergency.vo;


public class AttendanceHistoryDialogParamsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AttendanceHistoryDialogParamsVo()
	{
	}
	public AttendanceHistoryDialogParamsVo(ims.emergency.vo.beans.AttendanceHistoryDialogParamsVoBean bean)
	{
		this.patientrefvo = bean.getPatientRefVo() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatientRefVo().getId()), bean.getPatientRefVo().getVersion());
		this.maxrecords = bean.getMaxRecords();
		this.type = bean.getType();
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDateTime();
		this.unscheduleddate = bean.getUnscheduledDate() == null ? null : bean.getUnscheduledDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.AttendanceHistoryDialogParamsVoBean bean)
	{
		this.patientrefvo = bean.getPatientRefVo() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatientRefVo().getId()), bean.getPatientRefVo().getVersion());
		this.maxrecords = bean.getMaxRecords();
		this.type = bean.getType();
		this.scheduleddate = bean.getScheduledDate() == null ? null : bean.getScheduledDate().buildDateTime();
		this.unscheduleddate = bean.getUnscheduledDate() == null ? null : bean.getUnscheduledDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.AttendanceHistoryDialogParamsVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.AttendanceHistoryDialogParamsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.AttendanceHistoryDialogParamsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPatientRefVoIsNotNull()
	{
		return this.patientrefvo != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatientRefVo()
	{
		return this.patientrefvo;
	}
	public void setPatientRefVo(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patientrefvo = value;
	}
	public boolean getMaxRecordsIsNotNull()
	{
		return this.maxrecords != null;
	}
	public Integer getMaxRecords()
	{
		return this.maxrecords;
	}
	public void setMaxRecords(Integer value)
	{
		this.isValidated = false;
		this.maxrecords = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public Integer getType()
	{
		return this.type;
	}
	public void setType(Integer value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getScheduledDateIsNotNull()
	{
		return this.scheduleddate != null;
	}
	public ims.framework.utils.DateTime getScheduledDate()
	{
		return this.scheduleddate;
	}
	public void setScheduledDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.scheduleddate = value;
	}
	public boolean getUnscheduledDateIsNotNull()
	{
		return this.unscheduleddate != null;
	}
	public ims.framework.utils.DateTime getUnscheduledDate()
	{
		return this.unscheduleddate;
	}
	public void setUnscheduledDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.unscheduleddate = value;
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
		if(!(obj instanceof AttendanceHistoryDialogParamsVo))
			return false;
		AttendanceHistoryDialogParamsVo compareObj = (AttendanceHistoryDialogParamsVo)obj;
		if(this.getPatientRefVo() == null && compareObj.getPatientRefVo() != null)
			return false;
		if(this.getPatientRefVo() != null && compareObj.getPatientRefVo() == null)
			return false;
		if(this.getPatientRefVo() != null && compareObj.getPatientRefVo() != null)
			return this.getPatientRefVo().equals(compareObj.getPatientRefVo());
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
	
		AttendanceHistoryDialogParamsVo clone = new AttendanceHistoryDialogParamsVo();
		
		clone.patientrefvo = this.patientrefvo;
		clone.maxrecords = this.maxrecords;
		clone.type = this.type;
		if(this.scheduleddate == null)
			clone.scheduleddate = null;
		else
			clone.scheduleddate = (ims.framework.utils.DateTime)this.scheduleddate.clone();
		if(this.unscheduleddate == null)
			clone.unscheduleddate = null;
		else
			clone.unscheduleddate = (ims.framework.utils.DateTime)this.unscheduleddate.clone();
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
		if (!(AttendanceHistoryDialogParamsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AttendanceHistoryDialogParamsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AttendanceHistoryDialogParamsVo compareObj = (AttendanceHistoryDialogParamsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPatientRefVo() == null && compareObj.getPatientRefVo() != null)
				return -1;
			if(this.getPatientRefVo() != null && compareObj.getPatientRefVo() == null)
				return 1;
			if(this.getPatientRefVo() != null && compareObj.getPatientRefVo() != null)
				retVal = this.getPatientRefVo().compareTo(compareObj.getPatientRefVo());
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
		if(this.patientrefvo != null)
			count++;
		if(this.maxrecords != null)
			count++;
		if(this.type != null)
			count++;
		if(this.scheduleddate != null)
			count++;
		if(this.unscheduleddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.patient.vo.PatientRefVo patientrefvo;
	protected Integer maxrecords;
	protected Integer type;
	protected ims.framework.utils.DateTime scheduleddate;
	protected ims.framework.utils.DateTime unscheduleddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
