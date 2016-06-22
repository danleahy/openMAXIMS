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


public class CurrentInpatientListFilterVo extends ims.core.vo.BaseListFilterVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CurrentInpatientListFilterVo()
	{
	}
	public CurrentInpatientListFilterVo(ims.core.vo.beans.CurrentInpatientListFilterVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.hospnum = bean.getHospNum();
		this.ward = bean.getWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getWard().getId()), bean.getWard().getVersion());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.alert = bean.getAlert() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlert());
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
		this.sideward = bean.getSideWard() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getSideWard());
		this.idtype = bean.getIDType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getIDType());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.columnsortorder = bean.getColumnSortOrder() == null ? null : bean.getColumnSortOrder().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CurrentInpatientListFilterVoBean bean)
	{
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.hospnum = bean.getHospNum();
		this.ward = bean.getWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getWard().getId()), bean.getWard().getVersion());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.alert = bean.getAlert() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlert());
		this.hospital = bean.getHospital() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getHospital().getId()), bean.getHospital().getVersion());
		this.sideward = bean.getSideWard() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getSideWard());
		this.idtype = bean.getIDType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getIDType());
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
		this.columnsortorder = bean.getColumnSortOrder() == null ? null : bean.getColumnSortOrder().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CurrentInpatientListFilterVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CurrentInpatientListFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CurrentInpatientListFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getSideWardIsNotNull()
	{
		return this.sideward != null;
	}
	public ims.core.vo.lookups.WardType getSideWard()
	{
		return this.sideward;
	}
	public void setSideWard(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.sideward = value;
	}
	public boolean getIDTypeIsNotNull()
	{
		return this.idtype != null;
	}
	public ims.core.vo.lookups.PatIdType getIDType()
	{
		return this.idtype;
	}
	public void setIDType(ims.core.vo.lookups.PatIdType value)
	{
		this.isValidated = false;
		this.idtype = value;
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
	public boolean getColumnSortOrderIsNotNull()
	{
		return this.columnsortorder != null;
	}
	public ims.core.vo.ColumnSortOrderVo getColumnSortOrder()
	{
		return this.columnsortorder;
	}
	public void setColumnSortOrder(ims.core.vo.ColumnSortOrderVo value)
	{
		this.isValidated = false;
		this.columnsortorder = value;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof CurrentInpatientListFilterVo))
			return false;
		CurrentInpatientListFilterVo compareObj = (CurrentInpatientListFilterVo)obj;
		if(this.getWard() == null && compareObj.getWard() != null)
			return false;
		if(this.getWard() != null && compareObj.getWard() == null)
			return false;
		if(this.getWard() != null && compareObj.getWard() != null)
			return this.getWard().equals(compareObj.getWard());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		CurrentInpatientListFilterVo clone = new CurrentInpatientListFilterVo();
		
		clone.surname = this.surname;
		clone.forename = this.forename;
		clone.hospnum = this.hospnum;
		clone.ward = this.ward;
		clone.consultant = this.consultant;
		if(this.alert == null)
			clone.alert = null;
		else
			clone.alert = (ims.core.vo.lookups.AlertType)this.alert.clone();
		clone.hospital = this.hospital;
		if(this.sideward == null)
			clone.sideward = null;
		else
			clone.sideward = (ims.core.vo.lookups.WardType)this.sideward.clone();
		if(this.idtype == null)
			clone.idtype = null;
		else
			clone.idtype = (ims.core.vo.lookups.PatIdType)this.idtype.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
		if(this.columnsortorder == null)
			clone.columnsortorder = null;
		else
			clone.columnsortorder = (ims.core.vo.ColumnSortOrderVo)this.columnsortorder.clone();
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
		if (!(CurrentInpatientListFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CurrentInpatientListFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CurrentInpatientListFilterVo compareObj = (CurrentInpatientListFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getWard() == null && compareObj.getWard() != null)
				return -1;
			if(this.getWard() != null && compareObj.getWard() == null)
				return 1;
			if(this.getWard() != null && compareObj.getWard() != null)
				retVal = this.getWard().compareTo(compareObj.getWard());
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
		if(this.sideward != null)
			count++;
		if(this.idtype != null)
			count++;
		if(this.specialty != null)
			count++;
		if(this.columnsortorder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 4;
	}
	protected ims.core.vo.lookups.WardType sideward;
	protected ims.core.vo.lookups.PatIdType idtype;
	protected ims.core.vo.lookups.Specialty specialty;
	protected ims.core.vo.ColumnSortOrderVo columnsortorder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
