<!-- 结束计算器页面的数据，计算并显示 -->
<%@ page language="java" import="java.awt.*,java.sql.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<%
//接收用户名和密码
	String u=request.getParameter("username");
	String p=request.getParameter("pswd");
	//调用UserBeanCl的方法，完成对用户的验证
	UserBeanCl ubc=new UserBeanCl();
	if(ubc.checkAdmin(u, p)){
		response.sendRedirect("manage.jsp");
	}
	else if(ubc.checkUser(u, p)){
		response.sendRedirect("user.jsp?username="+u);
	}
	else{
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>