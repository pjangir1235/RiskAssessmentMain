package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.AircraftRepo;
import com.risk.producerdispatcher.AircraftDispatcher;
import com.risk.producerpojo.Aircraft;

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
