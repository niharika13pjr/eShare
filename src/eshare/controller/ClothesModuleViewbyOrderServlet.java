package eshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.clothesModuleViewbyOrderDAO;
import eshare.model.clothes;

public class ClothesModuleViewbyOrderServlet extends HttpServlet{
		     
	/**
	 * 
	 */
	private static final long serialVersionUID = 624633809457138419L;
	clothesModuleViewbyOrderDAO clothesmoduleviewDAO;
	
	public void init(){
		
		clothesmoduleviewDAO = new clothesModuleViewbyOrderDAO();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		ArrayList<clothes> ls=new ArrayList<clothes>();
		
		String option = request.getParameter("options");
		
		ls = clothesmoduleviewDAO.viewbyOrder(option);
		request.setAttribute("clothesls", ls);
		request.getRequestDispatcher("/viewclothes.jsp").forward(request, response);
		
	}
	public void goGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
