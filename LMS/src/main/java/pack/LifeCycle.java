package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	   String u;
    public LifeCycle() {
        super();
        System.out.println("in constructor");
    }
  // initialization 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init "+config);
	}

	public void destroy() {System.out.println("in destroy");	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in service"+request );
	}
	 

}
