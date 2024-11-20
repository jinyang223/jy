/**
 * shop.jsファイル
 */
//JSメソッドを設定してインターフェースのドロップダウンボックスを操作し、動的に値を設定する
function js(obj,v){
	var sum = parseFloat(obj.value) * 10;
	sessionStorage.setItem(v,sum + "");
	var sum_value = 0;
	var bo = true;
	if(getData() != ""){
		var $value = getData().split(",");
		for(var i = 0; i < $value.length; i++){
			if(v == $value[i]){
				bo = false;
				break;
			}
		}
	}
	if(bo){
		sessionStorage.setItem("dataValue",getData() + v);
	}
	if(getData() != ""){
		var $value = getData().split(",");
		for(var i = 0; i < $value.length -1; i++){
			sum_value = sum_value + parseFloat(sessionStorage.getItem($value[i]));
		}
	}
	sum_value = sum_value + parseFloat(document.getElementById("price_value").value);
	document.getElementById("price_view").innerHTML = sum_value;
}

//内容を取得する
function getData(){
	var dataValue = sessionStorage.getItem("dataValue");
	if(dataValue != null){
		return dataValue + ","
	}
	return "";
}

//現在の時間を設定する
function setDate(){
	var date = new Date();
	document.getElementById("staDateTime").value = date.getFullYear();
}

//現在の時間に基づいて注文番号を設定する
function getNowData(){
	
    // 現在の時間を取得する
    var now = new Date();

    // それぞれの時間コンポーネントを取得する
    var year = now.getFullYear().toString();
    //月は0から始まるので、1を加えて0を埋める必要がある
    var month = (now.getMonth() + 1).toString().padStart(2, '0'); 
    //0を埋める
    var day = now.getDate().toString().padStart(2, '0'); 
    var hours = now.getHours().toString().padStart(2, '0'); 
    var minutes = now.getMinutes().toString().padStart(2, '0'); 
    var seconds = now.getSeconds().toString().padStart(2, '0'); 

    //必要な形式の文字列に連結する
    var formattedTime = year + month + day + hours + minutes + seconds;
    return formattedTime;

}
//このウェブページを開くたびにsessionStorageをクリアして、金額が増加する状況を避ける
window.onload = function(){
	sessionStorage.clear();
	setDate();
}

//保険を購入して注文に追加する
$(function(){
	$("#buyCommodity").click(function(){
		//選択と入力値を取得する
		var commodity_id = $("#commodity_id").val();
		var order_id = getNowData();
		var order_commodity_liability1 = $("#yw").find('option:selected').text();
		var order_commodity_liability2 = $("#sc").find('option:selected').text();
		var order_commodity_liability3 = $("#cj").find('option:selected').text();
		var order_commodity_liability4 = $("#zy").find('option:selected').text();
		var order_commodity_liability5 = $("#zd").find('option:selected').text();
		var order_commodity_liability6 = $("#jt").find('option:selected').text();
		var order_commodity_liability7 = $("#jb").find('option:selected').text();
		var order_beneficiary_name = $("#userName2").val();
		var order_beneficiary_age = $("#userCity2").val();
		var order_beneficiary_ageInt = parseInt(order_beneficiary_age,10);
		var order_beneficiary_phone = $("#userPhone2").val();
		var order_commodity_time_start = $("#staDateTime").val();
		var order_commodity_time_lengths = $("#endDataTime").find('option:selected').val();
		var order_sum_price = document.getElementById("price_view").innerHTML;
		var bo = false;
		//被保険者情報は空でいてはいけない
		if(order_beneficiary_name.length > 0 && order_beneficiary_age.length > 0 && order_beneficiary_phone.length > 0){
			//被保険者の年齢が保険範囲内かどうかを判断する（最小保険購入年齢：0、最大保険購入年齢：80）
			if(order_beneficiary_ageInt >= 0 && order_beneficiary_ageInt <= 80){
				//正規表現で携帯電話のフォーマットを正しく判断する
				var regP = /^1[3,4,5,6,7,8,9][0-9]{9}$/;
				if(regP.test(order_beneficiary_phone)){
					bo = true;
				}else{
					alert("入力した携帯番号に問題がありますよ！");
				}
			} else{
				alert("被保険者の年齢は保険の有効範囲内にありません");
			}
		} else {
			alert("被保険者情報を空欄にすることはできません!");
		}
		if(bo){
			$.ajax({
				url:"/Jsp_insure/OrderServlet?opt=insert_order",
				type:"post",
				data:{"commodity_id":commodity_id,"order_id":order_id,"order_commodity_liability1":order_commodity_liability1,"order_commodity_liability2":order_commodity_liability2,"order_commodity_liability3":order_commodity_liability3,
				"order_commodity_liability4":order_commodity_liability4,"order_commodity_liability5":order_commodity_liability5,"order_commodity_liability6":order_commodity_liability6,
				"order_commodity_liability7":order_commodity_liability7,"order_beneficiary_name":order_beneficiary_name,"order_beneficiary_age":order_beneficiary_age,
				"order_beneficiary_phone":order_beneficiary_phone,"order_commodity_time_start":order_commodity_time_start,
				"order_commodity_time_lengths":order_commodity_time_lengths,"order_sum_price":order_sum_price},
				dataType:"json",
				success:function(date){
					if(date == 1){
						alert("保険購入が成功おめでとうございます。もうすぐ私の註文画面へ戻ります！");
						window.location.href = "my_order.jsp";
					}else if(date == 0){
						alert("注文追加に失敗しました！");
					}else if(date == 2){
						alert("残高不足です。チャージしてください。");
						window.location.href = "my_info.jsp";
					}else if(date == 3){
						alert("被保険者の年齢がこの保険の定める年齢範囲に合いません！");
					}else if(date == 4){
						alert("被保険者は登録済みですが、ここで姓名と電話番号の検証に失敗しました。入力情報を確認してください。");
					}else if(date == 5){
						alert("被保険者は登録済みですが、ここで年齢が正しくありません！再度入力してください。");
					}
				},
				error:function(){
					alert("ネットワークにエラーがありました。後で再試行してください！");
				}
			});
		}
		
	});
});