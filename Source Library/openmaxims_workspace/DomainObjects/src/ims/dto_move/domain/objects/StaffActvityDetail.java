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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.dto_move.domain.objects;

/**
 * 
 * @author Barbara Worwood
 * Generated.
 */


public class StaffActvityDetail extends ims.domain.DomainObject implements java.io.Serializable {
	public static final int CLASSID = 1105100040;
	private static final long serialVersionUID = 1105100040L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Not sure whether this is a separete bo or not, not same as ActivityGroup?? */
	private ims.dto_move.domain.objects.ActivityGroup group;
	private String active;
	private Integer activityId;
    public StaffActvityDetail (Integer id, int ver)
    {
    	super(id, ver);
		isComponentClass=true;
    }
    public StaffActvityDetail ()
    {
    	super();
		isComponentClass=true;
    }
    public StaffActvityDetail (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
		isComponentClass=true;
    }
	public Class getRealDomainClass()
	{
		return ims.dto_move.domain.objects.StaffActvityDetail.class;
	}


	public ims.dto_move.domain.objects.ActivityGroup getGroup() {
		return group;
	}
	public void setGroup(ims.dto_move.domain.objects.ActivityGroup group) {
		this.group = group;
	}

	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		if ( null != active && active.length() > 1 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for active. Tried to set value: "+
				active);
		}
		this.active = active;
	}

	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Configuration".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*group* :");
		if (group != null)
		{
			auditStr.append(toShortClassName(group));
				
		    auditStr.append(group.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*active* :");
		auditStr.append(active);
	    auditStr.append("; ");
		auditStr.append("\r\n*activityId* :");
		auditStr.append(activityId);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getGroup() != null)
		{
			sb.append("<group>");
			sb.append(this.getGroup().toXMLString(domMap)); 	
			sb.append("</group>");		
		}
		if (this.getActive() != null)
		{
			sb.append("<active>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getActive().toString()));
			sb.append("</active>");		
		}
		if (this.getActivityId() != null)
		{
			sb.append("<activityId>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getActivityId().toString()));
			sb.append("</activityId>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			StaffActvityDetail domainObject = getStaffActvityDetailfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			StaffActvityDetail domainObject = getStaffActvityDetailfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static StaffActvityDetail getStaffActvityDetailfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getStaffActvityDetailfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static StaffActvityDetail getStaffActvityDetailfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!StaffActvityDetail.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!StaffActvityDetail.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the StaffActvityDetail class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (StaffActvityDetail)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(StaffActvityDetail.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		StaffActvityDetail ret = null;
		if (ret == null)
		{
			ret = new StaffActvityDetail();
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, StaffActvityDetail obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("group");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setGroup(ims.dto_move.domain.objects.ActivityGroup.getActivityGroupfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("active");
		if(fldEl != null)
		{	
    		obj.setActive(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("activityId");
		if(fldEl != null)
		{	
    		obj.setActivityId(new Integer(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Group = "group";
		public static final String Active = "active";
		public static final String ActivityId = "activityId";
	}
}

