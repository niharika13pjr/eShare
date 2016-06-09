package eshare.controller;

import eshare.dao.*;
import eshare.model.*;
import eshare.util.*;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        
        registrationDao = new registrationDAO();
        // TODO Auto-generated constructor stub
    }
    
	//random a temporary password
	public static String nextSessionId(Random random) {
	    return new BigInteger(50, random).toString(32);
	  }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		boolean bResult;
		
		//All parameter get here.
	 
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    //String Date = request.getParameter("Date");
	    String Address = request.getParameter("Address");
	    String Contact = request.getParameter("Contact");
	    String gender = request.getParameter("gender");
	    String dppath = request.getParameter("dppath");
	    String Email = request.getParameter("Email");
	    String dob = request.getParameter("dob");
	    
	    
	    String password = request.getParameter("password");
	    
	    bResult = registrationDao.IsPresent(Email);
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("register.jsp");
			 Dispatch.forward(request, response);       	 
		}
		
		Date DOBdate = null;
	    
	    DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	    try
	    {
	    	DOBdate = format.parse(dob);	
	    }
	    catch(Exception e)
	    {
			 request.setAttribute("error", "Internal Error");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("register.jsp");
			 Dispatch.forward(request, response);     
	    }
	    
    
	    Registration NewUser = new Registration();
		NewUser.setFname(fname);
		NewUser.setLname(lname);
		NewUser.setPassword(password);
		NewUser.setAddress(Address);
		NewUser.setContact(Contact);
		NewUser.setDate(new Date());
		NewUser.setDob(DOBdate);
		NewUser.setVerifyUser(false);
		NewUser.setEmail(Email);
		//Generate verification code.
		
		String OPTCode;// = "KDLCD4422A";
		
	    Random random = new Random();
	    
	    OPTCode = nextSessionId(random);
        
        String content = "Please use :"+OPTCode+" as your temperary password to login...";
        String subject = "this is subject";
        String resultMessage = "";
       
        try {
        	//connect to DB and insert critical data.
	        SendEmail.sendEmail("smtp.gmail.com", "587", "eshare2016@gmail.com", "eshare12345", Email, subject,
                    content);
           // resultMessage = "The e-mail was sent successfully";
        }
        catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        }

	    NewUser.setVerificationCode(OPTCode);
		NewUser.setGender(gender);
		NewUser.setDppath(dppath);

		registrationDao.InsertNewUser(NewUser);
		
		request.setAttribute("error", "");
		request.setAttribute("OPTCode", OPTCode);
		request.setAttribute("Email", Email);
		
		RequestDispatcher Dispatch = request.getRequestDispatcher("entercode.jsp");
		Dispatch.forward(request, response);  
	     
        return;
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
