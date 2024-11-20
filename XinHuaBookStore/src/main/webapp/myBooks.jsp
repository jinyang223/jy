<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新华书店|正在阅读</title>
    <link rel="stylesheet" href="css/index.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all">
    <link href="https://fonts.googleapis.com/css?family=Mukta:300,400,500" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/myBooks.js"></script>
</head>
<body>
	<div id="headdiv">
    	<c:if test="${user == null}">
    		<h1>请登录后查看正在阅读的书籍！<a href="login.jsp">登录</a>&nbsp;<a href="regist.jsp">注册</a></h1>
    	</c:if>
    	<c:if test="${user != null}">
    		<h1>
    			<${user.getUserNickName()}>正在阅读
    			<a href="login.jsp">登录</a>&nbsp;
    			<a href="regist.jsp">注册</a>&nbsp;
    			<a href="#" id="userLogout">用户登出</a>
    		</h1>
    	</c:if>	 	
    </div>
	<div class="main">
	    <!-- books -->
	</div>
</body>
