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
 * Linked to core.clinical.IllicitDrugs business object (ID: 1003100038).
 */
public class IllicitDrugsVo extends ims.core.clinical.vo.IllicitDrugsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public IllicitDrugsVo()
	{
	}
	public IllicitDrugsVo(Integer id, int version)
	{
		super(id, version);
	}
	public IllicitDrugsVo(ims.core.vo.beans.IllicitDrugsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.drugsusedinthepastmonth = bean.getDrugsUsedInThePastMonth() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDrugsUsedInThePastMonth());
		this.drugsusedintravenously = bean.getDrugsUsedIntravenously() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDrugsUsedIntravenously());
		this.useanyotherdrugs = bean.getUseAnyOtherDrugs() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getUseAnyOtherDrugs());
		this.otherdrugdetails = bean.getOtherDrugDetails();
		this.drugdetails = ims.core.vo.IllicitDrugsDetailsVoCollection.buildFromBeanCollection(bean.getDrugDetails());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.IllicitDrugsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.drugsusedinthepastmonth = bean.getDrugsUsedInThePastMonth() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDrugsUsedInThePastMonth());
		this.drugsusedintravenously = bean.getDrugsUsedIntravenously() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getDrugsUsedIntravenously());
		this.useanyotherdrugs = bean.getUseAnyOtherDrugs() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getUseAnyOtherDrugs());
		this.otherdrugdetails = bean.getOtherDrugDetails();
		this.drugdetails = ims.core.vo.IllicitDrugsDetailsVoCollection.buildFromBeanCollection(bean.getDrugDetails());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.IllicitDrugsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.IllicitDrugsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.IllicitDrugsVoBean();
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
		if(fieldName.equals("DRUGSUSEDINTHEPASTMONTH"))
			return getDrugsUsedInThePastMonth();
		if(fieldName.equals("DRUGSUSEDINTRAVENOUSLY"))
			return getDrugsUsedIntravenously();
		if(fieldName.equals("USEANYOTHERDRUGS"))
			return getUseAnyOtherDrugs();
		if(fieldName.equals("OTHERDRUGDETAILS"))
			return getOtherDrugDetails();
		if(fieldName.equals("DRUGDETAILS"))
			return getDrugDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDrugsUsedInThePastMonthIsNotNull()
	{
		return this.drugsusedinthepastmonth != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDrugsUsedInThePastMonth()
	{
		return this.drugsusedinthepastmonth;
	}
	public void setDrugsUsedInThePastMonth(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.drugsusedinthepastmonth = value;
	}
	public boolean getDrugsUsedIntravenouslyIsNotNull()
	{
		return this.drugsusedintravenously != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getDrugsUsedIntravenously()
	{
		return this.drugsusedintravenously;
	}
	public void setDrugsUsedIntravenously(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.drugsusedintravenously = value;
	}
	public boolean getUseAnyOtherDrugsIsNotNull()
	{
		return this.useanyotherdrugs != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getUseAnyOtherDrugs()
	{
		return this.useanyotherdrugs;
	}
	public void setUseAnyOtherDrugs(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.useanyotherdrugs = value;
	}
	public boolean getOtherDrugDetailsIsNotNull()
	{
		return this.otherdrugdetails != null;
	}
	public String getOtherDrugDetails()
	{
		return this.otherdrugdetails;
	}
	public static int getOtherDrugDetailsMaxLength()
	{
		return 255;
	}
	public void setOtherDrugDetails(String value)
	{
		this.isValidated = false;
		this.otherdrugdetails = value;
	}
	public boolean getDrugDetailsIsNotNull()
	{
		return this.drugdetails != null;
	}
	public ims.core.vo.IllicitDrugsDetailsVoCollection getDrugDetails()
	{
		return this.drugdetails;
	}
	public void setDrugDetails(ims.core.vo.IllicitDrugsDetailsVoCollection value)
	{
		this.isValidated = false;
		this.drugdetails = value;
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
		if(this.drugdetails != null)
		{
			if(!this.drugdetails.isValidated())
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
		if(this.drugdetails != null)
		{
			String[] listOfOtherErrors = this.drugdetails.validate();
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
	
		IllicitDrugsVo clone = new IllicitDrugsVo(this.id, this.version);
		
		if(this.drugsusedinthepastmonth == null)
			clone.drugsusedinthepastmonth = null;
		else
			clone.drugsusedinthepastmonth = (ims.core.vo.lookups.YesNoUnknown)this.drugsusedinthepastmonth.clone();
		if(this.drugsusedintravenously == null)
			clone.drugsusedintravenously = null;
		else
			clone.drugsusedintravenously = (ims.core.vo.lookups.YesNoUnknown)this.drugsusedintravenously.clone();
		if(this.useanyotherdrugs == null)
			clone.useanyotherdrugs = null;
		else
			clone.useanyotherdrugs = (ims.core.vo.lookups.YesNoUnknown)this.useanyotherdrugs.clone();
		clone.otherdrugdetails = this.otherdrugdetails;
		if(this.drugdetails == null)
			clone.drugdetails = null;
		else
			clone.drugdetails = (ims.core.vo.IllicitDrugsDetailsVoCollection)this.drugdetails.clone();
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
		if (!(IllicitDrugsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A IllicitDrugsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		IllicitDrugsVo compareObj = (IllicitDrugsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_IllicitDrugs() == null && compareObj.getID_IllicitDrugs() != null)
				return -1;
			if(this.getID_IllicitDrugs() != null && compareObj.getID_IllicitDrugs() == null)
				return 1;
			if(this.getID_IllicitDrugs() != null && compareObj.getID_IllicitDrugs() != null)
				retVal = this.getID_IllicitDrugs().compareTo(compareObj.getID_IllicitDrugs());
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
		if(this.drugsusedinthepastmonth != null)
			count++;
		if(this.drugsusedintravenously != null)
			count++;
		if(this.useanyotherdrugs != null)
			count++;
		if(this.otherdrugdetails != null)
			count++;
		if(this.drugdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.lookups.YesNoUnknown drugsusedinthepastmonth;
	protected ims.core.vo.lookups.YesNoUnknown drugsusedintravenously;
	protected ims.core.vo.lookups.YesNoUnknown useanyotherdrugs;
	protected String otherdrugdetails;
	protected ims.core.vo.IllicitDrugsDetailsVoCollection drugdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
