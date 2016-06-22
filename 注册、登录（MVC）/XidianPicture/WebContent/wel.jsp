<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
	<!--
		
		function check(){
		//判断num1是不是空,表单form1中控件num1的值
			if(fsearch.search.value==""){
				return false;
			}
		}
	-->
</script>
</head>
<body background="picture\9.jpg" >
<center>
<h1>滴-西电卡</h1>
<form name="fsearch" action="view.jsp" method="post">
<input type="text"  size=50 name="search"><br>
<input type="submit" value="搜索" onclick="return check()">
</form>
</center>
<form action="login.jsp" method="post">
<input type="submit" value="登录" onclick>
</form>
<form action="regist.jsp" method="post">
<input type="submit" value="注册" onclick>
</form>	
</body>
</html>