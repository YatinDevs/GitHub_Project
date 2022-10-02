package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
 
@WebServlet("/change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try
		 {
		HttpSession s2= request.getSession();
		String u= (String)s2.getAttribute("user");
		
		String p=request.getParameter("pass");//this data will come from changepassword form
		
		 Databaseconfig d= new Databaseconfig();
		 Connection con=  d.getCon();
		 PreparedStatement ps=con.prepareStatement("update adminlogin set pass=? where user=?");
		 ps.setString(1, p);
		 ps.setString(2, u);
		 ps.executeUpdate();
		 response.sendRedirect("Login.html");
		}catch(Exception s) {}
	}

}
