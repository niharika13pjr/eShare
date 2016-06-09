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

import eshare.dao.bookModulePostDAO;

import eshare.model.books;

public class BookModulePostServlet extends HttpServlet{
	//declare food DAO object
		bookModulePostDAO bookdb;
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		public void init(){
			//initialize the DAO object
			bookdb = new bookModulePostDAO();
			
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//set the food model
					books f = new books();
					f.setBooktitle(request.getParameter("booktitle"));
					System.out.println(request.getParameter("booktitle"));
					f.setPublisher((request.getParameter("publisher")));
					//f.setBookID(Integer.parseInt(request.getParameter("bookID")));
					f.setAuthor(request.getParameter("author"));
					f.setAdditionVolume(request.getParameter("additionVolume"));
					f.setPaymentType(request.getParameter("paymentType"));
					f.setComments(request.getParameter("comments"));
					f.setUserID(Integer.parseInt(request.getSession().getAttribute("UserID").toString()));
					f.setISBNnumber(request.getParameter("ISBNnumber"));
					f.setRentedPrice(Double.parseDouble(request.getParameter("rentedPrice")));
					f.setPurchasePrice(Double.parseDouble(request.getParameter("purchasePrice")));
					//1 represent the status of food is available. 
					
					
			//insert into database eShare.food table
					bookdb.InsertNewPost(f);
					
					
					//after successfully insert, we have to forward to view all of the existing posts.
					request.getRequestDispatcher("/BookModuleViewServlet").forward(request, response);
				
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
