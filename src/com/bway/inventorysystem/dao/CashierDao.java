package com.bway.inventorysystem.dao;

import java.util.List;

import com.bway.inventorysystem.model.Cashier;
import com.bway.inventorysystem.model.User;


public interface CashierDao {
	
	boolean addCashier(Cashier c);
	boolean deleteCashier(int id);
	boolean updateCashier(Cashier c);
	List<Cashier> getAllCashier();
	boolean cashierLogin(Cashier ob);
	

}
