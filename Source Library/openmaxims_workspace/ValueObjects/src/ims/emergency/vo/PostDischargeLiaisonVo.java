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
 * Linked to emergency.PostDischargeLiaison business object (ID: 1086100052).
 */
public class PostDischargeLiaisonVo extends ims.emergency.vo.PostDischargeLiaisonRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PostDischargeLiaisonVo()
	{
	}
	public PostDischargeLiaisonVo(Integer id, int version)
	{
		super(id, version);
	}
	public PostDischargeLiaisonVo(ims.emergency.vo.beans.PostDischargeLiaisonVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.contactedby = bean.getContactedBy() == null ? null : bean.getContactedBy().buildVo();
		this.personcontacted = bean.getPersonContacted() == null ? null : ims.emergency.vo.lookups.PersonContacted.buildLookup(bean.getPersonContacted());
		this.personcontactedtext = bean.getPersonContactedText();
		this.reasonforcontact = bean.getReasonForContact() == null ? null : ims.emergency.vo.lookups.ReasonForContact.buildLookup(bean.getReasonForContact());
		this.contactmethod = bean.getContactMethod() == null ? null : ims.core.vo.lookups.ContactMethod.buildLookup(bean.getContactMethod());
		this.comments = bean.getComments();
		this.letterreviewstatus = bean.getLetterReviewStatus() == null ? null : ims.emergency.vo.lookups.LetterReviewStatus.buildLookup(bean.getLetterReviewStatus());
		this.allocatetohcp = bean.getAllocateToHCP() == null ? null : bean.getAllocateToHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.PostDischargeLiaisonVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.contactedby = bean.getContactedBy() == null ? null : bean.getContactedBy().buildVo(map);
		this.personcontacted = bean.getPersonContacted() == null ? null : ims.emergency.vo.lookups.PersonContacted.buildLookup(bean.getPersonContacted());
		this.personcontactedtext = bean.getPersonContactedText();
		this.reasonforcontact = bean.getReasonForContact() == null ? null : ims.emergency.vo.lookups.ReasonForContact.buildLookup(bean.getReasonForContact());
		this.contactmethod = bean.getContactMethod() == null ? null : ims.core.vo.lookups.ContactMethod.buildLookup(bean.getContactMethod());
		this.comments = bean.getComments();
		this.letterreviewstatus = bean.getLetterReviewStatus() == null ? null : ims.emergency.vo.lookups.LetterReviewStatus.buildLookup(bean.getLetterReviewStatus());
		this.allocatetohcp = bean.getAllocateToHCP() == null ? null : bean.getAllocateToHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.PostDischargeLiaisonVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.PostDischargeLiaisonVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.PostDischargeLiaisonVoBean();
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
		if(fieldName.equals("CONTACTEDBY"))
			return getContactedBy();
		if(fieldName.equals("PERSONCONTACTED"))
			return getPersonContacted();
		if(fieldName.equals("PERSONCONTACTEDTEXT"))
			return getPersonContactedText();
		if(fieldName.equals("REASONFORCONTACT"))
			return getReasonForContact();
		if(fieldName.equals("CONTACTMETHOD"))
			return getContactMethod();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("LETTERREVIEWSTATUS"))
			return getLetterReviewStatus();
		if(fieldName.equals("ALLOCATETOHCP"))
			return getAllocateToHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getContactedByIsNotNull()
	{
		return this.contactedby != null;
	}
	public ims.core.vo.AuthoringInformationVo getContactedBy()
	{
		return this.contactedby;
	}
	public void setContactedBy(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.contactedby = value;
	}
	public boolean getPersonContactedIsNotNull()
	{
		return this.personcontacted != null;
	}
	public ims.emergency.vo.lookups.PersonContacted getPersonContacted()
	{
		return this.personcontacted;
	}
	public void setPersonContacted(ims.emergency.vo.lookups.PersonContacted value)
	{
		this.isValidated = false;
		this.personcontacted = value;
	}
	public boolean getPersonContactedTextIsNotNull()
	{
		return this.personcontactedtext != null;
	}
	public String getPersonContactedText()
	{
		return this.personcontactedtext;
	}
	public static int getPersonContactedTextMaxLength()
	{
		return 100;
	}
	public void setPersonContactedText(String value)
	{
		this.isValidated = false;
		this.personcontactedtext = value;
	}
	public boolean getReasonForContactIsNotNull()
	{
		return this.reasonforcontact != null;
	}
	public ims.emergency.vo.lookups.ReasonForContact getReasonForContact()
	{
		return this.reasonforcontact;
	}
	public void setReasonForContact(ims.emergency.vo.lookups.ReasonForContact value)
	{
		this.isValidated = false;
		this.reasonforcontact = value;
	}
	public boolean getContactMethodIsNotNull()
	{
		return this.contactmethod != null;
	}
	public ims.core.vo.lookups.ContactMethod getContactMethod()
	{
		return this.contactmethod;
	}
	public void setContactMethod(ims.core.vo.lookups.ContactMethod value)
	{
		this.isValidated = false;
		this.contactmethod = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 5000;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getLetterReviewStatusIsNotNull()
	{
		return this.letterreviewstatus != null;
	}
	public ims.emergency.vo.lookups.LetterReviewStatus getLetterReviewStatus()
	{
		return this.letterreviewstatus;
	}
	public void setLetterReviewStatus(ims.emergency.vo.lookups.LetterReviewStatus value)
	{
		this.isValidated = false;
		this.letterreviewstatus = value;
	}
	public boolean getAllocateToHCPIsNotNull()
	{
		return this.allocatetohcp != null;
	}
	public ims.core.vo.HcpLiteVo getAllocateToHCP()
	{
		return this.allocatetohcp;
	}
	public void setAllocateToHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.allocatetohcp = value;
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
		if(this.contactedby != null)
		{
			if(!this.contactedby.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.allocatetohcp != null)
		{
			if(!this.allocatetohcp.isValidated())
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
		if(this.contactedby == null)
			listOfErrors.add("Contact By and Contact Date/Time are mandatory");
		if(this.contactedby != null)
		{
			String[] listOfOtherErrors = this.contactedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.personcontacted == null)
			listOfErrors.add("Person Contacted is mandatory");
		if(this.personcontactedtext != null)
			if(this.personcontactedtext.length() > 100)
				listOfErrors.add("The length of the field [personcontactedtext] in the value object [ims.emergency.vo.PostDischargeLiaisonVo] is too big. It should be less or equal to 100");
		if(this.reasonforcontact == null)
			listOfErrors.add("Reason for Contact is mandatory");
		if(this.contactmethod == null)
			listOfErrors.add("Contact Method is mandatory");
		if(this.allocatetohcp != null)
		{
			String[] listOfOtherErrors = this.allocatetohcp.validate();
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
	
		PostDischargeLiaisonVo clone = new PostDischargeLiaisonVo(this.id, this.version);
		
		if(this.contactedby == null)
			clone.contactedby = null;
		else
			clone.contactedby = (ims.core.vo.AuthoringInformationVo)this.contactedby.clone();
		if(this.personcontacted == null)
			clone.personcontacted = null;
		else
			clone.personcontacted = (ims.emergency.vo.lookups.PersonContacted)this.personcontacted.clone();
		clone.personcontactedtext = this.personcontactedtext;
		if(this.reasonforcontact == null)
			clone.reasonforcontact = null;
		else
			clone.reasonforcontact = (ims.emergency.vo.lookups.ReasonForContact)this.reasonforcontact.clone();
		if(this.contactmethod == null)
			clone.contactmethod = null;
		else
			clone.contactmethod = (ims.core.vo.lookups.ContactMethod)this.contactmethod.clone();
		clone.comments = this.comments;
		if(this.letterreviewstatus == null)
			clone.letterreviewstatus = null;
		else
			clone.letterreviewstatus = (ims.emergency.vo.lookups.LetterReviewStatus)this.letterreviewstatus.clone();
		if(this.allocatetohcp == null)
			clone.allocatetohcp = null;
		else
			clone.allocatetohcp = (ims.core.vo.HcpLiteVo)this.allocatetohcp.clone();
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
		if (!(PostDischargeLiaisonVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PostDischargeLiaisonVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PostDischargeLiaisonVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PostDischargeLiaisonVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.contactedby != null)
			count++;
		if(this.personcontacted != null)
			count++;
		if(this.personcontactedtext != null)
			count++;
		if(this.reasonforcontact != null)
			count++;
		if(this.contactmethod != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.letterreviewstatus != null)
			count++;
		if(this.allocatetohcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.AuthoringInformationVo contactedby;
	protected ims.emergency.vo.lookups.PersonContacted personcontacted;
	protected String personcontactedtext;
	protected ims.emergency.vo.lookups.ReasonForContact reasonforcontact;
	protected ims.core.vo.lookups.ContactMethod contactmethod;
	protected String comments;
	protected ims.emergency.vo.lookups.LetterReviewStatus letterreviewstatus;
	protected ims.core.vo.HcpLiteVo allocatetohcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
