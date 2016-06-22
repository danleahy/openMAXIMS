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
 * Linked to core.admin.EpisodeOfCare business object (ID: 1004100018).
 */
public class EpisodeOfCareAdmitVo extends ims.core.admin.vo.EpisodeOfCareRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpisodeOfCareAdmitVo()
	{
	}
	public EpisodeOfCareAdmitVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpisodeOfCareAdmitVo(ims.core.vo.beans.EpisodeOfCareAdmitVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.carespell = bean.getCareSpell() == null ? null : new ims.core.admin.vo.CareSpellRefVo(new Integer(bean.getCareSpell().getId()), bean.getCareSpell().getVersion());
		this.relationship = bean.getRelationship() == null ? null : ims.core.vo.lookups.CareSpelltoEpisodeRelationship.buildLookup(bean.getRelationship());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getResponsibleHCP().getId()), bean.getResponsibleHCP().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.statushistory = ims.core.vo.EpisodeOfCareStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.carecontexts = ims.core.vo.CareContextAdmitVoCollection.buildFromBeanCollection(bean.getCareContexts());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.EpisodeOfCareAdmitVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.carespell = bean.getCareSpell() == null ? null : new ims.core.admin.vo.CareSpellRefVo(new Integer(bean.getCareSpell().getId()), bean.getCareSpell().getVersion());
		this.relationship = bean.getRelationship() == null ? null : ims.core.vo.lookups.CareSpelltoEpisodeRelationship.buildLookup(bean.getRelationship());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getResponsibleHCP().getId()), bean.getResponsibleHCP().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.statushistory = ims.core.vo.EpisodeOfCareStatusHistoryVoCollection.buildFromBeanCollection(bean.getStatusHistory());
		this.carecontexts = ims.core.vo.CareContextAdmitVoCollection.buildFromBeanCollection(bean.getCareContexts());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.EpisodeOfCareAdmitVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.EpisodeOfCareAdmitVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.EpisodeOfCareAdmitVoBean();
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
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		if(fieldName.equals("CARESPELL"))
			return getCareSpell();
		if(fieldName.equals("RELATIONSHIP"))
			return getRelationship();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("STATUSHISTORY"))
			return getStatusHistory();
		if(fieldName.equals("CARECONTEXTS"))
			return getCareContexts();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartDateIsNotNull()
	{
		return this.startdate != null;
	}
	public ims.framework.utils.Date getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.startdate = value;
	}
	public boolean getEndDateIsNotNull()
	{
		return this.enddate != null;
	}
	public ims.framework.utils.Date getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.enddate = value;
	}
	public boolean getCareSpellIsNotNull()
	{
		return this.carespell != null;
	}
	public ims.core.admin.vo.CareSpellRefVo getCareSpell()
	{
		return this.carespell;
	}
	public void setCareSpell(ims.core.admin.vo.CareSpellRefVo value)
	{
		this.isValidated = false;
		this.carespell = value;
	}
	public boolean getRelationshipIsNotNull()
	{
		return this.relationship != null;
	}
	public ims.core.vo.lookups.CareSpelltoEpisodeRelationship getRelationship()
	{
		return this.relationship;
	}
	public void setRelationship(ims.core.vo.lookups.CareSpelltoEpisodeRelationship value)
	{
		this.isValidated = false;
		this.relationship = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.core.vo.EpisodeOfCareStatusHistoryVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.core.vo.EpisodeOfCareStatusHistoryVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getStatusHistoryIsNotNull()
	{
		return this.statushistory != null;
	}
	public ims.core.vo.EpisodeOfCareStatusHistoryVoCollection getStatusHistory()
	{
		return this.statushistory;
	}
	public void setStatusHistory(ims.core.vo.EpisodeOfCareStatusHistoryVoCollection value)
	{
		this.isValidated = false;
		this.statushistory = value;
	}
	public boolean getCareContextsIsNotNull()
	{
		return this.carecontexts != null;
	}
	public ims.core.vo.CareContextAdmitVoCollection getCareContexts()
	{
		return this.carecontexts;
	}
	public void setCareContexts(ims.core.vo.CareContextAdmitVoCollection value)
	{
		this.isValidated = false;
		this.carecontexts = value;
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
		if(this.carecontexts != null)
		{
			if(!this.carecontexts.isValidated())
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
		if(this.startdate == null)
			listOfErrors.add("StartDate is mandatory");
		if(this.carespell == null)
			listOfErrors.add("CareSpell is mandatory");
		if(this.specialty == null)
			listOfErrors.add("Specialty is mandatory");
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
		if(this.carecontexts != null)
		{
			String[] listOfOtherErrors = this.carecontexts.validate();
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
	
		EpisodeOfCareAdmitVo clone = new EpisodeOfCareAdmitVo(this.id, this.version);
		
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		clone.carespell = this.carespell;
		if(this.relationship == null)
			clone.relationship = null;
		else
			clone.relationship = (ims.core.vo.lookups.CareSpelltoEpisodeRelationship)this.relationship.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		clone.responsiblehcp = this.responsiblehcp;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.core.vo.EpisodeOfCareStatusHistoryVo)this.currentstatus.clone();
		if(this.statushistory == null)
			clone.statushistory = null;
		else
			clone.statushistory = (ims.core.vo.EpisodeOfCareStatusHistoryVoCollection)this.statushistory.clone();
		if(this.carecontexts == null)
			clone.carecontexts = null;
		else
			clone.carecontexts = (ims.core.vo.CareContextAdmitVoCollection)this.carecontexts.clone();
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
		if (!(EpisodeOfCareAdmitVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpisodeOfCareAdmitVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EpisodeOfCareAdmitVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EpisodeOfCareAdmitVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.carespell != null)
			count++;
		if(this.relationship != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.statushistory != null)
			count++;
		if(this.carecontexts != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	protected ims.core.admin.vo.CareSpellRefVo carespell;
	protected ims.core.vo.lookups.CareSpelltoEpisodeRelationship relationship;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.resource.people.vo.HcpRefVo responsiblehcp;
	protected ims.core.vo.EpisodeOfCareStatusHistoryVo currentstatus;
	protected ims.core.vo.EpisodeOfCareStatusHistoryVoCollection statushistory;
	protected ims.core.vo.CareContextAdmitVoCollection carecontexts;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
