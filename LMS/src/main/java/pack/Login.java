package pack;

import java.io.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

 //localhost:8080/LMS/Bookrecord
import java.sql.*;
@WebServlet("/logcheck")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
  PrintWriter out= response.getWriter();

  String u= request.getParameter("user");
  String p= request.getParameter("pass");
  
  Databaseconfig db= new Databaseconfig();
  
  Statement s= db.getS();
  ResultSet rs= s.executeQuery("select * from adminlogin where user='"+u+"' and pass='"+p+"'");
  if(rs.next())
  {
	  RequestDispatcher rd= request.getRequestDispatcher("AdminDashBoard.html");
	  rd.forward(request, response);   //url will not be modified
  }
  else
	  response.sendRedirect("Login.html"); //url wil be modified or rewritten
  
	
	}catch(Exception f)
	{
	System.out.println(" -------------"+ f.getMessage());	
	}
}
}