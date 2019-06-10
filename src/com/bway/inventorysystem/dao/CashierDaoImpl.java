package com.bway.inventorysystem.dao;

import com.bway.inventorysystem.db.DB;
import com.bway.inventorysystem.model.Cashier;
import com.bway.inventorysystem.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashierDaoImpl implements CashierDao{

	Connection con=null;
	public CashierDaoImpl()
	{
		con=(Connection) DB.getDBCon();
	}
	@Override
	public boolean addCashier(Cashier c) {
		// TODO Auto-generated method stub
		try {
			String sql="insert into cashier(cashierName,mobileNumber,address,emailId,password) values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, c.getCashierName());
			pst.setString(2, c.getMobileNumber());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getPassword());
			if(pst.executeUpdate()!=0)
			{
				return true;
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public boolean deleteCashier(int id) {
		// TODO Auto-generated method stub
		try
		{
			String sql="delete from cashier where cashierId="+id;
			Statement st=con.createStatement();
			if(st.executeUpdate(sql)!=0)
			{
				return true;
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public boolean updateCashier(Cashier c) {
		// TODO Auto-generated method stub
		try {
			String sql="update cashier set cashierName=?,mobileNumber=?,address=?,emailId=?,password=? where cashierId=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, c.getCashierName());
			pst.setString(2, c.getMobileNumber());
			pst.setString(3, c.getAddress());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getPassword());
			pst.setInt(6, c.getCashierId());
			if(pst.executeUpdate()!=0)
			{
				return true;
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}
	@Override
	public List<Cashier> getAllCashier() {
		// TODO Auto-generated method stub
		List<Cashier> clist=new ArrayList<>();
		try
		{
			String sql="select * from cashier";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Cashier c=new Cashier();
				c.setCashierName(rs.getString("cashierName"));
				c.setCashierId(rs.getInt("cashierId"));
				c.setAddress(rs.getString("address"));
				c.setMobileNumber(rs.getString("mobileNumber"));
				c.setEmail(rs.getString("emailId"));
				c.setPassword(rs.getString("password"));
				
				clist.add(c);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return clist;
	}
	
	
	@Override
	public boolean cashierLogin(Cashier ob) {
		// TODO Auto-generated method stubint status=-1;
        Connection con=null;
        
        try
        {
            con=DB.getDBCon();
            String sql="select * from cashier where emailId=? and password=? ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getEmail());
            pst.setString(2,ob.getPassword());
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                String  emailid=rs.getString("emailId");
                String username=rs.getString("password");
                return true;
                
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
		return false;
		
	}

}
