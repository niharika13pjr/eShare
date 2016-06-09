package eshare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.foodModuleConfirmationDAO;

public class FoodModuleConfirmationServlet extends HttpServlet{
	foodModuleConfirmationDAO dao = null;
	
	public void init(){
		 dao = new foodModuleConfirmationDAO();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String userID = request.getSession().getAttribute("UserID").toString();
		String foodID = request.getParameter("foodID");
		System.out.println("id is :"+userID);
		dao.confirm(userID, foodID);
		request.setAttribute("userID", userID);
		request.setAttribute("foodID", foodID);
		request.getRequestDispatcher("/foodconfirmation.jsp").forward(request, response);
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
