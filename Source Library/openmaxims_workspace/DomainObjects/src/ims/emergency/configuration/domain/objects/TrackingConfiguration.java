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
package ims.emergency.configuration.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class TrackingConfiguration extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1087100000;
	private static final long serialVersionUID = 1087100000L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** ED Location */
	private ims.core.resource.place.domain.objects.Location eDLocation;
	/** is Active */
	private Boolean isActive;
	/** Tracking Areas
	  * Collection of ims.emergency.configuration.domain.objects.TrackingArea.
	  */
	private java.util.List areas;
	/** Area Count Refresh Rate */
	private Integer areaCountRefreshRate;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public TrackingConfiguration (Integer id, int ver)
    {
    	super(id, ver);
    }
    public TrackingConfiguration ()
    {
    	super();
    }
    public TrackingConfiguration (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.emergency.configuration.domain.objects.TrackingConfiguration.class;
	}


	public ims.core.resource.place.domain.objects.Location getEDLocation() {
		return eDLocation;
	}
	public void setEDLocation(ims.core.resource.place.domain.objects.Location eDLocation) {
		this.eDLocation = eDLocation;
	}

	public Boolean isIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public java.util.List getAreas() {
		if ( null == areas ) {
			areas = new java.util.ArrayList();
		}
		return areas;
	}
	public void setAreas(java.util.List paramValue) {
		this.areas = paramValue;
	}

	public Integer getAreaCountRefreshRate() {
		return areaCountRefreshRate;
	}
	public void setAreaCountRefreshRate(Integer areaCountRefreshRate) {
		this.areaCountRefreshRate = areaCountRefreshRate;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
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
		
		auditStr.append("\r\n*eDLocation* :");
		if (eDLocation != null)
		{
			auditStr.append(toShortClassName(eDLocation));
				
		    auditStr.append(eDLocation.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*isActive* :");
		auditStr.append(isActive);
	    auditStr.append("; ");
		auditStr.append("\r\n*areas* :");
		if (areas != null)
		{
		int i3=0;
		for (i3=0; i3<areas.size(); i3++)
		{
			if (i3 > 0)
				auditStr.append(",");
			ims.emergency.configuration.domain.objects.TrackingArea obj = (ims.emergency.configuration.domain.objects.TrackingArea)areas.get(i3);
		    if (obj != null)
			{
				if (i3 == 0)
				{
				auditStr.append(toShortClassName(obj));
				auditStr.append("[");
				}
		        auditStr.append(obj.getId());
			}
		}
		if (i3 > 0)
			auditStr.append("] " + i3);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*areaCountRefreshRate* :");
		auditStr.append(areaCountRefreshRate);
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
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "TrackingConfiguration";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getEDLocation() != null)
		{
			sb.append("<eDLocation>");
			sb.append(this.getEDLocation().toXMLString(domMap)); 	
			sb.append("</eDLocation>");		
		}
		if (this.isIsActive() != null)
		{
			sb.append("<isActive>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isIsActive().toString()));
			sb.append("</isActive>");		
		}
		if (this.getAreas() != null)
		{
			if (this.getAreas().size() > 0 )
			{
			sb.append("<areas>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getAreas(), domMap));
			sb.append("</areas>");		
			}
		}
		if (this.getAreaCountRefreshRate() != null)
		{
			sb.append("<areaCountRefreshRate>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getAreaCountRefreshRate().toString()));
			sb.append("</areaCountRefreshRate>");		
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
			TrackingConfiguration domainObject = getTrackingConfigurationfromXML(itemEl, factory, domMap);

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
			TrackingConfiguration domainObject = getTrackingConfigurationfromXML(itemEl, factory, domMap);

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
		
	public static TrackingConfiguration getTrackingConfigurationfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getTrackingConfigurationfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static TrackingConfiguration getTrackingConfigurationfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!TrackingConfiguration.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!TrackingConfiguration.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the TrackingConfiguration class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (TrackingConfiguration)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(TrackingConfiguration.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		TrackingConfiguration ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (TrackingConfiguration)factory.getImportedDomainObject(TrackingConfiguration.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new TrackingConfiguration();
		}
		String keyClassName = "TrackingConfiguration";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (TrackingConfiguration)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, TrackingConfiguration obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("eDLocation");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setEDLocation(ims.core.resource.place.domain.objects.Location.getLocationfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("isActive");
		if(fldEl != null)
		{	
    		obj.setIsActive(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("areas");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setAreas(ims.emergency.configuration.domain.objects.TrackingArea.fromListXMLString(fldEl, factory, obj.getAreas(), domMap));
		}
		fldEl = el.element("areaCountRefreshRate");
		if(fldEl != null)
		{	
    		obj.setAreaCountRefreshRate(new Integer(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "areas"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String EDLocation = "eDLocation";
		public static final String IsActive = "isActive";
		public static final String Areas = "areas";
		public static final String AreaCountRefreshRate = "areaCountRefreshRate";
	}
}

