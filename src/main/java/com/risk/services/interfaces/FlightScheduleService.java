package com.risk.services.interfaces;

public interface FlightScheduleService {

	void getFlightScheduleData(String location, String date);

	void getFlightSchedulePilotData(int pilotId, String pilotDesignationCode, String dateOfDeparture);

}