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
 * Linked to Oncology.ActualPlanDetails business object (ID: 1074100034).
 */
public class ActualPlanDetailsVo extends ims.oncology.vo.ActualPlanDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ActualPlanDetailsVo()
	{
	}
	public ActualPlanDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ActualPlanDetailsVo(ims.oncology.vo.beans.ActualPlanDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.plannedtreatmenttype = bean.getPlannedTreatmentType() == null ? null : ims.oncology.vo.lookups.TreatmentType.buildLookup(bean.getPlannedTreatmentType());
		this.organisationplanned = bean.getOrganisationPlanned() == null ? null : ims.oncology.vo.lookups.OrganisationPlannedTreatment.buildLookup(bean.getOrganisationPlanned());
		this.actualtreatmentdate = bean.getActualTreatmentDate() == null ? null : bean.getActualTreatmentDate().buildDate();
		this.actualtreatmenttype = bean.getActualTreatmentType() == null ? null : ims.oncology.vo.lookups.TreatmentType.buildLookup(bean.getActualTreatmentType());
		this.organisationorganised = bean.getOrganisationOrganised() == null ? null : ims.oncology.vo.lookups.OrganisationOrganisedTreatment.buildLookup(bean.getOrganisationOrganised());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ActualPlanDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.datedecisiontotreat = bean.getDateDecisionToTreat() == null ? null : bean.getDateDecisionToTreat().buildDate();
		this.plannedtreatmenttype = bean.getPlannedTreatmentType() == null ? null : ims.oncology.vo.lookups.TreatmentType.buildLookup(bean.getPlannedTreatmentType());
		this.organisationplanned = bean.getOrganisationPlanned() == null ? null : ims.oncology.vo.lookups.OrganisationPlannedTreatment.buildLookup(bean.getOrganisationPlanned());
		this.actualtreatmentdate = bean.getActualTreatmentDate() == null ? null : bean.getActualTreatmentDate().buildDate();
		this.actualtreatmenttype = bean.getActualTreatmentType() == null ? null : ims.oncology.vo.lookups.TreatmentType.buildLookup(bean.getActualTreatmentType());
		this.organisationorganised = bean.getOrganisationOrganised() == null ? null : ims.oncology.vo.lookups.OrganisationOrganisedTreatment.buildLookup(bean.getOrganisationOrganised());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ActualPlanDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ActualPlanDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ActualPlanDetailsVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("DATEDECISIONTOTREAT"))
			return getDateDecisionToTreat();
		if(fieldName.equals("PLANNEDTREATMENTTYPE"))
			return getPlannedTreatmentType();
		if(fieldName.equals("ORGANISATIONPLANNED"))
			return getOrganisationPlanned();
		if(fieldName.equals("ACTUALTREATMENTDATE"))
			return getActualTreatmentDate();
		if(fieldName.equals("ACTUALTREATMENTTYPE"))
			return getActualTreatmentType();
		if(fieldName.equals("ORGANISATIONORGANISED"))
			return getOrganisationOrganised();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getDateDecisionToTreatIsNotNull()
	{
		return this.datedecisiontotreat != null;
	}
	public ims.framework.utils.Date getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datedecisiontotreat = value;
	}
	public boolean getPlannedTreatmentTypeIsNotNull()
	{
		return this.plannedtreatmenttype != null;
	}
	public ims.oncology.vo.lookups.TreatmentType getPlannedTreatmentType()
	{
		return this.plannedtreatmenttype;
	}
	public void setPlannedTreatmentType(ims.oncology.vo.lookups.TreatmentType value)
	{
		this.isValidated = false;
		this.plannedtreatmenttype = value;
	}
	public boolean getOrganisationPlannedIsNotNull()
	{
		return this.organisationplanned != null;
	}
	public ims.oncology.vo.lookups.OrganisationPlannedTreatment getOrganisationPlanned()
	{
		return this.organisationplanned;
	}
	public void setOrganisationPlanned(ims.oncology.vo.lookups.OrganisationPlannedTreatment value)
	{
		this.isValidated = false;
		this.organisationplanned = value;
	}
	public boolean getActualTreatmentDateIsNotNull()
	{
		return this.actualtreatmentdate != null;
	}
	public ims.framework.utils.Date getActualTreatmentDate()
	{
		return this.actualtreatmentdate;
	}
	public void setActualTreatmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.actualtreatmentdate = value;
	}
	public boolean getActualTreatmentTypeIsNotNull()
	{
		return this.actualtreatmenttype != null;
	}
	public ims.oncology.vo.lookups.TreatmentType getActualTreatmentType()
	{
		return this.actualtreatmenttype;
	}
	public void setActualTreatmentType(ims.oncology.vo.lookups.TreatmentType value)
	{
		this.isValidated = false;
		this.actualtreatmenttype = value;
	}
	public boolean getOrganisationOrganisedIsNotNull()
	{
		return this.organisationorganised != null;
	}
	public ims.oncology.vo.lookups.OrganisationOrganisedTreatment getOrganisationOrganised()
	{
		return this.organisationorganised;
	}
	public void setOrganisationOrganised(ims.oncology.vo.lookups.OrganisationOrganisedTreatment value)
	{
		this.isValidated = false;
		this.organisationorganised = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		ActualPlanDetailsVo clone = new ActualPlanDetailsVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.datedecisiontotreat == null)
			clone.datedecisiontotreat = null;
		else
			clone.datedecisiontotreat = (ims.framework.utils.Date)this.datedecisiontotreat.clone();
		if(this.plannedtreatmenttype == null)
			clone.plannedtreatmenttype = null;
		else
			clone.plannedtreatmenttype = (ims.oncology.vo.lookups.TreatmentType)this.plannedtreatmenttype.clone();
		if(this.organisationplanned == null)
			clone.organisationplanned = null;
		else
			clone.organisationplanned = (ims.oncology.vo.lookups.OrganisationPlannedTreatment)this.organisationplanned.clone();
		if(this.actualtreatmentdate == null)
			clone.actualtreatmentdate = null;
		else
			clone.actualtreatmentdate = (ims.framework.utils.Date)this.actualtreatmentdate.clone();
		if(this.actualtreatmenttype == null)
			clone.actualtreatmenttype = null;
		else
			clone.actualtreatmenttype = (ims.oncology.vo.lookups.TreatmentType)this.actualtreatmenttype.clone();
		if(this.organisationorganised == null)
			clone.organisationorganised = null;
		else
			clone.organisationorganised = (ims.oncology.vo.lookups.OrganisationOrganisedTreatment)this.organisationorganised.clone();
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
		if (!(ActualPlanDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ActualPlanDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ActualPlanDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ActualPlanDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carecontext != null)
			count++;
		if(this.datedecisiontotreat != null)
			count++;
		if(this.plannedtreatmenttype != null)
			count++;
		if(this.organisationplanned != null)
			count++;
		if(this.actualtreatmentdate != null)
			count++;
		if(this.actualtreatmenttype != null)
			count++;
		if(this.organisationorganised != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.framework.utils.Date datedecisiontotreat;
	protected ims.oncology.vo.lookups.TreatmentType plannedtreatmenttype;
	protected ims.oncology.vo.lookups.OrganisationPlannedTreatment organisationplanned;
	protected ims.framework.utils.Date actualtreatmentdate;
	protected ims.oncology.vo.lookups.TreatmentType actualtreatmenttype;
	protected ims.oncology.vo.lookups.OrganisationOrganisedTreatment organisationorganised;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
