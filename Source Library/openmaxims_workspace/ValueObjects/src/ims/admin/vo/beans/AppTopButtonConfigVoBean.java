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

package ims.admin.vo.beans;

public class AppTopButtonConfigVoBean extends ims.vo.ValueObjectBean
{
	public AppTopButtonConfigVoBean()
	{
	}
	public AppTopButtonConfigVoBean(ims.admin.vo.AppTopButtonConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.buttons = vo.getButtons() == null ? null : vo.getButtons().getBeanCollection();
		this.sections = vo.getSections() == null ? null : vo.getSections().getBeanCollection();
		this.nocolumns = vo.getNoColumns();
		this.includepatienthistory = vo.getIncludePatientHistory();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.AppTopButtonConfigVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.buttons = vo.getButtons() == null ? null : vo.getButtons().getBeanCollection();
		this.sections = vo.getSections() == null ? null : vo.getSections().getBeanCollection();
		this.nocolumns = vo.getNoColumns();
		this.includepatienthistory = vo.getIncludePatientHistory();
	}

	public ims.admin.vo.AppTopButtonConfigVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.admin.vo.AppTopButtonConfigVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.AppTopButtonConfigVo vo = null;
		if(map != null)
			vo = (ims.admin.vo.AppTopButtonConfigVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.admin.vo.AppTopButtonConfigVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.admin.vo.beans.AppTopButtonVoBean[] getButtons()
	{
		return this.buttons;
	}
	public void setButtons(ims.admin.vo.beans.AppTopButtonVoBean[] value)
	{
		this.buttons = value;
	}
	public ims.admin.vo.beans.AppTopButtonSectionVoBean[] getSections()
	{
		return this.sections;
	}
	public void setSections(ims.admin.vo.beans.AppTopButtonSectionVoBean[] value)
	{
		this.sections = value;
	}
	public Integer getNoColumns()
	{
		return this.nocolumns;
	}
	public void setNoColumns(Integer value)
	{
		this.nocolumns = value;
	}
	public Boolean getIncludePatientHistory()
	{
		return this.includepatienthistory;
	}
	public void setIncludePatientHistory(Boolean value)
	{
		this.includepatienthistory = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.admin.vo.beans.AppTopButtonVoBean[] buttons;
	private ims.admin.vo.beans.AppTopButtonSectionVoBean[] sections;
	private Integer nocolumns;
	private Boolean includepatienthistory;
}
