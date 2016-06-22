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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ProphylaxisOffered extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ProphylaxisOffered()
	{
		super();
	}
	public ProphylaxisOffered(int id)
	{
		super(id, "", true);
	}
	public ProphylaxisOffered(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ProphylaxisOffered(int id, String text, boolean active, ProphylaxisOffered parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ProphylaxisOffered(int id, String text, boolean active, ProphylaxisOffered parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ProphylaxisOffered(int id, String text, boolean active, ProphylaxisOffered parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ProphylaxisOffered buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ProphylaxisOffered(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ProphylaxisOffered)super.getParentInstance();
	}
	public ProphylaxisOffered getParent()
	{
		return (ProphylaxisOffered)super.getParentInstance();
	}
	public void setParent(ProphylaxisOffered parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ProphylaxisOffered[] typedChildren = new ProphylaxisOffered[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ProphylaxisOffered)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ProphylaxisOffered)
		{
			super.addChild((ProphylaxisOffered)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ProphylaxisOffered)
		{
			super.removeChild((ProphylaxisOffered)child);
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
		ProphylaxisOfferedCollection result = new ProphylaxisOfferedCollection();
		result.add(ANTIEMBOLISM_STOCKINGS_OR_MECHNICAL_DEVICE);
		result.add(ENOXAPARIN);
		result.add(NO_PROPHYLAXIS_REQUIRED);
		return result;
	}
	public static ProphylaxisOffered[] getNegativeInstances()
	{
		ProphylaxisOffered[] instances = new ProphylaxisOffered[3];
		instances[0] = ANTIEMBOLISM_STOCKINGS_OR_MECHNICAL_DEVICE;
		instances[1] = ENOXAPARIN;
		instances[2] = NO_PROPHYLAXIS_REQUIRED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "ANTIEMBOLISM_STOCKINGS_OR_MECHNICAL_DEVICE";
		negativeInstances[1] = "ENOXAPARIN";
		negativeInstances[2] = "NO_PROPHYLAXIS_REQUIRED";
		return negativeInstances;
	}
	public static ProphylaxisOffered getNegativeInstance(String name)
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
	public static ProphylaxisOffered getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ProphylaxisOffered[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231124;
	public static final ProphylaxisOffered ANTIEMBOLISM_STOCKINGS_OR_MECHNICAL_DEVICE = new ProphylaxisOffered(-2256, "Antiembolism Stockings or mechnical device", true, null, null, Color.Default);
	public static final ProphylaxisOffered ENOXAPARIN = new ProphylaxisOffered(-2257, "Enoxaparin", true, null, null, Color.Default);
	public static final ProphylaxisOffered NO_PROPHYLAXIS_REQUIRED = new ProphylaxisOffered(-2952, "No Prophylaxis Required ", true, null, null, Color.Default);
}
