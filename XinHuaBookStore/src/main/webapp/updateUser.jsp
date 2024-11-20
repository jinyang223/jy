<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户信息</title>
<link rel="stylesheet"  type="text/css" href="css/admin.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/updateUser.js"></script>
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
		                <th>账号</th>
		                <th>密码</th>
		                <th>昵称</th>
		                <th>头像</th>
		                <th>状态</th>
		                <th>类型</th>
		                <th>操作</th>
		            </tr>
		            <tr>
		                <td><input type="text" id="userId" value="${userInfo.getUserId()}" readonly></td>
		                <td><input type="text" value="${userInfo.getUserAccount()}" readonly></td>
		                <td><input type="password" id="userPass" value="${userInfo.getUserPass()}"></td>
		                <td><input type="text" id="userNickName" value="${userInfo.getUserNickName()}"></td>
		                <td><input type="text" value="${userInfo.getUserAvatar()}" readonly></td>
		                <td>
		                    <select id="userStatus">
		                    	<c:if test="${userInfo.getUserStatus() == 0}">
		                    		<option value="0" selected>非正常不可用</option>
		                        	<option value="1">正常可用</option>
		                    	</c:if>
		                        <c:if test="${userInfo.getUserStatus() == 1}">
		                    		<option value="0">非正常不可用</option>
		                        	<option value="1" selected>正常可用</option>
		                    	</c:if>
		                    </select>
		                </td>
		                <td>
		                    <select id="userType">
		                    	<c:if test="${userInfo.getUserType() == 0}">
		                    		<option value="0" selected>普通用户</option>
		                        	<option value="1">管理员</option>
		                    	</c:if>
		                        <c:if test="${userInfo.getUserType() == 1}">
		                    		<option value="0">普通用户</option>
		                        	<option value="1" selected>管理员</option>
		                    	</c:if>
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