//得到数据库连接
package com.ghl.model;
import java.sql.*;

public class ConnDB {
	private Connection ct=null;
	public Connection getConn(){
		try{
			String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);
			String url="jdbc:sqlserver://localhost:1433; DatabaseName=XidianPicture";
			String username="sa";
			String psw="DBA";
			ct=DriverManager.getConnection(url ,username,psw);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
}
