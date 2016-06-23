<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="javascript">
	<!--
	function _toLcal(){
		  location.href ='upload.jsp';
		}
	-->
</script>
<body >


<head>
	<meta charset="utf-8">
	<title>滴———西电卡-个人中心</title>
	<link type="text/css" rel="stylesheet" href="personal_center.css">
</head>
<body>
	<nav>
		<ul>
          <li><a href = "wel.jsp"><img id = "logo" src = "photos/logo1.png" alt= "logo loading..."></a></li>
           <li id = "card">滴——西电卡</li>
          
         
          
        </ul>
	</nav>
	<div id = "main">
		
        
         <img id = "me" src = "photos/me.png" alt = "me loading...">
         <input type = "button" id = "p" value = "修改头像" style="display : none;">
	  
         <span id = "name"><%=request.getParameter("uname") %></span>
        
     </div>    
     <div id = "display">
          <li>
          	<form class="navbar-form navbar-left" action="PictureClServlet" role="search">
               
                  <input type="text" class="form-control" name="q" placeholder="搜索你喜欢的...">
                  <button type="submit" class="btn btn-default">搜索</button>
            </form>
           </li>
      </div>
      <div>
	<form name="from1"  method="post">
	<input type="button" name="upload" value="上传" style="background-color:lightblue" onclick=" _toLcal()"/><br>
	<input type="button" name="uploaded" value="我已上传" style="background-color:lightblue" /><br>
	<input type="button" name="downloaded" value="我已下载" style="background-color:lightblue" /><br>
	</form>
     
	</div>
    <script type = "text/javascript">
    function show(){
    	if( document.getElementById("me").onclick()){
             document.getElementById("p").style.display = "inline";
    	}

    }
     show();
    </script>
</body>
</html>
