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
 * Linked to core.clinical.Clinical Notes business object (ID: 1011100000).
 */
public class NursingClinicalNotesVo extends ims.core.vo.ClinicalNotesVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NursingClinicalNotesVo()
	{
	}
	public NursingClinicalNotesVo(Integer id, int version)
	{
		super(id, version);
	}
	public NursingClinicalNotesVo(ims.nursing.vo.beans.NursingClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalnote = bean.getClinicalNote();
		this.notetype = bean.getNoteType() == null ? null : ims.core.vo.lookups.ClinicalNoteType.buildLookup(bean.getNoteType());
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
		this.isderivednote = bean.getIsDerivedNote();
		this.forreview = bean.getForReview();
		this.forreviewdiscipline = bean.getForReviewDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getForReviewDiscipline());
		this.reviewinghcp = bean.getReviewingHCP() == null ? null : bean.getReviewingHCP().buildVo();
		this.reviewingdatetime = bean.getReviewingDateTime() == null ? null : bean.getReviewingDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.iscorrected = bean.getIsCorrected();
		this.istranscribed = bean.getIsTranscribed();
		this.sourceofnote = bean.getSourceOfNote() == null ? null : ims.core.vo.lookups.SourceOfNote.buildLookup(bean.getSourceOfNote());
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo();
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
		this.systeminfo = bean.getSystemInfo() == null ? null : bean.getSystemInfo().buildSystemInformation();
		this.inhospitalreport = bean.getInHospitalReport();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.statushistory = ims.core.vo.ClinicalNoteStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.noteclassification = bean.getNoteClassification() == null ? null : ims.clinical.vo.lookups.ClinicalNoteClassification.buildLookup(bean.getNoteClassification());
		this.careplans = ims.nursing.vo.CarePlanTitleCollection.buildFromBeanCollection(bean.getCarePlans());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.beans.NursingClinicalNotesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalnote = bean.getClinicalNote();
		this.notetype = bean.getNoteType() == null ? null : ims.core.vo.lookups.ClinicalNoteType.buildLookup(bean.getNoteType());
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
		this.isderivednote = bean.getIsDerivedNote();
		this.forreview = bean.getForReview();
		this.forreviewdiscipline = bean.getForReviewDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getForReviewDiscipline());
		this.reviewinghcp = bean.getReviewingHCP() == null ? null : bean.getReviewingHCP().buildVo(map);
		this.reviewingdatetime = bean.getReviewingDateTime() == null ? null : bean.getReviewingDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.iscorrected = bean.getIsCorrected();
		this.istranscribed = bean.getIsTranscribed();
		this.sourceofnote = bean.getSourceOfNote() == null ? null : ims.core.vo.lookups.SourceOfNote.buildLookup(bean.getSourceOfNote());
		this.recordinguser = bean.getRecordingUser() == null ? null : bean.getRecordingUser().buildVo(map);
		this.recordingdatetime = bean.getRecordingDateTime() == null ? null : bean.getRecordingDateTime().buildDateTime();
		this.systeminfo = bean.getSystemInfo() == null ? null : bean.getSystemInfo().buildSystemInformation();
		this.inhospitalreport = bean.getInHospitalReport();
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.statushistory = ims.core.vo.ClinicalNoteStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.noteclassification = bean.getNoteClassification() == null ? null : ims.clinical.vo.lookups.ClinicalNoteClassification.buildLookup(bean.getNoteClassification());
		this.careplans = ims.nursing.vo.CarePlanTitleCollection.buildFromBeanCollection(bean.getCarePlans());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.beans.NursingClinicalNotesVoBean bean = null;
		if(map != null)
			bean = (ims.nursing.vo.beans.NursingClinicalNotesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.nursing.vo.beans.NursingClinicalNotesVoBean();
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
		if(fieldName.equals("CAREPLANS"))
			return getCarePlans();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCarePlansIsNotNull()
	{
		return this.careplans != null;
	}
	public ims.nursing.vo.CarePlanTitleCollection getCarePlans()
	{
		return this.careplans;
	}
	public void setCarePlans(ims.nursing.vo.CarePlanTitleCollection value)
	{
		this.isValidated = false;
		this.careplans = value;
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
		if(this.authoringinfo != null)
		{
			if(!this.authoringinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.statushistory != null)
		{
			if(!this.statushistory.isValidated())
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
		if(this.clinicalnote == null || this.clinicalnote.length() == 0)
			listOfErrors.add("ClinicalNote is mandatory");
		if(this.authoringinfo == null)
			listOfErrors.add("'Authoring Info' is mandatory");
		if(this.authoringinfo != null)
		{
			String[] listOfOtherErrors = this.authoringinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isderivednote == null)
			listOfErrors.add("isDerivedNote is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		NursingClinicalNotesVo clone = new NursingClinicalNotesVo(this.id, this.version);
		
		clone.clinicalnote = this.clinicalnote;
		if(this.notetype == null)
			clone.notetype = null;
		else
			clone.notetype = (ims.core.vo.lookups.ClinicalNoteType)this.notetype.clone();
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.lookups.HcpDisType)this.discipline.clone();
		clone.clinicalcontact = this.clinicalcontact;
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
		clone.isderivednote = this.isderivednote;
		clone.forreview = this.forreview;
		if(this.forreviewdiscipline == null)
			clone.forreviewdiscipline = null;
		else
			clone.forreviewdiscipline = (ims.core.vo.lookups.HcpDisType)this.forreviewdiscipline.clone();
		if(this.reviewinghcp == null)
			clone.reviewinghcp = null;
		else
			clone.reviewinghcp = (ims.core.vo.HcpLiteVo)this.reviewinghcp.clone();
		if(this.reviewingdatetime == null)
			clone.reviewingdatetime = null;
		else
			clone.reviewingdatetime = (ims.framework.utils.DateTime)this.reviewingdatetime.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.core.vo.ClinicalNoteStatusVo)this.currentstatus.clone();
		clone.iscorrected = this.iscorrected;
		clone.istranscribed = this.istranscribed;
		if(this.sourceofnote == null)
			clone.sourceofnote = null;
		else
			clone.sourceofnote = (ims.core.vo.lookups.SourceOfNote)this.sourceofnote.clone();
		if(this.recordinguser == null)
			clone.recordinguser = null;
		else
			clone.recordinguser = (ims.core.vo.MemberOfStaffLiteVo)this.recordinguser.clone();
		if(this.recordingdatetime == null)
			clone.recordingdatetime = null;
		else
			clone.recordingdatetime = (ims.framework.utils.DateTime)this.recordingdatetime.clone();
		if(this.systeminfo == null)
			clone.systeminfo = null;
		else
			clone.systeminfo = (ims.vo.SystemInformation)this.systeminfo.clone();
		clone.inhospitalreport = this.inhospitalreport;
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.core.vo.ClinicalNoteStatusVoCollection)this.statushistory.clone();
		clone.carecontext = this.carecontext;
		if(this.noteclassification == null)
			clone.noteclassification = null;
		else
			clone.noteclassification = (ims.clinical.vo.lookups.ClinicalNoteClassification)this.noteclassification.clone();
		if(this.careplans == null)
			clone.careplans = null;
		else
			clone.careplans = (ims.nursing.vo.CarePlanTitleCollection)this.careplans.clone();
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
		if (!(NursingClinicalNotesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NursingClinicalNotesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NursingClinicalNotesVo compareObj = (NursingClinicalNotesVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSystemInfo() == null && compareObj.getSystemInfo() != null)
				return -1;
			if(this.getSystemInfo() != null && compareObj.getSystemInfo() == null)
				return 1;
			if(this.getSystemInfo() != null && compareObj.getSystemInfo() != null)
				retVal = this.getSystemInfo().compareTo(compareObj.getSystemInfo());
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
		if(this.careplans != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.nursing.vo.CarePlanTitleCollection careplans;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
