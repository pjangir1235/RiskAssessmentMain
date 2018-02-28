package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.CrewDispatcher;
import com.riskAssessment.ProducerPOJO.Crew;
import com.riskAssessment.intefaceRepository.CrewRepo;

@Service
public class GetCrewData {

	@Autowired
	CrewRepo craftRepo;
	@Autowired
	CrewDispatcher craftDispatcher;

	public void getCrewData() {
		Iterable<Crew> itr = craftRepo.findAll();
		Iterator<Crew> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
