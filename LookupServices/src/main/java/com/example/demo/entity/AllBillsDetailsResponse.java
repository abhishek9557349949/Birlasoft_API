package com.example.demo.entity;

import java.util.List;

public class AllBillsDetailsResponse {
	
	private String response;
	private List<BillDetails> billDetailList;
	
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<BillDetails> getBillDetailList() {
		return billDetailList;
	}
	public void setBillDetailList(List<BillDetails> billDetailList) {
		this.billDetailList = billDetailList;
	}
	
	
}
