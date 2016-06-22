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

package ims.clinicaladmin.domain;

// Generated from form domain impl
public interface CancerStagingClassifications extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* saveStagingClassification
	*/
	public ims.clinicaladmin.vo.StagingClassificationVo saveStagingClassification(ims.clinicaladmin.vo.StagingClassificationVo stagingVo) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* geStagingClassification
	*/
	public ims.clinicaladmin.vo.StagingClassificationVo getStagingClassification(ims.oncology.configuration.vo.StagingClassificationRefVo stagingRefVo);

	// Generated from form domain interface definition
	/**
	* listStagingClassification
	*/
	public ims.clinicaladmin.vo.StagingClassificationVoCollection listStagingClassification(Boolean bActive);

	// Generated from form domain interface definition
	/**
	* list Tumour Groups for this classification
	*/
	public ims.clinicaladmin.vo.TumourGroupListVoCollection listTumourGroupForClassification(ims.oncology.configuration.vo.StagingClassificationRefVo classRefVo);

	// Generated from form domain interface definition
	/**
	* saveTumourGroup
	*/
	public ims.clinicaladmin.vo.TumourGroupListVo saveTumourGroup(ims.clinicaladmin.vo.TumourGroupListVo tumourgroupVo) throws ims.domain.exceptions.StaleObjectException;
}
