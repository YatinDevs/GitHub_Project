package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import java.sql.*;
@WebServlet("/viewbook")
public class viewbook extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out= response.getWriter();	
	try {
		Databaseconfig db= new Databaseconfig();
		Statement s=db.getS();
     //ResultSet interface --> we traverse data from database 
     // to fetch data we use resultset .next()		
	ResultSet rs=	s.executeQuery("select * from book ");
	out.println("<h1> List of books</h1><br>");
	out.println("<table border=2>");
	 out.println("<tr><th> isbn  <th>Bookname<th>Author name<th>Price<th>Quantity </tr>");
	while(rs.next())
	{
	//1 & 2 are column number 
	out.println("<tr><td>"+rs.getInt(1) +"<td>"+ rs.getString(2) +"<td>"+ rs.getString(3) +"<td>"+ rs.getInt(4)+"<td>"+ rs.getInt(5));
	out.println("<td><a href='editbook?isbn=" +rs.getInt(1)+"'>Edit</a></td>");	
	out.println("<td><a href='deletebook?isbn=" +rs.getInt(1)+"'>Delete</a></td>");	
    
	}
	
  
	}
	catch(Exception f) 
	{
		System.out.println(f.getMessage());
	}
	
	}
	 

}
