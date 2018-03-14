package com.risk.consumerpojo;

public class PilotDesignationData {

	private String pilotDesignationCode;
	private String pilotDesignationName;

	public PilotDesignationData() {
		super();
	}

	public String getPilotDesignationCode() {
		return pilotDesignationCode;
	}

	public void setPilotDesignationCode(String pilotDesignationCode) {
		this.pilotDesignationCode = pilotDesignationCode;
	}

	public String getPilotDesignationName() {
		return pilotDesignationName;
	}

	public void setPilotDesignationName(String pilotDesignationName) {
		this.pilotDesignationName = pilotDesignationName;
	}

	public PilotDesignationData(String pilotDesignationCode, String pilotDesignationName) {
		super();
		this.pilotDesignationCode = pilotDesignationCode;
		this.pilotDesignationName = pilotDesignationName;
	}

}
