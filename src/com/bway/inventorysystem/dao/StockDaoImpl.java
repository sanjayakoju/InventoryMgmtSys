package com.bway.inventorysystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.bway.inventorysystem.db.DB;
import com.bway.inventorysystem.model.Stock;
import java.sql.*;

public class StockDaoImpl implements  StockDao{

	Connection con=null;
	public StockDaoImpl()
	{
		
		con=DB.getDBCon();
	}
	
	public boolean addStock(Stock s) {
		// TODO Auto-generated method stub
		try
		{
			String sql="insert into stock(productName,quantityAdded,mrp) value (?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getProductName());
			//pst.setInt(2, s.getQuantityAvailable());
			pst.setInt(2, s.getQuantityAdded());
			pst.setDouble(3, s.getMrp());
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
	public boolean deleteStock(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStock(Stock s) {
		
		
		try
		{
			String sql="update stock set productName=?,quantityAvailable=?,quantityAdded=?,mrp=? where stockId=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, s.getProductName());
			pst.setInt(2, s.getQuantityAvailable());
			pst.setInt(3, s.getQuantityAdded());
			pst.setDouble(4, s.getMrp());
			pst.setInt(5, s.getStockId());
			if(pst.executeUpdate()!=0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		
		List<Stock> slist=new ArrayList<>();
		String sql="select * from stock";
		try
		{	
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Stock s=new Stock();
				s.setStockId(rs.getInt("stockId"));
				s.setProductName(rs.getString("productName"));
				s.setQuantityAdded(rs.getInt("quantityAdded"));
				s.setQuantityAvailable(rs.getInt("quantityAvailable"));
				s.setMrp(rs.getInt("mrp"));
				
				slist.add(s);
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return slist;
	}

	public ArrayList<Stock> fetchData(Stock s) {
		// TODO Auto-generated method stub
		 ArrayList<Stock> list=new ArrayList();
	        
	        try
	        {
	           
	            String name=s.getProductName();
	            String sql="select * from stock where productName like ?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1, "%"+name+"%");
	            ResultSet rs=pst.executeQuery();
	            while(rs.next())
	            {
	                
	                Stock ob=new Stock();
	                ob.setStockId(rs.getInt("stockId"));
	                ob.setProductName(rs.getString("productName"));
	                ob.setMrp(rs.getInt("mrp"));
	                ob.setQuantityAdded(rs.getInt("quantityAdded"));
	                ob.setQuantityAvailable(rs.getInt("quantityAvailable"));
	                
	                list.add(ob);
	            }
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
		
		return list;
	}

	
	public Stock fetchDatas(String s) {
		// TODO Auto-generated method stub
		
	        
	        try
	        {
	           
	            String name=s;
	            String sql="select * from stock where productName like ?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1, "%"+name+"%");
	            ResultSet rs=pst.executeQuery();
	            while(rs.next())
	            {
	                
	                Stock ob=new Stock();
	                ob.setStockId(rs.getInt("stockId"));
	                ob.setProductName(rs.getString("productName"));
	                ob.setMrp(rs.getInt("mrp"));
	                ob.setQuantityAdded(rs.getInt("quantityAdded"));
	                ob.setQuantityAvailable(rs.getInt("quantityAvailable"));
	                
	                return ob;
	            }
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
		
		return null;
	}

	@Override
	public int getQty(int id, Connection con) {
		// TODO Auto-generated method stub
		 int qty=0;
	        try
	        {
	            
	            String sql="select * from stock where stockId=?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setInt(1,id);
	            ResultSet rs=pst.executeQuery();
	            
	            while(rs.next())
	            {
	                qty=rs.getInt("quantityAvailable");
	            }
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
	        
	        return qty;
	}

	 public void updateQty(int id,int newQty,Connection con)
	    {
	        
	        try
	        {
	            
	            String sql="update stock set quantityAvailable=? where stockId=?";
	            PreparedStatement pst=con.prepareStatement(sql);
	            pst.setInt(1,newQty);
	            pst.setInt(2,id);
	            pst.execute();
	            
	            
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
	        
	        
	    }
	
}
