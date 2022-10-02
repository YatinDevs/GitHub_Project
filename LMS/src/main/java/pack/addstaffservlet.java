package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/addstaffservlet")
public class addstaffservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try 
	{
   long id= Long.parseLong(request.getParameter("id"));
   String name= request.getParameter("name");
   int age= Integer.parseInt(request.getParameter("age"));
   String city= request.getParameter("city");
   
   Databaseconfig y=new Databaseconfig();
   
   Connection con= y.getCon();
   //queries are stored in pre compiled form 
   //they are faster then statement 
   //prepared statmenet inherits Statement 
    //in place of value we write ? 
    PreparedStatement ps= con.prepareStatement("insert into employees values(?,?,?,?)");	
	ps.setLong(1, id);
	ps.setString(2, name);
	ps.setInt(3, age);
	ps.setString(4, city);
	int y1 =ps.executeUpdate();
	if(y1>0)
	{
		 System.out.println(" record inserted");
	}
	
		}catch(Exception f) {}}

}
