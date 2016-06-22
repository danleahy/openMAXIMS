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
//This code was generated by George Cristian Josan using IMS Development Environment (version 1.62 build 3040.26452)
//Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.pci.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.core.clinical.domain.objects.VaccineManufacturerBatch;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Gp;
import ims.core.resource.people.vo.GpRefVo;
import ims.core.vo.GpLiteWithNameVo;
import ims.core.vo.GpLiteWithNameVoCollection;
import ims.core.vo.GpShortVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.VaccineLiteVo;
import ims.core.vo.VaccineManufacturerBatchVo;
import ims.core.vo.VaccineManufacturerBatchVoCollection;
import ims.core.vo.domain.GpLiteWithNameVoAssembler;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.VaccineManufacturerBatchVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.MedicGrade;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.pci.domain.base.impl.BaseRecordingSchedulingImpl;
import ims.pci.domain.objects.ClientImmunisationSchedule;
import ims.pci.domain.objects.GpContract;
import ims.pci.domain.objects.ScheduleConfiguration;
import ims.pci.vo.ClientImmunisationScheduleVo;
import ims.pci.vo.ClientLiteVo;
import ims.pci.vo.ClientPCIScheduleProfileVo;
import ims.pci.vo.ClientPCIScheduleProfileVoCollection;
import ims.pci.vo.ClientScheduleStageVaccineVo;
import ims.pci.vo.ClientScheduleStageVaccineVoCollection;
import ims.pci.vo.ClientScheduleStageVo;
import ims.pci.vo.ClientScheduleStageVoCollection;
import ims.pci.vo.ClientVaccineSummaryVo;
import ims.pci.vo.ClientVaccineSummaryVoCollection;
import ims.pci.vo.GpContractVo;
import ims.pci.vo.GpContractVoCollection;
import ims.pci.vo.ScheduleConfigurationLiteVo;
import ims.pci.vo.ScheduleConfigurationLiteVoCollection;
import ims.pci.vo.ScheduleConfigurationRefVo;
import ims.pci.vo.ScheduleConfigurationRefVoCollection;
import ims.pci.vo.ScheduleConfigurationVo;
import ims.pci.vo.StageConfigurationVo;
import ims.pci.vo.StageConfigurationVoCollection;
import ims.pci.vo.StageVaccineVo;
import ims.pci.vo.StageVaccineVoCollection;
import ims.pci.vo.VaccineStatusLiteVo;
import ims.pci.vo.VaccineStatusLiteVoCollection;
import ims.pci.vo.domain.ClientImmunisationScheduleVoAssembler;
import ims.pci.vo.domain.ClientLiteVoAssembler;
import ims.pci.vo.domain.GpContractVoAssembler;
import ims.pci.vo.domain.ScheduleConfigurationLiteVoAssembler;
import ims.pci.vo.domain.ScheduleConfigurationVoAssembler;
import ims.pci.vo.lookups.VaccineStatus;

public class RecordingSchedulingImpl extends BaseRecordingSchedulingImpl
{

	private static final long serialVersionUID = 1L;



	/**
	 * Returns client immunisation schedule for provided client (null if there is none)
	 */
	public ClientImmunisationScheduleVo getClientImmunisationSchedule(PatientRefVo client) throws DomainInterfaceException
	{
		if (client == null)
			throw new DomainInterfaceException("There was no client selected. No immunisation schedule to display");

		DomainFactory factory = getDomainFactory();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String query = "select cis from ClientImmunisationSchedule as cis left join cis.client as pat where pat.id = :ID";
		markers.add("ID");
		values.add(client.getID_Patient());

		List results = factory.find(query, markers, values);

		if (results == null || results.size() == 0)
			return null;

		return ClientImmunisationScheduleVoAssembler.create((ClientImmunisationSchedule) (results.get(0)));
	}


	/**
	 * Saves ClientImmunisationSchedule (the ClientImmunisationSchedule must be non-null and validated)
	 */
	public ClientImmunisationScheduleVo saveClientImmunisationSchedule(ClientImmunisationScheduleVo clientImmunisationSchdule) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		if (clientImmunisationSchdule == null)
			throw new DomainInterfaceException("Can not save a null client immunisation schedule");

