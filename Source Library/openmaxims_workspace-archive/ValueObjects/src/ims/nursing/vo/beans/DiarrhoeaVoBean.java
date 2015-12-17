//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.nursing.vo.beans;

public class DiarrhoeaVoBean extends ims.vo.ValueObjectBean
{
	public DiarrhoeaVoBean()
	{
	}
	public DiarrhoeaVoBean(ims.nursing.vo.DiarrhoeaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pronetodiarrhoea = vo.getProneToDiarrhoea() == null ? null : (ims.vo.LookupInstanceBean)vo.getProneToDiarrhoea().getBean();
		this.frequency = vo.getFrequency() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequency().getBean();
		this.consistency = vo.getConsistency() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsistency().getBean();
		this.odour = vo.getOdour() == null ? null : (ims.vo.LookupInstanceBean)vo.getOdour().getBean();
		this.colour = vo.getColour() == null ? null : (ims.vo.LookupInstanceBean)vo.getColour().getBean();
		this.amount = vo.getAmount() == null ? null : (ims.vo.LookupInstanceBean)vo.getAmount().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.nursing.vo.DiarrhoeaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.pronetodiarrhoea = vo.getProneToDiarrhoea() == null ? null : (ims.vo.LookupInstanceBean)vo.getProneToDiarrhoea().getBean();
		this.frequency = vo.getFrequency() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequency().getBean();
		this.consistency = vo.getConsistency() == null ? null : (ims.vo.LookupInstanceBean)vo.getConsistency().getBean();
		this.odour = vo.getOdour() == null ? null : (ims.vo.LookupInstanceBean)vo.getOdour().getBean();
		this.colour = vo.getColour() == null ? null : (ims.vo.LookupInstanceBean)vo.getColour().getBean();
		this.amount = vo.getAmount() == null ? null : (ims.vo.LookupInstanceBean)vo.getAmount().getBean();
	}

	public ims.nursing.vo.DiarrhoeaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.nursing.vo.DiarrhoeaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.nursing.vo.DiarrhoeaVo vo = null;
		if(map != null)
			vo = (ims.nursing.vo.DiarrhoeaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.nursing.vo.DiarrhoeaVo();
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
	public ims.vo.LookupInstanceBean getProneToDiarrhoea()
	{
		return this.pronetodiarrhoea;
	}
	public void setProneToDiarrhoea(ims.vo.LookupInstanceBean value)
	{
		this.pronetodiarrhoea = value;
	}
	public ims.vo.LookupInstanceBean getFrequency()
	{
		return this.frequency;
	}
	public void setFrequency(ims.vo.LookupInstanceBean value)
	{
		this.frequency = value;
	}
	public ims.vo.LookupInstanceBean getConsistency()
	{
		return this.consistency;
	}
	public void setConsistency(ims.vo.LookupInstanceBean value)
	{
		this.consistency = value;
	}
	public ims.vo.LookupInstanceBean getOdour()
	{
		return this.odour;
	}
	public void setOdour(ims.vo.LookupInstanceBean value)
	{
		this.odour = value;
	}
	public ims.vo.LookupInstanceBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.vo.LookupInstanceBean value)
	{
		this.colour = value;
	}
	public ims.vo.LookupInstanceBean getAmount()
	{
		return this.amount;
	}
	public void setAmount(ims.vo.LookupInstanceBean value)
	{
		this.amount = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean pronetodiarrhoea;
	private ims.vo.LookupInstanceBean frequency;
	private ims.vo.LookupInstanceBean consistency;
	private ims.vo.LookupInstanceBean odour;
	private ims.vo.LookupInstanceBean colour;
	private ims.vo.LookupInstanceBean amount;
}