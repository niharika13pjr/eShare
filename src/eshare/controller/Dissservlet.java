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
 * Servlet implementation class Dissservlet
 */
@WebServlet("/Dissservlet")
public class Dissservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dissservlet() {
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
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshare","root","root"); 
			String q="select nameoftopic,userinfo from topic order by datecreated";			
			Statement ss=con.createStatement();
			ResultSet rs=ss.executeQuery(q);
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> namelist = new ArrayList<String>();
			while(rs.next()){
				list.add(rs.getString(1));
				namelist.add(rs.getString(2));
				
			}
			request.setAttribute("list",list);
			request.setAttribute("namelist",namelist);
			request.getRequestDispatcher("topics_list.jsp").forward(request, response);
		}
		catch (Exception ex) {
			System.out.println(ex);			
		}
	}

}
