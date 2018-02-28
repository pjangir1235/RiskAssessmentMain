package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.FlightSchedulePilotDispatcher;
import com.riskAssessment.ProducerPOJO.FlightSchedulePilot;
import com.riskAssessment.intefaceRepository.FlightSchedulePilotRepo;

@Service
public class GetFlightSchedulePilotData {

	@Autowired
	FlightSchedulePilotRepo craftRepo;
	@Autowired
	FlightSchedulePilotDispatcher craftDispatcher;

	public void getFlightSchedulePilotData() {
		Iterable<FlightSchedulePilot> itr = craftRepo.findAll();
		Iterator<FlightSchedulePilot> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
