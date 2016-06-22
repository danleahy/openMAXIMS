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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.70 build 3478.14513)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.icp.domain.base.impl.BaseBringIntoScopeImpl;
import ims.icp.vo.ICPActionLiteVo;
import ims.icp.vo.ICPActionVo;
import ims.icp.vo.ICPConfigurationDisplayVo;
import ims.icp.vo.ICPPhaseDisplayVo;
import ims.icp.vo.ICPPhaseVo;
import ims.icp.vo.ICPStageDisplayVo;
import ims.icp.vo.ICPStageVo;
import ims.icp.vo.ICPVo;
import ims.icp.vo.PatientICPActionFullVo;
import ims.icp.vo.PatientICPActionFullVoCollection;
import ims.icp.vo.PatientICPActionStatusVo;
import ims.icp.vo.PatientICPActionStatusVoCollection;
import ims.icp.vo.PatientICPFullVo;
import ims.icp.vo.PatientICPPhaseStatusVo;
import ims.icp.vo.PatientICPPhaseStatusVoCollection;
import ims.icp.vo.PatientICPPhasesFullVo;
import ims.icp.vo.PatientICPPhasesFullVoCollection;
import ims.icp.vo.PatientICPStageStatusVo;
import ims.icp.vo.PatientICPStageStatusVoCollection;
import ims.icp.vo.PatientICPStagesFullVo;
import ims.icp.vo.PatientICPStagesFullVoCollection;
import ims.icp.vo.domain.ICPConfigurationDisplayVoAssembler;
import ims.icp.vo.domain.ICPPhaseVoAssembler;
import ims.icp.vo.domain.ICPStageDisplayVoAssembler;
import ims.icp.vo.domain.ICPStageVoAssembler;
import ims.icp.vo.domain.ICPVoAssembler;
import ims.icp.vo.domain.PatientICPFullVoAssembler;
import ims.icp.vo.domain.PatientICPPhasesFullVoAssembler;
import ims.icp.vo.domain.PatientICPShortVoAssembler;
import ims.icp.vo.domain.PatientICPStagesFullVoAssembler;
import ims.icp.vo.lookups.ICPActionStatus;
import ims.icp.vo.lookups.ICPPhaseStatus;
import ims.icp.vo.lookups.ICPStageStatus;
import ims.icps.configuration.domain.objects.ICP;
import ims.icps.configuration.domain.objects.ICPPhase;
import ims.icps.configuration.domain.objects.ICPStage;
import ims.icps.configuration.vo.ICPActionRefVo;
import ims.icps.configuration.vo.ICPPhaseRefVo;
import ims.icps.configuration.vo.ICPRefVo;
import ims.icps.configuration.vo.ICPStageRefVo;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.icps.instantiation.domain.objects.PatientICPAction;
import ims.icps.instantiation.domain.objects.PatientICPPhase;
import ims.icps.instantiation.domain.objects.PatientICPStage;
import ims.icps.instantiation.domain.objects.PatientICPStageStatus;
import ims.icps.instantiation.vo.PatientICPPhaseRefVo;
import ims.icps.instantiation.vo.PatientICPRefVo;
import ims.icps.instantiation.vo.PatientICPStageRefVo;

