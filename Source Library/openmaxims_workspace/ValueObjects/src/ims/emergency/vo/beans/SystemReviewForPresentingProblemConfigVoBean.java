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

package ims.emergency.vo.beans;

public class SystemReviewForPresentingProblemConfigVoBean extends ims.vo.ValueObjectBean
{
	public SystemReviewForPresentingProblemConfigVoBean()
	{
	}
	public SystemReviewForPresentingProblemConfigVoBean(ims.emergency.vo.SystemReviewForPresentingProblemConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.problem = vo.getProblem() == null ? null : (ims.clinical.vo.beans.ClinicalProblemVoBean)vo.getProblem().getBean();
		this.system = vo.getSystem() == null ? null : vo.getSystem().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.SystemReviewForPresentingProblemConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.problem = vo.getProblem() == null ? null : (ims.clinical.vo.beans.ClinicalProblemVoBean)vo.getProblem().getBean(map);
		this.system = vo.getSystem() == null ? null : vo.getSystem().getBeanCollection();
	}

	public ims.emergency.vo.SystemReviewForPresentingProblemConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.SystemReviewForPresentingProblemConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.SystemReviewForPresentingProblemConfigVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.SystemReviewForPresentingProblemConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.SystemReviewForPresentingProblemConfigVo();
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
	public ims.clinical.vo.beans.ClinicalProblemVoBean getProblem()
	{
		return this.problem;
	}
	public void setProblem(ims.clinical.vo.beans.ClinicalProblemVoBean value)
	{
		this.problem = value;
	}
	public java.util.Collection getSystem()
	{
		return this.system;
	}
	public void setSystem(java.util.Collection value)
	{
		this.system = value;
	}
	public void addSystem(java.util.Collection value)
	{
		if(this.system == null)
			this.system = new java.util.ArrayList();
		this.system.add(value);
	}

	private Integer id;
	private int version;
	private ims.clinical.vo.beans.ClinicalProblemVoBean problem;
	private java.util.Collection system;
}
