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
public class PatientICPPhasesFullVo extends ims.icps.instantiation.vo.PatientICPPhaseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientICPPhasesFullVo()
	{
	}
	public PatientICPPhasesFullVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientICPPhasesFullVo(ims.icp.vo.beans.PatientICPPhasesFullVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.phase = bean.getPhase() == null ? null : new ims.icps.configuration.vo.ICPPhaseRefVo(new Integer(bean.getPhase().getId()), bean.getPhase().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.statushistory = ims.icp.vo.PatientICPPhaseStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.completedondate = bean.getCompletedOnDate() == null ? null : bean.getCompletedOnDate().buildDateTime();
		this.phaseactions = ims.icp.vo.PatientICPActionFullVoCollection.buildFromBeanCollection(bean.getPhaseActions());
		this.parentstage = bean.getParentStage() == null ? null : new ims.icps.instantiation.vo.PatientICPStageRefVo(new Integer(bean.getParentStage().getId()), bean.getParentStage().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.PatientICPPhasesFullVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.icp = bean.getICP() == null ? null : new ims.icps.instantiation.vo.PatientICPRefVo(new Integer(bean.getICP().getId()), bean.getICP().getVersion());
		this.phase = bean.getPhase() == null ? null : new ims.icps.configuration.vo.ICPPhaseRefVo(new Integer(bean.getPhase().getId()), bean.getPhase().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.statushistory = ims.icp.vo.PatientICPPhaseStatusVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.completedondate = bean.getCompletedOnDate() == null ? null : bean.getCompletedOnDate().buildDateTime();
		this.phaseactions = ims.icp.vo.PatientICPActionFullVoCollection.buildFromBeanCollection(bean.getPhaseActions());
		this.parentstage = bean.getParentStage() == null ? null : new ims.icps.instantiation.vo.PatientICPStageRefVo(new Integer(bean.getParentStage().getId()), bean.getParentStage().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.PatientICPPhasesFullVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.PatientICPPhasesFullVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.PatientICPPhasesFullVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ICP"))
			return getICP();
		if(fieldName.equals("PHASE"))
			return getPhase();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("COMPLETEDONDATE"))
			return getCompletedOnDate();
		if(fieldName.equals("PHASEACTIONS"))
			return getPhaseActions();
		if(fieldName.equals("PARENTSTAGE"))
			return getParentStage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
	public ims.icps.configuration.vo.ICPPhaseRefVo getPhase()
	{
		return this.phase;
	}
	public void setPhase(ims.icps.configuration.vo.ICPPhaseRefVo value)
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
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.icp.vo.PatientICPPhaseStatusVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.icp.vo.PatientICPPhaseStatusVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getCompletedOnDateIsNotNull()
	{
		return this.completedondate != null;
	}
	public ims.framework.utils.DateTime getCompletedOnDate()
	{
		return this.completedondate;
	}
	public void setCompletedOnDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.completedondate = value;
	}
	public boolean getPhaseActionsIsNotNull()
	{
		return this.phaseactions != null;
	}
	public ims.icp.vo.PatientICPActionFullVoCollection getPhaseActions()
	{
		return this.phaseactions;
	}
	public void setPhaseActions(ims.icp.vo.PatientICPActionFullVoCollection value)
	{
		this.isValidated = false;
		this.phaseactions = value;
	}
	public boolean getParentStageIsNotNull()
	{
		return this.parentstage != null;
	}
	public ims.icps.instantiation.vo.PatientICPStageRefVo getParentStage()
	{
		return this.parentstage;
	}
	public void setParentStage(ims.icps.instantiation.vo.PatientICPStageRefVo value)
	{
		this.isValidated = false;
		this.parentstage = value;
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
		if(this.phaseactions != null)
		{
			if(!this.phaseactions.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.icp == null)
			listOfErrors.add("ICP is mandatory");
		if(this.phase == null)
			listOfErrors.add("Phase is mandatory");
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
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
		if(this.statushistory == null || this.statushistory.size() == 0)
			listOfErrors.add("StatusHistory are mandatory");
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
		if(this.phaseactions != null)
		{
			String[] listOfOtherErrors = this.phaseactions.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.parentstage == null)
			listOfErrors.add("ParentStage is mandatory");
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
	
		PatientICPPhasesFullVo clone = new PatientICPPhasesFullVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.carecontext = this.carecontext;
		clone.icp = this.icp;
		clone.phase = this.phase;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.icp.vo.PatientICPPhaseStatusVo)this.currentstatus.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.icp.vo.PatientICPPhaseStatusVoCollection)this.statushistory.clone();
		if(this.completedondate == null)
			clone.completedondate = null;
		else
			clone.completedondate = (ims.framework.utils.DateTime)this.completedondate.clone();
		if(this.phaseactions == null)
			clone.phaseactions = null;
		else
			clone.phaseactions = (ims.icp.vo.PatientICPActionFullVoCollection)this.phaseactions.clone();
		clone.parentstage = this.parentstage;
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
		if (!(PatientICPPhasesFullVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientICPPhasesFullVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientICPPhasesFullVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientICPPhasesFullVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.icp != null)
			count++;
		if(this.phase != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.completedondate != null)
			count++;
		if(this.phaseactions != null)
			count++;
		if(this.parentstage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.icps.instantiation.vo.PatientICPRefVo icp;
	protected ims.icps.configuration.vo.ICPPhaseRefVo phase;
	protected ims.icp.vo.PatientICPPhaseStatusVo currentstatus;
	protected ims.icp.vo.PatientICPPhaseStatusVoCollection statushistory;
	protected ims.framework.utils.DateTime completedondate;
	protected ims.icp.vo.PatientICPActionFullVoCollection phaseactions;
	protected ims.icps.instantiation.vo.PatientICPStageRefVo parentstage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
