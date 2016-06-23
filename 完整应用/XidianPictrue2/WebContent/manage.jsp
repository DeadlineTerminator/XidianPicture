<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>滴———西电卡-管理员界面</title>
	<link type="text/css" rel="stylesheet" href="manage.css">
</head>

<body>
	<nav>
     <div id = "left">
        <ul>
          <li><a href = "wel.jsp"><img id = "logo" src = "photos/logo1.png" alt= "logo loading..."></a></li>
          <li id = "name">滴——西电卡</li>
        </ul>
    </div>
    <div id = "right">
        <input type="text" id="search_key" value="Administrator" / style = "font-family: 华文新魏 ; font-size: 22px; color: #696969">
        
        <a href = "#"><img id = "me" src = "photos/me.png" alt = "me loading..."></a>
        <a href = "#"><img id = "message" src = "photos/m.png"></a>
    </div>
  </nav>
  <h1>人员信息列表</h1>
 <table>
    <tr>
      <th>用户</th>
      <th>密码</th>
      <th>状态</th>
      <th>忘记密码</th>
      <th>屏蔽</th>
    </tr>
	
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
 	<!-- <table barder=1><td>userid</td><td>password</td> -->
 	<% 
 	for(int i=0;i<al.size();i++){
  		//从al中取出UserBean
  		UserBean ub=(UserBean)al.get(i);
  		%>
  		<tr><td><%=ub.getUserid() %></td>
  			<td><%=ub.getPswd() %></td>
  			<td>开放</td>
  			<td><img src = "photos/password.png" alt = "warning loading..."></td>
  			<td><input type="checkbox" value="selected1" name="myrad1" checked></td>
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