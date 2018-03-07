package com.riskAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.riskAssessment.ConsumerPOJO.UserData;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;
import com.riskAssessment.POJO.ScheduleRequestData;
import com.riskAssessment.ServiceInterface.ProducerService;

@RestController
@RequestMapping
public class RequestController {

	@Autowired
	ProducerService producer;

	@Autowired
	StoreRecord record;

	@GetMapping("/aircraft")
	
	public List<AircraftData> getaircraft() {
		try {

			producer.getAircraftValues();
			producer.checkFetchData();
			return record.getAircraft();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/airport")
	
	public List<AirportData> getAirport() {
		try {

			producer.getAiprotValues();
			producer.checkFetchData();
			return record.getAirport();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftChecklist")
	
	public List<AircraftChecklistData> getAircraftChecklist() {
		try {

			producer.getAircraftChecklistValues();
			producer.checkFetchData();
			return record.getAircraftChecklist();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftType")
	
	public List<AircraftTypeData> getAircraftType() {
		try {

			producer.getAircraftTypeValues();
			producer.checkFetchData();
			return record.getAircraftType();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/crew")
	
	public List<CrewData> getCrew() {
		try {

			producer.getCrewValues();
			producer.checkFetchData();
			
			return record.getCrew();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightScheduleCrew")
	
	public List<FlightScheduleCrewData> getFlightScheduleCrew() {
		try {

			producer.getFlightScheduleCrewValues();
			producer.checkFetchData();
			return record.getFlightScheduleCrew();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightSchedulePilot")
	
	public List<FlightSchedulePilotData> getFlightSchedulePilot() {
		try {

			producer.getFlightSchedulePilotValues();
			producer.checkFetchData();
			return record.getFlightSchedulePilot();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@PostMapping("/flightSchedule")
	
	public List<FlightScheduleData> getFlightSchedule(@RequestBody ScheduleRequestData req) {
		try {

			producer.getFlightScheduleValues(req);
			producer.checkFetchData();
			
			return record.getFlightSchedule();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/pilot")
	
	public List<PilotData> getPilot() {
		try {

			producer.getPilotValues();
			producer.checkFetchData();
			return record.getPilot();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/pilotDesignation")
	
	public List<PilotDesignationData> getPilotDesignationData() {
		try {

			producer.getPilotDesignationValues();
			producer.checkFetchData();
			return record.getPilotDesignation();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/restDetail")
	
	public List<RestDetailData> getRestDetail() {
		try {

			producer.getRestDetailValues();
			producer.checkFetchData();
			return record.getRestDetail();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}
	@PostMapping("/user")
	
	public List<UserData> getUser(@RequestBody UserData user) {
			try {
				record.DestroyUser();
			producer.getUserValues(user.getUserName(),user.getPassword());
			producer.checkFetchData();
			return record.getUser();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			
		}

	}


}
