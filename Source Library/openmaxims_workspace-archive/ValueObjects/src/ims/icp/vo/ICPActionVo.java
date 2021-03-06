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

package ims.icp.vo;

/**
 * Linked to ICPs.Configuration.ICPAction business object (ID: 1060100008).
 */
public class ICPActionVo extends ims.icps.configuration.vo.ICPActionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPActionVo()
	{
	}
	public ICPActionVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPActionVo(ims.icp.vo.beans.ICPActionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.helpurl = bean.getHelpURL();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.discipline = ims.core.vo.lookups.HcpDisTypeCollection.buildFromBeanCollection(bean.getDiscipline());
		this.linkedtype = bean.getLinkedType() == null ? null : ims.core.vo.lookups.ICPCompLinkedType.buildLookup(bean.getLinkedType());
		this.name = bean.getName();
		this.ismandatory = bean.getIsMandatory();
		this.linkedform = bean.getLinkedForm() == null ? null : bean.getLinkedForm().buildVo();
		this.linkedassessment = bean.getLinkedAssessment() == null ? null : bean.getLinkedAssessment().buildVo();
		this.linkedgraphicassessment = bean.getLinkedGraphicAssessment() == null ? null : bean.getLinkedGraphicAssessment().buildVo();
		this.linkedorderentrytemplate = bean.getLinkedOrderEntryTemplate() == null ? null : bean.getLinkedOrderEntryTemplate().buildVo();
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.requirescountersignature = bean.getRequiresCounterSignature();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPActionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.description = bean.getDescription();
		this.sequence = bean.getSequence();
		this.helpurl = bean.getHelpURL();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.discipline = ims.core.vo.lookups.HcpDisTypeCollection.buildFromBeanCollection(bean.getDiscipline());
		this.linkedtype = bean.getLinkedType() == null ? null : ims.core.vo.lookups.ICPCompLinkedType.buildLookup(bean.getLinkedType());
		this.name = bean.getName();
		this.ismandatory = bean.getIsMandatory();
		this.linkedform = bean.getLinkedForm() == null ? null : bean.getLinkedForm().buildVo(map);
		this.linkedassessment = bean.getLinkedAssessment() == null ? null : bean.getLinkedAssessment().buildVo(map);
		this.linkedgraphicassessment = bean.getLinkedGraphicAssessment() == null ? null : bean.getLinkedGraphicAssessment().buildVo(map);
		this.linkedorderentrytemplate = bean.getLinkedOrderEntryTemplate() == null ? null : bean.getLinkedOrderEntryTemplate().buildVo(map);
		this.isactivatedoninitiation = bean.getIsActivatedOnInitiation();
		this.requirescountersignature = bean.getRequiresCounterSignature();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPActionVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPActionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPActionVoBean();
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
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("HELPURL"))
			return getHelpURL();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("DISCIPLINE"))
			return getDiscipline();
		if(fieldName.equals("LINKEDTYPE"))
			return getLinkedType();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("ISMANDATORY"))
			return getIsMandatory();
		if(fieldName.equals("LINKEDFORM"))
			return getLinkedForm();
		if(fieldName.equals("LINKEDASSESSMENT"))
			return getLinkedAssessment();
		if(fieldName.equals("LINKEDGRAPHICASSESSMENT"))
			return getLinkedGraphicAssessment();
		if(fieldName.equals("LINKEDORDERENTRYTEMPLATE"))
			return getLinkedOrderEntryTemplate();
		if(fieldName.equals("ISACTIVATEDONINITIATION"))
			return getIsActivatedOnInitiation();
		if(fieldName.equals("REQUIRESCOUNTERSIGNATURE"))
			return getRequiresCounterSignature();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getHelpURLIsNotNull()
	{
		return this.helpurl != null;
	}
	public String getHelpURL()
	{
		return this.helpurl;
	}
	public static int getHelpURLMaxLength()
	{
		return 255;
	}
	public void setHelpURL(String value)
	{
		this.isValidated = false;
		this.helpurl = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getDisciplineIsNotNull()
	{
		return this.discipline != null;
	}
	public ims.core.vo.lookups.HcpDisTypeCollection getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.lookups.HcpDisTypeCollection value)
	{
		this.isValidated = false;
		this.discipline = value;
	}
	public boolean getLinkedTypeIsNotNull()
	{
		return this.linkedtype != null;
	}
	public ims.core.vo.lookups.ICPCompLinkedType getLinkedType()
	{
		return this.linkedtype;
	}
	public void setLinkedType(ims.core.vo.lookups.ICPCompLinkedType value)
	{
		this.isValidated = false;
		this.linkedtype = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getIsMandatoryIsNotNull()
	{
		return this.ismandatory != null;
	}
	public Boolean getIsMandatory()
	{
		return this.ismandatory;
	}
	public void setIsMandatory(Boolean value)
	{
		this.isValidated = false;
		this.ismandatory = value;
	}
	public boolean getLinkedFormIsNotNull()
	{
		return this.linkedform != null;
	}
	public ims.admin.vo.AppFormVo getLinkedForm()
	{
		return this.linkedform;
	}
	public void setLinkedForm(ims.admin.vo.AppFormVo value)
	{
		this.isValidated = false;
		this.linkedform = value;
	}
	public boolean getLinkedAssessmentIsNotNull()
	{
		return this.linkedassessment != null;
	}
	public ims.assessment.vo.UserAssessmentVo getLinkedAssessment()
	{
		return this.linkedassessment;
	}
	public void setLinkedAssessment(ims.assessment.vo.UserAssessmentVo value)
	{
		this.isValidated = false;
		this.linkedassessment = value;
	}
	public boolean getLinkedGraphicAssessmentIsNotNull()
	{
		return this.linkedgraphicassessment != null;
	}
	public ims.assessment.vo.GraphicAssessmentShortVo getLinkedGraphicAssessment()
	{
		return this.linkedgraphicassessment;
	}
	public void setLinkedGraphicAssessment(ims.assessment.vo.GraphicAssessmentShortVo value)
	{
		this.isValidated = false;
		this.linkedgraphicassessment = value;
	}
	public boolean getLinkedOrderEntryTemplateIsNotNull()
	{
		return this.linkedorderentrytemplate != null;
	}
	public ims.ocrr.vo.OrderEntryTemplateBaseVo getLinkedOrderEntryTemplate()
	{
		return this.linkedorderentrytemplate;
	}
	public void setLinkedOrderEntryTemplate(ims.ocrr.vo.OrderEntryTemplateBaseVo value)
	{
		this.isValidated = false;
		this.linkedorderentrytemplate = value;
	}
	public boolean getIsActivatedOnInitiationIsNotNull()
	{
		return this.isactivatedoninitiation != null;
	}
	public Boolean getIsActivatedOnInitiation()
	{
		return this.isactivatedoninitiation;
	}
	public void setIsActivatedOnInitiation(Boolean value)
	{
		this.isValidated = false;
		this.isactivatedoninitiation = value;
	}
	public boolean getRequiresCounterSignatureIsNotNull()
	{
		return this.requirescountersignature != null;
	}
	public Boolean getRequiresCounterSignature()
	{
		return this.requirescountersignature;
	}
	public void setRequiresCounterSignature(Boolean value)
	{
		this.isValidated = false;
		this.requirescountersignature = value;
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
		if(this.description != null)
			if(this.description.length() > 255)
				listOfErrors.add("The length of the field [description] in the value object [ims.icp.vo.ICPActionVo] is too big. It should be less or equal to 255");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 255)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.icp.vo.ICPActionVo] is too big. It should be less or equal to 255");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.discipline == null || this.discipline.size() == 0)
			listOfErrors.add("At least one discipline must be recorded.");
		if(this.linkedtype == null)
			listOfErrors.add("LinkedType is mandatory");
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 255)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPActionVo] is too big. It should be less or equal to 255");
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
	
		ICPActionVo clone = new ICPActionVo(this.id, this.version);
		
		clone.description = this.description;
		clone.sequence = this.sequence;
		clone.helpurl = this.helpurl;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.lookups.HcpDisTypeCollection)this.discipline.clone();
		if(this.linkedtype == null)
			clone.linkedtype = null;
		else
			clone.linkedtype = (ims.core.vo.lookups.ICPCompLinkedType)this.linkedtype.clone();
		clone.name = this.name;
		clone.ismandatory = this.ismandatory;
		if(this.linkedform == null)
			clone.linkedform = null;
		else
			clone.linkedform = (ims.admin.vo.AppFormVo)this.linkedform.clone();
		if(this.linkedassessment == null)
			clone.linkedassessment = null;
		else
			clone.linkedassessment = (ims.assessment.vo.UserAssessmentVo)this.linkedassessment.clone();
		if(this.linkedgraphicassessment == null)
			clone.linkedgraphicassessment = null;
		else
			clone.linkedgraphicassessment = (ims.assessment.vo.GraphicAssessmentShortVo)this.linkedgraphicassessment.clone();
		if(this.linkedorderentrytemplate == null)
			clone.linkedorderentrytemplate = null;
		else
			clone.linkedorderentrytemplate = (ims.ocrr.vo.OrderEntryTemplateBaseVo)this.linkedorderentrytemplate.clone();
		clone.isactivatedoninitiation = this.isactivatedoninitiation;
		clone.requirescountersignature = this.requirescountersignature;
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
		if (!(ICPActionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPActionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ICPActionVo compareObj = (ICPActionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSequence() == null && compareObj.getSequence() != null)
				return -1;
			if(this.getSequence() != null && compareObj.getSequence() == null)
				return 1;
			if(this.getSequence() != null && compareObj.getSequence() != null)
				retVal = this.getSequence().compareTo(compareObj.getSequence());
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
		if(this.description != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.helpurl != null)
			count++;
		if(this.status != null)
			count++;
		if(this.discipline != null)
			count++;
		if(this.linkedtype != null)
			count++;
		if(this.name != null)
			count++;
		if(this.ismandatory != null)
			count++;
		if(this.linkedform != null)
			count++;
		if(this.linkedassessment != null)
			count++;
		if(this.linkedgraphicassessment != null)
			count++;
		if(this.linkedorderentrytemplate != null)
			count++;
		if(this.isactivatedoninitiation != null)
			count++;
		if(this.requirescountersignature != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected String description;
	protected Integer sequence;
	protected String helpurl;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus status;
	protected ims.core.vo.lookups.HcpDisTypeCollection discipline;
	protected ims.core.vo.lookups.ICPCompLinkedType linkedtype;
	protected String name;
	protected Boolean ismandatory;
	protected ims.admin.vo.AppFormVo linkedform;
	protected ims.assessment.vo.UserAssessmentVo linkedassessment;
	protected ims.assessment.vo.GraphicAssessmentShortVo linkedgraphicassessment;
	protected ims.ocrr.vo.OrderEntryTemplateBaseVo linkedorderentrytemplate;
	protected Boolean isactivatedoninitiation;
	protected Boolean requirescountersignature;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
