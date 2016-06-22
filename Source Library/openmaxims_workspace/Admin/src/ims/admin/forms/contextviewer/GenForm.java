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

package ims.admin.forms.contextviewer;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	public static class grdContextDataRow extends GridRowBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected grdContextDataRow(GridRow row)
		{
			super(row);
		}
		public void showOpened(int column)
		{
			super.row.showOpened(column);
		}
		public void setIsParentRow(boolean value)
		{
			super.setIsParentRow(value);
		}
		public boolean isParentRow()
		{
			return super.isParentRow();
		}
		public void setExpanded(boolean value)
		{
			super.setExpanded(value);
		}
		public boolean isExpanded()
		{
			return super.isExpanded();
		}
		public void setColKeyReadOnly(boolean value)
		{
			super.row.setReadOnly(0, value);
		}
		public boolean isColKeyReadOnly()
		{
			return super.row.isReadOnly(0);
		}
		public void showColKeyOpened()
		{
			super.row.showOpened(0);
		}
		public void setTooltipForColKey(String value)
		{
			super.row.setTooltip(0, value);
		}
		public String getColKey()
		{
			return (String)super.row.get(0);
		}
		public void setColKey(String value)
		{
			super.row.set(0, value);
		}
		public void setCellColKeyTooltip(String value)
		{
			super.row.setTooltip(0, value);
		}
		public void setColTypeReadOnly(boolean value)
		{
			super.row.setReadOnly(1, value);
		}
		public boolean isColTypeReadOnly()
		{
			return super.row.isReadOnly(1);
		}
		public void showColTypeOpened()
		{
			super.row.showOpened(1);
		}
		public void setTooltipForColType(String value)
		{
			super.row.setTooltip(1, value);
		}
		public String getColType()
		{
			return (String)super.row.get(1);
		}
		public void setColType(String value)
		{
			super.row.set(1, value);
		}
		public void setCellColTypeTooltip(String value)
		{
			super.row.setTooltip(1, value);
		}
		public void setColSizeReadOnly(boolean value)
		{
			super.row.setReadOnly(2, value);
		}
		public boolean isColSizeReadOnly()
		{
			return super.row.isReadOnly(2);
		}
		public void showColSizeOpened()
		{
			super.row.showOpened(2);
		}
		public void setTooltipForColSize(String value)
		{
			super.row.setTooltip(2, value);
		}
		public String getColSize()
		{
			return (String)super.row.get(2);
		}
		public void setColSize(String value)
		{
			super.row.set(2, value);
		}
		public void setCellColSizeTooltip(String value)
		{
			super.row.setTooltip(2, value);
		}
		public void setColValueReadOnly(boolean value)
		{
			super.row.setReadOnly(3, value);
		}
		public boolean isColValueReadOnly()
		{
			return super.row.isReadOnly(3);
		}
		public void showColValueOpened()
		{
			super.row.showOpened(3);
		}
		public void setTooltipForColValue(String value)
		{
			super.row.setTooltip(3, value);
		}
		public String getColValue()
		{
			return (String)super.row.get(3);
		}
		public void setColValue(String value)
		{
			super.row.set(3, value);
		}
		public void setCellColValueTooltip(String value)
		{
			super.row.setTooltip(3, value);
		}
		public String getValue()
		{
			return (String)super.row.getValue();
		}
		public void setValue(String value)
		{
			super.row.setValue(value);
		}
		public grdContextDataRow getParentRow()
		{
			return super.row.getParent() == null ? null : new grdContextDataRow(super.row.getParent());
		}
		public grdContextDataRowCollection getRows()
		{
			if(this.collection == null)
				this.collection = new grdContextDataRowCollection(super.row.getRows());
			return this.collection;
		}
		private grdContextDataRowCollection collection;
	}
	public static class grdContextDataRowCollection extends GridRowCollectionBridge
	{
		private static final long serialVersionUID = 1L;
		
		private grdContextDataRowCollection(GridRowCollection collection)
		{
			super(collection);
		}
		public grdContextDataRow get(int index)
		{
			return new grdContextDataRow(super.collection.get(index));
		}
		public grdContextDataRow newRow()
		{
			return new grdContextDataRow(super.collection.newRow());
		}
		public grdContextDataRow newRow(boolean autoSelect)
		{
			return new grdContextDataRow(super.collection.newRow(autoSelect));
		}
		public grdContextDataRow newRowAt(int index)
		{
			return new grdContextDataRow(super.collection.newRowAt(index));
		}
		public grdContextDataRow newRowAt(int index, boolean autoSelect)
		{
			return new grdContextDataRow(super.collection.newRowAt(index, autoSelect));
		}
	}
	public static class grdContextDataGrid extends GridBridge
	{
		private static final long serialVersionUID = 1L;
		
		public GenForm.grdContextDataRow[] getAllRows()
		{
			java.util.ArrayList rows = new java.util.ArrayList();
			for(int x = 0; x < getRows().size(); x++)
			{
				GenForm.grdContextDataRow row = getRows().get(x);
				rows.add(row);
				GenForm.grdContextDataRow[] childRows = getAllRows(row);
				for(int i = 0; i < childRows.length; i++)
				{
					rows.add(childRows[i]);
				}
			}
			GenForm.grdContextDataRow[] result = new GenForm.grdContextDataRow[rows.size()];
			for(int x = 0; x < rows.size(); x++)
			{
				result[x] = (GenForm.grdContextDataRow)rows.get(x);
			}
			return result;
		}
		public GenForm.grdContextDataRow[] getAllRows(GenForm.grdContextDataRow parentRow)
		{
			java.util.ArrayList rows = new java.util.ArrayList();
			for(int x = 0; x < parentRow.getRows().size(); x++)
			{
				GenForm.grdContextDataRow row = parentRow.getRows().get(x);
				rows.add(row);
				GenForm.grdContextDataRow[] childRows = getAllRows(row);
				for(int i = 0; i < childRows.length; i++)
				{
					rows.add(childRows[i]);
				}
			}
			GenForm.grdContextDataRow[] result = new GenForm.grdContextDataRow[rows.size()];
			for(int x = 0; x < rows.size(); x++)
			{
				result[x] = (GenForm.grdContextDataRow)rows.get(x);
			}
			return result;
		}
		public void expandAll()
		{
			expandCollapseAll(true);
		}
		public void collapseAll()
		{
			expandCollapseAll(false);
		}
		private void expandCollapseAll(boolean expand)
		{
			for(int x = 0; x < getRows().size(); x++)
			{
				GenForm.grdContextDataRow row = getRows().get(x);
				row.setExpanded(expand);
				expandCollapseRow(row, expand);
			}
		}
		private void expandCollapseRow(GenForm.grdContextDataRow parentRow, boolean expand)
		{
			for(int x = 0; x < parentRow.getRows().size(); x++)
			{
				GenForm.grdContextDataRow row = parentRow.getRows().get(x);
				row.setExpanded(expand);
				expandCollapseRow(row, expand);
			}
		}
		private void addTreeColumn(String caption, int captionAlignment, int width, boolean bold, boolean canGrow)
		{
			super.grid.addTreeColumn(caption, captionAlignment, width, bold, canGrow);
		}
		private void addStringColumn(String caption, int captionAlignment, int alignment, int width, boolean readOnly, boolean bold, int sortOrder, int maxLength, boolean canGrow, ims.framework.enumerations.CharacterCasing casing)
		{
			super.grid.addStringColumn(caption, captionAlignment, alignment, width, readOnly, bold, sortOrder, maxLength, canGrow, casing);
		}
		public String[] getValues()
		{
			String[] listOfValues = new String[this.getRows().size()];
			for(int x = 0; x < this.getRows().size(); x++)
			{
				listOfValues[x] = this.getRows().get(x).getValue();
			}
			return listOfValues;
		}
		public String getValue()
		{
			return (String)super.grid.getValue();
		}
		public void setValue(String value)
		{
			super.grid.setValue(value);
		}
		public grdContextDataRow getSelectedRow()
		{
			return super.grid.getSelectedRow() == null ? null : new grdContextDataRow(super.grid.getSelectedRow());
		}
		public int getSelectedRowIndex()
		{
			return super.grid.getSelectedRowIndex();
		}
		public grdContextDataRowCollection getRows()
		{
			return new grdContextDataRowCollection(super.grid.getRows());
		}
		public grdContextDataRow getRowByValue(String value)
		{
			GridRow row = super.grid.getRowByValue(value);
			return row == null?null:new grdContextDataRow(row);
		}
		public void setColKeyHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(0, value);
		}
		public String getColKeyHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(0);
		}
		public void setColTypeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(1, value);
		}
		public String getColTypeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(1);
		}
		public void setColSizeHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(2, value);
		}
		public String getColSizeHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(2);
		}
		public void setColValueHeaderTooltip(String value)
		{
			super.grid.setColumnHeaderTooltip(3, value);
		}
		public String getColValueHeaderTooltip()
		{
			return super.grid.getColumnHeaderTooltip(3);
		}
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(848, 576);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());


		// Button Controls
		RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 757, 536, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), new Integer(-1), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Close", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// Grid Controls
		RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 16, 16, 816, 512, ims.framework.enumerations.ControlAnchoring.ALL);
		Grid m_grdContextDataTemp = (Grid)factory.getControl(Grid.class, new Object[] { control, new Integer(startControlID.intValue() + 1001), new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), new Integer(-1), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,Boolean.FALSE, Boolean.FALSE, new Integer(24), Boolean.TRUE, null, Boolean.FALSE, Boolean.FALSE, new Integer(50), null, Boolean.TRUE, Boolean.TRUE});
		addControl(m_grdContextDataTemp);
		grdContextDataGrid grdContextData = (grdContextDataGrid)GridFlyweightFactory.getInstance().createGridBridge(grdContextDataGrid.class, m_grdContextDataTemp);
		grdContextData.addTreeColumn("Key", 0, 180, false, true);
		grdContextData.addStringColumn("Type", 0, 0, 200, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdContextData.addStringColumn("Size", 0, 0, 100, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		grdContextData.addStringColumn("Value", 0, 0, -1, true, false, 0, 0, true, ims.framework.enumerations.CharacterCasing.NORMAL);
		super.addGrid(grdContextData);
	}


	public Button btnOK()
	{
		return (Button)super.getControl(0);
	}
	public grdContextDataGrid grdContextData()
	{
		return (grdContextDataGrid)super.getGrid(0);
	}
	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[144];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DEMENTIABREACHDATETIME", "DementiaBreachDateTime");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DEMENTIAWORKLISTSTATUS", "DementiaWorklistStatus");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MRNSTATUS", "MRNStatus");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-HASSCANNEDCASENOTEFOLDERS", "HasScannedCaseNoteFolders");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISCONFIDENTIAL", "IsConfidential");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFBIRTH", "TimeOfBirth");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-PATIENTCATEGORY", "PatientCategory");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPAENDOSCOPIST", "IsHCPaEndoscopist");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-ID", "ID_NAESReferral");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-DATEREFERRALRECEIVED", "DateReferralReceived");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-DATEOFSURGERY", "DateOfSurgery");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-REFERRINGHOSPITAL", "ReferringHospital");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-REFERRINGDOCTOR", "ReferringDoctor");
			fields[71] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-REFERRALREASON", "ReferralReason");
			fields[72] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-SECONDARYSURGERY", "SecondarySurgery");
			fields[73] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-UNDERLYINGREASON", "UnderlyingReason");
			fields[74] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-AFFECTEDEYE", "AffectedEye");
			fields[75] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-IMPLANT", "Implant");
			fields[76] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-IMPLANTTYPE", "ImplantType");
			fields[77] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-INTERPRETERREQUIRED", "InterpreterRequired");
			fields[78] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-LANGUAGE", "Language");
			fields[79] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-LANGUAGEIFOTHER", "LanguageIfOther");
			fields[80] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-REFERREDBY", "ReferredBy");
			fields[81] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-_6WEEKKPI", "SixWeekKPI");
			fields[82] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-_3WEEKKPI", "ThreeWeekKPI");
			fields[83] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-PREFERREDCLINIC", "PreferredClinic");
			fields[84] = new ims.framework.ReportField(this.context, "_cvp_Naes.Referral", "BO-1097100004-NOTES", "Notes");
			fields[85] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[86] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[87] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[88] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[89] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[90] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[91] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[92] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[93] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[94] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[95] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientClinicalNotesSearchCriteria", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[96] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientClinicalNotesSearchCriteria", "BO-1011100000-NOTETYPE", "NoteType");
			fields[97] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientClinicalNotesSearchCriteria", "BO-1011100000-FORREVIEW", "ForReview");
			fields[98] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientClinicalNotesSearchCriteria", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[99] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-ID", "ID_ObservationForm");
			fields[100] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-FORMTYPE", "FormType");
			fields[101] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-DETAILS", "Details");
			fields[102] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-DATETIMESTART", "DateTimeStart");
			fields[103] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-DATETIMESTOP", "DateTimeStop");
			fields[104] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-ISSTOPPED", "IsStopped");
			fields[105] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-CARECONTEXT", "CareContext");
			fields[106] = new ims.framework.ReportField(this.context, "_cvp_Nursing.ObservationFormsSearchCriteria", "BO-1011100002-CLINICALCONTACT", "ClinicalContact");
			fields[107] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesAdmSearchCriteia", "BO-1072100034-ID", "ID_MedicationOverview");
			fields[108] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesAdmSearchCriteia", "BO-1072100034-TYPE", "Type");
			fields[109] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesAdmSearchCriteia", "BO-1072100034-CARECONTEXT", "CareContext");
			fields[110] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesDisSearchCriteria", "BO-1072100034-ID", "ID_MedicationOverview");
			fields[111] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesDisSearchCriteria", "BO-1072100034-TYPE", "Type");
			fields[112] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesDisSearchCriteria", "BO-1072100034-CARECONTEXT", "CareContext");
			fields[113] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesOPDSearchCriteria", "BO-1072100034-ID", "ID_MedicationOverview");
			fields[114] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesOPDSearchCriteria", "BO-1072100034-TYPE", "Type");
			fields[115] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesOPDSearchCriteria", "BO-1072100034-CARECONTEXT", "CareContext");
			fields[116] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesPatSearchCriteria", "BO-1072100034-ID", "ID_MedicationOverview");
			fields[117] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesPatSearchCriteria", "BO-1072100034-TYPE", "Type");
			fields[118] = new ims.framework.ReportField(this.context, "_cvp_Clinical.MedMultipleDosesPatSearchCriteria", "BO-1072100034-CARECONTEXT", "CareContext");
			fields[119] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-ID", "ID_Urinalysis");
			fields[120] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-NOABNORMALITYDETECTED", "NoAbnormalityDetected");
			fields[121] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-LEUCOCYTES", "Leucocytes");
			fields[122] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-PROTEIN", "Protein");
			fields[123] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-BLOOD", "Blood");
			fields[124] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-KETONES", "Ketones");
			fields[125] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-ASCORBICACID", "AscorbicAcid");
			fields[126] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-GLUCOSE", "Glucose");
			fields[127] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-BILIRUBIN", "Bilirubin");
			fields[128] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-UROBILINOGEN", "Urobilinogen");
			fields[129] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-NITRATE", "Nitrate");
			fields[130] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-PH", "PH");
			fields[131] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-SPECIFICGRAVITY", "SpecificGravity");
			fields[132] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-NOSAMPLE", "NoSample");
			fields[133] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-ISACTIVE", "IsActive");
			fields[134] = new ims.framework.ReportField(this.context, "_cvp_Core.UrinalysisSearchCriteria", "BO-1022100012-CARECONTEXT", "CareContext");
			fields[135] = new ims.framework.ReportField(this.context, "_cvp_Core.PDSPatientFilterSearchCriteria", "BO-1001100000-ID", "ID_Patient");
			fields[136] = new ims.framework.ReportField(this.context, "_cvp_Core.PDSPatientFilterSearchCriteria", "BO-1001100000-SEX", "Sex");
			fields[137] = new ims.framework.ReportField(this.context, "_cvp_Core.PDSPatientFilterSearchCriteria", "BO-1001100000-DOB", "Dob");
			fields[138] = new ims.framework.ReportField(this.context, "_cvp_Core.LocalPatientFilterSearchCriteria", "BO-1001100000-ID", "ID_Patient");
			fields[139] = new ims.framework.ReportField(this.context, "_cvp_Core.LocalPatientFilterSearchCriteria", "BO-1001100000-SEX", "Sex");
			fields[140] = new ims.framework.ReportField(this.context, "_cvp_Core.LocalPatientFilterSearchCriteria", "BO-1001100000-DOB", "Dob");
			fields[141] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[142] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[143] = new ims.framework.ReportField(this.context, "_cvp_RefMan.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private IReportField[] reportFields = null;
}
