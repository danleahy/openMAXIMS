// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.appointmentpatientproceduredialog;

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
	public static class cmbReasonComboBox extends ComboBoxBridge
	{
		private static final long serialVersionUID = 1L;
		
		public void newRow(ims.core.vo.lookups.ProcedureIncompleteReason value, String text)
		{
			super.control.newRow(value, text);
		}
		public void newRow(ims.core.vo.lookups.ProcedureIncompleteReason value, String text, ims.framework.utils.Image image)
		{
			super.control.newRow(value, text, image);
		}
		public void newRow(ims.core.vo.lookups.ProcedureIncompleteReason value, String text, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, textColor);
		}
		public void newRow(ims.core.vo.lookups.ProcedureIncompleteReason value, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
		{
			super.control.newRow(value, text, image, textColor);
		}
		public boolean removeRow(ims.core.vo.lookups.ProcedureIncompleteReason value)
		{
			return super.control.removeRow(value);
		}
		public ims.core.vo.lookups.ProcedureIncompleteReason getValue()
		{
			return (ims.core.vo.lookups.ProcedureIncompleteReason)super.control.getValue();
		}
		public void setValue(ims.core.vo.lookups.ProcedureIncompleteReason value)
		{
			super.control.setValue(value);
		}
	}

	public static class OutcomeRadioButton extends RadioButtonBridge
	{
		private static final long serialVersionUID = 1L;
		
		protected void setContext(Integer startTabIndex, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize)
		{
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex ");
			RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 224, 136, 80, 16, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
			control.addButton(0, anchoringHelper1.getX(), anchoringHelper1.getY(), anchoringHelper1.getWidth(), "Incomplete", startTabIndex.intValue() + 1006);
			RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 144, 136, 80, 16, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
			control.addButton(1, anchoringHelper2.getX(), anchoringHelper2.getY(), anchoringHelper2.getWidth(), "Complete", startTabIndex.intValue() + 1005);
		}
		public void setText(OutcomeEnumeration option, String value)
		{
			if(option != null && option.id >= 0 && value != null)
				control.setText(option.id, value);
		}
		public OutcomeEnumeration getValue()
		{
			switch (super.control.getValue())
			{
				case -1: return OutcomeEnumeration.None;
				case 0: return OutcomeEnumeration.rdoIncomplete;
				case 1: return OutcomeEnumeration.rdoComplete;
			}
			return null;
		}
		public void setValue(OutcomeEnumeration value)
		{
			if(value != null)
				super.control.setValue(value.id);
			else
				super.control.setValue(OutcomeEnumeration.None.id);
		}
		public boolean isEnabled(OutcomeEnumeration option)
		{
			return super.control.isEnabled(option.id);
		}
		public void setEnabled(OutcomeEnumeration option, boolean value)
		{
			super.control.setEnabled(option.id, value);
		}
		public boolean isVisible(OutcomeEnumeration option)
		{
			return super.control.isVisible(option.id);
		}
		public void setVisible(OutcomeEnumeration option, boolean value)
		{
			super.control.setVisible(option.id, value);
		}
		public void setVisible(boolean value)
		{
			super.control.setVisible(value);
		}
		public void setEnabled(boolean value)
		{
			super.control.setEnabled(value);
		}
	}
	public static class OutcomeEnumeration implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		public static OutcomeEnumeration None = new OutcomeEnumeration(-1);
		public static OutcomeEnumeration rdoIncomplete = new OutcomeEnumeration(0);
		public static OutcomeEnumeration rdoComplete = new OutcomeEnumeration(1);
		private OutcomeEnumeration(int id)
		{
			this.id = id;
		}
		public boolean equals(Object o)
		{
			return this.id == ((OutcomeEnumeration)o).id;
		}
		private int id;
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
	}
	private void validateMandatoryContext(Context context)
	{
		if(new ims.framework.ContextVariable("RefMan.AppointmentPatientProcedure", "_cv_RefMan.AppointmentPatientProcedure").getValueIsNull(context))
			throw new ims.framework.exceptions.FormMandatoryContextMissingException("The required context data 'RefMan.AppointmentPatientProcedure' is not available.");
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
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
			validateMandatoryContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(752, 264);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));


		// Custom Controls
		ims.framework.CustomComponent instance1 = factory.getEmptyCustomComponent();
		RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 8, 152, 744, 56, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
		ims.framework.FormUiLogic m_ccAuthoringForm = loader.loadComponent(102228, appForm, startControlID * 10 + 1000, anchoringHelper3.getSize(), instance1, startTabIndex.intValue() + 1008, skipContextValidation);
		//ims.framework.Control m_ccAuthoringControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(8), new Integer(152), new Integer(744), new Integer(56), ControlState.DISABLED, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT, new Integer(startTabIndex.intValue() + 1008), m_ccAuthoringForm, instance1 } );
		ims.framework.Control m_ccAuthoringControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1001),  new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.DISABLED, ControlState.DISABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT, new Integer(startTabIndex.intValue() + 1008), m_ccAuthoringForm, instance1, Boolean.FALSE } );
		super.addControl(m_ccAuthoringControl);
		Menu[] menus1 = m_ccAuthoringForm.getForm().getRegisteredMenus();
		for(int x = 0; x < menus1.length; x++)
		{
			form.registerMenu(menus1[x]);
		}
		ims.framework.CustomComponent instance2 = factory.getEmptyCustomComponent();
		RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 8, 16, 744, 64, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT);
		ims.framework.FormUiLogic m_ccProcedureForm = loader.loadComponent(123133, appForm, startControlID * 10 + 2000, anchoringHelper4.getSize(), instance2, startTabIndex.intValue() + 1, skipContextValidation);
		//ims.framework.Control m_ccProcedureControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(8), new Integer(16), new Integer(744), new Integer(64), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT, new Integer(startTabIndex.intValue() + 1), m_ccProcedureForm, instance2 } );
		ims.framework.Control m_ccProcedureControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1003),  new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.TOPLEFTRIGHT, new Integer(startTabIndex.intValue() + 1), m_ccProcedureForm, instance2, Boolean.FALSE } );
		super.addControl(m_ccProcedureControl);
		Menu[] menus2 = m_ccProcedureForm.getForm().getRegisteredMenus();
		for(int x = 0; x < menus2.length; x++)
		{
			form.registerMenu(menus2[x]);
		}

		// Label Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 16, 90, 53, 17, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Primary:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper6 = new RuntimeAnchoring(designSize, runtimeSize, 352, 138, 50, 17, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper6.getX()), new Integer(anchoringHelper6.getY()), new Integer(anchoringHelper6.getWidth()), new Integer(anchoringHelper6.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Reason:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper7 = new RuntimeAnchoring(designSize, runtimeSize, 16, 136, 121, 17, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper7.getX()), new Integer(anchoringHelper7.getY()), new Integer(anchoringHelper7.getWidth()), new Integer(anchoringHelper7.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Procedure Outcome:", new Integer(1), null, new Integer(0)}));
		RuntimeAnchoring anchoringHelper8 = new RuntimeAnchoring(designSize, runtimeSize, 16, 114, 96, 17, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(Label.class, new Object[] { control, new Integer(startControlID.intValue() + 1007), new Integer(anchoringHelper8.getX()), new Integer(anchoringHelper8.getY()), new Integer(anchoringHelper8.getWidth()), new Integer(anchoringHelper8.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, "Procedure Date:", new Integer(1), null, new Integer(0)}));

		// Button Controls
		RuntimeAnchoring anchoringHelper9 = new RuntimeAnchoring(designSize, runtimeSize, 664, 232, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1008), new Integer(anchoringHelper9.getX()), new Integer(anchoringHelper9.getY()), new Integer(anchoringHelper9.getWidth()), new Integer(anchoringHelper9.getHeight()), new Integer(startTabIndex.intValue() + 2010), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Cancel", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
		RuntimeAnchoring anchoringHelper10 = new RuntimeAnchoring(designSize, runtimeSize, 584, 232, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1009), new Integer(anchoringHelper10.getX()), new Integer(anchoringHelper10.getY()), new Integer(anchoringHelper10.getWidth()), new Integer(anchoringHelper10.getHeight()), new Integer(startTabIndex.intValue() + 2009), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Save", Boolean.FALSE, null, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));

		// PartialDateBox Controls
		RuntimeAnchoring anchoringHelper11 = new RuntimeAnchoring(designSize, runtimeSize, 144, 112, 152, 20, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT);
		super.addControl(factory.getControl(PartialDateBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1010), new Integer(anchoringHelper11.getX()), new Integer(anchoringHelper11.getY()), new Integer(anchoringHelper11.getWidth()), new Integer(anchoringHelper11.getHeight()), new Integer(startTabIndex.intValue() + 1004), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT, null, Boolean.TRUE, Boolean.FALSE}));

		// ComboBox Controls
		RuntimeAnchoring anchoringHelper12 = new RuntimeAnchoring(designSize, runtimeSize, 408, 136, 328, 21, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT);
		ComboBox m_cmbReasonTemp = (ComboBox)factory.getControl(ComboBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1011), new Integer(anchoringHelper12.getX()), new Integer(anchoringHelper12.getY()), new Integer(anchoringHelper12.getWidth()), new Integer(anchoringHelper12.getHeight()), new Integer(startTabIndex.intValue() + 1007), ControlState.UNKNOWN, ControlState.UNKNOWN,ims.framework.enumerations.ControlAnchoring.BOTTOMLEFTRIGHT ,Boolean.TRUE, Boolean.FALSE, SortOrder.NONE, Boolean.FALSE, new Integer(1), null, Boolean.TRUE, new Integer(-1)});
		addControl(m_cmbReasonTemp);
		cmbReasonComboBox cmbReason = (cmbReasonComboBox)ComboBoxFlyweightFactory.getInstance().createComboBoxBridge(cmbReasonComboBox.class, m_cmbReasonTemp);
		super.addComboBox(cmbReason);

		// CheckBox Controls
		RuntimeAnchoring anchoringHelper13 = new RuntimeAnchoring(designSize, runtimeSize, 144, 90, 16, 16, ims.framework.enumerations.ControlAnchoring.TOPLEFT);
		super.addControl(factory.getControl(CheckBox.class, new Object[] { control, new Integer(startControlID.intValue() + 1012), new Integer(anchoringHelper13.getX()), new Integer(anchoringHelper13.getY()), new Integer(anchoringHelper13.getWidth()), new Integer(anchoringHelper13.getHeight()), new Integer(startTabIndex.intValue() + 1002), ControlState.DISABLED, ControlState.ENABLED,ims.framework.enumerations.ControlAnchoring.TOPLEFT ,"", Boolean.FALSE, null}));

		// RadioButton Controls
		RadioButton tmpOutcome = (RadioButton)factory.getControl(RadioButton.class, new Object[] { control, new Integer(startControlID.intValue() + 1013), new Integer(0), ControlState.DISABLED, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMLEFT,Boolean.TRUE});
		super.addControl(tmpOutcome);
		OutcomeRadioButton Outcome = (OutcomeRadioButton)RadioButtonBridgeFlyweightFactory.getInstance().createRadioButtonBridge(OutcomeRadioButton.class, tmpOutcome);
		Outcome.setContext(startTabIndex, designSize, runtimeSize);
		super.addRadioButton(Outcome);
	}


	public ims.core.forms.authoringinfo.IComponent ccAuthoring()
	{
		return (ims.core.forms.authoringinfo.IComponent)((ims.framework.cn.controls.CustomComponent)super.getControl(0)).getLogic();
	}
	public void setccAuthoringValueChangedEvent(ims.framework.delegates.ValueChanged delegate)
	{
		((CustomComponent)super.getControl(0)).setValueChangedEvent(delegate);
	}
	public void setccAuthoringVisible(boolean value)
	{
		((ims.framework.Control)super.getControl(0)).setVisible(value);
	}
	public boolean isccAuthoringVisible()
	{
		return ((ims.framework.Control)super.getControl(0)).isVisible();
	}
	public void setccAuthoringEnabled(boolean value)
	{
		((ims.framework.Control)super.getControl(0)).setEnabled(value);
	}
	public boolean isccAuthoringEnabled()
	{
		return ((ims.framework.Control)super.getControl(0)).isEnabled();
	}
	public ims.clinical.forms.clinicalcoding.IComponent ccProcedure()
	{
		return (ims.clinical.forms.clinicalcoding.IComponent)((ims.framework.cn.controls.CustomComponent)super.getControl(1)).getLogic();
	}
	public void setccProcedureValueChangedEvent(ims.framework.delegates.ValueChanged delegate)
	{
		((CustomComponent)super.getControl(1)).setValueChangedEvent(delegate);
	}
	public void setccProcedureVisible(boolean value)
	{
		((ims.framework.Control)super.getControl(1)).setVisible(value);
	}
	public boolean isccProcedureVisible()
	{
		return ((ims.framework.Control)super.getControl(1)).isVisible();
	}
	public void setccProcedureEnabled(boolean value)
	{
		((ims.framework.Control)super.getControl(1)).setEnabled(value);
	}
	public boolean isccProcedureEnabled()
	{
		return ((ims.framework.Control)super.getControl(1)).isEnabled();
	}
	public Label lblReason()
	{
		return (Label)super.getControl(3);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(6);
	}
	public Button btnSave()
	{
		return (Button)super.getControl(7);
	}
	public PartialDateBox pdtProcDate()
	{
		return (PartialDateBox)super.getControl(8);
	}
	public cmbReasonComboBox cmbReason()
	{
		return (cmbReasonComboBox)super.getComboBox(0);
	}
	public CheckBox chkPrimary()
	{
		return (CheckBox)super.getControl(10);
	}
	public OutcomeRadioButton Outcome()
	{
		return (OutcomeRadioButton)super.getRadioButton(0);
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
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
			IReportField[] fields = new IReportField[81];
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
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_RefMan.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			fields[71] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-ID", "ID_PatientProcedure");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-PROCEDUREDESCRIPTION", "ProcedureDescription");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-INFOSOURCE", "InfoSource");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-CARECONTEXT", "CareContext");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-EPISODEOFCARE", "EpisodeOfCare");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-PROCDATE", "ProcDate");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-PROCEDURESTATUS", "ProcedureStatus");
			fields[78] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1003100017-INCOMPLETEREASON", "IncompleteReason");
			fields[79] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1096100060-APPOINTMENT", "Appointment");
			fields[80] = new ims.framework.ReportField(this.context, "_cv_RefMan.AppointmentPatientProcedure", "BO-1096100060-ISPRIMARYPROCEDURE", "IsPrimaryProcedure");
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
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}