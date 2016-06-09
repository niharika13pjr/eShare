package eshare.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import eshare.model.clothes;
import eshare.util.DBHandle;

public class clothesModuleViewbyOrderDAO {

	ArrayList<clothes> ls = null;
	String sql = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public ArrayList<clothes> viewbyOrder(String type){
		ls = new ArrayList<clothes>();
		
		//sql syntax
		sql = "select * from cloth where clothstatus = 1 and currentclothcount > 0 and now()<offervalidupto order by "+type;
		
		conn = DBHandle.getDBHandle();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				clothes c = new clothes();
				c.setClothID(Integer.parseInt(rs.getString("clothid")));
				c.setBrandname(rs.getString("brandname"));
				c.setComments(rs.getString("comments"));
				c.setLink(rs.getString("link"));
				c.setCount(Integer.parseInt(rs.getString("currentclothcount")));
				c.setClothtype(rs.getString("clothtype"));
				c.setShoplocation(rs.getString("shoplocation"));
				ls.add(c);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
}
