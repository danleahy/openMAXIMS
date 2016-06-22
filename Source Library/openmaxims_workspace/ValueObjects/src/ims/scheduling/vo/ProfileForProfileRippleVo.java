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

package ims.scheduling.vo;

/**
 * Linked to Scheduling.Sch_Profile business object (ID: 1005100001).
 */
public class ProfileForProfileRippleVo extends ims.scheduling.vo.ProfileShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ProfileForProfileRippleVo()
	{
	}
	public ProfileForProfileRippleVo(Integer id, int version)
	{
		super(id, version);
	}
	public ProfileForProfileRippleVo(ims.scheduling.vo.beans.ProfileForProfileRippleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.prfcategory = bean.getPrfCategory() == null ? null : ims.scheduling.vo.lookups.Sched_Prfile_Cat.buildLookup(bean.getPrfCategory());
		this.prftype = bean.getPrftype() == null ? null : ims.scheduling.vo.lookups.Sched_Profile_Type.buildLookup(bean.getPrftype());
		this.efffrm = bean.getEffFrm() == null ? null : bean.getEffFrm().buildDate();
		this.effto = bean.getEffTo() == null ? null : bean.getEffTo().buildDate();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.lastactualgendate = bean.getLastActualGenDate() == null ? null : bean.getLastActualGenDate().buildDate();
		this.lastgendate = bean.getLastGenDate() == null ? null : bean.getLastGenDate().buildDate();
		this.autogenerateperiod = bean.getAutoGeneratePeriod();
		this.readytogenerate = bean.getReadyToGenerate();
		this.isfixed = bean.getIsFixed();
		this.schlocation = bean.getSchLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getSchLocation().getId()), bean.getSchLocation().getVersion());
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.profileslots = ims.scheduling.vo.Profile_SlotGenericVoCollection.buildFromBeanCollection(bean.getProfileSlots());
		this.listowners = ims.scheduling.vo.Profile_ListOwnerVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.profiletype = bean.getProfileType() == null ? null : ims.scheduling.vo.lookups.SchProfileType.buildLookup(bean.getProfileType());
		this.function = ims.core.vo.lookups.ServiceFunctionCollection.buildFromBeanCollection(bean.getFunction());
		this.directoryofservices = ims.scheduling.vo.DirectoryOfServiceVoCollection.buildFromBeanCollection(bean.getDirectoryOfServices());
		this.haschoosebookactivity = bean.getHasChooseBookActivity();
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
		if(bean.getParentChildSlots() != null)
		{
			this.parentchildslots = new ims.scheduling.vo.ProfileParentChildSlotRefVoCollection();
			for(int parentchildslots_i = 0; parentchildslots_i < bean.getParentChildSlots().length; parentchildslots_i++)
			{
				this.parentchildslots.add(new ims.scheduling.vo.ProfileParentChildSlotRefVo(new Integer(bean.getParentChildSlots()[parentchildslots_i].getId()), bean.getParentChildSlots()[parentchildslots_i].getVersion()));
			}
		}
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.ProfileForProfileRippleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.prfcategory = bean.getPrfCategory() == null ? null : ims.scheduling.vo.lookups.Sched_Prfile_Cat.buildLookup(bean.getPrfCategory());
		this.prftype = bean.getPrftype() == null ? null : ims.scheduling.vo.lookups.Sched_Profile_Type.buildLookup(bean.getPrftype());
		this.efffrm = bean.getEffFrm() == null ? null : bean.getEffFrm().buildDate();
		this.effto = bean.getEffTo() == null ? null : bean.getEffTo().buildDate();
		this.isactive = bean.getIsActive();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.lastactualgendate = bean.getLastActualGenDate() == null ? null : bean.getLastActualGenDate().buildDate();
		this.lastgendate = bean.getLastGenDate() == null ? null : bean.getLastGenDate().buildDate();
		this.autogenerateperiod = bean.getAutoGeneratePeriod();
		this.readytogenerate = bean.getReadyToGenerate();
		this.isfixed = bean.getIsFixed();
		this.schlocation = bean.getSchLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getSchLocation().getId()), bean.getSchLocation().getVersion());
		this.starttm = bean.getStartTm() == null ? null : bean.getStartTm().buildTime();
		this.endtm = bean.getEndTm() == null ? null : bean.getEndTm().buildTime();
		this.profileslots = ims.scheduling.vo.Profile_SlotGenericVoCollection.buildFromBeanCollection(bean.getProfileSlots());
		this.listowners = ims.scheduling.vo.Profile_ListOwnerVoCollection.buildFromBeanCollection(bean.getListOwners());
		this.profiletype = bean.getProfileType() == null ? null : ims.scheduling.vo.lookups.SchProfileType.buildLookup(bean.getProfileType());
		this.function = ims.core.vo.lookups.ServiceFunctionCollection.buildFromBeanCollection(bean.getFunction());
		this.directoryofservices = ims.scheduling.vo.DirectoryOfServiceVoCollection.buildFromBeanCollection(bean.getDirectoryOfServices());
		this.haschoosebookactivity = bean.getHasChooseBookActivity();
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
		if(bean.getParentChildSlots() != null)
		{
			this.parentchildslots = new ims.scheduling.vo.ProfileParentChildSlotRefVoCollection();
			for(int parentchildslots_i = 0; parentchildslots_i < bean.getParentChildSlots().length; parentchildslots_i++)
			{
				this.parentchildslots.add(new ims.scheduling.vo.ProfileParentChildSlotRefVo(new Integer(bean.getParentChildSlots()[parentchildslots_i].getId()), bean.getParentChildSlots()[parentchildslots_i].getVersion()));
			}
		}
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.ProfileForProfileRippleVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.ProfileForProfileRippleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.ProfileForProfileRippleVoBean();
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
		if(fieldName.equals("SCHLOCATION"))
			return getSchLocation();
		if(fieldName.equals("STARTTM"))
			return getStartTm();
		if(fieldName.equals("ENDTM"))
			return getEndTm();
		if(fieldName.equals("PROFILESLOTS"))
			return getProfileSlots();
		if(fieldName.equals("LISTOWNERS"))
			return getListOwners();
		if(fieldName.equals("PROFILETYPE"))
			return getProfileType();
		if(fieldName.equals("FUNCTION"))
			return getFunction();
		if(fieldName.equals("DIRECTORYOFSERVICES"))
			return getDirectoryOfServices();
		if(fieldName.equals("HASCHOOSEBOOKACTIVITY"))
			return getHasChooseBookActivity();
		if(fieldName.equals("HOSPITAL"))
			return getHospital();
		if(fieldName.equals("PARENTCHILDSLOTS"))
			return getParentChildSlots();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSchLocationIsNotNull()
	{
		return this.schlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.schlocation = value;
	}
	public boolean getStartTmIsNotNull()
	{
		return this.starttm != null;
	}
	public ims.framework.utils.Time getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.starttm = value;
	}
	public boolean getEndTmIsNotNull()
	{
		return this.endtm != null;
	}
	public ims.framework.utils.Time getEndTm()
	{
		return this.endtm;
	}
	public void setEndTm(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.endtm = value;
	}
	public boolean getProfileSlotsIsNotNull()
	{
		return this.profileslots != null;
	}
	public ims.scheduling.vo.Profile_SlotGenericVoCollection getProfileSlots()
	{
		return this.profileslots;
	}
	public void setProfileSlots(ims.scheduling.vo.Profile_SlotGenericVoCollection value)
	{
		this.isValidated = false;
		this.profileslots = value;
	}
	public boolean getListOwnersIsNotNull()
	{
		return this.listowners != null;
	}
	public ims.scheduling.vo.Profile_ListOwnerVoCollection getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.Profile_ListOwnerVoCollection value)
	{
		this.isValidated = false;
		this.listowners = value;
	}
	public boolean getProfileTypeIsNotNull()
	{
		return this.profiletype != null;
	}
	public ims.scheduling.vo.lookups.SchProfileType getProfileType()
	{
		return this.profiletype;
	}
	public void setProfileType(ims.scheduling.vo.lookups.SchProfileType value)
	{
		this.isValidated = false;
		this.profiletype = value;
	}
	public boolean getFunctionIsNotNull()
	{
		return this.function != null;
	}
	public ims.core.vo.lookups.ServiceFunctionCollection getFunction()
	{
		return this.function;
	}
	public void setFunction(ims.core.vo.lookups.ServiceFunctionCollection value)
	{
		this.isValidated = false;
		this.function = value;
	}
	public boolean getDirectoryOfServicesIsNotNull()
	{
		return this.directoryofservices != null;
	}
	public ims.scheduling.vo.DirectoryOfServiceVoCollection getDirectoryOfServices()
	{
		return this.directoryofservices;
	}
	public void setDirectoryOfServices(ims.scheduling.vo.DirectoryOfServiceVoCollection value)
	{
		this.isValidated = false;
		this.directoryofservices = value;
	}
	public boolean getHasChooseBookActivityIsNotNull()
	{
		return this.haschoosebookactivity != null;
	}
	public Boolean getHasChooseBookActivity()
	{
		return this.haschoosebookactivity;
	}
	public void setHasChooseBookActivity(Boolean value)
	{
		this.isValidated = false;
		this.haschoosebookactivity = value;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.vo.LocationLiteVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getParentChildSlotsIsNotNull()
	{
		return this.parentchildslots != null;
	}
	public ims.scheduling.vo.ProfileParentChildSlotRefVoCollection getParentChildSlots()
	{
		return this.parentchildslots;
	}
	public void setParentChildSlots(ims.scheduling.vo.ProfileParentChildSlotRefVoCollection value)
	{
		this.isValidated = false;
		this.parentchildslots = value;
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
		if(this.service != null)
		{
			if(!this.service.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.profileslots != null)
		{
			if(!this.profileslots.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.listowners != null)
		{
			if(!this.listowners.isValidated())
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
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.scheduling.vo.ProfileForProfileRippleVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.scheduling.vo.ProfileForProfileRippleVo] is too big. It should be less or equal to 255");
		if(this.prfcategory == null)
			listOfErrors.add("Category is mandatory");
		if(this.prftype == null)
			listOfErrors.add("Type is mandatory");
		if(this.efffrm == null)
			listOfErrors.add("Start Date is mandatory");
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.service != null)
		{
			String[] listOfOtherErrors = this.service.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isfixed == null)
			listOfErrors.add("isFixed is mandatory");
		if(this.schlocation == null)
			listOfErrors.add("SchLocation is mandatory");
		if(this.starttm == null)
			listOfErrors.add("'Profile Start Time' is mandatory");
		if(this.endtm == null)
			listOfErrors.add("'Profile End Time' is mandatory");
		if(this.profileslots != null)
		{
			String[] listOfOtherErrors = this.profileslots.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.listowners != null)
		{
			String[] listOfOtherErrors = this.listowners.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.profiletype == null)
			listOfErrors.add("ProfileType is mandatory");
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
	
		ProfileForProfileRippleVo clone = new ProfileForProfileRippleVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		if(this.prfcategory == null)
			clone.prfcategory = null;
		else
			clone.prfcategory = (ims.scheduling.vo.lookups.Sched_Prfile_Cat)this.prfcategory.clone();
		if(this.prftype == null)
			clone.prftype = null;
		else
			clone.prftype = (ims.scheduling.vo.lookups.Sched_Profile_Type)this.prftype.clone();
		if(this.efffrm == null)
			clone.efffrm = null;
		else
			clone.efffrm = (ims.framework.utils.Date)this.efffrm.clone();
		if(this.effto == null)
			clone.effto = null;
		else
			clone.effto = (ims.framework.utils.Date)this.effto.clone();
		clone.isactive = this.isactive;
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceShortVo)this.service.clone();
		if(this.lastactualgendate == null)
			clone.lastactualgendate = null;
		else
			clone.lastactualgendate = (ims.framework.utils.Date)this.lastactualgendate.clone();
		if(this.lastgendate == null)
			clone.lastgendate = null;
		else
			clone.lastgendate = (ims.framework.utils.Date)this.lastgendate.clone();
		clone.autogenerateperiod = this.autogenerateperiod;
		clone.readytogenerate = this.readytogenerate;
		clone.isfixed = this.isfixed;
		clone.schlocation = this.schlocation;
		if(this.starttm == null)
			clone.starttm = null;
		else
			clone.starttm = (ims.framework.utils.Time)this.starttm.clone();
		if(this.endtm == null)
			clone.endtm = null;
		else
			clone.endtm = (ims.framework.utils.Time)this.endtm.clone();
		if(this.profileslots == null)
			clone.profileslots = null;
		else
			clone.profileslots = (ims.scheduling.vo.Profile_SlotGenericVoCollection)this.profileslots.clone();
		if(this.listowners == null)
			clone.listowners = null;
		else
			clone.listowners = (ims.scheduling.vo.Profile_ListOwnerVoCollection)this.listowners.clone();
		if(this.profiletype == null)
			clone.profiletype = null;
		else
			clone.profiletype = (ims.scheduling.vo.lookups.SchProfileType)this.profiletype.clone();
		if(this.function == null)
			clone.function = null;
		else
			clone.function = (ims.core.vo.lookups.ServiceFunctionCollection)this.function.clone();
		if(this.directoryofservices == null)
			clone.directoryofservices = null;
		else
			clone.directoryofservices = (ims.scheduling.vo.DirectoryOfServiceVoCollection)this.directoryofservices.clone();
		clone.haschoosebookactivity = this.haschoosebookactivity;
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocationLiteVo)this.hospital.clone();
		clone.parentchildslots = this.parentchildslots;
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
		if (!(ProfileForProfileRippleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ProfileForProfileRippleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ProfileForProfileRippleVo compareObj = (ProfileForProfileRippleVo)obj;
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
		int count = super.countFieldsWithValue();
		if(this.schlocation != null)
			count++;
		if(this.starttm != null)
			count++;
		if(this.endtm != null)
			count++;
		if(this.profileslots != null)
			count++;
		if(this.listowners != null)
			count++;
		if(this.profiletype != null)
			count++;
		if(this.function != null)
			count++;
		if(this.directoryofservices != null)
			count++;
		if(this.haschoosebookactivity != null)
			count++;
		if(this.hospital != null)
			count++;
		if(this.parentchildslots != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 11;
	}
	protected ims.core.resource.place.vo.LocationRefVo schlocation;
	protected ims.framework.utils.Time starttm;
	protected ims.framework.utils.Time endtm;
	protected ims.scheduling.vo.Profile_SlotGenericVoCollection profileslots;
	protected ims.scheduling.vo.Profile_ListOwnerVoCollection listowners;
	protected ims.scheduling.vo.lookups.SchProfileType profiletype;
	protected ims.core.vo.lookups.ServiceFunctionCollection function;
	protected ims.scheduling.vo.DirectoryOfServiceVoCollection directoryofservices;
	protected Boolean haschoosebookactivity;
	protected ims.core.vo.LocationLiteVo hospital;
	protected ims.scheduling.vo.ProfileParentChildSlotRefVoCollection parentchildslots;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
