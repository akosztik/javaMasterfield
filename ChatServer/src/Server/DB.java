package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB  {
	
	private Connection con;
		
		
		public DB() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/log", "root", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		public Connection getCon() {
			return con;
		}
		
}

		

