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

public class FormReadWrite extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public FormReadWrite()
	{
		super();
	}
	public FormReadWrite(int id)
	{
		super(id, "", true);
	}
	public FormReadWrite(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public FormReadWrite(int id, String text, boolean active, FormReadWrite parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public FormReadWrite(int id, String text, boolean active, FormReadWrite parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public FormReadWrite(int id, String text, boolean active, FormReadWrite parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static FormReadWrite buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new FormReadWrite(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (FormReadWrite)super.getParentInstance();
	}
	public FormReadWrite getParent()
	{
		return (FormReadWrite)super.getParentInstance();
	}
	public void setParent(FormReadWrite parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		FormReadWrite[] typedChildren = new FormReadWrite[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (FormReadWrite)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof FormReadWrite)
		{
			super.addChild((FormReadWrite)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof FormReadWrite)
		{
			super.removeChild((FormReadWrite)child);
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
		FormReadWriteCollection result = new FormReadWriteCollection();
		result.add(WRITE);
		result.add(READ);
		result.add(DENIED);
		return result;
	}
	public static FormReadWrite[] getNegativeInstances()
	{
		FormReadWrite[] instances = new FormReadWrite[3];
		instances[0] = WRITE;
		instances[1] = READ;
		instances[2] = DENIED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "WRITE";
		negativeInstances[1] = "READ";
		negativeInstances[2] = "DENIED";
		return negativeInstances;
	}
	public static FormReadWrite getNegativeInstance(String name)
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
	public static FormReadWrite getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		FormReadWrite[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031000;
	public static final FormReadWrite WRITE = new FormReadWrite(-63, "Write Access", true, null, new ims.framework.utils.ImagePath(102101, "Images/Core/answer_yes.png"), Color.Black);
	public static final FormReadWrite READ = new FormReadWrite(-134, "Read Access", true, null, new ims.framework.utils.ImagePath(102106, "Images/Core/R.gif"), Color.Black);
	public static final FormReadWrite DENIED = new FormReadWrite(-64, "Access Denied", true, null, new ims.framework.utils.ImagePath(102100, "Images/Core/answer_no.png"), Color.Black);
}
