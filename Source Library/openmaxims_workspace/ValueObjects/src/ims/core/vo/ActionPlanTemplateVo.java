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

package ims.core.vo;

/**
 * Linked to NAES.ActionPlanTemplate business object (ID: 1097100000).
 */
public class ActionPlanTemplateVo extends ims.naes.vo.ActionPlanTemplateRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActionPlanTemplateVo()
	{
	}
	public ActionPlanTemplateVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActionPlanTemplateVo(ims.core.vo.beans.ActionPlanTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.actionplanname = bean.getActionPlanName();
		this.description = bean.getDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.actions = ims.naes.vo.TemplateActionVoCollection.buildFromBeanCollection(bean.getActions());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ActionPlanTemplateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.actionplanname = bean.getActionPlanName();
		this.description = bean.getDescription();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.actions = ims.naes.vo.TemplateActionVoCollection.buildFromBeanCollection(bean.getActions());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ActionPlanTemplateVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ActionPlanTemplateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ActionPlanTemplateVoBean();
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
		if(fieldName.equals("ACTIONPLANNAME"))
			return getActionPlanName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("ACTIONS"))
			return getActions();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getActionPlanNameIsNotNull()
	{
		return this.actionplanname != null;
	}
	public String getActionPlanName()
	{
		return this.actionplanname;
	}
	public static int getActionPlanNameMaxLength()
	{
		return 125;
	}
	public void setActionPlanName(String value)
	{
		this.isValidated = false;
		this.actionplanname = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 500;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getActionsIsNotNull()
	{
		return this.actions != null;
	}
	public ims.naes.vo.TemplateActionVoCollection getActions()
	{
		return this.actions;
	}
	public void setActions(ims.naes.vo.TemplateActionVoCollection value)
	{
		this.isValidated = false;
		this.actions = value;
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
		if(this.actions != null)
		{
			if(!this.actions.isValidated())
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
		if(this.actionplanname == null || this.actionplanname.length() == 0)
			listOfErrors.add("ActionPlanName is mandatory");
		else if(this.actionplanname.length() > 125)
			listOfErrors.add("The length of the field [actionplanname] in the value object [ims.core.vo.ActionPlanTemplateVo] is too big. It should be less or equal to 125");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.core.vo.ActionPlanTemplateVo] is too big. It should be less or equal to 500");
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
		if(this.actions != null)
		{
			String[] listOfOtherErrors = this.actions.validate();
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
	
		ActionPlanTemplateVo clone = new ActionPlanTemplateVo(this.id, this.version);
		
		clone.actionplanname = this.actionplanname;
		clone.description = this.description;
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		if(this.actions == null)
			clone.actions = null;
		else
			clone.actions = (ims.naes.vo.TemplateActionVoCollection)this.actions.clone();
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
		if (!(ActionPlanTemplateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActionPlanTemplateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ActionPlanTemplateVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ActionPlanTemplateVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.actionplanname != null)
			count++;
		if(this.description != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.actions != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String actionplanname;
	protected String description;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected ims.naes.vo.TemplateActionVoCollection actions;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
