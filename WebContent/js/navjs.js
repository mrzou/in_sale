$(document).ready(function(){
	if($("#user_name").html().replace(/\s/g,   '') != "游客"){
		$("#login").html("切换用户");
	}
	$("#identify").hover(function(){
		if($("#user_name").html().replace(/\s/g,   '') != "游客"){
			layer.tips('点击退出登陆的用户', this, {
			    style: ['background-color:#428bca; color:#fff; height: 50px', '#428bca'],
			    maxWidth:100,
			});
		}
	},function(){
		layer.closeAll();
	});
	$("#identify").click(function(event){
		event.preventDefault();
		if($("#user_name").html().replace(/\s/g,   '')!="游客"){
			$.ajax({
				url: "/class_project/userLogout",
				async: true,
				success: function(){
					layer.alert("用户退出成功")
				}
			});
		}
	});
	var win_login = $("a.blog-nav-item").slice(1, 4).each(function(){
		$(this).click(function(event){
			var location = this.href.split("/");
			var urlName = location[location.length-1].split(".")[0];
			var ifExist = $.ajax({
				url: "/class_project/checkCookie",
				async: false,
			});
			console.log(ifExist.responseText);
			if(ifExist.responseText=="notExist"){
				layer.confirm('您的操作必须登陆,是否登陆？',function(){
					/* var winLogin = $.layer({
				        type: 2,
				        fadeIn: [300, true],
				        title: '用户登陆',
				        maxmin: true,
				        shadeClose: true, //开启点击遮罩关闭层
				        area : ['800px' , '460px'],
					    offset : ['100px', ''],
					    iframe: {src: 'win_login.jsp'},
						success: function(layero){
						}
					}); */
					window.location.href = "/class_project/jsp/login.jsp?location="+urlName;
				})
				event.preventDefault();
			}
		});
	});
});