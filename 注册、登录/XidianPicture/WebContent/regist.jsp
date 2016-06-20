<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1>滴-西电卡</h1>

<body background="picture\12.jpg">
<center>
用户注册
<hr>
<form name="form1" action="registCl.jsp" method="post">
一卡通卡号：<input type="text"  name="userid"><br>
用户名：<input type="text"  name="username"><br>
密&nbsp;&nbsp;&nbsp;码：<input type="password"  name="pswd"><br>
注：请输入6-10位由字母，数字，下划线构成的密码<br>
邮&nbsp;&nbsp;&nbsp;箱：<input type="text"  name="email"><br>
<!-- 有一个提交按钮 -->
<input type="submit" value="注册" >
<input type="reset" value="重置" >
</body>
</html>