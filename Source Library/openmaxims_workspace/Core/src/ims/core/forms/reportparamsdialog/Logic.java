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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.66 build 3271.26979)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.reportparamsdialog;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.tree.DefaultElement;

import ims.admin.vo.ReportSeedParsedVo;
import ims.admin.vo.ReportSeedParsedVoCollection;
import ims.core.helper.ReportSeedsHelper;
import ims.core.vo.GpShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.OrgShortVo;
import ims.core.vo.PersonName;
import ims.core.vo.lookups.HcpDisType;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;
import ims.framework.utils.PartialDate;
import ims.vo.ValueObjectCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final String	NAME_COLUMN			= "0";
	private static final String	VALUE_COLUMN		= "1";
	private static final String	MANDATORY_COLUMN	= "2";
	
	private static final String	INTEGER			= "java.lang.Integer";
	private static final String	BIG_INTEGER		= "java.math.BigInteger";
	private static final String	SHORT			= "java.lang.Short";
	private static final String	LONG			= "java.lang.Long";
	private static final String	BOOOLEAN		= "java.lang.Boolean";
	private static final String	STRING			= "java.lang.String";
	private static final String	BIG_DECIMAL		= "java.math.BigDecimal";
	private static final String	FLOAT			= "java.lang.Float";
	private static final String	DOUBLE			= "java.lang.Double";
	private static final String	UTIL_DATE		= "java.util.Date";
	private static final String	SQL_DATE		= "java.sql.Date";
	private static final String	SQL_TIME		= "java.sql.Time";
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if(!form.getGlobalContext().Core.getImsReportIdIsNotNull())
			return;
		
		String[] obj = domain.getSystemReportAndTemplate(form.getGlobalContext().Core.getImsReportId());
		
		if(obj == null)
		{
			engine.showMessage("The report having the ImsId = " + form.getGlobalContext().Core.getImsReportId() + " could not be retrieved !");
			return;
		}
		
		try
		{
			parseSeedsFromXML(obj[0]);
		}
		catch (DocumentException e)
		{
			engine.showMessage("Error deserializing Seeds: " + e.toString());
			return;
		}
		
		initialize();
		populateDynamicGrid();
		
		if(form.dyngrdParameters().getRows().size() == 0)
		{
			onBtnOkClick();
		}
		
	}
	@Override
	protected void onDyngrdParametersCellTextSubmited(ims.framework.controls.DynamicGridCell cell)
	{
		if (cell == null)
			return;

		if (cell.getType().equals(DynamicCellType.QUERYCOMBOBOX))
		{
			Object identifier = cell.getIdentifier();
			if (identifier != null)
			{
				if (identifier.equals(ReportSeedsHelper.GP_BO))
				{
					listGps(cell);
				}

				if (identifier.equals(ReportSeedsHelper.HCP_BO))
				{
					listHCPs(cell, null);
				}

				if (identifier.equals(ReportSeedsHelper.MEDIC_BO))
				{
					listHCPs(cell, HcpDisType.MEDICAL);
				}

				if (identifier.equals(ReportSeedsHelper.MOS_BO))
				{
					listMOS(cell);
				}

				if (identifier.equals(ReportSeedsHelper.ORG_BO))
				{
					listOrganisation(cell);
				}

				if (identifier.equals(ReportSeedsHelper.LOCATION_BO))
				{
					listLocation(cell);
				}

				if (identifier.equals(ReportSeedsHelper.LOC_SITE_BO))
				{
					listLocSite(cell);
				}
			}
		}
	}
	@Override
	protected void onBtnOkClick() throws ims.framework.exceptions.PresentationLogicException
	{
		ReportSeedParsedVoCollection seeds = new ReportSeedParsedVoCollection();
		for (int i = 0; i < form.dyngrdParameters().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdParameters().getRows().get(i);
			if (row.getValue() instanceof ReportSeedParsedVo)
			{
				ReportSeedParsedVo seed = (ReportSeedParsedVo) row.getValue();
				DynamicGridCell valueCell = row.getCells().get(getColumn(VALUE_COLUMN));
				seed = setSeedValue(valueCell, seed);
				seeds.add(seed);
			}
		}

		form.getGlobalContext().Admin.setReportSeedParsed(seeds);

		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private void initialize()
	{
		createSeedColumns();
	}

	private void createSeedColumns()
	{
		form.dyngrdParameters().clear();
		DynamicGridColumn nameCol = form.dyngrdParameters().getColumns().newColumn("Name", NAME_COLUMN);
		nameCol.setWidth(250);
		nameCol.setBackColor(Color.Gray);
		nameCol.setReadOnly(true);

		DynamicGridColumn seedCol = form.dyngrdParameters().getColumns().newColumn("Value", VALUE_COLUMN);
		seedCol.setWidth(205);
		
		DynamicGridColumn mandatoryCol = form.dyngrdParameters().getColumns().newColumn("", MANDATORY_COLUMN);
		mandatoryCol.setWidth(-1);
		mandatoryCol.setAlignment(Alignment.CENTER);
	}

	private void populateDynamicGrid()
	{
		ReportSeedParsedVoCollection voColl = form.getGlobalContext().Admin.getReportSeedParsed();
		createSeedRows(voColl);
	}

	private void createSeedRows(ReportSeedParsedVoCollection voColl)
	{
		if (voColl == null)
			return;

		for (int i = 0; i < voColl.size(); i++)
		{
			addSeed(voColl.get(i));
		}
	}

	private void addSeed(ReportSeedParsedVo voSeed)
	{
		if (voSeed == null)
			return;

		DynamicGridRow row = form.dyngrdParameters().getRows().newRow();

		DynamicGridCell nameCell = row.getCells().newCell(getColumn(NAME_COLUMN), DynamicCellType.WRAPTEXT);
		String seedName = getReportSeed().getCellName(voSeed);
		nameCell.setValue(seedName);
		nameCell.setReadOnly(true);

		DynamicCellType cellType = null;
		
		if(voSeed.getType().equalsIgnoreCase(INTEGER) && (voSeed.getName().equalsIgnoreCase("DOB") || voSeed.getName().equalsIgnoreCase("DOB_START") || voSeed.getName().equalsIgnoreCase("DOB_END") || voSeed.getName().equalsIgnoreCase("DATE_OF_BIRTH_FROM") || voSeed.getName().equalsIgnoreCase("DATE_OF_BIRTH_TO")))
		{
			cellType = DynamicCellType.PARTIALDATE;
		}
		else
			cellType = getReportSeed().getCellType(voSeed);
		
		Object value = getReportSeed().getValue(voSeed);

		DynamicGridCell valueCell = row.getCells().newCell(getColumn(VALUE_COLUMN), cellType);
		if (cellType.equals(DynamicCellType.QUERYCOMBOBOX))
		{
			valueCell.getItems().newItem(value);
			valueCell.setAutoPostBack(true);
		}

		if(cellType.equals(DynamicCellType.PARTIALDATE) && value instanceof java.lang.Integer)
		{
			valueCell.setValue(new PartialDate((Integer)value));
		}
		else
		{	
			valueCell.setValue(value);
		}
		
		valueCell.setIdentifier(getReportSeed().getIdentifier(voSeed));

		boolean canBeNull = voSeed == null ? true : voSeed.getCanBeNull().booleanValue();
		valueCell.setCanBeEmpty(canBeNull);
		
		if(canBeNull == false)
		{
			DynamicGridCell mandatoryCell = row.getCells().newCell(getColumn(MANDATORY_COLUMN), DynamicCellType.HTMLVIEW);
			mandatoryCell.setValue("<font color='#FF0000' size='3'>*</font>");
			mandatoryCell.setTooltip("Required");
			
			valueCell.setValidationMessage(seedName + " is mandatory");
		}
		
		row.setValue(voSeed);
	}

	private DynamicGridColumn getColumn(String columnIdentifier)
	{
		if (columnIdentifier == null)
			return null;

		return form.dyngrdParameters().getColumns().getByIdentifier(columnIdentifier);
	}

	private ReportSeedsHelper getReportSeed()
	{
		return new ReportSeedsHelper(engine);
	}

	private void listGps(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		populateCellItems(cell, domain.listGPsBySurname(cell.getTypedText()));
	}

	private void listHCPs(DynamicGridCell cell, HcpDisType hcpDisciplineType)
	{
		if (cell == null)
			return;

		HcpLiteVoCollection voColl = domain.listHcpLiteByNameAndDisciplineType(cell.getTypedText(), hcpDisciplineType);
		populateCellItems(cell, voColl);
	}

	private void listMOS(DynamicGridCell cell)
	{
		MemberOfStaffShortVo filter = new MemberOfStaffShortVo();
		PersonName personName = new PersonName();
		personName.setSurname(cell.getTypedText());
		filter.setName(personName);
		filter.setIsActive(Boolean.TRUE);

		populateCellItems(cell, domain.listMembersOfStaff(filter));
	}

	private void listOrganisation(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		OrgShortVo filter = new OrgShortVo();
		filter.setName(cell.getTypedText());
		filter.setIsActive(Boolean.TRUE);

		populateCellItems(cell, domain.listOrganisationsShort(filter));
	}

	private void listLocSite(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		populateCellItems(cell, domain.listLocSite(cell.getTypedText()));
	}

	private void listLocation(DynamicGridCell cell)
	{
		if (cell == null)
			return;

		populateCellItems(cell, domain.listLocationByName(cell.getTypedText()));
	}

	private void populateCellItems(DynamicGridCell cell, ValueObjectCollection voColl)
	{
		cell.getItems().clear();

		for (int i = 0; voColl != null && i < voColl.getItems().length; i++)
		{
			cell.getItems().newItem(voColl.getItems()[i]);
		}

		if (voColl != null && voColl.getItems() != null)
		{
			if (voColl.getItems().length == 1)
				cell.setValue(voColl.getItems()[0]);
			else if (voColl.getItems().length > 1)
				cell.showOpened();
		}
	}
	
	private ReportSeedParsedVo setSeedValue(DynamicGridCell valueCell, ReportSeedParsedVo seed)
	{
		if (valueCell == null)
			return seed;

		Object value = valueCell.getValue();
		if (value == null)
			return seed;
		
		if (value instanceof GpShortVo)
		{
			seed.setValue(((GpShortVo) value).getID_Gp().toString());
			seed.setGP(((GpShortVo) value));
		}
		else if (value instanceof HcpLiteVo)
		{
			seed.setValue(((HcpLiteVo) value).getID_Hcp().toString());
			seed.setHCP((HcpLiteVo) value);
		}
		else if (value instanceof MemberOfStaffShortVo)
		{
			seed.setValue(((MemberOfStaffShortVo) value).getID_MemberOfStaff().toString());
			seed.setMOS((MemberOfStaffShortVo) value);
		}
		else if (value instanceof OrgShortVo)
		{
			seed.setValue(((OrgShortVo) value).getID_Organisation().toString());
			seed.setOrganisation(((OrgShortVo) value));
		}
		else if (value instanceof LocSiteLiteVo)
		{
			seed.setValue(((LocSiteLiteVo) value).getID_Location().toString());
			seed.setLocSite((LocSiteLiteVo) value);
		}
		else if (value instanceof LocationLiteVo)
		{
			seed.setValue(((LocationLiteVo) value).getID_Location().toString());
			seed.setLocation((LocationLiteVo) value);
		}
		else if (value instanceof DateTime)
		{
			seed.setValue(((DateTime)value).toString(DateTimeFormat.ISO_SECS));
		}
		else if (value instanceof PartialDate && seed.getType().equalsIgnoreCase(INTEGER))
		{
			seed.setValue(((PartialDate)value).toInteger().toString());
		}
		else
		{
			seed.setValue(value.toString());	
		}

		return seed;
	}
	
	private void parseSeedsFromXML(String reportXML) throws DocumentException
	{
		Document document = DocumentHelper.parseText(reportXML);

		ReportSeedParsedVoCollection seeds = new ReportSeedParsedVoCollection();
		List list = document.selectNodes("//Project/Seeds/Seed");
		for (Iterator iter = list.iterator(); iter.hasNext();)
		{
			DefaultElement attribute = (DefaultElement) iter.next();

			ReportSeedParsedVo seed = new ReportSeedParsedVo();
			seed.setName(attribute.valueOf("Name"));
			seed.setType(attribute.valueOf("Type"));
			seed.setBOName(attribute.valueOf("BOName"));
			seed.setBOField(attribute.valueOf("BOField"));
			seed.setCanBeNull(new Boolean(attribute.valueOf("CanBeNull").equalsIgnoreCase("true")));
			seeds.add(seed);
		}

		form.getGlobalContext().Admin.setReportSeedParsed(seeds);
	}
	
}
