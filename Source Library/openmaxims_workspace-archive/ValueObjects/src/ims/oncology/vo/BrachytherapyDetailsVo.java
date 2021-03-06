//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.oncology.vo;

/**
 * Linked to Oncology.BrachytherapyDetails business object (ID: 1074100020).
 */
public class BrachytherapyDetailsVo extends ims.oncology.vo.BrachytherapyDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public BrachytherapyDetailsVo()
	{
	}
	public BrachytherapyDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public BrachytherapyDetailsVo(ims.oncology.vo.beans.BrachytherapyDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.actualdoserate = bean.getActualDoseRate() == null ? null : ims.oncology.vo.lookups.BrachyTherapyDoseRate.buildLookup(bean.getActualDoseRate());
		this.brachytherapyisotopetype = bean.getBrachyTherapyIsotopeType() == null ? null : ims.oncology.vo.lookups.BrachyTherapyIsotopeType.buildLookup(bean.getBrachyTherapyIsotopeType());
		this.brachytherapyunsealedsourcetype = bean.getBrachyTherapyUnsealedSourceType() == null ? null : ims.oncology.vo.lookups.UnsealedSourceType.buildLookup(bean.getBrachyTherapyUnsealedSourceType());
		this.brachydeliverytype = bean.getBrachyDeliveryType() == null ? null : ims.oncology.vo.lookups.BrachytherapyDeliveryType.buildLookup(bean.getBrachyDeliveryType());
		this.patienttype = bean.getPatientType() == null ? null : ims.oncology.vo.lookups.BrachytherapyPatientType.buildLookup(bean.getPatientType());
		this.brachytherapytype = bean.getBrachytherapyType() == null ? null : ims.oncology.vo.lookups.BrachyTherapyType.buildLookup(bean.getBrachytherapyType());
		this.prescriptionpoint = bean.getPrescriptionPoint() == null ? null : ims.oncology.vo.lookups.BrachytherapyPrescriptionPoint.buildLookup(bean.getPrescriptionPoint());
		this.unit = bean.getUnit() == null ? null : ims.oncology.vo.lookups.BrachyTxType.buildLookup(bean.getUnit());
		this.treatmentdetails = ims.oncology.vo.BrachyTxTreatmentDetailsVoCollection.buildFromBeanCollection(bean.getTreatmentDetails());
		this.actualnrtreatments = bean.getActualNrTreatments();
		this.treatmentlength = bean.getTreatmentLength();
		this.totaldose = bean.getTotalDose();
		this.actualduration = bean.getActualDuration();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.BrachytherapyDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.actualdoserate = bean.getActualDoseRate() == null ? null : ims.oncology.vo.lookups.BrachyTherapyDoseRate.buildLookup(bean.getActualDoseRate());
		this.brachytherapyisotopetype = bean.getBrachyTherapyIsotopeType() == null ? null : ims.oncology.vo.lookups.BrachyTherapyIsotopeType.buildLookup(bean.getBrachyTherapyIsotopeType());
		this.brachytherapyunsealedsourcetype = bean.getBrachyTherapyUnsealedSourceType() == null ? null : ims.oncology.vo.lookups.UnsealedSourceType.buildLookup(bean.getBrachyTherapyUnsealedSourceType());
		this.brachydeliverytype = bean.getBrachyDeliveryType() == null ? null : ims.oncology.vo.lookups.BrachytherapyDeliveryType.buildLookup(bean.getBrachyDeliveryType());
		this.patienttype = bean.getPatientType() == null ? null : ims.oncology.vo.lookups.BrachytherapyPatientType.buildLookup(bean.getPatientType());
		this.brachytherapytype = bean.getBrachytherapyType() == null ? null : ims.oncology.vo.lookups.BrachyTherapyType.buildLookup(bean.getBrachytherapyType());
		this.prescriptionpoint = bean.getPrescriptionPoint() == null ? null : ims.oncology.vo.lookups.BrachytherapyPrescriptionPoint.buildLookup(bean.getPrescriptionPoint());
		this.unit = bean.getUnit() == null ? null : ims.oncology.vo.lookups.BrachyTxType.buildLookup(bean.getUnit());
		this.treatmentdetails = ims.oncology.vo.BrachyTxTreatmentDetailsVoCollection.buildFromBeanCollection(bean.getTreatmentDetails());
		this.actualnrtreatments = bean.getActualNrTreatments();
		this.treatmentlength = bean.getTreatmentLength();
		this.totaldose = bean.getTotalDose();
		this.actualduration = bean.getActualDuration();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.BrachytherapyDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.BrachytherapyDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.BrachytherapyDetailsVoBean();
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
		if(fieldName.equals("ACTUALDOSERATE"))
			return getActualDoseRate();
		if(fieldName.equals("BRACHYTHERAPYISOTOPETYPE"))
			return getBrachyTherapyIsotopeType();
		if(fieldName.equals("BRACHYTHERAPYUNSEALEDSOURCETYPE"))
			return getBrachyTherapyUnsealedSourceType();
		if(fieldName.equals("BRACHYDELIVERYTYPE"))
			return getBrachyDeliveryType();
		if(fieldName.equals("PATIENTTYPE"))
			return getPatientType();
		if(fieldName.equals("BRACHYTHERAPYTYPE"))
			return getBrachytherapyType();
		if(fieldName.equals("PRESCRIPTIONPOINT"))
			return getPrescriptionPoint();
		if(fieldName.equals("UNIT"))
			return getUnit();
		if(fieldName.equals("TREATMENTDETAILS"))
			return getTreatmentDetails();
		if(fieldName.equals("ACTUALNRTREATMENTS"))
			return getActualNrTreatments();
		if(fieldName.equals("TREATMENTLENGTH"))
			return getTreatmentLength();
		if(fieldName.equals("TOTALDOSE"))
			return getTotalDose();
		if(fieldName.equals("ACTUALDURATION"))
			return getActualDuration();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActualDoseRateIsNotNull()
	{
		return this.actualdoserate != null;
	}
	public ims.oncology.vo.lookups.BrachyTherapyDoseRate getActualDoseRate()
	{
		return this.actualdoserate;
	}
	public void setActualDoseRate(ims.oncology.vo.lookups.BrachyTherapyDoseRate value)
	{
		this.isValidated = false;
		this.actualdoserate = value;
	}
	public boolean getBrachyTherapyIsotopeTypeIsNotNull()
	{
		return this.brachytherapyisotopetype != null;
	}
	public ims.oncology.vo.lookups.BrachyTherapyIsotopeType getBrachyTherapyIsotopeType()
	{
		return this.brachytherapyisotopetype;
	}
	public void setBrachyTherapyIsotopeType(ims.oncology.vo.lookups.BrachyTherapyIsotopeType value)
	{
		this.isValidated = false;
		this.brachytherapyisotopetype = value;
	}
	public boolean getBrachyTherapyUnsealedSourceTypeIsNotNull()
	{
		return this.brachytherapyunsealedsourcetype != null;
	}
	public ims.oncology.vo.lookups.UnsealedSourceType getBrachyTherapyUnsealedSourceType()
	{
		return this.brachytherapyunsealedsourcetype;
	}
	public void setBrachyTherapyUnsealedSourceType(ims.oncology.vo.lookups.UnsealedSourceType value)
	{
		this.isValidated = false;
		this.brachytherapyunsealedsourcetype = value;
	}
	public boolean getBrachyDeliveryTypeIsNotNull()
	{
		return this.brachydeliverytype != null;
	}
	public ims.oncology.vo.lookups.BrachytherapyDeliveryType getBrachyDeliveryType()
	{
		return this.brachydeliverytype;
	}
	public void setBrachyDeliveryType(ims.oncology.vo.lookups.BrachytherapyDeliveryType value)
	{
		this.isValidated = false;
		this.brachydeliverytype = value;
	}
	public boolean getPatientTypeIsNotNull()
	{
		return this.patienttype != null;
	}
	public ims.oncology.vo.lookups.BrachytherapyPatientType getPatientType()
	{
		return this.patienttype;
	}
	public void setPatientType(ims.oncology.vo.lookups.BrachytherapyPatientType value)
	{
		this.isValidated = false;
		this.patienttype = value;
	}
	public boolean getBrachytherapyTypeIsNotNull()
	{
		return this.brachytherapytype != null;
	}
	public ims.oncology.vo.lookups.BrachyTherapyType getBrachytherapyType()
	{
		return this.brachytherapytype;
	}
	public void setBrachytherapyType(ims.oncology.vo.lookups.BrachyTherapyType value)
	{
		this.isValidated = false;
		this.brachytherapytype = value;
	}
	public boolean getPrescriptionPointIsNotNull()
	{
		return this.prescriptionpoint != null;
	}
	public ims.oncology.vo.lookups.BrachytherapyPrescriptionPoint getPrescriptionPoint()
	{
		return this.prescriptionpoint;
	}
	public void setPrescriptionPoint(ims.oncology.vo.lookups.BrachytherapyPrescriptionPoint value)
	{
		this.isValidated = false;
		this.prescriptionpoint = value;
	}
	public boolean getUnitIsNotNull()
	{
		return this.unit != null;
	}
	public ims.oncology.vo.lookups.BrachyTxType getUnit()
	{
		return this.unit;
	}
	public void setUnit(ims.oncology.vo.lookups.BrachyTxType value)
	{
		this.isValidated = false;
		this.unit = value;
	}
	public boolean getTreatmentDetailsIsNotNull()
	{
		return this.treatmentdetails != null;
	}
	public ims.oncology.vo.BrachyTxTreatmentDetailsVoCollection getTreatmentDetails()
	{
		return this.treatmentdetails;
	}
	public void setTreatmentDetails(ims.oncology.vo.BrachyTxTreatmentDetailsVoCollection value)
	{
		this.isValidated = false;
		this.treatmentdetails = value;
	}
	public boolean getActualNrTreatmentsIsNotNull()
	{
		return this.actualnrtreatments != null;
	}
	public Integer getActualNrTreatments()
	{
		return this.actualnrtreatments;
	}
	public void setActualNrTreatments(Integer value)
	{
		this.isValidated = false;
		this.actualnrtreatments = value;
	}
	public boolean getTreatmentLengthIsNotNull()
	{
		return this.treatmentlength != null;
	}
	public Integer getTreatmentLength()
	{
		return this.treatmentlength;
	}
	public void setTreatmentLength(Integer value)
	{
		this.isValidated = false;
		this.treatmentlength = value;
	}
	public boolean getTotalDoseIsNotNull()
	{
		return this.totaldose != null;
	}
	public Float getTotalDose()
	{
		return this.totaldose;
	}
	public void setTotalDose(Float value)
	{
		this.isValidated = false;
		this.totaldose = value;
	}
	public boolean getActualDurationIsNotNull()
	{
		return this.actualduration != null;
	}
	public Integer getActualDuration()
	{
		return this.actualduration;
	}
	public void setActualDuration(Integer value)
	{
		this.isValidated = false;
		this.actualduration = value;
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
		if(this.treatmentdetails != null)
		{
			if(!this.treatmentdetails.isValidated())
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
		if(this.brachytherapytype == null)
			listOfErrors.add("BrachytherapyType is mandatory");
		if(this.treatmentdetails != null)
		{
			String[] listOfOtherErrors = this.treatmentdetails.validate();
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
	
		BrachytherapyDetailsVo clone = new BrachytherapyDetailsVo(this.id, this.version);
		
		if(this.actualdoserate == null)
			clone.actualdoserate = null;
		else
			clone.actualdoserate = (ims.oncology.vo.lookups.BrachyTherapyDoseRate)this.actualdoserate.clone();
		if(this.brachytherapyisotopetype == null)
			clone.brachytherapyisotopetype = null;
		else
			clone.brachytherapyisotopetype = (ims.oncology.vo.lookups.BrachyTherapyIsotopeType)this.brachytherapyisotopetype.clone();
		if(this.brachytherapyunsealedsourcetype == null)
			clone.brachytherapyunsealedsourcetype = null;
		else
			clone.brachytherapyunsealedsourcetype = (ims.oncology.vo.lookups.UnsealedSourceType)this.brachytherapyunsealedsourcetype.clone();
		if(this.brachydeliverytype == null)
			clone.brachydeliverytype = null;
		else
			clone.brachydeliverytype = (ims.oncology.vo.lookups.BrachytherapyDeliveryType)this.brachydeliverytype.clone();
		if(this.patienttype == null)
			clone.patienttype = null;
		else
			clone.patienttype = (ims.oncology.vo.lookups.BrachytherapyPatientType)this.patienttype.clone();
		if(this.brachytherapytype == null)
			clone.brachytherapytype = null;
		else
			clone.brachytherapytype = (ims.oncology.vo.lookups.BrachyTherapyType)this.brachytherapytype.clone();
		if(this.prescriptionpoint == null)
			clone.prescriptionpoint = null;
		else
			clone.prescriptionpoint = (ims.oncology.vo.lookups.BrachytherapyPrescriptionPoint)this.prescriptionpoint.clone();
		if(this.unit == null)
			clone.unit = null;
		else
			clone.unit = (ims.oncology.vo.lookups.BrachyTxType)this.unit.clone();
		if(this.treatmentdetails == null)
			clone.treatmentdetails = null;
		else
			clone.treatmentdetails = (ims.oncology.vo.BrachyTxTreatmentDetailsVoCollection)this.treatmentdetails.clone();
		clone.actualnrtreatments = this.actualnrtreatments;
		clone.treatmentlength = this.treatmentlength;
		clone.totaldose = this.totaldose;
		clone.actualduration = this.actualduration;
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
		if (!(BrachytherapyDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A BrachytherapyDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((BrachytherapyDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((BrachytherapyDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.actualdoserate != null)
			count++;
		if(this.brachytherapyisotopetype != null)
			count++;
		if(this.brachytherapyunsealedsourcetype != null)
			count++;
		if(this.brachydeliverytype != null)
			count++;
		if(this.patienttype != null)
			count++;
		if(this.brachytherapytype != null)
			count++;
		if(this.prescriptionpoint != null)
			count++;
		if(this.unit != null)
			count++;
		if(this.treatmentdetails != null)
			count++;
		if(this.actualnrtreatments != null)
			count++;
		if(this.treatmentlength != null)
			count++;
		if(this.totaldose != null)
			count++;
		if(this.actualduration != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.oncology.vo.lookups.BrachyTherapyDoseRate actualdoserate;
	protected ims.oncology.vo.lookups.BrachyTherapyIsotopeType brachytherapyisotopetype;
	protected ims.oncology.vo.lookups.UnsealedSourceType brachytherapyunsealedsourcetype;
	protected ims.oncology.vo.lookups.BrachytherapyDeliveryType brachydeliverytype;
	protected ims.oncology.vo.lookups.BrachytherapyPatientType patienttype;
	protected ims.oncology.vo.lookups.BrachyTherapyType brachytherapytype;
	protected ims.oncology.vo.lookups.BrachytherapyPrescriptionPoint prescriptionpoint;
	protected ims.oncology.vo.lookups.BrachyTxType unit;
	protected ims.oncology.vo.BrachyTxTreatmentDetailsVoCollection treatmentdetails;
	protected Integer actualnrtreatments;
	protected Integer treatmentlength;
	protected Float totaldose;
	protected Integer actualduration;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
