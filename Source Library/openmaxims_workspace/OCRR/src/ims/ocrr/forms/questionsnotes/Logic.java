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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.53 build 2651.24225)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.ocrr.forms.questionsnotes;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.Sex;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.ocrr.helper.MyOrderQuestionsPopulation;
import ims.vo.interfaces.IQuestionNotes;
public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initiliaze();// 	WDEV-15737
		populateDetails();
	}

	// 	WDEV-15737
	private void initiliaze() 
	{
		form.lyrDisplay().tabSummaryClinicalInformation().setHeaderVisible(ConfigFlag.UI.ORDERING_DISPLAY_SUMMARY_CLINICAL_INFO.getValue());
	}

	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	
	private void populateDetails() throws PresentationLogicException
	{
		IQuestionNotes questionNotes = form.getGlobalContext().OCRR.getQuestionsNotes();
		if(questionNotes != null)
		{
			MyOrderQuestionsPopulation helper = getMyOrderQuestionPopulationHelperFactory();
			helper.populate(questionNotes.getClinicalInfo());
	
			form.lyrDisplay().tabQuestionsNotes().txtNotes().setValue(questionNotes.getAdditClinNotes());
			
			if(ConfigFlag.UI.ORDERING_DISPLAY_SUMMARY_CLINICAL_INFO.getValue())// 	WDEV-15737, WDEV-15765
			{
				form.lyrDisplay().tabSummaryClinicalInformation().txtSummary().setValue(questionNotes.getSummaryClinicalInformation());
			}
			
			form.lyrDisplay().tabReasonReOrder().setHeaderVisible(questionNotes.getReOrderMessages() != null && questionNotes.getReOrderMessages().length > 0);// 	WDEV-16503
			if(questionNotes.getReOrderMessages() != null)// 	WDEV-16503
			{
				form.lyrDisplay().tabReasonReOrder().htmMessage().setHTML(getReOrderMessages(questionNotes.getReOrderMessages()));
			}
		}
	}
	
	// 	WDEV-16503
	private String getReOrderMessages(String[] reOrderMessages) 
	{
		if(reOrderMessages == null)
			return null;
		
		String message = "";
		
		for(int i = 0; i<reOrderMessages.length; i++)
		{
			message += reOrderMessages[i] + "<br><br>";
		}
		
		return message.length() > 0 ? message : null;
	}

	private MyOrderQuestionsPopulation getMyOrderQuestionPopulationHelperFactory()
	{
		PatientShort voPatShort = form.getGlobalContext().OCRR.getQuestionsNotes().getPatient();
		Integer age = voPatShort != null ? voPatShort.calculateAge() : null;
		Sex sex = voPatShort != null ? voPatShort.getSex() : null;

		return new MyOrderQuestionsPopulation(form.lyrDisplay().tabQuestionsNotes().dyngrdQuestions(), form.getImages().OCRR.Question, form.getImages().OCRR.Information, form.getImages().Core.MandatoryQuestion, form.getImages().OCRR.Investigation, age, sex, engine);
	}
}
