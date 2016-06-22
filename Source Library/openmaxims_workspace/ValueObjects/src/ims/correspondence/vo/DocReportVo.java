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

package ims.correspondence.vo;

/**
 * Linked to core.admin.ReportBo business object (ID: 1004100009).
 */
public class DocReportVo extends ims.core.admin.vo.ReportBoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DocReportVo()
	{
	}
	public DocReportVo(Integer id, int version)
	{
		super(id, version);
	}
	public DocReportVo(ims.correspondence.vo.beans.DocReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.reportdescription = bean.getReportDescription();
		this.isactive = bean.getIsActive();
		this.reportxml = bean.getReportXml();
		this.templates = ims.correspondence.vo.DischargeDocTemplateVoCollection.buildFromBeanCollection(bean.getTemplates());
		this.seeds = ims.correspondence.vo.DischargeReportSeedVoCollection.buildFromBeanCollection(bean.getSeeds());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.beans.DocReportVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reportname = bean.getReportName();
		this.reportdescription = bean.getReportDescription();
		this.isactive = bean.getIsActive();
		this.reportxml = bean.getReportXml();
		this.templates = ims.correspondence.vo.DischargeDocTemplateVoCollection.buildFromBeanCollection(bean.getTemplates());
		this.seeds = ims.correspondence.vo.DischargeReportSeedVoCollection.buildFromBeanCollection(bean.getSeeds());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.beans.DocReportVoBean bean = null;
		if(map != null)
			bean = (ims.correspondence.vo.beans.DocReportVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.correspondence.vo.beans.DocReportVoBean();
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
		if(fieldName.equals("REPORTNAME"))
			return getReportName();
		if(fieldName.equals("REPORTDESCRIPTION"))
			return getReportDescription();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("REPORTXML"))
			return getReportXml();
		if(fieldName.equals("TEMPLATES"))
			return getTemplates();
		if(fieldName.equals("SEEDS"))
			return getSeeds();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReportNameIsNotNull()
	{
		return this.reportname != null;
	}
	public String getReportName()
	{
		return this.reportname;
	}
	public static int getReportNameMaxLength()
	{
		return 255;
	}
	public void setReportName(String value)
	{
		this.isValidated = false;
		this.reportname = value;
	}
	public boolean getReportDescriptionIsNotNull()
	{
		return this.reportdescription != null;
	}
	public String getReportDescription()
	{
		return this.reportdescription;
	}
	public static int getReportDescriptionMaxLength()
	{
		return 255;
	}
	public void setReportDescription(String value)
	{
		this.isValidated = false;
		this.reportdescription = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getReportXmlIsNotNull()
	{
		return this.reportxml != null;
	}
	public String getReportXml()
	{
		return this.reportxml;
	}
	public static int getReportXmlMaxLength()
	{
		return 200000;
	}
	public void setReportXml(String value)
	{
		this.isValidated = false;
		this.reportxml = value;
	}
	public boolean getTemplatesIsNotNull()
	{
		return this.templates != null;
	}
	public ims.correspondence.vo.DischargeDocTemplateVoCollection getTemplates()
	{
		return this.templates;
	}
	public void setTemplates(ims.correspondence.vo.DischargeDocTemplateVoCollection value)
	{
		this.isValidated = false;
		this.templates = value;
	}
	public boolean getSeedsIsNotNull()
	{
		return this.seeds != null;
	}
	public ims.correspondence.vo.DischargeReportSeedVoCollection getSeeds()
	{
		return this.seeds;
	}
	public void setSeeds(ims.correspondence.vo.DischargeReportSeedVoCollection value)
	{
		this.isValidated = false;
		this.seeds = value;
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
		if(this.templates != null)
		{
			if(!this.templates.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.seeds != null)
		{
			if(!this.seeds.isValidated())
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
		if(this.reportname == null || this.reportname.length() == 0)
			listOfErrors.add("reportName is mandatory");
		else if(this.reportname.length() > 255)
			listOfErrors.add("The length of the field [reportname] in the value object [ims.correspondence.vo.DocReportVo] is too big. It should be less or equal to 255");
		if(this.reportdescription != null)
			if(this.reportdescription.length() > 255)
				listOfErrors.add("The length of the field [reportdescription] in the value object [ims.correspondence.vo.DocReportVo] is too big. It should be less or equal to 255");
		if(this.templates != null)
		{
			String[] listOfOtherErrors = this.templates.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.seeds != null)
		{
			String[] listOfOtherErrors = this.seeds.validate();
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
	
		DocReportVo clone = new DocReportVo(this.id, this.version);
		
		clone.reportname = this.reportname;
		clone.reportdescription = this.reportdescription;
		clone.isactive = this.isactive;
		clone.reportxml = this.reportxml;
		if(this.templates == null)
			clone.templates = null;
		else
			clone.templates = (ims.correspondence.vo.DischargeDocTemplateVoCollection)this.templates.clone();
		if(this.seeds == null)
			clone.seeds = null;
		else
			clone.seeds = (ims.correspondence.vo.DischargeReportSeedVoCollection)this.seeds.clone();
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
		if (!(DocReportVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DocReportVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		DocReportVo compareObj = (DocReportVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReportName() == null && compareObj.getReportName() != null)
				return -1;
			if(this.getReportName() != null && compareObj.getReportName() == null)
				return 1;
			if(this.getReportName() != null && compareObj.getReportName() != null)
			{
				if(caseInsensitive)
					retVal = this.getReportName().toLowerCase().compareTo(compareObj.getReportName().toLowerCase());
				else
					retVal = this.getReportName().compareTo(compareObj.getReportName());
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
		if(this.reportname != null)
			count++;
		if(this.reportdescription != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.reportxml != null)
			count++;
		if(this.templates != null)
			count++;
		if(this.seeds != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String reportname;
	protected String reportdescription;
	protected Boolean isactive;
	protected String reportxml;
	protected ims.correspondence.vo.DischargeDocTemplateVoCollection templates;
	protected ims.correspondence.vo.DischargeReportSeedVoCollection seeds;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
