// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ContractConfigKPIHistoryVoBean extends ims.vo.ValueObjectBean
{
	public ContractConfigKPIHistoryVoBean()
	{
	}
	public ContractConfigKPIHistoryVoBean(ims.RefMan.vo.ContractConfigKPIHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dateinstantiated = vo.getDateInstantiated() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateInstantiated().getBean();
		this.daystorttbreachdate = vo.getDaysToRTTBreachDate();
		this.daysto1stappt = vo.getDaysTo1stAppt();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ContractConfigKPIHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dateinstantiated = vo.getDateInstantiated() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateInstantiated().getBean();
		this.daystorttbreachdate = vo.getDaysToRTTBreachDate();
		this.daysto1stappt = vo.getDaysTo1stAppt();
	}

	public ims.RefMan.vo.ContractConfigKPIHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ContractConfigKPIHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ContractConfigKPIHistoryVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ContractConfigKPIHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ContractConfigKPIHistoryVo();
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
	public ims.framework.utils.beans.DateBean getDateInstantiated()
	{
		return this.dateinstantiated;
	}
	public void setDateInstantiated(ims.framework.utils.beans.DateBean value)
	{
		this.dateinstantiated = value;
	}
	public Integer getDaysToRTTBreachDate()
	{
		return this.daystorttbreachdate;
	}
	public void setDaysToRTTBreachDate(Integer value)
	{
		this.daystorttbreachdate = value;
	}
	public Integer getDaysTo1stAppt()
	{
		return this.daysto1stappt;
	}
	public void setDaysTo1stAppt(Integer value)
	{
		this.daysto1stappt = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean dateinstantiated;
	private Integer daystorttbreachdate;
	private Integer daysto1stappt;
}
