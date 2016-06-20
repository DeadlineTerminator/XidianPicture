
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h1>滴-西电卡</h1>

<body background="picture\10.jpg">
<head>
<script language="javascript">
	<!--
		//写一个韩式验证用户是不是空提交
		function checkNum(){
		//判断num1是不是空,表单form1中控件num1的值
			if(form1.username.value==""){
				window.alert("用户名不能为空");
				return false;
			}
			
			if(form1.pawd.value==""){
				window.alert("密码不能为空");
				return false;
			}
			//判断num1是不是一个数
			
		}
	-->
</script>
</head>
<center>
用户登录
<hr>
<form name="form1" action="loginCl.jsp" method="post">
<!-- 把这个表单的数据提交给另外一个jsp页面 -->
用户名：<input type="text"  name="username"><br>
注：请使用学号登录<br>
密&nbsp;码：<input type="password" name="pswd"><br>
<!-- 有一个提交按钮 -->
<input type="submit" value="登录" onclick="return checkNum()">
<input type="reset" value="重置" >

</form>
</center>
</body>
</html>