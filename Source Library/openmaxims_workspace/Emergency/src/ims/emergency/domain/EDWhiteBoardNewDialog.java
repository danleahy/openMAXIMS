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

package ims.emergency.domain;

// Generated from form domain impl
public interface EDWhiteBoardNewDialog extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingAreaShortVoCollection listTrackingAreas(ims.framework.interfaces.ILocation edLoc);

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingForPatientWhiteBoardVoCollection listTrackingPatients(ims.emergency.vo.TrackingAreaShortVo trackingArea, ims.emergency.vo.lookups.TrackingStatus trackingStatus, ims.framework.interfaces.ILocation edLoc);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatientShort(ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextShortVo getCareContextShort(ims.core.admin.vo.CareContextRefVo careContextRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.WhiteBoardConfigVo getEDWhiteBoardConfigByArea(ims.emergency.configuration.vo.TrackingAreaRefVo areaRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.PatientWhiteboardRecordVo getPatientWhiteBoard(ims.core.admin.vo.CareContextRefVo careContextRef, ims.core.patient.vo.PatientRefVo patientRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.PatientAssessmentForWhiteboardVo getPatientAssessment(ims.core.admin.vo.CareContextRefVo careContextRef, ims.assessment.configuration.vo.UserAssessmentRefVo userAssessmentRef);

	// Generated from form domain interface definition
	public ims.emergency.vo.PatientWhiteboardActionsVo savePatientWhiteBoardActionVo(ims.emergency.vo.PatientWhiteboardActionsVo patientWhiteBoardActionVoToSave) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.emergency.vo.PatientWhiteboardRecordVo savePatientWhiteBoard(ims.emergency.vo.PatientWhiteboardRecordVo patientWhiteBoardToSave) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.emergency.vo.PatientWhiteboardActionsVo getPatientWhiteBoardAction(ims.emergency.vo.PatientWhiteboardRecordVo patientWhiteBoard, ims.emergency.vo.WhiteBoardOtherActionsVo whiteBoardOtherAction);

	// Generated from form domain interface definition
	public ims.emergency.vo.TrackingAreaShortVo getTrackingArea(ims.emergency.configuration.vo.TrackingAreaRefVo trackingAreaRef);
}
