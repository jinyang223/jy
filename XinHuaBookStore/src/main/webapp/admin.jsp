<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理用户|书籍</title>
<link rel="stylesheet"  type="text/css" href="css/admin.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
	<c:if test="${user == null}">
   		<h1>您尚未登录，无法进入管理员界面！<a href="login.jsp">登录</a>&nbsp;<a href="regist.jsp">注册</a></h1>
   	</c:if>
   	<c:if test="${user != null}">
		<h1>欢迎管理员<${user.getUserNickName()}>进入后台！<a href="login.jsp">登录</a>&nbsp;<a href="regist.jsp">注册</a>&nbsp;<a href="#" id="userLogout">用户登出</a></h1>
		<div class="container">
	        <div class="table-container">
	        	<h3>用户表数据结构 <input type="button" id="addUser" value="添加用户" />&nbsp;<input type="button" id="userExcel" value="导出用户数据" /></h3>
	            <table class="data-table1">
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
	                <!-- 表格数据 -->
	            </table>
	            <h3>商品表数据结构 <input type="button" id="addBook" value="添加商品" /></h3>
	            <table class="data-table2">
	                <tr>
	                    <th>编号</th>
	                    <th>名称</th>
	                    <th>介绍</th>
	                    <th>封面</th>
	                    <th>种类</th>
	                    <th>状态</th>
	                    <th>操作</th>
	                </tr>
	                <!-- 表格数据 -->
	            </table>
	            <h3>日志表数据结构</h3>
	            <table class="data-table3">
	                <tr>
	                    <th>编号</th>
	                    <th>用户编号</th>
	                    <th>书籍编号</th>
	                    <th>借书时间</th>
	                    <th>还书时间</th>
	                </tr>
	                <!-- 表格数据 -->
	            </table>
	        </div>
	    </div>
   	</c:if>	 
   	<!-- 添加用户弹出框 -->
	<div id="userModal" class="modal">
	    <form id="userForm" enctype="multipart/form-data">
	        <label for="username">账号:</label>
	        <input type="text" id="username" name="username" required>
	        <br>
	        <label for="password">密码:</label>
	        <input type="password" id="password" name="password" required>
	        <br>
	        <label for="nickname">昵称:</label>
	        <input type="text" id="nickname" name="nickname" required>
	        <br>
	        <label for="avatar">头像:</label>
	        <input type="file" id="avatar" name="avatar" accept="image/*">
	        <br>
	        <label for="status">状态:</label>
	        <select id="status" name="status">
	            <option value="1">正常可用</option>
	            <option value="0">非正常不可用</option>
	        </select>
	        <br>
	        <label for="type">类型:</label>
	        <select id="type" name="type">
	            <option value="1">管理员</option>
	            <option value="0">普通用户</option>
	        </select>
	        <br>
	        <input type="submit" value="提交">
	        <input type="button" value="取消" id="cancel">
	    </form>
	</div>	
	<!-- 添加书籍弹出框 -->
	<div id="bookModal" class="modal">
	    <form id="bookForm" enctype="multipart/form-data">
	        <label for="bookname">名称:</label>
	        <input type="text" id="bookname" name="bookname" required>
	        <br>
	        <label for="bookIntroduce">介绍:</label>
	        <input type="text" id="bookIntroduce" name="bookIntroduce" required>
	        <br>
	        <label for="bookCover">封面:</label>
	        <input type="file" id="bookCover" name="bookCover" accept="image/*">
	        <br>
	        <label for="bookStatus">状态:</label>
	        <select id="bookStatus" name="bookStatus">
	            <option value="0">已借出</option>
	            <option value="1" selected>未借出</option>
	        </select>
	        <br>
	        <label for="bookType">种类:</label>
	        <select id="bookType" name="bookType">
	            <option value="1" selected>文学类</option>
	            <option value="2">教育类</option>
	            <option value="3">学术类</option>
	            <option value="4">科技类</option>
	        </select>
	        <br>
	        <input type="submit" value="提交">
	        <input type="button" value="取消" id="cancel2">
	    </form>
	</div>
</body>
</html>