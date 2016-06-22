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
 * Linked to core.admin.EpisodeOfCare business object (ID: 1004100018).
 */
public class EpisodeOfCareForCancerReferralVo extends ims.core.admin.vo.EpisodeOfCareRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpisodeOfCareForCancerReferralVo()
	{
	}
	public EpisodeOfCareForCancerReferralVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpisodeOfCareForCancerReferralVo(ims.core.vo.beans.EpisodeOfCareForCancerReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.linkedreferrals = ims.core.vo.PASReferralVoCollection.buildFromBeanCollection(bean.getLinkedReferrals());
		this.currentreferral = bean.getCurrentReferral() == null ? null : new ims.core.admin.vo.ReferralRefVo(new Integer(bean.getCurrentReferral().getId()), bean.getCurrentReferral().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.EpisodeOfCareForCancerReferralVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.linkedreferrals = ims.core.vo.PASReferralVoCollection.buildFromBeanCollection(bean.getLinkedReferrals());
		this.currentreferral = bean.getCurrentReferral() == null ? null : new ims.core.admin.vo.ReferralRefVo(new Integer(bean.getCurrentReferral().getId()), bean.getCurrentReferral().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.EpisodeOfCareForCancerReferralVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.EpisodeOfCareForCancerReferralVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.EpisodeOfCareForCancerReferralVoBean();
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
		if(fieldName.equals("LINKEDREFERRALS"))
			return getLinkedReferrals();
		if(fieldName.equals("CURRENTREFERRAL"))
			return getCurrentReferral();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getLinkedReferralsIsNotNull()
	{
		return this.linkedreferrals != null;
	}
	public ims.core.vo.PASReferralVoCollection getLinkedReferrals()
	{
		return this.linkedreferrals;
	}
	public void setLinkedReferrals(ims.core.vo.PASReferralVoCollection value)
	{
		this.isValidated = false;
		this.linkedreferrals = value;
	}
	public boolean getCurrentReferralIsNotNull()
	{
		return this.currentreferral != null;
	}
	public ims.core.admin.vo.ReferralRefVo getCurrentReferral()
	{
		return this.currentreferral;
	}
	public void setCurrentReferral(ims.core.admin.vo.ReferralRefVo value)
	{
		this.isValidated = false;
		this.currentreferral = value;
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
	
		EpisodeOfCareForCancerReferralVo clone = new EpisodeOfCareForCancerReferralVo(this.id, this.version);
		
		if(this.linkedreferrals == null)
			clone.linkedreferrals = null;
		else
			clone.linkedreferrals = (ims.core.vo.PASReferralVoCollection)this.linkedreferrals.clone();
		clone.currentreferral = this.currentreferral;
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
		if (!(EpisodeOfCareForCancerReferralVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpisodeOfCareForCancerReferralVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EpisodeOfCareForCancerReferralVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EpisodeOfCareForCancerReferralVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.linkedreferrals != null)
			count++;
		if(this.currentreferral != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.PASReferralVoCollection linkedreferrals;
	protected ims.core.admin.vo.ReferralRefVo currentreferral;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
