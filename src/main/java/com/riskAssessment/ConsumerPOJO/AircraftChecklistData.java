package com.riskAssessment.ConsumerPOJO;

public class AircraftChecklistData {
	private int checklistId;
	private String aircraftCode;
	private String date;
	private boolean autoPilot;
	private boolean stormScope;
	private boolean weatherRadar;
	private boolean deIce;

	public AircraftChecklistData() {
		super();
	}

	public AircraftChecklistData(int checklistId, String aircraftCode, String date, boolean autoPilot,
			boolean stormScope, boolean weatherRadar, boolean deIce) {
		super();
		this.checklistId = checklistId;
		this.aircraftCode = aircraftCode;
		this.date = date;
		this.autoPilot = autoPilot;
		this.stormScope = stormScope;
		this.weatherRadar = weatherRadar;
		this.deIce = deIce;
	}

	public int getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(int checklistId) {
		this.checklistId = checklistId;
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isAutoPilot() {
		return autoPilot;
	}

	public void setAutoPilot(boolean autoPilot) {
		this.autoPilot = autoPilot;
	}

	public boolean isStormScope() {
		return stormScope;
	}

	public void setStormScope(boolean stormScope) {
		this.stormScope = stormScope;
	}

	public boolean isWeatherRadar() {
		return weatherRadar;
	}

	public void setWeatherRadar(boolean weatherRadar) {
		this.weatherRadar = weatherRadar;
	}

	public boolean isDeIce() {
		return deIce;
	}

	public void setDeIce(boolean deIce) {
		this.deIce = deIce;
	}

}
