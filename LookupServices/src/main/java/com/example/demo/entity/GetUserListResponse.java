package com.example.demo.entity;

import java.util.List;

public class GetUserListResponse {
	
	private String response;
	private List<String> userNames;
	
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<String> getUserNames() {
		return userNames;
	}
	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}

	
}
