<%@ page language="java" import="com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body background="photos\background.jpg">
<% 
String id=request.getParameter("uname");
String p=request.getParameter("password1");
String p2=request.getParameter("password2");
//String email=request.getParameter("email");
	//调用UserBeanCl的方法，完成对用户的验证

	UserBeanCl ubc=new UserBeanCl();
	if(ubc.addUser(id,p)==true){	
	out.print("您注册成功,3秒后跳到登录页面");
	%>
	<script>
	setTimeout("location.href='wel.jsp'", 3000);//3000是3秒，单位是毫秒
	</script>
	<%
}
	else{
		out.print("该用户已存在，请登录");
		%>
		<script>
		setTimeout("location.href='wel.jsp'", 1000);
		</script>
		<%
	}
%>


</body>
</html>