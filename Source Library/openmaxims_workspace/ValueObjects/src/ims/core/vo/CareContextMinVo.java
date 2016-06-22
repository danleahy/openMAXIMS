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
 * Linked to core.admin.CareContext business object (ID: 1004100019).
 */
public class CareContextMinVo extends ims.core.admin.vo.CareContextRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CareContextMinVo()
	{
	}
	public CareContextMinVo(Integer id, int version)
	{
		super(id, version);
	}
	public CareContextMinVo(ims.core.vo.beans.CareContextMinVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getResponsibleHCP().getId()), bean.getResponsibleHCP().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.CareContextMinVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : new ims.core.resource.people.vo.HcpRefVo(new Integer(bean.getResponsibleHCP().getId()), bean.getResponsibleHCP().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.CareContextMinVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.CareContextMinVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.CareContextMinVoBean();
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
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.vo.EpisodeOfCareForPatientDocumentsVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.EpisodeOfCareForPatientDocumentsVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.resource.people.vo.HcpRefVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.resource.people.vo.HcpRefVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
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
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.startdatetime == null)
			listOfErrors.add("StartDateTime is mandatory");
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
	
		CareContextMinVo clone = new CareContextMinVo(this.id, this.version);
		
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeOfCareForPatientDocumentsVo)this.episodeofcare.clone();
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		clone.responsiblehcp = this.responsiblehcp;
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
		if (!(CareContextMinVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CareContextMinVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CareContextMinVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CareContextMinVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.episodeofcare != null)
			count++;
		if(this.startdatetime != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.EpisodeOfCareForPatientDocumentsVo episodeofcare;
	protected ims.framework.utils.DateTime startdatetime;
	protected ims.core.resource.people.vo.HcpRefVo responsiblehcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
