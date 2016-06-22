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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.70 build 3392.14041)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.helper.Keywords;
import ims.clinical.configuration.domain.objects.AMP;
import ims.clinical.configuration.domain.objects.VMP;
import ims.clinical.configuration.domain.objects.VTM;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.EnvironmentConfig;
import ims.core.clinical.coding.domain.objects.Icd10AmProc;
import ims.core.clinical.coding.domain.objects.Opcs4;
import ims.core.vo.GpVo;
import ims.core.vo.GpVoCollection;
import ims.core.vo.KeywordVo;
import ims.core.vo.KeywordVoCollection;
import ims.core.vo.OrgVo;
import ims.core.vo.OrgVoCollection;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.core.vo.domain.GpVoAssembler;
import ims.core.vo.domain.OrgVoAssembler;
import ims.core.vo.lookups.OrganisationType;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.dto.DTODomainImplementation;
import ims.dto.Result;
import ims.dto.client.Read_codes;
import ims.dto.client.Read_codes.Read_codesRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class TaxonomySearchCmpImpl extends DTODomainImplementation implements ims.admin.domain.TaxonomySearchCmp, ims.domain.impl.Transactional
{

	private static final long serialVersigonUID = 1L;

	public boolean dtoOnly() 
	{
		return false;
	}
	
	public Class getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}

	/**
	* Search Read/ICD10/PAS Codes
	*/
	public TaxonomyMapCollection searchCodes(TaxonomyMap filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		if(filter.getTaxonomyNameIsNotNull())// ==ReadCode???, ICD10 or Read3)
		{
			try
			{
				if(filter.getTaxonomyName().equals(TaxonomyType.READ3))
				{
					return searchReadCodes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.ICD10))
				{
					return searchICD10Codes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.SNOMED))
				{
					return searchSnomedCodes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.NAT_SPEC_CODE))
				{
					return searchNatSpecTreatCodes(filter, TaxonomyType.NAT_SPEC_CODE).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.NAT_TREAT_CODE))
				{
					return searchNatSpecTreatCodes(filter, TaxonomyType.NAT_TREAT_CODE).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.OPCS4))
				{
					return searchOPCS4Codes(filter).sort();
				}				
				else if(filter.getTaxonomyName().equals(TaxonomyType.VTM))
				{
					return searchVTMCodes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.VMP))
				{
					return searchVMPCodes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.AMP))
				{
					return searchAMPCodes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.NAT_LOC_CODE))
				{
					return searchPracticeCodes(filter).sort();
				}
				else if(filter.getTaxonomyName().equals(TaxonomyType.NAT_GP_CODE))
				{
					return searchGpCodes(filter).sort();
				}
				
			}
			catch (DomainRuntimeException e)
			{
				throw new ims.domain.exceptions.DomainInterfaceException("Please contact your system administrator.\n\nError:\n" + e.getMessage());
			}
		}
		
		return null; 
	}
		
	private TaxonomyMapCollection searchGpCodes(TaxonomyMap filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		try{

			ArrayList<String> names = new ArrayList<String>();
			ArrayList<Object> values = new ArrayList<Object>();
				
			StringBuffer taxonomyHql = new StringBuffer(" select distinct gp from Gp as gp left join gp.codeMappings as mappings" +
			" left join mappings.taxonomyName as tn where (tn.id = :taxonomyType and upper(mappings.taxonomyCode) like :taxonomyCode)");
			
			//StringBuffer taxonomyHql = new StringBuffer(" select distinct g1_1 from Gp as g1_1 left join g1_1.codeMappings as t1_1  where  (upper(t1_1.taxonomyCode) like :taxonomyCode and t1_1.taxonomyName = :taxonomyType)");

			
			names.add("taxonomyType");
			names.add("taxonomyCode");
				
			values.add(TaxonomyType.NAT_GP_CODE.getId());
			values.add("%"+filter.getDescription().toUpperCase()+"%");
				
			List<?> find = getDomainFactory().find(taxonomyHql.toString(), names, values);
			GpVoCollection  coll = GpVoAssembler.createGpVoCollectionFromGp(find);

			TaxonomyMapCollection coll_ret = new TaxonomyMapCollection();
			
			if (coll != null && coll.size()>0)
			{							
				for (int i = 0; i < coll.size(); i++)
				{
					GpVo vo= coll.get(i);									
					
					TaxonomyMap tmGPCode = new TaxonomyMap();
					tmGPCode.setTaxonomyName(TaxonomyType.NAT_GP_CODE);
					tmGPCode.setDescription(vo.getName().toString());
					tmGPCode.setTaxonomyCode(vo.getCodeMappings().getMappingValue(TaxonomyType.NAT_GP_CODE));
										
					coll_ret.add(tmGPCode);
				}				 
			}	
			return coll_ret;
		}
		catch (DomainRuntimeException e)
		{
			throw new ims.domain.exceptions.DomainInterfaceException("Please contact your system administrator.\n\nError:\n" + e.getMessage());
		}			
	}

	private TaxonomyMapCollection searchPracticeCodes(TaxonomyMap filter) throws ims.domain.exceptions.DomainInterfaceException
	{
		// TODO Auto-generated method stub
		try{

			ArrayList names = new ArrayList();
			ArrayList values = new ArrayList();
				
			StringBuffer taxonomyHql = new StringBuffer(" select distinct org from Organisation org join org.codeMappings as mappings" +
							" where mappings.taxonomyName = :taxonomyType and upper(mappings.taxonomyCode) like :taxonomyCode and org.type = :gpPractice");
				
			names.add("taxonomyType");
			names.add("taxonomyCode");
			names.add("gpPractice");
			
			values.add(getDomLookup(TaxonomyType.NAT_LOC_CODE));
			values.add("%"+filter.getDescription().toUpperCase()+"%");
			values.add(getDomLookup(OrganisationType.GPP));
			
			OrgVoCollection  coll = OrgVoAssembler.createOrgVoCollectionFromOrganisation(getDomainFactory().find(taxonomyHql.toString(), names, values));
			
			TaxonomyMapCollection coll_ret = new TaxonomyMapCollection();
			
			if (coll != null && coll.size()>0)
			{							
				for (int i = 0; i < coll.size(); i++)
				{
					OrgVo vo= coll.get(i);
					
					/*TaxonomyMap tmCAB = new TaxonomyMap();
					tmCAB.setTaxonomyName(TaxonomyType.ICAB);
					tmCAB.setDescription(vo.getName());
					tmCAB.setTaxonomyCode(vo.getCodeMappings().getMappingValue(TaxonomyType.ICAB));		*/
					
					TaxonomyMap tmNAT = new TaxonomyMap();
					tmNAT.setTaxonomyName(TaxonomyType.NAT_LOC_CODE);
					tmNAT.setDescription(vo.getName());
					tmNAT.setTaxonomyCode(vo.getCodeMappings().getMappingValue(TaxonomyType.NAT_LOC_CODE));
					
					//coll_ret.add(tmCAB);
					coll_ret.add(tmNAT);
				}				 
			}	
			return coll_ret;
		}
		catch (DomainRuntimeException e)
		{
			throw new ims.domain.exceptions.DomainInterfaceException("Please contact your system administrator.\n\nError:\n" + e.getMessage());
		}			
	}

	private TaxonomyMapCollection searchVTMCodes(TaxonomyMap filter) 
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();
		
		DomainFactory factory = getDomainFactory();
		String hqlList	= " from VTM vt where upper(vt.name) like '%" + filter.getDescription().toUpperCase() + "%'";
		
		TaxonomyMapCollection coll = new TaxonomyMapCollection();
		List codesList = factory.find(hqlList, maxRecords);			
		for (int i = 0; i < codesList.size(); i++)
		{
			VTM vtm = (VTM)codesList.get(i);
			TaxonomyMap taxMap = new TaxonomyMap();
			taxMap.setTaxonomyName(TaxonomyType.VTM);
			taxMap.setDescription(vtm.getName());
			taxMap.setTaxonomyCode(String.valueOf(vtm.getId()));			
			coll.add(taxMap);
		}		
		return coll; 
	}
	private TaxonomyMapCollection searchVMPCodes(TaxonomyMap filter) 
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();
		
		DomainFactory factory = getDomainFactory();
		String hqlList	= " from VMP vm where upper(vm.name) like '%" + filter.getDescription().toUpperCase() + "%'";
		
		TaxonomyMapCollection coll = new TaxonomyMapCollection();
		List codesList = factory.find(hqlList, maxRecords);			
		for (int i = 0; i < codesList.size(); i++)
		{
			VMP vmp = (VMP)codesList.get(i);
			TaxonomyMap taxMap = new TaxonomyMap();
			taxMap.setTaxonomyName(TaxonomyType.VMP);
			taxMap.setDescription(vmp.getName());
			taxMap.setTaxonomyCode(String.valueOf(vmp.getId()));			
			coll.add(taxMap);
		}		
		return coll; 
	}
	private TaxonomyMapCollection searchAMPCodes(TaxonomyMap filter) 
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();
		
		DomainFactory factory = getDomainFactory();
		String hqlList	= " from AMP am where upper(am.name) like '%" + filter.getDescription().toUpperCase() + "%'";
		
		TaxonomyMapCollection coll = new TaxonomyMapCollection();
		List codesList = factory.find(hqlList, maxRecords);			
		for (int i = 0; i < codesList.size(); i++)
		{			
			AMP amp = (AMP)codesList.get(i);
			TaxonomyMap taxMap = new TaxonomyMap();
			taxMap.setTaxonomyName(TaxonomyType.AMP);
			taxMap.setDescription(amp.getName());
			taxMap.setTaxonomyCode(String.valueOf(amp.getId()));			
			coll.add(taxMap);
		}		
		return coll; 
	}

	private TaxonomyMapCollection searchOPCS4Codes(TaxonomyMap filter) 
	{		
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();
		
		DomainFactory factory = getDomainFactory();
		String hqlList	= " from Opcs4 opcs4 where upper(opcs4.opname4) like '%" + filter.getDescription().toUpperCase() + "%' or upper(opcs4.opname3) like '%" + filter.getDescription().toUpperCase() + "%')";
		
		TaxonomyMapCollection coll = new TaxonomyMapCollection();
		List codesList = factory.find(hqlList, maxRecords);			
		for (int i = 0; i < codesList.size(); i++)
		{
			Opcs4 proc = (Opcs4)codesList.get(i);
			TaxonomyMap taxMap = new TaxonomyMap();
			taxMap.setTaxonomyName(TaxonomyType.OPCS4);
			taxMap.setDescription(proc.getOpname3() + " - " + proc.getOpname4());
			taxMap.setTaxonomyCode(proc.getOpcode());			
			coll.add(taxMap);
		}		
		return coll; 

	}

	/**
	* Search Read Codes
	*/
	private TaxonomyMapCollection searchReadCodes(TaxonomyMap filter)  throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.DomainRuntimeException
	{
		String searchType = ConfigFlag.DOM.READ_CODES_SEARCH_TYPE.getValue();
		if (searchType.equals("SQL"))
		{
			return searchReadCodesSql(filter);			
		}
		else if(searchType.equals("DTO"))
		{
			return searchReadCodesDto(filter);			
		}
		else
		{
			throw new ims.domain.exceptions.DomainInterfaceException("Value for READ_CODES_SEARCH_TYPE of " + searchType + " is invalid. Valid values are SQL or DTO");
		}		
	}
	
	//ReadCodes
	private TaxonomyMapCollection searchReadCodesSql(TaxonomyMap filter) throws DomainInterfaceException, ims.domain.exceptions.DomainRuntimeException 
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();

		TaxonomyMapCollection readCodeColl = new TaxonomyMapCollection();

		StringBuffer sql = new StringBuffer();
		if (EnvironmentConfig.getCaseSensitiveDatabase())
		{
			sql.append("select distinct rt.term_id termid, rd.read_code readcode, ")
					.append(" rt.term_30 term30, rt.term_60 term60 ") 
					.append(" from read_desc rd, read_term rt, read_concept rc" ) 
					.append(" where rt.term_id = rd.term_id ")
					.append(" and  rc.read_code = rd.read_code ") 
					.append(" and  rt.term_status = 'C' ")
					.append(" and  rc.concept_status = 'C' ") 
					.append(" and  rd.desc_type = 'P' ")
					.append(" and  rd.term_id in ( ")
					.append(" select term_id from read_key where term_key like ");
		}
		else
		{
			sql.append("select distinct read_view.term_id termid, read_view.read_code readcode, ")
					.append(" read_view.term_30 term30, read_view.term_60 term60 ")
					.append(" from read_view ")
					.append(" where  convert(binary(5),term_id) in ( ")
					.append(" select convert(binary(5),term_id) from read_key where term_key like ");
		}
		
		StringTokenizer st = new StringTokenizer(filter.getDescription().trim().toUpperCase(), " ,.;:");
		if (st.countTokens() == 0) throw new DomainInterfaceException("At least one key value must be supplied.");	

		String val = st.nextToken().trim();
		if (val == null || val.length() == 0) throw new DomainInterfaceException("At least one key value must be supplied.");
		val = Keywords.fixKeyword(val);
		sql.append("'" + val + "%' ");

		while (st.hasMoreTokens())
		{
			val = st.nextToken().trim();
			if (val == null || val.length() == 0) continue;
			if (EnvironmentConfig.getCaseSensitiveDatabase())
			{
		        sql.append(" and term_id in (select term_id from read_key where term_key like '" + Keywords.fixKeyword(val) + "%' )");
			}
			else
			{
		        sql.append(" and convert(binary(5), term_id) in (select convert(binary(5),term_id) from read_key where term_key like '" + Keywords.fixKeyword(val) + "%' )");
			}
		}
		sql.append(" ) ");
				
		DomainFactory factory = getDomainFactory();		
		Connection conn = factory.getJdbcConnection();
		ResultSet rs;		
		try 
		{
			rs = conn.createStatement().executeQuery(sql.toString());
			TaxonomyMap taxMap;
			int count = 0;
			while (rs.next() && count < maxRecords )
			{
				taxMap = new TaxonomyMap();
				taxMap.setTaxonomyName(TaxonomyType.READ3);
				taxMap.setTaxonomyCode(rs.getString("readcode"));		// WDEV-13164 - display the read code
				taxMap.setDescription(rs.getString("term30"));
				readCodeColl.add(taxMap);
				count++;
			}
			rs.close();
			return readCodeColl;
		}
		catch (SQLException e) 
		{
			throw new DomainRuntimeException(e.getMessage(),e);
		}
	}

	//DTO Read Codes
	private TaxonomyMapCollection searchReadCodesDto(TaxonomyMap filter)  throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.DomainRuntimeException
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();

		Read_codes readCodes = (Read_codes)getDTOInstance(Read_codes.class);		
		readCodes.Filter.clear();
		readCodes.Connection.setListSize(50);
		
		if (filter.getDescription() != null)
		{
			readCodes.Filter.Term_30 = '?' + filter.getDescription() + '?';
		}
		
		//Check first if doesn't exceed the maxRecords size - the result count is stored in the id of Result   
		Result result = readCodes.count();
		if (result != null && result.getId() > maxRecords)
		{
			throw new DomainInterfaceException("Search returned more than the configured max size of " + maxRecords + ". Please refine the search criteria.");
		}
				
		//List maxRecords records
		result = readCodes.list(maxRecords);
		if (result != null)
		{
			throw new DomainInterfaceException(result.getMessage());
		}
	
		TaxonomyMapCollection readCodeColl = new TaxonomyMapCollection();
		TaxonomyMap readCodeFilter;
		Read_codesRecord read_codesRecord;
		for (int i = 0; i < readCodes.DataCollection.count(); i++)
		{
			read_codesRecord = readCodes.DataCollection.get(i);
			readCodeFilter = new TaxonomyMap();
			readCodeFilter.setTaxonomyName(TaxonomyType.READ3);
			readCodeFilter.setDescription(read_codesRecord.Term_30);
			readCodeFilter.setTaxonomyCode(read_codesRecord.Read_code);		// WDEV-13164 - display the read code
			readCodeColl.add(readCodeFilter);
		}		
		return readCodeColl;
	}
	
	private TaxonomyMapCollection searchICD10Codes(TaxonomyMap filter) throws ims.domain.exceptions.DomainRuntimeException
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();

		DomainFactory factory = getDomainFactory();
		String hqlList	= " from Icd10AmProc p where (upper(p.ascii_desc) like '%" + filter.getDescription().toUpperCase() + "%') or upper(p.ascii_short_desc) like '%" + filter.getDescription().toUpperCase() + "%')";

		TaxonomyMapCollection coll = new TaxonomyMapCollection();
		List codesList = factory.find(hqlList, maxRecords);			
		for (int i = 0; i < codesList.size(); i++)
		{
			Icd10AmProc proc = (Icd10AmProc)codesList.get(i);
			TaxonomyMap taxMap = new TaxonomyMap();
			taxMap.setTaxonomyName(TaxonomyType.ICD10);
			taxMap.setDescription(proc.getAscii_short_desc() + " - " + proc.getAscii_desc());
			taxMap.setTaxonomyCode(proc.getCode_id());			
			coll.add(taxMap);
		}		
		return coll; 
	}

	private TaxonomyMapCollection searchSnomedCodes(TaxonomyMap filter) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.DomainRuntimeException
	{
		int maxRecords = ConfigFlag.DOM.TAXONOMY_SEARCH_MAX_SIZE.getValue();
		TaxonomyMapCollection snomedCodeColl = new TaxonomyMapCollection();
		HashMap concepts = new HashMap();

		StringBuffer sql = new StringBuffer();
		sql.append(" select c.fullyspeci term, c.conceptid conceptid")
			.append(" from core_snomed_concept c, core_snomed_cwrdidx w " ) 
			.append(" where w.conceptid = c.conceptid ")
			.append(" and c.conceptsta = 0 ")
			.append(" and w.keyword like ");
		
		StringTokenizer st = new StringTokenizer(filter.getDescription().trim().toUpperCase(), " ,.;:");
		if (st.countTokens() == 0) throw new DomainInterfaceException("At least one key value must be supplied.");	

		String val = st.nextToken().trim();
		if (val == null || val.length() == 0) throw new DomainInterfaceException("At least one key value must be supplied.");
		if (val.length() > 8)
			val = val.substring(0,8);
		val = "'" + Keywords.fixKeyword(val) + "%' ";

		DomainFactory factory = getDomainFactory();		
		Connection conn = factory.getJdbcConnection();
		ResultSet rs;
		try 
		{
			rs = conn.createStatement().executeQuery(sql.toString() + val);
			TaxonomyMap taxMap;
			while (rs.next())
			{
				taxMap = new TaxonomyMap();
				taxMap.setTaxonomyName(TaxonomyType.SNOMED);
				taxMap.setTaxonomyCode(rs.getString("conceptid"));
				taxMap.setDescription(rs.getString("term"));
				concepts.put(taxMap.getTaxonomyCode() ,taxMap);
			}			
			while (st.hasMoreTokens())
			{	
				HashMap currentConcepts = new HashMap();

				val = st.nextToken().trim();
				if (val == null || val.length() == 0) continue;
				if (val.length() > 8)
					val = val.substring(0,8);
				val = "'" + Keywords.fixKeyword(val) + "%' ";
				rs = conn.createStatement().executeQuery(sql.toString() + val);
				while (rs.next())
				{
					taxMap = new TaxonomyMap();
					taxMap.setTaxonomyName(TaxonomyType.SNOMED);
					taxMap.setTaxonomyCode(rs.getString("conceptid"));
					taxMap.setDescription(rs.getString("term"));
					currentConcepts.put(taxMap.getTaxonomyCode() ,taxMap);
				}
				Iterator iter = concepts.keySet().iterator();
				HashMap keepConcepts = new HashMap();
				while (iter.hasNext())
				{
					String key = (String)iter.next();
					if (currentConcepts.get(key) != null)
					{
						keepConcepts.put(key, currentConcepts.get(key));
					}
				}
				concepts.clear();
				concepts.putAll(keepConcepts);
			}
			if (rs != null)
				rs.close();
		}
		catch (SQLException e) 
		{
			throw new DomainRuntimeException(e.getMessage(),e);
		}
		
		int count = 0;
		Iterator iter = concepts.values().iterator();
		while (iter.hasNext() && count < maxRecords )
		{
			snomedCodeColl.add((TaxonomyMap)iter.next());
			count++;
		}
		
		return snomedCodeColl;
	}

	private KeywordVoCollection listKeywords(TaxonomyType type, String taxCode)
	{
		KeywordVoCollection ret = new KeywordVoCollection();
		
		if (type.equals(TaxonomyType.SNOMED))
		{
			DomainFactory factory = getDomainFactory();		
			Connection conn = factory.getJdbcConnection();
			ResultSet rs = null;

			StringBuffer sql = new StringBuffer();
			sql.append(" select w.keyword keyword")
				.append(" from core_snomed_concept_wordindex w " ) 
				.append(" where w.conceptid = '");
			sql.append(taxCode);
			sql.append("'");
			
			try
			{
				rs = conn.createStatement().executeQuery(sql.toString());				
				while (rs.next())
				{
					KeywordVo keyword = new KeywordVo();
					keyword.setKeyword(rs.getString("keyword"));
					ret.add(keyword);
				}			
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				return ret;
			}
			finally
			{
				if (rs != null)
				{
					try
					{
						rs.close();
					}
					catch (SQLException e)
					{						
						e.printStackTrace();
					}
				}
			}
		}
		return ret;
	}
	
	public KeywordVoCollection listSnomedKeywords(String snomedCode)
	{
		return listKeywords(TaxonomyType.SNOMED, snomedCode);
	}
	
	/**
	 * This function is called when the NAT_SPEC_CODE or NAT_TREAT_CODE search is called. 
	 * It searches in the NAT_SPEC_CODES table for any matching specialties or treatments. 
	 * 
	 * @param filter
	 * @param nat_spec_code
	 * @return
	 */
	private TaxonomyMapCollection searchNatSpecTreatCodes(TaxonomyMap filter, TaxonomyType nat_code) throws ims.domain.exceptions.DomainRuntimeException
	{
		TaxonomyMapCollection natSpecCodeColl = new TaxonomyMapCollection();
		String specOrTreat = new String();
		
		if (nat_code.equals(TaxonomyType.NAT_SPEC_CODE)) specOrTreat = "isSpecialty";
		else specOrTreat = "isTreatment";
		
		String sql = "select description, code from nat_spec_codes where " + specOrTreat + " = 1 and description like '%" + filter.getDescription().toUpperCase() + "%' "; 
		
		DomainFactory factory = getDomainFactory();		
		Connection conn = factory.getJdbcConnection();
		ResultSet rs;
		try 
		{
			TaxonomyMap taxMap;
			rs = conn.createStatement().executeQuery(sql.toString());
			taxMap = new TaxonomyMap();
			
			while (rs.next())
			{
				taxMap = new TaxonomyMap();
				taxMap.setTaxonomyName(nat_code);
				taxMap.setDescription(rs.getString(1));
				taxMap.setTaxonomyCode(rs.getString(2));			
				natSpecCodeColl.add(taxMap);
			}			

			if (rs != null)
				rs.close();
		}
		catch (SQLException e) 
		{
			throw new DomainRuntimeException(e.getMessage(),e);
		}
		
		return natSpecCodeColl;
	}
}
