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
 * Linked to clinical.ClinicalReferrals business object (ID: 1072100112).
 */
public class ClinicalReferralForRejectionVo extends ims.clinical.vo.ClinicalReferralsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalReferralForRejectionVo()
	{
	}
	public ClinicalReferralForRejectionVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalReferralForRejectionVo(ims.clinical.vo.beans.ClinicalReferralForRejectionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentreferralstatus = bean.getCurrentReferralStatus() == null ? null : bean.getCurrentReferralStatus().buildVo();
		this.historyofreferralstatus = ims.clinical.vo.ClinicalReferralStatusVoCollection.buildFromBeanCollection(bean.getHistoryOfReferralStatus());
		this.acknowledgerejection = bean.getAcknowledgeRejection();
		this.clinicalreferralnotes = ims.clinical.vo.ClinicalReferralNotesVoCollection.buildFromBeanCollection(bean.getClinicalReferralNotes());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalReferralForRejectionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.currentreferralstatus = bean.getCurrentReferralStatus() == null ? null : bean.getCurrentReferralStatus().buildVo(map);
		this.historyofreferralstatus = ims.clinical.vo.ClinicalReferralStatusVoCollection.buildFromBeanCollection(bean.getHistoryOfReferralStatus());
		this.acknowledgerejection = bean.getAcknowledgeRejection();
		this.clinicalreferralnotes = ims.clinical.vo.ClinicalReferralNotesVoCollection.buildFromBeanCollection(bean.getClinicalReferralNotes());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalReferralForRejectionVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalReferralForRejectionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalReferralForRejectionVoBean();
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
		if(fieldName.equals("CURRENTREFERRALSTATUS"))
			return getCurrentReferralStatus();
		if(fieldName.equals("HISTORYOFREFERRALSTATUS"))
			return getHistoryOfReferralStatus();
		if(fieldName.equals("ACKNOWLEDGEREJECTION"))
			return getAcknowledgeRejection();
		if(fieldName.equals("CLINICALREFERRALNOTES"))
			return getClinicalReferralNotes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCurrentReferralStatusIsNotNull()
	{
		return this.currentreferralstatus != null;
	}
	public ims.clinical.vo.ClinicalReferralStatusVo getCurrentReferralStatus()
	{
		return this.currentreferralstatus;
	}
	public void setCurrentReferralStatus(ims.clinical.vo.ClinicalReferralStatusVo value)
	{
		this.isValidated = false;
		this.currentreferralstatus = value;
	}
	public boolean getHistoryOfReferralStatusIsNotNull()
	{
		return this.historyofreferralstatus != null;
	}
	public ims.clinical.vo.ClinicalReferralStatusVoCollection getHistoryOfReferralStatus()
	{
		return this.historyofreferralstatus;
	}
	public void setHistoryOfReferralStatus(ims.clinical.vo.ClinicalReferralStatusVoCollection value)
	{
		this.isValidated = false;
		this.historyofreferralstatus = value;
	}
	public boolean getAcknowledgeRejectionIsNotNull()
	{
		return this.acknowledgerejection != null;
	}
	public Boolean getAcknowledgeRejection()
	{
		return this.acknowledgerejection;
	}
	public void setAcknowledgeRejection(Boolean value)
	{
		this.isValidated = false;
		this.acknowledgerejection = value;
	}
	public boolean getClinicalReferralNotesIsNotNull()
	{
		return this.clinicalreferralnotes != null;
	}
	public ims.clinical.vo.ClinicalReferralNotesVoCollection getClinicalReferralNotes()
	{
		return this.clinicalreferralnotes;
	}
	public void setClinicalReferralNotes(ims.clinical.vo.ClinicalReferralNotesVoCollection value)
	{
		this.isValidated = false;
		this.clinicalreferralnotes = value;
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
		if(this.currentreferralstatus != null)
		{
			if(!this.currentreferralstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.historyofreferralstatus != null)
		{
			if(!this.historyofreferralstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinicalreferralnotes != null)
		{
			if(!this.clinicalreferralnotes.isValidated())
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
		if(this.currentreferralstatus == null)
			listOfErrors.add("CurrentReferralStatus is mandatory");
		if(this.currentreferralstatus != null)
		{
			String[] listOfOtherErrors = this.currentreferralstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.historyofreferralstatus != null)
		{
			String[] listOfOtherErrors = this.historyofreferralstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalreferralnotes != null)
		{
			String[] listOfOtherErrors = this.clinicalreferralnotes.validate();
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
	
		ClinicalReferralForRejectionVo clone = new ClinicalReferralForRejectionVo(this.id, this.version);
		
		if(this.currentreferralstatus == null)
			clone.currentreferralstatus = null;
		else
			clone.currentreferralstatus = (ims.clinical.vo.ClinicalReferralStatusVo)this.currentreferralstatus.clone();
		if(this.historyofreferralstatus == null)
			clone.historyofreferralstatus = null;
		else
			clone.historyofreferralstatus = (ims.clinical.vo.ClinicalReferralStatusVoCollection)this.historyofreferralstatus.clone();
		clone.acknowledgerejection = this.acknowledgerejection;
		if(this.clinicalreferralnotes == null)
			clone.clinicalreferralnotes = null;
		else
			clone.clinicalreferralnotes = (ims.clinical.vo.ClinicalReferralNotesVoCollection)this.clinicalreferralnotes.clone();
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
		if (!(ClinicalReferralForRejectionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalReferralForRejectionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalReferralForRejectionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalReferralForRejectionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.currentreferralstatus != null)
			count++;
		if(this.historyofreferralstatus != null)
			count++;
		if(this.acknowledgerejection != null)
			count++;
		if(this.clinicalreferralnotes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.clinical.vo.ClinicalReferralStatusVo currentreferralstatus;
	protected ims.clinical.vo.ClinicalReferralStatusVoCollection historyofreferralstatus;
	protected Boolean acknowledgerejection;
	protected ims.clinical.vo.ClinicalReferralNotesVoCollection clinicalreferralnotes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
