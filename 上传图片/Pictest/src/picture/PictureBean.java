package picture;

import java.sql.*;

public class PictureBean {
	public boolean pictureAdd(String name,String des,String type,String picture){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
				conn=DBconnection.getConnect();
				String[] t=picture.split("\\\\");
				picture="picture\\"+t[t.length-1];
				String strSQL="INSERT INTO picture VALUES(?,?,?,?)";
				pstmt=conn.prepareStatement(strSQL);
				pstmt.setString(1, name);
				pstmt.setString(2, des);
				pstmt.setString(3, type);
				pstmt.setString(4, picture);
				if(pstmt.executeUpdate()>0)
					return true;
				else
					return false;
		  	}catch(SQLException ex){
		  		//ex.printStackTrace();
		  		return false;
		  	}finally{
		  		try{
		  			pstmt.close();
		  			conn.close();
		  		}catch(Exception ex){}
		 }
	}
}