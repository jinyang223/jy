/**
 * 用户正在阅读书籍展示
 */
$(function(){
	$.ajax({
		url:"/XINHUABookStore/BookServlet?opt=checkUserLoginSelectMyBooks",
		type:"post",
		dataType:"json",
		contentType: "application/json",
		success:function(data){
			var info = "";
			for(var i = 0; i < data.length; i++){
				info = info + "<div class='book'>";
				info = info + "<img src='" + data[i].bookCover +"'/>";
				info = info + "<p>" + data[i].bookIntroduce + "</p>";
				var bookId = data[i].bookId;
                var bookStatus = data[i].bookStatus === "0" ? "此书已被借走！" : "此书未被借走！";
                var bookStatus2 = data[i].bookStatus === "0" ? "我要还书" : "我要借书";
				info = info + "<p>" + bookStatus + "<button class='bookbutton' id='" + bookId + "'>" + bookStatus2 + "</button></p>";
				info = info + "</div>";
			}
			$(".main").append(info);
		},
		error:function(){
			alert("网络错误，请稍后再试！");
		}
	});
	
	// 添加事件监听器到所有类名为 'bookbutton' 的按钮
	$(".main").on("click", ".bookbutton", function() {
		var bookId = $(this).attr("id");
		var buttonValue = document.getElementById(bookId).innerHTML;
		$.ajax({
			url:"/XINHUABookStore/BookServlet?opt=chooseBook",
			type:"post",
			data:{"bookId":bookId,"buttonValue":buttonValue},
			dataType:"json",
			success:function(data){
				if(data === 0){
					alert("恭喜您还书成功！");
					window.location.href="myBooks.jsp";
				}else if(data == 4){
					alert("还书失败！请稍后再试！");
				}
			},
			error:function(){
				alert("网络错误，请稍后再试！");
			}
		});
	});
	
    // 用户登出
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