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

public class ReferralInitiatedFrom extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReferralInitiatedFrom()
	{
		super();
	}
	public ReferralInitiatedFrom(int id)
	{
		super(id, "", true);
	}
	public ReferralInitiatedFrom(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReferralInitiatedFrom(int id, String text, boolean active, ReferralInitiatedFrom parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReferralInitiatedFrom(int id, String text, boolean active, ReferralInitiatedFrom parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReferralInitiatedFrom(int id, String text, boolean active, ReferralInitiatedFrom parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReferralInitiatedFrom buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReferralInitiatedFrom(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReferralInitiatedFrom)super.getParentInstance();
	}
	public ReferralInitiatedFrom getParent()
	{
		return (ReferralInitiatedFrom)super.getParentInstance();
	}
	public void setParent(ReferralInitiatedFrom parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReferralInitiatedFrom[] typedChildren = new ReferralInitiatedFrom[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReferralInitiatedFrom)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReferralInitiatedFrom)
		{
			super.addChild((ReferralInitiatedFrom)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReferralInitiatedFrom)
		{
			super.removeChild((ReferralInitiatedFrom)child);
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
		ReferralInitiatedFromCollection result = new ReferralInitiatedFromCollection();
		result.add(COMUNITY_DENTAL);
		result.add(DENTAL);
		result.add(PROSTHETIST);
		result.add(CLINICAL_NURSE_SPECIALIST);
		result.add(AHP);
		result.add(OPTOMETRIST);
		result.add(ORTHOPTIST);
		result.add(EMERGENCY);
		result.add(DOMICILIARY);
		result.add(A_AND_E);
		result.add(OTHER);
		return result;
	}
	public static ReferralInitiatedFrom[] getNegativeInstances()
	{
		ReferralInitiatedFrom[] instances = new ReferralInitiatedFrom[11];
		instances[0] = COMUNITY_DENTAL;
		instances[1] = DENTAL;
		instances[2] = PROSTHETIST;
		instances[3] = CLINICAL_NURSE_SPECIALIST;
		instances[4] = AHP;
		instances[5] = OPTOMETRIST;
		instances[6] = ORTHOPTIST;
		instances[7] = EMERGENCY;
		instances[8] = DOMICILIARY;
		instances[9] = A_AND_E;
		instances[10] = OTHER;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[11];
		negativeInstances[0] = "COMUNITY_DENTAL";
		negativeInstances[1] = "DENTAL";
		negativeInstances[2] = "PROSTHETIST";
		negativeInstances[3] = "CLINICAL_NURSE_SPECIALIST";
		negativeInstances[4] = "AHP";
		negativeInstances[5] = "OPTOMETRIST";
		negativeInstances[6] = "ORTHOPTIST";
		negativeInstances[7] = "EMERGENCY";
		negativeInstances[8] = "DOMICILIARY";
		negativeInstances[9] = "A_AND_E";
		negativeInstances[10] = "OTHER";
		return negativeInstances;
	}
	public static ReferralInitiatedFrom getNegativeInstance(String name)
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
	public static ReferralInitiatedFrom getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReferralInitiatedFrom[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341058;
	public static final ReferralInitiatedFrom COMUNITY_DENTAL = new ReferralInitiatedFrom(-3213, "Community Dental", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom DENTAL = new ReferralInitiatedFrom(-3214, "Dental", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom PROSTHETIST = new ReferralInitiatedFrom(-3215, "Prosthetist", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom CLINICAL_NURSE_SPECIALIST = new ReferralInitiatedFrom(-3216, "Clinical Nurse Specialist", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom AHP = new ReferralInitiatedFrom(-3217, "AHP", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom OPTOMETRIST = new ReferralInitiatedFrom(-3218, "Optometrist", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom ORTHOPTIST = new ReferralInitiatedFrom(-3219, "Orthoptist", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom EMERGENCY = new ReferralInitiatedFrom(-3220, "Following an Emergency Admission", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom DOMICILIARY = new ReferralInitiatedFrom(-3221, "Following a Domiciliary Consultation", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom A_AND_E = new ReferralInitiatedFrom(-3222, "Following an Accident and Emergency Attendance", true, null, null, Color.Default);
	public static final ReferralInitiatedFrom OTHER = new ReferralInitiatedFrom(-3395, "Other", true, null, null, Color.Default);
}
