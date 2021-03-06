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

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ReferralUrgency extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReferralUrgency()
	{
		super();
	}
	public ReferralUrgency(int id)
	{
		super(id, "", true);
	}
	public ReferralUrgency(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReferralUrgency(int id, String text, boolean active, ReferralUrgency parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReferralUrgency(int id, String text, boolean active, ReferralUrgency parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReferralUrgency(int id, String text, boolean active, ReferralUrgency parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReferralUrgency buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReferralUrgency(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReferralUrgency)super.getParentInstance();
	}
	public ReferralUrgency getParent()
	{
		return (ReferralUrgency)super.getParentInstance();
	}
	public void setParent(ReferralUrgency parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReferralUrgency[] typedChildren = new ReferralUrgency[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReferralUrgency)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReferralUrgency)
		{
			super.addChild((ReferralUrgency)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReferralUrgency)
		{
			super.removeChild((ReferralUrgency)child);
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
		ReferralUrgencyCollection result = new ReferralUrgencyCollection();
		result.add(TWO_WEEK_WAIT);
		result.add(CONSULTANT_UPGRADE);
		result.add(NATIONAL_SCREENING);
		result.add(ROUTINE);
		result.add(URGENT);
		result.add(EMERGENCY);
		return result;
	}
	public static ReferralUrgency[] getNegativeInstances()
	{
		ReferralUrgency[] instances = new ReferralUrgency[6];
		instances[0] = TWO_WEEK_WAIT;
		instances[1] = CONSULTANT_UPGRADE;
		instances[2] = NATIONAL_SCREENING;
		instances[3] = ROUTINE;
		instances[4] = URGENT;
		instances[5] = EMERGENCY;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[6];
		negativeInstances[0] = "TWO_WEEK_WAIT";
		negativeInstances[1] = "CONSULTANT_UPGRADE";
		negativeInstances[2] = "NATIONAL_SCREENING";
		negativeInstances[3] = "ROUTINE";
		negativeInstances[4] = "URGENT";
		negativeInstances[5] = "EMERGENCY";
		return negativeInstances;
	}
	public static ReferralUrgency getNegativeInstance(String name)
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
	public static ReferralUrgency getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReferralUrgency[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341036;
	public static final ReferralUrgency TWO_WEEK_WAIT = new ReferralUrgency(-2675, "Two Week Wait", true, null, null, Color.Default);
	public static final ReferralUrgency CONSULTANT_UPGRADE = new ReferralUrgency(-2676, "Consultant Upgrade", true, null, null, Color.Default);
	public static final ReferralUrgency NATIONAL_SCREENING = new ReferralUrgency(-2981, "National Screening", true, null, null, Color.Default);
	public static final ReferralUrgency ROUTINE = new ReferralUrgency(-3144, "Routine", true, null, null, Color.Default);
	public static final ReferralUrgency URGENT = new ReferralUrgency(-3145, "Urgent", true, null, null, Color.Default);
	public static final ReferralUrgency EMERGENCY = new ReferralUrgency(-3156, "Emergency", true, null, null, Color.Default);
}
