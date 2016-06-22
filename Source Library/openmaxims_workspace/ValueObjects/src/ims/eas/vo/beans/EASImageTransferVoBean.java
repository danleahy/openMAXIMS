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

package ims.eas.vo.beans;

public class EASImageTransferVoBean extends ims.vo.ValueObjectBean
{
	public EASImageTransferVoBean()
	{
	}
	public EASImageTransferVoBean(ims.eas.vo.EASImageTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.imagetype = vo.getImageType() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageType().getBean();
		this.imagedate = vo.getImageDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getImageDate().getBean();
		this.imagetakenat = vo.getImageTakenAt() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageTakenAt().getBean();
		this.locationtaken = vo.getLocationTaken();
		this.anatomicalsite = vo.getAnatomicalSite();
		this.imagerequested = vo.getImageRequested();
		this.removedstat = vo.getRemovedStat();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.EASImageTransferVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.imagetype = vo.getImageType() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageType().getBean();
		this.imagedate = vo.getImageDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getImageDate().getBean();
		this.imagetakenat = vo.getImageTakenAt() == null ? null : (ims.vo.LookupInstanceBean)vo.getImageTakenAt().getBean();
		this.locationtaken = vo.getLocationTaken();
		this.anatomicalsite = vo.getAnatomicalSite();
		this.imagerequested = vo.getImageRequested();
		this.removedstat = vo.getRemovedStat();
		this.removalreason = vo.getRemovalReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getRemovalReason().getBean();
	}

	public ims.eas.vo.EASImageTransferVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.EASImageTransferVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.EASImageTransferVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.EASImageTransferVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.EASImageTransferVo();
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
	public ims.vo.LookupInstanceBean getImageType()
	{
		return this.imagetype;
	}
	public void setImageType(ims.vo.LookupInstanceBean value)
	{
		this.imagetype = value;
	}
	public ims.framework.utils.beans.PartialDateBean getImageDate()
	{
		return this.imagedate;
	}
	public void setImageDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.imagedate = value;
	}
	public ims.vo.LookupInstanceBean getImageTakenAt()
	{
		return this.imagetakenat;
	}
	public void setImageTakenAt(ims.vo.LookupInstanceBean value)
	{
		this.imagetakenat = value;
	}
	public String getLocationTaken()
	{
		return this.locationtaken;
	}
	public void setLocationTaken(String value)
	{
		this.locationtaken = value;
	}
	public String getAnatomicalSite()
	{
		return this.anatomicalsite;
	}
	public void setAnatomicalSite(String value)
	{
		this.anatomicalsite = value;
	}
	public Boolean getImageRequested()
	{
		return this.imagerequested;
	}
	public void setImageRequested(Boolean value)
	{
		this.imagerequested = value;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.removedstat = value;
	}
	public ims.vo.LookupInstanceBean getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.vo.LookupInstanceBean value)
	{
		this.removalreason = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean imagetype;
	private ims.framework.utils.beans.PartialDateBean imagedate;
	private ims.vo.LookupInstanceBean imagetakenat;
	private String locationtaken;
	private String anatomicalsite;
	private Boolean imagerequested;
	private Boolean removedstat;
	private ims.vo.LookupInstanceBean removalreason;
}
