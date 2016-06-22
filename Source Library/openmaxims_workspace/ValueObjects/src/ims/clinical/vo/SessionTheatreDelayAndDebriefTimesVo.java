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
 * Linked to Scheduling.Sch_Session business object (ID: 1055100010).
 */
public class SessionTheatreDelayAndDebriefTimesVo extends ims.scheduling.vo.Sch_SessionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SessionTheatreDelayAndDebriefTimesVo()
	{
	}
	public SessionTheatreDelayAndDebriefTimesVo(Integer id, int version)
	{
		super(id, version);
	}
	public SessionTheatreDelayAndDebriefTimesVo(ims.clinical.vo.beans.SessionTheatreDelayAndDebriefTimesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.safetybriefdelayreasondetails = bean.getSafetyBriefDelayReasonDetails();
		this.debriefdatetimes = ims.clinical.vo.SessionDebriefDetailVoCollection.buildFromBeanCollection(bean.getDebriefDateTimes());
		this.safetybriefdelaymins = bean.getSafetyBriefDelayMins();
		this.safetybriefdelayreason = bean.getSafetyBriefDelayReason() == null ? null : ims.scheduling.vo.lookups.SafetyBriefDelayReason.buildLookup(bean.getSafetyBriefDelayReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SessionTheatreDelayAndDebriefTimesVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.safetybriefdelayreasondetails = bean.getSafetyBriefDelayReasonDetails();
		this.debriefdatetimes = ims.clinical.vo.SessionDebriefDetailVoCollection.buildFromBeanCollection(bean.getDebriefDateTimes());
		this.safetybriefdelaymins = bean.getSafetyBriefDelayMins();
		this.safetybriefdelayreason = bean.getSafetyBriefDelayReason() == null ? null : ims.scheduling.vo.lookups.SafetyBriefDelayReason.buildLookup(bean.getSafetyBriefDelayReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SessionTheatreDelayAndDebriefTimesVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SessionTheatreDelayAndDebriefTimesVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SessionTheatreDelayAndDebriefTimesVoBean();
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
		if(fieldName.equals("SAFETYBRIEFDELAYREASONDETAILS"))
			return getSafetyBriefDelayReasonDetails();
		if(fieldName.equals("DEBRIEFDATETIMES"))
			return getDebriefDateTimes();
		if(fieldName.equals("SAFETYBRIEFDELAYMINS"))
			return getSafetyBriefDelayMins();
		if(fieldName.equals("SAFETYBRIEFDELAYREASON"))
			return getSafetyBriefDelayReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSafetyBriefDelayReasonDetailsIsNotNull()
	{
		return this.safetybriefdelayreasondetails != null;
	}
	public String getSafetyBriefDelayReasonDetails()
	{
		return this.safetybriefdelayreasondetails;
	}
	public static int getSafetyBriefDelayReasonDetailsMaxLength()
	{
		return 2000;
	}
	public void setSafetyBriefDelayReasonDetails(String value)
	{
		this.isValidated = false;
		this.safetybriefdelayreasondetails = value;
	}
	public boolean getDebriefDateTimesIsNotNull()
	{
		return this.debriefdatetimes != null;
	}
	public ims.clinical.vo.SessionDebriefDetailVoCollection getDebriefDateTimes()
	{
		return this.debriefdatetimes;
	}
	public void setDebriefDateTimes(ims.clinical.vo.SessionDebriefDetailVoCollection value)
	{
		this.isValidated = false;
		this.debriefdatetimes = value;
	}
	public boolean getSafetyBriefDelayMinsIsNotNull()
	{
		return this.safetybriefdelaymins != null;
	}
	public Integer getSafetyBriefDelayMins()
	{
		return this.safetybriefdelaymins;
	}
	public void setSafetyBriefDelayMins(Integer value)
	{
		this.isValidated = false;
		this.safetybriefdelaymins = value;
	}
	public boolean getSafetyBriefDelayReasonIsNotNull()
	{
		return this.safetybriefdelayreason != null;
	}
	public ims.scheduling.vo.lookups.SafetyBriefDelayReason getSafetyBriefDelayReason()
	{
		return this.safetybriefdelayreason;
	}
	public void setSafetyBriefDelayReason(ims.scheduling.vo.lookups.SafetyBriefDelayReason value)
	{
		this.isValidated = false;
		this.safetybriefdelayreason = value;
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
		if(this.debriefdatetimes != null)
		{
			if(!this.debriefdatetimes.isValidated())
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
		if(this.safetybriefdelayreasondetails != null)
			if(this.safetybriefdelayreasondetails.length() > 2000)
				listOfErrors.add("The length of the field [safetybriefdelayreasondetails] in the value object [ims.clinical.vo.SessionTheatreDelayAndDebriefTimesVo] is too big. It should be less or equal to 2000");
		if(this.debriefdatetimes != null)
		{
			String[] listOfOtherErrors = this.debriefdatetimes.validate();
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
	
		SessionTheatreDelayAndDebriefTimesVo clone = new SessionTheatreDelayAndDebriefTimesVo(this.id, this.version);
		
		clone.safetybriefdelayreasondetails = this.safetybriefdelayreasondetails;
		if(this.debriefdatetimes == null)
			clone.debriefdatetimes = null;
		else
			clone.debriefdatetimes = (ims.clinical.vo.SessionDebriefDetailVoCollection)this.debriefdatetimes.clone();
		clone.safetybriefdelaymins = this.safetybriefdelaymins;
		if(this.safetybriefdelayreason == null)
			clone.safetybriefdelayreason = null;
		else
			clone.safetybriefdelayreason = (ims.scheduling.vo.lookups.SafetyBriefDelayReason)this.safetybriefdelayreason.clone();
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
		if (!(SessionTheatreDelayAndDebriefTimesVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SessionTheatreDelayAndDebriefTimesVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SessionTheatreDelayAndDebriefTimesVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SessionTheatreDelayAndDebriefTimesVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.safetybriefdelayreasondetails != null)
			count++;
		if(this.debriefdatetimes != null)
			count++;
		if(this.safetybriefdelaymins != null)
			count++;
		if(this.safetybriefdelayreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String safetybriefdelayreasondetails;
	protected ims.clinical.vo.SessionDebriefDetailVoCollection debriefdatetimes;
	protected Integer safetybriefdelaymins;
	protected ims.scheduling.vo.lookups.SafetyBriefDelayReason safetybriefdelayreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
