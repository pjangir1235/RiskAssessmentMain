package com.risk.consumerpojo;

public class PilotData {
	private int pilotId;
	private String pilotName;
	private String pilotDesignationCode;

	public PilotData() {
		super();
	}

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getPilotDesignationCode() {
		return pilotDesignationCode;
	}

	public void setPilotDesignationCode(String pilotDesignationCode) {
		this.pilotDesignationCode = pilotDesignationCode;
	}

	public PilotData(int pilotId, String pilotName, String pilotDesignationCode) {
		super();
		this.pilotId = pilotId;
		this.pilotName = pilotName;
		this.pilotDesignationCode = pilotDesignationCode;
	}

}
