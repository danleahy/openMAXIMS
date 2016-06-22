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
 * Linked to clinical.SurgicalAuditSurgicalPack business object (ID: 1072100105).
 */
public class SurgicalAuditSurgicalPackVo extends ims.clinical.vo.SurgicalAuditSurgicalPackRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SurgicalAuditSurgicalPackVo()
	{
	}
	public SurgicalAuditSurgicalPackVo(Integer id, int version)
	{
		super(id, version);
	}
	public SurgicalAuditSurgicalPackVo(ims.clinical.vo.beans.SurgicalAuditSurgicalPackVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surgicalpack = bean.getSurgicalPack() == null ? null : ims.clinical.vo.lookups.SurgicalPack.buildLookup(bean.getSurgicalPack());
		this.barcodenumber = bean.getBarcodeNumber();
		this.comment = bean.getComment();
		this.issaved = bean.getIsSaved();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SurgicalAuditSurgicalPackVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.surgicalpack = bean.getSurgicalPack() == null ? null : ims.clinical.vo.lookups.SurgicalPack.buildLookup(bean.getSurgicalPack());
		this.barcodenumber = bean.getBarcodeNumber();
		this.comment = bean.getComment();
		this.issaved = bean.getIsSaved();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SurgicalAuditSurgicalPackVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SurgicalAuditSurgicalPackVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SurgicalAuditSurgicalPackVoBean();
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
		if(fieldName.equals("SURGICALPACK"))
			return getSurgicalPack();
		if(fieldName.equals("BARCODENUMBER"))
			return getBarcodeNumber();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("ISSAVED"))
			return getIsSaved();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSurgicalPackIsNotNull()
	{
		return this.surgicalpack != null;
	}
	public ims.clinical.vo.lookups.SurgicalPack getSurgicalPack()
	{
		return this.surgicalpack;
	}
	public void setSurgicalPack(ims.clinical.vo.lookups.SurgicalPack value)
	{
		this.isValidated = false;
		this.surgicalpack = value;
	}
	public boolean getBarcodeNumberIsNotNull()
	{
		return this.barcodenumber != null;
	}
	public String getBarcodeNumber()
	{
		return this.barcodenumber;
	}
	public static int getBarcodeNumberMaxLength()
	{
		return 20;
	}
	public void setBarcodeNumber(String value)
	{
		this.isValidated = false;
		this.barcodenumber = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 50;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getIsSavedIsNotNull()
	{
		return this.issaved != null;
	}
	public Boolean getIsSaved()
	{
		return this.issaved;
	}
	public void setIsSaved(Boolean value)
	{
		this.isValidated = false;
		this.issaved = value;
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
		if(this.surgicalpack == null)
			listOfErrors.add("SurgicalPack is mandatory");
		if(this.barcodenumber == null || this.barcodenumber.length() == 0)
			listOfErrors.add("BarcodeNumber is mandatory");
		else if(this.barcodenumber.length() > 20)
			listOfErrors.add("The length of the field [barcodenumber] in the value object [ims.clinical.vo.SurgicalAuditSurgicalPackVo] is too big. It should be less or equal to 20");
		if(this.comment != null)
			if(this.comment.length() > 50)
				listOfErrors.add("The length of the field [comment] in the value object [ims.clinical.vo.SurgicalAuditSurgicalPackVo] is too big. It should be less or equal to 50");
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
	
		SurgicalAuditSurgicalPackVo clone = new SurgicalAuditSurgicalPackVo(this.id, this.version);
		
		if(this.surgicalpack == null)
			clone.surgicalpack = null;
		else
			clone.surgicalpack = (ims.clinical.vo.lookups.SurgicalPack)this.surgicalpack.clone();
		clone.barcodenumber = this.barcodenumber;
		clone.comment = this.comment;
		clone.issaved = this.issaved;
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
		if (!(SurgicalAuditSurgicalPackVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SurgicalAuditSurgicalPackVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((SurgicalAuditSurgicalPackVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((SurgicalAuditSurgicalPackVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.surgicalpack != null)
			count++;
		if(this.barcodenumber != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.issaved != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.clinical.vo.lookups.SurgicalPack surgicalpack;
	protected String barcodenumber;
	protected String comment;
	protected Boolean issaved;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
