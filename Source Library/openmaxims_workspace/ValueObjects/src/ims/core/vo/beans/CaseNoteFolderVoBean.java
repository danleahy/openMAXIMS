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

public class CaseNoteFolderVoBean extends ims.vo.ValueObjectBean
{
	public CaseNoteFolderVoBean()
	{
	}
	public CaseNoteFolderVoBean(ims.core.vo.CaseNoteFolderVo vo)
	{
		this.volume = vo.getVolume();
		this.location = vo.getLocation();
		this.moveto = vo.getMoveTo();
		this.locdate = vo.getLocDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLocDate().getBean();
		this.loctime = vo.getLocTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getLocTime().getBean();
		this.comments = vo.getComments();
		this.unam = vo.getUNAM();
		this.rdat = vo.getRDAT() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRDAT().getBean();
		this.rtim = vo.getRTIM() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getRTIM().getBean();
		this.hospnum = vo.getHOSPNUM();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CaseNoteFolderVo vo)
	{
		this.volume = vo.getVolume();
		this.location = vo.getLocation();
		this.moveto = vo.getMoveTo();
		this.locdate = vo.getLocDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getLocDate().getBean();
		this.loctime = vo.getLocTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getLocTime().getBean();
		this.comments = vo.getComments();
		this.unam = vo.getUNAM();
		this.rdat = vo.getRDAT() == null ? null : (ims.framework.utils.beans.DateBean)vo.getRDAT().getBean();
		this.rtim = vo.getRTIM() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getRTIM().getBean();
		this.hospnum = vo.getHOSPNUM();
	}

	public ims.core.vo.CaseNoteFolderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CaseNoteFolderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CaseNoteFolderVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CaseNoteFolderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CaseNoteFolderVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getVolume()
	{
		return this.volume;
	}
	public void setVolume(String value)
	{
		this.volume = value;
	}
	public String getLocation()
	{
		return this.location;
	}
	public void setLocation(String value)
	{
		this.location = value;
	}
	public String getMoveTo()
	{
		return this.moveto;
	}
	public void setMoveTo(String value)
	{
		this.moveto = value;
	}
	public ims.framework.utils.beans.DateBean getLocDate()
	{
		return this.locdate;
	}
	public void setLocDate(ims.framework.utils.beans.DateBean value)
	{
		this.locdate = value;
	}
	public ims.framework.utils.beans.TimeBean getLocTime()
	{
		return this.loctime;
	}
	public void setLocTime(ims.framework.utils.beans.TimeBean value)
	{
		this.loctime = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public String getUNAM()
	{
		return this.unam;
	}
	public void setUNAM(String value)
	{
		this.unam = value;
	}
	public ims.framework.utils.beans.DateBean getRDAT()
	{
		return this.rdat;
	}
	public void setRDAT(ims.framework.utils.beans.DateBean value)
	{
		this.rdat = value;
	}
	public ims.framework.utils.beans.TimeBean getRTIM()
	{
		return this.rtim;
	}
	public void setRTIM(ims.framework.utils.beans.TimeBean value)
	{
		this.rtim = value;
	}
	public String getHOSPNUM()
	{
		return this.hospnum;
	}
	public void setHOSPNUM(String value)
	{
		this.hospnum = value;
	}

	private String volume;
	private String location;
	private String moveto;
	private ims.framework.utils.beans.DateBean locdate;
	private ims.framework.utils.beans.TimeBean loctime;
	private String comments;
	private String unam;
	private ims.framework.utils.beans.DateBean rdat;
	private ims.framework.utils.beans.TimeBean rtim;
	private String hospnum;
}
