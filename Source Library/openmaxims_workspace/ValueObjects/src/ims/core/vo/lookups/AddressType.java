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

public class AddressType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AddressType()
	{
		super();
	}
	public AddressType(int id)
	{
		super(id, "", true);
	}
	public AddressType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AddressType(int id, String text, boolean active, AddressType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AddressType(int id, String text, boolean active, AddressType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AddressType(int id, String text, boolean active, AddressType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AddressType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AddressType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AddressType)super.getParentInstance();
	}
	public AddressType getParent()
	{
		return (AddressType)super.getParentInstance();
	}
	public void setParent(AddressType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AddressType[] typedChildren = new AddressType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AddressType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AddressType)
		{
			super.addChild((AddressType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AddressType)
		{
			super.removeChild((AddressType)child);
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
		AddressTypeCollection result = new AddressTypeCollection();
		result.add(CORRESPONDENCE);
		result.add(NOKHOME);
		result.add(PERMANENT);
		result.add(HISTORICAL);
		result.add(SURGERY);
		result.add(PRACTICE);
		result.add(ORGANISATION);
		result.add(LOC_SITE);
		result.add(LOCATION);
		result.add(TEMPORARY);
		result.add(SENSITIVE);
		return result;
	}
	public static AddressType[] getNegativeInstances()
	{
		AddressType[] instances = new AddressType[11];
		instances[0] = CORRESPONDENCE;
		instances[1] = NOKHOME;
		instances[2] = PERMANENT;
		instances[3] = HISTORICAL;
		instances[4] = SURGERY;
		instances[5] = PRACTICE;
		instances[6] = ORGANISATION;
		instances[7] = LOC_SITE;
		instances[8] = LOCATION;
		instances[9] = TEMPORARY;
		instances[10] = SENSITIVE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[11];
		negativeInstances[0] = "CORRESPONDENCE";
		negativeInstances[1] = "NOKHOME";
		negativeInstances[2] = "PERMANENT";
		negativeInstances[3] = "HISTORICAL";
		negativeInstances[4] = "SURGERY";
		negativeInstances[5] = "PRACTICE";
		negativeInstances[6] = "ORGANISATION";
		negativeInstances[7] = "LOC_SITE";
		negativeInstances[8] = "LOCATION";
		negativeInstances[9] = "TEMPORARY";
		negativeInstances[10] = "SENSITIVE";
		return negativeInstances;
	}
	public static AddressType getNegativeInstance(String name)
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
	public static AddressType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AddressType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021222;
	public static final AddressType CORRESPONDENCE = new AddressType(-1556, "Correspondence", true, null, null, Color.Default);
	public static final AddressType NOKHOME = new AddressType(-1907, "Next Of Kin Home Address", true, null, null, Color.Default);
	public static final AddressType PERMANENT = new AddressType(-1924, "Permanent", true, null, null, Color.Default);
	public static final AddressType HISTORICAL = new AddressType(-2176, "Historical", true, null, null, Color.Default);
	public static final AddressType SURGERY = new AddressType(-2432, "GP Surgery Address", true, null, null, Color.Default);
	public static final AddressType PRACTICE = new AddressType(-2433, "GP Practice Address", true, null, null, Color.Default);
	public static final AddressType ORGANISATION = new AddressType(-2435, "Organisation", true, null, null, Color.Default);
	public static final AddressType LOC_SITE = new AddressType(-2436, "Location Site", true, null, null, Color.Default);
	public static final AddressType LOCATION = new AddressType(-2437, "Location", true, null, null, Color.Default);
	public static final AddressType TEMPORARY = new AddressType(-3056, "Temporary", true, null, null, Color.Default);
	public static final AddressType SENSITIVE = new AddressType(-3358, "SENSITIVE", true, null, null, Color.Default);
}
