package eshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.bookModuleViewbyOrderDAO;
import eshare.dao.bookModuleViewbyOrderDAO;
import eshare.model.books;
import eshare.model.food;

public class BookModuleViewbyOrderServlet {
bookModuleViewbyOrderDAO bookviewbyorderDAO;
	
	public void init(){
		//initialize the DAO object
		bookviewbyorderDAO = new bookModuleViewbyOrderDAO();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ArrayList<food> ls = new ArrayList<food>();
		
		String option = request.getParameter("options");
	//	ls = bookviewbyorderDAO.viewbyOrder(option);
		
		request.setAttribute("bookList", ls);
		request.getRequestDispatcher("/viewbook.jsp").forward(request, response);
		
	}
	
	public void goGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
