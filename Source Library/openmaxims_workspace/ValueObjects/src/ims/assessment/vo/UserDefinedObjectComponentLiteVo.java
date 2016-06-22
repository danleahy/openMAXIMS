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

package ims.assessment.vo;

/**
 * Linked to Assessment.Configuration.UserDefinedObjectComponent business object (ID: 1028100005).
 */
public class UserDefinedObjectComponentLiteVo extends ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public UserDefinedObjectComponentLiteVo()
	{
	}
	public UserDefinedObjectComponentLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public UserDefinedObjectComponentLiteVo(ims.assessment.vo.beans.UserDefinedObjectComponentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userassessments = bean.getUserAssessments() == null ? null : bean.getUserAssessments().buildVo();
		this.graphic = bean.getGraphic() == null ? null : bean.getGraphic().buildVo();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.seqno = bean.getSeqNo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.UserDefinedObjectComponentLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userassessments = bean.getUserAssessments() == null ? null : bean.getUserAssessments().buildVo(map);
		this.graphic = bean.getGraphic() == null ? null : bean.getGraphic().buildVo(map);
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
		this.seqno = bean.getSeqNo();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.UserDefinedObjectComponentLiteVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.UserDefinedObjectComponentLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.UserDefinedObjectComponentLiteVoBean();
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
		if(fieldName.equals("USERASSESSMENTS"))
			return getUserAssessments();
		if(fieldName.equals("GRAPHIC"))
			return getGraphic();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		if(fieldName.equals("SEQNO"))
			return getSeqNo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUserAssessmentsIsNotNull()
	{
		return this.userassessments != null;
	}
	public ims.assessment.vo.UserAssessmentLiteVo getUserAssessments()
	{
		return this.userassessments;
	}
	public void setUserAssessments(ims.assessment.vo.UserAssessmentLiteVo value)
	{
		this.isValidated = false;
		this.userassessments = value;
	}
	public boolean getGraphicIsNotNull()
	{
		return this.graphic != null;
	}
	public ims.assessment.vo.GraphicAssessmentShortVo getGraphic()
	{
		return this.graphic;
	}
	public void setGraphic(ims.assessment.vo.GraphicAssessmentShortVo value)
	{
		this.isValidated = false;
		this.graphic = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
	}
	public boolean getSeqNoIsNotNull()
	{
		return this.seqno != null;
	}
	public Integer getSeqNo()
	{
		return this.seqno;
	}
	public void setSeqNo(Integer value)
	{
		this.isValidated = false;
		this.seqno = value;
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
		if(this.userassessments != null)
		{
			if(!this.userassessments.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.graphic != null)
		{
			if(!this.graphic.isValidated())
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
		if(this.userassessments != null)
		{
			String[] listOfOtherErrors = this.userassessments.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.graphic != null)
		{
			String[] listOfOtherErrors = this.graphic.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
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
	
		UserDefinedObjectComponentLiteVo clone = new UserDefinedObjectComponentLiteVo(this.id, this.version);
		
		if(this.userassessments == null)
			clone.userassessments = null;
		else
			clone.userassessments = (ims.assessment.vo.UserAssessmentLiteVo)this.userassessments.clone();
		if(this.graphic == null)
			clone.graphic = null;
		else
			clone.graphic = (ims.assessment.vo.GraphicAssessmentShortVo)this.graphic.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
		clone.seqno = this.seqno;
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
		if (!(UserDefinedObjectComponentLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A UserDefinedObjectComponentLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		UserDefinedObjectComponentLiteVo compareObj = (UserDefinedObjectComponentLiteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSeqNo() == null && compareObj.getSeqNo() != null)
				return -1;
			if(this.getSeqNo() != null && compareObj.getSeqNo() == null)
				return 1;
			if(this.getSeqNo() != null && compareObj.getSeqNo() != null)
				retVal = this.getSeqNo().compareTo(compareObj.getSeqNo());
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
		if(this.userassessments != null)
			count++;
		if(this.graphic != null)
			count++;
		if(this.activestatus != null)
			count++;
		if(this.seqno != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.assessment.vo.UserAssessmentLiteVo userassessments;
	protected ims.assessment.vo.GraphicAssessmentShortVo graphic;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	protected Integer seqno;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
