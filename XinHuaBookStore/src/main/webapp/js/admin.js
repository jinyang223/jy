/**
 * 管理员管理
 */
$(function(){
	// 进入index.jsp页面即遍历书籍信息
	$.ajax({
		url:"/XINHUABookStore/AdminServlet?opt=selectAllData",
		type:"post",
		dataType:"json",
		contentType: "application/json",
		success:function(data){
			// 获取三个集合信息
			var userInfos = data.userInfos;
			var bookInfos = data.bookInfos;
			var logInfos = data.logInfos;
			var info = "";
			for(var i = 0; i < userInfos.length; i++){
				info = info + "<tr>";
				info = info + "<td>" + userInfos[i].userId + "</td>";
				info = info + "<td>" + userInfos[i].userAccount + "</td>";
				info = info + "<td>" + userInfos[i].userPass + "</td>";
				info = info + "<td>" + userInfos[i].userNickName + "</td>";
				info = info + "<td>" + userInfos[i].userAvatar + "</td>";
				info = info + "<td>" + (userInfos[i].userStatus == 1 ? "正常可用" : "非正常不可用") + "</td>";
				info = info + "<td>" + (userInfos[i].userType == 0 ? "普通用户" : "管理员") + "</td>";
				if(userInfos[i].userType == 1){
					info = info + "<td>此账号为管理员账号，不可修改或删除！</td>"
				}else{
					info = info + "<td><input type='button' class='update' id='" + userInfos[i].userId + "' value='修改'/><input type='button' class='delete' id='" + userInfos[i].userId + "' value='删除'/></td>";
				}
				info = info + "</tr>";
			}
			$(".data-table1").append(info);
			var info = "";
			for (var i = 0; i < bookInfos.length; i++) {
			    info += "<tr>";
			    info += "<td>" + bookInfos[i].bookId + "</td>";
			    info += "<td>" + bookInfos[i].bookName + "</td>";
			    info += "<td>" + bookInfos[i].bookIntroduce + "</td>";
			    info += "<td>" + bookInfos[i].bookCover + "</td>";
			    // 根据 bookInfos[i].bookType 的值显示书籍类型名称
			    var bookTypeName;
			    switch (Number(bookInfos[i].bookType)) {
			        case 1:
			            bookTypeName = "文学类";
			            break;
			        case 2:
			            bookTypeName = "教育类";
			            break;
			        case 3:
			            bookTypeName = "学术类";
			            break;
			        case 4:
			            bookTypeName = "科技类";
			            break;
			        default:
			            bookTypeName = "未知类型";
			    }
			    info += "<td>" + bookTypeName + "</td>";
			    info += "<td>" + (bookInfos[i].bookStatus == 0 ? "不可操作" : "可操作") + "</td>";
			    if (bookInfos[i].bookStatus == 0) {
			        info += "<td>此书已借出，无法操作！</td>";
			    } else {
			        info += "<td><input type='button' class='update' id='" + bookInfos[i].bookId + "' value='修改'/><input type='button' class='delete' id='" + bookInfos[i].bookId + "' value='删除'/></td>";
			    }
			
			    info += "</tr>";
			}
			$(".data-table2").append(info);
			var info = "";
			for(var i = 0; i < logInfos.length; i++){
				info = info + "<tr>";
				info = info + "<td>" + logInfos[i].logId + "</td>";
				info = info + "<td>" + logInfos[i].logUserId + "</td>";
				info = info + "<td>" + logInfos[i].logBookId + "</td>";
				info = info + "<td>" + logInfos[i].logBorrowingTime + "</td>";
				if(logInfos[i].logBookReturnTime == null){
					info = info + "<td>未还</td>"
				}else{
					info = info + "<td>" + logInfos[i].logBookReturnTime + "</td>";
				}
				info = info + "</tr>";
			}
			$(".data-table3").append(info);
		},
		error:function(){
			alert("网络错误，请稍后再试！");
		}
	});
	
	// 用户信息修改按钮（进入用户信息修改界面）
	$(".data-table1").on("click", ".update", function() {
		var userId = $(this).attr("id");
		$.ajax({
			url:"/XINHUABookStore/AdminServlet?opt=selectUserById",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(data){
				if(data == 1){
                	window.location.href = "updateUser.jsp";
				}
			},
			error:function(){
				alert("网络错误，请稍后再试！");
			}
		});
	});
	
	// 用户信息删除按钮
	$(".data-table1").on("click", ".delete", function() {
		var userId = $(this).attr("id");
		if(confirm("您确认删除该用户数据吗？该操作不可逆！请确认！！")){
			$.ajax({
				url:"/XINHUABookStore/AdminServlet?opt=deleteUserByUserId",
				type:"post",
				data:{"userId":userId},
				dataType:"json",
				success:function(data){
					if(data === 0){
						alert("用户信息删除成功！");
						window.location.href = "admin.jsp";
					}else{
						alert("用户信息删除失败！");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});		
		}
	});
	
	// 添加用户
	$("#addUser").click(function(){
		// 弹出框
		var modal = $("#userModal");
	    var form = $("#userForm");
	    // 取消按钮
	    var cancelButton = $("#cancel");
	    // 显示模态框
	    modal.show();
	    // 隐藏模态框
	    cancelButton.click(function() {
	        modal.hide();
	    });
	    // 表单提交
	    form.submit(function(event) {
			// 阻止表单默认提交行为
	        event.preventDefault(); 
	        // 获取表单中的各个值
	        var username = document.getElementById('username').value;
	        var password = document.getElementById('password').value;
	        var nickname = document.getElementById('nickname').value;
	        // 获取文件对象
	        // var avatar = document.getElementById('avatar').files; 
	        var status = document.getElementById('status').value;
	        var type = document.getElementById('type').value;
	        if (username === "" || password === "" || nickname === "") {
	            alert("用户名、密码、昵称不能为空！");
	            return;
	        } else {
				// 验证账号格式
				var regA = /^[a-zA-Z0-9][a-zA-Z0-9._%+-]{0,19}$/;
				if(regA.test(username)){
					// 验证密码格式
					var regPa=/^[0-9]{6,9}$/;
					if(regPa.test(password)){

					} else {
						alert("密码必须是6-9位数字");
						return;
					}
				} else {
					alert("账号以数字或字母开头，由字母、数字、点、下划线、百分号、加号和减号组成，长度不超过20位");
					return;
				}
			}
			// 使用FormData提交数据到后台
    		// var formData = new FormData();
	        // 使用AJAX提交数据到后台
	        $.ajax({
				url:"/XINHUABookStore/AdminServlet?opt=addUser",
				type:"post",
				data:{"username":username,"password":password,"nickname":nickname,"status":status,"type":type},
				dataType:"json",
				success:function(data){
					if(data == 0){
						alert("用户新增成功！");
						window.location.href = "admin.jsp";
					}else if(data == 1){
						alert("账号重复注册！");
					}else{
						alert("用户新增失败！");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});
	    });
	});
	
	// 用户表Excel导出
	$("#userExcel").click(function(){
		
	});
	
	// 添加商品
	$("#addBook").click(function(){
		// 弹出框
		var modal = $("#bookModal");
	    var form = $("#bookForm");
	    // 取消按钮
	    var cancelButton = $("#cancel2");
	    // 显示模态框
	    modal.show();
	    // 隐藏模态框
	    cancelButton.click(function() {
	        modal.hide();
	    });
	    // 表单提交
	    form.submit(function(event) {
			// 阻止表单默认提交行为
	        event.preventDefault(); 
	         // 获取表单中的各个值
	        var bookname = "《" + document.getElementById('bookname').value + "》";
	        var bookIntroduce = document.getElementById('bookIntroduce').value;
	        // 获取文件对象
	        // var bookCover = document.getElementById('bookCover').files; 
	        var bookStatus = document.getElementById('bookStatus').value;
	        var bookType = document.getElementById('bookType').value;
	        if (bookname === "" || bookIntroduce === "") {
	            alert("书籍名称和简介不能为空！");
	            return;
	        }
			// 使用FormData提交数据到后台
    		// var formData = new FormData();
	        // 使用AJAX提交数据到后台
	        $.ajax({
				url:"/XINHUABookStore/AdminServlet?opt=addBook",
				type:"post",
				data:{"bookname":bookname,"bookIntroduce":bookIntroduce,"bookStatus":bookStatus,"bookType":bookType},
				dataType:"json",
				success:function(data){
					if(data === 0){
						alert("书籍新增成功！");
						window.location.href = "admin.jsp";
					}else{
						alert("书籍新增失败！");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});
	    });
	})
	
	// 删除商品
	$(".data-table2").on("click", ".delete", function() {
		var bookId = $(this).attr("id");
		if(confirm("您确认删除该商品数据吗？该操作不可逆！请确认！！")){
			$.ajax({
				url:"/XINHUABookStore/AdminServlet?opt=deleteBookByBookId",
				type:"post",
				data:{"bookId":bookId},
				dataType:"json",
				success:function(data){
					if(data === 0){
						alert("书籍信息删除成功！");
						window.location.href = "admin.jsp";
					}else{
						alert("书籍信息删除失败！");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});		
		}
	});
	
	// 商品信息修改按钮（进入用户信息修改界面）
	$(".data-table2").on("click", ".update", function() {
		var bookId = $(this).attr("id");
		$.ajax({
			url:"/XINHUABookStore/AdminServlet?opt=selectBookById",
			type:"post",
			data:{"bookId":bookId},
			dataType:"json",
			success:function(data){
				if(data == 1){
                	window.location.href = "updateBook.jsp";
				}
			},
			error:function(){
				alert("网络错误，请稍后再试！");
			}
		});
	});
	
	//用户登出
    $("#userLogout").click(function(event){
		// 阻止默认链接行为
		event.preventDefault(); 
		$.ajax({
            url: "/XINHUABookStore/UserServlet?opt=userLogout",
            type: "post",
            success: function(response) {
				window.location.href="login.jsp";
            },
            error: function() {
                alert("网络错误，请稍后再试！");
            }
        });
	});
});