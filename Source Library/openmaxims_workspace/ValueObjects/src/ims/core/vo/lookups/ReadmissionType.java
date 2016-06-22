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

public class ReadmissionType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReadmissionType()
	{
		super();
	}
	public ReadmissionType(int id)
	{
		super(id, "", true);
	}
	public ReadmissionType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReadmissionType(int id, String text, boolean active, ReadmissionType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReadmissionType(int id, String text, boolean active, ReadmissionType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReadmissionType(int id, String text, boolean active, ReadmissionType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReadmissionType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReadmissionType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReadmissionType)super.getParentInstance();
	}
	public ReadmissionType getParent()
	{
		return (ReadmissionType)super.getParentInstance();
	}
	public void setParent(ReadmissionType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReadmissionType[] typedChildren = new ReadmissionType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReadmissionType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReadmissionType)
		{
			super.addChild((ReadmissionType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReadmissionType)
		{
			super.removeChild((ReadmissionType)child);
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
		ReadmissionTypeCollection result = new ReadmissionTypeCollection();
		result.add(RELATED);
		result.add(UNRELATED);
		return result;
	}
	public static ReadmissionType[] getNegativeInstances()
	{
		ReadmissionType[] instances = new ReadmissionType[2];
		instances[0] = RELATED;
		instances[1] = UNRELATED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "RELATED";
		negativeInstances[1] = "UNRELATED";
		return negativeInstances;
	}
	public static ReadmissionType getNegativeInstance(String name)
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
	public static ReadmissionType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReadmissionType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021257;
	public static final ReadmissionType RELATED = new ReadmissionType(-1826, "Related", true, null, null, Color.Default);
	public static final ReadmissionType UNRELATED = new ReadmissionType(-1827, "Unrelated", true, null, null, Color.Default);
}
