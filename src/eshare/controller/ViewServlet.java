package eshare.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  
			String topic = request.getParameter("topic");
			System.out.println(topic);
			if (topic == null) {
				topic = (String) request.getAttribute("topic");
			}
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshare","root","root"); 
			String q="select content from topicfeed where nameoftopic='"+topic+"' order by time";			
			Statement ss=con.createStatement();
			ResultSet rs=ss.executeQuery(q);
			ArrayList<String> contents = new ArrayList<String>();
			while(rs.next()){
				contents.add(rs.getString(1));
			}
			request.setAttribute("contents",contents);
			request.setAttribute("topic",topic);
			request.getRequestDispatcher("viewtopic.jsp").forward(request, response);
		}
		catch (Exception ex) {
			System.out.println(ex);			
		}
	}

}
