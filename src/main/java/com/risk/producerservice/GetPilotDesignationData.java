package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.PilotDesignationRepo;
import com.risk.producerdispatcher.PilotDesignationDispatcher;
import com.risk.producerpojo.PilotDesignation;

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
