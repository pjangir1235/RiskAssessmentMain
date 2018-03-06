package com.riskAssessment.ProducerPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_schedule_crew")
public class FlightScheduleCrew {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightScheduleId;
	private Integer crewMemberId;
	
	public FlightScheduleCrew() {
		super();
	}

	public FlightScheduleCrew(Integer crewMemberId, Integer flightScheduleId) {
		super();
		this.crewMemberId = crewMemberId;
		this.flightScheduleId = flightScheduleId;
	}

	public Integer getCrewMemberId() {
		return crewMemberId;
	}

	public void setCrewMemberId(Integer crewMemberId) {
		this.crewMemberId = crewMemberId;
	}

	public Integer getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(Integer flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

}
