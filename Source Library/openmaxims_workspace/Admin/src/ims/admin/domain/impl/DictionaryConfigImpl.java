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
// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.60 build 2888.18539)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.base.impl.BaseDictionaryConfigImpl;
import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.GlobalDictionaryVoCollection;
import ims.admin.vo.GlobalDictionaryWordVoCollection;
import ims.admin.vo.UserDictionaryVo;
import ims.admin.vo.UserDictionaryVoCollection;
import ims.admin.vo.domain.GlobalDictionaryVoAssembler;
import ims.admin.vo.domain.GlobalDictionaryWordVoAssembler;
import ims.admin.vo.domain.UserDictionaryVoAssembler;
import ims.assessment.vo.domain.GraphicAssessmentShortVoAssembler;
import ims.core.admin.domain.objects.UserDictionary;
import ims.core.configuration.domain.objects.AppUser;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.domain.MemberOfStaffShortVoAssembler;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;

public class DictionaryConfigImpl extends BaseDictionaryConfigImpl
{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void importGlobalDictionary(String[] words) throws StaleObjectException 
	{
		DomainFactory domainFactory = getDomainFactory();
		Connection connection = domainFactory.getJdbcConnection();
        PreparedStatement pstmt = null;
        
		try
		{
			connection.setAutoCommit(false);
			String sql = "INSERT INTO core_globaldictiona(vstp, word) VALUES(0, ?)";
	        pstmt = connection.prepareStatement(sql);
		}
		catch (SQLException e)
		{	
			throw new RuntimeException(e);
		}

        for (int i = 0; i < words.length; i++)
        {
            try
			{
				pstmt.setString(1, words[i]);
				pstmt.executeUpdate();
				if(i % 500 == 0)
				{
	        		connection.commit();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
        }

        try
		{
			connection.commit();
        	pstmt.close();
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				throw new RuntimeException(e);
			}
		}        
	}

	public GlobalDictionaryWordVoCollection searchByWord(String word)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from GlobalDictionary gd ");
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		String clause = " where ";
	
		if (word != null)
		{
			hql.append(clause);
			hql.append(" upper(ga.word) like :name");
			names.add("word");
			values.add(word.toUpperCase());
			clause = " and ";
		}
		
		List list = factory.find(hql.toString(), names, values);
		return GlobalDictionaryWordVoAssembler.createGlobalDictionaryWordVoCollectionFromGlobalDictionaryWord(list);
	}


	public AppUserShortVoCollection listAppUsers(AppUserShortVo appUserFilter) 
	{
		ApplicationUsersImpl impl = (ApplicationUsersImpl)getDomainImpl(ApplicationUsersImpl.class);
		return impl.listAppUsers(appUserFilter);
	}
	
	public UserDictionaryVoCollection listUserDictionary(AppUserShortVo user) 
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from UserDictionary userDictionary ";
		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		condStr.append(" where userDictionary.user.id =:id ");
		markers.add("id");
		values.add(user.getID_AppUser());
		
		
		List list = factory.find(hql, markers, values);
		return UserDictionaryVoAssembler.createUserDictionaryVoCollectionFromUserDictionary(list);
	}
	public GlobalDictionaryVoCollection listGlobalDictionary(AppUserShortVo user) 
	{
		DomainFactory factory = getDomainFactory();
		String hql = "select globalDictionaries from UserDictionary as userDictionary ";
		StringBuffer condStr = new StringBuffer();
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		condStr.append(" left join userDictionary.globalDictionaries as globalDictionaries  where userDictionary.user.id = :id ");
		markers.add("id");
		values.add(user.getID_AppUser());
				
		List list = factory.find(hql, markers, values);
		return GlobalDictionaryVoAssembler.createGlobalDictionaryVoCollectionFromGlobalDictionary(list);
	}	
}
