package com.risk.producerpojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rest_detail")
public class RestDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;
	private String date;
	private Integer restMinutes;

	public RestDetail() {
		super();
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getRestMinutes() {
		return restMinutes;
	}

	public void setRestMinutes(Integer restMinutes) {
		this.restMinutes = restMinutes;
	}



}
