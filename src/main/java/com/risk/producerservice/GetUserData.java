package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.UserRepo;
import com.risk.producerdispatcher.UserDispatcher;
import com.risk.producerpojo.User;

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
