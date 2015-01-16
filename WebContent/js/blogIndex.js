$(document).ready(function(){
	$("a").removeClass("active");
	$("a").eq(1).addClass("active");
	$('.footable').data('page-size', 20);
	$('.footable').trigger('footable_initialized');
	$(function () {
	    $('.footable').footable();
	});
	/*获取博客列表*/
	var allCategory = $.ajax({
		url: "/class_project/blogIndex",
		async: false,
		success: function(data){
			if(JSON.parse(data).records.length!=0){
				JSON.parse(data).records.forEach(function(obj){
					$("#tbody").prepend("<tr>"+
						      "<td id='blog-title'><a href='/class_project/showBlog?id="+obj.id+"'>"+
						      obj.title+"</td>"+
						      "</a><td>"+obj.time+"</td>"+
						      "<td>"+
						      	"<a href='/class_project/modifyBlog?id="+obj.id+"'"+
						      	">修改</a>"+
						      	"<a href='/class_project/blogDelete?id="+obj.id+"'"+
						      	"class='delete-category'>删除</a>"+
						      "</td>"+
						      "</tr>");
				})
			}
		},
		error: function(msg){
			$("#error").html(msg.responseText);
		}
	});
	/*添加删除修改用户的事件*/
	$("tbody td a").click(function(event){
		event.preventDefault();
		var action = this.href;
		if(this.innerHTML=="删除"){
			layer.confirm("确定删除?",function(){
				var state = $.ajax({
					url: action,
					async: false,
				});
				if(state.responseText=="success"){
					location.reload();
				}else{
					layer.alert("错误!");
				}
			});
		}else if(this.innerHTML=="修改"){
			var id = this.href.split("?")[1];
			window.location.href = "/class_project/navFolder/addBlog.jsp?"+id;
		}else{
			var allCategory = $.ajax({
				url: this.href,
				async: false,
				success: function(data){
					$("#blogForm").remove();
					JSON.parse(data).content.split("\\n").forEach(function(pdata){
						$("div.signup-place").append("<div><p class='article'>" + pdata + "</p></div>");
						/*$(".signup-place").css("height",$(document).height());*/
					})
				},
				error: function(msg){
					$("#error").html(msg.responseText);
				}
			});
		}
	})
});