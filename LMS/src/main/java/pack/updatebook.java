package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatebook
 */
@WebServlet("/updatebook")
public class updatebook extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int i=Integer.parseInt(request.getParameter("isbn"));
		 String bname=request.getParameter("bname");
		 PrintWriter out= response.getWriter();
		 out.println(i +  "   "+ bname );
		 
	}

}
