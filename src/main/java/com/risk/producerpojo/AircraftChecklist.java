package com.risk.producerpojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aircraft_checklist")
public class AircraftChecklist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer checklistId;
	private String aircraftCode;
	private String date;
	private Boolean autoPilot;
	private Boolean stormScope;
	private Boolean weatherRadar;
	private Boolean deIce;

	public AircraftChecklist() {
		super();
	}

	public AircraftChecklist(Integer checklistId, String aircraftCode, String date, Boolean autoPilot,
			Boolean stormScope, Boolean weatherRadar, Boolean deIce) {
		super();
		this.checklistId = checklistId;
		this.aircraftCode = aircraftCode;
		this.date = date;
		this.autoPilot = autoPilot;
		this.stormScope = stormScope;
		this.weatherRadar = weatherRadar;
		this.deIce = deIce;
	}

	public Integer getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(Integer checklistId) {
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

	public Boolean getAutoPilot() {
		return autoPilot;
	}

	public void setAutoPilot(Boolean autoPilot) {
		this.autoPilot = autoPilot;
	}

	public Boolean getStormScope() {
		return stormScope;
	}

	public void setStormScope(Boolean stormScope) {
		this.stormScope = stormScope;
	}

	public Boolean getWeatherRadar() {
		return weatherRadar;
	}

	public void setWeatherRadar(Boolean weatherRadar) {
		this.weatherRadar = weatherRadar;
	}

	public Boolean getDeIce() {
		return deIce;
	}

	public void setDeIce(Boolean deIce) {
		this.deIce = deIce;
	}
}
