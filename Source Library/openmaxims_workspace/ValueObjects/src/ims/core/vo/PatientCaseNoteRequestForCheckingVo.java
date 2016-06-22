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

package ims.core.vo;

/**
 * Linked to core.clinical.PatientCaseNoteRequest business object (ID: 1003100131).
 */
public class PatientCaseNoteRequestForCheckingVo extends ims.core.clinical.vo.PatientCaseNoteRequestRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteRequestForCheckingVo()
	{
	}
	public PatientCaseNoteRequestForCheckingVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCaseNoteRequestForCheckingVo(ims.core.vo.beans.PatientCaseNoteRequestForCheckingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.casenote = bean.getCaseNote() == null ? null : new ims.core.clinical.vo.PatientCaseNoteRefVo(new Integer(bean.getCaseNote().getId()), bean.getCaseNote().getVersion());
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.cancelledby = bean.getCancelledBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getCancelledBy().getId()), bean.getCancelledBy().getVersion());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDateTime();
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.core.vo.lookups.CaseNoteRequestCancellationReason.buildLookup(bean.getCancellationReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCaseNoteRequestForCheckingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.casenote = bean.getCaseNote() == null ? null : new ims.core.clinical.vo.PatientCaseNoteRefVo(new Integer(bean.getCaseNote().getId()), bean.getCaseNote().getVersion());
		this.requeststatus = bean.getRequestStatus() == null ? null : ims.core.vo.lookups.CaseNoteRequestStatus.buildLookup(bean.getRequestStatus());
		this.cancelledby = bean.getCancelledBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getCancelledBy().getId()), bean.getCancelledBy().getVersion());
		this.cancelleddate = bean.getCancelledDate() == null ? null : bean.getCancelledDate().buildDateTime();
		this.cancellationreason = bean.getCancellationReason() == null ? null : ims.core.vo.lookups.CaseNoteRequestCancellationReason.buildLookup(bean.getCancellationReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCaseNoteRequestForCheckingVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCaseNoteRequestForCheckingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCaseNoteRequestForCheckingVoBean();
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
		if(fieldName.equals("CASENOTE"))
			return getCaseNote();
		if(fieldName.equals("REQUESTSTATUS"))
			return getRequestStatus();
		if(fieldName.equals("CANCELLEDBY"))
			return getCancelledBy();
		if(fieldName.equals("CANCELLEDDATE"))
			return getCancelledDate();
		if(fieldName.equals("CANCELLATIONREASON"))
			return getCancellationReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCaseNoteIsNotNull()
	{
		return this.casenote != null;
	}
	public ims.core.clinical.vo.PatientCaseNoteRefVo getCaseNote()
	{
		return this.casenote;
	}
	public void setCaseNote(ims.core.clinical.vo.PatientCaseNoteRefVo value)
	{
		this.isValidated = false;
		this.casenote = value;
	}
	public boolean getRequestStatusIsNotNull()
	{
		return this.requeststatus != null;
	}
	public ims.core.vo.lookups.CaseNoteRequestStatus getRequestStatus()
	{
		return this.requeststatus;
	}
	public void setRequestStatus(ims.core.vo.lookups.CaseNoteRequestStatus value)
	{
		this.isValidated = false;
		this.requeststatus = value;
	}
	public boolean getCancelledByIsNotNull()
	{
		return this.cancelledby != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getCancelledBy()
	{
		return this.cancelledby;
	}
	public void setCancelledBy(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.cancelledby = value;
	}
	public boolean getCancelledDateIsNotNull()
	{
		return this.cancelleddate != null;
	}
	public ims.framework.utils.DateTime getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.cancelleddate = value;
	}
	public boolean getCancellationReasonIsNotNull()
	{
		return this.cancellationreason != null;
	}
	public ims.core.vo.lookups.CaseNoteRequestCancellationReason getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.core.vo.lookups.CaseNoteRequestCancellationReason value)
	{
		this.isValidated = false;
		this.cancellationreason = value;
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
		if(this.casenote == null)
			listOfErrors.add("CaseNote is mandatory");
		if(this.requeststatus == null)
			listOfErrors.add("RequestStatus is mandatory");
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
	
		PatientCaseNoteRequestForCheckingVo clone = new PatientCaseNoteRequestForCheckingVo(this.id, this.version);
		
		clone.casenote = this.casenote;
		if(this.requeststatus == null)
			clone.requeststatus = null;
		else
			clone.requeststatus = (ims.core.vo.lookups.CaseNoteRequestStatus)this.requeststatus.clone();
		clone.cancelledby = this.cancelledby;
		if(this.cancelleddate == null)
			clone.cancelleddate = null;
		else
			clone.cancelleddate = (ims.framework.utils.DateTime)this.cancelleddate.clone();
		if(this.cancellationreason == null)
			clone.cancellationreason = null;
		else
			clone.cancellationreason = (ims.core.vo.lookups.CaseNoteRequestCancellationReason)this.cancellationreason.clone();
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
		if (!(PatientCaseNoteRequestForCheckingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCaseNoteRequestForCheckingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientCaseNoteRequestForCheckingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientCaseNoteRequestForCheckingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.casenote != null)
			count++;
		if(this.requeststatus != null)
			count++;
		if(this.cancelledby != null)
			count++;
		if(this.cancelleddate != null)
			count++;
		if(this.cancellationreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.clinical.vo.PatientCaseNoteRefVo casenote;
	protected ims.core.vo.lookups.CaseNoteRequestStatus requeststatus;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo cancelledby;
	protected ims.framework.utils.DateTime cancelleddate;
	protected ims.core.vo.lookups.CaseNoteRequestCancellationReason cancellationreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
