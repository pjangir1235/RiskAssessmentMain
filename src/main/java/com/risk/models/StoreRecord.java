package com.risk.models;

import java.util.ArrayList;
import java.util.List;

import com.risk.consumer.model.AircraftChecklistDTO;
import com.risk.consumer.model.AircraftDTO;
import com.risk.consumer.model.AircraftTypeDTO;
import com.risk.consumer.model.AirportDTO;
import com.risk.consumer.model.CrewDTO;
import com.risk.consumer.model.FlightScheduleCrewDTO;
import com.risk.consumer.model.FlightScheduleDTO;
import com.risk.consumer.model.FlightSchedulePilotDTO;
import com.risk.consumer.model.PilotDTO;
import com.risk.consumer.model.PilotDesignationDTO;
import com.risk.consumer.model.RestDetailDTO;
import com.risk.consumer.model.UserDTO;

public class StoreRecord {

	private List<AirportDTO> airport;
	private List<AircraftDTO> aircraft ;
	private List<AircraftChecklistDTO> aircraftChecklist;
	private List<AircraftTypeDTO> aircraftType;
	private List<CrewDTO> crew;
	private List<FlightScheduleDTO> flightSchedule;
	private List<FlightScheduleCrewDTO> flightScheduleCrew;
	private List<FlightSchedulePilotDTO> flightSchedulePilot;
	private List<PilotDesignationDTO> pilotDesignation;
	private List<RestDetailDTO> restDetail;
	private List<PilotDTO> pilot;
	private List<UserDTO> user;
	private List<Environment> env;

	private int environmentCount = 0;
	private int airportCount = 0;
	private int aircraftCount = 0;
	private int aircraftChecklistCount = 0;
	private int aircraftCodeCount = 0;
	private int userCount = 0;
	private int aircraftTypeCount = 0;
	private int crewCount = 0;
	private int flightScheduleCount = 0;
	private int flightScheduleCrewCount = 0;
	private int flightSchedulePilotCount = 0;
	private int pilotCount = 0;
	private int pilotDesignationCount = 0;
	private int restDetailCount = 0;

	public StoreRecord() {
		super();
		init();
		user = new ArrayList<>();
	}

	private void init() {
		airport = new ArrayList<>();
		aircraft = new ArrayList<>();
		aircraftChecklist = new ArrayList<>();
		aircraftType = new ArrayList<>();
		crew = new ArrayList<>();
		flightSchedule = new ArrayList<>();
		flightScheduleCrew = new ArrayList<>();
		flightSchedulePilot = new ArrayList<>();
		pilotDesignation = new ArrayList<>();
		restDetail = new ArrayList<>();
		pilot = new ArrayList<>();
		env = new ArrayList<>();
	}

	public void destroy() {
		init();
	}

	public void destroyUser() {
		user = new ArrayList<>();
	}

	public List<AircraftDTO> getAircraft() {
		return aircraft;
	}

	public List<AircraftChecklistDTO> getAircraftChecklist() {
		return aircraftChecklist;
	}

	public int getAircraftChecklistCount() {
		return aircraftChecklistCount;
	}

	public int getAircraftCodeCount() {
		return aircraftCodeCount;
	}

	public int getAircraftCount() {
		return aircraftCount;
	}

	public List<AircraftTypeDTO> getAircraftType() {
		return aircraftType;
	}

	public int getAircraftTypeCount() {
		return aircraftTypeCount;
	}

	public List<AirportDTO> getAirport() {
		return airport;
	}

	public int getAirportCount() {
		return airportCount;

	}

	public List<CrewDTO> getCrew() {
		return crew;
	}

	public int getCrewCount() {
		return crewCount;
	}

	public List<Environment> getEnv() {
		return env;
	}

	public int getEnvironmentCount() {
		return environmentCount;
	}

	public List<FlightScheduleDTO> getFlightSchedule() {
		return flightSchedule;
	}

	public int getFlightScheduleCount() {
		return flightScheduleCount;
	}

	public List<FlightScheduleCrewDTO> getFlightScheduleCrew() {
		return flightScheduleCrew;
	}

