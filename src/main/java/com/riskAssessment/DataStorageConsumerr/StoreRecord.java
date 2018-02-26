package com.riskAssessment.DataStorageConsumerr;

import java.util.ArrayList;
import java.util.List;

import com.riskAssessment.ConsumerPOJO.Airport_Data;

public class StoreRecord {

	private List<Airport_Data> airport = new ArrayList<>();
	private int airportCount = 0;

	public void setAirportCount(int airportCount) {

		this.airportCount = airportCount;

	}

	public List<Airport_Data> getAirport() {
		return airport;
	}

	public void setAirportObj(Airport_Data airport) {
		this.airport.add(airport);
	}

	public int getAirportCount() {
		return airportCount;

	}

	public void destroy() {
		airport = new ArrayList<>();
	}
}
