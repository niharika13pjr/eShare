package eshare.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.registrationDAO;
import eshare.model.Registration;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        registrationDao = new registrationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boolean bResult;
	    String Email = request.getParameter("email");
	    String password = request.getParameter("pd");
	    
	    bResult = registrationDao.IsPresent(Email);
		if(!bResult)
		{
			 request.setAttribute("error", "usernotfound");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("login.jsp");
			 Dispatch.forward(request, response);       
			 
			return;
		}

	    bResult = registrationDao.IsAuthenticatedUser(Email, password);
		if(!bResult)
		{
			 request.setAttribute("error", "invalidpassowrd");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("login.jsp");
			 Dispatch.forward(request, response);       
			 
			return;
		}		
		
		
		Registration UserInfo = registrationDao.GetUserInfo(Email);
		
		//Set the object in the Session.
		javax.servlet.http.HttpSession session = request.getSession();
		session.setAttribute("UserInfo", UserInfo);
		
		session.setAttribute("UserID", UserInfo.getUserID());
		
		//registrationDao.InsertNewUser(NewUser);
		
		
		request.setAttribute("error", "");
		//request.setAttribute("UserInfo", UserInfo);
		
		RequestDispatcher Dispatch = request.getRequestDispatcher("home.jsp");
		Dispatch.forward(request, response);  
	     
		//System.out.println("Control is comming here");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private registrationDAO registrationDao;	
}
