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

import eshare.dao.foodModulePostDAO;
import eshare.model.food;

public class FoodModulePostServlet extends HttpServlet{
	
	//declare food DAO object
	foodModulePostDAO fooddb;
	
	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void init(){
		//initialize the DAO object
		fooddb = new foodModulePostDAO();
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//set the food model
				food f = new food();
				f.setFoodType(request.getParameter("foodType"));
				f.setFoodPrice(Double.parseDouble(request.getParameter("foodPrice")));
				f.setPeopleNeeded(Integer.parseInt(request.getParameter("peopleNeeded")));
				f.setPriceperPerson(f.getFoodPrice()/f.getPeopleNeeded());
				f.setFoodQuantity(request.getParameter("foodQuantity"));
				f.setVenue(request.getParameter("venue"));
				f.setTimeposted(FoodModulePostServlet.getdateTime());
				System.out.println(f.getTimeposted());
				//f.setExpirydate(FoodModulePostServlet.getDate());
				try {
					//System.out.println(FoodModulePostServlet.handle(request.getParameter("expirydate")));
					f.setExpirydate(formatter1.parse(handle(request.getParameter("expirydate"))));
					System.out.println(f.getExpirydate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f.setPaymentType(request.getParameter("paymentType"));
				f.setComments(request.getParameter("comments"));
				f.setUserID(Integer.parseInt(request.getSession().getAttribute("UserID").toString()));
				//1 represent the status of food is available. 
				f.setFoodStatus(1);
				
		//insert into database eShare.food table
				fooddb.InsertNewPost(f);
				
				
				//after successfully insert, we have to forward to view all of the existing posts.
				request.getRequestDispatcher("/FoodModuleViewServlet").forward(request, response);
			
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
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
