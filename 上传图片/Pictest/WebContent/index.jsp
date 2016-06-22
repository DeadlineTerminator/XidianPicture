<%@ page language="java" contentType="text/html; charset=GB18030"
pageEncoding="GB18030"%>
<%@ page import="java.util.*,picture.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>登录页面</title>
</head>
<body>
<form name="loginForm" method="post" action="judgeUser.jsp">
<table>
<tr>
<td>图片名称:<input type="text" name="picname" id="picname"></td>
</tr>
<tr>
<td>图片描述:<input type="text" name="description" id="description"></td>
</tr>
<tr>
<td>图片类别:<input type="text" name="pictype" id="pictype"></td>
</tr>
<tr>
<td>图片地址:<input type="file" name="picture" id="picture"></td>
</tr>
<tr>
<td><input type="submit" value="上传文件" style="background-color:pink" onclick="submit1()">
 
<input type="reset" value="重置" style="background-color:red"></td> 
</tr>
</table>
</form>
</body>
</html>
