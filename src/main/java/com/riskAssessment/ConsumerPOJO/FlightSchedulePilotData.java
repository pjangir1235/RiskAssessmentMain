package com.riskAssessment.ConsumerPOJO;

public class FlightSchedulePilotData {

	private int flightScheduleId;
	private int pilotId;

	public FlightSchedulePilotData() {
		super();
	}

	public int getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public FlightSchedulePilotData(int flightScheduleId, int pilotId) {
		super();
		this.flightScheduleId = flightScheduleId;
		this.pilotId = pilotId;
	}

}
