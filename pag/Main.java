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
			System.out.println("���������ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		try{
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("�������ݿ�ɹ���");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("SQL Server����ʧ�ܣ�");
		}	*/
		Main m=new Main();
		m.add(up);
		m.setSize(500, 200);
		m.setTitle("�ϴ�");
		m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m.setVisible(true);
		
	}
	
	
	

}
