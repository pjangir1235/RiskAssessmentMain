package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.PilotDispatcher;
import com.riskAssessment.ProducerPOJO.Pilot;
import com.riskAssessment.intefaceRepository.PilotRepo;

@Service
public class GetPilotData {

	@Autowired
	PilotRepo craftRepo;
	@Autowired
	PilotDispatcher craftDispatcher;

	public void getPilotData() {
		Iterable<Pilot> itr = craftRepo.findAll();
		Iterator<Pilot> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
