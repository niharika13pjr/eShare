package eshare.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eshare.model.Registration;

/**
 * Servlet implementation class Discussionservlet
 */
@WebServlet("/Discussionservlet")
public class Discussionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Discussionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		  
		String name=request.getParameter("name");
		System.out.println(name);
		boolean valid = (name != null) && name.matches("[A-Za-z0-9_]+");
		if(valid) {
		System.out.println("valid name");}
		else {
			System.out.println("invalid name please try different name");
			String dell = "invalid name please try different name";
			request.setAttribute("dell",dell);
			RequestDispatcher rd=request.getRequestDispatcher("topiccreate.jsp");
			rd.forward(request, response);	
			return;
		}
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshare","root","root");  
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			//java.sql.Date sqlDate = new java.sql.Date(arg0);
			String ddate=df.format(date);
			Statement ss=con.createStatement();
			String q="select nameoftopic from topic where nameoftopic='"+name+"';";
			
			ResultSet rs=ss.executeQuery(q);
			int count=0;
			while(rs.next()){
				count=count+1;
			}
			if(count>0){
				String bigerror="topic already exist would you like to create another";
				request.setAttribute("bigerror",bigerror);
				request.getRequestDispatcher("topiccreate.jsp").forward(request, response);
			}
			else{
				HttpSession session=request.getSession();
				
				Registration unames =	 (Registration) session.getAttribute("UserInfo");
		String uname = unames.getFname();
		String query="insert into topic(nameoftopic,datecreated,userinfo) values('"+name+"','"+ddate+"','"+uname+"');";
		
		ss.executeUpdate(query);
		
		String aga="successfully created";
		request.setAttribute("aga",aga);
		request.setAttribute("topic", name);
	RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");
	rd.forward(request, response);
			}
		} catch (Exception e){
			e.printStackTrace();
		}



		}
			
			
			
	
	

}
