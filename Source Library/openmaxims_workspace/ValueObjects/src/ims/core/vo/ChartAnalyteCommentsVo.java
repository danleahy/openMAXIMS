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

package ims.core.vo;


public class ChartAnalyteCommentsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IChartValueAnalyte
{
	private static final long serialVersionUID = 1L;

	public ChartAnalyteCommentsVo()
	{
	}
	public ChartAnalyteCommentsVo(ims.core.vo.beans.ChartAnalyteCommentsVoBean bean)
	{
		this.investigationname = bean.getInvestigationName();
		this.specimenname = bean.getSpecimenName();
		this.analyte = bean.getAnalyte();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDateTime();
		this.displayflag = bean.getDisplayFlag();
		this.comments = ims.core.vo.ChartValueCommentVoCollection.buildFromBeanCollection(bean.getComments());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartAnalyteCommentsVoBean bean)
	{
		this.investigationname = bean.getInvestigationName();
		this.specimenname = bean.getSpecimenName();
		this.analyte = bean.getAnalyte();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDateTime();
		this.displayflag = bean.getDisplayFlag();
		this.comments = ims.core.vo.ChartValueCommentVoCollection.buildFromBeanCollection(bean.getComments());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartAnalyteCommentsVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartAnalyteCommentsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartAnalyteCommentsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getInvestigationNameIsNotNull()
	{
		return this.investigationname != null;
	}
	public String getInvestigationName()
	{
		return this.investigationname;
	}
	public static int getInvestigationNameMaxLength()
	{
		return 255;
	}
	public void setInvestigationName(String value)
	{
		this.isValidated = false;
		this.investigationname = value;
	}
	public boolean getSpecimenNameIsNotNull()
	{
		return this.specimenname != null;
	}
	public String getSpecimenName()
	{
		return this.specimenname;
	}
	public static int getSpecimenNameMaxLength()
	{
		return 255;
	}
	public void setSpecimenName(String value)
	{
		this.isValidated = false;
		this.specimenname = value;
	}
	public boolean getAnalyteIsNotNull()
	{
		return this.analyte != null;
	}
	public String getAnalyte()
	{
		return this.analyte;
	}
	public static int getAnalyteMaxLength()
	{
		return 255;
	}
	public void setAnalyte(String value)
	{
		this.isValidated = false;
		this.analyte = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.DateTime getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.date = value;
	}
	public boolean getDisplayFlagIsNotNull()
	{
		return this.displayflag != null;
	}
	public String getDisplayFlag()
	{
		return this.displayflag;
	}
	public static int getDisplayFlagMaxLength()
	{
		return 255;
	}
	public void setDisplayFlag(String value)
	{
		this.isValidated = false;
		this.displayflag = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public ims.core.vo.ChartValueCommentVoCollection getComments()
	{
		return this.comments;
	}
	public void setComments(ims.core.vo.ChartValueCommentVoCollection value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	/**
	* IChartValueComments interface implementation
	*/
		public String getIChartAnalyteInvestigationName()
		{
			return investigationname;
		}
		public String getIChartAnalyteSpecimenName()
		{
			return specimenname;
		}
		public String getIChartAnalyteName()
		{
			return analyte;
		}
		public ims.framework.utils.DateTime getIChartAnalyteDate()
		{
			return date;
		}
		public String getIChartAnalyteDisplayFlag()
		{
			return displayflag;
		}
		public ims.vo.interfaces.IChartValueComment[] getIChartAnalyteComments()
		{
			if (comments == null)
				return new  ims.vo.interfaces.IChartValueComment[0];
			
		
			ims.vo.interfaces.IChartValueComment[] analyteComments = new ims.vo.interfaces.IChartValueComment[comments.size()];
				
			for (int x = 0; x < comments.size(); x++)
			{
				analyteComments[x] = comments.get(x);
			}
		
			return analyteComments;
		}
	
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ChartAnalyteCommentsVo clone = new ChartAnalyteCommentsVo();
		
		clone.investigationname = this.investigationname;
		clone.specimenname = this.specimenname;
		clone.analyte = this.analyte;
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.DateTime)this.date.clone();
		clone.displayflag = this.displayflag;
		if(this.comments == null)
			clone.comments = null;
		else
			clone.comments = (ims.core.vo.ChartValueCommentVoCollection)this.comments.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ChartAnalyteCommentsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartAnalyteCommentsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartAnalyteCommentsVo compareObj = (ChartAnalyteCommentsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getDate() == null && compareObj.getDate() != null)
				return -1;
			if(this.getDate() != null && compareObj.getDate() == null)
				return 1;
			if(this.getDate() != null && compareObj.getDate() != null)
				retVal = this.getDate().compareTo(compareObj.getDate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.investigationname != null)
			count++;
		if(this.specimenname != null)
			count++;
		if(this.analyte != null)
			count++;
		if(this.date != null)
			count++;
		if(this.displayflag != null)
			count++;
		if(this.comments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String investigationname;
	protected String specimenname;
	protected String analyte;
	protected ims.framework.utils.DateTime date;
	protected String displayflag;
	protected ims.core.vo.ChartValueCommentVoCollection comments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
