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

public class ActionPlanVoBean extends ims.vo.ValueObjectBean
{
	public ActionPlanVoBean()
	{
	}
	public ActionPlanVoBean(ims.core.vo.ActionPlanVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datecommenced = vo.getDateCommenced() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateCommenced().getBean();
		this.ordernumber = vo.getOrderNumber();
		this.datecompleted = vo.getDateCompleted() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateCompleted().getBean();
		this.comment = vo.getComment();
		this.recall = vo.getRecall() == null ? null : (ims.vo.LookupInstanceBean)vo.getRecall().getBean();
		this.recallin = vo.getRecallIn();
		this.recallperiod = vo.getRecallPeriod() == null ? null : (ims.vo.LookupInstanceBean)vo.getRecallPeriod().getBean();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
		this.ncpcomment = vo.getNcpComment();
		this.naesreferral = vo.getNAESReferral() == null ? null : (ims.naes.vo.beans.NAESReferralVoBean)vo.getNAESReferral().getBean();
		this.sclera = vo.getSclera();
		this.quarteryear = vo.getQuarterYear();
		this.finalcure = vo.getFinalCure();
		this.batchnumber = vo.getBatchNumber();
		this.sixmonthopenperiod = vo.getSixMonthOpenPeriod() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSixMonthOpenPeriod().getBean();
		this.actionsaddedwithin6monthperiod = vo.getActionsAddedWithin6MonthPeriod();
		this.quarterhistory = vo.getQuarterHistory() == null ? null : vo.getQuarterHistory().getBeanCollection();
		this.eyesinordernumber = vo.getEyesInOrderNumber() == null ? null : (ims.core.vo.beans.EyesInOrderNumberVoBean)vo.getEyesInOrderNumber().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ActionPlanVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.datecommenced = vo.getDateCommenced() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateCommenced().getBean();
		this.ordernumber = vo.getOrderNumber();
		this.datecompleted = vo.getDateCompleted() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateCompleted().getBean();
		this.comment = vo.getComment();
		this.recall = vo.getRecall() == null ? null : (ims.vo.LookupInstanceBean)vo.getRecall().getBean();
		this.recallin = vo.getRecallIn();
		this.recallperiod = vo.getRecallPeriod() == null ? null : (ims.vo.LookupInstanceBean)vo.getRecallPeriod().getBean();
		this.actions = vo.getActions() == null ? null : vo.getActions().getBeanCollection();
		this.ncpcomment = vo.getNcpComment();
		this.naesreferral = vo.getNAESReferral() == null ? null : (ims.naes.vo.beans.NAESReferralVoBean)vo.getNAESReferral().getBean(map);
		this.sclera = vo.getSclera();
		this.quarteryear = vo.getQuarterYear();
		this.finalcure = vo.getFinalCure();
		this.batchnumber = vo.getBatchNumber();
		this.sixmonthopenperiod = vo.getSixMonthOpenPeriod() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSixMonthOpenPeriod().getBean();
		this.actionsaddedwithin6monthperiod = vo.getActionsAddedWithin6MonthPeriod();
		this.quarterhistory = vo.getQuarterHistory() == null ? null : vo.getQuarterHistory().getBeanCollection();
		this.eyesinordernumber = vo.getEyesInOrderNumber() == null ? null : (ims.core.vo.beans.EyesInOrderNumberVoBean)vo.getEyesInOrderNumber().getBean(map);
	}

