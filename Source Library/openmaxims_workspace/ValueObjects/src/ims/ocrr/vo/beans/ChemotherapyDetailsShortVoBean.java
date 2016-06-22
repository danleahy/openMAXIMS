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

package ims.ocrr.vo.beans;

public class ChemotherapyDetailsShortVoBean extends ims.vo.ValueObjectBean
{
	public ChemotherapyDetailsShortVoBean()
	{
	}
	public ChemotherapyDetailsShortVoBean(ims.ocrr.vo.ChemotherapyDetailsShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.drugtherapytype = vo.getDrugTherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDrugTherapyType().getBean();
		this.regimenacronym = vo.getRegimenAcronym() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegimenAcronym().getBean();
		this.cancertreatementintent = vo.getCancerTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerTreatementIntent().getBean();
		this.treatmentresponse = vo.getTreatmentResponse() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentResponse().getBean();
		this.treatingconsultant = vo.getTreatingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTreatingConsultant().getBean();
		this.txchangereason = vo.getTxChangeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTxChangeReason().getBean();
		this.pretreatsurfacearea = vo.getPreTreatSurfaceArea();
		this.creatinineclearance = vo.getCreatinineClearance();
		this.heightvaluecm = vo.getHeightValueCM();
		this.weightvaluekg = vo.getWeightValueKG();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.ChemotherapyDetailsShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.episodeofcare = vo.getEpisodeOfCare() == null ? null : new ims.vo.RefVoBean(vo.getEpisodeOfCare().getBoId(), vo.getEpisodeOfCare().getBoVersion());
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.datedecisiontotreat = vo.getDateDecisionToTreat() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateDecisionToTreat().getBean();
		this.drugtherapytype = vo.getDrugTherapyType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDrugTherapyType().getBean();
		this.regimenacronym = vo.getRegimenAcronym() == null ? null : (ims.vo.LookupInstanceBean)vo.getRegimenAcronym().getBean();
		this.cancertreatementintent = vo.getCancerTreatementIntent() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerTreatementIntent().getBean();
		this.treatmentresponse = vo.getTreatmentResponse() == null ? null : (ims.vo.LookupInstanceBean)vo.getTreatmentResponse().getBean();
		this.treatingconsultant = vo.getTreatingConsultant() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getTreatingConsultant().getBean(map);
		this.txchangereason = vo.getTxChangeReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getTxChangeReason().getBean();
		this.pretreatsurfacearea = vo.getPreTreatSurfaceArea();
		this.creatinineclearance = vo.getCreatinineClearance();
		this.heightvaluecm = vo.getHeightValueCM();
		this.weightvaluekg = vo.getWeightValueKG();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
	}

	public ims.ocrr.vo.ChemotherapyDetailsShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.ChemotherapyDetailsShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.ChemotherapyDetailsShortVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.ChemotherapyDetailsShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.ChemotherapyDetailsShortVo();
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
	public ims.vo.RefVoBean getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.vo.RefVoBean value)
	{
		this.episodeofcare = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getDateDecisionToTreat()
	{
		return this.datedecisiontotreat;
	}
	public void setDateDecisionToTreat(ims.framework.utils.beans.DateBean value)
	{
		this.datedecisiontotreat = value;
	}
	public ims.vo.LookupInstanceBean getDrugTherapyType()
	{
		return this.drugtherapytype;
	}
	public void setDrugTherapyType(ims.vo.LookupInstanceBean value)
	{
		this.drugtherapytype = value;
	}
	public ims.vo.LookupInstanceBean getRegimenAcronym()
	{
		return this.regimenacronym;
	}
	public void setRegimenAcronym(ims.vo.LookupInstanceBean value)
	{
		this.regimenacronym = value;
	}
	public ims.vo.LookupInstanceBean getCancerTreatementIntent()
	{
		return this.cancertreatementintent;
	}
	public void setCancerTreatementIntent(ims.vo.LookupInstanceBean value)
	{
		this.cancertreatementintent = value;
	}
	public ims.vo.LookupInstanceBean getTreatmentResponse()
	{
		return this.treatmentresponse;
	}
	public void setTreatmentResponse(ims.vo.LookupInstanceBean value)
	{
		this.treatmentresponse = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getTreatingConsultant()
	{
		return this.treatingconsultant;
	}
	public void setTreatingConsultant(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.treatingconsultant = value;
	}
	public ims.vo.LookupInstanceBean getTxChangeReason()
	{
		return this.txchangereason;
	}
	public void setTxChangeReason(ims.vo.LookupInstanceBean value)
	{
		this.txchangereason = value;
	}
	public Float getPreTreatSurfaceArea()
	{
		return this.pretreatsurfacearea;
	}
	public void setPreTreatSurfaceArea(Float value)
	{
		this.pretreatsurfacearea = value;
	}
	public Float getCreatinineClearance()
	{
		return this.creatinineclearance;
	}
	public void setCreatinineClearance(Float value)
	{
		this.creatinineclearance = value;
	}
	public Float getHeightValueCM()
	{
		return this.heightvaluecm;
	}
	public void setHeightValueCM(Float value)
	{
		this.heightvaluecm = value;
	}
	public Float getWeightValueKG()
	{
		return this.weightvaluekg;
	}
	public void setWeightValueKG(Float value)
	{
		this.weightvaluekg = value;
	}
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean episodeofcare;
	private ims.vo.RefVoBean carecontext;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean datedecisiontotreat;
	private ims.vo.LookupInstanceBean drugtherapytype;
	private ims.vo.LookupInstanceBean regimenacronym;
	private ims.vo.LookupInstanceBean cancertreatementintent;
	private ims.vo.LookupInstanceBean treatmentresponse;
	private ims.core.vo.beans.HcpLiteVoBean treatingconsultant;
	private ims.vo.LookupInstanceBean txchangereason;
	private Float pretreatsurfacearea;
	private Float creatinineclearance;
	private Float heightvaluecm;
	private Float weightvaluekg;
	private ims.vo.LookupInstanceBean status;
}
