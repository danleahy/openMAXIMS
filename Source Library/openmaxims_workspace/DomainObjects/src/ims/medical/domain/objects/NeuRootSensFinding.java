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
package ims.medical.domain.objects;

/**
 * 
 * @author Kevin O'Carroll
 * Generated.
 */


public class NeuRootSensFinding extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1023100018;
	private static final long serialVersionUID = 1023100018L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	private ims.core.clinical.domain.objects.VertebralLevels rootValue;
	private Integer rightFinding;
	private Integer leftFinding;
	private ims.domain.lookups.LookupInstance sensationType;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public NeuRootSensFinding (Integer id, int ver)
    {
    	super(id, ver);
    }
    public NeuRootSensFinding ()
    {
    	super();
    }
    public NeuRootSensFinding (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.medical.domain.objects.NeuRootSensFinding.class;
	}


	public ims.core.clinical.domain.objects.VertebralLevels getRootValue() {
		return rootValue;
	}
	public void setRootValue(ims.core.clinical.domain.objects.VertebralLevels rootValue) {
		this.rootValue = rootValue;
	}

	public Integer getRightFinding() {
		return rightFinding;
	}
	public void setRightFinding(Integer rightFinding) {
		this.rightFinding = rightFinding;
	}

	public Integer getLeftFinding() {
		return leftFinding;
	}
	public void setLeftFinding(Integer leftFinding) {
		this.leftFinding = leftFinding;
	}

	public ims.domain.lookups.LookupInstance getSensationType() {
		return sensationType;
	}
	public void setSensationType(ims.domain.lookups.LookupInstance sensationType) {
		this.sensationType = sensationType;
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
		
		auditStr.append("\r\n*rootValue* :");
		if (rootValue != null)
		{
			auditStr.append(toShortClassName(rootValue));
				
		    auditStr.append(rootValue.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*rightFinding* :");
		auditStr.append(rightFinding);
	    auditStr.append("; ");
		auditStr.append("\r\n*leftFinding* :");
		auditStr.append(leftFinding);
	    auditStr.append("; ");
		auditStr.append("\r\n*sensationType* :");
		if (sensationType != null)
			auditStr.append(sensationType.getText());
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
		
		String keyClassName = "NeuRootSensFinding";
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
		if (this.getRootValue() != null)
		{
			sb.append("<rootValue>");
			sb.append(this.getRootValue().toXMLString(domMap)); 	
			sb.append("</rootValue>");		
		}
		if (this.getRightFinding() != null)
		{
			sb.append("<rightFinding>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getRightFinding().toString()));
			sb.append("</rightFinding>");		
		}
		if (this.getLeftFinding() != null)
		{
			sb.append("<leftFinding>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getLeftFinding().toString()));
			sb.append("</leftFinding>");		
		}
		if (this.getSensationType() != null)
		{
			sb.append("<sensationType>");
			sb.append(this.getSensationType().toXMLString()); 
			sb.append("</sensationType>");		
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
			NeuRootSensFinding domainObject = getNeuRootSensFindingfromXML(itemEl, factory, domMap);

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
			NeuRootSensFinding domainObject = getNeuRootSensFindingfromXML(itemEl, factory, domMap);

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
		
	public static NeuRootSensFinding getNeuRootSensFindingfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getNeuRootSensFindingfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static NeuRootSensFinding getNeuRootSensFindingfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!NeuRootSensFinding.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!NeuRootSensFinding.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the NeuRootSensFinding class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (NeuRootSensFinding)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(NeuRootSensFinding.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		NeuRootSensFinding ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (NeuRootSensFinding)factory.getImportedDomainObject(NeuRootSensFinding.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new NeuRootSensFinding();
		}
		String keyClassName = "NeuRootSensFinding";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (NeuRootSensFinding)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, NeuRootSensFinding obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("rootValue");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setRootValue(ims.core.clinical.domain.objects.VertebralLevels.getVertebralLevelsfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("rightFinding");
		if(fldEl != null)
		{	
    		obj.setRightFinding(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("leftFinding");
		if(fldEl != null)
		{	
    		obj.setLeftFinding(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("sensationType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setSensationType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
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
		public static final String RootValue = "rootValue";
		public static final String RightFinding = "rightFinding";
		public static final String LeftFinding = "leftFinding";
		public static final String SensationType = "sensationType";
	}
}

