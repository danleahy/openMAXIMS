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
 * Linked to core.admin.Referral business object (ID: 1004100001).
 */
public class HL7ReferralVo extends ims.core.vo.ReferralLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HL7ReferralVo()
	{
	}
	public HL7ReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public HL7ReferralVo(ims.core.vo.beans.HL7ReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.referralreceiveddate = bean.getReferralReceivedDate() == null ? null : bean.getReferralReceivedDate().buildDate();
		this.originalreferraldate = bean.getOriginalReferralDate() == null ? null : bean.getOriginalReferralDate().buildDate();
		this.referraltype = bean.getReferralType() == null ? null : ims.core.vo.lookups.ReferralType.buildLookup(bean.getReferralType());
		this.details = bean.getDetails();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.extreferralkey = bean.getExtReferralKey();
		this.clockid = bean.getClockId();
		this.catsreferraldetails = bean.getCatsReferralDetails() == null ? null : bean.getCatsReferralDetails().buildVo();
		this.authoringcp = bean.getAuthoringCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getAuthoringCP().getId()), bean.getAuthoringCP().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.isactive = bean.getIsActive();
		this.firstapptdate = bean.getFirstApptDate() == null ? null : bean.getFirstApptDate().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.referringgp = bean.getReferringGP() == null ? null : new ims.core.resource.people.vo.GpRefVo(new Integer(bean.getReferringGP().getId()), bean.getReferringGP().getVersion());
		this.referringclinician = bean.getReferringClinician() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getReferringClinician().getId()), bean.getReferringClinician().getVersion());
		this.referralpriority = bean.getReferralPriority() == null ? null : ims.core.vo.lookups.ReferralPriority.buildLookup(bean.getReferralPriority());
		this.referredto = bean.getReferredTo() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getReferredTo().getId()), bean.getReferredTo().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.referraldetails = bean.getReferralDetails();
		this.dateofreferral = bean.getDateOfReferral() == null ? null : bean.getDateOfReferral().buildDate();
		this.referrallocation = bean.getReferralLocation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.HL7ReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.referralreceiveddate = bean.getReferralReceivedDate() == null ? null : bean.getReferralReceivedDate().buildDate();
		this.originalreferraldate = bean.getOriginalReferralDate() == null ? null : bean.getOriginalReferralDate().buildDate();
		this.referraltype = bean.getReferralType() == null ? null : ims.core.vo.lookups.ReferralType.buildLookup(bean.getReferralType());
		this.details = bean.getDetails();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.extreferralkey = bean.getExtReferralKey();
		this.clockid = bean.getClockId();
		this.catsreferraldetails = bean.getCatsReferralDetails() == null ? null : bean.getCatsReferralDetails().buildVo(map);
		this.authoringcp = bean.getAuthoringCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getAuthoringCP().getId()), bean.getAuthoringCP().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.isactive = bean.getIsActive();
		this.firstapptdate = bean.getFirstApptDate() == null ? null : bean.getFirstApptDate().buildDateTime();
		this.sourceofreferral = bean.getSourceOfReferral() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getSourceOfReferral());
		this.referringgp = bean.getReferringGP() == null ? null : new ims.core.resource.people.vo.GpRefVo(new Integer(bean.getReferringGP().getId()), bean.getReferringGP().getVersion());
		this.referringclinician = bean.getReferringClinician() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getReferringClinician().getId()), bean.getReferringClinician().getVersion());
		this.referralpriority = bean.getReferralPriority() == null ? null : ims.core.vo.lookups.ReferralPriority.buildLookup(bean.getReferralPriority());
		this.referredto = bean.getReferredTo() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getReferredTo().getId()), bean.getReferredTo().getVersion());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.referraldetails = bean.getReferralDetails();
		this.dateofreferral = bean.getDateOfReferral() == null ? null : bean.getDateOfReferral().buildDate();
		this.referrallocation = bean.getReferralLocation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.HL7ReferralVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.HL7ReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.HL7ReferralVoBean();
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
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("FIRSTAPPTDATE"))
			return getFirstApptDate();
		if(fieldName.equals("SOURCEOFREFERRAL"))
			return getSourceOfReferral();
		if(fieldName.equals("REFERRINGGP"))
			return getReferringGP();
		if(fieldName.equals("REFERRINGCLINICIAN"))
			return getReferringClinician();
		if(fieldName.equals("REFERRALPRIORITY"))
			return getReferralPriority();
		if(fieldName.equals("REFERREDTO"))
			return getReferredTo();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		if(fieldName.equals("DATEOFREFERRAL"))
			return getDateOfReferral();
		if(fieldName.equals("REFERRALLOCATION"))
			return getReferralLocation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getFirstApptDateIsNotNull()
	{
		return this.firstapptdate != null;
	}
	public ims.framework.utils.DateTime getFirstApptDate()
	{
		return this.firstapptdate;
	}
	public void setFirstApptDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.firstapptdate = value;
	}
	public boolean getSourceOfReferralIsNotNull()
	{
		return this.sourceofreferral != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getSourceOfReferral()
	{
		return this.sourceofreferral;
	}
	public void setSourceOfReferral(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.sourceofreferral = value;
	}
	public boolean getReferringGPIsNotNull()
	{
		return this.referringgp != null;
	}
	public ims.core.resource.people.vo.GpRefVo getReferringGP()
	{
		return this.referringgp;
	}
	public void setReferringGP(ims.core.resource.people.vo.GpRefVo value)
	{
		this.isValidated = false;
		this.referringgp = value;
	}
	public boolean getReferringClinicianIsNotNull()
	{
		return this.referringclinician != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getReferringClinician()
	{
		return this.referringclinician;
	}
	public void setReferringClinician(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.referringclinician = value;
	}
	public boolean getReferralPriorityIsNotNull()
	{
		return this.referralpriority != null;
	}
	public ims.core.vo.lookups.ReferralPriority getReferralPriority()
	{
		return this.referralpriority;
	}
	public void setReferralPriority(ims.core.vo.lookups.ReferralPriority value)
	{
		this.isValidated = false;
		this.referralpriority = value;
	}
	public boolean getReferredToIsNotNull()
	{
		return this.referredto != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getReferredTo()
	{
		return this.referredto;
	}
	public void setReferredTo(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.referredto = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public String getReferralDetails()
	{
		return this.referraldetails;
	}
	public static int getReferralDetailsMaxLength()
	{
		return 250;
	}
	public void setReferralDetails(String value)
	{
		this.isValidated = false;
		this.referraldetails = value;
	}
	public boolean getDateOfReferralIsNotNull()
	{
		return this.dateofreferral != null;
	}
	public ims.framework.utils.Date getDateOfReferral()
	{
		return this.dateofreferral;
	}
	public void setDateOfReferral(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateofreferral = value;
	}
	public boolean getReferralLocationIsNotNull()
	{
		return this.referrallocation != null;
	}
	public String getReferralLocation()
	{
		return this.referrallocation;
	}
	public static int getReferralLocationMaxLength()
	{
		return 100;
	}
	public void setReferralLocation(String value)
	{
		this.isValidated = false;
		this.referrallocation = value;
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
		if(this.details != null)
			if(this.details.length() > 255)
				listOfErrors.add("The length of the field [details] in the value object [ims.core.vo.HL7ReferralVo] is too big. It should be less or equal to 255");
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.extreferralkey != null)
			if(this.extreferralkey.length() > 50)
				listOfErrors.add("The length of the field [extreferralkey] in the value object [ims.core.vo.HL7ReferralVo] is too big. It should be less or equal to 50");
		if(this.clockid != null)
			if(this.clockid.length() > 25)
				listOfErrors.add("The length of the field [clockid] in the value object [ims.core.vo.HL7ReferralVo] is too big. It should be less or equal to 25");
		if(this.referraldetails != null)
			if(this.referraldetails.length() > 250)
				listOfErrors.add("The length of the field [referraldetails] in the value object [ims.core.vo.HL7ReferralVo] is too big. It should be less or equal to 250");
		if(this.referrallocation != null)
			if(this.referrallocation.length() > 100)
				listOfErrors.add("The length of the field [referrallocation] in the value object [ims.core.vo.HL7ReferralVo] is too big. It should be less or equal to 100");
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
	
		HL7ReferralVo clone = new HL7ReferralVo(this.id, this.version);
		
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.referralreceiveddate == null)
			clone.referralreceiveddate = null;
		else
			clone.referralreceiveddate = (ims.framework.utils.Date)this.referralreceiveddate.clone();
		if(this.originalreferraldate == null)
			clone.originalreferraldate = null;
		else
			clone.originalreferraldate = (ims.framework.utils.Date)this.originalreferraldate.clone();
		if(this.referraltype == null)
			clone.referraltype = null;
		else
			clone.referraltype = (ims.core.vo.lookups.ReferralType)this.referraltype.clone();
		clone.details = this.details;
		clone.patient = this.patient;
		clone.extreferralkey = this.extreferralkey;
		clone.clockid = this.clockid;
		if(this.catsreferraldetails == null)
			clone.catsreferraldetails = null;
		else
			clone.catsreferraldetails = (ims.RefMan.vo.CatsReferralForJourneyVo)this.catsreferraldetails.clone();
		clone.authoringcp = this.authoringcp;
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
		clone.isactive = this.isactive;
		if(this.firstapptdate == null)
			clone.firstapptdate = null;
		else
			clone.firstapptdate = (ims.framework.utils.DateTime)this.firstapptdate.clone();
		if(this.sourceofreferral == null)
			clone.sourceofreferral = null;
		else
			clone.sourceofreferral = (ims.core.vo.lookups.SourceOfReferral)this.sourceofreferral.clone();
		clone.referringgp = this.referringgp;
		clone.referringclinician = this.referringclinician;
		if(this.referralpriority == null)
			clone.referralpriority = null;
		else
			clone.referralpriority = (ims.core.vo.lookups.ReferralPriority)this.referralpriority.clone();
		clone.referredto = this.referredto;
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		clone.referraldetails = this.referraldetails;
		if(this.dateofreferral == null)
			clone.dateofreferral = null;
		else
			clone.dateofreferral = (ims.framework.utils.Date)this.dateofreferral.clone();
		clone.referrallocation = this.referrallocation;
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
		if (!(HL7ReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HL7ReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((HL7ReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((HL7ReferralVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.authoringcp != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.firstapptdate != null)
			count++;
		if(this.sourceofreferral != null)
			count++;
		if(this.referringgp != null)
			count++;
		if(this.referringclinician != null)
			count++;
		if(this.referralpriority != null)
			count++;
		if(this.referredto != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.referraldetails != null)
			count++;
		if(this.dateofreferral != null)
			count++;
		if(this.referrallocation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 14;
	}
	protected ims.core.resource.people.vo.HcpRefVo authoringcp;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected Boolean isactive;
	protected ims.framework.utils.DateTime firstapptdate;
	protected ims.core.vo.lookups.SourceOfReferral sourceofreferral;
	protected ims.core.resource.people.vo.GpRefVo referringgp;
	protected ims.core.resource.people.vo.HcpRefVo referringclinician;
	protected ims.core.vo.lookups.ReferralPriority referralpriority;
	protected ims.core.resource.people.vo.HcpRefVo referredto;
	protected ims.core.vo.lookups.Specialty specialty;
	protected String referraldetails;
	protected ims.framework.utils.Date dateofreferral;
	protected String referrallocation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
