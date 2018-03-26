package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.AirportRepo;
import com.risk.producerdispatcher.AirportDispatcher;
import com.risk.producerpojo.Airport;

@Service
public class GetAirportData {
	@Autowired
	AirportRepo airport;
	@Autowired
	AirportDispatcher dispatcher;

	public void getAirportData() {
		Iterable<Airport> itr = airport.findAll();
		Iterator<Airport> iter = itr.iterator();
		while (iter.hasNext())
			dispatcher.dispatch(iter.next());

	}

}
