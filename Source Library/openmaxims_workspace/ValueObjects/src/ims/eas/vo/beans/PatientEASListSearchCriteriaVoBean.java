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

public class PatientEASListSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public PatientEASListSearchCriteriaVoBean()
	{
	}
	public PatientEASListSearchCriteriaVoBean(ims.eas.vo.PatientEASListSearchCriteriaVo vo)
	{
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.showcancelled = vo.getShowCancelled();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.PatientEASListSearchCriteriaVo vo)
	{
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.showcancelled = vo.getShowCancelled();
	}

	public ims.eas.vo.PatientEASListSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.eas.vo.PatientEASListSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.PatientEASListSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.eas.vo.PatientEASListSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.eas.vo.PatientEASListSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public Boolean getShowCancelled()
	{
		return this.showcancelled;
	}
	public void setShowCancelled(Boolean value)
	{
		this.showcancelled = value;
	}

	private ims.vo.RefVoBean patient;
	private Boolean showcancelled;
}
