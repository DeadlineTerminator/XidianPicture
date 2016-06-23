<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>上传页面</title>
</head>
<body>
<form name="UploadForm" method="post" action="UploadClServlet">
<table>
<tr>
<td>图片名称:<input type="text" name="picname" id="picname"></td>
</tr>
<tr>
<td>图片描述:<input type="text" name="description" id="description"></td>
</tr>
<tr>
<td>图片类别:<select name="pictype" id="pictype">
	<option value="人物">人物</option>
	<option value="风景">风景</option>
	<option value="丁香">丁香</option>
	<option value="海棠">海棠</option>
	<option value="竹园">竹园</option>
	<option value="操场">操场</option>
	<option value="图书馆">图书馆</option>
	</select>
</td>
</tr>
<tr>
<td>图片地址:<input type="file" name="picture" id="picture"></td>
</tr>
<tr>
<td><input type="submit" value="上传文件" style="background-color:pink" >
 
<input type="reset" value="重置" style="background-color:red" ></td> 
</tr>
</table>
</form>
</body>
</html>
