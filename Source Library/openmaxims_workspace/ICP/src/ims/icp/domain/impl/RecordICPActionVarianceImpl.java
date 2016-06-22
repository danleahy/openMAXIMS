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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3434.21163)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.icp.domain.impl;

import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.icp.domain.base.impl.BaseRecordICPActionVarianceImpl;
import ims.icp.vo.PatientICPActionStatusVo;
import ims.icp.vo.domain.PatientICPActionStatusVoAssembler;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.vo.PatientICPRefVo;

public class RecordICPActionVarianceImpl extends BaseRecordICPActionVarianceImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* updateStatusDetails
	*/
	public void updateStatusDetails(PatientICPRefVo patientICP, PatientICPActionStatusVo actionStatus) throws DomainInterfaceException, StaleObjectException
	{
		if(actionStatus == null || actionStatus.getID_PatientICPActionStatus() == null)
			throw new CodingRuntimeException("PatientICPActionStatusVo is null or has a null ID !");
		
		if (patientICP == null || patientICP.getID_PatientICP() == null)
			throw new CodingRuntimeException("Patient ICP is invalid.");
		

		DomainFactory factory = getDomainFactory();
		
		PatientICP domPatientICP = (PatientICP) factory.getDomainObject(PatientICP.class, patientICP.getID_PatientICP());
		
		if (domPatientICP.getCompletedDateTime() != null)
			throw new StaleObjectException(domPatientICP);
		
		factory.save(PatientICPActionStatusVoAssembler.extractPatientICPActionStatus(factory, actionStatus));
	}
}
