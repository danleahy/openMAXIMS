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

package ims.nursing.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseMetricImpl extends DomainImpl implements ims.nursing.domain.Metric, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistPatientMetrics(ims.core.patient.vo.PatientRefVo patRef, ims.framework.utils.DateTime dteFrom, ims.framework.utils.DateTime dteTo)
	{
		if(patRef == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patRef' of type 'ims.core.patient.vo.PatientRefVo' cannot be null.");
		if(dteFrom == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'dteFrom' of type 'ims.framework.utils.DateTime' cannot be null.");
		if(dteTo == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'dteTo' of type 'ims.framework.utils.DateTime' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesave(ims.core.vo.VSMetrics metric)
	{
		if(metric == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'metric' of type 'ims.core.vo.VSMetrics' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validategetLastRecordedHeight(ims.core.patient.vo.PatientRefVo patientRef)
	{
		if(patientRef == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'patientRef' of type 'ims.core.patient.vo.PatientRefVo' cannot be null.");
	}
}
