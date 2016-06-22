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

package ims.ocrr.vo.beans;

public class PathologyOrderVoBean extends ims.vo.ValueObjectBean
{
	public PathologyOrderVoBean()
	{
	}
	public PathologyOrderVoBean(ims.ocrr.vo.PathologyOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationLiteVoBean)vo.getInvestigation().getBean();
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.OcsOrderShortVoBean)vo.getOrderDetails().getBean();
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.PathologyOrderVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.investigation = vo.getInvestigation() == null ? null : (ims.ocrr.vo.beans.InvestigationLiteVoBean)vo.getInvestigation().getBean(map);
		this.orderdetails = vo.getOrderDetails() == null ? null : (ims.ocrr.vo.beans.OcsOrderShortVoBean)vo.getOrderDetails().getBean(map);
		this.displaydatetime = vo.getDisplayDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDisplayDateTime().getBean();
		this.specimen = vo.getSpecimen() == null ? null : vo.getSpecimen().getBeanCollection();
	}

	public ims.ocrr.vo.PathologyOrderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.PathologyOrderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.PathologyOrderVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.PathologyOrderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.PathologyOrderVo();
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
	public ims.ocrr.vo.beans.InvestigationLiteVoBean getInvestigation()
	{
		return this.investigation;
	}
	public void setInvestigation(ims.ocrr.vo.beans.InvestigationLiteVoBean value)
	{
		this.investigation = value;
	}
	public ims.ocrr.vo.beans.OcsOrderShortVoBean getOrderDetails()
	{
		return this.orderdetails;
	}
	public void setOrderDetails(ims.ocrr.vo.beans.OcsOrderShortVoBean value)
	{
		this.orderdetails = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDisplayDateTime()
	{
		return this.displaydatetime;
	}
	public void setDisplayDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.displaydatetime = value;
	}
	public ims.ocrr.vo.beans.OrderSpecimenPathologyVoBean[] getSpecimen()
	{
		return this.specimen;
	}
	public void setSpecimen(ims.ocrr.vo.beans.OrderSpecimenPathologyVoBean[] value)
	{
		this.specimen = value;
	}

	private Integer id;
	private int version;
	private ims.ocrr.vo.beans.InvestigationLiteVoBean investigation;
	private ims.ocrr.vo.beans.OcsOrderShortVoBean orderdetails;
	private ims.framework.utils.beans.DateTimeBean displaydatetime;
	private ims.ocrr.vo.beans.OrderSpecimenPathologyVoBean[] specimen;
}
