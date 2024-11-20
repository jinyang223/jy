/**
 * ログイン
 */
$(function(){
	$("#user_login").click(function(){
		var user_email = $("#email").val();
		var user_pass = $("#password").val();
		var bo = false;
		if(user_email.length > 0){
			//正規表現でメールアドレスを正しく判断する
			var regE = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			if(regE.test(user_email)){
				if(user_pass.length > 0){
					//正規表現でパスワードを正しく判断する
					var regPa=/^[0-9]{6,9}$/;
					if(regPa.test(user_pass)){
						bo = true;
					}else{
						alert("パスワードは6〜9桁の数字ですよ！");
					}
				} else{
					alert("パスワードを空にすることはできませんよ！");						
				}
			}else{
				alert("入力したメールアドレスに問題がありますよ！");
			}
		}else{
			alert(" メールアドレスを空にすることはできませんよ！");
		}
		if(bo){
			$.ajax({
				url:"/Jsp_insure/UserServlet?opt=user_login",
				type:"post",
				data:{"userEmail":user_email,"userPass":user_pass},
				dataType:"json",
				success:function(date){
					if(date > 0){
						alert("ログイン成功おめでとうございます。もうすぐメイン画面をジャンプします！");
						window.location.href = "index.jsp";
					}else{
						alert("アカウントまたはパスワードが正しくないため、再度お試しください!");
					}
				},
				error:function(){
					alert("ネットワークにエラーがありました。後で再試行してください！");
				}
			});
		}
	});
});