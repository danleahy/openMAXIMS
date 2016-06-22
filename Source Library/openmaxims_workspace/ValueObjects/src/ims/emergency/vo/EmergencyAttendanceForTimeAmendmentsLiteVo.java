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
public class EmergencyAttendanceForTimeAmendmentsLiteVo extends ims.core.admin.vo.EmergencyAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceForTimeAmendmentsLiteVo()
	{
	}
	public EmergencyAttendanceForTimeAmendmentsLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceForTimeAmendmentsLiteVo(ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.customid = bean.getCustomID();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.registrationdatetime = bean.getRegistrationDateTime() == null ? null : bean.getRegistrationDateTime().buildDateTime();
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.customid = bean.getCustomID();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsLiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceForTimeAmendmentsLiteVoBean();
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
		if(fieldName.equals("REGISTRATIONDATETIME"))
			return getRegistrationDateTime();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CUSTOMID"))
			return getCustomID();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getRegistrationDateTimeIsNotNull()
	{
		return this.registrationdatetime != null;
	}
	public ims.framework.utils.DateTime getRegistrationDateTime()
	{
		return this.registrationdatetime;
	}
	public void setRegistrationDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.registrationdatetime = value;
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
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
	public boolean getCustomIDIsNotNull()
	{
		return this.customid != null;
	}
	public String getCustomID()
	{
		return this.customid;
	}
	public static int getCustomIDMaxLength()
	{
		return 20;
	}
	public void setCustomID(String value)
	{
		this.isValidated = false;
		this.customid = value;
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
		if(this.registrationdatetime == null)
			listOfErrors.add("RegistrationDateTime is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.customid != null)
			if(this.customid.length() > 20)
				listOfErrors.add("The length of the field [customid] in the value object [ims.emergency.vo.EmergencyAttendanceForTimeAmendmentsLiteVo] is too big. It should be less or equal to 20");
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
	
		EmergencyAttendanceForTimeAmendmentsLiteVo clone = new EmergencyAttendanceForTimeAmendmentsLiteVo(this.id, this.version);
		
		if(this.registrationdatetime == null)
			clone.registrationdatetime = null;
		else
			clone.registrationdatetime = (ims.framework.utils.DateTime)this.registrationdatetime.clone();
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		clone.carecontext = this.carecontext;
		clone.customid = this.customid;
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
		if (!(EmergencyAttendanceForTimeAmendmentsLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceForTimeAmendmentsLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceForTimeAmendmentsLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceForTimeAmendmentsLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.registrationdatetime != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.customid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.DateTime registrationdatetime;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected String customid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