	public int getFlightScheduleCrewCount() {
		return flightScheduleCrewCount;
	}

	public List<FlightSchedulePilotDTO> getFlightSchedulePilot() {
		return flightSchedulePilot;
	}

	public int getFlightSchedulePilotCount() {
		return flightSchedulePilotCount;
	}

	public List<PilotDTO> getPilot() {
		return pilot;
	}

	public int getPilotCount() {
		return pilotCount;
	}

	public List<PilotDesignationDTO> getPilotDesignation() {
		return pilotDesignation;
	}

	public int getPilotDesignationCount() {
		return pilotDesignationCount;
	}

	public List<RestDetailDTO> getRestDetail() {
		return restDetail;
	}

	public int getRestDetailCount() {
		return restDetailCount;
	}

	public List<UserDTO> getUser() {
		return user;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setAircraft(AircraftDTO aircraft) {
		this.aircraft.add(aircraft);
	}

	public void setAircraftChecklist(AircraftChecklistDTO aircraftChecklist) {
		this.aircraftChecklist.add(aircraftChecklist);
	}

	public void setAircraftChecklistCount(int aircraftChecklistCount) {
		this.aircraftChecklistCount = aircraftChecklistCount;
	}

	public void setAircraftCodeCount(int aircraftCodeCount) {
		this.aircraftCodeCount = aircraftCodeCount;
	}

	public void setAircraftCount(int aircraftCount) {
		this.aircraftCount = aircraftCount;
	}

	public void setAircraftType(AircraftTypeDTO aircraftType) {
		this.aircraftType.add(aircraftType);
	}

	public void setAircraftTypeCount(int aircraftTypeCount) {
		this.aircraftTypeCount = aircraftTypeCount;
	}

	public void setAirport(AirportDTO airport) {
		this.airport.add(airport);
	}

	public void setAirportCount(int airportCount) {

		this.airportCount = airportCount;

	}

	public void setAirportObj(AirportDTO airport) {
		this.airport.add(airport);
	}

	public void setCrew(CrewDTO crew) {
		this.crew.add(crew);
	}

	public void setCrewCount(int crewCount) {
		this.crewCount = crewCount;
	}

	public void setEnv(Environment env) {
		this.env.add(env);
	}

	public void setEnvironmentCount(int environmentCount) {
		this.environmentCount = environmentCount;
	}

	public void setFlightSchedule(FlightScheduleDTO flightSchedule) {
		this.flightSchedule.add(flightSchedule);
	}

	public void setFlightScheduleCount(int flightScheduleCount) {
		this.flightScheduleCount = flightScheduleCount;
	}

	public void setFlightScheduleCrew(FlightScheduleCrewDTO flightScheduleCrew) {
		this.flightScheduleCrew.add(flightScheduleCrew);
	}

	public void setFlightScheduleCrewCount(int flightScheduleCrewCount) {
		this.flightScheduleCrewCount = flightScheduleCrewCount;
	}

	public void setFlightSchedulePilot(FlightSchedulePilotDTO flightSchedulePilot) {
		this.flightSchedulePilot.add(flightSchedulePilot);
	}

	public void setFlightSchedulePilotCount(int flightSchedulePilotCount) {
		this.flightSchedulePilotCount = flightSchedulePilotCount;
	}

	public void setPilot(PilotDTO pilot) {
		this.pilot.add(pilot);
	}

	public void setPilotCount(int pilotCount) {
		this.pilotCount = pilotCount;
	}

	public void setPilotDesignation(PilotDesignationDTO pilotDesignation) {
		this.pilotDesignation.add(pilotDesignation);
	}

	public void setPilotDesignationCount(int pilotDesignationCount) {
		this.pilotDesignationCount = pilotDesignationCount;
	}

	public void setRestDetail(RestDetailDTO restDetail) {
		this.restDetail.add(restDetail);
	}

	public void setRestDetailCount(int restDetailCount) {
		this.restDetailCount = restDetailCount;
	}

	public void setUser(UserDTO user) {
		this.user.add(user);
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
}
