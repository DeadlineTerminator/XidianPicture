<%@ page language="java" contentType="text/html; charset=GB18030"
pageEncoding="GB18030"%>
<%@ page import="java.util.*,picture.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>��¼ҳ��</title>
</head>
<body>
<form name="loginForm" method="post" action="judgeUser.jsp">
<table>
<tr>
<td>ͼƬ����:<input type="text" name="picname" id="picname"></td>
</tr>
<tr>
<td>ͼƬ����:<input type="text" name="description" id="description"></td>
</tr>
<tr>
<td>ͼƬ���:<input type="text" name="pictype" id="pictype"></td>
</tr>
<tr>
<td>ͼƬ��ַ:<input type="file" name="picture" id="picture"></td>
</tr>
<tr>
<td><input type="submit" value="�ϴ��ļ�" style="background-color:pink" onclick="submit1()">
 
<input type="reset" value="����" style="background-color:red"></td> 
</tr>
</table>
</form>
</body>
</html>
