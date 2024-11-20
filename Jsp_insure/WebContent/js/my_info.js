/**
 * 情報の提出修正
 */
$(function(){
	 $("#updateuserinfo").click(function(){
		var user_pass = $("#userPass").val();
		var user_phone = $("#userPhone").val();
		var addMoney = $("#addMoney").val();
		var addMoney2 = parseFloat(addMoney);
		var bo = false;
		if(user_pass.length > 0){
			//正規表現でパスワードを正しく判断する
			var regPa=/^[0-9]{6,9}$/;
			if(regPa.test(user_pass)){
				if(isNaN(addMoney2) || addMoney2 < 0){
					alert("入力したチャージ金額のフォーマットが違います!");
				}else{
					//正規表現で携帯電話番号を正しく判断する
					var regP = /^1[3,4,5,6,7,8,9][0-9]{9}$/;
					if(regP.test(user_phone)){
						bo = true;
					}else{
						alert("入力した携帯番号に問題がありますよ！");
					}
				}
			}else{
				alert("パスワードは6〜9桁の数字ですよ！");
			}
		}else{
			alert("メールボックスを空にすることはできませんよ！");
		}
		if(bo){
			$.ajax({
				url:"/Jsp_insure/UserServlet?opt=userInfoChange",
				type:"post",
				data:{"userPass":user_pass,"userPhone":user_phone,"addMoney":addMoney2},
				dataType:"json",
				success:function(date){
					if(date == 1){
						alert("アカウントメッセージの変更が成功おめでとうございます。もうすぐログイン画面へ戻ります！");
						window.location.href = "login.jsp";
					}else if(date == 2){
						alert("アカウントメッセージの変更が成功おめでとうございます。");
						window.location.href = "my_info.jsp";
					}else{
						alert("変更が失敗しました！");
					}
				},
				error:function(){
					alert("ネットワークにエラーがありました。後で再試行してください！");
				}
			});
		}
	});
});