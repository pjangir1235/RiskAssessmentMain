package com.risk.producerpojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_schedule_pilot")
public class FlightSchedulePilot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightScheduleId;
	private Integer pilotId;

	public FlightSchedulePilot() {
		super();
	}

	public Integer getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(Integer flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public Integer getPilotId() {
		return pilotId;
	}

	public void setPilotId(Integer pilotId) {
		this.pilotId = pilotId;
	}

	public FlightSchedulePilot(Integer flightScheduleId, Integer pilotId) {
		super();
		this.flightScheduleId = flightScheduleId;
		this.pilotId = pilotId;
	}

}
