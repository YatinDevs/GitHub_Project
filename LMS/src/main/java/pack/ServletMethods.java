package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMethods
 */
@WebServlet("/ServletMethods")
public class ServletMethods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out= response.getWriter();
		out.println(getServletInfo()+"===========<br>");
		out.println(getServletConfig());
	}

}
