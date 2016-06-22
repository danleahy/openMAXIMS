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

package ims.coe.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class DressingAndGroomingActivities extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public DressingAndGroomingActivities()
	{
		super();
	}
	public DressingAndGroomingActivities(int id)
	{
		super(id, "", true);
	}
	public DressingAndGroomingActivities(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public DressingAndGroomingActivities(int id, String text, boolean active, DressingAndGroomingActivities parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public DressingAndGroomingActivities(int id, String text, boolean active, DressingAndGroomingActivities parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public DressingAndGroomingActivities(int id, String text, boolean active, DressingAndGroomingActivities parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static DressingAndGroomingActivities buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new DressingAndGroomingActivities(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (DressingAndGroomingActivities)super.getParentInstance();
	}
	public DressingAndGroomingActivities getParent()
	{
		return (DressingAndGroomingActivities)super.getParentInstance();
	}
	public void setParent(DressingAndGroomingActivities parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		DressingAndGroomingActivities[] typedChildren = new DressingAndGroomingActivities[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (DressingAndGroomingActivities)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof DressingAndGroomingActivities)
		{
			super.addChild((DressingAndGroomingActivities)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof DressingAndGroomingActivities)
		{
			super.removeChild((DressingAndGroomingActivities)child);
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
		DressingAndGroomingActivitiesCollection result = new DressingAndGroomingActivitiesCollection();
		return result;
	}
	public static DressingAndGroomingActivities[] getNegativeInstances()
	{
		return new DressingAndGroomingActivities[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static DressingAndGroomingActivities getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static DressingAndGroomingActivities getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1011043;
}
