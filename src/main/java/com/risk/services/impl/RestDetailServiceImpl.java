package com.risk.services.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.producer.dispatcher.RestDetailDispatcher;
import com.risk.producer.intefacerepo.RestDetailRepo;
import com.risk.producer.model.RestDetail;
import com.risk.services.interfaces.RestDetailService;

@Service
public class RestDetailServiceImpl implements  RestDetailService {

	@Autowired
	RestDetailRepo craftRepo;
	@Autowired
	RestDetailDispatcher craftDispatcher;

	/* (non-Javadoc)
	 * @see com.risk.services.impl.RestDetailService#getCrewRestDetail(int, java.lang.String)
	 */
	@Override
	public void getCrewRestDetail(int crewMemberId, String date) {

		Iterable<RestDetail> itr = craftRepo.findById(crewMemberId, date);
		Iterator<RestDetail> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}

	/* (non-Javadoc)
	 * @see com.risk.services.impl.RestDetailService#getRestDetailData()
	 */
	@Override
	public void getRestDetailData() {
		Iterable<RestDetail> itr = craftRepo.findAll();
		Iterator<RestDetail> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}
}
