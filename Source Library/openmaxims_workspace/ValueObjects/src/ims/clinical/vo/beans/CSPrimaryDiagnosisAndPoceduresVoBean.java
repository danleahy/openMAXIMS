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

package ims.clinical.vo.beans;

public class CSPrimaryDiagnosisAndPoceduresVoBean extends ims.vo.ValueObjectBean
{
	public CSPrimaryDiagnosisAndPoceduresVoBean()
	{
	}
	public CSPrimaryDiagnosisAndPoceduresVoBean(ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo vo)
	{
		this.primaryprocedures = vo.getPrimaryProcedures() == null ? null : vo.getPrimaryProcedures().getBeanCollection();
		this.primarydiagnosis = vo.getPrimaryDiagnosis() == null ? null : vo.getPrimaryDiagnosis().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo vo)
	{
		this.primaryprocedures = vo.getPrimaryProcedures() == null ? null : vo.getPrimaryProcedures().getBeanCollection();
		this.primarydiagnosis = vo.getPrimaryDiagnosis() == null ? null : vo.getPrimaryDiagnosis().getBeanCollection();
	}

	public ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.CSPrimaryDiagnosisAndPoceduresVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.clinical.vo.beans.CSPatientSummaryProcedureVoBean[] getPrimaryProcedures()
	{
		return this.primaryprocedures;
	}
	public void setPrimaryProcedures(ims.clinical.vo.beans.CSPatientSummaryProcedureVoBean[] value)
	{
		this.primaryprocedures = value;
	}
	public ims.clinical.vo.beans.CSPatientSummaryDiagnosisVoBean[] getPrimaryDiagnosis()
	{
		return this.primarydiagnosis;
	}
	public void setPrimaryDiagnosis(ims.clinical.vo.beans.CSPatientSummaryDiagnosisVoBean[] value)
	{
		this.primarydiagnosis = value;
	}

	private ims.clinical.vo.beans.CSPatientSummaryProcedureVoBean[] primaryprocedures;
	private ims.clinical.vo.beans.CSPatientSummaryDiagnosisVoBean[] primarydiagnosis;
}
