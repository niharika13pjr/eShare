package eshare.dao;

import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import eshare.model.food;
import eshare.util.DBHandle;

public class foodModuleViewbyOrderDAO {

	ArrayList<food> ls = null;
	String sql = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public ArrayList<food> viewbyOrder(String type){
		ls = new ArrayList<food>();
		
		//sql syntax
		sql = "select * from food where foodStatus = 1 and peopleNeeded > 0 and"
				+ " now()<expirydate order by "+type;
		
		conn = DBHandle.getDBHandle();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				food f = new food();
				f.setFoodID(Integer.parseInt(rs.getString("foodID")));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodPrice(Integer.parseInt(rs.getString("foodprice")));
				f.setPeopleNeeded(Integer.parseInt(rs.getString("peopleNeeded")));
				f.setPriceperPerson(Double.parseDouble(rs.getString("priceperPerson")));
				f.setFoodQuantity(rs.getString("foodQuantity"));
				f.setVenue(rs.getString("venue"));
				f.setTimeposted(formatter2.parse(rs.getString("timeposted")));
				f.setExpirydate(formatter1.parse(rs.getString("expirydate")));
				f.setPaymentType(rs.getString("paymentType"));
				f.setComments(rs.getString("comments"));
				f.setFoodStatus(Integer.parseInt(rs.getString("foodStatus")));
			
				ls.add(f);
			}
			
			
			
			
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
		
	}
}
