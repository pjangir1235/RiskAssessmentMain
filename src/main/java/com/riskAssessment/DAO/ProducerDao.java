package com.riskAssessment.DAO;

public interface ProducerDao {
	void getAiprotValues();

	void getAircraftValues();

	void getCrewValues();

	void getFlightScheduleCrewValues();

	void getFlightScheduleValues();

	void getFlightSchedulePilotValues();

	void getAircraftChecklistValues();

	void getAircraftTypeValues();

	void getPilotValues();

	void getPilotDesignationValues();

	void getRestDetailValues();
	
	void getUserValues(String userName,String Password);

}
