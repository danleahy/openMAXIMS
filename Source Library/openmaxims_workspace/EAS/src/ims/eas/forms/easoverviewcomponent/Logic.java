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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 4828.20158)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.forms.easoverviewcomponent;
 
import ims.ccosched.vo.lookups.ActionStatusReasonCollection;
import ims.ccosched.vo.lookups.Priority;
import ims.ccosched.vo.lookups.SeenAt;
import ims.ccosched.vo.lookups.TreatmentIntent;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicLiteVo;
import ims.core.vo.MedicVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.RecordingUserInformationVo;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.MedicGrade;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.forms.easoverviewcomponent.GenForm.grdAnnotationRow;
import ims.eas.vo.EASAnnotationVo;
import ims.eas.vo.EASAnnotationVoCollection;
import ims.eas.vo.EASPhaseVo;
import ims.eas.vo.EASPhaseVoCollection;
import ims.eas.vo.EASStatusRecordVo;
import ims.eas.vo.EASStatusRecordVoCollection;
import ims.eas.vo.ElectronicActionSheetVo;
import ims.eas.vo.lookups.EASStatus;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;
import ims.vo.LookupInstVo;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	public void setDefaultLookups(SeenAt seenAt, TreatmentIntent treatmentIntent, Priority priority)
	{
		LookupInstVo seenAtDefault = getSeenAtDefaultInstance();
		form.cmbSeenAt().setValue(seenAtDefault==null?seenAt:(SeenAt)seenAtDefault);
		form.cmbIntent().setValue(treatmentIntent);
		form.cmbPriority().setValue(priority);
	}	
	
	private LookupInstVo getSeenAtDefaultInstance() 
	{
		//Seen At
//		Lookup used on Treatment Plan form, SeenAt. We will endeavour to default SeenAt to the O/P clinic if 
//		a) the patient has been selected from a clinic list and 
//		b) the clinic location has been mapped exactly to the SeenAt location. 			
		if (form.getGlobalContext().Core.getOutpatientAttendanceForOrderIsNotNull())
		{
			if (form.cmbSeenAt().getValues() != null)
			{
				SeenAt luSeenAt = null;
				
				for(int i=0; i< form.cmbSeenAt().getValues().size();i++)
				{
					luSeenAt = (SeenAt)form.cmbSeenAt().getValues().get(i);
					luSeenAt = (SeenAt)domain.getMappings(luSeenAt);
					if (checkMapping(luSeenAt.getMappings(),form.getGlobalContext().Core.getOutpatientAttendanceForOrder().getClinic().getMapping(TaxonomyType.PAS),TaxonomyType.PAS.toString()))
					{
						return luSeenAt;						
					}
				}
			}
		}		
		return null;
	}
		
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{		 	
		//for a new record call the open to initalise defaults.
		if (!form.getLocalContext().getElectronisActionSheetIsNotNull())
			initaliseDefaults();			
	}
	
	public void initialise() 
	{
		form.getLocalContext().setresponsibleHcp(null);
		form.getLocalContext().setseenBy(null);
		initaliseAuthoringControls();
		loadDelayedReasonCombo();	
		form.cmbPriority().setRequired(true);
		form.cmbIntent().setRequired(true);
	}
	
	private void loadDelayedReasonCombo() 
	{
		form.cmbDelayedReason().clear();
		
		ActionStatusReasonCollection voColl = domain.getDelayReasonLookups();
		if (voColl != null)
		{
			for(int i=0; i< voColl.size(); i++)
			{
				form.cmbDelayedReason().newRow(voColl.get(i), voColl.get(i).getText());
			}
		}		
		
		//delayed reason combo
		form.cmbDelayedReason().setEnabled(false);
		form.txtDelayedReasonComment().setEnabled(false);

	}

	private boolean getEnabledState() 
	{
				
		if (form.getLocalContext().getElectronisActionSheetIsNotNull() 
				&& form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull()
				&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull()
				&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.DRAFT)
				&& form.getMode().equals(FormMode.EDIT))
				return true;
		
    	boolean bRespHcp = false;
		boolean bSeenByHcp = false;

		MemberOfStaffShortVo mosVo = (MemberOfStaffShortVo)domain.getMosUser();
		
		Object currUser = domain.getHcpUser();
		if (currUser != null
				&& currUser instanceof MedicVo && MedicGrade.CONS.equals(((MedicVo)currUser).getGrade()))
		{		
			if (mosVo != null && mosVo.getHcpIsNotNull() 
					&& mosVo.getHcp().getIsHCPaResponsibleHCPIsNotNull()
					&& mosVo.getHcp().getIsHCPaResponsibleHCP()
					&& mosVo.getHcp().getHcpTypeIsNotNull()
					&& mosVo.getHcp().getHcpType().equals(HcpDisType.MEDICAL))
			{
				
				bRespHcp = true;
			}
		}
		
		if (mosVo != null && mosVo.getHcpIsNotNull() 
				&& mosVo.getHcp().getIsHCPaResponsibleHCPIsNotNull()
				&& mosVo.getHcp().getIsHCPaResponsibleHCP()
				&& mosVo.getHcp().getHcpTypeIsNotNull()
				&& mosVo.getHcp().getHcpType().equals(HcpDisType.MEDICAL))
		{
			
			bSeenByHcp = true;
		}

		//enable if in awaiting authorisation and the resposible hcp is the logged in user
		if(form.getLocalContext().getElectronisActionSheetIsNotNull()
				&& (bRespHcp || bSeenByHcp)
				&& form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull()
				&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull()
				&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.AWAITING_AUTHORISATION)
				&& form.getMode().equals(FormMode.EDIT))
				return true;

		return false;
	}
	
	private void updateControlState() 
	{
		
		form.txtAuthorisedBy().setVisible(false);
		form.lblAuthorisedBy().setVisible(false);
		form.dteDateAuthorised().setVisible(false);
		form.lblDateAuthorised().setVisible(false);
		
		if (form.getLocalContext().getElectronisActionSheetIsNotNull())
		{
			//Where viewing an Authorised EAS, the user who authorised/date&time authorised will display			
			if (form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull() 
					&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull()
					&& wasAuthorised())
			{
				form.txtAuthorisedBy().setVisible(true);
				form.txtAuthorisedBy().setEnabled(false);				
				form.lblAuthorisedBy().setVisible(true);
				form.dteDateAuthorised().setVisible(true);
				form.dteDateAuthorised().setEnabled(false);
				form.lblDateAuthorised().setVisible(true);
			}
		}

		boolean bEnabledState = getEnabledState();
		
		if (form.getMode().equals(FormMode.EDIT))
		{			
			//Delayed reason controls
			form.cmbDelayedReason().setEnabled(bEnabledState
					&& form.chkDelayed().getValue());
			
			
			form.ccResponsibleHcp().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.ccSeenBy().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState
					&& (form.getLocalContext().getElectronisActionSheetIsNotNull()
							&& form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull()
							&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull()
							&& !form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.AWAITING_AUTHORISATION)));
			form.dteDateSeen().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.dteDateDecisionToTreat().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.cmbSeenAt().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.cmbIntent().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.cmbPriority().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.chkDelayed().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState);
			form.pdtDateReadyToTreat().setEnabled(!form.getLocalContext().getElectronisActionSheetIsNotNull()
					|| bEnabledState
					&& form.chkDelayed().getValue());
			
			if (form.getLocalContext().getElectronisActionSheetIsNotNull()
					&& form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull () 
					&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull()
					&& (form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.AUTHORISED)
							|| form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.ANNOTATED)))
			{
				form.txtAnnotate().setEnabled(true);
				form.txtAnnotate().setFocus();
			}
			
		}
		else if (form.getMode().equals(FormMode.VIEW))
		{
			form.cmbDelayedReason().setEnabled(false);			
			form.txtRecordingMos().setEnabled(false);
			form.dteDateCreated().setEnabled(false);			
			form.txtAuthorisedBy().setEnabled(false);
			form.dteDateAuthorised().setEnabled(false);
			form.pdtDateReadyToTreat().setEnabled(false);
			form.txtAnnotate().setEnabled(false);
			form.grdAnnotation().setReadOnly(true);

		}
		
		form.txtDelayedReasonComment().setVisible(form.chkDelayed().getValue());
		form.txtDelayedReasonComment().setEnabled(bEnabledState && form.chkDelayed().getValue() && !wasAuthorised());			

		form.cmbDelayedReason().setVisible(form.chkDelayed().getValue());
		form.lblDelayReason().setVisible(form.chkDelayed().getValue());
		form.lblReadToTreatDate().setVisible(form.chkDelayed().getValue());		
		form.lblDelayReason2().setVisible(form.chkDelayed().getValue());		
		form.lblDelayReasonComment().setVisible(form.chkDelayed().getValue());		
		form.pdtDateReadyToTreat().setVisible(form.chkDelayed().getValue());
		
		
		//set Annotations controls WDEV-17546
		boolean isVisibleForView = form.getMode().equals(FormMode.VIEW) && wasAnnotated();
		boolean isVisibleForEdit = form.getMode().equals(FormMode.EDIT) && form.getLocalContext().getElectronisActionSheetIsNotNull() && form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull() && form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull() && (form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.AUTHORISED) || form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.ANNOTATED));
		
		form.lblAnnotate().setVisible(isVisibleForView || isVisibleForEdit);
		form.grdAnnotation().setVisible(isVisibleForView || isVisibleForEdit);
		form.txtAnnotate().setVisible(isVisibleForEdit);
		form.lblAnnotate2().setVisible(isVisibleForEdit);
	}

	private boolean wasAnnotated()
	{
		if (form.getLocalContext().getElectronisActionSheet() != null && form.getLocalContext().getElectronisActionSheet().getEasStatus() != null && form.getLocalContext().getElectronisActionSheet().getStatusHistory() != null)
		{
			EASStatusRecordVoCollection statuses = form.getLocalContext().getElectronisActionSheet().getStatusHistory();
			
			for (int i=0; i < statuses.size(); i++)
			{
				if (EASStatus.ANNOTATED.equals(statuses.get(i).getStatus()))
				{
					return true;
				}
			}
		}
			
		return false;
	}

	private boolean wasAuthorised()
	{
		if (form.getLocalContext().getElectronisActionSheet() != null && form.getLocalContext().getElectronisActionSheet().getEasStatus() != null && form.getLocalContext().getElectronisActionSheet().getStatusHistory() != null)
		{
			EASStatusRecordVoCollection statuses = form.getLocalContext().getElectronisActionSheet().getStatusHistory();
			
			for (int i=0; i < statuses.size(); i++)
			{
				if (EASStatus.AUTHORISED.equals(statuses.get(i).getStatus()))
				{
					return true;
				}
			}
		}
			
		return false;
	}

	private void open() 
	{
		populateScreenFromData();	
	}

	private void initaliseDefaults()
	{
		//new record. set defaults
		
		if (!form.getLocalContext().getElectronisActionSheetIsNotNull())
		{
			MemberOfStaffShortVo mosVo = (MemberOfStaffShortVo)domain.getMosUser();
			
			Object currUser = domain.getHcpUser();
			if (currUser != null
					&& currUser instanceof MedicVo && MedicGrade.CONS.equals(((MedicVo)currUser).getGrade()))
			{		
				if (mosVo.getHcpIsNotNull() 
						&& mosVo.getHcp().getIsHCPaResponsibleHCPIsNotNull()
						&& mosVo.getHcp().getIsHCPaResponsibleHCP()
						&& mosVo.getHcp().getHcpTypeIsNotNull()
						&& mosVo.getHcp().getHcpType().equals(HcpDisType.MEDICAL))
				{
					
					form.ccResponsibleHcp().setValue(mosVo);
					form.getLocalContext().setresponsibleHcp(null);
				}
			}
			
			if (mosVo != null && mosVo.getHcpIsNotNull() 
					&& mosVo.getHcp().getHcpTypeIsNotNull()
					&& mosVo.getHcp().getHcpType().equals(HcpDisType.MEDICAL))
			{
				
				form.ccSeenBy().setValue(mosVo.getHcp());
				form.getLocalContext().setseenBy(null);
			}
			
			//Recording MOS and Date
			form.txtRecordingMos().setValue(mosVo != null ?mosVo.getNameIsNotNull()?mosVo.getName().toProperCase():"":"");
			form.dteDateCreated().setValue(new Date());
			
			//Date Seen
	//			This will default to the O/P clinic date if the patient has been selected from a clinic list, 
	//			otherwise will default to today’s date 
			if (form.getGlobalContext().Core.getOutpatientAttendanceForOrderIsNotNull())
			{
				if (form.getGlobalContext().Core.getOutpatientAttendanceForOrder().getAppointmentDateTimeIsNotNull())
					form.dteDateSeen().setValue(form.getGlobalContext().Core.getOutpatientAttendanceForOrder().getAppointmentDateTime().getDate());
				else
					form.dteDateSeen().setValue(new Date());
			}
			else
				form.dteDateSeen().setValue(new Date());
			
			//This will default to Date Seen. User will be able to change this.
			form.dteDateDecisionToTreat().setValue(form.dteDateSeen().getValue());
			
			//Seen At
	//			Lookup used on Treatment Plan form, SeenAt. We will endeavour to default SeenAt to the O/P clinic if 
	//			a) the patient has been selected from a clinic list and 
	//			b) the clinic location has been mapped exactly to the SeenAt location. 			
			if (form.getGlobalContext().Core.getOutpatientAttendanceForOrderIsNotNull())
			{
				if (form.cmbSeenAt().getValues() != null)
				{
					SeenAt luSeenAt = null;
					
					for(int i=0; i< form.cmbSeenAt().getValues().size();i++)
					{
						luSeenAt = (SeenAt)form.cmbSeenAt().getValues().get(i);
						luSeenAt = (SeenAt)domain.getMappings(luSeenAt);
						if (checkMapping(luSeenAt.getMappings(),form.getGlobalContext().Core.getOutpatientAttendanceForOrder().getClinic().getMapping(TaxonomyType.PAS),TaxonomyType.PAS.toString()))
						{
							form.cmbSeenAt().setValue(luSeenAt);						
						}
					}
				}
			}			
		}
		
		updateControlState();
	}
	
	private void populateScreenFromData() 
	{
		clearAllControls();
		ElectronicActionSheetVo voEAS = form.getLocalContext().getElectronisActionSheet();
				
		if (voEAS != null)
		{
			populateAuthorisedControls(voEAS.getAuthorisedBy(),voEAS.getAuthorisedDateTime(),voEAS.getRecordingInfo());
			
			// Responsible HCP
			if (form.getLocalContext().getresponsibleHcpIsNotNull())
				form.ccResponsibleHcp().setValue(form.getLocalContext().getresponsibleHcp());
			else
				form.ccResponsibleHcp().setValue(voEAS.getResponsibleHcpIsNotNull()?voEAS.getResponsibleHcp().getMosIsNotNull()?voEAS.getResponsibleHcp().getMos():null:null);
			
			// Seen By
			if (form.getLocalContext().getseenByIsNotNull())
				form.ccSeenBy().setValue(form.getLocalContext().getseenBy());
			else
				form.ccSeenBy().setValue(voEAS.getSeenBy());
			
			//Date Seen
			form.dteDateSeen().setValue(voEAS.getDateSeen());
			
			//Date Decision to Treat
			form.dteDateDecisionToTreat().setValue(voEAS.getDateDecisionToTreat());
			
			// Seen At
			form.cmbSeenAt().setValue(voEAS.getSeenAt());
			
			// Intent
			form.cmbIntent().setValue(voEAS.getIntent());
			
			// Priority
			form.cmbPriority().setValue(voEAS.getPriority());
			
			// Delayed
			form.chkDelayed().setValue(voEAS.getDelayed());			
			form.cmbDelayedReason().setValue(voEAS.getDelayedReason());
			
			// Ready to Treat Date
			form.pdtDateReadyToTreat().setValue(voEAS.getReadyToTreatDate());
			
			//Delayed Reason Comment
			form.txtDelayedReasonComment().setValue(voEAS.getDelayedComment());
			
			//Recording MOS
			form.txtRecordingMos().setValue(voEAS.getRecordingInfoIsNotNull()?voEAS.getRecordingInfo().getRecordingUserIsNotNull()?voEAS.getRecordingInfo().getRecordingUser().getNameIsNotNull()?voEAS.getRecordingInfo().getRecordingUser().getName().toString():null:null:null);
			
			//Date Created
			form.dteDateCreated().setValue(voEAS.getRecordingInfoIsNotNull()?voEAS.getRecordingInfo().getRecordingDateTimeIsNotNull()?voEAS.getRecordingInfo().getRecordingDateTime().getDate():null:null);
			
			//Authorised By
			form.txtAuthorisedBy().setValue(voEAS.getAuthorisedByIsNotNull()?voEAS.getAuthorisedBy().getName().toString():null);
			
			//Date Authorised
			form.dteDateAuthorised().setValue(voEAS.getAuthorisedDateTimeIsNotNull()?voEAS.getAuthorisedDateTime().getDate():null);
			
			//Annotations
			form.grdAnnotation().getRows().clear();
			
			if (form.getLocalContext().getElectronisActionSheetIsNotNull() 
					&& form.getLocalContext().getElectronisActionSheet().getAnnotationIsNotNull())
			{				
				EASAnnotationVoCollection vocoll = form.getLocalContext().getElectronisActionSheet().getAnnotation();
				vocoll.sort(SortOrder.DESCENDING);
				for (EASAnnotationVo vo : vocoll)
				{
					grdAnnotationRow row = form.grdAnnotation().getRows().newRow();
					row.setcolAnnotation(vo.getAnnotation());
					row.setcolDate(vo.getRecordingDateTimeIsNotNull()?vo.getRecordingDateTime().getDate().toString():null);
					row.setcolCreatedBy(vo.getRecordingMosIsNotNull()?vo.getRecordingMos().getNameIsNotNull()?vo.getRecordingMos().getName().toString():null:null);
					row.setTooltip(vo.getAnnotation());
				}
			}
		}
	}

	private boolean checkMapping(LookupMappingVoCollection mappings, String strCode, String strExtSystem) 
	{
		if (mappings==null)
			return false;

		LookupMappingVo voMapping = null;
		
		for (int i=0; i<mappings.size();i++)
		{
			voMapping = mappings.get(i);
			if (voMapping.getExtSystem().equals(strExtSystem) && voMapping.getExtCode().equals(strCode))
				return true;
		}
		
		return false;
	}

	private void initaliseAuthoringControls() 
{
	//Responsible HCP
//	If the logged on user is configured as a medic with medic grade of ‘Consultant’ and is a Responsible HCP, 
//	this field will default to the logged in user. If we cannot default based on logged in user, 
//	this will be blank and will search only those members of staff who are medics, 
//	with medic grade of ‘Consultant’ and are a Responsible HCP
	form.ccResponsibleHcp().initialize(null, MedicGrade.CONS);
	form.ccResponsibleHcp().initializeResponsibleHcp(MosType.MEDIC, true);
	form.ccResponsibleHcp().isRequired(true);
	
	form.ccSeenBy().isRequired(true);
	
//	If the logged on user is configured as a medic, this field will default to the logged in user. 
//	If we cannot default based on logged in user, this will be blank and will search only those members of staff who are medics.	
	form.ccSeenBy().initialize(MosType.MEDIC);
	
}
	
	private void populateAuthorisedControls(MemberOfStaffRefVo authorisedBy,
											 DateTime authorisedDateTime,
											 RecordingUserInformationVo recordingInfo) 
	{
				
		form.txtAuthorisedBy().setValue(authorisedBy!=null?authorisedBy.toString():"");
		form.dteDateAuthorised().setValue(authorisedDateTime!=null?authorisedDateTime.getDate():null);
		if (recordingInfo != null)
		{
			form.txtRecordingMos().setValue(recordingInfo.getRecordingUserIsNotNull()?recordingInfo.getRecordingUser().getNameIsNotNull()?recordingInfo.getRecordingUser().getName().toString():"":"");
		}
	}

	private void clearAllControls() 
	{
		// Responsible HCP
		//form.ccResponsibleHcp().setValue(null);
		
		// Seen By
		//form.ccSeenBy().setValue(null);
		
		//Date Seen
		form.dteDateSeen().setValue(null);
		
		//Date Decision to Treat
		form.dteDateDecisionToTreat().setValue(null);
		
		// Seen At
		form.cmbSeenAt().setValue(null);
		
		// Intent
		form.cmbIntent().setValue(null);
		
		// Priority
		form.cmbPriority().setValue(null);
		
		// Delayed
		form.chkDelayed().setValue(null);
		//TODO
		form.cmbDelayedReason().setValue(null);
		
		// Ready to Treat Date
		form.pdtDateReadyToTreat().setValue(null);
		
		//Delayed Reason Comment
		form.txtDelayedReasonComment().setValue(null);
		
		//Recording MOS
		form.txtRecordingMos().setValue(null);
		
		//Date Created
		form.dteDateCreated().setValue(null);
		
		//Authorised By
		form.txtAuthorisedBy().setValue(null);
		
		//Date Authorised
		form.dteDateAuthorised().setValue(null);
		
	}

	public void setFormMode(ims.framework.enumerations.FormMode formMode)
	{
		form.setMode(formMode);
		updateControlState();
	}

	public void setValue(ims.eas.vo.ElectronicActionSheetVo easVo)
	{
		form.getLocalContext().setElectronisActionSheet(easVo);
		open();
		updateControlState();
	}

	public ims.eas.vo.ElectronicActionSheetVo getValue()
	{
		//WDEV-17539
		populateDataFromScreen(true);
		return form.getLocalContext().getElectronisActionSheet();
	}

	
	private String[] populateDataFromScreen(boolean bShowMessage) throws CodingRuntimeException
	{
		java.util.ArrayList<String> uiValidationErrors = new java.util.ArrayList<String>();
		
		ElectronicActionSheetVo voEAS = form.getLocalContext().getElectronisActionSheet();
		
		if (voEAS == null)
			voEAS = new ElectronicActionSheetVo();
		
		//Patient
		if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			voEAS.setPatient(form.getGlobalContext().Core.getPatientShort());		
		
		//Status default is Draft
		if (!voEAS.getEasStatusIsNotNull())
		{
			EASStatusRecordVo voStatus2 = new EASStatusRecordVo();
			voStatus2.setStatus(EASStatus.DRAFT);
			voStatus2.setRecordingDateTime(new DateTime(form.dteDateCreated().getValue(), new Time())); //WDEV-17584
			voStatus2.setRecordingMos((MemberOfStaffShortVo)domain.getMosUser());
			voEAS.setEasStatus(voStatus2);
			
			EASStatusRecordVo voStatus = new EASStatusRecordVo();
			voStatus.setStatus(EASStatus.DRAFT);						
			EASStatusRecordVoCollection vocoll = new EASStatusRecordVoCollection();			
			voStatus.setRecordingMos((MemberOfStaffShortVo)domain.getMosUser());
			voStatus.setRecordingDateTime(new DateTime(form.dteDateCreated().getValue(), new Time())); //WDEV-17584
			vocoll.add(voStatus);
			voEAS.setStatusHistory(vocoll);
			
		}
		
		if (form.ccResponsibleHcp().getValue() != null && form.ccResponsibleHcp().getValue().getClass().equals((MemberOfStaffShortVo.class)))
		{
			MemberOfStaffShortVo voMos = (MemberOfStaffShortVo)form.ccResponsibleHcp().getValue();
			voEAS.setResponsibleHcp(voMos.getHcpIsNotNull()?voMos.getHcp().toHcpLiteVo():null);
		}
		else if (form.ccResponsibleHcp().getValue() != null && form.ccResponsibleHcp().getValue().getClass().equals((MedicLiteVo.class)))
		{
			MedicLiteVo voMedic = (MedicLiteVo)form.ccResponsibleHcp().getValue();
			form.getLocalContext().setresponsibleHcp(voMedic);
			voEAS.setResponsibleHcp(new HcpLiteVo(voMedic.getID_Hcp(), 0));		
		}
		else if (form.ccResponsibleHcp().getValue() != null && form.ccResponsibleHcp().getValue().getClass().equals((MemberOfStaffLiteVo.class)))
		{
			MemberOfStaffLiteVo voMosLite = (MemberOfStaffLiteVo)form.ccResponsibleHcp().getValue();
			voEAS.setResponsibleHcp(domain.getHcp(voMosLite.getID_MemberOfStaff()));		
		}
		else
		{
			voEAS.setResponsibleHcp(null);
			form.getLocalContext().setresponsibleHcp(null);
			uiValidationErrors.add("Please select a Responsible HCP.");
			form.getLocalContext().setElectronisActionSheet(voEAS);		
		}
		
		//Seen By
		if (form.ccSeenBy().getValue() != null)
		{
			if (form.ccSeenBy().getValue().getClass().equals(MedicVo.class))
			{				
				voEAS.setSeenBy((MedicVo)form.ccSeenBy().getValue());
				form.getLocalContext().setseenBy(voEAS.getSeenBy());
			}
			else if (form.ccSeenBy().getValue().getClass().equals(Hcp.class))
			{				
				voEAS.setSeenBy((Hcp)form.ccSeenBy().getValue());
				form.getLocalContext().setseenBy(voEAS.getSeenBy());
			}
		}
		else
		{
			voEAS.setSeenBy(null);
			uiValidationErrors.add("Please select Seen By.");
			form.getLocalContext().setseenBy(null);
			form.getLocalContext().setElectronisActionSheet(voEAS);
		}
		
		//recording info
		if (!voEAS.getRecordingInfoIsNotNull())
		{
			//insert recording informstion
			RecordingUserInformationVo voRecUser = new RecordingUserInformationVo();
			voRecUser.setRecordingUser((MemberOfStaffShortVo)domain.getMosUser());
			voRecUser.setRecordingDateTime(new DateTime());
			voEAS.setRecordingInfo(voRecUser);
		}
				
		//Date Seen
		voEAS.setDateSeen(form.dteDateSeen().getValue());
		
		//Date Decision to Treat
		voEAS.setDateDecisionToTreat(form.dteDateDecisionToTreat().getValue());
		
		// Seen At
		voEAS.setSeenAt(form.cmbSeenAt().getValue());
		
		// Intent
		voEAS.setIntent(form.cmbIntent().getValue());
		
		// Priority
		voEAS.setPriority(form.cmbPriority().getValue());
		
		// Delayed
		voEAS.setDelayed(form.chkDelayed().getValue());		
		voEAS.setDelayedReason(form.cmbDelayedReason().getValue());
		
		// Ready to Treat Date
		voEAS.setReadyToTreatDate(form.pdtDateReadyToTreat().getValue());
		
		//Delayed Reason Comment
		voEAS.setDelayedComment(form.txtDelayedReasonComment().getValue());

		//perform extra checks after data is coollected.
		if (form.chkDelayed().getValue() && form.cmbDelayedReason().getValue()==null)
		{
			uiValidationErrors.add("Please select a Delayed Reason.");
			form.getLocalContext().setElectronisActionSheet(voEAS);
		}		

		//annotations
		if (form.txtAnnotate().isVisible() && form.txtAnnotate().isEnabled())
		{
			EASAnnotationVoCollection voAnnColl = voEAS.getAnnotation();
			if (voAnnColl == null)
				voAnnColl = new EASAnnotationVoCollection();
			
			if (form.txtAnnotate().getValue()!= null)
			{
				EASAnnotationVo voAnn = new EASAnnotationVo();
				voAnn.setAnnotation(form.txtAnnotate().getValue());
				voAnn.setRecordingMos((MemberOfStaffShortVo)domain.getMosUser());
				voAnn.setRecordingDateTime(new DateTime());
				
				voAnnColl.add(voAnn);
				//if annotation note was changed then create a new record.
				voEAS.setAnnotation(voAnnColl);
				
				//add setActionRequired
				voEAS.setActionRequired(true);
				
				//add changed status and append to history
				//Status Annotated
				if (voEAS.getEasStatusIsNotNull())
				{
					EASStatusRecordVo voStatus2 = new EASStatusRecordVo();
					voStatus2.setStatus(EASStatus.ANNOTATED);
					voStatus2.setRecordingDateTime(new DateTime());
					voStatus2.setRecordingMos((MemberOfStaffShortVo)domain.getMosUser());
					
					//WDEV-17504
					voStatus2.setActionRequired(voEAS.getActionRequired());
					voStatus2.setTPCreated(voEAS.getTPCreated());
					voStatus2.setRemovalReason(voEAS.getRemovalReason());
					voStatus2.setRemovedStat(voEAS.getRemovedStat());
					voStatus2.setComment(voEAS.getEasStatus().getComment());
					
					voEAS.setEasStatus(voStatus2);
					
					EASStatusRecordVo voStatus = new EASStatusRecordVo();
					voStatus.setStatus(EASStatus.ANNOTATED);						
					EASStatusRecordVoCollection vocoll = new EASStatusRecordVoCollection();			
					voStatus.setRecordingMos((MemberOfStaffShortVo)domain.getMosUser());
					voStatus.setRecordingDateTime(new DateTime());
					
					//WDEV-17504
					voStatus.setActionRequired(voEAS.getActionRequired());
					voStatus.setTPCreated(voEAS.getTPCreated());
					voStatus.setRemovalReason(voEAS.getRemovalReason());
					voStatus.setRemovedStat(voEAS.getRemovedStat());
					voStatus.setComment(voEAS.getEasStatus().getComment());
					
					vocoll.add(voStatus);
					
					//should always have at least a draft status
					if (voEAS.getStatusHistoryIsNotNull())
						voEAS.getStatusHistory().add(voStatus);
					
				}
				
			}
			else
			{
				uiValidationErrors.add("Please enter annotation text.");
			}
		}
		
		int errorCount = uiValidationErrors.size();
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)uiValidationErrors.get(x);

		form.getLocalContext().setElectronisActionSheet(voEAS);	
		
		return result;
	}
	
	protected void onChkDelayedValueChanged() throws PresentationLogicException 
	{
		
		if (!form.chkDelayed().getValue())		
		{
			form.txtDelayedReasonComment().setValue(null);
			form.cmbDelayedReason().setValue(null);
			form.txtDelayedReasonComment().setEnabled(false);
			form.txtDelayedReasonComment().setRequired(false);
			form.txtDelayedReasonComment().setVisible(false);
			form.cmbDelayedReason().setEnabled(false);
			form.cmbDelayedReason().setVisible(false);	
			form.cmbDelayedReason().setRequired(false);
			form.pdtDateReadyToTreat().setVisible(false);
			form.pdtDateReadyToTreat().setEnabled(false);
			form.pdtDateReadyToTreat().setValue(null);
			form.lblDelayReason().setVisible(false);
			form.lblDelayReason2().setVisible(false);	
			form.lblDelayReasonComment().setVisible(false);	
			form.lblReadToTreatDate().setVisible(false);
			form.txtDelayedReasonComment().setValue(null);
			if (form.getLocalContext().getElectronisActionSheetIsNotNull()
					&& form.getLocalContext().getElectronisActionSheet().getDelayedCommentIsNotNull())
			{
				form.getLocalContext().getElectronisActionSheet().setDelayed(false);
				form.getLocalContext().getElectronisActionSheet().setDelayedComment(null);
				form.getLocalContext().getElectronisActionSheet().setDelayedReason(null);
			}
			form.pdtDateReadyToTreat().setValue(null);
		}
		else
		{
			form.txtDelayedReasonComment().setEnabled(true);
			form.txtDelayedReasonComment().setVisible(true);
			form.cmbDelayedReason().setEnabled(true);
			form.cmbDelayedReason().setVisible(true);
			form.cmbDelayedReason().setRequired(true);
			form.cmbDelayedReason().setTooltip("Please select a Delayed Reason");
			form.pdtDateReadyToTreat().setVisible(true);
			form.pdtDateReadyToTreat().setEnabled(true);
			form.lblDelayReason().setVisible(true);
			form.lblDelayReason2().setVisible(true);	
			form.lblDelayReasonComment().setVisible(true);	
			form.lblReadToTreatDate().setVisible(true);
			
		}
		
	}
	
	private ArrayList<String> validatePhaseCollection(EASPhaseVoCollection phaseColl,
			boolean bShowMessages) 
	{		
		java.util.ArrayList<String> uiValidationErrors = new java.util.ArrayList<String>();
		
		//check collection
		if (phaseColl != null)
		{
			for (int i = 0; i < phaseColl.size(); i++)
			{
				//check for duplicate phases				
				if (isMultiple(phaseColl.get(i),phaseColl) > 1)
					uiValidationErrors.add("Duplicate Phases found: " + phaseColl.get(i).getPhaseName().getText());
				
				//check Unit Energy values
				if (phaseColl.get(i).getEnergyIsNotNull()
						&& !phaseColl.get(i).getUnitsIsNotNull())
				{
					uiValidationErrors.add("No Unit selected for Phase: " 
								+ (phaseColl.get(i).getPhaseNameIsNotNull()?phaseColl.get(i).getPhaseName().getText():"")
								+ " Energy: " 
								+ (phaseColl.get(i).getEnergyIsNotNull()?phaseColl.get(i).getEnergy().toString():""));
				}					
			}
		}
		return uiValidationErrors;		
	}

	private ArrayList<String> validateLaterality() 
	{
		java.util.ArrayList<String> uiValidationErrors = new java.util.ArrayList<String>();
		
		if (form.getLocalContext().getElectronisActionSheetIsNotNull())
		{
			if (form.getLocalContext().getElectronisActionSheet().getTreatmentSiteIsNotNull() 
					&& !form.getLocalContext().getElectronisActionSheet().getTreatmentSite().getLateralityIsNotNull())
			{
				if (form.getLocalContext().getElectronisActionSheet().getTreatmentSite().getLaterality())
				{
					//laterality is mandatory
					if (!form.getLocalContext().getElectronisActionSheet().getTreatSiteLateralityIsNotNull())
							uiValidationErrors.add("Please select Treatment Site Laterality");
				}
			}
		}
		
		return uiValidationErrors;
	}

	private int isMultiple(EASPhaseVo vpPhaseVo, EASPhaseVoCollection voPhaseVoColl)
	{
		int lCount = 0;
		
		if (vpPhaseVo == null)
			throw new CodingRuntimeException("vpPhaseVo cannot be null in method isThisRecordDuplicate");
		if (voPhaseVoColl == null)
			throw new CodingRuntimeException("voPhaseVoColl cannot be null in method isThisRecordDuplicate");
		
		for (EASPhaseVo voPhaseVoCollListItem : voPhaseVoColl)
		{
			if(voPhaseVoCollListItem.getPhaseNameIsNotNull())
			{
				if(voPhaseVoCollListItem.getPhaseName().equals(vpPhaseVo.getPhaseName())
						&& voPhaseVoCollListItem.getSelectedIsNotNull()
						&& vpPhaseVo.getSelectedIsNotNull()
						&& voPhaseVoCollListItem.getSelected())
				{
					lCount++;
				}
			}	
		}
		
		return lCount;
	}
	
	public Boolean save() 
	{
		String[] uiValidation = null;
		java.util.ArrayList<String> uiValidationErrors = new java.util.ArrayList<String>();
		
		try
		{
			uiValidation = populateDataFromScreen(true);
		}
		catch (CodingRuntimeException ce)
		{
			engine.showMessage(ce.getMessage());
			return false;
		}
		
		uiValidationErrors.addAll(validatePhaseCollection(form.getLocalContext().getElectronisActionSheet().getPhases(),true));

		uiValidationErrors.addAll(validateLaterality());

		int errorCount = uiValidationErrors.size();
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)uiValidationErrors.get(x);

		
		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		if (uiValidation != null && uiValidation.length > 0)
		{
			engine.showErrors(uiValidation);
			return false;

		}
			
		String[] str = form.getLocalContext().getElectronisActionSheet().validate();
		
		if (str != null && str.length > 0)
		{
			engine.showErrors(str);
			return false;
		}

		try 
		{
			form.getLocalContext().setElectronisActionSheet(domain.saveElectronicActionSheet(form.getLocalContext().getElectronisActionSheet()));
			open();
			updateControlState();
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			
			form.getLocalContext().setElectronisActionSheet(domain.getElectronicActionSheet(form.getLocalContext().getElectronisActionSheet()));
			
			return false;
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.getLocalContext().setElectronisActionSheet(domain.getElectronicActionSheet(form.getLocalContext().getElectronisActionSheet()));
			open();
			updateControlState();
			return false;
		} 		

		
		return true;
	}

	protected void onFormModeChanged() 
	{	
		updateControlState();
	}

	protected void onDteDateSeenValueChanged()
			throws PresentationLogicException 
	{
		//reviewed.
		// if in draft, this will alwys change the dteDateDecisionToTreat
		if (form.getLocalContext().getElectronisActionSheetIsNotNull()
				&& form.getLocalContext().getElectronisActionSheet().getEasStatusIsNotNull () 
				&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatusIsNotNull()
				&& form.getLocalContext().getElectronisActionSheet().getEasStatus().getStatus().equals(EASStatus.DRAFT))
			form.dteDateDecisionToTreat().setValue(form.dteDateSeen().getValue());
	}

	protected void onDteDateAuthorisedValueChanged()
			throws PresentationLogicException {
		// TODO Auto-generated method stub
		
	}

	//WDEV-17539
	public Boolean errorsPresent()
	{
		if (form.getLocalContext().getElectronisActionSheetIsNotNull() && form.getLocalContext().getElectronisActionSheet().getID_ElectronicActionSheet() == null)
		{
			if (!validateUiRulesWhileNotSaved())
				return true;
		}
		
		return false;
	}

	private Boolean validateUiRulesWhileNotSaved()
	{
		
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.ccResponsibleHcp().getValue() == null)
		{
			listOfErrors.add("Responsible HCP is mandatory.");
		}
		
		if (form.ccSeenBy().getValue() == null)
		{
			listOfErrors.add("Seen By is mandatory.");
		}
		
		if (form.dteDateSeen().getValue() == null)
		{
			listOfErrors.add("Date Seen is mandatory.");
		}
		
		if (form.cmbIntent().getValue() == null)
		{
			listOfErrors.add("Intent is mandatory.");
		}
		
		if (form.cmbPriority().getValue() == null)
		{
			listOfErrors.add("Priority is mandatory.");
		}
		
		if (form.dteDateDecisionToTreat().getValue() == null)
		{
			listOfErrors.add("Date Decision to Treat is mandatory.");
		}
		
		if (Boolean.TRUE.equals(form.chkDelayed().getValue()))
		{
			if (form.cmbDelayedReason().getValue() == null)
				listOfErrors.add("Reason is mandatory.");
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}
			
			return true;
		
	}
}
