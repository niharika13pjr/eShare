package eshare.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Topicviewservlet
 */
@WebServlet("/Topicviewservlet")
public class Topicviewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Topicviewservlet() {
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
		String newpost=request.getParameter("replyContent");
		//String reply=request.getParameter("reply");
		//ServletContext context=getServletContext();
		
		String n=request.getParameter("topic"); 
		System.out.println(n);
		//System.out.println("topic name "+n);
		//if(newpost!=null){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshare","root","root");
			Statement stmt1 = con.createStatement();           
		
			
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
			Date date=new Date();
			String dddate=df.format(date);
			//System.out.println(dddate);
			String q1="insert into topicfeed(time,nameoftopic,content) values('"+dddate+"','"+n+"','"+newpost+"');";
			
			stmt1.executeUpdate(q1);
			//System.out.println("reached uptil here");
			//System.out.println(newpost);
			String q="select content from topicfeed where nameoftopic='"+n+"' order by time";			
			Statement ss=con.createStatement();
			ResultSet rs=ss.executeQuery(q);
			ArrayList<String> contents = new ArrayList<String>();
			while(rs.next()){
				contents.add(rs.getString(1));
			}
			request.setAttribute("contents",contents);
			request.setAttribute("topic",n);
			RequestDispatcher rd=request.getRequestDispatcher("viewtopic.jsp");
			rd.forward(request, response);
		} catch(Exception e){
			System.out.println(e);
		}
	
	}

}
