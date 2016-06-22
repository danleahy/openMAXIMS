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
 * Linked to ICPs.Instantiation.PatientICPStage business object (ID: 1100100001).
 */
public class PatientICPStageViewVo extends ims.icps.instantiation.vo.PatientICPStageRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IInstantiationICPStagePhaseAction
{
	private static final long serialVersionUID = 1L;

	public PatientICPStageViewVo()
	{
	}
	public PatientICPStageViewVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPStageViewVo(ims.icp.vo.beans.PatientICPStageViewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.stagephases = ims.icp.vo.PatientICPPhaseViewVoCollection.buildFromBeanCollection(bean.getStagePhases());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPStageViewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stage = bean.getStage() == null ? null : bean.getStage().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.stagephases = ims.icp.vo.PatientICPPhaseViewVoCollection.buildFromBeanCollection(bean.getStagePhases());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPStageViewVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPStageViewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPStageViewVoBean();
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
		if(fieldName.equals("STAGE"))
			return getStage();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STAGEPHASES"))
			return getStagePhases();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.icp.vo.ICPStageViewVo getStage()
	{
		return this.stage;
	}
	public void setStage(ims.icp.vo.ICPStageViewVo value)
	{
		this.isValidated = false;
		this.stage = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPStageStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPStageStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStagePhasesIsNotNull()
	{
		return this.stagephases != null;
	}
	public ims.icp.vo.PatientICPPhaseViewVoCollection getStagePhases()
	{
		return this.stagephases;
	}
	public void setStagePhases(ims.icp.vo.PatientICPPhaseViewVoCollection value)
	{
		this.isValidated = false;
		this.stagephases = value;
	}
	/**
	* IInstantiationICPStagePhaseAction methods
	*/
		public String getHelpURL()
		{
			if (this.stage == null)
				return null;
			
			return this.stage.helpurl;
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
		if(this.stage == null)
			listOfErrors.add("Stage is mandatory");
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
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
	
		PatientICPStageViewVo clone = new PatientICPStageViewVo(this.id, this.version);
		
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.icp.vo.ICPStageViewVo)this.stage.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPStageStatusVo)this.currentstatus.clone();
		if(this.stagephases == null)
			clone.stagephases = null;
		else
			clone.stagephases = (ims.icp.vo.PatientICPPhaseViewVoCollection)this.stagephases.clone();
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
		if (!(PatientICPStageViewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPStageViewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPStageViewVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPStageViewVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.stage != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.stagephases != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.icp.vo.ICPStageViewVo stage;
	protected ims.icp.vo.PatientICPStageStatusVo currentstatus;
	protected ims.icp.vo.PatientICPPhaseViewVoCollection stagephases;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
