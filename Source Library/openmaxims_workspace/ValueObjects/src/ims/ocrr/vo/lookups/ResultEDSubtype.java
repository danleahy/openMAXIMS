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

package ims.ocrr.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ResultEDSubtype extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ResultEDSubtype()
	{
		super();
	}
	public ResultEDSubtype(int id)
	{
		super(id, "", true);
	}
	public ResultEDSubtype(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ResultEDSubtype(int id, String text, boolean active, ResultEDSubtype parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ResultEDSubtype(int id, String text, boolean active, ResultEDSubtype parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ResultEDSubtype(int id, String text, boolean active, ResultEDSubtype parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ResultEDSubtype buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ResultEDSubtype(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ResultEDSubtype)super.getParentInstance();
	}
	public ResultEDSubtype getParent()
	{
		return (ResultEDSubtype)super.getParentInstance();
	}
	public void setParent(ResultEDSubtype parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ResultEDSubtype[] typedChildren = new ResultEDSubtype[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ResultEDSubtype)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ResultEDSubtype)
		{
			super.addChild((ResultEDSubtype)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ResultEDSubtype)
		{
			super.removeChild((ResultEDSubtype)child);
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
		ResultEDSubtypeCollection result = new ResultEDSubtypeCollection();
		result.add(RTF);
		result.add(PDF);
		result.add(HTML);
		result.add(JPEG);
		return result;
	}
	public static ResultEDSubtype[] getNegativeInstances()
	{
		ResultEDSubtype[] instances = new ResultEDSubtype[4];
		instances[0] = RTF;
		instances[1] = PDF;
		instances[2] = HTML;
		instances[3] = JPEG;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "RTF";
		negativeInstances[1] = "PDF";
		negativeInstances[2] = "HTML";
		negativeInstances[3] = "JPEG";
		return negativeInstances;
	}
	public static ResultEDSubtype getNegativeInstance(String name)
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
	public static ResultEDSubtype getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ResultEDSubtype[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1161053;
	public static final ResultEDSubtype RTF = new ResultEDSubtype(-2128, "RTF", true, null, null, Color.Default);
	public static final ResultEDSubtype PDF = new ResultEDSubtype(-2129, "PDF", true, null, null, Color.Default);
	public static final ResultEDSubtype HTML = new ResultEDSubtype(-2130, "HTML", true, null, null, Color.Default);
	public static final ResultEDSubtype JPEG = new ResultEDSubtype(-2422, "JPEG", true, null, null, Color.Default);
}
