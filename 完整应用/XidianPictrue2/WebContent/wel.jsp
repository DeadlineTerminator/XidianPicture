<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>滴，西电卡 - 主页</title>
<link rel="stylesheet" type="text/css" href="home.css">
<link href="/WebContent/home.css" rel="stylesheet" type="text/css">
<script language="javascript">
<!-- 	
function showr(){
		var a = document.getElementsByClassName("register-card")[0];
		a.className = "register-card-show";
		var b = document.getElementsByClassName("login-card-show")[0];
		b.className = "login-card";
		
		}
		
	function showl(){
		var a = document.getElementsByClassName("login-card")[0];
		a.className = "login-card-show";
		var b = document.getElementsByClassName("register-card-show")[0];
		b.className = "register-card";
		}
		
	function cardClose(obj){
		if(obj.className = "close-btn lclose"){
				obj.parentNode.className = "login-card";	
				
				}
		if(obj.className = "close-btn rclose"){
				obj.parentNode.className = "register-card";	
				
				}
		}
		
	/*注册验证*/
	function inputCheck(){
		if(form2.uname.value==""){
			window.alert("用户名不能为空!");
			return false;
		}
		if(form2.password1.value==""){
			window.alert("密码不能为空!");
			return false;
		}
		if(form2.password1.value!=form2.password2.value){
			window.alert("两次输入密码不同");
			return false;
		}
		
		
	}
	function check3(){
		//判断num1是不是空,表单form1中控件num1的值
			if(form3.uname.value==""){
				window.alert("用户名不能为空");
				return false;
			}
			
			if(form3.password1.value==""){
				window.alert("密码不能为空");
				return false;
			}
			//判断num1是不是一个数 
			
			
		} 
	   -->
</script>
<script language="javascript">
	<!--
		function check1(){
		//判断num1是不是空,表单form1中控件num1的值
			if(form1.q.value==""){
				window.alert("搜索关键字不能为空");
				return false;
			}
			
			
		}
	-->
</script>
</head>

<body onselectstart="return false;">
	<div class="top">
		<div class="logo">
        	<img src="photos/logo.png"/>
            <div class="tittle">滴———西电卡</div>
        </div>
            <div class="top-right">
            	<div class="login-nav">
                	<div class="register btn"><input type="button" class="register btn" value="注册" style="color:rgba(255,255,255,0.6)" onClick="showr()"/></div>
                    <div class="login btn" ><input type="button"  class="login btn"  value="登录" style="color:rgba(255,255,255,0.6)" onClick="showl()"/></div>          
                </div>
            </div>
	</div>
	<div class="center">
    <div class="text-line">西电卡 - 做你生活的记录者</div>
    <form name="form1" id="search_form" method="postt" action="PictureClServlet" class="searching-unit" data-regestered="regestered">
    	<input id="query" type="text" size="27" name="q" autocomplete="off" placeholder="搜索你喜欢的" />
    	<input type="image" src="photos/search.png" class="go" onclick="return check1()" width="31px" height="20px">
    </form>
    </div>
    <!--注册悬浮框-->
    <div class="register-card">
    	<div class="line1"><img src="photos/logo.png" width="25"/></div>
    	<div class="line2"><div class="fengexian"></div><div><span>使用学号注册</span></div><div class="fengexian"></div></div>
        <form name="form2" action="registCl.jsp" method="post" >
    		<input class="r-in" id="uname" type="text" size="27"  name="uname" autocomplete="off" placeholder="请输入您的注册学号" /><br>
    		<input class="r-in" id="password1" type="password" size="16"  name="password1"  placeholder="请设置您的密码" /><br>
            <input class="r-in" id="password2" type="password" size="16"  name="password2"  placeholder="请再次确认密码" /><br>
			<input class="r-in" id="rbtn" type="submit" value="注册" style="color:rgba(255,255,255,0.6)" onClick="return inputCheck()"/>
            
        </form>
		<div class="close-btn rclose" onClick="cardClose(this)">关闭</div>

	</div>
    
    <!--登录框悬浮-->
    <div class="login-card">
    	<div class="line1"><img src="photos/logo.png" width="25"/></div>
    	<div class="line2"><div class="fengexian"></div><div><span>使用学号登录</span></div><div class="fengexian"></div></div>
        <form name="form3" action="LoginClServlet" method="post" >
    		<input class="l-in" id="uname" type="text" size="27"  name="uname" autocomplete="off" placeholder="请输入您的用户名" /><br>
    		<input class="l-in" id="password1" type="password" size="16"  name="password1"  placeholder="请输入您的密码" /><br>
            <input class="l-in" id="lbtn" type="submit" value="登录" onClick="return check3()" style="color:rgba(255,255,255,0.6)"/>
		</form>
		<div class="close-btn lclose" onClick="cardClose(this)">关闭</div>
	</div>
    
</body>

</html>
