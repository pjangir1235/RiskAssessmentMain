package com.risk.services.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.constants.CommonConstant;
import com.risk.consumer.model.CrewDTO;
import com.risk.consumer.model.FlightScheduleDTO;
import com.risk.consumer.model.PilotDTO;
import com.risk.controllers.Controller;
import com.risk.models.ScheduleRequestDTO;
import com.risk.models.StoreRecord;
import com.risk.services.interfaces.AircraftChecklistService;
import com.risk.services.interfaces.AircraftService;
import com.risk.services.interfaces.AircraftTypeService;
import com.risk.services.interfaces.AirportService;
import com.risk.services.interfaces.CrewService;
import com.risk.services.interfaces.EnvironmentService;
import com.risk.services.interfaces.FlightScheduleCrewService;
import com.risk.services.interfaces.FlightSchedulePilotService;
import com.risk.services.interfaces.FlightScheduleService;
import com.risk.services.interfaces.MainService;
import com.risk.services.interfaces.PilotDesignationService;
import com.risk.services.interfaces.PilotService;
import com.risk.services.interfaces.RestDetailService;
import com.risk.services.interfaces.UserService;
import com.risk.util.LocalDateString;

@Service
public class MainServiceImpl implements MainService {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private AirportService airportData;

	@Autowired
	private AircraftService aircraftData;

	@Autowired
	private AircraftTypeService aircraftTypeData;

	@Autowired
	private AircraftChecklistService aircraftChecklistData;

	@Autowired
	private CrewService crewData;

	@Autowired
	private FlightScheduleService flightScheduleData;

	@Autowired
	private FlightScheduleCrewService flightScheduleCrewData;
	@Autowired
	private FlightSchedulePilotService flightSchedulePilotData;
	@Autowired
	private PilotService pilotData;

	@Autowired
	private PilotDesignationService pilotDesignationData;

	@Autowired
	private RestDetailService restDetailData;

	@Autowired
	private UserService userData;

	@Autowired
	private EnvironmentService environmentData;

	@Autowired
	StoreRecord record;

	@Autowired
	LocalDateString dateConverter;

	@Override
	public void checkFetchData() {
		try {

			while (record.getFlightScheduleCount() != 0 || record.getFlightSchedulePilotCount() != 0
			                || record.getFlightScheduleCrewCount() != 0 || record.getPilotCount() != 0
			                || record.getAircraftChecklistCount() != 0 || record.getAircraftCount() != 0
			                || record.getUserCount() != 0 || record.getPilotDesignationCount() != 0
			                || record.getRestDetailCount() != 0 || record.getCrewCount() != 0
			                || record.getAirportCount() != 0 || record.getAircraftTypeCount() != 0
			                || record.getEnvironmentCount() != 0)
				Thread.sleep(1000);
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}

	}

	@Override
	public void getAiprotValues() {
		airportData.getAirportData();
	}

	@Override
	public void getAircraftChecklistValues() {
		aircraftChecklistData.getAircraftChecklistData();

	}

	@Override
	public void getAircraftTypeValues() {
		aircraftTypeData.getAircraftTypeData();
	}

	@Override
	public void getAircraftValues() {
		aircraftData.getAircraftData();

	}



	@Override
	public void getCrewValues() {
		crewData.getCrewData();

	}

	@Override
	public void getEnvironmentValues(String stationCode) {
		environmentData.getEnvironmentData(stationCode);

	}

	@Override
	public void getFlightScheduleCrewValues() {
		flightScheduleCrewData.getFlightScheduleCrewData();

	}

	@Override
	public void getFlightSchedulePilotValues() {
		flightSchedulePilotData.getFlightSchedulePilotData();

	}

	@Override
	public void getFlightScheduleValues(ScheduleRequestDTO req) {
		flightScheduleData.getFlightScheduleData(req.getLocation(), req.getDate());

	}

	@Override
	public void getPilotDesignationValues() {
		pilotDesignationData.getPilotDesignationData();
	}

	@Override
	public void getPilotValues() {
		pilotData.getPilotData();
	}

	@Override
	public void getRestDetailValues() {
		restDetailData.getRestDetailData();
	}

	@Override
	public void getUserValues(String userName, String password) {
		userData.getUserData(userName, password);

	}

	@Override
	public void getAnalysisData(FlightScheduleDTO data) throws ParseException {
		LocalDate date;
		try {
			PilotDTO pilot = null;
			List<PilotDTO> pilotdetails = data.getPilots();
			Iterable<PilotDTO> itr = pilotdetails;
			Iterator<PilotDTO> iter = itr.iterator();

			// Get Pilot Working Detail

			while (iter.hasNext()) {
				pilot = iter.next();
				flightScheduleData.getFlightSchedulePilotData(pilot.getPilotId(), pilot.getPilotDesignationCode(),
				                data.getDateOfDeparture());
			}
		}

		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}
		// Get Environment Source
		try {

			environmentData.getEnvironmentData(data.getSourceAirportCode());
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}
		// Get Environment Destination
		try {

			environmentData.getEnvironmentData(data.getDestinationAirportCode());
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}

		try {

			aircraftChecklistData.getAircraftChecklistOnAircraftCodeData(data.getAircraftCode(),
			                data.getDateOfDeparture());
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}
		// get all aircraft Code

		try {

			aircraftData.getAllAircraftCodeforType(data.getAircraftCode());
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}

		try {
			CrewDTO crew = null;
			List<CrewDTO> crews = null;
			crews = data.getCrews();
			Iterable<CrewDTO> itr = crews;
			Iterator<CrewDTO> iter = itr.iterator();
			while (iter.hasNext()) {
				date = dateConverter.stringToLocalDate(data.getDateOfDeparture());
				date = date.minusDays(1);
				crew = iter.next();
				restDetailData.getCrewRestDetail(crew.getCrewMemberId(), dateConverter.localDateToString(date));
			}

		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
		}

	}

}
