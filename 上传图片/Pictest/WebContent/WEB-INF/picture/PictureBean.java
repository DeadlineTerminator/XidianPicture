package picture;

import java.io.*;
import java.sql.*;

public class PictureBean {
	public boolean pictureAdd(String name,String des,String type,String picture){
		Connection conn=null;
		PreparedStatement pstmt=null;
		FileInputStream fis=null;
		try{
				conn=DBconnection.getConnect();
				fis=new FileInputStream(picture);
				String strSQL="INSERT INTO picture VALUES(?,?,?,?)";
				pstmt=conn.prepareStatement(strSQL);
				pstmt.setString(1, name);
				pstmt.setString(2, des);
				pstmt.setString(3, type);
				pstmt.setBinaryStream(4, fis, fis.available());
				if(pstmt.executeUpdate()>0)
					return true;
				else
					return false;
		  	}catch(SQLException ex){
		  		ex.printStackTrace();
		  		return false;
		  	}catch(IOException ex){
		  		ex.printStackTrace();
		  		return false;
		  	}finally{
		  		try{
		  			fis.close();
		  			pstmt.close();
		  			conn.close();
		  		}catch(Exception ex){}
		 }
	}
}