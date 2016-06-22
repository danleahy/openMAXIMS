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

package ims.clinical.vo;

/**
 * Linked to core.clinical.DiathermyPlateDetail business object (ID: 1072100083).
 */
public class DiathermyPlateDetailVo extends ims.core.clinical.vo.DiathermyPlateDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DiathermyPlateDetailVo()
	{
	}
	public DiathermyPlateDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public DiathermyPlateDetailVo(ims.clinical.vo.beans.DiathermyPlateDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diathermytype = bean.getDiathermyType() == null ? null : ims.clinical.vo.lookups.DiathermyType.buildLookup(bean.getDiathermyType());
		this.skinshaved = bean.getSkinShaved() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinShaved());
		this.skinintact = bean.getSkinintact() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinintact());
		this.plateposition = bean.getPlatePosition();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.DiathermyPlateDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diathermytype = bean.getDiathermyType() == null ? null : ims.clinical.vo.lookups.DiathermyType.buildLookup(bean.getDiathermyType());
		this.skinshaved = bean.getSkinShaved() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinShaved());
		this.skinintact = bean.getSkinintact() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getSkinintact());
		this.plateposition = bean.getPlatePosition();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.DiathermyPlateDetailVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.DiathermyPlateDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.DiathermyPlateDetailVoBean();
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
		if(fieldName.equals("DIATHERMYTYPE"))
			return getDiathermyType();
		if(fieldName.equals("SKINSHAVED"))
			return getSkinShaved();
		if(fieldName.equals("SKININTACT"))
			return getSkinintact();
		if(fieldName.equals("PLATEPOSITION"))
			return getPlatePosition();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDiathermyTypeIsNotNull()
	{
		return this.diathermytype != null;
	}
	public ims.clinical.vo.lookups.DiathermyType getDiathermyType()
	{
		return this.diathermytype;
	}
	public void setDiathermyType(ims.clinical.vo.lookups.DiathermyType value)
	{
		this.isValidated = false;
		this.diathermytype = value;
	}
	public boolean getSkinShavedIsNotNull()
	{
		return this.skinshaved != null;
	}
	public ims.core.vo.lookups.YesNo getSkinShaved()
	{
		return this.skinshaved;
	}
	public void setSkinShaved(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.skinshaved = value;
	}
	public boolean getSkinintactIsNotNull()
	{
		return this.skinintact != null;
	}
	public ims.core.vo.lookups.YesNo getSkinintact()
	{
		return this.skinintact;
	}
	public void setSkinintact(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.skinintact = value;
	}
	public boolean getPlatePositionIsNotNull()
	{
		return this.plateposition != null;
	}
	public String getPlatePosition()
	{
		return this.plateposition;
	}
	public static int getPlatePositionMaxLength()
	{
		return 100;
	}
	public void setPlatePosition(String value)
	{
		this.isValidated = false;
		this.plateposition = value;
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
		if(this.plateposition != null)
			if(this.plateposition.length() > 100)
				listOfErrors.add("The length of the field [plateposition] in the value object [ims.clinical.vo.DiathermyPlateDetailVo] is too big. It should be less or equal to 100");
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
	
		DiathermyPlateDetailVo clone = new DiathermyPlateDetailVo(this.id, this.version);
		
		if(this.diathermytype == null)
			clone.diathermytype = null;
		else
			clone.diathermytype = (ims.clinical.vo.lookups.DiathermyType)this.diathermytype.clone();
		if(this.skinshaved == null)
			clone.skinshaved = null;
		else
			clone.skinshaved = (ims.core.vo.lookups.YesNo)this.skinshaved.clone();
		if(this.skinintact == null)
			clone.skinintact = null;
		else
			clone.skinintact = (ims.core.vo.lookups.YesNo)this.skinintact.clone();
		clone.plateposition = this.plateposition;
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
		if (!(DiathermyPlateDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DiathermyPlateDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DiathermyPlateDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DiathermyPlateDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.diathermytype != null)
			count++;
		if(this.skinshaved != null)
			count++;
		if(this.skinintact != null)
			count++;
		if(this.plateposition != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.clinical.vo.lookups.DiathermyType diathermytype;
	protected ims.core.vo.lookups.YesNo skinshaved;
	protected ims.core.vo.lookups.YesNo skinintact;
	protected String plateposition;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
