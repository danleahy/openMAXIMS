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

package ims.icp.vo;

/**
 * Linked to ICPs.Instantiation.PatientICPEvaluationNote business object (ID: 1100100008).
 */
public class PatientICPEvaluationNoteVo extends ims.icps.instantiation.vo.PatientICPEvaluationNoteRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPEvaluationNoteVo()
	{
	}
	public PatientICPEvaluationNoteVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPEvaluationNoteVo(ims.icp.vo.beans.PatientICPEvaluationNoteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.note = bean.getNote();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPEvaluationNoteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datetime = bean.getDateTime() == null ? null : bean.getDateTime().buildDateTime();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.discipline = bean.getDiscipline() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getDiscipline());
		this.note = bean.getNote();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPEvaluationNoteVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPEvaluationNoteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPEvaluationNoteVoBean();
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
		if(fieldName.equals("DATETIME"))
			return getDateTime();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("DISCIPLINE"))
			return getDiscipline();
		if(fieldName.equals("NOTE"))
			return getNote();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateTimeIsNotNull()
	{
		return this.datetime != null;
	}
	public ims.framework.utils.DateTime getDateTime()
	{
		return this.datetime;
	}
	public void setDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datetime = value;
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
	public boolean getDisciplineIsNotNull()
	{
		return this.discipline != null;
	}
	public ims.core.vo.lookups.HcpDisType getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.discipline = value;
	}
	public boolean getNoteIsNotNull()
	{
		return this.note != null;
	}
	public String getNote()
	{
		return this.note;
	}
	public static int getNoteMaxLength()
	{
		return 5000;
	}
	public void setNote(String value)
	{
		this.isValidated = false;
		this.note = value;
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
		if(this.datetime == null)
			listOfErrors.add("Evaluation Date/Time is mandatory");
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
		if(this.discipline == null)
			listOfErrors.add("Discipline is mandatory");
		if(this.note == null || this.note.length() == 0)
			listOfErrors.add("Note is mandatory");
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
	
		PatientICPEvaluationNoteVo clone = new PatientICPEvaluationNoteVo(this.id, this.version);
		
		if(this.datetime == null)
			clone.datetime = null;
		else
			clone.datetime = (ims.framework.utils.DateTime)this.datetime.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.lookups.HcpDisType)this.discipline.clone();
		clone.note = this.note;
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
		if (!(PatientICPEvaluationNoteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPEvaluationNoteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientICPEvaluationNoteVo compareObj = (PatientICPEvaluationNoteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAuthoringInformation() == null && compareObj.getAuthoringInformation() != null)
				return -1;
			if(this.getAuthoringInformation() != null && compareObj.getAuthoringInformation() == null)
				return 1;
			if(this.getAuthoringInformation() != null && compareObj.getAuthoringInformation() != null)
				retVal = this.getAuthoringInformation().compareTo(compareObj.getAuthoringInformation());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datetime != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.discipline != null)
			count++;
		if(this.note != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.DateTime datetime;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.lookups.HcpDisType discipline;
	protected String note;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
