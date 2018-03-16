package com.risk.datastorageconsumer;

import java.util.ArrayList;
import java.util.List;

import com.risk.consumerpojo.AircraftChecklistData;
import com.risk.consumerpojo.AircraftData;
import com.risk.consumerpojo.AircraftTypeData;
import com.risk.consumerpojo.AirportData;
import com.risk.consumerpojo.CrewData;
import com.risk.consumerpojo.FlightScheduleCrewData;
import com.risk.consumerpojo.FlightScheduleData;
import com.risk.consumerpojo.FlightSchedulePilotData;
import com.risk.consumerpojo.PilotData;
import com.risk.consumerpojo.PilotDesignationData;
import com.risk.consumerpojo.RestDetailData;
import com.risk.consumerpojo.UserData;

public class StoreRecord {

	private List<AirportData> airport = new ArrayList<>();
	private List<AircraftData> aircraft = new ArrayList<>();
	private List<AircraftChecklistData> aircraftChecklist = new ArrayList<>();
	private List<AircraftTypeData> aircraftType = new ArrayList<>();
	private List<CrewData> crew = new ArrayList<>();
	private List<FlightScheduleData> flightSchedule = new ArrayList<>();
	private List<FlightScheduleCrewData> flightScheduleCrew = new ArrayList<>();
	private List<FlightSchedulePilotData> flightSchedulePilot = new ArrayList<>();
	private List<PilotDesignationData> pilotDesignation = new ArrayList<>();
	private List<RestDetailData> restDetail = new ArrayList<>();
	private List<PilotData> pilot = new ArrayList<>();
	private List<UserData> user=new ArrayList<>();

	private int airportCount = 0;
	private int aircraftCount = 0;
	private int aircraftChecklistCount = 0;
	private int userCount=0;



	private int aircraftTypeCount = 0;
	private int crewCount = 0;
	private int flightScheduleCount = 0;
	private int flightScheduleCrewCount = 0;
	private int flightSchedulePilotCount = 0;
	private int pilotCount = 0;
	private int pilotDesignationCount = 0;
	private int restDetailCount = 0;


	public int getAircraftChecklistCount() {
		return aircraftChecklistCount;
	}
	public void setAircraftChecklistCount(int aircraftChecklistCount) {
		this.aircraftChecklistCount = aircraftChecklistCount;
	}

	public int getAircraftTypeCount() {
		return aircraftTypeCount;
	}

	public void setAircraftTypeCount(int aircraftTypeCount) {
		this.aircraftTypeCount = aircraftTypeCount;
	}

	public int getCrewCount() {
		return crewCount;
	}

	public void setCrewCount(int crewCount) {
		this.crewCount = crewCount;
	}
	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public int getFlightScheduleCount() {
		return flightScheduleCount;
	}

	public void setFlightScheduleCount(int flightScheduleCount) {
		this.flightScheduleCount = flightScheduleCount;
	}

	public int getFlightScheduleCrewCount() {
		return flightScheduleCrewCount;
	}

	public void setFlightScheduleCrewCount(int flightScheduleCrewCount) {
		this.flightScheduleCrewCount = flightScheduleCrewCount;
	}

	public int getFlightSchedulePilotCount() {
		return flightSchedulePilotCount;
	}

	public void setFlightSchedulePilotCount(int flightSchedulePilotCount) {
		this.flightSchedulePilotCount = flightSchedulePilotCount;
	}

	public int getPilotCount() {
		return pilotCount;
	}

	public void setPilotCount(int pilotCount) {
		this.pilotCount = pilotCount;
	}

	public int getPilotDesignationCount() {
		return pilotDesignationCount;
	}

	public void setPilotDesignationCount(int pilotDesignationCount) {
		this.pilotDesignationCount = pilotDesignationCount;
	}

	public int getRestDetailCount() {
		return restDetailCount;
	}

	public void setRestDetailCount(int restDetailCount) {
		this.restDetailCount = restDetailCount;
	}

	public void setAirport(AirportData airport) {
		this.airport.add(airport);
	}

	public List<AircraftData> getAircraft() {
		return aircraft;
	}

	public void setAircraft(AircraftData aircraft) {
		this.aircraft.add(aircraft);
	}

	public int getAircraftCount() {
		return aircraftCount;
	}

	public void setAircraftCount(int aircraftCount) {
		this.aircraftCount = aircraftCount;
	}

	public void setAirportCount(int airportCount) {

		this.airportCount = airportCount;

	}

	public List<AirportData> getAirport() {
		return airport;
	}

	public void setAirportObj(AirportData airport) {
		this.airport.add(airport);
	}

	public int getAirportCount() {
		return airportCount;

	}



	public List<AircraftChecklistData> getAircraftChecklist() {
		return aircraftChecklist;
	}

	public void setAircraftChecklist(AircraftChecklistData aircraftChecklist) {
		this.aircraftChecklist.add(aircraftChecklist);
	}

	public List<AircraftTypeData> getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(AircraftTypeData aircraftType) {
		this.aircraftType.add(aircraftType);
	}

	public List<CrewData> getCrew() {
		return crew;
	}

	public void setCrew(CrewData crew) {
		this.crew.add(crew);
	}

	public List<FlightScheduleData> getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightScheduleData flightSchedule) {
		this.flightSchedule.add(flightSchedule);
	}
	public List<UserData> getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user.add(user);
	}

	public List<FlightScheduleCrewData> getFlightScheduleCrew() {
		return flightScheduleCrew;
	}

	public void setFlightScheduleCrew(FlightScheduleCrewData flightScheduleCrew) {
		this.flightScheduleCrew.add(flightScheduleCrew);
	}

	public List<FlightSchedulePilotData> getFlightSchedulePilot() {
		return flightSchedulePilot;
	}

	public void setFlightSchedulePilot(FlightSchedulePilotData flightSchedulePilot) {
		this.flightSchedulePilot.add(flightSchedulePilot);
	}

	public List<PilotDesignationData> getPilotDesignation() {
		return pilotDesignation;
	}

	public void setPilotDesignation(PilotDesignationData pilotDesignation) {
		this.pilotDesignation.add(pilotDesignation);
	}

	public List<RestDetailData> getRestDetail() {
		return restDetail;
	}

	public void setRestDetail(RestDetailData restDetail) {
		this.restDetail.add(restDetail);
	}

	public List<PilotData> getPilot() {
		return pilot;
	}

	public void setPilot(PilotData pilot) {
		this.pilot.add(pilot);
	}

	public StoreRecord() {
		super();
	}

	public void destroy() {
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
		user=new ArrayList<>();
	}
	public void destroyUser() {
		user=new ArrayList<>();
	}
}
