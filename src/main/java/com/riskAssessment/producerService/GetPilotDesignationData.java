package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.PilotDesignationDispatcher;
import com.riskAssessment.ProducerPOJO.PilotDesignation;
import com.riskAssessment.intefaceRepository.PilotDesignationRepo;

@Service
public class GetPilotDesignationData {

	@Autowired
	PilotDesignationRepo craftRepo;
	@Autowired
	PilotDesignationDispatcher craftDispatcher;

	public void getPilotDesignationData() {
		Iterable<PilotDesignation> itr = craftRepo.findAll();
		Iterator<PilotDesignation> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
