package com.riskAssessment.ConsumerPOJO;

public class AircraftTypeData {
	private int aircraftTypeId;
	private String aircraftType;

	public AircraftTypeData() {
		super();
	}

	public AircraftTypeData(int aircraftTypeId, String aircraftType) {
		super();
		this.aircraftTypeId = aircraftTypeId;
		this.aircraftType = aircraftType;
	}

	public int getAircraftTypeId() {
		return aircraftTypeId;
	}

	public void setAircraftTypeId(int aircraftTypeId) {
		this.aircraftTypeId = aircraftTypeId;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

}
