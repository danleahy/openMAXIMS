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

package ims.oncology.vo.beans;

public class RadiotherapyDetailsShortVoBean extends ims.vo.ValueObjectBean
{
	public RadiotherapyDetailsShortVoBean()
	{
	}
	public RadiotherapyDetailsShortVoBean(ims.oncology.vo.RadiotherapyDetailsShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean();
		this.radiotherapytype = vo.getRadiotherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRadiotherapyType().getBean();
		// Interface field type not supported.
		this.treatementintent = vo.getTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatementIntent().getBean();
		this.anatomicaltreatmentsite = vo.getAnatomicalTreatmentSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnatomicalTreatmentSite().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.RadiotherapyDetailsShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContext().getBean(map);
		this.radiotherapytype = vo.getRadiotherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRadiotherapyType().getBean();
		// Interface field type not supported.
		this.treatementintent = vo.getTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatementIntent().getBean();
		this.anatomicaltreatmentsite = vo.getAnatomicalTreatmentSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnatomicalTreatmentSite().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public ims.oncology.vo.RadiotherapyDetailsShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.RadiotherapyDetailsShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.RadiotherapyDetailsShortVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.RadiotherapyDetailsShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.RadiotherapyDetailsShortVo();
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
	public ims.core.vo.beans.CareContextShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.LookupInstanceBean getRadiotherapyType()
	{
		return this.radiotherapytype;
	}
	public void setRadiotherapyType(ims.vo.LookupInstanceBean value)
	{
		this.radiotherapytype = value;
	}
	public ims.vo.LookupInstanceBean getTreatementIntent()
	{
		return this.treatementintent;
	}
	public void setTreatementIntent(ims.vo.LookupInstanceBean value)
	{
		this.treatementintent = value;
	}
	public ims.vo.LookupInstanceBean getAnatomicalTreatmentSite()
	{
		return this.anatomicaltreatmentsite;
	}
	public void setAnatomicalTreatmentSite(ims.vo.LookupInstanceBean value)
	{
		this.anatomicaltreatmentsite = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.CareContextShortVoBean carecontext;
	private ims.vo.LookupInstanceBean radiotherapytype;
	private ims.vo.LookupInstanceBean treatementintent;
	private ims.vo.LookupInstanceBean anatomicaltreatmentsite;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.vo.RefVoBean episodeofcare;
}
