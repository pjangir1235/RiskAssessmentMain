package com.riskAssessment.ConsumerPOJO;

public class CrewData {

	private int crewMemberId;
	private String crewMemberName;
	private long mobile;

	public int getCrewMemberId() {
		return crewMemberId;
	}

	public void setCrewMemberId(int crewMemberId) {
		this.crewMemberId = crewMemberId;
	}

	public String getCrewMemberName() {
		return crewMemberName;
	}

	public void setCrewMemberName(String crewMemberName) {
		this.crewMemberName = crewMemberName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public CrewData(int crewMemberId, String crewMemberName, long mobile) {
		super();
		this.crewMemberId = crewMemberId;
		this.crewMemberName = crewMemberName;
		this.mobile = mobile;
	}

	public CrewData() {
		super();
	}

}
