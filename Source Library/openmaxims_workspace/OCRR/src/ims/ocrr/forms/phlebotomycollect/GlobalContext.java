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

package ims.ocrr.forms.phlebotomycollect;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		OCRR = new OCRRContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getReportIsNotNull()
		{
			return !cx_CoreReport.getValueIsNull(context);
		}
		public String getReport()
		{
			return (String)cx_CoreReport.getValue(context);
		}
		public void setReport(String value)
		{
			cx_CoreReport.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReport = new ims.framework.ContextVariable("Core.Report", "_cv_Core.Report");
		public boolean getPrinterSelectIsNotNull()
		{
			return !cx_CorePrinterSelect.getValueIsNull(context);
		}
		public String getPrinterSelect()
		{
			return (String)cx_CorePrinterSelect.getValue(context);
		}
		public void setPrinterSelect(String value)
		{
			cx_CorePrinterSelect.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrinterSelect = new ims.framework.ContextVariable("Core.PrinterSelect", "_cv_Core.PrinterSelect");
		public boolean getPrepareForPrintingIsNotNull()
		{
			return !cx_CorePrepareForPrinting.getValueIsNull(context);
		}
		public Boolean getPrepareForPrinting()
		{
			return (Boolean)cx_CorePrepareForPrinting.getValue(context);
		}
		public void setPrepareForPrinting(Boolean value)
		{
			cx_CorePrepareForPrinting.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePrepareForPrinting = new ims.framework.ContextVariable("Core.PrepareForPrinting", "_cv_Core.PrepareForPrinting");
		public boolean getTemplateIsNotNull()
		{
			return !cx_CoreTemplate.getValueIsNull(context);
		}
		public String getTemplate()
		{
			return (String)cx_CoreTemplate.getValue(context);
		}
		public void setTemplate(String value)
		{
			cx_CoreTemplate.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplate = new ims.framework.ContextVariable("Core.Template", "_cv_Core.Template");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getSpecimenWorkListItemsForPrintIsNotNull()
		{
			return !cx_CoreSpecimenWorkListItemsForPrint.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenWorkListItemListVoCollection getSpecimenWorkListItemsForPrint()
		{
			return (ims.ocrr.vo.SpecimenWorkListItemListVoCollection)cx_CoreSpecimenWorkListItemsForPrint.getValue(context);
		}
		public void setSpecimenWorkListItemsForPrint(ims.ocrr.vo.SpecimenWorkListItemListVoCollection value)
		{
			cx_CoreSpecimenWorkListItemsForPrint.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreSpecimenWorkListItemsForPrint = new ims.framework.ContextVariable("Core.SpecimenWorkListItemsForPrint", "_cv_Core.SpecimenWorkListItemsForPrint");

		private ims.framework.Context context;
	}
	public final class OCRRContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private OCRRContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPhlebotomyCollectSearchCriteriaIsNotNull()
		{
			return !cx_OCRRPhlebotomyCollectSearchCriteria.getValueIsNull(context);
		}
		public ims.ocrr.vo.PhlebotomyCollectSearchCriteriaVo getPhlebotomyCollectSearchCriteria()
		{
			return (ims.ocrr.vo.PhlebotomyCollectSearchCriteriaVo)cx_OCRRPhlebotomyCollectSearchCriteria.getValue(context);
		}
		public void setPhlebotomyCollectSearchCriteria(ims.ocrr.vo.PhlebotomyCollectSearchCriteriaVo value)
		{
			cx_OCRRPhlebotomyCollectSearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_OCRRPhlebotomyCollectSearchCriteria = new ims.framework.ContextVariable("OCRR.PhlebotomyCollectSearchCriteria", "_cvp_OCRR.PhlebotomyCollectSearchCriteria");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public OCRRContext OCRR;
}
