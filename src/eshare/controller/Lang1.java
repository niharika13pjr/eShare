package eshare.controller;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class Lang
 */
@WebServlet("/Lang1")
public class Lang1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lang1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		 session.setAttribute("todo",request.getLocale());
		 request.getRequestDispatcher("/login.jsp").forward(request, response);

		 
		    PrintWriter out = response.getWriter();

		    Locale userPreferredLocale = request.getLocale();
		    Enumeration userPreferredLocales = request.getLocales();

		    out.println("------Locale: " + userPreferredLocale.toString());
		    out.println("");
		    out.print("Preferred Locales: ");

		    while (userPreferredLocales.hasMoreElements()) {
		      userPreferredLocale = (Locale) userPreferredLocales.nextElement();
		      out.print(userPreferredLocale.toString() + ", ");
		    }
		    out.println();
		    out.println("");
		
	}

}
