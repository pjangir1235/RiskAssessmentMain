package com.risk.consumerpojo;

public class FlightScheduleCrewData {

	private int crewMemberId;
	private int flightScheduleId;

	public FlightScheduleCrewData() {
		super();
	}

	public FlightScheduleCrewData(int crewMemberId, int flightScheduleId) {
		super();
		this.crewMemberId = crewMemberId;
		this.flightScheduleId = flightScheduleId;
	}

	public int getCrewMemberId() {
		return crewMemberId;
	}

	public void setCrewMemberId(int crewMemberId) {
		this.crewMemberId = crewMemberId;
	}

	public int getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(int flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

}
