package eshare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import eshare.model.food;
import eshare.util.DBHandle;;

public class foodModulePostDAO {
	
	Connection conn = null;
	String insertNewPost = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void InsertNewPost(food f){
		
		insertNewPost = "insert into food (foodType,foodPrice,peopleNeeded,currentfoodCount,priceperPerson"
					+ ",foodQuantity,venue,timeposted,expirydate,paymentType,comments,foodStatus,userID) values ('"
					+ f.getFoodType()+"','"+f.getFoodPrice()+"','"+f.getPeopleNeeded()+"','"+f.getCurrentfoodCount()+"','"+f.getPriceperPerson()+"','"
					+f.getFoodQuantity()+"','"+f.getVenue()+"','"+f.getTimeposted()+"','"+formatter1.format(f.getExpirydate())+"','"+f.getPaymentType()+"','"
					+f.getComments()+"','"+f.getFoodStatus()+"','"+f.getUserID()+"')";
		//get connection
		conn = DBHandle.getDBHandle();
		
		try {
			//prepare statement
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(insertNewPost);
			ResultSet rs = null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
