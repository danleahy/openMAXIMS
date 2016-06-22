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

package ims.spinalinjuries.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class InjuryClassMechanism extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public InjuryClassMechanism()
	{
		super();
	}
	public InjuryClassMechanism(int id)
	{
		super(id, "", true);
	}
	public InjuryClassMechanism(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public InjuryClassMechanism(int id, String text, boolean active, InjuryClassMechanism parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public InjuryClassMechanism(int id, String text, boolean active, InjuryClassMechanism parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public InjuryClassMechanism(int id, String text, boolean active, InjuryClassMechanism parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static InjuryClassMechanism buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new InjuryClassMechanism(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (InjuryClassMechanism)super.getParentInstance();
	}
	public InjuryClassMechanism getParent()
	{
		return (InjuryClassMechanism)super.getParentInstance();
	}
	public void setParent(InjuryClassMechanism parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		InjuryClassMechanism[] typedChildren = new InjuryClassMechanism[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (InjuryClassMechanism)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof InjuryClassMechanism)
		{
			super.addChild((InjuryClassMechanism)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof InjuryClassMechanism)
		{
			super.removeChild((InjuryClassMechanism)child);
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
		InjuryClassMechanismCollection result = new InjuryClassMechanismCollection();
		result.add(MECHANISM1);
		result.add(MECHANISM2);
		return result;
	}
	public static InjuryClassMechanism[] getNegativeInstances()
	{
		InjuryClassMechanism[] instances = new InjuryClassMechanism[2];
		instances[0] = MECHANISM1;
		instances[1] = MECHANISM2;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "MECHANISM1";
		negativeInstances[1] = "MECHANISM2";
		return negativeInstances;
	}
	public static InjuryClassMechanism getNegativeInstance(String name)
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
	public static InjuryClassMechanism getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		InjuryClassMechanism[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1051100;
	public static final InjuryClassMechanism MECHANISM1 = new InjuryClassMechanism(-203, "mechanism1", true, null, null, Color.Default);
	public static final InjuryClassMechanism MECHANISM2 = new InjuryClassMechanism(-204, "mechanism2", true, null, null, Color.Default);
}
