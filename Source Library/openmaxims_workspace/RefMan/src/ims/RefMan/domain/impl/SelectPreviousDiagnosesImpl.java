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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.ArrayList;

import ims.RefMan.domain.base.impl.BaseSelectPreviousDiagnosesImpl;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.domain.PatientDiagnosisListVoAssembler;
import ims.domain.DomainFactory;

public class SelectPreviousDiagnosesImpl extends BaseSelectPreviousDiagnosesImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.PatientDiagnosisListVoCollection listDiagnosis(CareContextRefVo careContextRefVo, PatientRefVo patRef)
	{
		DomainFactory factory = getDomainFactory();
		
		String hql = new String();
		hql = "select patdiag from PatientDiagnosis as patdiag left join patdiag.episodeOfCare as epcare left join epcare.careSpell as carespell left join carespell.patient as pat";

		StringBuffer condStr = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		String andStr = " ";
		
		condStr.append(andStr + " patdiag.careContext.id <> :carecontextId");
		markers.add("carecontextId");
		values.add(careContextRefVo.getID_CareContext());
		andStr = " and ";	
		
		condStr.append(andStr + " pat.id = :PatID");
		markers.add("PatID");
		values.add(patRef.getID_Patient());
		andStr = " and ";	
		

		hql += " where ";
		hql += condStr.toString();
		return PatientDiagnosisListVoAssembler.createPatientDiagnosisListVoCollectionFromPatientDiagnosis(factory.find(hql,markers,values)).sort();
	}
}
