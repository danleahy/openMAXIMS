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

public class Category extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Category()
	{
		super();
	}
	public Category(int id)
	{
		super(id, "", true);
	}
	public Category(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Category(int id, String text, boolean active, Category parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Category(int id, String text, boolean active, Category parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Category(int id, String text, boolean active, Category parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Category buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Category(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Category)super.getParentInstance();
	}
	public Category getParent()
	{
		return (Category)super.getParentInstance();
	}
	public void setParent(Category parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Category[] typedChildren = new Category[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Category)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Category)
		{
			super.addChild((Category)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Category)
		{
			super.removeChild((Category)child);
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
		CategoryCollection result = new CategoryCollection();
		result.add(PATHOLOGY);
		result.add(CLINICALIMAGING);
		result.add(CLINICAL);
		result.add(PAS);
		return result;
	}
	public static Category[] getNegativeInstances()
	{
		Category[] instances = new Category[4];
		instances[0] = PATHOLOGY;
		instances[1] = CLINICALIMAGING;
		instances[2] = CLINICAL;
		instances[3] = PAS;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "PATHOLOGY";
		negativeInstances[1] = "CLINICALIMAGING";
		negativeInstances[2] = "CLINICAL";
		negativeInstances[3] = "PAS";
		return negativeInstances;
	}
	public static Category getNegativeInstance(String name)
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
	public static Category getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Category[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1161000;
	public static final Category PATHOLOGY = new Category(-574, "Pathology", true, null, null, Color.Default);
	public static final Category CLINICALIMAGING = new Category(-575, "Radiology", true, null, null, Color.Default);
	public static final Category CLINICAL = new Category(-1563, "Clinical", true, null, null, Color.Default);
	public static final Category PAS = new Category(-1187, "Pas", true, null, null, Color.Default);
}
