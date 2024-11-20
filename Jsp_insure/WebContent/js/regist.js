/**
 * ユーザー登録
 */
$(function(){
	$("#userRegister").click(function(){
		// インターフェース情報を取得する
		var userName1 = $("#userX").val() + $("#userM").val();
		var userName2 = $("#userXq").val() + $("#userMq").val();
		var userBirthday = $("#year").val() + $("#month").val() + $("#day").val();
		var userSex = $("#userSex").val();
		var userPhone = $("#userPhone5").val() + $("#userPhone4").val() + $("#userPhone42").val();
		var userEmail = $("#userEmail1").val() + "@" + $("#userEmail2").val();
		var userPass = $("#userPass").val();
		var bo = false;
		if(userName1.length > 0){
			if(userName2.length > 0){
				//正規表現で誕生日を正しく判断する
				var regB=/^((19|20)[0-9]{2})((0[1-9])|(1[0-2]))((0[1-9])|((1|2)[0-9])|(3[0-1]))$/;
				if(regB.test(userBirthday)){
					//正規表現で携帯電話番号を正しく判断する
					var regP = /^1[3,4,5,6,7,8,9][0-9]{9}$/;
					if(regP.test(userPhone)){
						//正規表現でメールアドレスを正しく判断する
						var regE = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
						if(regE.test(userEmail)){
							//正規表現でパスワードを正しく判断する
							var regPa=/^[0-9]{6,9}$/;
							if(regPa.test(userPass)){
								bo = true;
							}else{
								alert("パスワードは6〜9桁の数字ですよ！");
							}
						}else{
							alert("入力した メールアドレスに問題がありますよ！");
						}
					}else{
						alert("入力した携帯番号に問題がありますよ！");
					}
				}else{
					alert("あなたが入力した誕生日情報に問題がありますよ！");
				}
			}else{
				alert("仮名は空にしてはいけませんよ！");
			}
		}else{
			alert("名前は空にしてはいけませんよ！");
		}
		if(bo){
			// AJAXでデータを送信して判断する
			$.ajax({
				url:"/Jsp_insure/UserServlet?opt=user_regist",
				type:"post",
				data:{"userName":userName1 + "(" + userName2 + ")","userBirthday":userBirthday,"userSex":userSex,"userPhone":userPhone,"userEmail":userEmail,"userPass":userPass},
				dataType:"json",
				success:function(date){
					if(date == 1){
						alert("ログインインタフェースをジャンプしてご登録おめでとうございます！");
						window.location.href = "login.jsp";
					}else if(date == 2){
						alert("アカウント登録が重複しています。メールアドレスまたは携帯電話番号が重複している可能性がありますので、ご確認ください！")
					}else if(date == 3){
						alert("登録に失敗しました！");
					}
				},
				error:function(){
					alert("ネットワークにエラーがありました。後で再試行してください！");
				}
			});
		}
	});
});