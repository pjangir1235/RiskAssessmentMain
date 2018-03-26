package com.risk.producer.model;

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

	public Aircraft() {
		super();
	}

	public String getAircraftCode() {
		return aircraftCode;
	}

	public Integer getAircraftId() {
		return aircraftId;
	}

	public Integer getAircraftType() {
		return aircraftType;
	}

	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}

	public void setAircraftId(Integer aircraftId) {
		this.aircraftId = aircraftId;
	}

	public void setAircraftType(Integer aircraftType) {
		this.aircraftType = aircraftType;
	}

}
