package com.bway.inventorysystem.dao;

import com.bway.inventorysystem.db.DB;

import com.bway.inventorysystem.model.User;
import java.sql.*;

import javax.swing.JOptionPane;

public class UserController {
	
	
	
	public void registerUser(User u)
	{
		Connection con = null;
		con=DB.getDBCon();
		
		try
		{
			String sql="insert into user (firstName,lastName,username,password,retypePass,birthDate,address) value (?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getFirstName());
			pst.setString(2, u.getLastName());
			pst.setString(3, u.getUsername());
			pst.setString(4, u.getPassword());
			pst.setString(5,u.getRetypePass());
			pst.setDate(6, u.getBirthDate());
			pst.setString(7, u.getAddress());
			pst.execute();
			JOptionPane.showMessageDialog(null,"User register successfully");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public int userLogin(User ob)
    {
        int status=-1;
        Connection con = null;
    	con=DB.getDBCon();
        
        try
        {
            
            String sql="select * from user where username=? and password=? ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getUsername());
            pst.setString(2,ob.getPassword());
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                int id=rs.getInt("userId");
                String username=rs.getString("username");
                status=rs.getInt("status");
                
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        return status;

}
}
