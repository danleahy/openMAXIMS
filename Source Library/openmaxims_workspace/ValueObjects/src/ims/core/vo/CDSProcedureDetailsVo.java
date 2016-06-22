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
 * Linked to core.cds.CDSProcedureDetails business object (ID: 1104100004).
 */
public class CDSProcedureDetailsVo extends ims.core.cds.vo.CDSProcedureDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CDSProcedureDetailsVo()
	{
	}
	public CDSProcedureDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public CDSProcedureDetailsVo(ims.core.vo.beans.CDSProcedureDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedurescheme = bean.getProcedureScheme();
		this.procedure = bean.getProcedure();
		this.proceduredate = bean.getProcedureDate() == null ? null : bean.getProcedureDate().buildDate();
		this.laterality = bean.getLaterality();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CDSProcedureDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.procedurescheme = bean.getProcedureScheme();
		this.procedure = bean.getProcedure();
		this.proceduredate = bean.getProcedureDate() == null ? null : bean.getProcedureDate().buildDate();
		this.laterality = bean.getLaterality();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CDSProcedureDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CDSProcedureDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CDSProcedureDetailsVoBean();
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
		if(fieldName.equals("PROCEDURESCHEME"))
			return getProcedureScheme();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("PROCEDUREDATE"))
			return getProcedureDate();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getProcedureSchemeIsNotNull()
	{
		return this.procedurescheme != null;
	}
	public String getProcedureScheme()
	{
		return this.procedurescheme;
	}
	public static int getProcedureSchemeMaxLength()
	{
		return 2;
	}
	public void setProcedureScheme(String value)
	{
		this.isValidated = false;
		this.procedurescheme = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public String getProcedure()
	{
		return this.procedure;
	}
	public static int getProcedureMaxLength()
	{
		return 4;
	}
	public void setProcedure(String value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getProcedureDateIsNotNull()
	{
		return this.proceduredate != null;
	}
	public ims.framework.utils.Date getProcedureDate()
	{
		return this.proceduredate;
	}
	public void setProcedureDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.proceduredate = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public String getLaterality()
	{
		return this.laterality;
	}
	public static int getLateralityMaxLength()
	{
		return 4;
	}
	public void setLaterality(String value)
	{
		this.isValidated = false;
		this.laterality = value;
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
		if(this.procedurescheme != null)
			if(this.procedurescheme.length() > 2)
				listOfErrors.add("The length of the field [procedurescheme] in the value object [ims.core.vo.CDSProcedureDetailsVo] is too big. It should be less or equal to 2");
		if(this.procedure != null)
			if(this.procedure.length() > 4)
				listOfErrors.add("The length of the field [procedure] in the value object [ims.core.vo.CDSProcedureDetailsVo] is too big. It should be less or equal to 4");
		if(this.laterality != null)
			if(this.laterality.length() > 4)
				listOfErrors.add("The length of the field [laterality] in the value object [ims.core.vo.CDSProcedureDetailsVo] is too big. It should be less or equal to 4");
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
	
		CDSProcedureDetailsVo clone = new CDSProcedureDetailsVo(this.id, this.version);
		
		clone.procedurescheme = this.procedurescheme;
		clone.procedure = this.procedure;
		if(this.proceduredate == null)
			clone.proceduredate = null;
		else
			clone.proceduredate = (ims.framework.utils.Date)this.proceduredate.clone();
		clone.laterality = this.laterality;
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
		if (!(CDSProcedureDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CDSProcedureDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CDSProcedureDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CDSProcedureDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.procedurescheme != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.proceduredate != null)
			count++;
		if(this.laterality != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String procedurescheme;
	protected String procedure;
	protected ims.framework.utils.Date proceduredate;
	protected String laterality;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
