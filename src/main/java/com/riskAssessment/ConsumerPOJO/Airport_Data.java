package com.riskAssessment.ConsumerPOJO;

public class Airport_Data {
	int airportId;
	String airportName;
	long latitude;
	// long longitude;

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	// public long getLongitude() {
	// return longitude;
	// }
	//
	// public void setLongitude(long longitude) {
	// this.longitude = longitude;
	// }

	public Airport_Data() {
		super();
	}

	public Airport_Data(int airportId, String airportName, long latitude) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.latitude = latitude;
		// this.longitude = longitude;
	}
}
