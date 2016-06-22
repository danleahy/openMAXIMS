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

public class EDischargeSummarySectionStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public EDischargeSummarySectionStatus()
	{
		super();
	}
	public EDischargeSummarySectionStatus(int id)
	{
		super(id, "", true);
	}
	public EDischargeSummarySectionStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public EDischargeSummarySectionStatus(int id, String text, boolean active, EDischargeSummarySectionStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public EDischargeSummarySectionStatus(int id, String text, boolean active, EDischargeSummarySectionStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public EDischargeSummarySectionStatus(int id, String text, boolean active, EDischargeSummarySectionStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static EDischargeSummarySectionStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new EDischargeSummarySectionStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (EDischargeSummarySectionStatus)super.getParentInstance();
	}
	public EDischargeSummarySectionStatus getParent()
	{
		return (EDischargeSummarySectionStatus)super.getParentInstance();
	}
	public void setParent(EDischargeSummarySectionStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		EDischargeSummarySectionStatus[] typedChildren = new EDischargeSummarySectionStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (EDischargeSummarySectionStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof EDischargeSummarySectionStatus)
		{
			super.addChild((EDischargeSummarySectionStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof EDischargeSummarySectionStatus)
		{
			super.removeChild((EDischargeSummarySectionStatus)child);
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
		EDischargeSummarySectionStatusCollection result = new EDischargeSummarySectionStatusCollection();
		result.add(NOT_STARTED);
		result.add(IN_PROGRESS);
		result.add(COMPLETED);
		return result;
	}
	public static EDischargeSummarySectionStatus[] getNegativeInstances()
	{
		EDischargeSummarySectionStatus[] instances = new EDischargeSummarySectionStatus[3];
		instances[0] = NOT_STARTED;
		instances[1] = IN_PROGRESS;
		instances[2] = COMPLETED;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "NOT_STARTED";
		negativeInstances[1] = "IN_PROGRESS";
		negativeInstances[2] = "COMPLETED";
		return negativeInstances;
	}
	public static EDischargeSummarySectionStatus getNegativeInstance(String name)
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
	public static EDischargeSummarySectionStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		EDischargeSummarySectionStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231115;
	public static final EDischargeSummarySectionStatus NOT_STARTED = new EDischargeSummarySectionStatus(-2096, "Not Started", true, null, null, Color.Default);
	public static final EDischargeSummarySectionStatus IN_PROGRESS = new EDischargeSummarySectionStatus(-2097, "In Progress", true, null, null, Color.Default);
	public static final EDischargeSummarySectionStatus COMPLETED = new EDischargeSummarySectionStatus(-2098, "Completed", true, null, null, Color.Default);
}
