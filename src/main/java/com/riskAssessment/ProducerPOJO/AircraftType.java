package com.riskAssessment.ProducerPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aircraft_type_detail")
public class AircraftType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aircraftTypeId;
	private String aircraftType;

	public AircraftType() {
		super();
	}

	public AircraftType(Integer aircraftTypeId, String aircraftType) {
		super();
		aircraftTypeId = aircraftTypeId;
		this.aircraftType = aircraftType;
	}

	public Integer getAircraftTypeId() {
		return aircraftTypeId;
	}

	public void setAircraftTypeId(Integer aircraftTypeId) {
		this.aircraftTypeId = aircraftTypeId;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

}