public class BringIntoScopeImpl extends BaseBringIntoScopeImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * getPatientICPShort
	 */
	public ims.icp.vo.PatientICPShortVo getPatientICPShort(ims.icps.instantiation.vo.PatientICPRefVo patientICPRef) throws ims.domain.exceptions.DomainInterfaceException
	{
		// Check patient ICP param
		if (patientICPRef == null || !patientICPRef.getID_PatientICPIsNotNull())
			throw new CodingRuntimeException("PatientICPRefVo is null or has a null ID !");

		return PatientICPShortVoAssembler.create((PatientICP) getDomainFactory().getDomainObject(PatientICP.class, patientICPRef.getID_PatientICP()));
	}

	/**
	 * get configuration ICP
	 */
	public ICPConfigurationDisplayVo getConfigurationICP(ICPRefVo refICP) throws DomainInterfaceException
	{
		if (refICP == null || !refICP.getID_ICPIsNotNull())
		{
			return null;
		}

		ICP doICP = (ICP) getDomainFactory().getDomainObject(ICP.class, refICP.getID_ICP());
		return ICPConfigurationDisplayVoAssembler.create(doICP);
	}

	/**
	 * bringStageIntoScope
	 */
	public void bringStageIntoScope(PatientICPRefVo patientICPRef, ICPStageRefVo stageRef) throws DomainInterfaceException, StaleObjectException
	{
		// Check parameters
		if (patientICPRef == null || stageRef == null)
			throw new CodingRuntimeException("Major Logical Error - Can not bring into scope on null Patient ICP or null stage");

		if (!patientICPRef.getID_PatientICPIsNotNull() || !stageRef.getID_ICPStageIsNotNull())
			throw new CodingRuntimeException("Major Logical Error - Missing ID on Patient ICP or stage");

		// Check for actions
		if (!hasActions(patientICPRef, stageRef))
			throw new DomainInterfaceException("The given phase has no actions and it can not be brought into scope");

		// Get domain factory
		DomainFactory domainFactory = getDomainFactory();

		// Get Patient ICP domain object
		PatientICP patientICP = (PatientICP) domainFactory.getDomainObject(PatientICP.class, patientICPRef.getID_PatientICP());

		// Bring phase into scope
		patientICP.bringStageIntoScope(domainFactory, null, stageRef.getID_ICPStage().toString());

		// Save Patient ICP
		domainFactory.save(patientICP);
	}

	/**
	 * 
	 * @param patientICPRef
	 * @param stageRef
	 * @return
	 */
	private boolean hasActions(PatientICPRefVo patientICPRef, ICPStageRefVo stageRef)
	{
		// Check parameters
		if (stageRef == null || !stageRef.getID_ICPStageIsNotNull())
			return false;

		// Get domain factory
		DomainFactory domainFactory = getDomainFactory();

		// Get the ICP Phase
		ICPStageDisplayVo icpStage = ICPStageDisplayVoAssembler.create((ICPStage) domainFactory.getDomainObject(ICPStage.class, stageRef.getID_ICPStage()));

		// Check for active actions
		for (ICPPhaseDisplayVo phase : icpStage.getPhases())
		{
			if (phase == null || !PreActiveActiveInactiveStatus.ACTIVE.equals(phase.getStatus()))
				continue;
			
			for (ICPActionLiteVo action : phase.getActions())
			{
				if (PreActiveActiveInactiveStatus.ACTIVE.equals(action.getStatus()))
					return true;
			}
		}

		// Check for PatientICP
		if (patientICPRef == null || !patientICPRef.getID_PatientICPIsNotNull())
			return false;

		// Get the Patient ICP
		PatientICPFullVo patientICP = PatientICPFullVoAssembler.create((PatientICP) domainFactory.getDomainObject(PatientICP.class, patientICPRef.getID_PatientICP()));

		// Check for actions
		for (PatientICPStagesFullVo stage : patientICP.getStages())
		{
			if (!stageRef.equals(stage.getStage()))
				continue;

			for (PatientICPPhasesFullVo phase : stage.getStagePhases())
			{
				if (phase.getPhaseActionsIsNotNull() && phase.getPhaseActions().size() > 0)
					return true;
			}
		}

		return false;
	}

	/**
	 * bringPhaseIntoScope
	 */
	public void bringPhaseIntoScope(PatientICPRefVo patientICPRef, ICPPhaseRefVo phaseRef) throws DomainInterfaceException, StaleObjectException
	{
		// Check parameters
		if (patientICPRef == null || phaseRef == null)
			throw new CodingRuntimeException("Major Logical Error - Can not bring into scope on null Patient ICP or null stage");

		if (!patientICPRef.getID_PatientICPIsNotNull() || !phaseRef.getID_ICPPhaseIsNotNull())
			throw new CodingRuntimeException("Major Logical Error - Missing ID on Patient ICP or phase");

		// Check for actions
		if (!hasActions(patientICPRef, phaseRef))
			throw new DomainInterfaceException("The given phase has no actions and it can not be brought into scope");

		// Get domain factory
		DomainFactory domainFactory = getDomainFactory();

		// Get Patient ICP domain object
		PatientICP patientICP = (PatientICP) domainFactory.getDomainObject(PatientICP.class, patientICPRef.getID_PatientICP());

		// Bring phase into scope
		patientICP.bringPhaseIntoScope(domainFactory, null, phaseRef.getID_ICPPhase().toString());

		// Save Patient ICP
		domainFactory.save(patientICP);
	}

	/**
	 * 
	 * @param patientICPRef
	 * @param phaseRef
	 * @return
	 */
	private boolean hasActions(PatientICPRefVo patientICPRef, ICPPhaseRefVo phaseRef)
	{
		// Check parameters
		if (phaseRef == null || !phaseRef.getID_ICPPhaseIsNotNull())
			return false;

		// Get domain factory
		DomainFactory domainFactory = getDomainFactory();

		// Get the ICP Phase
		ICPPhaseVo icpPhase = ICPPhaseVoAssembler.create((ICPPhase) domainFactory.getDomainObject(ICPPhase.class, phaseRef.getID_ICPPhase()));

		// Check for active actions
		for (ICPActionLiteVo action : icpPhase.getActions())
		{
			if (PreActiveActiveInactiveStatus.ACTIVE.equals(action.getStatus()))
				return true;
		}

		// Check for PatientICP
		if (patientICPRef == null || !patientICPRef.getID_PatientICPIsNotNull())
			return false;

		// Get the Patient ICP
		PatientICPFullVo patientICP = PatientICPFullVoAssembler.create((PatientICP) domainFactory.getDomainObject(PatientICP.class, patientICPRef.getID_PatientICP()));

		// Check for actions
		for (PatientICPStagesFullVo stage : patientICP.getStages())
		{
			for (PatientICPPhasesFullVo phase : stage.getStagePhases())
			{
				if (!phaseRef.equals(phase.getPhase()))
					continue;

				if (phase.getPhaseActionsIsNotNull() && phase.getPhaseActions().size() > 0)
					return true;
			}
		}

		return false;
	}

}
