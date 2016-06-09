package eshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eshare.dao.bookModuleViewDAO;

import eshare.model.books;


public class BookModuleViewServlet extends HttpServlet{
	//declare view DAO object
		bookModuleViewDAO bookViewobj;
		
		
		public void init(){
			//initialize the DAO object
			bookViewobj = new bookModuleViewDAO();
		}
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			ArrayList<books> ls = new ArrayList<books>();
			
			ls = bookViewobj.ViewExistingPost();
			request.setAttribute("bookList", ls);
			System.out.println("this is the size of the book"+ls.size());
			request.getRequestDispatcher("/viewbook.jsp").forward(request, response);
		}
		
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			doPost(request,response);
		}

}
