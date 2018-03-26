package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.AircraftTypeRepo;
import com.risk.producerdispatcher.AircraftTypeDispatcher;
import com.risk.producerpojo.AircraftTypeValue;

@Service
public class GetAircraftTypeData {

	@Autowired
	AircraftTypeRepo craftRepo;
	@Autowired
	AircraftTypeDispatcher craftDispatcher;

	public void getAircraftTypeData() {
		Iterable<AircraftTypeValue> itr = craftRepo.findAll();
		Iterator<AircraftTypeValue> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
