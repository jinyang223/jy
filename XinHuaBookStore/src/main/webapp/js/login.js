/**
 * 用户登录
 */
$(function(){
	$("#login").click(function(){
		var userAccount = $("#userAccount").val();
		var userPass = $("#userPass").val();
		var bo = false;
		if(userAccount.length > 0){
			var regA = /^[a-zA-Z0-9][a-zA-Z0-9._%+-]{0,19}$/;
			if(regA.test(userAccount)){
				if(userPass.length > 0){
					var regPa=/^[0-9]{6,9}$/;
					if(regPa.test(userPass)){
						bo = true;
					}else{
						alert("密码必须是6-9位数字");
					}
				} else{
					alert("密码不能为空！");						
				}
			}else{
				alert("账号以数字或字母开头，由字母、数字、点、下划线、百分号、加号和减号组成，长度不超过20位");
			}
		}else{
			alert("账号不能为空！");
		}
		if(bo){
			$.ajax({
				url:"/XINHUABookStore/UserServlet?opt=login",
				type:"post",
				data:{"userAccount":userAccount,"userPass":userPass},
				dataType:"json",
				success:function(data){
					var login = data;
					if(login === 0){
						alert("恭喜您登陆成功！进入新华书店！");
						window.location.href = "index.jsp";
					}else{
						alert("账号或密码错误，请重新输入！（若多次错误，请检查账号状态）");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});
		}
	});
	$("#adminLogin").click(function(){
		var userAccount = $("#userAccount").val();
		var userPass = $("#userPass").val();
		var bo = false;
		if(userAccount.length > 0){
			var regA = /^[a-zA-Z0-9][a-zA-Z0-9._%+-]{0,19}$/;
			if(regA.test(userAccount)){
				if(userPass.length > 0){
					var regPa=/^[0-9]{6,9}$/;
					if(regPa.test(userPass)){
						bo = true;
					}else{
						alert("密码必须是6-9位数字");
					}
				} else{
					alert("密码不能为空！");						
				}
			}else{
				alert("账号以数字或字母开头，由字母、数字、点、下划线、百分号、加号和减号组成，长度不超过20位");
			}
		}else{
			alert("账号不能为空！");
		}
		if(bo){
			$.ajax({
				url:"/XINHUABookStore/UserServlet?opt=adminLogin",
				type:"post",
				data:{"userAccount":userAccount,"userPass":userPass},
				dataType:"json",
				success:function(data){
					var adminLogin = data;
					if(adminLogin === 1){
						alert("恭喜您登陆成功！进入管理界面！");
						window.location.href = "admin.jsp";
					}else{
						alert("账号或密码错误，请重新输入！（若多次错误，请检查账号状态）");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});
		}
	});
});