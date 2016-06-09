package eshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.foodModuleViewDAO;
import eshare.model.food;

public class FoodModuleViewServlet extends HttpServlet{
	
	//declare view DAO object
	foodModuleViewDAO foodViewobj;
	
	
	public void init(){
		//initialize the DAO object
		foodViewobj = new foodModuleViewDAO();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		ArrayList<food> ls = new ArrayList<food>();
		
		ls = foodViewobj.ViewExistingPost();
		request.setAttribute("foodList", ls);
		System.out.println("this is the size of the food"+ls.size());
		request.getRequestDispatcher("/viewfood.jsp").forward(request, response);
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
