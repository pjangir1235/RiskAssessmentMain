package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.AircraftDispatcher;
import com.riskAssessment.ProducerPOJO.Aircraft;
import com.riskAssessment.intefaceRepository.AircraftRepo;

@Service
public class GetAircraftData {

	@Autowired
	AircraftRepo craftRepo;
	@Autowired
	AircraftDispatcher craftDispatcher;

	public void getAircraftData() {
		Iterable<Aircraft> itr = craftRepo.findAll();
		Iterator<Aircraft> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
