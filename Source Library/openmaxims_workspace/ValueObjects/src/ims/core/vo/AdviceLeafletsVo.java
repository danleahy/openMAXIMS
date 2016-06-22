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
 * Linked to core.clinical.AdviceLeaflets business object (ID: 1024100002).
 */
public class AdviceLeafletsVo extends ims.core.clinical.vo.AdviceLeafletsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdviceLeafletsVo()
	{
	}
	public AdviceLeafletsVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdviceLeafletsVo(ims.core.vo.beans.AdviceLeafletsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.adviceleaflet = bean.getAdviceLeaflet() == null ? null : ims.core.vo.lookups.AdviceLeaflets.buildLookup(bean.getAdviceLeaflet());
		this.dategiven = bean.getDateGiven() == null ? null : bean.getDateGiven().buildDate();
		this.givento = bean.getGivenTo() == null ? null : ims.core.vo.lookups.AdviceLeafletGivenTo.buildLookup(bean.getGivenTo());
		this.giventoname = bean.getGivenToName();
		this.leafletversion = bean.getLeafletVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AdviceLeafletsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.adviceleaflet = bean.getAdviceLeaflet() == null ? null : ims.core.vo.lookups.AdviceLeaflets.buildLookup(bean.getAdviceLeaflet());
		this.dategiven = bean.getDateGiven() == null ? null : bean.getDateGiven().buildDate();
		this.givento = bean.getGivenTo() == null ? null : ims.core.vo.lookups.AdviceLeafletGivenTo.buildLookup(bean.getGivenTo());
		this.giventoname = bean.getGivenToName();
		this.leafletversion = bean.getLeafletVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringhcp = bean.getAuthoringHCP() == null ? null : bean.getAuthoringHCP().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AdviceLeafletsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AdviceLeafletsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AdviceLeafletsVoBean();
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
		if(fieldName.equals("ADVICELEAFLET"))
			return getAdviceLeaflet();
		if(fieldName.equals("DATEGIVEN"))
			return getDateGiven();
		if(fieldName.equals("GIVENTO"))
			return getGivenTo();
		if(fieldName.equals("GIVENTONAME"))
			return getGivenToName();
		if(fieldName.equals("LEAFLETVERSION"))
			return getLeafletVersion();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGHCP"))
			return getAuthoringHCP();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAdviceLeafletIsNotNull()
	{
		return this.adviceleaflet != null;
	}
	public ims.core.vo.lookups.AdviceLeaflets getAdviceLeaflet()
	{
		return this.adviceleaflet;
	}
	public void setAdviceLeaflet(ims.core.vo.lookups.AdviceLeaflets value)
	{
		this.isValidated = false;
		this.adviceleaflet = value;
	}
	public boolean getDateGivenIsNotNull()
	{
		return this.dategiven != null;
	}
	public ims.framework.utils.Date getDateGiven()
	{
		return this.dategiven;
	}
	public void setDateGiven(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dategiven = value;
	}
	public boolean getGivenToIsNotNull()
	{
		return this.givento != null;
	}
	public ims.core.vo.lookups.AdviceLeafletGivenTo getGivenTo()
	{
		return this.givento;
	}
	public void setGivenTo(ims.core.vo.lookups.AdviceLeafletGivenTo value)
	{
		this.isValidated = false;
		this.givento = value;
	}
	public boolean getGivenToNameIsNotNull()
	{
		return this.giventoname != null;
	}
	public String getGivenToName()
	{
		return this.giventoname;
	}
	public static int getGivenToNameMaxLength()
	{
		return 100;
	}
	public void setGivenToName(String value)
	{
		this.isValidated = false;
		this.giventoname = value;
	}
	public boolean getLeafletVersionIsNotNull()
	{
		return this.leafletversion != null;
	}
	public String getLeafletVersion()
	{
		return this.leafletversion;
	}
	public static int getLeafletVersionMaxLength()
	{
		return 50;
	}
	public void setLeafletVersion(String value)
	{
		this.isValidated = false;
		this.leafletversion = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuthoringHCPIsNotNull()
	{
		return this.authoringhcp != null;
	}
	public ims.core.vo.Hcp getAuthoringHCP()
	{
		return this.authoringhcp;
	}
	public void setAuthoringHCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringhcp = value;
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
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.id);
		return sb.toString();
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
		if(this.authoringhcp != null)
		{
			if(!this.authoringhcp.isValidated())
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
		if(this.dategiven == null)
			listOfErrors.add("Date Given is a mandatory field");
		if(this.giventoname != null)
			if(this.giventoname.length() > 100)
				listOfErrors.add("The length of the field [giventoname] in the value object [ims.core.vo.AdviceLeafletsVo] is too big. It should be less or equal to 100");
		if(this.leafletversion != null)
			if(this.leafletversion.length() > 50)
				listOfErrors.add("The length of the field [leafletversion] in the value object [ims.core.vo.AdviceLeafletsVo] is too big. It should be less or equal to 50");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.authoringhcp == null)
			listOfErrors.add("AuthoringHCP is mandatory");
		if(this.authoringhcp != null)
		{
			String[] listOfOtherErrors = this.authoringhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
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
	
		AdviceLeafletsVo clone = new AdviceLeafletsVo(this.id, this.version);
		
		if(this.adviceleaflet == null)
			clone.adviceleaflet = null;
		else
			clone.adviceleaflet = (ims.core.vo.lookups.AdviceLeaflets)this.adviceleaflet.clone();
		if(this.dategiven == null)
			clone.dategiven = null;
		else
			clone.dategiven = (ims.framework.utils.Date)this.dategiven.clone();
		if(this.givento == null)
			clone.givento = null;
		else
			clone.givento = (ims.core.vo.lookups.AdviceLeafletGivenTo)this.givento.clone();
		clone.giventoname = this.giventoname;
		clone.leafletversion = this.leafletversion;
		clone.carecontext = this.carecontext;
		if(this.authoringhcp == null)
			clone.authoringhcp = null;
		else
			clone.authoringhcp = (ims.core.vo.Hcp)this.authoringhcp.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
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
		if (!(AdviceLeafletsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdviceLeafletsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AdviceLeafletsVo compareObj = (AdviceLeafletsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getAdviceLeaflet() == null && compareObj.getAdviceLeaflet() != null)
				return -1;
			if(this.getAdviceLeaflet() != null && compareObj.getAdviceLeaflet() == null)
				return 1;
			if(this.getAdviceLeaflet() != null && compareObj.getAdviceLeaflet() != null)
				retVal = this.getAdviceLeaflet().compareTo(compareObj.getAdviceLeaflet());
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
		if(this.adviceleaflet != null)
			count++;
		if(this.dategiven != null)
			count++;
		if(this.givento != null)
			count++;
		if(this.giventoname != null)
			count++;
		if(this.leafletversion != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.authoringhcp != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.lookups.AdviceLeaflets adviceleaflet;
	protected ims.framework.utils.Date dategiven;
	protected ims.core.vo.lookups.AdviceLeafletGivenTo givento;
	protected String giventoname;
	protected String leafletversion;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.core.vo.Hcp authoringhcp;
	protected ims.framework.utils.DateTime authoringdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
