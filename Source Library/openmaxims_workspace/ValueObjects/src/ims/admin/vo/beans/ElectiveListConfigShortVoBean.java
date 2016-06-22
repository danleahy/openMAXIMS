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

package ims.admin.vo.beans;

public class ElectiveListConfigShortVoBean extends ims.vo.ValueObjectBean
{
	public ElectiveListConfigShortVoBean()
	{
	}
	public ElectiveListConfigShortVoBean(ims.admin.vo.ElectiveListConfigShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.waitinglistname = vo.getWaitingListName();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.waitinglistcode = vo.getWaitingListCode();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.ElectiveListConfigShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.waitinglistname = vo.getWaitingListName();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.waitinglistcode = vo.getWaitingListCode();
		this.isactive = vo.getIsActive();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
	}

	public ims.admin.vo.ElectiveListConfigShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.ElectiveListConfigShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.ElectiveListConfigShortVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.ElectiveListConfigShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.ElectiveListConfigShortVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public String getWaitingListName()
	{
		return this.waitinglistname;
	}
	public void setWaitingListName(String value)
	{
		this.waitinglistname = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public String getWaitingListCode()
	{
		return this.waitinglistcode;
	}
	public void setWaitingListCode(String value)
	{
		this.waitinglistcode = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}

	private Integer id;
	private int version;
	private String waitinglistname;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean enddate;
	private String waitinglistcode;
	private Boolean isactive;
	private ims.core.vo.beans.ServiceLiteVoBean service;
}
