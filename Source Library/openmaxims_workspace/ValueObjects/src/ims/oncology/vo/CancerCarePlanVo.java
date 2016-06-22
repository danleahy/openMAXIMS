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

package ims.oncology.vo;

/**
 * Linked to Oncology.CancerCarePlan business object (ID: 1074100016).
 */
public class CancerCarePlanVo extends ims.oncology.vo.CancerCarePlanShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CancerCarePlanVo()
	{
	}
	public CancerCarePlanVo(Integer id, int version)
	{
		super(id, version);
	}
	public CancerCarePlanVo(ims.oncology.vo.beans.CancerCarePlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.careplandate = bean.getCarePlanDate() == null ? null : bean.getCarePlanDate().buildDate();
		this.consultantincharge = bean.getConsultantInCharge() == null ? null : bean.getConsultantInCharge().buildVo();
		this.careplanintent = bean.getCarePlanIntent() == null ? null : ims.oncology.vo.lookups.CarePlanIntent.buildLookup(bean.getCarePlanIntent());
		this.recurrenceindicator = bean.getRecurrenceIndicator() == null ? null : ims.oncology.vo.lookups.RecurrenceIndicator.buildLookup(bean.getRecurrenceIndicator());
		this.iscurrent = bean.getIsCurrent();
		this.mdtmeeting = bean.getMdtMeeting() == null ? null : bean.getMdtMeeting().buildVo();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.careplannotes = bean.getCarePlanNotes();
		this.treatmentmodalities = ims.oncology.vo.TreatmentModalitiesVoCollection.buildFromBeanCollection(bean.getTreatmentModalities());
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.oncology.vo.lookups.CarePlanCurrentStatus.buildLookup(bean.getCurrentStatus());
		this.agreeddate = bean.getAgreedDate() == null ? null : bean.getAgreedDate().buildDate();
		this.reasonpatientplandiffmdt = bean.getReasonPatientPlanDiffMDT();
		this.noanticancertxreason = ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection.buildFromBeanCollection(bean.getNoAntiCancerTxReason());
		this.hasassociatedmdtmeeting = bean.getHasAssociatedMDTMeeting();
		this.reasonforrevision = bean.getReasonForRevision();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.CancerCarePlanVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.careplandate = bean.getCarePlanDate() == null ? null : bean.getCarePlanDate().buildDate();
		this.consultantincharge = bean.getConsultantInCharge() == null ? null : bean.getConsultantInCharge().buildVo(map);
		this.careplanintent = bean.getCarePlanIntent() == null ? null : ims.oncology.vo.lookups.CarePlanIntent.buildLookup(bean.getCarePlanIntent());
		this.recurrenceindicator = bean.getRecurrenceIndicator() == null ? null : ims.oncology.vo.lookups.RecurrenceIndicator.buildLookup(bean.getRecurrenceIndicator());
		this.iscurrent = bean.getIsCurrent();
		this.mdtmeeting = bean.getMdtMeeting() == null ? null : bean.getMdtMeeting().buildVo(map);
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.careplannotes = bean.getCarePlanNotes();
		this.treatmentmodalities = ims.oncology.vo.TreatmentModalitiesVoCollection.buildFromBeanCollection(bean.getTreatmentModalities());
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.oncology.vo.lookups.CarePlanCurrentStatus.buildLookup(bean.getCurrentStatus());
		this.agreeddate = bean.getAgreedDate() == null ? null : bean.getAgreedDate().buildDate();
		this.reasonpatientplandiffmdt = bean.getReasonPatientPlanDiffMDT();
		this.noanticancertxreason = ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection.buildFromBeanCollection(bean.getNoAntiCancerTxReason());
		this.hasassociatedmdtmeeting = bean.getHasAssociatedMDTMeeting();
		this.reasonforrevision = bean.getReasonForRevision();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.CancerCarePlanVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.CancerCarePlanVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.CancerCarePlanVoBean();
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
		if(fieldName.equals("TREATMENTMODALITIES"))
			return getTreatmentModalities();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("AGREEDDATE"))
			return getAgreedDate();
		if(fieldName.equals("REASONPATIENTPLANDIFFMDT"))
			return getReasonPatientPlanDiffMDT();
		if(fieldName.equals("NOANTICANCERTXREASON"))
			return getNoAntiCancerTxReason();
		if(fieldName.equals("HASASSOCIATEDMDTMEETING"))
			return getHasAssociatedMDTMeeting();
		if(fieldName.equals("REASONFORREVISION"))
			return getReasonForRevision();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatmentModalitiesIsNotNull()
	{
		return this.treatmentmodalities != null;
	}
	public ims.oncology.vo.TreatmentModalitiesVoCollection getTreatmentModalities()
	{
		return this.treatmentmodalities;
	}
	public void setTreatmentModalities(ims.oncology.vo.TreatmentModalitiesVoCollection value)
	{
		this.isValidated = false;
		this.treatmentmodalities = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.oncology.vo.lookups.CarePlanCurrentStatus getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.oncology.vo.lookups.CarePlanCurrentStatus value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getAgreedDateIsNotNull()
	{
		return this.agreeddate != null;
	}
	public ims.framework.utils.Date getAgreedDate()
	{
		return this.agreeddate;
	}
	public void setAgreedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.agreeddate = value;
	}
	public boolean getReasonPatientPlanDiffMDTIsNotNull()
	{
		return this.reasonpatientplandiffmdt != null;
	}
	public String getReasonPatientPlanDiffMDT()
	{
		return this.reasonpatientplandiffmdt;
	}
	public static int getReasonPatientPlanDiffMDTMaxLength()
	{
		return 1000;
	}
	public void setReasonPatientPlanDiffMDT(String value)
	{
		this.isValidated = false;
		this.reasonpatientplandiffmdt = value;
	}
	public boolean getNoAntiCancerTxReasonIsNotNull()
	{
		return this.noanticancertxreason != null;
	}
	public ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection getNoAntiCancerTxReason()
	{
		return this.noanticancertxreason;
	}
	public void setNoAntiCancerTxReason(ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection value)
	{
		this.isValidated = false;
		this.noanticancertxreason = value;
	}
	public boolean getHasAssociatedMDTMeetingIsNotNull()
	{
		return this.hasassociatedmdtmeeting != null;
	}
	public Boolean getHasAssociatedMDTMeeting()
	{
		return this.hasassociatedmdtmeeting;
	}
	public void setHasAssociatedMDTMeeting(Boolean value)
	{
		this.isValidated = false;
		this.hasassociatedmdtmeeting = value;
	}
	public boolean getReasonForRevisionIsNotNull()
	{
		return this.reasonforrevision != null;
	}
	public String getReasonForRevision()
	{
		return this.reasonforrevision;
	}
	public static int getReasonForRevisionMaxLength()
	{
		return 255;
	}
	public void setReasonForRevision(String value)
	{
		this.isValidated = false;
		this.reasonforrevision = value;
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
		if(this.consultantincharge != null)
		{
			if(!this.consultantincharge.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.mdtmeeting != null)
		{
			if(!this.mdtmeeting.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.treatmentmodalities != null)
		{
			if(!this.treatmentmodalities.isValidated())
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
		if(this.careplandate == null)
			listOfErrors.add("CarePlanDate is mandatory");
		if(this.consultantincharge != null)
		{
			String[] listOfOtherErrors = this.consultantincharge.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.mdtmeeting != null)
		{
			String[] listOfOtherErrors = this.mdtmeeting.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.careplannotes != null)
			if(this.careplannotes.length() > 1000)
				listOfErrors.add("The length of the field [careplannotes] in the value object [ims.oncology.vo.CancerCarePlanVo] is too big. It should be less or equal to 1000");
		if(this.treatmentmodalities != null)
		{
			String[] listOfOtherErrors = this.treatmentmodalities.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.reasonpatientplandiffmdt != null)
			if(this.reasonpatientplandiffmdt.length() > 1000)
				listOfErrors.add("The length of the field [reasonpatientplandiffmdt] in the value object [ims.oncology.vo.CancerCarePlanVo] is too big. It should be less or equal to 1000");
		if(this.reasonforrevision != null)
			if(this.reasonforrevision.length() > 255)
				listOfErrors.add("The length of the field [reasonforrevision] in the value object [ims.oncology.vo.CancerCarePlanVo] is too big. It should be less or equal to 255");
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
	
		CancerCarePlanVo clone = new CancerCarePlanVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.careplandate == null)
			clone.careplandate = null;
		else
			clone.careplandate = (ims.framework.utils.Date)this.careplandate.clone();
		if(this.consultantincharge == null)
			clone.consultantincharge = null;
		else
			clone.consultantincharge = (ims.core.vo.HcpLiteVo)this.consultantincharge.clone();
		if(this.careplanintent == null)
			clone.careplanintent = null;
		else
			clone.careplanintent = (ims.oncology.vo.lookups.CarePlanIntent)this.careplanintent.clone();
		if(this.recurrenceindicator == null)
			clone.recurrenceindicator = null;
		else
			clone.recurrenceindicator = (ims.oncology.vo.lookups.RecurrenceIndicator)this.recurrenceindicator.clone();
		clone.iscurrent = this.iscurrent;
		if(this.mdtmeeting == null)
			clone.mdtmeeting = null;
		else
			clone.mdtmeeting = (ims.oncology.vo.CancerMDTMeetingVo)this.mdtmeeting.clone();
		clone.episodeofcare = this.episodeofcare;
		clone.careplannotes = this.careplannotes;
		if(this.treatmentmodalities == null)
			clone.treatmentmodalities = null;
		else
			clone.treatmentmodalities = (ims.oncology.vo.TreatmentModalitiesVoCollection)this.treatmentmodalities.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.oncology.vo.lookups.CarePlanCurrentStatus)this.currentstatus.clone();
		if(this.agreeddate == null)
			clone.agreeddate = null;
		else
			clone.agreeddate = (ims.framework.utils.Date)this.agreeddate.clone();
		clone.reasonpatientplandiffmdt = this.reasonpatientplandiffmdt;
		if(this.noanticancertxreason == null)
			clone.noanticancertxreason = null;
		else
			clone.noanticancertxreason = (ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection)this.noanticancertxreason.clone();
		clone.hasassociatedmdtmeeting = this.hasassociatedmdtmeeting;
		clone.reasonforrevision = this.reasonforrevision;
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
		if (!(CancerCarePlanVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CancerCarePlanVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CancerCarePlanVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CancerCarePlanVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.treatmentmodalities != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.agreeddate != null)
			count++;
		if(this.reasonpatientplandiffmdt != null)
			count++;
		if(this.noanticancertxreason != null)
			count++;
		if(this.hasassociatedmdtmeeting != null)
			count++;
		if(this.reasonforrevision != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.oncology.vo.TreatmentModalitiesVoCollection treatmentmodalities;
	protected ims.oncology.vo.lookups.CarePlanCurrentStatus currentstatus;
	protected ims.framework.utils.Date agreeddate;
	protected String reasonpatientplandiffmdt;
	protected ims.oncology.vo.lookups.NoAntiCancerTxReasonCollection noanticancertxreason;
	protected Boolean hasassociatedmdtmeeting;
	protected String reasonforrevision;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
