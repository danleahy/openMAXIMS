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

/**
 * Linked to emergency.Tracking business object (ID: 1086100005).
 */
public class TrackingLiteVo extends ims.emergency.vo.TrackingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TrackingLiteVo()
	{
	}
	public TrackingLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TrackingLiteVo(ims.emergency.vo.beans.TrackingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentarea = bean.getCurrentArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getCurrentArea().getId()), bean.getCurrentArea().getVersion());
		this.isprimarycare = bean.getIsPrimaryCare();
		this.isdischarged = bean.getIsDischarged();
		this.lastmovementdatetime = bean.getLastMovementDateTime() == null ? null : bean.getLastMovementDateTime().buildDateTime();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo();
		this.currentpartialadmission = bean.getCurrentPartialAdmission() == null ? null : bean.getCurrentPartialAdmission().buildVo();
		this.currentcubicle = bean.getCurrentCubicle() == null ? null : bean.getCurrentCubicle().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.displayined = bean.getDisplayInED();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TrackingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentarea = bean.getCurrentArea() == null ? null : new ims.emergency.configuration.vo.TrackingAreaRefVo(new Integer(bean.getCurrentArea().getId()), bean.getCurrentArea().getVersion());
		this.isprimarycare = bean.getIsPrimaryCare();
		this.isdischarged = bean.getIsDischarged();
		this.lastmovementdatetime = bean.getLastMovementDateTime() == null ? null : bean.getLastMovementDateTime().buildDateTime();
		this.attendance = bean.getAttendance() == null ? null : bean.getAttendance().buildVo(map);
		this.currentpartialadmission = bean.getCurrentPartialAdmission() == null ? null : bean.getCurrentPartialAdmission().buildVo(map);
		this.currentcubicle = bean.getCurrentCubicle() == null ? null : bean.getCurrentCubicle().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.displayined = bean.getDisplayInED();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TrackingLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TrackingLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TrackingLiteVoBean();
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
		if(fieldName.equals("CURRENTAREA"))
			return getCurrentArea();
		if(fieldName.equals("ISPRIMARYCARE"))
			return getIsPrimaryCare();
		if(fieldName.equals("ISDISCHARGED"))
			return getIsDischarged();
		if(fieldName.equals("LASTMOVEMENTDATETIME"))
			return getLastMovementDateTime();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("CURRENTPARTIALADMISSION"))
			return getCurrentPartialAdmission();
		if(fieldName.equals("CURRENTCUBICLE"))
			return getCurrentCubicle();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("DISPLAYINED"))
			return getDisplayInED();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCurrentAreaIsNotNull()
	{
		return this.currentarea != null;
	}
	public ims.emergency.configuration.vo.TrackingAreaRefVo getCurrentArea()
	{
		return this.currentarea;
	}
	public void setCurrentArea(ims.emergency.configuration.vo.TrackingAreaRefVo value)
	{
		this.isValidated = false;
		this.currentarea = value;
	}
	public boolean getIsPrimaryCareIsNotNull()
	{
		return this.isprimarycare != null;
	}
	public Boolean getIsPrimaryCare()
	{
		return this.isprimarycare;
	}
	public void setIsPrimaryCare(Boolean value)
	{
		this.isValidated = false;
		this.isprimarycare = value;
	}
	public boolean getIsDischargedIsNotNull()
	{
		return this.isdischarged != null;
	}
	public Boolean getIsDischarged()
	{
		return this.isdischarged;
	}
	public void setIsDischarged(Boolean value)
	{
		this.isValidated = false;
		this.isdischarged = value;
	}
	public boolean getLastMovementDateTimeIsNotNull()
	{
		return this.lastmovementdatetime != null;
	}
	public ims.framework.utils.DateTime getLastMovementDateTime()
	{
		return this.lastmovementdatetime;
	}
	public void setLastMovementDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.lastmovementdatetime = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.emergency.vo.EmergencyAttendanceForSendToAreaVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.emergency.vo.EmergencyAttendanceForSendToAreaVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getCurrentPartialAdmissionIsNotNull()
	{
		return this.currentpartialadmission != null;
	}
	public ims.emergency.vo.CurrentPartialAdmissionForSendToAreaVo getCurrentPartialAdmission()
	{
		return this.currentpartialadmission;
	}
	public void setCurrentPartialAdmission(ims.emergency.vo.CurrentPartialAdmissionForSendToAreaVo value)
	{
		this.isValidated = false;
		this.currentpartialadmission = value;
	}
	public boolean getCurrentCubicleIsNotNull()
	{
		return this.currentcubicle != null;
	}
	public ims.emergency.vo.CubicleAllocationVo getCurrentCubicle()
	{
		return this.currentcubicle;
	}
	public void setCurrentCubicle(ims.emergency.vo.CubicleAllocationVo value)
	{
		this.isValidated = false;
		this.currentcubicle = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.emergency.vo.TrackingAttendanceStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.emergency.vo.TrackingAttendanceStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getDisplayInEDIsNotNull()
	{
		return this.displayined != null;
	}
	public Boolean getDisplayInED()
	{
		return this.displayined;
	}
	public void setDisplayInED(Boolean value)
	{
		this.isValidated = false;
		this.displayined = value;
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
		if(this.attendance != null)
		{
			if(!this.attendance.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentpartialadmission != null)
		{
			if(!this.currentpartialadmission.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentcubicle != null)
		{
			if(!this.currentcubicle.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
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
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.attendance != null)
		{
			String[] listOfOtherErrors = this.attendance.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentpartialadmission != null)
		{
			String[] listOfOtherErrors = this.currentpartialadmission.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentcubicle != null)
		{
			String[] listOfOtherErrors = this.currentcubicle.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
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
	
		TrackingLiteVo clone = new TrackingLiteVo(this.id, this.version);
		
		clone.currentarea = this.currentarea;
		clone.isprimarycare = this.isprimarycare;
		clone.isdischarged = this.isdischarged;
		if(this.lastmovementdatetime == null)
			clone.lastmovementdatetime = null;
		else
			clone.lastmovementdatetime = (ims.framework.utils.DateTime)this.lastmovementdatetime.clone();
		if(this.attendance == null)
			clone.attendance = null;
		else
			clone.attendance = (ims.emergency.vo.EmergencyAttendanceForSendToAreaVo)this.attendance.clone();
		if(this.currentpartialadmission == null)
			clone.currentpartialadmission = null;
		else
			clone.currentpartialadmission = (ims.emergency.vo.CurrentPartialAdmissionForSendToAreaVo)this.currentpartialadmission.clone();
		if(this.currentcubicle == null)
			clone.currentcubicle = null;
		else
			clone.currentcubicle = (ims.emergency.vo.CubicleAllocationVo)this.currentcubicle.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.emergency.vo.TrackingAttendanceStatusVo)this.currentstatus.clone();
		clone.displayined = this.displayined;
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
		if (!(TrackingLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TrackingLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TrackingLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TrackingLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.currentarea != null)
			count++;
		if(this.isprimarycare != null)
			count++;
		if(this.isdischarged != null)
			count++;
		if(this.lastmovementdatetime != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.currentpartialadmission != null)
			count++;
		if(this.currentcubicle != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.displayined != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.emergency.configuration.vo.TrackingAreaRefVo currentarea;
	protected Boolean isprimarycare;
	protected Boolean isdischarged;
	protected ims.framework.utils.DateTime lastmovementdatetime;
	protected ims.emergency.vo.EmergencyAttendanceForSendToAreaVo attendance;
	protected ims.emergency.vo.CurrentPartialAdmissionForSendToAreaVo currentpartialadmission;
	protected ims.emergency.vo.CubicleAllocationVo currentcubicle;
	protected ims.emergency.vo.TrackingAttendanceStatusVo currentstatus;
	protected Boolean displayined;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
