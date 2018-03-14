package com.risk.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.risk.datastorageconsumer.StoreRecord;
import com.risk.pojo.ScheduleRequestData;
import com.risk.serviceinterface.ProducerService;

@RestController
@RequestMapping
public class RequestController {

	@Autowired
	ProducerService producer;

	@Autowired
	StoreRecord record;

	 private static final Logger logger =
		 LoggerFactory.getLogger(RequestController.class);


	@GetMapping("/aircraft")

	public List<AircraftData> getaircraft() {
		try {

			producer.getAircraftValues();
			producer.checkFetchData();
			return record.getAircraft();
		} catch (Exception e) {
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
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
			logger.error("Error->"+e);
			return null;
		} finally {


		}

	}


}
