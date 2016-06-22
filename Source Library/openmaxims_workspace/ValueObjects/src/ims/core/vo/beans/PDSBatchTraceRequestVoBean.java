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

public class PDSBatchTraceRequestVoBean extends ims.vo.ValueObjectBean
{
	public PDSBatchTraceRequestVoBean()
	{
	}
	public PDSBatchTraceRequestVoBean(ims.core.vo.PDSBatchTraceRequestVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.sdsroleprofileid = vo.getSDSRoleProfileId();
		this.sdsuserid = vo.getSDSUserId();
		this.pdsack = vo.getPDSAck() == null ? null : (ims.vo.LookupInstanceBean)vo.getPDSAck().getBean();
		this.pdsackdetailtype = vo.getPDSAckDetailType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPDSAckDetailType().getBean();
		this.active = vo.getActive();
		this.comment = vo.getComment();
		this.requesttype = vo.getRequestType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequestType().getBean();
		this.requestdate = vo.getRequestDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequestDate().getBean();
		this.pdsackexception = vo.getPDSAckException();
		this.retrycount = vo.getRetryCount();
		this.convid = vo.getConvId() == null ? null : new ims.vo.RefVoBean(vo.getConvId().getBoId(), vo.getConvId().getBoVersion());
		this.sdsjobrolecode = vo.getSDSJobRoleCode();
		this.pdsbatchtraceitems = vo.getPDSBatchTraceItems() == null ? null : vo.getPDSBatchTraceItems().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PDSBatchTraceRequestVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.sdsroleprofileid = vo.getSDSRoleProfileId();
		this.sdsuserid = vo.getSDSUserId();
		this.pdsack = vo.getPDSAck() == null ? null : (ims.vo.LookupInstanceBean)vo.getPDSAck().getBean();
		this.pdsackdetailtype = vo.getPDSAckDetailType() == null ? null : (ims.vo.LookupInstanceBean)vo.getPDSAckDetailType().getBean();
		this.active = vo.getActive();
		this.comment = vo.getComment();
		this.requesttype = vo.getRequestType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequestType().getBean();
		this.requestdate = vo.getRequestDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequestDate().getBean();
		this.pdsackexception = vo.getPDSAckException();
		this.retrycount = vo.getRetryCount();
		this.convid = vo.getConvId() == null ? null : new ims.vo.RefVoBean(vo.getConvId().getBoId(), vo.getConvId().getBoVersion());
		this.sdsjobrolecode = vo.getSDSJobRoleCode();
		this.pdsbatchtraceitems = vo.getPDSBatchTraceItems() == null ? null : vo.getPDSBatchTraceItems().getBeanCollection();
	}

	public ims.core.vo.PDSBatchTraceRequestVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PDSBatchTraceRequestVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PDSBatchTraceRequestVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PDSBatchTraceRequestVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PDSBatchTraceRequestVo();
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
	public String getSDSRoleProfileId()
	{
		return this.sdsroleprofileid;
	}
	public void setSDSRoleProfileId(String value)
	{
		this.sdsroleprofileid = value;
	}
	public String getSDSUserId()
	{
		return this.sdsuserid;
	}
	public void setSDSUserId(String value)
	{
		this.sdsuserid = value;
	}
	public ims.vo.LookupInstanceBean getPDSAck()
	{
		return this.pdsack;
	}
	public void setPDSAck(ims.vo.LookupInstanceBean value)
	{
		this.pdsack = value;
	}
	public ims.vo.LookupInstanceBean getPDSAckDetailType()
	{
		return this.pdsackdetailtype;
	}
	public void setPDSAckDetailType(ims.vo.LookupInstanceBean value)
	{
		this.pdsackdetailtype = value;
	}
	public Boolean getActive()
	{
		return this.active;
	}
	public void setActive(Boolean value)
	{
		this.active = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}
	public ims.vo.LookupInstanceBean getRequestType()
	{
		return this.requesttype;
	}
	public void setRequestType(ims.vo.LookupInstanceBean value)
	{
		this.requesttype = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRequestDate()
	{
		return this.requestdate;
	}
	public void setRequestDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.requestdate = value;
	}
	public String getPDSAckException()
	{
		return this.pdsackexception;
	}
	public void setPDSAckException(String value)
	{
		this.pdsackexception = value;
	}
	public Integer getRetryCount()
	{
		return this.retrycount;
	}
	public void setRetryCount(Integer value)
	{
		this.retrycount = value;
	}
	public ims.vo.RefVoBean getConvId()
	{
		return this.convid;
	}
	public void setConvId(ims.vo.RefVoBean value)
	{
		this.convid = value;
	}
	public String getSDSJobRoleCode()
	{
		return this.sdsjobrolecode;
	}
	public void setSDSJobRoleCode(String value)
	{
		this.sdsjobrolecode = value;
	}
	public ims.core.vo.beans.PDSBatchTraceItemsVoBean[] getPDSBatchTraceItems()
	{
		return this.pdsbatchtraceitems;
	}
	public void setPDSBatchTraceItems(ims.core.vo.beans.PDSBatchTraceItemsVoBean[] value)
	{
		this.pdsbatchtraceitems = value;
	}

	private Integer id;
	private int version;
	private String sdsroleprofileid;
	private String sdsuserid;
	private ims.vo.LookupInstanceBean pdsack;
	private ims.vo.LookupInstanceBean pdsackdetailtype;
	private Boolean active;
	private String comment;
	private ims.vo.LookupInstanceBean requesttype;
	private ims.framework.utils.beans.DateTimeBean requestdate;
	private String pdsackexception;
	private Integer retrycount;
	private ims.vo.RefVoBean convid;
	private String sdsjobrolecode;
	private ims.core.vo.beans.PDSBatchTraceItemsVoBean[] pdsbatchtraceitems;
}
