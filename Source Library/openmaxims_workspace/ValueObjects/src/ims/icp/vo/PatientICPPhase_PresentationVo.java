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
 * Linked to ICPs.Instantiation.PatientICPPhase business object (ID: 1100100003).
 */
public class PatientICPPhase_PresentationVo extends ims.icps.instantiation.vo.PatientICPPhaseRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IInstantiationICPStagePhaseAction
{
	private static final long serialVersionUID = 1L;

	public PatientICPPhase_PresentationVo()
	{
	}
	public PatientICPPhase_PresentationVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPPhase_PresentationVo(ims.icp.vo.beans.PatientICPPhase_PresentationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.phase = bean.getPhase() == null ? null : bean.getPhase().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.actions = ims.icp.vo.PatientICPAction_PresentationVoCollection.buildFromBeanCollection(bean.getActions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPPhase_PresentationVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.phase = bean.getPhase() == null ? null : bean.getPhase().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.actions = ims.icp.vo.PatientICPAction_PresentationVoCollection.buildFromBeanCollection(bean.getActions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPPhase_PresentationVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPPhase_PresentationVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPPhase_PresentationVoBean();
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
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("PHASE"))
			return getPhase();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("ACTIONS"))
			return getActions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getICPIsNotNull()
	{
		return this.icp != null;
	}
	public ims.icps.instantiation.vo.PatientICPRefVo getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icps.instantiation.vo.PatientICPRefVo value)
	{
		this.isValidated = false;
		this.icp = value;
	}
	public boolean getPhaseIsNotNull()
	{
		return this.phase != null;
	}
	public ims.icp.vo.ICPPhaseLiteVo getPhase()
	{
		return this.phase;
	}
	public void setPhase(ims.icp.vo.ICPPhaseLiteVo value)
	{
		this.isValidated = false;
		this.phase = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.icp.vo.PatientICPPhaseStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.icp.vo.PatientICPPhaseStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getActionsIsNotNull()
	{
		return this.actions != null;
	}
	public ims.icp.vo.PatientICPAction_PresentationVoCollection getActions()
	{
		return this.actions;
	}
	public void setActions(ims.icp.vo.PatientICPAction_PresentationVoCollection value)
	{
		this.isValidated = false;
		this.actions = value;
	}
	/**
	* IInstantiationICPStagePhaseAction
	*/
	public String getHelpURL()
	{
		if (this.phase == null)
			return null;
			
		return this.phase.helpurl;
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
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.phase == null)
			listOfErrors.add("Phase is mandatory");
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
	
		PatientICPPhase_PresentationVo clone = new PatientICPPhase_PresentationVo(this.id, this.version);
		
		clone.icp = this.icp;
		if(this.phase == null)
			clone.phase = null;
		else
			clone.phase = (ims.icp.vo.ICPPhaseLiteVo)this.phase.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPPhaseStatusVo)this.currentstatus.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.icp.vo.PatientICPAction_PresentationVoCollection)this.actions.clone();
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
		if (!(PatientICPPhase_PresentationVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPPhase_PresentationVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPPhase_PresentationVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPPhase_PresentationVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.icp != null)
			count++;
		if(this.phase != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.actions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.icps.instantiation.vo.PatientICPRefVo icp;
	protected ims.icp.vo.ICPPhaseLiteVo phase;
	protected ims.icp.vo.PatientICPPhaseStatusVo currentstatus;
	protected ims.icp.vo.PatientICPAction_PresentationVoCollection actions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
