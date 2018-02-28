package com.riskAssessment.producerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.DAO.ProducerDao;

@Service
public class GetAllData implements ProducerDao {
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
	public void getFlightScheduleValues() {
		flightScheduleData.getFlightScheduleData();

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

}
