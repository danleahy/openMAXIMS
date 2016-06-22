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
 * Linked to clinical.PatientPMHChecklistProcedure business object (ID: 1072100017).
 */
public class PatientPMHChecklistProcedureVo extends ims.clinical.vo.PatientPMHChecklistProcedureRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientPMHChecklistProcedureVo()
	{
	}
	public PatientPMHChecklistProcedureVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientPMHChecklistProcedureVo(ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.selected = bean.getSelected() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSelected());
		this.notes = bean.getNotes();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.selected = bean.getSelected() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSelected());
		this.notes = bean.getNotes();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.PatientPMHChecklistProcedureVoBean();
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
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("SELECTED"))
			return getSelected();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("SOURCEOFINFORMATION"))
			return getSourceofInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getSelectedIsNotNull()
	{
		return this.selected != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getSelected()
	{
		return this.selected;
	}
	public void setSelected(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.selected = value;
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
	public boolean getSourceofInformationIsNotNull()
	{
		return this.sourceofinformation != null;
	}
	public ims.core.vo.lookups.SourceofInformation getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.sourceofinformation = value;
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
		if(this.notes != null)
			if(this.notes.length() > 500)
				listOfErrors.add("The length of the field [notes] in the value object [ims.clinical.vo.PatientPMHChecklistProcedureVo] is too big. It should be less or equal to 500");
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
	
		PatientPMHChecklistProcedureVo clone = new PatientPMHChecklistProcedureVo(this.id, this.version);
		
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.core.vo.ProcedureLiteVo)this.procedure.clone();
		if(this.selected == null)
			clone.selected = null;
		else
			clone.selected = (ims.core.vo.lookups.YesNoUnknown)this.selected.clone();
		clone.notes = this.notes;
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
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
		if (!(PatientPMHChecklistProcedureVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientPMHChecklistProcedureVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PatientPMHChecklistProcedureVo compareObj = (PatientPMHChecklistProcedureVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_PatientPMHChecklistProcedure() == null && compareObj.getID_PatientPMHChecklistProcedure() != null)
				return -1;
			if(this.getID_PatientPMHChecklistProcedure() != null && compareObj.getID_PatientPMHChecklistProcedure() == null)
				return 1;
			if(this.getID_PatientPMHChecklistProcedure() != null && compareObj.getID_PatientPMHChecklistProcedure() != null)
				retVal = this.getID_PatientPMHChecklistProcedure().compareTo(compareObj.getID_PatientPMHChecklistProcedure());
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
		if(this.procedure != null)
			count++;
		if(this.selected != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.sourceofinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.ProcedureLiteVo procedure;
	protected ims.core.vo.lookups.YesNoUnknown selected;
	protected String notes;
	protected ims.core.vo.lookups.SourceofInformation sourceofinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
