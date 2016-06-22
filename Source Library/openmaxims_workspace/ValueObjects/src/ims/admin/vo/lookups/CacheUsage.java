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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class CacheUsage extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public CacheUsage()
	{
		super();
	}
	public CacheUsage(int id)
	{
		super(id, "", true);
	}
	public CacheUsage(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public CacheUsage(int id, String text, boolean active, CacheUsage parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public CacheUsage(int id, String text, boolean active, CacheUsage parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public CacheUsage(int id, String text, boolean active, CacheUsage parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static CacheUsage buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new CacheUsage(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (CacheUsage)super.getParentInstance();
	}
	public CacheUsage getParent()
	{
		return (CacheUsage)super.getParentInstance();
	}
	public void setParent(CacheUsage parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		CacheUsage[] typedChildren = new CacheUsage[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (CacheUsage)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof CacheUsage)
		{
			super.addChild((CacheUsage)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof CacheUsage)
		{
			super.removeChild((CacheUsage)child);
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
		CacheUsageCollection result = new CacheUsageCollection();
		result.add(NONSTRICT_READ_WRITE);
		result.add(READ_WRITE);
		result.add(READ_ONLY);
		result.add(TRANSACTIONAL);
		return result;
	}
	public static CacheUsage[] getNegativeInstances()
	{
		CacheUsage[] instances = new CacheUsage[4];
		instances[0] = NONSTRICT_READ_WRITE;
		instances[1] = READ_WRITE;
		instances[2] = READ_ONLY;
		instances[3] = TRANSACTIONAL;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "NONSTRICT_READ_WRITE";
		negativeInstances[1] = "READ_WRITE";
		negativeInstances[2] = "READ_ONLY";
		negativeInstances[3] = "TRANSACTIONAL";
		return negativeInstances;
	}
	public static CacheUsage getNegativeInstance(String name)
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
	public static CacheUsage getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		CacheUsage[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031009;
	public static final CacheUsage NONSTRICT_READ_WRITE = new CacheUsage(-1169, "nonstrict-read-write", true, null, new ims.framework.utils.ImagePath(102258, "Images/Core/Control_Form.gif"), Color.Default);
	public static final CacheUsage READ_WRITE = new CacheUsage(-1168, "read-write", true, null, new ims.framework.utils.ImagePath(103102, "Images/Admin/edit.gif"), Color.Default);
	public static final CacheUsage READ_ONLY = new CacheUsage(-1167, "read-only", true, null, new ims.framework.utils.ImagePath(103101, "Images/Admin/Leaf.gif"), Color.Default);
	public static final CacheUsage TRANSACTIONAL = new CacheUsage(-1170, "transactional", true, null, new ims.framework.utils.ImagePath(103108, "Images/Admin/Assign16Enabled.gif"), Color.Default);
}
