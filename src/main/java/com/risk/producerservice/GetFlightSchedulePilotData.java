package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.FlightSchedulePilotRepo;
import com.risk.producerdispatcher.FlightSchedulePilotDispatcher;
import com.risk.producerpojo.FlightSchedulePilot;

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