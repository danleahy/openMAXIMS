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
 * Linked to clinical.CodingComment business object (ID: 1072100115).
 */
public class CodingCommentVo extends ims.clinical.vo.CodingCommentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CodingCommentVo()
	{
	}
	public CodingCommentVo(Integer id, int version)
	{
		super(id, version);
	}
	public CodingCommentVo(ims.clinical.vo.beans.CodingCommentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringmos = bean.getAuthoringMOS() == null ? null : bean.getAuthoringMOS().buildVo();
		this.commenttext = bean.getCommentText();
		this.structuredcomment = bean.getStructuredComment() == null ? null : ims.clinical.vo.lookups.StructuredCodingComment.buildLookup(bean.getStructuredComment());
		this.commentstatus = bean.getCommentStatus() == null ? null : ims.clinical.vo.lookups.CodingCommentStatus.buildLookup(bean.getCommentStatus());
		this.codingtype = bean.getCodingType() == null ? null : ims.clinical.vo.lookups.CodingCommentType.buildLookup(bean.getCodingType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.CodingCommentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringmos = bean.getAuthoringMOS() == null ? null : bean.getAuthoringMOS().buildVo(map);
		this.commenttext = bean.getCommentText();
		this.structuredcomment = bean.getStructuredComment() == null ? null : ims.clinical.vo.lookups.StructuredCodingComment.buildLookup(bean.getStructuredComment());
		this.commentstatus = bean.getCommentStatus() == null ? null : ims.clinical.vo.lookups.CodingCommentStatus.buildLookup(bean.getCommentStatus());
		this.codingtype = bean.getCodingType() == null ? null : ims.clinical.vo.lookups.CodingCommentType.buildLookup(bean.getCodingType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.CodingCommentVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.CodingCommentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.CodingCommentVoBean();
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
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGMOS"))
			return getAuthoringMOS();
		if(fieldName.equals("COMMENTTEXT"))
			return getCommentText();
		if(fieldName.equals("STRUCTUREDCOMMENT"))
			return getStructuredComment();
		if(fieldName.equals("COMMENTSTATUS"))
			return getCommentStatus();
		if(fieldName.equals("CODINGTYPE"))
			return getCodingType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringMOSIsNotNull()
	{
		return this.authoringmos != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getAuthoringMOS()
	{
		return this.authoringmos;
	}
	public void setAuthoringMOS(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.authoringmos = value;
	}
	public boolean getCommentTextIsNotNull()
	{
		return this.commenttext != null;
	}
	public String getCommentText()
	{
		return this.commenttext;
	}
	public static int getCommentTextMaxLength()
	{
		return 10000;
	}
	public void setCommentText(String value)
	{
		this.isValidated = false;
		this.commenttext = value;
	}
	public boolean getStructuredCommentIsNotNull()
	{
		return this.structuredcomment != null;
	}
	public ims.clinical.vo.lookups.StructuredCodingComment getStructuredComment()
	{
		return this.structuredcomment;
	}
	public void setStructuredComment(ims.clinical.vo.lookups.StructuredCodingComment value)
	{
		this.isValidated = false;
		this.structuredcomment = value;
	}
	public boolean getCommentStatusIsNotNull()
	{
		return this.commentstatus != null;
	}
	public ims.clinical.vo.lookups.CodingCommentStatus getCommentStatus()
	{
		return this.commentstatus;
	}
	public void setCommentStatus(ims.clinical.vo.lookups.CodingCommentStatus value)
	{
		this.isValidated = false;
		this.commentstatus = value;
	}
	public boolean getCodingTypeIsNotNull()
	{
		return this.codingtype != null;
	}
	public ims.clinical.vo.lookups.CodingCommentType getCodingType()
	{
		return this.codingtype;
	}
	public void setCodingType(ims.clinical.vo.lookups.CodingCommentType value)
	{
		this.isValidated = false;
		this.codingtype = value;
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
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date/Time is mandatory");
		if(this.authoringmos == null)
			listOfErrors.add("Authoring User is mandatory");
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
	
		CodingCommentVo clone = new CodingCommentVo(this.id, this.version);
		
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringmos == null)
			clone.authoringmos = null;
		else
			clone.authoringmos = (ims.core.vo.MemberOfStaffLiteVo)this.authoringmos.clone();
		clone.commenttext = this.commenttext;
		if(this.structuredcomment == null)
			clone.structuredcomment = null;
		else
			clone.structuredcomment = (ims.clinical.vo.lookups.StructuredCodingComment)this.structuredcomment.clone();
		if(this.commentstatus == null)
			clone.commentstatus = null;
		else
			clone.commentstatus = (ims.clinical.vo.lookups.CodingCommentStatus)this.commentstatus.clone();
		if(this.codingtype == null)
			clone.codingtype = null;
		else
			clone.codingtype = (ims.clinical.vo.lookups.CodingCommentType)this.codingtype.clone();
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
		if (!(CodingCommentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CodingCommentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CodingCommentVo compareObj = (CodingCommentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAuthoringDateTime() == null && compareObj.getAuthoringDateTime() != null)
				return -1;
			if(this.getAuthoringDateTime() != null && compareObj.getAuthoringDateTime() == null)
				return 1;
			if(this.getAuthoringDateTime() != null && compareObj.getAuthoringDateTime() != null)
				retVal = this.getAuthoringDateTime().compareTo(compareObj.getAuthoringDateTime());
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
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringmos != null)
			count++;
		if(this.commenttext != null)
			count++;
		if(this.structuredcomment != null)
			count++;
		if(this.commentstatus != null)
			count++;
		if(this.codingtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.MemberOfStaffLiteVo authoringmos;
	protected String commenttext;
	protected ims.clinical.vo.lookups.StructuredCodingComment structuredcomment;
	protected ims.clinical.vo.lookups.CodingCommentStatus commentstatus;
	protected ims.clinical.vo.lookups.CodingCommentType codingtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
