/**
 * 修改用户信息
 */
$(function(){
	$("#submitUpdate").click(function(){
		// 获取各个输入框和选择框的值
		var userId = $("#userId").val();
        var userPass = $("#userPass").val();
        var userNickName = $("#userNickName").val();
        var userStatus = $("#userStatus").val();
        var userType = $("#userType").val();
        if (userPass === "" || userNickName === "") {
            alert("密码、昵称不能为空！");
            return;
        } else {
			// 验证密码格式
			var regPa=/^[0-9]{6,9}$/;
			if(regPa.test(userPass)){

			} else {
				alert("密码必须是6-9位数字");
				return;
			}
		}
        $.ajax({
			url:"/XINHUABookStore/AdminServlet?opt=updateUserInfo",
			type:"post",
			data:{"userId":userId,"userPass":userPass,"userNickName":userNickName,"userStatus":userStatus,"userType":userType},
			dataType:"json",
			success:function(data){
				if(data == 1) {
					alert("用户信息修改成功！");
					window.location.href = "admin.jsp";
				} else if(data == 2) {
					alert("用户信息修改失败！");
				} else if(data == 0) {
					alert("您并未修改任何数据！");
				}
			},
			error:function() {
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