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
public class NurAssessmentBowelsVo extends ims.nursing.vo.AssessmentComponent implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurAssessmentBowelsVo()
	{
	}
	public NurAssessmentBowelsVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurAssessmentBowelsVo(ims.spinalinjuries.vo.beans.NurAssessmentBowelsVoBean bean)
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
		this.usualbowelpattern = bean.getUsualBowelPattern() == null ? null : ims.nursing.vo.lookups.BowelPattern.buildLookup(bean.getUsualBowelPattern());
		this.timeofday = bean.getTimeOfDay() == null ? null : ims.nursing.vo.lookups.BowelTimeOfDay.buildLookup(bean.getTimeOfDay());
		this.bowelroutineperformedin = bean.getBowelRoutinePerformedIn() == null ? null : ims.nursing.vo.lookups.BowelRoutineLocation.buildLookup(bean.getBowelRoutinePerformedIn());
		this.bowelroutineperformedby = bean.getBowelRoutinePerformedBy() == null ? null : ims.nursing.vo.lookups.BowelRoutinePerformedBy.buildLookup(bean.getBowelRoutinePerformedBy());
		this.bowelsopenspontaneously = bean.getBowelsOpenSpontaneously() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getBowelsOpenSpontaneously());
		this.notes = bean.getNotes();
		this.bowelmedication = ims.core.vo.PatientMedicationVoCollection.buildFromBeanCollection(bean.getBowelMedication());
		this.ostomydetails = bean.getOstomyDetails() == null ? null : bean.getOstomyDetails().buildVo();
		this.sufferfrom = ims.nursing.vo.BowelDiarrhoeaConstipationVoCollection.buildFromBeanCollection(bean.getSufferFrom());
		this.bowelregime = ims.nursing.vo.BowelRegimeVoCollection.buildFromBeanCollection(bean.getBowelRegime());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.beans.NurAssessmentBowelsVoBean bean)
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
		this.usualbowelpattern = bean.getUsualBowelPattern() == null ? null : ims.nursing.vo.lookups.BowelPattern.buildLookup(bean.getUsualBowelPattern());
		this.timeofday = bean.getTimeOfDay() == null ? null : ims.nursing.vo.lookups.BowelTimeOfDay.buildLookup(bean.getTimeOfDay());
		this.bowelroutineperformedin = bean.getBowelRoutinePerformedIn() == null ? null : ims.nursing.vo.lookups.BowelRoutineLocation.buildLookup(bean.getBowelRoutinePerformedIn());
		this.bowelroutineperformedby = bean.getBowelRoutinePerformedBy() == null ? null : ims.nursing.vo.lookups.BowelRoutinePerformedBy.buildLookup(bean.getBowelRoutinePerformedBy());
		this.bowelsopenspontaneously = bean.getBowelsOpenSpontaneously() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getBowelsOpenSpontaneously());
		this.notes = bean.getNotes();
		this.bowelmedication = ims.core.vo.PatientMedicationVoCollection.buildFromBeanCollection(bean.getBowelMedication());
		this.ostomydetails = bean.getOstomyDetails() == null ? null : bean.getOstomyDetails().buildVo(map);
		this.sufferfrom = ims.nursing.vo.BowelDiarrhoeaConstipationVoCollection.buildFromBeanCollection(bean.getSufferFrom());
		this.bowelregime = ims.nursing.vo.BowelRegimeVoCollection.buildFromBeanCollection(bean.getBowelRegime());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.beans.NurAssessmentBowelsVoBean bean = null;
		if(map != null)
			bean = (ims.spinalinjuries.vo.beans.NurAssessmentBowelsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.spinalinjuries.vo.beans.NurAssessmentBowelsVoBean();
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
		if(fieldName.equals("USUALBOWELPATTERN"))
			return getUsualBowelPattern();
		if(fieldName.equals("TIMEOFDAY"))
			return getTimeOfDay();
		if(fieldName.equals("BOWELROUTINEPERFORMEDIN"))
			return getBowelRoutinePerformedIn();
		if(fieldName.equals("BOWELROUTINEPERFORMEDBY"))
			return getBowelRoutinePerformedBy();
		if(fieldName.equals("BOWELSOPENSPONTANEOUSLY"))
			return getBowelsOpenSpontaneously();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("BOWELMEDICATION"))
			return getBowelMedication();
		if(fieldName.equals("OSTOMYDETAILS"))
			return getOstomyDetails();
		if(fieldName.equals("SUFFERFROM"))
			return getSufferFrom();
		if(fieldName.equals("BOWELREGIME"))
			return getBowelRegime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUsualBowelPatternIsNotNull()
	{
		return this.usualbowelpattern != null;
	}
	public ims.nursing.vo.lookups.BowelPattern getUsualBowelPattern()
	{
		return this.usualbowelpattern;
	}
	public void setUsualBowelPattern(ims.nursing.vo.lookups.BowelPattern value)
	{
		this.isValidated = false;
		this.usualbowelpattern = value;
	}
	public boolean getTimeOfDayIsNotNull()
	{
		return this.timeofday != null;
	}
	public ims.nursing.vo.lookups.BowelTimeOfDay getTimeOfDay()
	{
		return this.timeofday;
	}
	public void setTimeOfDay(ims.nursing.vo.lookups.BowelTimeOfDay value)
	{
		this.isValidated = false;
		this.timeofday = value;
	}
	public boolean getBowelRoutinePerformedInIsNotNull()
	{
		return this.bowelroutineperformedin != null;
	}
	public ims.nursing.vo.lookups.BowelRoutineLocation getBowelRoutinePerformedIn()
	{
		return this.bowelroutineperformedin;
	}
	public void setBowelRoutinePerformedIn(ims.nursing.vo.lookups.BowelRoutineLocation value)
	{
		this.isValidated = false;
		this.bowelroutineperformedin = value;
	}
	public boolean getBowelRoutinePerformedByIsNotNull()
	{
		return this.bowelroutineperformedby != null;
	}
	public ims.nursing.vo.lookups.BowelRoutinePerformedBy getBowelRoutinePerformedBy()
	{
		return this.bowelroutineperformedby;
	}
	public void setBowelRoutinePerformedBy(ims.nursing.vo.lookups.BowelRoutinePerformedBy value)
	{
		this.isValidated = false;
		this.bowelroutineperformedby = value;
	}
	public boolean getBowelsOpenSpontaneouslyIsNotNull()
	{
		return this.bowelsopenspontaneously != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getBowelsOpenSpontaneously()
	{
		return this.bowelsopenspontaneously;
	}
	public void setBowelsOpenSpontaneously(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.bowelsopenspontaneously = value;
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
	public boolean getBowelMedicationIsNotNull()
	{
		return this.bowelmedication != null;
	}
	public ims.core.vo.PatientMedicationVoCollection getBowelMedication()
	{
		return this.bowelmedication;
	}
	public void setBowelMedication(ims.core.vo.PatientMedicationVoCollection value)
	{
		this.isValidated = false;
		this.bowelmedication = value;
	}
	public boolean getOstomyDetailsIsNotNull()
	{
		return this.ostomydetails != null;
	}
	public ims.nursing.vo.BowelOstomyVo getOstomyDetails()
	{
		return this.ostomydetails;
	}
	public void setOstomyDetails(ims.nursing.vo.BowelOstomyVo value)
	{
		this.isValidated = false;
		this.ostomydetails = value;
	}
	public boolean getSufferFromIsNotNull()
	{
		return this.sufferfrom != null;
	}
	public ims.nursing.vo.BowelDiarrhoeaConstipationVoCollection getSufferFrom()
	{
		return this.sufferfrom;
	}
	public void setSufferFrom(ims.nursing.vo.BowelDiarrhoeaConstipationVoCollection value)
	{
		this.isValidated = false;
		this.sufferfrom = value;
	}
	public boolean getBowelRegimeIsNotNull()
	{
		return this.bowelregime != null;
	}
	public ims.nursing.vo.BowelRegimeVoCollection getBowelRegime()
	{
		return this.bowelregime;
	}
	public void setBowelRegime(ims.nursing.vo.BowelRegimeVoCollection value)
	{
		this.isValidated = false;
		this.bowelregime = value;
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
		if(this.bowelmedication != null)
		{
			if(!this.bowelmedication.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ostomydetails != null)
		{
			if(!this.ostomydetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.sufferfrom != null)
		{
			if(!this.sufferfrom.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.bowelregime != null)
		{
			if(!this.bowelregime.isValidated())
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
		if(this.notes != null)
			if(this.notes.length() > 500)
				listOfErrors.add("The length of the field [notes] in the value object [ims.spinalinjuries.vo.NurAssessmentBowelsVo] is too big. It should be less or equal to 500");
		if(this.bowelmedication != null)
		{
			String[] listOfOtherErrors = this.bowelmedication.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ostomydetails != null)
		{
			String[] listOfOtherErrors = this.ostomydetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.sufferfrom != null)
		{
			String[] listOfOtherErrors = this.sufferfrom.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.bowelregime != null)
		{
			String[] listOfOtherErrors = this.bowelregime.validate();
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
	
		NurAssessmentBowelsVo clone = new NurAssessmentBowelsVo(this.id, this.version);
		
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
		if(this.usualbowelpattern == null)
			clone.usualbowelpattern = null;
		else
			clone.usualbowelpattern = (ims.nursing.vo.lookups.BowelPattern)this.usualbowelpattern.clone();
		if(this.timeofday == null)
			clone.timeofday = null;
		else
			clone.timeofday = (ims.nursing.vo.lookups.BowelTimeOfDay)this.timeofday.clone();
		if(this.bowelroutineperformedin == null)
			clone.bowelroutineperformedin = null;
		else
			clone.bowelroutineperformedin = (ims.nursing.vo.lookups.BowelRoutineLocation)this.bowelroutineperformedin.clone();
		if(this.bowelroutineperformedby == null)
			clone.bowelroutineperformedby = null;
		else
			clone.bowelroutineperformedby = (ims.nursing.vo.lookups.BowelRoutinePerformedBy)this.bowelroutineperformedby.clone();
		if(this.bowelsopenspontaneously == null)
			clone.bowelsopenspontaneously = null;
		else
			clone.bowelsopenspontaneously = (ims.core.vo.lookups.YesNoUnknown)this.bowelsopenspontaneously.clone();
		clone.notes = this.notes;
		if(this.bowelmedication == null)
			clone.bowelmedication = null;
		else
			clone.bowelmedication = (ims.core.vo.PatientMedicationVoCollection)this.bowelmedication.clone();
		if(this.ostomydetails == null)
			clone.ostomydetails = null;
		else
			clone.ostomydetails = (ims.nursing.vo.BowelOstomyVo)this.ostomydetails.clone();
		if(this.sufferfrom == null)
			clone.sufferfrom = null;
		else
			clone.sufferfrom = (ims.nursing.vo.BowelDiarrhoeaConstipationVoCollection)this.sufferfrom.clone();
		if(this.bowelregime == null)
			clone.bowelregime = null;
		else
			clone.bowelregime = (ims.nursing.vo.BowelRegimeVoCollection)this.bowelregime.clone();
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
		if (!(NurAssessmentBowelsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurAssessmentBowelsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		NurAssessmentBowelsVo compareObj = (NurAssessmentBowelsVo)obj;
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
		if(this.usualbowelpattern != null)
			count++;
		if(this.timeofday != null)
			count++;
		if(this.bowelroutineperformedin != null)
			count++;
		if(this.bowelroutineperformedby != null)
			count++;
		if(this.bowelsopenspontaneously != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.bowelmedication != null)
			count++;
		if(this.ostomydetails != null)
			count++;
		if(this.sufferfrom != null)
			count++;
		if(this.bowelregime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 10;
	}
	protected ims.nursing.vo.lookups.BowelPattern usualbowelpattern;
	protected ims.nursing.vo.lookups.BowelTimeOfDay timeofday;
	protected ims.nursing.vo.lookups.BowelRoutineLocation bowelroutineperformedin;
	protected ims.nursing.vo.lookups.BowelRoutinePerformedBy bowelroutineperformedby;
	protected ims.core.vo.lookups.YesNoUnknown bowelsopenspontaneously;
	protected String notes;
	protected ims.core.vo.PatientMedicationVoCollection bowelmedication;
	protected ims.nursing.vo.BowelOstomyVo ostomydetails;
	protected ims.nursing.vo.BowelDiarrhoeaConstipationVoCollection sufferfrom;
	protected ims.nursing.vo.BowelRegimeVoCollection bowelregime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
