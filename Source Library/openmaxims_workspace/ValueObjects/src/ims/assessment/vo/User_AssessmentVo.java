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
 * Linked to Assessment.Configuration.UserAssessment business object (ID: 1003100043).
 */
public class User_AssessmentVo extends ims.assessment.configuration.vo.UserAssessmentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public User_AssessmentVo()
	{
	}
	public User_AssessmentVo(Integer id, int version)
	{
		super(id, version);
	}
	public User_AssessmentVo(ims.assessment.vo.beans.User_AssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.groupquestionwidth = bean.getGroupQuestionWidth();
		this.helpurl = bean.getHelpURL();
		this.isflatview = bean.getIsFlatView();
		this.ismultiplegroup = bean.getIsMultipleGroup();
		this.questiongroups = ims.assessment.vo.Assessment_QuestionGroupVoCollection.buildFromBeanCollection(bean.getQuestionGroups());
		this.headertext = bean.getHeaderText();
		this.footertext = bean.getFooterText();
		this.maxheaderheight = bean.getMaxHeaderHeight();
		this.maxfooterheight = bean.getMaxFooterHeight();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.scoringmethod = bean.getScoringMethod() == null ? null : ims.core.vo.lookups.UserAssessmentScoringMethod.buildLookup(bean.getScoringMethod());
		this.associatedreport = bean.getAssociatedReport() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getAssociatedReport().getId()), bean.getAssociatedReport().getVersion());
		this.storeprintedassessment = bean.getStorePrintedAssessment();
		this.cancopylast = bean.getCanCopyLast();
		this.copylastfromcontext = bean.getCopyLastFromContext() == null ? null : ims.assessment.vo.lookups.CopyLastAssessmentContextType.buildLookup(bean.getCopyLastFromContext());
		this.assessmentroles = ims.assessment.vo.AssessmentRoleVoCollection.buildFromBeanCollection(bean.getAssessmentRoles());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserAssessmentCategory.buildLookup(bean.getCategory());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.User_AssessmentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.description = bean.getDescription();
		this.groupquestionwidth = bean.getGroupQuestionWidth();
		this.helpurl = bean.getHelpURL();
		this.isflatview = bean.getIsFlatView();
		this.ismultiplegroup = bean.getIsMultipleGroup();
		this.questiongroups = ims.assessment.vo.Assessment_QuestionGroupVoCollection.buildFromBeanCollection(bean.getQuestionGroups());
		this.headertext = bean.getHeaderText();
		this.footertext = bean.getFooterText();
		this.maxheaderheight = bean.getMaxHeaderHeight();
		this.maxfooterheight = bean.getMaxFooterHeight();
		this.assessmenttype = bean.getAssessmentType() == null ? null : ims.core.vo.lookups.UserDefinedAssessmentType.buildLookup(bean.getAssessmentType());
		this.scoringmethod = bean.getScoringMethod() == null ? null : ims.core.vo.lookups.UserAssessmentScoringMethod.buildLookup(bean.getScoringMethod());
		this.associatedreport = bean.getAssociatedReport() == null ? null : new ims.core.admin.vo.TemplateBoRefVo(new Integer(bean.getAssociatedReport().getId()), bean.getAssociatedReport().getVersion());
		this.storeprintedassessment = bean.getStorePrintedAssessment();
		this.cancopylast = bean.getCanCopyLast();
		this.copylastfromcontext = bean.getCopyLastFromContext() == null ? null : ims.assessment.vo.lookups.CopyLastAssessmentContextType.buildLookup(bean.getCopyLastFromContext());
		this.assessmentroles = ims.assessment.vo.AssessmentRoleVoCollection.buildFromBeanCollection(bean.getAssessmentRoles());
		this.category = bean.getCategory() == null ? null : ims.core.vo.lookups.UserAssessmentCategory.buildLookup(bean.getCategory());
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.User_AssessmentVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.User_AssessmentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.User_AssessmentVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("GROUPQUESTIONWIDTH"))
			return getGroupQuestionWidth();
		if(fieldName.equals("HELPURL"))
			return getHelpURL();
		if(fieldName.equals("ISFLATVIEW"))
			return getIsFlatView();
		if(fieldName.equals("ISMULTIPLEGROUP"))
			return getIsMultipleGroup();
		if(fieldName.equals("QUESTIONGROUPS"))
			return getQuestionGroups();
		if(fieldName.equals("HEADERTEXT"))
			return getHeaderText();
		if(fieldName.equals("FOOTERTEXT"))
			return getFooterText();
		if(fieldName.equals("MAXHEADERHEIGHT"))
			return getMaxHeaderHeight();
		if(fieldName.equals("MAXFOOTERHEIGHT"))
			return getMaxFooterHeight();
		if(fieldName.equals("ASSESSMENTTYPE"))
			return getAssessmentType();
		if(fieldName.equals("SCORINGMETHOD"))
			return getScoringMethod();
		if(fieldName.equals("ASSOCIATEDREPORT"))
			return getAssociatedReport();
		if(fieldName.equals("STOREPRINTEDASSESSMENT"))
			return getStorePrintedAssessment();
		if(fieldName.equals("CANCOPYLAST"))
			return getCanCopyLast();
		if(fieldName.equals("COPYLASTFROMCONTEXT"))
			return getCopyLastFromContext();
		if(fieldName.equals("ASSESSMENTROLES"))
			return getAssessmentRoles();
		if(fieldName.equals("CATEGORY"))
			return getCategory();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		return super.getFieldValueByFieldName(fieldName);
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
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
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
		return 500;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getGroupQuestionWidthIsNotNull()
	{
		return this.groupquestionwidth != null;
	}
	public Integer getGroupQuestionWidth()
	{
		return this.groupquestionwidth;
	}
	public void setGroupQuestionWidth(Integer value)
	{
		this.isValidated = false;
		this.groupquestionwidth = value;
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
		return 1024;
	}
	public void setHelpURL(String value)
	{
		this.isValidated = false;
		this.helpurl = value;
	}
	public boolean getIsFlatViewIsNotNull()
	{
		return this.isflatview != null;
	}
	public Boolean getIsFlatView()
	{
		return this.isflatview;
	}
	public void setIsFlatView(Boolean value)
	{
		this.isValidated = false;
		this.isflatview = value;
	}
	public boolean getIsMultipleGroupIsNotNull()
	{
		return this.ismultiplegroup != null;
	}
	public Boolean getIsMultipleGroup()
	{
		return this.ismultiplegroup;
	}
	public void setIsMultipleGroup(Boolean value)
	{
		this.isValidated = false;
		this.ismultiplegroup = value;
	}
	public boolean getQuestionGroupsIsNotNull()
	{
		return this.questiongroups != null;
	}
	public ims.assessment.vo.Assessment_QuestionGroupVoCollection getQuestionGroups()
	{
		return this.questiongroups;
	}
	public void setQuestionGroups(ims.assessment.vo.Assessment_QuestionGroupVoCollection value)
	{
		this.isValidated = false;
		this.questiongroups = value;
	}
	public boolean getHeaderTextIsNotNull()
	{
		return this.headertext != null;
	}
	public String getHeaderText()
	{
		return this.headertext;
	}
	public static int getHeaderTextMaxLength()
	{
		return 5000;
	}
	public void setHeaderText(String value)
	{
		this.isValidated = false;
		this.headertext = value;
	}
	public boolean getFooterTextIsNotNull()
	{
		return this.footertext != null;
	}
	public String getFooterText()
	{
		return this.footertext;
	}
	public static int getFooterTextMaxLength()
	{
		return 5000;
	}
	public void setFooterText(String value)
	{
		this.isValidated = false;
		this.footertext = value;
	}
	public boolean getMaxHeaderHeightIsNotNull()
	{
		return this.maxheaderheight != null;
	}
	public Integer getMaxHeaderHeight()
	{
		return this.maxheaderheight;
	}
	public void setMaxHeaderHeight(Integer value)
	{
		this.isValidated = false;
		this.maxheaderheight = value;
	}
	public boolean getMaxFooterHeightIsNotNull()
	{
		return this.maxfooterheight != null;
	}
	public Integer getMaxFooterHeight()
	{
		return this.maxfooterheight;
	}
	public void setMaxFooterHeight(Integer value)
	{
		this.isValidated = false;
		this.maxfooterheight = value;
	}
	public boolean getAssessmentTypeIsNotNull()
	{
		return this.assessmenttype != null;
	}
	public ims.core.vo.lookups.UserDefinedAssessmentType getAssessmentType()
	{
		return this.assessmenttype;
	}
	public void setAssessmentType(ims.core.vo.lookups.UserDefinedAssessmentType value)
	{
		this.isValidated = false;
		this.assessmenttype = value;
	}
	public boolean getScoringMethodIsNotNull()
	{
		return this.scoringmethod != null;
	}
	public ims.core.vo.lookups.UserAssessmentScoringMethod getScoringMethod()
	{
		return this.scoringmethod;
	}
	public void setScoringMethod(ims.core.vo.lookups.UserAssessmentScoringMethod value)
	{
		this.isValidated = false;
		this.scoringmethod = value;
	}
	public boolean getAssociatedReportIsNotNull()
	{
		return this.associatedreport != null;
	}
	public ims.core.admin.vo.TemplateBoRefVo getAssociatedReport()
	{
		return this.associatedreport;
	}
	public void setAssociatedReport(ims.core.admin.vo.TemplateBoRefVo value)
	{
		this.isValidated = false;
		this.associatedreport = value;
	}
	public boolean getStorePrintedAssessmentIsNotNull()
	{
		return this.storeprintedassessment != null;
	}
	public Boolean getStorePrintedAssessment()
	{
		return this.storeprintedassessment;
	}
	public void setStorePrintedAssessment(Boolean value)
	{
		this.isValidated = false;
		this.storeprintedassessment = value;
	}
	public boolean getCanCopyLastIsNotNull()
	{
		return this.cancopylast != null;
	}
	public Boolean getCanCopyLast()
	{
		return this.cancopylast;
	}
	public void setCanCopyLast(Boolean value)
	{
		this.isValidated = false;
		this.cancopylast = value;
	}
	public boolean getCopyLastFromContextIsNotNull()
	{
		return this.copylastfromcontext != null;
	}
	public ims.assessment.vo.lookups.CopyLastAssessmentContextType getCopyLastFromContext()
	{
		return this.copylastfromcontext;
	}
	public void setCopyLastFromContext(ims.assessment.vo.lookups.CopyLastAssessmentContextType value)
	{
		this.isValidated = false;
		this.copylastfromcontext = value;
	}
	public boolean getAssessmentRolesIsNotNull()
	{
		return this.assessmentroles != null;
	}
	public ims.assessment.vo.AssessmentRoleVoCollection getAssessmentRoles()
	{
		return this.assessmentroles;
	}
	public void setAssessmentRoles(ims.assessment.vo.AssessmentRoleVoCollection value)
	{
		this.isValidated = false;
		this.assessmentroles = value;
	}
	public boolean getCategoryIsNotNull()
	{
		return this.category != null;
	}
	public ims.core.vo.lookups.UserAssessmentCategory getCategory()
	{
		return this.category;
	}
	public void setCategory(ims.core.vo.lookups.UserAssessmentCategory value)
	{
		this.isValidated = false;
		this.category = value;
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
	/**
	* isScoringUserDefinedAssessment() - returns if a UDA has one of the Scoring types
	*/
	public Boolean isScoringUserDefinedAssessment()
	{
		java.util.List<ims.core.vo.lookups.UserDefinedAssessmentType> scoringTypesList = java.util.Arrays.asList(ims.core.vo.lookups.UserDefinedAssessmentType.ASSESSMENTTOOL,
		ims.core.vo.lookups.UserDefinedAssessmentType.DPP,
		ims.core.vo.lookups.UserDefinedAssessmentType.FALLSRISK,
		ims.core.vo.lookups.UserDefinedAssessmentType.ADL,
		ims.core.vo.lookups.UserDefinedAssessmentType.SKIN,
		ims.core.vo.lookups.UserDefinedAssessmentType.BLAD,
		ims.core.vo.lookups.UserDefinedAssessmentType.BWEL,
		ims.core.vo.lookups.UserDefinedAssessmentType.WC,
		ims.core.vo.lookups.UserDefinedAssessmentType.COM,
		ims.core.vo.lookups.UserDefinedAssessmentType.PSY,
		ims.core.vo.lookups.UserDefinedAssessmentType.NURSEDISCHARGECHKLST,
		ims.core.vo.lookups.UserDefinedAssessmentType.PREOPPOSSUM,
		ims.core.vo.lookups.UserDefinedAssessmentType.OPERATIVEDETAILSPOSSUM);
	
		 if (scoringTypesList.contains(this.assessmenttype))
		return true;
	
		return false;
	}
	/**
	* isNonScoringUserDefinedAssessment() - returns if a UDA has one of the Non-Scoring types
	*/
	public Boolean isNonScoringUserDefinedAssessment()
	{
		java.util.List<ims.core.vo.lookups.UserDefinedAssessmentType> nonScoringTypesList = java.util.Arrays.asList(ims.core.vo.lookups.UserDefinedAssessmentType.USERDEFINEDDATASHEET,
		ims.core.vo.lookups.UserDefinedAssessmentType.DISCHARGECHECKLIST,
		ims.core.vo.lookups.UserDefinedAssessmentType.DISCHARGE_PLANNING,
		ims.core.vo.lookups.UserDefinedAssessmentType.DISCHARGE,
		ims.core.vo.lookups.UserDefinedAssessmentType.MANCHESTERTRIAGE,
		ims.core.vo.lookups.UserDefinedAssessmentType.INTROPHONECALL);
	
		 if (nonScoringTypesList.contains(this.assessmenttype))
			return true;
	
		return false;
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
		if(this.questiongroups != null)
		{
			if(!this.questiongroups.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.assessment.vo.User_AssessmentVo] is too big. It should be less or equal to 100");
		if(this.description != null)
			if(this.description.length() > 500)
				listOfErrors.add("The length of the field [description] in the value object [ims.assessment.vo.User_AssessmentVo] is too big. It should be less or equal to 500");
		if(this.helpurl != null)
			if(this.helpurl.length() > 1024)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.assessment.vo.User_AssessmentVo] is too big. It should be less or equal to 1024");
		if(this.isflatview == null)
			listOfErrors.add("isFlatView is mandatory");
		if(this.questiongroups != null)
		{
			String[] listOfOtherErrors = this.questiongroups.validate();
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
	
		User_AssessmentVo clone = new User_AssessmentVo(this.id, this.version);
		
		clone.name = this.name;
		clone.description = this.description;
		clone.groupquestionwidth = this.groupquestionwidth;
		clone.helpurl = this.helpurl;
		clone.isflatview = this.isflatview;
		clone.ismultiplegroup = this.ismultiplegroup;
		if(this.questiongroups == null)
			clone.questiongroups = null;
		else
			clone.questiongroups = (ims.assessment.vo.Assessment_QuestionGroupVoCollection)this.questiongroups.clone();
		clone.headertext = this.headertext;
		clone.footertext = this.footertext;
		clone.maxheaderheight = this.maxheaderheight;
		clone.maxfooterheight = this.maxfooterheight;
		if(this.assessmenttype == null)
			clone.assessmenttype = null;
		else
			clone.assessmenttype = (ims.core.vo.lookups.UserDefinedAssessmentType)this.assessmenttype.clone();
		if(this.scoringmethod == null)
			clone.scoringmethod = null;
		else
			clone.scoringmethod = (ims.core.vo.lookups.UserAssessmentScoringMethod)this.scoringmethod.clone();
		clone.associatedreport = this.associatedreport;
		clone.storeprintedassessment = this.storeprintedassessment;
		clone.cancopylast = this.cancopylast;
		if(this.copylastfromcontext == null)
			clone.copylastfromcontext = null;
		else
			clone.copylastfromcontext = (ims.assessment.vo.lookups.CopyLastAssessmentContextType)this.copylastfromcontext.clone();
		if(this.assessmentroles == null)
			clone.assessmentroles = null;
		else
			clone.assessmentroles = (ims.assessment.vo.AssessmentRoleVoCollection)this.assessmentroles.clone();
		if(this.category == null)
			clone.category = null;
		else
			clone.category = (ims.core.vo.lookups.UserAssessmentCategory)this.category.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
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
		if (!(User_AssessmentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A User_AssessmentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		User_AssessmentVo compareObj = (User_AssessmentVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.description != null)
			count++;
		if(this.groupquestionwidth != null)
			count++;
		if(this.helpurl != null)
			count++;
		if(this.isflatview != null)
			count++;
		if(this.ismultiplegroup != null)
			count++;
		if(this.questiongroups != null)
			count++;
		if(this.headertext != null)
			count++;
		if(this.footertext != null)
			count++;
		if(this.maxheaderheight != null)
			count++;
		if(this.maxfooterheight != null)
			count++;
		if(this.assessmenttype != null)
			count++;
		if(this.scoringmethod != null)
			count++;
		if(this.associatedreport != null)
			count++;
		if(this.storeprintedassessment != null)
			count++;
		if(this.cancopylast != null)
			count++;
		if(this.copylastfromcontext != null)
			count++;
		if(this.assessmentroles != null)
			count++;
		if(this.category != null)
			count++;
		if(this.activestatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 20;
	}
	protected String name;
	protected String description;
	protected Integer groupquestionwidth;
	protected String helpurl;
	protected Boolean isflatview;
	protected Boolean ismultiplegroup;
	protected ims.assessment.vo.Assessment_QuestionGroupVoCollection questiongroups;
	protected String headertext;
	protected String footertext;
	protected Integer maxheaderheight;
	protected Integer maxfooterheight;
	protected ims.core.vo.lookups.UserDefinedAssessmentType assessmenttype;
	protected ims.core.vo.lookups.UserAssessmentScoringMethod scoringmethod;
	protected ims.core.admin.vo.TemplateBoRefVo associatedreport;
	protected Boolean storeprintedassessment;
	protected Boolean cancopylast;
	protected ims.assessment.vo.lookups.CopyLastAssessmentContextType copylastfromcontext;
	protected ims.assessment.vo.AssessmentRoleVoCollection assessmentroles;
	protected ims.core.vo.lookups.UserAssessmentCategory category;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
