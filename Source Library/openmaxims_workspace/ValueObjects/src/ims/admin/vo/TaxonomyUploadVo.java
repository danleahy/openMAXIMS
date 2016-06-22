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

package ims.admin.vo;

/**
 * Linked to core.admin.TaxonomyUpload business object (ID: 1004100038).
 */
public class TaxonomyUploadVo extends ims.core.admin.vo.TaxonomyUploadRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TaxonomyUploadVo()
	{
	}
	public TaxonomyUploadVo(Integer id, int version)
	{
		super(id, version);
	}
	public TaxonomyUploadVo(ims.admin.vo.beans.TaxonomyUploadVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.taxonomycolumnmapfilename = bean.getTaxonomyColumnMapFilename();
		this.taxonomycode = bean.getTaxonomyCode() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getTaxonomyCode());
		this.taxonomyfilename = bean.getTaxonomyFilename();
		this.filetype = bean.getFileType() == null ? null : ims.admin.vo.lookups.FileFormatType.buildLookup(bean.getFileType());
		this.taxonomyelement = bean.getTaxonomyElement() == null ? null : ims.core.vo.lookups.TaxonomyElement.buildLookup(bean.getTaxonomyElement());
		this.delimeter = bean.getDelimeter();
		this.qualifier = bean.getQualifier();
		this.deletefirst = bean.getDeleteFirst();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.TaxonomyUploadVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.taxonomycolumnmapfilename = bean.getTaxonomyColumnMapFilename();
		this.taxonomycode = bean.getTaxonomyCode() == null ? null : ims.core.vo.lookups.TaxonomyType.buildLookup(bean.getTaxonomyCode());
		this.taxonomyfilename = bean.getTaxonomyFilename();
		this.filetype = bean.getFileType() == null ? null : ims.admin.vo.lookups.FileFormatType.buildLookup(bean.getFileType());
		this.taxonomyelement = bean.getTaxonomyElement() == null ? null : ims.core.vo.lookups.TaxonomyElement.buildLookup(bean.getTaxonomyElement());
		this.delimeter = bean.getDelimeter();
		this.qualifier = bean.getQualifier();
		this.deletefirst = bean.getDeleteFirst();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.TaxonomyUploadVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.TaxonomyUploadVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.TaxonomyUploadVoBean();
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
		if(fieldName.equals("TAXONOMYCOLUMNMAPFILENAME"))
			return getTaxonomyColumnMapFilename();
		if(fieldName.equals("TAXONOMYCODE"))
			return getTaxonomyCode();
		if(fieldName.equals("TAXONOMYFILENAME"))
			return getTaxonomyFilename();
		if(fieldName.equals("FILETYPE"))
			return getFileType();
		if(fieldName.equals("TAXONOMYELEMENT"))
			return getTaxonomyElement();
		if(fieldName.equals("DELIMETER"))
			return getDelimeter();
		if(fieldName.equals("QUALIFIER"))
			return getQualifier();
		if(fieldName.equals("DELETEFIRST"))
			return getDeleteFirst();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTaxonomyColumnMapFilenameIsNotNull()
	{
		return this.taxonomycolumnmapfilename != null;
	}
	public String getTaxonomyColumnMapFilename()
	{
		return this.taxonomycolumnmapfilename;
	}
	public static int getTaxonomyColumnMapFilenameMaxLength()
	{
		return 200;
	}
	public void setTaxonomyColumnMapFilename(String value)
	{
		this.isValidated = false;
		this.taxonomycolumnmapfilename = value;
	}
	public boolean getTaxonomyCodeIsNotNull()
	{
		return this.taxonomycode != null;
	}
	public ims.core.vo.lookups.TaxonomyType getTaxonomyCode()
	{
		return this.taxonomycode;
	}
	public void setTaxonomyCode(ims.core.vo.lookups.TaxonomyType value)
	{
		this.isValidated = false;
		this.taxonomycode = value;
	}
	public boolean getTaxonomyFilenameIsNotNull()
	{
		return this.taxonomyfilename != null;
	}
	public String getTaxonomyFilename()
	{
		return this.taxonomyfilename;
	}
	public static int getTaxonomyFilenameMaxLength()
	{
		return 200;
	}
	public void setTaxonomyFilename(String value)
	{
		this.isValidated = false;
		this.taxonomyfilename = value;
	}
	public boolean getFileTypeIsNotNull()
	{
		return this.filetype != null;
	}
	public ims.admin.vo.lookups.FileFormatType getFileType()
	{
		return this.filetype;
	}
	public void setFileType(ims.admin.vo.lookups.FileFormatType value)
	{
		this.isValidated = false;
		this.filetype = value;
	}
	public boolean getTaxonomyElementIsNotNull()
	{
		return this.taxonomyelement != null;
	}
	public ims.core.vo.lookups.TaxonomyElement getTaxonomyElement()
	{
		return this.taxonomyelement;
	}
	public void setTaxonomyElement(ims.core.vo.lookups.TaxonomyElement value)
	{
		this.isValidated = false;
		this.taxonomyelement = value;
	}
	public boolean getDelimeterIsNotNull()
	{
		return this.delimeter != null;
	}
	public String getDelimeter()
	{
		return this.delimeter;
	}
	public static int getDelimeterMaxLength()
	{
		return 4;
	}
	public void setDelimeter(String value)
	{
		this.isValidated = false;
		this.delimeter = value;
	}
	public boolean getQualifierIsNotNull()
	{
		return this.qualifier != null;
	}
	public String getQualifier()
	{
		return this.qualifier;
	}
	public static int getQualifierMaxLength()
	{
		return 4;
	}
	public void setQualifier(String value)
	{
		this.isValidated = false;
		this.qualifier = value;
	}
	public boolean getDeleteFirstIsNotNull()
	{
		return this.deletefirst != null;
	}
	public Boolean getDeleteFirst()
	{
		return this.deletefirst;
	}
	public void setDeleteFirst(Boolean value)
	{
		this.isValidated = false;
		this.deletefirst = value;
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
		if(this.taxonomycolumnmapfilename != null)
			if(this.taxonomycolumnmapfilename.length() > 200)
				listOfErrors.add("The length of the field [taxonomycolumnmapfilename] in the value object [ims.admin.vo.TaxonomyUploadVo] is too big. It should be less or equal to 200");
		if(this.taxonomyfilename != null)
			if(this.taxonomyfilename.length() > 200)
				listOfErrors.add("The length of the field [taxonomyfilename] in the value object [ims.admin.vo.TaxonomyUploadVo] is too big. It should be less or equal to 200");
		if(this.delimeter != null)
			if(this.delimeter.length() > 4)
				listOfErrors.add("The length of the field [delimeter] in the value object [ims.admin.vo.TaxonomyUploadVo] is too big. It should be less or equal to 4");
		if(this.qualifier != null)
			if(this.qualifier.length() > 4)
				listOfErrors.add("The length of the field [qualifier] in the value object [ims.admin.vo.TaxonomyUploadVo] is too big. It should be less or equal to 4");
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
	
		TaxonomyUploadVo clone = new TaxonomyUploadVo(this.id, this.version);
		
		clone.taxonomycolumnmapfilename = this.taxonomycolumnmapfilename;
		if(this.taxonomycode == null)
			clone.taxonomycode = null;
		else
			clone.taxonomycode = (ims.core.vo.lookups.TaxonomyType)this.taxonomycode.clone();
		clone.taxonomyfilename = this.taxonomyfilename;
		if(this.filetype == null)
			clone.filetype = null;
		else
			clone.filetype = (ims.admin.vo.lookups.FileFormatType)this.filetype.clone();
		if(this.taxonomyelement == null)
			clone.taxonomyelement = null;
		else
			clone.taxonomyelement = (ims.core.vo.lookups.TaxonomyElement)this.taxonomyelement.clone();
		clone.delimeter = this.delimeter;
		clone.qualifier = this.qualifier;
		clone.deletefirst = this.deletefirst;
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
		if (!(TaxonomyUploadVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TaxonomyUploadVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TaxonomyUploadVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TaxonomyUploadVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.taxonomycolumnmapfilename != null)
			count++;
		if(this.taxonomycode != null)
			count++;
		if(this.taxonomyfilename != null)
			count++;
		if(this.filetype != null)
			count++;
		if(this.taxonomyelement != null)
			count++;
		if(this.delimeter != null)
			count++;
		if(this.qualifier != null)
			count++;
		if(this.deletefirst != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected String taxonomycolumnmapfilename;
	protected ims.core.vo.lookups.TaxonomyType taxonomycode;
	protected String taxonomyfilename;
	protected ims.admin.vo.lookups.FileFormatType filetype;
	protected ims.core.vo.lookups.TaxonomyElement taxonomyelement;
	protected String delimeter;
	protected String qualifier;
	protected Boolean deletefirst;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
