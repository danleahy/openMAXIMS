// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ReportNotePrintTemplateVoBean extends ims.vo.ValueObjectBean
{
	public ReportNotePrintTemplateVoBean()
	{
	}
	public ReportNotePrintTemplateVoBean(ims.RefMan.vo.ReportNotePrintTemplateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.notetype = vo.getNoteType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteType().getBean();
		this.template = vo.getTemplate() == null ? null : (ims.admin.vo.beans.ReportTemplateLiteVoBean)vo.getTemplate().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReportNotePrintTemplateVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.notetype = vo.getNoteType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNoteType().getBean();
		this.template = vo.getTemplate() == null ? null : (ims.admin.vo.beans.ReportTemplateLiteVoBean)vo.getTemplate().getBean(map);
	}

	public ims.RefMan.vo.ReportNotePrintTemplateVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReportNotePrintTemplateVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReportNotePrintTemplateVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReportNotePrintTemplateVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReportNotePrintTemplateVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.vo.LookupInstanceBean value)
	{
		this.notetype = value;
	}
	public ims.admin.vo.beans.ReportTemplateLiteVoBean getTemplate()
	{
		return this.template;
	}
	public void setTemplate(ims.admin.vo.beans.ReportTemplateLiteVoBean value)
	{
		this.template = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean notetype;
	private ims.admin.vo.beans.ReportTemplateLiteVoBean template;
}
