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

public class PDSDataQualityType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PDSDataQualityType()
	{
		super();
	}
	public PDSDataQualityType(int id)
	{
		super(id, "", true);
	}
	public PDSDataQualityType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PDSDataQualityType(int id, String text, boolean active, PDSDataQualityType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PDSDataQualityType(int id, String text, boolean active, PDSDataQualityType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PDSDataQualityType(int id, String text, boolean active, PDSDataQualityType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PDSDataQualityType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PDSDataQualityType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PDSDataQualityType)super.getParentInstance();
	}
	public PDSDataQualityType getParent()
	{
		return (PDSDataQualityType)super.getParentInstance();
	}
	public void setParent(PDSDataQualityType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PDSDataQualityType[] typedChildren = new PDSDataQualityType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PDSDataQualityType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PDSDataQualityType)
		{
			super.addChild((PDSDataQualityType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PDSDataQualityType)
		{
			super.removeChild((PDSDataQualityType)child);
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
		PDSDataQualityTypeCollection result = new PDSDataQualityTypeCollection();
		result.add(UNDERBUSINESSINVESTIGATION);
		result.add(NOTUNDERDQINVESTIGATION);
		return result;
	}
	public static PDSDataQualityType[] getNegativeInstances()
	{
		PDSDataQualityType[] instances = new PDSDataQualityType[2];
		instances[0] = UNDERBUSINESSINVESTIGATION;
		instances[1] = NOTUNDERDQINVESTIGATION;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "UNDERBUSINESSINVESTIGATION";
		negativeInstances[1] = "NOTUNDERDQINVESTIGATION";
		return negativeInstances;
	}
	public static PDSDataQualityType getNegativeInstance(String name)
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
	public static PDSDataQualityType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PDSDataQualityType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031035;
	public static final PDSDataQualityType UNDERBUSINESSINVESTIGATION = new PDSDataQualityType(-3080, "Under Business Investigation", true, null, null, Color.Default);
	public static final PDSDataQualityType NOTUNDERDQINVESTIGATION = new PDSDataQualityType(-3081, "Not Under DQ Investigation", true, null, null, Color.Default);
}
