package com.risk.pojo;

public class ScheduleRequestData {
	private String location;
	 private String date;
	public ScheduleRequestData() {
		super();
	}
	public ScheduleRequestData(String location, String date) {
		super();
		this.location = location;
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
