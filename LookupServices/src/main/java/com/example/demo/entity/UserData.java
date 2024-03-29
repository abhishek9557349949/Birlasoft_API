package com.example.demo.entity;

import com.example.demo.constants.LookupConstants;

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
			if(role.equalsIgnoreCase(LookupConstants.ACCOUNTANT_ROLE_CODE))
				this.role = LookupConstants.ACCOUNTANT_ROLE_STRING;
			if(role.equalsIgnoreCase(LookupConstants.EXC_ROLE_CODE))
				this.role = LookupConstants.EXC_ROLE_STRING;
			if(role.equalsIgnoreCase(LookupConstants.MANAGER_ROLE_CODE))
				this.role = LookupConstants.MANAGER_ROLE_STRING;
			if(role.equalsIgnoreCase(LookupConstants.OWNER_ROLE_CODE))
				this.role = LookupConstants.OWNER_ROLE_STRING;
		}
	}
	
	
}
