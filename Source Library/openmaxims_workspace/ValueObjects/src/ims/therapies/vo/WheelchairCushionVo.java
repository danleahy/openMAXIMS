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
 * Linked to therapies.MobilityTransfers.WheelchairCushion business object (ID: 1019100043).
 */
public class WheelchairCushionVo extends ims.therapies.mobilitytransfers.vo.WheelchairCushionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WheelchairCushionVo()
	{
	}
	public WheelchairCushionVo(Integer id, int version)
	{
		super(id, version);
	}
	public WheelchairCushionVo(ims.therapies.vo.beans.WheelchairCushionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.cushiontype = bean.getCushionType() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCushionType.buildLookup(bean.getCushionType());
		this.cushioncategory = bean.getCushionCategory() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCushionType.buildLookup(bean.getCushionCategory());
		this.covertype = bean.getCoverType() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCoverType.buildLookup(bean.getCoverType());
		this.cushionsize = bean.getCushionSize() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCushionSize.buildLookup(bean.getCushionSize());
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.pressurereadingdate = ims.framework.utils.beans.DateBean.buildDateArray(bean.getPressureReadingDate());
		this.cushionmodification = ims.spinalinjuries.vo.lookups.WheelchairCushionModificationCollection.buildFromBeanCollection(bean.getCushionModification());
		this.cushionaccessory = ims.spinalinjuries.vo.lookups.WheelchairCushionAccessoryCollection.buildFromBeanCollection(bean.getCushionAccessory());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.WheelchairCushionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.cushiontype = bean.getCushionType() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCushionType.buildLookup(bean.getCushionType());
		this.cushioncategory = bean.getCushionCategory() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCushionType.buildLookup(bean.getCushionCategory());
		this.covertype = bean.getCoverType() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCoverType.buildLookup(bean.getCoverType());
		this.cushionsize = bean.getCushionSize() == null ? null : ims.spinalinjuries.vo.lookups.WheelchairCushionSize.buildLookup(bean.getCushionSize());
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
		this.pressurereadingdate = ims.framework.utils.beans.DateBean.buildDateArray(bean.getPressureReadingDate());
		this.cushionmodification = ims.spinalinjuries.vo.lookups.WheelchairCushionModificationCollection.buildFromBeanCollection(bean.getCushionModification());
		this.cushionaccessory = ims.spinalinjuries.vo.lookups.WheelchairCushionAccessoryCollection.buildFromBeanCollection(bean.getCushionAccessory());
		this.clinicalcontact = bean.getClinicalContact() == null ? null : new ims.core.admin.vo.ClinicalContactRefVo(new Integer(bean.getClinicalContact().getId()), bean.getClinicalContact().getVersion());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.WheelchairCushionVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.WheelchairCushionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.WheelchairCushionVoBean();
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
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("CUSHIONTYPE"))
			return getCushionType();
		if(fieldName.equals("CUSHIONCATEGORY"))
			return getCushionCategory();
		if(fieldName.equals("COVERTYPE"))
			return getCoverType();
		if(fieldName.equals("CUSHIONSIZE"))
			return getCushionSize();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		if(fieldName.equals("PRESSUREREADINGDATE"))
			return getPressureReadingDate();
		if(fieldName.equals("CUSHIONMODIFICATION"))
			return getCushionModification();
		if(fieldName.equals("CUSHIONACCESSORY"))
			return getCushionAccessory();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getCushionTypeIsNotNull()
	{
		return this.cushiontype != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairCushionType getCushionType()
	{
		return this.cushiontype;
	}
	public void setCushionType(ims.spinalinjuries.vo.lookups.WheelchairCushionType value)
	{
		this.isValidated = false;
		this.cushiontype = value;
	}
	public boolean getCushionCategoryIsNotNull()
	{
		return this.cushioncategory != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairCushionType getCushionCategory()
	{
		return this.cushioncategory;
	}
	public void setCushionCategory(ims.spinalinjuries.vo.lookups.WheelchairCushionType value)
	{
		this.isValidated = false;
		this.cushioncategory = value;
	}
	public boolean getCoverTypeIsNotNull()
	{
		return this.covertype != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairCoverType getCoverType()
	{
		return this.covertype;
	}
	public void setCoverType(ims.spinalinjuries.vo.lookups.WheelchairCoverType value)
	{
		this.isValidated = false;
		this.covertype = value;
	}
	public boolean getCushionSizeIsNotNull()
	{
		return this.cushionsize != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairCushionSize getCushionSize()
	{
		return this.cushionsize;
	}
	public void setCushionSize(ims.spinalinjuries.vo.lookups.WheelchairCushionSize value)
	{
		this.isValidated = false;
		this.cushionsize = value;
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
	public boolean getPressureReadingDateIsNotNull()
	{
		return this.pressurereadingdate != null;
	}
	public ims.framework.utils.Date[] getPressureReadingDate()
	{
		return this.pressurereadingdate;
	}
	public void setPressureReadingDate(ims.framework.utils.Date[] value)
	{
		this.isValidated = false;
		this.pressurereadingdate = value;
	}
	public boolean getCushionModificationIsNotNull()
	{
		return this.cushionmodification != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairCushionModificationCollection getCushionModification()
	{
		return this.cushionmodification;
	}
	public void setCushionModification(ims.spinalinjuries.vo.lookups.WheelchairCushionModificationCollection value)
	{
		this.isValidated = false;
		this.cushionmodification = value;
	}
	public boolean getCushionAccessoryIsNotNull()
	{
		return this.cushionaccessory != null;
	}
	public ims.spinalinjuries.vo.lookups.WheelchairCushionAccessoryCollection getCushionAccessory()
	{
		return this.cushionaccessory;
	}
	public void setCushionAccessory(ims.spinalinjuries.vo.lookups.WheelchairCushionAccessoryCollection value)
	{
		this.isValidated = false;
		this.cushionaccessory = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.admin.vo.ClinicalContactRefVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.admin.vo.ClinicalContactRefVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.authoringdatetime == null)
			listOfErrors.add("Please enter Date/Time.");
		if(this.authoringcp == null)
			listOfErrors.add("Please enter Authoring CP");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.cushiontype == null)
			listOfErrors.add("Please enter Type of Cushion.");
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
	
		WheelchairCushionVo clone = new WheelchairCushionVo(this.id, this.version);
		
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.cushiontype == null)
			clone.cushiontype = null;
		else
			clone.cushiontype = (ims.spinalinjuries.vo.lookups.WheelchairCushionType)this.cushiontype.clone();
		if(this.cushioncategory == null)
			clone.cushioncategory = null;
		else
			clone.cushioncategory = (ims.spinalinjuries.vo.lookups.WheelchairCushionType)this.cushioncategory.clone();
		if(this.covertype == null)
			clone.covertype = null;
		else
			clone.covertype = (ims.spinalinjuries.vo.lookups.WheelchairCoverType)this.covertype.clone();
		if(this.cushionsize == null)
			clone.cushionsize = null;
		else
			clone.cushionsize = (ims.spinalinjuries.vo.lookups.WheelchairCushionSize)this.cushionsize.clone();
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
		if(this.pressurereadingdate == null)
			clone.pressurereadingdate = null;
		else
			clone.pressurereadingdate = (ims.framework.utils.Date[])this.pressurereadingdate.clone();
		if(this.cushionmodification == null)
			clone.cushionmodification = null;
		else
			clone.cushionmodification = (ims.spinalinjuries.vo.lookups.WheelchairCushionModificationCollection)this.cushionmodification.clone();
		if(this.cushionaccessory == null)
			clone.cushionaccessory = null;
		else
			clone.cushionaccessory = (ims.spinalinjuries.vo.lookups.WheelchairCushionAccessoryCollection)this.cushionaccessory.clone();
		clone.clinicalcontact = this.clinicalcontact;
		clone.carecontext = this.carecontext;
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
		if (!(WheelchairCushionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WheelchairCushionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WheelchairCushionVo compareObj = (WheelchairCushionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_WheelchairCushion() == null && compareObj.getID_WheelchairCushion() != null)
				return -1;
			if(this.getID_WheelchairCushion() != null && compareObj.getID_WheelchairCushion() == null)
				return 1;
			if(this.getID_WheelchairCushion() != null && compareObj.getID_WheelchairCushion() != null)
				retVal = this.getID_WheelchairCushion().compareTo(compareObj.getID_WheelchairCushion());
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
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.cushiontype != null)
			count++;
		if(this.cushioncategory != null)
			count++;
		if(this.covertype != null)
			count++;
		if(this.cushionsize != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		if(this.pressurereadingdate != null)
			count++;
		if(this.cushionmodification != null)
			count++;
		if(this.cushionaccessory != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.spinalinjuries.vo.lookups.WheelchairCushionType cushiontype;
	protected ims.spinalinjuries.vo.lookups.WheelchairCushionType cushioncategory;
	protected ims.spinalinjuries.vo.lookups.WheelchairCoverType covertype;
	protected ims.spinalinjuries.vo.lookups.WheelchairCushionSize cushionsize;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	protected ims.framework.utils.Date[] pressurereadingdate;
	protected ims.spinalinjuries.vo.lookups.WheelchairCushionModificationCollection cushionmodification;
	protected ims.spinalinjuries.vo.lookups.WheelchairCushionAccessoryCollection cushionaccessory;
	protected ims.core.admin.vo.ClinicalContactRefVo clinicalcontact;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
