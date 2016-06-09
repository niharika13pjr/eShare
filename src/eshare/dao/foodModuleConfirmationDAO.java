package eshare.dao;

import java.sql.*;

import eshare.util.DBHandle;

public class foodModuleConfirmationDAO {

	String sql = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void confirm(String userID,String foodID){
		
		//get connection
		conn = DBHandle.getDBHandle();
		sql = "insert into foodconfirmation (userID,foodID,status) values ("
				+ userID+","+foodID+","+1+")";
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
