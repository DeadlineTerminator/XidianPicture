<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	登录成功  admin
	<a href="login.jsp"><br>返回重新登录</a>
	<a href="wel.jsp"><br>返回首页面</a>

	<h1>人员信息列表</h1>
	<%
  //定义四个分页会用到的变量
 // int pageNow=1;
  
  //接收用户希望显示的页数 
 // String s_pageNow=request.getParameter("pageNow");
 // if(s_pageNow!=null){
	  //确实接收到pageNow
	//  pageNow=Integer.parseInt(s_pageNow);
  //}
  //调用方法
 // UserBeanCl ubc=new UserBeanCl();
 
  //ArrayList al=ubc.getUsersByPage(pageNow);	
  
  //要显示的用户信息，从request中
  ArrayList al=(ArrayList)request.getAttribute( "result");
 %>
 	<table barder=1><td>userid</td><td>password</td>
 	<% 
 	for(int i=0;i<al.size();i++){
  		//从al中取出UserBean
  		UserBean ub=(UserBean)al.get(i);
  		%>
  		<tr><td><%=ub.getUserid() %></td>
  			<td><%=ub.getPswd() %></td>
  		</tr>
  		<% 
  	}
 	
 	%>
 	</table>
 <% 
 //显示超链接
 //从Request中取出pageNow
 	//int pageCount=ubc.pageCount();
 String s_pageCount=(String)request.getAttribute("pageCount");
 int pageCount=Integer.parseInt(s_pageCount);
 int pageNow=Integer.parseInt((String)request.getAttribute("pageNow")); 
		 if(pageNow!=1){
			  out.println("<a href=UsersClServlet?pageNow="+1+">首页</a>");
			  out.println("<a href=UsersClServlet?pageNow="+(pageNow-1)+">上一页</a>");
		 }
		 for(int i=1;i<=pageCount;i++){
			  out.println("<a href=UsersClServlet?pageNow="+i+">["+i+"]</a>");
			  
		 }
		 if(pageNow!=pageCount){
			  out.println("<a href=UsersClServlet?pageNow="+(pageNow+1)+">下一页</a>");
			  out.println("<a href=UsersClServlet?pageNow="+pageCount+">末页</a>");
		 }
 
 %>
  

</body>
</html>