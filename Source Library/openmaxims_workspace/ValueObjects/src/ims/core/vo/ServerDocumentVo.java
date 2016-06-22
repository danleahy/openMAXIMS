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

package ims.core.vo;

/**
 * Linked to core.Documents.ServerDocument business object (ID: 1068100000).
 */
public class ServerDocumentVo extends ims.core.documents.vo.ServerDocumentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ServerDocumentVo()
	{
	}
	public ServerDocumentVo(Integer id, int version)
	{
		super(id, version);
	}
	public ServerDocumentVo(ims.core.vo.beans.ServerDocumentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.filename = bean.getFileName();
		this.filetype = bean.getFileType() == null ? null : ims.core.vo.lookups.FileType.buildLookup(bean.getFileType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ServerDocumentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.filename = bean.getFileName();
		this.filetype = bean.getFileType() == null ? null : ims.core.vo.lookups.FileType.buildLookup(bean.getFileType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ServerDocumentVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ServerDocumentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ServerDocumentVoBean();
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
		if(fieldName.equals("FILENAME"))
			return getFileName();
		if(fieldName.equals("FILETYPE"))
			return getFileType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFileNameIsNotNull()
	{
		return this.filename != null;
	}
	public String getFileName()
	{
		return this.filename;
	}
	public static int getFileNameMaxLength()
	{
		return 500;
	}
	public void setFileName(String value)
	{
		this.isValidated = false;
		this.filename = value;
	}
	public boolean getFileTypeIsNotNull()
	{
		return this.filetype != null;
	}
	public ims.core.vo.lookups.FileType getFileType()
	{
		return this.filetype;
	}
	public void setFileType(ims.core.vo.lookups.FileType value)
	{
		this.isValidated = false;
		this.filetype = value;
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
		if(this.filename == null || this.filename.length() == 0)
			listOfErrors.add("FileName is mandatory");
		else if(this.filename.length() > 500)
			listOfErrors.add("The length of the field [filename] in the value object [ims.core.vo.ServerDocumentVo] is too big. It should be less or equal to 500");
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
	
		ServerDocumentVo clone = new ServerDocumentVo(this.id, this.version);
		
		clone.filename = this.filename;
		if(this.filetype == null)
			clone.filetype = null;
		else
			clone.filetype = (ims.core.vo.lookups.FileType)this.filetype.clone();
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
		if (!(ServerDocumentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ServerDocumentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ServerDocumentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ServerDocumentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.filename != null)
			count++;
		if(this.filetype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String filename;
	protected ims.core.vo.lookups.FileType filetype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
