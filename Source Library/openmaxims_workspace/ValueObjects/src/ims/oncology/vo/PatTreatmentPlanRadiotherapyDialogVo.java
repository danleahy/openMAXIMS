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

package ims.oncology.vo;

/**
 * Linked to Oncology.PatTreatmentPlan business object (ID: 1105100037).
 */
public class PatTreatmentPlanRadiotherapyDialogVo extends ims.oncology.vo.PatTreatmentPlanRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatTreatmentPlanRadiotherapyDialogVo()
	{
	}
	public PatTreatmentPlanRadiotherapyDialogVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatTreatmentPlanRadiotherapyDialogVo(ims.oncology.vo.beans.PatTreatmentPlanRadiotherapyDialogVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.decisiontotreat = bean.getDecisionToTreat() == null ? null : bean.getDecisionToTreat().buildDate();
		this.actions = ims.ccosched.vo.PatTreatPlanActionLiteVoCollection.buildFromBeanCollection(bean.getActions());
		this.treatmentsites = ims.oncology.vo.lookups.TreatmentGroupSiteCollection.buildFromBeanCollection(bean.getTreatmentSites());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.PatTreatmentPlanRadiotherapyDialogVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.decisiontotreat = bean.getDecisionToTreat() == null ? null : bean.getDecisionToTreat().buildDate();
		this.actions = ims.ccosched.vo.PatTreatPlanActionLiteVoCollection.buildFromBeanCollection(bean.getActions());
		this.treatmentsites = ims.oncology.vo.lookups.TreatmentGroupSiteCollection.buildFromBeanCollection(bean.getTreatmentSites());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.PatTreatmentPlanRadiotherapyDialogVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.PatTreatmentPlanRadiotherapyDialogVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.PatTreatmentPlanRadiotherapyDialogVoBean();
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
		if(fieldName.equals("DECISIONTOTREAT"))
			return getDecisionToTreat();
		if(fieldName.equals("ACTIONS"))
			return getActions();
		if(fieldName.equals("TREATMENTSITES"))
			return getTreatmentSites();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDecisionToTreatIsNotNull()
	{
		return this.decisiontotreat != null;
	}
	public ims.framework.utils.Date getDecisionToTreat()
	{
		return this.decisiontotreat;
	}
	public void setDecisionToTreat(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.decisiontotreat = value;
	}
	public boolean getActionsIsNotNull()
	{
		return this.actions != null;
	}
	public ims.ccosched.vo.PatTreatPlanActionLiteVoCollection getActions()
	{
		return this.actions;
	}
	public void setActions(ims.ccosched.vo.PatTreatPlanActionLiteVoCollection value)
	{
		this.isValidated = false;
		this.actions = value;
	}
	public boolean getTreatmentSitesIsNotNull()
	{
		return this.treatmentsites != null;
	}
	public ims.oncology.vo.lookups.TreatmentGroupSiteCollection getTreatmentSites()
	{
		return this.treatmentsites;
	}
	public void setTreatmentSites(ims.oncology.vo.lookups.TreatmentGroupSiteCollection value)
	{
		this.isValidated = false;
		this.treatmentsites = value;
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
	
		PatTreatmentPlanRadiotherapyDialogVo clone = new PatTreatmentPlanRadiotherapyDialogVo(this.id, this.version);
		
		if(this.decisiontotreat == null)
			clone.decisiontotreat = null;
		else
			clone.decisiontotreat = (ims.framework.utils.Date)this.decisiontotreat.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.ccosched.vo.PatTreatPlanActionLiteVoCollection)this.actions.clone();
		if(this.treatmentsites == null)
			clone.treatmentsites = null;
		else
			clone.treatmentsites = (ims.oncology.vo.lookups.TreatmentGroupSiteCollection)this.treatmentsites.clone();
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
		if (!(PatTreatmentPlanRadiotherapyDialogVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatTreatmentPlanRadiotherapyDialogVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatTreatmentPlanRadiotherapyDialogVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatTreatmentPlanRadiotherapyDialogVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.decisiontotreat != null)
			count++;
		if(this.actions != null)
			count++;
		if(this.treatmentsites != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.Date decisiontotreat;
	protected ims.ccosched.vo.PatTreatPlanActionLiteVoCollection actions;
	protected ims.oncology.vo.lookups.TreatmentGroupSiteCollection treatmentsites;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
