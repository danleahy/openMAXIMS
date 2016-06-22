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

package ims.core.vo.beans;

public class PDSConsentHistoryVoBean extends ims.vo.ValueObjectBean
{
	public PDSConsentHistoryVoBean()
	{
	}
	public PDSConsentHistoryVoBean(ims.core.vo.PDSConsentHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.consent = vo.getConsent() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsent().getBean();
		this.comment = vo.getComment();
		this.consenttype = vo.getConsentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsentType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PDSConsentHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.consent = vo.getConsent() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsent().getBean();
		this.comment = vo.getComment();
		this.consenttype = vo.getConsentType() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsentType().getBean();
	}

	public ims.core.vo.PDSConsentHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PDSConsentHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PDSConsentHistoryVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PDSConsentHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PDSConsentHistoryVo();
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
	public ims.framework.utils.beans.DateBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateBean value)
	{
		this.date = value;
	}
	public ims.vo.LookupInstanceBean getConsent()
	{
		return this.consent;
	}
	public void setConsent(ims.vo.LookupInstanceBean value)
	{
		this.consent = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.vo.LookupInstanceBean getConsentType()
	{
		return this.consenttype;
	}
	public void setConsentType(ims.vo.LookupInstanceBean value)
	{
		this.consenttype = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean date;
	private ims.vo.LookupInstanceBean consent;
	private String comment;
	private ims.vo.LookupInstanceBean consenttype;
}
