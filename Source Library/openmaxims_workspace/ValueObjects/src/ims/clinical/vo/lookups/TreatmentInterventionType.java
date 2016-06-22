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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TreatmentInterventionType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TreatmentInterventionType()
	{
		super();
	}
	public TreatmentInterventionType(int id)
	{
		super(id, "", true);
	}
	public TreatmentInterventionType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TreatmentInterventionType(int id, String text, boolean active, TreatmentInterventionType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TreatmentInterventionType(int id, String text, boolean active, TreatmentInterventionType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TreatmentInterventionType(int id, String text, boolean active, TreatmentInterventionType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TreatmentInterventionType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TreatmentInterventionType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TreatmentInterventionType)super.getParentInstance();
	}
	public TreatmentInterventionType getParent()
	{
		return (TreatmentInterventionType)super.getParentInstance();
	}
	public void setParent(TreatmentInterventionType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TreatmentInterventionType[] typedChildren = new TreatmentInterventionType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TreatmentInterventionType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TreatmentInterventionType)
		{
			super.addChild((TreatmentInterventionType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TreatmentInterventionType)
		{
			super.removeChild((TreatmentInterventionType)child);
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
		TreatmentInterventionTypeCollection result = new TreatmentInterventionTypeCollection();
		result.add(TI_TYPE_MEDICATION);
		result.add(TI_TYPE_WOUND_TX);
		result.add(TI_TYPE_TUBES);
		result.add(TI_TYPE_ORTHO);
		result.add(TI_TYPE_RESUS);
		result.add(TI_TYPE_OTHER);
		return result;
	}
	public static TreatmentInterventionType[] getNegativeInstances()
	{
		TreatmentInterventionType[] instances = new TreatmentInterventionType[6];
		instances[0] = TI_TYPE_MEDICATION;
		instances[1] = TI_TYPE_WOUND_TX;
		instances[2] = TI_TYPE_TUBES;
		instances[3] = TI_TYPE_ORTHO;
		instances[4] = TI_TYPE_RESUS;
		instances[5] = TI_TYPE_OTHER;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[6];
		negativeInstances[0] = "TI_TYPE_MEDICATION";
		negativeInstances[1] = "TI_TYPE_WOUND_TX";
		negativeInstances[2] = "TI_TYPE_TUBES";
		negativeInstances[3] = "TI_TYPE_ORTHO";
		negativeInstances[4] = "TI_TYPE_RESUS";
		negativeInstances[5] = "TI_TYPE_OTHER";
		return negativeInstances;
	}
	public static TreatmentInterventionType getNegativeInstance(String name)
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
	public static TreatmentInterventionType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TreatmentInterventionType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231134;
	public static final TreatmentInterventionType TI_TYPE_MEDICATION = new TreatmentInterventionType(-2529, "Medication", true, null, null, Color.Default);
	public static final TreatmentInterventionType TI_TYPE_WOUND_TX = new TreatmentInterventionType(-2530, "Wound Tx", true, null, null, Color.Default);
	public static final TreatmentInterventionType TI_TYPE_TUBES = new TreatmentInterventionType(-2531, "Tubes", true, null, null, Color.Default);
	public static final TreatmentInterventionType TI_TYPE_ORTHO = new TreatmentInterventionType(-2532, "Ortho", true, null, null, Color.Default);
	public static final TreatmentInterventionType TI_TYPE_RESUS = new TreatmentInterventionType(-2533, "Resus", true, null, null, Color.Default);
	public static final TreatmentInterventionType TI_TYPE_OTHER = new TreatmentInterventionType(-2534, "Other", true, null, null, Color.Default);
}
