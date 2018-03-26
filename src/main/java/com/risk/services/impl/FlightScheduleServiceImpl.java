package com.risk.services.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.producer.dispatcher.FlightScheduleDispatcher;
import com.risk.producer.intefacerepo.FlightScheduleRepo;
import com.risk.producer.model.FlightPilotSummary;
import com.risk.producer.model.FlightSchedule;
import com.risk.services.interfaces.FlightScheduleService;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	FlightScheduleRepo craftRepo;
	@Autowired
	FlightScheduleDispatcher craftDispatcher;

	/* (non-Javadoc)
	 * @see com.risk.services.impl.FlightScheduleService#getFlightScheduleData(java.lang.String, java.lang.String)
	 */
	@Override
	public void getFlightScheduleData(String location, String date) {
		Iterable<FlightSchedule> itr = craftRepo.findSchedule(location, date);
		Iterator<FlightSchedule> iter = itr.iterator();
		while (iter.hasNext())
			craftDispatcher.dispatch(iter.next());

	}

	/* (non-Javadoc)
	 * @see com.risk.services.impl.FlightScheduleService#getFlightSchedulePilotData(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void getFlightSchedulePilotData(int pilotId, String pilotDesignationCode, String dateOfDeparture) {

		Iterable<FlightPilotSummary> itr = craftRepo.getPilotData(pilotId, dateOfDeparture);
		Iterator<FlightPilotSummary> iter = itr.iterator();
		/*if (pilotDesignationCode.equals("PD1"))
			while (iter.hasNext())
				iter.next().toString();
		else
			while (iter.hasNext())
				iter.next().toString();*/
		while (iter.hasNext())
			iter.next().toString();
	}
}
