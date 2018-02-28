package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.AirportDispatcher;
import com.riskAssessment.ProducerPOJO.Airport;
import com.riskAssessment.intefaceRepository.AirportRepo;

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
