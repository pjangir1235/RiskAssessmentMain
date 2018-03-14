package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.CrewRepo;
import com.risk.producerdispatcher.CrewDispatcher;
import com.risk.producerpojo.Crew;

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
