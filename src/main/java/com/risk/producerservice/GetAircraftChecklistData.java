package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.AircraftChecklistRepo;
import com.risk.producerdispatcher.AircraftChecklistDispatcher;
import com.risk.producerpojo.AircraftChecklist;

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
