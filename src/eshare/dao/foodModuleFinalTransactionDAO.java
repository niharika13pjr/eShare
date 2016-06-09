package eshare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;

import eshare.util.*;
import eshare.model.food;

public class foodModuleFinalTransactionDAO {

	String viewSelectedFood = null;
	String checkAvailable = null;
	String reducePeople = null;
	String currentfoodcount = null;
	String changeFoodStatus = null;
	String userEmail = null;
	String userID = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	food f = null;
	int peopleNeeded = 0;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public food viewSelectedFood(int foodID){
		
		//sql syntax
		viewSelectedFood = "select * from food where foodID = '"+foodID+"' and foodStatus = 1";
		reducePeople = "update food set peopleNeeded = peopleNeeded - 1 where foodID = '"+foodID+"'";
		currentfoodcount = "update food set currentfoodCount = currentfoodCount + 1 where foodID ='"+foodID+"'";
		//get connection 
		conn = DBHandle.getDBHandle();
		
		//prepare statement
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(reducePeople);
			stmt.executeUpdate(currentfoodcount);
			rs = stmt.executeQuery(viewSelectedFood);
			
			while(rs.next()){
				f = new food();
				f.setFoodType(rs.getString("foodType"));
				f.setFoodPrice(Integer.parseInt(rs.getString("foodPrice")));
				f.setPeopleNeeded(Integer.parseInt(rs.getString("peopleNeeded")));		
				f.setPriceperPerson(Double.parseDouble(rs.getString("priceperPerson")));
				f.setFoodQuantity(rs.getString("foodQuantity"));
				f.setVenue(rs.getString("venue"));
				f.setTimeposted((formatter2.parse(rs.getString("timeposted"))));
				f.setExpirydate((formatter1.parse(rs.getString("expirydate"))));
				f.setPaymentType(rs.getString("paymentType"));
				f.setComments(rs.getString("comments"));
				f.setFoodStatus(Integer.parseInt(rs.getString("foodStatus")));
			}
			
			if(f.getPeopleNeeded() <= 0)
			{
				changeFoodStatus = "update food set foodStatus = 0 where foodID = '"+foodID+"'";
				stmt.executeUpdate(changeFoodStatus);
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return f;
	}
	
	public String emailOriginalPoster(int foodID){
		//sql syntax
		String userIDQuery = "select userID from food where foodID ='"+foodID+"'";
		

		
		//get connection 
				conn = DBHandle.getDBHandle();
				
				//prepare statement
				
				
					try {
						stmt = conn.createStatement();
						rs = stmt.executeQuery(userIDQuery);
						while(rs.next()){
							userID = rs.getString("userID");
						}
						String userEmailQuery = "select email from Registration where userid = '"+userID+"'";
						rs = stmt.executeQuery(userEmailQuery);
					
						while(rs.next()){
							userEmail = rs.getString("email");

							System.out.println("useremail : "+ userEmail);
						}
						
						/**
						 * now, we have to send email to notice to the original user who posted 
						 * the food...
						 * 
						 * */	
						
						 String content = "Dear: "+userID+". Someone is interested in your food " + foodID+
								 "Click the link to confirm: 		www.localhost:8080/EshareFinal/FoodModuleConfirmationServlet?userID="+userID+"&foodID="+foodID;
					     String subject = "Interested Notification...";
					     SendEmail.sendEmail("smtp.gmail.com", "587", "eshare2016@gmail.com", "eshare12345", userEmail, subject,
				                    content);
						
						
						
						
					} catch (SQLException | MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
		
		return null;
	}
	

}
