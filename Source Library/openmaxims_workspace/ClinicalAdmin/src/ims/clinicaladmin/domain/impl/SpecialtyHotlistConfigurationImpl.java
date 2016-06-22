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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.45 build 2315.17237)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.clinicaladmin.domain.impl;

import ims.clinical.configuration.domain.objects.DiagnosisHotlist;
import ims.clinical.configuration.domain.objects.ProblemHotlist;
import ims.clinical.configuration.domain.objects.ProcedureHotlist;
import ims.clinical.configuration.domain.objects.CancerImagingHotlist;
import ims.clinicaladmin.domain.base.impl.BaseSpecialtyHotlistConfigurationImpl;
import ims.clinicaladmin.vo.domain.CancerImagingHotlistShortVoAssembler;
import ims.clinicaladmin.vo.domain.CancerImagingHotlistVoAssembler;
import ims.clinicaladmin.vo.domain.DiagnosisHotListShortVoAssembler;
import ims.clinicaladmin.vo.domain.DiagnosisHotListVoAssembler;
import ims.clinicaladmin.vo.domain.ProblemHotlistShortVoAssembler;
import ims.clinicaladmin.vo.domain.ProblemHotlistVoAssembler;
import ims.clinicaladmin.vo.domain.ProcedureHotlistShortVoAssembler;
import ims.clinicaladmin.vo.domain.ProcedureHotlistVoAssembler;
import ims.clinicaladmin.vo.enums.CciType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.vo.interfaces.IHotlist;
import ims.vo.interfaces.IHotlistShort;


public class SpecialtyHotlistConfigurationImpl extends BaseSpecialtyHotlistConfigurationImpl
{
	private static final long serialVersionUID = 1L;

	/** 
	 * Gets the hotlist associated with the given Hotlist ID and CciType
	 * @param Integer
	 * @param CciType
	 * @return IHotlist
	 * @author mmccarthy 
	 */
	public IHotlist getIHotlist(Integer hotlistID, CciType cciType)
	{
		DomainFactory factory = getDomainFactory();
		
		if ( cciType.equals(CciType.PROCEDURE))
		{
			return ProcedureHotlistVoAssembler.create((ProcedureHotlist) factory.getDomainObject(ProcedureHotlist.class, hotlistID));
		}
		else if ( cciType.equals(CciType.PROBLEM) )
		{
			return ProblemHotlistVoAssembler.create((ProblemHotlist)factory.getDomainObject(ProblemHotlist.class, hotlistID));
		}
		else if ( cciType.equals(CciType.DIAGNOSIS) )
		{
			return DiagnosisHotListVoAssembler.create((DiagnosisHotlist) getDomainFactory().getDomainObject(DiagnosisHotlist.class, hotlistID));
		}
		else if ( cciType.equals(CciType.CANCERIMAGE) )
		{
			return CancerImagingHotlistVoAssembler.create((CancerImagingHotlist) getDomainFactory().getDomainObject(CancerImagingHotlist.class, hotlistID));
		}
		else 
		{
			throw new DomainRuntimeException ("Unknown CciType in getIHotlist = " + cciType.toString());
		}
	}
	
	/** 
	 * Gets the hotlist short associated with the given Hotlist ID and CciType
	 * @param Integer
	 * @param CciType
	 * @return IHotlistShort
	 * @author mmccarthy
	 */
	public IHotlistShort getIHotlistShort(Integer hotlistID, CciType cciType)
	{
		DomainFactory factory = getDomainFactory();
		
		if ( cciType.equals(CciType.PROCEDURE))
		{
			return ProcedureHotlistShortVoAssembler.create((ProcedureHotlist) factory.getDomainObject(ProcedureHotlist.class, hotlistID));
		}
		else if ( cciType.equals(CciType.PROBLEM) )
		{
			return ProblemHotlistShortVoAssembler.create((ProblemHotlist)factory.getDomainObject(ProblemHotlist.class, hotlistID));
		}
		else if ( cciType.equals(CciType.DIAGNOSIS) )
		{
			return DiagnosisHotListShortVoAssembler.create((DiagnosisHotlist) getDomainFactory().getDomainObject(DiagnosisHotlist.class, hotlistID));
		}
		else if ( cciType.equals(CciType.CANCERIMAGE) )
		{
			return CancerImagingHotlistShortVoAssembler.create((CancerImagingHotlist) getDomainFactory().getDomainObject(CancerImagingHotlist.class, hotlistID));
		}
		else 
		{
			throw new DomainRuntimeException ("Unknown CciType in getIHotlistShort = " + cciType.toString());
		}
	}
	
	/**
	 * Lists IHotlistShorts based on a give CciType
	 * @param CciType
	 * @return IHotlistShort[]
	 * @author mmccarthy
	 */
	public IHotlistShort[] listIHotlistShorts(CciType cciType)
	{
		DomainFactory factory = getDomainFactory();
		
		if ( cciType.equals(CciType.PROCEDURE))
		{
			return ProcedureHotlistShortVoAssembler.createProcedureHotlistShortVoCollectionFromProcedureHotlist(factory.listDomainObjects(ProcedureHotlist.class)).toIHotlistShortArray();	
		}
		else if ( cciType.equals(CciType.PROBLEM) )
		{
			return ProblemHotlistShortVoAssembler.createProblemHotlistShortVoCollectionFromProblemHotlist(factory.listDomainObjects(ProblemHotlist.class)).toIHotlistShortArray();
		}
		else if ( cciType.equals(CciType.DIAGNOSIS) )
		{
			return DiagnosisHotListShortVoAssembler.createDiagnosisHotListShortVoCollectionFromDiagnosisHotlist(factory.listDomainObjects(DiagnosisHotlist.class)).toIHotlistShortArray();
		}
		else if ( cciType.equals(CciType.CANCERIMAGE) )
		{
			return CancerImagingHotlistShortVoAssembler.createCancerImagingHotlistShortVoCollectionFromCancerImagingHotlist(factory.listDomainObjects(CancerImagingHotlist.class)).toIHotlistShortArray();
		}
		else 
		{
			throw new DomainRuntimeException ("Unknown CciType in listIHotlistShorts = " + cciType.toString());
		}
	}
}
