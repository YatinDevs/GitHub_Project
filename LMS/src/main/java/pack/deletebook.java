package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/deletebook")
public class deletebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   try {
     Databaseconfig db= new Databaseconfig();
     Statement s= db.getS();
     int i= Integer.parseInt(request.getParameter("isbn"));
     int y=s.executeUpdate("delete from book where isbn='"+i+"'");
     
     response.sendRedirect("viewbook");
   }catch(Exception f) {}
	}

}
