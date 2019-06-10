package com.bway.inventorysystem.model;

import java.sql.Date;

public class Sale {
	
	
	    private int saleId;
	    private String customerName ;
	    private String productName ;
	    private int quantity;
	    private int mrp ;
	    private double total;
	    private String date;
	    private int stockId;
		public int getSaleId() {
			return saleId;
		}
		public void setSaleId(int saleId) {
			this.saleId = saleId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getMrp() {
			return mrp;
		}
		public void setMrp(int mrp) {
			this.mrp = mrp;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getStockId() {
			return stockId;
		}
		public void setStockId(int stockId) {
			this.stockId = stockId;
		}
		
	    
	    
	    
	   
}
