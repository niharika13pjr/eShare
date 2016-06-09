package eshare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;

import eshare.model.clothes;
import eshare.util.DBHandle;
import eshare.util.SendEmail;

public class clothesModuleFinalTransactionDAO {

	String viewSelectedCloth = null;
	String checkAvailable = null;
	String reduceCount = null;
	String currentClothcount = null;
	String changeClothStatus = null;
	String userEmail = null;
	String userID = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	clothes c = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public clothes viewSelectedClothes(int clothID) {
		// TODO Auto-generated method stub
		System.out.println("**** clothid ****"+clothID);
		viewSelectedCloth = "select * from cloth where clothid = '"+clothID
				+"'and clothstatus = 1";
		reduceCount = "update cloth set currentclothcount =currentclothcount-1 where clothID='"+clothID+"'";
		//conn
		conn = DBHandle.getDBHandle();
		
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(reduceCount);
			rs = stmt.executeQuery(viewSelectedCloth);
			
			while(rs.next()){
				c = new clothes();
				c.setClothID(Integer.parseInt(rs.getString("clothID")));
				c.setClothtype(rs.getString("clothtype"));
				c.setBrandname(rs.getString("brandname"));
				c.setShoplocation(rs.getString("shoplocation"));
				c.setComments(rs.getString("comments"));
				c.setCount(Integer.parseInt(rs.getString("currentclothCount")));
				c.setQuantity(Integer.parseInt(rs.getString("quantityshare")));
				c.setLink(rs.getString("link"));
				c.setClothstatus(Integer.parseInt(rs.getString("clothstatus")));
			}
			System.out.println(c.getClothID()+"asdfasd");
			System.out.println(c.getCount());
			if(c.getCount()<=0){
				changeClothStatus = "update cloth set clothstatus = 0 where clothid='"+clothID+"'";
				stmt.executeUpdate(changeClothStatus);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cloth from final"+c.getClothID());
		return c;
				
		
	}

	public void emailOriginalPoster(int clothID) {
		//sql syntax
				String userIDQuery = "select userID from cloth where clothid ='"+clothID+"'";
				

				
				//get connection 
						conn = DBHandle.getDBHandle();
						
						//prepare statement
						System.out.println(userIDQuery);
						
							try {
								stmt = conn.createStatement();
								rs = stmt.executeQuery(userIDQuery);
								
								while(rs.next()){
									userID = rs.getString("userID");
									System.out.println("userid: "+userID);
									
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
								
								 String content = "Dear: "+userID+". Someone is interested in your cloth " + clothID+
										 "Click the link to confirm: 		www.localhost:8080/EshareFinal/ClothesModuleConfirmationServlet?userID="+userID+"&ClothID="+clothID;
							     String subject = "Interested Notification...";
							     SendEmail.sendEmail("smtp.gmail.com", "587", "eshare666666@gmail.com", "eshare12345", userEmail, subject,
						                    content);
								
								
								
								
							} catch (SQLException | MessagingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
									
				
			}

}
