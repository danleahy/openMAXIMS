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

package ims.spinalinjuries.vo;

/**
 * Linked to nursing.assessment.Assessment Component business object (ID: 1015100001).
 */
public class NurAssessmentMobilityVo extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurAssessmentMobilityVo()
	{
	}
	public NurAssessmentMobilityVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurAssessmentMobilityVo(ims.spinalinjuries.vo.beans.NurAssessmentMobilityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo();
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.mobilitystatus = ims.nursing.vo.lookups.MobilityStatusCollection.buildFromBeanCollection(bean.getMobilityStatus());
		this.orthosesused = ims.spinalinjuries.vo.lookups.OrthosesCollection.buildFromBeanCollection(bean.getOrthosesUsed());
		this.mobilityaids = bean.getMobilityAids() == null ? null : ims.nursing.vo.lookups.MobilityAids.buildLookup(bean.getMobilityAids());
		this.transfers = ims.nursing.vo.TransfersCollection.buildFromBeanCollection(bean.getTransfers());
		this.notes = bean.getNotes();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.beans.NurAssessmentMobilityVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscomplete = bean.getIsComplete();
		this.assessmentinfo = ims.nursing.vo.AssessmentInfoCollection.buildFromBeanCollection(bean.getAssessmentInfo());
		this.copy = bean.getCopy();
		this.componenttype = bean.getComponentType() == null ? null : ims.nursing.vo.lookups.AssessmentComponentType.buildLookup(bean.getComponentType());
		this.lastassessmentinfo = bean.getLastAssessmentInfo() == null ? null : bean.getLastAssessmentInfo().buildVo(map);
		this.careplantemplate = ims.nursing.vo.CarePlanTemplateCollection.buildFromBeanCollection(bean.getCarePlanTemplate());
		this.careplans = ims.nursing.vo.CarePlanCollection.buildFromBeanCollection(bean.getCarePlans());
		this.mobilitystatus = ims.nursing.vo.lookups.MobilityStatusCollection.buildFromBeanCollection(bean.getMobilityStatus());
		this.orthosesused = ims.spinalinjuries.vo.lookups.OrthosesCollection.buildFromBeanCollection(bean.getOrthosesUsed());
		this.mobilityaids = bean.getMobilityAids() == null ? null : ims.nursing.vo.lookups.MobilityAids.buildLookup(bean.getMobilityAids());
		this.transfers = ims.nursing.vo.TransfersCollection.buildFromBeanCollection(bean.getTransfers());
		this.notes = bean.getNotes();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.beans.NurAssessmentMobilityVoBean bean = null;
		if(map != null)
			bean = (ims.spinalinjuries.vo.beans.NurAssessmentMobilityVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.spinalinjuries.vo.beans.NurAssessmentMobilityVoBean();
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
		if(fieldName.equals("MOBILITYSTATUS"))
			return getMobilityStatus();
		if(fieldName.equals("ORTHOSESUSED"))
			return getOrthosesUsed();
		if(fieldName.equals("MOBILITYAIDS"))
			return getMobilityAids();
		if(fieldName.equals("TRANSFERS"))
			return getTransfers();
		if(fieldName.equals("NOTES"))
			return getNotes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMobilityStatusIsNotNull()
	{
		return this.mobilitystatus != null;
	}
	public ims.nursing.vo.lookups.MobilityStatusCollection getMobilityStatus()
	{
		return this.mobilitystatus;
	}
	public void setMobilityStatus(ims.nursing.vo.lookups.MobilityStatusCollection value)
	{
		this.isValidated = false;
		this.mobilitystatus = value;
	}
	public boolean getOrthosesUsedIsNotNull()
	{
		return this.orthosesused != null;
	}
	public ims.spinalinjuries.vo.lookups.OrthosesCollection getOrthosesUsed()
	{
		return this.orthosesused;
	}
	public void setOrthosesUsed(ims.spinalinjuries.vo.lookups.OrthosesCollection value)
	{
		this.isValidated = false;
		this.orthosesused = value;
	}
	public boolean getMobilityAidsIsNotNull()
	{
		return this.mobilityaids != null;
	}
	public ims.nursing.vo.lookups.MobilityAids getMobilityAids()
	{
		return this.mobilityaids;
	}
	public void setMobilityAids(ims.nursing.vo.lookups.MobilityAids value)
	{
		this.isValidated = false;
		this.mobilityaids = value;
	}
	public boolean getTransfersIsNotNull()
	{
		return this.transfers != null;
	}
	public ims.nursing.vo.TransfersCollection getTransfers()
	{
		return this.transfers;
	}
	public void setTransfers(ims.nursing.vo.TransfersCollection value)
	{
		this.isValidated = false;
		this.transfers = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public static int getNotesMaxLength()
	{
		return 500;
	}
	public void setNotes(String value)
	{
		this.isValidated = false;
		this.notes = value;
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
		if(this.assessmentinfo != null)
		{
			if(!this.assessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastassessmentinfo != null)
		{
			if(!this.lastassessmentinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplantemplate != null)
		{
			if(!this.careplantemplate.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.careplans != null)
		{
			if(!this.careplans.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.transfers != null)
		{
			if(!this.transfers.isValidated())
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
		if(this.assessmentinfo != null)
		{
			String[] listOfOtherErrors = this.assessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastassessmentinfo != null)
		{
			String[] listOfOtherErrors = this.lastassessmentinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplantemplate != null)
		{
			String[] listOfOtherErrors = this.careplantemplate.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.careplans != null)
		{
			String[] listOfOtherErrors = this.careplans.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.transfers != null)
		{
			String[] listOfOtherErrors = this.transfers.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.notes != null)
			if(this.notes.length() > 500)
				listOfErrors.add("The length of the field [notes] in the value object [ims.spinalinjuries.vo.NurAssessmentMobilityVo] is too big. It should be less or equal to 500");
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
	
		NurAssessmentMobilityVo clone = new NurAssessmentMobilityVo(this.id, this.version);
		
		clone.iscomplete = this.iscomplete;
		if(this.assessmentinfo == null)
			clone.assessmentinfo = null;
		else
			clone.assessmentinfo = (ims.nursing.vo.AssessmentInfoCollection)this.assessmentinfo.clone();
		clone.copy = this.copy;
		if(this.componenttype == null)
			clone.componenttype = null;
		else
			clone.componenttype = (ims.nursing.vo.lookups.AssessmentComponentType)this.componenttype.clone();
		if(this.lastassessmentinfo == null)
			clone.lastassessmentinfo = null;
		else
			clone.lastassessmentinfo = (ims.nursing.vo.AssessmentInfo)this.lastassessmentinfo.clone();
		if(this.careplantemplate == null)
			clone.careplantemplate = null;
		else
			clone.careplantemplate = (ims.nursing.vo.CarePlanTemplateCollection)this.careplantemplate.clone();
		if(this.careplans == null)
			clone.careplans = null;
		else
			clone.careplans = (ims.nursing.vo.CarePlanCollection)this.careplans.clone();
		if(this.mobilitystatus == null)
			clone.mobilitystatus = null;
		else
			clone.mobilitystatus = (ims.nursing.vo.lookups.MobilityStatusCollection)this.mobilitystatus.clone();
		if(this.orthosesused == null)
			clone.orthosesused = null;
		else
			clone.orthosesused = (ims.spinalinjuries.vo.lookups.OrthosesCollection)this.orthosesused.clone();
		if(this.mobilityaids == null)
			clone.mobilityaids = null;
		else
			clone.mobilityaids = (ims.nursing.vo.lookups.MobilityAids)this.mobilityaids.clone();
		if(this.transfers == null)
			clone.transfers = null;
		else
			clone.transfers = (ims.nursing.vo.TransfersCollection)this.transfers.clone();
		clone.notes = this.notes;
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
		if (!(NurAssessmentMobilityVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurAssessmentMobilityVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NurAssessmentMobilityVo compareObj = (NurAssessmentMobilityVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_AssessmentComponent() == null && compareObj.getID_AssessmentComponent() != null)
				return -1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() == null)
				return 1;
			if(this.getID_AssessmentComponent() != null && compareObj.getID_AssessmentComponent() != null)
				retVal = this.getID_AssessmentComponent().compareTo(compareObj.getID_AssessmentComponent());
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
		if(this.mobilitystatus != null)
			count++;
		if(this.orthosesused != null)
			count++;
		if(this.mobilityaids != null)
			count++;
		if(this.transfers != null)
			count++;
		if(this.notes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected ims.nursing.vo.lookups.MobilityStatusCollection mobilitystatus;
	protected ims.spinalinjuries.vo.lookups.OrthosesCollection orthosesused;
	protected ims.nursing.vo.lookups.MobilityAids mobilityaids;
	protected ims.nursing.vo.TransfersCollection transfers;
	protected String notes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
