package pag;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Uploadphoto {
	 static PreparedStatement sql;
		static Connection conn;
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=IMAGE";
		String userName="sa";
		String userPwd="mayu123";
		public Connection getConnection(){
			try
			{
				Class.forName(driverName);
				System.out.println("���������ɹ���");
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("��������ʧ�ܣ�");
			}
			try{
				conn=DriverManager.getConnection(dbURL,userName,userPwd);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.print("SQL Server����ʧ�ܣ�");
			}	
			return conn;
		}
		public  static void upload(String name,String description,String type,String path){
			System.out.println("mayu");
			Uploadimage up=new Uploadimage();
			conn=up.getConnection();
			try{
				sql=conn.prepareStatement("INSERT INTO picture VALUES(?,?,?,?)");
			//	sql.setInt(1, i);
				sql.setString(1,name);
				sql.setString(2,description );
				sql.setString(3, type);
				FileInputStream fis=new FileInputStream(path);
				sql.setBinaryStream(4, fis,fis.available());
				System.out.println(sql.executeUpdate());
				fis.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
				
		}
		public static void main(String[] args){
			upload("abcd" , "sat", "dd","F://ͼƬ//a573c509b3de9c8241ec0ae46b81800a18d843ff.jpg");
		}

}
