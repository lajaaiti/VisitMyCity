package application;

import java.sql.*;

public class ConnexionBDD {
	
	//  com.mysql.jdbc.Driver
	
	public Connection cn = null;
	
	public static Connection connexionDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vmc","root","");
			//System.out.println("Bravo !!!!");
			return cn;
			
		} catch (ClassNotFoundException  | SQLException e) {
			//System.out.println("error connecxion!!!!");
			e.printStackTrace();
		}
		return null;
	}

}
