package com.risk.consumerpojo;

public class AircraftData {
	private int aircraftId;
	private String aircraftCode;
	private int aircraftType;

	public AircraftData() {
		super();
	}

	public AircraftData(int aircraftId, String aircraftCode, int aircraftType) {
		super();
		this.aircraftId = aircraftId;
		this.aircraftCode = aircraftCode;
		this.aircraftType = aircraftType;
	}

	public int getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(int aircraftType) {
		this.aircraftType = aircraftType;
	}

	public int getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(int aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

}
