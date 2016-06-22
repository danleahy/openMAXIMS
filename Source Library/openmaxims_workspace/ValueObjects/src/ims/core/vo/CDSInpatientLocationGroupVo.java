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
 * Linked to core.cds.CDSInpatientLocationGroup business object (ID: 1104100002).
 */
public class CDSInpatientLocationGroupVo extends ims.core.cds.vo.CDSInpatientLocationGroupRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CDSInpatientLocationGroupVo()
	{
	}
	public CDSInpatientLocationGroupVo(Integer id, int version)
	{
		super(id, version);
	}
	public CDSInpatientLocationGroupVo(ims.core.vo.beans.CDSInpatientLocationGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.locationclass = bean.getLocationClass();
		this.sitecodetreatment = bean.getSiteCodeTreatment();
		this.intendedccintensity = bean.getIntendedCCIntensity();
		this.agegroupintended = bean.getAgeGroupIntended();
		this.sexofpatients = bean.getSexOfPatients();
		this.warddayavail = bean.getWardDayAvail();
		this.wardnightavail = bean.getWardNightAvail();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CDSInpatientLocationGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.locationclass = bean.getLocationClass();
		this.sitecodetreatment = bean.getSiteCodeTreatment();
		this.intendedccintensity = bean.getIntendedCCIntensity();
		this.agegroupintended = bean.getAgeGroupIntended();
		this.sexofpatients = bean.getSexOfPatients();
		this.warddayavail = bean.getWardDayAvail();
		this.wardnightavail = bean.getWardNightAvail();
		this.startdate = bean.getStartDate() == null ? null : bean.getStartDate().buildDate();
		this.enddate = bean.getEndDate() == null ? null : bean.getEndDate().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CDSInpatientLocationGroupVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CDSInpatientLocationGroupVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CDSInpatientLocationGroupVoBean();
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
		if(fieldName.equals("LOCATIONCLASS"))
			return getLocationClass();
		if(fieldName.equals("SITECODETREATMENT"))
			return getSiteCodeTreatment();
		if(fieldName.equals("INTENDEDCCINTENSITY"))
			return getIntendedCCIntensity();
		if(fieldName.equals("AGEGROUPINTENDED"))
			return getAgeGroupIntended();
		if(fieldName.equals("SEXOFPATIENTS"))
			return getSexOfPatients();
		if(fieldName.equals("WARDDAYAVAIL"))
			return getWardDayAvail();
		if(fieldName.equals("WARDNIGHTAVAIL"))
			return getWardNightAvail();
		if(fieldName.equals("STARTDATE"))
			return getStartDate();
		if(fieldName.equals("ENDDATE"))
			return getEndDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLocationClassIsNotNull()
	{
		return this.locationclass != null;
	}
	public String getLocationClass()
	{
		return this.locationclass;
	}
	public static int getLocationClassMaxLength()
	{
		return 2;
	}
	public void setLocationClass(String value)
	{
		this.isValidated = false;
		this.locationclass = value;
	}
	public boolean getSiteCodeTreatmentIsNotNull()
	{
		return this.sitecodetreatment != null;
	}
	public String getSiteCodeTreatment()
	{
		return this.sitecodetreatment;
	}
	public static int getSiteCodeTreatmentMaxLength()
	{
		return 5;
	}
	public void setSiteCodeTreatment(String value)
	{
		this.isValidated = false;
		this.sitecodetreatment = value;
	}
	public boolean getIntendedCCIntensityIsNotNull()
	{
		return this.intendedccintensity != null;
	}
	public String getIntendedCCIntensity()
	{
		return this.intendedccintensity;
	}
	public static int getIntendedCCIntensityMaxLength()
	{
		return 2;
	}
	public void setIntendedCCIntensity(String value)
	{
		this.isValidated = false;
		this.intendedccintensity = value;
	}
	public boolean getAgeGroupIntendedIsNotNull()
	{
		return this.agegroupintended != null;
	}
	public String getAgeGroupIntended()
	{
		return this.agegroupintended;
	}
	public static int getAgeGroupIntendedMaxLength()
	{
		return 1;
	}
	public void setAgeGroupIntended(String value)
	{
		this.isValidated = false;
		this.agegroupintended = value;
	}
	public boolean getSexOfPatientsIsNotNull()
	{
		return this.sexofpatients != null;
	}
	public String getSexOfPatients()
	{
		return this.sexofpatients;
	}
	public static int getSexOfPatientsMaxLength()
	{
		return 1;
	}
	public void setSexOfPatients(String value)
	{
		this.isValidated = false;
		this.sexofpatients = value;
	}
	public boolean getWardDayAvailIsNotNull()
	{
		return this.warddayavail != null;
	}
	public String getWardDayAvail()
	{
		return this.warddayavail;
	}
	public static int getWardDayAvailMaxLength()
	{
		return 1;
	}
	public void setWardDayAvail(String value)
	{
		this.isValidated = false;
		this.warddayavail = value;
	}
	public boolean getWardNightAvailIsNotNull()
	{
		return this.wardnightavail != null;
	}
	public String getWardNightAvail()
	{
		return this.wardnightavail;
	}
	public static int getWardNightAvailMaxLength()
	{
		return 1;
	}
	public void setWardNightAvail(String value)
	{
		this.isValidated = false;
		this.wardnightavail = value;
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
		if(this.locationclass != null)
			if(this.locationclass.length() > 2)
				listOfErrors.add("The length of the field [locationclass] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 2");
		if(this.sitecodetreatment != null)
			if(this.sitecodetreatment.length() > 5)
				listOfErrors.add("The length of the field [sitecodetreatment] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 5");
		if(this.intendedccintensity != null)
			if(this.intendedccintensity.length() > 2)
				listOfErrors.add("The length of the field [intendedccintensity] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 2");
		if(this.agegroupintended != null)
			if(this.agegroupintended.length() > 1)
				listOfErrors.add("The length of the field [agegroupintended] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 1");
		if(this.sexofpatients != null)
			if(this.sexofpatients.length() > 1)
				listOfErrors.add("The length of the field [sexofpatients] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 1");
		if(this.warddayavail != null)
			if(this.warddayavail.length() > 1)
				listOfErrors.add("The length of the field [warddayavail] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 1");
		if(this.wardnightavail != null)
			if(this.wardnightavail.length() > 1)
				listOfErrors.add("The length of the field [wardnightavail] in the value object [ims.core.vo.CDSInpatientLocationGroupVo] is too big. It should be less or equal to 1");
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
	
		CDSInpatientLocationGroupVo clone = new CDSInpatientLocationGroupVo(this.id, this.version);
		
		clone.locationclass = this.locationclass;
		clone.sitecodetreatment = this.sitecodetreatment;
		clone.intendedccintensity = this.intendedccintensity;
		clone.agegroupintended = this.agegroupintended;
		clone.sexofpatients = this.sexofpatients;
		clone.warddayavail = this.warddayavail;
		clone.wardnightavail = this.wardnightavail;
		if(this.startdate == null)
			clone.startdate = null;
		else
			clone.startdate = (ims.framework.utils.Date)this.startdate.clone();
		if(this.enddate == null)
			clone.enddate = null;
		else
			clone.enddate = (ims.framework.utils.Date)this.enddate.clone();
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
		if (!(CDSInpatientLocationGroupVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CDSInpatientLocationGroupVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CDSInpatientLocationGroupVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CDSInpatientLocationGroupVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.locationclass != null)
			count++;
		if(this.sitecodetreatment != null)
			count++;
		if(this.intendedccintensity != null)
			count++;
		if(this.agegroupintended != null)
			count++;
		if(this.sexofpatients != null)
			count++;
		if(this.warddayavail != null)
			count++;
		if(this.wardnightavail != null)
			count++;
		if(this.startdate != null)
			count++;
		if(this.enddate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String locationclass;
	protected String sitecodetreatment;
	protected String intendedccintensity;
	protected String agegroupintended;
	protected String sexofpatients;
	protected String warddayavail;
	protected String wardnightavail;
	protected ims.framework.utils.Date startdate;
	protected ims.framework.utils.Date enddate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
