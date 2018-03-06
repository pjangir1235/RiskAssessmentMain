package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.PilotDesignationDispatcher;
import com.riskAssessment.ProducerDispatcher.UserDispatcher;
import com.riskAssessment.ProducerPOJO.PilotDesignation;
import com.riskAssessment.ProducerPOJO.User;
import com.riskAssessment.intefaceRepository.PilotDesignationRepo;
import com.riskAssessment.intefaceRepository.UserRepo;

@Service
public class GetUserData {

	@Autowired
	UserRepo userRepo;
	@Autowired
	UserDispatcher userDispatcher;

	public void getUserData(String userName,String password) {
		Iterable<User> itr = userRepo.findByName(userName,password);
		Iterator<User> iter = itr.iterator();
		while (iter.hasNext())
			userDispatcher.dispatch(iter.next());

	}
}
