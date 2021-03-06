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
package ims.rules.helper;

import java.util.List;
import java.util.ArrayList;

public final class ICPStageConfiguration extends ims.rules.types.RulesEngineEntity
{
	private static final long serialVersionUID = 1L;

	public ICPStageConfiguration(List<ims.rules.types.RulesEngineEntity> entities)
	{
		super.id = "1060100001";
		if(entities.contains(this))
			return;
		else
			entities.add(this);

		int fieldEntityIndex = -1;
		super.name = "ICP Stage Configuration";
		super.isPublic = true;
		super.supportsNotifications = false;
		super.description = "ICP Stage Configuration";
		super.businessObjectName = "ims.icps.configuration.domain.objects.ICPStage";
		super.fields = new ArrayList<ims.rules.types.RulesEngineField>();
		fieldEntityIndex = entities.indexOf(new ims.rules.helper.ICPPhaseConfiguration(entities));
		super.fields.add(new ims.rules.types.RulesEngineField("73511062005420132307698347279", "Phases for the Stage", "The Phases for the Stage", true, ims.rules.types.RulesEngineFieldType.ENTITY, (fieldEntityIndex >= 0 ? entities.get(fieldEntityIndex) : new ims.rules.helper.ICPPhaseConfiguration(entities)), 0, "Phases", this));
		super.fields.add(new ims.rules.types.RulesEngineField("316879920054201329127928540138", "Stage Name", "Stage Name", false, ims.rules.types.RulesEngineFieldType.STRING, null, 0, "Name", this));
		super.actions = new ArrayList<ims.rules.types.RulesEngineEntityMethod>();
	}
}
