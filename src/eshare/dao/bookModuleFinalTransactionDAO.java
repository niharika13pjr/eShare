package eshare.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;

import eshare.model.books;

import eshare.util.DBHandle;
import eshare.util.SendEmail;
public class bookModuleFinalTransactionDAO {
	String viewSelectedbook = null;
	String checkAvailable = null;
	String reduceCount = null;
	String currentClothcount = null;
	String changeClothStatus = null;
	String userEmail = null;
	String userID = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public books viewSelectedbook(int bookID) {
		// TODO Auto-generated method stub
		System.out.println("**** bookID ****"+bookID);
		viewSelectedbook = "select * from book where bookID = '"+bookID+"'";
		reduceCount = "update book set rentedPrice =rentedPrice-1 where bookid='"+bookID+"'";
		
		conn = DBHandle.getDBHandle();
		
		books f = null;
		try {
			stmt = conn.createStatement();
			//stmt.executeUpdate(reduceCount);
			rs = stmt.executeQuery(viewSelectedbook);
			
			while(rs.next()){
				f = new books();
				f.setBookID(Integer.parseInt(rs.getString("bookID")));
				f.setBooktitle(rs.getString("booktitle"));
				f.setPublisher(rs.getString("publisher"));
				f.setAuthor(rs.getString("author"));
				f.setPurchasePrice(Integer.parseInt(rs.getString("purchasePrice")));
				
				f.setPaymentType(rs.getString("paymentType"));
				f.setComments(rs.getString("comments"));
				f.setISBNnumber(rs.getString("iSBNnumber"));
				f.setRentedPrice(Double.parseDouble(rs.getString("rentedPrice")));
				f.setPurchasePrice(Double.parseDouble(rs.getString("purchasePrice")));
			
				
			}
			//System.out.println(f.getClothID()+"asdfasd");
			//System.out.println(c.getCount());
		//	if(f.getCount()<=0){
			//	changeClothStatus = "update cloth set clothstatus = 0 where clothid='"+clothID+"'";
			//	stmt.executeUpdate(changeClothStatus);
			//}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("cloth from final"+c.getClothID());
		return f;
				
		
	}

	public void emailOriginalPoster(int bookID) {
		//sql syntax
				String userIDQuery = "select userID from book where bookID ='"+bookID+"'";
				
System.out.println(bookID);
				
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
								
								 String content = "Dear: "+userID+". Someone is interested in your book" + bookID+
										 "Click the link to confirm: 		www.localhost:8080/EshareFinal/BookModuleConfirmationServlet?userID="+userID+"&bookID="+bookID;
							     String subject = "Interested Notification...";
							     SendEmail.sendEmail("smtp.gmail.com", "587", "eshare2016@gmail.com", "eshare12345", userEmail, subject,
						                    content);
								
								
								
								
							} catch (SQLException | MessagingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
									
				
			}

}
