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

package ims.RefMan.vo;

/**
 * Linked to core.clinical.ReferralLetterDetails business object (ID: 1003100093).
 */
public class ReferralLetterServiceVo extends ims.core.clinical.vo.ReferralLetterDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralLetterServiceVo()
	{
	}
	public ReferralLetterServiceVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralLetterServiceVo(ims.RefMan.vo.beans.ReferralLetterServiceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.referrertype = bean.getReferrerType() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getReferrerType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReferralLetterServiceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.referrertype = bean.getReferrerType() == null ? null : ims.core.vo.lookups.SourceOfReferral.buildLookup(bean.getReferrerType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReferralLetterServiceVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReferralLetterServiceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReferralLetterServiceVoBean();
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
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("REFERRERTYPE"))
			return getReferrerType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getReferrerTypeIsNotNull()
	{
		return this.referrertype != null;
	}
	public ims.core.vo.lookups.SourceOfReferral getReferrerType()
	{
		return this.referrertype;
	}
	public void setReferrerType(ims.core.vo.lookups.SourceOfReferral value)
	{
		this.isValidated = false;
		this.referrertype = value;
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
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
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
	
		ReferralLetterServiceVo clone = new ReferralLetterServiceVo(this.id, this.version);
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		if(this.referrertype == null)
			clone.referrertype = null;
		else
			clone.referrertype = (ims.core.vo.lookups.SourceOfReferral)this.referrertype.clone();
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
		if (!(ReferralLetterServiceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralLetterServiceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralLetterServiceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralLetterServiceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.service != null)
			count++;
		if(this.referrertype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.vo.lookups.SourceOfReferral referrertype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
