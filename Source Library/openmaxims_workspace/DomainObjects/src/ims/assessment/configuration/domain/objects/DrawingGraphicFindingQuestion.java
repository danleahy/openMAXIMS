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
package ims.assessment.configuration.domain.objects;

/**
 * 
 * @author Kevin O'Carroll
 * Generated.
 */


public class DrawingGraphicFindingQuestion extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1028100012;
	private static final long serialVersionUID = 1028100012L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Question */
	private ims.core.clinical.domain.objects.QuestionInformation question;
	/** Order */
	private Integer order;
	/** DrawingGraphicFinding */
	private ims.assessment.configuration.domain.objects.DrawingGraphicFinding drawingGraphicFinding;
	private Boolean active;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public DrawingGraphicFindingQuestion (Integer id, int ver)
    {
    	super(id, ver);
    }
    public DrawingGraphicFindingQuestion ()
    {
    	super();
    }
    public DrawingGraphicFindingQuestion (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.assessment.configuration.domain.objects.DrawingGraphicFindingQuestion.class;
	}


	public ims.core.clinical.domain.objects.QuestionInformation getQuestion() {
		return question;
	}
	public void setQuestion(ims.core.clinical.domain.objects.QuestionInformation question) {
		this.question = question;
	}

	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}

	public ims.assessment.configuration.domain.objects.DrawingGraphicFinding getDrawingGraphicFinding() {
		return drawingGraphicFinding;
	}
	public void setDrawingGraphicFinding(ims.assessment.configuration.domain.objects.DrawingGraphicFinding drawingGraphicFinding) {
		this.drawingGraphicFinding = drawingGraphicFinding;
	}

	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
		
		auditStr.append("\r\n*question* :");
		if (question != null)
		{
			auditStr.append(toShortClassName(question));
				
		    auditStr.append(question.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*order* :");
		auditStr.append(order);
	    auditStr.append("; ");
		auditStr.append("\r\n*drawingGraphicFinding* :");
		if (drawingGraphicFinding != null)
		{
			auditStr.append(toShortClassName(drawingGraphicFinding));
				
		    auditStr.append(drawingGraphicFinding.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*active* :");
		auditStr.append(active);
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
		
		String keyClassName = "DrawingGraphicFindingQuestion";
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
		if (this.getQuestion() != null)
		{
			sb.append("<question>");
			sb.append(this.getQuestion().toXMLString(domMap)); 	
			sb.append("</question>");		
		}
		if (this.getOrder() != null)
		{
			sb.append("<order>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getOrder().toString()));
			sb.append("</order>");		
		}
		if (this.getDrawingGraphicFinding() != null)
		{
			sb.append("<drawingGraphicFinding>");
			sb.append(this.getDrawingGraphicFinding().toXMLString(domMap)); 	
			sb.append("</drawingGraphicFinding>");		
		}
		if (this.isActive() != null)
		{
			sb.append("<active>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isActive().toString()));
			sb.append("</active>");		
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
			DrawingGraphicFindingQuestion domainObject = getDrawingGraphicFindingQuestionfromXML(itemEl, factory, domMap);

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
			DrawingGraphicFindingQuestion domainObject = getDrawingGraphicFindingQuestionfromXML(itemEl, factory, domMap);

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
		
	public static DrawingGraphicFindingQuestion getDrawingGraphicFindingQuestionfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getDrawingGraphicFindingQuestionfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static DrawingGraphicFindingQuestion getDrawingGraphicFindingQuestionfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!DrawingGraphicFindingQuestion.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!DrawingGraphicFindingQuestion.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the DrawingGraphicFindingQuestion class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (DrawingGraphicFindingQuestion)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(DrawingGraphicFindingQuestion.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		DrawingGraphicFindingQuestion ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (DrawingGraphicFindingQuestion)factory.getImportedDomainObject(DrawingGraphicFindingQuestion.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new DrawingGraphicFindingQuestion();
		}
		String keyClassName = "DrawingGraphicFindingQuestion";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (DrawingGraphicFindingQuestion)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, DrawingGraphicFindingQuestion obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("question");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setQuestion(ims.core.clinical.domain.objects.QuestionInformation.getQuestionInformationfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("order");
		if(fldEl != null)
		{	
    		obj.setOrder(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("drawingGraphicFinding");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setDrawingGraphicFinding(ims.assessment.configuration.domain.objects.DrawingGraphicFinding.getDrawingGraphicFindingfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("active");
		if(fldEl != null)
		{	
    		obj.setActive(new Boolean(fldEl.getTextTrim()));	
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
		public static final String Question = "question";
		public static final String Order = "order";
		public static final String DrawingGraphicFinding = "drawingGraphicFinding";
		public static final String Active = "active";
	}
}

