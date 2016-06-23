//处理类，有些人叫bo，主要是封装对users表的各种操作：增删改差
package com.ghl.model;
import java.sql.*;
import java.util.*;


public class UserBeanCl {
//空闲
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageSize=3;
	private int rowCount =0;
	private int pageCount=0;
	//得到用户需要显示的照片信息（分页）
	//返回分页总页数
	public boolean addUser(String a,String b){
		boolean bb=false;
		try{
			ct=new ConnDB().getConn();
			sm=ct.createStatement();
			sm.executeUpdate("INSERT INTO users VALUES('"+a+"','"+b+"')");
			bb=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			this.close();
		}
		return bb;
		
	}
	public int getpageCount(){
		try{
			ct=new ConnDB().getConn();
			 sm=ct.createStatement();
			rs=sm.executeQuery("SELECT count(*) FROM users");
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
	public ArrayList getUsersByPage(int pageNow){
		ArrayList al=new ArrayList();
		//若返回rs,则关闭数据库就会出错
		//把查询结果，当做UserBean的实例对象
		try{
			ct=new ConnDB().getConn();
			 sm=ct.createStatement();
		  rs=sm.executeQuery("select top "+pageSize+" * from users where userid not in (select top "+pageSize*(pageNow-1)+" +userid from users)");
		 //开始将rs封装到arraylist
		 while(rs.next()){
			 UserBean ub=new UserBean();
			 ub.setUserid(rs.getString(1));
			 ub.setPswd(rs.getString(2));
			
			 al.add(ub);
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
	public boolean checkAdmin(String u,String p){
		boolean b=false;
		if(u.equals("admin")&&p.equals("admin")){
			b=true;
		}
		
		return b;
	}
	public boolean checkUser(String u,String p){
		boolean b=false;
		try{
			ct=new ConnDB().getConn();
			sm=ct.createStatement();
			rs=sm.executeQuery("SELECT pswd FROM users where userid='"+u+"'");
			//根据结果判断
			if(rs.next()){
				//说明用户名存在
				if(rs.getString(1).equals(p)){
					//一定是合法
					b=true;
					
				}
				else{
					//System.out.println("密码不正确");
					
				}
			}
			else{
				//System.out.println("该用户不存在");
			
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//关闭打开的各种资源
			this.close();
		}
		return b;
	}
}
