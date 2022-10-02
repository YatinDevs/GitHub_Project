package pack;

import java.sql.*;

public class Databaseconfig {

	Connection con;
	Statement s;
	ResultSet rs;
	public Databaseconfig()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//loading driver
			 
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nodedb","root","");
			
			s= con.createStatement();
		} catch(Exception f) 
		{
			System.out.println("error occured "+ f.getMessage());
		}
	}
	
	public Statement getS()	{		return s;	}
	public Connection getCon() { return con;}
	
	
}
