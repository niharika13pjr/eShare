package eshare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.clothesModuleConfirmationDAO;
import eshare.dao.foodModuleConfirmationDAO;

public class ClothesModuleConfirmationServlet extends HttpServlet{
	/**
	 * @author HuaZhe Yin.
	 */
	private static final long serialVersionUID = -3811101568792404363L;
	clothesModuleConfirmationDAO dao = null;
	
	public void init(){
		 dao = new clothesModuleConfirmationDAO();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		//String userID = request.getParameter("userID");
		String userID =request.getSession().getAttribute("UserID").toString();
		
		String clothID = request.getParameter("ClothID");
		System.out.println("id is :"+userID);
		dao.confirm(userID, clothID);
		request.setAttribute("userID", userID);
		request.setAttribute("clothID", clothID);
		request.getRequestDispatcher("/clothconfirmation.jsp").forward(request, response);
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
