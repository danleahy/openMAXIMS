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

public class InititPatAndPDSPATForJobVoBean extends ims.vo.ValueObjectBean
{
	public InititPatAndPDSPATForJobVoBean()
	{
	}
	public InititPatAndPDSPATForJobVoBean(ims.core.vo.InititPatAndPDSPATForJobVo vo)
	{
		this.initialpatient = vo.getInitialPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getInitialPatient().getBean();
		this.pdspatient = vo.getPDSPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPDSPatient().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.InititPatAndPDSPATForJobVo vo)
	{
		this.initialpatient = vo.getInitialPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getInitialPatient().getBean(map);
		this.pdspatient = vo.getPDSPatient() == null ? null : (ims.core.vo.beans.PatientBean)vo.getPDSPatient().getBean(map);
	}

	public ims.core.vo.InititPatAndPDSPATForJobVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.InititPatAndPDSPATForJobVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.InititPatAndPDSPATForJobVo vo = null;
		if(map != null)
			vo = (ims.core.vo.InititPatAndPDSPATForJobVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.InititPatAndPDSPATForJobVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.PatientBean getInitialPatient()
	{
		return this.initialpatient;
	}
	public void setInitialPatient(ims.core.vo.beans.PatientBean value)
	{
		this.initialpatient = value;
	}
	public ims.core.vo.beans.PatientBean getPDSPatient()
	{
		return this.pdspatient;
	}
	public void setPDSPatient(ims.core.vo.beans.PatientBean value)
	{
		this.pdspatient = value;
	}

	private ims.core.vo.beans.PatientBean initialpatient;
	private ims.core.vo.beans.PatientBean pdspatient;
}
