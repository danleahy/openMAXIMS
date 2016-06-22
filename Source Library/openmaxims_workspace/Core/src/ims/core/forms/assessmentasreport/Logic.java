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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.65 build 3180.29032)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.assessmentasreport;

import java.security.SecureRandom;

import ims.assessment.instantiation.vo.PatientAssessmentRefVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.lookups.FileType;
import ims.framework.utils.DateTime;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	/**
	* builds and Assessment report
	*/
	@Deprecated
	public void buildAssessmentReport(ims.vo.ValueObjectRef refVo)
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		String obj[] = domain.getReportAndTemplate(refVo);
		
		if(obj == null)
		{
			engine.showMessage("I could not get the report and template linked to this assessment !");
			return;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("CareContext_id", form.getGlobalContext().Core.getCurrentCareContextIsNotNull() ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext() : null, Integer.class));
		client.addSeed(new SeedValue("ClinicalContact_id", form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() ? form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact() : null, Integer.class));
		
		String resultUrl = "";
		try
		{
			resultUrl = client.buildReportAsUrlInlineFrame(obj[0], obj[1], urlReportServer, QueryBuilderClient.HTML, "", 1);
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}
		
		form.htmView().setHTML(resultUrl);
	}

	public void buildAssessmentReport(PatientAssessmentRefVo patientAssessmentRef)
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		String obj[] = domain.getReportAndTemplate(patientAssessmentRef);
		
		if (obj == null || obj.length < 2 || obj[0] == null || obj[1] == null)
		{
			engine.showMessage("I could not get the report and template linked to this assessment !");
			return;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		// WDEV-13300
		// PatientAssessment reports in new version use PatientAssessment_ID, but some old versions use a combination of
		// CareContext_id and ClinicalContact_id - so we need to set all tree as seeds. Reports are ignoring the extra & unused seeds
		client.addSeed(new SeedValue("PatientAssessment_id", patientAssessmentRef.getID_PatientAssessment(), Integer.class));
		client.addSeed(new SeedValue("CareContext_id", form.getGlobalContext().Core.getCurrentCareContextIsNotNull() ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext() : null, Integer.class));
		client.addSeed(new SeedValue("ClinicalContact_id", form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() ? form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact() : null, Integer.class));
		
		String resultUrl = "";
		try
		{
			resultUrl = client.buildReportAsUrlInlineFrame(obj[0], obj[1], urlReportServer, QueryBuilderClient.HTML, "", 1);
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}
		
		form.htmView().setHTML(resultUrl);
	}

	/**
	 * WDEV-13601
	 * Function used to create a PDF, upload it to PDF store path and return an unsaved document
	 */
	public ServerDocumentVo printAssessment(PatientAssessmentRefVo patientAssessment, String printerName)
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		String obj[] = domain.getReportAndTemplate(patientAssessment);
		
		if(obj == null)
		{
			engine.showMessage("I could not get the report and template linked to this assessment !");
			return null;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		// WDEV-13300
		// PatientAssessment reports in new version use PatientAssessment_ID, but some old versions use a combination of
		// CareContext_id and ClinicalContact_id - so we need to set all tree as seeds. Reports are ignoring the extra & unused seeds
		client.addSeed(new SeedValue("PatientAssessment_id", patientAssessment.getID_PatientAssessment(), Integer.class));
		client.addSeed(new SeedValue("CareContext_id", form.getGlobalContext().Core.getCurrentCareContextIsNotNull() ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext() : null, Integer.class));
		client.addSeed(new SeedValue("ClinicalContact_id", form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() ? form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact() : null, Integer.class));
		
		try
		{
			byte[] reportContent = client.buildReport(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, printerName, 1);
			
			String fileName = generateName() + ".pdf";
			engine.uploadFile(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue(), reportContent, fileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "\\");
			
			String path = null;// client.buildReportAndUpload(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, printerName, 1);
			
			int year  = new DateTime().getDate().getYear();
			int month = new DateTime().getDate().getMonth();
			int day   = new DateTime().getDate().getDay();
			
			if(fileName != null && fileName.length() > 0)
				path = year + "\\" + month + "\\" + day + "\\" + fileName;

			// Create Server document VO if uploads succeeds
			ServerDocumentVo document = new ServerDocumentVo();
			document.setFileName(path);
			document.setFileType(FileType.PDF);
			
			return document;
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return null;
		}
		catch (Exception e)
		{
			engine.showMessage("Could not upload file: " + e.getMessage());
			return null;
		}
	}

	/**
	 * WDEV-13601
	 * Method used to generate a unique file name
	 * @return
	 */
	private String generateName() 
	{
		String str = "";

		try
		{
			//Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length() < 12)
			{
				str = '0' + str;
			}

			//Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str;
			}
			//Get Third Random Segment
			byte bytes[] = new byte[16];
			SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
			thirdPrng.nextBytes(bytes);
			str += Integer.toHexString(thirdPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}
		}
		catch (java.security.NoSuchAlgorithmException ex)
		{
			ex.getMessage();
		}

		return str;
	}
	
	//WDEV-12501
	public void clear() 
	{
		form.htmView().setHTML("");
	}
}
