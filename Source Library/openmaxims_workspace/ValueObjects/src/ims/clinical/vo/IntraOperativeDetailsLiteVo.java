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
 * Linked to core.clinical.IntraOperativeDetails business object (ID: 1072100082).
 */
public class IntraOperativeDetailsLiteVo extends ims.core.clinical.vo.IntraOperativeDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IntraOperativeDetailsLiteVo()
	{
	}
	public IntraOperativeDetailsLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public IntraOperativeDetailsLiteVo(ims.clinical.vo.beans.IntraOperativeDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.skinpreparationused = ims.clinical.vo.lookups.SkinPreparationusedCollection.buildFromBeanCollection(bean.getSkinPreparationUsed());
		this.dressing = ims.clinical.vo.lookups.DressingCollection.buildFromBeanCollection(bean.getDressing());
		this.drains = bean.getDrains() == null ? null : bean.getDrains().buildVo();
		this.patientposition = bean.getPatientPosition() == null ? null : ims.core.vo.lookups.PatientPosition.buildLookup(bean.getPatientPosition());
		this.specimentype = bean.getSpecimenType();
		this.histopathology = bean.getHistopathology();
		this.microbiology = bean.getMicrobiology();
		this.haematology = bean.getHaematology();
		this.cytology = bean.getCytology();
		this.otherskinpreparationused = bean.getOtherSkinPreparationUsed();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.IntraOperativeDetailsLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.skinpreparationused = ims.clinical.vo.lookups.SkinPreparationusedCollection.buildFromBeanCollection(bean.getSkinPreparationUsed());
		this.dressing = ims.clinical.vo.lookups.DressingCollection.buildFromBeanCollection(bean.getDressing());
		this.drains = bean.getDrains() == null ? null : bean.getDrains().buildVo(map);
		this.patientposition = bean.getPatientPosition() == null ? null : ims.core.vo.lookups.PatientPosition.buildLookup(bean.getPatientPosition());
		this.specimentype = bean.getSpecimenType();
		this.histopathology = bean.getHistopathology();
		this.microbiology = bean.getMicrobiology();
		this.haematology = bean.getHaematology();
		this.cytology = bean.getCytology();
		this.otherskinpreparationused = bean.getOtherSkinPreparationUsed();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.IntraOperativeDetailsLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.IntraOperativeDetailsLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.IntraOperativeDetailsLiteVoBean();
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
		if(fieldName.equals("SKINPREPARATIONUSED"))
			return getSkinPreparationUsed();
		if(fieldName.equals("DRESSING"))
			return getDressing();
		if(fieldName.equals("DRAINS"))
			return getDrains();
		if(fieldName.equals("PATIENTPOSITION"))
			return getPatientPosition();
		if(fieldName.equals("SPECIMENTYPE"))
			return getSpecimenType();
		if(fieldName.equals("HISTOPATHOLOGY"))
			return getHistopathology();
		if(fieldName.equals("MICROBIOLOGY"))
			return getMicrobiology();
		if(fieldName.equals("HAEMATOLOGY"))
			return getHaematology();
		if(fieldName.equals("CYTOLOGY"))
			return getCytology();
		if(fieldName.equals("OTHERSKINPREPARATIONUSED"))
			return getOtherSkinPreparationUsed();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSkinPreparationUsedIsNotNull()
	{
		return this.skinpreparationused != null;
	}
	public ims.clinical.vo.lookups.SkinPreparationusedCollection getSkinPreparationUsed()
	{
		return this.skinpreparationused;
	}
	public void setSkinPreparationUsed(ims.clinical.vo.lookups.SkinPreparationusedCollection value)
	{
		this.isValidated = false;
		this.skinpreparationused = value;
	}
	public boolean getDressingIsNotNull()
	{
		return this.dressing != null;
	}
	public ims.clinical.vo.lookups.DressingCollection getDressing()
	{
		return this.dressing;
	}
	public void setDressing(ims.clinical.vo.lookups.DressingCollection value)
	{
		this.isValidated = false;
		this.dressing = value;
	}
	public boolean getDrainsIsNotNull()
	{
		return this.drains != null;
	}
	public ims.clinical.vo.DrainsVo getDrains()
	{
		return this.drains;
	}
	public void setDrains(ims.clinical.vo.DrainsVo value)
	{
		this.isValidated = false;
		this.drains = value;
	}
	public boolean getPatientPositionIsNotNull()
	{
		return this.patientposition != null;
	}
	public ims.core.vo.lookups.PatientPosition getPatientPosition()
	{
		return this.patientposition;
	}
	public void setPatientPosition(ims.core.vo.lookups.PatientPosition value)
	{
		this.isValidated = false;
		this.patientposition = value;
	}
	public boolean getSpecimenTypeIsNotNull()
	{
		return this.specimentype != null;
	}
	public String getSpecimenType()
	{
		return this.specimentype;
	}
	public static int getSpecimenTypeMaxLength()
	{
		return 255;
	}
	public void setSpecimenType(String value)
	{
		this.isValidated = false;
		this.specimentype = value;
	}
	public boolean getHistopathologyIsNotNull()
	{
		return this.histopathology != null;
	}
	public Boolean getHistopathology()
	{
		return this.histopathology;
	}
	public void setHistopathology(Boolean value)
	{
		this.isValidated = false;
		this.histopathology = value;
	}
	public boolean getMicrobiologyIsNotNull()
	{
		return this.microbiology != null;
	}
	public Boolean getMicrobiology()
	{
		return this.microbiology;
	}
	public void setMicrobiology(Boolean value)
	{
		this.isValidated = false;
		this.microbiology = value;
	}
	public boolean getHaematologyIsNotNull()
	{
		return this.haematology != null;
	}
	public Boolean getHaematology()
	{
		return this.haematology;
	}
	public void setHaematology(Boolean value)
	{
		this.isValidated = false;
		this.haematology = value;
	}
	public boolean getCytologyIsNotNull()
	{
		return this.cytology != null;
	}
	public Boolean getCytology()
	{
		return this.cytology;
	}
	public void setCytology(Boolean value)
	{
		this.isValidated = false;
		this.cytology = value;
	}
	public boolean getOtherSkinPreparationUsedIsNotNull()
	{
		return this.otherskinpreparationused != null;
	}
	public String getOtherSkinPreparationUsed()
	{
		return this.otherskinpreparationused;
	}
	public static int getOtherSkinPreparationUsedMaxLength()
	{
		return 125;
	}
	public void setOtherSkinPreparationUsed(String value)
	{
		this.isValidated = false;
		this.otherskinpreparationused = value;
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
		if(this.specimentype != null)
			if(this.specimentype.length() > 255)
				listOfErrors.add("The length of the field [specimentype] in the value object [ims.clinical.vo.IntraOperativeDetailsLiteVo] is too big. It should be less or equal to 255");
		if(this.otherskinpreparationused != null)
			if(this.otherskinpreparationused.length() > 125)
				listOfErrors.add("The length of the field [otherskinpreparationused] in the value object [ims.clinical.vo.IntraOperativeDetailsLiteVo] is too big. It should be less or equal to 125");
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
	
		IntraOperativeDetailsLiteVo clone = new IntraOperativeDetailsLiteVo(this.id, this.version);
		
		if(this.skinpreparationused == null)
			clone.skinpreparationused = null;
		else
			clone.skinpreparationused = (ims.clinical.vo.lookups.SkinPreparationusedCollection)this.skinpreparationused.clone();
		if(this.dressing == null)
			clone.dressing = null;
		else
			clone.dressing = (ims.clinical.vo.lookups.DressingCollection)this.dressing.clone();
		if(this.drains == null)
			clone.drains = null;
		else
			clone.drains = (ims.clinical.vo.DrainsVo)this.drains.clone();
		if(this.patientposition == null)
			clone.patientposition = null;
		else
			clone.patientposition = (ims.core.vo.lookups.PatientPosition)this.patientposition.clone();
		clone.specimentype = this.specimentype;
		clone.histopathology = this.histopathology;
		clone.microbiology = this.microbiology;
		clone.haematology = this.haematology;
		clone.cytology = this.cytology;
		clone.otherskinpreparationused = this.otherskinpreparationused;
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
		if (!(IntraOperativeDetailsLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IntraOperativeDetailsLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((IntraOperativeDetailsLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((IntraOperativeDetailsLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.skinpreparationused != null)
			count++;
		if(this.dressing != null)
			count++;
		if(this.drains != null)
			count++;
		if(this.patientposition != null)
			count++;
		if(this.specimentype != null)
			count++;
		if(this.histopathology != null)
			count++;
		if(this.microbiology != null)
			count++;
		if(this.haematology != null)
			count++;
		if(this.cytology != null)
			count++;
		if(this.otherskinpreparationused != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.clinical.vo.lookups.SkinPreparationusedCollection skinpreparationused;
	protected ims.clinical.vo.lookups.DressingCollection dressing;
	protected ims.clinical.vo.DrainsVo drains;
	protected ims.core.vo.lookups.PatientPosition patientposition;
	protected String specimentype;
	protected Boolean histopathology;
	protected Boolean microbiology;
	protected Boolean haematology;
	protected Boolean cytology;
	protected String otherskinpreparationused;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
