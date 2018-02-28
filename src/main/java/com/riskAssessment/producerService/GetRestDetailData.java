package com.riskAssessment.producerService;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskAssessment.ProducerDispatcher.RestDetailDispatcher;
import com.riskAssessment.ProducerPOJO.RestDetail;
import com.riskAssessment.intefaceRepository.RestDetailRepo;

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
