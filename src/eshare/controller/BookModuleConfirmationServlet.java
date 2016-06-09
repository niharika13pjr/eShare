package eshare.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.bookModuleConfirmationDAO;

public class BookModuleConfirmationServlet extends HttpServlet{
bookModuleConfirmationDAO dao = null;
	
	public void init(){
		 dao = new bookModuleConfirmationDAO();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String userID = request.getSession().getAttribute("userID").toString();
		String bookID = request.getParameter("bookID");
		System.out.println("id is :"+userID);
		dao.confirm(userID, bookID);
		request.setAttribute("userID", userID);
		request.setAttribute("bookID", bookID);
		request.getRequestDispatcher("/bookconfirmation.jsp").forward(request, response);
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
