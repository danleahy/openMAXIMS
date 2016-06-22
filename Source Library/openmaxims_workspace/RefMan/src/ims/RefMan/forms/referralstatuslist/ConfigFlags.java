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
package ims.RefMan.forms.referralstatuslist;

import java.io.Serializable;

public final class ConfigFlags extends ims.framework.FormConfigFlags implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final STALE_OBJECT_MESSAGEClass STALE_OBJECT_MESSAGE;
	public final MERGED_COLOURClass MERGED_COLOUR;
	public final RIP_COLOURClass RIP_COLOUR;
	public final FURTHER_MANAGEMENT_REQUIRED_ROW_COLOURClass FURTHER_MANAGEMENT_REQUIRED_ROW_COLOUR;
	public final DISCHARGED_ROW_COLOURClass DISCHARGED_ROW_COLOUR;
	public final PUKKAJ_ENABLEDClass PUKKAJ_ENABLED;
	public final CREATE_ICP_ON_ACCEPTANCE_OF_REFERRALClass CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL;

	public ConfigFlags(ims.framework.ConfigFlag configFlags)
	{
		super(configFlags);

		STALE_OBJECT_MESSAGE = new STALE_OBJECT_MESSAGEClass(configFlags);
		MERGED_COLOUR = new MERGED_COLOURClass(configFlags);
		RIP_COLOUR = new RIP_COLOURClass(configFlags);
		FURTHER_MANAGEMENT_REQUIRED_ROW_COLOUR = new FURTHER_MANAGEMENT_REQUIRED_ROW_COLOURClass(configFlags);
		DISCHARGED_ROW_COLOUR = new DISCHARGED_ROW_COLOURClass(configFlags);
		PUKKAJ_ENABLED = new PUKKAJ_ENABLEDClass(configFlags);
		CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL = new CREATE_ICP_ON_ACCEPTANCE_OF_REFERRALClass(configFlags);
	}

	public final class STALE_OBJECT_MESSAGEClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public STALE_OBJECT_MESSAGEClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public String getValue()
		{
			return (String)configFlags.get("STALE_OBJECT_MESSAGE");
		}
	}
	public final class MERGED_COLOURClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public MERGED_COLOURClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public ims.framework.utils.Color getValue()
		{
			return (ims.framework.utils.Color)configFlags.get("MERGED_COLOUR");
		}
	}
	public final class RIP_COLOURClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public RIP_COLOURClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public ims.framework.utils.Color getValue()
		{
			return (ims.framework.utils.Color)configFlags.get("RIP_COLOUR");
		}
	}
	public final class FURTHER_MANAGEMENT_REQUIRED_ROW_COLOURClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public FURTHER_MANAGEMENT_REQUIRED_ROW_COLOURClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public ims.framework.utils.Color getValue()
		{
			return (ims.framework.utils.Color)configFlags.get("FURTHER_MANAGEMENT_REQUIRED_ROW_COLOUR");
		}
	}
	public final class DISCHARGED_ROW_COLOURClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public DISCHARGED_ROW_COLOURClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public ims.framework.utils.Color getValue()
		{
			return (ims.framework.utils.Color)configFlags.get("DISCHARGED_ROW_COLOUR");
		}
	}
	public final class PUKKAJ_ENABLEDClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public PUKKAJ_ENABLEDClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public Boolean getValue()
		{
			return (Boolean)configFlags.get("PUKKAJ_ENABLED");
		}
	}
	public final class CREATE_ICP_ON_ACCEPTANCE_OF_REFERRALClass implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private final ims.framework.ConfigFlag configFlags;

		public CREATE_ICP_ON_ACCEPTANCE_OF_REFERRALClass(ims.framework.ConfigFlag configFlags)
		{
			this.configFlags = configFlags;
		}

		public Boolean getValue()
		{
			return (Boolean)configFlags.get("CREATE_ICP_ON_ACCEPTANCE_OF_REFERRAL");
		}
	}
}
