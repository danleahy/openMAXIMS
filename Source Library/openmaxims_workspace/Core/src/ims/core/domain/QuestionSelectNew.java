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
public interface QuestionSelectNew extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* Question Add/Update
	*/
	public ims.core.vo.QuestionInformationVo saveQuestion(ims.core.vo.QuestionInformationVo questionInfo) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	/**
	* Add/Save a Lookup Instance
	*/
	public ims.vo.LookupInstanceCollection saveLookupInstance(ims.vo.LookupTypeVo type, ims.vo.LookupInstVo instance) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.vo.LookupInstVo deactivateInstance(ims.vo.LookupTypeVo type, ims.vo.LookupInstVo voInstance) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get Lookup Instances
	*/
	public ims.vo.LookupInstanceCollection getLookupInstances(ims.vo.LookupTypeVo type);

	// Generated from form domain interface definition
	/**
	* List Question
	*/
	public ims.core.vo.QuestionInformationShortVoCollection listQuestion(ims.core.vo.QuestionInformationVo filter);

	// Generated from form domain interface definition
	public ims.core.vo.QuestionInformationVo getQuestion(Integer idQuestion);

	// Generated from form domain interface definition
	/**
	* list Questions using Question Information Filter
	*/
	public ims.core.vo.QuestionInformationShortVoCollection listQuestion(ims.core.vo.lookups.QuestionClassification classification, ims.core.vo.lookups.QuestionType questionType, String text, ims.core.vo.lookups.PreActiveActiveInactiveStatus status, Boolean isQuestion, Boolean isShortText);

	// Generated from form domain interface definition
	/**
	* Counts the number of questions
	*/
	public Integer countQuestion(ims.core.vo.lookups.QuestionClassificationCollection classification, ims.core.vo.lookups.QuestionType questionType, String text, ims.core.vo.lookups.PreActiveActiveInactiveStatus status, Boolean isQuestion);

	// Generated from form domain interface definition
	/**
	* list Questions using Question Information Filter
	*/
	public ims.core.vo.QuestionInformationShortVoCollection listQuestionExcludeInactive(ims.core.vo.lookups.QuestionClassification classification, ims.core.vo.lookups.QuestionType questionType, String text, Boolean isQuestion, Boolean isShortText);

	// Generated from form domain interface definition
	/**
	* Counts the number of questions
	*/
	public Integer countQuestionExcludeInactive(ims.core.vo.lookups.QuestionClassificationCollection classification, ims.core.vo.lookups.QuestionType questionType, String text, Boolean isQuestion);
}
