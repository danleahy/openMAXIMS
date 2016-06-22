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
 * @author Rory Fitzpatrick
 * Generated.
 */


public class WhiteBoardOtherActions extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1087100024;
	private static final long serialVersionUID = 1087100024L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** OtherActionType */
	private ims.domain.lookups.LookupInstance otherActionType;
	/** OtherActionTooltip */
	private String otherActionTooltip;
	/** ActionIcon */
	private ims.core.configuration.domain.objects.AppImage actionIcon;
	/** RequiredIcon */
	private ims.core.configuration.domain.objects.AppImage requiredIcon;
	/** CompleteIcon */
	private ims.core.configuration.domain.objects.AppImage completeIcon;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public WhiteBoardOtherActions (Integer id, int ver)
    {
    	super(id, ver);
    }
    public WhiteBoardOtherActions ()
    {
    	super();
    }
    public WhiteBoardOtherActions (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.emergency.configuration.domain.objects.WhiteBoardOtherActions.class;
	}


	public ims.domain.lookups.LookupInstance getOtherActionType() {
		return otherActionType;
	}
	public void setOtherActionType(ims.domain.lookups.LookupInstance otherActionType) {
		this.otherActionType = otherActionType;
	}

	public String getOtherActionTooltip() {
		return otherActionTooltip;
	}
	public void setOtherActionTooltip(String otherActionTooltip) {
		if ( null != otherActionTooltip && otherActionTooltip.length() > 255 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for otherActionTooltip. Tried to set value: "+
				otherActionTooltip);
		}
		this.otherActionTooltip = otherActionTooltip;
	}

	public ims.core.configuration.domain.objects.AppImage getActionIcon() {
		return actionIcon;
	}
	public void setActionIcon(ims.core.configuration.domain.objects.AppImage actionIcon) {
		this.actionIcon = actionIcon;
	}

	public ims.core.configuration.domain.objects.AppImage getRequiredIcon() {
		return requiredIcon;
	}
	public void setRequiredIcon(ims.core.configuration.domain.objects.AppImage requiredIcon) {
		this.requiredIcon = requiredIcon;
	}

	public ims.core.configuration.domain.objects.AppImage getCompleteIcon() {
		return completeIcon;
	}
	public void setCompleteIcon(ims.core.configuration.domain.objects.AppImage completeIcon) {
		this.completeIcon = completeIcon;
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
		if ( "Instantiation".equals("Configuration") )
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
		
		auditStr.append("\r\n*otherActionType* :");
		if (otherActionType != null)
			auditStr.append(otherActionType.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*otherActionTooltip* :");
		auditStr.append(otherActionTooltip);
	    auditStr.append("; ");
		auditStr.append("\r\n*actionIcon* :");
		if (actionIcon != null)
		{
			auditStr.append(toShortClassName(actionIcon));
				
		    auditStr.append(actionIcon.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*requiredIcon* :");
		if (requiredIcon != null)
		{
			auditStr.append(toShortClassName(requiredIcon));
				
		    auditStr.append(requiredIcon.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*completeIcon* :");
		if (completeIcon != null)
		{
			auditStr.append(toShortClassName(completeIcon));
				
		    auditStr.append(completeIcon.getId());
		}
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
		
		String keyClassName = "WhiteBoardOtherActions";
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
		if (this.getOtherActionType() != null)
		{
			sb.append("<otherActionType>");
			sb.append(this.getOtherActionType().toXMLString()); 
			sb.append("</otherActionType>");		
		}
		if (this.getOtherActionTooltip() != null)
		{
			sb.append("<otherActionTooltip>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getOtherActionTooltip().toString()));
			sb.append("</otherActionTooltip>");		
		}
		if (this.getActionIcon() != null)
		{
			sb.append("<actionIcon>");
			sb.append(this.getActionIcon().toXMLString(domMap)); 	
			sb.append("</actionIcon>");		
		}
		if (this.getRequiredIcon() != null)
		{
			sb.append("<requiredIcon>");
			sb.append(this.getRequiredIcon().toXMLString(domMap)); 	
			sb.append("</requiredIcon>");		
		}
		if (this.getCompleteIcon() != null)
		{
			sb.append("<completeIcon>");
			sb.append(this.getCompleteIcon().toXMLString(domMap)); 	
			sb.append("</completeIcon>");		
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
			WhiteBoardOtherActions domainObject = getWhiteBoardOtherActionsfromXML(itemEl, factory, domMap);

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
			WhiteBoardOtherActions domainObject = getWhiteBoardOtherActionsfromXML(itemEl, factory, domMap);

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
		
	public static WhiteBoardOtherActions getWhiteBoardOtherActionsfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getWhiteBoardOtherActionsfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static WhiteBoardOtherActions getWhiteBoardOtherActionsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!WhiteBoardOtherActions.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!WhiteBoardOtherActions.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the WhiteBoardOtherActions class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (WhiteBoardOtherActions)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(WhiteBoardOtherActions.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		WhiteBoardOtherActions ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (WhiteBoardOtherActions)factory.getImportedDomainObject(WhiteBoardOtherActions.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new WhiteBoardOtherActions();
		}
		String keyClassName = "WhiteBoardOtherActions";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (WhiteBoardOtherActions)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, WhiteBoardOtherActions obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("otherActionType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setOtherActionType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("otherActionTooltip");
		if(fldEl != null)
		{	
    		obj.setOtherActionTooltip(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("actionIcon");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setActionIcon(ims.core.configuration.domain.objects.AppImage.getAppImagefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("requiredIcon");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setRequiredIcon(ims.core.configuration.domain.objects.AppImage.getAppImagefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("completeIcon");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setCompleteIcon(ims.core.configuration.domain.objects.AppImage.getAppImagefromXML(fldEl, factory, domMap)); 
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
		public static final String OtherActionType = "otherActionType";
		public static final String OtherActionTooltip = "otherActionTooltip";
		public static final String ActionIcon = "actionIcon";
		public static final String RequiredIcon = "requiredIcon";
		public static final String CompleteIcon = "completeIcon";
	}
}

