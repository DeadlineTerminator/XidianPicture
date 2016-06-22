<%@ page language="java" import="com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<% 
String id=request.getParameter("userid");
String p=request.getParameter("pswd");
String p2=request.getParameter("pswd2");
//String email=request.getParameter("email");
	//调用UserBeanCl的方法，完成对用户的验证

	UserBeanCl ubc=new UserBeanCl();
/*if(p.equals(p2)!=true){
	out.print("请输入相同的密码");
	
}
else*/ if(ubc.addUser(id,p)==true){	
	out.print("注册成功,3秒后自动跳转到登录页面");
	%>
	<script>
	setTimeout("location.href='login.jsp'", 3000);//3000是3秒，单位是毫秒
	</script>
	<%
}
%>


</body>
</html>