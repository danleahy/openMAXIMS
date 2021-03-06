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
 * Linked to eDischarge.TTAMedicationAndPharmacy business object (ID: 1099100015).
 */
public class TTAMedicationAndPharmacyLiteVo extends ims.edischarge.vo.TTAMedicationAndPharmacyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TTAMedicationAndPharmacyLiteVo()
	{
	}
	public TTAMedicationAndPharmacyLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TTAMedicationAndPharmacyLiteVo(ims.clinical.vo.beans.TTAMedicationAndPharmacyLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.bodyweightkg = bean.getBodyWeightKg();
		this.clinicalcommentstopharmacy = bean.getClinicalCommentsToPharmacy();
		this.orderingdatetime = bean.getOrderingDateTime() == null ? null : bean.getOrderingDateTime().buildDateTime();
		this.clinicianbleepno = bean.getClinicianBleepNo();
		this.currentttastatus = bean.getCurrentTTAStatus() == null ? null : bean.getCurrentTTAStatus().buildVo();
		this.datesubmittedtopharmacy = bean.getDateSubmittedToPharmacy() == null ? null : bean.getDateSubmittedToPharmacy().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.TTAMedicationAndPharmacyLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.bodyweightkg = bean.getBodyWeightKg();
		this.clinicalcommentstopharmacy = bean.getClinicalCommentsToPharmacy();
		this.orderingdatetime = bean.getOrderingDateTime() == null ? null : bean.getOrderingDateTime().buildDateTime();
		this.clinicianbleepno = bean.getClinicianBleepNo();
		this.currentttastatus = bean.getCurrentTTAStatus() == null ? null : bean.getCurrentTTAStatus().buildVo(map);
		this.datesubmittedtopharmacy = bean.getDateSubmittedToPharmacy() == null ? null : bean.getDateSubmittedToPharmacy().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.TTAMedicationAndPharmacyLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.TTAMedicationAndPharmacyLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.TTAMedicationAndPharmacyLiteVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("BODYWEIGHTKG"))
			return getBodyWeightKg();
		if(fieldName.equals("CLINICALCOMMENTSTOPHARMACY"))
			return getClinicalCommentsToPharmacy();
		if(fieldName.equals("ORDERINGDATETIME"))
			return getOrderingDateTime();
		if(fieldName.equals("CLINICIANBLEEPNO"))
			return getClinicianBleepNo();
		if(fieldName.equals("CURRENTTTASTATUS"))
			return getCurrentTTAStatus();
		if(fieldName.equals("DATESUBMITTEDTOPHARMACY"))
			return getDateSubmittedToPharmacy();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextLiteVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextLiteVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getBodyWeightKgIsNotNull()
	{
		return this.bodyweightkg != null;
	}
	public Float getBodyWeightKg()
	{
		return this.bodyweightkg;
	}
	public void setBodyWeightKg(Float value)
	{
		this.isValidated = false;
		this.bodyweightkg = value;
	}
	public boolean getClinicalCommentsToPharmacyIsNotNull()
	{
		return this.clinicalcommentstopharmacy != null;
	}
	public String getClinicalCommentsToPharmacy()
	{
		return this.clinicalcommentstopharmacy;
	}
	public static int getClinicalCommentsToPharmacyMaxLength()
	{
		return 1500;
	}
	public void setClinicalCommentsToPharmacy(String value)
	{
		this.isValidated = false;
		this.clinicalcommentstopharmacy = value;
	}
	public boolean getOrderingDateTimeIsNotNull()
	{
		return this.orderingdatetime != null;
	}
	public ims.framework.utils.DateTime getOrderingDateTime()
	{
		return this.orderingdatetime;
	}
	public void setOrderingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.orderingdatetime = value;
	}
	public boolean getClinicianBleepNoIsNotNull()
	{
		return this.clinicianbleepno != null;
	}
	public String getClinicianBleepNo()
	{
		return this.clinicianbleepno;
	}
	public static int getClinicianBleepNoMaxLength()
	{
		return 25;
	}
	public void setClinicianBleepNo(String value)
	{
		this.isValidated = false;
		this.clinicianbleepno = value;
	}
	public boolean getCurrentTTAStatusIsNotNull()
	{
		return this.currentttastatus != null;
	}
	public ims.clinical.vo.TTAStatusVo getCurrentTTAStatus()
	{
		return this.currentttastatus;
	}
	public void setCurrentTTAStatus(ims.clinical.vo.TTAStatusVo value)
	{
		this.isValidated = false;
		this.currentttastatus = value;
	}
	public boolean getDateSubmittedToPharmacyIsNotNull()
	{
		return this.datesubmittedtopharmacy != null;
	}
	public ims.framework.utils.Date getDateSubmittedToPharmacy()
	{
		return this.datesubmittedtopharmacy;
	}
	public void setDateSubmittedToPharmacy(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datesubmittedtopharmacy = value;
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
		if(this.currentttastatus != null)
		{
			if(!this.currentttastatus.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.clinicalcommentstopharmacy != null)
			if(this.clinicalcommentstopharmacy.length() > 1500)
				listOfErrors.add("The length of the field [clinicalcommentstopharmacy] in the value object [ims.clinical.vo.TTAMedicationAndPharmacyLiteVo] is too big. It should be less or equal to 1500");
		if(this.clinicianbleepno != null)
			if(this.clinicianbleepno.length() > 25)
				listOfErrors.add("The length of the field [clinicianbleepno] in the value object [ims.clinical.vo.TTAMedicationAndPharmacyLiteVo] is too big. It should be less or equal to 25");
		if(this.currentttastatus != null)
		{
			String[] listOfOtherErrors = this.currentttastatus.validate();
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
	
		TTAMedicationAndPharmacyLiteVo clone = new TTAMedicationAndPharmacyLiteVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextLiteVo)this.carecontext.clone();
		clone.bodyweightkg = this.bodyweightkg;
		clone.clinicalcommentstopharmacy = this.clinicalcommentstopharmacy;
		if(this.orderingdatetime == null)
			clone.orderingdatetime = null;
		else
			clone.orderingdatetime = (ims.framework.utils.DateTime)this.orderingdatetime.clone();
		clone.clinicianbleepno = this.clinicianbleepno;
		if(this.currentttastatus == null)
			clone.currentttastatus = null;
		else
			clone.currentttastatus = (ims.clinical.vo.TTAStatusVo)this.currentttastatus.clone();
		if(this.datesubmittedtopharmacy == null)
			clone.datesubmittedtopharmacy = null;
		else
			clone.datesubmittedtopharmacy = (ims.framework.utils.Date)this.datesubmittedtopharmacy.clone();
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
		if (!(TTAMedicationAndPharmacyLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TTAMedicationAndPharmacyLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TTAMedicationAndPharmacyLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TTAMedicationAndPharmacyLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.bodyweightkg != null)
			count++;
		if(this.clinicalcommentstopharmacy != null)
			count++;
		if(this.orderingdatetime != null)
			count++;
		if(this.clinicianbleepno != null)
			count++;
		if(this.currentttastatus != null)
			count++;
		if(this.datesubmittedtopharmacy != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.PatientShort patient;
	protected ims.core.vo.CareContextLiteVo carecontext;
	protected Float bodyweightkg;
	protected String clinicalcommentstopharmacy;
	protected ims.framework.utils.DateTime orderingdatetime;
	protected String clinicianbleepno;
	protected ims.clinical.vo.TTAStatusVo currentttastatus;
	protected ims.framework.utils.Date datesubmittedtopharmacy;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
