package com.risk.producerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.controller.RequestController;
import com.risk.datastorageconsumer.StoreRecord;
import com.risk.pojo.ScheduleRequestData;
import com.risk.serviceinterface.ProducerService;

@Service
public class GetAllData implements ProducerService {


	 private static final Logger logger =
		 LoggerFactory.getLogger(RequestController.class);

	@Autowired
	private GetAirportData airportData;

	@Autowired
	private GetAircraftData aircraftData;

	@Autowired
	private GetAircraftTypeData aircraftTypeData;

	@Autowired
	private GetAircraftChecklistData aircraftChecklistData;

	@Autowired
	private GetCrewData crewData;

	@Autowired
	private GetFlightScheduleCrewData flightScheduleCrewData;

	@Autowired
	private GetFlightScheduleData flightScheduleData;

	@Autowired
	private GetFlightSchedulePilotData flightSchedulePilotData;

	@Autowired
	private GetPilotData pilotData;

	@Autowired
	private GetPilotDesignationData pilotDesignationData;

	@Autowired
	private GetRestDetailData restDetailData;

	@Autowired
	private GetUserData userData;

	@Autowired
	StoreRecord record;

	@Override
	public void getAiprotValues() {
		airportData.getAirportData();
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
	public void getFlightScheduleCrewValues() {
		flightScheduleCrewData.getFlightScheduleCrewData();

	}

	@Override
	public void getFlightScheduleValues(ScheduleRequestData req) {
		flightScheduleData.getFlightScheduleData(req.getLocation(),req.getDate());

	}

	@Override
	public void getFlightSchedulePilotValues() {
		flightSchedulePilotData.getFlightSchedulePilotData();

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
	public void getPilotValues() {
		pilotData.getPilotData();
	}

	@Override
	public void getPilotDesignationValues() {
		pilotDesignationData.getPilotDesignationData();
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
	public void checkFetchData() {
		try {


		while (record.getFlightScheduleCount() != 0||record.getFlightSchedulePilotCount() != 0||record.getFlightScheduleCrewCount() != 0||
				record.getPilotCount() != 0||record.getAircraftChecklistCount() != 0||record.getAircraftCount() != 0||
				record.getUserCount() != 0||record.getPilotDesignationCount() != 0||record.getRestDetailCount() != 0||
				record.getCrewCount() != 0||record.getAirportCount() != 0||record.getAircraftTypeCount() != 0)
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Error->"+e);
		}

	}

}
