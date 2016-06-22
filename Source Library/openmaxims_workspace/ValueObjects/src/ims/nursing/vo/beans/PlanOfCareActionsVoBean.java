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

package ims.nursing.vo.beans;

public class PlanOfCareActionsVoBean extends ims.vo.ValueObjectBean
{
	public PlanOfCareActionsVoBean()
	{
	}
	public PlanOfCareActionsVoBean(ims.nursing.vo.PlanOfCareActionsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.action = vo.getAction();
		this.review = vo.getReview();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.reviewingdatetime = vo.getReviewingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewingDateTime().getBean();
		this.reviewinghcp = vo.getReviewingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReviewingHCP().getBean();
		this.planofcare = vo.getPlanOfCare() == null ? null : (ims.nursing.vo.beans.PlanOfCareListVoBean)vo.getPlanOfCare().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.PlanOfCareActionsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.action = vo.getAction();
		this.review = vo.getReview();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.reviewingdatetime = vo.getReviewingDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewingDateTime().getBean();
		this.reviewinghcp = vo.getReviewingHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getReviewingHCP().getBean(map);
		this.planofcare = vo.getPlanOfCare() == null ? null : (ims.nursing.vo.beans.PlanOfCareListVoBean)vo.getPlanOfCare().getBean(map);
	}

	public ims.nursing.vo.PlanOfCareActionsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.PlanOfCareActionsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.PlanOfCareActionsVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.PlanOfCareActionsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.PlanOfCareActionsVo();
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
	public String getAction()
	{
		return this.action;
	}
	public void setAction(String value)
	{
		this.action = value;
	}
	public String getReview()
	{
		return this.review;
	}
	public void setReview(String value)
	{
		this.review = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReviewingDateTime()
	{
		return this.reviewingdatetime;
	}
	public void setReviewingDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.reviewingdatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getReviewingHCP()
	{
		return this.reviewinghcp;
	}
	public void setReviewingHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.reviewinghcp = value;
	}
	public ims.nursing.vo.beans.PlanOfCareListVoBean getPlanOfCare()
	{
		return this.planofcare;
	}
	public void setPlanOfCare(ims.nursing.vo.beans.PlanOfCareListVoBean value)
	{
		this.planofcare = value;
	}

	private Integer id;
	private int version;
	private String action;
	private String review;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.framework.utils.beans.DateTimeBean reviewingdatetime;
	private ims.core.vo.beans.HcpLiteVoBean reviewinghcp;
	private ims.nursing.vo.beans.PlanOfCareListVoBean planofcare;
}
