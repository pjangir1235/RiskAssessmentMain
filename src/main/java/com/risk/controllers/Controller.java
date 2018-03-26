package com.risk.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.risk.constants.CommonConstant;
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
import com.risk.models.Environment;
import com.risk.models.ScheduleRequestDTO;
import com.risk.models.StoreRecord;
import com.risk.services.interfaces.MainService;

@RestController
public class Controller {


	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	MainService producer;

	@Autowired
	StoreRecord record;

	@PostMapping("analysis")
	public List<Object> doAnalysis(@RequestBody FlightScheduleDTO schedule) {
		List<Object> data = new ArrayList<>();
		try {
			producer.getAnalysisData(schedule);
				producer.checkFetchData();

			return data;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return data;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraft")

	public List<AircraftDTO> getaircraft() {
		List<AircraftDTO> list = null;
		try {

			producer.getAircraftValues();
			producer.checkFetchData();
			list = record.getAircraft();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftChecklist")

	public List<AircraftChecklistDTO> getAircraftChecklist() {
		List<AircraftChecklistDTO> list = null;
		try {

			producer.getAircraftChecklistValues();
			producer.checkFetchData();
			list = record.getAircraftChecklist();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftType")

	public List<AircraftTypeDTO> getAircraftType() {
		List<AircraftTypeDTO> list = null;
		try {

			producer.getAircraftTypeValues();
			producer.checkFetchData();
			list = record.getAircraftType();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/airport")

	public List<AirportDTO> getAirport() {
		List<AirportDTO> list = null;
		try {

			producer.getAiprotValues();
			producer.checkFetchData();
			list = record.getAirport();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/crew")

	public List<CrewDTO> getCrew() {
		List<CrewDTO> list = null;
		try {

			producer.getCrewValues();
			producer.checkFetchData();

			list = record.getCrew();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/environment/{stationCode}")

	public List<Environment> getEnvironmentDetail(@PathVariable("stationCode") String stationCode) {
		List<Environment> data = null;
		try {

			producer.getEnvironmentValues(stationCode);
			producer.checkFetchData();
			data = record.getEnv();
			return data;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return data;
		}
		finally {

			record.destroy();
		}

	}

	@PostMapping("/flightSchedule")

	public List<FlightScheduleDTO> getFlightSchedule(@RequestBody ScheduleRequestDTO req) {
		List<FlightScheduleDTO> list = null;
		try {

			producer.getFlightScheduleValues(req);
			producer.checkFetchData();
			list = record.getFlightSchedule();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/flightScheduleCrew")

	public List<FlightScheduleCrewDTO> getFlightScheduleCrew() {
		List<FlightScheduleCrewDTO> list = null;
		try {

			producer.getFlightScheduleCrewValues();
			producer.checkFetchData();
			list = record.getFlightScheduleCrew();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/flightSchedulePilot")

	public List<FlightSchedulePilotDTO> getFlightSchedulePilot() {
		List<FlightSchedulePilotDTO> list = null;
		try {

			producer.getFlightSchedulePilotValues();
			producer.checkFetchData();
			list = record.getFlightSchedulePilot();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/pilot")

	public List<PilotDTO> getPilot() {
		List<PilotDTO> list = null;
		try {

			producer.getPilotValues();
			producer.checkFetchData();
			list = record.getPilot();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/pilotDesignation")

	public List<PilotDesignationDTO> getPilotDesignationData() {
		List<PilotDesignationDTO> list = null;
		try {

			producer.getPilotDesignationValues();
			producer.checkFetchData();
			list = record.getPilotDesignation();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@GetMapping("/restDetail")

	public List<RestDetailDTO> getRestDetail() {
		List<RestDetailDTO> list = null;
		try {

			producer.getRestDetailValues();
			producer.checkFetchData();
			list = record.getRestDetail();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
		finally {

			record.destroy();
		}

	}

	@PostMapping("/user")

	public List<UserDTO> getUser(@RequestBody UserDTO user) {
		List<UserDTO> list = null;
		try {
			record.destroyUser();
			producer.getUserValues(user.getUserName(), user.getPassword());
			producer.checkFetchData();
			list = record.getUser();
			return list;
		}
		catch (Exception e) {
			logger.error(CommonConstant.ERROR + e);
			return list;
		}
	}

}
