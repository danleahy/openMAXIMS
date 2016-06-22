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

package ims.pci.vo.beans;

public class TerminationDetailsVoBean extends ims.vo.ValueObjectBean
{
	public TerminationDetailsVoBean()
	{
	}
	public TerminationDetailsVoBean(ims.pci.vo.TerminationDetailsVo vo)
	{
		this.terminatedby = vo.getTerminatedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getTerminatedBy().getBean();
		this.terminationreason = vo.getTerminationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTerminationReason().getBean();
		this.terminationdate = vo.getTerminationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTerminationDate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.pci.vo.TerminationDetailsVo vo)
	{
		this.terminatedby = vo.getTerminatedBy() == null ? null : (ims.vo.LookupInstanceBean)vo.getTerminatedBy().getBean();
		this.terminationreason = vo.getTerminationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTerminationReason().getBean();
		this.terminationdate = vo.getTerminationDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTerminationDate().getBean();
	}

	public ims.pci.vo.TerminationDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.pci.vo.TerminationDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.pci.vo.TerminationDetailsVo vo = null;
		if(map != null)
			vo = (ims.pci.vo.TerminationDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.pci.vo.TerminationDetailsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getTerminatedBy()
	{
		return this.terminatedby;
	}
	public void setTerminatedBy(ims.vo.LookupInstanceBean value)
	{
		this.terminatedby = value;
	}
	public ims.vo.LookupInstanceBean getTerminationReason()
	{
		return this.terminationreason;
	}
	public void setTerminationReason(ims.vo.LookupInstanceBean value)
	{
		this.terminationreason = value;
	}
	public ims.framework.utils.beans.DateBean getTerminationDate()
	{
		return this.terminationdate;
	}
	public void setTerminationDate(ims.framework.utils.beans.DateBean value)
	{
		this.terminationdate = value;
	}

	private ims.vo.LookupInstanceBean terminatedby;
	private ims.vo.LookupInstanceBean terminationreason;
	private ims.framework.utils.beans.DateBean terminationdate;
}
