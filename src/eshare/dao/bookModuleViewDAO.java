package eshare.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import eshare.model.books;
import eshare.util.DBHandle;
public class bookModuleViewDAO {
	String viewExistingPost = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList<books> ls = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public ArrayList<books> ViewExistingPost(){
		ls = new ArrayList<books>();

		//sql syntax
		viewExistingPost = "select * from book where booked = 0";
		
		//get connection
		conn = DBHandle.getDBHandle();
		
		//prepare statement
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(viewExistingPost);
			
			while(rs.next()){
				//assign all of the data from db, into food object
				books f = new books();
				f.setBookID(Integer.parseInt(rs.getString("bookID")));
				f.setBooktitle(rs.getString("booktitle"));
				f.setPublisher(rs.getString("publisher"));
				f.setAuthor(rs.getString("author"));
				f.setPurchasePrice(Integer.parseInt(rs.getString("purchasePrice")));
				
			//	f.setTimeposted(formatter2.parse(rs.getString("timeposted")));
				//f.setExpirydate(formatter1.parse(rs.getString("expirydate")));
				f.setPaymentType(rs.getString("paymentType"));
				f.setComments(rs.getString("comments"));
				f.setISBNnumber(rs.getString("iSBNnumber"));
				f.setRentedPrice(Double.parseDouble(rs.getString("rentedPrice")));
				f.setPurchasePrice(Double.parseDouble(rs.getString("purchasePrice")));
			
				ls.add(f);
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		
		
		return ls;
	}

}
