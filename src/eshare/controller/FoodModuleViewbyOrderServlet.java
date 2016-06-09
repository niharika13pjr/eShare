package eshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.foodModuleViewbyOrderDAO;
import eshare.model.food;

public class FoodModuleViewbyOrderServlet extends HttpServlet{
	
	foodModuleViewbyOrderDAO foodviewbyorderDAO;
	
	public void init(){
		//intialize the DAO object
		foodviewbyorderDAO = new foodModuleViewbyOrderDAO();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ArrayList<food> ls = new ArrayList<food>();
		
		String option = request.getParameter("options");
		ls = foodviewbyorderDAO.viewbyOrder(option);
		
		request.setAttribute("foodList", ls);
		request.getRequestDispatcher("/viewfood.jsp").forward(request, response);
		
	}
	
	public void goGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
