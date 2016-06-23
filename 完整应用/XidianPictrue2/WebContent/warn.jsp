<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
 <% 
 	Boolean b=(Boolean)request.getAttribute("check");
 	System.out.print(b);

 
	  if(b==false)
		  %>
	  <script language="javascript">
	  {
		  window.alert("该用户不存在或密码错误");
		  setTimeout("location.href='wel.jsp'", 1000);//3000是3秒，单位是毫秒
		  
	  }
</script>
</body>
</html>