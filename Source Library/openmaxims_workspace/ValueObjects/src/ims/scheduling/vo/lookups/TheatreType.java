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

package ims.scheduling.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class TheatreType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public TheatreType()
	{
		super();
	}
	public TheatreType(int id)
	{
		super(id, "", true);
	}
	public TheatreType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public TheatreType(int id, String text, boolean active, TheatreType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public TheatreType(int id, String text, boolean active, TheatreType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public TheatreType(int id, String text, boolean active, TheatreType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static TheatreType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new TheatreType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (TheatreType)super.getParentInstance();
	}
	public TheatreType getParent()
	{
		return (TheatreType)super.getParentInstance();
	}
	public void setParent(TheatreType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		TheatreType[] typedChildren = new TheatreType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (TheatreType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof TheatreType)
		{
			super.addChild((TheatreType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof TheatreType)
		{
			super.removeChild((TheatreType)child);
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
		TheatreTypeCollection result = new TheatreTypeCollection();
		result.add(DAYCASE);
		result.add(INPATIENT);
		result.add(OP_CASE);
		result.add(EMERGENCY);
		result.add(EMERGENCY_NON_TO);
		return result;
	}
	public static TheatreType[] getNegativeInstances()
	{
		TheatreType[] instances = new TheatreType[5];
		instances[0] = DAYCASE;
		instances[1] = INPATIENT;
		instances[2] = OP_CASE;
		instances[3] = EMERGENCY;
		instances[4] = EMERGENCY_NON_TO;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[5];
		negativeInstances[0] = "DAYCASE";
		negativeInstances[1] = "INPATIENT";
		negativeInstances[2] = "OP_CASE";
		negativeInstances[3] = "EMERGENCY";
		negativeInstances[4] = "EMERGENCY_NON_TO";
		return negativeInstances;
	}
	public static TheatreType getNegativeInstance(String name)
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
	public static TheatreType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		TheatreType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1141022;
	public static final TheatreType DAYCASE = new TheatreType(-1762, "Day Surgery", true, null, null, Color.Default);
	public static final TheatreType INPATIENT = new TheatreType(-1763, "Inpatient", true, null, null, Color.Default);
	public static final TheatreType OP_CASE = new TheatreType(-2204, "OP Case", true, null, null, Color.Default);
	public static final TheatreType EMERGENCY = new TheatreType(-3043, "Emergency T&O", true, null, null, Color.Default);
	public static final TheatreType EMERGENCY_NON_TO = new TheatreType(-3354, "Emergency Non-T&O", true, null, null, Color.Default);
}
