package com.bway.inventorysystem.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bway.inventorysystem.model.Stock;

public interface StockDao {
	
	boolean addStock(Stock s);
	boolean deleteStock(int id);
	boolean updateStock(Stock s);
	List<Stock> getAllStock();
	public ArrayList<Stock> fetchData(Stock s);

	public Stock fetchDatas(String s);
	 public  int getQty(int id,Connection con);
}
