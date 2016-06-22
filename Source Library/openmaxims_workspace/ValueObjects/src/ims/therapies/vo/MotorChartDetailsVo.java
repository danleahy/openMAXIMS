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

package ims.therapies.vo;

/**
 * Linked to spinalinjuries.therapies.MotorChartDetails business object (ID: 1030100007).
 */
public class MotorChartDetailsVo extends ims.spinalinjuries.therapies.vo.MotorChartDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MotorChartDetailsVo()
	{
	}
	public MotorChartDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public MotorChartDetailsVo(ims.therapies.vo.beans.MotorChartDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.musclegroup = bean.getMuscleGroup() == null ? null : new ims.therapies.vo.MuscleGroupRefVo(new Integer(bean.getMuscleGroup().getId()), bean.getMuscleGroup().getVersion());
		this.muscle = bean.getMuscle() == null ? null : new ims.therapies.vo.MuscleRefVo(new Integer(bean.getMuscle().getId()), bean.getMuscle().getVersion());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRonly.buildLookup(bean.getLaterality());
		this.score = bean.getScore();
		this.motorarea = bean.getMotorArea() == null ? null : new ims.therapies.vo.MotorAreaRefVo(new Integer(bean.getMotorArea().getId()), bean.getMotorArea().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.MotorChartDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.musclegroup = bean.getMuscleGroup() == null ? null : new ims.therapies.vo.MuscleGroupRefVo(new Integer(bean.getMuscleGroup().getId()), bean.getMuscleGroup().getVersion());
		this.muscle = bean.getMuscle() == null ? null : new ims.therapies.vo.MuscleRefVo(new Integer(bean.getMuscle().getId()), bean.getMuscle().getVersion());
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRonly.buildLookup(bean.getLaterality());
		this.score = bean.getScore();
		this.motorarea = bean.getMotorArea() == null ? null : new ims.therapies.vo.MotorAreaRefVo(new Integer(bean.getMotorArea().getId()), bean.getMotorArea().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.MotorChartDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.MotorChartDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.MotorChartDetailsVoBean();
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
		if(fieldName.equals("MUSCLEGROUP"))
			return getMuscleGroup();
		if(fieldName.equals("MUSCLE"))
			return getMuscle();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		if(fieldName.equals("SCORE"))
			return getScore();
		if(fieldName.equals("MOTORAREA"))
			return getMotorArea();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMuscleGroupIsNotNull()
	{
		return this.musclegroup != null;
	}
	public ims.therapies.vo.MuscleGroupRefVo getMuscleGroup()
	{
		return this.musclegroup;
	}
	public void setMuscleGroup(ims.therapies.vo.MuscleGroupRefVo value)
	{
		this.isValidated = false;
		this.musclegroup = value;
	}
	public boolean getMuscleIsNotNull()
	{
		return this.muscle != null;
	}
	public ims.therapies.vo.MuscleRefVo getMuscle()
	{
		return this.muscle;
	}
	public void setMuscle(ims.therapies.vo.MuscleRefVo value)
	{
		this.isValidated = false;
		this.muscle = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public ims.core.vo.lookups.LateralityLRonly getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.core.vo.lookups.LateralityLRonly value)
	{
		this.isValidated = false;
		this.laterality = value;
	}
	public boolean getScoreIsNotNull()
	{
		return this.score != null;
	}
	public Integer getScore()
	{
		return this.score;
	}
	public void setScore(Integer value)
	{
		this.isValidated = false;
		this.score = value;
	}
	public boolean getMotorAreaIsNotNull()
	{
		return this.motorarea != null;
	}
	public ims.therapies.vo.MotorAreaRefVo getMotorArea()
	{
		return this.motorarea;
	}
	public void setMotorArea(ims.therapies.vo.MotorAreaRefVo value)
	{
		this.isValidated = false;
		this.motorarea = value;
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
		if(this.laterality == null)
			listOfErrors.add("Laterality is mandatory");
		if(this.score == null)
			listOfErrors.add("Score is mandatory");
		if(this.score != null && (this.score.intValue() < 0 || this.score.intValue() > 5))
			listOfErrors.add("A Score must range between 0 - 5");
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
	
		MotorChartDetailsVo clone = new MotorChartDetailsVo(this.id, this.version);
		
		clone.musclegroup = this.musclegroup;
		clone.muscle = this.muscle;
		if(this.laterality == null)
			clone.laterality = null;
		else
			clone.laterality = (ims.core.vo.lookups.LateralityLRonly)this.laterality.clone();
		clone.score = this.score;
		clone.motorarea = this.motorarea;
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
		if (!(MotorChartDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MotorChartDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MotorChartDetailsVo compareObj = (MotorChartDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_MotorChartDetails() == null && compareObj.getID_MotorChartDetails() != null)
				return -1;
			if(this.getID_MotorChartDetails() != null && compareObj.getID_MotorChartDetails() == null)
				return 1;
			if(this.getID_MotorChartDetails() != null && compareObj.getID_MotorChartDetails() != null)
				retVal = this.getID_MotorChartDetails().compareTo(compareObj.getID_MotorChartDetails());
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
		if(this.musclegroup != null)
			count++;
		if(this.muscle != null)
			count++;
		if(this.laterality != null)
			count++;
		if(this.score != null)
			count++;
		if(this.motorarea != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.therapies.vo.MuscleGroupRefVo musclegroup;
	protected ims.therapies.vo.MuscleRefVo muscle;
	protected ims.core.vo.lookups.LateralityLRonly laterality;
	protected Integer score;
	protected ims.therapies.vo.MotorAreaRefVo motorarea;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
