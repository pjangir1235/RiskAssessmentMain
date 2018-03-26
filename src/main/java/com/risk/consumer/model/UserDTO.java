package com.risk.consumer.model;

public class UserDTO {

	private int userId;

	private String userName;
	private String password;

	public UserDTO() {
		super();
	}

	public UserDTO(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
