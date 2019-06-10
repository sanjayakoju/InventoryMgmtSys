package com.bway.inventorysystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.bway.inventorysystem.db.DB;
import com.bway.inventorysystem.model.Sale;
import com.bway.inventorysystem.model.Stock;
import com.mysql.jdbc.Connection;

public class SaleDaoImpl implements SaleDao{

	Connection con=null;
	public SaleDaoImpl()
	{
		con=(Connection) DB.getDBCon();
	}
	
	
	public void addSale(List<Sale> slist) {
		
		try
		{
			con.setAutoCommit(false);
			for(int i=0;i<slist.size();i++)
			{
				 
				int qt=slist.get(i).getQuantity();
				StockDaoImpl sdao=new StockDaoImpl();
				System.out.println(slist.get(i).getStockId());
				int qty=sdao.getQty(slist.get(i).getStockId(),con);
				System.out.println(qt);
				System.out.println(qty);
				if(qty>=qt)
				{
					int newQty=qty-slist.get(i).getQuantity();
                    sdao.updateQty(slist.get(i).getStockId(), newQty,con);
                    
                    String sql="insert into sale(customerName,productName,date,quantity,mrp,total,stockId) values(?,?,?,?,?,?,?)";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1, slist.get(i).getCustomerName());
                    pst.setString(2,slist.get(i).getProductName());
                    pst.setString(3,slist.get(i).getDate());
                    pst.setInt(4,slist.get(i).getQuantity());
                    pst.setInt(5,slist.get(i).getMrp());
                    pst.setDouble(6,slist.get(i).getTotal());
                    pst.setInt(7,slist.get(i).getStockId());
                    
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Record Saved Successfully.");
	               }
	               else
	               {
	                   JOptionPane.showMessageDialog(null,"Qunatity not Sufficient.");
	               }
	               con.commit();
				}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}

	@Override
	public boolean deleteSale(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSale(Sale s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Sale> getAllSale() {
		List<Sale> slist=new ArrayList<>();
		String sql="select * from sale";
		try
		{	
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Sale s=new Sale();
				s.setSaleId(rs.getInt("saleId"));
				s.setProductName(rs.getString("productName"));
				s.setCustomerName(rs.getString("customerName"));
				s.setQuantity(rs.getInt("quantity"));
				s.setMrp(rs.getInt("mrp"));
				s.setDate(rs.getString("date"));
				s.setTotal(rs.getDouble("total"));
				slist.add(s);
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return slist;
		
	}

	@Override
	public ArrayList<Sale> fetchData(Sale s) {

		List<Sale> slist=new ArrayList<>();
		try
		{
			int saleId=s.getSaleId();
			String sql="select * from sale where saleId=? ";
			PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, saleId);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                
                Sale ob=new Sale();
                ob.setSaleId(rs.getInt("saleId"));
                ob.setCustomerName(rs.getString("customerName"));
                ob.setProductName(rs.getString("productName"));
                ob.setTotal(rs.getDouble("total"));
                ob.setDate(rs.getString("date"));
                
                slist.add(ob);
            }
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return (ArrayList<Sale>) slist;
	}

	

}
