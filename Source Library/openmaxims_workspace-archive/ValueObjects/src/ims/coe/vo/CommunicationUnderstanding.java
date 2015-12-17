//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.coe.vo;

/**
 * Linked to coe.assessment.Communication SpeechAndLanguage Understanding business object (ID: 1012100015).
 */
public class CommunicationUnderstanding extends ims.coe.assessment.vo.CommunicationSpeechAndLanguageUnderstandingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CommunicationUnderstanding()
	{
	}
	public CommunicationUnderstanding(Integer id, int version)
	{
		super(id, version);
	}
	public CommunicationUnderstanding(ims.coe.vo.beans.CommunicationUnderstandingBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.speechandlanguageunderstanding = bean.getSpeechAndLanguageUnderstanding() == null ? null : ims.coe.vo.lookups.SpeechAndLanguageUnderstanding.buildLookup(bean.getSpeechAndLanguageUnderstanding());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.CommunicationUnderstandingBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.speechandlanguageunderstanding = bean.getSpeechAndLanguageUnderstanding() == null ? null : ims.coe.vo.lookups.SpeechAndLanguageUnderstanding.buildLookup(bean.getSpeechAndLanguageUnderstanding());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.CommunicationUnderstandingBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.CommunicationUnderstandingBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.CommunicationUnderstandingBean();
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
		if(fieldName.equals("SPEECHANDLANGUAGEUNDERSTANDING"))
			return getSpeechAndLanguageUnderstanding();
		if(fieldName.equals("STATUS"))
			return getStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpeechAndLanguageUnderstandingIsNotNull()
	{
		return this.speechandlanguageunderstanding != null;
	}
	public ims.coe.vo.lookups.SpeechAndLanguageUnderstanding getSpeechAndLanguageUnderstanding()
	{
		return this.speechandlanguageunderstanding;
	}
	public void setSpeechAndLanguageUnderstanding(ims.coe.vo.lookups.SpeechAndLanguageUnderstanding value)
	{
		this.isValidated = false;
		this.speechandlanguageunderstanding = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.status = value;
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
	
		CommunicationUnderstanding clone = new CommunicationUnderstanding(this.id, this.version);
		
		if(this.speechandlanguageunderstanding == null)
			clone.speechandlanguageunderstanding = null;
		else
			clone.speechandlanguageunderstanding = (ims.coe.vo.lookups.SpeechAndLanguageUnderstanding)this.speechandlanguageunderstanding.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.YesNoUnknown)this.status.clone();
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
		if (!(CommunicationUnderstanding.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CommunicationUnderstanding object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CommunicationUnderstanding compareObj = (CommunicationUnderstanding)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_CommunicationSpeechAndLanguageUnderstanding() == null && compareObj.getID_CommunicationSpeechAndLanguageUnderstanding() != null)
				return -1;
			if(this.getID_CommunicationSpeechAndLanguageUnderstanding() != null && compareObj.getID_CommunicationSpeechAndLanguageUnderstanding() == null)
				return 1;
			if(this.getID_CommunicationSpeechAndLanguageUnderstanding() != null && compareObj.getID_CommunicationSpeechAndLanguageUnderstanding() != null)
				retVal = this.getID_CommunicationSpeechAndLanguageUnderstanding().compareTo(compareObj.getID_CommunicationSpeechAndLanguageUnderstanding());
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
		if(this.speechandlanguageunderstanding != null)
			count++;
		if(this.status != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.coe.vo.lookups.SpeechAndLanguageUnderstanding speechandlanguageunderstanding;
	protected ims.core.vo.lookups.YesNoUnknown status;
	private boolean isValidated = false;
	private boolean isBusy = false;
}