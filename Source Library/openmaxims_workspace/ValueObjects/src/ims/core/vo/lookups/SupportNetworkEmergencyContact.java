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

public class SupportNetworkEmergencyContact extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SupportNetworkEmergencyContact()
	{
		super();
	}
	public SupportNetworkEmergencyContact(int id)
	{
		super(id, "", true);
	}
	public SupportNetworkEmergencyContact(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SupportNetworkEmergencyContact(int id, String text, boolean active, SupportNetworkEmergencyContact parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SupportNetworkEmergencyContact(int id, String text, boolean active, SupportNetworkEmergencyContact parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SupportNetworkEmergencyContact(int id, String text, boolean active, SupportNetworkEmergencyContact parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SupportNetworkEmergencyContact buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SupportNetworkEmergencyContact(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SupportNetworkEmergencyContact)super.getParentInstance();
	}
	public SupportNetworkEmergencyContact getParent()
	{
		return (SupportNetworkEmergencyContact)super.getParentInstance();
	}
	public void setParent(SupportNetworkEmergencyContact parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SupportNetworkEmergencyContact[] typedChildren = new SupportNetworkEmergencyContact[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SupportNetworkEmergencyContact)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SupportNetworkEmergencyContact)
		{
			super.addChild((SupportNetworkEmergencyContact)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SupportNetworkEmergencyContact)
		{
			super.removeChild((SupportNetworkEmergencyContact)child);
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
		SupportNetworkEmergencyContactCollection result = new SupportNetworkEmergencyContactCollection();
		result.add(EMERGENCYCONTACT1);
		result.add(EMERGENCYCONTACT2);
		result.add(EMERGENCYCONTACT3);
		result.add(EMERGENCYCONTACT4);
		result.add(EMERGENCYCONTACT5);
		result.add(EMERGENCYCONTACT6);
		result.add(EMERGENCYCONTACT7);
		result.add(EMERGENCYCONTACT8);
		result.add(EMERGENCYCONTACT9);
		result.add(EMERGENCYCONTACT10);
		result.add(EMERGENCYCONTACT11);
		result.add(EMERGENCYCONTACT12);
		result.add(EMERGENCYCONTACT13);
		result.add(EMERGENCYCONTACT14);
		result.add(EMERGENCYCONTACT15);
		return result;
	}
	public static SupportNetworkEmergencyContact[] getNegativeInstances()
	{
		SupportNetworkEmergencyContact[] instances = new SupportNetworkEmergencyContact[15];
		instances[0] = EMERGENCYCONTACT1;
		instances[1] = EMERGENCYCONTACT2;
		instances[2] = EMERGENCYCONTACT3;
		instances[3] = EMERGENCYCONTACT4;
		instances[4] = EMERGENCYCONTACT5;
		instances[5] = EMERGENCYCONTACT6;
		instances[6] = EMERGENCYCONTACT7;
		instances[7] = EMERGENCYCONTACT8;
		instances[8] = EMERGENCYCONTACT9;
		instances[9] = EMERGENCYCONTACT10;
		instances[10] = EMERGENCYCONTACT11;
		instances[11] = EMERGENCYCONTACT12;
		instances[12] = EMERGENCYCONTACT13;
		instances[13] = EMERGENCYCONTACT14;
		instances[14] = EMERGENCYCONTACT15;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[15];
		negativeInstances[0] = "EMERGENCYCONTACT1";
		negativeInstances[1] = "EMERGENCYCONTACT2";
		negativeInstances[2] = "EMERGENCYCONTACT3";
		negativeInstances[3] = "EMERGENCYCONTACT4";
		negativeInstances[4] = "EMERGENCYCONTACT5";
		negativeInstances[5] = "EMERGENCYCONTACT6";
		negativeInstances[6] = "EMERGENCYCONTACT7";
		negativeInstances[7] = "EMERGENCYCONTACT8";
		negativeInstances[8] = "EMERGENCYCONTACT9";
		negativeInstances[9] = "EMERGENCYCONTACT10";
		negativeInstances[10] = "EMERGENCYCONTACT11";
		negativeInstances[11] = "EMERGENCYCONTACT12";
		negativeInstances[12] = "EMERGENCYCONTACT13";
		negativeInstances[13] = "EMERGENCYCONTACT14";
		negativeInstances[14] = "EMERGENCYCONTACT15";
		return negativeInstances;
	}
	public static SupportNetworkEmergencyContact getNegativeInstance(String name)
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
	public static SupportNetworkEmergencyContact getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SupportNetworkEmergencyContact[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021018;
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT1 = new SupportNetworkEmergencyContact(-95, "Emergency Contact 1", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT2 = new SupportNetworkEmergencyContact(-157, "Emergency Contact 2", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT3 = new SupportNetworkEmergencyContact(-96, "Emergency Contact 3", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT4 = new SupportNetworkEmergencyContact(-158, "Emergency Contact 4", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT5 = new SupportNetworkEmergencyContact(-97, "Emergency Contact 5", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT6 = new SupportNetworkEmergencyContact(-159, "Emergency Contact 6", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT7 = new SupportNetworkEmergencyContact(-107, "Emergency Contact 7", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT8 = new SupportNetworkEmergencyContact(-160, "Emergency Contact 8", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT9 = new SupportNetworkEmergencyContact(-120, "Emergency Contact 9", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT10 = new SupportNetworkEmergencyContact(-161, "Emergency Contact 10", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT11 = new SupportNetworkEmergencyContact(-121, "Emergency Contact 11", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT12 = new SupportNetworkEmergencyContact(-162, "Emergency Contact 12", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT13 = new SupportNetworkEmergencyContact(-122, "Emergency Contact 13", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT14 = new SupportNetworkEmergencyContact(-163, "Emergency Contact 14", true, null, null, Color.Black);
	public static final SupportNetworkEmergencyContact EMERGENCYCONTACT15 = new SupportNetworkEmergencyContact(-123, "Emergency Contact 15", true, null, null, Color.Black);
}
