package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.FlightScheduleCrewDispatcher;
import com.riskAssessment.ProducerPOJO.FlightScheduleCrew;
import com.riskAssessment.intefaceRepository.FlightScheduleCrewRepo;

@Service
public class GetFlightScheduleCrewData {

	@Autowired
	FlightScheduleCrewRepo craftRepo;
	@Autowired
	FlightScheduleCrewDispatcher craftDispatcher;

	public void getFlightScheduleCrewData() {
		Iterable<FlightScheduleCrew> itr = craftRepo.findAll();
		Iterator<FlightScheduleCrew> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
