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

package ims.assessment.vo;

/**
 * Linked to Assessment.Instantiation.PatientUserDefinedObject business object (ID: 1085100000).
 */
public class PatientUserDefinedObjectVo extends ims.assessment.instantiation.vo.PatientUserDefinedObjectRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientUserDefinedObjectVo()
	{
	}
	public PatientUserDefinedObjectVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientUserDefinedObjectVo(ims.assessment.vo.beans.PatientUserDefinedObjectVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userdefinedobject = bean.getUserDefinedObject() == null ? null : bean.getUserDefinedObject().buildVo();
		this.patientassessments = ims.assessment.vo.PatientAssessmentVoCollection.buildFromBeanCollection(bean.getPatientAssessments());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientUserDefinedObjectVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userdefinedobject = bean.getUserDefinedObject() == null ? null : bean.getUserDefinedObject().buildVo(map);
		this.patientassessments = ims.assessment.vo.PatientAssessmentVoCollection.buildFromBeanCollection(bean.getPatientAssessments());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientUserDefinedObjectVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientUserDefinedObjectVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientUserDefinedObjectVoBean();
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
		if(fieldName.equals("USERDEFINEDOBJECT"))
			return getUserDefinedObject();
		if(fieldName.equals("PATIENTASSESSMENTS"))
			return getPatientAssessments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUserDefinedObjectIsNotNull()
	{
		return this.userdefinedobject != null;
	}
	public ims.assessment.vo.UserDefinedObjectVo getUserDefinedObject()
	{
		return this.userdefinedobject;
	}
	public void setUserDefinedObject(ims.assessment.vo.UserDefinedObjectVo value)
	{
		this.isValidated = false;
		this.userdefinedobject = value;
	}
	public boolean getPatientAssessmentsIsNotNull()
	{
		return this.patientassessments != null;
	}
	public ims.assessment.vo.PatientAssessmentVoCollection getPatientAssessments()
	{
		return this.patientassessments;
	}
	public void setPatientAssessments(ims.assessment.vo.PatientAssessmentVoCollection value)
	{
		this.isValidated = false;
		this.patientassessments = value;
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
		if(this.patientassessments != null)
		{
			if(!this.patientassessments.isValidated())
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
		if(this.userdefinedobject == null)
			listOfErrors.add("UserDefinedObject is mandatory");
		if(this.patientassessments == null || this.patientassessments.size() == 0)
			listOfErrors.add("PatientAssessments are mandatory");
		if(this.patientassessments != null)
		{
			String[] listOfOtherErrors = this.patientassessments.validate();
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
	
		PatientUserDefinedObjectVo clone = new PatientUserDefinedObjectVo(this.id, this.version);
		
		if(this.userdefinedobject == null)
			clone.userdefinedobject = null;
		else
			clone.userdefinedobject = (ims.assessment.vo.UserDefinedObjectVo)this.userdefinedobject.clone();
		if(this.patientassessments == null)
			clone.patientassessments = null;
		else
			clone.patientassessments = (ims.assessment.vo.PatientAssessmentVoCollection)this.patientassessments.clone();
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
		if (!(PatientUserDefinedObjectVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientUserDefinedObjectVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientUserDefinedObjectVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientUserDefinedObjectVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.userdefinedobject != null)
			count++;
		if(this.patientassessments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.assessment.vo.UserDefinedObjectVo userdefinedobject;
	protected ims.assessment.vo.PatientAssessmentVoCollection patientassessments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
