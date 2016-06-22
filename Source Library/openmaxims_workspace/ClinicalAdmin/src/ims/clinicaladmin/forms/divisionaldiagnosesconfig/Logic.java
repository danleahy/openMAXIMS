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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.clinicaladmin.forms.divisionaldiagnosesconfig;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.DiagLiteVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.core.vo.DivisionalDiagnosesVo;
import ims.core.vo.DivisionalDiagnosesVoCollection;
import ims.core.vo.lookups.DiagnosisDivisions;
import ims.core.vo.lookups.DiagnosisDivisionsCollection;
import ims.core.vo.lookups.LookupHelper;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		open();

	}

	private void open()
	{
		displayDivisions();
		populateDivisionsWithDiagnoses();

		if (form.getLocalContext().getSelectedDivision() != null)
		{
			form.treDivisionalDiganosis().getNodeByValue(form.getLocalContext().getSelectedDivision()).setExpanded(Boolean.TRUE);
			form.treDivisionalDiganosis().setValue(form.getLocalContext().getSelectedDivision());
		}
		else if (form.getLocalContext().getSelectedLookup() != null)
		{
			form.treDivisionalDiganosis().setValue(form.getLocalContext().getSelectedLookup());
		}

	}

	private void displayDivisions()
	{
		form.treDivisionalDiganosis().clear();

		DiagnosisDivisionsCollection lkpCollDivisions = LookupHelper.getDiagnosisDivisions(domain.getLookupService());

		if (lkpCollDivisions != null)
		{
			for (int x = 0; x < lkpCollDivisions.size(); x++)
			{
				TreeNode node = form.treDivisionalDiganosis().getNodes().add(lkpCollDivisions.get(x), lkpCollDivisions.get(x).getText());
				setNodeImage(node, Color.Red);
			}
		}
	}

	private void populateDivisionsWithDiagnoses()
	{
		DivisionalDiagnosesVoCollection divisionalDiagnosesColl = domain.getDivisionalDiagnosis();

		for (int i = 0; i < divisionalDiagnosesColl.size(); i++)
		{
			DivisionalDiagnosesVo divDiagn = divisionalDiagnosesColl.get(i);

			for (int j = 0; j < form.treDivisionalDiganosis().getNodes().size(); j++)
			{
				TreeNode node = form.treDivisionalDiganosis().getNodes().get(j);

				if (node.getNodes() == null || node.getNodes().size() == 0) // parent
																			// node
				{
					if (node.getValue() instanceof DiagnosisDivisions)
					{
						if (divDiagn.getDivision().equals((DiagnosisDivisions) node.getValue()))
						{
							node.setValue(divDiagn);
							setNodeImage(node, Color.Green);

							for (int k = 0; divDiagn.getDiagnoses() != null && k < divDiagn.getDiagnoses().size(); k++)
							{
								TreeNode childNode = node.getNodes().add(divDiagn.getDiagnoses().get(k), divDiagn.getDiagnoses().get(k).getDiagnosisName());
								childNode.setValue(divDiagn.getDiagnoses().get(k));

								if (!Boolean.TRUE.equals(divDiagn.getDiagnoses().get(k).getIsActive()))
								{
									childNode.setTextColor(Color.Gray);
								}

								setNodeImage(childNode, Color.Blue);
							}
						}
					}
				}
			}
		}
	}

	private void setNodeImage(TreeNode node, Color color)
	{
		if (color == Color.Red)
		{
			node.setExpandedImage(form.getImages().Core.RedSqaure);
			node.setCollapsedImage(form.getImages().Core.RedSqaure);
			node.setSelectedImage(form.getImages().Core.RedSqaure);
		}
		else if (color == Color.Green)
		{
			node.setExpandedImage(form.getImages().Core.GreenSquare);
			node.setCollapsedImage(form.getImages().Core.GreenSquare);
			node.setSelectedImage(form.getImages().Core.GreenSquare);
		}
		else if (color == Color.Blue)
		{
			node.setExpandedImage(form.getImages().Admin.Service);
			node.setCollapsedImage(form.getImages().Admin.Service);
			node.setSelectedImage(form.getImages().Admin.Service);
		}
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		openSelectionDialog();

	}

	private void openSelectionDialog()
	{
		if (form.treDivisionalDiganosis().getSelectedNode().getValue() instanceof DiagnosisDivisions)
		{
			DivisionalDiagnosesVo divisionalDiagnoses = new DivisionalDiagnosesVo();
			divisionalDiagnoses.setDivision((DiagnosisDivisions) form.treDivisionalDiganosis().getSelectedNode().getValue());
			divisionalDiagnoses.setDiagnoses(new DiagLiteVoCollection());

			form.getLocalContext().setSelectedDivision(null);
			form.getLocalContext().setSelectedLookup((DiagnosisDivisions) form.treDivisionalDiganosis().getSelectedNode().getValue());

			form.getGlobalContext().ClinicalAdmin.setDivisionalDiagnoses(divisionalDiagnoses);
		}
		else if (form.treDivisionalDiganosis().getSelectedNode().getValue() instanceof DivisionalDiagnosesVo)
		{
			form.getLocalContext().setSelectedDivision((DivisionalDiagnosesVo) form.treDivisionalDiganosis().getSelectedNode().getValue());
			form.getLocalContext().setSelectedLookup(null);

			form.getGlobalContext().ClinicalAdmin.setDivisionalDiagnoses((DivisionalDiagnosesVo) form.treDivisionalDiganosis().getSelectedNode().getValue());
		}
		else if (form.treDivisionalDiganosis().getSelectedNode().getValue() instanceof DiagLiteVo)
		{
			form.getLocalContext().setSelectedDivision((DivisionalDiagnosesVo) form.treDivisionalDiganosis().getSelectedNode().getParent().getValue());
			form.getLocalContext().setSelectedLookup(null);

			form.getGlobalContext().ClinicalAdmin.setDivisionalDiagnoses((DivisionalDiagnosesVo) form.treDivisionalDiganosis().getSelectedNode().getParent().getValue());
		}

		engine.open(form.getForms().ClinicalAdmin.DivisionalDiagnosesSelectionDialog);

	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().ClinicalAdmin.DivisionalDiagnosesSelectionDialog) && DialogResult.OK.equals(result))
		{
			// check if there is already a record saved for the same division
			if (form.getGlobalContext().ClinicalAdmin.getDivisionalDiagnoses().getID_DivisionalDiagnoses() == null && domain.recordWasAlreadySaved(form.getGlobalContext().ClinicalAdmin.getDivisionalDiagnoses()))
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				return;
			}
			else
				try
				{
					form.getLocalContext().setSelectedDivision(domain.saveDivisionalDiagnoses(form.getGlobalContext().ClinicalAdmin.getDivisionalDiagnoses()));
				}
				catch (StaleObjectException e)
				{
					engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				}
		}

		open();
		updateControlsState();

	}

	@Override
	protected void onTreDivisionalDiganosisTreeViewSelectionChanged(TreeNode node) throws PresentationLogicException
	{
		updateControlsState();

	}

	private void updateControlsState()
	{
		boolean nodeSelected = form.treDivisionalDiganosis().getSelectedNode() != null;

		form.getContextMenus().ClinicalAdmin.hideAllDivisionalDiagnosisMenuMenuItems();

		form.getContextMenus().ClinicalAdmin.getDivisionalDiagnosisMenuEDITItem().setVisible(nodeSelected);

	}

}