		if (!clientImmunisationSchdule.isValidated())
			throw new DomainInterfaceException("The ClientImmunisationScheduleVo was not validated (RecordingSchedulingImpl.java)");


		DomainFactory factory = getDomainFactory();


		ClientImmunisationSchedule extractClientImmunisationSchedule = ClientImmunisationScheduleVoAssembler.extractClientImmunisationSchedule(factory, clientImmunisationSchdule);
		factory.save(extractClientImmunisationSchedule);
		return ClientImmunisationScheduleVoAssembler.create(extractClientImmunisationSchedule);
	}


	/**
	 * Gets the default schedule for the date provided. If no date is provided, current date is considered.
	 */
	public ims.pci.vo.ScheduleConfigurationLiteVo getDefaultScheduleConfiguration(ims.framework.utils.Date atDate) throws ims.domain.exceptions.DomainInterfaceException
	{
		if (atDate == null)
		{
			atDate = new Date();
		}

		DomainFactory factory = getDomainFactory();
		String query = "from ScheduleConfiguration as sc where sc.isDefaultSchedule = 1";

		List results = factory.find(query);
		
		if (results == null || results.size() == 0)
			return null;

		ScheduleConfigurationLiteVoCollection schedules = ScheduleConfigurationLiteVoAssembler.createScheduleConfigurationLiteVoCollectionFromScheduleConfiguration(results);
		
		for (int i = schedules.size() - 1; i >= 0; i--)
		{
			ScheduleConfigurationLiteVo scheduleConfiguration = schedules.get(i);
			if (scheduleConfiguration == null || scheduleConfiguration.getStartDob() == null)
			{
				schedules.remove(i);
				continue;
			}
			
			if (scheduleConfiguration.getStartDob().isGreaterThan(atDate))
			{
				schedules.remove(i);
				continue;
			}
			
			if (scheduleConfiguration.getEndDobIsNotNull() && scheduleConfiguration.getEndDob().isLessThan(atDate))
			{
				schedules.remove(i);
				continue;
			}
		}
		
		if (schedules.size() == 0)
			return null;
		
		return schedules.get(0);
	}


	/**
	 * Saves the default schedule for current date to a provided client ClientImmunisationSchedule
	 */
	public ClientImmunisationScheduleVo saveDefaultScheduleToClient(PatientRefVo clientRef, MemberOfStaffLiteVo mos) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		if (clientRef == null)
			throw new DomainInterfaceException("A client must be selected before a schedule can be added");
		
		// Look for a client in the database
		DomainFactory factory = getDomainFactory();
		ClientLiteVo clientLiteVo = ClientLiteVoAssembler.create((Patient) factory.getDomainObject(Patient.class, clientRef.getID_Patient()));

		if (clientLiteVo == null)
			throw new DomainInterfaceException("Desired client does not exist");
		
		Date dateOfBirth = new Date();
		dateOfBirth.setDay(clientLiteVo.getDob().getDay() == null ? new Integer(1) : clientLiteVo.getDob().getDay());
		dateOfBirth.setMonth(clientLiteVo.getDob().getMonth() == null ? new Integer(1) : clientLiteVo.getDob().getMonth());
		dateOfBirth.setYear(clientLiteVo.getDob().getYear() == null ? new Integer(new Date().getYear()) : clientLiteVo.getDob().getYear());
		
		ScheduleConfigurationLiteVo defaultScheduleConfiguration = getDefaultScheduleConfiguration(dateOfBirth);

		if (defaultScheduleConfiguration == null)
			throw new DomainInterfaceException("There is no default schedule for the current date. Please define a default schedule for this date or select a schedule");

		ClientImmunisationScheduleVo clientSchedule = addScheduleToClient(clientRef, defaultScheduleConfiguration, mos);

		String[] errors = clientSchedule.validate();

		if (errors != null && errors.length != 0)
		{
			throw new DomainInterfaceException("Can not add a default schedule to client. Errors present");
		}

		return saveClientImmunisationSchedule(clientSchedule);
	}

	private ClientImmunisationScheduleVo addScheduleToClient(PatientRefVo clientRef, ScheduleConfigurationRefVo scheduleRef, MemberOfStaffLiteVo mos) throws DomainInterfaceException
	{
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//	PRELIMINARY CHECKS
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Check for a client
		if (clientRef == null)
			throw new DomainInterfaceException("Can not add schedule. Client was not found in records");

		// Look for a client in the database
		DomainFactory factory = getDomainFactory();
		ClientLiteVo clientLiteVo = ClientLiteVoAssembler.create((Patient) factory.getDomainObject(Patient.class, clientRef.getID_Patient()));

		if (clientLiteVo == null)
			throw new DomainInterfaceException("Desired client does not exist");

		Date dateOfBirth = new Date();
		dateOfBirth.setDay(clientLiteVo.getDob().getDay() == null ? new Integer(1) : clientLiteVo.getDob().getDay());
		dateOfBirth.setMonth(clientLiteVo.getDob().getMonth() == null ? new Integer(1) : clientLiteVo.getDob().getMonth());
		dateOfBirth.setYear(clientLiteVo.getDob().getYear() == null ? new Integer(new Date().getYear()) : clientLiteVo.getDob().getYear());

		// Check for a member of staff
		if (mos == null)
			throw new DomainInterfaceException("An immunisation schedule for a client can be added only by a member of staff");

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//	RETRIVE - ClientImmunisationScheduleVo, ScheduleConfigurationVo
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// Get the client schedule
		ClientImmunisationScheduleVo clientSchedule = getClientImmunisationSchedule(clientRef);

		// Get the schedule configuration to add (return the client schedule as it is - null if there is none - if the schedule configuration is null) 
		ScheduleConfigurationVo schedule;
		if (scheduleRef == null)
			return clientSchedule;
		else
		{
			// Get the schedule configuration
			schedule = ScheduleConfigurationVoAssembler.create((ScheduleConfiguration) factory.getDomainObject(ScheduleConfiguration.class, scheduleRef.getID_ScheduleConfiguration()));

			if (schedule == null)
				return clientSchedule;
		}
		

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//	START BUILDING ClientImmunisationSchedule (create a new one if needed)
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// At this point if there was no schedule configuration create a new one
		if (clientSchedule == null)
		{
			clientSchedule = new ClientImmunisationScheduleVo();
		}

		// Set the client (if not already set)
		if (clientSchedule.getClient() == null)
		{
			clientSchedule.setClient(clientLiteVo);
		}
		
		try
		{
			clientSchedule.addSchedule(schedule, mos, new DateTime());
		}
		catch (IllegalArgumentException e)
		{
//			throw new DomainInterfaceException("Can not add default schedule configuration to client immunisation schedule as it conflicts withs existing schedule.");
			throw new DomainInterfaceException(e.getMessage());
		}

		return clientSchedule;
	}



	public VaccineManufacturerBatchVoCollection listBatchVaccine(String batchNumber, VaccineLiteVo vaccine) throws DomainInterfaceException
	{
		if (batchNumber == null)
			throw new DomainInterfaceException("Can not search for batch vaccines after an empty batch number");

		if (vaccine == null)
			throw new DomainInterfaceException("Can not search for batch vaccines with no selected vaccine");

		DomainFactory factory = getDomainFactory();

		String query = "from VaccineManufacturerBatch as vmb where vmb.vaccine.id = :ID and UPPER(vmb.batchNumber) like :BATCHNUMBER and vmb.status.id = -617";
		ArrayList<String> markers = new ArrayList<String>();
		markers.add("ID"); markers.add("BATCHNUMBER");
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(vaccine.getID_Vaccine()); values.add("%" + batchNumber.toUpperCase() +"%");

		return VaccineManufacturerBatchVoAssembler.createVaccineManufacturerBatchVoCollectionFromVaccineManufacturerBatch(factory.find(query, markers, values));
	}


	public GpLiteWithNameVoCollection listGp(String name) throws DomainInterfaceException
	{
		if (name == null || name.trim() == null || name.trim().length() == 0)
			throw new DomainInterfaceException("Can not search for GP with no name provided");

		DomainFactory factory = getDomainFactory();

		String query = "from Gp as gp ";

		StringBuffer hql = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		hql.append(" where ");

		// Break the name
		String[] splitNames = name.toUpperCase().trim().split(" ");
		
		for (int i = 0; i < splitNames.length; i++)
		{
			if (splitNames[i] != null || splitNames[i].length() > 0)
			{
				hql.append("gp.name.upperSurname like :NAME" + i + " or gp.name.upperForename like :NAME" + i);
				markers.add("NAME" + i);
				values.add("%" + splitNames[i].toUpperCase() + "%");
			}

			if (i < splitNames.length - 1)
			{
				hql.append(" or ");
			}
		}

		if (markers.size() > 0)
			query += hql;

		return GpLiteWithNameVoAssembler.createGpLiteWithNameVoCollectionFromGp(factory.find(query, markers, values));
	}

	public HcpLiteVoCollection listMembersOfStaff(String name) throws DomainInterfaceException
	{
		DomainFactory factory = getDomainFactory();

		if (name == null)
		{
			String query = "from Medic as md where md.medicType.id = :ID)";
			ArrayList<String> markers = new ArrayList<String>();
			ArrayList<Object> values = new ArrayList<Object>();
			markers.add("ID");
			values.add(HcpDisType.AMO.getId());

			return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(factory.find(query, markers, values));
		}

		// Break the name
		String[] splitNames = name.toUpperCase().trim().split(" ");

		String query = "from Medic as md where md.medicType.id = :ID ";

		StringBuffer hql = new StringBuffer();
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		for (int i = 0; i < splitNames.length; i++)
		{
			if (splitNames[i] != null || splitNames[i].length() > 0)
			{
				hql.append(" md.mos.name.upperSurname like :NAME" + i + " or md.mos.name.upperForename like :NAME" + i);
				markers.add("NAME" + i);
				values.add("%" + splitNames[i].toUpperCase() + "%");
			}

			if (i < splitNames.length - 1)
			{
				hql.append(" or ");
			}
		}

		if (markers.size() > 0)
		{
			query += " and (";
			query += hql;
			query += ")";
		}

		markers.add("ID");
		values.add(HcpDisType.AMO.getId());

		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(factory.find(query, markers, values));
	}


	public GpContractVo getGpContract(GpRefVo gpRef, Date date)
	{
		if (gpRef == null)
			return null;

		String query = "select gcon from GpContract as gcon left join gcon.gP as gp where gp.id = :ID";
		ArrayList<String> markers = new ArrayList<String>();
		markers.add("ID");
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(gpRef.getID_Gp());

		DomainFactory factory = getDomainFactory();
		GpContractVoCollection results = GpContractVoAssembler.createGpContractVoCollectionFromGpContract(factory.find(query, markers, values));

		if (results == null || results.size() == 0)
			return null;

		for (int i = results.size() - 1; i >= 0 ; i--)
		{
			GpContractVo contract = results.get(i);
			if (contract.getContractStartDate() != null && contract.getContractStartDate().isGreaterThan(date))
			{
				results.remove(contract);
				continue;
			}

			if (contract.getContractEndDate() != null && contract.getContractEndDate().isLessThan(date))
			{
				results.remove(contract);
				continue;
			}
		}

		if (results == null || results.size() == 0)
		{
			return null;
		}

		return results.get(0);
	}


	public GpShortVo getRegisteredGp(PatientRefVo client) throws DomainInterfaceException 
	{
		if (client == null)
			throw new DomainInterfaceException("A client must be selected to search for a registred GP");

		DomainFactory factory = getDomainFactory();

		String query = "select gp from Patient as pt left join pt.communityCare as cc left join cc.registeredGp as gp where (pt.id = :ID)";
		ArrayList<String> markers = new ArrayList<String>();
		markers.add("ID");
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(client.getID_Patient());
		
		return GpShortVoAssembler.create((Gp) factory.find(query, markers, values).get(0));
	}


	public VaccineManufacturerBatchVo getBatchVaccine(String batchName) throws DomainInterfaceException
	{
		if (batchName == null)
			return null;
		
		DomainFactory factory = getDomainFactory();

		String query = "from VaccineManufacturerBatch as vmb where UPPER(vmb.batchNumber) = :BATCHNUMBER";
		ArrayList<String> markers = new ArrayList<String>();
		markers.add("BATCHNUMBER");
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(batchName.toUpperCase());
		
		List results = factory.find(query, markers, values);
		
		if (results == null || results.size() == 0)
			return null;
		
		return VaccineManufacturerBatchVoAssembler.create((VaccineManufacturerBatch)(results.get(0)));
	}
}
