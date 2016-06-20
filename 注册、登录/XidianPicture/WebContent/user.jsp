<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	登录成功<%=request.getParameter("username") %>
	<a href="login.jsp"><br>返回重新登录</a>
	<a href="login.jsp"><br>返回首页面</a>
</body>
</html>