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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.62 build 3126.20282)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.atconsultation;

import ims.RefMan.helper.CatsReferralReportBuilder;
import ims.RefMan.vo.CatsReferralDetailsVo;
import ims.RefMan.vo.CatsReferralFlaggedForReviewVo;
import ims.RefMan.vo.ClinicalContactTimeVo;
import ims.RefMan.vo.ConsultationDetailsVo;
import ims.RefMan.vo.ConsultationTimeVo;
import ims.RefMan.vo.WorkAllocationVo;
import ims.RefMan.vo.enums.AtConsultationSelectedTab;
import ims.RefMan.vo.enums.ReferralAppointmentDetailsAction;
import ims.RefMan.vo.enums.ReferralReviewDetail;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.enums.DocumentViewLevel;
import ims.core.vo.enums.UploadDocumentStoreLevel;
import ims.core.vo.lookups.Language;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.LayerBridge;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVoCollection;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.zip.CRC32;

import com.ims.query.builder.client.exceptions.QueryBuilderClientException;
import com.ims.query.server.ResultCollection;
import com.ims.query.server.ResultHolder;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final Integer CATS_FINAL_REPORT_ID = 130;
	private static final Integer RESULT_INVESTIGATION_REPORT = 309;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		initialiseTabs();
		String lang=domain.getInterpretersLanguage(form.getGlobalContext().RefMan.getCatsReferral());
		if (lang!=null&&!(lang.equals(Language.OTHER.toString())))
		{
			form.btnInterpreters().setVisible(true);
			form.btnInterpreters().setEnabled(true);
			form.getGlobalContext().RefMan.setLanguage(lang);
		}
		else if (lang!=null&&lang.equals(Language.OTHER.toString()))
		{
			form.btnInterpreters().setVisible(true);
			form.btnInterpreters().setEnabled(true);
			form.getGlobalContext().RefMan.setLanguage(domain.getInterpretersOtherLanguage(form.getGlobalContext().RefMan.getCatsReferral()));
		}
		else
			form.btnInterpreters().setVisible(false);
		
		form.getLocalContext().setSelectedRecord(domain.getConsultation(form.getGlobalContext().RefMan.getCatsReferral()));
		
	 	if ( (form.getGlobalContext().RefMan.getIsClinicalContactStartedIsNotNull()
	 			&& form.getGlobalContext().RefMan.getIsClinicalContactStarted())
	 		|| (form.getGlobalContext().RefMan.getIsConsultationStartedIsNotNull()
	 				&& 	form.getGlobalContext().RefMan.getIsConsultationStarted()) )
	 	{
	 		form.btnPatientContact().setVisible(true);
	 		form.btnPatientContact().setEnabled(true);
	 	}
	 	else
	 	{
	 		form.btnPatientContact().setVisible(false);
	 		form.btnPatientContact().setEnabled(false);
	 	}
	 
		//wdev-6163
		if(form.getGlobalContext().RefMan.getIsProviderCancellationIsNotNull()
			&& 	form.getGlobalContext().RefMan.getIsProviderCancellation())
		{
			form.btnPatientContact().setVisible(false);
			form.btn1().setVisible(false);
			
			form.lyr1().tabReferralLetter().customControlUploadDoc().setMode(FormMode.VIEW);
		}
		
		if(!engine.hasRight(AppRight.ALLOW_ORDERINVESTIGATIONS_CAREUK))
			form.btn1().setVisible(false);
			
		updateReviewButton();		
			
		openWorkAllocation();
	}

	private void openWorkAllocation() 
	{
		form.btnCompleteTask().setVisible(false);
		form.getLocalContext().setWorkAllocation(null);
		if (form.getGlobalContext().RefMan.getCatsReferralIsNotNull() &&
				domain.getMosUser() != null &&
				 ((MemberOfStaffRefVo)domain.getMosUser()).getID_MemberOfStaffIsNotNull())
		{
			WorkAllocationVo voWork = domain.getWorkAllocation(form.getGlobalContext().RefMan.getCatsReferral(),(MemberOfStaffRefVo)domain.getMosUser());
			if (voWork != null)
			{
				form.btnCompleteTask().setVisible(true);
				form.getLocalContext().setWorkAllocation(voWork);
			}
		}
	}

	private void initialiseTabs()
	{
		form.lyr1().tabReferralLetter().customControlUploadDoc().initialize(null, UploadDocumentStoreLevel.REFERRAL,DocumentViewLevel.REFERRAL);			
		form.lyr1().tabReferralLetter().customControlUploadDoc().setMode(FormMode.EDIT);		
		form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.DOCS);
	}
	
	private void updateReviewButton()
	{		
		CatsReferralFlaggedForReviewVo vo = domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral());
		if (vo.getIsFlaggedForReviewIsNotNull() &&
				vo.getIsFlaggedForReview().equals(Boolean.TRUE))
		{
			form.btnReview().setText("Flag for Review + Review Detail");
			form.getLocalContext().setFlagForReview(ReferralReviewDetail.REVIEW);
		}
		else
		{
			form.btnReview().setText("Flag for Review");
			form.getLocalContext().setFlagForReview(ReferralReviewDetail.RECORDING);
		}
	}
	
	private void populateApptDetailComponent() 
	{
		CatsReferralDetailsVo voContainer = domain.getReferralDetail(form.getGlobalContext().RefMan.getCatsReferral());		
		form.lyr1().tabReferralAppts().ccAppts().setValue(voContainer.getAppointmentDetail());		
		
		if(voContainer != null)
		{
			ReferralApptStatus statusLookup = voContainer.getReferralApptStatus();
			setReferralAcceptedOnApptTab(statusLookup);
		}
	}

	private void setReferralAcceptedOnApptTab(ReferralApptStatus statusLookup)
	{
		if (statusLookup.equals(ReferralApptStatus.REFERRAL_ACCEPTED) 
				|| statusLookup.equals(ReferralApptStatus.FURTHER_MANAGEMENT_REQUIRED) 
				|| statusLookup.equals(ReferralApptStatus.ACTIVE_MONITORING) 
				|| statusLookup.equals(ReferralApptStatus.DISCHARGED) 
				|| statusLookup.equals(ReferralApptStatus.APPOINTMENTBOOKED))
			form.lyr1().tabReferralAppts().ccAppts().setReferralAccepted();
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
		form.setMode(FormMode.VIEW);
	}
	@Override
	protected void onBtn1Click() throws PresentationLogicException 
	{
		form.getGlobalContext().Rotherham.setAppointmentToLink(null);
		
		if(ConfigFlag.GEN.ALLOW_LINK_EXISTING_APPOINTMENTS_AND_ORDERS.getValue())
		{
			if(form.lyr1().tabReferralAppts().ccAppts().getSelectedBookedAppointment() != null && form.lyr1().tabReferralAppts().isVisible())
				form.getGlobalContext().Rotherham.setAppointmentToLink(form.lyr1().tabReferralAppts().ccAppts().getSelectedBookedAppointment());
		}	
		if( Boolean.TRUE.equals((form.lyr1().tabDischarge().isVisible())))				//wdev-15685
		{
			form.lyr1().tabDischarge().htmPreview().setVisible(false);					//wdev-15685
		}
		engine.open(form.getForms().OCRR.SelectAndOrderDialog);
		form.lyr1().tabReferralLetter().customControlUploadDoc().hideHtmlControl();
	}

	@Override
	protected void onlyr1TabChanged(LayerBridge tab) 
	{
		boolean isProviderCancellation = form.getGlobalContext().RefMan.getIsProviderCancellationIsNotNull() && form.getGlobalContext().RefMan.getIsProviderCancellation();
		
		if (tab.equals(form.lyr1().tabReferralLetter()))
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.DOCS);
			form.lyr1().tabReferralLetter().customControlUploadDoc().initialize(null, UploadDocumentStoreLevel.REFERRAL,DocumentViewLevel.REFERRAL);////WDEV-12242			
		}
		else if (tab.equals(form.lyr1().tabReferralAppts()))
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.APPTS);
			form.lyr1().tabReferralAppts().ccAppts().initialise(engine.hasRight(AppRight.ALLOW_ORDERINVESTIGATIONS_CAREUK));		
			populateApptDetailComponent();		
		}		
		else if (tab.equals(form.lyr1().tabBaselineObs()))
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.BASELINEOBS);
			form.lyr1().tabBaselineObs().ccNursingNotes().initialize();
		}
		else if (tab.equals(form.lyr1().tabPrescription()))
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.PRESCRIPTION);
			form.lyr1().tabPrescription().ccPrescription().initialize(isProviderCancellation, null);
		}
		else if (tab.equals(form.lyr1().tabAssesments()))
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.ASSESSMENTS);
			form.lyr1().tabAssesments().ccPatientSpecialtyAssessments().initialize();
		}
		else if (tab.equals(form.lyr1().tabInvestigations()))
		{
			form.lyr1().tabInvestigations().ccInvestigations().initialise(engine.hasRight(AppRight.CAN_VIEW_CONFIDENTIAL_INVESTIGATION_RESULTS), engine.hasRight(AppRight.CAN_VIEW_CONFIDENTIAL_INVESTIGATIONS_ORDERED), Boolean.TRUE);	
		}
		else if (tab.equals(form.lyr1().tabOutcome())) 
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.OUTCOME);
			form.lyr1().tabOutcome().ccOutcome().initialize(isProviderCancellation,null,null,null);
		}
		else if (tab.equals(form.lyr1().tabDischarge())) 
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.OUTCOME);
			buildFinalReport();
		}
		else if(tab.equals(form.lyr1().tabClinicalNotes()))
		{
			form.getLocalContext().setSelectedTab(AtConsultationSelectedTab.CLINICALNOTES);
			form.lyr1().tabClinicalNotes().ccClinicalNotes().initialize(isProviderCancellation);
		}
		else if (tab.equals(form.lyr1().tabNotes()))
		{
			form.lyr1().tabNotes().ccNote().initialize();
		}
		else if (tab.equals(form.lyr1().tabSpecimenCollection()))
		{
			form.lyr1().tabSpecimenCollection().ccSpecimenCollection().initialize();
		}
	}

	private void buildFinalReport() 
	{						
		try
		{
		// Get CATS Referral Discharge Report
		String[] coverReport = domain.getSystemReportAndTemplate(CATS_FINAL_REPORT_ID);
		
		// Check for report and template
		if (coverReport == null || coverReport.length < 2)
		{
			engine.showMessage("I could not get the report and template !");
			return;
		}

		if (coverReport[0] == null || coverReport[1] == null)
		{
			engine.showMessage("The report has not been deployed !");
			return;
		}

		// Get investigation report
		String[] investigationReport = domain.getSystemReportAndTemplate(RESULT_INVESTIGATION_REPORT);
		
		// Check for report and template
		if (investigationReport == null || investigationReport.length < 2)		//wdev-15070
		{
			engine.showMessage("I could not get the report and template !");
			return;
		}

		if (investigationReport[0] == null || investigationReport[1] == null)	//wdev-15070
		{
			engine.showMessage("The report has not been deployed !");
			return;
		}
		
		// Get order investigation
		OrderInvestigationRefVoCollection investigationList = domain.listInvestigations(form.getGlobalContext().RefMan.getCatsReferral());
		
		// Build CATS Referral Discharge Report (Final or Interim)
		CatsReferralReportBuilder reportBuilder = new CatsReferralReportBuilder();

		// Return content of the CATS Referral Discharge Report
		byte[] buffer = reportBuilder.getCatsReferralFinalDischargeReport(form.getGlobalContext().RefMan.getCatsReferral(), investigationList, coverReport, investigationReport, engine.getSessionId());

		
		if (buffer == null)
		{
			engine.showMessage("PDF size is zero.");
			return;
		}

			// Build checksum
			CRC32 crc = new CRC32();
			crc.reset();
			crc.update(buffer);

			// Build unique key
			String key = String.valueOf(System.currentTimeMillis());
			key += engine.getSessionId() != null ? engine.getSessionId() : "";
			key += String.valueOf(crc.getValue());

			// Add PDF byte array
			ResultCollection.putResult(key, new ResultHolder(buffer, "application/pdf"));

			// Code to preview a PDF byte array
			String urlToOpen = getQueryServerRoot() + "/ReturnAsUrlServlet?action=getResult&id=" + key + "&appservername=" + InetAddress.getLocalHost().getHostName();

			if (urlToOpen != null)
			{
				form.lyr1().tabDischarge().htmPreview().setHTML("<IFRAME id=\"PostFrame\" width=\"100%\" height=\"100%\" frameborder=0 src='" + urlToOpen + "'></IFRAME>");
			}
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return;
		}
		catch (QueryBuilderClientException e)
		{
			engine.showMessage(e.getMessage());
			return;
		} 

		catch (UnknownHostException e)
		{
			engine.showMessage("Error creating report: " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}		


	private String getQueryServerRoot()
	{
		String root = ConfigFlag.GEN.QUERY_SERVER_URL.getValue().trim();

		if (root.endsWith("/"))
			root = root.substring(0, root.length() - 1);

		if (root.endsWith("/ReportBuilder"))
		{
			int index = root.lastIndexOf("/");

			if (index > -1)
			{
				return root.substring(0, index);
			}
		}

		return root;
	}


	@Override
	protected void onBtnInterpretersClick() throws PresentationLogicException
	{

		if( Boolean.TRUE.equals((form.lyr1().tabDischarge().isVisible())))				//wdev-15685
		{
			form.lyr1().tabDischarge().htmPreview().setVisible(false);					//wdev-15685
		}
		engine.open(form.getForms().RefMan.InterpreterDetails);
		form.lyr1().tabReferralLetter().customControlUploadDoc().hideHtmlControl();
	}

	@Override
	protected void onBtnPatientContactClick() throws PresentationLogicException 
	{
		form.getLocalContext().setSelectedRecord(domain.getConsultation(form.getGlobalContext().RefMan.getCatsReferral()));

		ConsultationDetailsVo voCons = form.getLocalContext().getSelectedRecord();

		HcpLiteVo hcpVo = new HcpLiteVo();
		hcpVo.setID_Hcp(engine.getLoggedInUser().getHcpId());
		hcpVo.setMos(domain.getMosUser() != null ? (MemberOfStaffLiteVo) domain.getMosUser() : null);

		if (form.getGlobalContext().RefMan.getIsClinicalContactStartedIsNotNull()
			&& form.getGlobalContext().RefMan.getIsClinicalContactStarted())
	 	{
			boolean bUnfinishedRecord = false;
			ClinicalContactTimeVo voTime = new ClinicalContactTimeVo();
			if (voCons.getClinicalContactTimeIsNotNull())
			{
				voCons.getClinicalContactTime().sort();
				
				int index = 0;
				for(int i = 0 ; i < voCons.getClinicalContactTime().size() ; i ++)
				{
					if (voCons.getClinicalContactTime().get(i).getEndDateTime() == null)
					{
						voTime = voCons.getClinicalContactTime().get(i);
						index = i;
						bUnfinishedRecord = true;
					}
				}
				
				if ( !bUnfinishedRecord )
				{
					engine.showMessage("This Contact has been Ended by another user.");
				 	form.getGlobalContext().RefMan.setIsClinicalContactStarted(Boolean.FALSE);
				 	form.getGlobalContext().RefMan.setIsConsultationStarted(Boolean.FALSE);
			 		form.btnPatientContact().setVisible(false);
			 		form.btnPatientContact().setEnabled(false);
					return;
				}
				voTime.setEndDateTime(new DateTime());
				voTime.setEndHcp(hcpVo);

				if (voCons.getClinicalContactTime().size() == 0)
				{
					voCons.getClinicalContactTime().add(voTime);
				}
				else
				{
					voCons.getClinicalContactTime().set(index, voTime);
				}
				
				String[] error = voCons.validate();
				if (error != null)
				{
					engine.showErrors(error);
					return;
				}
				
			 	try 
			 	{
					form.getLocalContext().setSelectedRecord(domain.saveConsultation(voCons));
				} 
			 	catch (StaleObjectException e) 
			 	{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				}
			}
	 	}
	 	else if (form.getGlobalContext().RefMan.getIsConsultationStartedIsNotNull()
	 			&& form.getGlobalContext().RefMan.getIsConsultationStarted())
		{
			boolean bUnfinishedRecord = false;
			ConsultationTimeVo voTime = new ConsultationTimeVo();
			if (voCons.getConsultationTimesIsNotNull())
			{
				voCons.getConsultationTimes().sort();
				
				int index = 0;
				for(int i = 0 ; i < voCons.getConsultationTimes().size() ; i ++)
				{
					if (voCons.getConsultationTimes().get(i).getEndDateTime() == null)
					{
						voTime = voCons.getConsultationTimes().get(i);
						index = i;
						bUnfinishedRecord = true;
					}
				}
				if ( !bUnfinishedRecord )
				{
					engine.showMessage("This Consultation/Contact has been Ended by another user.");
				 	form.getGlobalContext().RefMan.setIsClinicalContactStarted(Boolean.FALSE);
				 	form.getGlobalContext().RefMan.setIsConsultationStarted(Boolean.FALSE);
			 		form.btnPatientContact().setVisible(false);
			 		form.btnPatientContact().setEnabled(false);
					return;
				}
				voTime.setEndDateTime(new DateTime());
				voTime.setEndHcp(hcpVo);

				if (voCons.getConsultationTimes().size() == 0)
				{
					voCons.getConsultationTimes().add(voTime);
				}
				else
				{
					voCons.getConsultationTimes().set(index, voTime);
				}
				String[] error = voCons.validate();
				if (error != null)
				{
					engine.showErrors(error);
					return;
				}
				
			 	try 
			 	{
					form.getLocalContext().setSelectedRecord(domain.saveConsultation(voCons));
				} 
			 	catch (StaleObjectException e) 
			 	{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
					return;
				}
			}
		}
	 	form.getGlobalContext().RefMan.setIsClinicalContactStarted(Boolean.FALSE);
	 	form.getGlobalContext().RefMan.setIsConsultationStarted(Boolean.FALSE);
 		form.btnPatientContact().setVisible(false);
 		form.btnPatientContact().setEnabled(false);
	}

	@Override
	protected void onBtnReviewClick() throws PresentationLogicException 
	{
		if(form.getLocalContext().getFlagForReviewIsNotNull())
		{
			if( Boolean.TRUE.equals((form.lyr1().tabDischarge().isVisible())))				//wdev-15685
			{
				form.lyr1().tabDischarge().htmPreview().setVisible(false);					//wdev-15685
			}
			flagForReview(form.getLocalContext().getFlagForReview());
		}		
	}
	
	private void flagForReview(ReferralReviewDetail referralReviewDetail) 
	{
		form.getGlobalContext().RefMan.setReferralReviewDetailsMode(referralReviewDetail);
		engine.open(form.getForms().RefMan.ReferralReviewDetails);
		form.lyr1().tabReferralLetter().customControlUploadDoc().hideHtmlControl();
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if (formName.equals(form.getForms().RefMan.ReferralReviewDetails))
		{
			/*if( Boolean.TRUE.equals((form.lyr1().tabDischarge().isVisible())))				//wdev-15685
			{
				form.lyr1().tabDischarge().htmPreview().setVisible(true);					//wdev-15685
			}*/
			updateReviewButton();		
		}		
		else if (formName.equals(form.getForms().OCRR.SelectAndOrderDialog) && result.equals(DialogResult.OK))
		{
			if(form.lyr1().tabReferralAppts().isVisible())
			{
				CatsReferralDetailsVo voContainer = domain.getReferralDetail(form.getGlobalContext().RefMan.getCatsReferral());		
				form.lyr1().tabReferralAppts().ccAppts().setValue(voContainer.getAppointmentDetail());		
			}
			else if (form.lyr1().tabInvestigations().isVisible())
			{
				form.lyr1().tabInvestigations().ccInvestigations().initialise(engine.hasRight(AppRight.CAN_VIEW_CONFIDENTIAL_INVESTIGATION_RESULTS), engine.hasRight(AppRight.CAN_VIEW_CONFIDENTIAL_INVESTIGATIONS_ORDERED), Boolean.TRUE);	
			}
			
			/*if( Boolean.TRUE.equals((form.lyr1().tabDischarge().isVisible())))				//wdev-15685
			{
				form.lyr1().tabDischarge().htmPreview().setVisible(true);					//wdev-15685
			}*/
		}	
		if( Boolean.TRUE.equals((form.lyr1().tabDischarge().isVisible())))				//wdev-15685
		{
			form.lyr1().tabDischarge().htmPreview().setVisible(true);					//wdev-15685
		}
		form.lyr1().tabReferralLetter().customControlUploadDoc().showHtmlControl();
		form.lyr1().tabSpecimenCollection().ccSpecimenCollection().initialize();//wdev-14020
	}	

	/*@Override
	protected void onCustomControlBaselineValueChanged()
			throws PresentationLogicException 
	{
		if (form.getGlobalContext().RefMan.getIsComponentInEditModeIsNotNull())
		{
			if (form.getGlobalContext().RefMan.getIsComponentInEditMode().equals(FormMode.EDIT))
			{
				disableTabs();				
			}
			if (form.getGlobalContext().RefMan.getIsComponentInEditMode().equals(FormMode.VIEW))
			{
				enableTabs();				
			}
		}			
	}*/
	
	@Override
	protected void onCcPatientSpecialtyAssessmentsValueChanged()
			throws PresentationLogicException 
	{
		disableOrEnableTabs();
	}

	private void enableTabs()
	{
		form.lyr1().tabReferralLetter().setHeaderEnabled(true);				
		form.lyr1().tabBaselineObs().setHeaderEnabled(true);
		form.lyr1().tabClinicalNotes().setHeaderEnabled(true);
		form.lyr1().tabInvestigations().setHeaderEnabled(true);
		form.lyr1().tabPrescription().setHeaderEnabled(true);
		form.lyr1().tabAssesments().setHeaderEnabled(true);
		form.lyr1().tabOutcome().setHeaderEnabled(true);
		form.lyr1().tabDischarge().setHeaderEnabled(true);
		form.lyr1().tabNotes().setHeaderEnabled(true);		
		form.lyr1().tabReferralAppts().setHeaderEnabled(true);
		form.lyr1().tabSpecimenCollection().setHeaderEnabled(true);
	}
	
	
	private void disableOrEnableTabs()
	{
		if (form.getLocalContext().getSelectedTabIsNotNull() && 
				form.getGlobalContext().RefMan.getIsComponentInEditModeIsNotNull())
		{
			if (form.getGlobalContext().RefMan.getIsComponentInEditMode().equals(FormMode.EDIT))
			{
				form.setMode(FormMode.EDIT);
				AtConsultationSelectedTab tab = form.getLocalContext().getSelectedTab();
				
				form.lyr1().tabReferralLetter().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.DOCS) ?  true : false);
				form.lyr1().tabBaselineObs().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.BASELINEOBS) ? true : false);				
				form.lyr1().tabClinicalNotes().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.CLINICALNOTES) ? true : false);
				form.lyr1().tabInvestigations().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.INV) ? true : false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.DISCHARGE) ? true : false);
				form.lyr1().tabNotes().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.NOTES) ? true : false);
				form.lyr1().tabReferralAppts().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.APPOINTMENTS) ? true : false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(tab.equals(AtConsultationSelectedTab.SPECIMENCOLL) ? true : false);
			}
			else
			{
				form.setMode(FormMode.VIEW);
				form.lyr1().tabReferralLetter().setHeaderEnabled(true);
				form.lyr1().tabBaselineObs().setHeaderEnabled(true);				
				form.lyr1().tabClinicalNotes().setHeaderEnabled(true);
				form.lyr1().tabInvestigations().setHeaderEnabled(true);
				form.lyr1().tabPrescription().setHeaderEnabled(true);
				form.lyr1().tabAssesments().setHeaderEnabled(true);
				form.lyr1().tabOutcome().setHeaderEnabled(true);
				form.lyr1().tabDischarge().setHeaderEnabled(true);
				form.lyr1().tabNotes().setHeaderEnabled(true);
				form.lyr1().tabReferralAppts().setHeaderEnabled(true);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(true);
			}
		}
		else
		{
			form.setMode(FormMode.VIEW);
			form.lyr1().tabReferralLetter().setHeaderEnabled(true);
			form.lyr1().tabBaselineObs().setHeaderEnabled(true);				
			form.lyr1().tabClinicalNotes().setHeaderEnabled(true);
			form.lyr1().tabInvestigations().setHeaderEnabled(true);
			form.lyr1().tabPrescription().setHeaderEnabled(true);
			form.lyr1().tabAssesments().setHeaderEnabled(true);
			form.lyr1().tabOutcome().setHeaderEnabled(true);
			form.lyr1().tabDischarge().setHeaderEnabled(true);
			form.lyr1().tabNotes().setHeaderEnabled(true);
			form.lyr1().tabReferralAppts().setHeaderEnabled(true);
			form.lyr1().tabSpecimenCollection().setHeaderEnabled(true);
		}
	}

	private void disableTabs()
	{

		form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
		form.lyr1().tabBaselineObs().setHeaderEnabled(false);
		form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
		form.lyr1().tabInvestigations().setHeaderEnabled(false);
		form.lyr1().tabPrescription().setHeaderEnabled(false);
		form.lyr1().tabAssesments().setHeaderEnabled(false);
		form.lyr1().tabOutcome().setHeaderEnabled(false);
		form.lyr1().tabDischarge().setHeaderEnabled(false);
		form.lyr1().tabNotes().setHeaderEnabled(false);		
		form.lyr1().tabReferralAppts().setHeaderEnabled(false);
		form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);

		if (form.getLocalContext().getSelectedTabIsNotNull())
		{
			AtConsultationSelectedTab tab = form.getLocalContext().getSelectedTab();
			if (tab.equals(AtConsultationSelectedTab.BASELINEOBS))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}
			else if (tab.equals(AtConsultationSelectedTab.CLINICALNOTES))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			} 
			else if (tab.equals(AtConsultationSelectedTab.INV))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			} 
			else if (tab.equals(AtConsultationSelectedTab.PRESCRIPTION))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}		
			else if (tab.equals(AtConsultationSelectedTab.ASSESSMENTS))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}
			else if (tab.equals(AtConsultationSelectedTab.OUTCOME))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}
			else if (tab.equals(AtConsultationSelectedTab.DISCHARGE))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}
			else if (tab.equals(AtConsultationSelectedTab.NOTES))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}
			else if (tab.equals(AtConsultationSelectedTab.APPOINTMENTS))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabSpecimenCollection().setHeaderEnabled(false);
			}
			else if (tab.equals(AtConsultationSelectedTab.SPECIMENCOLL))
			{
				form.lyr1().tabReferralLetter().setHeaderEnabled(false);				
				form.lyr1().tabBaselineObs().setHeaderEnabled(false);
				form.lyr1().tabClinicalNotes().setHeaderEnabled(false);
				form.lyr1().tabInvestigations().setHeaderEnabled(false);
				form.lyr1().tabPrescription().setHeaderEnabled(false);
				form.lyr1().tabAssesments().setHeaderEnabled(false);
				form.lyr1().tabOutcome().setHeaderEnabled(false);
				form.lyr1().tabDischarge().setHeaderEnabled(false);
				form.lyr1().tabNotes().setHeaderEnabled(false);		
				form.lyr1().tabReferralAppts().setHeaderEnabled(false);
			}
		}
	}

	protected void onCcApptsValueChanged() throws PresentationLogicException
	{
		if(form.lyr1().tabReferralAppts().ccAppts().getAction() != null)
		{
			if(form.lyr1().tabReferralAppts().ccAppts().getAction().equals(ReferralAppointmentDetailsAction.REFRESH))
			{
				CatsReferralDetailsVo voContainer = domain.getReferralDetail(form.getGlobalContext().RefMan.getCatsReferral());		
				form.lyr1().tabReferralAppts().ccAppts().setValue(voContainer.getAppointmentDetail());		
			}
		}
	}

	@Override
	protected void onBtnCompleteTaskClick() throws PresentationLogicException 
	{
		WorkAllocationVo voWork = form.getLocalContext().getWorkAllocation();
		
		voWork.setCompletedBy(domain.getMosUser() != null ? (MemberOfStaffRefVo) domain.getMosUser() : null);
		voWork.setCompletedDateTime(new DateTime());
		
		String[] arrErrors = voWork.validate();
		if(arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return;
		}
		try
		{
			voWork = domain.saveWorkAllocation(voWork);
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		}

		form.btnCompleteTask().setVisible(false);
	}

	@Override
	protected void onCcNursingNotesValueChanged() throws PresentationLogicException
	{
		if (form.lyr1().tabBaselineObs().ccNursingNotes().getMode().equals(FormMode.EDIT))
			disableTabs();
		else
			enableTabs();
	}

	@Override
	protected void onCcClinicalNotesValueChanged() throws PresentationLogicException
	{
		disableOrEnableTabs();
	}

	@Override
	protected void onCcInvestigationsValueChanged() throws PresentationLogicException
	{
		disableOrEnableTabs();
	}

	@Override
	protected void onCcPrescriptionValueChanged() throws PresentationLogicException
	{
		disableOrEnableTabs();
	}

	@Override
	protected void onCcOutcomeValueChanged() throws PresentationLogicException
	{
		disableOrEnableTabs();
	}

	@Override
	protected void onCcSpecimenCollectionValueChanged() throws PresentationLogicException
	{
		disableOrEnableTabs();
	}
}
