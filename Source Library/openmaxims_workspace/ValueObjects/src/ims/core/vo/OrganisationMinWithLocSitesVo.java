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
 * Linked to core.resource.place.Organisation business object (ID: 1007100003).
 */
public class OrganisationMinWithLocSitesVo extends ims.core.resource.place.vo.OrganisationRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrganisationMinWithLocSitesVo()
	{
	}
	public OrganisationMinWithLocSitesVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrganisationMinWithLocSitesVo(ims.core.vo.beans.OrganisationMinWithLocSitesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.locationsites = ims.core.vo.LocSiteLiteWithLocationsVoCollection.buildFromBeanCollection(bean.getLocationSites());
		this.relatedorganisations = ims.core.vo.OrganisationMinWithLocSitesVoCollection.buildFromBeanCollection(bean.getRelatedOrganisations());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.OrganisationMinWithLocSitesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.isactive = bean.getIsActive();
		this.locationsites = ims.core.vo.LocSiteLiteWithLocationsVoCollection.buildFromBeanCollection(bean.getLocationSites());
		this.relatedorganisations = ims.core.vo.OrganisationMinWithLocSitesVoCollection.buildFromBeanCollection(bean.getRelatedOrganisations());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.OrganisationMinWithLocSitesVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.OrganisationMinWithLocSitesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.OrganisationMinWithLocSitesVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("LOCATIONSITES"))
			return getLocationSites();
		if(fieldName.equals("RELATEDORGANISATIONS"))
			return getRelatedOrganisations();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 120;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getLocationSitesIsNotNull()
	{
		return this.locationsites != null;
	}
	public ims.core.vo.LocSiteLiteWithLocationsVoCollection getLocationSites()
	{
		return this.locationsites;
	}
	public void setLocationSites(ims.core.vo.LocSiteLiteWithLocationsVoCollection value)
	{
		this.isValidated = false;
		this.locationsites = value;
	}
	public boolean getRelatedOrganisationsIsNotNull()
	{
		return this.relatedorganisations != null;
	}
	public ims.core.vo.OrganisationMinWithLocSitesVoCollection getRelatedOrganisations()
	{
		return this.relatedorganisations;
	}
	public void setRelatedOrganisations(ims.core.vo.OrganisationMinWithLocSitesVoCollection value)
	{
		this.isValidated = false;
		this.relatedorganisations = value;
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
		if(this.locationsites != null)
		{
			if(!this.locationsites.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 120)
			listOfErrors.add("The length of the field [name] in the value object [ims.core.vo.OrganisationMinWithLocSitesVo] is too big. It should be less or equal to 120");
		if(this.locationsites != null)
		{
			String[] listOfOtherErrors = this.locationsites.validate();
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
	
		OrganisationMinWithLocSitesVo clone = new OrganisationMinWithLocSitesVo(this.id, this.version);
		
		clone.name = this.name;
		clone.isactive = this.isactive;
		if(this.locationsites == null)
			clone.locationsites = null;
		else
			clone.locationsites = (ims.core.vo.LocSiteLiteWithLocationsVoCollection)this.locationsites.clone();
		if(this.relatedorganisations == null)
			clone.relatedorganisations = null;
		else
			clone.relatedorganisations = (ims.core.vo.OrganisationMinWithLocSitesVoCollection)this.relatedorganisations.clone();
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
		if (!(OrganisationMinWithLocSitesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrganisationMinWithLocSitesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		OrganisationMinWithLocSitesVo compareObj = (OrganisationMinWithLocSitesVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.locationsites != null)
			count++;
		if(this.relatedorganisations != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected Boolean isactive;
	protected ims.core.vo.LocSiteLiteWithLocationsVoCollection locationsites;
	protected ims.core.vo.OrganisationMinWithLocSitesVoCollection relatedorganisations;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
