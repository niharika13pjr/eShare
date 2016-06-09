package eshare.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import eshare.model.clothes;
import eshare.util.DBHandle;

public class clothesModulePostDAO {
	
	Connection conn = null;
	String insertNewPost = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void InsertNewPost(clothes c){
		
		insertNewPost = "insert into cloth (clothType,brandName,shoplocation,comments,currentclothCount,offerStartDate,offerValidUpto,quantityShare,link,userID,clothstatus) values"
				+ "('"+c.getClothtype() +"','"+c.getBrandname()+"','"+c.getShoplocation()+"','"+c.getComments()+"','"+c.getCount()+"','"
						+formatter1.format(c.getStartdate())+"','"+formatter1.format(c.getExpirydate())+"','"+c.getQuantity()+"','"+c.getLink()
						+"','"+c.getUserid()+"','"+c.getClothstatus()+"')";
	
		//get connection
		conn = DBHandle.getDBHandle();
		System.out.println(insertNewPost);
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(insertNewPost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
	
	
	}

}
