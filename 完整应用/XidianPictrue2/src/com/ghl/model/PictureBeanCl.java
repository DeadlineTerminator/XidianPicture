package com.ghl.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class PictureBeanCl {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageSize=4;
	private int rowCount =0;
	private int pageCount=0;
	//得到用户需要显示的照片信息（分页）
	//返回分页总页数
	public boolean addPicture(String name,String des,String type,String picture){
		boolean bb=false;
		try{
			ct=new ConnDB().getConn();
			String[] t=picture.split("\\\\");
			picture="picture\\"+t[t.length-1];
			String strSQL="INSERT INTO picture VALUES(?,?,?,?)";
			PreparedStatement pstmt=ct.prepareStatement(strSQL);
			pstmt.setString(1, name);
			pstmt.setString(2, des);
			pstmt.setString(3, type);
			pstmt.setString(4, picture);
			if(pstmt.executeUpdate()>0)
				return true;
			else
				return false;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			
			this.close();
		}
		
	}
	public int getpageCount(String t){
		try{
			ct=new ConnDB().getConn();
			 sm=ct.createStatement();
			rs=sm.executeQuery("SELECT count(*) FROM picture WHERE typ="+"'"+t+"'");
			  //一定要先next一下
				if(rs.next()){
				   rowCount=rs.getInt(1);
			   }
			  //计算
			  if(rowCount%pageSize==0){
				  pageCount=rowCount/pageSize;
			  }
			  else{
				  pageCount=rowCount/pageSize+1;
				  
			  }
		}catch(Exception e){
			
		}
		finally{
			this.close();
		}
		return pageCount;
	}
	public ArrayList getPicturesByPage(int pageNow,String s){
		ArrayList al=new ArrayList();
		//若返回rs,则关闭数据库就会出错
		//把查询结果，当做UserBean的实例对象
		try{
			//String s=request
			ct=new ConnDB().getConn();
			 sm=ct.createStatement();
		  rs=sm.executeQuery("select top "+pageSize+"* from picture where id not in (select top "+(pageSize*(pageNow-1))+" id from picture)"+"and typ="+"'"+s+"'");
		 //开始将rs封装到arraylist
		 while(rs.next()){
			 PictureBean pb=new PictureBean();
			 pb.setId(rs.getInt(1));
			 pb.setName(rs.getString(2));
			 pb.setDescrip(rs.getString(3));
			 pb.setTyp(rs.getString(4));
			 pb.setP(rs.getString(5));
			 al.add(pb);
		 }
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.close();
			
		}
		return al;
		
	}
	//关闭资源的函数
	public void close(){
		try{
			if(rs!=null){
				rs.close();
				rs=null;//加速资源的释放
			}
			if(sm!=null){
				sm.close();
				sm=null;
			}
			if(ct!=null){
				ct.close();
				ct=null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//验证用户是否存在
	
	public void copyFile(String oldPath, String newPath) throws IOException{
		 FileInputStream fin = new FileInputStream(oldPath);
				     FileOutputStream fout = new FileOutputStream(newPath);
				  
				     FileChannel fcin = fin.getChannel();
				     FileChannel fcout = fout.getChannel();
				  
				     ByteBuffer buffer = ByteBuffer.allocateDirect( 1024 );
				  
				     while (true) {
				       buffer.clear();
				  
				       int r = fcin.read( buffer );
				  
				       if (r==-1) {
				         break;
				       }
				  
				       buffer.flip();
				  
				       fcout.write( buffer );
				     }
				  }
	public class JFileChooserDemo extends JFrame {//implements ActionListener{
		JFileChooser fc=new JFileChooser();
		//JButton save;
		String path;
		public JFileChooserDemo(String path){
			int select=fc.showSaveDialog(this);
			if(select==JFileChooser.APPROVE_OPTION){
				//选择是否为确认
				File file=fc.getSelectedFile();//根据选择创建文件对象
				String s=file.getPath();//新文件的路径
				String s1=s.replace('\\','/');
				try {
					System.out.println("eeeee");
					copyFile(path,s1);
					System.out.println("diaoyong");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//在屏幕上显示打开文件的文件名
				//System.out.println("文件"+file.getName()+"被保存");
			}
			else{
				System.out.println("保存操作被取消");
			}
		}
	}
}
