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

public class ReferralLiteVoBean extends ims.vo.ValueObjectBean
{
	public ReferralLiteVoBean()
	{
	}
	public ReferralLiteVoBean(ims.core.vo.ReferralLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.referralreceiveddate = vo.getReferralReceivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralReceivedDate().getBean();
		this.originalreferraldate = vo.getOriginalReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getOriginalReferralDate().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.details = vo.getDetails();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.extreferralkey = vo.getExtReferralKey();
		this.clockid = vo.getClockId();
		this.catsreferraldetails = vo.getCatsReferralDetails() == null ? null : (ims.RefMan.vo.beans.CatsReferralForJourneyVoBean)vo.getCatsReferralDetails().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ReferralLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.authoringdatetime = vo.getAuthoringDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAuthoringDateTime().getBean();
		this.referralreceiveddate = vo.getReferralReceivedDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralReceivedDate().getBean();
		this.originalreferraldate = vo.getOriginalReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getOriginalReferralDate().getBean();
		this.referraltype = vo.getReferralType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralType().getBean();
		this.details = vo.getDetails();
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.extreferralkey = vo.getExtReferralKey();
		this.clockid = vo.getClockId();
		this.catsreferraldetails = vo.getCatsReferralDetails() == null ? null : (ims.RefMan.vo.beans.CatsReferralForJourneyVoBean)vo.getCatsReferralDetails().getBean(map);
	}

	public ims.core.vo.ReferralLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ReferralLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ReferralLiteVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ReferralLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ReferralLiteVo();
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
	public ims.framework.utils.beans.DateTimeBean getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.authoringdatetime = value;
	}
	public ims.framework.utils.beans.DateBean getReferralReceivedDate()
	{
		return this.referralreceiveddate;
	}
	public void setReferralReceivedDate(ims.framework.utils.beans.DateBean value)
	{
		this.referralreceiveddate = value;
	}
	public ims.framework.utils.beans.DateBean getOriginalReferralDate()
	{
		return this.originalreferraldate;
	}
	public void setOriginalReferralDate(ims.framework.utils.beans.DateBean value)
	{
		this.originalreferraldate = value;
	}
	public ims.vo.LookupInstanceBean getReferralType()
	{
		return this.referraltype;
	}
	public void setReferralType(ims.vo.LookupInstanceBean value)
	{
		this.referraltype = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public String getExtReferralKey()
	{
		return this.extreferralkey;
	}
	public void setExtReferralKey(String value)
	{
		this.extreferralkey = value;
	}
	public String getClockId()
	{
		return this.clockid;
	}
	public void setClockId(String value)
	{
		this.clockid = value;
	}
	public ims.RefMan.vo.beans.CatsReferralForJourneyVoBean getCatsReferralDetails()
	{
		return this.catsreferraldetails;
	}
	public void setCatsReferralDetails(ims.RefMan.vo.beans.CatsReferralForJourneyVoBean value)
	{
		this.catsreferraldetails = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean authoringdatetime;
	private ims.framework.utils.beans.DateBean referralreceiveddate;
	private ims.framework.utils.beans.DateBean originalreferraldate;
	private ims.vo.LookupInstanceBean referraltype;
	private String details;
	private ims.vo.RefVoBean patient;
	private String extreferralkey;
	private String clockid;
	private ims.RefMan.vo.beans.CatsReferralForJourneyVoBean catsreferraldetails;
}
