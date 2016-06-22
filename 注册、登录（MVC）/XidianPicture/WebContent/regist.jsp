<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h1>滴-西电卡</h1>

<body background="picture\12.jpg">
<head>
<script language="javascript">
	<!--
		//写一个韩式验证用户是不是空提交
		function checkPs(){
		//判断num1是不是空,表单form1中控件num1的值
		if(form1.userid.value==""){
			window.alert("用户名不能为空");
			return false;
		}
			if(form1.pswd.value!=form1.pswd2.value){
				window.alert("请输入相同的密码");
				return false;
			}
			
			//判断num1是不是一个数 
			
		}
	-->
</script>
</head>
<center>
用户注册
<hr>
<form name="form1" action="registCl.jsp" method="post">
一卡通卡号：<input type="text"  name="userid"><br>
密&nbsp;&nbsp;&nbsp;码：<input type="password"  name="pswd"><br>
请再次输入密&nbsp;&nbsp;&nbsp;码：<input type="password"  name="pswd2"><br>
注：请输入6-10位由字母，数字，下划线构成的密码<br>
<!--  邮&nbsp;&nbsp;&nbsp;箱：<input type="text"  name="email"><br>-->
<!-- 有一个提交按钮 -->

<input type="submit" value="注册" onclick="return checkPs()">
<input type="reset" value="重置" >
</body>
</html>