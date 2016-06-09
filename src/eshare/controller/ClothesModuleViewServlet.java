package eshare.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.clothModuleViewDAO;
import eshare.model.clothes;

public class ClothesModuleViewServlet extends HttpServlet {

	/**
	 * 
	 */
	
	//declare view dao
	clothModuleViewDAO clothViewobj;
	
	public void init(){
		//initialize the DAO object
		clothViewobj = new clothModuleViewDAO();
	}
	private static final long serialVersionUID = 3645351134984664182L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ArrayList<clothes> ls = new ArrayList<clothes>();
		
		ls = clothViewobj.ViewExistingPost();
		request.setAttribute("clothesls", ls);
		request.getRequestDispatcher("/viewclothes.jsp").forward(request, response);
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

}
