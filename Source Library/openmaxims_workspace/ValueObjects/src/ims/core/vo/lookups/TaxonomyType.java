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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TaxonomyType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TaxonomyType()
	{
		super();
	}
	public TaxonomyType(int id)
	{
		super(id, "", true);
	}
	public TaxonomyType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TaxonomyType(int id, String text, boolean active, TaxonomyType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TaxonomyType(int id, String text, boolean active, TaxonomyType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TaxonomyType(int id, String text, boolean active, TaxonomyType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TaxonomyType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TaxonomyType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TaxonomyType)super.getParentInstance();
	}
	public TaxonomyType getParent()
	{
		return (TaxonomyType)super.getParentInstance();
	}
	public void setParent(TaxonomyType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TaxonomyType[] typedChildren = new TaxonomyType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TaxonomyType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TaxonomyType)
		{
			super.addChild((TaxonomyType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TaxonomyType)
		{
			super.removeChild((TaxonomyType)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		TaxonomyTypeCollection result = new TaxonomyTypeCollection();
		result.add(READ3);
		result.add(ICD10);
		result.add(ICD9);
		result.add(SNOMED);
		result.add(EXCH);
		result.add(NOMI);
		result.add(ICAB);
		result.add(PAS);
		result.add(RAD);
		result.add(PATH);
		result.add(NAT_CONS_CODE);
		result.add(NAT_GP_CODE);
		result.add(MCN_NO);
		result.add(AN_BORD_ALTRANAIS);
		result.add(SDSID);
		result.add(NAT_LOC_CODE);
		result.add(NAT_SPEC_CODE);
		result.add(NAT_TREAT_CODE);
		result.add(ASSESSMENTSCORING);
		result.add(REPORTS);
		result.add(OPCS4);
		result.add(PCG);
		result.add(ENDOSCOPY);
		result.add(VTM);
		result.add(VMP);
		result.add(AMP);
		result.add(ACTIVITY_TYPE);
		result.add(ACTIVITY_CODE);
		result.add(TWO_WEEK_WAIT);
		result.add(PHARMACY);
		result.add(WORKLIST_MAPPING);
		result.add(INVESTIGATION);
		result.add(MAXIMS_INTERNAL);
		result.add(CDS);
		result.add(CLEARSPAN);
		result.add(HARVEST);
		result.add(CLINICAL_OUTCOME_CODE);
		result.add(EDRM);
		result.add(MAXIMS);
		result.add(ANE);
		result.add(WEB_SERVICE);
		result.add(OPWL);
		result.add(ICD03);
		result.add(DISPLAY_TEXT);
		result.add(CLINICAL_MAPPING);
		result.add(PCT);
		result.add(CCG);
		result.add(PASCONTRACT);
		result.add(PDS);
		result.add(DASHBOARD);
		result.add(HRG);
		return result;
	}
	public static TaxonomyType[] getNegativeInstances()
	{
		TaxonomyType[] instances = new TaxonomyType[51];
		instances[0] = READ3;
		instances[1] = ICD10;
		instances[2] = ICD9;
		instances[3] = SNOMED;
		instances[4] = EXCH;
		instances[5] = NOMI;
		instances[6] = ICAB;
		instances[7] = PAS;
		instances[8] = RAD;
		instances[9] = PATH;
		instances[10] = NAT_CONS_CODE;
		instances[11] = NAT_GP_CODE;
		instances[12] = MCN_NO;
		instances[13] = AN_BORD_ALTRANAIS;
		instances[14] = SDSID;
		instances[15] = NAT_LOC_CODE;
		instances[16] = NAT_SPEC_CODE;
		instances[17] = NAT_TREAT_CODE;
		instances[18] = ASSESSMENTSCORING;
		instances[19] = REPORTS;
		instances[20] = OPCS4;
		instances[21] = PCG;
		instances[22] = ENDOSCOPY;
		instances[23] = VTM;
		instances[24] = VMP;
		instances[25] = AMP;
		instances[26] = ACTIVITY_TYPE;
		instances[27] = ACTIVITY_CODE;
		instances[28] = TWO_WEEK_WAIT;
		instances[29] = PHARMACY;
		instances[30] = WORKLIST_MAPPING;
		instances[31] = INVESTIGATION;
		instances[32] = MAXIMS_INTERNAL;
		instances[33] = CDS;
		instances[34] = CLEARSPAN;
		instances[35] = HARVEST;
		instances[36] = CLINICAL_OUTCOME_CODE;
		instances[37] = EDRM;
		instances[38] = MAXIMS;
		instances[39] = ANE;
		instances[40] = WEB_SERVICE;
		instances[41] = OPWL;
		instances[42] = ICD03;
		instances[43] = DISPLAY_TEXT;
		instances[44] = CLINICAL_MAPPING;
		instances[45] = PCT;
		instances[46] = CCG;
		instances[47] = PASCONTRACT;
		instances[48] = PDS;
		instances[49] = DASHBOARD;
		instances[50] = HRG;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[51];
		negativeInstances[0] = "READ3";
		negativeInstances[1] = "ICD10";
		negativeInstances[2] = "ICD9";
		negativeInstances[3] = "SNOMED";
		negativeInstances[4] = "EXCH";
		negativeInstances[5] = "NOMI";
		negativeInstances[6] = "ICAB";
		negativeInstances[7] = "PAS";
		negativeInstances[8] = "RAD";
		negativeInstances[9] = "PATH";
		negativeInstances[10] = "NAT_CONS_CODE";
		negativeInstances[11] = "NAT_GP_CODE";
		negativeInstances[12] = "MCN_NO";
		negativeInstances[13] = "AN_BORD_ALTRANAIS";
		negativeInstances[14] = "SDSID";
		negativeInstances[15] = "NAT_LOC_CODE";
		negativeInstances[16] = "NAT_SPEC_CODE";
		negativeInstances[17] = "NAT_TREAT_CODE";
		negativeInstances[18] = "ASSESSMENTSCORING";
		negativeInstances[19] = "REPORTS";
		negativeInstances[20] = "OPCS4";
		negativeInstances[21] = "PCG";
		negativeInstances[22] = "ENDOSCOPY";
		negativeInstances[23] = "VTM";
		negativeInstances[24] = "VMP";
		negativeInstances[25] = "AMP";
		negativeInstances[26] = "ACTIVITY_TYPE";
		negativeInstances[27] = "ACTIVITY_CODE";
		negativeInstances[28] = "TWO_WEEK_WAIT";
		negativeInstances[29] = "PHARMACY";
		negativeInstances[30] = "WORKLIST_MAPPING";
		negativeInstances[31] = "INVESTIGATION";
		negativeInstances[32] = "MAXIMS_INTERNAL";
		negativeInstances[33] = "CDS";
		negativeInstances[34] = "CLEARSPAN";
		negativeInstances[35] = "HARVEST";
		negativeInstances[36] = "CLINICAL_OUTCOME_CODE";
		negativeInstances[37] = "EDRM";
		negativeInstances[38] = "MAXIMS";
		negativeInstances[39] = "ANE";
		negativeInstances[40] = "WEB_SERVICE";
		negativeInstances[41] = "OPWL";
		negativeInstances[42] = "ICD03";
		negativeInstances[43] = "DISPLAY_TEXT";
		negativeInstances[44] = "CLINICAL_MAPPING";
		negativeInstances[45] = "PCT";
		negativeInstances[46] = "CCG";
		negativeInstances[47] = "PASCONTRACT";
		negativeInstances[48] = "PDS";
		negativeInstances[49] = "DASHBOARD";
		negativeInstances[50] = "HRG";
		return negativeInstances;
	}
	public static TaxonomyType getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static TaxonomyType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TaxonomyType[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021047;
	public static final TaxonomyType READ3 = new TaxonomyType(-47, "Read3", true, null, null, Color.Black);
	public static final TaxonomyType ICD10 = new TaxonomyType(-279, "ICD10", true, null, null, Color.Default);
	public static final TaxonomyType ICD9 = new TaxonomyType(-514, "ICD 9", true, null, null, Color.Default);
	public static final TaxonomyType SNOMED = new TaxonomyType(-829, "Snomed", true, null, null, Color.Default);
	public static final TaxonomyType EXCH = new TaxonomyType(-513, "Exchequer", true, null, null, Color.Default);
	public static final TaxonomyType NOMI = new TaxonomyType(-525, "Nominal Codes", true, null, null, Color.Default);
	public static final TaxonomyType ICAB = new TaxonomyType(-609, "Choose and Book", true, null, null, Color.Default);
	public static final TaxonomyType PAS = new TaxonomyType(-286, "PAS", true, null, null, Color.Default);
	public static final TaxonomyType RAD = new TaxonomyType(-823, "Radiology System", true, null, null, Color.Default);
	public static final TaxonomyType PATH = new TaxonomyType(-822, "Pathology System", true, null, null, Color.Default);
	public static final TaxonomyType NAT_CONS_CODE = new TaxonomyType(-826, "National Consultant Code", true, null, null, Color.Default);
	public static final TaxonomyType NAT_GP_CODE = new TaxonomyType(-827, "National GP Code", true, null, null, Color.Default);
	public static final TaxonomyType MCN_NO = new TaxonomyType(-2782, "MCN Registration Number", true, null, null, Color.Default);
	public static final TaxonomyType AN_BORD_ALTRANAIS = new TaxonomyType(-2783, "An Bord Altranais Registration No.", true, null, null, Color.Default);
	public static final TaxonomyType SDSID = new TaxonomyType(-824, "SDS Id", true, null, null, Color.Default);
	public static final TaxonomyType NAT_LOC_CODE = new TaxonomyType(-828, "National Location Code", true, null, null, Color.Default);
	public static final TaxonomyType NAT_SPEC_CODE = new TaxonomyType(-915, "NAT_SPEC_CODE", true, null, null, Color.Default);
	public static final TaxonomyType NAT_TREAT_CODE = new TaxonomyType(-916, "NAT_TREAT_CODE", true, null, null, Color.Default);
	public static final TaxonomyType ASSESSMENTSCORING = new TaxonomyType(-1323, "Assessment Scoring", true, null, null, Color.Default);
	public static final TaxonomyType REPORTS = new TaxonomyType(-1475, "Report", true, null, null, Color.Default);
	public static final TaxonomyType OPCS4 = new TaxonomyType(-1513, "OPCS4", true, null, null, Color.Default);
	public static final TaxonomyType PCG = new TaxonomyType(-1540, "Primary Care Group", true, null, null, Color.Default);
	public static final TaxonomyType ENDOSCOPY = new TaxonomyType(-1559, "Endoscopy System", true, null, null, Color.Default);
	public static final TaxonomyType VTM = new TaxonomyType(-1577, "VTM", true, null, null, Color.Default);
	public static final TaxonomyType VMP = new TaxonomyType(-1584, "VMP", true, null, null, Color.Default);
	public static final TaxonomyType AMP = new TaxonomyType(-1585, "AMP", true, null, null, Color.Default);
	public static final TaxonomyType ACTIVITY_TYPE = new TaxonomyType(-1591, "Activity Type", true, null, null, Color.Default);
	public static final TaxonomyType ACTIVITY_CODE = new TaxonomyType(-1592, "Activity Code", true, null, null, Color.Default);
	public static final TaxonomyType TWO_WEEK_WAIT = new TaxonomyType(-1708, "Two Week Wait", true, null, null, Color.Default);
	public static final TaxonomyType PHARMACY = new TaxonomyType(-1761, "Pharmacy System", true, null, null, Color.Default);
	public static final TaxonomyType WORKLIST_MAPPING = new TaxonomyType(-1771, "Worklist Mapping", true, null, null, Color.Default);
	public static final TaxonomyType INVESTIGATION = new TaxonomyType(-1773, "Investigation", true, null, null, Color.Default);
	public static final TaxonomyType MAXIMS_INTERNAL = new TaxonomyType(-1811, "Maxims Internal", true, null, null, Color.Default);
	public static final TaxonomyType CDS = new TaxonomyType(-1850, "CDS", true, null, null, Color.Default);
	public static final TaxonomyType CLEARSPAN = new TaxonomyType(-2108, "CLEARSPAN", true, null, null, Color.Default);
	public static final TaxonomyType HARVEST = new TaxonomyType(-2113, "HARVEST", true, null, null, Color.Default);
	public static final TaxonomyType CLINICAL_OUTCOME_CODE = new TaxonomyType(-2144, "Clinical Outcome Code", true, null, null, Color.Default);
	public static final TaxonomyType EDRM = new TaxonomyType(-2177, "Electronic Document and Records Management System", true, null, null, Color.Default);
	public static final TaxonomyType MAXIMS = new TaxonomyType(-2180, "MAXIMS", true, null, null, Color.Default);
	public static final TaxonomyType ANE = new TaxonomyType(-2181, "A&E System", true, null, null, Color.Default);
	public static final TaxonomyType WEB_SERVICE = new TaxonomyType(-2214, "Web Service Mapping", true, null, null, Color.Default);
	public static final TaxonomyType OPWL = new TaxonomyType(-2378, "OPWL", true, null, null, Color.Default);
	public static final TaxonomyType ICD03 = new TaxonomyType(-2423, "ICD03", true, null, null, Color.Default);
	public static final TaxonomyType DISPLAY_TEXT = new TaxonomyType(-2429, "Display Text", true, null, null, Color.Default);
	public static final TaxonomyType CLINICAL_MAPPING = new TaxonomyType(-2485, "Clinical Mapping", true, null, null, Color.Default);
	public static final TaxonomyType PCT = new TaxonomyType(-2486, "PCT Code", true, null, null, Color.Default);
	public static final TaxonomyType CCG = new TaxonomyType(-2489, "CCG Mapping", true, null, null, Color.Default);
	public static final TaxonomyType PASCONTRACT = new TaxonomyType(-2554, "Pas Contract Allocation", true, null, null, Color.Default);
	public static final TaxonomyType PDS = new TaxonomyType(-3053, "PDS", true, null, null, Color.Default);
	public static final TaxonomyType DASHBOARD = new TaxonomyType(-3225, "Dashboard", true, null, null, Color.Default);
	public static final TaxonomyType HRG = new TaxonomyType(-3423, "HRG", true, null, null, Color.Default);
}
