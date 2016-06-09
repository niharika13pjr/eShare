package eshare.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import eshare.model.books;

import eshare.util.DBHandle;
public class bookModulePostDAO {
	Connection conn = null;
	String insertNewPost = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void InsertNewPost(books f){
		
		insertNewPost = "insert into book (booktitle,author,publisher,additionVolume,booked,rentedPrice,purchasePrice,comments,paymentType,ISBNnumber,userID) values ('"+f.getBooktitle()+"','"+f.getAuthor()+"','"+f.getPublisher()+"','"+f.getAdditionVolume()+"','"+f.isBooked()+"','"+f.getRentedPrice()+"','"+f.getPurchasePrice()+"','"+f.getComments()+"','"+f.getPaymentType()+"','"+f.getISBNnumber()+"','"+f.getUserID()+"')";
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
