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

package ims.ntpf.vo;

/**
 * Linked to NTPF.LoCall.LoCallWaitingListDetails business object (ID: 1039100002).
 */
public class LoCallWaitingListDetailsVo extends ims.ntpf.vo.LoCallWaitingListDetailsMediumVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public LoCallWaitingListDetailsVo()
	{
	}
	public LoCallWaitingListDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public LoCallWaitingListDetailsVo(ims.ntpf.vo.beans.LoCallWaitingListDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.statushistory = ims.ntpf.vo.LoCallStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.ntpf.vo.lookups.LoCallStatus.buildLookup(bean.getCurrentStatus());
		this.currentstatusreason = bean.getCurrentStatusReason() == null ? null : ims.ntpf.vo.lookups.LoCallStatus.buildLookup(bean.getCurrentStatusReason());
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.proceduretext = bean.getProcedureText();
		this.assoclocall = bean.getAssocLocall() == null ? null : new ims.ntpf.locall.vo.LoCallRefVo(new Integer(bean.getAssocLocall().getId()), bean.getAssocLocall().getVersion());
		this.assoccase = bean.getAssocCase() == null ? null : new ims.ntpf.casereferral.vo.CaseReferralRefVo(new Integer(bean.getAssocCase().getId()), bean.getAssocCase().getVersion());
		this.speciality = bean.getSpeciality() == null ? null : bean.getSpeciality().buildVo();
		this.referringhospital = bean.getReferringHospital() == null ? null : bean.getReferringHospital().buildVo();
		this.referringconsultant = bean.getReferringConsultant() == null ? null : bean.getReferringConsultant().buildVo();
		this.referringconsultanttext = bean.getReferringConsultantText();
		this.category = bean.getCategory() == null ? null : ims.ntpf.vo.lookups.PatientType.buildLookup(bean.getCategory());
		this.waitinglisttype = bean.getWaitingListType() == null ? null : ims.ntpf.vo.lookups.CaseType.buildLookup(bean.getWaitingListType());
		this.waitinglistdate = bean.getWaitingListDate() == null ? null : bean.getWaitingListDate().buildDate();
		this.waitinglistmonthinterval = bean.getWaitingListMonthInterval();
		this.waitinglistlengthqualifier = bean.getWaitingListLengthQualifier() == null ? null : ims.ntpf.vo.lookups.WaitingListLengthQualifier.buildLookup(bean.getWaitingListLengthQualifier());
		this.faxto = bean.getFaxTo() == null ? null : bean.getFaxTo().buildVo();
		this.faxdate = bean.getFaxDate() == null ? null : bean.getFaxDate().buildDate();
		this.liaisonquery = bean.getLiaisonQuery();
		this.islinkedtocase = bean.getIsLinkedtoCase();
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
		this.mrn = bean.getMrn();
		this.episodenumber = bean.getEpisodeNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ntpf.vo.beans.LoCallWaitingListDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.statushistory = ims.ntpf.vo.LoCallStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.ntpf.vo.lookups.LoCallStatus.buildLookup(bean.getCurrentStatus());
		this.currentstatusreason = bean.getCurrentStatusReason() == null ? null : ims.ntpf.vo.lookups.LoCallStatus.buildLookup(bean.getCurrentStatusReason());
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.proceduretext = bean.getProcedureText();
		this.assoclocall = bean.getAssocLocall() == null ? null : new ims.ntpf.locall.vo.LoCallRefVo(new Integer(bean.getAssocLocall().getId()), bean.getAssocLocall().getVersion());
		this.assoccase = bean.getAssocCase() == null ? null : new ims.ntpf.casereferral.vo.CaseReferralRefVo(new Integer(bean.getAssocCase().getId()), bean.getAssocCase().getVersion());
		this.speciality = bean.getSpeciality() == null ? null : bean.getSpeciality().buildVo(map);
		this.referringhospital = bean.getReferringHospital() == null ? null : bean.getReferringHospital().buildVo(map);
		this.referringconsultant = bean.getReferringConsultant() == null ? null : bean.getReferringConsultant().buildVo(map);
		this.referringconsultanttext = bean.getReferringConsultantText();
		this.category = bean.getCategory() == null ? null : ims.ntpf.vo.lookups.PatientType.buildLookup(bean.getCategory());
		this.waitinglisttype = bean.getWaitingListType() == null ? null : ims.ntpf.vo.lookups.CaseType.buildLookup(bean.getWaitingListType());
		this.waitinglistdate = bean.getWaitingListDate() == null ? null : bean.getWaitingListDate().buildDate();
		this.waitinglistmonthinterval = bean.getWaitingListMonthInterval();
		this.waitinglistlengthqualifier = bean.getWaitingListLengthQualifier() == null ? null : ims.ntpf.vo.lookups.WaitingListLengthQualifier.buildLookup(bean.getWaitingListLengthQualifier());
		this.faxto = bean.getFaxTo() == null ? null : bean.getFaxTo().buildVo(map);
		this.faxdate = bean.getFaxDate() == null ? null : bean.getFaxDate().buildDate();
		this.liaisonquery = bean.getLiaisonQuery();
		this.islinkedtocase = bean.getIsLinkedtoCase();
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
		this.mrn = bean.getMrn();
		this.episodenumber = bean.getEpisodeNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ntpf.vo.beans.LoCallWaitingListDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.ntpf.vo.beans.LoCallWaitingListDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ntpf.vo.beans.LoCallWaitingListDetailsVoBean();
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
		if(fieldName.equals("SPECIALITY"))
			return getSpeciality();
		if(fieldName.equals("REFERRINGHOSPITAL"))
			return getReferringHospital();
		if(fieldName.equals("REFERRINGCONSULTANT"))
			return getReferringConsultant();
		if(fieldName.equals("REFERRINGCONSULTANTTEXT"))
			return getReferringConsultantText();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("WAITINGLISTTYPE"))
			return getWaitingListType();
		if(fieldName.equals("WAITINGLISTDATE"))
			return getWaitingListDate();
		if(fieldName.equals("WAITINGLISTMONTHINTERVAL"))
			return getWaitingListMonthInterval();
		if(fieldName.equals("WAITINGLISTLENGTHQUALIFIER"))
			return getWaitingListLengthQualifier();
		if(fieldName.equals("FAXTO"))
			return getFaxTo();
		if(fieldName.equals("FAXDATE"))
			return getFaxDate();
		if(fieldName.equals("LIAISONQUERY"))
			return getLiaisonQuery();
		if(fieldName.equals("ISLINKEDTOCASE"))
			return getIsLinkedtoCase();
		if(fieldName.equals("HOSPITAL"))
			return getHospital();
		if(fieldName.equals("MRN"))
			return getMrn();
		if(fieldName.equals("EPISODENUMBER"))
			return getEpisodeNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpecialityIsNotNull()
	{
		return this.speciality != null;
	}
	public ims.core.vo.ServiceVo getSpeciality()
	{
		return this.speciality;
	}
	public void setSpeciality(ims.core.vo.ServiceVo value)
	{
		this.isValidated = false;
		this.speciality = value;
	}
	public boolean getReferringHospitalIsNotNull()
	{
		return this.referringhospital != null;
	}
	public ims.core.vo.LocationLiteVo getReferringHospital()
	{
		return this.referringhospital;
	}
	public void setReferringHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.referringhospital = value;
	}
	public boolean getReferringConsultantIsNotNull()
	{
		return this.referringconsultant != null;
	}
	public ims.core.vo.MedicVo getReferringConsultant()
	{
		return this.referringconsultant;
	}
	public void setReferringConsultant(ims.core.vo.MedicVo value)
	{
		this.isValidated = false;
		this.referringconsultant = value;
	}
	public boolean getReferringConsultantTextIsNotNull()
	{
		return this.referringconsultanttext != null;
	}
	public String getReferringConsultantText()
	{
		return this.referringconsultanttext;
	}
	public static int getReferringConsultantTextMaxLength()
	{
		return 255;
	}
	public void setReferringConsultantText(String value)
	{
		this.isValidated = false;
		this.referringconsultanttext = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.ntpf.vo.lookups.PatientType getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.ntpf.vo.lookups.PatientType value)
	{
		this.isValidated = false;
		this.category = value;
	}
	public boolean getWaitingListTypeIsNotNull()
	{
		return this.waitinglisttype != null;
	}
	public ims.ntpf.vo.lookups.CaseType getWaitingListType()
	{
		return this.waitinglisttype;
	}
	public void setWaitingListType(ims.ntpf.vo.lookups.CaseType value)
	{
		this.isValidated = false;
		this.waitinglisttype = value;
	}
	public boolean getWaitingListDateIsNotNull()
	{
		return this.waitinglistdate != null;
	}
	public ims.framework.utils.Date getWaitingListDate()
	{
		return this.waitinglistdate;
	}
	public void setWaitingListDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.waitinglistdate = value;
	}
	public boolean getWaitingListMonthIntervalIsNotNull()
	{
		return this.waitinglistmonthinterval != null;
	}
	public Integer getWaitingListMonthInterval()
	{
		return this.waitinglistmonthinterval;
	}
	public void setWaitingListMonthInterval(Integer value)
	{
		this.isValidated = false;
		this.waitinglistmonthinterval = value;
	}
	public boolean getWaitingListLengthQualifierIsNotNull()
	{
		return this.waitinglistlengthqualifier != null;
	}
	public ims.ntpf.vo.lookups.WaitingListLengthQualifier getWaitingListLengthQualifier()
	{
		return this.waitinglistlengthqualifier;
	}
	public void setWaitingListLengthQualifier(ims.ntpf.vo.lookups.WaitingListLengthQualifier value)
	{
		this.isValidated = false;
		this.waitinglistlengthqualifier = value;
	}
	public boolean getFaxToIsNotNull()
	{
		return this.faxto != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getFaxTo()
	{
		return this.faxto;
	}
	public void setFaxTo(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.faxto = value;
	}
	public boolean getFaxDateIsNotNull()
	{
		return this.faxdate != null;
	}
	public ims.framework.utils.Date getFaxDate()
	{
		return this.faxdate;
	}
	public void setFaxDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.faxdate = value;
	}
	public boolean getLiaisonQueryIsNotNull()
	{
		return this.liaisonquery != null;
	}
	public String getLiaisonQuery()
	{
		return this.liaisonquery;
	}
	public static int getLiaisonQueryMaxLength()
	{
		return 255;
	}
	public void setLiaisonQuery(String value)
	{
		this.isValidated = false;
		this.liaisonquery = value;
	}
	public boolean getIsLinkedtoCaseIsNotNull()
	{
		return this.islinkedtocase != null;
	}
	public Boolean getIsLinkedtoCase()
	{
		return this.islinkedtocase;
	}
	public void setIsLinkedtoCase(Boolean value)
	{
		this.isValidated = false;
		this.islinkedtocase = value;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getMrnIsNotNull()
	{
		return this.mrn != null;
	}
	public String getMrn()
	{
		return this.mrn;
	}
	public static int getMrnMaxLength()
	{
		return 50;
	}
	public void setMrn(String value)
	{
		this.isValidated = false;
		this.mrn = value;
	}
	public boolean getEpisodeNumberIsNotNull()
	{
		return this.episodenumber != null;
	}
	public String getEpisodeNumber()
	{
		return this.episodenumber;
	}
	public static int getEpisodeNumberMaxLength()
	{
		return 50;
	}
	public void setEpisodeNumber(String value)
	{
		this.isValidated = false;
		this.episodenumber = value;
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
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.procedure != null)
		{
			if(!this.procedure.isValidated())
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
		if(this.statushistory != null)
		{
			String[] listOfOtherErrors = this.statushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.procedure != null)
		{
			String[] listOfOtherErrors = this.procedure.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.proceduretext != null)
			if(this.proceduretext.length() > 255)
				listOfErrors.add("The length of the field [proceduretext] in the value object [ims.ntpf.vo.LoCallWaitingListDetailsVo] is too big. It should be less or equal to 255");
		if(this.referringconsultanttext != null)
			if(this.referringconsultanttext.length() > 255)
				listOfErrors.add("The length of the field [referringconsultanttext] in the value object [ims.ntpf.vo.LoCallWaitingListDetailsVo] is too big. It should be less or equal to 255");
		if(this.liaisonquery != null)
			if(this.liaisonquery.length() > 255)
				listOfErrors.add("The length of the field [liaisonquery] in the value object [ims.ntpf.vo.LoCallWaitingListDetailsVo] is too big. It should be less or equal to 255");
		if(this.mrn != null)
			if(this.mrn.length() > 50)
				listOfErrors.add("The length of the field [mrn] in the value object [ims.ntpf.vo.LoCallWaitingListDetailsVo] is too big. It should be less or equal to 50");
		if(this.episodenumber != null)
			if(this.episodenumber.length() > 50)
				listOfErrors.add("The length of the field [episodenumber] in the value object [ims.ntpf.vo.LoCallWaitingListDetailsVo] is too big. It should be less or equal to 50");
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
	
		LoCallWaitingListDetailsVo clone = new LoCallWaitingListDetailsVo(this.id, this.version);
		
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.ntpf.vo.LoCallStatusVoCollection)this.statushistory.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.ntpf.vo.lookups.LoCallStatus)this.currentstatus.clone();
		if(this.currentstatusreason == null)
			clone.currentstatusreason = null;
		else
			clone.currentstatusreason = (ims.ntpf.vo.lookups.LoCallStatus)this.currentstatusreason.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ActivityVo)this.procedure.clone();
		clone.proceduretext = this.proceduretext;
		clone.assoclocall = this.assoclocall;
		clone.assoccase = this.assoccase;
		if(this.speciality == null)
			clone.speciality = null;
		else
			clone.speciality = (ims.core.vo.ServiceVo)this.speciality.clone();
		if(this.referringhospital == null)
			clone.referringhospital = null;
		else
			clone.referringhospital = (ims.core.vo.LocationLiteVo)this.referringhospital.clone();
		if(this.referringconsultant == null)
			clone.referringconsultant = null;
		else
			clone.referringconsultant = (ims.core.vo.MedicVo)this.referringconsultant.clone();
		clone.referringconsultanttext = this.referringconsultanttext;
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.ntpf.vo.lookups.PatientType)this.category.clone();
		if(this.waitinglisttype == null)
			clone.waitinglisttype = null;
		else
			clone.waitinglisttype = (ims.ntpf.vo.lookups.CaseType)this.waitinglisttype.clone();
		if(this.waitinglistdate == null)
			clone.waitinglistdate = null;
		else
			clone.waitinglistdate = (ims.framework.utils.Date)this.waitinglistdate.clone();
		clone.waitinglistmonthinterval = this.waitinglistmonthinterval;
		if(this.waitinglistlengthqualifier == null)
			clone.waitinglistlengthqualifier = null;
		else
			clone.waitinglistlengthqualifier = (ims.ntpf.vo.lookups.WaitingListLengthQualifier)this.waitinglistlengthqualifier.clone();
		if(this.faxto == null)
			clone.faxto = null;
		else
			clone.faxto = (ims.core.vo.MemberOfStaffShortVo)this.faxto.clone();
		if(this.faxdate == null)
			clone.faxdate = null;
		else
			clone.faxdate = (ims.framework.utils.Date)this.faxdate.clone();
		clone.liaisonquery = this.liaisonquery;
		clone.islinkedtocase = this.islinkedtocase;
		clone.hospital = this.hospital;
		clone.mrn = this.mrn;
		clone.episodenumber = this.episodenumber;
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
		if (!(LoCallWaitingListDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A LoCallWaitingListDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		LoCallWaitingListDetailsVo compareObj = (LoCallWaitingListDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getWaitingListDate() == null && compareObj.getWaitingListDate() != null)
				return -1;
			if(this.getWaitingListDate() != null && compareObj.getWaitingListDate() == null)
				return 1;
			if(this.getWaitingListDate() != null && compareObj.getWaitingListDate() != null)
				retVal = this.getWaitingListDate().compareTo(compareObj.getWaitingListDate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.speciality != null)
			count++;
		if(this.referringhospital != null)
			count++;
		if(this.referringconsultant != null)
			count++;
		if(this.referringconsultanttext != null)
			count++;
		if(this.category != null)
			count++;
		if(this.waitinglisttype != null)
			count++;
		if(this.waitinglistdate != null)
			count++;
		if(this.waitinglistmonthinterval != null)
			count++;
		if(this.waitinglistlengthqualifier != null)
			count++;
		if(this.faxto != null)
			count++;
		if(this.faxdate != null)
			count++;
		if(this.liaisonquery != null)
			count++;
		if(this.islinkedtocase != null)
			count++;
		if(this.hospital != null)
			count++;
		if(this.mrn != null)
			count++;
		if(this.episodenumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 16;
	}
	protected ims.core.vo.ServiceVo speciality;
	protected ims.core.vo.LocationLiteVo referringhospital;
	protected ims.core.vo.MedicVo referringconsultant;
	protected String referringconsultanttext;
	protected ims.ntpf.vo.lookups.PatientType category;
	protected ims.ntpf.vo.lookups.CaseType waitinglisttype;
	protected ims.framework.utils.Date waitinglistdate;
	protected Integer waitinglistmonthinterval;
	protected ims.ntpf.vo.lookups.WaitingListLengthQualifier waitinglistlengthqualifier;
	protected ims.core.vo.MemberOfStaffShortVo faxto;
	protected ims.framework.utils.Date faxdate;
	protected String liaisonquery;
	protected Boolean islinkedtocase;
	protected ims.core.resource.place.vo.LocationRefVo hospital;
	protected String mrn;
	protected String episodenumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
