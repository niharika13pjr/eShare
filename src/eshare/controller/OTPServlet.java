package eshare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshare.dao.registrationDAO;
import eshare.model.Registration;

/**
 * Servlet implementation class OTPServlet
 */
public class OTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OTPServlet() {
        super();
        registrationDao = new registrationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean bResult;
	    String Email = request.getParameter("Email");
	    String OPTCodeGen = request.getParameter("OPTCodeGen");
	    String EnteredCode = request.getParameter("code");
	    
    	request.setAttribute("Email", Email);
    	request.setAttribute("OPTCode", OPTCodeGen);
  	    
		if(!EnteredCode.equals(OPTCodeGen))
		{
			 request.setAttribute("error", "incorrect");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("entercode.jsp");
			 Dispatch.forward(request, response);       
			 
			return;
		}
		
		
		registrationDao.SetVerificatoinStatus(Email, 1);

		Registration UserInfo = registrationDao.GetUserInfo(Email);
		
		
		//registrationDao.InsertNewUser(NewUser);
		
		request.setAttribute("error", "");
		request.setAttribute("UserInfo", UserInfo);
		RequestDispatcher Dispatch = request.getRequestDispatcher("home.jsp");
		Dispatch.forward(request, response);  
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
