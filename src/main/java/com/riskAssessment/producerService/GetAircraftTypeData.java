package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.AircraftTypeDispatcher;
import com.riskAssessment.ProducerPOJO.AircraftType;
import com.riskAssessment.intefaceRepository.AircraftTypeRepo;

@Service
public class GetAircraftTypeData {

	@Autowired
	AircraftTypeRepo craftRepo;
	@Autowired
	AircraftTypeDispatcher craftDispatcher;

	public void getAircraftTypeData() {
		Iterable<AircraftType> itr = craftRepo.findAll();
		Iterator<AircraftType> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
