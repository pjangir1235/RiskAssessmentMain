package com.risk.producerpojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight_schedule")
public class FlightSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightScheduleId;
	private String aircraftCode;
	private String sourceAirportCode;
	private String destinationAirportCode;
	private String dateOfDeparture;
	private String timeDeparture;
	private String timeArrival;
	private Integer duration;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "flight_schedule_pilot", joinColumns = {
			@JoinColumn(name = "flightScheduleId") }, inverseJoinColumns = { @JoinColumn(name = "pilotId") })
	List<Pilot> pilots;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "flight_schedule_crew", joinColumns = {
			@JoinColumn(name = "flightScheduleId") }, inverseJoinColumns = { @JoinColumn(name = "crewMemberId") })
	List<Crew> crews;
	
	public List<Crew> getCrews() {
		return crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public FlightSchedule() {
		super();
	}

	public FlightSchedule(Integer flightScheduleId, String aircraftCode, String sourceAirportCode,
			String destinationAirportCode, String dateOfDeparture, String timeDeparture, String timeArrival,
			Integer duration) {
		super();
		this.flightScheduleId = flightScheduleId;
		this.aircraftCode = aircraftCode;
		this.sourceAirportCode = sourceAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.dateOfDeparture = dateOfDeparture;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.duration = duration;
	}

	public Integer getFlightScheduleId() {
		return flightScheduleId;
	}

	public void setFlightScheduleId(Integer flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

	public String getSourceAirportCode() {
		return sourceAirportCode;
	}

	public void setSourceAirportCode(String sourceAirportCode) {
		this.sourceAirportCode = sourceAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(String dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public String getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public String getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(String timeArrival) {
		this.timeArrival = timeArrival;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	@Override
	public String toString() {
		return this.sourceAirportCode + "  " + this.flightScheduleId + " " + this.getPilots()+" "+this.getCrews();
	}

}
