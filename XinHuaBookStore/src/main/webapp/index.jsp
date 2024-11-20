<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新华书店|首页</title>
    <link rel="stylesheet" href="css/index.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all">
    <link href="https://fonts.googleapis.com/css?family=Mukta:300,400,500" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div id="headdiv">
    	<c:if test="${user == null}">
    		<h1>欢迎来到新华书店！<a href="login.jsp">登录</a>&nbsp;<a href="regist.jsp">注册</a></h1>
    	</c:if>
    	<c:if test="${user != null}">
    		<h1>
    			欢迎<${user.getUserNickName()}>来到新华书店！
    			<a href="login.jsp">登录</a>&nbsp;
    			<a href="regist.jsp">注册</a>&nbsp;
    			<a href="myBooks.jsp">正在阅读</a>
    			<a href="#" id="userLogout">用户登出</a>
    		</h1>
    	</c:if>	 	
    </div>
    <div class="search">
    	<input type="text" id="searchKeyword" placeholder="输入关键字查询书籍" />
		<button id="searchButton">查询</button>
   	</div>
	<div class="main">
	    <!-- books -->
	</div>
</body>
