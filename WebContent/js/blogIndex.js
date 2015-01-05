$(document).ready(function(){
	$("a").removeClass("active");
	$("a").eq(1).addClass("active");
	$(".signup-place").css("height",document.body.clientHeight+'px');
	/*获取博客列表*/
	var allCategory = $.ajax({
		url: "/class_project/blogIndex",
		async: false,
		success: function(data){
			if(JSON.parse(data).records.length!=0){
				JSON.parse(data).records.forEach(function(obj){
					$("#tbody").prepend("<tr>"+
						      "<td><a href='/class_project/showBlog?id="+obj.id+"'>"+
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
		if(this.innerHTML=="删除"){
			var state = $.ajax({
				url: this.href,
				async: false,
			});
			if(state.responseText=="success"){
				$(this).parent().parent().remove();
				layer.alert("删除成功!");
			}else{
				layer.alert("删除失败!");
			}
		}else if(this.innerHTML=="修改"){
			layer.alert("要修改请先删除再添加!");
		}else{
			var allCategory = $.ajax({
				url: this.href,
				async: false,
				success: function(data){
					$("#blogForm").remove();
					$("h4").append(data);
				},
				error: function(msg){
					$("#error").html(msg.responseText);
				}
			});
		}
	})
});