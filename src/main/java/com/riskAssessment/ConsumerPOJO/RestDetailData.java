package com.riskAssessment.ConsumerPOJO;

public class RestDetailData {
	private int memberId;
	private String date;
	private int restMinutes;

	public RestDetailData() {
		super();
	}

	public RestDetailData(int memberId, String date, int restMinutes) {
		super();
		this.memberId = memberId;
		this.date = date;
		this.restMinutes = restMinutes;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRestMinutes() {
		return restMinutes;
	}

	public void setRestMinutes(int restMinutes) {
		this.restMinutes = restMinutes;
	}

}
