package eshare.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.bookModuleFinalTransactionDAO;

import eshare.model.books;
public class BookModuleFinalTransactionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	bookModuleFinalTransactionDAO trans = null;
	//int bookstatus = 0;	//to record how many room left.
	String msg = "error";	//error message if there is no room 
	books c = null;			//book object
	
	public void init(){
		trans = new bookModuleFinalTransactionDAO();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		//foodstatus = trans.checkAvailable(foodID);
		System.out.println("this is bookID :"+bookID);
		//we have to send email to the original user who posted this posts. 
		
		trans.emailOriginalPoster(bookID);
		
		
		//check status
			
			c = trans.viewSelectedbook(bookID);
			request.setAttribute("bookID", c);
			request.getRequestDispatcher("/finalBooktransaction.jsp").forward(request, response);
			
			
		//}
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
