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

	public static final  String ERROR = "Error->";
	@Autowired
	ProducerService producer;

	@Autowired
	StoreRecord record;

	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

	@GetMapping("/aircraft")

	public List<AircraftData> getaircraft() {
		List<AircraftData> list = null;
		try {

			producer.getAircraftValues();
			producer.checkFetchData();
			list = record.getAircraft();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/airport")

	public List<AirportData> getAirport() {
		List<AirportData> list = null;
		try {

			producer.getAiprotValues();
			producer.checkFetchData();
			list = record.getAirport();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftChecklist")

	public List<AircraftChecklistData> getAircraftChecklist() {
		List<AircraftChecklistData> list = null;
		try {

			producer.getAircraftChecklistValues();
			producer.checkFetchData();
			list = record.getAircraftChecklist();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftType")

	public List<AircraftTypeData> getAircraftType() {
		List<AircraftTypeData> list = null;
		try {

			producer.getAircraftTypeValues();
			producer.checkFetchData();
			list = record.getAircraftType();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/crew")

	public List<CrewData> getCrew() {
		List<CrewData> list = null;
		try {

			producer.getCrewValues();
			producer.checkFetchData();

			list = record.getCrew();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightScheduleCrew")

	public List<FlightScheduleCrewData> getFlightScheduleCrew() {
		List<FlightScheduleCrewData> list = null;
		try {

			producer.getFlightScheduleCrewValues();
			producer.checkFetchData();
			list= record.getFlightScheduleCrew();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightSchedulePilot")

	public List<FlightSchedulePilotData> getFlightSchedulePilot() {
		List<FlightSchedulePilotData> list=null;
		try {

			producer.getFlightSchedulePilotValues();
			producer.checkFetchData();
			list= record.getFlightSchedulePilot();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@PostMapping("/flightSchedule")

	public List<FlightScheduleData> getFlightSchedule(@RequestBody ScheduleRequestData req) {
		List<FlightScheduleData>list=null;
		try {

			producer.getFlightScheduleValues(req);
			producer.checkFetchData();
list= record.getFlightSchedule();
return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/pilot")

	public List<PilotData> getPilot() {
		List<PilotData> list=null;
		try {

			producer.getPilotValues();
			producer.checkFetchData();
			list= record.getPilot();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/pilotDesignation")

	public List<PilotDesignationData> getPilotDesignationData() {
		List<PilotDesignationData> list=null;
		try {

			producer.getPilotDesignationValues();
			producer.checkFetchData();
			list= record.getPilotDesignation();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/restDetail")

	public List<RestDetailData> getRestDetail() {
		List<RestDetailData> list=null;
		try {

			producer.getRestDetailValues();
			producer.checkFetchData();
			list= record.getRestDetail();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		} finally {

			record.destroy();
		}

	}

	@PostMapping("/user")

	public List<UserData> getUser(@RequestBody UserData user) {
		List<UserData> list=null;
		try {
			record.destroyUser();
			producer.getUserValues(user.getUserName(), user.getPassword());
			producer.checkFetchData();
			list= record.getUser();
			return list;
		} catch (Exception e) {
			logger.error(ERROR + e);
			return list;
		}
	}

}
