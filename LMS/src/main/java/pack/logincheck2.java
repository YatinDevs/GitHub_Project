package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/logcheck2")
public class logincheck2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String user= request.getParameter("user");
		String pass= request.getParameter("pass");

		Databaseconfig d= new Databaseconfig();
		Connection c= d.getCon();
		Statement s= c.createStatement();
		ResultSet rs= s.executeQuery("select * from adminlogin where user='"+user+"' and pass='"+pass+"'   ");
		//resultset cannot move previous unless we mention it as scrollable 
		if(rs.next()) 
		{
			HttpSession s1= request.getSession();
			s1.setAttribute("user",user);
			s1.setAttribute("pass",pass);
			
			RequestDispatcher rd= request.getRequestDispatcher("AdminDashBoard.html");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("Login.html");
		}
		}
		catch(Exception d) {}
		
	}

}
