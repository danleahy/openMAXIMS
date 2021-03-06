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

package ims.clinicaladmin.vo.beans;

public class SelectedRecordForOverallStagingDialogVoBean extends ims.vo.ValueObjectBean
{
	public SelectedRecordForOverallStagingDialogVoBean()
	{
	}
	public SelectedRecordForOverallStagingDialogVoBean(ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo vo)
	{
		this.tnmvalues = vo.getTNMValues() == null ? null : vo.getTNMValues().getBeanCollection();
		this.histologyvalue = vo.getHistologyValue() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean)vo.getHistologyValue().getBean();
		this.serummarker = vo.getSerumMarker() == null ? null : (ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean)vo.getSerumMarker().getBean();
		this.over45 = vo.getOver45();
		this.differentationvalue = vo.getDifferentationValue() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)vo.getDifferentationValue().getBean();
		this.overallvalue = vo.getOverallValue() == null ? null : (ims.vo.LookupInstanceBean)vo.getOverallValue().getBean();
		this.selectedsiterecord = vo.getSelectedSiteRecord() == null ? null : new ims.vo.RefVoBean(vo.getSelectedSiteRecord().getBoId(), vo.getSelectedSiteRecord().getBoVersion());
		this.selectedgrouprecord = vo.getSelectedGroupRecord() == null ? null : new ims.vo.RefVoBean(vo.getSelectedGroupRecord().getBoId(), vo.getSelectedGroupRecord().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo vo)
	{
		this.tnmvalues = vo.getTNMValues() == null ? null : vo.getTNMValues().getBeanCollection();
		this.histologyvalue = vo.getHistologyValue() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean)vo.getHistologyValue().getBean(map);
		this.serummarker = vo.getSerumMarker() == null ? null : (ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean)vo.getSerumMarker().getBean(map);
		this.over45 = vo.getOver45();
		this.differentationvalue = vo.getDifferentationValue() == null ? null : (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)vo.getDifferentationValue().getBean(map);
		this.overallvalue = vo.getOverallValue() == null ? null : (ims.vo.LookupInstanceBean)vo.getOverallValue().getBean();
		this.selectedsiterecord = vo.getSelectedSiteRecord() == null ? null : new ims.vo.RefVoBean(vo.getSelectedSiteRecord().getBoId(), vo.getSelectedSiteRecord().getBoVersion());
		this.selectedgrouprecord = vo.getSelectedGroupRecord() == null ? null : new ims.vo.RefVoBean(vo.getSelectedGroupRecord().getBoId(), vo.getSelectedGroupRecord().getBoVersion());
	}

	public ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo vo = null;
		if(map != null)
			vo = (ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinicaladmin.vo.SelectedRecordForOverallStagingDialogVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean[] getTNMValues()
	{
		return this.tnmvalues;
	}
	public void setTNMValues(ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean[] value)
	{
		this.tnmvalues = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean getHistologyValue()
	{
		return this.histologyvalue;
	}
	public void setHistologyValue(ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean value)
	{
		this.histologyvalue = value;
	}
	public ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean getSerumMarker()
	{
		return this.serummarker;
	}
	public void setSerumMarker(ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean value)
	{
		this.serummarker = value;
	}
	public Boolean getOver45()
	{
		return this.over45;
	}
	public void setOver45(Boolean value)
	{
		this.over45 = value;
	}
	public ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean getDifferentationValue()
	{
		return this.differentationvalue;
	}
	public void setDifferentationValue(ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean value)
	{
		this.differentationvalue = value;
	}
	public ims.vo.LookupInstanceBean getOverallValue()
	{
		return this.overallvalue;
	}
	public void setOverallValue(ims.vo.LookupInstanceBean value)
	{
		this.overallvalue = value;
	}
	public ims.vo.RefVoBean getSelectedSiteRecord()
	{
		return this.selectedsiterecord;
	}
	public void setSelectedSiteRecord(ims.vo.RefVoBean value)
	{
		this.selectedsiterecord = value;
	}
	public ims.vo.RefVoBean getSelectedGroupRecord()
	{
		return this.selectedgrouprecord;
	}
	public void setSelectedGroupRecord(ims.vo.RefVoBean value)
	{
		this.selectedgrouprecord = value;
	}

	private ims.clinicaladmin.vo.beans.TumourGroupSiteTNMValueListVoBean[] tnmvalues;
	private ims.clinicaladmin.vo.beans.TumourGroupHistologyVoBean histologyvalue;
	private ims.clinicaladmin.vo.beans.TumourSerumMarkersLiteVoBean serummarker;
	private Boolean over45;
	private ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean differentationvalue;
	private ims.vo.LookupInstanceBean overallvalue;
	private ims.vo.RefVoBean selectedsiterecord;
	private ims.vo.RefVoBean selectedgrouprecord;
}
