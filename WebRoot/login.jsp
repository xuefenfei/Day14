<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	

  </head>
  
  <body>
   
   <h1>登录窗口</h1>
	<hr>
	${error }
	<form action="/day14/login" method="post">
		USERNAME:<input type="text" name="username"><br>
		PASSWORD:<input type="password" name="password"><br> <input
			type="submit" value="login">
	</form>
  </body>
</html>
