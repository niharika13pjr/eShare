package eshare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.clothesModuleFinalTransactionDAO;
import eshare.model.clothes;

public class ClothesModuleFinalTransactionServlet extends HttpServlet{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		clothesModuleFinalTransactionDAO trans = null;
		int foodstatus = 0;	//to record how many room left.
		String msg = "error";	//error message if there is no room 
		clothes c = null;			//food object
		
		public void init(){
			trans = new clothesModuleFinalTransactionDAO();
		}
		
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
			int clothID = Integer.parseInt(request.getParameter("clothID"));
			//foodstatus = trans.checkAvailable(foodID);
			System.out.println("this is clothID :"+clothID);
			//we have to send email to the original user who posted this posts. 
			
			trans.emailOriginalPoster(clothID);
			
			// peopleneeded - 1
			
			
			
			//currnetfoodcount + 1
			
			
			//check status
				c = trans.viewSelectedClothes(clothID);
				request.setAttribute("clothID", c);
				request.getRequestDispatcher("/finalClothtransaction.jsp").forward(request, response);
				
				
			//}
		}
		
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			doPost(request,response);
		}

}
