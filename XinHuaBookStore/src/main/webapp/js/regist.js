/**
 * 用户注册
 */
$(function(){
	$("#regist").click(function(){
		var userNickName = $("#userNickName").val();
		var userAccount = $("#userAccount").val();
		var userPass = $("#userPass").val();
		var bo = false;
		if(!userNickName.lengnt > 0){
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
		}else{
			alert("昵称不能为空！");
		}
		if(bo){
			$.ajax({
				url:"/XINHUABookStore/UserServlet?opt=userRegist",
				type:"post",
				data:{"userNickName":userNickName,"userAccount":userAccount,"userPass":userPass},
				dataType:"json",
				success:function(data){
					if(data === 0){
						alert("账号重复注册！");
					}else if(data === 1){
						alert("恭喜注册成功！请前往登录！");
						window.location.href = "login.jsp";
					}else if(data === 2){
						alert("注册失败！");
					}
				},
				error:function(){
					alert("网络错误，请稍后再试！");
				}
			});
		}
	});
});