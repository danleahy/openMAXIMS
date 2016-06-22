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

package ims.therapies.vo.beans;

public class WorkOnDischargeVoBean extends ims.vo.ValueObjectBean
{
	public WorkOnDischargeVoBean()
	{
	}
	public WorkOnDischargeVoBean(ims.therapies.vo.WorkOnDischargeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean();
		this.positionondischarge = vo.getPositionOnDischarge();
		this.returntoworkdate = vo.getReturnToWorkDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReturnToWorkDate().getBean();
		this.jobposition = vo.getJobPosition();
		this.hours = vo.getHours();
		this.reasonfornotreturning = vo.getReasonForNotReturning();
		this.careeradvice = vo.getCareerAdvice();
		this.occupationalpsychologist = vo.getOccupationalPsychologist();
		this.highereducation = vo.getHigherEducation();
		this.retraining = vo.getRetraining();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.WorkOnDischargeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.authoringcp = vo.getAuthoringCP() == null ? null : (ims.core.vo.beans.HcpBean)vo.getAuthoringCP().getBean(map);
		this.positionondischarge = vo.getPositionOnDischarge();
		this.returntoworkdate = vo.getReturnToWorkDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReturnToWorkDate().getBean();
		this.jobposition = vo.getJobPosition();
		this.hours = vo.getHours();
		this.reasonfornotreturning = vo.getReasonForNotReturning();
		this.careeradvice = vo.getCareerAdvice();
		this.occupationalpsychologist = vo.getOccupationalPsychologist();
		this.highereducation = vo.getHigherEducation();
		this.retraining = vo.getRetraining();
	}

	public ims.therapies.vo.WorkOnDischargeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.therapies.vo.WorkOnDischargeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.WorkOnDischargeVo vo = null;
		if(map != null)
			vo = (ims.therapies.vo.WorkOnDischargeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.therapies.vo.WorkOnDischargeVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.core.vo.beans.HcpBean getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.beans.HcpBean value)
	{
		this.authoringcp = value;
	}
	public String getPositionOnDischarge()
	{
		return this.positionondischarge;
	}
	public void setPositionOnDischarge(String value)
	{
		this.positionondischarge = value;
	}
	public ims.framework.utils.beans.DateBean getReturnToWorkDate()
	{
		return this.returntoworkdate;
	}
	public void setReturnToWorkDate(ims.framework.utils.beans.DateBean value)
	{
		this.returntoworkdate = value;
	}
	public String getJobPosition()
	{
		return this.jobposition;
	}
	public void setJobPosition(String value)
	{
		this.jobposition = value;
	}
	public String getHours()
	{
		return this.hours;
	}
	public void setHours(String value)
	{
		this.hours = value;
	}
	public String getReasonForNotReturning()
	{
		return this.reasonfornotreturning;
	}
	public void setReasonForNotReturning(String value)
	{
		this.reasonfornotreturning = value;
	}
	public String getCareerAdvice()
	{
		return this.careeradvice;
	}
	public void setCareerAdvice(String value)
	{
		this.careeradvice = value;
	}
	public String getOccupationalPsychologist()
	{
		return this.occupationalpsychologist;
	}
	public void setOccupationalPsychologist(String value)
	{
		this.occupationalpsychologist = value;
	}
	public String getHigherEducation()
	{
		return this.highereducation;
	}
	public void setHigherEducation(String value)
	{
		this.highereducation = value;
	}
	public String getRetraining()
	{
		return this.retraining;
	}
	public void setRetraining(String value)
	{
		this.retraining = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.core.vo.beans.HcpBean authoringcp;
	private String positionondischarge;
	private ims.framework.utils.beans.DateBean returntoworkdate;
	private String jobposition;
	private String hours;
	private String reasonfornotreturning;
	private String careeradvice;
	private String occupationalpsychologist;
	private String highereducation;
	private String retraining;
}
