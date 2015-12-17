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

package ims.RefMan.vo;

/**
 * Linked to RefMan.PatientElectiveList business object (ID: 1014100020).
 */
public class PatientElectiveListForEndoscWorklistVo extends ims.RefMan.vo.PatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveListForEndoscWorklistVo()
	{
	}
	public PatientElectiveListForEndoscWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveListForEndoscWorklistVo(ims.RefMan.vo.beans.PatientElectiveListForEndoscWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.RefMan.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo();
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo();
		this.priority = bean.getPriority() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getPriority());
		this.requiresvetting = bean.getRequiresVetting();
		this.comments = bean.getComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PatientElectiveListForEndoscWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electiveadmissiontype = bean.getElectiveAdmissionType() == null ? null : ims.RefMan.vo.lookups.ElectiveAdmissionType.buildLookup(bean.getElectiveAdmissionType());
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo(map);
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo(map);
		this.priority = bean.getPriority() == null ? null : ims.RefMan.vo.lookups.ReferralUrgency.buildLookup(bean.getPriority());
		this.requiresvetting = bean.getRequiresVetting();
		this.comments = bean.getComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PatientElectiveListForEndoscWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PatientElectiveListForEndoscWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PatientElectiveListForEndoscWorklistVoBean();
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
		if(fieldName.equals("ELECTIVEADMISSIONTYPE"))
			return getElectiveAdmissionType();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("DATEONLIST"))
			return getDateOnList();
		if(fieldName.equals("PRIMARYPROCEDURE"))
			return getPrimaryProcedure();
		if(fieldName.equals("PRIORITY"))
			return getPriority();
		if(fieldName.equals("REQUIRESVETTING"))
			return getRequiresVetting();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getElectiveAdmissionTypeIsNotNull()
	{
		return this.electiveadmissiontype != null;
	}
	public ims.RefMan.vo.lookups.ElectiveAdmissionType getElectiveAdmissionType()
	{
		return this.electiveadmissiontype;
	}
	public void setElectiveAdmissionType(ims.RefMan.vo.lookups.ElectiveAdmissionType value)
	{
		this.isValidated = false;
		this.electiveadmissiontype = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShortListVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShortListVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.RefMan.vo.ReferralLiteForEndoscWorklistVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.ReferralLiteForEndoscWorklistVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getDateOnListIsNotNull()
	{
		return this.dateonlist != null;
	}
	public ims.framework.utils.Date getDateOnList()
	{
		return this.dateonlist;
	}
	public void setDateOnList(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateonlist = value;
	}
	public boolean getPrimaryProcedureIsNotNull()
	{
		return this.primaryprocedure != null;
	}
	public ims.core.vo.ProcedureVo getPrimaryProcedure()
	{
		return this.primaryprocedure;
	}
	public void setPrimaryProcedure(ims.core.vo.ProcedureVo value)
	{
		this.isValidated = false;
		this.primaryprocedure = value;
	}
	public boolean getPriorityIsNotNull()
	{
		return this.priority != null;
	}
	public ims.RefMan.vo.lookups.ReferralUrgency getPriority()
	{
		return this.priority;
	}
	public void setPriority(ims.RefMan.vo.lookups.ReferralUrgency value)
	{
		this.isValidated = false;
		this.priority = value;
	}
	public boolean getRequiresVettingIsNotNull()
	{
		return this.requiresvetting != null;
	}
	public Boolean getRequiresVetting()
	{
		return this.requiresvetting;
	}
	public void setRequiresVetting(Boolean value)
	{
		this.isValidated = false;
		this.requiresvetting = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
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
		if(this.electiveadmissiontype == null)
			listOfErrors.add("ElectiveAdmissionType is mandatory");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.referral == null)
			listOfErrors.add("Referral is mandatory");
		if(this.dateonlist == null)
			listOfErrors.add("DateOnList is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 255)
				listOfErrors.add("The length of the field [comments] in the value object [ims.RefMan.vo.PatientElectiveListForEndoscWorklistVo] is too big. It should be less or equal to 255");
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
	
		PatientElectiveListForEndoscWorklistVo clone = new PatientElectiveListForEndoscWorklistVo(this.id, this.version);
		
		if(this.electiveadmissiontype == null)
			clone.electiveadmissiontype = null;
		else
			clone.electiveadmissiontype = (ims.RefMan.vo.lookups.ElectiveAdmissionType)this.electiveadmissiontype.clone();
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShortListVo)this.patient.clone();
		if(this.referral == null)
			clone.referral = null;
		else
			clone.referral = (ims.RefMan.vo.ReferralLiteForEndoscWorklistVo)this.referral.clone();
		if(this.dateonlist == null)
			clone.dateonlist = null;
		else
			clone.dateonlist = (ims.framework.utils.Date)this.dateonlist.clone();
		if(this.primaryprocedure == null)
			clone.primaryprocedure = null;
		else
			clone.primaryprocedure = (ims.core.vo.ProcedureVo)this.primaryprocedure.clone();
		if(this.priority == null)
			clone.priority = null;
		else
			clone.priority = (ims.RefMan.vo.lookups.ReferralUrgency)this.priority.clone();
		clone.requiresvetting = this.requiresvetting;
		clone.comments = this.comments;
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
		if (!(PatientElectiveListForEndoscWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveListForEndoscWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveListForEndoscWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveListForEndoscWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.electiveadmissiontype != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.dateonlist != null)
			count++;
		if(this.primaryprocedure != null)
			count++;
		if(this.priority != null)
			count++;
		if(this.requiresvetting != null)
			count++;
		if(this.comments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.RefMan.vo.lookups.ElectiveAdmissionType electiveadmissiontype;
	protected ims.core.vo.PatientShortListVo patient;
	protected ims.RefMan.vo.ReferralLiteForEndoscWorklistVo referral;
	protected ims.framework.utils.Date dateonlist;
	protected ims.core.vo.ProcedureVo primaryprocedure;
	protected ims.RefMan.vo.lookups.ReferralUrgency priority;
	protected Boolean requiresvetting;
	protected String comments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}