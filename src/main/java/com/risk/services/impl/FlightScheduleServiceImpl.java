package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.FlightScheduleRepo;
import com.risk.producerdispatcher.FlightScheduleDispatcher;
import com.risk.producerpojo.FlightSchedule;

@Service
public class GetFlightScheduleData {

	@Autowired
	FlightScheduleRepo craftRepo;
	@Autowired
	FlightScheduleDispatcher craftDispatcher;

	public void getFlightScheduleData(String location,String date) {
		Iterable<FlightSchedule> itr = craftRepo.findSchedule(location,date);
		Iterator<FlightSchedule> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}

}