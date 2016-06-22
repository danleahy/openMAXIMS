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
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class EmergencyAttendanceForPartialAdmissionVo extends ims.core.admin.vo.EmergencyAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceForPartialAdmissionVo()
	{
	}
	public EmergencyAttendanceForPartialAdmissionVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceForPartialAdmissionVo(ims.emergency.vo.beans.EmergencyAttendanceForPartialAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedtyperequested = bean.getBedTypeRequested() == null ? null : ims.core.vo.lookups.BedTypeRequested.buildLookup(bean.getBedTypeRequested());
		this.patientattendancestatus = bean.getPatientAttendanceStatus() == null ? null : ims.emergency.vo.lookups.PatientAttendanceStatus.buildLookup(bean.getPatientAttendanceStatus());
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.accomodationrequestedtype = bean.getAccomodationRequestedType() == null ? null : ims.core.vo.lookups.AccomodationRequestedType.buildLookup(bean.getAccomodationRequestedType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceForPartialAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.bedtyperequested = bean.getBedTypeRequested() == null ? null : ims.core.vo.lookups.BedTypeRequested.buildLookup(bean.getBedTypeRequested());
		this.patientattendancestatus = bean.getPatientAttendanceStatus() == null ? null : ims.emergency.vo.lookups.PatientAttendanceStatus.buildLookup(bean.getPatientAttendanceStatus());
		this.conclusiondatetime = bean.getConclusionDateTime() == null ? null : bean.getConclusionDateTime().buildDateTime();
		this.accomodationrequestedtype = bean.getAccomodationRequestedType() == null ? null : ims.core.vo.lookups.AccomodationRequestedType.buildLookup(bean.getAccomodationRequestedType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceForPartialAdmissionVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceForPartialAdmissionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceForPartialAdmissionVoBean();
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
		if(fieldName.equals("BEDTYPEREQUESTED"))
			return getBedTypeRequested();
		if(fieldName.equals("PATIENTATTENDANCESTATUS"))
			return getPatientAttendanceStatus();
		if(fieldName.equals("CONCLUSIONDATETIME"))
			return getConclusionDateTime();
		if(fieldName.equals("ACCOMODATIONREQUESTEDTYPE"))
			return getAccomodationRequestedType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getBedTypeRequestedIsNotNull()
	{
		return this.bedtyperequested != null;
	}
	public ims.core.vo.lookups.BedTypeRequested getBedTypeRequested()
	{
		return this.bedtyperequested;
	}
	public void setBedTypeRequested(ims.core.vo.lookups.BedTypeRequested value)
	{
		this.isValidated = false;
		this.bedtyperequested = value;
	}
	public boolean getPatientAttendanceStatusIsNotNull()
	{
		return this.patientattendancestatus != null;
	}
	public ims.emergency.vo.lookups.PatientAttendanceStatus getPatientAttendanceStatus()
	{
		return this.patientattendancestatus;
	}
	public void setPatientAttendanceStatus(ims.emergency.vo.lookups.PatientAttendanceStatus value)
	{
		this.isValidated = false;
		this.patientattendancestatus = value;
	}
	public boolean getConclusionDateTimeIsNotNull()
	{
		return this.conclusiondatetime != null;
	}
	public ims.framework.utils.DateTime getConclusionDateTime()
	{
		return this.conclusiondatetime;
	}
	public void setConclusionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.conclusiondatetime = value;
	}
	public boolean getAccomodationRequestedTypeIsNotNull()
	{
		return this.accomodationrequestedtype != null;
	}
	public ims.core.vo.lookups.AccomodationRequestedType getAccomodationRequestedType()
	{
		return this.accomodationrequestedtype;
	}
	public void setAccomodationRequestedType(ims.core.vo.lookups.AccomodationRequestedType value)
	{
		this.isValidated = false;
		this.accomodationrequestedtype = value;
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
	
		EmergencyAttendanceForPartialAdmissionVo clone = new EmergencyAttendanceForPartialAdmissionVo(this.id, this.version);
		
		if(this.bedtyperequested == null)
			clone.bedtyperequested = null;
		else
			clone.bedtyperequested = (ims.core.vo.lookups.BedTypeRequested)this.bedtyperequested.clone();
		if(this.patientattendancestatus == null)
			clone.patientattendancestatus = null;
		else
			clone.patientattendancestatus = (ims.emergency.vo.lookups.PatientAttendanceStatus)this.patientattendancestatus.clone();
		if(this.conclusiondatetime == null)
			clone.conclusiondatetime = null;
		else
			clone.conclusiondatetime = (ims.framework.utils.DateTime)this.conclusiondatetime.clone();
		if(this.accomodationrequestedtype == null)
			clone.accomodationrequestedtype = null;
		else
			clone.accomodationrequestedtype = (ims.core.vo.lookups.AccomodationRequestedType)this.accomodationrequestedtype.clone();
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
		if (!(EmergencyAttendanceForPartialAdmissionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceForPartialAdmissionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceForPartialAdmissionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceForPartialAdmissionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.bedtyperequested != null)
			count++;
		if(this.patientattendancestatus != null)
			count++;
		if(this.conclusiondatetime != null)
			count++;
		if(this.accomodationrequestedtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.lookups.BedTypeRequested bedtyperequested;
	protected ims.emergency.vo.lookups.PatientAttendanceStatus patientattendancestatus;
	protected ims.framework.utils.DateTime conclusiondatetime;
	protected ims.core.vo.lookups.AccomodationRequestedType accomodationrequestedtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
