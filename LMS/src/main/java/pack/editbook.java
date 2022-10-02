package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;;

/**
 * Servlet implementation class editbook
 */
@WebServlet("/editbook")
public class editbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int  isbn= Integer.parseInt(request.getParameter("isbn"));
		
		Databaseconfig db= new Databaseconfig();
		Statement s= db.getS();
		ResultSet rs= s.executeQuery("select * from book where isbn='"+ isbn+"' ");
		rs.next();
		PrintWriter out= response.getWriter();
		
		response.setHeader("Content-Type", "text/html");
		
		
		
		out.println("<form action='updatebook' method='post'>");
		out.println("Isbn<input type='text' name='isbn'   value='"+rs.getInt(1)+"'><br>");
		out.println("bname<input type='text' name='bname' value='"+rs.getString(2)+"'><br>");
		out.println("aname<input type='text' name='aname' value='"+rs.getString(3)+"'><br>");
		out.println("price<input type='text' name='price' value='"+rs.getInt(4)+"'><br>");
		out.println("Qty<input type='text' name='qty'     value='"+rs.getInt(5)+"'><br>");
		out.println("<input type='submit'>");
		out.println("</form>");
		
		}
		catch(Exception df) {}
		

}
}
