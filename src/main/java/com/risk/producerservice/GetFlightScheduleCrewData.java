package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.FlightScheduleCrewRepo;
import com.risk.producerdispatcher.FlightScheduleCrewDispatcher;
import com.risk.producerpojo.FlightScheduleCrew;

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