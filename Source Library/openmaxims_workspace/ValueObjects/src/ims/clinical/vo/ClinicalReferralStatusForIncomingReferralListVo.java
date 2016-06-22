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
 * Linked to clinical.ClinicalReferralStatus business object (ID: 1072100113).
 */
public class ClinicalReferralStatusForIncomingReferralListVo extends ims.clinical.vo.ClinicalReferralStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalReferralStatusForIncomingReferralListVo()
	{
	}
	public ClinicalReferralStatusForIncomingReferralListVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalReferralStatusForIncomingReferralListVo(ims.clinical.vo.beans.ClinicalReferralStatusForIncomingReferralListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referralstatus = bean.getReferralStatus() == null ? null : ims.core.vo.lookups.InternalReferralStatus.buildLookup(bean.getReferralStatus());
		this.appointmentrequired = bean.getAppointmentRequired();
		this.appointmentbooked = bean.getAppointmentBooked();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalReferralStatusForIncomingReferralListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.referralstatus = bean.getReferralStatus() == null ? null : ims.core.vo.lookups.InternalReferralStatus.buildLookup(bean.getReferralStatus());
		this.appointmentrequired = bean.getAppointmentRequired();
		this.appointmentbooked = bean.getAppointmentBooked();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalReferralStatusForIncomingReferralListVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalReferralStatusForIncomingReferralListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalReferralStatusForIncomingReferralListVoBean();
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
		if(fieldName.equals("REFERRALSTATUS"))
			return getReferralStatus();
		if(fieldName.equals("APPOINTMENTREQUIRED"))
			return getAppointmentRequired();
		if(fieldName.equals("APPOINTMENTBOOKED"))
			return getAppointmentBooked();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReferralStatusIsNotNull()
	{
		return this.referralstatus != null;
	}
	public ims.core.vo.lookups.InternalReferralStatus getReferralStatus()
	{
		return this.referralstatus;
	}
	public void setReferralStatus(ims.core.vo.lookups.InternalReferralStatus value)
	{
		this.isValidated = false;
		this.referralstatus = value;
	}
	public boolean getAppointmentRequiredIsNotNull()
	{
		return this.appointmentrequired != null;
	}
	public Boolean getAppointmentRequired()
	{
		return this.appointmentrequired;
	}
	public void setAppointmentRequired(Boolean value)
	{
		this.isValidated = false;
		this.appointmentrequired = value;
	}
	public boolean getAppointmentBookedIsNotNull()
	{
		return this.appointmentbooked != null;
	}
	public Boolean getAppointmentBooked()
	{
		return this.appointmentbooked;
	}
	public void setAppointmentBooked(Boolean value)
	{
		this.isValidated = false;
		this.appointmentbooked = value;
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
		if(this.referralstatus == null)
			listOfErrors.add("ReferralStatus is mandatory");
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
	
		ClinicalReferralStatusForIncomingReferralListVo clone = new ClinicalReferralStatusForIncomingReferralListVo(this.id, this.version);
		
		if(this.referralstatus == null)
			clone.referralstatus = null;
		else
			clone.referralstatus = (ims.core.vo.lookups.InternalReferralStatus)this.referralstatus.clone();
		clone.appointmentrequired = this.appointmentrequired;
		clone.appointmentbooked = this.appointmentbooked;
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
		if (!(ClinicalReferralStatusForIncomingReferralListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalReferralStatusForIncomingReferralListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalReferralStatusForIncomingReferralListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalReferralStatusForIncomingReferralListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.referralstatus != null)
			count++;
		if(this.appointmentrequired != null)
			count++;
		if(this.appointmentbooked != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.lookups.InternalReferralStatus referralstatus;
	protected Boolean appointmentrequired;
	protected Boolean appointmentbooked;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
