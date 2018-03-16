package com.risk.producerpojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pilot")
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pilotId;

	public Pilot() {
		super();
	}



	public Integer getPilotId() {
		return pilotId;
	}

	public void setPilotId(Integer pilotId) {
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

	private String pilotName;
	private String pilotDesignationCode;
	@Override
	public String toString() {
		return getPilotName();
	}
}
