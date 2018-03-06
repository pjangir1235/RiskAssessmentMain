package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.FlightScheduleDispatcher;
import com.riskAssessment.ProducerPOJO.FlightSchedule;
import com.riskAssessment.intefaceRepository.FlightScheduleRepo;

@Service
public class GetFlightScheduleData {

	@Autowired
	FlightScheduleRepo craftRepo;
	@Autowired
	FlightScheduleDispatcher craftDispatcher;

	public void getFlightScheduleData() {
		Iterable<FlightSchedule> itr = craftRepo.findAll();
		Iterator<FlightSchedule> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
//	public void getFlightSchedulePilotData() {
//		Iterable<FlightSchedule> 
//	}
}
