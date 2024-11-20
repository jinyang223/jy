<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品信息</title>
<link rel="stylesheet"  type="text/css" href="css/admin.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/updateBook.js"></script>
</head>
<body>
	<c:if test="${user == null}">
   		<h1>您尚未登录，无法进入管理员界面！<a href="login.jsp">登录</a>&nbsp;<a href="regist.jsp">注册</a></h1>
   	</c:if>
   	<c:if test="${user != null}">
		<h1>欢迎管理员<${user.getUserNickName()}>进入后台！<a href="login.jsp">登录</a>&nbsp;<a href="regist.jsp">注册</a>&nbsp;<a href="#" id="userLogout">用户登出</a></h1>
		<div class="container">
	        <div class="table-container">
	        	<h2>用户信息修改</h2>
		    	<table class="data-table">
		            <tr>
		                <th>编号</th>
		                <th>名称</th>
		                <th>介绍</th>
		                <th>封面</th>
		                <th>状态</th>
		                <th>种类</th>
		                <th>操作</th>
		            </tr>
		            <tr>
		                <td><input type="text" id="bookId" value="${bookInfo.getBookId()}" readonly></td>
		                <td><input type="text" id="bookName" value="${bookInfo.getBookName()}"></td>
		                <td><input type="text" id="bookIntroduce" value="${bookInfo.getBookIntroduce()}"></td>
		                <td><input type="text" value="${bookInfo.getBookCover()}" readonly></td>
		                <td>
		                    <select id="bookStatus">
		                    	<c:if test="${bookInfo.getBookStatus() == 0}">
		                    		<option value="0" selected>已借出</option>
		                        	<option value="1">未借出</option>
		                    	</c:if>
		                        <c:if test="${bookInfo.getBookStatus() == 1}">
		                    		<option value="0">已借出</option>
		                        	<option value="1" selected>未借出</option>
		                    	</c:if>
		                    </select>
		                </td>
		                <td>
		                    <select id="bookType">
							    <c:set var="bookType" value="${bookInfo.getBookType()}" />
							    <option value="1" ${bookType == 1 ? 'selected' : ''}>文学类</option>
							    <option value="2" ${bookType == 2 ? 'selected' : ''}>教育类</option>
							    <option value="3" ${bookType == 3 ? 'selected' : ''}>学术类</option>
							    <option value="4" ${bookType == 4 ? 'selected' : ''}>科技类</option>
		                    </select>
		                </td>
		                <td><button id="submitUpdate" type="button">保存并提交</button></td>
		            </tr>
		        </table>
	        </div>
	    </div>
   	</c:if>	 
</body>
</html>