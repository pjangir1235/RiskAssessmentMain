package com.riskAssessment.ProducerPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aircraft")
public class Aircraft {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aircraftId;
	private String aircraftCode;
	private Integer aircraftType;

	public Aircraft(Integer aircraftId, String aircraftCode, Integer aircraftType) {
		super();
		this.aircraftId = aircraftId;
		this.aircraftCode = aircraftCode;
		this.aircraftType = aircraftType;
	}

	public Aircraft() {
		super();
	}

	public Integer getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(Integer aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

	public Integer getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(Integer aircraftType) {
		this.aircraftType = aircraftType;
	}

}
