package com.riskAssessment.ProducerPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pilot_designation")
public class PilotDesignation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pilotDesignationCode;
	private String pilotDesignationName;

	public PilotDesignation() {
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

	public PilotDesignation(String pilotDesignationCode, String pilotDesignationName) {
		super();
		this.pilotDesignationCode = pilotDesignationCode;
		this.pilotDesignationName = pilotDesignationName;
	}

}
