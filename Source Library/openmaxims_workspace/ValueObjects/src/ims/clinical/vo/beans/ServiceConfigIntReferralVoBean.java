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

package ims.clinical.vo.beans;

public class ServiceConfigIntReferralVoBean extends ims.vo.ValueObjectBean
{
	public ServiceConfigIntReferralVoBean()
	{
	}
	public ServiceConfigIntReferralVoBean(ims.clinical.vo.ServiceConfigIntReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		this.active = vo.getActive();
		this.requireshcpauthorisation = vo.getRequiresHcpAuthorisation();
		this.nonhcpacceptance = vo.getNonHcpAcceptance();
		this.nohcpallowedforservice = vo.getNoHCPAllowedForService();
		this.tooltiptext = vo.getTooltipText();
		this.questions = vo.getQuestions() == null ? null : vo.getQuestions().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.ServiceConfigIntReferralVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		this.active = vo.getActive();
		this.requireshcpauthorisation = vo.getRequiresHcpAuthorisation();
		this.nonhcpacceptance = vo.getNonHcpAcceptance();
		this.nohcpallowedforservice = vo.getNoHCPAllowedForService();
		this.tooltiptext = vo.getTooltipText();
		this.questions = vo.getQuestions() == null ? null : vo.getQuestions().getBeanCollection();
	}

	public ims.clinical.vo.ServiceConfigIntReferralVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.ServiceConfigIntReferralVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.ServiceConfigIntReferralVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.ServiceConfigIntReferralVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.ServiceConfigIntReferralVo();
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
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public Boolean getRequiresHcpAuthorisation()
	{
		return this.requireshcpauthorisation;
	}
	public void setRequiresHcpAuthorisation(Boolean value)
	{
		this.requireshcpauthorisation = value;
	}
	public Boolean getNonHcpAcceptance()
	{
		return this.nonhcpacceptance;
	}
	public void setNonHcpAcceptance(Boolean value)
	{
		this.nonhcpacceptance = value;
	}
	public Boolean getNoHCPAllowedForService()
	{
		return this.nohcpallowedforservice;
	}
	public void setNoHCPAllowedForService(Boolean value)
	{
		this.nohcpallowedforservice = value;
	}
	public String getTooltipText()
	{
		return this.tooltiptext;
	}
	public void setTooltipText(String value)
	{
		this.tooltiptext = value;
	}
	public ims.core.vo.beans.AssessmentQuestionServiceVoBean[] getQuestions()
	{
		return this.questions;
	}
	public void setQuestions(ims.core.vo.beans.AssessmentQuestionServiceVoBean[] value)
	{
		this.questions = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.ServiceLiteVoBean service;
	private Boolean active;
	private Boolean requireshcpauthorisation;
	private Boolean nonhcpacceptance;
	private Boolean nohcpallowedforservice;
	private String tooltiptext;
	private ims.core.vo.beans.AssessmentQuestionServiceVoBean[] questions;
}
