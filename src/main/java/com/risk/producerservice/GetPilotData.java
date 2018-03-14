package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.PilotRepo;
import com.risk.producerdispatcher.PilotDispatcher;
import com.risk.producerpojo.Pilot;

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
