package com.example.demo.entity;

import java.sql.Date;

public class ProductItems {

	private String productName;
	private String description;
	private String category;
	private Double unitPrice;
	private Integer stockQuantity;
	private Date expirationDate;
	private Double discount;
	 
	 
	public ProductItems() {
		super();
	}
	
	public ProductItems(String productName, String description, String category, Double unitPrice,
			Integer stockQuantity, Date expirationDate, Double discount) {
		super();
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stockQuantity = stockQuantity;
		this.expirationDate = expirationDate;
		this.discount = discount;
	}

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	
}
