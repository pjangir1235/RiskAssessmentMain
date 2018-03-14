package com.risk.producerservice;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.intefacerepository.RestDetailRepo;
import com.risk.producerdispatcher.RestDetailDispatcher;
import com.risk.producerpojo.RestDetail;

@Service
public class GetRestDetailData {

	@Autowired
	RestDetailRepo craftRepo;
	@Autowired
	RestDetailDispatcher craftDispatcher;

	public void getRestDetailData() {
		Iterable<RestDetail> itr = craftRepo.findAll();
		Iterator<RestDetail> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
