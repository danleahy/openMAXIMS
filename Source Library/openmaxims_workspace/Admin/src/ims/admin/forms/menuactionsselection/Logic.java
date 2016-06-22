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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.55 build 2741.25619)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.menuactionsselection;

import java.util.ArrayList;

import ims.admin.vo.AppFormMenuActionsVo;
import ims.admin.vo.AppFormMenuActionsVoCollection;
import ims.admin.vo.MenuActionVo;
import ims.admin.vo.MenuActionVoCollection;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.IAppForm;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	@Override
	protected void onTreFormActionsTreeViewSelectionChanged(ims.framework.controls.TreeNode node) throws ims.framework.exceptions.PresentationLogicException
	{	
		loadFormMenuActions(node);
	}
	@Override
	protected void onTreFormActionsTreeViewNodeExpandCollapse(TreeNode node) throws PresentationLogicException 
	{
		if(node.isExpanded())
			loadFormMenuActions(node);		
	}
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Admin.setSelectedMenuActions(getSelection());
		engine.close(DialogResult.OK);
	}
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	private void open()
	{
		loadForms();
	}
	private void loadForms()
	{
		form.treFormActions().clear();
		IAppForm[] forms = sort(engine.getRegisteredForms());
		form.getLocalContext().setAllForms(forms);
//		for (IAppForm form : forms) 
//		{
//			addForm(form);
//		}
	}
	private IAppForm[] sort(IAppForm[] registeredForms) 
	{		
		for(int x = 0; x < registeredForms.length; x++)
		{
			for(int y = 0; y < registeredForms.length; y++)
			{
				if(x != y)
				{
					if(registeredForms[x].getName().compareTo(registeredForms[y].getName()) < 0)
					{
						IAppForm save = registeredForms[x];
						registeredForms[x] = registeredForms[y];
						registeredForms[y] = save;
					}
				}
			}
		}
		
		return registeredForms;
	}
	private void addForm(IAppForm item) 
	{		
		if(item.isComponent())
			return;
		
		String formName = item.getName();
		if(item.isAlias())
			formName += " (" + item.getAliasName() + ")";
		if(item.isDialog())
			formName += " - dialog";
		
		TreeNode node = form.treFormActions().getNodes().add(item, formName);
		node.setExpandedImage(form.getImages().Core.Form);
		node.setCollapsedImage(form.getImages().Core.Form);
		node.setCheckBoxVisible(false);
		
		TreeNode loadingNode = node.getNodes().add(null, "Loading...");
		loadingNode.setExpandedImage(form.getImages().Core.Time);
		loadingNode.setCollapsedImage(form.getImages().Core.Time);
		loadingNode.setCheckBoxVisible(false);
	}
	private void loadFormMenuActions(TreeNode node)
	{
		if(node.getValue() instanceof IAppForm && 				
				node.getNodes().size() == 1 &&
				node.getNodes().get(0).getValue() == null)
		{
			node.getNodes().clear();
			
			MenuActionVoCollection actions = domain.getMenuActions((IAppForm)node.getValue());
			if(actions != null && actions.size() > 0)
			{
				for (MenuActionVo action : actions) 
				{
					addMenuAction(node, action);
				}
			}
			else
			{
				node.setCheckBoxVisible(false);
			}
		}
	}
	private void addMenuAction(TreeNode node, MenuActionVo action) 
	{
		TreeNode actionNode = node.getNodes().add(action, action.getMenuActionDescription());		
		actionNode.setExpandedImage(form.getImages().Emergency.TransferEnabled16);
		actionNode.setCollapsedImage(form.getImages().Emergency.TransferEnabled16);
	}
	private AppFormMenuActionsVoCollection getSelection() 
	{		
		AppFormMenuActionsVoCollection result = new AppFormMenuActionsVoCollection();
		
		for(int x = 0; x < form.treFormActions().getNodes().size(); x++)
		{
			TreeNode node = form.treFormActions().getNodes().get(x);
			
			if(node.getValue() instanceof IAppForm)
			{
				MenuActionVoCollection checkedActions = new MenuActionVoCollection();
				
				for(int y = 0; y < node.getNodes().size(); y++)
				{
					TreeNode childNode = node.getNodes().get(y);
					
					if(childNode.isChecked() && childNode.getValue() instanceof MenuActionVo)
					{
						checkedActions.add((MenuActionVo)childNode.getValue());
					}
				}
				
				if(checkedActions.size() > 0)
				{					
					AppFormMenuActionsVo item = new AppFormMenuActionsVo();
					item.setID_AppForm(((IAppForm)node.getValue()).getFormId());
					item.setMenuActions(checkedActions);
					result.add(item);
				}
			}
		}
		
		return result;
	}
	
	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		form.txtName().setValue(null);
		form.treFormActions().clear();	
	}
	
	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		form.treFormActions().clear();
		populateGridForms();		
	}
	
	private void populateGridForms()
	{
		ArrayList<IAppForm> collectionForm = new ArrayList<IAppForm>();
		
		String formName = "";
		if (form.txtName().getValue() != null && form.txtName().getValue().length() > 0)
			formName = form.txtName().getValue().replaceAll("%", "");
		
		for (int i = 0; i < form.getLocalContext().getAllForms().length; i++)
		{
			IAppForm appFormVo = form.getLocalContext().getAllForms()[i];

			if (appFormVo == null)
				continue;

			if (appFormVo.isAlias())
			{
				if (appFormVo.getAliasName().equalsIgnoreCase(formName) || appFormVo.getAliasName().toUpperCase().contains(formName.toUpperCase()))
				{
					collectionForm.add(appFormVo);
				}
				continue;
			}

			if (appFormVo.getName().equalsIgnoreCase(formName) || appFormVo.getName().toUpperCase().contains(formName.toUpperCase()))
			{
				collectionForm.add(appFormVo);
			}
		}
		
		
		if (collectionForm == null || collectionForm.size() == 0)
			engine.showMessage("No records matching your search criteria were found!", "No results",MessageButtons.OK, MessageIcon.INFORMATION);
		
		for (IAppForm form : collectionForm) 
		{
			addForm(form);
		}
	}
	
}
