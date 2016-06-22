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

package ims.generalmedical.vo.beans;

public class InjuryDetailsVoBean extends ims.vo.ValueObjectBean
{
	public InjuryDetailsVoBean()
	{
	}
	public InjuryDetailsVoBean(ims.generalmedical.vo.InjuryDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.injurydate = vo.getInjuryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInjuryDate().getBean();
		this.injurytime = vo.getInjuryTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getInjuryTime().getBean();
		this.referraldate = vo.getReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDate().getBean();
		this.transferdate = vo.getTransferDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTransferDate().getBean();
		this.sufferedloc = vo.getSufferedLOC();
		this.durloc = vo.getDurLOC();
		this.durlocunit = vo.getDurLOCUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDurLOCUnit().getBean();
		this.requiresventillation = vo.getRequiresVentillation() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequiresVentillation().getBean();
		this.descriptionofinjury = vo.getDescriptionOfInjury();
		this.presentingcomplaints = vo.getPresentingComplaints();
		this.associatedfactor = vo.getAssociatedFactor() == null ? null : vo.getAssociatedFactor().getBeanCollection();
		this.modeofinjury = vo.getModeOfInjury() == null ? null : (ims.vo.LookupInstanceBean)vo.getModeOfInjury().getBean();
		this.causeofinjury = vo.getCauseOfInjury() == null ? null : (ims.vo.LookupInstanceBean)vo.getCauseOfInjury().getBean();
		this.mechanismofinjury = vo.getMechanismOfInjury() == null ? null : (ims.vo.LookupInstanceBean)vo.getMechanismOfInjury().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.generalmedical.vo.InjuryDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.injurydate = vo.getInjuryDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getInjuryDate().getBean();
		this.injurytime = vo.getInjuryTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getInjuryTime().getBean();
		this.referraldate = vo.getReferralDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getReferralDate().getBean();
		this.transferdate = vo.getTransferDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTransferDate().getBean();
		this.sufferedloc = vo.getSufferedLOC();
		this.durloc = vo.getDurLOC();
		this.durlocunit = vo.getDurLOCUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getDurLOCUnit().getBean();
		this.requiresventillation = vo.getRequiresVentillation() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequiresVentillation().getBean();
		this.descriptionofinjury = vo.getDescriptionOfInjury();
		this.presentingcomplaints = vo.getPresentingComplaints();
		this.associatedfactor = vo.getAssociatedFactor() == null ? null : vo.getAssociatedFactor().getBeanCollection();
		this.modeofinjury = vo.getModeOfInjury() == null ? null : (ims.vo.LookupInstanceBean)vo.getModeOfInjury().getBean();
		this.causeofinjury = vo.getCauseOfInjury() == null ? null : (ims.vo.LookupInstanceBean)vo.getCauseOfInjury().getBean();
		this.mechanismofinjury = vo.getMechanismOfInjury() == null ? null : (ims.vo.LookupInstanceBean)vo.getMechanismOfInjury().getBean();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getClinicalContact().getBean(map);
	}

	public ims.generalmedical.vo.InjuryDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.generalmedical.vo.InjuryDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.generalmedical.vo.InjuryDetailsVo vo = null;
		if(map != null)
			vo = (ims.generalmedical.vo.InjuryDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.generalmedical.vo.InjuryDetailsVo();
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
	public ims.framework.utils.beans.DateBean getInjuryDate()
	{
		return this.injurydate;
	}
	public void setInjuryDate(ims.framework.utils.beans.DateBean value)
	{
		this.injurydate = value;
	}
	public ims.framework.utils.beans.TimeBean getInjuryTime()
	{
		return this.injurytime;
	}
	public void setInjuryTime(ims.framework.utils.beans.TimeBean value)
	{
		this.injurytime = value;
	}
	public ims.framework.utils.beans.DateBean getReferralDate()
	{
		return this.referraldate;
	}
	public void setReferralDate(ims.framework.utils.beans.DateBean value)
	{
		this.referraldate = value;
	}
	public ims.framework.utils.beans.DateBean getTransferDate()
	{
		return this.transferdate;
	}
	public void setTransferDate(ims.framework.utils.beans.DateBean value)
	{
		this.transferdate = value;
	}
	public Boolean getSufferedLOC()
	{
		return this.sufferedloc;
	}
	public void setSufferedLOC(Boolean value)
	{
		this.sufferedloc = value;
	}
	public Integer getDurLOC()
	{
		return this.durloc;
	}
	public void setDurLOC(Integer value)
	{
		this.durloc = value;
	}
	public ims.vo.LookupInstanceBean getDurLOCUnit()
	{
		return this.durlocunit;
	}
	public void setDurLOCUnit(ims.vo.LookupInstanceBean value)
	{
		this.durlocunit = value;
	}
	public ims.vo.LookupInstanceBean getRequiresVentillation()
	{
		return this.requiresventillation;
	}
	public void setRequiresVentillation(ims.vo.LookupInstanceBean value)
	{
		this.requiresventillation = value;
	}
	public String getDescriptionOfInjury()
	{
		return this.descriptionofinjury;
	}
	public void setDescriptionOfInjury(String value)
	{
		this.descriptionofinjury = value;
	}
	public String getPresentingComplaints()
	{
		return this.presentingcomplaints;
	}
	public void setPresentingComplaints(String value)
	{
		this.presentingcomplaints = value;
	}
	public ims.generalmedical.vo.beans.AssociatedFactorVoBean[] getAssociatedFactor()
	{
		return this.associatedfactor;
	}
	public void setAssociatedFactor(ims.generalmedical.vo.beans.AssociatedFactorVoBean[] value)
	{
		this.associatedfactor = value;
	}
	public ims.vo.LookupInstanceBean getModeOfInjury()
	{
		return this.modeofinjury;
	}
	public void setModeOfInjury(ims.vo.LookupInstanceBean value)
	{
		this.modeofinjury = value;
	}
	public ims.vo.LookupInstanceBean getCauseOfInjury()
	{
		return this.causeofinjury;
	}
	public void setCauseOfInjury(ims.vo.LookupInstanceBean value)
	{
		this.causeofinjury = value;
	}
	public ims.vo.LookupInstanceBean getMechanismOfInjury()
	{
		return this.mechanismofinjury;
	}
	public void setMechanismOfInjury(ims.vo.LookupInstanceBean value)
	{
		this.mechanismofinjury = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.clinicalcontact = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean injurydate;
	private ims.framework.utils.beans.TimeBean injurytime;
	private ims.framework.utils.beans.DateBean referraldate;
	private ims.framework.utils.beans.DateBean transferdate;
	private Boolean sufferedloc;
	private Integer durloc;
	private ims.vo.LookupInstanceBean durlocunit;
	private ims.vo.LookupInstanceBean requiresventillation;
	private String descriptionofinjury;
	private String presentingcomplaints;
	private ims.generalmedical.vo.beans.AssociatedFactorVoBean[] associatedfactor;
	private ims.vo.LookupInstanceBean modeofinjury;
	private ims.vo.LookupInstanceBean causeofinjury;
	private ims.vo.LookupInstanceBean mechanismofinjury;
	private ims.core.vo.beans.ClinicalContactShortVoBean clinicalcontact;
}
