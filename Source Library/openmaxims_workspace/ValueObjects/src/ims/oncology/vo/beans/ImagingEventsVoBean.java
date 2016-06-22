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

public class ImagingEventsVoBean extends ims.vo.ValueObjectBean
{
	public ImagingEventsVoBean()
	{
	}
	public ImagingEventsVoBean(ims.oncology.vo.ImagingEventsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean();
		this.hospitalsiteofimage = vo.getHospitalSiteOfImage() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getHospitalSiteOfImage().getBean();
		this.imagedate = vo.getImageDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getImageDate().getBean();
		this.anatomicalsite = vo.getAnatomicalSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnatomicalSite().getBean();
		this.reportdate = vo.getReportDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReportDate().getBean();
		this.lesionsize = vo.getLesionSize();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.imagingevent = vo.getImagingEvent() == null ? null : (ims.core.vo.beans.CancerImagingEventLiteVoBean)vo.getImagingEvent().getBean();
		this.imagingeventdescription = vo.getImagingEventDescription();
		this.requesteddate = vo.getRequestedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRequestedDate().getBean();
		this.investigationresult = vo.getInvestigationResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvestigationResult().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.ImagingEventsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextLiteVoBean)vo.getCareContext().getBean(map);
		this.hospitalsiteofimage = vo.getHospitalSiteOfImage() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getHospitalSiteOfImage().getBean(map);
		this.imagedate = vo.getImageDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getImageDate().getBean();
		this.anatomicalsite = vo.getAnatomicalSite() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnatomicalSite().getBean();
		this.reportdate = vo.getReportDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReportDate().getBean();
		this.lesionsize = vo.getLesionSize();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.imagingevent = vo.getImagingEvent() == null ? null : (ims.core.vo.beans.CancerImagingEventLiteVoBean)vo.getImagingEvent().getBean(map);
		this.imagingeventdescription = vo.getImagingEventDescription();
		this.requesteddate = vo.getRequestedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRequestedDate().getBean();
		this.investigationresult = vo.getInvestigationResult() == null ? null : (ims.vo.LookupInstanceBean)vo.getInvestigationResult().getBean();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
	}

	public ims.oncology.vo.ImagingEventsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.oncology.vo.ImagingEventsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.ImagingEventsVo vo = null;
		if(map != null)
			vo = (ims.oncology.vo.ImagingEventsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.oncology.vo.ImagingEventsVo();
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
	public ims.core.vo.beans.CareContextLiteVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextLiteVoBean value)
	{
		this.carecontext = value;
	}
	public ims.core.vo.beans.LocSiteLiteVoBean getHospitalSiteOfImage()
	{
		return this.hospitalsiteofimage;
	}
	public void setHospitalSiteOfImage(ims.core.vo.beans.LocSiteLiteVoBean value)
	{
		this.hospitalsiteofimage = value;
	}
	public ims.framework.utils.beans.DateBean getImageDate()
	{
		return this.imagedate;
	}
	public void setImageDate(ims.framework.utils.beans.DateBean value)
	{
		this.imagedate = value;
	}
	public ims.vo.LookupInstanceBean getAnatomicalSite()
	{
		return this.anatomicalsite;
	}
	public void setAnatomicalSite(ims.vo.LookupInstanceBean value)
	{
		this.anatomicalsite = value;
	}
	public ims.framework.utils.beans.DateBean getReportDate()
	{
		return this.reportdate;
	}
	public void setReportDate(ims.framework.utils.beans.DateBean value)
	{
		this.reportdate = value;
	}
	public Integer getLesionSize()
	{
		return this.lesionsize;
	}
	public void setLesionSize(Integer value)
	{
		this.lesionsize = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.CancerImagingEventLiteVoBean getImagingEvent()
	{
		return this.imagingevent;
	}
	public void setImagingEvent(ims.core.vo.beans.CancerImagingEventLiteVoBean value)
	{
		this.imagingevent = value;
	}
	public String getImagingEventDescription()
	{
		return this.imagingeventdescription;
	}
	public void setImagingEventDescription(String value)
	{
		this.imagingeventdescription = value;
	}
	public ims.framework.utils.beans.DateBean getRequestedDate()
	{
		return this.requesteddate;
	}
	public void setRequestedDate(ims.framework.utils.beans.DateBean value)
	{
		this.requesteddate = value;
	}
	public ims.vo.LookupInstanceBean getInvestigationResult()
	{
		return this.investigationresult;
	}
	public void setInvestigationResult(ims.vo.LookupInstanceBean value)
	{
		this.investigationresult = value;
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
	private ims.core.vo.beans.CareContextLiteVoBean carecontext;
	private ims.core.vo.beans.LocSiteLiteVoBean hospitalsiteofimage;
	private ims.framework.utils.beans.DateBean imagedate;
	private ims.vo.LookupInstanceBean anatomicalsite;
	private ims.framework.utils.beans.DateBean reportdate;
	private Integer lesionsize;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.CancerImagingEventLiteVoBean imagingevent;
	private String imagingeventdescription;
	private ims.framework.utils.beans.DateBean requesteddate;
	private ims.vo.LookupInstanceBean investigationresult;
	private ims.vo.RefVoBean episodeofcare;
}
