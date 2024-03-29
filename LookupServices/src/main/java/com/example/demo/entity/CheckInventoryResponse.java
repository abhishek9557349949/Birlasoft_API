package com.example.demo.entity;

import java.util.List;

public class CheckInventoryResponse {

	private String respose;
	private List<InventoryDetails> inventoryDetails;
	
	
	public String getRespose() {
		return respose;
	}
	public void setRespose(String respose) {
		this.respose = respose;
	}
	public List<InventoryDetails> getInventoryDetails() {
		return inventoryDetails;
	}
	public void setInventoryDetails(List<InventoryDetails> inventoryDetails) {
		this.inventoryDetails = inventoryDetails;
	}

	
	
}
