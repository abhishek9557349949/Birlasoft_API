package com.example.demo.entity;

import java.util.List;

public class GetUserDataResponse {
	
	private String response;
	private List<UserData> userData;
	
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<UserData> getUserData() {
		return userData;
	}
	public void setUserData(List<UserData> userData) {
		this.userData = userData;
	}
	
}