	public ims.core.vo.ActionPlanVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ActionPlanVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ActionPlanVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ActionPlanVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ActionPlanVo();
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
	public ims.framework.utils.beans.DateBean getDateCommenced()
	{
		return this.datecommenced;
	}
	public void setDateCommenced(ims.framework.utils.beans.DateBean value)
	{
		this.datecommenced = value;
	}
	public String getOrderNumber()
	{
		return this.ordernumber;
	}
	public void setOrderNumber(String value)
	{
		this.ordernumber = value;
	}
	public ims.framework.utils.beans.DateBean getDateCompleted()
	{
		return this.datecompleted;
	}
	public void setDateCompleted(ims.framework.utils.beans.DateBean value)
	{
		this.datecompleted = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.vo.LookupInstanceBean getRecall()
	{
		return this.recall;
	}
	public void setRecall(ims.vo.LookupInstanceBean value)
	{
		this.recall = value;
	}
	public Integer getRecallIn()
	{
		return this.recallin;
	}
	public void setRecallIn(Integer value)
	{
		this.recallin = value;
	}
	public ims.vo.LookupInstanceBean getRecallPeriod()
	{
		return this.recallperiod;
	}
	public void setRecallPeriod(ims.vo.LookupInstanceBean value)
	{
		this.recallperiod = value;
	}
	public ims.naes.vo.beans.ActionDetailVoBean[] getActions()
	{
		return this.actions;
	}
	public void setActions(ims.naes.vo.beans.ActionDetailVoBean[] value)
	{
		this.actions = value;
	}
	public String getNcpComment()
	{
		return this.ncpcomment;
	}
	public void setNcpComment(String value)
	{
		this.ncpcomment = value;
	}
	public ims.naes.vo.beans.NAESReferralVoBean getNAESReferral()
	{
		return this.naesreferral;
	}
	public void setNAESReferral(ims.naes.vo.beans.NAESReferralVoBean value)
	{
		this.naesreferral = value;
	}
	public String getSclera()
	{
		return this.sclera;
	}
	public void setSclera(String value)
	{
		this.sclera = value;
	}
	public Integer getQuarterYear()
	{
		return this.quarteryear;
	}
	public void setQuarterYear(Integer value)
	{
		this.quarteryear = value;
	}
	public String getFinalCure()
	{
		return this.finalcure;
	}
	public void setFinalCure(String value)
	{
		this.finalcure = value;
	}
	public String getBatchNumber()
	{
		return this.batchnumber;
	}
	public void setBatchNumber(String value)
	{
		this.batchnumber = value;
	}
	public ims.framework.utils.beans.DateBean getSixMonthOpenPeriod()
	{
		return this.sixmonthopenperiod;
	}
	public void setSixMonthOpenPeriod(ims.framework.utils.beans.DateBean value)
	{
		this.sixmonthopenperiod = value;
	}
	public Boolean getActionsAddedWithin6MonthPeriod()
	{
		return this.actionsaddedwithin6monthperiod;
	}
	public void setActionsAddedWithin6MonthPeriod(Boolean value)
	{
		this.actionsaddedwithin6monthperiod = value;
	}
	public ims.naes.vo.beans.ActionPlanQuarterVoBean[] getQuarterHistory()
	{
		return this.quarterhistory;
	}
	public void setQuarterHistory(ims.naes.vo.beans.ActionPlanQuarterVoBean[] value)
	{
		this.quarterhistory = value;
	}
	public ims.core.vo.beans.EyesInOrderNumberVoBean getEyesInOrderNumber()
	{
		return this.eyesinordernumber;
	}
	public void setEyesInOrderNumber(ims.core.vo.beans.EyesInOrderNumberVoBean value)
	{
		this.eyesinordernumber = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean datecommenced;
	private String ordernumber;
	private ims.framework.utils.beans.DateBean datecompleted;
	private String comment;
	private ims.vo.LookupInstanceBean recall;
	private Integer recallin;
	private ims.vo.LookupInstanceBean recallperiod;
	private ims.naes.vo.beans.ActionDetailVoBean[] actions;
	private String ncpcomment;
	private ims.naes.vo.beans.NAESReferralVoBean naesreferral;
	private String sclera;
	private Integer quarteryear;
	private String finalcure;
	private String batchnumber;
	private ims.framework.utils.beans.DateBean sixmonthopenperiod;
	private Boolean actionsaddedwithin6monthperiod;
	private ims.naes.vo.beans.ActionPlanQuarterVoBean[] quarterhistory;
	private ims.core.vo.beans.EyesInOrderNumberVoBean eyesinordernumber;
}
