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

package ims.emergency.vo;

/**
 * Linked to emergency.HistoryOfPatientMeds business object (ID: 1086100027).
 */
public class HistoryOfPatientMedsVo extends ims.emergency.vo.HistoryOfPatientMedsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public HistoryOfPatientMedsVo()
	{
	}
	public HistoryOfPatientMedsVo(Integer id, int version)
	{
		super(id, version);
	}
	public HistoryOfPatientMedsVo(ims.emergency.vo.beans.HistoryOfPatientMedsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nhsnumber = bean.getNHSNumber();
		this.externalmeddetails = bean.getExternalMedDetails();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.HistoryOfPatientMedsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nhsnumber = bean.getNHSNumber();
		this.externalmeddetails = bean.getExternalMedDetails();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.HistoryOfPatientMedsVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.HistoryOfPatientMedsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.HistoryOfPatientMedsVoBean();
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
		if(fieldName.equals("NHSNUMBER"))
			return getNHSNumber();
		if(fieldName.equals("EXTERNALMEDDETAILS"))
			return getExternalMedDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNHSNumberIsNotNull()
	{
		return this.nhsnumber != null;
	}
	public String getNHSNumber()
	{
		return this.nhsnumber;
	}
	public static int getNHSNumberMaxLength()
	{
		return 10;
	}
	public void setNHSNumber(String value)
	{
		this.isValidated = false;
		this.nhsnumber = value;
	}
	public boolean getExternalMedDetailsIsNotNull()
	{
		return this.externalmeddetails != null;
	}
	public String getExternalMedDetails()
	{
		return this.externalmeddetails;
	}
	public static int getExternalMedDetailsMaxLength()
	{
		return 2000;
	}
	public void setExternalMedDetails(String value)
	{
		this.isValidated = false;
		this.externalmeddetails = value;
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
		if(this.nhsnumber != null)
			if(this.nhsnumber.length() > 10)
				listOfErrors.add("The length of the field [nhsnumber] in the value object [ims.emergency.vo.HistoryOfPatientMedsVo] is too big. It should be less or equal to 10");
		if(this.externalmeddetails != null)
			if(this.externalmeddetails.length() > 2000)
				listOfErrors.add("The length of the field [externalmeddetails] in the value object [ims.emergency.vo.HistoryOfPatientMedsVo] is too big. It should be less or equal to 2000");
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
	
		HistoryOfPatientMedsVo clone = new HistoryOfPatientMedsVo(this.id, this.version);
		
		clone.nhsnumber = this.nhsnumber;
		clone.externalmeddetails = this.externalmeddetails;
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
		if (!(HistoryOfPatientMedsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HistoryOfPatientMedsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((HistoryOfPatientMedsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((HistoryOfPatientMedsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.nhsnumber != null)
			count++;
		if(this.externalmeddetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String nhsnumber;
	protected String externalmeddetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
