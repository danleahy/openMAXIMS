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
public interface AcceptTransferToWardDlg extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo saveTransferIn(ims.core.vo.BedSpaceStateLiteVo voOldBedSpaceStateLite, ims.core.vo.InPatientEpisodeADTVo voInpatientEpisode, ims.core.vo.PendingTransfersLiteVo voPending, ims.core.vo.HomeLeaveVo voHL, ims.core.vo.PatientCaseNoteTransferVoCollection collPatientCaseNoteTransfer) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.InPatientEpisodeADTVo getInpatientEpisodeADT(ims.core.admin.pas.vo.InpatientEpisodeRefVo inpatientEpisodeRef);

	// Generated from form domain interface definition
	public ims.core.vo.WardConfigLiteVo getWardConfig(ims.core.resource.place.vo.LocationRefVo locationRef);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceLiteVoCollection listServices(String serviceName);

	// Generated from form domain interface definition
	/**
	* getCaseNoteFolders
	*/
	public ims.core.vo.PatientCaseNoteVoCollection getCaseNoteFolders(ims.core.patient.vo.PatientRefVo patientRef, ims.core.resource.place.vo.LocationRefVo locationRef);

	// Generated from form domain interface definition
	public Boolean isCaseNoteFolderLocation(ims.core.patient.vo.PatientRefVo patientRef);
}
