<%@ page language="java" import="java.awt.*,java.sql.*,java.io.*,java.util.*,com.ghl.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body >


<% 
  ArrayList al=(ArrayList)request.getAttribute("result");
session.setAttribute("result", al);
	if(al.isEmpty()==true){
		out.print("找不到对应图片");
		%>
		<script>
		setTimeout("location.href='wel.jsp'", 1000);//3000是3秒，单位是毫秒
		</script>
		<%
	}
	else{
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>滴———西电卡-</title>
  <link type="text/css" rel="stylesheet" href="search.css">
</head>
<script language="javascript">
	<!--
	function _toLcal(){
		  location.href ='wel.jsp';
		}
	-->
</script>
<body>
  <nav>
     <div id = "left">
        <ul>
          <li><a href = "wel.jsp"><img id = "logo" src = "photos/logo1.png" alt= "logo loading..."></a></li>
          <li id = "name">滴——西电卡</li>
        </ul>
    </div>
    <div id = "right">
         <input type="button" id="register" value="注册" onclick=" _toLcal()" >
        <input type="button" id="login" value="登录" onclick=" _toLcal()">
    </div>
  </nav>
  <div id = "main">
    <div id = "key">
       <div class = "tableRow">
           <p class = "heading"><a href="#">美景:</a></p>
           <p></p>
       </div>
       <div class = "tableRow">
           <p><a href="#">丁香</a></p>
           <p><a href="#">海棠</a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#">竹园</a></p>
           <p><a href="#">教学楼</a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#">行政区</a></p>
           <p><a href="#">家属区</a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#">操场</a></p>
           <p><a href="#">广场</a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#">其他</a></p>
           <p><a href="#"></a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#"></a></p>
           <p><a href="#"></a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#"></a></p>
           <p><a href="#"></a></p>
       </div>
       <div class = "tableRow">
           <p class = "heading"><a href="#">人物:</a></p>
           <p><a href="#"></a></p>
       </div>
       <div class = "tableRow">
           <p><a 
            href="#">丁香</a></p>
           <p><a href="#">海棠</a></p>
       </div>
       <div class = "tableRow">
           <p><a href="#">竹园</a></p>
           <p><a href="#">其他</a></p>
       </div>
     </div>
     <div id = "picture"> 
     <ul>
          <% 
          String []p=new String[al.size()+1];
          String []n=new String[al.size()+1];
		 	for(int i=0;i<al.size();i++){
		  		//从al中取出UserBean
		  		PictureBean pb=(PictureBean)al.get(i);
		  		String m=pb.getName();
		  		n[i]=new String(m);
		  		String s=pb.getP();
		  		p[i]=new String(s);
		  		%>
		  			 <li>
			             <div id = "picture1" class = "tableRow">
			              <p><img src="<%=p[i]%>"   width="400" height="300" alt = "loading..."></p>
			              <p><%=n[i]%></p>
						  <form name="form1" action="DownloadClServlet" method="post">
			              <p><input type ="submit"  name="button" value = "<%="download"+i%>"></p>
             			</div>
          			</li>
		  		<% 
		  		}
         	 %>
 		 </ul>
   
     
  
 	 <% 
 	 String s_pageCount=(String)request.getAttribute("pageCount");
 	 int pageCount=Integer.parseInt(s_pageCount);
 	 int pageNow=Integer.parseInt((String)request.getAttribute("pageNow")); 
 			 if(pageNow!=1){
 				  out.println("<a href=PictureClServlet?pageNow="+1+">首页</a>");
 				  out.println("<a href=PictureClServlet?pageNow="+(pageNow-1)+">上一页</a>");
 			 }
 			 for(int i=1;i<=pageCount;i++){
 				  out.println("<a href=PictureClServlet?pageNow="+i+">["+i+"]</a>");
 				  //width="500" height="250"
 			 }
 			 if(pageNow!=pageCount){
 				  out.println("<a href=PictureClServlet?pageNow="+(pageNow+1)+">下一页</a>");
 				  out.println("<a href=PictureClServlet?pageNow="+pageCount+">末页</a>");
 			 }
 	  
	}
 	 %>
 	
 	
 </div>
  </div>

</body>
</html>