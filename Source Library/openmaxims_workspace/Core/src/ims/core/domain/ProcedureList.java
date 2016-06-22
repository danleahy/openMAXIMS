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

package ims.core.domain;

// Generated from form domain impl
public interface ProcedureList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Save a ProcedureVo
	*/
	public ims.core.vo.ProcedureVo saveProcedureVo(ims.core.vo.ProcedureVo voProcedureVo, Boolean bNoLocationServiceActivityChecks) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Get a ProcedureVo record
	*/
	public ims.core.vo.ProcedureVo getProcedureVo(ims.core.clinical.vo.ProcedureRefVo voProcedureVo);

	// Generated from form domain interface definition
	/**
	* A list call returning any LocationServiceActivity for a Procedure that the user wants to make inactive
	*/
	public ims.core.vo.LocationServiceActivityVoCollection listProcedureinLocationServiceActivity(ims.core.vo.ActivityVo voActivity);

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureLiteVoCollection listActiveProcedures(String filter) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureLiteVoCollection listAllProcedures(String filter) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureVo saveProcedureLite(ims.core.vo.ProcedureLiteVo procVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureVoCollection listActiveFullProcedures(String filter) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* isProcedureExported
	*/
	public Boolean isProcedureExported(ims.core.vo.ProcedureVo procVo);

	// Generated from form domain interface definition
	/**
	* updateServiceActivityExportRecords
	*/
	public Boolean updateServiceActivityExportRecords(ims.core.vo.ProcedureVo procVo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	public ims.ntpf.vo.ServiceActivityExportVoCollection listServiceActivityExports() throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* listProcedureinServiceActivity
	*/
	public ims.core.vo.ServiceActivityVoCollection listProcedureinServiceActivity(ims.core.vo.ActivityVo activityVo);
}
