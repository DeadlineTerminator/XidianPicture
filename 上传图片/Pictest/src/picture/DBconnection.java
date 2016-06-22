package picture;

import java.sql.*;

public class DBconnection {
	static private Connection con=null;
	static public Connection getConnect(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=XDPicture","sa","DBA");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

}
