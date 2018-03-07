package com.riskAssessment.ServiceInterface;

import com.riskAssessment.POJO.ScheduleRequestData;

public interface ProducerService {
	void getAiprotValues();

	void getAircraftValues();

	void getCrewValues();

	void getFlightScheduleCrewValues();

	void getFlightScheduleValues(ScheduleRequestData req);

	void getFlightSchedulePilotValues();

	void getAircraftChecklistValues();

	void getAircraftTypeValues();

	void getPilotValues();

	void getPilotDesignationValues();

	void getRestDetailValues();

	void getUserValues(String userName, String Password);

	void checkFetchData();

}
