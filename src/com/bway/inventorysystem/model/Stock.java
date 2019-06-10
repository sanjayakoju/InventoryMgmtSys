package com.bway.inventorysystem.model;

public class Stock {
	
	private int stockId;
	private String productName;
	private int quantityAvailable;
	private int quantityAdded;
	private int mrp;
	
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public int getQuantityAdded() {
		return quantityAdded;
	}
	public void setQuantityAdded(int quantityAdded) {
		this.quantityAdded = quantityAdded;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	
	
	

}
