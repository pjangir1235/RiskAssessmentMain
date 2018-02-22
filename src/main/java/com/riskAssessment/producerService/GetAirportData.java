package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.POJO.Airport_Location;
import com.riskAssessment.intefaceRepository.AirportRepo;

@Service
public class GetAirportData {
    @Autowired
    AirportRepo airport;
    @Autowired
    AirportDispatcher dispatcher;

    public void getAirport() {
	Iterable<Airport_Location> itr = airport.findAll();
	Iterator<Airport_Location> iter = itr.iterator();
	while (iter.hasNext())
	    dispatcher.dispatch(iter.next());

    }

}
