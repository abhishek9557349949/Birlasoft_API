package com.example.demo.entity;

import com.example.demo.constants.RequestConstants;

public class UserData {
	
	private String userName;
	private String mailId;
	private String employeeName;
	private String accountStatus;
	private String buisnessName;
	private String role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getBuisnessName() {
		return buisnessName;
	}
	public void setBuisnessName(String buisnessName) {
		this.buisnessName = buisnessName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		if(role != null) {
			if(role.equalsIgnoreCase(RequestConstants.ACCOUNTANT_ROLE_CODE))
				this.role = RequestConstants.ACCOUNTANT_ROLE_STRING;
			if(role.equalsIgnoreCase(RequestConstants.EXC_ROLE_CODE))
				this.role = RequestConstants.EXC_ROLE_STRING;
			if(role.equalsIgnoreCase(RequestConstants.MANAGER_ROLE_CODE))
				this.role = RequestConstants.MANAGER_ROLE_STRING;
			if(role.equalsIgnoreCase(RequestConstants.OWNER_ROLE_CODE))
				this.role = RequestConstants.OWNER_ROLE_STRING;
		}
	}
	
	
}
