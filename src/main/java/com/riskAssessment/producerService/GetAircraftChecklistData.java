package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.AircraftChecklistDispatcher;
import com.riskAssessment.ProducerPOJO.AircraftChecklist;
import com.riskAssessment.intefaceRepository.AircraftChecklistRepo;

@Service
public class GetAircraftChecklistData {

	@Autowired
	AircraftChecklistRepo craftRepo;
	@Autowired
	AircraftChecklistDispatcher craftDispatcher;

	public void getAircraftChecklistData() {
		Iterable<AircraftChecklist> itr = craftRepo.findAll();
		Iterator<AircraftChecklist> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
