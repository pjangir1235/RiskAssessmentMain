package com.riskAssessment.ProducerPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport_location")
public class AirportLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer airportId;

	private String airportName;
	private Long latitude;
	// private Long longitude;

	public Integer getAirportId() {
		return airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	// public Long getLongitude() {
	// return longitude;
	// }
	//
	// public void setLongitude(Long longitude) {
	// this.longitude = longitude;
	// }

	public AirportLocation(Integer airportId, String airportName, Long latitude) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.latitude = latitude;
		// this.longitude = longitude;
	}

	public AirportLocation() {
		super();
	}
}
