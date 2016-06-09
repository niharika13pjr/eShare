package eshare.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import eshare.model.clothes;
import eshare.util.DBHandle;

public class clothModuleViewDAO {

	String viewExistingPost = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	ArrayList<clothes> ls = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public ArrayList<clothes> ViewExistingPost(){
		ls = new ArrayList<clothes>();

		//sql syntax
		viewExistingPost = "select * from cloth where clothStatus = 1 and currentclothcount > 0 and now()<offerValidupto";
		
		//get connection
		conn = DBHandle.getDBHandle();
		
		//prepare statement
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(viewExistingPost);
			
			while(rs.next()){
				//assign all of the data from db, into food object
				clothes c = new clothes();
				c.setClothID(Integer.parseInt(rs.getString("clothid")));
				c.setClothtype(rs.getString("clothtype"));
				c.setBrandname(rs.getString("brandname"));
				c.setShoplocation(rs.getString("shoplocation"));
				c.setComments(rs.getString("comments"));
				c.setCount(Integer.parseInt(rs.getString("currentclothCount")));
				c.setExpirydate(formatter1.parse(rs.getString("offervalidupto")));
				c.setQuantity(Integer.parseInt(rs.getString("quantityshare")));
				c.setLink(rs.getString("link"));
				c.setClothstatus(Integer.parseInt(rs.getString("clothstatus")));
				ls.add(c);
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ls;
	}


}
