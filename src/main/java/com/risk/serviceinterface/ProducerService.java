package com.risk.serviceinterface;

import com.risk.pojo.ScheduleRequestData;

public interface ProducerService {
	void getAiprotValues();

	void getAircraftValues();

	void getCrewValues();

	void getFlightScheduleValues(ScheduleRequestData req);

	void getFlightScheduleCrewValues();

	void getFlightSchedulePilotValues();

	void getAircraftChecklistValues();

	void getAircraftTypeValues();

	void getPilotValues();

	void getPilotDesignationValues();

	void getRestDetailValues();

	void getUserValues(String userName, String password);

	void checkFetchData();

}
