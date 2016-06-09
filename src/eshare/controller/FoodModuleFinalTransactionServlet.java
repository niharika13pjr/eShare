package eshare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.foodModuleFinalTransactionDAO;
import eshare.model.food;

public class FoodModuleFinalTransactionServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	foodModuleFinalTransactionDAO trans = null;
	int foodstatus = 0;	//to record how many room left.
	String msg = "error";	//error message if there is no room 
	food f = null;			//food object
	
	public void init(){
		trans = new foodModuleFinalTransactionDAO();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		int foodID = Integer.parseInt(request.getParameter("foodID"));
		//foodstatus = trans.checkAvailable(foodID);
		System.out.println("this is foodid :"+foodID);
		//we have to send email to the original user who posted this posts. 
		
		trans.emailOriginalPoster(foodID);
		
		// peopleneeded - 1
		
		
		
		//currnetfoodcount + 1
		
		
		//check status
			f = trans.viewSelectedFood(foodID);
			request.setAttribute("food", f);
			request.getRequestDispatcher("/finaltransaction.jsp").forward(request, response);
			
			
		//}
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
