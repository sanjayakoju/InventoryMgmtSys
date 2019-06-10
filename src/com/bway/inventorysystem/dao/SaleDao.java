package com.bway.inventorysystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.bway.inventorysystem.model.Sale;

public interface SaleDao {
	
	public void addSale(List<Sale> slist);
	boolean deleteSale(int id);
	boolean updateSale(Sale s);
	public List<Sale> getAllSale();
	public ArrayList<Sale> fetchData(Sale s);

}
