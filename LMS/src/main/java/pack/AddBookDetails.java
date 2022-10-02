package pack;

import java.io.IOException;
import java.io.PrintWriter;
 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
 

 

@WebServlet("/addbookdetails")
public class AddBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	     int isbn= Integer.parseInt(request.getParameter("isbn"));
		String bname= request.getParameter("bname");
		String aname= request.getParameter("aname");
	    int  price= Integer.parseInt(request.getParameter("price"));
		int  qty= Integer.parseInt(request.getParameter("qty"));
      	PrintWriter out = response.getWriter();
         		
		Databaseconfig d1= new Databaseconfig();
		
		Statement s= d1.getS();
		
	s.execute("insert into book values('"+isbn+"','"+bname+"','"+aname+"','"+price+"','"+qty+"')");
	
	//s.execute("insert into book values('java','herbert',1233,33)");
		}catch(Exception d) {}	}

}

