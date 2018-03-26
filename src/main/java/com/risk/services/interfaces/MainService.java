package com.risk.services.interfaces;

import java.text.ParseException;

import com.risk.consumer.model.FlightScheduleDTO;
import com.risk.models.ScheduleRequestDTO;

public interface MainService {
	void checkFetchData();

	void getAiprotValues();

	void getAircraftChecklistValues();

	void getAircraftTypeValues();

	void getAircraftValues();

	void getAnalysisData(FlightScheduleDTO data) throws ParseException;

	void getCrewValues();

	void getEnvironmentValues(String stationCode);

	void getFlightScheduleCrewValues();

	void getFlightSchedulePilotValues();

	void getFlightScheduleValues(ScheduleRequestDTO req);

	void getPilotDesignationValues();

	void getPilotValues();

	void getRestDetailValues();

	void getUserValues(String userName, String password);

}
