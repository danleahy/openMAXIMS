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
 * Linked to core.admin.EpisodeOfCare business object (ID: 1004100018).
 */
public class EpisodeofCareLiteVo extends ims.core.admin.vo.EpisodeOfCareRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EpisodeofCareLiteVo()
	{
	}
	public EpisodeofCareLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public EpisodeofCareLiteVo(ims.core.vo.beans.EpisodeofCareLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carespell = bean.getCareSpell() == null ? null : new ims.core.admin.vo.CareSpellRefVo(new Integer(bean.getCareSpell().getId()), bean.getCareSpell().getVersion());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.EpisodeofCareLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carespell = bean.getCareSpell() == null ? null : new ims.core.admin.vo.CareSpellRefVo(new Integer(bean.getCareSpell().getId()), bean.getCareSpell().getVersion());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
		this.specialty = bean.getSpecialty() == null ? null : ims.core.vo.lookups.Specialty.buildLookup(bean.getSpecialty());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.EpisodeofCareLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.EpisodeofCareLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.EpisodeofCareLiteVoBean();
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
		if(fieldName.equals("CARESPELL"))
			return getCareSpell();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		if(fieldName.equals("SPECIALTY"))
			return getSpecialty();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareSpellIsNotNull()
	{
		return this.carespell != null;
	}
	public ims.core.admin.vo.CareSpellRefVo getCareSpell()
	{
		return this.carespell;
	}
	public void setCareSpell(ims.core.admin.vo.CareSpellRefVo value)
	{
		this.isValidated = false;
		this.carespell = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	public boolean getSpecialtyIsNotNull()
	{
		return this.specialty != null;
	}
	public ims.core.vo.lookups.Specialty getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.core.vo.lookups.Specialty value)
	{
		this.isValidated = false;
		this.specialty = value;
	}
	/**
	* getHcpDisplayString
	*/
	public String getHcpDisplayString()
	{
		if(this.responsiblehcp != null)
		{
			if(this.responsiblehcp.getMosIsNotNull())
				if(this.responsiblehcp.getMos().getNameIsNotNull())
					return this.responsiblehcp.getMos().getName().toString();
		}
			
		return "";
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
		if(this.carespell == null)
			listOfErrors.add("CareSpell is mandatory");
		if(this.specialty == null)
			listOfErrors.add("Specialty is mandatory");
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
	
		EpisodeofCareLiteVo clone = new EpisodeofCareLiteVo(this.id, this.version);
		
		clone.carespell = this.carespell;
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		if(this.specialty == null)
			clone.specialty = null;
		else
			clone.specialty = (ims.core.vo.lookups.Specialty)this.specialty.clone();
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
		if (!(EpisodeofCareLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EpisodeofCareLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EpisodeofCareLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EpisodeofCareLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.carespell != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		if(this.specialty != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.admin.vo.CareSpellRefVo carespell;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	protected ims.core.vo.lookups.Specialty specialty;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
