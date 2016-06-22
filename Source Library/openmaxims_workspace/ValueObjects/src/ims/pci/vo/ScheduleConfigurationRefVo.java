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

package ims.pci.vo;

/**
 * Linked to PCI.ScheduleConfiguration business object (ID: 1091100002).
 */
public class ScheduleConfigurationRefVo extends ims.vo.ValueObjectRef implements ims.domain.IDomainGetter
{
	private static final long serialVersionUID = 1L;

	public ScheduleConfigurationRefVo()
	{
	}
	public ScheduleConfigurationRefVo(Integer id, int version)
	{
		super(id, version);
	}
	public final boolean getID_ScheduleConfigurationIsNotNull()
	{
		return this.id != null;
	}
	public final Integer getID_ScheduleConfiguration()
	{
		return this.id;
	}
	public final void setID_ScheduleConfiguration(Integer value)
	{
		this.id = value;
	}
	public final int getVersion_ScheduleConfiguration()
	{
		return this.version;
	}
	public Object clone()
	{
		return new ScheduleConfigurationRefVo(this.id, this.version);
	}
	public final ScheduleConfigurationRefVo toScheduleConfigurationRefVo()
	{
		if(this.id == null)
			return this;
		return new ScheduleConfigurationRefVo(this.id, this.version);
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof ScheduleConfigurationRefVo))
			return false;
		ScheduleConfigurationRefVo compareObj = (ScheduleConfigurationRefVo)obj;
		if(this.id != null && compareObj.getBoId() != null)
			return this.id.equals(compareObj.getBoId());
		if(this.id != null && compareObj.getBoId() == null)
			return false;
		if(this.id == null && compareObj.getBoId() != null)
			return false;
		return super.equals(obj);
	}
	public int hashCode()
	{
		if(this.id != null)
			return this.id.intValue();
		return super.hashCode();
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public String getBoClassName()
	{
		return "ims.pci.domain.objects.ScheduleConfiguration";
	}
	public Class getDomainClass()
	{
		return ims.pci.domain.objects.ScheduleConfiguration.class;
	}
	public String getIItemText()
	{
		return toString();
	}
	public String toString()
	{
		return this.getClass().toString() + " (ID: " + (this.id == null ? "null" : this.id.toString()) + ")";
	}
	public int compareTo(Object obj)
	{
		if (obj == null)
			return -1;
		if (!(obj instanceof ScheduleConfigurationRefVo))
			throw new ClassCastException("A ScheduleConfigurationRefVo object cannot be compared an Object of type " + obj.getClass().getName());
		if (this.id == null)
			return 1;
		if (((ScheduleConfigurationRefVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ScheduleConfigurationRefVo)obj).getBoId());
	}
	// this method is not needed. It is here for compatibility purpose only.
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if(caseInsensitive); // this is to avoid Eclipse warning
		return compareTo(obj);
	}

	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ID_SCHEDULECONFIGURATION"))
			return getID_ScheduleConfiguration();
		return super.getFieldValueByFieldName(fieldName);
	}
}
