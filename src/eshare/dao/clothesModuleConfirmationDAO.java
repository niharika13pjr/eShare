package eshare.dao;

import java.sql.*;

import eshare.util.DBHandle;

public class clothesModuleConfirmationDAO {

	String sql = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void confirm(String userID,String clothID){
		
		//get connection
		conn = DBHandle.getDBHandle();
		sql = "insert into clothconfirmation (userID,clothID,status) values ("
				+ userID+","+clothID+","+1+")";
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
