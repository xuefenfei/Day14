<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    

  </head>
  
  <body>
 <h1>所有用户信息</h1>
 <hr>
 <c:if test="${empty user }">
 请<a href='/day14/login.jsp'>登录</a>
  </c:if>
  <c:if test="${not empty user}">
	当前用户是:${user.username}&nbsp;&nbsp;当前用户角色${user.role}
	<br>
	<hr>
	<c:forEach items="${applicationScope.map }" var=entry>
	用户名：${entry.key.username } &nbsp;昵称：${entry.key.nickname }&nbsp;&nbsp;
			<c:if test="${entry.key.role!='admin' and user.role=='admin' }">
				<a href="/day14/kick?id=${entry.key.id}">踢人</a>
			</c:if>
			<br>
	</c:forEach>
	</c:if>
  </body>
</html>
