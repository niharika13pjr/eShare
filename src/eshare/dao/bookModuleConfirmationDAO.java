package eshare.dao;

import java.sql.*;

import eshare.util.DBHandle;

public class bookModuleConfirmationDAO {

	public void confirm(String userID, String bookID) {
		// TODO Auto-generated method stub
		String sql = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
			
			//get connection
			conn = DBHandle.getDBHandle();
			sql = "insert into bookconfirmation (userID,bookID,booked) values ("
					+ userID+","+bookID+","+1+")";
			
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}



