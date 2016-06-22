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

package ims.nursing.vo;

/**
 * Linked to nursing.AdmissionDetails business object (ID: 1009100010).
 */
public class AdmissionDetailsVo extends ims.nursing.vo.AdmissionDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdmissionDetailsVo()
	{
	}
	public AdmissionDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdmissionDetailsVo(ims.nursing.vo.beans.AdmissionDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.patientadmreason = bean.getPatientAdmReason();
		this.nursingadmreason = bean.getNursingAdmReason();
		this.resusstatus = bean.getResusStatus() == null ? null : ims.core.vo.lookups.ResuscitationStatus.buildLookup(bean.getResusStatus());
		this.isdnrformcompleted = bean.getIsDnrFormCompleted();
		this.admquestionsans = ims.nursing.vo.AdmissionDetailsQuestionsVoCollection.buildFromBeanCollection(bean.getAdmQuestionsAns());
		this.wasdiagnosisdiscussed = bean.getWasDiagnosisDiscussed();
		this.communicationneeds = bean.getCommunicationNeeds();
		this.preferredlang = bean.getPreferredLang() == null ? null : ims.nursing.vo.lookups.PreferredLanguage.buildLookup(bean.getPreferredLang());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.AdmissionDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.patientadmreason = bean.getPatientAdmReason();
		this.nursingadmreason = bean.getNursingAdmReason();
		this.resusstatus = bean.getResusStatus() == null ? null : ims.core.vo.lookups.ResuscitationStatus.buildLookup(bean.getResusStatus());
		this.isdnrformcompleted = bean.getIsDnrFormCompleted();
		this.admquestionsans = ims.nursing.vo.AdmissionDetailsQuestionsVoCollection.buildFromBeanCollection(bean.getAdmQuestionsAns());
		this.wasdiagnosisdiscussed = bean.getWasDiagnosisDiscussed();
		this.communicationneeds = bean.getCommunicationNeeds();
		this.preferredlang = bean.getPreferredLang() == null ? null : ims.nursing.vo.lookups.PreferredLanguage.buildLookup(bean.getPreferredLang());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.AdmissionDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.AdmissionDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.AdmissionDetailsVoBean();
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
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("PATIENTADMREASON"))
			return getPatientAdmReason();
		if(fieldName.equals("NURSINGADMREASON"))
			return getNursingAdmReason();
		if(fieldName.equals("RESUSSTATUS"))
			return getResusStatus();
		if(fieldName.equals("ISDNRFORMCOMPLETED"))
			return getIsDnrFormCompleted();
		if(fieldName.equals("ADMQUESTIONSANS"))
			return getAdmQuestionsAns();
		if(fieldName.equals("WASDIAGNOSISDISCUSSED"))
			return getWasDiagnosisDiscussed();
		if(fieldName.equals("COMMUNICATIONNEEDS"))
			return getCommunicationNeeds();
		if(fieldName.equals("PREFERREDLANG"))
			return getPreferredLang();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
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
	public boolean getPatientAdmReasonIsNotNull()
	{
		return this.patientadmreason != null;
	}
	public String getPatientAdmReason()
	{
		return this.patientadmreason;
	}
	public static int getPatientAdmReasonMaxLength()
	{
		return 255;
	}
	public void setPatientAdmReason(String value)
	{
		this.isValidated = false;
		this.patientadmreason = value;
	}
	public boolean getNursingAdmReasonIsNotNull()
	{
		return this.nursingadmreason != null;
	}
	public String getNursingAdmReason()
	{
		return this.nursingadmreason;
	}
	public static int getNursingAdmReasonMaxLength()
	{
		return 255;
	}
	public void setNursingAdmReason(String value)
	{
		this.isValidated = false;
		this.nursingadmreason = value;
	}
	public boolean getResusStatusIsNotNull()
	{
		return this.resusstatus != null;
	}
	public ims.core.vo.lookups.ResuscitationStatus getResusStatus()
	{
		return this.resusstatus;
	}
	public void setResusStatus(ims.core.vo.lookups.ResuscitationStatus value)
	{
		this.isValidated = false;
		this.resusstatus = value;
	}
	public boolean getIsDnrFormCompletedIsNotNull()
	{
		return this.isdnrformcompleted != null;
	}
	public Boolean getIsDnrFormCompleted()
	{
		return this.isdnrformcompleted;
	}
	public void setIsDnrFormCompleted(Boolean value)
	{
		this.isValidated = false;
		this.isdnrformcompleted = value;
	}
	public boolean getAdmQuestionsAnsIsNotNull()
	{
		return this.admquestionsans != null;
	}
	public ims.nursing.vo.AdmissionDetailsQuestionsVoCollection getAdmQuestionsAns()
	{
		return this.admquestionsans;
	}
	public void setAdmQuestionsAns(ims.nursing.vo.AdmissionDetailsQuestionsVoCollection value)
	{
		this.isValidated = false;
		this.admquestionsans = value;
	}
	public boolean getWasDiagnosisDiscussedIsNotNull()
	{
		return this.wasdiagnosisdiscussed != null;
	}
	public Boolean getWasDiagnosisDiscussed()
	{
		return this.wasdiagnosisdiscussed;
	}
	public void setWasDiagnosisDiscussed(Boolean value)
	{
		this.isValidated = false;
		this.wasdiagnosisdiscussed = value;
	}
	public boolean getCommunicationNeedsIsNotNull()
	{
		return this.communicationneeds != null;
	}
	public String getCommunicationNeeds()
	{
		return this.communicationneeds;
	}
	public static int getCommunicationNeedsMaxLength()
	{
		return 255;
	}
	public void setCommunicationNeeds(String value)
	{
		this.isValidated = false;
		this.communicationneeds = value;
	}
	public boolean getPreferredLangIsNotNull()
	{
		return this.preferredlang != null;
	}
	public ims.nursing.vo.lookups.PreferredLanguage getPreferredLang()
	{
		return this.preferredlang;
	}
	public void setPreferredLang(ims.nursing.vo.lookups.PreferredLanguage value)
	{
		this.isValidated = false;
		this.preferredlang = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.admquestionsans != null)
		{
			if(!this.admquestionsans.isValidated())
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.patientadmreason != null)
			if(this.patientadmreason.length() > 255)
				listOfErrors.add("The length of the field [patientadmreason] in the value object [ims.nursing.vo.AdmissionDetailsVo] is too big. It should be less or equal to 255");
		if(this.nursingadmreason != null)
			if(this.nursingadmreason.length() > 255)
				listOfErrors.add("The length of the field [nursingadmreason] in the value object [ims.nursing.vo.AdmissionDetailsVo] is too big. It should be less or equal to 255");
		if(this.resusstatus == null)
			listOfErrors.add("ResusStatus is mandatory");
		if(this.admquestionsans != null)
		{
			String[] listOfOtherErrors = this.admquestionsans.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.communicationneeds != null)
			if(this.communicationneeds.length() > 255)
				listOfErrors.add("The length of the field [communicationneeds] in the value object [ims.nursing.vo.AdmissionDetailsVo] is too big. It should be less or equal to 255");
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
	
		AdmissionDetailsVo clone = new AdmissionDetailsVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.carecontext = this.carecontext;
		clone.clinicalcontact = this.clinicalcontact;
		clone.patientadmreason = this.patientadmreason;
		clone.nursingadmreason = this.nursingadmreason;
		if(this.resusstatus == null)
			clone.resusstatus = null;
		else
			clone.resusstatus = (ims.core.vo.lookups.ResuscitationStatus)this.resusstatus.clone();
		clone.isdnrformcompleted = this.isdnrformcompleted;
		if(this.admquestionsans == null)
			clone.admquestionsans = null;
		else
			clone.admquestionsans = (ims.nursing.vo.AdmissionDetailsQuestionsVoCollection)this.admquestionsans.clone();
		clone.wasdiagnosisdiscussed = this.wasdiagnosisdiscussed;
		clone.communicationneeds = this.communicationneeds;
		if(this.preferredlang == null)
			clone.preferredlang = null;
		else
			clone.preferredlang = (ims.nursing.vo.lookups.PreferredLanguage)this.preferredlang.clone();
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
		if (!(AdmissionDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdmissionDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdmissionDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdmissionDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.patientadmreason != null)
			count++;
		if(this.nursingadmreason != null)
			count++;
		if(this.resusstatus != null)
			count++;
		if(this.isdnrformcompleted != null)
			count++;
		if(this.admquestionsans != null)
			count++;
		if(this.wasdiagnosisdiscussed != null)
			count++;
		if(this.communicationneeds != null)
			count++;
		if(this.preferredlang != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected String patientadmreason;
	protected String nursingadmreason;
	protected ims.core.vo.lookups.ResuscitationStatus resusstatus;
	protected Boolean isdnrformcompleted;
	protected ims.nursing.vo.AdmissionDetailsQuestionsVoCollection admquestionsans;
	protected Boolean wasdiagnosisdiscussed;
	protected String communicationneeds;
	protected ims.nursing.vo.lookups.PreferredLanguage preferredlang;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
