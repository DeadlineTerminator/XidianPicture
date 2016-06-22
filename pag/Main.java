package pag;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
		static UPloadJpanel up=new UPloadJpanel();
	public static void main(String [] args)
	{
		/*String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=IMAGE";
		String userName="sa";
		String userPwd="mayu123";
		try
		{
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try{
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("连接数据库成功！");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}	*/
		Main m=new Main();
		m.add(up);
		m.setSize(500, 200);
		m.setTitle("上传");
		m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m.setVisible(true);
		
	}
	
	
	

}
