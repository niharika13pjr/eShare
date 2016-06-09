package eshare.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.clothesModulePostDAO;
import eshare.model.clothes;

public class ClothesModulePostServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6129297004218200910L;

	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//declare clothes DAO object
	clothesModulePostDAO clothesdb;
	
	public void init(){
		//Initialize the DAO object
		clothesdb = new clothesModulePostDAO();
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//set the clothes model;
		
		clothes c = new clothes();
		
		c.setClothtype(request.getParameter("clothtype"));
		c.setBrandname(request.getParameter("clothbrand"));
		c.setShoplocation(request.getParameter("location"));
		c.setComments(request.getParameter("comments"));
		c.setCount(Integer.parseInt(request.getParameter("clothescount")));
		try {
			c.setStartdate(formatter1.parse(handle(request.getParameter("startdate"))));
			c.setExpirydate(formatter1.parse(handle(request.getParameter("expirydate"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		c.setLink(request.getParameter("link"));
		c.setUserid(Integer.parseInt(request.getSession().getAttribute("UserID").toString()));
		c.setClothstatus(1);
		
		//insert into database eshare cloth databse
		clothesdb.InsertNewPost(c);
		
		//redirect to the view clothes
		request.getRequestDispatcher("/ClothesModuleViewServlet").forward(request, response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	//get the dateTime format : HH:MM:SS
		public static Date getdateTime() {
			
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			return timestamp;
		}
		
		//get the data format : YYYY-MM-DD
		public static Date getDate(){
			
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			return timestamp;
		}
		//handle the string
		public static String handle(String str){
			str = str.replace("T", " ");
			str = str.concat(":00");
			System.out.println("Inside the handle"+str);
			
			return str;
			
		}

}
