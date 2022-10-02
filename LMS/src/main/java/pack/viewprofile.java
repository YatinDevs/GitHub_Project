package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
@WebServlet("/viewprofile")
public class viewprofile extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s= request.getSession(); //session id  
		String u=(String) s.getAttribute("user");
		String p=(String) s.getAttribute("pass");
		PrintWriter out= response.getWriter();
				
		try {
		 Databaseconfig d= new Databaseconfig();
		 Connection con=  d.getCon();
		 PreparedStatement ps=con.prepareStatement("select * from adminlogin where user=? and pass=?");
		 ps.setString(1, u);
		 ps.setString(2, p);
		 out.println("<table border=2>");
		 out.println("<tr><th> username  <th>password</tr>");
		 ResultSet rs= ps.executeQuery();
		 if(rs.next())
			 out.println("<tr><td>"+rs.getString(1) +" <td>"+ rs.getString(2));
		
		 
		}catch(Exception d) {
			System.out.println("***********"+d.getMessage());
		}
	}

	 
}
