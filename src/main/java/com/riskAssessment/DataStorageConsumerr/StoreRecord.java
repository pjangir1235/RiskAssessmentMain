package com.riskAssessment.DataStorageConsumerr;

import java.util.ArrayList;
import java.util.List;

import com.riskAssessment.ConsumerPOJO.AircraftChecklistData;
import com.riskAssessment.ConsumerPOJO.AircraftData;
import com.riskAssessment.ConsumerPOJO.AircraftTypeData;
import com.riskAssessment.ConsumerPOJO.AirportData;
import com.riskAssessment.ConsumerPOJO.CrewData;
import com.riskAssessment.ConsumerPOJO.FlightScheduleCrewData;
import com.riskAssessment.ConsumerPOJO.FlightScheduleData;
import com.riskAssessment.ConsumerPOJO.FlightSchedulePilotData;
import com.riskAssessment.ConsumerPOJO.PilotData;
import com.riskAssessment.ConsumerPOJO.PilotDesignationData;
import com.riskAssessment.ConsumerPOJO.RestDetailData;

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

	private int airportCount = 0;
	private int aircraftCount = 0;
	private int aircraftChecklistCount = 0;

	public int getAircraftChecklistCount() {
		return aircraftChecklistCount;
	}

	private int aircraftTypeCount = 0;
	private int crewCount = 0;
	private int flightScheduleCount = 0;
	private int flightScheduleCrewCount = 0;
	private int flightSchedulePilotCount = 0;
	private int pilotCount = 0;
	private int pilotDesignationCount = 0;
	private int restDetailCount = 0;

	public int Aircraft() {
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

	public StoreRecord(List<AirportData> airport, List<AircraftData> aircraft,
			List<AircraftChecklistData> aircraftChecklist, List<AircraftTypeData> aircraftType, List<CrewData> crew,
			List<FlightScheduleData> flightSchedule, List<FlightScheduleCrewData> flightScheduleCrew,
			List<FlightSchedulePilotData> flightSchedulePilot, List<PilotDesignationData> pilotDesignation,
			List<RestDetailData> restDetail, List<PilotData> pilot, int airportCount, int aircraftCount,
			int aircraftChecklistCount, int aircraftTypeCount, int crewCount, int flightScheduleCount,
			int flightScheduleCrewCount, int flightSchedulePilotCount, int pilotCount, int pilotDesignationCount,
			int restDetailCount) {
		super();
		this.airport = airport;
		this.aircraft = aircraft;
		this.aircraftChecklist = aircraftChecklist;
		this.aircraftType = aircraftType;
		this.crew = crew;
		this.flightSchedule = flightSchedule;
		this.flightScheduleCrew = flightScheduleCrew;
		this.flightSchedulePilot = flightSchedulePilot;
		this.pilotDesignation = pilotDesignation;
		this.restDetail = restDetail;
		this.pilot = pilot;
		this.airportCount = airportCount;
		this.aircraftCount = aircraftCount;
		this.aircraftChecklistCount = aircraftChecklistCount;
		this.aircraftTypeCount = aircraftTypeCount;
		this.crewCount = crewCount;
		this.flightScheduleCount = flightScheduleCount;
		this.flightScheduleCrewCount = flightScheduleCrewCount;
		this.flightSchedulePilotCount = flightSchedulePilotCount;
		this.pilotCount = pilotCount;
		this.pilotDesignationCount = pilotDesignationCount;
		this.restDetailCount = restDetailCount;
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
	}
}
