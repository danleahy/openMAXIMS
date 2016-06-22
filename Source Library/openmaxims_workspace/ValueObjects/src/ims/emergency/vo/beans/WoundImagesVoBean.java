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

public class WoundImagesVoBean extends ims.vo.ValueObjectBean
{
	public WoundImagesVoBean()
	{
	}
	public WoundImagesVoBean(ims.emergency.vo.WoundImagesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.photo = vo.getPhoto() == null ? null : (ims.core.vo.beans.AppDBImageVoBean)vo.getPhoto().getBean();
		this.comment = vo.getComment();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.WoundImagesVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.photo = vo.getPhoto() == null ? null : (ims.core.vo.beans.AppDBImageVoBean)vo.getPhoto().getBean(map);
		this.comment = vo.getComment();
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public ims.emergency.vo.WoundImagesVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.WoundImagesVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.WoundImagesVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.WoundImagesVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.WoundImagesVo();
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
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.core.vo.beans.AppDBImageVoBean getPhoto()
	{
		return this.photo;
	}
	public void setPhoto(ims.core.vo.beans.AppDBImageVoBean value)
	{
		this.photo = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.core.vo.beans.AppDBImageVoBean photo;
	private String comment;
	private ims.vo.SysInfoBean systeminformation;
}
