package com.riskAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.riskAssessment.DAO.ProducerDao;
import com.riskAssessment.DataStorageConsumerr.StoreRecord;

@Controller
@RequestMapping
public class RequestController {

	@Autowired
	ProducerDao producer;

	@Autowired
	StoreRecord record;

	@GetMapping("/aircraft")
	@ResponseBody
	public List<AircraftData> getaircraft() {
		try {

			producer.getAircraftValues();
			while (record.getAircraftCount() != 0) {
				System.out.println("record" + record.getAircraftCount());
				Thread.sleep(1000);
			}
			return record.getAircraft();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/airport")
	@ResponseBody
	public List<AirportData> getAirport() {
		try {

			producer.getAiprotValues();
			while (record.getAirportCount() != 0) {
				System.out.println("record" + record.getAirportCount());
				Thread.sleep(1000);
			}
			return record.getAirport();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftChecklist")
	@ResponseBody
	public List<AircraftChecklistData> getAircraftChecklist() {
		try {

			producer.getAircraftChecklistValues();
			while (record.getAircraftChecklistCount() != 0) {
				System.out.println("record" + record.getAircraftChecklistCount());
				Thread.sleep(1000);
			}
			return record.getAircraftChecklist();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/aircraftType")
	@ResponseBody
	public List<AircraftTypeData> getAircraftType() {
		try {

			producer.getAircraftTypeValues();

			while (record.getAircraftTypeCount() != 0) {
				System.out.println("record" + record.getAircraftTypeCount());
				Thread.sleep(1000);
			}
			return record.getAircraftType();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/crew")
	@ResponseBody
	public List<CrewData> getCrew() {
		try {

			producer.getCrewValues();

			while (record.getCrewCount() != 0) {
				System.out.println("record" + record.getCrewCount());
				Thread.sleep(1000);
			}
			return record.getCrew();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightScheduleCrew")
	@ResponseBody
	public List<FlightScheduleCrewData> getFlightScheduleCrew() {
		try {

			producer.getFlightScheduleCrewValues();
			while (record.getAircraftChecklistCount() != 0) {
				System.out.println("record" + record.getFlightScheduleCrewCount());
				Thread.sleep(1000);
			}
			return record.getFlightScheduleCrew();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightSchedulePilot")
	@ResponseBody
	public List<FlightSchedulePilotData> getFlightSchedulePilot() {
		try {

			producer.getFlightSchedulePilotValues();
			while (record.getFlightSchedulePilotCount() != 0) {
				System.out.println("record" + record.getFlightSchedulePilotCount());
				Thread.sleep(1000);
			}
			return record.getFlightSchedulePilot();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/flightSchedule")
	@ResponseBody
	public List<FlightScheduleData> getFlightSchedule() {
		try {

			producer.getFlightSchedulePilotValues();
			while (record.getFlightScheduleCount() != 0) {
				System.out.println("record" + record.getFlightScheduleCount());
				Thread.sleep(1000);
			}
			return record.getFlightSchedule();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/pilot")
	@ResponseBody
	public List<PilotData> getPilot() {
		try {

			producer.getPilotValues();
			while (record.getPilotCount() != 0) {
				System.out.println("record" + record.getPilotCount());
				Thread.sleep(1000);
			}
			return record.getPilot();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/pilotDesignation")
	@ResponseBody
	public List<PilotDesignationData> getPilotDesignationData() {
		try {

			producer.getPilotDesignationValues();
			while (record.getPilotDesignationCount() != 0) {
				System.out.println("record" + record.getPilotDesignationCount());
				Thread.sleep(1000);
			}
			return record.getPilotDesignation();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	@GetMapping("/restDetail")
	@ResponseBody
	public List<RestDetailData> getRestDetail() {
		try {

			producer.getRestDetailValues();
			while (record.getRestDetailCount() != 0) {
				System.out.println("record" + record.getRestDetailCount());
				Thread.sleep(1000);
			}
			return record.getRestDetail();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			record.destroy();
		}

	}

	/*
	 * @GetMapping("/aircraftDetail") @ResponseBody public
	 * List<AircraftChecklistData> getAllAircraft() { try {
	 *
	 * producer.getAiprotValues(); producer.getAircraftChecklistValues();
	 * producer.getAircraftValues(); producer.getAircraftTypeValues();
	 * producer.getCrewValues(); producer.getFlightScheduleCrewValues();
	 * producer.getFlightSchedulePilotValues(); producer.getFlightScheduleValues();
	 * // producer.getPilotDesignationValues(); producer.getPilotValues(); //
	 * producer.getRestDetailValues(); while (record.getAircraftChecklistCount() !=
	 * 0) { System.out.println("record" + record.getAircraftChecklistCount());
	 * Thread.sleep(1000); } return record.getAircraftChecklist(); } catch
	 * (Exception e) { e.printStackTrace(); return null; } finally {
	 *
	 * record.destroy(); }
	 *
	 * }
	 */

}
