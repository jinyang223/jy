/**
 * 修改商品信息
 */
$(function(){
	$("#submitUpdate").click(function(){
		// 获取各个输入框和选择框的值
		var bookId = $("#bookId").val();
        var bookName = $("#bookName").val();
        var bookIntroduce = $("#bookIntroduce").val();
        var bookStatus = $("#bookStatus").val();
        var bookType = $("#bookType").val();
        if (bookName === "" || bookIntroduce === "") {
            alert("书籍名称和简介不能为空！");
            return;
        } 
        $.ajax({
			url:"/XINHUABookStore/AdminServlet?opt=updateBookInfo",
			type:"post",
			data:{"bookId":bookId,"bookName":bookName,"bookIntroduce":bookIntroduce,"bookStatus":bookStatus,"bookType":bookType},
			dataType:"json",
			success:function(data){
				if(data == 1) {
					alert("书籍信息修改成功！");
					window.location.href = "admin.jsp";
				} else if(data == 2) {
					alert("书籍信息修改失败！");
				} else if(data == 0) {
					alert("您并未修改任何数据！");
				}
			},
			error:function() {
				alert("网络错误，请稍后再试！");
			}
		});
	})
	
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