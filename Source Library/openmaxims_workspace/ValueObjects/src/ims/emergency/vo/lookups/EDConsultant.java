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

package ims.emergency.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class EDConsultant extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public EDConsultant()
	{
		super();
	}
	public EDConsultant(int id)
	{
		super(id, "", true);
	}
	public EDConsultant(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public EDConsultant(int id, String text, boolean active, EDConsultant parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public EDConsultant(int id, String text, boolean active, EDConsultant parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public EDConsultant(int id, String text, boolean active, EDConsultant parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static EDConsultant buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new EDConsultant(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (EDConsultant)super.getParentInstance();
	}
	public EDConsultant getParent()
	{
		return (EDConsultant)super.getParentInstance();
	}
	public void setParent(EDConsultant parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		EDConsultant[] typedChildren = new EDConsultant[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (EDConsultant)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof EDConsultant)
		{
			super.addChild((EDConsultant)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof EDConsultant)
		{
			super.removeChild((EDConsultant)child);
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
		EDConsultantCollection result = new EDConsultantCollection();
		result.add(ED_CONSULTANT);
		return result;
	}
	public static EDConsultant[] getNegativeInstances()
	{
		EDConsultant[] instances = new EDConsultant[1];
		instances[0] = ED_CONSULTANT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[1];
		negativeInstances[0] = "ED_CONSULTANT";
		return negativeInstances;
	}
	public static EDConsultant getNegativeInstance(String name)
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
	public static EDConsultant getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		EDConsultant[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1291043;
	public static final EDConsultant ED_CONSULTANT = new EDConsultant(-2444, "Consultant", true, null, null, Color.Default);
}
