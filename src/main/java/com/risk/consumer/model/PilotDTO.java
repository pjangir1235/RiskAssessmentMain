package com.risk.consumer.model;

public class PilotDTO {
	private int pilotId;
	private String pilotName;
	private String pilotDesignationCode;

	public PilotDTO() {
		super();
	}

	public PilotDTO(int pilotId, String pilotName, String pilotDesignationCode) {
		super();
		this.pilotId = pilotId;
		this.pilotName = pilotName;
		this.pilotDesignationCode = pilotDesignationCode;
	}

	public String getPilotDesignationCode() {
		return pilotDesignationCode;
	}

	public int getPilotId() {
		return pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotDesignationCode(String pilotDesignationCode) {
		this.pilotDesignationCode = pilotDesignationCode;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

}
